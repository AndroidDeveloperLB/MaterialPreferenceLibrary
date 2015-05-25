MaterialPreferenceLibrary
==================================

Allows to have a nice Material-Design look&feel for API 7 and above for the PreferenceActivity, including most commonly used preferences and also showing the actionBar.
All the dialogs are using the support library's dialogs, including accent-color.
You can even choose which theme to use.

Supported preferences are:
- **DialogPreference**
- **EditTextPreference**
- **ListPreference**
- **NumberEditTextPreference** - a customized preference I've made, that's like EditTextPreference, but allows to enters digits only.
- **Preference**
- **SwitchPreference**
- **TwoStatePreference**

Sample and screenshots
==================================
Just check the code, or see how it works on my app, here:
https://play.google.com/store/apps/details?id=com.lb.app_manager

**Screensots:**

**Gingerbread :**


**Lollipop :** 

Notes
==================================

1. About the **actionBar**, all this library does is to simply put a Toolbar at the top of the PreferenceActivity, and you need to use the Toolbar instead of the ActionBar.
2. Not all preferences were imported.
3. Sadly, **reflection** was used for 2 functions of "PreferenceManager" which aren't public (yet the framework's classes have full access to it) : "unregisterOnActivityDestroyListener", "registerOnActivityDestroyListener". Those functions seem to be used only for dismissing the dialogs when the activity is being destroyed. Just in case something goes wrong, I've made the code ignore (and write in the logs) in case they are unreachable.
4. **Preference icon** is missing, but I think it should be easy to add it. The reason it was missing is because I need to use the internal class that extends ImageView for it, which has "minWidth" and "minHeight", yet those are missing from old APIs, so I would need to import the entire code of ImageView... However, I'm sure there is a better way.
5. Not tested on **PreferenceFragment** (yet), but you can try it using these libraries and see if you can support even older APIs : 
https://github.com/Machinarius/PreferenceFragment-Compat
https://github.com/kolavar/android-support-v4-preferencefragment
6. In order to add **action items**, you need to do it completely via code, without using XML. Otherwise, on some Android versions (or all?), the action items will all gather inside the overflow menu item.
7. Some **attributes** should be used using Android's framework, and some using mine. Sorry for the confusion. 

Contribution is appreciated. Please try to be "loyal" to the original code of Android, as I've tried.

Requirements
==
This library needs:
 - API 7 and above.
 - AppCompat v7.

That's it.

What this library doesn't do
==
Sadly, it doesn't support all kinds of preferences. Currently, those are missing:
 - RingtonePreference
 - MultiSelectListPreference
 - CheckBoxPreference
and others...

Also, note that 

Thanks
==
Android's code ?

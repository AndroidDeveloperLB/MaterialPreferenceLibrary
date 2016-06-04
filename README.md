MaterialPreferenceLibrary
==================================

Allows to have a nice Material-Design look&feel for API 7 and above for the PreferenceActivity, including most commonly used preferences and also showing the actionBar.
All the dialogs are using the support library's dialogs, including accent-color.
You can even choose which theme to use.

Supported preferences are:
- **DialogPreference**
- **EditTextPreference**
- **ListPreference**
- **Preference**
- **SwitchPreference**
- **TwoStatePreference**
- **CheckBoxPreference**
- Partial support for (inner) **PreferenceScreen**. It's partial since I can't extend from it (and can't give it to you to be used), so what I did is to at least set the same layout  for all PreferenceScreen classes.
 
In addition to all of those, I've disabled the truncating of the text of all the supported preferences, so that translated text will still be fully shown. Do try ot make them short though.

Import 
======
Via gradle :

	allprojects {
    		repositories {
	        	jcenter()
	        	maven {
            		url "https://jitpack.io"
        			}
    			}
		}
	
		dependencies {
	        compile 'com.github.AndroidDeveloperLB:MaterialPreferenceLibrary:###'
	}
	
Where "###" is the number as shown here: https://jitpack.io/#AndroidDeveloperLB/MaterialPreferenceLibrary/ .

	

Sample 
==================================
Just check the code (it has a sample inside), or see how it works on my app, here:

<a href="https://play.google.com/store/apps/details?id=com.lb.app_manager">
  <img alt="sample app"
       src="en_app_rgb_wo_60.png" />
</a>

Screenshots
==================================
Here's a demo of how the library performs on both Gingerbread and Lollipop, including how the native preferences look and behave:

![demo](https://raw.githubusercontent.com/AndroidDeveloperLB/ActionBarPreferenceActivity/master/demo.gif)


Notes
==================================

1. About the **actionBar**, all this library does is to simply put a Toolbar at the top of the PreferenceActivity, and you need to use the Toolbar instead of the ActionBar.
2. Not all preferences were imported.
3. Sadly, **reflection** was used for 2 functions of "PreferenceManager" which aren't public (yet the framework's classes have full access to it) : "unregisterOnActivityDestroyListener", "registerOnActivityDestroyListener". Those functions seem to be used only for dismissing the dialogs when the activity is being destroyed. Just in case something goes wrong, I've made the code ignore (and write in the logs) in case they are unreachable.
4. Not tested on **PreferenceFragment** (yet), but you can try it using these libraries and see if you can support even older APIs : 
https://github.com/Machinarius/PreferenceFragment-Compat
https://github.com/kolavar/android-support-v4-preferencefragment
5. In order to add **action items**, you need to do it completely via code, without using XML. Otherwise, on some Android versions (or all?), the action items will all gather inside the overflow menu item.
6. Some **attributes** should be used using Android's framework, and some using mine. Sorry for the confusion. 
7. **Preference selection** obviously can't have ripples, but it should at least be possible to have Kitkat style selection for pre-Kitkat versions.
8. Sadly, it **doesn't support all kinds of preferences**. Currently, those are missing:
 - RingtonePreference
 - MultiSelectListPreference
 - others ?



Contribution is appreciated. Please try to be "loyal" to the original code of Android, as I've tried.

Requirements
==
This library needs:
 - API 7 and above.
 - AppCompat v7.

That's it.

Thanks
==
Android's code ?

License
==
It's Apache2 . Do with it what you wish. Credits are appreciated :)

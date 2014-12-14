ActionBarPreferenceActivityLibrary
==================================

Allows to have an ActionBar even on PreferenceActivity, even for pre-Honeycomb versions of Android.

All this library does is to simply put a Toolbar at the top of the PreferenceActivity, and you need to use the Toolbar instead of the ActionBar.

Screenshots
==
Gingerbread :
![enter image description here](https://raw.githubusercontent.com/AndroidDeveloperLB/MaterialStuffLibrary/master/1.png)

Lollipop : 
![enter image description here](https://raw.githubusercontent.com/AndroidDeveloperLB/MaterialStuffLibrary/master/2.png)

Requirements
==
This library needs:
 - API 8 and above.
 - AppCompat v7.

That's it.

What this library doesn't do
==
Sadly, it doesn't style the preferences, but you can use the one of the support library if you wish.

It has handled dialogs in the past, but no longer. If you wish to have material-style dialogs, you can use this great library:
    https://github.com/fengdai/AlertDialogPro

Thanks
==
Didn't get a lot of code from others:
 
 - Some code I got from my own app:
 https://play.google.com/store/apps/details?id=com.lb.app_manager
 - The support library of Google, of course:
 http://android-developers.blogspot.co.il/2014/10/appcompat-v21-material-design-for-pre.html
 - This website:
 https://chris.banes.me/2014/10/17/appcompat-v21/  

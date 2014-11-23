MaterialStuffLibrary
====================

Adds material-style dialogs, and also allow to have an ActionBar even on PreferenceActivity

This library is based on some other libraries, to support the next features:

 - alert dialogs, with a similar style of Material-Design.
 - PreferenceActivity, with support of an ActionBar (which is actually a toolbar that looks like an ActionBar)
 
I made it since the current version of the support library doesn't have any of those things. I've asked about it on StackOverflow ([here](http://stackoverflow.com/q/26473648) and [here](http://stackoverflow.com/q/26495530/)), but what I got wasn't enough to support what I needed.

Screenshots
==
![enter image description here](https://raw.githubusercontent.com/AndroidDeveloperLB/MaterialStuffLibrary/master/1.png)

![enter image description here](https://raw.githubusercontent.com/AndroidDeveloperLB/MaterialStuffLibrary/master/2.png)

Requirements
==
This library needs:
 - API 8 and above.
 - AppCompat v7.

That's it.

What this library doesn't do
==
It doesn't style the preferences, and since it's heavily based on [this library](https://github.com/fengdai/AlertDialogPro), it has the same functionality and style for the dialogs. However, I've cleaned the code and removed un-needed files, so it's lighter.

Thanks
==
The project consists of some libraries and websites I've looked at :
 - AlertDialogPro (for the alert dialogs):
 https://github.com/fengdai/AlertDialogPro
 - ActionBarSherlock (for the shadow below the action bar) :
 http://actionbarsherlock.com/
 - Some code I got from my own app:
 https://play.google.com/store/apps/details?id=com.lb.app_manager
 - The support library of Google, of course:
 http://android-developers.blogspot.co.il/2014/10/appcompat-v21-material-design-for-pre.html
 - This website:
 https://chris.banes.me/2014/10/17/appcompat-v21/  

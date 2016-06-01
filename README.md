Material SnackBar For Android
-----
This is an Open Source Android library that allows developers to easily show notification message on top and bottom.
Feel free to use it all you want in your Android apps provided that you cite this project and include the license in your app.
Support Sdk Version 14 to latest.

Version
-----
- 1.0.0: Just TopSnackBar and BottomSnackBar message (Beta), custom view will release in next time.

Feature
-----
- Custom Colors: should define on colors.xml
    `<color name="snackBarTextColor">#FFFFFF</color>`
    `<color name="snackBarBackgroundColor">#3F51B5</color>`
    `<color name="snackBarColorNotificationError">#FFFF4444</color>`
    `<color name="snackBarColorNotificationWaring">#FFF5A623</color>`
    `<color name="snackBarColorNotificationSuccess">#FF8BC34A</color>`

- Custom dimen: should define on dimens.xml
    `<dimen name="snack_bar_icon_delete_padding">14dp</dimen>`
    `<dimen name="snack_bar_text_message_padding_left">16dp</dimen>`
    `<dimen name="snack_bar_text_message_padding_right">16dp</dimen>`
    `<dimen name="snack_bar_text_message_padding_top">16dp</dimen>`
    `<dimen name="snack_bar_text_message_padding_bottom">16dp</dimen>`

![](https://github.com/viethoa/image-repositories/blob/master/material-snack-bar.gif "Fast scroller alphabet")

Dependency
-----
    repositories {
        maven { url 'https://oss.sonatype.org/content/groups/public' }
    }

    dependencies {
        compile 'com.github.viethoa:snackbar:1.0.0'
    }

    **Or**:

    Download this project and import library in there.

How to use
-----
**Top Snack Bar:**

    TopSnackBarMessage topSnackBarMessage = new TopSnackBarMessage(this);
    topSnackBarMessage.showSuccessMessage(messageRes);
    topSnackBarMessage.showSuccessMessageCloseable(messageRes);

**Bottom Snack Bar:**

    BottomSnackBarMessage bottomSnackBarMessage = new BottomSnackBarMessage(this);
    bottomSnackBarMessage.showSuccessMessage(messageRes);
    bottomSnackBarMessage.showSuccessMessageCloseable(messageRes);

Note: Should download and see my setup in demo.

License
-------

    Copyright 2015 Khuat Viet Hoa

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.




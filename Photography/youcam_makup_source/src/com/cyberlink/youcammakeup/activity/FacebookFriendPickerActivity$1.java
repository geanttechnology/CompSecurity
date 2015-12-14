// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import com.facebook.FacebookException;
import com.facebook.widget.PickerFragment;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            FacebookFriendPickerActivity

class a
    implements com.facebook.widget.ickerActivity._cls1
{

    final FacebookFriendPickerActivity a;

    public void onError(PickerFragment pickerfragment, FacebookException facebookexception)
    {
        FacebookFriendPickerActivity.a(a, facebookexception.getMessage());
    }

    (FacebookFriendPickerActivity facebookfriendpickeractivity)
    {
        a = facebookfriendpickeractivity;
        super();
    }
}

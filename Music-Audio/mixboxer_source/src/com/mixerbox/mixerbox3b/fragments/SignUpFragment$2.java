// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b.fragments;

import android.view.View;
import com.flurry.android.FlurryAgent;
import com.mixerbox.mixerbox3b.MainPage;
import com.mixerbox.mixerbox3b.classes.MyFbLoginButton;

// Referenced classes of package com.mixerbox.mixerbox3b.fragments:
//            SignUpFragment

class inClickListener extends com.mixerbox.mixerbox3b.classes.oginClickListener
{

    final SignUpFragment this$0;

    public void onClick(View view)
    {
        ((MainPage)getActivity()).canSetLocalNotification = false;
        ((MainPage)getActivity()).shouldSendNoti = false;
        ((MainPage)getActivity()).shouldPlayAfterReady = false;
        ((MainPage)getActivity()).closePlayer();
        if (checkLoginType == 1)
        {
            FlurryAgent.logEvent("action:djs_page_login");
        }
        checkLoginType = 1;
        super.onClick(view);
    }

    inClickListener(MyFbLoginButton myfbloginbutton)
    {
        this$0 = SignUpFragment.this;
        myfbloginbutton.getClass();
        super(myfbloginbutton);
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.programdetails;

import android.content.DialogInterface;
import android.os.Bundle;
import com.comcast.cim.model.system.PlayerAndroidDevice;
import com.xfinity.playerlib.view.PlayNowActivity;

// Referenced classes of package com.xfinity.playerlib.view.programdetails:
//            FetchCanceledListener

public abstract class DetailActivity extends PlayNowActivity
    implements FetchCanceledListener
{

    public DetailActivity()
    {
    }

    public void onCancel(DialogInterface dialoginterface)
    {
        finish();
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setTitle("");
    }

    protected void setupTalkDelegateForAccessibilityViaLayout()
    {
        if (isAccessibilityEnabled() && androidDevice.isTabletDevice())
        {
            setTheme(com.xfinity.playerlib.R.style.Theme_xfinity);
        }
        super.setupTalkDelegateForAccessibilityViaLayout();
    }
}

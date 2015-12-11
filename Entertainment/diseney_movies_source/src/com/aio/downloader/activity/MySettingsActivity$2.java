// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.activity;

import android.content.SharedPreferences;
import android.widget.CompoundButton;

// Referenced classes of package com.aio.downloader.activity:
//            MySettingsActivity

class this._cls0
    implements android.widget.kedChangeListener
{

    final MySettingsActivity this$0;

    public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
    {
        if (flag)
        {
            MySettingsActivity.access$4(MySettingsActivity.this).edit().putBoolean("isopen", true).commit();
            return;
        } else
        {
            MySettingsActivity.access$4(MySettingsActivity.this).edit().putBoolean("isopen", false).commit();
            return;
        }
    }

    ener()
    {
        this$0 = MySettingsActivity.this;
        super();
    }
}

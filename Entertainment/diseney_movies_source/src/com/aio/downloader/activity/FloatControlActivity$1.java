// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.activity;

import android.content.SharedPreferences;
import android.widget.CompoundButton;

// Referenced classes of package com.aio.downloader.activity:
//            FloatControlActivity

class this._cls0
    implements android.widget.dChangeListener
{

    final FloatControlActivity this$0;

    public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
    {
        if (flag)
        {
            startService(FloatControlActivity.access$0(FloatControlActivity.this));
            FloatControlActivity.access$1(FloatControlActivity.this).edit().putBoolean("fctri", true).commit();
            return;
        } else
        {
            stopService(FloatControlActivity.access$0(FloatControlActivity.this));
            FloatControlActivity.access$1(FloatControlActivity.this).edit().putBoolean("fctri", false).commit();
            return;
        }
    }

    er()
    {
        this$0 = FloatControlActivity.this;
        super();
    }
}

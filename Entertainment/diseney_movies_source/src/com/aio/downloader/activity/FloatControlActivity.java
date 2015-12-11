// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import com.aio.downloader.floatwindow.FloatWindowService;

public class FloatControlActivity extends Activity
    implements android.view.View.OnClickListener
{

    private CheckBox cb_float;
    private Intent intent_float;
    private SharedPreferences userInfo;

    public FloatControlActivity()
    {
    }

    public void onClick(View view)
    {
        switch (view.getId())
        {
        default:
            return;

        case 2131165655: 
            finish();
            break;
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030043);
        findViewById(0x7f0701d7).setOnClickListener(this);
        cb_float = (CheckBox)findViewById(0x7f0701d8);
        intent_float = new Intent(getApplicationContext(), com/aio/downloader/floatwindow/FloatWindowService);
        userInfo = getSharedPreferences("floatctri", 0);
        if (getSharedPreferences("floatctri", 0).getBoolean("fctri", true))
        {
            cb_float.setChecked(true);
            startService(intent_float);
        } else
        {
            cb_float.setChecked(false);
            stopService(intent_float);
        }
        cb_float.setOnCheckedChangeListener(new android.widget.CompoundButton.OnCheckedChangeListener() {

            final FloatControlActivity this$0;

            public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
            {
                if (flag)
                {
                    startService(intent_float);
                    userInfo.edit().putBoolean("fctri", true).commit();
                    return;
                } else
                {
                    stopService(intent_float);
                    userInfo.edit().putBoolean("fctri", false).commit();
                    return;
                }
            }

            
            {
                this$0 = FloatControlActivity.this;
                super();
            }
        });
    }


}

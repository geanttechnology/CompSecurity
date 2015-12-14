// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.unittest.dataeditcenter;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.e;
import com.pf.common.utility.m;

public class DataEditCenterTestbedActivity extends Activity
{

    private e a;
    private TextView b;

    public DataEditCenterTestbedActivity()
    {
    }

    private void a()
    {
        b.setText("testMain\n");
        m.e("testMain", "start");
        m.e("testMain", "end");
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030007);
        a = e.a();
        b = (TextView)findViewById(0x7f0c00af);
        a();
    }
}

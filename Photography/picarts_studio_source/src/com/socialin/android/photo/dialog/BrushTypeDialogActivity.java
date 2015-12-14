// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.dialog;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import com.socialin.android.activity.BaseActivity;
import com.socialin.android.apiv3.util.AnalyticUtils;
import myobfuscated.cc.a;
import myobfuscated.f.m;

public class BrushTypeDialogActivity extends BaseActivity
{

    public BrushTypeDialogActivity()
    {
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030048);
        bundle = getIntent();
        byte byte0 = 30;
        boolean flag = true;
        int j = ((flag) ? 1 : 0);
        int i = byte0;
        if (bundle != null)
        {
            bundle = bundle.getExtras();
            j = ((flag) ? 1 : 0);
            i = byte0;
            if (bundle != null)
            {
                i = bundle.getInt("size");
                j = bundle.getInt("type");
            }
        }
        Log.e("ex", (new StringBuilder("brushSize = ")).append(i).toString());
        Log.e("ex", (new StringBuilder("brushType = ")).append(j).toString());
        AnalyticUtils.getInstance(this).trackLocalAction("brushTypeDialog:onCreate");
        new a(this, i, j);
        m.a(this).setText(0x7f080113);
    }
}

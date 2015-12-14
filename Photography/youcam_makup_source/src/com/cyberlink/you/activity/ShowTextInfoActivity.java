// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;
import com.cyberlink.you.BaseActivity;
import com.cyberlink.you.o;
import com.cyberlink.you.p;

public class ShowTextInfoActivity extends BaseActivity
{

    public ShowTextInfoActivity()
    {
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(p.u_activity_show_text_info);
        if (getIntent() != null)
        {
            bundle = getIntent().getStringExtra("displayText");
            if (bundle == null)
            {
                bundle = "No Info Data show \n";
            }
            TextView textview = (TextView)findViewById(o.ShowTextInfoTextArea);
            textview.setText(bundle);
            textview.setMovementMethod(new ScrollingMovementMethod());
        }
    }
}

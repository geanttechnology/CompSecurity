// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano.registration;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import com.smule.pianoandroid.magicpiano.ag;
import com.smule.pianoandroid.magicpiano.b.e;

public class FacebookEmailActivity extends ag
{

    private EditText a;

    public FacebookEmailActivity()
    {
    }

    static EditText a(FacebookEmailActivity facebookemailactivity)
    {
        return facebookemailactivity.a;
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f03002b);
        a = (EditText)findViewById(0x7f0a00b9);
        findViewById(0x7f0a00b7).setOnClickListener(new android.view.View.OnClickListener() {

            final FacebookEmailActivity a;

            public void onClick(View view)
            {
                view = new e(a, FacebookEmailActivity.a(a).getText().toString(), false);
                view.execute(new Void[0]);
                if (view.a())
                {
                    a.finish();
                }
            }

            
            {
                a = FacebookEmailActivity.this;
                super();
            }
        });
    }
}

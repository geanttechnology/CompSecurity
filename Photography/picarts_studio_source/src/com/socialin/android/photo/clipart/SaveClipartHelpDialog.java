// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.clipart;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import com.socialin.android.util.a;
import myobfuscated.f.m;

public class SaveClipartHelpDialog extends AppCompatActivity
{

    private a a;

    public SaveClipartHelpDialog()
    {
    }

    static a a(SaveClipartHelpDialog savecliparthelpdialog)
    {
        return savecliparthelpdialog.a;
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        a = new a(this);
        setContentView(0x7f030195);
        m.a(this).setText(getString(0x7f0802a3));
        findViewById(0x7f100125).setOnClickListener(new android.view.View.OnClickListener() {

            private SaveClipartHelpDialog a;

            public final void onClick(View view)
            {
                if (a.getIntent().getStringExtra("from").equals("freeCrop"))
                {
                    com.socialin.android.photo.clipart.SaveClipartHelpDialog.a(a).a("save-clipart-help-opened-freeCrop", true);
                }
                if (a.getIntent().getStringExtra("from").equals("collageCrop"))
                {
                    com.socialin.android.photo.clipart.SaveClipartHelpDialog.a(a).a("save-clipart-help-opened-collageCrop", true);
                }
                if (a.getIntent().getStringExtra("from").equals("selectionMainFragment"))
                {
                    com.socialin.android.photo.clipart.SaveClipartHelpDialog.a(a).a("save-clipart-help-opened-selectionMainFragment", true);
                }
                a.finish();
            }

            
            {
                a = SaveClipartHelpDialog.this;
                super();
            }
        });
    }
}

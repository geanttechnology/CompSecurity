// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.picsart.profile.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import com.socialin.android.activity.BaseActivity;
import com.socialin.android.picsart.profile.util.y;
import com.socialin.android.util.Utils;
import com.socialin.android.util.s;

public class UserPasswordConfirmActivity extends BaseActivity
{

    public UserPasswordConfirmActivity()
    {
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f03022e);
        findViewById(0x7f100a2b).setOnClickListener(new android.view.View.OnClickListener() {

            private UserPasswordConfirmActivity a;

            public final void onClick(View view)
            {
                if (!s.a(a))
                {
                    y.b(a);
                    return;
                }
                view = ((EditText)a.findViewById(0x7f100a28)).getText().toString();
                if (view.contains(" ") || "".equals(view))
                {
                    Utils.a(a, 0x7f08023a);
                    return;
                } else
                {
                    a.getIntent().putExtra("passwordConfirm", view.trim());
                    a.setResult(-1, a.getIntent());
                    a.finish();
                    return;
                }
            }

            
            {
                a = UserPasswordConfirmActivity.this;
                super();
            }
        });
    }
}

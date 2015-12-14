// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.facebook.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import com.socialin.android.activity.BaseActivity;
import com.socialin.android.dialog.g;
import myobfuscated.ad.h;
import myobfuscated.f.m;

public class FacebookSettingsDialogActivity extends BaseActivity
    implements android.view.View.OnClickListener
{

    private g a;
    private View b;
    private CheckBox c;
    private CheckBox d;
    private CheckBox e;
    private CheckBox f;
    private CheckBox g;
    private CheckBox h;
    private CheckBox i;
    private SharedPreferences j;

    public FacebookSettingsDialogActivity()
    {
        a = null;
    }

    static CheckBox a(FacebookSettingsDialogActivity facebooksettingsdialogactivity)
    {
        return facebooksettingsdialogactivity.c;
    }

    static void a(FacebookSettingsDialogActivity facebooksettingsdialogactivity, boolean flag)
    {
        facebooksettingsdialogactivity.d.setChecked(flag);
        facebooksettingsdialogactivity.e.setChecked(flag);
        facebooksettingsdialogactivity.f.setChecked(flag);
        facebooksettingsdialogactivity.g.setChecked(flag);
        facebooksettingsdialogactivity.h.setChecked(flag);
        facebooksettingsdialogactivity.i.setChecked(flag);
    }

    private void a(String s)
    {
        Intent intent = getIntent();
        intent.putExtra("fbAppId", getString(0x7f0808e2));
        intent.putExtra("method", s);
    }

    static CheckBox b(FacebookSettingsDialogActivity facebooksettingsdialogactivity)
    {
        return facebooksettingsdialogactivity.i;
    }

    static SharedPreferences c(FacebookSettingsDialogActivity facebooksettingsdialogactivity)
    {
        return facebooksettingsdialogactivity.j;
    }

    static CheckBox d(FacebookSettingsDialogActivity facebooksettingsdialogactivity)
    {
        return facebooksettingsdialogactivity.d;
    }

    static CheckBox e(FacebookSettingsDialogActivity facebooksettingsdialogactivity)
    {
        return facebooksettingsdialogactivity.e;
    }

    static CheckBox f(FacebookSettingsDialogActivity facebooksettingsdialogactivity)
    {
        return facebooksettingsdialogactivity.f;
    }

    static CheckBox g(FacebookSettingsDialogActivity facebooksettingsdialogactivity)
    {
        return facebooksettingsdialogactivity.g;
    }

    static CheckBox h(FacebookSettingsDialogActivity facebooksettingsdialogactivity)
    {
        return facebooksettingsdialogactivity.h;
    }

    public void onClick(View view)
    {
        boolean flag = true;
        if (view != null)
        {
            if (view.getId() == 0x7f1004ea)
            {
                view = (CheckBox)findViewById(0x7f1004e8);
                if (view != null && j != null)
                {
                    android.content.SharedPreferences.Editor editor = j.edit();
                    if (!view.isChecked())
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    editor.putBoolean("enable_fb_settings_dialog", flag).apply();
                }
                setResult(0);
                finish();
                return;
            }
            if (view.getId() == 0x7f1004eb)
            {
                view = (CheckBox)findViewById(0x7f1004e8);
                if (view != null && j != null)
                {
                    android.content.SharedPreferences.Editor editor1 = j.edit();
                    if (view.isChecked())
                    {
                        flag = false;
                    }
                    editor1.putBoolean("enable_fb_settings_dialog", flag).apply();
                }
                if (c.isChecked())
                {
                    new h() {

                    };
                    a("fbAskWritePermissions");
                    return;
                }
                if (i.isChecked())
                {
                    new h() {

                    };
                    a("fbAskPagePermissions");
                    return;
                }
                if (d.isChecked() || e.isChecked() || f.isChecked() || g.isChecked() || h.isChecked())
                {
                    new h() {

                    };
                    a("fbAskPostPermissions");
                    return;
                } else
                {
                    setResult(0);
                    finish();
                    return;
                }
            }
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f0300f0);
        bundle = getResources().getDrawable(0x7f02045f);
        TextView textview = m.a(this);
        textview.setCompoundDrawablesWithIntrinsicBounds(bundle, null, null, null);
        textview.setText(0x7f08060d);
        a = new g(this);
        a.setMessage(getString(0x7f0803d8));
        j = getSharedPreferences((new StringBuilder("sinPref_")).append(getString(m.e(this, "app_name_short"))).toString(), 0);
        b = LayoutInflater.from(this).inflate(0x7f0300ef, null);
        ((ViewGroup)findViewById(0x7f1004e7)).addView(b);
        c = (CheckBox)b.findViewById(0x7f1004db);
        d = (CheckBox)b.findViewById(0x7f1004df);
        e = (CheckBox)b.findViewById(0x7f1004e1);
        f = (CheckBox)b.findViewById(0x7f1004e3);
        g = (CheckBox)b.findViewById(0x7f1004e4);
        h = (CheckBox)b.findViewById(0x7f1004e6);
        i = (CheckBox)b.findViewById(0x7f1004dd);
        findViewById(0x7f1004ea).setOnClickListener(this);
        findViewById(0x7f1004eb).setOnClickListener(this);
        c.setOnClickListener(new android.view.View.OnClickListener() {

            private FacebookSettingsDialogActivity a;

            public final void onClick(View view)
            {
                FacebookSettingsDialogActivity.a(a, FacebookSettingsDialogActivity.a(a).isChecked());
            }

            
            {
                a = FacebookSettingsDialogActivity.this;
                super();
            }
        });
        i.setOnClickListener(new android.view.View.OnClickListener() {

            private FacebookSettingsDialogActivity a;

            public final void onClick(View view)
            {
                boolean flag = FacebookSettingsDialogActivity.b(a).isChecked();
                FacebookSettingsDialogActivity.c(a).edit().putBoolean("enable_fb_post_to_pages", flag).apply();
                if (!flag)
                {
                    FacebookSettingsDialogActivity.a(a).setChecked(false);
                } else
                if (FacebookSettingsDialogActivity.d(a).isChecked() && FacebookSettingsDialogActivity.e(a).isChecked() && FacebookSettingsDialogActivity.f(a).isChecked() && com.socialin.android.facebook.activity.FacebookSettingsDialogActivity.g(a).isChecked() && com.socialin.android.facebook.activity.FacebookSettingsDialogActivity.h(a).isChecked())
                {
                    FacebookSettingsDialogActivity.a(a).setChecked(true);
                    return;
                }
            }

            
            {
                a = FacebookSettingsDialogActivity.this;
                super();
            }
        });
        d.setOnClickListener(new android.view.View.OnClickListener() {

            private FacebookSettingsDialogActivity a;

            public final void onClick(View view)
            {
                FacebookSettingsDialogActivity.c(a).edit().putBoolean("enable_fb_action_add", FacebookSettingsDialogActivity.d(a).isChecked()).apply();
                if (!FacebookSettingsDialogActivity.d(a).isChecked())
                {
                    FacebookSettingsDialogActivity.a(a).setChecked(false);
                } else
                if (FacebookSettingsDialogActivity.e(a).isChecked() && FacebookSettingsDialogActivity.f(a).isChecked() && com.socialin.android.facebook.activity.FacebookSettingsDialogActivity.g(a).isChecked() && com.socialin.android.facebook.activity.FacebookSettingsDialogActivity.h(a).isChecked() && FacebookSettingsDialogActivity.b(a).isChecked())
                {
                    FacebookSettingsDialogActivity.a(a).setChecked(true);
                    return;
                }
            }

            
            {
                a = FacebookSettingsDialogActivity.this;
                super();
            }
        });
        b.findViewById(0x7f1004e0).setOnClickListener(new android.view.View.OnClickListener() {

            private FacebookSettingsDialogActivity a;

            public final void onClick(View view)
            {
                FacebookSettingsDialogActivity.c(a).edit().putBoolean("enable_fb_action_like", FacebookSettingsDialogActivity.e(a).isChecked()).apply();
                if (!FacebookSettingsDialogActivity.e(a).isChecked())
                {
                    FacebookSettingsDialogActivity.a(a).setChecked(false);
                } else
                if (FacebookSettingsDialogActivity.d(a).isChecked() && FacebookSettingsDialogActivity.f(a).isChecked() && com.socialin.android.facebook.activity.FacebookSettingsDialogActivity.g(a).isChecked() && com.socialin.android.facebook.activity.FacebookSettingsDialogActivity.h(a).isChecked() && FacebookSettingsDialogActivity.b(a).isChecked())
                {
                    FacebookSettingsDialogActivity.a(a).setChecked(true);
                    return;
                }
            }

            
            {
                a = FacebookSettingsDialogActivity.this;
                super();
            }
        });
        f.setOnClickListener(new android.view.View.OnClickListener() {

            private FacebookSettingsDialogActivity a;

            public final void onClick(View view)
            {
                FacebookSettingsDialogActivity.c(a).edit().putBoolean("enable_fb_action_comment", FacebookSettingsDialogActivity.f(a).isChecked()).apply();
                if (!FacebookSettingsDialogActivity.f(a).isChecked())
                {
                    FacebookSettingsDialogActivity.a(a).setChecked(false);
                } else
                if (FacebookSettingsDialogActivity.d(a).isChecked() && FacebookSettingsDialogActivity.e(a).isChecked() && com.socialin.android.facebook.activity.FacebookSettingsDialogActivity.g(a).isChecked() && com.socialin.android.facebook.activity.FacebookSettingsDialogActivity.h(a).isChecked() && FacebookSettingsDialogActivity.b(a).isChecked())
                {
                    FacebookSettingsDialogActivity.a(a).setChecked(true);
                    return;
                }
            }

            
            {
                a = FacebookSettingsDialogActivity.this;
                super();
            }
        });
        g.setOnClickListener(new android.view.View.OnClickListener() {

            private FacebookSettingsDialogActivity a;

            public final void onClick(View view)
            {
                FacebookSettingsDialogActivity.c(a).edit().putBoolean("enable_fb_action_follow", com.socialin.android.facebook.activity.FacebookSettingsDialogActivity.g(a).isChecked()).apply();
                if (!com.socialin.android.facebook.activity.FacebookSettingsDialogActivity.g(a).isChecked())
                {
                    FacebookSettingsDialogActivity.a(a).setChecked(false);
                } else
                if (FacebookSettingsDialogActivity.d(a).isChecked() && FacebookSettingsDialogActivity.e(a).isChecked() && FacebookSettingsDialogActivity.f(a).isChecked() && com.socialin.android.facebook.activity.FacebookSettingsDialogActivity.h(a).isChecked() && FacebookSettingsDialogActivity.b(a).isChecked())
                {
                    FacebookSettingsDialogActivity.a(a).setChecked(true);
                    return;
                }
            }

            
            {
                a = FacebookSettingsDialogActivity.this;
                super();
            }
        });
        h.setOnClickListener(new android.view.View.OnClickListener() {

            private FacebookSettingsDialogActivity a;

            public final void onClick(View view)
            {
                FacebookSettingsDialogActivity.c(a).edit().putBoolean("enable_fb_action_vote", com.socialin.android.facebook.activity.FacebookSettingsDialogActivity.h(a).isChecked()).apply();
                if (!com.socialin.android.facebook.activity.FacebookSettingsDialogActivity.h(a).isChecked())
                {
                    FacebookSettingsDialogActivity.a(a).setChecked(false);
                } else
                if (FacebookSettingsDialogActivity.d(a).isChecked() && FacebookSettingsDialogActivity.e(a).isChecked() && FacebookSettingsDialogActivity.f(a).isChecked() && com.socialin.android.facebook.activity.FacebookSettingsDialogActivity.g(a).isChecked() && FacebookSettingsDialogActivity.b(a).isChecked())
                {
                    FacebookSettingsDialogActivity.a(a).setChecked(true);
                    return;
                }
            }

            
            {
                a = FacebookSettingsDialogActivity.this;
                super();
            }
        });
        bundle = getIntent();
        bundle.putExtra("fbAppId", getString(0x7f0808e2));
        bundle.putExtra("method", "fbSessionCheck");
    }

    public boolean onKeyDown(int k, KeyEvent keyevent)
    {
        if (k == 0)
        {
            setResult(0);
            finish();
            return true;
        } else
        {
            return super.onKeyDown(k, keyevent);
        }
    }
}

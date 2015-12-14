// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.tools;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;
import com.picsart.studio.PicsartContext;
import com.socialin.android.activity.BaseActivity;
import com.socialin.android.util.Utils;
import com.socialin.android.util.n;
import com.socialin.android.util.w;
import myobfuscated.f.m;

public class ResizeDialogActivity extends BaseActivity
{

    private int a;
    private int b;
    private boolean c;

    public ResizeDialogActivity()
    {
        a = 0;
        b = 0;
        c = true;
    }

    static boolean a(ResizeDialogActivity resizedialogactivity)
    {
        return resizedialogactivity.c;
    }

    static boolean a(ResizeDialogActivity resizedialogactivity, boolean flag)
    {
        resizedialogactivity.c = flag;
        return flag;
    }

    static int b(ResizeDialogActivity resizedialogactivity)
    {
        return resizedialogactivity.b;
    }

    static int c(ResizeDialogActivity resizedialogactivity)
    {
        return resizedialogactivity.a;
    }

    public void finish()
    {
        super.finish();
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        getWindow().setFlags(1024, 1024);
        setContentView(0x7f0300a7);
        m.a(this).setText(0x7f080118);
        bundle = getIntent().getExtras();
        a = bundle.getInt("width", 0);
        b = bundle.getInt("height", 0);
        bundle = (EditText)findViewById(0x7f10038f);
        EditText edittext = (EditText)findViewById(0x7f100390);
        bundle.setText(String.valueOf(a));
        edittext.setText(String.valueOf(b));
        bundle.setOnFocusChangeListener(new android.view.View.OnFocusChangeListener() {

            private ResizeDialogActivity a;

            public final void onFocusChange(View view, boolean flag)
            {
                ResizeDialogActivity.a(a, flag);
            }

            
            {
                a = ResizeDialogActivity.this;
                super();
            }
        });
        bundle.addTextChangedListener(new TextWatcher(edittext) {

            private EditText a;
            private ResizeDialogActivity b;

            public final void afterTextChanged(Editable editable)
            {
                if (ResizeDialogActivity.a(b) && !editable.toString().equals(""))
                {
                    int i = Math.round(((float)ResizeDialogActivity.b(b) / (float)ResizeDialogActivity.c(b)) * (float)Integer.parseInt(editable.toString()));
                    a.setText(String.valueOf(i));
                }
            }

            public final void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
            {
            }

            public final void onTextChanged(CharSequence charsequence, int i, int j, int k)
            {
            }

            
            {
                b = ResizeDialogActivity.this;
                a = edittext;
                super();
            }
        });
        edittext.setOnFocusChangeListener(new android.view.View.OnFocusChangeListener() {

            private ResizeDialogActivity a;

            public final void onFocusChange(View view, boolean flag)
            {
                view = a;
                if (!flag)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                ResizeDialogActivity.a(view, flag);
            }

            
            {
                a = ResizeDialogActivity.this;
                super();
            }
        });
        edittext.addTextChangedListener(new TextWatcher(bundle) {

            private EditText a;
            private ResizeDialogActivity b;

            public final void afterTextChanged(Editable editable)
            {
                if (!ResizeDialogActivity.a(b) && !editable.toString().equals(""))
                {
                    int i = Math.round(((float)ResizeDialogActivity.c(b) / (float)ResizeDialogActivity.b(b)) * (float)Integer.parseInt(editable.toString()));
                    a.setText(String.valueOf(i));
                }
            }

            public final void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
            {
            }

            public final void onTextChanged(CharSequence charsequence, int i, int j, int k)
            {
            }

            
            {
                b = ResizeDialogActivity.this;
                a = edittext;
                super();
            }
        });
        findViewById(0x7f100380).setOnClickListener(new android.view.View.OnClickListener(edittext, bundle) {

            private EditText a;
            private EditText b;
            private ResizeDialogActivity c;

            public final void onClick(View view)
            {
                boolean flag = true;
                if (!a.getText().toString().equals("") && !b.getText().toString().equals(""))
                {
                    int i = Integer.parseInt(b.getText().toString());
                    int j = Integer.parseInt(a.getText().toString());
                    if (i >= 50 && j >= 50)
                    {
                        if (i == ResizeDialogActivity.c(c) && j == ResizeDialogActivity.b(c))
                        {
                            c.setResult(0);
                            c.finish();
                        } else
                        if (i * j <= PicsartContext.a())
                        {
                            view = new Intent();
                            view.putExtra("width", i);
                            view.putExtra("height", j);
                            c.setResult(-1, view);
                            c.finish();
                        } else
                        {
                            view = w.a(new n(i, j), PicsartContext.a());
                            view = (new StringBuilder()).append(c.getResources().getString(0x7f080567, new Object[] {
                                Integer.valueOf(Math.round(PicsartContext.a() / 0x100000))
                            })).append(" (").append(((n) (view)).a).append("x").append(((n) (view)).b).append(")").toString();
                            Utils.c(c, view);
                        }
                    } else
                    {
                        view = c.getResources().getString(0x7f080566);
                        Utils.c(c, view);
                    }
                } else
                {
                    flag = false;
                }
                if (!flag)
                {
                    c.setResult(0);
                    c.finish();
                }
            }

            
            {
                c = ResizeDialogActivity.this;
                a = edittext;
                b = edittext1;
                super();
            }
        });
        findViewById(0x7f10037f).setOnClickListener(new android.view.View.OnClickListener() {

            private ResizeDialogActivity a;

            public final void onClick(View view)
            {
                a.setResult(0);
                a.finish();
            }

            
            {
                a = ResizeDialogActivity.this;
                super();
            }
        });
        Utils.b(hashCode());
    }

    protected void onPause()
    {
        super.onPause();
    }

    protected void onResume()
    {
        super.onResume();
        Utils.b(hashCode());
    }
}

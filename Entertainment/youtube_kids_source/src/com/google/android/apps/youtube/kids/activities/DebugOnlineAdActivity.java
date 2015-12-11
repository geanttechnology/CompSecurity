// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.apps.youtube.kids.activities;

import a;
import android.app.AlertDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.EditText;
import bgs;
import bgv;
import nc;
import vq;
import wk;
import wl;
import wm;
import wn;
import wo;
import wp;
import wq;
import wr;

public class DebugOnlineAdActivity extends vq
{

    private final Context h = this;
    private bgs i;
    private CheckBox j;
    private CheckBox k;
    private CheckBox l;
    private EditText m;
    private CheckBox n;
    private EditText o;
    private boolean p;

    public DebugOnlineAdActivity()
    {
    }

    public static CheckBox a(DebugOnlineAdActivity debugonlineadactivity)
    {
        return debugonlineadactivity.j;
    }

    public static bgs b(DebugOnlineAdActivity debugonlineadactivity)
    {
        return debugonlineadactivity.i;
    }

    private void b(boolean flag)
    {
        EditText edittext = new EditText(h);
        android.app.AlertDialog.Builder builder = (new android.app.AlertDialog.Builder(h)).setView(edittext);
        String s;
        if (flag)
        {
            s = i.d();
        } else
        {
            s = i.e();
        }
        edittext.setText(s);
        builder.setPositiveButton("OK", new wr(this, edittext, flag)).setNegativeButton("Cancel", new wq(this));
        builder.create().show();
    }

    public static void c(DebugOnlineAdActivity debugonlineadactivity)
    {
        debugonlineadactivity.h();
    }

    public static boolean d(DebugOnlineAdActivity debugonlineadactivity)
    {
        return debugonlineadactivity.p;
    }

    public static CheckBox e(DebugOnlineAdActivity debugonlineadactivity)
    {
        return debugonlineadactivity.k;
    }

    public static CheckBox f(DebugOnlineAdActivity debugonlineadactivity)
    {
        return debugonlineadactivity.l;
    }

    public static void g(DebugOnlineAdActivity debugonlineadactivity)
    {
        debugonlineadactivity.b(true);
    }

    public static CheckBox h(DebugOnlineAdActivity debugonlineadactivity)
    {
        return debugonlineadactivity.n;
    }

    private void h()
    {
        boolean flag1 = true;
        k.setEnabled(j.isChecked());
        l.setEnabled(j.isChecked());
        EditText edittext = m;
        boolean flag;
        if (j.isChecked() && l.isChecked())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        edittext.setEnabled(flag);
        n.setEnabled(j.isChecked());
        edittext = o;
        if (j.isChecked() && n.isChecked())
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        edittext.setEnabled(flag);
    }

    public static void i(DebugOnlineAdActivity debugonlineadactivity)
    {
        debugonlineadactivity.b(false);
    }

    public static EditText j(DebugOnlineAdActivity debugonlineadactivity)
    {
        return debugonlineadactivity.m;
    }

    public static EditText k(DebugOnlineAdActivity debugonlineadactivity)
    {
        return debugonlineadactivity.o;
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        if (!a.e(this))
        {
            finish();
        }
        setContentView(0x7f040028);
        i = new bgs(((nc)getApplication()).a.i());
        j = (CheckBox)findViewById(0x7f1000d6);
        k = (CheckBox)findViewById(0x7f1000d7);
        l = (CheckBox)findViewById(0x7f1000d8);
        m = (EditText)findViewById(0x7f1000d9);
        n = (CheckBox)findViewById(0x7f1000da);
        o = (EditText)findViewById(0x7f1000db);
        p = i.a();
        j.setOnClickListener(new wk(this));
        k.setOnClickListener(new wl(this));
        l.setOnClickListener(new wm(this));
        m.setOnClickListener(new wn(this));
        n.setOnClickListener(new wo(this));
        o.setOnClickListener(new wp(this));
    }

    protected void onResume()
    {
        super.onResume();
        j.setChecked(i.a());
        k.setChecked(i.b());
        l.setChecked(i.c());
        m.setText(i.d());
        n.setChecked(i.a.getBoolean("forceBrowseAdEnable", false));
        o.setText(i.e());
        h();
    }
}

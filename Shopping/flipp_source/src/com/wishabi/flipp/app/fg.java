// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.app;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

// Referenced classes of package com.wishabi.flipp.app:
//            fh, fj, fi, fk, 
//            fl, fm

public final class fg extends DialogFragment
{

    private EditText a;
    private EditText b;
    private EditText c;
    private CheckBox d;
    private AlertDialog e;

    public fg()
    {
    }

    static CheckBox a(fg fg1)
    {
        return fg1.d;
    }

    static EditText b(fg fg1)
    {
        return fg1.a;
    }

    static EditText c(fg fg1)
    {
        return fg1.b;
    }

    static EditText d(fg fg1)
    {
        return fg1.c;
    }

    static void e(fg fg1)
    {
        Button button = fg1.e.getButton(-1);
        if (button != null)
        {
            boolean flag;
            if (fg1.a.length() > 0 && (!fg1.d.isChecked() || fg1.b.length() > 0 || fg1.c.length() > 0))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            button.setEnabled(flag);
        }
    }

    public final Dialog onCreateDialog(Bundle bundle)
    {
        Object obj1 = getActivity();
        if (obj1 == null)
        {
            return null;
        }
        bundle = new android.app.AlertDialog.Builder(((android.content.Context) (obj1)));
        ViewGroup viewgroup = (ViewGroup)getActivity().getLayoutInflater().inflate(0x7f030051, null);
        if (viewgroup == null)
        {
            return null;
        }
        Object obj = viewgroup.findViewById(0x7f0b013b);
        d = (CheckBox)viewgroup.findViewById(0x7f0b013a);
        if (obj != null)
        {
            d.setOnClickListener(new fh(this, ((android.view.View) (obj))));
        }
        a = (EditText)viewgroup.findViewById(0x7f0b00be);
        b = (EditText)viewgroup.findViewById(0x7f0b013c);
        c = (EditText)viewgroup.findViewById(0x7f0b013d);
        obj = getActivity().getSharedPreferences("com.wishabi.flipp.preferences", 0);
        Object obj2 = ((SharedPreferences) (obj)).getString("email", null);
        String s = ((SharedPreferences) (obj)).getString("twitter_handle", null);
        b.setText(((CharSequence) (obj2)));
        c.setText(s);
        obj2 = ((Activity) (obj1)).getPackageManager();
        obj1 = ((Activity) (obj1)).getPackageName();
        if (obj2 != null)
        {
            try
            {
                obj1 = ((PackageManager) (obj2)).getPackageInfo(((String) (obj1)), 0).versionName;
            }
            catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception) { }
        }
        bundle.setMessage(0x7f0e0115).setView(viewgroup).setPositiveButton(0x7f0e0123, new fj(this, ((SharedPreferences) (obj)), viewgroup)).setNegativeButton(0x1040000, new fi(this));
        e = bundle.create();
        e.setOnShowListener(new fk(this));
        d.setOnCheckedChangeListener(new fl(this));
        bundle = new fm(this);
        a.addTextChangedListener(bundle);
        b.addTextChangedListener(bundle);
        c.addTextChangedListener(bundle);
        return e;
    }
}

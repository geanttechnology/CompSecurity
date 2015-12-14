// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.internal.widget.SpinnerCompat;
import android.widget.ListAdapter;

public class cb
    implements android.content.DialogInterface.OnClickListener, ce
{

    final SpinnerCompat a;
    private AlertDialog b;
    private ListAdapter c;
    private CharSequence d;

    private cb(SpinnerCompat spinnercompat)
    {
        a = spinnercompat;
        super();
    }

    public cb(SpinnerCompat spinnercompat, android.support.v7.internal.widget.SpinnerCompat._cls1 _pcls1)
    {
        this(spinnercompat);
    }

    public void a()
    {
        if (b != null)
        {
            b.dismiss();
            b = null;
        }
    }

    public void a(ListAdapter listadapter)
    {
        c = listadapter;
    }

    public void a(CharSequence charsequence)
    {
        d = charsequence;
    }

    public boolean b()
    {
        if (b != null)
        {
            return b.isShowing();
        } else
        {
            return false;
        }
    }

    public void c()
    {
        if (c == null)
        {
            return;
        }
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(a.getContext());
        if (d != null)
        {
            builder.setTitle(d);
        }
        b = builder.setSingleChoiceItems(c, a.getSelectedItemPosition(), this).create();
        b.show();
    }

    public void onClick(DialogInterface dialoginterface, int i)
    {
        a.setSelection(i);
        if (a.mOnItemClickListener != null)
        {
            a.performItemClick(null, i, c.getItemId(i));
        }
        a();
    }
}

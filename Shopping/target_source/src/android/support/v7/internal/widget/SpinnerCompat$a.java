// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.internal.widget;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.widget.ListAdapter;

// Referenced classes of package android.support.v7.internal.widget:
//            SpinnerCompat

private class <init>
    implements android.content.OnClickListener, <init>
{

    final SpinnerCompat a;
    private AlertDialog b;
    private ListAdapter c;
    private CharSequence d;

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
        android.app.der der = new android.app.der(a.getContext());
        if (d != null)
        {
            der.setTitle(d);
        }
        b = der.setSingleChoiceItems(c, a.getSelectedItemPosition(), this).create();
        b.show();
    }

    public void onClick(DialogInterface dialoginterface, int i)
    {
        a.setSelection(i);
        if (a.s != null)
        {
            a.a(null, i, c.getItemId(i));
        }
        a();
    }

    private (SpinnerCompat spinnercompat)
    {
        a = spinnercompat;
        super();
    }

    a(SpinnerCompat spinnercompat, a a1)
    {
        this(spinnercompat);
    }
}

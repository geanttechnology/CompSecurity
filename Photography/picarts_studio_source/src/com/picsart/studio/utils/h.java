// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.utils;

import android.app.DialogFragment;
import android.content.Context;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import com.socialin.android.dialog.c;
import com.socialin.android.util.n;

public final class h
    implements c
{

    private n a;
    private n b;
    private int c;

    public h(n n1, n n2, int i)
    {
        a = n1;
        b = n2;
        c = i;
    }

    public final void onViewCreated(View view, DialogFragment dialogfragment)
    {
        dialogfragment = (RadioButton)view.findViewById(0x7f100373);
        dialogfragment.setText(view.getContext().getString(0x7f080392, new Object[] {
            Integer.valueOf(a.a), Integer.valueOf(a.b)
        }));
        RadioButton radiobutton = (RadioButton)view.findViewById(0x7f100374);
        radiobutton.setText(view.getContext().getString(0x7f080393, new Object[] {
            Integer.valueOf(b.a), Integer.valueOf(b.b)
        }));
        ((CheckBox)view.findViewById(0x7f100376)).setChecked(true);
        if (c == b.c)
        {
            radiobutton.setChecked(true);
            return;
        } else
        {
            dialogfragment.setChecked(true);
            return;
        }
    }
}

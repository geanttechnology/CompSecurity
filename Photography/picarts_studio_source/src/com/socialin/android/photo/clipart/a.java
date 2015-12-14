// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.clipart;

import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.picsart.effects.view.BrushStyleView;
import com.picsart.studio.editor.item.BrushEditableItem;
import com.socialin.android.dialog.c;
import com.socialin.android.util.Utils;

public final class a extends com.socialin.android.dialog.a
    implements c
{

    public static final int b[] = {
        60, 48, 36, 24, 8
    };
    final int a[] = {
        0x7f1001d7, 0x7f1001d9, 0x7f1001db, 0x7f1001dd, 0x7f1001df
    };
    private int c[] = {
        0x7f1001d8, 0x7f1001da, 0x7f1001dc, 0x7f1001de, 0x7f1001e0
    };
    private BrushEditableItem g;

    public a()
    {
    }

    private a(String s, int i, String s1, int j, boolean flag, boolean flag1, android.view.View.OnClickListener onclicklistener, 
            android.view.View.OnClickListener onclicklistener1, android.content.DialogInterface.OnCancelListener oncancellistener, int k, int l, c c1, String s2, String s3)
    {
        super(s, i, s1, j, flag, flag1, onclicklistener, onclicklistener1, oncancellistener, k, l, c1, s2, s3, true);
        a(this);
    }

    public a(String s, int i, String s1, int j, boolean flag, boolean flag1, android.view.View.OnClickListener onclicklistener, 
            android.view.View.OnClickListener onclicklistener1, android.content.DialogInterface.OnCancelListener oncancellistener, int k, int l, c c1, String s2, String s3, 
            byte byte0)
    {
        this(s, i, s1, j, flag, flag1, onclicklistener, onclicklistener1, oncancellistener, k, l, c1, s2, s3);
    }

    static int a(int i)
    {
        if (i < 5)
        {
            return b[i];
        } else
        {
            return b[4];
        }
    }

    static BrushEditableItem a(a a1)
    {
        return a1.g;
    }

    private void a(View view, int i, int j)
    {
        int ai[] = c;
        for (i = 0; i < 5; i++)
        {
            BrushStyleView brushstyleview = (BrushStyleView)view.findViewById(ai[i]);
            brushstyleview.setParams(255, 100 - j);
            brushstyleview.setBmpTag(d);
        }

    }

    static void a(a a1, View view, int i)
    {
        a1.a(view, 255, i);
    }

    public static void a(a a1, BrushEditableItem brusheditableitem)
    {
        a1.g = brusheditableitem;
    }

    public final void onDestroyView()
    {
        Dialog dialog = getDialog();
        if (dialog != null && getRetainInstance())
        {
            dialog.setDismissMessage(null);
        }
        super.onDestroyView();
    }

    public final void onViewCreated(View view, DialogFragment dialogfragment)
    {
        int i;
        boolean flag;
        int j;
        flag = false;
        dialogfragment = a;
        j = (int)Utils.b(g.g, getActivity().getApplicationContext());
        i = 0;
_L7:
        if (i >= 5) goto _L2; else goto _L1
_L1:
        if (b[i] != j) goto _L4; else goto _L3
_L3:
        view.findViewById(dialogfragment[i]).setBackgroundResource(0x7f0205a1);
        a(view, 255, (int)g.f);
        dialogfragment = new android.view.View.OnClickListener(view) {

            private View a;
            private a b;

            public final void onClick(View view1)
            {
                int ai[] = b.a;
                for (int k = 0; k < 5; k++)
                {
                    int l = ai[k];
                    a.findViewById(l).setBackgroundResource(0x7f0f0038);
                }

                a.a(b).g = Utils.a(a.a(((Integer)view1.getTag()).intValue()), b.getActivity().getApplicationContext());
                view1.setBackgroundResource(0x7f0205a1);
            }

            
            {
                b = a.this;
                a = view;
                super();
            }
        };
        for (i = ((flag) ? 1 : 0); i < 5; i++)
        {
            FrameLayout framelayout = (FrameLayout)view.findViewById(a[i]);
            framelayout.setTag(Integer.valueOf(i));
            framelayout.setOnClickListener(dialogfragment);
        }

        break; /* Loop/switch isn't completed */
_L4:
        i++;
        continue; /* Loop/switch isn't completed */
_L2:
        i = 0;
        if (true) goto _L3; else goto _L5
_L5:
        dialogfragment = view.findViewById(0x7f1001e2);
        if (dialogfragment != null)
        {
            dialogfragment.setVisibility(8);
        }
        dialogfragment = view.findViewById(0x7f1001e1);
        if (dialogfragment != null)
        {
            dialogfragment.setVisibility(8);
        }
        dialogfragment = (SeekBar)view.findViewById(0x7f1001e4);
        dialogfragment.setMax(100);
        dialogfragment.setProgress((int)g.f);
        ((TextView)view.findViewById(0x7f1001e3)).setText((new StringBuilder()).append(getString(0x7f080068)).append(" ").append((int)g.f).toString());
        dialogfragment.setOnSeekBarChangeListener(new android.widget.SeekBar.OnSeekBarChangeListener(view) {

            private View a;
            private a b;

            public final void onProgressChanged(SeekBar seekbar, int k, boolean flag1)
            {
                k = seekbar.getProgress();
                a.a(b).f = k;
                ((TextView)a.findViewById(0x7f1001e3)).setText((new StringBuilder()).append(b.getString(0x7f080068)).append(" ").append(k).toString());
                a.a(b, a, k);
            }

            public final void onStartTrackingTouch(SeekBar seekbar)
            {
            }

            public final void onStopTrackingTouch(SeekBar seekbar)
            {
                a.a(b).f = seekbar.getProgress();
            }

            
            {
                b = a.this;
                a = view;
                super();
            }
        });
        return;
        if (true) goto _L7; else goto _L6
_L6:
    }

}

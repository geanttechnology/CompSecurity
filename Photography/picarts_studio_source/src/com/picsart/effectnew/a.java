// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.effectnew;

import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.picsart.effects.view.BrushStyleView;
import com.socialin.android.dialog.c;

// Referenced classes of package com.picsart.effectnew:
//            b, d

public final class a extends com.socialin.android.dialog.a
    implements c
{

    final int a[] = {
        0x7f1001d7, 0x7f1001d9, 0x7f1001db, 0x7f1001dd, 0x7f1001df
    };
    public b b;
    d c;
    private int g[] = {
        0x7f1001d8, 0x7f1001da, 0x7f1001dc, 0x7f1001de, 0x7f1001e0
    };

    public a()
    {
    }

    private a(String s, int i, String s1, int j, boolean flag, boolean flag1, android.view.View.OnClickListener onclicklistener, 
            android.view.View.OnClickListener onclicklistener1, android.content.DialogInterface.OnCancelListener oncancellistener, int k, int l, c c1, String s2, String s3)
    {
        super(s, i, s1, j, flag, flag1, onclicklistener, onclicklistener1, oncancellistener, k, l, c1, s2, s3, true);
        a(this);
    }

    a(String s, int i, String s1, int j, boolean flag, boolean flag1, android.view.View.OnClickListener onclicklistener, 
            android.view.View.OnClickListener onclicklistener1, android.content.DialogInterface.OnCancelListener oncancellistener, int k, int l, c c1, String s2, String s3, 
            byte byte0)
    {
        this(s, i, s1, j, flag, flag1, onclicklistener, onclicklistener1, oncancellistener, k, l, c1, s2, s3);
    }

    static b a(a a1)
    {
        return a1.b;
    }

    private void a(View view, int i, int j)
    {
        for (int k = 0; k < 5; k++)
        {
            BrushStyleView brushstyleview = (BrushStyleView)view.findViewById(g[k]);
            brushstyleview.setParams(i, j);
            brushstyleview.setBmpTag(d);
        }

    }

    static void a(a a1, View view, int i, int j)
    {
        a1.a(view, i, j);
    }

    static d b(a a1)
    {
        return a1.c;
    }

    public final void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        if (b == null)
        {
            dismiss();
        }
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
        int i = b.a;
        int k = b.b;
        float f = b.c;
        ((FrameLayout)view.findViewById(a[i])).setBackgroundResource(0x7f0205a1);
        a(view, k, 100 - (int)f);
        dialogfragment = new android.view.View.OnClickListener(view) {

            private View a;
            private a b;

            public final void onClick(View view1)
            {
                a.a(b).a = ((Integer)view1.getTag()).intValue();
                if (a.b(b) != null)
                {
                    a.b(b).a(a.a(b));
                }
                int ai[] = b.a;
                for (int l = 0; l < 5; l++)
                {
                    int i1 = ai[l];
                    ((FrameLayout)a.findViewById(i1)).setBackgroundResource(0x7f0201f8);
                }

                ((FrameLayout)view1).setBackgroundResource(0x7f0205a1);
            }

            
            {
                b = a.this;
                a = view;
                super();
            }
        };
        for (int j = 0; j < 5; j++)
        {
            FrameLayout framelayout = (FrameLayout)view.findViewById(a[j]);
            framelayout.setTag(Integer.valueOf(j));
            framelayout.setOnClickListener(dialogfragment);
        }

        dialogfragment = (SeekBar)view.findViewById(0x7f1001e2);
        dialogfragment.setMax(255);
        dialogfragment.setProgress(k);
        ((TextView)view.findViewById(0x7f1001e1)).setText((new StringBuilder()).append(getString(0x7f080069)).append(" ").append(k).toString());
        dialogfragment.setOnSeekBarChangeListener(new android.widget.SeekBar.OnSeekBarChangeListener(view) {

            private View a;
            private a b;

            public final void onProgressChanged(SeekBar seekbar, int l, boolean flag)
            {
                l = seekbar.getProgress();
                ((TextView)a.findViewById(0x7f1001e1)).setText((new StringBuilder()).append(b.getString(0x7f080069)).append(" ").append(l).toString());
                a.a(b, a, l, (int)(100F - a.a(b).c));
            }

            public final void onStartTrackingTouch(SeekBar seekbar)
            {
            }

            public final void onStopTrackingTouch(SeekBar seekbar)
            {
                a.a(b).b = seekbar.getProgress();
            }

            
            {
                b = a.this;
                a = view;
                super();
            }
        });
        dialogfragment = (SeekBar)view.findViewById(0x7f1001e4);
        dialogfragment.setMax(100);
        dialogfragment.setProgress((int)f);
        ((TextView)view.findViewById(0x7f1001e3)).setText((new StringBuilder()).append(getString(0x7f080068)).append(" ").append((int)f).toString());
        dialogfragment.setOnSeekBarChangeListener(new android.widget.SeekBar.OnSeekBarChangeListener(view) {

            private View a;
            private a b;

            public final void onProgressChanged(SeekBar seekbar, int l, boolean flag)
            {
                l = seekbar.getProgress();
                ((TextView)a.findViewById(0x7f1001e3)).setText((new StringBuilder()).append(b.getString(0x7f080068)).append(" ").append(l).toString());
                a.a(b, a, a.a(b).b, 100 - l);
            }

            public final void onStartTrackingTouch(SeekBar seekbar)
            {
            }

            public final void onStopTrackingTouch(SeekBar seekbar)
            {
                a.a(b).c = seekbar.getProgress();
            }

            
            {
                b = a.this;
                a = view;
                super();
            }
        });
    }
}

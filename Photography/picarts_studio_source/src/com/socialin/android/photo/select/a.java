// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.select;

import android.app.Activity;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Paint;
import android.util.SparseArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import com.socialin.android.apiv3.util.Inventory;
import com.socialin.android.photo.picsinphoto.f;
import com.socialin.android.util.d;
import java.util.ArrayList;
import java.util.List;
import myobfuscated.f.m;

// Referenced classes of package com.socialin.android.photo.select:
//            b, c

public final class a
{

    public b a;
    Spinner b;
    Button c;
    TextView d;
    private SeekBar e;

    public a(Activity activity, b b1, View view)
    {
        b = null;
        a = b1;
        e = (SeekBar)view.findViewById(0x7f1005fe);
        e.setMax(255);
        d = (TextView)view.findViewById(0x7f1005fd);
        e.setOnSeekBarChangeListener(new android.widget.SeekBar.OnSeekBarChangeListener() {

            private a a;

            public final void onProgressChanged(SeekBar seekbar, int j, boolean flag)
            {
                a.d.setText((new StringBuilder(": ")).append(j).toString());
                if (a.a != null)
                {
                    seekbar = a.a.f();
                    if (seekbar != null)
                    {
                        seekbar.H = j;
                        ((c) (seekbar)).p.setAlpha(j);
                        seekbar = a.a.g();
                        if (seekbar != null)
                        {
                            seekbar.invalidate();
                        }
                    }
                }
            }

            public final void onStartTrackingTouch(SeekBar seekbar)
            {
            }

            public final void onStopTrackingTouch(SeekBar seekbar)
            {
            }

            
            {
                a = a.this;
                super();
            }
        });
        a(activity, view);
        a();
        if (activity.getResources().getConfiguration().orientation == 2)
        {
            int i = (int)activity.getResources().getDimension(0x7f0b0105);
            if (Inventory.isAdsEnabled())
            {
                activity = (LinearLayout)view.findViewById(0x7f1005fb);
                b1 = (android.widget.RelativeLayout.LayoutParams)activity.getLayoutParams();
                b1.setMargins(0, 0, 0, i);
                activity.setLayoutParams(b1);
            }
        }
    }

    private void a(Activity activity, View view)
    {
        List list = m.h();
        ArrayList arraylist = new ArrayList();
        for (int i = 0; i < list.size(); i++)
        {
            arraylist.add(d.a.get(((Integer)list.get(i)).intValue()));
        }

        c = (Button)view.findViewById(0x7f100601);
        activity = new f(activity, arraylist);
        activity.setDropDownViewResource(0x7f03024f);
        b = (Spinner)view.findViewById(0x7f100600);
        b.setAdapter(activity);
        b.setOnItemSelectedListener(new android.widget.AdapterView.OnItemSelectedListener(arraylist, list) {

            private ArrayList a;
            private List b;
            private a c;

            public final void onItemSelected(AdapterView adapterview, View view1, int j, long l)
            {
                c.c.setText((CharSequence)a.get(j));
                if (c.a != null)
                {
                    adapterview = c.a.f();
                    if (adapterview != null)
                    {
                        j = ((Integer)b.get(j)).intValue();
                        adapterview.G = j;
                        view1 = com.socialin.android.util.d.a(j);
                        ((c) (adapterview)).p.setXfermode(view1);
                        adapterview = c.a.g();
                        if (adapterview != null)
                        {
                            adapterview.invalidate();
                        }
                    }
                }
            }

            public final void onNothingSelected(AdapterView adapterview)
            {
            }

            
            {
                c = a.this;
                a = arraylist;
                b = list;
                super();
            }
        });
        c.setOnClickListener(new android.view.View.OnClickListener() {

            private a a;

            public final void onClick(View view1)
            {
                a.b.performClick();
            }

            
            {
                a = a.this;
                super();
            }
        });
    }

    public final void a()
    {
        if (a == null) goto _L2; else goto _L1
_L1:
        c c1 = a.f();
        if (c1 == null) goto _L2; else goto _L3
_L3:
        int i;
        int j;
        j = c1.H;
        i = c1.G;
_L5:
        if (b != null)
        {
            b.setSelection(0);
        }
        if (c != null)
        {
            c.setText((CharSequence)d.a.get(i));
        }
        if (e != null)
        {
            e.setProgress(j);
        }
        if (d != null)
        {
            d.setText((new StringBuilder(": ")).append(j).toString());
        }
        return;
_L2:
        i = -1;
        j = 255;
        if (true) goto _L5; else goto _L4
_L4:
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.utility;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.model.CircleType;
import com.cyberlink.beautycircle.view.widgetpool.common.ObservableHorizontalScrollView;
import com.cyberlink.beautycircle.view.widgetpool.common.UICImageView;
import com.perfectcorp.utility.e;
import com.perfectcorp.utility.j;
import com.perfectcorp.utility.m;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.cyberlink.beautycircle.utility:
//            e

public class d
{

    private Context a;
    private ArrayList b;
    private android.view.View.OnClickListener c;
    private ObservableHorizontalScrollView d;
    private LinearLayout e;
    private boolean f;

    public d(Context context, ObservableHorizontalScrollView observablehorizontalscrollview, android.view.View.OnClickListener onclicklistener)
    {
        f = false;
        a = context;
        d = observablehorizontalscrollview;
        c = onclicklistener;
    }

    static void a(d d1, ArrayList arraylist)
    {
        d1.a(arraylist);
    }

    private void a(ArrayList arraylist)
    {
        if (d == null || c == null || arraylist.size() < 0)
        {
            return;
        }
        if (b == null)
        {
            b = new ArrayList();
        }
        b = arraylist;
        if (e == null)
        {
            e = new LinearLayout(a);
            e.setOrientation(0);
        }
        int j1 = b.size();
        int i = e.getChildCount();
        int k1 = j1 - i;
        if (i > 0)
        {
            int k;
            int i1;
            if (i < j1)
            {
                k = i;
            } else
            {
                k = j1;
            }
            for (i1 = 0; i1 < k; i1++)
            {
                arraylist = (com.cyberlink.beautycircle.utility.e)e.getChildAt(i1);
                com.cyberlink.beautycircle.utility.e.a(arraylist, (CircleType)b.get(i1));
                com.cyberlink.beautycircle.utility.e.a(arraylist).setImageURI(((CircleType)b.get(i1)).iconUrl);
                com.cyberlink.beautycircle.utility.e.b(arraylist).setText(((CircleType)b.get(i1)).circleTypeName);
            }

        }
        if (k1 < 0)
        {
            for (; i > j1; i--)
            {
                e.removeViewAt(i - 1);
            }

        } else
        {
            for (int l = 0; l < k1; l++)
            {
                arraylist = new com.cyberlink.beautycircle.utility.e(this, a);
                arraylist.setOnClickListener(c);
                arraylist = arraylist.a((CircleType)b.get(i + l));
                e.addView(arraylist);
            }

        }
        d.removeAllViews();
        d.addView(e);
    }

    private void b(ArrayList arraylist)
    {
        CircleType.b().a(new m(arraylist) {

            final ArrayList a;
            final d b;

            protected void a()
            {
                Globals.a("listAllCircles cancelled");
                a(0x80000005);
            }

            protected void a(int i)
            {
                Globals.a("Network error");
                com.perfectcorp.utility.e.e(new Object[] {
                    Integer.valueOf(i)
                });
            }

            protected void a(com.cyberlink.beautycircle.model.network.d d1)
            {
                if (d1 == null || d1.b == null || d1.b.isEmpty())
                {
                    a(0x80000003);
                    return;
                }
                CircleType circletype;
                for (d1 = d1.b.iterator(); d1.hasNext(); a.add(circletype))
                {
                    circletype = (CircleType)d1.next();
                }

                d.a(b, a);
            }

            protected void b(Object obj)
            {
                a((com.cyberlink.beautycircle.model.network.d)obj);
            }

            
            {
                b = d.this;
                a = arraylist;
                super();
            }
        });
    }

    public void a()
    {
        if (!f)
        {
            f = true;
            b();
        }
    }

    public void b()
    {
        b(new ArrayList());
    }
}

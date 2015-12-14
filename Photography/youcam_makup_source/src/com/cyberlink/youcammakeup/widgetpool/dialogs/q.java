// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.dialogs;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.view.View;
import android.widget.ImageView;
import w.a.a;
import w.panzoomview.PanZoomView;
import w.panzoomview.o;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.dialogs:
//            s, r, t, u

public class q extends a
{

    private PanZoomView a;
    private Bitmap b;
    private s c;
    private ImageView d;
    private ImageView e;
    private View f;
    private Context g;
    private r h;
    private android.view.View.OnClickListener i;
    private android.view.View.OnClickListener j;
    private android.view.View.OnClickListener k;

    public q(Context context, boolean flag)
    {
        super(context, flag);
        i = new android.view.View.OnClickListener() {

            final q a;

            public void onClick(View view)
            {
                com.cyberlink.youcammakeup.widgetpool.dialogs.q.a(a).a();
            }

            
            {
                a = q.this;
                super();
            }
        };
        j = new android.view.View.OnClickListener() {

            final q a;

            public void onClick(View view)
            {
                view = new PointF[3];
                for (int l = 0; l < 3; l++)
                {
                    view[l] = new PointF(q.b(a).d[l].a, q.b(a).d[l].b);
                }

                com.cyberlink.youcammakeup.widgetpool.dialogs.q.a(a).a(view);
            }

            
            {
                a = q.this;
                super();
            }
        };
        k = new android.view.View.OnClickListener() {

            final q a;

            public void onClick(View view)
            {
                (new u(q.c(a), true)).show();
            }

            
            {
                a = q.this;
                super();
            }
        };
        g = context;
    }

    static r a(q q1)
    {
        return q1.h;
    }

    static s b(q q1)
    {
        return q1.c;
    }

    static Context c(q q1)
    {
        return q1.g;
    }

    protected int a()
    {
        return 0x7f030153;
    }

    public void a(Bitmap bitmap)
    {
        b = bitmap;
    }

    protected void a(View view)
    {
        e = (ImageView)view.findViewById(0x7f0c0616);
        d = (ImageView)view.findViewById(0x7f0c0618);
        f = view.findViewById(0x7f0c0613);
        a = (PanZoomView)view.findViewById(0x7f0c0612);
        a.setDrawingImage(b);
        c = new s(b.getWidth(), b.getHeight());
        view = (new o()).a(c).a(c).a();
        a.a(view);
        d.setOnClickListener(j);
        e.setOnClickListener(i);
        f.setOnClickListener(k);
    }

    public void a(r r)
    {
        h = r;
    }
}

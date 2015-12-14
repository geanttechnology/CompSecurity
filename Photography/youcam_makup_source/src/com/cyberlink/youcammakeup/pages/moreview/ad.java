// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.pages.moreview;

import android.graphics.BitmapFactory;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

// Referenced classes of package com.cyberlink.youcammakeup.pages.moreview:
//            ae

public class ad
{

    private ImageView a;
    private ImageView b;
    private TextView c;
    private long d;
    private boolean e;
    private boolean f;
    private Collection g;
    private android.view.View.OnClickListener h;

    public ad(RelativeLayout relativelayout)
    {
        h = new android.view.View.OnClickListener() {

            final ad a;

            public void onClick(View view)
            {
                if (ad.a(a) != null && ad.a(a).size() > 0)
                {
                    for (view = ad.a(a).iterator(); view.hasNext(); ((ae)view.next()).a(a)) { }
                }
            }

            
            {
                a = ad.this;
                super();
            }
        };
        a(relativelayout);
    }

    static Collection a(ad ad1)
    {
        return ad1.g;
    }

    private void a(RelativeLayout relativelayout)
    {
        a = (ImageView)relativelayout.findViewById(0x7f0c060f);
        b = (ImageView)relativelayout.findViewById(0x7f0c0611);
        c = (TextView)relativelayout.findViewById(0x7f0c0610);
        a.setOnClickListener(h);
        d = -1L;
        g = new ArrayList();
    }

    public void a()
    {
        f = false;
        a.setBackgroundColor(0);
    }

    public void a(int i)
    {
        c.setTextColor(i);
    }

    public void a(long l)
    {
        d = l;
    }

    public void a(ae ae)
    {
        if (g != null && !g.contains(ae))
        {
            g.add(ae);
        }
    }

    public void a(String s)
    {
        a.setBackgroundColor(0);
        s = BitmapFactory.decodeFile(s);
        if (s != null)
        {
            f = true;
            a.setImageBitmap(s);
            a(e);
        }
    }

    public void a(boolean flag)
    {
        e = flag;
        if (f)
        {
            int i;
            if (flag)
            {
                i = 0;
            } else
            {
                i = 4;
            }
            b.setVisibility(i);
        }
    }

    public long b()
    {
        return d;
    }

    public void b(String s)
    {
        if (s != null)
        {
            c.setText(s);
        }
    }
}

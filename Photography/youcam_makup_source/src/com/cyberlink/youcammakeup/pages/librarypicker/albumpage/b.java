// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.pages.librarypicker.albumpage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.cyberlink.youcammakeup.pages.librarypicker.ItemView;

// Referenced classes of package com.cyberlink.youcammakeup.pages.librarypicker.albumpage:
//            a

public class b extends ItemView
{

    protected final TextView e;
    protected final TextView f;
    protected a g;
    private View h;

    public b(Context context, a a1)
    {
        super(context);
        g = a1;
        context = ((LayoutInflater)c.getSystemService("layout_inflater")).inflate(0x7f0301da, this);
        d = (ImageView)context.findViewById(0x7f0c020a);
        e = (TextView)context.findViewById(0x7f0c020b);
        f = (TextView)context.findViewById(0x7f0c085d);
        h = context.findViewById(0x7f0c085e);
        b();
    }

    private void b()
    {
        String s = g.f();
        int i = g.g();
        Object obj = new StringBuilder();
        if (i > 0x10000)
        {
            ((StringBuilder) (obj)).append(0x10000);
            ((StringBuilder) (obj)).append("+");
        } else
        {
            ((StringBuilder) (obj)).append(i);
        }
        obj = ((StringBuilder) (obj)).toString();
        e.setText(s);
        f.setText(((CharSequence) (obj)));
    }

    public void a(a a1)
    {
        a();
        g = a1;
        b();
    }

    public a getItem()
    {
        return g;
    }

    public volatile com.cyberlink.youcammakeup.pages.librarypicker.b getItem()
    {
        return getItem();
    }

    public void setDividerVisibility(int i)
    {
        h.setVisibility(i);
    }
}

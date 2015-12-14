// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.pages.librarypicker.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import com.cyberlink.youcammakeup.pages.librarypicker.ItemView;

// Referenced classes of package com.cyberlink.youcammakeup.pages.librarypicker.a:
//            a

public class b extends ItemView
{

    final a e;
    protected final ImageView f;

    public b(Context context, a a)
    {
        super(context);
        e = a;
        context = ((LayoutInflater)c.getSystemService("layout_inflater")).inflate(0x7f030200, this);
        d = (ImageView)context.findViewById(0x7f0c08d3);
        f = (ImageView)context.findViewById(0x7f0c08d5);
    }

    public a getItem()
    {
        return e;
    }

    public volatile com.cyberlink.youcammakeup.pages.librarypicker.b getItem()
    {
        return getItem();
    }

    protected void onMeasure(int i, int j)
    {
        i = android.view.View.MeasureSpec.makeMeasureSpec(android.view.View.MeasureSpec.getSize(j), 0x40000000);
        super.onMeasure(i, i);
    }

    public void setOnCloseListener(android.view.View.OnClickListener onclicklistener)
    {
        f.setOnClickListener(onclicklistener);
    }
}

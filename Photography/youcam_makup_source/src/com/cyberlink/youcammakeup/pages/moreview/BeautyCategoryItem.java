// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.pages.moreview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

// Referenced classes of package com.cyberlink.youcammakeup.pages.moreview:
//            k, c

public class BeautyCategoryItem extends RelativeLayout
{

    private ImageView a;
    private ImageView b;
    private TextView c;
    private int d;
    private int e;
    private float f;
    private long g;
    private Rect h;
    private boolean i;
    private boolean j;
    private Collection k;
    private android.view.View.OnClickListener l = new android.view.View.OnClickListener() {

        final BeautyCategoryItem a;

        public void onClick(View view)
        {
            if (BeautyCategoryItem.a(a) != null && BeautyCategoryItem.a(a).size() > 0)
            {
                for (view = BeautyCategoryItem.a(a).iterator(); view.hasNext(); ((c)view.next()).a(a)) { }
            }
        }

            
            {
                a = BeautyCategoryItem.this;
                super();
            }
    };

    public BeautyCategoryItem(Context context)
    {
        super(context);
        a(context);
    }

    public BeautyCategoryItem(Context context, AttributeSet attributeset, int i1)
    {
        super(context, attributeset, i1);
        a(context);
    }

    static Collection a(BeautyCategoryItem beautycategoryitem)
    {
        return beautycategoryitem.k;
    }

    private void a(Context context)
    {
        context = ((LayoutInflater)context.getSystemService("layout_inflater")).inflate(0x7f0301db, this);
        a = (ImageView)context.findViewById(0x7f0c085f);
        b = (ImageView)context.findViewById(0x7f0c0861);
        c = (TextView)context.findViewById(0x7f0c0860);
        a.setOnClickListener(l);
        context = BitmapFactory.decodeResource(getResources(), 0x7f020758);
        d = context.getWidth();
        e = context.getHeight();
        g = -1L;
        h = null;
        k = new ArrayList();
    }

    public k a(k k1, k k2, float f1)
    {
        if (k1 == null)
        {
            return null;
        }
        f = f1;
        k k3 = new k();
        f1 = d;
        float f2 = e;
        k3.a = k1.a;
        k3.b = k1.b - f2 / 5F;
        float f3 = k1.c;
        k3.c = f1 / 5F + f3;
        k3.d = k1.d + f2 / 5F;
        h = new Rect();
        if (k2 != null)
        {
            h.left = (int)(k2.a - k3.a);
            h.top = (int)(k2.b - k3.b);
            h.right = (int)((float)h.left + k2.c);
            h.bottom = (int)((float)h.top + k2.d);
            return k3;
        } else
        {
            h.left = 0;
            h.top = (int)(f2 / 5F);
            h.right = (int)k1.c;
            h.bottom = (int)(k1.d / 2.0F);
            return k3;
        }
    }

    public void a()
    {
        j = false;
        a.setBackgroundColor(0);
    }

    public void a(int i1, float f1, float f2, float f3)
    {
        c.setShadowLayer(f3, f1, f2, i1);
    }

    public void a(boolean flag)
    {
        i = flag;
        if (j)
        {
            int i1;
            if (flag)
            {
                i1 = 0;
            } else
            {
                i1 = 4;
            }
            b.setVisibility(i1);
        }
    }

    public long getCategoryItemId()
    {
        return g;
    }

    protected void onLayout(boolean flag, int i1, int j1, int k1, int l1)
    {
        super.onLayout(flag, i1, j1, k1, l1);
        int j2 = k1 - i1;
        k1 = (int)((float)d * f);
        int i2 = (int)((float)e * f);
        if (k1 < i2)
        {
            i1 = k1;
        } else
        {
            i1 = i2;
        }
        a.layout(0, i1 / 5, j2 - i1 / 5, l1 - j1);
        if (h != null)
        {
            c.layout(h.left, h.top, h.right, h.bottom);
        }
        i1 = (int)((double)k1 * 0.40000000000000002D);
        j1 = (int)((double)i2 * 0.40000000000000002D);
        b.layout(j2 - k1 - i1, j1, j2 - i1, i2 + j1);
    }

    protected void onMeasure(int i1, int j1)
    {
        super.onMeasure(i1, j1);
        int l1 = android.view.View.MeasureSpec.getSize(i1);
        int i2 = android.view.View.MeasureSpec.getSize(j1);
        int k1 = (int)((float)d * f);
        j1 = (int)((float)e * f);
        if (k1 < j1)
        {
            i1 = k1;
        } else
        {
            i1 = j1;
        }
        l1 = android.view.View.MeasureSpec.makeMeasureSpec(l1 - i1 / 5, 0x40000000);
        i1 = android.view.View.MeasureSpec.makeMeasureSpec(i2 - i1 / 5, 0x40000000);
        a.measure(l1, i1);
        i1 = android.view.View.MeasureSpec.makeMeasureSpec(k1, 0x40000000);
        j1 = android.view.View.MeasureSpec.makeMeasureSpec(j1, 0x40000000);
        b.measure(i1, j1);
        i1 = android.view.View.MeasureSpec.makeMeasureSpec(h.right - h.left, 0x40000000);
        j1 = android.view.View.MeasureSpec.makeMeasureSpec(h.bottom - h.top, 0x40000000);
        c.measure(i1, j1);
    }

    public void setCategoryItemId(long l1)
    {
        g = l1;
    }

    public void setCategoryName(String s)
    {
        if (s != null)
        {
            c.setText(s);
        }
    }

    public void setTextAlign(int i1)
    {
        c.setGravity(i1);
    }

    public void setTextColor(int i1)
    {
        c.setTextColor(i1);
    }

    public void setThumbnail(int i1)
    {
        j = true;
        a.setImageResource(i1);
        a(i);
    }

    public void setThumbnail(String s)
    {
        a.setBackgroundColor(0);
        s = BitmapFactory.decodeFile(s);
        if (s != null)
        {
            j = true;
            a.setImageBitmap(s);
            a(i);
        }
    }

    public void setmThumbClickListener(c c1)
    {
        if (k != null && !k.contains(c1))
        {
            k.add(c1);
        }
    }
}

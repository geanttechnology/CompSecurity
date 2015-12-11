// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.smule.android.network.models.ListingV2;
import com.smule.android.network.models.SongV2;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            al, am

public class ProductListItem extends LinearLayout
{

    static final boolean a;
    private ListingV2 b;
    private SongV2 c;
    private TextView d;
    private TextView e;
    private ImageView f;
    private ImageView g;
    private ImageView h;
    private ImageView i;
    private ImageView j;
    private am k;

    public ProductListItem(Context context)
    {
        super(context);
        d = null;
    }

    public ProductListItem(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        d = null;
    }

    static am a(ProductListItem productlistitem)
    {
        return productlistitem.k;
    }

    private void a()
    {
        d = (TextView)findViewById(0x7f0a00c0);
        e = (TextView)findViewById(0x7f0a00c1);
        f = (ImageView)findViewById(0x7f0a01d9);
        h = (ImageView)findViewById(0x7f0a01db);
        i = (ImageView)findViewById(0x7f0a01dc);
        j = (ImageView)findViewById(0x7f0a01dd);
        g = (ImageView)findViewById(0x7f0a01d8);
        g.setOnClickListener(new android.view.View.OnClickListener() {

            final ProductListItem a;

            public void onClick(View view)
            {
                if (ProductListItem.a(a) != null)
                {
                    ProductListItem.a(a).b(ProductListItem.b(a));
                }
            }

            
            {
                a = ProductListItem.this;
                super();
            }
        });
    }

    static ListingV2 b(ProductListItem productlistitem)
    {
        return productlistitem.b;
    }

    static SongV2 c(ProductListItem productlistitem)
    {
        return productlistitem.c;
    }

    static ImageView d(ProductListItem productlistitem)
    {
        return productlistitem.h;
    }

    static ImageView e(ProductListItem productlistitem)
    {
        return productlistitem.i;
    }

    static ImageView f(ProductListItem productlistitem)
    {
        return productlistitem.j;
    }

    public ListingV2 getListing()
    {
        return b;
    }

    public SongV2 getSong()
    {
        return c;
    }

    public void setPreviewListener(am am)
    {
        k = am;
    }

    public void setProduct(ListingV2 listingv2)
    {
        c = listingv2.song;
        b = listingv2;
        if (d == null)
        {
            a();
            if (!a && d == null)
            {
                throw new AssertionError();
            }
        }
        boolean flag = listingv2.b();
        d.setText(c.title);
        TextView textview = e;
        int l;
        if (c.artist != null)
        {
            listingv2 = c.artist;
        } else
        {
            listingv2 = "";
        }
        textview.setText(listingv2);
        listingv2 = f;
        if (b != null && flag)
        {
            l = 0;
        } else
        {
            l = 4;
        }
        listingv2.setVisibility(l);
        listingv2 = ((ListingV2) (getTag()));
        if (listingv2 != null && (listingv2 instanceof al))
        {
            listingv2 = (al)listingv2;
            if (((al) (listingv2)).d.equals(c.songId))
            {
                return;
            }
            listingv2.cancel(true);
        }
        listingv2 = new al(this);
        listingv2.execute(new Void[] {
            null, null, null
        });
        setTag(listingv2);
    }

    static 
    {
        boolean flag;
        if (!com/smule/pianoandroid/magicpiano/ProductListItem.desiredAssertionStatus())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        a = flag;
    }
}

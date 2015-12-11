// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.crittercism.app.Crittercism;
import com.smule.android.network.managers.i;
import com.smule.android.network.models.ListingV2;
import com.smule.android.network.models.SongV2;
import com.smule.pianoandroid.e.c;
import com.smule.pianoandroid.e.e;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            t

public class ListingListItem extends LinearLayout
{

    static final boolean a;
    private ListingV2 b;
    private TextView c;
    private TextView d;
    private TextView e;
    private TextView f;
    private ImageView g;
    private ImageView h;
    private TextView i;
    private ImageView j;
    private ImageView k;
    private View l;
    private t m;

    public ListingListItem(Context context)
    {
        super(context);
        c = null;
    }

    public ListingListItem(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        c = null;
    }

    static t a(ListingListItem listinglistitem)
    {
        return listinglistitem.m;
    }

    private void a()
    {
        c = (TextView)findViewById(0x7f0a00c0);
        f = (TextView)findViewById(0x7f0a01df);
        e = (TextView)findViewById(0x7f0a01e1);
        d = (TextView)findViewById(0x7f0a00c1);
        h = (ImageView)findViewById(0x7f0a01d9);
        i = (TextView)findViewById(0x7f0a01cd);
        j = (ImageView)findViewById(0x7f0a01cc);
        k = (ImageView)findViewById(0x7f0a01ce);
        g = (ImageView)findViewById(0x7f0a01d8);
        l = findViewById(0x7f0a01cb);
        g.setOnClickListener(new android.view.View.OnClickListener() {

            final ListingListItem a;

            public void onClick(View view)
            {
                if (ListingListItem.a(a) != null)
                {
                    ListingListItem.a(a).a(ListingListItem.b(a));
                }
            }

            
            {
                a = ListingListItem.this;
                super();
            }
        });
    }

    static ListingV2 b(ListingListItem listinglistitem)
    {
        return listinglistitem.b;
    }

    public void a(ListingV2 listingv2, Boolean boolean1)
    {
        b = listingv2;
        if (c == null)
        {
            a();
            if (!a && c == null)
            {
                throw new AssertionError();
            }
        }
        boolean flag = listingv2.b();
        Object obj = b.song;
        c.setText(((SongV2) (obj)).title);
        TextView textview = d;
        int i1;
        if (((SongV2) (obj)).artist != null)
        {
            obj = ((SongV2) (obj)).artist;
        } else
        {
            obj = "";
        }
        textview.setText(((CharSequence) (obj)));
        obj = h;
        if (flag)
        {
            i1 = 0;
        } else
        {
            i1 = 4;
        }
        ((ImageView) (obj)).setVisibility(i1);
        j.setImageResource(0x7f020120);
        obj = j;
        if (boolean1.booleanValue() || listingv2.subscriberOnly)
        {
            i1 = 8;
        } else
        {
            i1 = 0;
        }
        ((ImageView) (obj)).setVisibility(i1);
        if (listingv2.isNew)
        {
            e.setVisibility(0);
        } else
        {
            e.setVisibility(8);
        }
        if (listingv2.sale)
        {
            f.setVisibility(0);
        } else
        {
            f.setVisibility(8);
        }
        l.setBackgroundResource(0x7f02005f);
        if (listingv2.subscriberOnly)
        {
            i.setText(0x7f0c01e0);
            k.setVisibility(0);
            return;
        }
        k.setVisibility(8);
        if (boolean1.booleanValue())
        {
            i.setText(0x7f0c01e0);
            return;
        }
        boolean1 = com.smule.pianoandroid.e.c.a().b(listingv2.productId);
        if (boolean1 != null)
        {
            if (boolean1.intValue() <= com.smule.pianoandroid.e.e.a().f())
            {
                Crittercism.a(new Exception((new StringBuilder()).append("user wasn't granted reward for level ").append(boolean1).append("song id ").append(listingv2.productId).append(", but is currently at level ").append(com.smule.pianoandroid.e.e.a().f()).append(", granting now.").toString()));
                com.smule.android.network.managers.i.a().d(listingv2.productId);
                j.setVisibility(8);
                i.setText(getResources().getString(0x7f0c01e0));
                return;
            } else
            {
                l.setBackgroundResource(0x7f020068);
                j.setVisibility(8);
                i.setText(String.format(getResources().getString(0x7f0c0159), new Object[] {
                    boolean1
                }));
                return;
            }
        }
        if (listingv2.isFree || listingv2.price == 0)
        {
            j.setVisibility(8);
            i.setText(getResources().getString(0x7f0c01e0));
            return;
        } else
        {
            i.setText(String.format("%,d", new Object[] {
                Integer.valueOf(listingv2.price)
            }));
            return;
        }
    }

    public ListingV2 getListing()
    {
        return b;
    }

    public void setPreviewListener(t t)
    {
        m = t;
    }

    static 
    {
        boolean flag;
        if (!com/smule/pianoandroid/magicpiano/ListingListItem.desiredAssertionStatus())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        a = flag;
    }
}

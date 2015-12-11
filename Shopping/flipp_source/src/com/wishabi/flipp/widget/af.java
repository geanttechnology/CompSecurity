// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.widget;

import android.content.Context;
import android.content.res.Resources;
import android.text.Spannable;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

// Referenced classes of package com.wishabi.flipp.widget:
//            WebImageView, ActionButton, ag, ah, 
//            ai, aj, ak

public final class af extends FrameLayout
{

    public static final int a[] = {
        0x7f010009
    };
    final RelativeLayout b;
    final LinearLayout c;
    private final WebImageView d;
    private final TextView e;
    private final WebImageView f;
    private final TextView g;
    private final TextView h;
    private final LinearLayout i;
    private final TextView j;
    private final TextView k;
    private final TextView l;
    private final TextView m;
    private final TextView n;
    private final RelativeLayout o;
    private final LinearLayout p;
    private final ActionButton q;
    private final ActionButton r;
    private final TextView s;
    private final LinearLayout t;
    private final TextView u;
    private final TextView v;
    private ak w;
    private boolean x;
    private boolean y;
    private boolean z;

    public af(Context context)
    {
        this(context, (byte)0);
    }

    private af(Context context, byte byte0)
    {
        this(context, '\0');
    }

    private af(Context context, char c1)
    {
        super(context, null, 0);
        View.inflate(getContext(), 0x7f03001d, this);
        d = (WebImageView)findViewById(0x7f0b007a);
        e = (TextView)findViewById(0x7f0b007c);
        e.setSingleLine();
        f = (WebImageView)findViewById(0x7f0b007d);
        g = (TextView)findViewById(0x7f0b007f);
        h = (TextView)findViewById(0x7f0b0080);
        h.setSingleLine();
        i = (LinearLayout)findViewById(0x7f0b0081);
        j = (TextView)findViewById(0x7f0b0082);
        k = (TextView)findViewById(0x7f0b0084);
        l = (TextView)findViewById(0x7f0b0083);
        m = (TextView)findViewById(0x7f0b0085);
        n = (TextView)findViewById(0x7f0b0086);
        o = (RelativeLayout)findViewById(0x7f0b0087);
        p = (LinearLayout)findViewById(0x7f0b008b);
        q = (ActionButton)findViewById(0x7f0b008d);
        r = (ActionButton)findViewById(0x7f0b008e);
        b = (RelativeLayout)findViewById(0x7f0b008f);
        s = (TextView)findViewById(0x7f0b0090);
        c = (LinearLayout)findViewById(0x7f0b0091);
        t = (LinearLayout)findViewById(0x7f0b0092);
        u = (TextView)findViewById(0x7f0b0093);
        v = (TextView)findViewById(0x7f0b0094);
        v.setVisibility(8);
        x = false;
        y = false;
        z = false;
        d();
    }

    static ak a(af af1)
    {
        return af1.w;
    }

    static boolean b(af af1)
    {
        return af1.z;
    }

    private void c()
    {
        if (y)
        {
            v.setText(0x7f0e0017);
            v.setBackgroundColor(getResources().getColor(0x7f090007));
            v.setVisibility(0);
            return;
        }
        if (x)
        {
            v.setText(0x7f0e0013);
            v.setBackgroundColor(getResources().getColor(0x7f090001));
            v.setVisibility(0);
            return;
        } else
        {
            v.setVisibility(8);
            return;
        }
    }

    private void d()
    {
        int i1;
        int j1;
        if (z)
        {
            j1 = 0x7f0200c6;
            i1 = 0x7f0e0138;
            o.setVisibility(8);
            p.setVisibility(8);
        } else
        {
            j1 = 0x7f0200bb;
            i1 = 0x7f0e0104;
            o.setVisibility(0);
            p.setVisibility(0);
        }
        r.setIcon(j1);
        r.setLabel(i1);
    }

    public final void a()
    {
        b.setVisibility(8);
    }

    public final void a(String s1, String s2, String s3)
    {
        byte byte0 = 0;
        int i1;
        if (TextUtils.isEmpty(s1))
        {
            j.setText(null);
            j.setVisibility(8);
            i1 = 0;
        } else
        {
            j.setText(s1);
            j.setVisibility(0);
            i1 = 1;
        }
        if (TextUtils.isEmpty(s2))
        {
            l.setText(null);
            l.setVisibility(8);
        } else
        {
            l.setText(s2);
            l.setVisibility(0);
            i1++;
        }
        if (TextUtils.isEmpty(s3))
        {
            k.setText(null);
            k.setVisibility(8);
        } else
        {
            k.setText(s3);
            k.setVisibility(0);
            i1++;
        }
        s1 = i;
        if (i1 == 0)
        {
            byte0 = 8;
        }
        s1.setVisibility(byte0);
    }

    public final void b()
    {
        int j1 = c.getChildCount();
        for (int i1 = 0; i1 < j1; i1++)
        {
            c.getChildAt(i1).setVisibility(8);
        }

    }

    public final boolean getIsClipped()
    {
        return x;
    }

    protected final int[] onCreateDrawableState(int i1)
    {
        int ai1[] = super.onCreateDrawableState(i1 + 1);
        if (x)
        {
            mergeDrawableStates(ai1, a);
        }
        return ai1;
    }

    public final void setBrandImage(String s1)
    {
        if (TextUtils.isEmpty(s1))
        {
            f.setImageUrl(null);
            f.setVisibility(8);
            e.setVisibility(0);
            return;
        } else
        {
            f.setImageUrl(s1);
            f.setVisibility(0);
            e.setVisibility(8);
            return;
        }
    }

    public final void setBrandName(String s1)
    {
        e.setText(s1);
    }

    public final void setDisclaimer(String s1)
    {
        if (TextUtils.isEmpty(s1))
        {
            u.setText(null);
            u.setVisibility(8);
            return;
        } else
        {
            u.setText(s1);
            u.setVisibility(0);
            return;
        }
    }

    public final void setHasBarcode(boolean flag)
    {
        z = flag;
        d();
    }

    public final void setImage(String s1)
    {
        if (TextUtils.isEmpty(s1))
        {
            d.setImageUrl(null);
            d.setVisibility(8);
            return;
        } else
        {
            d.setImageUrl(s1);
            d.setVisibility(0);
            return;
        }
    }

    public final void setIsClipped(boolean flag)
    {
        x = flag;
        ActionButton actionbutton = q;
        int i1;
        if (x)
        {
            i1 = 0x7f0e0156;
        } else
        {
            i1 = 0x7f0e002c;
        }
        actionbutton.setLabel(i1);
        c();
    }

    public final void setIsSent(boolean flag)
    {
        y = flag;
        c();
    }

    public final void setItemMatchupLabel(String s1)
    {
        s.setText(s1);
    }

    public final void setListener(ak ak)
    {
        w = ak;
        if (w == null)
        {
            q.setOnClickListener(null);
            r.setOnClickListener(null);
            p.setOnClickListener(null);
            t.setOnClickListener(null);
            return;
        } else
        {
            q.setOnClickListener(new ag(this));
            r.setOnClickListener(new ah(this));
            p.setOnClickListener(new ai(this));
            t.setOnClickListener(new aj(this));
            return;
        }
    }

    public final void setMerchant(String s1)
    {
        if (TextUtils.isEmpty(s1))
        {
            g.setVisibility(8);
            h.setVisibility(8);
            return;
        } else
        {
            g.setVisibility(0);
            h.setText(s1);
            h.setVisibility(0);
            return;
        }
    }

    public final void setPromoText(String s1)
    {
        if (TextUtils.isEmpty(s1))
        {
            m.setText(null);
            m.setVisibility(8);
            return;
        } else
        {
            m.setText(s1);
            m.setVisibility(0);
            return;
        }
    }

    public final void setSaleStory(String s1)
    {
        a(s1, null, null);
    }

    public final void setValidity(Spannable spannable)
    {
        if (TextUtils.isEmpty(spannable))
        {
            n.setText(null);
            n.setVisibility(8);
            return;
        } else
        {
            n.setText(spannable);
            n.setVisibility(0);
            return;
        }
    }

}

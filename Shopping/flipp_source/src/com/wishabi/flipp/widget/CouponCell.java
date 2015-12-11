// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.widget;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.wishabi.flipp.app.dn;
import com.wishabi.flipp.util.i;

// Referenced classes of package com.wishabi.flipp.widget:
//            z, WebImageView, ItemCellSmall

public class CouponCell extends FrameLayout
{

    public static final int a[] = {
        0x7f010009
    };
    private boolean A;
    private boolean B;
    private boolean C;
    private int D;
    final View b;
    final View c;
    final ItemCellSmall d;
    dn e;
    private final View f;
    private final View g;
    private final ImageView h;
    private final View i;
    private final View j;
    private final View k;
    private final TextView l;
    private final WebImageView m;
    private final TextView n;
    private final TextView o;
    private final TextView p;
    private final TextView q;
    private final WebImageView r;
    private final TextView s;
    private final View t;
    private final WebImageView u;
    private final TextView v;
    private final View w;
    private final TextView x;
    private final TextView y;
    private boolean z;

    public CouponCell(Context context)
    {
        this(context, null);
    }

    public CouponCell(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public CouponCell(Context context, AttributeSet attributeset, int i1)
    {
        super(context, attributeset, i1);
        D = z.a;
        View.inflate(getContext(), 0x7f03001b, this);
        f = findViewById(0x7f0b005e);
        g = findViewById(0x7f0b0075);
        h = (ImageView)findViewById(0x7f0b0076);
        i = findViewById(0x7f0b005f);
        b = findViewById(0x7f0b0065);
        j = findViewById(0x7f0b0066);
        k = findViewById(0x7f0b0069);
        k.setVisibility(8);
        l = (TextView)findViewById(0x7f0b006a);
        m = (WebImageView)findViewById(0x7f0b006b);
        n = (TextView)findViewById(0x7f0b006d);
        n.setSingleLine();
        o = (TextView)findViewById(0x7f0b006e);
        o.setSingleLine();
        p = (TextView)findViewById(0x7f0b006f);
        p.setSingleLine();
        q = (TextView)findViewById(0x7f0b0070);
        r = (WebImageView)findViewById(0x7f0b0067);
        s = (TextView)findViewById(0x7f0b0068);
        t = findViewById(0x7f0b0072);
        u = (WebImageView)findViewById(0x7f0b0073);
        v = (TextView)findViewById(0x7f0b0074);
        v.setSingleLine();
        w = findViewById(0x7f0b0071);
        w.setVisibility(8);
        c = findViewById(0x7f0b0060);
        c.setVisibility(8);
        d = (ItemCellSmall)findViewById(0x7f0b0062);
        x = (TextView)findViewById(0x7f0b0063);
        x.setSingleLine();
        y = (TextView)findViewById(0x7f0b0064);
    }

    static dn a(CouponCell couponcell)
    {
        return couponcell.e;
    }

    private void a()
    {
        if (C)
        {
            s.setText(0x7f0e0018);
            s.setBackgroundColor(getResources().getColor(0x7f090008));
            s.setVisibility(0);
            return;
        }
        if (B)
        {
            s.setText(0x7f0e0014);
            s.setBackgroundColor(getResources().getColor(0x7f090002));
            s.setVisibility(0);
            return;
        }
        if (A)
        {
            s.setText(0x7f0e0017);
            s.setBackgroundColor(getResources().getColor(0x7f090007));
            s.setVisibility(0);
            return;
        } else
        {
            s.setVisibility(8);
            return;
        }
    }

    private void b()
    {
        if (D == z.b)
        {
            setPadding(0, 0, 0, 0);
            g.setVisibility(8);
            h.setImageResource(0x7f0200e0);
            h.setVisibility(0);
            setSelected(true);
            return;
        }
        if (D == z.c)
        {
            setPadding(0, 0, 0, 0);
            g.setVisibility(8);
            h.setImageResource(0x7f0200e1);
            h.setVisibility(0);
            setSelected(false);
            return;
        }
        if (D == z.d && isActivated())
        {
            int i1 = com.wishabi.flipp.util.i.a(2);
            setPadding(i1, i1, i1, i1);
            g.setVisibility(0);
            h.setImageResource(0x7f0200e0);
            h.setVisibility(0);
            setSelected(false);
            return;
        }
        if (D == z.d && !isActivated())
        {
            int j1 = com.wishabi.flipp.util.i.a(2);
            setPadding(j1, j1, j1, j1);
            g.setVisibility(8);
            h.setImageResource(0x7f0200e1);
            h.setVisibility(0);
            setSelected(false);
            return;
        } else
        {
            setPadding(0, 0, 0, 0);
            g.setVisibility(8);
            h.setImageDrawable(null);
            h.setVisibility(8);
            setSelected(false);
            return;
        }
    }

    public final void a(String s1, String s2, String s3)
    {
        int i1;
        if (TextUtils.isEmpty(s1))
        {
            n.setText(null);
            n.setVisibility(8);
            i1 = 0;
            s1 = null;
        } else
        {
            n.setText(s1);
            n.setVisibility(0);
            n.setSingleLine();
            s1 = n;
            i1 = 1;
        }
        if (TextUtils.isEmpty(s2))
        {
            o.setText(null);
            o.setVisibility(8);
        } else
        {
            o.setText(s2);
            o.setVisibility(0);
            o.setSingleLine();
            s1 = o;
            i1++;
        }
        if (TextUtils.isEmpty(s3))
        {
            p.setText(null);
            p.setVisibility(8);
        } else
        {
            p.setText(s3);
            p.setVisibility(0);
            p.setSingleLine();
            s1 = p;
            i1++;
        }
        if (i1 == 1)
        {
            s1.setSingleLine(false);
            s1.setMaxLines(2);
        }
    }

    public final void a(boolean flag, boolean flag1)
    {
        if (flag)
        {
            c.setVisibility(0);
            w.setVisibility(0);
        } else
        {
            c.setVisibility(8);
            w.setVisibility(8);
            if (flag1)
            {
                q.getLayoutParams().height = com.wishabi.flipp.util.i.a(85);
                q.setMaxLines(5);
                return;
            }
        }
        q.getLayoutParams().height = com.wishabi.flipp.util.i.a(35);
        q.setMaxLines(2);
    }

    protected int[] onCreateDrawableState(int i1)
    {
        int ai[] = super.onCreateDrawableState(i1 + 1);
        if (z)
        {
            mergeDrawableStates(ai, a);
        }
        return ai;
    }

    public void setActivated(boolean flag)
    {
        super.setActivated(flag);
        b();
    }

    public void setContainerHeight(int i1)
    {
        f.getLayoutParams().height = i1;
    }

    public void setCouponBrandImage(String s1)
    {
        if (TextUtils.isEmpty(s1))
        {
            m.setImageUrl(null);
            m.setVisibility(8);
            l.setVisibility(0);
            return;
        } else
        {
            m.setImageUrl(s1);
            m.setVisibility(0);
            l.setVisibility(8);
            return;
        }
    }

    public void setCouponBrandName(String s1)
    {
        l.setText(s1);
    }

    public void setCouponImage(String s1)
    {
        if (TextUtils.isEmpty(s1))
        {
            r.setImageUrl(null);
            r.setVisibility(8);
            return;
        } else
        {
            r.setImageUrl(s1);
            r.setVisibility(0);
            return;
        }
    }

    public void setCouponPromoText(String s1)
    {
        q.setText(s1);
    }

    public void setCouponSaleStory(String s1)
    {
        a(s1, null, null);
    }

    public void setIsClipped(boolean flag)
    {
        z = flag;
        b();
    }

    public void setIsExpired(boolean flag)
    {
        B = flag;
        a();
    }

    public void setIsSent(boolean flag)
    {
        A = flag;
        a();
    }

    public void setIsUnavailable(boolean flag)
    {
        C = flag;
        a();
    }

    public void setItemMatchupHeight(int i1)
    {
        int j1 = com.wishabi.flipp.util.i.a(10);
        w.getLayoutParams().height = i1;
        c.getLayoutParams().height = j1 + i1;
    }

    public void setItemMatchupImage(String s1)
    {
        d.setImageUrl(s1);
    }

    public void setItemMatchupLabel(String s1)
    {
        x.setText(s1);
    }

    public void setItemMatchupMerchant(String s1)
    {
        y.setText(s1);
    }

    public void setMerchantFallback(String s1)
    {
        if (TextUtils.isEmpty(s1))
        {
            t.setVisibility(8);
            return;
        } else
        {
            t.setVisibility(0);
            v.setText(s1);
            v.setVisibility(0);
            u.setVisibility(8);
            return;
        }
    }

    public void setMerchantLogoUrl(String s1)
    {
        if (TextUtils.isEmpty(s1))
        {
            t.setVisibility(8);
            return;
        } else
        {
            t.setVisibility(0);
            u.setImageUrl(s1);
            u.setVisibility(0);
            v.setVisibility(8);
            return;
        }
    }

    public void setSelectionState$5470411a(int i1)
    {
        D = i1;
        b();
    }

    public void setShowCouponBrand(boolean flag)
    {
        View view = k;
        int i1;
        if (flag)
        {
            i1 = 0;
        } else
        {
            i1 = 8;
        }
        view.setVisibility(i1);
    }

}

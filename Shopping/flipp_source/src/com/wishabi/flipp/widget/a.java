// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.widget;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.wishabi.flipp.app.dn;
import com.wishabi.flipp.util.i;

// Referenced classes of package com.wishabi.flipp.widget:
//            WebImageView, f

public final class a extends FrameLayout
{

    final View a;
    final View b;
    final View c;
    final TextView d;
    final TextView e;
    final TextView f;
    final TextView g;
    dn h;
    private final View i;
    private final View j;
    private final ImageView k;
    private final WebImageView l;
    private final View m;
    private final WebImageView n;
    private final TextView o;
    private final TextView p;
    private int q;

    public a(Context context)
    {
        this(context, (byte)0);
    }

    private a(Context context, byte byte0)
    {
        this(context, '\0');
    }

    private a(Context context, char c1)
    {
        super(context, null, 0);
        View.inflate(context, 0x7f030007, this);
        i = findViewById(0x7f0b002e);
        i.setVisibility(8);
        j = findViewById(0x7f0b003c);
        k = (ImageView)findViewById(0x7f0b003d);
        a = findViewById(0x7f0b002f);
        l = (WebImageView)findViewById(0x7f0b0030);
        m = findViewById(0x7f0b0039);
        n = (WebImageView)findViewById(0x7f0b003a);
        o = (TextView)findViewById(0x7f0b003b);
        o.setSingleLine();
        p = (TextView)findViewById(0x7f0b0031);
        b = findViewById(0x7f0b0032);
        b.setVisibility(8);
        c = findViewById(0x7f0b0034);
        d = (TextView)findViewById(0x7f0b0035);
        d.setSingleLine();
        e = (TextView)findViewById(0x7f0b0036);
        e.setSingleLine();
        f = (TextView)findViewById(0x7f0b0037);
        f.setSingleLine();
        g = (TextView)findViewById(0x7f0b0038);
    }

    static dn a(a a1)
    {
        return a1.h;
    }

    private void a()
    {
        if (q == f.b && isActivated())
        {
            int i1 = com.wishabi.flipp.util.i.a(2);
            setPadding(i1, i1, i1, i1);
            j.setVisibility(0);
            k.setImageResource(0x7f0200e0);
            k.setVisibility(0);
            return;
        }
        if (q == f.b && !isActivated())
        {
            int j1 = com.wishabi.flipp.util.i.a(2);
            setPadding(j1, j1, j1, j1);
            j.setVisibility(8);
            k.setImageResource(0x7f0200e1);
            k.setVisibility(0);
            return;
        } else
        {
            setPadding(0, 0, 0, 0);
            j.setVisibility(8);
            k.setImageDrawable(null);
            k.setVisibility(8);
            return;
        }
    }

    public final void setActivated(boolean flag)
    {
        super.setActivated(flag);
        a();
    }

    public final void setCouponMatchupAvailable(String s)
    {
        if (TextUtils.isEmpty(s))
        {
            g.setText(null);
            g.setVisibility(8);
            return;
        } else
        {
            g.setText(s);
            g.setVisibility(0);
            c.setVisibility(8);
            return;
        }
    }

    public final void setCouponMatchupHeight(int i1)
    {
        b.getLayoutParams().height = i1;
    }

    public final void setExpired(boolean flag)
    {
        if (flag)
        {
            p.setText(0x7f0e0014);
            p.setBackgroundColor(getResources().getColor(0x7f090002));
            p.setVisibility(0);
            return;
        } else
        {
            p.setVisibility(8);
            return;
        }
    }

    public final void setImageUrl(String s)
    {
        if (s != null)
        {
            l.setImageUrl(s);
        }
    }

    public final void setItemBackgroundResource(int i1)
    {
        a.setBackgroundResource(i1);
    }

    public final void setMerchantFallback(String s)
    {
        if (TextUtils.isEmpty(s))
        {
            m.setVisibility(8);
            return;
        } else
        {
            m.setVisibility(0);
            o.setText(s);
            o.setVisibility(0);
            n.setVisibility(8);
            return;
        }
    }

    public final void setMerchantLogoUrl(String s)
    {
        if (TextUtils.isEmpty(s))
        {
            m.setVisibility(8);
            return;
        } else
        {
            m.setVisibility(0);
            n.setImageUrl(s);
            n.setVisibility(0);
            o.setVisibility(8);
            return;
        }
    }

    public final void setSelectionState$448952c2(int i1)
    {
        q = i1;
        a();
    }

    public final void setShowCouponMatchup(boolean flag)
    {
        boolean flag1 = false;
        View view = b;
        int i1;
        if (flag)
        {
            i1 = 0;
        } else
        {
            i1 = 8;
        }
        view.setVisibility(i1);
        view = i;
        if (flag)
        {
            i1 = ((flag1) ? 1 : 0);
        } else
        {
            i1 = 8;
        }
        view.setVisibility(i1);
    }
}

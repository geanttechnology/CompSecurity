// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import android.content.Context;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.mopub.c.i;
import com.mopub.common.c.a;
import com.mopub.common.d.d;
import com.mopub.common.d.m;
import com.mopub.d.a.g;
import com.mopub.d.s;
import com.mopub.mobileads.b.b;

public final class ag extends RelativeLayout
{

    TextView a;
    final g b;
    private ImageView c;
    private b d;
    private final int e;
    private final int f;
    private final int g;
    private final int h;

    public ag(Context context)
    {
        super(context);
        setId((int)m.a());
        e = com.mopub.common.d.d.b(16F, context);
        g = com.mopub.common.d.d.b(5F, context);
        h = com.mopub.common.d.d.b(46F, context);
        f = com.mopub.common.d.d.b(7F, context);
        d = new b();
        b = i.b(context);
        c = new ImageView(getContext());
        c.setId((int)m.a());
        context = new android.widget.RelativeLayout.LayoutParams(h, h);
        context.addRule(11);
        c.setImageDrawable(d);
        c.setPadding(g, g + e, g + e, g);
        addView(c, context);
        a = new TextView(getContext());
        a.setSingleLine();
        a.setEllipsize(android.text.TextUtils.TruncateAt.END);
        a.setTextColor(-1);
        a.setTextSize(20F);
        a.setTypeface(com.mopub.mobileads.b.d.a.b);
        a.setText("");
        context = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        context.addRule(15);
        context.addRule(0, c.getId());
        a.setPadding(0, e, 0, 0);
        context.setMargins(0, 0, f, 0);
        addView(a, context);
        context = new android.widget.RelativeLayout.LayoutParams(-2, h);
        context.addRule(11);
        setLayoutParams(context);
    }

    static ImageView a(ag ag1)
    {
        return ag1.c;
    }

    final ImageView getImageView()
    {
        return c;
    }

    final TextView getTextView()
    {
        return a;
    }

    final void setImageView(ImageView imageview)
    {
        c = imageview;
    }

    final void setOnTouchListenerToContent(android.view.View.OnTouchListener ontouchlistener)
    {
        c.setOnTouchListener(ontouchlistener);
        a.setOnTouchListener(ontouchlistener);
    }

    // Unreferenced inner class com/mopub/mobileads/ag$1

/* anonymous class */
    final class _cls1
        implements com.mopub.d.a.g.d
    {

        final String a;
        final ag b;

        public final void a(com.mopub.d.a.g.c c1)
        {
            c1 = c1.a;
            if (c1 != null)
            {
                com.mopub.mobileads.ag.a(b).setImageBitmap(c1);
                return;
            } else
            {
                com.mopub.common.c.a.b(String.format("%s returned null bitmap", new Object[] {
                    a
                }));
                return;
            }
        }

        public final void a(s s)
        {
            com.mopub.common.c.a.b("Failed to load image.", s);
        }

            
            {
                b = ag.this;
                a = s;
                super();
            }
    }

}

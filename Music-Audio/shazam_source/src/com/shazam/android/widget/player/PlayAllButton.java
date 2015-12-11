// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.widget.player;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.shazam.android.analytics.event.EventAnalyticsFromView;
import com.shazam.android.analytics.event.factory.PlayerEventFactory;
import com.shazam.android.j.n;
import com.shazam.android.k.d.a;
import com.shazam.android.k.f.p;
import com.shazam.android.k.f.t;
import com.shazam.android.widget.k;
import com.shazam.android.widget.l;
import com.shazam.android.widget.preview.c;
import com.shazam.android.widget.text.CustomFontTextView;
import com.shazam.i.b.n.b;
import com.shazam.model.analytics.player.PlayAllButtonAnalyticsInfo;
import com.shazam.model.playlist.PlaybackProviderSelector;
import java.util.EnumMap;

public class PlayAllButton extends l
    implements android.view.View.OnClickListener, a
{

    public PlayAllButtonAnalyticsInfo a;
    private final PlaybackProviderSelector b;
    private final n c;
    private final EventAnalyticsFromView d;
    private final t e;
    private int f;
    private CustomFontTextView g;
    private ImageView h;

    public PlayAllButton(Context context)
    {
        this(context, null, 0x7f010026);
    }

    public PlayAllButton(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0x7f010026);
    }

    public PlayAllButton(Context context, AttributeSet attributeset, int i)
    {
        boolean flag = true;
        super(context, attributeset, i);
        b = com.shazam.i.b.ai.a.a();
        c = com.shazam.i.b.n.b.H();
        d = com.shazam.i.b.g.b.a.b();
        e = new p();
        f = 0x7fffffff;
        a = com.shazam.model.analytics.player.PlayAllButtonAnalyticsInfo.Builder.a().b();
        if (attributeset != null)
        {
            context = getContext().obtainStyledAttributes(attributeset, new int[] {
                0x101011f
            });
            f = context.getDimensionPixelSize(0, 0x7fffffff);
            context.recycle();
        }
        h = new ImageView(getContext());
        a();
        g = new CustomFontTextView(getContext());
        g.setTextSize(2, 16F);
        g.setAllCaps(true);
        g.setText(0x7f0900d1);
        g.a(0x7f09020e);
        context = g;
        context.setTextColor(context.getResources().getColorStateList(0x7f0f00b1));
        a(new View[] {
            h, g
        });
        if (!c.a())
        {
            i = ((flag) ? 1 : 0);
        } else
        {
            i = 0;
        }
        if (i != 0)
        {
            setVisibility(8);
        }
    }

    private void a()
    {
        h.setImageResource(((Integer)c.b.get(b.a())).intValue());
    }

    public final void f()
    {
        a();
    }

    public Uri getUri()
    {
        return e.h();
    }

    public void onClick(View view)
    {
        d.logEvent(this, PlayerEventFactory.createPlayAllUserEvent(a));
    }

    protected void onLayout(boolean flag, int i, int j, int i1, int j1)
    {
        i = com.shazam.android.util.h.b.a(10);
        j = h.getMeasuredWidth();
        i1 = g.getMeasuredWidth();
        j1 = getMeasuredWidth();
        int k1 = getPaddingLeft();
        int l1 = getPaddingRight();
        k.a.a(h).a((j1 - k1 - l1 - (j + i1 + i)) / 2 + getPaddingLeft()).b(this);
        k.a.a(g).a(i + h.getRight()).b(this);
    }

    protected void onMeasure(int i, int j)
    {
        super.onMeasure(i, j);
        i = Math.min(f, getMeasuredWidth());
        j = getResources().getDimensionPixelSize(0x7f0a00ed);
        h.measure(android.view.View.MeasureSpec.makeMeasureSpec(j, 0x40000000), android.view.View.MeasureSpec.makeMeasureSpec(j, 0x40000000));
        g.measure(android.view.View.MeasureSpec.makeMeasureSpec(i - h.getMeasuredWidth(), 0x80000000), android.view.View.MeasureSpec.makeMeasureSpec(0, 0));
        setMeasuredDimension(a(this, i), a(this, getResources().getDimensionPixelSize(0x7f0a00ec)));
    }

    public void setEnabled(boolean flag)
    {
        super.setEnabled(flag);
        g.setEnabled(flag);
        h.setEnabled(flag);
    }

    public void setOnClickListener(android.view.View.OnClickListener onclicklistener)
    {
        super.setOnClickListener(new com.shazam.android.ad.d.a(new android.view.View.OnClickListener[] {
            onclicklistener, this
        }));
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.res.Resources;
import android.util.Pair;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;
import com.google.android.apps.youtube.kids.ui.HeaderTileGridLayout;
import java.util.List;

public final class afj
    implements Runnable
{

    final int a;
    final HeaderTileGridLayout b;
    private int c;
    private int d;
    private boolean e;

    public afj(HeaderTileGridLayout headertilegridlayout, int i, boolean flag)
    {
        b = headertilegridlayout;
        a = i;
        e = flag;
        super();
        c = HeaderTileGridLayout.a(b);
        d = b.getContext().getResources().getInteger(0x7f0e0019);
    }

    public final void run()
    {
        int i = ((View)((Pair)HeaderTileGridLayout.d(b).get(a)).second).getWidth();
        int j = b.getWidth() / 2;
        int k = (HeaderTileGridLayout.d(b).size() * i) / 2;
        int l = a;
        int i1 = HeaderTileGridLayout.e(b).getWidth() / 2;
        i = (i / 2 + ((j - k) + l * i)) - i1;
        if (i == 0)
        {
            i = -500;
        }
        HeaderTileGridLayout.c(b).setText((CharSequence)((Pair)HeaderTileGridLayout.b(b).get(a)).second);
        if (HeaderTileGridLayout.a(b) < 0 || e)
        {
            c = i;
            d = 0;
        }
        HeaderTileGridLayout.a(b, i);
        HeaderTileGridLayout.e(b).clearAnimation();
        TranslateAnimation translateanimation = new TranslateAnimation(0, c, 0, i, 0, 0.0F, 0, 0.0F);
        translateanimation.setFillAfter(true);
        translateanimation.setDuration(d);
        translateanimation.setInterpolator(new DecelerateInterpolator());
        translateanimation.setAnimationListener(new afk(this, translateanimation));
        HeaderTileGridLayout.e(b).startAnimation(translateanimation);
        HeaderTileGridLayout.a(b, translateanimation);
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import com.google.android.apps.youtube.kids.ui.HeaderTileGridLayout;
import com.google.android.apps.youtube.kids.ui.ScrollingSectionListGridView;

public final class afl
    implements android.view.View.OnClickListener
{

    private final View a;
    private final int b;
    private HeaderTileGridLayout c;

    public afl(HeaderTileGridLayout headertilegridlayout, View view, int i)
    {
        c = headertilegridlayout;
        super();
        a = view;
        b = i;
    }

    public final void onClick(View view)
    {
        int i;
label0:
        {
            i = HeaderTileGridLayout.a(c, a);
            HeaderTileGridLayout.a(c, a, true);
            if (i >= 0)
            {
                if (i != HeaderTileGridLayout.g(c))
                {
                    break label0;
                }
                HeaderTileGridLayout.a(c, a, true);
            }
            return;
        }
        c.a(i, true);
        HeaderTileGridLayout.b(c, i);
        HeaderTileGridLayout.h(c).a(b);
    }
}

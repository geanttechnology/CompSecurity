// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes;

import android.view.View;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.TextView;

// Referenced classes of package com.livemixtapes:
//            Mixtape

class this._cls0
    implements android.widget.w.OnScrollListener
{

    final Mixtape this$0;

    public void onScroll(AbsListView abslistview, int i, int j, int k)
    {
        if (!Mixtape.access$20(Mixtape.this).booleanValue())
        {
            return;
        }
        j = getScrollY();
        if (j > 0)
        {
            Mixtape.access$21(Mixtape.this).setVisibility(4);
            if (Mixtape.access$22(Mixtape.this) == 0L)
            {
                Mixtape.access$23(Mixtape.this).setVisibility(4);
            }
            Mixtape.access$24(Mixtape.this).setVisibility(4);
        } else
        {
            Mixtape.access$21(Mixtape.this).setVisibility(0);
            if (Mixtape.access$22(Mixtape.this) == 0L)
            {
                Mixtape.access$23(Mixtape.this).setVisibility(0);
            }
            Mixtape.access$24(Mixtape.this).setVisibility(0);
        }
        i = j;
        if (j < 0)
        {
            i = 0;
        }
        j = Math.max(Mixtape.access$25(Mixtape.this) - (int)((double)i * 0.40000000000000002D), Mixtape.access$26(Mixtape.this));
        i = Math.max(Mixtape.access$27(Mixtape.this) - (int)((double)i * 0.40000000000000002D), Mixtape.access$28(Mixtape.this));
        Mixtape.access$29(Mixtape.this).getLayoutParams().width = j;
        Mixtape.access$29(Mixtape.this).getLayoutParams().height = j;
        Mixtape.access$30(Mixtape.this).getLayoutParams().height = i;
        Mixtape.access$29(Mixtape.this).requestLayout();
        Mixtape.access$30(Mixtape.this).requestLayout();
    }

    public void onScrollStateChanged(AbsListView abslistview, int i)
    {
        Mixtape.access$31(Mixtape.this, i);
    }

    utParams()
    {
        this$0 = Mixtape.this;
        super();
    }
}

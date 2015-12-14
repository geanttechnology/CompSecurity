// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import android.widget.LinearLayout;
import com.wantu.view.TIconListScrollView;

public class bqg
    implements Runnable
{

    final int a;
    final TIconListScrollView b;

    public bqg(TIconListScrollView ticonlistscrollview, int i)
    {
        b = ticonlistscrollview;
        a = i;
        super();
    }

    public void run()
    {
        int i = TIconListScrollView.access$000(b).getChildAt(a).getLeft();
        if (a > 2)
        {
            b.scrollTo(i - 50, 0);
        }
    }
}

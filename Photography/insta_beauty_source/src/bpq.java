// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import android.widget.LinearLayout;
import com.wantu.view.TBackgroudScrollView;

public class bpq
    implements Runnable
{

    final int a;
    final TBackgroudScrollView b;

    public bpq(TBackgroudScrollView tbackgroudscrollview, int i)
    {
        b = tbackgroudscrollview;
        a = i;
        super();
    }

    public void run()
    {
        View view = TBackgroudScrollView.access$000(b).getChildAt(a);
        if (view != null)
        {
            int i = view.getLeft();
            if (a > 2)
            {
                b.scrollTo(i - 50, 0);
            }
        }
    }
}

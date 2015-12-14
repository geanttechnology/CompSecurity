// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import android.widget.LinearLayout;
import com.wantu.view.TLightingScrollView;

public class bqj
    implements Runnable
{

    final int a;
    final TLightingScrollView b;

    public bqj(TLightingScrollView tlightingscrollview, int i)
    {
        b = tlightingscrollview;
        a = i;
        super();
    }

    public void run()
    {
        View view = TLightingScrollView.access$000(b).getChildAt(a);
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

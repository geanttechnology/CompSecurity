// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import android.widget.LinearLayout;
import com.wantu.view.TFrameListScrollView;

public class bqa
    implements Runnable
{

    final int a;
    final TFrameListScrollView b;

    public bqa(TFrameListScrollView tframelistscrollview, int i)
    {
        b = tframelistscrollview;
        a = i;
        super();
    }

    public void run()
    {
        View view = TFrameListScrollView.access$000(b).getChildAt(a);
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

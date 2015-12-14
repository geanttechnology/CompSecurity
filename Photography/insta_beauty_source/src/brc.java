// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import com.wantu.view.scroll.TShareScrollView;

public class brc
    implements android.view.View.OnClickListener
{

    final TShareScrollView a;

    public brc(TShareScrollView tsharescrollview)
    {
        a = tsharescrollview;
        super();
    }

    public void onClick(View view)
    {
        if (TShareScrollView.access$000(a) != view)
        {
            if (TShareScrollView.access$000(a) != null)
            {
                TShareScrollView.access$000(a).setSelected(false);
            }
            TShareScrollView.access$002(a, view);
        }
        view.setSelected(true);
        if (TShareScrollView.access$100(a) != null)
        {
            TShareScrollView.access$100(a).a((String)view.getTag(), a);
        }
    }
}

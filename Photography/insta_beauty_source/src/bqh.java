// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import com.wantu.view.TIconListScrollView;

public class bqh
    implements android.view.View.OnClickListener
{

    final TIconListScrollView a;

    public bqh(TIconListScrollView ticonlistscrollview)
    {
        a = ticonlistscrollview;
        super();
    }

    public void onClick(View view)
    {
        if (TIconListScrollView.access$100(a) != view)
        {
            if (TIconListScrollView.access$100(a) != null)
            {
                TIconListScrollView.access$100(a).setSelected(false);
            }
            TIconListScrollView.access$102(a, view);
            view.setSelected(true);
            if (TIconListScrollView.access$200(a) != null)
            {
                TIconListScrollView.access$200(a).a(view.getTag());
                return;
            }
        }
    }
}

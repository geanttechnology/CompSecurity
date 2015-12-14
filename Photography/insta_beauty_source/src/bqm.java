// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import com.wantu.view.TMagFilterListScrollView;

public class bqm
    implements android.view.View.OnClickListener
{

    final TMagFilterListScrollView a;

    public bqm(TMagFilterListScrollView tmagfilterlistscrollview)
    {
        a = tmagfilterlistscrollview;
        super();
    }

    public void onClick(View view)
    {
        if (TMagFilterListScrollView.access$000(a) != null)
        {
            TMagFilterListScrollView.access$000(a).setSelected(false);
        }
        TMagFilterListScrollView.access$002(a, view);
        view.setSelected(true);
        if (TMagFilterListScrollView.access$100(a) != null)
        {
            TMagFilterListScrollView.access$100(a).a((String)view.getTag());
        }
    }
}

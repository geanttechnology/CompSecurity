// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import android.widget.AdapterView;
import com.wantu.view.TFilterListScrollView;
import java.util.List;

public class bpv
    implements android.widget.AdapterView.OnItemClickListener
{

    final TFilterListScrollView a;

    public bpv(TFilterListScrollView tfilterlistscrollview)
    {
        a = tfilterlistscrollview;
        super();
    }

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        if (TFilterListScrollView.access$200(a) != null)
        {
            a.cancelSelected();
            TFilterListScrollView.access$300(a, view, true);
            TFilterListScrollView.access$102(a, i);
            TFilterListScrollView.access$200(a).a(((bpz)TFilterListScrollView.access$400(a).get(i)).b);
            a.requestLayout();
        }
    }
}

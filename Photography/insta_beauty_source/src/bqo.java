// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import android.widget.AdapterView;
import com.wantu.view.TMagFilterListScrollView2;
import java.util.List;

public class bqo
    implements android.widget.AdapterView.OnItemClickListener
{

    final TMagFilterListScrollView2 a;

    public bqo(TMagFilterListScrollView2 tmagfilterlistscrollview2)
    {
        a = tmagfilterlistscrollview2;
        super();
    }

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        if (TMagFilterListScrollView2.access$200(a) != null)
        {
            a.cancelSelected();
            adapterview = view.findViewById(0x7f0d01ef);
            TMagFilterListScrollView2.access$302(a, adapterview);
            adapterview.setSelected(true);
            TMagFilterListScrollView2.access$102(a, i);
            TMagFilterListScrollView2.access$200(a).a(((bqs)TMagFilterListScrollView2.access$400(a).get(i)).b);
        }
    }
}

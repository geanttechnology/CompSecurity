// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import android.widget.AdapterView;
import com.wantu.model.res.pip.TDFSceneInfo;
import com.wantu.view.TPipListScrollView;
import java.util.List;

public class bqt
    implements android.widget.AdapterView.OnItemClickListener
{

    final TPipListScrollView a;

    public bqt(TPipListScrollView tpiplistscrollview)
    {
        a = tpiplistscrollview;
        super();
    }

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        if (TPipListScrollView.access$200(a) != null)
        {
            a.cancelSelected();
            TPipListScrollView.access$300(a, view, true);
            TPipListScrollView.access$102(a, i);
            TPipListScrollView.access$200(a).a((TDFSceneInfo)TPipListScrollView.access$400(a).get(i));
        }
    }
}

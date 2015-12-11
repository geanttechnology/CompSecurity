// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.jpush.android.ui;

import android.view.View;
import android.widget.AdapterView;
import cn.jpush.android.data.d;
import cn.jpush.android.util.a;
import java.util.List;

// Referenced classes of package cn.jpush.android.ui:
//            ListViewActivity

final class g
    implements android.widget.AdapterView.OnItemClickListener
{

    final List a;
    final ListViewActivity b;

    g(ListViewActivity listviewactivity, List list)
    {
        b = listviewactivity;
        a = list;
        super();
    }

    public final void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        adapterview = (d)a.get(i);
        adapterview.q = false;
        adapterview = cn.jpush.android.util.a.a(b, adapterview, false);
        b.startActivity(adapterview);
    }
}

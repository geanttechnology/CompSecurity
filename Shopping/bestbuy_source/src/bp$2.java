// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import android.widget.ExpandableListView;
import java.util.ArrayList;

class lang.Object
    implements android.widget.dableListView.OnGroupClickListener
{

    final bp a;

    public boolean onGroupClick(ExpandableListView expandablelistview, View view, int i, long l)
    {
        if (!expandablelistview.isGroupExpanded(i))
        {
            lu.b((new StringBuilder()).append(lu.bb).append((String)bp.b(a).get(i)).toString(), null);
        }
        return false;
    }

    >(bp bp1)
    {
        a = bp1;
        super();
    }
}

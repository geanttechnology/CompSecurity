// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.dialogs;

import android.view.View;
import android.widget.ExpandableListView;
import com.cyberlink.youcammakeup.activity.EditViewActivity;
import com.cyberlink.youcammakeup.pages.editview.savemylook.c;
import com.cyberlink.youcammakeup.utility.BeautyMode;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.dialogs:
//            ah

class a
    implements android.widget.ableListView.OnGroupClickListener
{

    final ah a;

    public boolean onGroupClick(ExpandableListView expandablelistview, View view, int i, long l)
    {
        if (!ah.g(a))
        {
            return true;
        }
        a.dismiss();
        ah.a(a, false);
        expandablelistview = (c)view.getTag();
        view = a.getActivity();
        if (view instanceof EditViewActivity)
        {
            ((EditViewActivity)view).c(true);
            ((EditViewActivity)view).a(BeautyMode.c(((c) (expandablelistview)).a), ((c) (expandablelistview)).a, ((c) (expandablelistview)).b);
        }
        ah.b = true;
        return true;
    }

    (ah ah1)
    {
        a = ah1;
        super();
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.pages.moreview;

import android.view.View;
import android.widget.ExpandableListView;

// Referenced classes of package com.cyberlink.youcammakeup.pages.moreview:
//            aa, p

class a
    implements android.view.OnClickListener
{

    final aa a;

    public void onClick(View view)
    {
        if (aa.g(a) != null)
        {
            int i = ((p)view.getTag()).a();
            aa.g(a).onGroupClick((ExpandableListView)view.getParent(), view, i, a.getGroupId(i));
        }
    }

    istener(aa aa1)
    {
        a = aa1;
        super();
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.instamag.activity.commonview;

import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.SectionIndexer;

// Referenced classes of package com.instamag.activity.commonview:
//            MagFilterActionBar

class a
    implements android.view.agFilterActionBar._cls1
{

    final MagFilterActionBar a;

    public void onClick(View view)
    {
        int i = ((Integer)view.getTag()).intValue();
        if (MagFilterActionBar.access$000(a) == null)
        {
            MagFilterActionBar.access$002(a, (SectionIndexer)MagFilterActionBar.access$100(a).getAdapter());
        }
        if (i < 0)
        {
            i = 0;
        }
        int j = i;
        if (MagFilterActionBar.access$200(a) != null)
        {
            j = i;
            if (i >= MagFilterActionBar.access$200(a).length)
            {
                j = MagFilterActionBar.access$200(a).length - 1;
            }
        }
        i = MagFilterActionBar.access$000(a).getPositionForSection(j);
        Log.v(a.TAG, (new StringBuilder()).append(a.TAG).append("Touch on selectedIndex: ").append(String.valueOf(j)).toString());
        if (i == -1)
        {
            return;
        } else
        {
            MagFilterActionBar.access$100(a).setSelection(i);
            return;
        }
    }

    (MagFilterActionBar magfilteractionbar)
    {
        a = magfilteractionbar;
        super();
    }
}

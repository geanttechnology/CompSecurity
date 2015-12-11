// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.browseprograms;

import android.util.Pair;
import java.util.Comparator;

// Referenced classes of package com.xfinity.playerlib.view.browseprograms:
//            BrowseFilterCategoryDetailPanel

class this._cls0
    implements Comparator
{

    final BrowseFilterCategoryDetailPanel this$0;

    public int compare(Pair pair, Pair pair1)
    {
        return ((String)pair.second).compareTo((String)pair1.second);
    }

    public volatile int compare(Object obj, Object obj1)
    {
        return compare((Pair)obj, (Pair)obj1);
    }

    Q()
    {
        this$0 = BrowseFilterCategoryDetailPanel.this;
        super();
    }
}

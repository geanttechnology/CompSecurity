// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.sketch.view;

import android.view.View;
import android.widget.ExpandableListView;

// Referenced classes of package com.fotoable.sketch.view:
//            TTieZhiLibraryView

class a
    implements android.widget.GroupClickListener
{

    final TTieZhiLibraryView a;

    public boolean onGroupClick(ExpandableListView expandablelistview, View view, int i, long l)
    {
        return true;
    }

    Listener(TTieZhiLibraryView ttiezhilibraryview)
    {
        a = ttiezhilibraryview;
        super();
    }
}

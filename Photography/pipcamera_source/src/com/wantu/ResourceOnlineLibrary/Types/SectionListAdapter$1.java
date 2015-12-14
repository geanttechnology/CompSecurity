// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.ResourceOnlineLibrary.Types;

import android.view.View;
import android.widget.AdapterView;
import uh;
import ui;

// Referenced classes of package com.wantu.ResourceOnlineLibrary.Types:
//            SectionListAdapter

class a
    implements android.widget.ckListener
{

    final SectionListAdapter a;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        adapterview = a.indexPathForPosition(i);
        if (((uh) (adapterview)).b >= 0)
        {
            a._flddelegate.a(adapterview, view);
        }
    }

    (SectionListAdapter sectionlistadapter)
    {
        a = sectionlistadapter;
        super();
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.ResourceOnlineLibrary.Manage;

import android.content.DialogInterface;
import android.widget.Button;
import tg;
import th;

// Referenced classes of package com.wantu.ResourceOnlineLibrary.Manage:
//            SectionGridViewAdapter

class a
    implements android.content.stener
{

    final SectionGridViewAdapter a;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        if (SectionGridViewAdapter.access$000(a) != null)
        {
            dialoginterface = (tg)SectionGridViewAdapter.access$000(a).getTag();
            if (SectionGridViewAdapter.access$100(a) != null && dialoginterface != null)
            {
                SectionGridViewAdapter.access$100(a).a(((tg) (dialoginterface)).a, ((tg) (dialoginterface)).b, ((tg) (dialoginterface)).c);
            }
        }
    }

    (SectionGridViewAdapter sectiongridviewadapter)
    {
        a = sectiongridviewadapter;
        super();
    }
}

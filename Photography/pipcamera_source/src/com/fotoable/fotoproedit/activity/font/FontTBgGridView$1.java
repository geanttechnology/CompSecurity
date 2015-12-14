// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.fotoproedit.activity.font;

import android.view.View;
import android.widget.AdapterView;
import hn;
import ho;
import java.util.ArrayList;
import ub;

// Referenced classes of package com.fotoable.fotoproedit.activity.font:
//            FontTBgGridView, FontOnlineInfo

public class a
    implements android.widget.ClickListener
{

    final FontTBgGridView a;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        if (i < FontTBgGridView.access$000(a).a().size())
        {
            adapterview = (FontOnlineInfo)FontTBgGridView.access$000(a).a().get(i);
            break MISSING_BLOCK_LABEL_35;
        }
        do
        {
            return;
        } while (a.getContext() != null && (new ub(a.getContext(), adapterview)).a() || FontTBgGridView.access$100(a) == null);
        FontTBgGridView.access$100(a).a(adapterview);
    }

    (FontTBgGridView fonttbggridview)
    {
        a = fonttbggridview;
        super();
    }
}

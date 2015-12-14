// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.sticker;

import android.view.View;
import android.widget.Adapter;
import com.cyberlink.you.database.StickerPackObj;
import com.cyberlink.you.widgetpool.clhorizontalgridview.AdapterView;
import com.cyberlink.you.widgetpool.clhorizontalgridview.p;

// Referenced classes of package com.cyberlink.you.sticker:
//            StickerFragment

class a
    implements p
{

    final StickerFragment a;

    public void a(AdapterView adapterview, View view, int i, long l)
    {
        if (a.getActivity() != null)
        {
            StickerFragment.a(a, i);
            view = ((StickerPackObj)adapterview.getAdapter().getItem(i)).r();
            if (view == com.cyberlink.you.database.tionType.a)
            {
                adapterview = (StickerPackObj)adapterview.getAdapter().getItem(i);
                StickerFragment.a(a, adapterview.b());
                return;
            }
            if (view == com.cyberlink.you.database.tionType.b)
            {
                StickerFragment.a(a, -2L);
                return;
            }
            if (view == com.cyberlink.you.database.tionType.c)
            {
                return;
            }
        }
    }

    view.AdapterView(StickerFragment stickerfragment)
    {
        a = stickerfragment;
        super();
    }
}

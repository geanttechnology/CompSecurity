// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.sticker;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.cyberlink.you.activity.StickerShopAcitvity;

// Referenced classes of package com.cyberlink.you.sticker:
//            StickerFragment

class a
    implements android.view.r
{

    final StickerFragment a;

    public void onClick(View view)
    {
        if (a.getActivity() == null)
        {
            return;
        } else
        {
            view = new Intent(a.getActivity(), com/cyberlink/you/activity/StickerShopAcitvity);
            a.getActivity().startActivityForResult(view, 20);
            return;
        }
    }

    y(StickerFragment stickerfragment)
    {
        a = stickerfragment;
        super();
    }
}

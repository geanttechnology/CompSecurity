// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.sticker;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.cyberlink.you.activity.StickerShopDetailActivity;
import com.cyberlink.you.database.StickerPackObj;

// Referenced classes of package com.cyberlink.you.sticker:
//            StickerFragment

class a
    implements android.view.er
{

    final StickerFragment a;

    public void onClick(View view)
    {
        StickerPackObj stickerpackobj = (StickerPackObj)view.getTag();
        if (a.getActivity() == null)
        {
            return;
        } else
        {
            Intent intent = new Intent(a.getActivity(), com/cyberlink/you/activity/StickerShopDetailActivity);
            intent.putExtra("stickerPckObj", (StickerPackObj)view.getTag());
            intent.putExtra("isPurchased", false);
            a.getActivity().startActivityForResult(intent, 20);
            return;
        }
    }

    Activity(StickerFragment stickerfragment)
    {
        a = stickerfragment;
        super();
    }
}

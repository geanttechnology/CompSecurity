// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.activity;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.AdapterView;
import com.cyberlink.you.database.StickerPackObj;

// Referenced classes of package com.cyberlink.you.activity:
//            u, v, StickerShopDetailActivity

class a
    implements android.widget.terView.OnItemClickListener
{

    final u a;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        adapterview = (StickerPackObj)u.b(a).getItem(i);
        view = new Intent(a.getActivity(), com/cyberlink/you/activity/StickerShopDetailActivity);
        view.putExtra("stickerPckObj", adapterview);
        view.putExtra("isPurchased", false);
        a.getActivity().startActivity(view);
    }

    Activity(u u1)
    {
        a = u1;
        super();
    }
}

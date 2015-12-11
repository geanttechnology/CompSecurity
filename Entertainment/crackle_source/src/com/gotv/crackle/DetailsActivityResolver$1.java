// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle;

import android.content.Intent;
import com.gotv.crackle.data.ChannelDetails;
import com.gotv.crackle.data.MediaDetailsRequest;
import com.gotv.crackle.helpers.ChromeCastHelper;
import com.gotv.crackle.model.ChannelItem;
import com.gotv.crackle.model.MediaDetailsItem;

// Referenced classes of package com.gotv.crackle:
//            DetailsActivityResolver, ShowWatchlistDetailsActivity, ChromeCastingDetailsActivity, MovieDetailsActivity

class val.tag
    implements Runnable
{

    final DetailsActivityResolver this$0;
    final String val$tag;

    public void run()
    {
        Intent intent1;
        Object obj;
        intent1 = null;
        obj = null;
        if (!val$tag.equalsIgnoreCase("MediaDetails")) goto _L2; else goto _L1
_L1:
        MediaDetailsItem mediadetailsitem = DetailsActivityResolver.access$000(DetailsActivityResolver.this).getItem();
        if (!mediadetailsitem.getRootChannelID().equalsIgnoreCase("46") && !mediadetailsitem.getRootChannelID().equalsIgnoreCase("114")) goto _L4; else goto _L3
_L3:
        Intent intent;
        String s;
        s = "shows";
        intent = new Intent(DetailsActivityResolver.this, com/gotv/crackle/ShowWatchlistDetailsActivity);
        DetailsActivityResolver.access$102(DetailsActivityResolver.this, mediadetailsitem.getParentChannelID());
_L6:
        intent1 = intent;
        if (ChromeCastHelper.getInstance(DetailsActivityResolver.this).isConnected())
        {
            intent1 = intent;
            if (DetailsActivityResolver.access$300(DetailsActivityResolver.this))
            {
                intent1 = new Intent(DetailsActivityResolver.this, com/gotv/crackle/ChromeCastingDetailsActivity);
                intent1.addFlags(0x20000);
            }
        }
        if (intent1 != null)
        {
            if (DetailsActivityResolver.access$100(DetailsActivityResolver.this) != null)
            {
                intent1.putExtra("ID", DetailsActivityResolver.access$100(DetailsActivityResolver.this));
            }
            if (DetailsActivityResolver.access$400(DetailsActivityResolver.this) != null)
            {
                intent1.putExtra("MEDIA_ITEM_ID", DetailsActivityResolver.access$400(DetailsActivityResolver.this));
            }
            intent1.putExtra("EXTRA_CATEGORY", s);
            intent1.putExtra("START_PLAYING", DetailsActivityResolver.access$300(DetailsActivityResolver.this));
            startActivity(intent1);
        }
        finish();
        return;
_L4:
        s = obj;
        intent = intent1;
        if (mediadetailsitem.getRootChannelID().equalsIgnoreCase("82"))
        {
            s = "movies";
            intent = new Intent(DetailsActivityResolver.this, com/gotv/crackle/MovieDetailsActivity);
            DetailsActivityResolver.access$102(DetailsActivityResolver.this, mediadetailsitem.getParentChannelID());
        }
        continue; /* Loop/switch isn't completed */
_L2:
        s = obj;
        intent = intent1;
        if (val$tag.equalsIgnoreCase("ChannelDetails"))
        {
            ChannelItem channelitem = DetailsActivityResolver.access$200(DetailsActivityResolver.this).getItem();
            if (channelitem.getRrootChannelID().equalsIgnoreCase("46") || channelitem.getRrootChannelID().equalsIgnoreCase("114"))
            {
                s = "shows";
                intent = new Intent(DetailsActivityResolver.this, com/gotv/crackle/ShowWatchlistDetailsActivity);
            } else
            if (channelitem.getRrootChannelID().equalsIgnoreCase("82"))
            {
                s = "movies";
                intent = new Intent(DetailsActivityResolver.this, com/gotv/crackle/MovieDetailsActivity);
            } else
            {
                s = obj;
                intent = intent1;
                if (channelitem.getRrootChannelID().equalsIgnoreCase("586"))
                {
                    s = "watchlists";
                    intent = new Intent(DetailsActivityResolver.this, com/gotv/crackle/ShowWatchlistDetailsActivity);
                }
            }
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    ty()
    {
        this$0 = final_detailsactivityresolver;
        val$tag = String.this;
        super();
    }
}

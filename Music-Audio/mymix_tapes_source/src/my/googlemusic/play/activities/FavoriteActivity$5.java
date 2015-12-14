// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.activities;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import my.googlemusic.play.adapters.manager.library.LibraryRecyclerAdapter;

// Referenced classes of package my.googlemusic.play.activities:
//            FavoriteActivity

class this._cls0 extends BroadcastReceiver
{

    final FavoriteActivity this$0;

    public void onReceive(Context context, Intent intent)
    {
        context = intent.getStringExtra("EXTRAS");
        if (context != null)
        {
            if (context.equals("FAVORITE ADDED"))
            {
                FavoriteActivity.access$1000(FavoriteActivity.this, 1);
                FavoriteActivity.access$1100(FavoriteActivity.this);
            } else
            {
                if (context.equals("DOWNLOAD ADDED"))
                {
                    FavoriteActivity.access$700(FavoriteActivity.this).notifyDataSetChanged();
                    return;
                }
                if (context.equals("DOWNLOAD DELETED"))
                {
                    FavoriteActivity.access$700(FavoriteActivity.this).notifyDataSetChanged();
                    return;
                }
                if (context.equals("DOWNLOAD FINISHED"))
                {
                    FavoriteActivity.access$700(FavoriteActivity.this).notifyDataSetChanged();
                    return;
                }
            }
        }
    }

    ryRecyclerAdapter()
    {
        this$0 = FavoriteActivity.this;
        super();
    }
}

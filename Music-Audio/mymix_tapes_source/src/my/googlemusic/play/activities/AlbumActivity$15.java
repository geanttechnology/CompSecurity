// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.activities;

import my.googlemusic.play.interfaces.Server;
import my.googlemusic.play.model.User;
import my.googlemusic.play.utils.views.StickyListView;

// Referenced classes of package my.googlemusic.play.activities:
//            AlbumActivity

class this._cls0
    implements Runnable
{

    final AlbumActivity this$0;

    public void run()
    {
        if (!AlbumActivity.access$600(AlbumActivity.this).getUser().isPremium())
        {
            AlbumActivity.access$702(AlbumActivity.this, list.getLastVisiblePosition());
            if (AlbumActivity.access$800(AlbumActivity.this) == 99F)
            {
                AlbumActivity.access$802(AlbumActivity.this, list.getLastVisiblePosition());
            } else
            if (AlbumActivity.access$800(AlbumActivity.this) == AlbumActivity.access$700(AlbumActivity.this))
            {
                list.smoothScrollBy(160, 500);
                return;
            }
        }
    }

    ()
    {
        this$0 = AlbumActivity.this;
        super();
    }
}

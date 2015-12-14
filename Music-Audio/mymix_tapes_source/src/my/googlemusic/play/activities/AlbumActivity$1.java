// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.activities;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import my.googlemusic.play.adapters.album.AlbumAdapter;
import my.googlemusic.play.utils.toast.Toast;
import my.googlemusic.play.utils.toast.ToastCreator;

// Referenced classes of package my.googlemusic.play.activities:
//            AlbumActivity

class this._cls0 extends BroadcastReceiver
{

    final AlbumActivity this$0;

    public void onReceive(Context context, Intent intent)
    {
        context = intent.getStringExtra("EXTRAS");
        if (context != null)
        {
            if (context.equals("DOWNLOAD FINISHED"))
            {
                AlbumActivity.access$000(AlbumActivity.this).notifyDataSetChanged();
            } else
            if (context.equals("DOWNLOAD COMPLETED") && this != null)
            {
                Toast.with(AlbumActivity.this).message("Download complete").show();
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

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.activities;

import my.googlemusic.play.adapters.album.AlbumAdapter;
import my.googlemusic.play.internet.Response;
import my.googlemusic.play.utils.toast.Toast;
import my.googlemusic.play.utils.toast.ToastCreator;

// Referenced classes of package my.googlemusic.play.activities:
//            AlbumActivity

class this._cls0
    implements my.googlemusic.play.interfaces.this._cls0
{

    final AlbumActivity this$0;

    public void onFailure(Response response)
    {
        Toast.with(AlbumActivity.this).message(response.getContent()).show();
    }

    public void onProgress(int i)
    {
    }

    public void onSuccess(Object obj)
    {
        AlbumActivity.access$000(AlbumActivity.this).notifyDataSetChanged();
    }

    ()
    {
        this$0 = AlbumActivity.this;
        super();
    }
}

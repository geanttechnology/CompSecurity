// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.activities;

import java.util.List;
import my.googlemusic.play.internet.Response;
import my.googlemusic.play.model.Album;
import my.googlemusic.play.model.Song;

// Referenced classes of package my.googlemusic.play.activities:
//            AlbumActivity

class this._cls0
    implements my.googlemusic.play.interfaces.this._cls0
{

    final AlbumActivity this$0;

    public void onFailure(Response response)
    {
    }

    public void onProgress(int i)
    {
    }

    public void onSuccess(Object obj)
    {
        if (obj instanceof Album)
        {
            obj = (Album)obj;
            mAlbum = ((Album) (obj));
            AlbumActivity.access$102(AlbumActivity.this, ((Album) (obj)).getSongs());
            ((Album) (obj)).setSongs(null);
            for (int i = 0; i < AlbumActivity.access$100(AlbumActivity.this).size(); i++)
            {
                ((Song)AlbumActivity.access$100(AlbumActivity.this).get(i)).setAlbum(((Album) (obj)));
            }

            updateView();
        }
    }

    ()
    {
        this$0 = AlbumActivity.this;
        super();
    }
}

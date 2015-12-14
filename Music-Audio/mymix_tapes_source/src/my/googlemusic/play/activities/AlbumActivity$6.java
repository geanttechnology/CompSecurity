// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.activities;

import android.content.Intent;
import my.googlemusic.play.interfaces.Player;
import my.googlemusic.play.internet.Response;
import my.googlemusic.play.model.Album;
import my.googlemusic.play.model.Artist;
import my.googlemusic.play.model.Song;

// Referenced classes of package my.googlemusic.play.activities:
//            AlbumActivity

class this._cls0
    implements my.googlemusic.play.interfaces.this._cls0
{

    final AlbumActivity this$0;

    public void onFailure(Response response)
    {
        response = (new StringBuilder()).append("I'm listening to ").append(mAlbum.getArtist().getName()).append("'s ").append(AlbumActivity.access$400(AlbumActivity.this).getCurrentSong().getAlbum().getName()).append(" on #mymixtapez app").toString();
        AlbumActivity.access$300(AlbumActivity.this, response);
    }

    public void onProgress(int i)
    {
    }

    public void onSuccess(Object obj)
    {
        (new Intent("android.intent.action.SEND")).setType("text/plain");
        if (obj instanceof String)
        {
            obj = (String)obj;
        } else
        {
            obj = (new StringBuilder()).append("I'm listening to ").append(mAlbum.getArtist().getName()).append("'s ").append(mAlbum.getName()).append(" on My Mixtapez app http://goo.gl/7dQT59").toString();
        }
        AlbumActivity.access$300(AlbumActivity.this, ((String) (obj)));
    }

    ()
    {
        this$0 = AlbumActivity.this;
        super();
    }
}

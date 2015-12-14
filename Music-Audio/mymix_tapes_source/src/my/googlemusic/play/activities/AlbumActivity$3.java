// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.activities;

import android.widget.TextView;
import java.util.Iterator;
import java.util.List;
import my.googlemusic.play.interfaces.DatabaseCallback;
import my.googlemusic.play.model.Album;
import my.googlemusic.play.model.Artist;
import my.googlemusic.play.utils.appbar.AppBar;

// Referenced classes of package my.googlemusic.play.activities:
//            AlbumActivity

class this._cls0
    implements DatabaseCallback
{

    final AlbumActivity this$0;

    public void onTransactionSuccessful(Object obj)
    {
        for (obj = ((List)obj).iterator(); ((Iterator) (obj)).hasNext();)
        {
            Artist artist = (Artist)((Iterator) (obj)).next();
            StringBuilder stringbuilder = new StringBuilder();
            AlbumActivity albumactivity = AlbumActivity.this;
            albumactivity.artistsFeatures = stringbuilder.append(albumactivity.artistsFeatures).append(", ").append(artist.getName()).toString();
        }

        textArtistFeature.setText(artistsFeatures);
        infoSong.setText((new StringBuilder()).append(AlbumActivity.access$100(AlbumActivity.this).size()).append(" songs").toString());
        textArtist.setText((new StringBuilder()).append("More from ").append(mAlbum.getArtist().getName()).toString());
        if (AlbumActivity.access$100(AlbumActivity.this) != null && AlbumActivity.access$100(AlbumActivity.this).size() != 0)
        {
            appBar.title(artistsFeatures);
        }
    }

    ()
    {
        this$0 = AlbumActivity.this;
        super();
    }
}

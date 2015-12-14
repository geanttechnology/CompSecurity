// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.utils;

import android.app.Activity;
import android.net.Uri;
import java.io.File;
import my.googlemusic.play.application.App;
import my.googlemusic.play.interfaces.Server;
import my.googlemusic.play.model.Album;
import my.googlemusic.play.model.Song;
import my.googlemusic.play.model.User;

public class TwitterUtil
{

    public static final int SHARE_TWITTER = 2;
    private Activity mActivity;
    private Server mServer;

    private TwitterUtil(Activity activity)
    {
        mActivity = activity;
        mServer = ((App)mActivity.getApplication()).getServer();
    }

    private void share(String s, Song song, Uri uri)
    {
        mServer.addLike(song.getAlbum().getId(), mServer.getUser().getId(), 2, new _cls1(s, uri));
    }

    public static TwitterUtil with(Activity activity)
    {
        return new TwitterUtil(activity);
    }

    public void sharePicture(Song song)
    {
        share("text/plain", song, null);
    }

    public void shareVideo(Song song, String s)
    {
        share("video/*", song, Uri.fromFile(new File(s)));
    }


    /* member class not found */
    class _cls1 {}

}

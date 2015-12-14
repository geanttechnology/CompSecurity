// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.utils;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.net.Uri;
import android.util.Base64;
import android.util.Log;
import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import my.googlemusic.play.application.App;
import my.googlemusic.play.interfaces.Server;
import my.googlemusic.play.model.Album;
import my.googlemusic.play.model.Song;
import my.googlemusic.play.model.User;

public class FacebookUtil
{

    public static final int SHARE_FACEBOOK = 1;
    private Activity mActivity;
    private Server mServer;

    private FacebookUtil(Activity activity)
    {
        mActivity = activity;
        mServer = ((App)mActivity.getApplication()).getServer();
    }

    public static String getHashKey(Context context, String s)
    {
        s = context.getPackageManager().getPackageInfo(s, 64);
        context = null;
        int j;
        s = ((PackageInfo) (s)).signatures;
        j = s.length;
        int i = 0;
_L2:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        context = s[i];
        MessageDigest messagedigest = MessageDigest.getInstance("SHA");
        messagedigest.update(context.toByteArray());
        context = new String(Base64.encode(messagedigest.digest(), 0));
        Log.e("hash key", context);
        i++;
        if (true) goto _L2; else goto _L1
        context;
        Log.e("name not found", context.toString());
_L4:
        context = null;
_L1:
        return context;
        context;
        Log.e("no such an algorithm", context.toString());
        continue; /* Loop/switch isn't completed */
        context;
        Log.e("exception", context.toString());
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void share(String s, Song song, Uri uri)
    {
        mServer.addLike(song.getAlbum().getId(), mServer.getUser().getId(), 1, new _cls1(s, uri));
    }

    public static FacebookUtil with(Activity activity)
    {
        return new FacebookUtil(activity);
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

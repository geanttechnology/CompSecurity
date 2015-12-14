// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.activities;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import java.util.List;
import my.googlemusic.play.internet.Response;
import my.googlemusic.play.model.Album;
import my.googlemusic.play.model.Artist;
import my.googlemusic.play.model.Song;
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
        response = new Intent("android.intent.action.SEND");
        response.setType("text/plain");
        response.putExtra("android.intent.extra.TEXT", (new StringBuilder()).append("I'm listening to ").append(AlbumActivity.access$500(AlbumActivity.this).getAlbum().getArtist().getName()).append("'s ").append(AlbumActivity.access$500(AlbumActivity.this).getAlbum().getName()).append(" on My Mixtapez app http://goo.gl/7dQT59").toString());
        startActivity(Intent.createChooser(response, "Share via"));
    }

    public void onProgress(int i)
    {
    }

    public void onSuccess(Object obj)
    {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.TEXT", obj.toString());
        obj = getPackageManager().queryIntentActivities(intent, 0);
        for (int i = 0; i < ((List) (obj)).size(); i++)
        {
            String s = ((ResolveInfo)((List) (obj)).get(i)).activityInfo.packageName;
            if (s.contains("twitter"))
            {
                intent.setPackage(s);
            }
        }

        if (intent.getPackage() != null)
        {
            startActivity(intent);
            return;
        } else
        {
            Toast.with(AlbumActivity.this).message("You don\u2019t have twitter installed").show();
            return;
        }
    }

    ()
    {
        this$0 = AlbumActivity.this;
        super();
    }
}

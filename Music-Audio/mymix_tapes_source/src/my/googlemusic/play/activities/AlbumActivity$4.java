// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.activities;

import android.content.Intent;
import my.googlemusic.play.internet.Response;

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
        if (obj instanceof String)
        {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.SEND");
            intent.setType("text/plain");
            intent.putExtra("android.intent.extra.TEXT", obj.toString());
            intent.setPackage("com.google.android.apps.plus");
            startActivityForResult(Intent.createChooser(intent, "Share using Google+"), 3000);
        }
    }

    ()
    {
        this$0 = AlbumActivity.this;
        super();
    }
}

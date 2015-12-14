// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.activities;

import android.content.Intent;
import com.google.gson.Gson;
import my.googlemusic.play.application.App;
import my.googlemusic.play.interfaces.Server;
import my.googlemusic.play.internet.Response;

// Referenced classes of package my.googlemusic.play.activities:
//            ManagerActivity, AlbumActivity

class this._cls0
    implements my.googlemusic.play.interfaces.this._cls0
{

    final ManagerActivity this$0;

    public void onFailure(Response response)
    {
    }

    public void onProgress(int i)
    {
    }

    public void onSuccess(Object obj)
    {
        Intent intent = new Intent(ManagerActivity.this, my/googlemusic/play/activities/AlbumActivity);
        intent.putExtra("album", App.getGson().toJson(ManagerActivity.access$000(ManagerActivity.this).getAlbum(((Long)obj).longValue())));
        startActivity(intent);
        ManagerActivity.access$102(ManagerActivity.this, null);
    }

    ()
    {
        this$0 = ManagerActivity.this;
        super();
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.activities;

import android.widget.ImageButton;
import my.googlemusic.play.internet.Response;
import my.googlemusic.play.utils.toast.Toast;
import my.googlemusic.play.utils.toast.ToastCreator;

// Referenced classes of package my.googlemusic.play.activities:
//            PlayerActivity

class this._cls0
    implements my.googlemusic.play.interfaces.this._cls0
{

    final PlayerActivity this$0;

    public void onFailure(Response response)
    {
        Toast.with(PlayerActivity.this).message(response.getContent()).show();
        PlayerActivity.access$1000(PlayerActivity.this).favorite.setImageResource(0x7f020078);
    }

    public void onProgress(int i)
    {
    }

    public void onSuccess(Object obj)
    {
        if (!(obj instanceof String));
    }

    ewHolder()
    {
        this$0 = PlayerActivity.this;
        super();
    }
}

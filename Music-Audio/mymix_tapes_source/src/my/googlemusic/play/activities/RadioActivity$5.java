// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.activities;

import android.widget.ImageButton;
import my.googlemusic.play.internet.Response;
import my.googlemusic.play.utils.toast.Toast;
import my.googlemusic.play.utils.toast.ToastCreator;

// Referenced classes of package my.googlemusic.play.activities:
//            RadioActivity

class this._cls0
    implements my.googlemusic.play.interfaces.this._cls0
{

    final RadioActivity this$0;

    public void onFailure(Response response)
    {
        Toast.with(RadioActivity.this).message(response.getContent()).show();
        RadioActivity.access$700(RadioActivity.this).favorite.setImageResource(0x7f020077);
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
        this$0 = RadioActivity.this;
        super();
    }
}

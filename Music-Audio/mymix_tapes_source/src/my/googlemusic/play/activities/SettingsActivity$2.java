// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.activities;

import android.app.Dialog;
import my.googlemusic.play.internet.Response;
import my.googlemusic.play.utils.toast.Toast;
import my.googlemusic.play.utils.toast.ToastCreator;

// Referenced classes of package my.googlemusic.play.activities:
//            SettingsActivity

class this._cls0
    implements my.googlemusic.play.interfaces.this._cls0
{

    final SettingsActivity this$0;

    public void onFailure(Response response)
    {
        if (response.getStatus() == 7)
        {
            Toast.with(SettingsActivity.this).message(response.getContent()).show();
        }
    }

    public void onProgress(int i)
    {
    }

    public void onSuccess(Object obj)
    {
        if (obj instanceof String)
        {
            Toast.with(SettingsActivity.this).message(obj.toString()).show();
            SettingsActivity.access$2900(SettingsActivity.this).cancel();
        }
    }

    ()
    {
        this$0 = SettingsActivity.this;
        super();
    }
}

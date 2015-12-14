// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.activities;

import my.googlemusic.play.internet.Response;
import my.googlemusic.play.model.User;
import my.googlemusic.play.utils.toast.Toast;
import my.googlemusic.play.utils.toast.ToastCreator;

// Referenced classes of package my.googlemusic.play.activities:
//            LoginActivity

class this._cls0
    implements my.googlemusic.play.interfaces.this._cls0
{

    final LoginActivity this$0;

    public void onFailure(Response response)
    {
        if (response.getStatus() == 7)
        {
            Toast.with(LoginActivity.this).message("An error has occurred on our server, try again later").show();
        }
    }

    public void onProgress(int i)
    {
    }

    public void onSuccess(Object obj)
    {
        if (obj instanceof User)
        {
            LoginActivity.access$000(LoginActivity.this);
            Toast.with(LoginActivity.this).message((new StringBuilder()).append("welcome ").append(((User)obj).getName()).toString()).show();
        }
    }

    ()
    {
        this$0 = LoginActivity.this;
        super();
    }
}

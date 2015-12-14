// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.activities;

import android.app.Dialog;
import my.googlemusic.play.interfaces.Server;
import my.googlemusic.play.internet.Response;
import my.googlemusic.play.model.Badge;
import my.googlemusic.play.utils.toast.Toast;
import my.googlemusic.play.utils.toast.ToastCreator;

// Referenced classes of package my.googlemusic.play.activities:
//            BadgeActivity

class this._cls0
    implements my.googlemusic.play.interfaces.this._cls0
{

    final BadgeActivity this$0;

    public void onFailure(Response response)
    {
        Toast.with(BadgeActivity.this).message(response.getContent()).show();
    }

    public void onProgress(int i)
    {
    }

    public void onSuccess(Object obj)
    {
        if (obj instanceof String)
        {
            Toast.with(BadgeActivity.this).message(obj.toString()).show();
            BadgeActivity.access$500(BadgeActivity.this).changeBadge(BadgeActivity.access$800(BadgeActivity.this).getId());
            BadgeActivity.access$900(BadgeActivity.this).dismiss();
            BadgeActivity.access$1000(BadgeActivity.this);
        }
    }

    ()
    {
        this$0 = BadgeActivity.this;
        super();
    }
}

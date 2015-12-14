// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.activities;

import java.io.File;
import my.googlemusic.play.internet.Response;
import my.googlemusic.play.utils.toast.Toast;
import my.googlemusic.play.utils.toast.ToastCreator;

// Referenced classes of package my.googlemusic.play.activities:
//            DabbShareActivity

class val.outputPath
    implements my.googlemusic.play.interfaces.val.outputPath
{

    final DabbShareActivity this$0;
    final String val$outputPath;

    public void onFailure(Response response)
    {
    }

    public void onProgress(int i)
    {
    }

    public void onSuccess(Object obj)
    {
        Toast.with(DabbShareActivity.this).message((String)obj).show();
        DabbShareActivity.access$900(DabbShareActivity.this, new File(val$outputPath));
    }

    ()
    {
        this$0 = final_dabbshareactivity;
        val$outputPath = String.this;
        super();
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.activities;

import android.app.Dialog;
import android.os.Environment;
import com.github.hiteshsondhi88.libffmpeg.FFmpegExecuteResponseHandler;
import com.github.rahatarmanahmed.cpv.CircularProgressView;
import java.io.PrintStream;

// Referenced classes of package my.googlemusic.play.activities:
//            DabbShareActivity

class this._cls0
    implements FFmpegExecuteResponseHandler
{

    final DabbShareActivity this$0;

    public void onFailure(String s)
    {
        if (DabbShareActivity.access$300(DabbShareActivity.this).isShowing())
        {
            DabbShareActivity.access$300(DabbShareActivity.this).dismiss();
        }
    }

    public void onFinish()
    {
    }

    public void onProgress(String s)
    {
        System.out.println(s);
        DabbShareActivity.access$600(DabbShareActivity.this, s);
    }

    public void onStart()
    {
        DabbShareActivity.access$700(DabbShareActivity.this).dialogProgress.setIndeterminate(false);
        DabbShareActivity.access$700(DabbShareActivity.this).dialogProgress.setMaxProgress(DabbShareActivity.access$800(DabbShareActivity.this) + 1);
    }

    public void onSuccess(String s)
    {
        System.out.println((new StringBuilder()).append("terminou video: ").append(System.currentTimeMillis() / 1000L).toString());
        if (DabbShareActivity.access$300(DabbShareActivity.this).isShowing())
        {
            DabbShareActivity.access$300(DabbShareActivity.this).dismiss();
        }
        DabbShareActivity.access$402(DabbShareActivity.this, (new StringBuilder()).append(Environment.getExternalStorageDirectory()).append("/MyMixtapez/").append("temporaryVideo.mp4").toString());
        DabbShareActivity.access$500(DabbShareActivity.this);
    }

    ()
    {
        this$0 = DabbShareActivity.this;
        super();
    }
}

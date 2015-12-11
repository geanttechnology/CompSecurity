// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.renderers.tremor;

import com.tremorvideo.sdk.android.videoad.TremorVideo;
import java.util.Timer;
import java.util.TimerTask;
import tv.freewheel.ad.interfaces.IConstants;
import tv.freewheel.renderers.interfaces.IRendererContext;

// Referenced classes of package tv.freewheel.renderers.tremor:
//            TremorVideoRenderer

class this._cls0 extends TimerTask
{

    final TremorVideoRenderer this$0;

    public void run()
    {
        if (TremorVideo.isAdReady())
        {
            TremorVideoRenderer.access$100(TremorVideoRenderer.this).purge();
            TremorVideoRenderer.access$100(TremorVideoRenderer.this).cancel();
            TremorVideoRenderer.access$102(TremorVideoRenderer.this, null);
            TremorVideoRenderer.access$000(TremorVideoRenderer.this).dispatchEvent(TremorVideoRenderer.access$000(TremorVideoRenderer.this).getConstants().EVENT_AD_LOADED());
        } else
        if (!TremorVideo.isDownloadStarted())
        {
            TremorVideoRenderer.access$200(TremorVideoRenderer.this, TremorVideoRenderer.access$000(TremorVideoRenderer.this).getConstants().ERROR_NO_AD_AVAILABLE(), "Unable to load Ad");
            return;
        }
    }

    ()
    {
        this$0 = TremorVideoRenderer.this;
        super();
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.renderers.millennial;

import android.view.ViewGroup;
import com.millennialmedia.android.MMAdView;
import com.millennialmedia.android.MMAdViewOverlayActivity;
import tv.freewheel.ad.interfaces.IConstants;
import tv.freewheel.ad.interfaces.ISlot;
import tv.freewheel.renderers.interfaces.IRendererContext;
import tv.freewheel.utils.Logger;

// Referenced classes of package tv.freewheel.renderers.millennial:
//            MillennialRenderer

class this._cls0
    implements Runnable
{

    final MillennialRenderer this$0;

    public void run()
    {
        if (MillennialRenderer.access$300(MillennialRenderer.this) != null)
        {
            try
            {
                if (MMAdViewOverlayActivity.getContext() != null)
                {
                    ((MMAdViewOverlayActivity)MMAdViewOverlayActivity.getContext()).finish();
                }
                MillennialRenderer.access$300(MillennialRenderer.this).removeAllViews();
                MillennialRenderer.access$300(MillennialRenderer.this).setVisibility(4);
                MillennialRenderer.access$300(MillennialRenderer.this).setListener(null);
                MillennialRenderer.access$900(MillennialRenderer.this).getBase().removeView(MillennialRenderer.access$300(MillennialRenderer.this));
            }
            catch (Exception exception)
            {
                MillennialRenderer.access$000(MillennialRenderer.this).warn((new StringBuilder()).append("Error when trying to stop MMAdViewOverlayActivity and remove adView: ").append(exception.getMessage()).toString());
            }
        } else
        {
            MillennialRenderer.access$000(MillennialRenderer.this).warn("when stop Millennial ad, the adView is null");
        }
        MillennialRenderer.access$1000(MillennialRenderer.this).dispatchEvent(MillennialRenderer.access$800(MillennialRenderer.this).EVENT_AD_STOPPED());
    }

    ()
    {
        this$0 = MillennialRenderer.this;
        super();
    }
}

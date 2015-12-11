// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.renderers;

import android.util.Log;
import com.liverail.library.events.VPAIDEvent;
import com.liverail.library.events.VPAIDEventListener;
import tv.freewheel.ad.interfaces.IConstants;
import tv.freewheel.renderers.interfaces.IRendererContext;

// Referenced classes of package tv.freewheel.renderers:
//            LiveRailFWRenderer

class this._cls0
    implements VPAIDEventListener
{

    final LiveRailFWRenderer this$0;

    public void onEvent(VPAIDEvent vpaidevent)
    {
        Log.v("LiveRailRenderer", (new StringBuilder("VPAID Event ")).append(vpaidevent.getType()).toString());
        LiveRailFWRenderer.access$4(LiveRailFWRenderer.this, true);
        Log.v("LiveRailRenderer", "Dispatching EVENT_AD_STARTED");
        LiveRailFWRenderer.access$1(LiveRailFWRenderer.this).dispatchEvent(LiveRailFWRenderer.access$1(LiveRailFWRenderer.this).getConstants().EVENT_AD_STARTED());
    }

    ontext()
    {
        this$0 = LiveRailFWRenderer.this;
        super();
    }
}

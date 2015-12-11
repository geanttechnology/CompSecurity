// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.renderers;

import android.util.Log;
import com.liverail.library.events.VPAIDEvent;
import com.liverail.library.events.VPAIDEventListener;

// Referenced classes of package tv.freewheel.renderers:
//            LiveRailFWRenderer

class this._cls0
    implements VPAIDEventListener
{

    final LiveRailFWRenderer this$0;

    public void onEvent(VPAIDEvent vpaidevent)
    {
        Log.v("LiveRailRenderer", (new StringBuilder("VPAID Event ")).append(vpaidevent.getType()).toString());
        LiveRailFWRenderer.access$3(LiveRailFWRenderer.this);
    }

    er()
    {
        this$0 = LiveRailFWRenderer.this;
        super();
    }
}

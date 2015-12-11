// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.renderers;

import android.os.Bundle;
import android.util.Log;
import com.liverail.library.events.VPAIDEvent;
import com.liverail.library.events.VPAIDEventListener;
import java.util.HashMap;
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
        boolean flag = ((Boolean)vpaidevent.getParameter("playerHandles")).booleanValue();
        Object obj = (String)vpaidevent.getParameter("url");
        Object obj1 = (new StringBuilder("VPAID Event ")).append(vpaidevent.getType()).append(" playerHandles=").append(flag).append(" url=");
        if (obj != null)
        {
            vpaidevent = ((VPAIDEvent) (obj));
        } else
        {
            vpaidevent = "null";
        }
        Log.v("LiveRailRenderer", ((StringBuilder) (obj1)).append(vpaidevent).toString());
        if (flag && obj != null && !((String) (obj)).isEmpty())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        vpaidevent = new Bundle();
        vpaidevent.putBoolean(LiveRailFWRenderer.access$5(LiveRailFWRenderer.this).INFO_KEY_SHOW_BROWSER(), flag);
        obj1 = LiveRailFWRenderer.access$5(LiveRailFWRenderer.this).INFO_KEY_URL();
        if (!flag)
        {
            obj = "";
        }
        vpaidevent.putString(((String) (obj1)), ((String) (obj)));
        obj = new HashMap();
        ((HashMap) (obj)).put(LiveRailFWRenderer.access$5(LiveRailFWRenderer.this).INFO_KEY_EXTRA_INFO(), vpaidevent);
        Log.d("LiveRailRenderer", "dispatch EVENT_AD_CLICK ");
        LiveRailFWRenderer.access$1(LiveRailFWRenderer.this).dispatchEvent(LiveRailFWRenderer.access$5(LiveRailFWRenderer.this).EVENT_AD_CLICK(), ((HashMap) (obj)));
    }

    ontext()
    {
        this$0 = LiveRailFWRenderer.this;
        super();
    }
}

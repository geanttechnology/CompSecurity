// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.renderers;

import java.util.HashMap;
import tv.freewheel.ad.interfaces.IConstants;
import tv.freewheel.renderers.interfaces.IRendererContext;

// Referenced classes of package tv.freewheel.renderers:
//            LiveRailFWRenderer

class val.map
    implements Runnable
{

    final LiveRailFWRenderer this$0;
    private final HashMap val$map;

    public void run()
    {
        LiveRailFWRenderer.access$1(LiveRailFWRenderer.this).dispatchEvent(LiveRailFWRenderer.access$5(LiveRailFWRenderer.this).EVENT_ERROR(), val$map);
    }

    ontext()
    {
        this$0 = final_liverailfwrenderer;
        val$map = HashMap.this;
        super();
    }
}

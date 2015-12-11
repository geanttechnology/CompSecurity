// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.renderers.medialets;

import tv.freewheel.ad.interfaces.IConstants;
import tv.freewheel.renderers.interfaces.IActivityCallbackListener;
import tv.freewheel.utils.Logger;
import tv.freewheel.utils.renderer.RendererTimer;

// Referenced classes of package tv.freewheel.renderers.medialets:
//            MedialetsRenderer

class this._cls0
    implements IActivityCallbackListener
{

    final MedialetsRenderer this$0;

    public void onActivityCallback(int i)
    {
        MedialetsRenderer.access$100(MedialetsRenderer.this).debug((new StringBuilder()).append("onActivityStateChange ").append(i).toString());
        if (i == MedialetsRenderer.access$200(MedialetsRenderer.this).ACTIVITY_CALLBACK_RESUME())
        {
            MedialetsRenderer.access$100(MedialetsRenderer.this).info("context activity resumed");
            if (MedialetsRenderer.access$300(MedialetsRenderer.this) != null)
            {
                MedialetsRenderer.access$300(MedialetsRenderer.this).resume();
            }
        } else
        if (i == MedialetsRenderer.access$200(MedialetsRenderer.this).ACTIVITY_CALLBACK_PAUSE())
        {
            MedialetsRenderer.access$100(MedialetsRenderer.this).info("context activity paused");
            if (MedialetsRenderer.access$300(MedialetsRenderer.this) != null)
            {
                MedialetsRenderer.access$300(MedialetsRenderer.this).pause();
                return;
            }
        }
    }

    stener()
    {
        this$0 = MedialetsRenderer.this;
        super();
    }
}

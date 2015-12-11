// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.renderers.medialets;

import tv.freewheel.renderers.interfaces.IRendererContext;

// Referenced classes of package tv.freewheel.renderers.medialets:
//            MedialetsRenderer

class val.contextFinalRef
    implements Runnable
{

    final MedialetsRenderer this$0;
    final IRendererContext val$contextFinalRef;

    public void run()
    {
        MedialetsRenderer.access$000(MedialetsRenderer.this, val$contextFinalRef);
    }

    ()
    {
        this$0 = final_medialetsrenderer;
        val$contextFinalRef = IRendererContext.this;
        super();
    }
}

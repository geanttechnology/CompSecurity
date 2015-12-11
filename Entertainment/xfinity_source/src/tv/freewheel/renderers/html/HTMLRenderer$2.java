// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.renderers.html;

import tv.freewheel.renderers.interfaces.IRendererContext;

// Referenced classes of package tv.freewheel.renderers.html:
//            HTMLRenderer

class Context
    implements Runnable
{

    final HTMLRenderer this$0;
    final IRendererContext val$rendererContextFinalRef;

    public void run()
    {
        HTMLRenderer.access$100(HTMLRenderer.this, val$rendererContextFinalRef);
    }

    Context()
    {
        this$0 = final_htmlrenderer;
        val$rendererContextFinalRef = IRendererContext.this;
        super();
    }
}

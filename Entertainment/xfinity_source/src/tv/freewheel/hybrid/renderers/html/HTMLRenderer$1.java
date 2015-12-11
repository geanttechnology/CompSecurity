// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.hybrid.renderers.html;


// Referenced classes of package tv.freewheel.hybrid.renderers.html:
//            HTMLRenderer

class val.isResized
    implements Runnable
{

    final HTMLRenderer this$0;
    final boolean val$isResized;

    public void run()
    {
        HTMLRenderer.access$000(HTMLRenderer.this, val$isResized);
    }

    ()
    {
        this$0 = final_htmlrenderer;
        val$isResized = Z.this;
        super();
    }
}

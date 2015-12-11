// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.renderers.html;


// Referenced classes of package tv.freewheel.renderers.html:
//            HTMLRenderer

class this._cls0
    implements Runnable
{

    final HTMLRenderer this$0;

    public void run()
    {
        if (HTMLRenderer.access$600(HTMLRenderer.this, AIDState.EXPANDED) || HTMLRenderer.access$600(HTMLRenderer.this, AIDState.RESIZED))
        {
            HTMLRenderer.access$1500(HTMLRenderer.this, AIDState.DEFAULT);
        }
        HTMLRenderer.access$1600(HTMLRenderer.this);
    }

    AIDState()
    {
        this$0 = HTMLRenderer.this;
        super();
    }
}

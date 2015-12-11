// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.renderers.html;


// Referenced classes of package tv.freewheel.renderers.html:
//            HTMLRenderer

class val.description
    implements Runnable
{

    final HTMLRenderer this$0;
    final String val$description;
    final int val$errorCode;

    public void run()
    {
        HTMLRenderer.access$2600(HTMLRenderer.this, val$errorCode, val$description);
    }

    ()
    {
        this$0 = final_htmlrenderer;
        val$errorCode = i;
        val$description = String.this;
        super();
    }
}

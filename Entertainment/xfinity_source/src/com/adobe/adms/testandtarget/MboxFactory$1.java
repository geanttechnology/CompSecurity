// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adobe.adms.testandtarget;


// Referenced classes of package com.adobe.adms.testandtarget:
//            MboxFactory, Mbox

class val.mbox
    implements rgetCallback
{

    final MboxFactory this$0;
    final Mbox val$mbox;

    public volatile void call(Object obj)
    {
        call((String)obj);
    }

    public void call(String s)
    {
        val$mbox.callOnLoadConsumers(s);
    }

    rgetCallback()
    {
        this$0 = final_mboxfactory;
        val$mbox = Mbox.this;
        super();
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adobe.adms.testandtarget;

import java.util.TimerTask;

// Referenced classes of package com.adobe.adms.testandtarget:
//            Mbox, MboxFactory

private static class <init> extends TimerTask
{

    private Mbox _mbox;

    public void run()
    {
        _mbox.getFactory().disable();
        _mbox.callOnLoadConsumers(null);
    }

    private (Mbox mbox)
    {
        _mbox = mbox;
    }

    _mbox(Mbox mbox, _mbox _pmbox)
    {
        this(mbox);
    }
}

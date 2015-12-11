// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.core.sequencing;


// Referenced classes of package com.rdio.android.core.sequencing:
//            ProxySequencerUnit

class this._cls0
    implements Runnable
{

    final ProxySequencerUnit this$0;

    public void run()
    {
        listener.onSequenceReachedEnd(ProxySequencerUnit.this);
    }

    r()
    {
        this$0 = ProxySequencerUnit.this;
        super();
    }
}

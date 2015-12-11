// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.sample.castcompanionlibrary.cast;


// Referenced classes of package com.google.sample.castcompanionlibrary.cast:
//            BaseCastManager

class this._cls0
    implements Runnable
{

    final BaseCastManager this$0;

    public void run()
    {
        reconnectSessionIfPossible(mContext, false, 10);
    }

    ()
    {
        this$0 = BaseCastManager.this;
        super();
    }
}

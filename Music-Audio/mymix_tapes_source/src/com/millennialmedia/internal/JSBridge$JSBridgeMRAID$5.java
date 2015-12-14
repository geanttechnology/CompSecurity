// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal;


// Referenced classes of package com.millennialmedia.internal:
//            JSBridge

class this._cls1
    implements Runnable
{

    final tion this$1;

    public void run()
    {
        if (isInterstitial || currentState.equals("expanded"))
        {
            JSBridge.access$300(_fld0).setOrientation(requestedOrientation);
        }
    }

    ()
    {
        this$1 = this._cls1.this;
        super();
    }
}

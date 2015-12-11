// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.primetime.android.primetime;


// Referenced classes of package com.comcast.playerplatform.primetime.android.primetime:
//            PrimeTimePlayer

class this._cls0
    implements Runnable
{

    final PrimeTimePlayer this$0;

    public void run()
    {
        PrimeTimePlayer.access$1602(PrimeTimePlayer.this, false);
        int _tmp = PrimeTimePlayer.access$1104(PrimeTimePlayer.this);
        if (PrimeTimePlayer.access$000(PrimeTimePlayer.this) != null)
        {
            setAsset(getCurrentChannel(), PrimeTimePlayer.access$1700(PrimeTimePlayer.this), PrimeTimePlayer.access$900(PrimeTimePlayer.this));
        }
    }

    ()
    {
        this$0 = PrimeTimePlayer.this;
        super();
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.sample.castcompanionlibrary.cast;


// Referenced classes of package com.google.sample.castcompanionlibrary.cast:
//            DataCastManager

class this._cls0 extends com.google.android.gms.cast.er.CastListener
{

    final DataCastManager this$0;

    public void onApplicationDisconnected(int i)
    {
        DataCastManager.this.onApplicationDisconnected(i);
    }

    public void onApplicationStatusChanged()
    {
        DataCastManager.this.onApplicationStatusChanged();
    }

    ()
    {
        this$0 = DataCastManager.this;
        super();
    }
}

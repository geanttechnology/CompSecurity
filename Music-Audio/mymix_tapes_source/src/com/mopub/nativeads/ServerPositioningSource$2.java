// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.nativeads;


// Referenced classes of package com.mopub.nativeads:
//            ServerPositioningSource

class this._cls0
    implements com.mopub.volley.._cls2
{

    final ServerPositioningSource this$0;

    public void onResponse(oPubClientPositioning opubclientpositioning)
    {
        ServerPositioningSource.access$100(ServerPositioningSource.this, opubclientpositioning);
    }

    public volatile void onResponse(Object obj)
    {
        onResponse((oPubClientPositioning)obj);
    }

    oPubClientPositioning()
    {
        this$0 = ServerPositioningSource.this;
        super();
    }
}

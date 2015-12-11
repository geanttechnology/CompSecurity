// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.platform.setting;


// Referenced classes of package com.amazon.identity.platform.setting:
//            DCPSettings

class gs.Listener
    implements com.amazon.dcp.settings.IListener
{

    final DCPSettings this$0;
    final gs.Listener val$listener;

    public void onCacheUpdated()
    {
        val$listener.onCacheUpdated();
    }

    gs.Listener()
    {
        this$0 = final_dcpsettings;
        val$listener = gs.Listener.this;
        super();
    }
}

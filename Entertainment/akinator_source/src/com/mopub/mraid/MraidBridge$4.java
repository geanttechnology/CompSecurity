// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mraid;


// Referenced classes of package com.mopub.mraid:
//            MraidBridge

class this._cls0
    implements aidWebView.OnVisibilityChangedListener
{

    final MraidBridge this$0;

    public void onVisibilityChanged(boolean flag)
    {
        if (MraidBridge.access$000(MraidBridge.this) != null)
        {
            MraidBridge.access$000(MraidBridge.this).onVisibilityChanged(flag);
        }
    }

    aidBridgeListener()
    {
        this$0 = MraidBridge.this;
        super();
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mraid;


// Referenced classes of package com.mopub.mraid:
//            MraidController

class this._cls0
    implements com.mopub.common.CloseListener
{

    final MraidController this$0;

    public void onClose()
    {
        handleClose();
    }

    nCloseListener()
    {
        this$0 = MraidController.this;
        super();
    }
}

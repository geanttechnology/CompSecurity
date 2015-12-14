// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.mm.sdk.openapi;

import android.os.Bundle;

// Referenced classes of package com.tencent.mm.sdk.openapi:
//            BaseReq, WXMediaMessage

public class fromBundle extends BaseReq
{

    public WXMediaMessage message;

    final boolean checkArgs()
    {
        if (message == null)
        {
            return false;
        } else
        {
            return message.checkArgs();
        }
    }

    public void fromBundle(Bundle bundle)
    {
        super.fromBundle(bundle);
        message = .fromBundle(bundle);
    }

    public int getType()
    {
        return 4;
    }

    public void toBundle(Bundle bundle)
    {
        Bundle bundle1 = .toBundle(message);
        super.toBundle(bundle1);
        bundle.putAll(bundle1);
    }

    public ()
    {
    }

    public (Bundle bundle)
    {
        fromBundle(bundle);
    }
}

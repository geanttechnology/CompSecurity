// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.mm.sdk.openapi;

import android.os.Bundle;

// Referenced classes of package com.tencent.mm.sdk.openapi:
//            BaseReq

public class fromBundle extends BaseReq
{

    public String username;

    final boolean checkArgs()
    {
        return true;
    }

    public void fromBundle(Bundle bundle)
    {
        super.fromBundle(bundle);
    }

    public int getType()
    {
        return 3;
    }

    public void toBundle(Bundle bundle)
    {
        super.toBundle(bundle);
    }

    public ()
    {
    }

    public (Bundle bundle)
    {
        fromBundle(bundle);
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.mm.sdk.modelmsg;

import android.os.Bundle;
import com.tencent.mm.sdk.modelbase.BaseResp;

// Referenced classes of package com.tencent.mm.sdk.modelmsg:
//            SendMessageToWX

public static class fromBundle extends BaseResp
{

    public boolean checkArgs()
    {
        return true;
    }

    public void fromBundle(Bundle bundle)
    {
        super.fromBundle(bundle);
    }

    public int getType()
    {
        return 2;
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

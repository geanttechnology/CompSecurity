// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.mm.sdk.modelmsg;

import android.os.Bundle;
import com.tencent.mm.sdk.modelbase.BaseReq;

public class fromBundle extends BaseReq
{

    public String username;

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

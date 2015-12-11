// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adobe.mobile;

import atz;

// Referenced classes of package com.adobe.mobile:
//            WearableDataResponse

class success extends WearableDataResponse
{

    protected byte result[];

    protected byte[] getResult()
    {
        return result;
    }

    protected (atz atz1)
    {
        result = atz1.h("Result");
        if (result != null)
        {
            success = true;
        }
    }
}

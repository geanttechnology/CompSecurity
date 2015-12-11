// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.pdp.protectionservices;


// Referenced classes of package com.bestbuy.android.api.lib.models.pdp.protectionservices:
//            ProtectionServiceMatrix

public class ProtectionService
{

    private static final long serialVersionUID = 1L;
    private ProtectionServiceMatrix matrix;

    public ProtectionService()
    {
    }

    public ProtectionServiceMatrix getMatrix()
    {
        return matrix;
    }

    public void setMatrix(ProtectionServiceMatrix protectionservicematrix)
    {
        matrix = protectionservicematrix;
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.content.dm;


// Referenced classes of package com.ebay.common.content.dm:
//            RlProductInfoDataManager

public static interface Info
{

    public abstract void onProdInfoQueryStarted(uery uery);

    public abstract void onProductInfoRetrieved(uery uery, Info info);
}

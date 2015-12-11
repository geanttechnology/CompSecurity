// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.api.init;


// Referenced classes of package com.amazon.retailsearch.android.api.init:
//            RetailSearchAppType

private static class clientId
{

    private String clientId;
    private boolean isAppStoreSupported;

    public clientId setAppStoreSupported(boolean flag)
    {
        isAppStoreSupported = flag;
        return this;
    }



    public (String s)
    {
        clientId = s;
    }
}

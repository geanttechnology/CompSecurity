// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.model;

import java.io.Serializable;

// Referenced classes of package com.ebay.common.model:
//            EbayDetail

public static final class _cls9
    implements Serializable
{

    public String description;
    public String token;

    public String toString()
    {
        return (new StringBuilder(description)).append(":").append(token).append("\n").toString();
    }

    public _cls9()
    {
    }
}

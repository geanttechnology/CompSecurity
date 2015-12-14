// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.signals;

import com.inmobi.commons.core.network.NetworkRequest;
import com.inmobi.commons.core.utilities.uid.d;

public class b extends NetworkRequest
{

    private int d;
    private int e;

    public b(String s, int i, int j, d d1)
    {
        super(com.inmobi.commons.core.network.NetworkRequest.RequestType.POST, s, true, d1);
        d = i;
        e = j;
    }
}

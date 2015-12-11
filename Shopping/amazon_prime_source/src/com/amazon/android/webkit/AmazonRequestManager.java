// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.android.webkit;

import java.util.Map;

public abstract class AmazonRequestManager
{

    public AmazonRequestManager()
    {
    }

    public abstract void fireOutOfBandUrlRequest(AmazonWebKitFactory.OutOfBandResponseListener outofbandresponselistener, String s, String s1, Map map, byte abyte0[]);
}

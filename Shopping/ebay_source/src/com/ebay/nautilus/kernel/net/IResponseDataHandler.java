// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.kernel.net;

import java.io.InputStream;

public interface IResponseDataHandler
{

    public abstract void parse(InputStream inputstream)
        throws Connector.ParseResponseDataException;
}

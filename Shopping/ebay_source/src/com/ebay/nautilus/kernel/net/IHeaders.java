// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.kernel.net;

import java.util.Map;

public interface IHeaders
    extends Iterable
{

    public abstract Map getAllHeaders();

    public abstract String getFirstHeader(String s);

    public abstract String getLastHeader(String s);

    public abstract void setHeader(String s, String s1);
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy;


public interface TJAwardCurrencyListener
{

    public abstract void onAwardCurrencyResponse(String s, int i);

    public abstract void onAwardCurrencyResponseFailure(String s);
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.client.cache;


public interface FailureCache
{

    public abstract int getErrorCount(String s);

    public abstract void increaseErrorCount(String s);

    public abstract void resetErrorCount(String s);
}

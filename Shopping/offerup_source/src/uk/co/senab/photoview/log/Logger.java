// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package uk.co.senab.photoview.log;


public interface Logger
{

    public abstract int d(String s, String s1);

    public abstract int d(String s, String s1, Throwable throwable);

    public abstract int e(String s, String s1);

    public abstract int e(String s, String s1, Throwable throwable);

    public abstract int i(String s, String s1);

    public abstract int i(String s, String s1, Throwable throwable);

    public abstract int v(String s, String s1);

    public abstract int v(String s, String s1, Throwable throwable);

    public abstract int w(String s, String s1);

    public abstract int w(String s, String s1, Throwable throwable);
}

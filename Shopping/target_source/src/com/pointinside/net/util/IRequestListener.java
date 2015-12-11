// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.net.util;


public interface IRequestListener
{

    public abstract void onComplete(Object obj);

    public abstract void onError(Object obj);

    public abstract void onPreExecute(Object obj);

    public abstract void onProgressUpdate(Object obj);
}

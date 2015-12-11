// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.igexin.sdk;


public interface CallbackListener
{

    public abstract void exceptionHandler(Exception exception);

    public abstract void getCallbackData(Object obj);
}

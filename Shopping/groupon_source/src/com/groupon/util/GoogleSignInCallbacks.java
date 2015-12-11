// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;


public interface GoogleSignInCallbacks
{

    public abstract void onGoogleSignInCancel()
        throws RuntimeException;

    public abstract void onGoogleSignInException(Throwable throwable)
        throws RuntimeException;

    public abstract void onGoogleSignInSuccess();
}

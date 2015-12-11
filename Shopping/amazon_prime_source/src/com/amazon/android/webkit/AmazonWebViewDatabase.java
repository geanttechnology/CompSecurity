// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.android.webkit;


public abstract class AmazonWebViewDatabase
{

    public AmazonWebViewDatabase()
    {
    }

    public abstract void clearFormData();

    public abstract void clearHttpAuthUsernamePassword();

    public abstract void clearUsernamePassword();

    public abstract boolean hasFormData();

    public abstract boolean hasHttpAuthUsernamePassword();

    public abstract boolean hasUsernamePassword();
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.auth;


public interface AuthenticationManager
{

    public abstract String getAccountId();

    public abstract String getPFM();

    public abstract boolean hasActiveAccount();
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.communication.authentication;

import java.util.Set;

public interface MapAccountManagerWrapper
{

    public abstract String getAccount();

    public abstract Set getAccounts();

    public abstract String getPrimaryAccount();
}

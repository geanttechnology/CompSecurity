// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.accounts;


public interface MultipleAccountDefinition
{

    public abstract boolean doesAccountHaveMapping(String s, com.amazon.identity.auth.device.api.MultipleAccountManager.AccountMappingType accountmappingtype);

    public transient abstract String getAccountForMapping(com.amazon.identity.auth.device.api.MultipleAccountManager.AccountMappingType aaccountmappingtype[]);

    public transient abstract boolean removeAccountMappings(String s, com.amazon.identity.auth.device.api.MultipleAccountManager.AccountMappingType aaccountmappingtype[]);

    public transient abstract boolean setAccountMappings(String s, com.amazon.identity.auth.device.api.MultipleAccountManager.AccountMappingType aaccountmappingtype[]);
}

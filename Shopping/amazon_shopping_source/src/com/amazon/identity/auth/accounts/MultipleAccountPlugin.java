// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.accounts;

import android.content.Intent;
import android.os.Bundle;
import java.util.Set;

public interface MultipleAccountPlugin
{

    public abstract void addDataOnAddAccount(String s, Bundle bundle, Bundle bundle1);

    public abstract boolean deregisterAllAccountsOnAccountRemoval(String s);

    public abstract com.amazon.identity.auth.device.api.MultipleAccountManager.AccountMappingType[] getAccountHierarchy(String s, int i);

    public abstract String getVisibleUser();

    public abstract void notifyToolbarOfUserChanged(String s, Intent intent, String s1);

    public abstract void sendAccountRemovalBroadcast(String s, Set set, Intent intent, String s1);

    public abstract void sendBroadcast(String s, Intent intent, String s1);

    public abstract void sendBroadcastToMainUser(String s, Intent intent, String s1);
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.auth.mapr5;

import android.content.Context;
import android.os.Bundle;
import com.amazon.gallery.framework.kindle.auth.AuthenticationManager;
import com.amazon.identity.auth.device.api.CustomerAttributeStore;
import com.amazon.identity.auth.device.api.MAPAccountManager;
import com.amazon.identity.auth.device.api.MAPInit;

public class MAPR5AuthenticationManager
    implements AuthenticationManager
{

    private final MAPAccountManager accountManager;
    private final CustomerAttributeStore customerAttStore;

    public MAPR5AuthenticationManager(Context context)
    {
        MAPInit.getInstance(context).initialize();
        accountManager = new MAPAccountManager(context);
        customerAttStore = CustomerAttributeStore.getInstance(context);
    }

    public String getAccountId()
    {
        return accountManager.getAccount();
    }

    public String getPFM()
    {
        Bundle bundle = customerAttStore.peekAttribute(getAccountId(), "PFM");
        if (bundle.containsKey("error_code_key"))
        {
            return null;
        } else
        {
            return CustomerAttributeStore.getValueOrAttributeDefault(bundle);
        }
    }

    public boolean hasActiveAccount()
    {
        return accountManager.getAccount() != null;
    }
}

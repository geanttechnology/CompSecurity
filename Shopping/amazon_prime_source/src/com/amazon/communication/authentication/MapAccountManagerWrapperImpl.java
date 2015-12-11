// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.communication.authentication;

import android.content.Context;
import com.amazon.identity.auth.device.api.MAPAccountManager;
import java.util.Set;

// Referenced classes of package com.amazon.communication.authentication:
//            MapAccountManagerWrapper

public class MapAccountManagerWrapperImpl
    implements MapAccountManagerWrapper
{

    private final MAPAccountManager mAccountManager;

    public MapAccountManagerWrapperImpl(Context context)
    {
        mAccountManager = new MAPAccountManager(context);
    }

    public String getAccount()
    {
        return mAccountManager.getAccount();
    }

    public Set getAccounts()
    {
        return mAccountManager.getAccounts();
    }

    public String getPrimaryAccount()
    {
        return mAccountManager.getPrimaryAccount();
    }
}

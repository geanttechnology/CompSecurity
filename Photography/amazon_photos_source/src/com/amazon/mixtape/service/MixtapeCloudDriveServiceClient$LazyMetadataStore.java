// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mixtape.service;

import android.content.Context;
import com.amazon.mixtape.account.AccountContextFactory;
import com.amazon.mixtape.account.MetadataStore;
import com.amazon.mixtape.utils.Lazy;

// Referenced classes of package com.amazon.mixtape.service:
//            MixtapeCloudDriveServiceClient

private static class <init> extends Lazy
{

    private final String accountId;
    private final String cloudNodeProviderAuthority;
    private final Context context;

    protected MetadataStore instantiateItem()
    {
        return AccountContextFactory.getContextForAccountId(context, accountId).taStore(cloudNodeProviderAuthority);
    }

    protected volatile Object instantiateItem()
    {
        return instantiateItem();
    }

    private Q(Context context1, String s, String s1)
    {
        context = context1;
        accountId = s;
        cloudNodeProviderAuthority = s1;
    }

    cloudNodeProviderAuthority(Context context1, String s, String s1, cloudNodeProviderAuthority cloudnodeproviderauthority)
    {
        this(context1, s, s1);
    }
}

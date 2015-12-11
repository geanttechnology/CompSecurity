// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.crash;

import com.amazon.device.crashmanager.Domain;
import com.amazon.device.crashmanager.DomainChooser;

public class ProdDomainChooser
    implements DomainChooser
{

    public ProdDomainChooser()
    {
    }

    public Domain chooseDomain()
    {
        return Domain.PROD;
    }
}

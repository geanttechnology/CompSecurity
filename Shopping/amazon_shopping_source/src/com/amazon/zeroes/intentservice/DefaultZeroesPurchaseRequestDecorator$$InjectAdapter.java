// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.zeroes.intentservice;

import dagger.internal.Binding;
import javax.inject.Provider;

// Referenced classes of package com.amazon.zeroes.intentservice:
//            DefaultZeroesPurchaseRequestDecorator

public final class  extends Binding
    implements Provider
{

    public DefaultZeroesPurchaseRequestDecorator get()
    {
        return new DefaultZeroesPurchaseRequestDecorator();
    }

    public volatile Object get()
    {
        return get();
    }

    public ()
    {
        super("com.amazon.zeroes.intentservice.DefaultZeroesPurchaseRequestDecorator", "members/com.amazon.zeroes.intentservice.DefaultZeroesPurchaseRequestDecorator", false, com/amazon/zeroes/intentservice/DefaultZeroesPurchaseRequestDecorator);
    }
}

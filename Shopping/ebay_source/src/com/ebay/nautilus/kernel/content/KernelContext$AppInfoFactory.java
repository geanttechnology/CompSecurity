// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.kernel.content;

import android.content.Context;
import com.ebay.nautilus.kernel.NautilusKernel;

// Referenced classes of package com.ebay.nautilus.kernel.content:
//            KernelContext, EbayContext, EbayAppInfo

private static final class <init> extends <init>
{

    public EbayAppInfo create(EbayContext ebaycontext)
    {
        return NautilusKernel.getAppInfo((Context)ebaycontext.getExtension(android/content/Context));
    }

    public volatile Object create(EbayContext ebaycontext)
    {
        return create(ebaycontext);
    }

    private ()
    {
    }

    ( )
    {
        this();
    }
}

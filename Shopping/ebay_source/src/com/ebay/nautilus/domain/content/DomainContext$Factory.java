// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content;

import android.content.SharedPreferences;
import com.ebay.nautilus.domain.EbayAppCredentials;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.kernel.content.ResultStatus;

// Referenced classes of package com.ebay.nautilus.domain.content:
//            DomainContext

public static interface 
{

    public abstract EbayAppCredentials createApplicationCredentials(EbayContext ebaycontext);

    public abstract SharedPreferences getDomainSharedPreferences();

    public abstract void rewriteServiceErrors(EbayContext ebaycontext, ResultStatus resultstatus);
}

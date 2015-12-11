// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

// Referenced classes of package com.ebay.nautilus.domain.net:
//            EbayDateUtils

static final class  extends ThreadLocal
{

    protected volatile Object initialValue()
    {
        return initialValue();
    }

    protected DateFormat initialValue()
    {
        return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'.'SSS".substring(0, 10), Locale.US);
    }

    ()
    {
    }
}

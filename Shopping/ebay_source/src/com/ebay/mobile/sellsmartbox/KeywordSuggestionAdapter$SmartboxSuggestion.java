// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.sellsmartbox;

import java.io.Serializable;

// Referenced classes of package com.ebay.mobile.sellsmartbox:
//            KeywordSuggestionAdapter

public static final class requestId
    implements Serializable
{

    public long requestId;
    public String title;

    public String toString()
    {
        return title;
    }

    public ()
    {
        requestId = 0L;
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal;

import android.text.TextUtils;
import java.security.InvalidParameterException;

// Referenced classes of package com.millennialmedia.internal:
//            PlayList

private static class itemId
{

    final String itemId;

    protected (String s)
    {
        if (TextUtils.isEmpty(s))
        {
            throw new InvalidParameterException("itemId is required");
        } else
        {
            itemId = s;
            return;
        }
    }
}

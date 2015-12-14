// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal;

import android.text.TextUtils;
import java.security.InvalidParameterException;

// Referenced classes of package com.millennialmedia.internal:
//            PlayList

public static class url extends url
{

    public String postBody;
    public String postContentType;
    final String url;
    public String validateRegex;

    public (String s, String s1)
    {
        super(s);
        if (TextUtils.isEmpty(s1))
        {
            throw new InvalidParameterException("url is required");
        } else
        {
            url = s1;
            return;
        }
    }
}

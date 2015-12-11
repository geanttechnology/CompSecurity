// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship.js;

import android.net.Uri;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package com.urbanairship.js:
//            Whitelist

class path
{

    private final Pattern host;
    private final Pattern path;
    private final Pattern scheme;
    final Whitelist this$0;

    boolean matches(Uri uri)
    {
        while (scheme != null && (uri.getScheme() == null || !scheme.matcher(uri.getScheme()).matches()) || host != null && (uri.getHost() == null || !host.matcher(uri.getHost()).matches()) || path != null && (uri.getPath() == null || !path.matcher(uri.getPath()).matches())) 
        {
            return false;
        }
        return true;
    }

    (Pattern pattern, Pattern pattern1, Pattern pattern2)
    {
        this$0 = Whitelist.this;
        super();
        scheme = pattern;
        host = pattern1;
        path = pattern2;
    }
}

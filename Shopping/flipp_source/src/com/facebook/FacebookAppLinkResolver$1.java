// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook;

import a.c;
import a.g;
import a.h;
import android.net.Uri;
import java.util.Map;

// Referenced classes of package com.facebook:
//            FacebookAppLinkResolver

class val.uri
    implements g
{

    final FacebookAppLinkResolver this$0;
    final Uri val$uri;

    public c then(h h1)
    {
        return (c)((Map)h1.d()).get(val$uri);
    }

    public volatile Object then(h h1)
    {
        return then(h1);
    }

    ()
    {
        this$0 = final_facebookapplinkresolver;
        val$uri = Uri.this;
        super();
    }
}

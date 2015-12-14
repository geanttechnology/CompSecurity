// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook;

import a.a;
import a.c;
import a.e;
import android.net.Uri;
import java.util.Map;

// Referenced classes of package com.facebook:
//            FacebookAppLinkResolver

class val.uri
    implements c
{

    final FacebookAppLinkResolver this$0;
    final Uri val$uri;

    public a then(e e1)
    {
        return (a)((Map)e1.e()).get(val$uri);
    }

    public volatile Object then(e e1)
    {
        return then(e1);
    }

    ()
    {
        this$0 = final_facebookapplinkresolver;
        val$uri = Uri.this;
        super();
    }
}

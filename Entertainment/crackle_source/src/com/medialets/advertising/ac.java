// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.medialets.advertising;

import android.content.Context;
import org.apache.http.client.ResponseHandler;

// Referenced classes of package com.medialets.advertising:
//            DataSource, ad, ag

final class ac extends DataSource
{

    public ac(Context context, ag ag)
    {
        setContext(context);
        a("http://a.medialytics.com/ad");
        setDataStore(ag);
    }

    protected final ResponseHandler getResponseHandler()
    {
        return new ad(this);
    }
}

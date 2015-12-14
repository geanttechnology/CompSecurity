// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.framework;

import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.net.Uri;

// Referenced classes of package com.amazon.identity.auth.device.framework:
//            ContentProviderClientCallback, SecureContentResolver

class val.values
    implements ContentProviderClientCallback
{

    final SecureContentResolver this$0;
    final Uri val$url;
    final ContentValues val$values;

    public volatile Object useContentProviderClient(ContentProviderClient contentproviderclient)
        throws Exception
    {
        return useContentProviderClient$4951ae5c();
    }

    public Uri useContentProviderClient$4951ae5c()
        throws Exception
    {
        return SecureContentResolver.access$000(SecureContentResolver.this).insert(val$url, val$values);
    }

    lback()
    {
        this$0 = final_securecontentresolver;
        val$url = uri;
        val$values = ContentValues.this;
        super();
    }
}

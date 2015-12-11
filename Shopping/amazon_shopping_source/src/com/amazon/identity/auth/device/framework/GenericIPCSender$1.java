// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.framework;

import android.content.ContentProviderClient;
import android.database.Cursor;
import android.os.Bundle;
import android.os.RemoteException;
import com.amazon.identity.auth.device.utils.DBUtils;
import com.amazon.identity.auth.device.utils.ParcelUtils;

// Referenced classes of package com.amazon.identity.auth.device.framework:
//            ContentProviderClientCallback, GenericIPCSender

class val.command
    implements ContentProviderClientCallback
{

    final GenericIPCSender this$0;
    final String val$command;

    public Bundle useContentProviderClient(ContentProviderClient contentproviderclient)
        throws RemoteException
    {
        contentproviderclient = contentproviderclient.query(GenericIPCSender.GENERIC_IPC_URI, GenericIPCSender.access$500(), val$command, null, null);
        if (contentproviderclient != null)
        {
            break MISSING_BLOCK_LABEL_44;
        }
        throw new RuntimeException("Got a null cursor calling Generic IPC central store.");
        Exception exception;
        exception;
        if (contentproviderclient != null)
        {
            contentproviderclient.close();
        }
        throw exception;
        Bundle bundle;
        if (!contentproviderclient.moveToFirst())
        {
            throw new RuntimeException("Got an empty cursor calling Generic IPC central store.");
        }
        bundle = ParcelUtils.stringToBundle(DBUtils.getString(contentproviderclient, "bundle_value"));
        if (bundle != null)
        {
            break MISSING_BLOCK_LABEL_87;
        }
        throw new RuntimeException("Corrupted value returned.");
        if (contentproviderclient != null)
        {
            contentproviderclient.close();
        }
        return bundle;
    }

    public volatile Object useContentProviderClient(ContentProviderClient contentproviderclient)
        throws Exception
    {
        return useContentProviderClient(contentproviderclient);
    }

    ntCallback()
    {
        this$0 = final_genericipcsender;
        val$command = String.this;
        super();
    }
}

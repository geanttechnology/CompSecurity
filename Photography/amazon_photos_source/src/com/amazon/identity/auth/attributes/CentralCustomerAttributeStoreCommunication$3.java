// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.attributes;

import android.content.ContentProviderClient;
import android.database.Cursor;
import android.os.Bundle;
import android.os.RemoteException;
import com.amazon.identity.auth.device.framework.ContentProviderClientCallback;
import java.util.List;

// Referenced classes of package com.amazon.identity.auth.attributes:
//            CentralCustomerAttributeStoreCommunication

class val.command
    implements ContentProviderClientCallback
{

    final CentralCustomerAttributeStoreCommunication this$0;
    final String val$command;

    public Bundle useContentProviderClient(ContentProviderClient contentproviderclient)
        throws RemoteException
    {
        contentproviderclient = contentproviderclient.query(CentralCustomerAttributeStoreCommunication.CUSTOMER_ATTRIBUTE_STORE_URI, (String[])CentralCustomerAttributeStoreCommunication.COLUMNS.toArray(new String[0]), val$command, null, null);
        Bundle bundle = CentralCustomerAttributeStoreCommunication.parseCursor(contentproviderclient, val$command);
        if (contentproviderclient != null)
        {
            contentproviderclient.close();
        }
        return bundle;
        Exception exception;
        exception;
        if (contentproviderclient != null)
        {
            contentproviderclient.close();
        }
        throw exception;
    }

    public volatile Object useContentProviderClient(ContentProviderClient contentproviderclient)
        throws Exception
    {
        return useContentProviderClient(contentproviderclient);
    }

    ()
    {
        this$0 = final_centralcustomerattributestorecommunication;
        val$command = String.this;
        super();
    }
}

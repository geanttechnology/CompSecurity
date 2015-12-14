// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.storage;

import android.content.ContentProviderClient;
import android.database.Cursor;
import android.net.Uri;
import com.amazon.identity.auth.device.framework.ContentProviderClientCallback;
import com.amazon.identity.auth.device.utils.DBHelpers;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.amazon.identity.auth.device.storage:
//            RemoteAmazonDataStorage, MAPInformationProviderHelpers

class val.getBulkDataUri
    implements ContentProviderClientCallback
{

    final RemoteAmazonDataStorage this$0;
    final Uri val$getBulkDataUri;

    public volatile Object useContentProviderClient(ContentProviderClient contentproviderclient)
        throws Exception
    {
        return useContentProviderClient(contentproviderclient);
    }

    public Collection useContentProviderClient(ContentProviderClient contentproviderclient)
        throws Exception
    {
        ContentProviderClient contentproviderclient1 = null;
        contentproviderclient = contentproviderclient.query(val$getBulkDataUri, (String[])MAPInformationProviderHelpers.QUERY_BULK_DATA_COLUMNS.toArray(new String[0]), null, null, null);
        if (contentproviderclient == null)
        {
            DBHelpers.closeCursor(contentproviderclient);
            return null;
        }
        contentproviderclient1 = contentproviderclient;
        LinkedList linkedlist = new LinkedList();
        contentproviderclient1 = contentproviderclient;
        boolean flag = contentproviderclient.moveToFirst();
        if (!flag)
        {
            DBHelpers.closeCursor(contentproviderclient);
            return linkedlist;
        }
_L4:
        contentproviderclient1 = contentproviderclient;
        HashMap hashmap = new HashMap();
        contentproviderclient1 = contentproviderclient;
        Iterator iterator = MAPInformationProviderHelpers.QUERY_BULK_DATA_COLUMNS.iterator();
_L2:
        contentproviderclient1 = contentproviderclient;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_158;
        }
        contentproviderclient1 = contentproviderclient;
        String s = (String)iterator.next();
        contentproviderclient1 = contentproviderclient;
        String s1 = DBHelpers.getString(contentproviderclient, s);
        if (s == null) goto _L2; else goto _L1
_L1:
        contentproviderclient1 = contentproviderclient;
        hashmap.put(s, s1);
          goto _L2
        contentproviderclient;
        DBHelpers.closeCursor(contentproviderclient1);
        throw contentproviderclient;
        contentproviderclient1 = contentproviderclient;
        linkedlist.add(hashmap);
        contentproviderclient1 = contentproviderclient;
        flag = contentproviderclient.moveToNext();
        if (!flag)
        {
            DBHelpers.closeCursor(contentproviderclient);
            return linkedlist;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    ers()
    {
        this$0 = final_remoteamazondatastorage;
        val$getBulkDataUri = Uri.this;
        super();
    }
}

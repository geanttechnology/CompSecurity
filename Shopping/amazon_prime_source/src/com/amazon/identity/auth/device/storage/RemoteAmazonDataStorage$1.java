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
        contentproviderclient = contentproviderclient.query(val$getBulkDataUri, (String[])MAPInformationProviderHelpers.QUERY_BULK_DATA_COLUMNS.toArray(new String[0]), null, null, null);
        if (contentproviderclient == null)
        {
            return null;
        }
        Object obj;
        boolean flag;
        obj = new LinkedList();
        flag = contentproviderclient.moveToFirst();
        if (!flag)
        {
            DBHelpers.closeCursor(contentproviderclient);
            return ((Collection) (obj));
        }
_L4:
        HashMap hashmap;
        Iterator iterator;
        hashmap = new HashMap();
        iterator = MAPInformationProviderHelpers.QUERY_BULK_DATA_COLUMNS.iterator();
_L2:
        String s;
        String s1;
        do
        {
            if (!iterator.hasNext())
            {
                break MISSING_BLOCK_LABEL_134;
            }
            s = (String)iterator.next();
            s1 = DBHelpers.getString(contentproviderclient, s);
        } while (s == null);
        hashmap.put(s, s1);
        if (true) goto _L2; else goto _L1
_L1:
        obj;
        DBHelpers.closeCursor(contentproviderclient);
        throw obj;
        ((Collection) (obj)).add(hashmap);
        flag = contentproviderclient.moveToNext();
        if (!flag)
        {
            DBHelpers.closeCursor(contentproviderclient);
            return ((Collection) (obj));
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

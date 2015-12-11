// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.storage;

import com.amazon.identity.auth.device.utils.JSONHelpers;
import com.amazon.identity.auth.device.utils.MAPLog;
import com.amazon.identity.auth.device.utils.ParcelUtils;
import com.amazon.identity.auth.device.utils.TimeUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import org.json.JSONException;

// Referenced classes of package com.amazon.identity.auth.device.storage:
//            RemoteAmazonDataStorage

private static final class selectionArgs
{

    public final String selection;
    public final String selectionArgs[];

    private static void addValueToSelection(LinkedHashMap linkedhashmap, List list, String s, String s1)
        throws JSONException
    {
        if (s1 == null)
        {
            return;
        } else
        {
            linkedhashmap.put(s, "?");
            list.add(s1);
            return;
        }
    }

    public static selectionArgs create(String s, String s1, String s2, String s3, Date date)
    {
        try
        {
            LinkedHashMap linkedhashmap = new LinkedHashMap();
            ArrayList arraylist = new ArrayList();
            addValueToSelection(linkedhashmap, arraylist, "directedId", s);
            addValueToSelection(linkedhashmap, arraylist, "key", s1);
            addValueToSelection(linkedhashmap, arraylist, "value", s2);
            addValueToSelection(linkedhashmap, arraylist, "namespace", s3);
            addValueToSelection(linkedhashmap, arraylist, "timestamp_key", TimeUtil.serialize(date));
            s = new <init>(JSONHelpers.toJsonString(linkedhashmap), (String[])arraylist.toArray(new String[0]));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            MAPLog.e(RemoteAmazonDataStorage.access$000(), (new StringBuilder("Error consturcting selection. Error: ")).append(s.getMessage()).toString());
            return null;
        }
        return s;
    }

    public static <init> create(Collection collection)
    {
        try
        {
            LinkedHashMap linkedhashmap = new LinkedHashMap();
            ArrayList arraylist = new ArrayList();
            addValueToSelection(linkedhashmap, arraylist, "bulk_data", ParcelUtils.listOfMapOfStringsToString(collection));
            collection = new <init>(JSONHelpers.toJsonString(linkedhashmap), (String[])arraylist.toArray(new String[0]));
        }
        // Misplaced declaration of an exception variable
        catch (Collection collection)
        {
            MAPLog.e(RemoteAmazonDataStorage.access$000(), (new StringBuilder("Error consturcting selection. Error: ")).append(collection.getMessage()).toString());
            return null;
        }
        return collection;
    }

    private (String s, String as[])
    {
        selection = s;
        selectionArgs = as;
    }
}

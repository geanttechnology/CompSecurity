// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.storage;

import com.amazon.identity.auth.device.utils.JSONHelpers;
import com.amazon.identity.auth.device.utils.ParcelUtils;
import com.amazon.identity.auth.device.utils.TimeUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

// Referenced classes of package com.amazon.identity.auth.device.storage:
//            RemoteAmazonDataStorage

private static final class selectionArgs
{

    public final String selection;
    public final String selectionArgs[];

    private static void addValueToSelection(LinkedHashMap linkedhashmap, List list, String s, String s1)
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

    public static selectionArgs create(Collection collection)
    {
        LinkedHashMap linkedhashmap = new LinkedHashMap();
        ArrayList arraylist = new ArrayList();
        addValueToSelection(linkedhashmap, arraylist, "bulk_data", ParcelUtils.listOfMapOfStringsToString(collection));
        return new <init>(JSONHelpers.toJsonString(linkedhashmap), (String[])arraylist.toArray(new String[0]));
    }

    public static <init> create$86a8b1c(String s, String s1, Date date)
    {
        LinkedHashMap linkedhashmap = new LinkedHashMap();
        ArrayList arraylist = new ArrayList();
        addValueToSelection(linkedhashmap, arraylist, "directedId", s);
        addValueToSelection(linkedhashmap, arraylist, "key", s1);
        addValueToSelection(linkedhashmap, arraylist, "value", null);
        addValueToSelection(linkedhashmap, arraylist, "namespace", null);
        addValueToSelection(linkedhashmap, arraylist, "timestamp_key", TimeUtil.serialize(date));
        return new <init>(JSONHelpers.toJsonString(linkedhashmap), (String[])arraylist.toArray(new String[0]));
    }

    private (String s, String as[])
    {
        selection = s;
        selectionArgs = as;
    }
}

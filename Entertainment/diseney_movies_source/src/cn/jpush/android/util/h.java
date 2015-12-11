// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.jpush.android.util;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;

public final class h
{

    public static ArrayList a(JSONArray jsonarray)
    {
        ArrayList arraylist = new ArrayList();
        if (jsonarray == null || jsonarray.length() == 0)
        {
            return arraylist;
        }
        for (int i = 0; i < jsonarray.length(); i++)
        {
            String s = jsonarray.optString(i);
            if (!TextUtils.isEmpty(s))
            {
                arraylist.add(s);
            }
        }

        return arraylist;
    }

    public static JSONArray a(ArrayList arraylist)
    {
        JSONArray jsonarray = new JSONArray();
        for (arraylist = arraylist.iterator(); arraylist.hasNext(); jsonarray.put((String)arraylist.next())) { }
        return jsonarray;
    }
}

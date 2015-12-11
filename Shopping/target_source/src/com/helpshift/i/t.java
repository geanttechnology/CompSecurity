// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.helpshift.i;

import android.util.Log;
import android.util.Pair;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class t
{

    private static final List a = Arrays.asList(new Pair[] {
        new Pair("admin", "txt"), new Pair("admin", "rsc"), new Pair("admin", "rar"), new Pair("admin", "rfr"), new Pair("admin", "admin_attachment_image"), new Pair("admin", "admin_attachment_generic"), new Pair("mobile", "txt"), new Pair("mobile", "ncr"), new Pair("mobile", "sc"), new Pair("mobile", "ar")
    });
    private static final List b = Arrays.asList(new Pair[] {
        new Pair("admin", "rfr"), new Pair("mobile", "ra"), new Pair("mobile", "rj")
    });

    public static boolean a(String s, String s1)
    {
        return a.contains(new Pair(s, s1));
    }

    public static boolean a(JSONArray jsonarray, int i, String s)
    {
        boolean flag1 = false;
_L2:
        boolean flag;
        flag = flag1;
        if (i >= jsonarray.length())
        {
            break MISSING_BLOCK_LABEL_82;
        }
        JSONObject jsonobject = jsonarray.getJSONObject(i);
        String s1 = jsonobject.getString("origin");
        String s2 = jsonobject.getString("type");
        if (!s1.equals("mobile") || !s2.equals("ra"))
        {
            break MISSING_BLOCK_LABEL_95;
        }
        flag = jsonobject.getJSONObject("meta").getString("refers").equals(s);
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_95;
        }
        flag = true;
        return flag;
        JSONException jsonexception;
        jsonexception;
        Log.d("HelpShiftDebug", "isRfrAccepted", jsonexception);
        i++;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public static boolean b(String s, String s1)
    {
        return b.contains(new Pair(s, s1));
    }

}

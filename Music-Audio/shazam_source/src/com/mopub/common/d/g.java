// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.common.d;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;
import org.json.JSONTokener;

public final class g
{

    public static Map a(String s)
    {
        HashMap hashmap = new HashMap();
        if (TextUtils.isEmpty(s))
        {
            return hashmap;
        }
        s = (JSONObject)(new JSONTokener(s)).nextValue();
        String s1;
        for (Iterator iterator = s.keys(); iterator.hasNext(); hashmap.put(s1, s.getString(s1)))
        {
            s1 = (String)iterator.next();
        }

        return hashmap;
    }
}

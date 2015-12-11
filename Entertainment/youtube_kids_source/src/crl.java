// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.client.methods.HttpUriRequest;

public final class crl
    implements cno, cqs, crc
{

    private final SharedPreferences a;

    public crl(SharedPreferences sharedpreferences)
    {
        a = (SharedPreferences)b.a(sharedpreferences);
    }

    public final void a(dwa dwa1)
    {
        if (!TextUtils.isEmpty(dwa1.a))
        {
            String s = a.getString("visitor_id", null);
            if (!dwa1.a.equals(s))
            {
                a.edit().putString("visitor_id", dwa1.a).apply();
            }
        }
    }

    public final void a(Map map, cra cra)
    {
        cra = a.getString("visitor_id", null);
        if (cra != null)
        {
            map.put("X-Goog-Visitor-Id", cra);
        }
    }

    public final void a(HttpUriRequest httpurirequest)
    {
        HashMap hashmap = new HashMap();
        a(((Map) (hashmap)), null);
        if (hashmap.containsKey("X-Goog-Visitor-Id"))
        {
            httpurirequest.addHeader("X-Goog-Visitor-Id", (String)hashmap.get("X-Goog-Visitor-Id"));
        }
    }
}

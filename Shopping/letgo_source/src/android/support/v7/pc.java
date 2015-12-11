// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import com.google.android.gms.ads.internal.util.client.zzb;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package android.support.v7:
//            ox, ua, ul

public class pc
    implements ox
{

    final HashMap a = new HashMap();

    public pc()
    {
    }

    public Future a(String s)
    {
        ua ua1 = new ua();
        a.put(s, ua1);
        return ua1;
    }

    public void a(String s, String s1)
    {
        ua ua1;
        zzb.zzaC("Received ad from the cache.");
        ua1 = (ua)a.get(s);
        if (ua1 == null)
        {
            zzb.e("Could not find the ad request for the corresponding ad response.");
            return;
        }
        ua1.b(new JSONObject(s1));
        a.remove(s);
        return;
        s1;
        zzb.zzb("Failed constructing JSON object from value passed from javascript", s1);
        ua1.b(null);
        a.remove(s);
        return;
        s1;
        a.remove(s);
        throw s1;
    }

    public void b(String s)
    {
        ua ua1 = (ua)a.get(s);
        if (ua1 == null)
        {
            zzb.e("Could not find the ad request for the corresponding ad response.");
            return;
        }
        if (!ua1.isDone())
        {
            ua1.cancel(true);
        }
        a.remove(s);
    }

    public void zza(ul ul, Map map)
    {
        a((String)map.get("request_id"), (String)map.get("fetched_ad"));
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.overlay.d;
import com.google.android.gms.ads.internal.p;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.b;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.google.android.gms.d:
//            cm, cq, ce, he, 
//            o, k, ay, ax, 
//            p, gm, gt, gi, 
//            gl

public final class cd
{

    public static final ce a = new ce() {

        public final void a(he he, Map map)
        {
        }

    };
    public static final ce b = new ce() {

        public final void a(he he1, Map map)
        {
            map = (String)map.get("urls");
            if (TextUtils.isEmpty(map))
            {
                com.google.android.gms.ads.internal.util.client.b.a(5);
                return;
            }
            String as[] = map.split(",");
            HashMap hashmap = new HashMap();
            PackageManager packagemanager = he1.getContext().getPackageManager();
            int j1 = as.length;
            int i1 = 0;
            while (i1 < j1) 
            {
                String s = as[i1];
                map = s.split(";", 2);
                String s1 = map[0].trim();
                boolean flag;
                if (map.length > 1)
                {
                    map = map[1].trim();
                } else
                {
                    map = "android.intent.action.VIEW";
                }
                if (packagemanager.resolveActivity(new Intent(map, Uri.parse(s1)), 0x10000) != null)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                hashmap.put(s, Boolean.valueOf(flag));
                i1++;
            }
            he1.a("openableURLs", hashmap);
        }

    };
    public static final ce c = new ce() {

        public final void a(he he1, Map map)
        {
            PackageManager packagemanager = he1.getContext().getPackageManager();
            map = (String)map.get("data");
            JSONObject jsonobject;
            int i1;
            try
            {
                map = new JSONObject(map);
            }
            // Misplaced declaration of an exception variable
            catch (Map map)
            {
                he1.a("openableIntents", new JSONObject());
                return;
            }
            try
            {
                map = map.getJSONArray("intents");
            }
            // Misplaced declaration of an exception variable
            catch (Map map)
            {
                he1.a("openableIntents", new JSONObject());
                return;
            }
            jsonobject = new JSONObject();
            i1 = 0;
label0:
            do
            {
label1:
                {
                    if (i1 >= map.length())
                    {
                        break label0;
                    }
                    String s;
                    String s1;
                    String s2;
                    String s3;
                    String s4;
                    String s5;
                    Object obj;
                    boolean flag;
                    try
                    {
                        obj = map.getJSONObject(i1);
                    }
                    catch (JSONException jsonexception)
                    {
                        com.google.android.gms.ads.internal.util.client.b.a("Error parsing the intent data.", jsonexception);
                        break label1;
                    }
                    s = ((JSONObject) (obj)).optString("id");
                    s1 = ((JSONObject) (obj)).optString("u");
                    s2 = ((JSONObject) (obj)).optString("i");
                    s3 = ((JSONObject) (obj)).optString("m");
                    s4 = ((JSONObject) (obj)).optString("p");
                    s5 = ((JSONObject) (obj)).optString("c");
                    ((JSONObject) (obj)).optString("f");
                    ((JSONObject) (obj)).optString("e");
                    obj = new Intent();
                    if (!TextUtils.isEmpty(s1))
                    {
                        ((Intent) (obj)).setData(Uri.parse(s1));
                    }
                    if (!TextUtils.isEmpty(s2))
                    {
                        ((Intent) (obj)).setAction(s2);
                    }
                    if (!TextUtils.isEmpty(s3))
                    {
                        ((Intent) (obj)).setType(s3);
                    }
                    if (!TextUtils.isEmpty(s4))
                    {
                        ((Intent) (obj)).setPackage(s4);
                    }
                    if (!TextUtils.isEmpty(s5))
                    {
                        String as[] = s5.split("/", 2);
                        if (as.length == 2)
                        {
                            ((Intent) (obj)).setComponent(new ComponentName(as[0], as[1]));
                        }
                    }
                    if (packagemanager.resolveActivity(((Intent) (obj)), 0x10000) != null)
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    try
                    {
                        jsonobject.put(s, flag);
                    }
                    catch (JSONException jsonexception1)
                    {
                        com.google.android.gms.ads.internal.util.client.b.a("Error constructing openable urls response.", jsonexception1);
                    }
                }
                i1++;
            } while (true);
            he1.a("openableIntents", jsonobject);
        }

    };
    public static final ce d = new ce() {

        public final void a(he he1, Map map)
        {
            Uri uri;
            map = (String)map.get("u");
            if (map == null)
            {
                com.google.android.gms.ads.internal.util.client.b.a(5);
                return;
            }
            p.e();
            uri = Uri.parse(com.google.android.gms.d.gm.b(he1.getContext(), map, he1.r()));
            o o1 = he1.k();
            map = uri;
            if (o1 != null)
            {
                map = uri;
                try
                {
                    if (o1.a(uri))
                    {
                        map = o1.a(uri, he1.getContext());
                    }
                }
                // Misplaced declaration of an exception variable
                catch (Map map)
                {
                    com.google.android.gms.ads.internal.util.client.b.a(5);
                    map = uri;
                }
            }
            map = map.toString();
            gl.a(((gi) (new gt(he1.getContext(), he1.l().b, map))).i);
            return;
        }

    };
    public static final ce e = new ce() {

        public final void a(he he1, Map map)
        {
            map = he1.f();
            if (map != null)
            {
                map.a();
                return;
            }
            he1 = he1.g();
            if (he1 != null)
            {
                he1.a();
                return;
            } else
            {
                com.google.android.gms.ads.internal.util.client.b.a(5);
                return;
            }
        }

    };
    public static final ce f = new ce() {

        public final void a(he he1, Map map)
        {
            he1.c("1".equals(map.get("custom_close")));
        }

    };
    public static final ce g = new ce() {

        public final void a(he he1, Map map)
        {
            map = (String)map.get("u");
            if (map == null)
            {
                com.google.android.gms.ads.internal.util.client.b.a(5);
                return;
            } else
            {
                gl.a(((gi) (new gt(he1.getContext(), he1.l().b, map))).i);
                return;
            }
        }

    };
    public static final ce h = new ce() {

        public final void a(he he, Map map)
        {
            (new StringBuilder("Received log message: ")).append((String)map.get("string"));
            com.google.android.gms.ads.internal.util.client.b.a(4);
        }

    };
    public static final ce i = new ce() {

        public final void a(he he1, Map map)
        {
            String s = (String)map.get("tx");
            String s1 = (String)map.get("ty");
            map = (String)map.get("td");
            int i1;
            int j1;
            int k1;
            try
            {
                i1 = Integer.parseInt(s);
                j1 = Integer.parseInt(s1);
                k1 = Integer.parseInt(map);
                he1 = he1.k();
            }
            // Misplaced declaration of an exception variable
            catch (he he1)
            {
                com.google.android.gms.ads.internal.util.client.b.a(5);
                return;
            }
            if (he1 == null)
            {
                break MISSING_BLOCK_LABEL_82;
            }
            ((o) (he1)).a.a(i1, j1, k1);
        }

    };
    public static final ce j = new ce() {

        public final void a(he he1, Map map)
        {
            au au = ay.ai;
            if (!((Boolean)p.n().a(au)).booleanValue())
            {
                return;
            }
            boolean flag;
            if (!Boolean.parseBoolean((String)map.get("disabled")))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            he1.d(flag);
        }

    };
    public static final ce k = new cm();
    public static final ce l = new cq();

}

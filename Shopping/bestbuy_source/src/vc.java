// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.internal.gs;
import com.google.android.gms.internal.gu;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class vc
{

    public static final vd a = new vd() {

        public void a(gu gu, Map map)
        {
        }

    };
    public static final vd b = new vd() {

        public void a(gu gu1, Map map)
        {
            map = (String)map.get("urls");
            if (TextUtils.isEmpty(map))
            {
                acb.e("URLs missing in canOpenURLs GMSG.");
                return;
            }
            String as[] = map.split(",");
            HashMap hashmap = new HashMap();
            PackageManager packagemanager = gu1.getContext().getPackageManager();
            int l = as.length;
            int k = 0;
            while (k < l) 
            {
                String s = as[k];
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
                k++;
            }
            gu1.a("openableURLs", hashmap);
        }

    };
    public static final vd c = new vd() {

        public void a(gu gu1, Map map)
        {
            PackageManager packagemanager = gu1.getContext().getPackageManager();
            map = (String)map.get("data");
            JSONObject jsonobject;
            int k;
            try
            {
                map = new JSONObject(map);
            }
            // Misplaced declaration of an exception variable
            catch (Map map)
            {
                gu1.b("openableIntents", new JSONObject());
                return;
            }
            try
            {
                map = map.getJSONArray("intents");
            }
            // Misplaced declaration of an exception variable
            catch (Map map)
            {
                gu1.b("openableIntents", new JSONObject());
                return;
            }
            jsonobject = new JSONObject();
            k = 0;
label0:
            do
            {
label1:
                {
                    if (k >= map.length())
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
                        obj = map.getJSONObject(k);
                    }
                    catch (JSONException jsonexception)
                    {
                        acb.b("Error parsing the intent data.", jsonexception);
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
                        acb.b("Error constructing openable urls response.", jsonexception1);
                    }
                }
                k++;
            } while (true);
            gu1.b("openableIntents", jsonobject);
        }

    };
    public static final vd d = new vd() {

        public void a(gu gu1, Map map)
        {
            String s;
            s = (String)map.get("u");
            if (s == null)
            {
                acb.e("URL missing from click GMSG.");
                return;
            }
            map = Uri.parse(s);
            Object obj = gu1.h();
            if (obj == null)
            {
                break MISSING_BLOCK_LABEL_59;
            }
            if (!((aea) (obj)).b(map))
            {
                break MISSING_BLOCK_LABEL_59;
            }
            obj = ((aea) (obj)).a(map, gu1.getContext());
            map = ((Map) (obj));
_L2:
            map = map.toString();
            (new abz(gu1.getContext(), gu1.i().b, map)).e();
            return;
            aec aec1;
            aec1;
            acb.e((new StringBuilder()).append("Unable to append parameter to URL: ").append(s).toString());
            if (true) goto _L2; else goto _L1
_L1:
        }

    };
    public static final vd e = new vd() {

        public void a(gu gu1, Map map)
        {
            gu1 = gu1.d();
            if (gu1 == null)
            {
                acb.e("A GMSG tried to close something that wasn't an overlay.");
                return;
            } else
            {
                gu1.a();
                return;
            }
        }

    };
    public static final vd f = new vd() {

        public void a(gu gu1, Map map)
        {
            gu1.b("1".equals(map.get("custom_close")));
        }

    };
    public static final vd g = new vd() {

        public void a(gu gu1, Map map)
        {
            map = (String)map.get("u");
            if (map == null)
            {
                acb.e("URL missing from httpTrack GMSG.");
                return;
            } else
            {
                (new abz(gu1.getContext(), gu1.i().b, map)).e();
                return;
            }
        }

    };
    public static final vd h = new vd() {

        public void a(gu gu, Map map)
        {
            acb.c((new StringBuilder()).append("Received log message: ").append((String)map.get("string")).toString());
        }

    };
    public static final vd i = new vd() {

        public void a(gu gu1, Map map)
        {
            String s = (String)map.get("tx");
            String s1 = (String)map.get("ty");
            map = (String)map.get("td");
            int k;
            int l;
            int i1;
            try
            {
                k = Integer.parseInt(s);
                l = Integer.parseInt(s1);
                i1 = Integer.parseInt(map);
                gu1 = gu1.h();
            }
            // Misplaced declaration of an exception variable
            catch (gu gu1)
            {
                acb.e("Could not parse touch parameters from gmsg.");
                return;
            }
            if (gu1 == null)
            {
                break MISSING_BLOCK_LABEL_80;
            }
            gu1.a().a(k, l, i1);
        }

    };
    public static final vd j = new vj();

}

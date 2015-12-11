// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.overlay.zzd;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzp;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package android.support.v7:
//            pf, pj, ox, ul, 
//            mc, ly, nn, nj, 
//            md, tp, tw

public final class ow
{

    public static final ox a = new ox() {

        public void zza(ul ul, Map map)
        {
        }

    };
    public static final ox b = new ox() {

        public void zza(ul ul1, Map map)
        {
            map = (String)map.get("urls");
            if (TextUtils.isEmpty(map))
            {
                zzb.zzaE("URLs missing in canOpenURLs GMSG.");
                return;
            }
            String as[] = map.split(",");
            HashMap hashmap = new HashMap();
            PackageManager packagemanager = ul1.getContext().getPackageManager();
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
            ul1.a("openableURLs", hashmap);
        }

    };
    public static final ox c = new ox() {

        public void zza(ul ul1, Map map)
        {
            PackageManager packagemanager = ul1.getContext().getPackageManager();
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
                ul1.a("openableIntents", new JSONObject());
                return;
            }
            try
            {
                map = map.getJSONArray("intents");
            }
            // Misplaced declaration of an exception variable
            catch (Map map)
            {
                ul1.a("openableIntents", new JSONObject());
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
                        zzb.zzb("Error parsing the intent data.", jsonexception);
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
                        zzb.zzb("Error constructing openable urls response.", jsonexception1);
                    }
                }
                i1++;
            } while (true);
            ul1.a("openableIntents", jsonobject);
        }

    };
    public static final ox d = new ox() {

        public void zza(ul ul1, Map map)
        {
            Uri uri;
            String s;
            map = (String)map.get("u");
            if (map == null)
            {
                zzb.zzaE("URL missing from click GMSG.");
                return;
            }
            s = zzp.zzbx().b(ul1.getContext(), map, ul1.r());
            uri = Uri.parse(s);
            mc mc1 = ul1.k();
            map = uri;
            if (mc1 != null)
            {
                map = uri;
                try
                {
                    if (mc1.b(uri))
                    {
                        map = mc1.a(uri, ul1.getContext());
                    }
                }
                // Misplaced declaration of an exception variable
                catch (Map map)
                {
                    zzb.zzaE((new StringBuilder()).append("Unable to append parameter to URL: ").append(s).toString());
                    map = uri;
                }
            }
            map = map.toString();
            (new tw(ul1.getContext(), ul1.l().zzIz, map)).zzgn();
            return;
        }

    };
    public static final ox e = new ox() {

        public void zza(ul ul1, Map map)
        {
            map = ul1.f();
            if (map != null)
            {
                map.close();
                return;
            }
            ul1 = ul1.g();
            if (ul1 != null)
            {
                ul1.close();
                return;
            } else
            {
                zzb.zzaE("A GMSG tried to close something that wasn't an overlay.");
                return;
            }
        }

    };
    public static final ox f = new ox() {

        public void zza(ul ul1, Map map)
        {
            ul1.b("1".equals(map.get("custom_close")));
        }

    };
    public static final ox g = new ox() {

        public void zza(ul ul1, Map map)
        {
            map = (String)map.get("u");
            if (map == null)
            {
                zzb.zzaE("URL missing from httpTrack GMSG.");
                return;
            } else
            {
                (new tw(ul1.getContext(), ul1.l().zzIz, map)).zzgn();
                return;
            }
        }

    };
    public static final ox h = new ox() {

        public void zza(ul ul, Map map)
        {
            zzb.zzaD((new StringBuilder()).append("Received log message: ").append((String)map.get("string")).toString());
        }

    };
    public static final ox i = new ox() {

        public void zza(ul ul1, Map map)
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
                ul1 = ul1.k();
            }
            // Misplaced declaration of an exception variable
            catch (ul ul1)
            {
                zzb.zzaE("Could not parse touch parameters from gmsg.");
                return;
            }
            if (ul1 == null)
            {
                break MISSING_BLOCK_LABEL_82;
            }
            ul1.a().zza(i1, j1, k1);
        }

    };
    public static final ox j = new ox() {

        public void zza(ul ul1, Map map)
        {
            if (!((Boolean)nn.ai.c()).booleanValue())
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
            ul1.c(flag);
        }

    };
    public static final ox k = new pf();
    public static final ox l = new pj();

}

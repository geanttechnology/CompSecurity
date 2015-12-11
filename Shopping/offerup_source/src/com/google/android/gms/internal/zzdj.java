// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;


// Referenced classes of package com.google.android.gms.internal:
//            zzds, zzdw, zzdi, zzdk

public final class zzdj
{

    public static final zzdk zzxA = new zzdi();
    public static final zzdk zzxo = new _cls1();
    public static final zzdk zzxp = new _cls3();
    public static final zzdk zzxq = new _cls4();
    public static final zzdk zzxr = new _cls5();
    public static final zzdk zzxs = new _cls6();
    public static final zzdk zzxt = new _cls7();
    public static final zzdk zzxu = new _cls8();
    public static final zzdk zzxv = new _cls9();
    public static final zzdk zzxw = new _cls10();
    public static final zzdk zzxx = new _cls2();
    public static final zzdk zzxy = new zzds();
    public static final zzdk zzxz = new zzdw();


    private class _cls1
        implements zzdk
    {

        public final void zza(zziz zziz, Map map)
        {
        }

        _cls1()
        {
        }
    }


    private class _cls3
        implements zzdk
    {

        public final void zza(zziz zziz1, Map map)
        {
            map = (String)map.get("urls");
            if (TextUtils.isEmpty(map))
            {
                zzb.zzaH("URLs missing in canOpenURLs GMSG.");
                return;
            }
            String as[] = map.split(",");
            HashMap hashmap = new HashMap();
            PackageManager packagemanager = zziz1.getContext().getPackageManager();
            int j = as.length;
            int i = 0;
            while (i < j) 
            {
                String s = as[i];
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
                i++;
            }
            zziz1.zzb("openableURLs", hashmap);
        }

        _cls3()
        {
        }
    }


    private class _cls4
        implements zzdk
    {

        public final void zza(zziz zziz1, Map map)
        {
            PackageManager packagemanager = zziz1.getContext().getPackageManager();
            map = (String)map.get("data");
            JSONObject jsonobject;
            int i;
            try
            {
                map = new JSONObject(map);
            }
            // Misplaced declaration of an exception variable
            catch (Map map)
            {
                zziz1.zzb("openableIntents", new JSONObject());
                return;
            }
            try
            {
                map = map.getJSONArray("intents");
            }
            // Misplaced declaration of an exception variable
            catch (Map map)
            {
                zziz1.zzb("openableIntents", new JSONObject());
                return;
            }
            jsonobject = new JSONObject();
            i = 0;
label0:
            do
            {
label1:
                {
                    if (i >= map.length())
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
                        obj = map.getJSONObject(i);
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
                i++;
            } while (true);
            zziz1.zzb("openableIntents", jsonobject);
        }

        _cls4()
        {
        }
    }


    private class _cls5
        implements zzdk
    {

        public final void zza(zziz zziz1, Map map)
        {
            String s;
            s = (String)map.get("u");
            if (s == null)
            {
                zzb.zzaH("URL missing from click GMSG.");
                return;
            }
            map = Uri.parse(s);
            Object obj = zziz1.zzhg();
            if (obj == null)
            {
                break MISSING_BLOCK_LABEL_63;
            }
            if (!((zzan) (obj)).zzb(map))
            {
                break MISSING_BLOCK_LABEL_63;
            }
            obj = ((zzan) (obj)).zza(map, zziz1.getContext());
            map = ((Map) (obj));
_L2:
            map = map.toString();
            (new zzij(zziz1.getContext(), zziz1.zzhh().zzJu, map)).zzgz();
            return;
            zzao zzao1;
            zzao1;
            zzb.zzaH((new StringBuilder("Unable to append parameter to URL: ")).append(s).toString());
            if (true) goto _L2; else goto _L1
_L1:
        }

        _cls5()
        {
        }
    }


    private class _cls6
        implements zzdk
    {

        public final void zza(zziz zziz1, Map map)
        {
            map = zziz1.zzhc();
            if (map != null)
            {
                map.close();
                return;
            }
            zziz1 = zziz1.zzhd();
            if (zziz1 != null)
            {
                zziz1.close();
                return;
            } else
            {
                zzb.zzaH("A GMSG tried to close something that wasn't an overlay.");
                return;
            }
        }

        _cls6()
        {
        }
    }


    private class _cls7
        implements zzdk
    {

        public final void zza(zziz zziz1, Map map)
        {
            zziz1.zzD("1".equals(map.get("custom_close")));
        }

        _cls7()
        {
        }
    }


    private class _cls8
        implements zzdk
    {

        public final void zza(zziz zziz1, Map map)
        {
            map = (String)map.get("u");
            if (map == null)
            {
                zzb.zzaH("URL missing from httpTrack GMSG.");
                return;
            } else
            {
                (new zzij(zziz1.getContext(), zziz1.zzhh().zzJu, map)).zzgz();
                return;
            }
        }

        _cls8()
        {
        }
    }


    private class _cls9
        implements zzdk
    {

        public final void zza(zziz zziz, Map map)
        {
            zzb.zzaG((new StringBuilder("Received log message: ")).append((String)map.get("string")).toString());
        }

        _cls9()
        {
        }
    }


    private class _cls10
        implements zzdk
    {

        public final void zza(zziz zziz1, Map map)
        {
            String s = (String)map.get("tx");
            String s1 = (String)map.get("ty");
            map = (String)map.get("td");
            int i;
            int j;
            int k;
            try
            {
                i = Integer.parseInt(s);
                j = Integer.parseInt(s1);
                k = Integer.parseInt(map);
                zziz1 = zziz1.zzhg();
            }
            // Misplaced declaration of an exception variable
            catch (zziz zziz1)
            {
                zzb.zzaH("Could not parse touch parameters from gmsg.");
                return;
            }
            if (zziz1 == null)
            {
                break MISSING_BLOCK_LABEL_82;
            }
            zziz1.zzab().zza(i, j, k);
        }

        _cls10()
        {
        }
    }


    private class _cls2
        implements zzdk
    {

        public final void zza(zziz zziz1, Map map)
        {
            if (!((Boolean)zzby.zzvs.get()).booleanValue())
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
            zziz1.zzE(flag);
        }

        _cls2()
        {
        }
    }

}

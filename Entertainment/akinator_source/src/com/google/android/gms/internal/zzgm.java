// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.formats.zzc;
import com.google.android.gms.ads.internal.formats.zzf;
import com.google.android.gms.ads.internal.formats.zzh;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzn;
import com.google.android.gms.dynamic.zze;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.google.android.gms.internal:
//            zzhs, zzio, zzih, zzbb, 
//            zzin, zzcu, zzcy, zzby, 
//            zzbu, zzbc, zzgn, zzgo, 
//            zzid, zzgp, zzip, zzan, 
//            zziq

public class zzgm
    implements Callable
{

    private static final long zzDE;
    private final Context mContext;
    private final zzih zzDF;
    private final zzn zzDG;
    private final zzbc zzDH;
    private boolean zzDI;
    private List zzDJ;
    private final zzhs.zza zzDe;
    private int zzDv;
    private final Object zzpd = new Object();
    private final zzan zzwL;

    public zzgm(Context context, zzn zzn1, zzbc zzbc1, zzih zzih1, zzan zzan, zzhs.zza zza1)
    {
        mContext = context;
        zzDG = zzn1;
        zzDF = zzih1;
        zzDH = zzbc1;
        zzDe = zza1;
        zzwL = zzan;
        zzDI = false;
        zzDv = -2;
        zzDJ = null;
    }

    private com.google.android.gms.ads.internal.formats.zzh.zza zza(zzbb zzbb1, zza zza1, JSONObject jsonobject)
        throws ExecutionException, InterruptedException, JSONException
    {
        if (zzfD())
        {
            return null;
        }
        List list = zzc(jsonobject.getJSONObject("tracking_urls_and_actions"), "impression_tracking_urls");
    /* block-local class not found */
    class zza {}

        if (list == null)
        {
            list = null;
        } else
        {
            list = Arrays.asList(list);
        }
        zzDJ = list;
        zza1 = zza1.zza(this, jsonobject);
        if (zza1 == null)
        {
            com.google.android.gms.ads.internal.util.client.zzb.e("Failed to retrieve ad assets.");
            return null;
        } else
        {
            zza1.zza(new zzh(mContext, zzDG, zzbb1, zzwL, jsonobject, zza1, zzDe.zzHC.zzqj));
            return zza1;
        }
    }

    static zzn zza(zzgm zzgm1)
    {
        return zzgm1.zzDG;
    }

    private zzhs zza(com.google.android.gms.ads.internal.formats.zzh.zza zza1)
    {
        Object obj = zzpd;
        obj;
        JVM INSTR monitorenter ;
        int j = zzDv;
        int i;
        i = j;
        if (zza1 != null)
        {
            break MISSING_BLOCK_LABEL_34;
        }
        i = j;
        if (zzDv == -2)
        {
            i = 0;
        }
        obj;
        JVM INSTR monitorexit ;
        if (i != -2)
        {
            zza1 = null;
        }
        return new zzhs(zzDe.zzHC.zzEn, null, zzDe.zzHD.zzyY, i, zzDe.zzHD.zzyZ, zzDJ, zzDe.zzHD.orientation, zzDe.zzHD.zzzc, zzDe.zzHC.zzEq, false, null, null, null, null, null, 0L, zzDe.zzqn, zzDe.zzHD.zzEJ, zzDe.zzHz, zzDe.zzHA, zzDe.zzHD.zzEP, zzDe.zzHw, zza1);
        zza1;
        obj;
        JVM INSTR monitorexit ;
        throw zza1;
    }

    private zziq zza(JSONObject jsonobject, boolean flag, boolean flag1)
        throws JSONException
    {
        double d;
        String s;
        if (flag)
        {
            s = jsonobject.getString("url");
        } else
        {
            s = jsonobject.optString("url");
        }
        d = jsonobject.optDouble("scale", 1.0D);
        if (TextUtils.isEmpty(s))
        {
            zza(0, flag);
            return new zzio(null);
        }
        if (flag1)
        {
            return new zzio(new zzc(null, Uri.parse(s), d));
        } else
        {
            return zzDF.zza(s, new _cls5(flag, d, s));
        }
    }

    private void zza(com.google.android.gms.ads.internal.formats.zzh.zza zza1, zzbb zzbb1)
    {
        if (!(zza1 instanceof zzf))
        {
            return;
        } else
        {
            Object obj = (zzf)zza1;
    /* block-local class not found */
    class zzb {}

            zza1 = new zzb();
            obj = new _cls3(((zzf) (obj)));
            zza1.zzDZ = ((zzdk) (obj));
            zzbb1.zza("/nativeAdCustomClick", ((zzdk) (obj)));
            return;
        }
    }

    static void zza(zzgm zzgm1, zzcu zzcu1, String s)
    {
        zzgm1.zzb(zzcu1, s);
    }

    private Integer zzb(JSONObject jsonobject, String s)
    {
        int i;
        try
        {
            jsonobject = jsonobject.getJSONObject(s);
            i = Color.rgb(jsonobject.getInt("r"), jsonobject.getInt("g"), jsonobject.getInt("b"));
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            return null;
        }
        return Integer.valueOf(i);
    }

    private JSONObject zzb(zzbb zzbb1)
        throws TimeoutException, JSONException
    {
        if (zzfD())
        {
            return null;
        } else
        {
            zzin zzin1 = new zzin();
            zzb zzb1 = new zzb();
            _cls1 _lcls1 = new _cls1(zzbb1, zzb1, zzin1);
            zzb1.zzDZ = _lcls1;
            zzbb1.zza("/nativeAdPreProcess", _lcls1);
            zzbb1.zza("google.afma.nativeAds.preProcessJsonGmsg", new JSONObject(zzDe.zzHD.body));
            return (JSONObject)zzin1.get(zzDE, TimeUnit.MILLISECONDS);
        }
    }

    private void zzb(zzcu zzcu1, String s)
    {
        zzcy zzcy1;
        try
        {
            zzcy1 = zzDG.zzr(zzcu1.getCustomTemplateId());
        }
        // Misplaced declaration of an exception variable
        catch (zzcu zzcu1)
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzd((new StringBuilder()).append("Failed to call onCustomClick for asset ").append(s).append(".").toString(), zzcu1);
            return;
        }
        if (zzcy1 == null)
        {
            break MISSING_BLOCK_LABEL_26;
        }
        zzcy1.zza(zzcu1, s);
    }

    private String[] zzc(JSONObject jsonobject, String s)
        throws JSONException
    {
        jsonobject = jsonobject.optJSONArray(s);
        if (jsonobject == null)
        {
            return null;
        }
        s = new String[jsonobject.length()];
        for (int i = 0; i < jsonobject.length(); i++)
        {
            s[i] = jsonobject.getString(i);
        }

        return s;
    }

    private static List zzd(List list)
        throws RemoteException
    {
        ArrayList arraylist = new ArrayList();
        for (list = list.iterator(); list.hasNext(); arraylist.add((Drawable)com.google.android.gms.dynamic.zze.zzp(((zzc)list.next()).zzdv()))) { }
        return arraylist;
    }

    static List zze(List list)
        throws RemoteException
    {
        return zzd(list);
    }

    private zzbb zzfC()
        throws CancellationException, ExecutionException, InterruptedException, TimeoutException
    {
        if (zzfD())
        {
            return null;
        }
        String s = (String)zzby.zzvj.get();
        Object obj;
        if (zzDe.zzHD.zzBF.indexOf("https") == 0)
        {
            obj = "https:";
        } else
        {
            obj = "http:";
        }
        obj = (new StringBuilder()).append(((String) (obj))).append(s).toString();
        obj = (zzbb)zzDH.zza(mContext, zzDe.zzHC.zzqj, ((String) (obj)), zzwL).get(zzDE, TimeUnit.MILLISECONDS);
        ((zzbb) (obj)).zza(zzDG, zzDG, zzDG, zzDG, false, null, null, null, null);
        return ((zzbb) (obj));
    }

    public Object call()
        throws Exception
    {
        return zzfB();
    }

    public void zzC(int i)
    {
        synchronized (zzpd)
        {
            zzDI = true;
            zzDv = i;
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public zziq zza(JSONObject jsonobject, String s, boolean flag, boolean flag1)
        throws JSONException
    {
        if (flag)
        {
            jsonobject = jsonobject.getJSONObject(s);
        } else
        {
            jsonobject = jsonobject.optJSONObject(s);
        }
        s = jsonobject;
        if (jsonobject == null)
        {
            s = new JSONObject();
        }
        return zza(((JSONObject) (s)), flag, flag1);
    }

    public List zza(JSONObject jsonobject, String s, boolean flag, boolean flag1, boolean flag2)
        throws JSONException
    {
        ArrayList arraylist;
        if (flag)
        {
            jsonobject = jsonobject.getJSONArray(s);
        } else
        {
            jsonobject = jsonobject.optJSONArray(s);
        }
        arraylist = new ArrayList();
        if (jsonobject == null || jsonobject.length() == 0)
        {
            zza(0, flag);
            return arraylist;
        }
        int i;
        int j;
        if (flag2)
        {
            i = jsonobject.length();
        } else
        {
            i = 1;
        }
        for (j = 0; j < i; j++)
        {
            JSONObject jsonobject1 = jsonobject.getJSONObject(j);
            s = jsonobject1;
            if (jsonobject1 == null)
            {
                s = new JSONObject();
            }
            arraylist.add(zza(((JSONObject) (s)), flag, flag1));
        }

        return arraylist;
    }

    public Future zza(JSONObject jsonobject, String s, boolean flag)
        throws JSONException
    {
        s = jsonobject.getJSONObject(s);
        boolean flag1 = s.optBoolean("require", true);
        jsonobject = s;
        if (s == null)
        {
            jsonobject = new JSONObject();
        }
        return zza(jsonobject, flag1, flag);
    }

    public void zza(int i, boolean flag)
    {
        if (flag)
        {
            zzC(i);
        }
    }

    protected zza zzd(JSONObject jsonobject)
        throws JSONException, TimeoutException
    {
        if (zzfD())
        {
            return null;
        }
        String s = jsonobject.getString("template_id");
        boolean flag;
        boolean flag1;
        if (zzDe.zzHC.zzqB != null)
        {
            flag = zzDe.zzHC.zzqB.zzwR;
        } else
        {
            flag = false;
        }
        if (zzDe.zzHC.zzqB != null)
        {
            flag1 = zzDe.zzHC.zzqB.zzwT;
        } else
        {
            flag1 = false;
        }
        if ("2".equals(s))
        {
            return new zzgn(flag, flag1);
        }
        if ("1".equals(s))
        {
            return new zzgo(flag, flag1);
        }
        if ("3".equals(s))
        {
            String s1 = jsonobject.getString("custom_template_id");
            zzin zzin1 = new zzin();
            zzid.zzIE.post(new _cls2(zzin1, s1));
            if (zzin1.get(zzDE, TimeUnit.MILLISECONDS) != null)
            {
                return new zzgp(flag);
            }
            com.google.android.gms.ads.internal.util.client.zzb.e((new StringBuilder()).append("No handler for custom template: ").append(jsonobject.getString("custom_template_id")).toString());
        } else
        {
            zzC(0);
        }
        return null;
    }

    public zziq zze(JSONObject jsonobject)
        throws JSONException
    {
        JSONObject jsonobject1 = jsonobject.optJSONObject("attribution");
        if (jsonobject1 == null)
        {
            return new zzio(null);
        }
        String s = jsonobject1.optString("text");
        int i = jsonobject1.optInt("text_size", -1);
        Integer integer = zzb(jsonobject1, "text_color");
        Integer integer1 = zzb(jsonobject1, "bg_color");
        int j = jsonobject1.optInt("animation_ms", 1000);
        int k = jsonobject1.optInt("presentation_ms", 4000);
        jsonobject = new ArrayList();
        if (jsonobject1.optJSONArray("images") != null)
        {
            jsonobject = zza(jsonobject1, "images", false, false, true);
        } else
        {
            jsonobject.add(zza(jsonobject1, "image", false, false));
        }
        return zzip.zza(com.google.android.gms.internal.zzip.zzh(jsonobject), new _cls4(s, integer1, integer, i, k, j));
    }

    public zzhs zzfB()
    {
        Object obj;
        obj = zzfC();
        Object obj2 = zzb(((zzbb) (obj)));
        obj2 = zza(((zzbb) (obj)), zzd(((JSONObject) (obj2))), ((JSONObject) (obj2)));
        zza(((com.google.android.gms.ads.internal.formats.zzh.zza) (obj2)), ((zzbb) (obj)));
        obj = zza(((com.google.android.gms.ads.internal.formats.zzh.zza) (obj2)));
        return ((zzhs) (obj));
        Object obj1;
        obj1;
        com.google.android.gms.ads.internal.util.client.zzb.zzd("Malformed native JSON response.", ((Throwable) (obj1)));
_L2:
        if (!zzDI)
        {
            zzC(0);
        }
        return zza(((com.google.android.gms.ads.internal.formats.zzh.zza) (null)));
        obj1;
        com.google.android.gms.ads.internal.util.client.zzb.zzd("Timeout when loading native ad.", ((Throwable) (obj1)));
        continue; /* Loop/switch isn't completed */
        obj1;
        continue; /* Loop/switch isn't completed */
        obj1;
        continue; /* Loop/switch isn't completed */
        obj1;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public boolean zzfD()
    {
        boolean flag;
        synchronized (zzpd)
        {
            flag = zzDI;
        }
        return flag;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    static 
    {
        zzDE = TimeUnit.SECONDS.toMillis(60L);
    }

    /* member class not found */
    class _cls5 {}


    /* member class not found */
    class _cls3 {}


    /* member class not found */
    class _cls1 {}


    /* member class not found */
    class _cls2 {}


    /* member class not found */
    class _cls4 {}

}

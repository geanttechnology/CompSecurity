// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzp;
import java.io.BufferedOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.google.android.gms.internal:
//            zzdk, zzid, zzic, zziz

public class zzdl
    implements zzdk
{

    private final Context mContext;
    private final VersionInfoParcel zzpb;

    public zzdl(Context context, VersionInfoParcel versioninfoparcel)
    {
        mContext = context;
        zzpb = versioninfoparcel;
    }

    public JSONObject zzX(String s)
    {
        String s1;
        JSONObject jsonobject;
        Object obj;
        try
        {
            obj = new JSONObject(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            com.google.android.gms.ads.internal.util.client.zzb.e("The request is not a valid JSON.");
            try
            {
                s = (new JSONObject()).put("success", false);
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                return new JSONObject();
            }
            return s;
        }
        jsonobject = new JSONObject();
        s = "";
        try
        {
            s1 = ((JSONObject) (obj)).optString("http_request_id");
        }
        catch (Exception exception)
        {
            try
            {
                jsonobject.put("response", (new JSONObject()).put("http_request_id", s));
                jsonobject.put("success", false);
                jsonobject.put("reason", exception.toString());
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                return jsonobject;
            }
            return jsonobject;
        }
        s = s1;
        obj = zza(zzb(((JSONObject) (obj))));
        s = s1;
        if (!((zzc) (obj)).isSuccess())
        {
            break MISSING_BLOCK_LABEL_114;
        }
        s = s1;
        jsonobject.put("response", zza(((zzc) (obj)).zzdI()));
        s = s1;
        jsonobject.put("success", true);
        return jsonobject;
        s = s1;
        jsonobject.put("response", (new JSONObject()).put("http_request_id", s1));
        s = s1;
        jsonobject.put("success", false);
        s = s1;
        jsonobject.put("reason", ((zzc) (obj)).getReason());
        return jsonobject;
    }

    protected zzc zza(zzb zzb1)
    {
        HttpURLConnection httpurlconnection;
        try
        {
            httpurlconnection = (HttpURLConnection)zzb1.zzdF().openConnection();
            zzp.zzbv().zza(mContext, zzpb.zzJu, false, httpurlconnection);
            zza zza1;
            for (Iterator iterator = zzb1.zzdG().iterator(); iterator.hasNext(); httpurlconnection.addRequestProperty(zza1.getKey(), zza1.getValue()))
            {
                zza1 = (zza)iterator.next();
            }

        }
        // Misplaced declaration of an exception variable
        catch (zzb zzb1)
        {
            return new zzc(false, null, zzb1.toString());
        }
        ArrayList arraylist;
        if (!TextUtils.isEmpty(zzb1.zzdH()))
        {
            httpurlconnection.setDoOutput(true);
            byte abyte0[] = zzb1.zzdH().getBytes();
            httpurlconnection.setFixedLengthStreamingMode(abyte0.length);
            BufferedOutputStream bufferedoutputstream = new BufferedOutputStream(httpurlconnection.getOutputStream());
            bufferedoutputstream.write(abyte0);
            bufferedoutputstream.close();
        }
        arraylist = new ArrayList();
        if (httpurlconnection.getHeaderFields() != null)
        {
            for (Iterator iterator1 = httpurlconnection.getHeaderFields().entrySet().iterator(); iterator1.hasNext();)
            {
                java.util.Map.Entry entry = (java.util.Map.Entry)iterator1.next();
                Iterator iterator2 = ((List)entry.getValue()).iterator();
                while (iterator2.hasNext()) 
                {
                    String s = (String)iterator2.next();
                    arraylist.add(new zza((String)entry.getKey(), s));
                }
            }

        }
        zzb1 = new zzc(true, new zzd(zzb1.zzdE(), httpurlconnection.getResponseCode(), arraylist, zzp.zzbv().zza(new InputStreamReader(httpurlconnection.getInputStream()))), null);
        return zzb1;
    }

    protected JSONObject zza(zzd zzd1)
    {
        JSONObject jsonobject;
        JSONArray jsonarray;
        jsonobject = new JSONObject();
        try
        {
            jsonobject.put("http_request_id", zzd1.zzdE());
            if (zzd1.getBody() != null)
            {
                jsonobject.put("body", zzd1.getBody());
            }
            jsonarray = new JSONArray();
            zza zza1;
            for (Iterator iterator = zzd1.zzdJ().iterator(); iterator.hasNext(); jsonarray.put((new JSONObject()).put("key", zza1.getKey()).put("value", zza1.getValue())))
            {
                zza1 = (zza)iterator.next();
            }

        }
        // Misplaced declaration of an exception variable
        catch (zzd zzd1)
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzb("Error constructing JSON for http response.", zzd1);
            return jsonobject;
        }
        jsonobject.put("headers", jsonarray);
        jsonobject.put("response_code", zzd1.getResponseCode());
        return jsonobject;
    }

    public void zza(zziz zziz, Map map)
    {
        zzic.zza(new _cls1(map, zziz));
    }

    protected zzb zzb(JSONObject jsonobject)
    {
        String s = jsonobject.optString("http_request_id");
        Object obj = jsonobject.optString("url");
        String s1 = jsonobject.optString("post_body", null);
        JSONArray jsonarray;
        ArrayList arraylist;
        try
        {
            obj = new URL(((String) (obj)));
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzb("Error constructing http request.", ((Throwable) (obj)));
            obj = null;
        }
        arraylist = new ArrayList();
        jsonarray = jsonobject.optJSONArray("headers");
        jsonobject = jsonarray;
        if (jsonarray == null)
        {
            jsonobject = new JSONArray();
        }
        for (int i = 0; i < jsonobject.length(); i++)
        {
            JSONObject jsonobject1 = jsonobject.optJSONObject(i);
            if (jsonobject1 != null)
            {
                arraylist.add(new zza(jsonobject1.optString("key"), jsonobject1.optString("value")));
            }
        }

        return new zzb(s, ((URL) (obj)), arraylist, s1);
    }

    private class zzc
    {

        final zzdl zzxC;
        private final zzd zzxJ;
        private final boolean zzxK;
        private final String zzxL;

        public String getReason()
        {
            return zzxL;
        }

        public boolean isSuccess()
        {
            return zzxK;
        }

        public zzd zzdI()
        {
            return zzxJ;
        }

        public zzc(boolean flag, zzd zzd, String s)
        {
            zzxC = zzdl.this;
            super();
            zzxK = flag;
            zzxJ = zzd;
            zzxL = s;
        }
    }


    private class zzb
    {

        private final String zzxF;
        private final URL zzxG;
        private final ArrayList zzxH;
        private final String zzxI;

        public String zzdE()
        {
            return zzxF;
        }

        public URL zzdF()
        {
            return zzxG;
        }

        public ArrayList zzdG()
        {
            return zzxH;
        }

        public String zzdH()
        {
            return zzxI;
        }

        public zzb(String s, URL url, ArrayList arraylist, String s1)
        {
            zzxF = s;
            zzxG = url;
            if (arraylist == null)
            {
                zzxH = new ArrayList();
            } else
            {
                zzxH = arraylist;
            }
            zzxI = s1;
        }
    }


    private class zza
    {

        private final String mValue;
        private final String zzue;

        public String getKey()
        {
            return zzue;
        }

        public String getValue()
        {
            return mValue;
        }

        public zza(String s, String s1)
        {
            zzue = s;
            mValue = s1;
        }
    }


    private class zzd
    {

        private final String zzwq;
        private final String zzxF;
        private final int zzxM;
        private final List zzxN;

        public String getBody()
        {
            return zzwq;
        }

        public int getResponseCode()
        {
            return zzxM;
        }

        public String zzdE()
        {
            return zzxF;
        }

        public Iterable zzdJ()
        {
            return zzxN;
        }

        public zzd(String s, int i, List list, String s1)
        {
            zzxF = s;
            zzxM = i;
            if (list == null)
            {
                zzxN = new ArrayList();
            } else
            {
                zzxN = list;
            }
            zzwq = s1;
        }
    }


    private class _cls1
        implements Runnable
    {

        final Map zzwP;
        final zziz zzxB;
        final zzdl zzxC;

        public void run()
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzaF("Received Http request.");
            Object obj = (String)zzwP.get("http_request");
            obj = zzxC.zzX(((String) (obj)));
            if (obj == null)
            {
                com.google.android.gms.ads.internal.util.client.zzb.e("Response should not be null.");
                return;
            } else
            {
                class _cls1
                    implements Runnable
                {

                    final JSONObject zzxD;
                    final _cls1 zzxE;

                    public void run()
                    {
                        zzxE.zzxB.zzb("fetchHttpRequestCompleted", zzxD);
                        com.google.android.gms.ads.internal.util.client.zzb.zzaF("Dispatched http response.");
                    }

                _cls1(JSONObject jsonobject)
                {
                    zzxE = _cls1.this;
                    zzxD = jsonobject;
                    super();
                }
                }

                zzid.zzIE.post(new _cls1(((JSONObject) (obj))));
                return;
            }
        }

        _cls1(Map map, zziz zziz)
        {
            zzxC = zzdl.this;
            zzwP = map;
            zzxB = zziz;
            super();
        }
    }

}

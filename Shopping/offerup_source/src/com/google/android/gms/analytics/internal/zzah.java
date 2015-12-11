// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.analytics.internal;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzmn;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.zip.GZIPOutputStream;

// Referenced classes of package com.google.android.gms.analytics.internal:
//            zzd, zze, zzam, zzaj, 
//            zzf, zzb, zzab, zzr, 
//            zzaf, zzm, zzo

class zzah extends zzd
{

    private static final byte zzPy[] = "\n".getBytes();
    private final String zzIa;
    private final zzaj zzPx;

    zzah(zzf zzf1)
    {
        super(zzf1);
        zzIa = zza("GoogleAnalytics", zze.VERSION, android.os.Build.VERSION.RELEASE, zzam.zza(Locale.getDefault()), Build.MODEL, Build.ID);
        zzPx = new zzaj(zzf1.zzit());
    }

    private int zza(URL url, byte abyte0[])
    {
        URL url2;
        OutputStream outputstream;
        OutputStream outputstream1;
        Object obj;
        url2 = null;
        outputstream1 = null;
        obj = null;
        outputstream = null;
        zzx.zzw(url);
        zzx.zzw(abyte0);
        zzb("POST bytes, url", Integer.valueOf(abyte0.length), url);
        if (zziD())
        {
            zza("Post payload\n", new String(abyte0));
        }
        url = zzc(url);
        URL url1;
        url2 = url;
        url = outputstream1;
        url1 = url2;
        outputstream = obj;
        url2.setDoOutput(true);
        url = outputstream1;
        url1 = url2;
        outputstream = obj;
        url2.setFixedLengthStreamingMode(abyte0.length);
        url = outputstream1;
        url1 = url2;
        outputstream = obj;
        url2.connect();
        url = outputstream1;
        url1 = url2;
        outputstream = obj;
        outputstream1 = url2.getOutputStream();
        url = outputstream1;
        url1 = url2;
        outputstream = outputstream1;
        outputstream1.write(abyte0);
        url = outputstream1;
        url1 = url2;
        outputstream = outputstream1;
        zzb(url2);
        url = outputstream1;
        url1 = url2;
        outputstream = outputstream1;
        int i = url2.getResponseCode();
        if (i != 200)
        {
            break MISSING_BLOCK_LABEL_203;
        }
        url = outputstream1;
        url1 = url2;
        outputstream = outputstream1;
        zzhP().zzip();
        url = outputstream1;
        url1 = url2;
        outputstream = outputstream1;
        zzb("POST status", Integer.valueOf(i));
        if (outputstream1 != null)
        {
            try
            {
                outputstream1.close();
            }
            // Misplaced declaration of an exception variable
            catch (URL url)
            {
                zze("Error closing http post connection output stream", url);
            }
        }
        if (url2 != null)
        {
            url2.disconnect();
        }
        return i;
        abyte0;
        url2 = null;
_L4:
        url = outputstream;
        url1 = url2;
        zzd("Network POST connection error", abyte0);
        if (outputstream != null)
        {
            try
            {
                outputstream.close();
            }
            // Misplaced declaration of an exception variable
            catch (URL url)
            {
                zze("Error closing http post connection output stream", url);
            }
        }
        if (url2 != null)
        {
            url2.disconnect();
        }
        return 0;
        abyte0;
        url1 = null;
        url = url2;
_L2:
        if (url != null)
        {
            try
            {
                url.close();
            }
            // Misplaced declaration of an exception variable
            catch (URL url)
            {
                zze("Error closing http post connection output stream", url);
            }
        }
        if (url1 != null)
        {
            url1.disconnect();
        }
        throw abyte0;
        abyte0;
        if (true) goto _L2; else goto _L1
_L1:
        abyte0;
        if (true) goto _L4; else goto _L3
_L3:
    }

    private static String zza(String s, String s1, String s2, String s3, String s4, String s5)
    {
        return String.format("%s/%s (Linux; U; Android %s; %s; %s Build/%s)", new Object[] {
            s, s1, s2, s3, s4, s5
        });
    }

    private void zza(StringBuilder stringbuilder, String s, String s1)
    {
        if (stringbuilder.length() != 0)
        {
            stringbuilder.append('&');
        }
        stringbuilder.append(URLEncoder.encode(s, "UTF-8"));
        stringbuilder.append('=');
        stringbuilder.append(URLEncoder.encode(s1, "UTF-8"));
    }

    private int zzb(URL url)
    {
        URL url1;
        URL url2;
        zzx.zzw(url);
        zzb("GET request", url);
        url2 = null;
        url1 = null;
        url = zzc(url);
        url1 = url;
        url2 = url;
        url.connect();
        url1 = url;
        url2 = url;
        zzb(((HttpURLConnection) (url)));
        url1 = url;
        url2 = url;
        int i = url.getResponseCode();
        if (i != 200)
        {
            break MISSING_BLOCK_LABEL_68;
        }
        url1 = url;
        url2 = url;
        zzhP().zzip();
        url1 = url;
        url2 = url;
        zzb("GET status", Integer.valueOf(i));
        if (url != null)
        {
            url.disconnect();
        }
        return i;
        url;
        url2 = url1;
        zzd("Network GET connection error", url);
        if (url1 != null)
        {
            url1.disconnect();
        }
        return 0;
        url;
        if (url2 != null)
        {
            url2.disconnect();
        }
        throw url;
    }

    private int zzb(URL url, byte abyte0[])
    {
        Object obj;
        Object obj1;
        obj1 = null;
        obj = null;
        zzx.zzw(url);
        zzx.zzw(abyte0);
        byte abyte1[];
        abyte1 = zzg(abyte0);
        zza("POST compressed size, ratio %, url", Integer.valueOf(abyte1.length), Long.valueOf((100L * (long)abyte1.length) / (long)abyte0.length), url);
        if (abyte1.length > abyte0.length)
        {
            zzc("Compressed payload is larger then uncompressed. compressed, uncompressed", Integer.valueOf(abyte1.length), Integer.valueOf(abyte0.length));
        }
        if (zziD())
        {
            zza("Post payload", (new StringBuilder("\n")).append(new String(abyte0)).toString());
        }
        url = zzc(url);
        Object obj2;
        int i;
        try
        {
            url.setDoOutput(true);
            url.addRequestProperty("Content-Encoding", "gzip");
            url.setFixedLengthStreamingMode(abyte1.length);
            url.connect();
            abyte0 = url.getOutputStream();
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            continue; /* Loop/switch isn't completed */
        }
        finally
        {
            obj = obj1;
        }
        abyte0.write(abyte1);
        abyte0.close();
        zzb(((HttpURLConnection) (url)));
        i = url.getResponseCode();
        if (i != 200)
        {
            break MISSING_BLOCK_LABEL_181;
        }
        zzhP().zzip();
        zzb("POST status", Integer.valueOf(i));
        if (url != null)
        {
            url.disconnect();
        }
        return i;
        abyte0;
        url = null;
_L4:
        zzd("Network compressed POST connection error", abyte0);
        if (obj != null)
        {
            try
            {
                ((OutputStream) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (byte abyte0[])
            {
                zze("Error closing http compressed post connection output stream", abyte0);
            }
        }
        if (url != null)
        {
            url.disconnect();
        }
        return 0;
        abyte0;
        url = null;
        obj = obj1;
_L2:
        if (obj != null)
        {
            try
            {
                ((OutputStream) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                zze("Error closing http compressed post connection output stream", obj);
            }
        }
        if (url != null)
        {
            url.disconnect();
        }
        throw abyte0;
        obj2;
        obj = abyte0;
        abyte0 = ((byte []) (obj2));
        continue; /* Loop/switch isn't completed */
        abyte0;
        if (true) goto _L2; else goto _L1
_L1:
        obj2;
        obj = abyte0;
        abyte0 = ((byte []) (obj2));
        if (true) goto _L4; else goto _L3
_L3:
    }

    private URL zzb(zzab zzab1, String s)
    {
        if (zzab1.zzkC())
        {
            zzab1 = (new StringBuilder()).append(zziv().zzjO()).append(zziv().zzjQ()).append("?").append(s).toString();
        } else
        {
            zzab1 = (new StringBuilder()).append(zziv().zzjP()).append(zziv().zzjQ()).append("?").append(s).toString();
        }
        try
        {
            zzab1 = new URL(zzab1);
        }
        // Misplaced declaration of an exception variable
        catch (zzab zzab1)
        {
            zze("Error trying to parse the hardcoded host url", zzab1);
            return null;
        }
        return zzab1;
    }

    private void zzb(HttpURLConnection httpurlconnection)
    {
        HttpURLConnection httpurlconnection1 = null;
        httpurlconnection = httpurlconnection.getInputStream();
        httpurlconnection1 = httpurlconnection;
        byte abyte0[] = new byte[1024];
_L2:
        httpurlconnection1 = httpurlconnection;
        int i = httpurlconnection.read(abyte0);
        if (i > 0) goto _L2; else goto _L1
_L1:
        if (httpurlconnection == null)
        {
            break MISSING_BLOCK_LABEL_37;
        }
        httpurlconnection.close();
        return;
        httpurlconnection;
        zze("Error closing http connection input stream", httpurlconnection);
        return;
        httpurlconnection;
        if (httpurlconnection1 != null)
        {
            try
            {
                httpurlconnection1.close();
            }
            catch (IOException ioexception)
            {
                zze("Error closing http connection input stream", ioexception);
            }
        }
        throw httpurlconnection;
    }

    private boolean zzg(zzab zzab1)
    {
        String s;
        zzx.zzw(zzab1);
        boolean flag;
        if (!zzab1.zzkC())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        s = zza(zzab1, flag);
        if (s != null) goto _L2; else goto _L1
_L1:
        zziu().zza(zzab1, "Error formatting hit for upload");
_L4:
        return true;
_L2:
        if (s.length() > zziv().zzjD())
        {
            break; /* Loop/switch isn't completed */
        }
        zzab1 = zzb(zzab1, s);
        if (zzab1 == null)
        {
            zzbe("Failed to build collect GET endpoint url");
            return false;
        }
        if (zzb(zzab1) != 200)
        {
            return false;
        }
        if (true) goto _L4; else goto _L3
_L3:
        String s1 = zza(zzab1, false);
        if (s1 == null)
        {
            zziu().zza(zzab1, "Error formatting hit for POST upload");
            return true;
        }
        byte abyte0[] = s1.getBytes();
        if (abyte0.length > zziv().zzjF())
        {
            zziu().zza(zzab1, "Hit payload exceeds size limit");
            return true;
        }
        zzab1 = zzh(zzab1);
        if (zzab1 == null)
        {
            zzbe("Failed to build collect POST endpoint url");
            return false;
        }
        if (zza(zzab1, abyte0) != 200)
        {
            return false;
        }
        if (true) goto _L4; else goto _L5
_L5:
    }

    private static byte[] zzg(byte abyte0[])
    {
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        GZIPOutputStream gzipoutputstream = new GZIPOutputStream(bytearrayoutputstream);
        gzipoutputstream.write(abyte0);
        gzipoutputstream.close();
        bytearrayoutputstream.close();
        return bytearrayoutputstream.toByteArray();
    }

    private URL zzh(zzab zzab1)
    {
        if (zzab1.zzkC())
        {
            zzab1 = (new StringBuilder()).append(zziv().zzjO()).append(zziv().zzjQ()).toString();
        } else
        {
            zzab1 = (new StringBuilder()).append(zziv().zzjP()).append(zziv().zzjQ()).toString();
        }
        try
        {
            zzab1 = new URL(zzab1);
        }
        // Misplaced declaration of an exception variable
        catch (zzab zzab1)
        {
            zze("Error trying to parse the hardcoded host url", zzab1);
            return null;
        }
        return zzab1;
    }

    private String zzi(zzab zzab1)
    {
        return String.valueOf(zzab1.zzkz());
    }

    private URL zzkL()
    {
        Object obj = (new StringBuilder()).append(zziv().zzjO()).append(zziv().zzjR()).toString();
        try
        {
            obj = new URL(((String) (obj)));
        }
        catch (MalformedURLException malformedurlexception)
        {
            zze("Error trying to parse the hardcoded host url", malformedurlexception);
            return null;
        }
        return ((URL) (obj));
    }

    static byte[] zzkM()
    {
        return zzPy;
    }

    String zza(zzab zzab1, boolean flag)
    {
        StringBuilder stringbuilder;
        zzx.zzw(zzab1);
        stringbuilder = new StringBuilder();
        try
        {
            Iterator iterator = zzab1.zzn().entrySet().iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
                String s = (String)entry.getKey();
                if (!"ht".equals(s) && !"qt".equals(s) && !"AppUID".equals(s) && !"z".equals(s) && !"_gmsv".equals(s))
                {
                    zza(stringbuilder, s, (String)entry.getValue());
                }
            } while (true);
        }
        // Misplaced declaration of an exception variable
        catch (zzab zzab1)
        {
            zze("Failed to encode name or value", zzab1);
            return null;
        }
        zza(stringbuilder, "ht", String.valueOf(zzab1.zzkA()));
        zza(stringbuilder, "qt", String.valueOf(zzit().currentTimeMillis() - zzab1.zzkA()));
        if (zziv().zzjA())
        {
            zza(stringbuilder, "_gmsv", zze.VERSION);
        }
        if (!flag) goto _L2; else goto _L1
_L1:
        long l = zzab1.zzkD();
        if (l == 0L) goto _L4; else goto _L3
_L3:
        zzab1 = String.valueOf(l);
_L6:
        zza(stringbuilder, "z", ((String) (zzab1)));
_L2:
        return stringbuilder.toString();
_L4:
        zzab1 = zzi(zzab1);
        if (true) goto _L6; else goto _L5
_L5:
    }

    List zza(List list, boolean flag)
    {
        zza zza1;
        ArrayList arraylist;
        boolean flag1;
        if (!list.isEmpty())
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        zzx.zzaa(flag1);
        zza("Uploading batched hits. compression, count", Boolean.valueOf(flag), Integer.valueOf(list.size()));
        zza1 = new zza();
        arraylist = new ArrayList();
        list = list.iterator();
        do
        {
            if (!list.hasNext())
            {
                break;
            }
            zzab zzab1 = (zzab)list.next();
            if (!zza1.zzj(zzab1))
            {
                break;
            }
            arraylist.add(Long.valueOf(zzab1.zzkz()));
        } while (true);
        if (zza1.zzkN() == 0)
        {
            return arraylist;
        }
        list = zzkL();
        if (list == null)
        {
            zzbe("Failed to build batching endpoint url");
            return Collections.emptyList();
        }
        int i;
        if (flag)
        {
            i = zzb(list, zza1.getPayload());
        } else
        {
            i = zza(((URL) (list)), zza1.getPayload());
        }
        if (200 == i)
        {
            zza("Batched upload completed. Hits batched", Integer.valueOf(zza1.zzkN()));
            return arraylist;
        }
        zza("Network error uploading hits. status code", Integer.valueOf(i));
        if (zziv().zzjU().contains(Integer.valueOf(i)))
        {
            zzbd("Server instructed the client to stop batching");
            zzPx.start();
        }
        return Collections.emptyList();
    }

    HttpURLConnection zzc(URL url)
    {
        url = url.openConnection();
        if (!(url instanceof HttpURLConnection))
        {
            throw new IOException("Failed to obtain http connection");
        } else
        {
            url = (HttpURLConnection)url;
            url.setDefaultUseCaches(false);
            url.setConnectTimeout(zziv().zzkd());
            url.setReadTimeout(zziv().zzke());
            url.setInstanceFollowRedirects(false);
            url.setRequestProperty("User-Agent", zzIa);
            url.setDoInput(true);
            return url;
        }
    }

    protected void zzhR()
    {
        zza("Network initialized. User agent", zzIa);
    }

    public boolean zzkK()
    {
        zzis();
        zziE();
        Object obj = (ConnectivityManager)getContext().getSystemService("connectivity");
        try
        {
            obj = ((ConnectivityManager) (obj)).getActiveNetworkInfo();
        }
        catch (SecurityException securityexception)
        {
            securityexception = null;
        }
        if (obj == null || !((NetworkInfo) (obj)).isConnected())
        {
            zzba("No network connectivity");
            return false;
        } else
        {
            return true;
        }
    }

    public List zzm(List list)
    {
        boolean flag2;
        flag2 = true;
        zzis();
        zziE();
        zzx.zzw(list);
        if (!zziv().zzjU().isEmpty() && zzPx.zzv(zziv().zzjN() * 1000L)) goto _L2; else goto _L1
_L1:
        boolean flag1 = false;
_L4:
        boolean flag;
        flag2 = false;
        flag = flag1;
_L3:
        if (flag)
        {
            return zza(list, flag2);
        } else
        {
            return zzn(list);
        }
_L2:
        if (zziv().zzjS() != zzm.zzNF)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        flag1 = flag;
        if (zziv().zzjT() != zzo.zzNQ) goto _L4; else goto _L3
    }

    List zzn(List list)
    {
        ArrayList arraylist = new ArrayList(list.size());
        list = list.iterator();
        do
        {
            if (!list.hasNext())
            {
                break;
            }
            zzab zzab1 = (zzab)list.next();
            if (!zzg(zzab1))
            {
                break;
            }
            arraylist.add(Long.valueOf(zzab1.zzkz()));
        } while (arraylist.size() < zziv().zzjL());
        return arraylist;
    }


    private class zza
    {

        private ByteArrayOutputStream zzPA;
        final zzah zzPB;
        private int zzPz;

        public byte[] getPayload()
        {
            return zzPA.toByteArray();
        }

        public boolean zzj(zzab zzab1)
        {
            zzx.zzw(zzab1);
            if (zzPz + 1 > zzPB.zziv().zzjM())
            {
                return false;
            }
            String s = zzPB.zza(zzab1, false);
            if (s == null)
            {
                zzPB.zziu().zza(zzab1, "Error formatting hit");
                return true;
            }
            byte abyte0[] = s.getBytes();
            int j = abyte0.length;
            if (j > zzPB.zziv().zzjE())
            {
                zzPB.zziu().zza(zzab1, "Hit size exceeds the maximum size limit");
                return true;
            }
            int i = j;
            if (zzPA.size() > 0)
            {
                i = j + 1;
            }
            if (i + zzPA.size() > zzPB.zziv().zzjG())
            {
                return false;
            }
            try
            {
                if (zzPA.size() > 0)
                {
                    zzPA.write(zzah.zzkM());
                }
                zzPA.write(abyte0);
            }
            // Misplaced declaration of an exception variable
            catch (zzab zzab1)
            {
                zzPB.zze("Failed to write payload when batching hits", zzab1);
                return true;
            }
            zzPz = zzPz + 1;
            return true;
        }

        public int zzkN()
        {
            return zzPz;
        }

        public zza()
        {
            zzPB = zzah.this;
            super();
            zzPA = new ByteArrayOutputStream();
        }
    }

}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzmn;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

// Referenced classes of package com.google.android.gms.measurement.internal:
//            zzy, zzu, zzc, zzv, 
//            zzp, zzn, zzab, zzag, 
//            zzs

public class zzq extends zzy
{
    static interface zza
    {

        public abstract void zza(int i, Throwable throwable, byte abyte0[]);
    }

    private static class zzb
        implements Runnable
    {

        private final zza zzaMY;
        private final Throwable zzaMZ;
        private final byte zzaNa[];
        private final int zzys;

        public void run()
        {
            zzaMY.zza(zzys, zzaMZ, zzaNa);
        }

        private zzb(zza zza1, int i, Throwable throwable, byte abyte0[])
        {
            zzaMY = zza1;
            zzys = i;
            zzaMZ = throwable;
            zzaNa = abyte0;
        }

    }

    private class zzc
        implements Runnable
    {

        private final byte zzaNb[];
        private final zza zzaNc;
        final zzq zzaNd;
        private final URL zzxG;

        public void run()
        {
            int k;
            boolean flag;
            boolean flag1;
            zzaNd.zzzn();
            flag1 = false;
            flag = false;
            k = 0;
            Object obj;
            byte abyte0[];
            abyte0 = zzaNd.zzzq().zzg(zzaNb);
            obj = zzaNd.zzc(zzxG);
            Object obj2;
            int i;
            int j = ((flag1) ? 1 : 0);
            i = ((flag) ? 1 : 0);
            Object obj1;
            IOException ioexception;
            Exception exception1;
            try
            {
                ((HttpURLConnection) (obj)).setDoOutput(true);
            }
            catch (IOException ioexception1)
            {
                obj1 = null;
                obj2 = obj;
                obj = ioexception1;
                continue; /* Loop/switch isn't completed */
            }
            finally
            {
                obj1 = null;
                obj2 = obj;
                obj = exception;
                continue; /* Loop/switch isn't completed */
            }
            j = ((flag1) ? 1 : 0);
            i = ((flag) ? 1 : 0);
            ((HttpURLConnection) (obj)).addRequestProperty("Content-Encoding", "gzip");
            j = ((flag1) ? 1 : 0);
            i = ((flag) ? 1 : 0);
            ((HttpURLConnection) (obj)).setFixedLengthStreamingMode(abyte0.length);
            j = ((flag1) ? 1 : 0);
            i = ((flag) ? 1 : 0);
            ((HttpURLConnection) (obj)).connect();
            j = ((flag1) ? 1 : 0);
            i = ((flag) ? 1 : 0);
            obj1 = ((HttpURLConnection) (obj)).getOutputStream();
            ((OutputStream) (obj1)).write(abyte0);
            ((OutputStream) (obj1)).close();
            j = ((flag1) ? 1 : 0);
            i = ((flag) ? 1 : 0);
            k = ((HttpURLConnection) (obj)).getResponseCode();
            j = k;
            i = k;
            obj1 = zzq.zza(zzaNd, ((HttpURLConnection) (obj)));
            if (false)
            {
                try
                {
                    throw new NullPointerException();
                }
                // Misplaced declaration of an exception variable
                catch (IOException ioexception)
                {
                    zzaNd.zzyd().zzzK().zzj("Error closing HTTP compressed POST connection output stream", ioexception);
                }
            }
            if (obj != null)
            {
                ((HttpURLConnection) (obj)).disconnect();
            }
            zzaNd.zzzr().zzh(new zzb(zzaNc, k, null, ((byte []) (obj1))));
            return;
            obj;
            i = 0;
            obj1 = null;
            obj2 = null;
_L4:
            if (obj1 != null)
            {
                try
                {
                    ((OutputStream) (obj1)).close();
                }
                // Misplaced declaration of an exception variable
                catch (Object obj1)
                {
                    zzaNd.zzyd().zzzK().zzj("Error closing HTTP compressed POST connection output stream", obj1);
                }
            }
            if (obj2 != null)
            {
                ((HttpURLConnection) (obj2)).disconnect();
            }
            zzaNd.zzzr().zzh(new zzb(zzaNc, i, ((Throwable) (obj)), null));
            return;
            obj;
            obj2 = null;
            obj1 = null;
            j = k;
_L2:
            if (obj1 != null)
            {
                try
                {
                    ((OutputStream) (obj1)).close();
                }
                // Misplaced declaration of an exception variable
                catch (Object obj1)
                {
                    zzaNd.zzyd().zzzK().zzj("Error closing HTTP compressed POST connection output stream", obj1);
                }
            }
            if (obj2 != null)
            {
                ((HttpURLConnection) (obj2)).disconnect();
            }
            zzaNd.zzzr().zzh(new zzb(zzaNc, j, null, null));
            throw obj;
            exception1;
            obj2 = obj;
            j = k;
            obj = exception1;
            if (true) goto _L2; else goto _L1
            IOException ioexception2;
            ioexception2;
            i = 0;
            obj2 = obj;
            obj = ioexception2;
            if (true) goto _L4; else goto _L3
_L3:
        }

        public zzc(URL url, byte abyte0[], zza zza1)
        {
            zzaNd = zzq.this;
            super();
            zzxG = url;
            zzaNb = abyte0;
            zzaNc = zza1;
        }
    }


    public zzq(zzv zzv)
    {
        super(zzv);
    }

    static byte[] zza(zzq zzq1, HttpURLConnection httpurlconnection)
        throws IOException
    {
        return zzq1.zzc(httpurlconnection);
    }

    private byte[] zzc(HttpURLConnection httpurlconnection)
        throws IOException
    {
        HttpURLConnection httpurlconnection1;
        byte abyte0[];
        abyte0 = null;
        httpurlconnection1 = abyte0;
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        httpurlconnection1 = abyte0;
        httpurlconnection = httpurlconnection.getInputStream();
        httpurlconnection1 = httpurlconnection;
        abyte0 = new byte[1024];
_L2:
        httpurlconnection1 = httpurlconnection;
        int i = httpurlconnection.read(abyte0);
        if (i <= 0)
        {
            break; /* Loop/switch isn't completed */
        }
        httpurlconnection1 = httpurlconnection;
        bytearrayoutputstream.write(abyte0, 0, i);
        if (true) goto _L2; else goto _L1
        httpurlconnection;
        if (httpurlconnection1 != null)
        {
            httpurlconnection1.close();
        }
        throw httpurlconnection;
_L1:
        httpurlconnection1 = httpurlconnection;
        abyte0 = bytearrayoutputstream.toByteArray();
        if (httpurlconnection != null)
        {
            httpurlconnection.close();
        }
        return abyte0;
    }

    public volatile Context getContext()
    {
        return super.getContext();
    }

    public void zza(URL url, byte abyte0[], zza zza1)
    {
        zzis();
        zziE();
        zzx.zzw(url);
        zzx.zzw(abyte0);
        zzx.zzw(zza1);
        zzzr().zzi(new zzc(url, abyte0, zza1));
    }

    protected HttpURLConnection zzc(URL url)
        throws IOException
    {
        url = url.openConnection();
        if (!(url instanceof HttpURLConnection))
        {
            throw new IOException("Failed to obtain HTTP connection");
        } else
        {
            url = (HttpURLConnection)url;
            url.setDefaultUseCaches(false);
            url.setConnectTimeout((int)zzzt().zzyY());
            url.setReadTimeout((int)zzzt().zzyZ());
            url.setInstanceFollowRedirects(false);
            url.setDoInput(true);
            return url;
        }
    }

    protected void zzhR()
    {
    }

    public volatile void zzir()
    {
        super.zzir();
    }

    public volatile void zzis()
    {
        super.zzis();
    }

    public volatile zzmn zzit()
    {
        return super.zzit();
    }

    public boolean zzkK()
    {
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
        return obj != null && ((NetworkInfo) (obj)).isConnected();
    }

    public volatile zzp zzyd()
    {
        return super.zzyd();
    }

    public volatile void zzzn()
    {
        super.zzzn();
    }

    public volatile zzn zzzo()
    {
        return super.zzzo();
    }

    public volatile zzab zzzp()
    {
        return super.zzzp();
    }

    public volatile zzag zzzq()
    {
        return super.zzzq();
    }

    public volatile zzu zzzr()
    {
        return super.zzzr();
    }

    public volatile zzs zzzs()
    {
        return super.zzzs();
    }

    public volatile com.google.android.gms.measurement.internal.zzc zzzt()
    {
        return super.zzzt();
    }
}

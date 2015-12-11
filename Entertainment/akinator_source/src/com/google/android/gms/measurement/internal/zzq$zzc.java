// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.measurement.internal;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

// Referenced classes of package com.google.android.gms.measurement.internal:
//            zzq, zzag, zzu, zzp

private class zzaNc
    implements Runnable
{

    private final byte zzaNb[];
    private final zzaNc zzaNc;
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
        zzaNd.zzzr().zzh(new <init>(zzaNc, k, null, ((byte []) (obj1)), null));
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
        zzaNd.zzzr().zzh(new <init>(zzaNc, i, ((Throwable) (obj)), null, null));
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
        zzaNd.zzzr().zzh(new <init>(zzaNc, j, null, null, null));
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

    public _cls9(zzq zzq1, URL url, byte abyte0[], _cls9 _pcls9)
    {
        zzaNd = zzq1;
        super();
        zzxG = url;
        zzaNb = abyte0;
        zzaNc = _pcls9;
    }
}

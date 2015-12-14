// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.util.client.zzb;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Locale;
import java.util.PriorityQueue;

// Referenced classes of package com.google.android.gms.internal:
//            zzbo, zzbl, zzbn, zzbp

public class zzbm
{

    private final int zzrL = 6;
    private final int zzrM;
    private final int zzrN = 0;
    private final zzbl zzrO = new zzbo();

    public zzbm(int i)
    {
        zzrM = i;
    }

    private String zzz(String s)
    {
        String as[];
        int i;
        as = s.split("\n");
        if (as.length == 0)
        {
            return "";
        }
        s = zzcv();
        Arrays.sort(as, new _cls1());
        i = 0;
_L2:
        if (i >= as.length || i >= zzrM)
        {
            break MISSING_BLOCK_LABEL_91;
        }
        if (as[i].trim().length() != 0)
        {
            break; /* Loop/switch isn't completed */
        }
_L3:
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        s.write(zzrO.zzy(as[i]));
          goto _L3
        IOException ioexception;
        ioexception;
        zzb.zzb("Error while writing hash to byteStream", ioexception);
        return s.toString();
    }

    String zzA(String s)
    {
        Iterator iterator;
        String as[] = s.split("\n");
        if (as.length == 0)
        {
            return "";
        }
        s = zzcv();
        PriorityQueue priorityqueue = new PriorityQueue(zzrM, new _cls2());
        int i = 0;
        while (i < as.length) 
        {
            String as1[] = zzbn.zzC(as[i]);
            if (as1.length >= zzrL)
            {
                zzbp.zza(as1, zzrM, zzrL, priorityqueue);
            }
            i++;
        }
        iterator = priorityqueue.iterator();
_L2:
        zzbp.zza zza1;
        if (!iterator.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        zza1 = (zzbp.zza)iterator.next();
        s.write(zzrO.zzy(zza1.zzrT));
        if (true) goto _L2; else goto _L1
        IOException ioexception;
        ioexception;
        zzb.zzb("Error while writing hash to byteStream", ioexception);
_L1:
        return s.toString();
    }

    public String zza(ArrayList arraylist)
    {
        StringBuffer stringbuffer = new StringBuffer();
        for (arraylist = arraylist.iterator(); arraylist.hasNext(); stringbuffer.append('\n'))
        {
            stringbuffer.append(((String)arraylist.next()).toLowerCase(Locale.US));
        }

        switch (zzrN)
        {
        default:
            return "";

        case 0: // '\0'
            return zzA(stringbuffer.toString());

        case 1: // '\001'
            return zzz(stringbuffer.toString());
        }
    }

    zza zzcv()
    {
        return new zza();
    }

    private class _cls1
        implements Comparator
    {

        final zzbm zzrP;

        public volatile int compare(Object obj, Object obj1)
        {
            return compare((String)obj, (String)obj1);
        }

        public int compare(String s, String s1)
        {
            return s1.length() - s.length();
        }

        _cls1()
        {
            zzrP = zzbm.this;
            super();
        }
    }


    private class zza
    {

        ByteArrayOutputStream zzrQ;
        Base64OutputStream zzrR;

        public String toString()
        {
            String s;
            try
            {
                zzrR.close();
            }
            catch (IOException ioexception)
            {
                zzb.zzb("HashManager: Unable to convert to Base64.", ioexception);
            }
            zzrQ.close();
            s = zzrQ.toString();
            zzrQ = null;
            zzrR = null;
            return s;
            Object obj;
            obj;
            zzb.zzb("HashManager: Unable to convert to Base64.", ((Throwable) (obj)));
            zzrQ = null;
            zzrR = null;
            return "";
            obj;
            zzrQ = null;
            zzrR = null;
            throw obj;
        }

        public void write(byte abyte0[])
        {
            zzrR.write(abyte0);
        }

        public zza()
        {
            zzrQ = new ByteArrayOutputStream(4096);
            zzrR = new Base64OutputStream(zzrQ, 10);
        }
    }


    private class _cls2
        implements Comparator
    {

        final zzbm zzrP;

        public int compare(Object obj, Object obj1)
        {
            return zza((zzbp.zza)obj, (zzbp.zza)obj1);
        }

        public int zza(zzbp.zza zza1, zzbp.zza zza2)
        {
            return (int)(zza1.value - zza2.value);
        }

        _cls2()
        {
            zzrP = zzbm.this;
            super();
        }
    }

}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.util.client.zzb;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;
import java.util.PriorityQueue;

// Referenced classes of package com.google.android.gms.internal:
//            zzbo, zzbl, zzbn, zzbp

public class zzbm
{

    private final int zzsp = 6;
    private final int zzsq;
    private final int zzsr = 0;
    private final zzbl zzss = new zzbo();

    public zzbm(int i)
    {
        zzsq = i;
    }

    private String zzA(String s)
    {
        String as[];
        int i;
        as = s.split("\n");
        if (as.length == 0)
        {
            return "";
        }
        s = zzcz();
        Arrays.sort(as, new Comparator() {

            final zzbm zzst;

            public volatile int compare(Object obj, Object obj1)
            {
                return compare((String)obj, (String)obj1);
            }

            public int compare(String s1, String s2)
            {
                return s2.length() - s1.length();
            }

            
            {
                zzst = zzbm.this;
                super();
            }
        });
        i = 0;
_L2:
        if (i >= as.length || i >= zzsq)
        {
            break; /* Loop/switch isn't completed */
        }
        if (as[i].trim().length() == 0)
        {
            break MISSING_BLOCK_LABEL_74;
        }
        s.write(zzss.zzz(as[i]));
        i++;
        if (true) goto _L2; else goto _L1
        IOException ioexception;
        ioexception;
        zzb.zzb("Error while writing hash to byteStream", ioexception);
_L1:
        return s.toString();
    }

    String zzB(String s)
    {
        Iterator iterator;
        String as[] = s.split("\n");
        if (as.length == 0)
        {
            return "";
        }
        s = zzcz();
        PriorityQueue priorityqueue = new PriorityQueue(zzsq, new Comparator() {

            final zzbm zzst;

            public int compare(Object obj, Object obj1)
            {
                return zza((zzbp.zza)obj, (zzbp.zza)obj1);
            }

            public int zza(zzbp.zza zza2, zzbp.zza zza3)
            {
                return (int)(zza2.value - zza3.value);
            }

            
            {
                zzst = zzbm.this;
                super();
            }
        });
        for (int i = 0; i < as.length; i++)
        {
            String as1[] = zzbn.zzD(as[i]);
            if (as1.length >= zzsp)
            {
                zzbp.zza(as1, zzsq, zzsp, priorityqueue);
            }
        }

        iterator = priorityqueue.iterator();
_L2:
        zzbp.zza zza1;
        if (!iterator.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        zza1 = (zzbp.zza)iterator.next();
        s.write(zzss.zzz(zza1.zzsx));
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

        switch (zzsr)
        {
        default:
            return "";

        case 0: // '\0'
            return zzB(stringbuffer.toString());

        case 1: // '\001'
            return zzA(stringbuffer.toString());
        }
    }

    zza zzcz()
    {
        return new zza();
    }

    private class zza
    {

        ByteArrayOutputStream zzsu;
        Base64OutputStream zzsv;

        public String toString()
        {
            String s;
            try
            {
                zzsv.close();
            }
            catch (IOException ioexception)
            {
                zzb.zzb("HashManager: Unable to convert to Base64.", ioexception);
            }
            zzsu.close();
            s = zzsu.toString();
            zzsu = null;
            zzsv = null;
            return s;
            Object obj;
            obj;
            zzb.zzb("HashManager: Unable to convert to Base64.", ((Throwable) (obj)));
            zzsu = null;
            zzsv = null;
            return "";
            obj;
            zzsu = null;
            zzsv = null;
            throw obj;
        }

        public void write(byte abyte0[])
        {
            zzsv.write(abyte0);
        }

        public zza()
        {
            zzsu = new ByteArrayOutputStream(4096);
            zzsv = new Base64OutputStream(zzsu, 10);
        }
    }

}

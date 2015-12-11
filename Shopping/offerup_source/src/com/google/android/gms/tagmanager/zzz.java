// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.tagmanager;

import android.content.Context;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

// Referenced classes of package com.google.android.gms.tagmanager:
//            zzar, zzat, zzcs, zzcd, 
//            zzbg, zzas

public class zzz
    implements zzar
{

    private static final Object zzaVD = new Object();
    private static zzz zzaWQ;
    private String zzaWR;
    private String zzaWS;
    private zzas zzaWT;
    private zzcd zzaWg;

    private zzz(Context context)
    {
        this(((zzas) (zzat.zzaQ(context))), ((zzcd) (new zzcs())));
    }

    zzz(zzas zzas1, zzcd zzcd1)
    {
        zzaWT = zzas1;
        zzaWg = zzcd1;
    }

    public static zzar zzaO(Context context)
    {
        synchronized (zzaVD)
        {
            if (zzaWQ == null)
            {
                zzaWQ = new zzz(context);
            }
            context = zzaWQ;
        }
        return context;
        context;
        obj;
        JVM INSTR monitorexit ;
        throw context;
    }

    public boolean zzeN(String s)
    {
        if (!zzaWg.zzkF())
        {
            zzbg.zzaH("Too many urls sent too quickly with the TagManagerSender, rate limiting invoked.");
            return false;
        }
        String s1 = s;
        if (zzaWR != null)
        {
            s1 = s;
            if (zzaWS != null)
            {
                try
                {
                    s1 = (new StringBuilder()).append(zzaWR).append("?").append(zzaWS).append("=").append(URLEncoder.encode(s, "UTF-8")).toString();
                    zzbg.v((new StringBuilder("Sending wrapped url hit: ")).append(s1).toString());
                }
                // Misplaced declaration of an exception variable
                catch (String s)
                {
                    zzbg.zzd("Error wrapping URL for testing.", s);
                    return false;
                }
            }
        }
        zzaWT.zzeR(s1);
        return true;
    }

}

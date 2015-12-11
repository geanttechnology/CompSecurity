// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.tagmanager;

import android.content.Context;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

// Referenced classes of package com.google.android.gms.tagmanager:
//            aq, as, cw, cg, 
//            bh, ar

class y
    implements aq
{

    private static y UO;
    private static final Object qI = new Object();
    private String UP;
    private String UQ;
    private ar UR;
    private cg Uc;

    private y(Context context)
    {
        this(((ar) (as.H(context))), ((cg) (new cw())));
    }

    y(ar ar1, cg cg1)
    {
        UR = ar1;
        Uc = cg1;
    }

    public static aq F(Context context)
    {
        synchronized (qI)
        {
            if (UO == null)
            {
                UO = new y(context);
            }
            context = UO;
        }
        return context;
        context;
        obj;
        JVM INSTR monitorexit ;
        throw context;
    }

    public boolean bk(String s)
    {
        if (!Uc.cl())
        {
            bh.w("Too many urls sent too quickly with the TagManagerSender, rate limiting invoked.");
            return false;
        }
        String s1 = s;
        if (UP != null)
        {
            s1 = s;
            if (UQ != null)
            {
                try
                {
                    s1 = (new StringBuilder()).append(UP).append("?").append(UQ).append("=").append(URLEncoder.encode(s, "UTF-8")).toString();
                    bh.v((new StringBuilder()).append("Sending wrapped url hit: ").append(s1).toString());
                }
                // Misplaced declaration of an exception variable
                catch (String s)
                {
                    bh.b("Error wrapping URL for testing.", s);
                    return false;
                }
            }
        }
        UR.bn(s1);
        return true;
    }

}

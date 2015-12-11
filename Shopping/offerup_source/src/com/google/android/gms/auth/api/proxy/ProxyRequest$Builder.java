// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.auth.api.proxy;

import android.os.Bundle;
import android.util.Patterns;
import com.google.android.gms.common.internal.zzx;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package com.google.android.gms.auth.api.proxy:
//            ProxyRequest

public class zzSL
{

    private String zzSL;
    private int zzSM;
    private long zzSN;
    private byte zzSO[];
    private Bundle zzSP;

    public ProxyRequest build()
    {
        if (zzSO == null)
        {
            zzSO = new byte[0];
        }
        return new ProxyRequest(2, zzSL, zzSM, zzSN, zzSO, zzSP);
    }

    public zzSP putHeader(String s, String s1)
    {
        zzx.zzh(s, "Header name cannot be null or empty!");
        Bundle bundle = zzSP;
        String s2 = s1;
        if (s1 == null)
        {
            s2 = "";
        }
        bundle.putString(s, s2);
        return this;
    }

    public zzSP setBody(byte abyte0[])
    {
        zzSO = abyte0;
        return this;
    }

    public zzSO setHttpMethod(int i)
    {
        boolean flag;
        if (i >= 0 && i <= ProxyRequest.LAST_CODE)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zzb(flag, "Unrecognized http method code.");
        zzSM = i;
        return this;
    }

    public zzSM setTimeoutMillis(long l)
    {
        boolean flag;
        if (l >= 0L)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zzb(flag, "The specified timeout must be non-negative.");
        zzSN = l;
        return this;
    }

    public (String s)
    {
        zzSM = ProxyRequest.HTTP_METHOD_GET;
        zzSN = 3000L;
        zzSO = null;
        zzSP = new Bundle();
        zzx.zzcr(s);
        if (Patterns.WEB_URL.matcher(s).matches())
        {
            zzSL = s;
            return;
        } else
        {
            throw new IllegalArgumentException((new StringBuilder("The supplied url [ ")).append(s).append("] is not match Patterns.WEB_URL!").toString());
        }
    }
}

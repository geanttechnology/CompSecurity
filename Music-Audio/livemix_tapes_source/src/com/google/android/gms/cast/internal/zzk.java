// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.cast.internal;

import java.nio.charset.Charset;
import java.nio.charset.IllegalCharsetNameException;
import java.nio.charset.UnsupportedCharsetException;

// Referenced classes of package com.google.android.gms.cast.internal:
//            zzf

public final class zzk
{

    public static final com.google.android.gms.common.api.Api.zzc zzQf;
    public static final String zzXs;
    public static final String zzXt;
    public static final Charset zzXu;

    static 
    {
        Charset charset;
        zzQf = new com.google.android.gms.common.api.Api.zzc();
        zzXs = zzf.zzbM("com.google.cast.receiver");
        zzXt = zzf.zzbM("com.google.cast.tp.connection");
        charset = null;
        Charset charset1 = Charset.forName("UTF-8");
        charset = charset1;
_L2:
        zzXu = charset;
        return;
        Object obj;
        obj;
        continue; /* Loop/switch isn't completed */
        obj;
        if (true) goto _L2; else goto _L1
_L1:
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal.request;

import android.content.Context;
import android.support.v7.ng;
import android.support.v7.nj;
import android.support.v7.nn;
import android.support.v7.sf;
import android.support.v7.sg;

// Referenced classes of package com.google.android.gms.ads.internal.request:
//            zzd, AdRequestInfoParcel, zzj

public static final class mContext extends zzd
{

    private final Context mContext;

    public void zzfx()
    {
    }

    public zzj zzfy()
    {
        ng ng1 = new ng((String)nn.b.c());
        return sg.a(mContext, ng1, sf.a());
    }

    public tInfoParcel(Context context, AdRequestInfoParcel adrequestinfoparcel, tInfoParcel tinfoparcel)
    {
        super(adrequestinfoparcel, tinfoparcel);
        mContext = context;
    }
}

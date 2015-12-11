// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.plus.internal;

import android.net.Uri;
import android.os.Bundle;
import android.os.IInterface;
import com.google.android.gms.common.internal.ICancelToken;
import com.google.android.gms.common.server.FavaDiagnosticsEntity;
import com.google.android.gms.common.server.response.SafeParcelResponse;
import java.util.List;

// Referenced classes of package com.google.android.gms.plus.internal:
//            zzb

public interface zzd
    extends IInterface
{

    public abstract String getAccountName();

    public abstract String getAuthCode();

    public abstract ICancelToken zza(zzb zzb1, int i, int j, int k, String s);

    public abstract void zza(SafeParcelResponse safeparcelresponse);

    public abstract void zza(zzb zzb1);

    public abstract void zza(zzb zzb1, int i, String s, Uri uri, String s1, String s2);

    public abstract void zza(zzb zzb1, Uri uri, Bundle bundle);

    public abstract void zza(zzb zzb1, SafeParcelResponse safeparcelresponse);

    public abstract void zza(zzb zzb1, String s);

    public abstract void zza(zzb zzb1, String s, String s1);

    public abstract void zza(zzb zzb1, List list);

    public abstract void zza(String s, FavaDiagnosticsEntity favadiagnosticsentity, FavaDiagnosticsEntity favadiagnosticsentity1);

    public abstract void zzb(zzb zzb1);

    public abstract void zzb(zzb zzb1, String s);

    public abstract void zzc(zzb zzb1, String s);

    public abstract void zzd(zzb zzb1, String s);

    public abstract void zzdp(String s);

    public abstract void zze(zzb zzb1, String s);

    public abstract void zzvv();

    public abstract boolean zzvw();

    public abstract String zzvx();
}

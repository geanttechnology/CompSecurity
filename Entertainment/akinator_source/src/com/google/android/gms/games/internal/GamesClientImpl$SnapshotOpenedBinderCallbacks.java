// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.Contents;

// Referenced classes of package com.google.android.gms.games.internal:
//            AbstractGamesCallbacks, GamesClientImpl

private static final class zzawx extends AbstractGamesCallbacks
{

    private final com.google.android.gms.internal.init> zzawx;

    public void zza(DataHolder dataholder, Contents contents)
    {
        zzawx.zzawx(new zzawx(dataholder, contents));
    }

    public void zza(DataHolder dataholder, String s, Contents contents, Contents contents1, Contents contents2)
    {
        zzawx.zzawx(new zzawx(dataholder, s, contents, contents1, contents2));
    }

    public Y(com.google.android.gms.internal.backs backs)
    {
        zzawx = (com.google.android.gms.internal.backs.zzawx)zzx.zzb(backs, "Holder must not be null");
    }
}

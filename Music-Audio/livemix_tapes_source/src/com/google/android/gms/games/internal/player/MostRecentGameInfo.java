// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal.player;

import android.net.Uri;
import android.os.Parcelable;
import com.google.android.gms.common.data.Freezable;

public interface MostRecentGameInfo
    extends Parcelable, Freezable
{

    public abstract String zzuG();

    public abstract String zzuH();

    public abstract long zzuI();

    public abstract Uri zzuJ();

    public abstract Uri zzuK();

    public abstract Uri zzuL();
}

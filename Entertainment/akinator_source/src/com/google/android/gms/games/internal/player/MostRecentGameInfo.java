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

    public abstract Uri zzvA();

    public abstract Uri zzvB();

    public abstract String zzvw();

    public abstract String zzvx();

    public abstract long zzvy();

    public abstract Uri zzvz();
}

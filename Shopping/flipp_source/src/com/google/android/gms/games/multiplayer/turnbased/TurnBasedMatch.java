// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.multiplayer.turnbased;

import android.os.Bundle;
import android.os.Parcelable;
import com.google.android.gms.common.data.d;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.multiplayer.f;

public interface TurnBasedMatch
    extends Parcelable, d, f
{

    public static final int a_[] = {
        0, 1, 2, 3
    };

    public abstract Game b();

    public abstract String c();

    public abstract String d();

    public abstract long e();

    public abstract int f();

    public abstract int g();

    public abstract int h();

    public abstract String j();

    public abstract long k();

    public abstract String l();

    public abstract byte[] m();

    public abstract int n();

    public abstract String o();

    public abstract byte[] p();

    public abstract int q();

    public abstract Bundle r();

    public abstract int s();

    public abstract boolean t();

}

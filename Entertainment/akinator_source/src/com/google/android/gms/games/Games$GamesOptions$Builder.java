// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games;

import java.util.ArrayList;

// Referenced classes of package com.google.android.gms.games:
//            Games

public static final class <init>
{

    boolean zzatS;
    boolean zzatT;
    int zzatU;
    boolean zzatV;
    int zzatW;
    String zzatX;
    ArrayList zzatY;

    public <init> build()
    {
        return new <init>(this, null);
    }

    public <init> setSdkVariant(int i)
    {
        zzatW = i;
        return this;
    }

    public zzatW setShowConnectingPopup(boolean flag)
    {
        zzatT = flag;
        zzatU = 17;
        return this;
    }

    public zzatU setShowConnectingPopup(boolean flag, int i)
    {
        zzatT = flag;
        zzatU = i;
        return this;
    }

    private ()
    {
        zzatS = false;
        zzatT = true;
        zzatU = 17;
        zzatV = false;
        zzatW = 4368;
        zzatX = null;
        zzatY = new ArrayList();
    }

    zzatY(zzatY zzaty)
    {
        this();
    }
}

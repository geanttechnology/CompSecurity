// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games;

import java.util.ArrayList;

// Referenced classes of package com.google.android.gms.games:
//            Games

public static final class <init>
{

    String zzarA;
    ArrayList zzarB;
    boolean zzarv;
    boolean zzarw;
    int zzarx;
    boolean zzary;
    int zzarz;

    public <init> build()
    {
        return new <init>(this, null);
    }

    public <init> setSdkVariant(int i)
    {
        zzarz = i;
        return this;
    }

    public zzarz setShowConnectingPopup(boolean flag)
    {
        zzarw = flag;
        zzarx = 17;
        return this;
    }

    public zzarx setShowConnectingPopup(boolean flag, int i)
    {
        zzarw = flag;
        zzarx = i;
        return this;
    }

    private ()
    {
        zzarv = false;
        zzarw = true;
        zzarx = 17;
        zzary = false;
        zzarz = 4368;
        zzarA = null;
        zzarB = new ArrayList();
    }

    zzarB(zzarB zzarb)
    {
        this();
    }
}

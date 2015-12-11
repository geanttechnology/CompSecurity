// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games;


// Referenced classes of package com.google.android.gms.games:
//            Games

public static final class <init>
{

    boolean ta;
    boolean tb;
    int tc;
    int td;

    public <init> build()
    {
        return new <init>(this, null);
    }

    public <init> setSdkVariant(int i)
    {
        td = i;
        return this;
    }

    public td setShowConnectingPopup(boolean flag)
    {
        tb = flag;
        tc = 17;
        return this;
    }

    public tc setShowConnectingPopup(boolean flag, int i)
    {
        tb = flag;
        tc = i;
        return this;
    }

    private ()
    {
        ta = false;
        tb = true;
        tc = 17;
        td = 4368;
    }

    td(td td1)
    {
        this();
    }
}

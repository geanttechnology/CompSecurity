// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads;

import android.os.Bundle;
import java.util.Date;

// Referenced classes of package com.google.android.gms.ads:
//            AdRequest

public static final class 
{

    private final com.google.android.gms.internal. kq = new com.google.android.gms.internal.();

    static com.google.android.gms.internal. a( )
    {
        return .kq;
    }

    public kq addKeyword(String s)
    {
        kq.(s);
        return this;
    }

    public kq addNetworkExtrasBundle(Class class1, Bundle bundle)
    {
        kq.(class1, bundle);
        return this;
    }

    public kq addTestDevice(String s)
    {
        kq.(s);
        return this;
    }

    public AdRequest build()
    {
        return new AdRequest(this, null);
    }

    public kq setBirthday(Date date)
    {
        kq.(date);
        return this;
    }

    public kq setGender(int i)
    {
        kq.(i);
        return this;
    }

    public kq tagForChildDirectedTreatment(boolean flag)
    {
        kq.(flag);
        return this;
    }

    public ()
    {
    }
}

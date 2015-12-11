// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.network.managers;

import com.smule.android.network.core.o;
import com.smule.android.network.core.t;
import java.util.ArrayList;
import java.util.List;

public class ab extends t
{

    public List mAccountIcons;

    public ab()
    {
        mAccountIcons = new ArrayList();
    }

    static ab a(o o)
    {
        return (ab)a(o, com/smule/android/network/managers/ab);
    }

    public String toString()
    {
        return (new StringBuilder()).append("RecommedationResponse[singers=").append(mAccountIcons).append("]").toString();
    }
}

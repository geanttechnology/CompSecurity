// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import com.mopub.common.m;
import java.io.Serializable;

public class ae
    implements Serializable
{

    protected final String a;
    public boolean b;
    public boolean c;

    public ae(String s)
    {
        m.a(s);
        a = s;
    }

    public final String a()
    {
        return a;
    }
}

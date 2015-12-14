// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.chat;

import java.util.List;
import org.jivesoftware.smack.packet.IQ;

// Referenced classes of package com.cyberlink.you.chat:
//            m

class k
{

    public int a;
    public IQ b;
    public int c;
    public Object d;
    public String e;
    public String f;
    public m g;
    private List h;

    private k()
    {
    }

    k(j._cls1 _pcls1)
    {
        this();
    }

    static List a(k k1)
    {
        return k1.h;
    }

    static List a(k k1, List list)
    {
        k1.h = list;
        return list;
    }
}

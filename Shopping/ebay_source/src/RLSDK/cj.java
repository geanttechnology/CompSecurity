// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package RLSDK;


// Referenced classes of package RLSDK:
//            cm, v, ag

abstract class cj extends cm
{

    cj(ag ag1)
    {
        super(ag1);
    }

    public final String a()
        throws v
    {
        if (a.b != 60)
        {
            throw v.a();
        } else
        {
            StringBuffer stringbuffer = new StringBuffer();
            b(stringbuffer, 5);
            b(stringbuffer, 45, 15);
            return stringbuffer.toString();
        }
    }
}

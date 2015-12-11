// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package RLSDK;


// Referenced classes of package RLSDK:
//            cl, v, cw, ag

final class ck extends cl
{

    ck(ag ag)
    {
        super(ag);
    }

    public final String a()
        throws v
    {
        StringBuffer stringbuffer = new StringBuffer();
        stringbuffer.append("(01)");
        int i = stringbuffer.length();
        stringbuffer.append(b.a(4, 4));
        a(stringbuffer, 8, i);
        return b.a(stringbuffer, 48);
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package RLSDK;


// Referenced classes of package RLSDK:
//            cl, v, ag, cw, 
//            cs

final class ch extends cl
{

    ch(ag ag1)
    {
        super(ag1);
    }

    public final String a()
        throws v
    {
        if (a.b < 48)
        {
            throw v.a();
        }
        StringBuffer stringbuffer = new StringBuffer();
        b(stringbuffer, 8);
        int i = b.a(48, 2);
        stringbuffer.append("(393");
        stringbuffer.append(i);
        stringbuffer.append(')');
        i = b.a(50, 10);
        if (i / 100 == 0)
        {
            stringbuffer.append('0');
        }
        if (i / 10 == 0)
        {
            stringbuffer.append('0');
        }
        stringbuffer.append(i);
        stringbuffer.append(b.a(60, null).a());
        return stringbuffer.toString();
    }
}

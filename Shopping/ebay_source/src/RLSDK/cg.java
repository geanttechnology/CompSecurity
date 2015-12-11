// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package RLSDK;


// Referenced classes of package RLSDK:
//            cl, v, ag, cw, 
//            cs

final class cg extends cl
{

    cg(ag ag1)
    {
        super(ag1);
    }

    public final String a()
        throws v
    {
        if (a.b < 48)
        {
            throw v.a();
        } else
        {
            StringBuffer stringbuffer = new StringBuffer();
            b(stringbuffer, 8);
            int i = b.a(48, 2);
            stringbuffer.append("(392");
            stringbuffer.append(i);
            stringbuffer.append(')');
            stringbuffer.append(b.a(50, null).a());
            return stringbuffer.toString();
        }
    }
}

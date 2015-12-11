// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package RLSDK;


// Referenced classes of package RLSDK:
//            cj, ag

final class cf extends cj
{

    cf(ag ag)
    {
        super(ag);
    }

    protected final int a(int i)
    {
        if (i < 10000)
        {
            return i;
        } else
        {
            return i - 10000;
        }
    }

    protected final void a(StringBuffer stringbuffer, int i)
    {
        if (i < 10000)
        {
            stringbuffer.append("(3202)");
            return;
        } else
        {
            stringbuffer.append("(3203)");
            return;
        }
    }
}

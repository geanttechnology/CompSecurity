// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package RLSDK;


// Referenced classes of package RLSDK:
//            s, cy, cz, ah, 
//            am

public final class da
{

    public da()
    {
    }

    public static am a(ah ah)
        throws s
    {
label0:
        {
            cy cy1 = new cy(ah);
            ah = cy1.a();
            if (ah == null || ah.length == 0)
            {
                throw s.a();
            }
            int i = 1 << cy1.c() + 1;
            int ai[] = cy1.b();
            if (ai != null && ai.length > i / 2 + 3 || i < 0 || i > 512)
            {
                throw s.a();
            }
            if (ai != null && ai.length > 3)
            {
                throw s.a();
            }
            if (ah.length < 4)
            {
                throw s.a();
            }
            int j = ah[0];
            if (j > ah.length)
            {
                throw s.a();
            }
            if (j == 0)
            {
                if (i >= ah.length)
                {
                    break label0;
                }
                ah[0] = ah.length - i;
            }
            return cz.a(ah);
        }
        throw s.a();
    }
}

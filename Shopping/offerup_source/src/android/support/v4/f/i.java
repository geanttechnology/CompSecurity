// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.f;


// Referenced classes of package android.support.v4.f:
//            m, k, j, n, 
//            h

public final class i
{

    public static final h a;
    public static final h b;

    static int a(int l)
    {
        switch (l)
        {
        default:
            return 2;

        case 0: // '\0'
        case 14: // '\016'
        case 15: // '\017'
            return 1;

        case 1: // '\001'
        case 2: // '\002'
        case 16: // '\020'
        case 17: // '\021'
            return 0;
        }
    }

    static int b(int l)
    {
        switch (l)
        {
        default:
            return 2;

        case 0: // '\0'
            return 1;

        case 1: // '\001'
        case 2: // '\002'
            return 0;
        }
    }

    static 
    {
        new m(null, false, (byte)0);
        new m(null, true, (byte)0);
        a = new m(k.a, false, (byte)0);
        b = new m(k.a, true, (byte)0);
        new m(j.a, false, (byte)0);
        n n1 = n.a;
    }
}

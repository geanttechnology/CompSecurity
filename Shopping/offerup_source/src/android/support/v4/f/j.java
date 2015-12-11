// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.f;


// Referenced classes of package android.support.v4.f:
//            l, i

final class j
    implements l
{

    public static final j a = new j(true);
    private final boolean b;

    private j(boolean flag)
    {
        b = flag;
    }

    public final int a(CharSequence charsequence, int k, int i1)
    {
        int j1;
        boolean flag;
        boolean flag1;
        flag1 = true;
        flag = false;
        j1 = k;
_L6:
        int k1 = j1;
        if (k1 >= k + i1) goto _L2; else goto _L1
_L1:
        i.b(Character.getDirectionality(charsequence.charAt(k1)));
        JVM INSTR tableswitch 0 1: default 56
    //                   0 77
    //                   1 96;
           goto _L3 _L4 _L5
_L3:
        j1 = ((flag) ? 1 : 0);
_L9:
        k1++;
        flag = j1;
        j1 = k1;
          goto _L6
_L4:
        if (!b) goto _L8; else goto _L7
_L7:
        j1 = 0;
_L11:
        return j1;
_L8:
        j1 = 1;
          goto _L9
_L5:
        j1 = ((flag1) ? 1 : 0);
        if (!b) goto _L11; else goto _L10
_L10:
        j1 = 1;
          goto _L9
_L2:
        if (!flag) goto _L13; else goto _L12
_L12:
        j1 = ((flag1) ? 1 : 0);
        if (!b)
        {
            return 0;
        }
          goto _L11
_L13:
        return 2;
          goto _L9
    }

    static 
    {
        new j(false);
    }
}

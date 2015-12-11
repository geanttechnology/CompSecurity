// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.f;


// Referenced classes of package android.support.v4.f:
//            l, i

final class k
    implements l
{

    public static final k a = new k();

    private k()
    {
    }

    public final int a(CharSequence charsequence, int j, int i1)
    {
        int k1 = 2;
        for (int j1 = j; j1 < j + i1 && k1 == 2; j1++)
        {
            k1 = i.a(Character.getDirectionality(charsequence.charAt(j1)));
        }

        return k1;
    }

}

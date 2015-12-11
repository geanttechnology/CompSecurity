// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;


// Referenced classes of package android.support.v7:
//            ez, fb, ev

class ex
{

    static ev a(int i)
    {
        if (i == 0)
        {
            return new ez();
        }
        if (i == 1)
        {
            return new fb();
        } else
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Invalid display type ").append(i).toString());
        }
    }
}

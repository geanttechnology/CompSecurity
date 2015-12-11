// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;


// Referenced classes of package android.support.v7:
//            fa, fd, fc, ait, 
//            ew

public class ey
{

    static ew a(int i, ait ait)
    {
        if (i == 0)
        {
            return new fa();
        }
        if (i == 1)
        {
            return new fd(ait);
        }
        if (i == 2)
        {
            return new fc(ait);
        } else
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Invalid display type ").append(i).toString());
        }
    }
}

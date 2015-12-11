// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;


// Referenced classes of package android.support.v7:
//            gc, ga, fz

public class gb
{

    public static fz a(int i)
    {
        if (i == 0)
        {
            return new gc();
        }
        if (i == 1)
        {
            return new ga();
        } else
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Invalid downloader type requested : ").append(i).toString());
        }
    }
}

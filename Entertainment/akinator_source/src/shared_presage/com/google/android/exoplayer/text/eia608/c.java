// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.android.exoplayer.text.eia608;


// Referenced classes of package shared_presage.com.google.android.exoplayer.text.eia608:
//            a

final class c
    implements Comparable
{

    public final long a;
    public final boolean b;
    public final a c[];

    public c(long l, boolean flag, a aa[])
    {
        a = l;
        b = flag;
        c = aa;
    }

    public final volatile int compareTo(Object obj)
    {
        obj = (c)obj;
        long l = a - ((c) (obj)).a;
        if (l == 0L)
        {
            return 0;
        }
        return l <= 0L ? -1 : 1;
    }
}

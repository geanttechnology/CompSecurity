// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;


// Referenced classes of package android.support.v7:
//            amy

static class c
{

    static final oString a = new <init>(0, 0);
    final int b;
    final int c;

    public String toString()
    {
        return (new StringBuilder()).append(getClass().getSimpleName()).append("[").append("position = ").append(b).append(", length = ").append(c).append("]").toString();
    }


    (int i, int j)
    {
        b = i;
        c = j;
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


class buh
{

    static final buh a = new buh(0, 0);
    final int b;
    final int c;

    buh(int i, int j)
    {
        b = i;
        c = j;
    }

    public String toString()
    {
        return (new StringBuilder()).append(getClass().getSimpleName()).append("[").append("position = ").append(b).append(", length = ").append(c).append("]").toString();
    }

}

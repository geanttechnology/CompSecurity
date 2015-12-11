// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.gson.internal;


// Referenced classes of package shared_presage.com.google.gson.internal:
//            Streams

static final class _cls9
    implements CharSequence
{

    char a[];

    public final char charAt(int i)
    {
        return a[i];
    }

    public final int length()
    {
        return a.length;
    }

    public final CharSequence subSequence(int i, int j)
    {
        return new String(a, i, j - i);
    }

    _cls9()
    {
    }
}

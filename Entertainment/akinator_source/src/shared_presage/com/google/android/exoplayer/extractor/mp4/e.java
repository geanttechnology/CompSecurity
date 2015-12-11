// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.android.exoplayer.extractor.mp4;

import shared_presage.com.google.android.exoplayer.util.ParsableByteArray;

final class e
{

    public int a;
    public int b;
    public int c[];
    public int d[];
    public long e[];
    public boolean f[];
    public boolean g;
    public boolean h[];
    public int i;
    public ParsableByteArray j;
    public boolean k;

    e()
    {
    }

    public final void a(int l)
    {
        if (j == null || j.limit() < l)
        {
            j = new ParsableByteArray(l);
        }
        i = l;
        g = true;
        k = true;
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.android.exoplayer.text.webvtt;

import shared_presage.com.google.android.exoplayer.text.Cue;

final class a extends Cue
{

    public final long a;
    public final long b;

    public a(long l, long l1, CharSequence charsequence, int i, int j, 
            android.text.Layout.Alignment alignment, int k)
    {
        super(charsequence, i, j, alignment, k);
        a = l;
        b = l1;
    }

    public a(CharSequence charsequence)
    {
        this(charsequence, (byte)0);
    }

    private a(CharSequence charsequence, byte byte0)
    {
        this(-1L, -1L, charsequence, -1, -1, null, -1);
    }

    public final boolean a()
    {
        return line == -1 && position == -1;
    }
}

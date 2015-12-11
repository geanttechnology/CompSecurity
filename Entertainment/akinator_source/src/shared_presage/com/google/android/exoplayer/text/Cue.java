// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.android.exoplayer.text;


public class Cue
{

    public static final int UNSET_VALUE = -1;
    public final android.text.Layout.Alignment alignment;
    public final int line;
    public final int position;
    public final int size;
    public final CharSequence text;

    public Cue()
    {
        this(null);
    }

    public Cue(CharSequence charsequence)
    {
        this(charsequence, -1, -1, null, -1);
    }

    public Cue(CharSequence charsequence, int i, int j, android.text.Layout.Alignment alignment1, int k)
    {
        text = charsequence;
        line = i;
        position = j;
        alignment = alignment1;
        size = k;
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.android.exoplayer;


// Referenced classes of package shared_presage.com.google.android.exoplayer:
//            ExoPlayer, b

public static final class 
{

    public static final int DEFAULT_MIN_BUFFER_MS = 2500;
    public static final int DEFAULT_MIN_REBUFFER_MS = 5000;

    public static ExoPlayer newInstance(int i)
    {
        return new b(i, 2500, 5000);
    }

    public static ExoPlayer newInstance(int i, int j, int k)
    {
        return new b(i, j, k);
    }

    private ()
    {
    }
}

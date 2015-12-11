// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.android.exoplayer.audio;


// Referenced classes of package shared_presage.com.google.android.exoplayer.audio:
//            AudioTrack

public static final class errorCode extends Exception
{

    public final int errorCode;

    public Q(int i)
    {
        super((new StringBuilder("AudioTrack write failed: ")).append(i).toString());
        errorCode = i;
    }
}

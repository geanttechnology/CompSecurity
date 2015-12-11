// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.android.exoplayer.extractor;


// Referenced classes of package shared_presage.com.google.android.exoplayer.extractor:
//            b

public interface SeekMap
{

    public static final SeekMap UNSEEKABLE = new b();

    public abstract long getPosition(long l);

    public abstract boolean isSeekable();

}

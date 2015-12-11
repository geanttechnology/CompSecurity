// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package twitter4j;


// Referenced classes of package twitter4j:
//            MediaEntity

public interface ExtendedMediaEntity
    extends MediaEntity
{

    public abstract int getVideoAspectRatioHeight();

    public abstract int getVideoAspectRatioWidth();

    public abstract long getVideoDurationMillis();

    public abstract Variant[] getVideoVariants();
}

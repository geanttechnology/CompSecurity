// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.android.exoplayer.text;

import java.io.InputStream;

// Referenced classes of package shared_presage.com.google.android.exoplayer.text:
//            Subtitle

public interface SubtitleParser
{

    public abstract boolean canParse(String s);

    public abstract Subtitle parse(InputStream inputstream, String s, long l);
}

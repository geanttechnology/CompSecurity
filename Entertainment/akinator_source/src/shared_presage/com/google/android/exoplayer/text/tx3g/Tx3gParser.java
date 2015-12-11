// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.android.exoplayer.text.tx3g;

import java.io.DataInputStream;
import java.io.InputStream;
import shared_presage.com.google.android.exoplayer.text.Cue;
import shared_presage.com.google.android.exoplayer.text.Subtitle;
import shared_presage.com.google.android.exoplayer.text.SubtitleParser;

// Referenced classes of package shared_presage.com.google.android.exoplayer.text.tx3g:
//            a

public final class Tx3gParser
    implements SubtitleParser
{

    public Tx3gParser()
    {
    }

    public final boolean canParse(String s)
    {
        return "application/x-quicktime-tx3g".equals(s);
    }

    public final Subtitle parse(InputStream inputstream, String s, long l)
    {
        return new a(l, new Cue((new DataInputStream(inputstream)).readUTF()));
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.text.tx3g;

import com.google.android.exoplayer.text.Cue;
import com.google.android.exoplayer.text.Subtitle;
import com.google.android.exoplayer.text.SubtitleParser;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

// Referenced classes of package com.google.android.exoplayer.text.tx3g:
//            Tx3gSubtitle

public final class Tx3gParser
    implements SubtitleParser
{

    public Tx3gParser()
    {
    }

    public boolean canParse(String s)
    {
        return "application/x-quicktime-tx3g".equals(s);
    }

    public Subtitle parse(InputStream inputstream, String s, long l)
        throws IOException
    {
        return new Tx3gSubtitle(l, new Cue((new DataInputStream(inputstream)).readUTF()));
    }
}

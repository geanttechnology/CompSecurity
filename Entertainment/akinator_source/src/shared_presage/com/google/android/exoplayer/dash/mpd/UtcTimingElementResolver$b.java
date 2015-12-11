// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.android.exoplayer.dash.mpd;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import shared_presage.com.google.android.exoplayer.ParserException;
import shared_presage.com.google.android.exoplayer.util.Util;

// Referenced classes of package shared_presage.com.google.android.exoplayer.dash.mpd:
//            UtcTimingElementResolver

private static final class <init>
    implements shared_presage.com.google.android.exoplayer.upstream.<init>
{

    private static Long a(InputStream inputstream)
    {
        inputstream = (new BufferedReader(new InputStreamReader(inputstream))).readLine();
        long l;
        try
        {
            l = Util.parseXsDateTime(inputstream);
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            throw new ParserException(inputstream);
        }
        return Long.valueOf(l);
    }

    public final Object parse(String s, InputStream inputstream)
    {
        return a(inputstream);
    }

    private ()
    {
    }

    (byte byte0)
    {
        this();
    }
}

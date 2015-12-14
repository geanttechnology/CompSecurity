// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.text.subrip;

import android.text.Html;
import android.text.TextUtils;
import com.google.android.exoplayer.ParserException;
import com.google.android.exoplayer.text.Cue;
import com.google.android.exoplayer.text.Subtitle;
import com.google.android.exoplayer.text.SubtitleParser;
import com.google.android.exoplayer.util.LongArray;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package com.google.android.exoplayer.text.subrip:
//            SubripSubtitle

public final class SubripParser
    implements SubtitleParser
{

    private static final Pattern SUBRIP_TIMESTAMP = Pattern.compile("(?:(\\d+):)?(\\d+):(\\d+),(\\d+)");
    private static final Pattern SUBRIP_TIMING_LINE = Pattern.compile("(.*)\\s+-->\\s+(.*)");
    private final StringBuilder textBuilder = new StringBuilder();

    public SubripParser()
    {
    }

    private static long parseTimestampUs(String s)
        throws NumberFormatException
    {
        s = SUBRIP_TIMESTAMP.matcher(s);
        if (!s.matches())
        {
            throw new NumberFormatException("has invalid format");
        } else
        {
            return (Long.parseLong(s.group(1)) * 60L * 60L * 1000L + Long.parseLong(s.group(2)) * 60L * 1000L + Long.parseLong(s.group(3)) * 1000L + Long.parseLong(s.group(4))) * 1000L;
        }
    }

    public boolean canParse(String s)
    {
        return "application/x-subrip".equals(s);
    }

    public volatile Subtitle parse(InputStream inputstream, String s, long l)
        throws IOException
    {
        return parse(inputstream, s, l);
    }

    public SubripSubtitle parse(InputStream inputstream, String s, long l)
        throws IOException
    {
        s = new ArrayList();
        LongArray longarray = new LongArray();
        inputstream = new BufferedReader(new InputStreamReader(inputstream, "UTF-8"));
        do
        {
            String s1 = inputstream.readLine();
            if (s1 != null)
            {
                Matcher matcher;
                try
                {
                    Integer.parseInt(s1);
                }
                // Misplaced declaration of an exception variable
                catch (InputStream inputstream)
                {
                    throw new ParserException((new StringBuilder()).append("Expected numeric counter: ").append(s1).toString());
                }
                s1 = inputstream.readLine();
                matcher = SUBRIP_TIMING_LINE.matcher(s1);
                if (matcher.find())
                {
                    longarray.add(parseTimestampUs(matcher.group(1)) + l);
                    longarray.add(parseTimestampUs(matcher.group(2)) + l);
                    textBuilder.setLength(0);
                    do
                    {
                        s1 = inputstream.readLine();
                        if (TextUtils.isEmpty(s1))
                        {
                            break;
                        }
                        if (textBuilder.length() > 0)
                        {
                            textBuilder.append("<br>");
                        }
                        textBuilder.append(s1.trim());
                    } while (true);
                } else
                {
                    throw new ParserException((new StringBuilder()).append("Expected timing line: ").append(s1).toString());
                }
                s.add(new Cue(Html.fromHtml(textBuilder.toString())));
            } else
            {
                inputstream = new Cue[s.size()];
                s.toArray(inputstream);
                return new SubripSubtitle(l, inputstream, longarray.toArray());
            }
        } while (true);
    }

}

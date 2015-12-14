// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.text.webvtt;

import android.text.Html;
import android.util.Log;
import com.google.android.exoplayer.ParserException;
import com.google.android.exoplayer.text.Subtitle;
import com.google.android.exoplayer.text.SubtitleParser;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package com.google.android.exoplayer.text.webvtt:
//            WebvttCue, WebvttSubtitle

public class WebvttParser
    implements SubtitleParser
{

    private static final Pattern MEDIA_TIMESTAMP = Pattern.compile("MPEGTS:\\d+");
    private static final Pattern MEDIA_TIMESTAMP_OFFSET = Pattern.compile("OFFSET:\\-?\\d+");
    private static final String NON_NUMERIC_STRING = ".*[^0-9].*";
    private static final long SAMPLING_RATE = 90L;
    private static final String TAG = "WebvttParser";
    private static final Pattern WEBVTT_CUE_IDENTIFIER = Pattern.compile("^(?!.*(-->)).*$");
    private static final String WEBVTT_CUE_IDENTIFIER_STRING = "^(?!.*(-->)).*$";
    private static final Pattern WEBVTT_CUE_SETTING = Pattern.compile("\\S*:\\S*");
    private static final String WEBVTT_CUE_SETTING_STRING = "\\S*:\\S*";
    private static final Pattern WEBVTT_FILE_HEADER = Pattern.compile("^\uFEFF?WEBVTT((\\u0020|\t).*)?$");
    private static final String WEBVTT_FILE_HEADER_STRING = "^\uFEFF?WEBVTT((\\u0020|\t).*)?$";
    private static final Pattern WEBVTT_METADATA_HEADER = Pattern.compile("\\S*[:=]\\S*");
    private static final String WEBVTT_METADATA_HEADER_STRING = "\\S*[:=]\\S*";
    private static final Pattern WEBVTT_TIMESTAMP = Pattern.compile("(\\d+:)?[0-5]\\d:[0-5]\\d\\.\\d{3}");
    private static final String WEBVTT_TIMESTAMP_STRING = "(\\d+:)?[0-5]\\d:[0-5]\\d\\.\\d{3}";
    private final boolean strictParsing;
    private final StringBuilder textBuilder;

    public WebvttParser()
    {
        this(false);
    }

    public WebvttParser(boolean flag)
    {
        strictParsing = flag;
        textBuilder = new StringBuilder();
    }

    private static int parseIntPercentage(String s)
        throws NumberFormatException
    {
        if (!s.endsWith("%"))
        {
            throw new NumberFormatException((new StringBuilder()).append(s).append(" doesn't end with '%'").toString());
        }
        s = s.substring(0, s.length() - 1);
        if (s.matches(".*[^0-9].*"))
        {
            throw new NumberFormatException((new StringBuilder()).append(s).append(" contains an invalid character").toString());
        }
        int i = Integer.parseInt(s);
        if (i < 0 || i > 100)
        {
            throw new NumberFormatException((new StringBuilder()).append(i).append(" is out of range [0-100]").toString());
        } else
        {
            return i;
        }
    }

    private static long parseTimestampUs(String s)
        throws NumberFormatException
    {
        if (!s.matches("(\\d+:)?[0-5]\\d:[0-5]\\d\\.\\d{3}"))
        {
            throw new NumberFormatException("has invalid format");
        }
        s = s.split("\\.", 2);
        long l = 0L;
        String as[] = s[0].split(":");
        int j = as.length;
        for (int i = 0; i < j; i++)
        {
            l = 60L * l + Long.parseLong(as[i]);
        }

        return (l * 1000L + Long.parseLong(s[1])) * 1000L;
    }

    public final boolean canParse(String s)
    {
        return "text/vtt".equals(s);
    }

    protected long getAdjustedStartTime(long l)
    {
        return l;
    }

    protected void handleNoncompliantLine(String s)
        throws ParserException
    {
        if (strictParsing)
        {
            throw new ParserException((new StringBuilder()).append("Unexpected line: ").append(s).toString());
        } else
        {
            return;
        }
    }

    public volatile Subtitle parse(InputStream inputstream, String s, long l)
        throws IOException
    {
        return parse(inputstream, s, l);
    }

    public final WebvttSubtitle parse(InputStream inputstream, String s, long l)
        throws IOException
    {
        ArrayList arraylist;
        BufferedReader bufferedreader;
        long l1;
        arraylist = new ArrayList();
        l1 = l;
        long l2 = 0L;
        bufferedreader = new BufferedReader(new InputStreamReader(inputstream, "UTF-8"));
        s = bufferedreader.readLine();
        if (s == null)
        {
            throw new ParserException("Expected WEBVTT or EXO-HEADER. Got null");
        }
        inputstream = s;
        l = l2;
        if (s.startsWith("EXO-HEADER"))
        {
            inputstream = MEDIA_TIMESTAMP_OFFSET.matcher(s);
            l = l2;
            if (inputstream.find())
            {
                l = Long.parseLong(inputstream.group().substring(7));
            }
            s = bufferedreader.readLine();
            inputstream = s;
            if (s == null)
            {
                throw new ParserException("Expected WEBVTT. Got null");
            }
        }
        if (!WEBVTT_FILE_HEADER.matcher(inputstream).matches())
        {
            throw new ParserException((new StringBuilder()).append("Expected WEBVTT. Got ").append(inputstream).toString());
        }
          goto _L1
_L8:
        l1 = getAdjustedStartTime((Long.parseLong(s.group().substring(7)) * 1000L) / 90L + l);
_L1:
        inputstream = bufferedreader.readLine();
        if (inputstream == null)
        {
            throw new ParserException("Expected an empty line after webvtt header");
        }
        Object obj;
        int i;
        int j;
        int k;
        if (!inputstream.isEmpty()) goto _L3; else goto _L2
_L3:
        if (!WEBVTT_METADATA_HEADER.matcher(inputstream).find())
        {
            handleNoncompliantLine(inputstream);
        }
        if (inputstream.startsWith("X-TIMESTAMP-MAP"))
        {
            s = MEDIA_TIMESTAMP.matcher(inputstream);
            if (!s.find())
            {
                throw new ParserException((new StringBuilder()).append("X-TIMESTAMP-MAP doesn't contain media timestamp: ").append(inputstream).toString());
            }
            continue; /* Loop/switch isn't completed */
        }
          goto _L1
_L2:
        long l3;
        s = bufferedreader.readLine();
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_945;
        }
        inputstream = s;
        if (WEBVTT_CUE_IDENTIFIER.matcher(s).find())
        {
            inputstream = bufferedreader.readLine();
        }
        i = -1;
        j = -1;
        s = null;
        k = -1;
        obj = WEBVTT_TIMESTAMP.matcher(inputstream);
        if (!((Matcher) (obj)).find())
        {
            throw new ParserException((new StringBuilder()).append("Expected cue start time: ").append(inputstream).toString());
        }
        l = parseTimestampUs(((Matcher) (obj)).group());
        if (!((Matcher) (obj)).find())
        {
            throw new ParserException((new StringBuilder()).append("Expected cue end time: ").append(inputstream).toString());
        }
        obj = ((Matcher) (obj)).group();
        l3 = parseTimestampUs(((String) (obj)));
        inputstream = inputstream.substring(inputstream.indexOf(((String) (obj))) + ((String) (obj)).length());
        obj = WEBVTT_CUE_SETTING.matcher(inputstream);
        inputstream = s;
_L5:
        String s1;
        String s2;
        if (!((Matcher) (obj)).find())
        {
            break; /* Loop/switch isn't completed */
        }
        s = ((Matcher) (obj)).group().split(":", 2);
        s1 = s[0];
        s2 = s[1];
        int i1;
        if (!"line".equals(s1))
        {
            break MISSING_BLOCK_LABEL_611;
        }
        if (!s2.endsWith("%"))
        {
            break MISSING_BLOCK_LABEL_521;
        }
        i1 = parseIntPercentage(s2);
        i = i1;
        continue; /* Loop/switch isn't completed */
        if (s2.matches(".*[^0-9].*"))
        {
            Log.w("WebvttParser", (new StringBuilder()).append("Invalid line value: ").append(s2).toString());
            continue; /* Loop/switch isn't completed */
        }
        i1 = Integer.parseInt(s2);
        i = i1;
        continue; /* Loop/switch isn't completed */
        if (!"align".equals(s1))
        {
            break MISSING_BLOCK_LABEL_752;
        }
        if (!"start".equals(s2))
        {
            break MISSING_BLOCK_LABEL_642;
        }
        s = android.text.Layout.Alignment.ALIGN_NORMAL;
        inputstream = s;
        continue; /* Loop/switch isn't completed */
        if (!"middle".equals(s2))
        {
            break MISSING_BLOCK_LABEL_662;
        }
        s = android.text.Layout.Alignment.ALIGN_CENTER;
        inputstream = s;
        continue; /* Loop/switch isn't completed */
        if (!"end".equals(s2))
        {
            break MISSING_BLOCK_LABEL_682;
        }
        s = android.text.Layout.Alignment.ALIGN_OPPOSITE;
        inputstream = s;
        continue; /* Loop/switch isn't completed */
        if (!"left".equals(s2))
        {
            break MISSING_BLOCK_LABEL_702;
        }
        s = android.text.Layout.Alignment.ALIGN_NORMAL;
        inputstream = s;
        continue; /* Loop/switch isn't completed */
        if (!"right".equals(s2))
        {
            break MISSING_BLOCK_LABEL_722;
        }
        s = android.text.Layout.Alignment.ALIGN_OPPOSITE;
        inputstream = s;
        continue; /* Loop/switch isn't completed */
        try
        {
            Log.w("WebvttParser", (new StringBuilder()).append("Invalid align value: ").append(s2).toString());
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Log.w("WebvttParser", (new StringBuilder()).append(s1).append(" contains an invalid value ").append(s2).toString(), s);
        }
        continue; /* Loop/switch isn't completed */
        if (!"position".equals(s1))
        {
            break MISSING_BLOCK_LABEL_777;
        }
        i1 = parseIntPercentage(s2);
        j = i1;
        continue; /* Loop/switch isn't completed */
        if (!"size".equals(s1))
        {
            break MISSING_BLOCK_LABEL_802;
        }
        i1 = parseIntPercentage(s2);
        k = i1;
        continue; /* Loop/switch isn't completed */
        Log.w("WebvttParser", (new StringBuilder()).append("Unknown cue setting ").append(s1).append(":").append(s2).toString());
        if (true) goto _L5; else goto _L4
_L4:
        textBuilder.setLength(0);
        do
        {
            s = bufferedreader.readLine();
            if (s == null || s.isEmpty())
            {
                break;
            }
            if (textBuilder.length() > 0)
            {
                textBuilder.append("<br>");
            }
            textBuilder.append(s.trim());
        } while (true);
        arraylist.add(new WebvttCue(l + l1, l3 + l1, Html.fromHtml(textBuilder.toString()), i, j, inputstream, k));
        if (true) goto _L2; else goto _L6
_L6:
        return new WebvttSubtitle(arraylist, l1);
        if (true) goto _L8; else goto _L7
_L7:
    }

}

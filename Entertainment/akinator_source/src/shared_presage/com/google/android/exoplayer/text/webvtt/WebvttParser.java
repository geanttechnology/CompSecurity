// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.android.exoplayer.text.webvtt;

import android.text.Html;
import android.util.Log;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import shared_presage.com.google.android.exoplayer.ParserException;
import shared_presage.com.google.android.exoplayer.text.Subtitle;
import shared_presage.com.google.android.exoplayer.text.SubtitleParser;

// Referenced classes of package shared_presage.com.google.android.exoplayer.text.webvtt:
//            a, WebvttSubtitle

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
    {
        int i = 0;
        if (!s.matches("(\\d+:)?[0-5]\\d:[0-5]\\d\\.\\d{3}"))
        {
            throw new NumberFormatException("has invalid format");
        }
        s = s.split("\\.", 2);
        long l = 0L;
        String as[] = s[0].split(":");
        for (int j = as.length; i < j; i++)
        {
            l = l * 60L + Long.parseLong(as[i]);
        }

        return (Long.parseLong(s[1]) + l * 1000L) * 1000L;
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
    {
        if (strictParsing)
        {
            throw new ParserException((new StringBuilder("Unexpected line: ")).append(s).toString());
        } else
        {
            return;
        }
    }

    public volatile Subtitle parse(InputStream inputstream, String s, long l)
    {
        return parse(inputstream, s, l);
    }

    public final WebvttSubtitle parse(InputStream inputstream, String s, long l)
    {
        ArrayList arraylist;
        BufferedReader bufferedreader;
        long l1;
        arraylist = new ArrayList();
        long l2 = 0L;
        bufferedreader = new BufferedReader(new InputStreamReader(inputstream, "UTF-8"));
        s = bufferedreader.readLine();
        if (s == null)
        {
            throw new ParserException("Expected WEBVTT or EXO-HEADER. Got null");
        }
        l1 = l2;
        inputstream = s;
        if (s.startsWith("EXO-HEADER"))
        {
            inputstream = MEDIA_TIMESTAMP_OFFSET.matcher(s);
            l1 = l2;
            if (inputstream.find())
            {
                l1 = Long.parseLong(inputstream.group().substring(7));
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
            throw new ParserException((new StringBuilder("Expected WEBVTT. Got ")).append(inputstream).toString());
        }
          goto _L1
_L6:
        l = getAdjustedStartTime((Long.parseLong(s.group().substring(7)) * 1000L) / 90L + l1);
_L1:
        inputstream = bufferedreader.readLine();
        if (inputstream == null)
        {
            throw new ParserException("Expected an empty line after webvtt header");
        }
        if (inputstream.isEmpty()) goto _L3; else goto _L2
_L2:
        if (!WEBVTT_METADATA_HEADER.matcher(inputstream).find())
        {
            handleNoncompliantLine(inputstream);
        }
        if (!inputstream.startsWith("X-TIMESTAMP-MAP")) goto _L1; else goto _L4
_L4:
        s = MEDIA_TIMESTAMP.matcher(inputstream);
        if (s.find()) goto _L6; else goto _L5
_L5:
        throw new ParserException((new StringBuilder("X-TIMESTAMP-MAP doesn't contain media timestamp: ")).append(inputstream).toString());
_L10:
        int i;
        int j;
        int k;
        long l3;
        arraylist.add(new a(l1 + l, l3 + l, Html.fromHtml(textBuilder.toString()), i, j, inputstream, k));
_L3:
        Object obj;
        s = bufferedreader.readLine();
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_928;
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
            throw new ParserException((new StringBuilder("Expected cue start time: ")).append(inputstream).toString());
        }
        l1 = parseTimestampUs(((Matcher) (obj)).group());
        if (!((Matcher) (obj)).find())
        {
            throw new ParserException((new StringBuilder("Expected cue end time: ")).append(inputstream).toString());
        }
        obj = ((Matcher) (obj)).group();
        l3 = parseTimestampUs(((String) (obj)));
        int i1 = inputstream.indexOf(((String) (obj)));
        inputstream = inputstream.substring(((String) (obj)).length() + i1);
        obj = WEBVTT_CUE_SETTING.matcher(inputstream);
        inputstream = s;
_L8:
        String s1;
        String s2;
        if (!((Matcher) (obj)).find())
        {
            break; /* Loop/switch isn't completed */
        }
        s = ((Matcher) (obj)).group().split(":", 2);
        s1 = s[0];
        s2 = s[1];
        int j1;
        if (!"line".equals(s1))
        {
            break MISSING_BLOCK_LABEL_642;
        }
        if (!s2.endsWith("%"))
        {
            break MISSING_BLOCK_LABEL_554;
        }
        j1 = parseIntPercentage(s2);
        i = j1;
        continue; /* Loop/switch isn't completed */
        if (s2.matches(".*[^0-9].*"))
        {
            Log.w("WebvttParser", (new StringBuilder("Invalid line value: ")).append(s2).toString());
            continue; /* Loop/switch isn't completed */
        }
        j1 = Integer.parseInt(s2);
        i = j1;
        continue; /* Loop/switch isn't completed */
        if (!"align".equals(s1))
        {
            break MISSING_BLOCK_LABEL_780;
        }
        if (!"start".equals(s2))
        {
            break MISSING_BLOCK_LABEL_673;
        }
        s = android.text.Layout.Alignment.ALIGN_NORMAL;
        inputstream = s;
        continue; /* Loop/switch isn't completed */
        if (!"middle".equals(s2))
        {
            break MISSING_BLOCK_LABEL_693;
        }
        s = android.text.Layout.Alignment.ALIGN_CENTER;
        inputstream = s;
        continue; /* Loop/switch isn't completed */
        if (!"end".equals(s2))
        {
            break MISSING_BLOCK_LABEL_713;
        }
        s = android.text.Layout.Alignment.ALIGN_OPPOSITE;
        inputstream = s;
        continue; /* Loop/switch isn't completed */
        if (!"left".equals(s2))
        {
            break MISSING_BLOCK_LABEL_733;
        }
        s = android.text.Layout.Alignment.ALIGN_NORMAL;
        inputstream = s;
        continue; /* Loop/switch isn't completed */
        if (!"right".equals(s2))
        {
            break MISSING_BLOCK_LABEL_753;
        }
        s = android.text.Layout.Alignment.ALIGN_OPPOSITE;
        inputstream = s;
        continue; /* Loop/switch isn't completed */
        try
        {
            Log.w("WebvttParser", (new StringBuilder("Invalid align value: ")).append(s2).toString());
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Log.w("WebvttParser", (new StringBuilder()).append(s1).append(" contains an invalid value ").append(s2).toString(), s);
        }
        continue; /* Loop/switch isn't completed */
        if (!"position".equals(s1))
        {
            break MISSING_BLOCK_LABEL_805;
        }
        j1 = parseIntPercentage(s2);
        j = j1;
        continue; /* Loop/switch isn't completed */
        if (!"size".equals(s1))
        {
            break MISSING_BLOCK_LABEL_830;
        }
        j1 = parseIntPercentage(s2);
        k = j1;
        continue; /* Loop/switch isn't completed */
        Log.w("WebvttParser", (new StringBuilder("Unknown cue setting ")).append(s1).append(":").append(s2).toString());
        if (true) goto _L8; else goto _L7
_L7:
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
        if (true) goto _L10; else goto _L9
_L9:
        return new WebvttSubtitle(arraylist, l);
    }

}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.log4j.helpers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;
import java.util.Set;
import org.apache.log4j.Layout;
import org.apache.log4j.Priority;
import org.apache.log4j.spi.LocationInfo;
import org.apache.log4j.spi.LoggingEvent;

// Referenced classes of package org.apache.log4j.helpers:
//            FormattingInfo, PatternConverter, LogLog, ISO8601DateFormat, 
//            AbsoluteTimeDateFormat, DateTimeDateFormat, OptionConverter

public class PatternParser
{
    private static class BasicPatternConverter extends PatternConverter
    {

        int type;

        public String convert(LoggingEvent loggingevent)
        {
            switch (type)
            {
            default:
                return null;

            case 2000: 
                return Long.toString(loggingevent.timeStamp - LoggingEvent.getStartTime());

            case 2001: 
                return loggingevent.getThreadName();

            case 2002: 
                return loggingevent.getLevel().toString();

            case 2003: 
                return loggingevent.getNDC();

            case 2004: 
                return loggingevent.getRenderedMessage();
            }
        }

        BasicPatternConverter(FormattingInfo formattinginfo, int j)
        {
            super(formattinginfo);
            type = j;
        }
    }

    private class CategoryPatternConverter extends NamedPatternConverter
    {

        private final PatternParser this$0;

        String getFullyQualifiedName(LoggingEvent loggingevent)
        {
            return loggingevent.getLoggerName();
        }

        CategoryPatternConverter(FormattingInfo formattinginfo, int j)
        {
            super(formattinginfo, j);
            this$0 = PatternParser.this;
        }
    }

    private class ClassNamePatternConverter extends NamedPatternConverter
    {

        private final PatternParser this$0;

        String getFullyQualifiedName(LoggingEvent loggingevent)
        {
            return loggingevent.getLocationInformation().getClassName();
        }

        ClassNamePatternConverter(FormattingInfo formattinginfo, int j)
        {
            super(formattinginfo, j);
            this$0 = PatternParser.this;
        }
    }

    private static class DatePatternConverter extends PatternConverter
    {

        private Date date;
        private DateFormat df;

        public String convert(LoggingEvent loggingevent)
        {
            date.setTime(loggingevent.timeStamp);
            try
            {
                loggingevent = df.format(date);
            }
            // Misplaced declaration of an exception variable
            catch (LoggingEvent loggingevent)
            {
                LogLog.error("Error occured while converting date.", loggingevent);
                return null;
            }
            return loggingevent;
        }

        DatePatternConverter(FormattingInfo formattinginfo, DateFormat dateformat)
        {
            super(formattinginfo);
            date = new Date();
            df = dateformat;
        }
    }

    private static class LiteralPatternConverter extends PatternConverter
    {

        private String literal;

        public String convert(LoggingEvent loggingevent)
        {
            return literal;
        }

        public final void format(StringBuffer stringbuffer, LoggingEvent loggingevent)
        {
            stringbuffer.append(literal);
        }

        LiteralPatternConverter(String s)
        {
            literal = s;
        }
    }

    private class LocationPatternConverter extends PatternConverter
    {

        private final PatternParser this$0;
        int type;

        public String convert(LoggingEvent loggingevent)
        {
            loggingevent = loggingevent.getLocationInformation();
            switch (type)
            {
            case 1002: 
            default:
                return null;

            case 1000: 
                return ((LocationInfo) (loggingevent)).fullInfo;

            case 1001: 
                return loggingevent.getMethodName();

            case 1003: 
                return loggingevent.getLineNumber();

            case 1004: 
                return loggingevent.getFileName();
            }
        }

        LocationPatternConverter(FormattingInfo formattinginfo, int j)
        {
            super(formattinginfo);
            this$0 = PatternParser.this;
            type = j;
        }
    }

    private static class MDCPatternConverter extends PatternConverter
    {

        private String key;

        public String convert(LoggingEvent loggingevent)
        {
            if (key == null)
            {
                StringBuffer stringbuffer = new StringBuffer("{");
                loggingevent = loggingevent.getProperties();
                if (loggingevent.size() > 0)
                {
                    Object aobj[] = loggingevent.keySet().toArray();
                    Arrays.sort(aobj);
                    for (int j = 0; j < aobj.length; j++)
                    {
                        stringbuffer.append('{');
                        stringbuffer.append(aobj[j]);
                        stringbuffer.append(',');
                        stringbuffer.append(loggingevent.get(aobj[j]));
                        stringbuffer.append('}');
                    }

                }
                stringbuffer.append('}');
                return stringbuffer.toString();
            }
            loggingevent = ((LoggingEvent) (loggingevent.getMDC(key)));
            if (loggingevent == null)
            {
                return null;
            } else
            {
                return loggingevent.toString();
            }
        }

        MDCPatternConverter(FormattingInfo formattinginfo, String s)
        {
            super(formattinginfo);
            key = s;
        }
    }

    private static abstract class NamedPatternConverter extends PatternConverter
    {

        int precision;

        public String convert(LoggingEvent loggingevent)
        {
            loggingevent = getFullyQualifiedName(loggingevent);
            if (precision > 0) goto _L2; else goto _L1
_L1:
            return loggingevent;
_L2:
            int k;
            int l;
            l = loggingevent.length();
            k = l - 1;
            int j = precision;
label0:
            do
            {
label1:
                {
                    if (j <= 0)
                    {
                        break label1;
                    }
                    k = loggingevent.lastIndexOf('.', k - 1);
                    if (k == -1)
                    {
                        break label0;
                    }
                    j--;
                }
            } while (true);
            if (true) goto _L1; else goto _L3
_L3:
            return loggingevent.substring(k + 1, l);
        }

        abstract String getFullyQualifiedName(LoggingEvent loggingevent);

        NamedPatternConverter(FormattingInfo formattinginfo, int j)
        {
            super(formattinginfo);
            precision = j;
        }
    }


    static Class class$java$text$DateFormat;
    protected StringBuffer currentLiteral;
    protected FormattingInfo formattingInfo;
    PatternConverter head;
    protected int i;
    protected String pattern;
    protected int patternLength;
    int state;
    PatternConverter tail;

    public PatternParser(String s)
    {
        currentLiteral = new StringBuffer(32);
        formattingInfo = new FormattingInfo();
        pattern = s;
        patternLength = s.length();
        state = 0;
    }

    private void addToList(PatternConverter patternconverter)
    {
        if (head == null)
        {
            tail = patternconverter;
            head = patternconverter;
            return;
        } else
        {
            tail.next = patternconverter;
            tail = patternconverter;
            return;
        }
    }

    static Class _mthclass$(String s)
    {
        try
        {
            s = Class.forName(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new NoClassDefFoundError(s.getMessage());
        }
        return s;
    }

    protected void addConverter(PatternConverter patternconverter)
    {
        currentLiteral.setLength(0);
        addToList(patternconverter);
        state = 0;
        formattingInfo.reset();
    }

    protected String extractOption()
    {
        if (i < patternLength && pattern.charAt(i) == '{')
        {
            int j = pattern.indexOf('}', i);
            if (j > i)
            {
                String s = pattern.substring(i + 1, j);
                i = j + 1;
                return s;
            }
        }
        return null;
    }

    protected int extractPrecisionOption()
    {
        String s = extractOption();
        int k = 0;
        int j = 0;
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_63;
        }
        j = k;
        try
        {
            k = Integer.parseInt(s);
        }
        catch (NumberFormatException numberformatexception)
        {
            LogLog.error("Category option \"" + s + "\" not a decimal integer.", numberformatexception);
            return j;
        }
        j = k;
        if (k > 0)
        {
            break MISSING_BLOCK_LABEL_63;
        }
        j = k;
        LogLog.error("Precision option (" + s + ") isn't a positive integer.");
        j = 0;
        return j;
    }

    protected void finalizeConverter(char c)
    {
        c;
        JVM INSTR lookupswitch 13: default 116
    //                   67: 212
    //                   70: 410
    //                   76: 464
    //                   77: 517
    //                   88: 648
    //                   99: 184
    //                   100: 240
    //                   108: 437
    //                   109: 491
    //                   112: 544
    //                   114: 570
    //                   116: 596
    //                   120: 622;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14
_L1:
        Object obj;
        LogLog.error("Unexpected char [" + c + "] at position " + i + " in conversion patterrn.");
        obj = new LiteralPatternConverter(currentLiteral.toString());
        currentLiteral.setLength(0);
_L19:
        addConverter(((PatternConverter) (obj)));
        return;
_L7:
        obj = new CategoryPatternConverter(formattingInfo, extractPrecisionOption());
        currentLiteral.setLength(0);
        continue; /* Loop/switch isn't completed */
_L2:
        obj = new ClassNamePatternConverter(formattingInfo, extractPrecisionOption());
        currentLiteral.setLength(0);
        continue; /* Loop/switch isn't completed */
_L8:
        obj = "ISO8601";
        String s = extractOption();
        if (s != null)
        {
            obj = s;
        }
        if (!((String) (obj)).equalsIgnoreCase("ISO8601")) goto _L16; else goto _L15
_L15:
        obj = new ISO8601DateFormat();
_L17:
        obj = new DatePatternConverter(formattingInfo, ((DateFormat) (obj)));
        currentLiteral.setLength(0);
        continue; /* Loop/switch isn't completed */
_L16:
        if (((String) (obj)).equalsIgnoreCase("ABSOLUTE"))
        {
            obj = new AbsoluteTimeDateFormat();
            continue; /* Loop/switch isn't completed */
        }
        if (((String) (obj)).equalsIgnoreCase("DATE"))
        {
            obj = new DateTimeDateFormat();
            continue; /* Loop/switch isn't completed */
        }
        SimpleDateFormat simpledateformat = new SimpleDateFormat(((String) (obj)));
        obj = simpledateformat;
        continue; /* Loop/switch isn't completed */
        IllegalArgumentException illegalargumentexception;
        illegalargumentexception;
        LogLog.error("Could not instantiate SimpleDateFormat with " + obj, illegalargumentexception);
        if (class$java$text$DateFormat == null)
        {
            obj = _mthclass$("java.text.DateFormat");
            class$java$text$DateFormat = ((Class) (obj));
        } else
        {
            obj = class$java$text$DateFormat;
        }
        obj = (DateFormat)OptionConverter.instantiateByClassName("org.apache.log4j.helpers.ISO8601DateFormat", ((Class) (obj)), null);
        if (true) goto _L17; else goto _L3
_L3:
        obj = new LocationPatternConverter(formattingInfo, 1004);
        currentLiteral.setLength(0);
        continue; /* Loop/switch isn't completed */
_L9:
        obj = new LocationPatternConverter(formattingInfo, 1000);
        currentLiteral.setLength(0);
        continue; /* Loop/switch isn't completed */
_L4:
        obj = new LocationPatternConverter(formattingInfo, 1003);
        currentLiteral.setLength(0);
        continue; /* Loop/switch isn't completed */
_L10:
        obj = new BasicPatternConverter(formattingInfo, 2004);
        currentLiteral.setLength(0);
        continue; /* Loop/switch isn't completed */
_L5:
        obj = new LocationPatternConverter(formattingInfo, 1001);
        currentLiteral.setLength(0);
        continue; /* Loop/switch isn't completed */
_L11:
        obj = new BasicPatternConverter(formattingInfo, 2002);
        currentLiteral.setLength(0);
        continue; /* Loop/switch isn't completed */
_L12:
        obj = new BasicPatternConverter(formattingInfo, 2000);
        currentLiteral.setLength(0);
        continue; /* Loop/switch isn't completed */
_L13:
        obj = new BasicPatternConverter(formattingInfo, 2001);
        currentLiteral.setLength(0);
        continue; /* Loop/switch isn't completed */
_L14:
        obj = new BasicPatternConverter(formattingInfo, 2003);
        currentLiteral.setLength(0);
        continue; /* Loop/switch isn't completed */
_L6:
        obj = extractOption();
        obj = new MDCPatternConverter(formattingInfo, ((String) (obj)));
        currentLiteral.setLength(0);
        if (true) goto _L19; else goto _L18
_L18:
    }

    public PatternConverter parse()
    {
        i = 0;
        do
        {
            if (i < patternLength)
            {
                String s = pattern;
                int j = i;
                i = j + 1;
                char c = s.charAt(j);
                switch (state)
                {
                case 0: // '\0'
                    if (i == patternLength)
                    {
                        currentLiteral.append(c);
                    } else
                    if (c == '%')
                    {
                        switch (pattern.charAt(i))
                        {
                        default:
                            if (currentLiteral.length() != 0)
                            {
                                addToList(new LiteralPatternConverter(currentLiteral.toString()));
                            }
                            currentLiteral.setLength(0);
                            currentLiteral.append(c);
                            state = 1;
                            formattingInfo.reset();
                            break;

                        case 37: // '%'
                            currentLiteral.append(c);
                            i = i + 1;
                            break;

                        case 110: // 'n'
                            currentLiteral.append(Layout.LINE_SEP);
                            i = i + 1;
                            break;
                        }
                    } else
                    {
                        currentLiteral.append(c);
                    }
                    break;

                case 1: // '\001'
                    currentLiteral.append(c);
                    switch (c)
                    {
                    default:
                        if (c >= '0' && c <= '9')
                        {
                            formattingInfo.min = c - 48;
                            state = 4;
                        } else
                        {
                            finalizeConverter(c);
                        }
                        break;

                    case 45: // '-'
                        formattingInfo.leftAlign = true;
                        break;

                    case 46: // '.'
                        state = 3;
                        break;
                    }
                    break;

                case 4: // '\004'
                    currentLiteral.append(c);
                    if (c >= '0' && c <= '9')
                    {
                        formattingInfo.min = formattingInfo.min * 10 + (c - 48);
                    } else
                    if (c == '.')
                    {
                        state = 3;
                    } else
                    {
                        finalizeConverter(c);
                    }
                    break;

                case 3: // '\003'
                    currentLiteral.append(c);
                    if (c >= '0' && c <= '9')
                    {
                        formattingInfo.max = c - 48;
                        state = 5;
                    } else
                    {
                        LogLog.error("Error occured in position " + i + ".\n Was expecting digit, instead got char \"" + c + "\".");
                        state = 0;
                    }
                    break;

                case 5: // '\005'
                    currentLiteral.append(c);
                    if (c >= '0' && c <= '9')
                    {
                        formattingInfo.max = formattingInfo.max * 10 + (c - 48);
                    } else
                    {
                        finalizeConverter(c);
                        state = 0;
                    }
                    break;
                }
            } else
            {
                if (currentLiteral.length() != 0)
                {
                    addToList(new LiteralPatternConverter(currentLiteral.toString()));
                }
                return head;
            }
        } while (true);
    }
}

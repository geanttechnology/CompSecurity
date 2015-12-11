// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.codehaus.jackson.map.ext;

import com.flurry.org.codehaus.jackson.JsonParser;
import com.flurry.org.codehaus.jackson.JsonProcessingException;
import com.flurry.org.codehaus.jackson.JsonToken;
import com.flurry.org.codehaus.jackson.map.DeserializationContext;
import com.flurry.org.codehaus.jackson.map.deser.std.StdDeserializer;
import com.flurry.org.codehaus.jackson.map.deser.std.StdScalarDeserializer;
import com.flurry.org.codehaus.jackson.map.util.Provider;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import org.joda.time.DateMidnight;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.joda.time.Period;
import org.joda.time.ReadableDateTime;
import org.joda.time.ReadableInstant;
import org.joda.time.ReadablePeriod;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

public class JodaDeserializers
    implements Provider
{
    public static class DateMidnightDeserializer extends JodaDeserializer
    {

        public volatile Object deserialize(JsonParser jsonparser, DeserializationContext deserializationcontext)
            throws IOException, JsonProcessingException
        {
            return deserialize(jsonparser, deserializationcontext);
        }

        public DateMidnight deserialize(JsonParser jsonparser, DeserializationContext deserializationcontext)
            throws IOException, JsonProcessingException
        {
            if (jsonparser.isExpectedStartArrayToken())
            {
                jsonparser.nextToken();
                int i = jsonparser.getIntValue();
                jsonparser.nextToken();
                int j = jsonparser.getIntValue();
                jsonparser.nextToken();
                int k = jsonparser.getIntValue();
                if (jsonparser.nextToken() != JsonToken.END_ARRAY)
                {
                    throw deserializationcontext.wrongTokenException(jsonparser, JsonToken.END_ARRAY, "after DateMidnight ints");
                } else
                {
                    return new DateMidnight(i, j, k);
                }
            }
            static class _cls1
            {

                static final int $SwitchMap$org$codehaus$jackson$JsonToken[];

                static 
                {
                    $SwitchMap$org$codehaus$jackson$JsonToken = new int[JsonToken.values().length];
                    try
                    {
                        $SwitchMap$org$codehaus$jackson$JsonToken[JsonToken.VALUE_NUMBER_INT.ordinal()] = 1;
                    }
                    catch (NoSuchFieldError nosuchfielderror1) { }
                    try
                    {
                        $SwitchMap$org$codehaus$jackson$JsonToken[JsonToken.VALUE_STRING.ordinal()] = 2;
                    }
                    catch (NoSuchFieldError nosuchfielderror)
                    {
                        return;
                    }
                }
            }

            switch (_cls1..SwitchMap.org.codehaus.jackson.JsonToken[jsonparser.getCurrentToken().ordinal()])
            {
            default:
                throw deserializationcontext.wrongTokenException(jsonparser, JsonToken.START_ARRAY, "expected JSON Array, Number or String");

            case 1: // '\001'
                return new DateMidnight(jsonparser.getLongValue());

            case 2: // '\002'
                jsonparser = parseLocal(jsonparser);
                break;
            }
            if (jsonparser == null)
            {
                return null;
            } else
            {
                return jsonparser.toDateMidnight();
            }
        }

        public DateMidnightDeserializer()
        {
            super(org/joda/time/DateMidnight);
        }
    }

    public static class DateTimeDeserializer extends JodaDeserializer
    {

        public volatile Object deserialize(JsonParser jsonparser, DeserializationContext deserializationcontext)
            throws IOException, JsonProcessingException
        {
            return deserialize(jsonparser, deserializationcontext);
        }

        public ReadableInstant deserialize(JsonParser jsonparser, DeserializationContext deserializationcontext)
            throws IOException, JsonProcessingException
        {
            JsonToken jsontoken = jsonparser.getCurrentToken();
            if (jsontoken == JsonToken.VALUE_NUMBER_INT)
            {
                return new DateTime(jsonparser.getLongValue(), DateTimeZone.UTC);
            }
            if (jsontoken == JsonToken.VALUE_STRING)
            {
                jsonparser = jsonparser.getText().trim();
                if (jsonparser.length() == 0)
                {
                    return null;
                } else
                {
                    return new DateTime(jsonparser, DateTimeZone.UTC);
                }
            } else
            {
                throw deserializationcontext.mappingException(getValueClass());
            }
        }

        public DateTimeDeserializer(Class class1)
        {
            super(class1);
        }
    }

    static abstract class JodaDeserializer extends StdScalarDeserializer
    {

        static final DateTimeFormatter _localDateTimeFormat = ISODateTimeFormat.localDateOptionalTimeParser();

        protected DateTime parseLocal(JsonParser jsonparser)
            throws IOException, JsonProcessingException
        {
            jsonparser = jsonparser.getText().trim();
            if (jsonparser.length() == 0)
            {
                return null;
            } else
            {
                return _localDateTimeFormat.parseDateTime(jsonparser);
            }
        }


        protected JodaDeserializer(Class class1)
        {
            super(class1);
        }
    }

    public static class LocalDateDeserializer extends JodaDeserializer
    {

        public volatile Object deserialize(JsonParser jsonparser, DeserializationContext deserializationcontext)
            throws IOException, JsonProcessingException
        {
            return deserialize(jsonparser, deserializationcontext);
        }

        public LocalDate deserialize(JsonParser jsonparser, DeserializationContext deserializationcontext)
            throws IOException, JsonProcessingException
        {
            if (jsonparser.isExpectedStartArrayToken())
            {
                jsonparser.nextToken();
                int i = jsonparser.getIntValue();
                jsonparser.nextToken();
                int j = jsonparser.getIntValue();
                jsonparser.nextToken();
                int k = jsonparser.getIntValue();
                if (jsonparser.nextToken() != JsonToken.END_ARRAY)
                {
                    throw deserializationcontext.wrongTokenException(jsonparser, JsonToken.END_ARRAY, "after LocalDate ints");
                } else
                {
                    return new LocalDate(i, j, k);
                }
            }
            switch (_cls1..SwitchMap.org.codehaus.jackson.JsonToken[jsonparser.getCurrentToken().ordinal()])
            {
            default:
                throw deserializationcontext.wrongTokenException(jsonparser, JsonToken.START_ARRAY, "expected JSON Array, String or Number");

            case 1: // '\001'
                return new LocalDate(jsonparser.getLongValue());

            case 2: // '\002'
                jsonparser = parseLocal(jsonparser);
                break;
            }
            if (jsonparser == null)
            {
                return null;
            } else
            {
                return jsonparser.toLocalDate();
            }
        }

        public LocalDateDeserializer()
        {
            super(org/joda/time/LocalDate);
        }
    }

    public static class LocalDateTimeDeserializer extends JodaDeserializer
    {

        public volatile Object deserialize(JsonParser jsonparser, DeserializationContext deserializationcontext)
            throws IOException, JsonProcessingException
        {
            return deserialize(jsonparser, deserializationcontext);
        }

        public LocalDateTime deserialize(JsonParser jsonparser, DeserializationContext deserializationcontext)
            throws IOException, JsonProcessingException
        {
            if (jsonparser.isExpectedStartArrayToken())
            {
                jsonparser.nextToken();
                int j = jsonparser.getIntValue();
                jsonparser.nextToken();
                int k = jsonparser.getIntValue();
                jsonparser.nextToken();
                int l = jsonparser.getIntValue();
                jsonparser.nextToken();
                int i1 = jsonparser.getIntValue();
                jsonparser.nextToken();
                int j1 = jsonparser.getIntValue();
                jsonparser.nextToken();
                int k1 = jsonparser.getIntValue();
                int i = 0;
                if (jsonparser.nextToken() != JsonToken.END_ARRAY)
                {
                    i = jsonparser.getIntValue();
                    jsonparser.nextToken();
                }
                if (jsonparser.getCurrentToken() != JsonToken.END_ARRAY)
                {
                    throw deserializationcontext.wrongTokenException(jsonparser, JsonToken.END_ARRAY, "after LocalDateTime ints");
                } else
                {
                    return new LocalDateTime(j, k, l, i1, j1, k1, i);
                }
            }
            switch (_cls1..SwitchMap.org.codehaus.jackson.JsonToken[jsonparser.getCurrentToken().ordinal()])
            {
            default:
                throw deserializationcontext.wrongTokenException(jsonparser, JsonToken.START_ARRAY, "expected JSON Array or Number");

            case 1: // '\001'
                return new LocalDateTime(jsonparser.getLongValue());

            case 2: // '\002'
                jsonparser = parseLocal(jsonparser);
                break;
            }
            if (jsonparser == null)
            {
                return null;
            } else
            {
                return jsonparser.toLocalDateTime();
            }
        }

        public LocalDateTimeDeserializer()
        {
            super(org/joda/time/LocalDateTime);
        }
    }

    public static class PeriodDeserializer extends JodaDeserializer
    {

        public volatile Object deserialize(JsonParser jsonparser, DeserializationContext deserializationcontext)
            throws IOException, JsonProcessingException
        {
            return deserialize(jsonparser, deserializationcontext);
        }

        public ReadablePeriod deserialize(JsonParser jsonparser, DeserializationContext deserializationcontext)
            throws IOException, JsonProcessingException
        {
            switch (_cls1..SwitchMap.org.codehaus.jackson.JsonToken[jsonparser.getCurrentToken().ordinal()])
            {
            default:
                throw deserializationcontext.wrongTokenException(jsonparser, JsonToken.START_ARRAY, "expected JSON Number or String");

            case 1: // '\001'
                return new Period(jsonparser.getLongValue());

            case 2: // '\002'
                return new Period(jsonparser.getText());
            }
        }

        public PeriodDeserializer()
        {
            super(org/joda/time/ReadablePeriod);
        }
    }


    public JodaDeserializers()
    {
    }

    public Collection provide()
    {
        return Arrays.asList(new StdDeserializer[] {
            new DateTimeDeserializer(org/joda/time/DateTime), new DateTimeDeserializer(org/joda/time/ReadableDateTime), new DateTimeDeserializer(org/joda/time/ReadableInstant), new LocalDateDeserializer(), new LocalDateTimeDeserializer(), new DateMidnightDeserializer(), new PeriodDeserializer()
        });
    }
}

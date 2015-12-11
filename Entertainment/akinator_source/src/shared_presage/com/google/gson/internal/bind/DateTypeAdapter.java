// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.gson.internal.bind;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import shared_presage.com.google.gson.JsonSyntaxException;
import shared_presage.com.google.gson.TypeAdapter;
import shared_presage.com.google.gson.TypeAdapterFactory;
import shared_presage.com.google.gson.stream.JsonReader;
import shared_presage.com.google.gson.stream.JsonToken;
import shared_presage.com.google.gson.stream.JsonWriter;

// Referenced classes of package shared_presage.com.google.gson.internal.bind:
//            b

public final class DateTypeAdapter extends TypeAdapter
{

    public static final TypeAdapterFactory FACTORY = new b();
    private final DateFormat enUsFormat;
    private final DateFormat iso8601Format = buildIso8601Format();
    private final DateFormat localFormat = DateFormat.getDateTimeInstance(2, 2);

    public DateTypeAdapter()
    {
        enUsFormat = DateFormat.getDateTimeInstance(2, 2, Locale.US);
    }

    private static DateFormat buildIso8601Format()
    {
        SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
        simpledateformat.setTimeZone(TimeZone.getTimeZone("UTC"));
        return simpledateformat;
    }

    private Date deserializeToDate(String s)
    {
        this;
        JVM INSTR monitorenter ;
        Date date = localFormat.parse(s);
        s = date;
_L1:
        this;
        JVM INSTR monitorexit ;
        return s;
        ParseException parseexception;
        parseexception;
        parseexception = enUsFormat.parse(s);
        s = parseexception;
          goto _L1
        parseexception;
        parseexception = iso8601Format.parse(s);
        s = parseexception;
          goto _L1
        parseexception;
        throw new JsonSyntaxException(s, parseexception);
        s;
        this;
        JVM INSTR monitorexit ;
        throw s;
    }

    public final volatile Object read(JsonReader jsonreader)
    {
        return read(jsonreader);
    }

    public final Date read(JsonReader jsonreader)
    {
        if (jsonreader.peek() == JsonToken.NULL)
        {
            jsonreader.nextNull();
            return null;
        } else
        {
            return deserializeToDate(jsonreader.nextString());
        }
    }

    public final volatile void write(JsonWriter jsonwriter, Object obj)
    {
        write(jsonwriter, (Date)obj);
    }

    public final void write(JsonWriter jsonwriter, Date date)
    {
        this;
        JVM INSTR monitorenter ;
        if (date != null) goto _L2; else goto _L1
_L1:
        jsonwriter.nullValue();
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        jsonwriter.value(enUsFormat.format(date));
        if (true) goto _L4; else goto _L3
_L3:
        jsonwriter;
        throw jsonwriter;
    }

}

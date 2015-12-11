// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.gson.internal.bind;

import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import shared_presage.com.google.gson.JsonSyntaxException;
import shared_presage.com.google.gson.TypeAdapter;
import shared_presage.com.google.gson.TypeAdapterFactory;
import shared_presage.com.google.gson.stream.JsonReader;
import shared_presage.com.google.gson.stream.JsonToken;
import shared_presage.com.google.gson.stream.JsonWriter;

// Referenced classes of package shared_presage.com.google.gson.internal.bind:
//            h

public final class TimeTypeAdapter extends TypeAdapter
{

    public static final TypeAdapterFactory FACTORY = new h();
    private final DateFormat format = new SimpleDateFormat("hh:mm:ss a");

    public TimeTypeAdapter()
    {
    }

    public final volatile Object read(JsonReader jsonreader)
    {
        return read(jsonreader);
    }

    public final Time read(JsonReader jsonreader)
    {
        this;
        JVM INSTR monitorenter ;
        if (jsonreader.peek() != JsonToken.NULL) goto _L2; else goto _L1
_L1:
        jsonreader.nextNull();
        jsonreader = null;
_L4:
        this;
        JVM INSTR monitorexit ;
        return jsonreader;
_L2:
        jsonreader = new Time(format.parse(jsonreader.nextString()).getTime());
        if (true) goto _L4; else goto _L3
_L3:
        jsonreader;
        throw new JsonSyntaxException(jsonreader);
        jsonreader;
        this;
        JVM INSTR monitorexit ;
        throw jsonreader;
    }

    public final volatile void write(JsonWriter jsonwriter, Object obj)
    {
        write(jsonwriter, (Time)obj);
    }

    public final void write(JsonWriter jsonwriter, Time time)
    {
        this;
        JVM INSTR monitorenter ;
        if (time != null) goto _L2; else goto _L1
_L1:
        time = null;
_L4:
        jsonwriter.value(time);
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        time = format.format(time);
        if (true) goto _L4; else goto _L3
_L3:
        jsonwriter;
        throw jsonwriter;
    }

}

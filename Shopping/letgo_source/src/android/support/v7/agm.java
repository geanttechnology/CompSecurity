// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

// Referenced classes of package android.support.v7:
//            afl, afi, afm, agq, 
//            aeu

public final class agm extends afl
{

    public static final afm a = new afm() {

        public afl a(aeu aeu, agq agq1)
        {
            if (agq1.a() == java/sql/Date)
            {
                return new agm();
            } else
            {
                return null;
            }
        }

    };
    private final DateFormat b = new SimpleDateFormat("MMM d, yyyy");

    public agm()
    {
    }

    public Date a(JsonReader jsonreader)
        throws IOException
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
        jsonreader = new Date(b.parse(jsonreader.nextString()).getTime());
        if (true) goto _L4; else goto _L3
_L3:
        jsonreader;
        throw new afi(jsonreader);
        jsonreader;
        this;
        JVM INSTR monitorexit ;
        throw jsonreader;
    }

    public volatile void a(JsonWriter jsonwriter, Object obj)
        throws IOException
    {
        a(jsonwriter, (Date)obj);
    }

    public void a(JsonWriter jsonwriter, Date date)
        throws IOException
    {
        this;
        JVM INSTR monitorenter ;
        if (date != null) goto _L2; else goto _L1
_L1:
        date = null;
_L4:
        jsonwriter.value(date);
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        date = b.format(date);
        if (true) goto _L4; else goto _L3
_L3:
        jsonwriter;
        throw jsonwriter;
    }

    public Object b(JsonReader jsonreader)
        throws IOException
    {
        return a(jsonreader);
    }

}

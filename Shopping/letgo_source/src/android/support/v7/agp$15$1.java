// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

// Referenced classes of package android.support.v7:
//            afl, afm, agp, agq, 
//            aeu

class > extends afl
{

    final afl a;
    final eader b;

    public Timestamp a(JsonReader jsonreader)
        throws IOException
    {
        jsonreader = (Date)a.b(jsonreader);
        if (jsonreader != null)
        {
            return new Timestamp(jsonreader.getTime());
        } else
        {
            return null;
        }
    }

    public volatile void a(JsonWriter jsonwriter, Object obj)
        throws IOException
    {
        a(jsonwriter, (Timestamp)obj);
    }

    public void a(JsonWriter jsonwriter, Timestamp timestamp)
        throws IOException
    {
        a.a(jsonwriter, timestamp);
    }

    public Object b(JsonReader jsonreader)
        throws IOException
    {
        return a(jsonreader);
    }

    eader(eader eader, afl afl1)
    {
        b = eader;
        a = afl1;
        super();
    }

    // Unreferenced inner class android/support/v7/agp$15

/* anonymous class */
    static final class agp._cls15
        implements afm
    {

        public afl a(aeu aeu1, agq agq1)
        {
            if (agq1.a() != java/sql/Timestamp)
            {
                return null;
            } else
            {
                return new agp._cls15._cls1(this, aeu1.a(java/util/Date));
            }
        }

    }

}

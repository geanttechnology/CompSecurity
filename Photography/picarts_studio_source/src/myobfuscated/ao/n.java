// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.ao;

import com.millennialmedia.google.gson.JsonSyntaxException;
import com.millennialmedia.google.gson.i;
import com.millennialmedia.google.gson.j;
import com.millennialmedia.google.gson.stream.JsonToken;
import com.millennialmedia.google.gson.stream.a;
import com.millennialmedia.google.gson.stream.b;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class n extends i
{

    public static final j a = new j() {

        public final i a(com.millennialmedia.google.gson.b b1, myobfuscated.ap.a a1)
        {
            if (a1.a == java/sql/Time)
            {
                return new n();
            } else
            {
                return null;
            }
        }

    };
    private final DateFormat b = new SimpleDateFormat("hh:mm:ss a");

    public n()
    {
    }

    private void a(b b1, Time time)
    {
        this;
        JVM INSTR monitorenter ;
        if (time != null) goto _L2; else goto _L1
_L1:
        time = null;
_L4:
        b1.b(time);
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        time = b.format(time);
        if (true) goto _L4; else goto _L3
_L3:
        b1;
        throw b1;
    }

    private Time b(a a1)
    {
        this;
        JVM INSTR monitorenter ;
        if (a1.f() != JsonToken.NULL) goto _L2; else goto _L1
_L1:
        a1.k();
        a1 = null;
_L4:
        this;
        JVM INSTR monitorexit ;
        return a1;
_L2:
        a1 = new Time(b.parse(a1.i()).getTime());
        if (true) goto _L4; else goto _L3
_L3:
        a1;
        throw new JsonSyntaxException(a1);
        a1;
        this;
        JVM INSTR monitorexit ;
        throw a1;
    }

    public final Object a(a a1)
    {
        return b(a1);
    }

    public final volatile void a(b b1, Object obj)
    {
        a(b1, (Time)obj);
    }

}

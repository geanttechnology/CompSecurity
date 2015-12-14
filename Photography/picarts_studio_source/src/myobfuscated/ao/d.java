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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public final class d extends i
{

    public static final j a = new j() {

        public final i a(com.millennialmedia.google.gson.b b1, myobfuscated.ap.a a1)
        {
            if (a1.a == java/util/Date)
            {
                return new d();
            } else
            {
                return null;
            }
        }

    };
    private final DateFormat b;
    private final DateFormat c = DateFormat.getDateTimeInstance(2, 2);
    private final DateFormat d;

    public d()
    {
        b = DateFormat.getDateTimeInstance(2, 2, Locale.US);
        SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
        simpledateformat.setTimeZone(TimeZone.getTimeZone("UTC"));
        d = simpledateformat;
    }

    private Date a(String s)
    {
        this;
        JVM INSTR monitorenter ;
        Date date = c.parse(s);
        s = date;
_L1:
        this;
        JVM INSTR monitorexit ;
        return s;
        ParseException parseexception;
        parseexception;
        parseexception = b.parse(s);
        s = parseexception;
          goto _L1
        parseexception;
        parseexception = d.parse(s);
        s = parseexception;
          goto _L1
        parseexception;
        throw new JsonSyntaxException(s, parseexception);
        s;
        this;
        JVM INSTR monitorexit ;
        throw s;
    }

    private void a(b b1, Date date)
    {
        this;
        JVM INSTR monitorenter ;
        if (date != null) goto _L2; else goto _L1
_L1:
        b1.e();
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        b1.b(b.format(date));
        if (true) goto _L4; else goto _L3
_L3:
        b1;
        throw b1;
    }

    public final Object a(a a1)
    {
        if (a1.f() == JsonToken.NULL)
        {
            a1.k();
            return null;
        } else
        {
            return a(a1.i());
        }
    }

    public final volatile void a(b b1, Object obj)
    {
        a(b1, (Date)obj);
    }

}

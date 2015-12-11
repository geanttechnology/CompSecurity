// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.text.TextUtils;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

final class auh extends auq
{

    private String a;
    private String c;

    auh(aug aug, String s, String s1)
    {
        a = s;
        c = s1;
        super();
    }

    protected final void a(awb awb)
    {
        String s;
        String s1;
        awb = (azh)awb;
        try
        {
            s = a;
            s1 = c;
            if (TextUtils.isEmpty(s1))
            {
                throw new IllegalArgumentException("The message payload cannot be null or empty");
            }
        }
        // Misplaced declaration of an exception variable
        catch (awb awb)
        {
            a(2001);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (awb awb)
        {
            a(2001);
            return;
        }
        if (s1.length() > 0x10000)
        {
            throw new IllegalArgumentException("Message exceeds maximum size");
        }
        long l;
        a.j(s);
        if (!((azh) (awb)).g || ((azh) (awb)).e == null || ((azh) (awb)).e.a.get())
        {
            throw new IllegalStateException("Not connected to a device");
        }
        l = ((azh) (awb)).i.incrementAndGet();
        ((azh) (awb)).j.put(Long.valueOf(l), this);
        ((azq)awb.i()).a(s, s1, l);
        return;
        Throwable throwable;
        throwable;
        ((azh) (awb)).j.remove(Long.valueOf(l));
        throw throwable;
    }
}

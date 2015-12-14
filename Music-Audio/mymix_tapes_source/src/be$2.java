// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.nuance.nmdp.speechkit.recognitionresult.b;

final class b
    implements bz
{

    private int a;
    private boolean b;
    private be c;

    private void a()
    {
        synchronized (be.b(c))
        {
            be.c(c);
            if (be.d(c))
            {
                be.b(c).notify();
                be.e(c);
            }
        }
    }

    public final void a(ca ca, String s, Object obj)
    {
        if (ca == be.f(c)) goto _L2; else goto _L1
_L1:
        com.nuance.nmdp.speechkit.recognitionresult.b.b(c, (new StringBuilder()).append("Event ").append(s).append(" received for invalid recorder").toString());
_L4:
        return;
_L2:
        if (s != "BUFFER_RECORDED")
        {
            break; /* Loop/switch isn't completed */
        }
        if (obj instanceof Float)
        {
            ca = be.h(c);
            be.g(c);
            ca.a(((Float)obj).floatValue());
            return;
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (s == "STARTED")
        {
            b = true;
            ca = be.h(c);
            be.g(c);
            ca.a();
            return;
        }
        if (s == "STOPPED")
        {
            com.nuance.nmdp.speechkit.recognitionresult.b.a(c, "Recorder stopped");
            a();
            ca = be.h(c);
            be.g(c);
            ca.a(a);
            return;
        }
        if (s != "RECORD_ERROR")
        {
            break; /* Loop/switch isn't completed */
        }
        com.nuance.nmdp.speechkit.recognitionresult.b.c(c, "Recorder error");
        a = 4;
        if (!b)
        {
            a();
            ca = be.h(c);
            be.g(c);
            ca.a(a);
            return;
        }
        if (true) goto _L4; else goto _L5
_L5:
        if (s == "END_OF_SPEECH")
        {
            com.nuance.nmdp.speechkit.recognitionresult.b.a(c, "Recorder event (end of speech)");
            a = 2;
            return;
        }
        if (s == "CAPTURE_TIMEOUT")
        {
            com.nuance.nmdp.speechkit.recognitionresult.b.a(c, "Recorder event (timeout)");
            a = 3;
            return;
        }
        if (true) goto _L4; else goto _L6
_L6:
    }

    >(be be1)
    {
        c = be1;
        super();
        a = 0;
        b = false;
    }
}

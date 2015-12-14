// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.nuance.nmdp.speechkit.recognitionresult.b;

final class a
    implements by
{

    private boolean a;
    private bc b;

    private void a()
    {
        synchronized (bc.a(b))
        {
            bc.b(b);
            if (bc.c(b))
            {
                bc.a(b).notify();
                bc.d(b);
            }
        }
    }

    public final void a(String s)
    {
        if (s == "BUFFER_PLAYED")
        {
            if (!a)
            {
                com.nuance.nmdp.speechkit.recognitionresult.b.a(b, "First audio buffer played");
                bc.f(b).b(bc.e(b));
                a = true;
            }
        } else
        if (s != "BUFFERING")
        {
            if (s == "STARTED")
            {
                com.nuance.nmdp.speechkit.recognitionresult.b.a(b, "Audio playback started");
                return;
            }
            if (s == "STOPPED")
            {
                com.nuance.nmdp.speechkit.recognitionresult.b.a(b, "Audio playback stopped");
                a();
                bc.f(b).c(bc.e(b));
                return;
            }
            if (s == "PLAYBACK_ERROR")
            {
                com.nuance.nmdp.speechkit.recognitionresult.b.c(b, "Audio playback error");
                a();
                bc.f(b).a(bc.e(b));
                return;
            }
        }
    }

    >(bc bc1)
    {
        b = bc1;
        super();
        a = false;
    }
}

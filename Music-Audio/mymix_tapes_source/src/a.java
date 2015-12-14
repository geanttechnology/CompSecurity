// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Handler;
import com.nuance.nmdp.speechkit.recognitionresult.b;

public abstract class a
{

    protected final Object a = new Object();
    private final Handler b;

    public a(Object obj)
    {
        b = (Handler)obj;
    }

    protected final void a(Runnable runnable)
    {
        if (b != null) goto _L2; else goto _L1
_L1:
        runnable.run();
_L4:
        return;
        runnable;
        com.nuance.nmdp.speechkit.recognitionresult.b.a(this, "Exception in application callback", runnable);
        return;
_L2:
        if (b.post(runnable)) goto _L4; else goto _L3
_L3:
        com.nuance.nmdp.speechkit.recognitionresult.b.c(this, "Unable to post callback to handler");
        return;
        runnable;
        com.nuance.nmdp.speechkit.recognitionresult.b.a(this, "Exception posting callback to handler", runnable);
        return;
    }
}

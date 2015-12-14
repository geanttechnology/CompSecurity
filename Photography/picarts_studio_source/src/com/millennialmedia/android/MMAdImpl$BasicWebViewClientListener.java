// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import java.lang.ref.WeakReference;

// Referenced classes of package com.millennialmedia.android:
//            MMAdImpl, MMAdImplController, MMWebView

class a extends ner
{

    WeakReference a;

    final void a()
    {
        MMAdImpl mmadimpl = (MMAdImpl)a.get();
        if (mmadimpl != null)
        {
            mmadimpl.setClickable(false);
        }
    }

    public void onPageFinished(String s)
    {
        MMAdImpl mmadimpl;
        mmadimpl = (MMAdImpl)a.get();
        if (mmadimpl == null)
        {
            break MISSING_BLOCK_LABEL_91;
        }
        mmadimpl.setClickable(true);
        if (mmadimpl.h == null || mmadimpl.h.a == null)
        {
            break MISSING_BLOCK_LABEL_91;
        }
        s = mmadimpl.h.a;
        s;
        JVM INSTR monitorenter ;
        if (!mmadimpl.h.a.hasWindowFocus())
        {
            break MISSING_BLOCK_LABEL_73;
        }
        mmadimpl.h.a.m();
_L2:
        return;
        mmadimpl.h.a.l();
        if (true) goto _L2; else goto _L1
_L1:
        Exception exception;
        exception;
        s;
        JVM INSTR monitorexit ;
        throw exception;
    }

    ner(MMAdImpl mmadimpl)
    {
        a = new WeakReference(mmadimpl);
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp;

import okio.h;
import okio.q;

// Referenced classes of package com.squareup.okhttp:
//            Cache

class val.editor extends h
{

    final tor.commit this$1;
    final com.squareup.okhttp.internal.t val$editor;
    final Cache val$this$0;

    public void close()
    {
label0:
        {
            synchronized (_fld0)
            {
                if (!cess._mth600(this._cls1.this))
                {
                    break label0;
                }
            }
            return;
        }
        cess._mth602(this._cls1.this, true);
        Cache.access$708(_fld0);
        cache;
        JVM INSTR monitorexit ;
        super.close();
        val$editor.t();
        return;
        exception;
        cache;
        JVM INSTR monitorexit ;
        throw exception;
    }

    tor(com.squareup.okhttp.internal. )
    {
        this$1 = final_tor;
        val$this$0 = Cache.this;
        val$editor = ;
        super(final_q);
    }
}

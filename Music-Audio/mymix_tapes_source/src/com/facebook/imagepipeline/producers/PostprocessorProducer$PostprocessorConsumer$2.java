// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.producers;

import com.facebook.common.references.CloseableReference;

// Referenced classes of package com.facebook.imagepipeline.producers:
//            PostprocessorProducer

class this._cls1
    implements Runnable
{

    final this._cls1 this$1;

    public void run()
    {
        boolean flag;
        synchronized (this._cls1.this)
        {
            obj = cess._mth300(this._cls1.this);
            flag = cess._mth400(this._cls1.this);
            cess._mth302(this._cls1.this, null);
            cess._mth502(this._cls1.this, false);
        }
        if (!CloseableReference.isValid(((CloseableReference) (obj))))
        {
            break MISSING_BLOCK_LABEL_63;
        }
        cess._mth600(this._cls1.this, ((CloseableReference) (obj)), flag);
        CloseableReference.closeSafely(((CloseableReference) (obj)));
        cess._mth700(this._cls1.this);
        return;
        obj;
        _lcls1;
        JVM INSTR monitorexit ;
        throw obj;
        Exception exception;
        exception;
        CloseableReference.closeSafely(((CloseableReference) (obj)));
        throw exception;
    }

    ()
    {
        this$1 = this._cls1.this;
        super();
    }
}

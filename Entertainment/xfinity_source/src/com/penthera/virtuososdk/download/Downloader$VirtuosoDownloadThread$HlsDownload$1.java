// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.penthera.virtuososdk.download;

import org.apache.http.client.HttpClient;
import org.apache.http.conn.ClientConnectionManager;

// Referenced classes of package com.penthera.virtuososdk.download:
//            Downloader

class this._cls2
    implements Runnable
{

    final this._cls2 this$2;

    public void run()
    {
_L5:
        obj = tNext();
        if (obj == null) goto _L2; else goto _L1
_L1:
        boolean flag = cess._mth2(this._cls2.this);
        if (!flag) goto _L3; else goto _L2
_L2:
        obj = this._cls2.this;
        cess._mth1(((cess._cls1) (obj)), cess._mth0(((cess._cls0) (obj))) - 1);
        if (cess._mth0(this._cls2.this) <= 0 && !cess._mth2(this._cls2.this))
        {
            synchronized (this._mth2(cess._mth7(this._cls2.this)))
            {
                this._mth2(cess._mth7(this._cls2.this)).notify();
            }
        }
        return;
_L3:
        obj = cess._mth3(this._cls2.this, ((com.penthera.virtuososdk.internal.interfaces.IEngFileFragment) (obj)));
        obj1 = cess._mth4(this._cls2.this);
        obj1;
        JVM INSTR monitorenter ;
        if (this._mth2(cess._mth7(this._cls2.this)))
        {
            obj = this._mth2(cess._mth7(this._cls2.this));
        }
        if (!cess._mth2(this._cls2.this))
        {
            Downloader.access$1(this._mth2(cess._mth7(this._cls2.this)), ((com.penthera.virtuososdk.utility..this._cls2) (obj)));
        }
        if (obj == com.penthera.virtuososdk.utility.lete)
        {
            break MISSING_BLOCK_LABEL_298;
        }
        cess._mth5(this._cls2.this, true);
        cess._mth6(this._cls2.this).getConnectionManager().shutdown();
        synchronized (this._mth2(cess._mth7(this._cls2.this)))
        {
            this._mth2(cess._mth7(this._cls2.this)).notify();
        }
        obj1;
        JVM INSTR monitorexit ;
          goto _L2
        obj;
        obj1;
        JVM INSTR monitorexit ;
        throw obj;
        obj;
        obj1 = this._cls2.this;
        cess._mth1(((cess._cls1) (obj1)), cess._mth0(((cess._cls0) (obj1))) - 1);
        if (cess._mth0(this._cls2.this) <= 0 && !cess._mth2(this._cls2.this))
        {
            synchronized (this._mth2(cess._mth7(this._cls2.this)))
            {
                this._mth2(cess._mth7(this._cls2.this)).notify();
            }
        }
        throw obj;
        exception1;
        obj;
        JVM INSTR monitorexit ;
        throw exception1;
        obj1;
        JVM INSTR monitorexit ;
        if (true) goto _L5; else goto _L4
_L4:
        obj;
        obj1;
        JVM INSTR monitorexit ;
        throw obj;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    ()
    {
        this$2 = this._cls2.this;
        super();
    }
}

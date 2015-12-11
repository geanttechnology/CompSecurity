// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.parse:
//            OfflineStore

class this._cls1
    implements i
{

    final then this$1;

    public j then(j j1)
        throws Exception
    {
label0:
        {
            j j3;
            synchronized (cess._mth000(this._cls1.this))
            {
                Iterator iterator = cess._mth100(this._cls1.this).iterator();
                do
                {
                    if (!iterator.hasNext())
                    {
                        break label0;
                    }
                    j3 = (j)iterator.next();
                } while (!j3.d() && !j3.c());
            }
            return j3;
        }
        j j2;
        cess._mth100(this._cls1.this).clear();
        j2 = j.a((Void)null);
        j1;
        JVM INSTR monitorexit ;
        return j2;
        exception;
        j1;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public volatile Object then(j j1)
        throws Exception
    {
        return then(j1);
    }

    ()
    {
        this$1 = this._cls1.this;
        super();
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.ct;
import android.support.v7.cu;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.parse:
//            OfflineStore

class this._cls1
    implements ct
{

    final then this$1;

    public cu then(cu cu1)
        throws Exception
    {
label0:
        {
            cu cu3;
            synchronized (cess._mth000(this._cls1.this))
            {
                Iterator iterator = cess._mth100(this._cls1.this).iterator();
                do
                {
                    if (!iterator.hasNext())
                    {
                        break label0;
                    }
                    cu3 = (cu)iterator.next();
                } while (!cu3.d() && !cu3.c());
            }
            return cu3;
        }
        cu cu2;
        cess._mth100(this._cls1.this).clear();
        cu2 = cu.a((Void)null);
        cu1;
        JVM INSTR monitorexit ;
        return cu2;
        exception;
        cu1;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public volatile Object then(cu cu1)
        throws Exception
    {
        return then(cu1);
    }

    ()
    {
        this$1 = this._cls1.this;
        super();
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.store.handler;

import com.target.mothership.model.store.interfaces.b;
import com.target.mothership.services.aa;
import com.target.mothership.services.e.h.b.f;

// Referenced classes of package com.target.mothership.model.store.handler:
//            b

class val.data
    implements b
{

    final val.data this$1;
    final f val$data;

    public String a()
    {
        return val$data.a();
    }

    public int b()
    {
        int i;
        try
        {
            i = Integer.parseInt(val$data.b());
        }
        catch (NumberFormatException numberformatexception)
        {
            return -1;
        }
        return i;
    }

    is._cls0()
    {
        this$1 = final__pcls0;
        val$data = f.this;
        super();
    }

    // Unreferenced inner class com/target/mothership/model/store/handler/b$1

/* anonymous class */
    class b._cls1
        implements aa
    {

        final com.target.mothership.model.store.handler.b this$0;

        public b a(f f1)
        {
            return f1. new b._cls1._cls1();
        }

        public volatile Object a(Object obj)
        {
            return a((f)obj);
        }

            
            {
                this$0 = com.target.mothership.model.store.handler.b.this;
                super();
            }
    }

}

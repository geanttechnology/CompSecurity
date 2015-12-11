// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.store.handler;

import com.target.mothership.model.store.interfaces.b;
import com.target.mothership.services.aa;
import com.target.mothership.services.e.h.b.f;

// Referenced classes of package com.target.mothership.model.store.handler:
//            b

class this._cls0
    implements aa
{

    final com.target.mothership.model.store.handler.b this$0;

    public b a(final f data)
    {
        return new b() {

            final b._cls1 this$1;
            final f val$data;

            public String a()
            {
                return data.a();
            }

            public int b()
            {
                int i;
                try
                {
                    i = Integer.parseInt(data.b());
                }
                catch (NumberFormatException numberformatexception)
                {
                    return -1;
                }
                return i;
            }

            
            {
                this$1 = b._cls1.this;
                data = f1;
                super();
            }
        };
    }

    public volatile Object a(Object obj)
    {
        return a((f)obj);
    }

    _cls1.val.data()
    {
        this$0 = com.target.mothership.model.store.handler.b.this;
        super();
    }
}

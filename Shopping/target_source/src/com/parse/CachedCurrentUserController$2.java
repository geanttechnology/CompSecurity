// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;

// Referenced classes of package com.parse:
//            CachedCurrentUserController, ParseObjectStore

class this._cls0
    implements i
{

    final CachedCurrentUserController this$0;

    public j then(j j1)
        throws Exception
    {
        return j1.b(new i() {

            final CachedCurrentUserController._cls2 this$1;

            public j then(j j2)
                throws Exception
            {
                return CachedCurrentUserController.access$100(this$0).existsAsync();
            }

            public volatile Object then(j j2)
                throws Exception
            {
                return then(j2);
            }

            
            {
                this$1 = CachedCurrentUserController._cls2.this;
                super();
            }
        });
    }

    public volatile Object then(j j1)
        throws Exception
    {
        return then(j1);
    }

    _cls1.this._cls1()
    {
        this$0 = CachedCurrentUserController.this;
        super();
    }
}

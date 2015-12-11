// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;

// Referenced classes of package com.parse:
//            CachedCurrentUserController, ParseObjectStore

class this._cls1
    implements i
{

    final then this$1;

    public j then(j j)
        throws Exception
    {
        return CachedCurrentUserController.access$100(_fld0).existsAsync();
    }

    public volatile Object then(j j)
        throws Exception
    {
        return then(j);
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/parse/CachedCurrentUserController$2

/* anonymous class */
    class CachedCurrentUserController._cls2
        implements i
    {

        final CachedCurrentUserController this$0;

        public j then(j j1)
            throws Exception
        {
            return j1.b(new CachedCurrentUserController._cls2._cls1());
        }

        public volatile Object then(j j1)
            throws Exception
        {
            return then(j1);
        }

            
            {
                this$0 = CachedCurrentUserController.this;
                super();
            }
    }

}

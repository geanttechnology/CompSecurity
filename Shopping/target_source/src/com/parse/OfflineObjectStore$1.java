// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;
import java.util.Arrays;

// Referenced classes of package com.parse:
//            OfflineObjectStore, ParseObject, ParseObjectStore

static final class val.to
    implements i
{

    final ParseObjectStore val$from;
    final ParseObjectStore val$to;

    public j then(j j1)
        throws Exception
    {
        final ParseObject object = (ParseObject)j1.e();
        if (object == null)
        {
            return j1;
        } else
        {
            return j.a(Arrays.asList(new j[] {
                val$from.deleteAsync(), val$to.setAsync(object)
            })).a(new i() {

                final OfflineObjectStore._cls1 this$0;
                final ParseObject val$object;

                public ParseObject then(j j2)
                    throws Exception
                {
                    return object;
                }

                public volatile Object then(j j2)
                    throws Exception
                {
                    return then(j2);
                }

            
            {
                this$0 = OfflineObjectStore._cls1.this;
                object = parseobject;
                super();
            }
            });
        }
    }

    public volatile Object then(j j1)
        throws Exception
    {
        return then(j1);
    }

    _cls1.val.object(ParseObjectStore parseobjectstore, ParseObjectStore parseobjectstore1)
    {
        val$from = parseobjectstore;
        val$to = parseobjectstore1;
        super();
    }
}

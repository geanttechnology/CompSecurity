// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;
import java.util.Arrays;

// Referenced classes of package com.parse:
//            ParseObject, OfflineObjectStore, ParseObjectStore

class val.object
    implements i
{

    final then this$0;
    final ParseObject val$object;

    public ParseObject then(j j)
        throws Exception
    {
        return val$object;
    }

    public volatile Object then(j j)
        throws Exception
    {
        return then(j);
    }

    l.to()
    {
        this$0 = final_to;
        val$object = ParseObject.this;
        super();
    }

    // Unreferenced inner class com/parse/OfflineObjectStore$1

/* anonymous class */
    static final class OfflineObjectStore._cls1
        implements i
    {

        final ParseObjectStore val$from;
        final ParseObjectStore val$to;

        public j then(j j1)
            throws Exception
        {
            ParseObject parseobject = (ParseObject)j1.e();
            if (parseobject == null)
            {
                return j1;
            } else
            {
                return j.a(Arrays.asList(new j[] {
                    from.deleteAsync(), to.setAsync(parseobject)
                })).a(parseobject. new OfflineObjectStore._cls1._cls1());
            }
        }

        public volatile Object then(j j1)
            throws Exception
        {
            return then(j1);
        }

            
            {
                from = parseobjectstore;
                to = parseobjectstore1;
                super();
            }
    }

}

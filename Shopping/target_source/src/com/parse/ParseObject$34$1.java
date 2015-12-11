// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.parse:
//            ParseObject, ParseObjectController

class val.object
    implements i
{

    final then this$0;
    final ParseObject val$object;

    public j then(final j batchTask)
        throws Exception
    {
        return val$object.handleDeleteResultAsync().b(new i() {

            final ParseObject._cls34._cls1 this$1;
            final j val$batchTask;

            public j then(j j1)
                throws Exception
            {
                return batchTask;
            }

            public volatile Object then(j j1)
                throws Exception
            {
                return then(j1);
            }

            
            {
                this$1 = ParseObject._cls34._cls1.this;
                batchTask = j1;
                super();
            }
        });
    }

    public volatile Object then(j j1)
        throws Exception
    {
        return then(j1);
    }

    l.sessionToken()
    {
        this$0 = final_sessiontoken;
        val$object = ParseObject.this;
        super();
    }

    // Unreferenced inner class com/parse/ParseObject$34

/* anonymous class */
    static final class ParseObject._cls34
        implements i
    {

        final String val$sessionToken;
        final List val$uniqueObjects;

        public j then(j j1)
            throws Exception
        {
            int i1 = uniqueObjects.size();
            j1 = new ArrayList(i1);
            for (int k = 0; k < i1; k++)
            {
                ParseObject parseobject = (ParseObject)uniqueObjects.get(k);
                parseobject.validateDelete();
                j1.add(parseobject.getState());
            }

            j1 = ParseObject.access$800().deleteAllAsync(j1, sessionToken);
            ArrayList arraylist = new ArrayList(i1);
            for (int l = 0; l < i1; l++)
            {
                arraylist.add(((j)j1.get(l)).d(((ParseObject)uniqueObjects.get(l)). new ParseObject._cls34._cls1()));
            }

            return j.a(arraylist);
        }

        public volatile Object then(j j1)
            throws Exception
        {
            return then(j1);
        }

            
            {
                uniqueObjects = list;
                sessionToken = s;
                super();
            }
    }

}

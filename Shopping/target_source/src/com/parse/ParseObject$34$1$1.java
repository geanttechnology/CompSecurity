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

class val.batchTask
    implements i
{

    final then this$1;
    final j val$batchTask;

    public j then(j j)
        throws Exception
    {
        return val$batchTask;
    }

    public volatile Object then(j j)
        throws Exception
    {
        return then(j);
    }

    sessionToken()
    {
        this$1 = final_sessiontoken;
        val$batchTask = j.this;
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


    // Unreferenced inner class com/parse/ParseObject$34$1

/* anonymous class */
    class ParseObject._cls34._cls1
        implements i
    {

        final ParseObject._cls34 this$0;
        final ParseObject val$object;

        public j then(j j1)
            throws Exception
        {
            return object.handleDeleteResultAsync().b(j1. new ParseObject._cls34._cls1._cls1());
        }

        public volatile Object then(j j1)
            throws Exception
        {
            return then(j1);
        }

            
            {
                this$0 = final__pcls34;
                object = ParseObject.this;
                super();
            }
    }

}

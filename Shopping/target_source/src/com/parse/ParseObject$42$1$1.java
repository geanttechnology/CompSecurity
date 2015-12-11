// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.parse:
//            ParseObject, KnownParseObjectDecoder, ParseObjectController, ParseOperationSet

class val.batchTask
    implements i
{

    final then this$1;
    final j val$batchTask;

    public j then(j j1)
        throws Exception
    {
        if (j1.d() || j1.c())
        {
            return j1;
        } else
        {
            return val$batchTask.j();
        }
    }

    public volatile Object then(j j1)
        throws Exception
    {
        return then(j1);
    }

    sessionToken()
    {
        this$1 = final_sessiontoken;
        val$batchTask = j.this;
        super();
    }

    // Unreferenced inner class com/parse/ParseObject$42

/* anonymous class */
    static final class ParseObject._cls42
        implements i
    {

        final String val$sessionToken;
        final List val$uniqueObjects;

        public j then(j j1)
            throws Exception
        {
            int i1 = uniqueObjects.size();
            Object obj = new ArrayList(i1);
            j1 = new ArrayList(i1);
            ArrayList arraylist = new ArrayList(i1);
            for (int k = 0; k < i1; k++)
            {
                ParseObject parseobject = (ParseObject)uniqueObjects.get(k);
                parseobject.updateBeforeSave();
                parseobject.validateSave();
                ((List) (obj)).add(parseobject.getState());
                j1.add(parseobject.startSave());
                arraylist.add(new KnownParseObjectDecoder(ParseObject.access$700(parseobject)));
            }

            obj = ParseObject.access$800().saveAllAsync(((List) (obj)), j1, sessionToken, arraylist);
            arraylist = new ArrayList(i1);
            for (int l = 0; l < i1; l++)
            {
                arraylist.add(((j)((List) (obj)).get(l)).b(((ParseOperationSet)j1.get(l)). new ParseObject._cls42._cls1()));
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


    // Unreferenced inner class com/parse/ParseObject$42$1

/* anonymous class */
    class ParseObject._cls42._cls1
        implements i
    {

        final ParseObject._cls42 this$0;
        final ParseObject val$object;
        final ParseOperationSet val$operations;

        public j then(j j1)
            throws Exception
        {
            ParseObject.State state = (ParseObject.State)j1.e();
            return object.handleSaveResultAsync(state, operations).b(j1. new ParseObject._cls42._cls1._cls1());
        }

        public volatile Object then(j j1)
            throws Exception
        {
            return then(j1);
        }

            
            {
                this$0 = final__pcls42;
                object = parseobject;
                operations = ParseOperationSet.this;
                super();
            }
    }

}

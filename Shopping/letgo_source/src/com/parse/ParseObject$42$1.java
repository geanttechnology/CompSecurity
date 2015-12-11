// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.ct;
import android.support.v7.cu;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.parse:
//            ParseObject, ParseOperationSet, KnownParseObjectDecoder, ParseObjectController

class 
    implements ct
{

    final then this$0;
    final ParseObject val$object;
    final ParseOperationSet val$operations;

    public cu then(final cu batchTask)
        throws Exception
    {
          = ()batchTask.e();
        return val$object.handleSaveResultAsync(, val$operations).b(new ct() {

            final ParseObject._cls42._cls1 this$1;
            final cu val$batchTask;

            public cu then(cu cu1)
                throws Exception
            {
                if (cu1.d() || cu1.c())
                {
                    return cu1;
                } else
                {
                    return batchTask.j();
                }
            }

            public volatile Object then(cu cu1)
                throws Exception
            {
                return then(cu1);
            }

            
            {
                this$1 = ParseObject._cls42._cls1.this;
                batchTask = cu1;
                super();
            }
        });
    }

    public volatile Object then(cu cu1)
        throws Exception
    {
        return then(cu1);
    }

    ()
    {
        this$0 = final_;
        val$object = parseobject;
        val$operations = ParseOperationSet.this;
        super();
    }

    // Unreferenced inner class com/parse/ParseObject$42

/* anonymous class */
    static final class ParseObject._cls42
        implements ct
    {

        final String val$sessionToken;
        final List val$uniqueObjects;

        public cu then(cu cu1)
            throws Exception
        {
            int k = uniqueObjects.size();
            Object obj = new ArrayList(k);
            cu1 = new ArrayList(k);
            ArrayList arraylist = new ArrayList(k);
            for (int i = 0; i < k; i++)
            {
                ParseObject parseobject = (ParseObject)uniqueObjects.get(i);
                parseobject.updateBeforeSave();
                parseobject.validateSave();
                ((List) (obj)).add(parseobject.getState());
                cu1.add(parseobject.startSave());
                arraylist.add(new KnownParseObjectDecoder(ParseObject.access$800(parseobject)));
            }

            obj = ParseObject.access$900().saveAllAsync(((List) (obj)), cu1, sessionToken, arraylist);
            arraylist = new ArrayList(k);
            for (int j = 0; j < k; j++)
            {
                arraylist.add(((cu)((List) (obj)).get(j)).b(((ParseOperationSet)cu1.get(j)). new ParseObject._cls42._cls1()));
            }

            return cu.a(arraylist);
        }

        public volatile Object then(cu cu1)
            throws Exception
        {
            return then(cu1);
        }

            
            {
                uniqueObjects = list;
                sessionToken = s;
                super();
            }
    }

}

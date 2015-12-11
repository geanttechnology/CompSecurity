// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.ct;
import android.support.v7.cu;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.parse:
//            ParseObject, ParseObjectController

class val.batchTask
    implements ct
{

    final then this$1;
    final cu val$batchTask;

    public cu then(cu cu)
        throws Exception
    {
        return val$batchTask;
    }

    public volatile Object then(cu cu)
        throws Exception
    {
        return then(cu);
    }

    sessionToken()
    {
        this$1 = final_sessiontoken;
        val$batchTask = cu.this;
        super();
    }

    // Unreferenced inner class com/parse/ParseObject$34

/* anonymous class */
    static final class ParseObject._cls34
        implements ct
    {

        final String val$sessionToken;
        final List val$uniqueObjects;

        public cu then(cu cu1)
            throws Exception
        {
            int k = uniqueObjects.size();
            cu1 = new ArrayList(k);
            for (int i = 0; i < k; i++)
            {
                ParseObject parseobject = (ParseObject)uniqueObjects.get(i);
                parseobject.validateDelete();
                cu1.add(parseobject.getState());
            }

            cu1 = ParseObject.access$900().deleteAllAsync(cu1, sessionToken);
            ArrayList arraylist = new ArrayList(k);
            for (int j = 0; j < k; j++)
            {
                arraylist.add(((cu)cu1.get(j)).d(((ParseObject)uniqueObjects.get(j)). new ParseObject._cls34._cls1()));
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


    // Unreferenced inner class com/parse/ParseObject$34$1

/* anonymous class */
    class ParseObject._cls34._cls1
        implements ct
    {

        final ParseObject._cls34 this$0;
        final ParseObject val$object;

        public cu then(cu cu1)
            throws Exception
        {
            return object.handleDeleteResultAsync().b(cu1. new ParseObject._cls34._cls1._cls1());
        }

        public volatile Object then(cu cu1)
            throws Exception
        {
            return then(cu1);
        }

            
            {
                this$0 = final__pcls34;
                object = ParseObject.this;
                super();
            }
    }

}

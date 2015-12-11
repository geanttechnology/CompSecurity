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

class val.object
    implements ct
{

    final then this$0;
    final ParseObject val$object;

    public cu then(final cu batchTask)
        throws Exception
    {
        return val$object.handleDeleteResultAsync().b(new ct() {

            final ParseObject._cls34._cls1 this$1;
            final cu val$batchTask;

            public cu then(cu cu1)
                throws Exception
            {
                return batchTask;
            }

            public volatile Object then(cu cu1)
                throws Exception
            {
                return then(cu1);
            }

            
            {
                this$1 = ParseObject._cls34._cls1.this;
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

    l.sessionToken()
    {
        this$0 = final_sessiontoken;
        val$object = ParseObject.this;
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

}

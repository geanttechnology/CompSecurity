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

static final class val.sessionToken
    implements ct
{

    final String val$sessionToken;
    final List val$uniqueObjects;

    public cu then(cu cu1)
        throws Exception
    {
        int k = val$uniqueObjects.size();
        cu1 = new ArrayList(k);
        for (int i = 0; i < k; i++)
        {
            ParseObject parseobject = (ParseObject)val$uniqueObjects.get(i);
            parseobject.validateDelete();
            cu1.add(parseobject.getState());
        }

        cu1 = ParseObject.access$900().deleteAllAsync(cu1, val$sessionToken);
        ArrayList arraylist = new ArrayList(k);
        for (int j = 0; j < k; j++)
        {
            arraylist.add(((cu)cu1.get(j)).d(new ct() {

                final ParseObject._cls34 this$0;
                final ParseObject val$object;

                public cu then(cu cu2)
                    throws Exception
                {
                    return object.handleDeleteResultAsync().b(cu2. new ct() {

                        final _cls1 this$1;
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
                this$1 = final__pcls1;
                batchTask = cu.this;
                super();
            }
                    });
                }

                public volatile Object then(cu cu2)
                    throws Exception
                {
                    return then(cu2);
                }

            
            {
                this$0 = ParseObject._cls34.this;
                object = parseobject;
                super();
            }
            }));
        }

        return cu.a(arraylist);
    }

    public volatile Object then(cu cu1)
        throws Exception
    {
        return then(cu1);
    }

    _cls1.val.object(List list, String s)
    {
        val$uniqueObjects = list;
        val$sessionToken = s;
        super();
    }
}

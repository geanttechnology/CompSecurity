// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.ct;
import android.support.v7.cu;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.parse:
//            ParseObject, KnownParseObjectDecoder, ParseObjectController, ParseOperationSet

static final class val.sessionToken
    implements ct
{

    final String val$sessionToken;
    final List val$uniqueObjects;

    public cu then(cu cu1)
        throws Exception
    {
        int k = val$uniqueObjects.size();
        Object obj = new ArrayList(k);
        cu1 = new ArrayList(k);
        ArrayList arraylist = new ArrayList(k);
        for (int i = 0; i < k; i++)
        {
            ParseObject parseobject = (ParseObject)val$uniqueObjects.get(i);
            parseobject.updateBeforeSave();
            parseobject.validateSave();
            ((List) (obj)).add(parseobject.getState());
            cu1.add(parseobject.startSave());
            arraylist.add(new KnownParseObjectDecoder(ParseObject.access$800(parseobject)));
        }

        obj = ParseObject.access$900().saveAllAsync(((List) (obj)), cu1, val$sessionToken, arraylist);
        arraylist = new ArrayList(k);
        for (int j = 0; j < k; j++)
        {
            arraylist.add(((cu)((List) (obj)).get(j)).b(new ct() {

                final ParseObject._cls42 this$0;
                final ParseObject val$object;
                final ParseOperationSet val$operations;

                public cu then(cu cu2)
                    throws Exception
                {
                    ParseObject.State state = (ParseObject.State)cu2.e();
                    return object.handleSaveResultAsync(state, operations).b(cu2. new ct() {

                        final _cls1 this$1;
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
                this$0 = ParseObject._cls42.this;
                object = parseobject;
                operations = parseoperationset;
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

    _cls1.val.operations(List list, String s)
    {
        val$uniqueObjects = list;
        val$sessionToken = s;
        super();
    }
}

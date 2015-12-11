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

static final class val.sessionToken
    implements i
{

    final String val$sessionToken;
    final List val$uniqueObjects;

    public j then(j j1)
        throws Exception
    {
        int i1 = val$uniqueObjects.size();
        Object obj = new ArrayList(i1);
        j1 = new ArrayList(i1);
        ArrayList arraylist = new ArrayList(i1);
        for (int k = 0; k < i1; k++)
        {
            ParseObject parseobject = (ParseObject)val$uniqueObjects.get(k);
            parseobject.updateBeforeSave();
            parseobject.validateSave();
            ((List) (obj)).add(parseobject.getState());
            j1.add(parseobject.startSave());
            arraylist.add(new KnownParseObjectDecoder(ParseObject.access$700(parseobject)));
        }

        obj = ParseObject.access$800().saveAllAsync(((List) (obj)), j1, val$sessionToken, arraylist);
        arraylist = new ArrayList(i1);
        for (int l = 0; l < i1; l++)
        {
            arraylist.add(((j)((List) (obj)).get(l)).b(new i() {

                final ParseObject._cls42 this$0;
                final ParseObject val$object;
                final ParseOperationSet val$operations;

                public j then(j j2)
                    throws Exception
                {
                    ParseObject.State state = (ParseObject.State)j2.e();
                    return object.handleSaveResultAsync(state, operations).b(j2. new i() {

                        final _cls1 this$1;
                        final j val$batchTask;

                        public j then(j j1)
                            throws Exception
                        {
                            if (j1.d() || j1.c())
                            {
                                return j1;
                            } else
                            {
                                return batchTask.j();
                            }
                        }

                        public volatile Object then(j j1)
                            throws Exception
                        {
                            return then(j1);
                        }

            
            {
                this$1 = final__pcls1;
                batchTask = j.this;
                super();
            }
                    });
                }

                public volatile Object then(j j2)
                    throws Exception
                {
                    return then(j2);
                }

            
            {
                this$0 = ParseObject._cls42.this;
                object = parseobject;
                operations = parseoperationset;
                super();
            }
            }));
        }

        return j.a(arraylist);
    }

    public volatile Object then(j j1)
        throws Exception
    {
        return then(j1);
    }

    _cls1.val.operations(List list, String s)
    {
        val$uniqueObjects = list;
        val$sessionToken = s;
        super();
    }
}

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

static final class val.sessionToken
    implements i
{

    final String val$sessionToken;
    final List val$uniqueObjects;

    public j then(j j1)
        throws Exception
    {
        int i1 = val$uniqueObjects.size();
        j1 = new ArrayList(i1);
        for (int k = 0; k < i1; k++)
        {
            ParseObject parseobject = (ParseObject)val$uniqueObjects.get(k);
            parseobject.validateDelete();
            j1.add(parseobject.getState());
        }

        j1 = ParseObject.access$800().deleteAllAsync(j1, val$sessionToken);
        ArrayList arraylist = new ArrayList(i1);
        for (int l = 0; l < i1; l++)
        {
            arraylist.add(((j)j1.get(l)).d(new i() {

                final ParseObject._cls34 this$0;
                final ParseObject val$object;

                public j then(j j2)
                    throws Exception
                {
                    return object.handleDeleteResultAsync().b(j2. new i() {

                        final _cls1 this$1;
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
                this$0 = ParseObject._cls34.this;
                object = parseobject;
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

    _cls1.val.object(List list, String s)
    {
        val$uniqueObjects = list;
        val$sessionToken = s;
        super();
    }
}

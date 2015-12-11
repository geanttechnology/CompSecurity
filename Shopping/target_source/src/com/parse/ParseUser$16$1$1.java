// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;

// Referenced classes of package com.parse:
//            ParseUser, ParseUserController, ParseOperationSet, Parse, 
//            ParseObject

class val.result
    implements i
{

    final then this$2;
    final then val$result;

    public val.result then(j j)
        throws Exception
    {
        return val$result;
    }

    public volatile Object then(j j)
        throws Exception
    {
        return then(j);
    }

    ()
    {
        this$2 = final_;
        val$result = val.result.this;
        super();
    }

    // Unreferenced inner class com/parse/ParseUser$16

/* anonymous class */
    class ParseUser._cls16
        implements i
    {

        final ParseUser this$0;
        final ParseOperationSet val$operations;

        public j then(j j1)
            throws Exception
        {
            return ParseUser.getUserController().logInAsync(getState(), operations).d(new ParseUser._cls16._cls1());
        }

        public volatile Object then(j j1)
            throws Exception
        {
            return then(j1);
        }

            
            {
                this$0 = final_parseuser;
                operations = ParseOperationSet.this;
                super();
            }
    }


    // Unreferenced inner class com/parse/ParseUser$16$1

/* anonymous class */
    class ParseUser._cls16._cls1
        implements i
    {

        final ParseUser._cls16 this$1;

        public j then(j j1)
            throws Exception
        {
            j1 = (ParseUser.State)j1.e();
            if (Parse.isLocalDatastoreEnabled() && !j1.isNew())
            {
                j1 = j.a(j1);
            } else
            {
                j1 = handleSaveResultAsync(j1, operations).c(j1. new ParseUser._cls16._cls1._cls1());
            }
            return j1.d(new ParseUser._cls16._cls1._cls2());
        }

        public volatile Object then(j j1)
            throws Exception
        {
            return then(j1);
        }

            
            {
                this$1 = ParseUser._cls16.this;
                super();
            }

        // Unreferenced inner class com/parse/ParseUser$16$1$2

/* anonymous class */
        class ParseUser._cls16._cls1._cls2
            implements i
        {

            final ParseUser._cls16._cls1 this$2;

            public j then(j j1)
                throws Exception
            {
                ParseUser.State state = (ParseUser.State)j1.e();
                if (!state.isNew())
                {
                    return ParseUser.access$200((ParseUser)ParseObject.from(state));
                } else
                {
                    return j1.j();
                }
            }

            public volatile Object then(j j1)
                throws Exception
            {
                return then(j1);
            }

                    
                    {
                        this$2 = ParseUser._cls16._cls1.this;
                        super();
                    }
        }

    }

}

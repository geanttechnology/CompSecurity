// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;

// Referenced classes of package com.parse:
//            ParseObject, ParseUser, ParseUserController, ParseOperationSet, 
//            Parse

class this._cls2
    implements i
{

    final then this$2;

    public j then(j j1)
        throws Exception
    {
          = ()j1.e();
        if (!.sNew())
        {
            return ParseUser.access$200((ParseUser)ParseObject.from());
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

    ()
    {
        this$2 = this._cls2.this;
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

        public j then(final j result)
            throws Exception
        {
            result = (ParseUser.State)result.e();
            if (Parse.isLocalDatastoreEnabled() && !result.isNew())
            {
                result = j.a(result);
            } else
            {
                result = handleSaveResultAsync(result, operations).c(new ParseUser._cls16._cls1._cls1());
            }
            return result.d(new ParseUser._cls16._cls1._cls2());
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

        // Unreferenced inner class com/parse/ParseUser$16$1$1

/* anonymous class */
        class ParseUser._cls16._cls1._cls1
            implements i
        {

            final ParseUser._cls16._cls1 this$2;
            final ParseUser.State val$result;

            public ParseUser.State then(j j1)
                throws Exception
            {
                return result;
            }

            public volatile Object then(j j1)
                throws Exception
            {
                return then(j1);
            }

                    
                    {
                        this$2 = ParseUser._cls16._cls1.this;
                        result = state;
                        super();
                    }
        }

    }

}

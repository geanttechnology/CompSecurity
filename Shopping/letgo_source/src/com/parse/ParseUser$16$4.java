// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.ct;
import android.support.v7.cu;
import java.io.File;
import java.util.Arrays;

// Referenced classes of package com.parse:
//            Parse, ParseFileUtils, ParseUser, ParseObject

class this._cls0
    implements ct
{

    final then this$0;

    public Boolean then(cu cu)
        throws Exception
    {
        return Boolean.valueOf(ParseFileUtils.deleteQuietly(new File(Parse.getParseDir(), "currentUser")));
    }

    public volatile Object then(cu cu)
        throws Exception
    {
        return then(cu);
    }

    l.userTask()
    {
        this$0 = this._cls0.this;
        super();
    }

    // Unreferenced inner class com/parse/ParseUser$16

/* anonymous class */
    static final class ParseUser._cls16
        implements ct
    {

        final cu val$userTask;

        public cu then(cu cu1)
            throws Exception
        {
            return cu.a(Arrays.asList(new cu[] {
                userTask.d(new ParseUser._cls16._cls1()), userTask.a(new ParseUser._cls16._cls4(), cu.a).b(new ParseUser._cls16._cls3()).c(new ParseUser._cls16._cls2())
            }));
        }

        public volatile Object then(cu cu1)
            throws Exception
        {
            return then(cu1);
        }

            
            {
                userTask = cu1;
                super();
            }

        // Unreferenced inner class com/parse/ParseUser$16$1

/* anonymous class */
        class ParseUser._cls16._cls1
            implements ct
        {

            final ParseUser._cls16 this$0;

            public cu then(cu cu1)
                throws Exception
            {
                ParseUser parseuser = (ParseUser)cu1.e();
                if (parseuser == null)
                {
                    return cu1.i();
                } else
                {
                    return ParseUser.access$1600(parseuser);
                }
            }

            public volatile Object then(cu cu1)
                throws Exception
            {
                return then(cu1);
            }

                    
                    {
                        this$0 = ParseUser._cls16.this;
                        super();
                    }
        }


        // Unreferenced inner class com/parse/ParseUser$16$2

/* anonymous class */
        class ParseUser._cls16._cls2
            implements ct
        {

            final ParseUser._cls16 this$0;

            public volatile Object then(cu cu1)
                throws Exception
            {
                return then(cu1);
            }

            public Void then(cu cu1)
                throws Exception
            {
                boolean flag = ((Boolean)cu1.e()).booleanValue();
                synchronized (ParseUser.access$900())
                {
                    ParseUser.access$1002(flag);
                    ParseUser.currentUser = null;
                }
                return null;
                exception;
                cu1;
                JVM INSTR monitorexit ;
                throw exception;
            }

                    
                    {
                        this$0 = ParseUser._cls16.this;
                        super();
                    }
        }


        // Unreferenced inner class com/parse/ParseUser$16$3

/* anonymous class */
        class ParseUser._cls16._cls3
            implements ct
        {

            final ParseUser._cls16 this$0;

            public cu then(cu cu1)
                throws Exception
            {
                if (Parse.isLocalDatastoreEnabled())
                {
                    cu1 = ParseObject.unpinAllInBackground("_currentUser").a(new ParseUser._cls16._cls3._cls1());
                }
                return cu1;
            }

            public volatile Object then(cu cu1)
                throws Exception
            {
                return then(cu1);
            }

                    
                    {
                        this$0 = ParseUser._cls16.this;
                        super();
                    }
        }


        // Unreferenced inner class com/parse/ParseUser$16$3$1

/* anonymous class */
        class ParseUser._cls16._cls3._cls1
            implements ct
        {

            final ParseUser._cls16._cls3 this$1;

            public Boolean then(cu cu1)
                throws Exception
            {
                boolean flag;
                if (!cu1.d())
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                return Boolean.valueOf(flag);
            }

            public volatile Object then(cu cu1)
                throws Exception
            {
                return then(cu1);
            }

                    
                    {
                        this$1 = ParseUser._cls16._cls3.this;
                        super();
                    }
        }

    }

}

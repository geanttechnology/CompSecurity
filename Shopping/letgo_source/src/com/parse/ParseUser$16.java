// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.ct;
import android.support.v7.cu;
import java.io.File;
import java.util.Arrays;

// Referenced classes of package com.parse:
//            ParseUser, Parse, ParseObject, ParseFileUtils

static final class 
    implements ct
{

    final cu val$userTask;

    public cu then(cu cu1)
        throws Exception
    {
        return cu.a(Arrays.asList(new cu[] {
            val$userTask.d(new ct() {

                final ParseUser._cls16 this$0;

                public cu then(cu cu2)
                    throws Exception
                {
                    ParseUser parseuser = (ParseUser)cu2.e();
                    if (parseuser == null)
                    {
                        return cu2.i();
                    } else
                    {
                        return ParseUser.access$1600(parseuser);
                    }
                }

                public volatile Object then(cu cu2)
                    throws Exception
                {
                    return then(cu2);
                }

            
            {
                this$0 = ParseUser._cls16.this;
                super();
            }
            }), val$userTask.a(new ct() {

                final ParseUser._cls16 this$0;

                public Boolean then(cu cu2)
                    throws Exception
                {
                    return Boolean.valueOf(ParseFileUtils.deleteQuietly(new File(Parse.getParseDir(), "currentUser")));
                }

                public volatile Object then(cu cu2)
                    throws Exception
                {
                    return then(cu2);
                }

            
            {
                this$0 = ParseUser._cls16.this;
                super();
            }
            }, cu.a).b(new ct() {

                final ParseUser._cls16 this$0;

                public cu then(cu cu2)
                    throws Exception
                {
                    if (Parse.isLocalDatastoreEnabled())
                    {
                        cu2 = ParseObject.unpinAllInBackground("_currentUser").a(new ct() {

                            final _cls3 this$1;

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
                this$1 = _cls3.this;
                super();
            }
                        });
                    }
                    return cu2;
                }

                public volatile Object then(cu cu2)
                    throws Exception
                {
                    return then(cu2);
                }

            
            {
                this$0 = ParseUser._cls16.this;
                super();
            }
            }).c(new ct() {

                final ParseUser._cls16 this$0;

                public volatile Object then(cu cu2)
                    throws Exception
                {
                    return then(cu2);
                }

                public Void then(cu cu2)
                    throws Exception
                {
                    boolean flag = ((Boolean)cu2.e()).booleanValue();
                    synchronized (ParseUser.access$900())
                    {
                        ParseUser.access$1002(flag);
                        ParseUser.currentUser = null;
                    }
                    return null;
                    exception;
                    cu2;
                    JVM INSTR monitorexit ;
                    throw exception;
                }

            
            {
                this$0 = ParseUser._cls16.this;
                super();
            }
            })
        }));
    }

    public volatile Object then(cu cu1)
        throws Exception
    {
        return then(cu1);
    }

    (cu cu1)
    {
        val$userTask = cu1;
        super();
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;

// Referenced classes of package com.parse:
//            ParseUser, ParseObject

static final class >
    implements i
{

    public j then(final j newCurrent)
        throws Exception
    {
        newCurrent = (ParseUser)ParseObject.from((ate)newCurrent.e());
        return ParseUser.access$200(newCurrent).c(new i() {

            final ParseUser._cls9 this$0;
            final ParseUser val$newCurrent;

            public ParseUser then(j j1)
                throws Exception
            {
                return newCurrent;
            }

            public volatile Object then(j j1)
                throws Exception
            {
                return then(j1);
            }

            
            {
                this$0 = ParseUser._cls9.this;
                newCurrent = parseuser;
                super();
            }
        });
    }

    public volatile Object then(j j1)
        throws Exception
    {
        return then(j1);
    }

    >()
    {
    }
}

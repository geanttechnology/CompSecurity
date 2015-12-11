// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;

// Referenced classes of package com.parse:
//            ParseObject, ParseSession, ParseSessionController

class this._cls0
    implements i
{

    final then this$0;

    public ParseSession then(j j1)
        throws Exception
    {
        return (ParseSession)ParseObject.from(()j1.e());
    }

    public volatile Object then(j j1)
        throws Exception
    {
        return then(j1);
    }

    oller()
    {
        this$0 = this._cls0.this;
        super();
    }

    // Unreferenced inner class com/parse/ParseSession$1

/* anonymous class */
    static final class ParseSession._cls1
        implements i
    {

        public j then(j j1)
            throws Exception
        {
            j1 = (String)j1.e();
            if (j1 == null)
            {
                return j.a(null);
            } else
            {
                return ParseSession.access$000().getSessionAsync(j1).c(new ParseSession._cls1._cls1());
            }
        }

        public volatile Object then(j j1)
            throws Exception
        {
            return then(j1);
        }

    }

}

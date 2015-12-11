// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.ct;
import android.support.v7.cu;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.parse:
//            EventuallyPin, ParsePinningEventuallyQueue

class this._cls2
    implements ct
{

    final then this$2;

    public cu then(cu cu1)
        throws Exception
    {
        Object obj = (List)cu1.e();
        cu1 = new ArrayList();
        for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); cu1.add(((EventuallyPin)((Iterator) (obj)).next()).unpinInBackground("_eventuallyPin"))) { }
        return cu.a(cu1);
    }

    public volatile Object then(cu cu1)
        throws Exception
    {
        return then(cu1);
    }

    ._cls0()
    {
        this$2 = this._cls2.this;
        super();
    }

    // Unreferenced inner class com/parse/ParsePinningEventuallyQueue$14

/* anonymous class */
    class ParsePinningEventuallyQueue._cls14
        implements ct
    {

        final ParsePinningEventuallyQueue this$0;

        public cu then(cu cu1)
            throws Exception
        {
            return cu1.b(new ParsePinningEventuallyQueue._cls14._cls1());
        }

        public volatile Object then(cu cu1)
            throws Exception
        {
            return then(cu1);
        }

            
            {
                this$0 = ParsePinningEventuallyQueue.this;
                super();
            }
    }


    // Unreferenced inner class com/parse/ParsePinningEventuallyQueue$14$1

/* anonymous class */
    class ParsePinningEventuallyQueue._cls14._cls1
        implements ct
    {

        final ParsePinningEventuallyQueue._cls14 this$1;

        public cu then(cu cu1)
            throws Exception
        {
            return EventuallyPin.findAllPinned().d(new ParsePinningEventuallyQueue._cls14._cls1._cls1());
        }

        public volatile Object then(cu cu1)
            throws Exception
        {
            return then(cu1);
        }

            
            {
                this$1 = ParsePinningEventuallyQueue._cls14.this;
                super();
            }
    }

}

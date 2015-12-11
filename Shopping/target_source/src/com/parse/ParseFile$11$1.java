// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

// Referenced classes of package com.parse:
//            ParseFile, ProgressCallback

class this._cls1
    implements i
{

    final then this$1;

    public InputStream then(j j1)
        throws Exception
    {
        return new FileInputStream((File)j1.e());
    }

    public volatile Object then(j j1)
        throws Exception
    {
        return then(j1);
    }

    l.cts()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/parse/ParseFile$11

/* anonymous class */
    class ParseFile._cls11
        implements i
    {

        final ParseFile this$0;
        final a.j.a val$cts;
        final ProgressCallback val$progressCallback;

        public j then(j j1)
            throws Exception
        {
            return ParseFile.access$800(ParseFile.this, progressCallback, j1, cts.a()).c(new ParseFile._cls11._cls1());
        }

        public volatile Object then(j j1)
            throws Exception
        {
            return then(j1);
        }

            
            {
                this$0 = final_parsefile;
                progressCallback = progresscallback;
                cts = a.j.a.this;
                super();
            }
    }

}

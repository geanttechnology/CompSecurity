// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;
import java.io.File;
import java.io.IOException;

// Referenced classes of package com.parse:
//            ParseFileUtils, ParseFile, ProgressCallback

class this._cls1
    implements i
{

    final  this$1;

    public volatile Object then(j j1)
        throws Exception
    {
        return then(j1);
    }

    public byte[] then(j j1)
        throws Exception
    {
        j1 = (File)j1.e();
        try
        {
            data = ParseFileUtils.readFileToByteArray(j1);
            j1 = data;
        }
        // Misplaced declaration of an exception variable
        catch (j j1)
        {
            return null;
        }
        return j1;
    }

    l.cts()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/parse/ParseFile$7

/* anonymous class */
    class ParseFile._cls7
        implements i
    {

        final ParseFile this$0;
        final a.j.a val$cts;
        final ProgressCallback val$progressCallback;

        public j then(j j1)
            throws Exception
        {
            if (data != null)
            {
                return j.a(data);
            } else
            {
                return ParseFile.access$800(ParseFile.this, progressCallback, j1, cts.a()).c(new ParseFile._cls7._cls1());
            }
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

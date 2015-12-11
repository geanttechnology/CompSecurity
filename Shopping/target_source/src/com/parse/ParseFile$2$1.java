// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;

// Referenced classes of package com.parse:
//            ParseFile, ParseFileController, ProgressCallback

class this._cls1
    implements i
{

    final then this$1;

    public j then(j j1)
        throws Exception
    {
        ParseFile.access$402(_fld0, (e)j1.e());
        file = null;
        return j1.j();
    }

    public volatile Object then(j j1)
        throws Exception
    {
        return then(j1);
    }

    ck()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/parse/ParseFile$2

/* anonymous class */
    class ParseFile._cls2
        implements i
    {

        final ParseFile this$0;
        final j val$cancellationToken;
        final String val$sessionToken;
        final ProgressCallback val$uploadProgressCallback;

        public j then(j j1)
            throws Exception
        {
            if (!isDirty())
            {
                return j.a(null);
            }
            if (cancellationToken != null && cancellationToken.c())
            {
                return j.h();
            }
            if (data != null)
            {
                j1 = ParseFile.getFileController().saveAsync(ParseFile.access$400(ParseFile.this), data, sessionToken, ParseFile.access$500(uploadProgressCallback), cancellationToken);
            } else
            {
                j1 = ParseFile.getFileController().saveAsync(ParseFile.access$400(ParseFile.this), file, sessionToken, ParseFile.access$500(uploadProgressCallback), cancellationToken);
            }
            return j1.d(new ParseFile._cls2._cls1());
        }

        public volatile Object then(j j1)
            throws Exception
        {
            return then(j1);
        }

            
            {
                this$0 = final_parsefile;
                cancellationToken = j1;
                sessionToken = s;
                uploadProgressCallback = ProgressCallback.this;
                super();
            }
    }

}

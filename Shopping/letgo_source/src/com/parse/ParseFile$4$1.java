// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.ct;
import android.support.v7.cu;

// Referenced classes of package com.parse:
//            ParseFile, ParseFileController, ProgressCallback

class this._cls1
    implements ct
{

    final then this$1;

    public cu then(cu cu1)
        throws Exception
    {
        ParseFile.access$402(_fld0, (e)cu1.e());
        return cu1.j();
    }

    public volatile Object then(cu cu1)
        throws Exception
    {
        return then(cu1);
    }

    ck()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/parse/ParseFile$4

/* anonymous class */
    class ParseFile._cls4
        implements ct
    {

        final ParseFile this$0;
        final cu val$cancellationToken;
        final String val$sessionToken;
        final ProgressCallback val$uploadProgressCallback;

        public cu then(cu cu1)
            throws Exception
        {
            if (!isDirty())
            {
                return cu.a(null);
            }
            if (cancellationToken != null && cancellationToken.c())
            {
                return cu.h();
            } else
            {
                return ParseFile.getFileController().saveAsync(ParseFile.access$400(ParseFile.this), data, sessionToken, ParseFile.access$500(uploadProgressCallback), cancellationToken).d(new ParseFile._cls4._cls1());
            }
        }

        public volatile Object then(cu cu1)
            throws Exception
        {
            return then(cu1);
        }

            
            {
                this$0 = final_parsefile;
                cancellationToken = cu1;
                sessionToken = s;
                uploadProgressCallback = ProgressCallback.this;
                super();
            }
    }

}

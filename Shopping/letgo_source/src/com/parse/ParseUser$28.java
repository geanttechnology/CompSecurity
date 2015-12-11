// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.ct;
import android.support.v7.cu;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            ParseUser, ParseObject, ParseSession

class 
    implements ct
{

    final ParseUser this$0;

    public cu then(cu cu1)
        throws Exception
    {
        cu1 = (ParseSession)ParseObject.fromJSON((JSONObject)cu1.e(), "_Session", true);
        return ParseUser.access$2700(ParseUser.this, cu1.getSessionToken());
    }

    public volatile Object then(cu cu1)
        throws Exception
    {
        return then(cu1);
    }

    ()
    {
        this$0 = ParseUser.this;
        super();
    }
}

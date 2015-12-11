// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.ct;
import android.support.v7.cu;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            ParseUser, ParseException, ParseObject

static final class on
    implements ct
{

    public cu then(cu cu1)
        throws Exception
    {
        cu1 = (JSONObject)cu1.e();
        if (cu1 == JSONObject.NULL)
        {
            return cu.a(new ParseException(101, "invalid login credentials"));
        } else
        {
            return ParseUser.access$200((ParseUser)ParseObject.fromJSON(cu1, "_User", true));
        }
    }

    public volatile Object then(cu cu1)
        throws Exception
    {
        return then(cu1);
    }

    on()
    {
    }
}

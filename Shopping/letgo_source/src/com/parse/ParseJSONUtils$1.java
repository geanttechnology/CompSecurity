// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import java.util.Iterator;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            ParseJSONUtils

static final class val.finalObject
    implements Iterable
{

    final JSONObject val$finalObject;

    public Iterator iterator()
    {
        return val$finalObject.keys();
    }

    (JSONObject jsonobject)
    {
        val$finalObject = jsonobject;
        super();
    }
}

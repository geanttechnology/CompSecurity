// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import java.util.HashSet;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            ParseFieldOperations, ParseRelationOperation, ParseDecoder, ParseFieldOperation

static final class rseFieldOperationFactory
    implements rseFieldOperationFactory
{

    public ParseFieldOperation decode(JSONObject jsonobject, ParseDecoder parsedecoder)
        throws JSONException
    {
        return new ParseRelationOperation(new HashSet((List)parsedecoder.decode(jsonobject.optJSONArray("objects"))), null);
    }

    rseFieldOperationFactory()
    {
    }
}

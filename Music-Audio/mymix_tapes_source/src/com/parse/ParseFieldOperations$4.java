// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            ParseFieldOperations, ParseAddOperation, ParseDecoder, ParseFieldOperation

static final class rseFieldOperationFactory
    implements rseFieldOperationFactory
{

    public ParseFieldOperation decode(JSONObject jsonobject, ParseDecoder parsedecoder)
        throws JSONException
    {
        return new ParseAddOperation(jsonobject.opt("objects"));
    }

    rseFieldOperationFactory()
    {
    }
}

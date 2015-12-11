// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import java.util.Collection;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            ParseFieldOperations, ParseAddUniqueOperation, ParseDecoder, ParseFieldOperation

static final class 
    implements rseFieldOperationFactory
{

    public ParseFieldOperation decode(JSONObject jsonobject, ParseDecoder parsedecoder)
        throws JSONException
    {
        return new ParseAddUniqueOperation((Collection)parsedecoder.decode(jsonobject.opt("objects")));
    }

    ()
    {
    }
}

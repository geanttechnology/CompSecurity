// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.cu;
import java.util.List;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            ParseDecoder, ParseOperationSet

interface ParseObjectController
{

    public abstract List deleteAllAsync(List list, String s);

    public abstract cu deleteAsync(ParseObject.State state, String s);

    public abstract cu fetchAsync(ParseObject.State state, String s, ParseDecoder parsedecoder);

    public abstract List saveAllAsync(List list, List list1, String s, List list2);

    public abstract cu saveAsync(ParseObject.State state, ParseOperationSet parseoperationset, String s, ParseDecoder parsedecoder);

    public abstract ParseObject.State stateFromJSON(ParseObject.State state, JSONObject jsonobject, ParseDecoder parsedecoder, boolean flag);
}

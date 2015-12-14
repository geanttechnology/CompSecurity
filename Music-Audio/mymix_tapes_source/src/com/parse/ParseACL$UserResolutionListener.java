// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import java.lang.ref.WeakReference;

// Referenced classes of package com.parse:
//            GetCallback, ParseACL, ParseUser, ParseObject, 
//            ParseException

private static class parent extends GetCallback
{

    private final WeakReference parent;

    public void done(ParseObject parseobject, ParseException parseexception)
    {
        parseexception = (ParseACL)parent.get();
        if (parseexception == null)
        {
            break MISSING_BLOCK_LABEL_23;
        }
        ParseACL.access$000(parseexception, (ParseUser)parseobject);
        parseobject.unregisterSaveListener(this);
        return;
        parseexception;
        parseobject.unregisterSaveListener(this);
        throw parseexception;
    }

    public (ParseACL parseacl)
    {
        parent = new WeakReference(parseacl);
    }
}

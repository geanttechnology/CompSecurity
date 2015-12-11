// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

// Referenced classes of package com.parse:
//            ParseTraverser, ParseObject, ParseFile

static final class <init> extends ParseTraverser
{

    final Set val$alreadySeen;
    final Set val$alreadySeenNew;
    final Collection val$dirtyChildren;
    final Collection val$dirtyFiles;

    protected boolean visit(Object obj)
    {
        if (!(obj instanceof ParseFile)) goto _L2; else goto _L1
_L1:
        if (val$dirtyFiles != null) goto _L4; else goto _L3
_L3:
        return true;
_L4:
        if (((ParseFile) (obj = (ParseFile)obj)).getUrl() == null)
        {
            val$dirtyFiles.add(obj);
            return true;
        }
        continue; /* Loop/switch isn't completed */
_L2:
        if ((obj instanceof ParseObject) && val$dirtyChildren != null)
        {
            ParseObject parseobject = (ParseObject)obj;
            Object obj1 = val$alreadySeen;
            obj = val$alreadySeenNew;
            if (parseobject.getObjectId() != null)
            {
                obj = new HashSet();
            } else
            {
                if (((Set) (obj)).contains(parseobject))
                {
                    throw new RuntimeException("Found a circular dependency while saving.");
                }
                obj = new HashSet(((Collection) (obj)));
                ((Set) (obj)).add(parseobject);
            }
            if (!((Set) (obj1)).contains(parseobject))
            {
                obj1 = new HashSet(((Collection) (obj1)));
                ((Set) (obj1)).add(parseobject);
                ParseObject.access$1400(ParseObject.access$1300(parseobject), val$dirtyChildren, val$dirtyFiles, ((Set) (obj1)), ((Set) (obj)));
                if (parseobject.isDirty(false))
                {
                    val$dirtyChildren.add(parseobject);
                    return true;
                }
            }
        }
        if (true) goto _L3; else goto _L5
_L5:
    }

    n(Collection collection, Collection collection1, Set set, Set set1)
    {
        val$dirtyFiles = collection;
        val$dirtyChildren = collection1;
        val$alreadySeen = set;
        val$alreadySeenNew = set1;
        super();
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import java.util.IdentityHashMap;
import java.util.List;

// Referenced classes of package com.parse:
//            ParseTraverser, ParseObject, ParseFile

static final class <init> extends ParseTraverser
{

    final IdentityHashMap val$alreadySeen;
    final IdentityHashMap val$alreadySeenNew;
    final List val$dirtyChildren;
    final List val$dirtyFiles;

    protected boolean visit(Object obj)
    {
        if (obj instanceof ParseFile)
        {
            obj = (ParseFile)obj;
            if (((ParseFile) (obj)).getUrl() == null)
            {
                val$dirtyFiles.add(obj);
            }
        } else
        if (obj instanceof ParseObject)
        {
            ParseObject parseobject = (ParseObject)obj;
            IdentityHashMap identityhashmap = val$alreadySeen;
            obj = val$alreadySeenNew;
            if (parseobject.getObjectId() != null)
            {
                obj = new IdentityHashMap();
            } else
            {
                if (((IdentityHashMap) (obj)).containsKey(parseobject))
                {
                    throw new RuntimeException("Found a circular dependency while saving.");
                }
                obj = new IdentityHashMap(((java.util.Map) (obj)));
                ((IdentityHashMap) (obj)).put(parseobject, parseobject);
            }
            if (!identityhashmap.containsKey(parseobject))
            {
                identityhashmap = new IdentityHashMap(identityhashmap);
                identityhashmap.put(parseobject, parseobject);
                ParseObject.access$1300(ParseObject.access$300(parseobject), val$dirtyChildren, val$dirtyFiles, identityhashmap, ((IdentityHashMap) (obj)));
                if (parseobject.isDirty(false))
                {
                    val$dirtyChildren.add(parseobject);
                    return true;
                }
            }
        }
        return true;
    }

    (List list, IdentityHashMap identityhashmap, IdentityHashMap identityhashmap1, List list1)
    {
        val$dirtyFiles = list;
        val$alreadySeen = identityhashmap;
        val$alreadySeenNew = identityhashmap1;
        val$dirtyChildren = list1;
        super();
    }
}

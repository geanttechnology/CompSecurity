// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.cds;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.amazon.gallery.thor.cds:
//            MetadataProcessor

private static class mNumParentsCursorRowsSeen
{

    final List childrenToDelete = new LinkedList();
    final Map childrenToSave = new HashMap();
    int mNodesCursorWindowRows;
    int mNumNodesCursorRowsSeen;
    int mNumParentsCursorRowsSeen;
    int mParentsCursorWindowRows;
    final List parentsToDelete = new LinkedList();
    final Map parentsToSave = new HashMap();
    final Map unresolvedParents = new HashMap();

    void addChildToRemove(String s)
    {
        childrenToDelete.add(s);
    }

    void addChildToSave(String s, Object obj)
    {
        childrenToSave.put(s, obj);
    }

    void addParentToDelete(String s)
    {
        parentsToDelete.add(s);
    }

    void addParentToSave(String s, Object obj)
    {
        parentsToSave.put(s, obj);
    }

    void addUnresolvedParent(String s, Object obj)
    {
        unresolvedParents.put(s, obj);
    }

    Collection getChildrenToSave()
    {
        return childrenToSave.values();
    }

    int getNumRowsInNodesCursorWindow()
    {
        return mNodesCursorWindowRows;
    }

    int getNumRowsInParentsCursorWindow()
    {
        return mParentsCursorWindowRows;
    }

    int getNumRowsSeenInNodesCursor()
    {
        return mNumNodesCursorRowsSeen;
    }

    int getNumRowsSeenInParentsCursor()
    {
        return mNumParentsCursorRowsSeen;
    }

    Object getParent(String s)
    {
        if (parentsToSave.containsKey(s))
        {
            return parentsToSave.get(s);
        }
        if (unresolvedParents.containsKey(s))
        {
            return unresolvedParents.get(s);
        } else
        {
            return null;
        }
    }

    Collection getParentsToSave()
    {
        return parentsToSave.values();
    }

    int getSize()
    {
        return parentsToSave.size() + unresolvedParents.size() + parentsToDelete.size() + childrenToSave.size() + childrenToDelete.size();
    }

    Collection getUnresolvedParents()
    {
        return unresolvedParents.values();
    }

    void incrementNumRowsSeenInNodesCursor()
    {
        mNumNodesCursorRowsSeen = mNumNodesCursorRowsSeen + 1;
    }

    void incrementNumRowsSeenInParentsCursor()
    {
        mNumParentsCursorRowsSeen = mNumParentsCursorRowsSeen + 1;
    }

    boolean isEmpty()
    {
        return parentsToSave.isEmpty() && unresolvedParents.isEmpty() && parentsToDelete.isEmpty() && childrenToSave.isEmpty() && childrenToDelete.isEmpty();
    }

    boolean isNodesCursorWindowFinished()
    {
        return mNumNodesCursorRowsSeen == mNodesCursorWindowRows;
    }

    boolean isParentKnown(String s)
    {
        return parentsToSave.containsKey(s) || unresolvedParents.containsKey(s);
    }

    boolean isParentToBeSaved(String s)
    {
        return parentsToSave.containsKey(s);
    }

    boolean isParentUnresolved(String s)
    {
        return unresolvedParents.containsKey(s);
    }

    boolean isParentsCursorWindowFinished()
    {
        return mNumParentsCursorRowsSeen == mParentsCursorWindowRows;
    }

    Object removeUnresolvedParent(String s)
    {
        return unresolvedParents.remove(s);
    }

    void resolveParent(String s, Object obj)
    {
        unresolvedParents.remove(s);
        parentsToSave.put(s, obj);
    }

    (int i, int j, int k, int l)
    {
        mNodesCursorWindowRows = i;
        mParentsCursorWindowRows = j;
        mNumNodesCursorRowsSeen = k;
        mNumParentsCursorRowsSeen = l;
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ChangeList
{
    public static final class ChangeType extends Enum
    {

        private static final ChangeType $VALUES[];
        public static final ChangeType ADDED;
        public static final ChangeType MODIFIED;
        public static final ChangeType REMOVED;

        public static ChangeType valueOf(String s)
        {
            return (ChangeType)Enum.valueOf(com/amazon/gallery/framework/data/dao/ChangeList$ChangeType, s);
        }

        public static ChangeType[] values()
        {
            return (ChangeType[])$VALUES.clone();
        }

        static 
        {
            ADDED = new ChangeType("ADDED", 0);
            MODIFIED = new ChangeType("MODIFIED", 1);
            REMOVED = new ChangeType("REMOVED", 2);
            $VALUES = (new ChangeType[] {
                ADDED, MODIFIED, REMOVED
            });
        }

        private ChangeType(String s, int i)
        {
            super(s, i);
        }
    }


    private boolean isEmpty;
    private final Map modifiedItems = new HashMap();

    public ChangeList()
    {
        isEmpty = true;
    }

    private Set getSetForChangeType(ChangeType changetype)
    {
        Set set = (Set)modifiedItems.get(changetype);
        Object obj = set;
        if (set == null)
        {
            obj = new HashSet();
            modifiedItems.put(changetype, obj);
        }
        return ((Set) (obj));
    }

    public void add(Object obj, ChangeType changetype)
    {
        isEmpty = false;
        getSetForChangeType(changetype).add(obj);
    }

    public void addAll(Collection collection, ChangeType changetype)
    {
        isEmpty = false;
        getSetForChangeType(changetype).addAll(collection);
    }

    public void clear()
    {
        modifiedItems.clear();
        isEmpty = true;
    }

    public Set getAllChangeLists()
    {
        HashSet hashset = new HashSet();
        ChangeType achangetype[] = ChangeType.values();
        int j = achangetype.length;
        for (int i = 0; i < j; i++)
        {
            hashset.addAll(getChangeListForType(achangetype[i]));
        }

        return hashset;
    }

    public Set getChangeListForType(ChangeType changetype)
    {
        Set set = (Set)modifiedItems.get(changetype);
        changetype = set;
        if (set == null)
        {
            changetype = Collections.emptySet();
        }
        return changetype;
    }

    public boolean isEmpty()
    {
        return isEmpty;
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        ChangeType achangetype[] = ChangeType.values();
        int j = achangetype.length;
        for (int i = 0; i < j; i++)
        {
            ChangeType changetype = achangetype[i];
            stringbuilder.append(changetype.name()).append(" : ").append(getChangeListForType(changetype).size()).append(" : ").append(getChangeListForType(changetype)).append("\n");
        }

        return stringbuilder.toString();
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mixtape.metadata.processing;

import android.database.Cursor;
import java.util.Collection;

// Referenced classes of package com.amazon.mixtape.metadata.processing:
//            AccountChangedException

public interface NodeProcessor
{

    public abstract void addRelationship(Object obj, Object obj1);

    public abstract Object createChild(Cursor cursor);

    public abstract Object createPlaceholderParent(String s);

    public abstract void delete(String s, Collection collection, Collection collection1)
        throws AccountChangedException;

    public abstract Object getExistingParent(String s, String s1)
        throws AccountChangedException;

    public abstract String[] getNeededColumns();

    public abstract boolean isChild(Cursor cursor);

    public abstract boolean isParent(Cursor cursor);

    public abstract void notifyProcessingComplete(String s);

    public abstract void save(String s, Collection collection, Collection collection1, Collection collection2)
        throws AccountChangedException;

    public abstract boolean shouldRemoveChild(Cursor cursor);

    public abstract boolean shouldRemoveParent(Cursor cursor);

    public abstract void updateExistingParent(Object obj, Cursor cursor);

    public abstract void updateExistingParent(Object obj, Object obj1);
}

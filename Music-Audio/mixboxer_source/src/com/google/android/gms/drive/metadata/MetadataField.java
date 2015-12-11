// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.metadata;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.internal.eg;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public abstract class MetadataField
{

    private final String rC;
    private final Set rD;

    protected MetadataField(String s)
    {
        rC = (String)eg.b(s, "fieldName");
        rD = Collections.singleton(s);
    }

    protected MetadataField(String s, Collection collection)
    {
        rC = (String)eg.b(s, "fieldName");
        rD = Collections.unmodifiableSet(new HashSet(collection));
    }

    protected abstract void a(Bundle bundle, Object obj);

    public final void a(DataHolder dataholder, MetadataBundle metadatabundle, int i, int j)
    {
        eg.b(dataholder, "dataHolder");
        eg.b(metadatabundle, "bundle");
        metadatabundle.b(this, c(dataholder, i, j));
    }

    public final void a(Object obj, Bundle bundle)
    {
        eg.b(bundle, "bundle");
        if (obj == null)
        {
            bundle.putString(getName(), null);
            return;
        } else
        {
            a(bundle, obj);
            return;
        }
    }

    protected abstract Object b(DataHolder dataholder, int i, int j);

    public final Object c(DataHolder dataholder, int i, int j)
    {
        for (Iterator iterator = rD.iterator(); iterator.hasNext();)
        {
            if (dataholder.hasNull((String)iterator.next(), i, j))
            {
                return null;
            }
        }

        return b(dataholder, i, j);
    }

    public final Collection cV()
    {
        return rD;
    }

    public final Object d(Bundle bundle)
    {
        eg.b(bundle, "bundle");
        if (bundle.get(getName()) != null)
        {
            return e(bundle);
        } else
        {
            return null;
        }
    }

    protected abstract Object e(Bundle bundle);

    public final String getName()
    {
        return rC;
    }

    public String toString()
    {
        return rC;
    }
}

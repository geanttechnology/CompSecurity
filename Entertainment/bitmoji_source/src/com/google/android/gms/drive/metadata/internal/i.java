// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.CollectionMetadataField;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import org.json.JSONArray;
import org.json.JSONException;

public class i extends CollectionMetadataField
{

    public i(String s, int k)
    {
        super(s, k);
    }

    public static final Collection as(String s)
        throws JSONException
    {
        if (s == null)
        {
            return null;
        }
        ArrayList arraylist = new ArrayList();
        s = new JSONArray(s);
        for (int k = 0; k < s.length(); k++)
        {
            arraylist.add(s.getString(k));
        }

        return Collections.unmodifiableCollection(arraylist);
    }

    protected Collection a(DataHolder dataholder, int k, int l)
    {
        try
        {
            dataholder = as(dataholder.getString(getName(), k, l));
        }
        // Misplaced declaration of an exception variable
        catch (DataHolder dataholder)
        {
            throw new IllegalStateException("DataHolder supplied invalid JSON", dataholder);
        }
        return dataholder;
    }

    protected volatile void a(Bundle bundle, Object obj)
    {
        a(bundle, (Collection)obj);
    }

    protected void a(Bundle bundle, Collection collection)
    {
        bundle.putStringArrayList(getName(), new ArrayList(collection));
    }

    protected Object b(DataHolder dataholder, int k, int l)
    {
        return a(dataholder, k, l);
    }

    protected Object e(Bundle bundle)
    {
        return j(bundle);
    }

    protected Collection j(Bundle bundle)
    {
        return bundle.getStringArrayList(getName());
    }
}

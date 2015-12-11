// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import com.google.android.gms.drive.metadata.CollectionMetadataField;
import java.util.ArrayList;
import java.util.Collection;

public class e extends CollectionMetadataField
{

    public e(String s)
    {
        super(s);
    }

    protected volatile void a(Bundle bundle, Object obj)
    {
        a(bundle, (Collection)obj);
    }

    protected void a(Bundle bundle, Collection collection)
    {
        bundle.putParcelableArrayList(getName(), new ArrayList(collection));
    }

    protected Object e(Bundle bundle)
    {
        return i(bundle);
    }

    protected Collection i(Bundle bundle)
    {
        return bundle.getParcelableArrayList(getName());
    }
}

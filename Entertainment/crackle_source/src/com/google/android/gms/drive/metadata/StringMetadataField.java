// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.metadata;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;

// Referenced classes of package com.google.android.gms.drive.metadata:
//            MetadataField

public final class StringMetadataField extends MetadataField
{

    public StringMetadataField(String s)
    {
        super(s);
    }

    protected volatile void a(Bundle bundle, Object obj)
    {
        a(bundle, (String)obj);
    }

    protected void a(Bundle bundle, String s)
    {
        bundle.putString(getName(), s);
    }

    protected Object b(DataHolder dataholder, int i, int j)
    {
        return d(dataholder, i, j);
    }

    protected String d(DataHolder dataholder, int i, int j)
    {
        return dataholder.getString(getName(), i, j);
    }

    protected Object e(Bundle bundle)
    {
        return f(bundle);
    }

    protected String f(Bundle bundle)
    {
        return bundle.getString(getName());
    }
}

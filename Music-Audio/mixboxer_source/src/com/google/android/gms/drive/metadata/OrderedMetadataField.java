// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.metadata;

import java.util.Collection;

// Referenced classes of package com.google.android.gms.drive.metadata:
//            MetadataField

public abstract class OrderedMetadataField extends MetadataField
{

    protected OrderedMetadataField(String s)
    {
        super(s);
    }

    protected OrderedMetadataField(String s, Collection collection)
    {
        super(s, collection);
    }
}

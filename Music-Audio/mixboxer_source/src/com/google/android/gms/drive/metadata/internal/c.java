// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.metadata.internal;

import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.internal.fh;
import com.google.android.gms.internal.fi;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class c
{

    private static Map rE = new HashMap();

    public static MetadataField ac(String s)
    {
        return (MetadataField)rE.get(s);
    }

    private static void b(MetadataField metadatafield)
    {
        if (rE.containsKey(metadatafield.getName()))
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Duplicate field name registered: ").append(metadatafield.getName()).toString());
        } else
        {
            rE.put(metadatafield.getName(), metadatafield);
            return;
        }
    }

    public static Collection cW()
    {
        return Collections.unmodifiableCollection(rE.values());
    }

    static 
    {
        b(fh.rG);
        b(fh.TITLE);
        b(fh.MIME_TYPE);
        b(fh.STARRED);
        b(fh.TRASHED);
        b(fh.rH);
        b(fh.rI);
        b(fh.PARENTS);
        b(fi.rL);
        b(fi.rJ);
        b(fi.rK);
        b(fi.rM);
    }
}

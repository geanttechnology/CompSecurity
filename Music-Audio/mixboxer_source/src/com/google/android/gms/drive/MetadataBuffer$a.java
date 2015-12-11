// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.drive.metadata.internal.c;
import java.util.Collection;
import java.util.Iterator;

// Referenced classes of package com.google.android.gms.drive:
//            Metadata, MetadataBuffer, b

private static class C extends Metadata
{

    private final DataHolder nE;
    private final int nH;
    private final int qU;

    protected Object a(MetadataField metadatafield)
    {
        return metadatafield.c(nE, qU, nH);
    }

    public Metadata cK()
    {
        MetadataBundle metadatabundle = MetadataBundle.cX();
        for (Iterator iterator = c.cW().iterator(); iterator.hasNext(); ((MetadataField)iterator.next()).a(nE, metadatabundle, qU, nH)) { }
        return new b(metadatabundle);
    }

    public Object freeze()
    {
        return cK();
    }

    public boolean isDataValid()
    {
        return !nE.isClosed();
    }

    public Field(DataHolder dataholder, int i)
    {
        nE = dataholder;
        qU = i;
        nH = dataholder.C(i);
    }
}

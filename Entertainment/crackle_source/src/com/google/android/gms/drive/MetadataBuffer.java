// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive;

import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.drive.metadata.internal.c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.google.android.gms.drive:
//            Metadata, b

public final class MetadataBuffer extends DataBuffer
{
    private static class a extends Metadata
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

        public a(DataHolder dataholder, int i)
        {
            nE = dataholder;
            qU = i;
            nH = dataholder.C(i);
        }
    }


    private static final String qS[];
    private final String qT;

    public MetadataBuffer(DataHolder dataholder, String s)
    {
        super(dataholder);
        qT = s;
    }

    public Metadata get(int i)
    {
        return new a(nE, i);
    }

    public volatile Object get(int i)
    {
        return get(i);
    }

    public String getNextPageToken()
    {
        return qT;
    }

    static 
    {
        ArrayList arraylist = new ArrayList();
        for (Iterator iterator = c.cW().iterator(); iterator.hasNext(); arraylist.addAll(((MetadataField)iterator.next()).cV())) { }
        qS = (String[])arraylist.toArray(new String[0]);
    }
}

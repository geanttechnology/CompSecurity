// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.i18n.phonenumbers;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.google.i18n.phonenumbers:
//            Phonemetadata

public static class metadata_
    implements Externalizable
{

    private List metadata_;

    public int getMetadataCount()
    {
        return metadata_.size();
    }

    public List getMetadataList()
    {
        return metadata_;
    }

    public void readExternal(ObjectInput objectinput)
        throws IOException
    {
        int j = objectinput.readInt();
        for (int i = 0; i < j; i++)
        {
            metadata_ metadata_1 = new metadata_();
            metadata_1.al(objectinput);
            metadata_.add(metadata_1);
        }

    }

    public void writeExternal(ObjectOutput objectoutput)
        throws IOException
    {
        int j = getMetadataCount();
        objectoutput.writeInt(j);
        for (int i = 0; i < j; i++)
        {
            ((getMetadataCount)metadata_.get(i)).nal(objectoutput);
        }

    }

    public ()
    {
        metadata_ = new ArrayList();
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.protobuf;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.google.protobuf:
//            Descriptors, Message

public static final class ptorProto
    implements or, or
{

    private final toProto containingType;
    private final toProto file;
    private final String fullName;
    private final int index;
    private ptorProto proto;
    private ptor values[];

    private void setProto(ptorProto ptorproto)
    {
        proto = ptorproto;
        for (int i = 0; i < values.length; i++)
        {
            ptor.access._mth2000(values[i], ptorproto.getValue(i));
        }

    }

    public ptor findValueByName(String s)
    {
        s = access._mth1200(file).findSymbol((new StringBuilder()).append(fullName).append('.').append(s).toString());
        if (s != null && (s instanceof ptor))
        {
            return (ptor)s;
        } else
        {
            return null;
        }
    }

    public ptor findValueByNumber(int i)
    {
        return (ptor)access._mth1800(access._mth1200(file)).get(new DescriptorIntPair(this, i));
    }

    public or getFile()
    {
        return file;
    }

    public String getFullName()
    {
        return fullName;
    }

    public String getName()
    {
        return proto.getName();
    }

    public List getValues()
    {
        return Collections.unmodifiableList(Arrays.asList(values));
    }

    public ptorProto toProto()
    {
        return proto;
    }

    public volatile Message toProto()
    {
        return toProto();
    }


    private or(ptorProto ptorproto, ptorProto ptorproto1, ptorProto ptorproto2, int i)
        throws ationException
    {
        index = i;
        proto = ptorproto;
        fullName = Descriptors.access$1400(ptorproto1, ptorproto2, ptorproto.getName());
        file = ptorproto1;
        containingType = ptorproto2;
        if (ptorproto.getValueCount() == 0)
        {
            throw new ationException(this, "Enums must contain at least one value.", null);
        }
        values = new ptor[ptorproto.getValueCount()];
        for (i = 0; i < ptorproto.getValueCount(); i++)
        {
            values[i] = new ptor(ptorproto.getValue(i), ptorproto1, this, i, null);
        }

        access._mth1200(ptorproto1).addSymbol(this);
    }

    ptorProto(ptorProto ptorproto, ptorProto ptorproto1, ptorProto ptorproto2, int i, ptorProto ptorproto3)
        throws ationException
    {
        this(ptorproto, ptorproto1, ptorproto2, i);
    }
}

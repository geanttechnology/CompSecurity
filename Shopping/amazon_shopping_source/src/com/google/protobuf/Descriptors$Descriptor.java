// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.protobuf;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.google.protobuf:
//            Descriptors, Message

public static final class tor
    implements riptor
{

    private final toProto containingType;
    private final tor enumTypes[];
    private final ptor extensions[];
    private final ptor fields[];
    private final tor file;
    private final String fullName;
    private final int index;
    private final tor nestedTypes[];
    private ptorProto proto;

    private void crossLink()
        throws alidationException
    {
        boolean flag = false;
        Object aobj[] = nestedTypes;
        int l = aobj.length;
        for (int i = 0; i < l; i++)
        {
            aobj[i].crossLink();
        }

        aobj = fields;
        l = aobj.length;
        for (int j = 0; j < l; j++)
        {
            ptor.access._mth700(aobj[j]);
        }

        aobj = extensions;
        l = aobj.length;
        for (int k = ((flag) ? 1 : 0); k < l; k++)
        {
            ptor.access._mth700(aobj[k]);
        }

    }

    private void setProto(ptorProto ptorproto)
    {
        boolean flag = false;
        proto = ptorproto;
        for (int i = 0; i < nestedTypes.length; i++)
        {
            nestedTypes[i].setProto(ptorproto.getNestedType(i));
        }

        for (int j = 0; j < enumTypes.length; j++)
        {
            tor.access._mth900(enumTypes[j], ptorproto.getEnumType(j));
        }

        int k = 0;
        int l;
        do
        {
            l = ((flag) ? 1 : 0);
            if (k >= fields.length)
            {
                break;
            }
            ptor.access._mth1100(fields[k], ptorproto.getField(k));
            k++;
        } while (true);
        for (; l < extensions.length; l++)
        {
            ptor.access._mth1100(extensions[l], ptorproto.getExtension(l));
        }

    }

    public ptor findFieldByNumber(int i)
    {
        return (ptor)ool.access._mth1300(tor.access._mth1200(file)).get(new ool.DescriptorIntPair(this, i));
    }

    public List getEnumTypes()
    {
        return Collections.unmodifiableList(Arrays.asList(enumTypes));
    }

    public List getFields()
    {
        return Collections.unmodifiableList(Arrays.asList(fields));
    }

    public tor getFile()
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

    public List getNestedTypes()
    {
        return Collections.unmodifiableList(Arrays.asList(nestedTypes));
    }

    public eOptions getOptions()
    {
        return proto.getOptions();
    }

    public boolean isExtensionNumber(int i)
    {
        for (Iterator iterator = proto.getExtensionRangeList().iterator(); iterator.hasNext();)
        {
            ptorProto.ExtensionRange extensionrange = (ptorProto.ExtensionRange)iterator.next();
            if (extensionrange.getStart() <= i && i < extensionrange.getEnd())
            {
                return true;
            }
        }

        return false;
    }

    public ptorProto toProto()
    {
        return proto;
    }

    public volatile Message toProto()
    {
        return toProto();
    }



    private riptor(ptorProto ptorproto, tor tor, tor tor1, int i)
        throws alidationException
    {
        index = i;
        proto = ptorproto;
        fullName = Descriptors.access$1400(tor, tor1, ptorproto.getName());
        file = tor;
        containingType = tor1;
        nestedTypes = new nestedTypes[ptorproto.getNestedTypeCount()];
        for (i = 0; i < ptorproto.getNestedTypeCount(); i++)
        {
            nestedTypes[i] = new <init>(ptorproto.getNestedType(i), tor, this, i);
        }

        enumTypes = new tor[ptorproto.getEnumTypeCount()];
        for (i = 0; i < ptorproto.getEnumTypeCount(); i++)
        {
            enumTypes[i] = new tor(ptorproto.getEnumType(i), tor, this, i, null);
        }

        fields = new ptor[ptorproto.getFieldCount()];
        for (i = 0; i < ptorproto.getFieldCount(); i++)
        {
            fields[i] = new ptor(ptorproto.getField(i), tor, this, i, false, null);
        }

        extensions = new ptor[ptorproto.getExtensionCount()];
        for (i = 0; i < ptorproto.getExtensionCount(); i++)
        {
            extensions[i] = new ptor(ptorproto.getExtension(i), tor, this, i, true, null);
        }

        tor.access._mth1200(tor).addSymbol(this);
    }

    tor(ptorProto ptorproto, tor tor, tor tor1, int i, tor tor2)
        throws alidationException
    {
        this(ptorproto, tor, tor1, i);
    }
}

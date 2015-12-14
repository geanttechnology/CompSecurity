// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.protobuf;

import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

// Referenced classes of package com.google.protobuf:
//            UnknownFieldSet, WireFormat, InvalidProtocolBufferException, CodedInputStream, 
//            ExtensionRegistry, MessageLite, ExtensionRegistryLite

public static final class ilder
    implements ilder
{

    private Map fields;
    private ilder lastField;
    private int lastFieldNumber;

    private static ilder create()
    {
        ilder ilder = new <init>();
        ilder.reinitialize();
        return ilder;
    }

    private ilder getFieldBuilder(int i)
    {
        if (lastField != null)
        {
            if (i == lastFieldNumber)
            {
                return lastField;
            }
            addField(lastFieldNumber, lastField.build());
        }
        if (i == 0)
        {
            return null;
        }
        ilder ilder = (ilder.build)fields.get(Integer.valueOf(i));
        lastFieldNumber = i;
        lastField = wBuilder();
        if (ilder != null)
        {
            lastField.mergeFrom(ilder);
        }
        return lastField;
    }

    private void reinitialize()
    {
        fields = Collections.emptyMap();
        lastFieldNumber = 0;
        lastField = null;
    }

    public lastField addField(int i, lastField lastfield)
    {
        if (i == 0)
        {
            throw new IllegalArgumentException("Zero is not a valid field number.");
        }
        if (lastField != null && lastFieldNumber == i)
        {
            lastField = null;
            lastFieldNumber = 0;
        }
        if (fields.isEmpty())
        {
            fields = new TreeMap();
        }
        fields.put(Integer.valueOf(i), lastfield);
        return this;
    }

    public volatile MessageLite build()
    {
        return build();
    }

    public UnknownFieldSet build()
    {
        getFieldBuilder(0);
        UnknownFieldSet unknownfieldset;
        if (fields.isEmpty())
        {
            unknownfieldset = UnknownFieldSet.getDefaultInstance();
        } else
        {
            unknownfieldset = new UnknownFieldSet(Collections.unmodifiableMap(fields), null);
        }
        fields = null;
        return unknownfieldset;
    }

    public UnknownFieldSet buildPartial()
    {
        return build();
    }

    public build clone()
    {
        getFieldBuilder(0);
        return UnknownFieldSet.newBuilder().mergeFrom(new UnknownFieldSet(fields, null));
    }

    public volatile Object clone()
        throws CloneNotSupportedException
    {
        return clone();
    }

    public boolean hasField(int i)
    {
        if (i == 0)
        {
            throw new IllegalArgumentException("Zero is not a valid field number.");
        }
        return i == lastFieldNumber || fields.containsKey(Integer.valueOf(i));
    }

    public boolean isInitialized()
    {
        return true;
    }

    public fields mergeField(int i, fields fields1)
    {
        if (i == 0)
        {
            throw new IllegalArgumentException("Zero is not a valid field number.");
        }
        if (hasField(i))
        {
            getFieldBuilder(i).mergeFrom(fields1);
            return this;
        } else
        {
            addField(i, fields1);
            return this;
        }
    }

    public boolean mergeFieldFrom(int i, CodedInputStream codedinputstream)
        throws IOException
    {
        int j = WireFormat.getTagFieldNumber(i);
        switch (WireFormat.getTagWireType(i))
        {
        default:
            throw InvalidProtocolBufferException.invalidWireType();

        case 0: // '\0'
            getFieldBuilder(j).addVarint(codedinputstream.readInt64());
            return true;

        case 1: // '\001'
            getFieldBuilder(j).addFixed64(codedinputstream.readFixed64());
            return true;

        case 2: // '\002'
            getFieldBuilder(j).addLengthDelimited(codedinputstream.readBytes());
            return true;

        case 3: // '\003'
            addField addfield = UnknownFieldSet.newBuilder();
            codedinputstream.readGroup(j, addfield, ExtensionRegistry.getEmptyRegistry());
            getFieldBuilder(j).addGroup(addfield.build());
            return true;

        case 4: // '\004'
            return false;

        case 5: // '\005'
            getFieldBuilder(j).addFixed32(codedinputstream.readFixed32());
            break;
        }
        return true;
    }

    public volatile ed32 mergeFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
        throws IOException
    {
        return mergeFrom(codedinputstream, extensionregistrylite);
    }

    public mergeFrom mergeFrom(CodedInputStream codedinputstream)
        throws IOException
    {
        int i;
        do
        {
            i = codedinputstream.readTag();
        } while (i != 0 && mergeFieldFrom(i, codedinputstream));
        return this;
    }

    public mergeFieldFrom mergeFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
        throws IOException
    {
        return mergeFrom(codedinputstream);
    }

    public mergeFrom mergeFrom(UnknownFieldSet unknownfieldset)
    {
        if (unknownfieldset != UnknownFieldSet.getDefaultInstance())
        {
            java.util.t t;
            for (unknownfieldset = UnknownFieldSet.access$200(unknownfieldset).entrySet().iterator(); unknownfieldset.hasNext(); mergeField(((Integer)t.mergeField()).intValue(), (mergeField)t.Field()))
            {
                t = (java.util.t.Field)unknownfieldset.next();
            }

        }
        return this;
    }

    public mergeField mergeVarintField(int i, int j)
    {
        if (i == 0)
        {
            throw new IllegalArgumentException("Zero is not a valid field number.");
        } else
        {
            getFieldBuilder(i).addVarint(j);
            return this;
        }
    }


    private ilder()
    {
    }
}

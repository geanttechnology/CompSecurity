// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.protobuf;

import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

// Referenced classes of package com.google.protobuf:
//            GeneratedMessage, FieldSet, DynamicMessage, Message, 
//            CodedOutputStream

public static abstract class access._cls300 extends GeneratedMessage
    implements rBuilder
{
    protected class ExtensionWriter
    {

        private final Iterator iter;
        private final boolean messageSetWireFormat;
        private java.util.Map.Entry next;
        final GeneratedMessage.ExtendableMessage this$0;

        public void writeUntil(int i, CodedOutputStream codedoutputstream)
            throws IOException
        {
            while (next != null && ((Descriptors.FieldDescriptor)next.getKey()).getNumber() < i) 
            {
                Descriptors.FieldDescriptor fielddescriptor = (Descriptors.FieldDescriptor)next.getKey();
                if (messageSetWireFormat && fielddescriptor.getLiteJavaType() == WireFormat.JavaType.MESSAGE && !fielddescriptor.isRepeated())
                {
                    codedoutputstream.writeMessageSetExtension(fielddescriptor.getNumber(), (Message)next.getValue());
                } else
                {
                    FieldSet.writeField(fielddescriptor, next.getValue(), codedoutputstream);
                }
                if (iter.hasNext())
                {
                    next = (java.util.Map.Entry)iter.next();
                } else
                {
                    next = null;
                }
            }
        }

        private ExtensionWriter(boolean flag)
        {
            this$0 = GeneratedMessage.ExtendableMessage.this;
            super();
            iter = extensions.iterator();
            if (iter.hasNext())
            {
                next = (java.util.Map.Entry)iter.next();
            }
            messageSetWireFormat = flag;
        }

        ExtensionWriter(boolean flag, GeneratedMessage._cls1 _pcls1)
        {
            this(flag);
        }
    }


    private final FieldSet extensions;

    private void verifyContainingType(ExtensionWriter.next next)
    {
        if (next.ainingType() != getDescriptorForType())
        {
            throw new IllegalArgumentException("FieldDescriptor does not match message type.");
        } else
        {
            return;
        }
    }

    protected boolean extensionsAreInitialized()
    {
        return extensions.isInitialized();
    }

    protected int extensionsSerializedSize()
    {
        return extensions.getSerializedSize();
    }

    public Map getAllFields()
    {
        Map map = GeneratedMessage.access$800(this);
        map.putAll(getExtensionFields());
        return Collections.unmodifiableMap(map);
    }

    protected Map getExtensionFields()
    {
        return extensions.getAllFields();
    }

    public Object getField(extensions extensions1)
    {
label0:
        {
label1:
            {
                if (!extensions1.sion())
                {
                    break label0;
                }
                verifyContainingType(extensions1);
                Object obj1 = extensions.getField(extensions1);
                Object obj = obj1;
                if (obj1 == null)
                {
                    if (extensions1.Type() != e.MESSAGE)
                    {
                        break label1;
                    }
                    obj = DynamicMessage.getDefaultInstance(extensions1.ageType());
                }
                return obj;
            }
            return extensions1.ultValue();
        }
        return super.getField(extensions1);
    }

    public Object getRepeatedField(ultValue ultvalue, int i)
    {
        if (ultvalue.sion())
        {
            verifyContainingType(ultvalue);
            return extensions.getRepeatedField(ultvalue, i);
        } else
        {
            return super.getRepeatedField(ultvalue, i);
        }
    }

    public int getRepeatedFieldCount(extensions extensions1)
    {
        if (extensions1.sion())
        {
            verifyContainingType(extensions1);
            return extensions.getRepeatedFieldCount(extensions1);
        } else
        {
            return super.getRepeatedFieldCount(extensions1);
        }
    }

    public boolean hasField(unt unt)
    {
        if (unt.sion())
        {
            verifyContainingType(unt);
            return extensions.hasField(unt);
        } else
        {
            return super.hasField(unt);
        }
    }

    public boolean isInitialized()
    {
        return super.isInitialized() && extensionsAreInitialized();
    }

    protected ExtensionWriter newExtensionWriter()
    {
        return new ExtensionWriter(false, null);
    }


    protected ExtensionWriter()
    {
        extensions = FieldSet.newFieldSet();
    }

    protected extensions(extensions extensions1)
    {
        super(extensions1);
        extensions = access._mth300(extensions1);
    }
}

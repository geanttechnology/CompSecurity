// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.tagmanager.protobuf;

import java.io.IOException;
import java.util.Iterator;

// Referenced classes of package com.google.tagmanager.protobuf:
//            GeneratedMessageLite, FieldSet, MutableMessageLite, CodedInputStream, 
//            CodedOutputStream, ExtensionRegistryLite, MessageLite

public static abstract class access._cls000 extends GeneratedMessageLite
    implements rBuilder
{
    protected class ExtensionWriter
    {

        private final Iterator iter;
        private final boolean messageSetWireFormat;
        private java.util.Map.Entry next;
        final GeneratedMessageLite.ExtendableMessage this$0;

        public void writeUntil(int i, CodedOutputStream codedoutputstream)
            throws IOException
        {
            while (next != null && ((GeneratedMessageLite.ExtensionDescriptor)next.getKey()).getNumber() < i) 
            {
                GeneratedMessageLite.ExtensionDescriptor extensiondescriptor = (GeneratedMessageLite.ExtensionDescriptor)next.getKey();
                if (messageSetWireFormat && extensiondescriptor.getLiteJavaType() == WireFormat.JavaType.MESSAGE && !extensiondescriptor.isRepeated())
                {
                    codedoutputstream.writeMessageSetExtension(extensiondescriptor.getNumber(), (MessageLite)next.getValue());
                } else
                {
                    FieldSet.writeField(extensiondescriptor, next.getValue(), codedoutputstream);
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
            this$0 = GeneratedMessageLite.ExtendableMessage.this;
            super();
            iter = extensions.iterator();
            if (iter.hasNext())
            {
                next = (java.util.Map.Entry)iter.next();
            }
            messageSetWireFormat = flag;
        }

        ExtensionWriter(boolean flag, GeneratedMessageLite._cls1 _pcls1)
        {
            this(flag);
        }
    }


    private final FieldSet extensions;

    private void verifyExtensionContainingType( )
    {
        if (.getContainingTypeDefaultInstance() != getDefaultInstanceForType())
        {
            throw new IllegalArgumentException("This extension is for a different message type.  Please make sure that you are not suppressing any generics type warnings.");
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

    protected int extensionsSerializedSizeAsMessageSet()
    {
        return extensions.getMessageSetSerializedSize();
    }

    public final Object getExtension( )
    {
        verifyExtensionContainingType();
        Object obj = extensions.getField(.descriptor);
        if (obj == null)
        {
            return .defaultValue;
        } else
        {
            return .fromFieldSetType(obj);
        }
    }

    public final Object getExtension( , int i)
    {
        verifyExtensionContainingType();
        return .singularFromFieldSetType(extensions.getRepeatedField(.descriptor, i));
    }

    public final int getExtensionCount( )
    {
        verifyExtensionContainingType();
        return extensions.getRepeatedFieldCount(.descriptor);
    }

    public final boolean hasExtension( )
    {
        verifyExtensionContainingType();
        return extensions.hasField(.descriptor);
    }

    protected void makeExtensionsImmutable()
    {
        extensions.makeImmutable();
    }

    public MutableMessageLite mutableCopy()
    {
        utableMessage utablemessage = (utableMessage)super.mutableCopy();
        utablemessage.internalSetExtensionSet(extensions.cloneWithAllFieldsToMutable());
        return utablemessage;
    }

    protected ExtensionWriter newExtensionWriter()
    {
        return new ExtensionWriter(false, null);
    }

    protected ExtensionWriter newMessageSetExtensionWriter()
    {
        return new ExtensionWriter(true, null);
    }

    protected boolean parseUnknownField(CodedInputStream codedinputstream, CodedOutputStream codedoutputstream, ExtensionRegistryLite extensionregistrylite, int i)
        throws IOException
    {
        return GeneratedMessageLite.access$100(extensions, getDefaultInstanceForType(), codedinputstream, codedoutputstream, extensionregistrylite, i);
    }


    protected ExtensionWriter()
    {
        extensions = FieldSet.newFieldSet();
    }

    protected extensions(extensions extensions1)
    {
        extensions = access._mth000(extensions1);
    }
}

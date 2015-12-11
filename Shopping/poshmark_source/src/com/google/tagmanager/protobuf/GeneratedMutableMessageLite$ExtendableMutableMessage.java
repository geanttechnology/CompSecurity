// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.tagmanager.protobuf;

import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.google.tagmanager.protobuf:
//            GeneratedMutableMessageLite, FieldSet, MutableMessageLite, MessageLite, 
//            CodedInputStream, CodedOutputStream, ExtensionRegistryLite

public static abstract class extensions extends GeneratedMutableMessageLite
{
    protected class ExtensionWriter
    {

        private final Iterator iter;
        private final boolean messageSetWireFormat;
        private java.util.Map.Entry next;
        final GeneratedMutableMessageLite.ExtendableMutableMessage this$0;

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
            this$0 = GeneratedMutableMessageLite.ExtendableMutableMessage.this;
            super();
            iter = extensions.iterator();
            if (iter.hasNext())
            {
                next = (java.util.Map.Entry)iter.next();
            }
            messageSetWireFormat = flag;
        }

        ExtensionWriter(boolean flag, GeneratedMutableMessageLite._cls1 _pcls1)
        {
            this(flag);
        }
    }


    private FieldSet extensions;

    private void ensureExtensionsIsMutable()
    {
        if (extensions.isImmutable())
        {
            extensions = extensions.clone();
        }
    }

    private void verifyExtensionContainingType(extensions extensions1)
    {
        if (extensions1.TypeDefaultInstance() != getDefaultInstanceForType())
        {
            throw new IllegalArgumentException("This extension is for a different message type.  Please make sure that you are not suppressing any generics type warnings.");
        } else
        {
            return;
        }
    }

    public final getDefaultInstanceForType addExtension(getDefaultInstanceForType getdefaultinstancefortype, Object obj)
    {
        assertMutable();
        verifyExtensionContainingType(getdefaultinstancefortype);
        ensureExtensionsIsMutable();
        extensions.addRepeatedField(getdefaultinstancefortype.extensions, getdefaultinstancefortype.ldSetType(obj));
        return this;
    }

    public ldSetType clear()
    {
        assertMutable();
        extensions = FieldSet.emptySet();
        return (extensions)super.clear();
    }

    public volatile GeneratedMutableMessageLite clear()
    {
        return clear();
    }

    public volatile MutableMessageLite clear()
    {
        return clear();
    }

    public final clear clearExtension(clear clear1)
    {
        assertMutable();
        verifyExtensionContainingType(clear1);
        ensureExtensionsIsMutable();
        extensions.clearField(clear1.extensions);
        return this;
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

    public volatile MessageLite getDefaultInstanceForType()
    {
        return super.getDefaultInstanceForType();
    }

    public final Object getExtension( )
    {
        verifyExtensionContainingType();
        Object obj = extensions.getField(.extensions);
        if (obj == null)
        {
            return .extensions;
        }
        if (.extensions.extensions)
        {
            return Collections.unmodifiableList((List).ype(obj));
        } else
        {
            return .ype(obj);
        }
    }

    public final Object getExtension(ype ype, int i)
    {
        verifyExtensionContainingType(ype);
        return ype.ieldSetType(extensions.getRepeatedField(ype.extensions, i));
    }

    public final int getExtensionCount(extensions extensions1)
    {
        verifyExtensionContainingType(extensions1);
        return extensions.getRepeatedFieldCount(extensions1.extensions);
    }

    public final MutableMessageLite getMutableExtension(extensions extensions1)
    {
        assertMutable();
        verifyExtensionContainingType(extensions1);
        ensureExtensionsIsMutable();
        Object obj = extensions1.ensureExtensionsIsMutable;
        if (((ensureExtensionsIsMutable) (obj)).ype() != ype)
        {
            throw new UnsupportedOperationException("getMutableExtension() called on a non-Message type.");
        }
        if (((ype) (obj)).ype())
        {
            throw new UnsupportedOperationException("getMutableExtension() called on a repeated type.");
        }
        obj = extensions.getField(extensions1.extensions);
        if (obj == null)
        {
            obj = ((MutableMessageLite)extensions1.extensions).newMessageForType();
            extensions.setField(extensions1.extensions, obj);
            return ((MutableMessageLite) (obj));
        } else
        {
            return (MutableMessageLite)obj;
        }
    }

    public final boolean hasExtension(extensions extensions1)
    {
        verifyExtensionContainingType(extensions1);
        return extensions.hasField(extensions1.extensions);
    }

    public MessageLite immutableCopy()
    {
        extensions extensions1 = (extensions)internalCopyToBuilder(this, internalImmutableDefault());
        extensions1.ensionSet(extensions.cloneWithAllFieldsToImmutable());
        return extensions1.extensions();
    }

    void internalSetExtensionSet(FieldSet fieldset)
    {
        extensions = fieldset;
    }

    protected final void mergeExtensionFields(extensions extensions1)
    {
        ensureExtensionsIsMutable();
        extensions.mergeFrom(extensions1.extensions);
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
        ensureExtensionsIsMutable();
        return GeneratedMutableMessageLite.parseUnknownField(extensions, getDefaultInstanceForType(), codedinputstream, codedoutputstream, extensionregistrylite, i);
    }

    public final getDefaultInstanceForType setExtension(getDefaultInstanceForType getdefaultinstancefortype, int i, Object obj)
    {
        assertMutable();
        verifyExtensionContainingType(getdefaultinstancefortype);
        ensureExtensionsIsMutable();
        extensions.setRepeatedField(getdefaultinstancefortype.extensions, i, getdefaultinstancefortype.ldSetType(obj));
        return this;
    }

    public final ldSetType setExtension(ldSetType ldsettype, Object obj)
    {
        assertMutable();
        verifyExtensionContainingType(ldsettype);
        ensureExtensionsIsMutable();
        extensions.setField(ldsettype.extensions, ldsettype.e(obj));
        return this;
    }


    protected ExtensionWriter()
    {
        extensions = FieldSet.emptySet();
    }
}

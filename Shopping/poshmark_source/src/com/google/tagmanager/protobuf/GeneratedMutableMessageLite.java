// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.tagmanager.protobuf;

import java.io.IOException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.google.tagmanager.protobuf:
//            AbstractMutableMessageLite, ByteString, InvalidProtocolBufferException, MessageLite, 
//            MutableMessageLite, GeneratedMessageLite, WireFormat, ExtensionRegistryLite, 
//            CodedInputStream, FieldSet, CodedOutputStream, Parser

public abstract class GeneratedMutableMessageLite extends AbstractMutableMessageLite
    implements Serializable
{
    public static abstract class ExtendableMutableMessage extends GeneratedMutableMessageLite
    {

        private FieldSet extensions;

        private void ensureExtensionsIsMutable()
        {
            if (extensions.isImmutable())
            {
                extensions = extensions.clone();
            }
        }

        private void verifyExtensionContainingType(GeneratedMessageLite.GeneratedExtension generatedextension)
        {
            if (generatedextension.getContainingTypeDefaultInstance() != getDefaultInstanceForType())
            {
                throw new IllegalArgumentException("This extension is for a different message type.  Please make sure that you are not suppressing any generics type warnings.");
            } else
            {
                return;
            }
        }

        public final ExtendableMutableMessage addExtension(GeneratedMessageLite.GeneratedExtension generatedextension, Object obj)
        {
            assertMutable();
            verifyExtensionContainingType(generatedextension);
            ensureExtensionsIsMutable();
            extensions.addRepeatedField(generatedextension.descriptor, generatedextension.singularToFieldSetType(obj));
            return this;
        }

        public ExtendableMutableMessage clear()
        {
            assertMutable();
            extensions = FieldSet.emptySet();
            return (ExtendableMutableMessage)clear();
        }

        public volatile GeneratedMutableMessageLite clear()
        {
            return clear();
        }

        public volatile MutableMessageLite clear()
        {
            return clear();
        }

        public final ExtendableMutableMessage clearExtension(GeneratedMessageLite.GeneratedExtension generatedextension)
        {
            assertMutable();
            verifyExtensionContainingType(generatedextension);
            ensureExtensionsIsMutable();
            extensions.clearField(generatedextension.descriptor);
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
            return getDefaultInstanceForType();
        }

        public final Object getExtension(GeneratedMessageLite.GeneratedExtension generatedextension)
        {
            verifyExtensionContainingType(generatedextension);
            Object obj = extensions.getField(generatedextension.descriptor);
            if (obj == null)
            {
                return generatedextension.defaultValue;
            }
            if (generatedextension.descriptor.isRepeated)
            {
                return Collections.unmodifiableList((List)generatedextension.fromFieldSetType(obj));
            } else
            {
                return generatedextension.fromFieldSetType(obj);
            }
        }

        public final Object getExtension(GeneratedMessageLite.GeneratedExtension generatedextension, int i)
        {
            verifyExtensionContainingType(generatedextension);
            return generatedextension.singularFromFieldSetType(extensions.getRepeatedField(generatedextension.descriptor, i));
        }

        public final int getExtensionCount(GeneratedMessageLite.GeneratedExtension generatedextension)
        {
            verifyExtensionContainingType(generatedextension);
            return extensions.getRepeatedFieldCount(generatedextension.descriptor);
        }

        public final MutableMessageLite getMutableExtension(GeneratedMessageLite.GeneratedExtension generatedextension)
        {
            assertMutable();
            verifyExtensionContainingType(generatedextension);
            ensureExtensionsIsMutable();
            Object obj = generatedextension.descriptor;
            if (((GeneratedMessageLite.ExtensionDescriptor) (obj)).getLiteJavaType() != WireFormat.JavaType.MESSAGE)
            {
                throw new UnsupportedOperationException("getMutableExtension() called on a non-Message type.");
            }
            if (((GeneratedMessageLite.ExtensionDescriptor) (obj)).isRepeated())
            {
                throw new UnsupportedOperationException("getMutableExtension() called on a repeated type.");
            }
            obj = extensions.getField(generatedextension.descriptor);
            if (obj == null)
            {
                obj = ((MutableMessageLite)generatedextension.defaultValue).newMessageForType();
                extensions.setField(generatedextension.descriptor, obj);
                return ((MutableMessageLite) (obj));
            } else
            {
                return (MutableMessageLite)obj;
            }
        }

        public final boolean hasExtension(GeneratedMessageLite.GeneratedExtension generatedextension)
        {
            verifyExtensionContainingType(generatedextension);
            return extensions.hasField(generatedextension.descriptor);
        }

        public MessageLite immutableCopy()
        {
            GeneratedMessageLite.ExtendableBuilder extendablebuilder = (GeneratedMessageLite.ExtendableBuilder)internalCopyToBuilder(this, internalImmutableDefault());
            extendablebuilder.internalSetExtensionSet(extensions.cloneWithAllFieldsToImmutable());
            return extendablebuilder.buildPartial();
        }

        void internalSetExtensionSet(FieldSet fieldset)
        {
            extensions = fieldset;
        }

        protected final void mergeExtensionFields(ExtendableMutableMessage extendablemutablemessage)
        {
            ensureExtensionsIsMutable();
            extensions.mergeFrom(extendablemutablemessage.extensions);
        }

        protected ExtensionWriter newExtensionWriter()
        {
            return new ExtensionWriter(false);
        }

        protected ExtensionWriter newMessageSetExtensionWriter()
        {
            return new ExtensionWriter(true);
        }

        protected boolean parseUnknownField(CodedInputStream codedinputstream, CodedOutputStream codedoutputstream, ExtensionRegistryLite extensionregistrylite, int i)
            throws IOException
        {
            ensureExtensionsIsMutable();
            return GeneratedMutableMessageLite.parseUnknownField(extensions, getDefaultInstanceForType(), codedinputstream, codedoutputstream, extensionregistrylite, i);
        }

        public final ExtendableMutableMessage setExtension(GeneratedMessageLite.GeneratedExtension generatedextension, int i, Object obj)
        {
            assertMutable();
            verifyExtensionContainingType(generatedextension);
            ensureExtensionsIsMutable();
            extensions.setRepeatedField(generatedextension.descriptor, i, generatedextension.singularToFieldSetType(obj));
            return this;
        }

        public final ExtendableMutableMessage setExtension(GeneratedMessageLite.GeneratedExtension generatedextension, Object obj)
        {
            assertMutable();
            verifyExtensionContainingType(generatedextension);
            ensureExtensionsIsMutable();
            extensions.setField(generatedextension.descriptor, generatedextension.toFieldSetType(obj));
            return this;
        }


        protected ExtendableMutableMessage()
        {
            extensions = FieldSet.emptySet();
        }
    }

    protected class ExtendableMutableMessage.ExtensionWriter
    {

        private final Iterator iter;
        private final boolean messageSetWireFormat;
        private java.util.Map.Entry next;
        final ExtendableMutableMessage this$0;

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

        private ExtendableMutableMessage.ExtensionWriter(boolean flag)
        {
            this$0 = ExtendableMutableMessage.this;
            super();
            iter = extensions.iterator();
            if (iter.hasNext())
            {
                next = (java.util.Map.Entry)iter.next();
            }
            messageSetWireFormat = flag;
        }

    }

    static final class SerializedForm
        implements Serializable
    {

        private static final long serialVersionUID = 0L;
        private byte asBytes[];
        private String messageClassName;

        protected Object readResolve()
            throws ObjectStreamException
        {
            Object obj;
            try
            {
                obj = (MutableMessageLite)Class.forName(messageClassName).getMethod("newMessage", new Class[0]).invoke(null, new Object[0]);
                if (!((MutableMessageLite) (obj)).mergeFrom(CodedInputStream.newInstance(asBytes)))
                {
                    throw new RuntimeException("Unable to understand proto buffer");
                }
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new RuntimeException("Unable to find proto buffer class", ((Throwable) (obj)));
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new RuntimeException("Unable to find newMessage method", ((Throwable) (obj)));
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new RuntimeException("Unable to call newMessage method", ((Throwable) (obj)));
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new RuntimeException("Error calling newMessage", ((InvocationTargetException) (obj)).getCause());
            }
            return obj;
        }

        SerializedForm(MutableMessageLite mutablemessagelite)
        {
            messageClassName = mutablemessagelite.getClass().getName();
            asBytes = mutablemessagelite.toByteArray();
        }
    }


    private static final long serialVersionUID = 1L;
    protected ByteString unknownFields;

    public GeneratedMutableMessageLite()
    {
        unknownFields = ByteString.EMPTY;
    }

    static MessageLite.Builder internalCopyToBuilder(MutableMessageLite mutablemessagelite, MessageLite messagelite)
    {
        messagelite = messagelite.newBuilderForType();
        try
        {
            messagelite.mergeFrom(mutablemessagelite.toByteArray());
        }
        // Misplaced declaration of an exception variable
        catch (MutableMessageLite mutablemessagelite)
        {
            throw new RuntimeException("Failed to parse serialized bytes (should not happen)");
        }
        return messagelite;
    }

    protected static MessageLite internalImmutableDefault(String s)
    {
        try
        {
            s = (MessageLite)GeneratedMessageLite.invokeOrDie(GeneratedMessageLite.getMethodOrDie(Class.forName(s), "getDefaultInstance", new Class[0]), null, new Object[0]);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new UnsupportedOperationException("Cannot load the corresponding immutable class. Please add necessary dependencies.");
        }
        return s;
    }

    static boolean parseUnknownField(FieldSet fieldset, MutableMessageLite mutablemessagelite, CodedInputStream codedinputstream, CodedOutputStream codedoutputstream, ExtensionRegistryLite extensionregistrylite, int i)
        throws IOException
    {
        GeneratedMessageLite.GeneratedExtension generatedextension;
        boolean flag;
        int l = WireFormat.getTagWireType(i);
        generatedextension = extensionregistrylite.findLiteExtensionByNumber(mutablemessagelite, WireFormat.getTagFieldNumber(i));
        boolean flag1 = false;
        flag = false;
        if (generatedextension == null)
        {
            flag1 = true;
        } else
        if (l == FieldSet.getWireFormatForFieldType(generatedextension.descriptor.getLiteType(), false))
        {
            flag = false;
        } else
        if (generatedextension.descriptor.isRepeated && generatedextension.descriptor.type.isPackable() && l == FieldSet.getWireFormatForFieldType(generatedextension.descriptor.getLiteType(), true))
        {
            flag = true;
        } else
        {
            flag1 = true;
        }
        if (flag1)
        {
            return codedinputstream.skipField(i, codedoutputstream);
        }
        if (!flag) goto _L2; else goto _L1
_L1:
        i = codedinputstream.pushLimit(codedinputstream.readRawVarint32());
        if (generatedextension.descriptor.getLiteType() == WireFormat.FieldType.ENUM)
        {
            for (; codedinputstream.getBytesUntilLimit() > 0; fieldset.addRepeatedField(generatedextension.descriptor, generatedextension.singularToFieldSetType(mutablemessagelite)))
            {
                int j = codedinputstream.readEnum();
                mutablemessagelite = generatedextension.descriptor.getEnumType().findValueByNumber(j);
                if (mutablemessagelite == null)
                {
                    return true;
                }
            }

        } else
        {
            for (; codedinputstream.getBytesUntilLimit() > 0; fieldset.addRepeatedField(generatedextension.descriptor, mutablemessagelite))
            {
                mutablemessagelite = ((MutableMessageLite) (FieldSet.readPrimitiveFieldForMutable(codedinputstream, generatedextension.descriptor.getLiteType(), false)));
            }

        }
        codedinputstream.popLimit(i);
_L6:
        return true;
_L2:
        static class _cls1
        {

            static final int $SwitchMap$com$google$protobuf$WireFormat$JavaType[];

            static 
            {
                $SwitchMap$com$google$protobuf$WireFormat$JavaType = new int[WireFormat.JavaType.values().length];
                try
                {
                    $SwitchMap$com$google$protobuf$WireFormat$JavaType[WireFormat.JavaType.MESSAGE.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$google$protobuf$WireFormat$JavaType[WireFormat.JavaType.ENUM.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1..SwitchMap.com.google.protobuf.WireFormat.JavaType[generatedextension.descriptor.getLiteJavaType().ordinal()];
        JVM INSTR tableswitch 1 2: default 284
    //                   1 327
    //                   2 380;
           goto _L3 _L4 _L5
_L3:
        mutablemessagelite = ((MutableMessageLite) (FieldSet.readPrimitiveFieldForMutable(codedinputstream, generatedextension.descriptor.getLiteType(), false)));
_L7:
        if (generatedextension.descriptor.isRepeated())
        {
            fieldset.addRepeatedField(generatedextension.descriptor, generatedextension.singularToFieldSetType(mutablemessagelite));
        } else
        {
            fieldset.setField(generatedextension.descriptor, generatedextension.singularToFieldSetType(mutablemessagelite));
        }
        if (true) goto _L6; else goto _L4
_L4:
        mutablemessagelite = ((MutableMessageLite)generatedextension.messageDefaultInstance).newMessageForType();
        if (generatedextension.descriptor.getLiteType() == WireFormat.FieldType.GROUP)
        {
            codedinputstream.readGroup(generatedextension.getNumber(), mutablemessagelite, extensionregistrylite);
        } else
        {
            codedinputstream.readMessage(mutablemessagelite, extensionregistrylite);
        }
          goto _L7
_L5:
        int k = codedinputstream.readEnum();
        codedinputstream = generatedextension.descriptor.getEnumType().findValueByNumber(k);
        mutablemessagelite = codedinputstream;
        if (codedinputstream == null)
        {
            codedoutputstream.writeRawVarint32(i);
            codedoutputstream.writeUInt32NoTag(k);
            return true;
        }
          goto _L7
    }

    public GeneratedMutableMessageLite clear()
    {
        assertMutable();
        unknownFields = ByteString.EMPTY;
        return this;
    }

    public volatile MutableMessageLite clear()
    {
        return clear();
    }

    public abstract GeneratedMutableMessageLite getDefaultInstanceForType();

    public volatile MessageLite getDefaultInstanceForType()
    {
        return getDefaultInstanceForType();
    }

    public Parser getParserForType()
    {
        throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
    }

    public MessageLite immutableCopy()
    {
        MessageLite messagelite = internalImmutableDefault();
        if (this == getDefaultInstanceForType())
        {
            return messagelite;
        } else
        {
            return internalCopyToBuilder(this, messagelite).buildPartial();
        }
    }

    protected abstract MessageLite internalImmutableDefault();

    public abstract GeneratedMutableMessageLite mergeFrom(GeneratedMutableMessageLite generatedmutablemessagelite);

    protected boolean parseUnknownField(CodedInputStream codedinputstream, CodedOutputStream codedoutputstream, ExtensionRegistryLite extensionregistrylite, int i)
        throws IOException
    {
        return codedinputstream.skipField(i, codedoutputstream);
    }

    protected Object writeReplace()
        throws ObjectStreamException
    {
        return new SerializedForm(this);
    }
}

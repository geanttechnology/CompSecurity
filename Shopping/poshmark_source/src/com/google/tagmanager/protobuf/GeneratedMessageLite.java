// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.tagmanager.protobuf;

import java.io.IOException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.google.tagmanager.protobuf:
//            AbstractMessageLite, MutableMessageLite, WireFormat, ExtensionRegistryLite, 
//            CodedInputStream, FieldSet, MessageLite, CodedOutputStream, 
//            Parser, ByteString, MessageLiteOrBuilder, GeneratedMutableMessageLite, 
//            InvalidProtocolBufferException

public abstract class GeneratedMessageLite extends AbstractMessageLite
    implements Serializable
{
    public static abstract class Builder extends AbstractMessageLite.Builder
    {

        private ByteString unknownFields;

        public Builder clear()
        {
            unknownFields = ByteString.EMPTY;
            return this;
        }

        public volatile MessageLite.Builder clear()
        {
            return clear();
        }

        public volatile AbstractMessageLite.Builder clone()
        {
            return clone();
        }

        public Builder clone()
        {
            throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
        }

        public volatile MessageLite.Builder clone()
        {
            return clone();
        }

        public volatile Object clone()
            throws CloneNotSupportedException
        {
            return clone();
        }

        public abstract GeneratedMessageLite getDefaultInstanceForType();

        public volatile MessageLite getDefaultInstanceForType()
        {
            return getDefaultInstanceForType();
        }

        public final ByteString getUnknownFields()
        {
            return unknownFields;
        }

        public abstract Builder mergeFrom(GeneratedMessageLite generatedmessagelite);

        protected boolean parseUnknownField(CodedInputStream codedinputstream, CodedOutputStream codedoutputstream, ExtensionRegistryLite extensionregistrylite, int i)
            throws IOException
        {
            return codedinputstream.skipField(i, codedoutputstream);
        }

        public final Builder setUnknownFields(ByteString bytestring)
        {
            unknownFields = bytestring;
            return this;
        }

        protected Builder()
        {
            unknownFields = ByteString.EMPTY;
        }
    }

    public static abstract class ExtendableBuilder extends Builder
        implements ExtendableMessageOrBuilder
    {

        private FieldSet extensions;
        private boolean extensionsIsMutable;

        private FieldSet buildExtensions()
        {
            extensions.makeImmutable();
            extensionsIsMutable = false;
            return extensions;
        }

        private void ensureExtensionsIsMutable()
        {
            if (!extensionsIsMutable)
            {
                extensions = extensions.clone();
                extensionsIsMutable = true;
            }
        }

        private void verifyExtensionContainingType(GeneratedExtension generatedextension)
        {
            if (generatedextension.getContainingTypeDefaultInstance() != getDefaultInstanceForType())
            {
                throw new IllegalArgumentException("This extension is for a different message type.  Please make sure that you are not suppressing any generics type warnings.");
            } else
            {
                return;
            }
        }

        public final ExtendableBuilder addExtension(GeneratedExtension generatedextension, Object obj)
        {
            verifyExtensionContainingType(generatedextension);
            ensureExtensionsIsMutable();
            extensions.addRepeatedField(generatedextension.descriptor, generatedextension.singularToFieldSetType(obj));
            return this;
        }

        public volatile Builder clear()
        {
            return clear();
        }

        public ExtendableBuilder clear()
        {
            extensions.clear();
            extensionsIsMutable = false;
            return (ExtendableBuilder)super.clear();
        }

        public volatile MessageLite.Builder clear()
        {
            return clear();
        }

        public final ExtendableBuilder clearExtension(GeneratedExtension generatedextension)
        {
            verifyExtensionContainingType(generatedextension);
            ensureExtensionsIsMutable();
            extensions.clearField(generatedextension.descriptor);
            return this;
        }

        public volatile AbstractMessageLite.Builder clone()
        {
            return clone();
        }

        public volatile Builder clone()
        {
            return clone();
        }

        public ExtendableBuilder clone()
        {
            throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
        }

        public volatile MessageLite.Builder clone()
        {
            return clone();
        }

        public volatile Object clone()
            throws CloneNotSupportedException
        {
            return clone();
        }

        protected boolean extensionsAreInitialized()
        {
            return extensions.isInitialized();
        }

        public final Object getExtension(GeneratedExtension generatedextension)
        {
            verifyExtensionContainingType(generatedextension);
            Object obj = extensions.getField(generatedextension.descriptor);
            if (obj == null)
            {
                return generatedextension.defaultValue;
            } else
            {
                return generatedextension.fromFieldSetType(obj);
            }
        }

        public final Object getExtension(GeneratedExtension generatedextension, int i)
        {
            verifyExtensionContainingType(generatedextension);
            return generatedextension.singularFromFieldSetType(extensions.getRepeatedField(generatedextension.descriptor, i));
        }

        public final int getExtensionCount(GeneratedExtension generatedextension)
        {
            verifyExtensionContainingType(generatedextension);
            return extensions.getRepeatedFieldCount(generatedextension.descriptor);
        }

        public final boolean hasExtension(GeneratedExtension generatedextension)
        {
            verifyExtensionContainingType(generatedextension);
            return extensions.hasField(generatedextension.descriptor);
        }

        void internalSetExtensionSet(FieldSet fieldset)
        {
            extensions = fieldset;
        }

        protected final void mergeExtensionFields(ExtendableMessage extendablemessage)
        {
            ensureExtensionsIsMutable();
            extensions.mergeFrom(extendablemessage.extensions);
        }

        protected boolean parseUnknownField(CodedInputStream codedinputstream, CodedOutputStream codedoutputstream, ExtensionRegistryLite extensionregistrylite, int i)
            throws IOException
        {
            ensureExtensionsIsMutable();
            return GeneratedMessageLite.parseUnknownField(extensions, getDefaultInstanceForType(), codedinputstream, codedoutputstream, extensionregistrylite, i);
        }

        public final ExtendableBuilder setExtension(GeneratedExtension generatedextension, int i, Object obj)
        {
            verifyExtensionContainingType(generatedextension);
            ensureExtensionsIsMutable();
            extensions.setRepeatedField(generatedextension.descriptor, i, generatedextension.singularToFieldSetType(obj));
            return this;
        }

        public final ExtendableBuilder setExtension(GeneratedExtension generatedextension, Object obj)
        {
            verifyExtensionContainingType(generatedextension);
            ensureExtensionsIsMutable();
            extensions.setField(generatedextension.descriptor, generatedextension.toFieldSetType(obj));
            return this;
        }


        protected ExtendableBuilder()
        {
            extensions = FieldSet.emptySet();
        }
    }

    public static abstract class ExtendableMessage extends GeneratedMessageLite
        implements ExtendableMessageOrBuilder
    {

        private final FieldSet extensions;

        private void verifyExtensionContainingType(GeneratedExtension generatedextension)
        {
            if (generatedextension.getContainingTypeDefaultInstance() != getDefaultInstanceForType())
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

        public final Object getExtension(GeneratedExtension generatedextension)
        {
            verifyExtensionContainingType(generatedextension);
            Object obj = extensions.getField(generatedextension.descriptor);
            if (obj == null)
            {
                return generatedextension.defaultValue;
            } else
            {
                return generatedextension.fromFieldSetType(obj);
            }
        }

        public final Object getExtension(GeneratedExtension generatedextension, int i)
        {
            verifyExtensionContainingType(generatedextension);
            return generatedextension.singularFromFieldSetType(extensions.getRepeatedField(generatedextension.descriptor, i));
        }

        public final int getExtensionCount(GeneratedExtension generatedextension)
        {
            verifyExtensionContainingType(generatedextension);
            return extensions.getRepeatedFieldCount(generatedextension.descriptor);
        }

        public final boolean hasExtension(GeneratedExtension generatedextension)
        {
            verifyExtensionContainingType(generatedextension);
            return extensions.hasField(generatedextension.descriptor);
        }

        protected void makeExtensionsImmutable()
        {
            extensions.makeImmutable();
        }

        public MutableMessageLite mutableCopy()
        {
            GeneratedMutableMessageLite.ExtendableMutableMessage extendablemutablemessage = (GeneratedMutableMessageLite.ExtendableMutableMessage)mutableCopy();
            extendablemutablemessage.internalSetExtensionSet(extensions.cloneWithAllFieldsToMutable());
            return extendablemutablemessage;
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
            return GeneratedMessageLite.parseUnknownField(extensions, getDefaultInstanceForType(), codedinputstream, codedoutputstream, extensionregistrylite, i);
        }


        protected ExtendableMessage()
        {
            extensions = FieldSet.newFieldSet();
        }

        protected ExtendableMessage(ExtendableBuilder extendablebuilder)
        {
            extensions = extendablebuilder.buildExtensions();
        }
    }

    protected class ExtendableMessage.ExtensionWriter
    {

        private final Iterator iter;
        private final boolean messageSetWireFormat;
        private java.util.Map.Entry next;
        final ExtendableMessage this$0;

        public void writeUntil(int i, CodedOutputStream codedoutputstream)
            throws IOException
        {
            while (next != null && ((ExtensionDescriptor)next.getKey()).getNumber() < i) 
            {
                ExtensionDescriptor extensiondescriptor = (ExtensionDescriptor)next.getKey();
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

        private ExtendableMessage.ExtensionWriter(boolean flag)
        {
            this$0 = ExtendableMessage.this;
            super();
            iter = extensions.iterator();
            if (iter.hasNext())
            {
                next = (java.util.Map.Entry)iter.next();
            }
            messageSetWireFormat = flag;
        }

    }

    public static interface ExtendableMessageOrBuilder
        extends MessageLiteOrBuilder
    {

        public abstract Object getExtension(GeneratedExtension generatedextension);

        public abstract Object getExtension(GeneratedExtension generatedextension, int i);

        public abstract int getExtensionCount(GeneratedExtension generatedextension);

        public abstract boolean hasExtension(GeneratedExtension generatedextension);
    }

    static final class ExtensionDescriptor
        implements FieldSet.FieldDescriptorLite
    {

        final Internal.EnumLiteMap enumTypeMap;
        final boolean isPacked;
        final boolean isRepeated;
        final int number;
        final WireFormat.FieldType type;

        public int compareTo(ExtensionDescriptor extensiondescriptor)
        {
            return number - extensiondescriptor.number;
        }

        public volatile int compareTo(Object obj)
        {
            return compareTo((ExtensionDescriptor)obj);
        }

        public Internal.EnumLiteMap getEnumType()
        {
            return enumTypeMap;
        }

        public WireFormat.JavaType getLiteJavaType()
        {
            return type.getJavaType();
        }

        public WireFormat.FieldType getLiteType()
        {
            return type;
        }

        public int getNumber()
        {
            return number;
        }

        public MessageLite.Builder internalMergeFrom(MessageLite.Builder builder, MessageLite messagelite)
        {
            return ((Builder)builder).mergeFrom((GeneratedMessageLite)messagelite);
        }

        public MutableMessageLite internalMergeFrom(MutableMessageLite mutablemessagelite, MutableMessageLite mutablemessagelite1)
        {
            return ((GeneratedMutableMessageLite)mutablemessagelite).mergeFrom((GeneratedMutableMessageLite)mutablemessagelite1);
        }

        public boolean isPacked()
        {
            return isPacked;
        }

        public boolean isRepeated()
        {
            return isRepeated;
        }

        ExtensionDescriptor(Internal.EnumLiteMap enumlitemap, int i, WireFormat.FieldType fieldtype, boolean flag, boolean flag1)
        {
            enumTypeMap = enumlitemap;
            number = i;
            type = fieldtype;
            isRepeated = flag;
            isPacked = flag1;
        }
    }

    public static class GeneratedExtension
    {

        final MessageLite containingTypeDefaultInstance;
        final Object defaultValue;
        final ExtensionDescriptor descriptor;
        final Method enumValueOf;
        final MessageLite messageDefaultInstance;
        final Class singularType;

        Object fromFieldSetType(Object obj)
        {
            if (descriptor.isRepeated())
            {
                if (descriptor.getLiteJavaType() == WireFormat.JavaType.ENUM)
                {
                    ArrayList arraylist = new ArrayList();
                    Iterator iterator = ((List)obj).iterator();
                    do
                    {
                        obj = arraylist;
                        if (!iterator.hasNext())
                        {
                            break;
                        }
                        arraylist.add(singularFromFieldSetType(iterator.next()));
                    } while (true);
                }
                return obj;
            } else
            {
                return singularFromFieldSetType(obj);
            }
        }

        public MessageLite getContainingTypeDefaultInstance()
        {
            return containingTypeDefaultInstance;
        }

        public MessageLite getMessageDefaultInstance()
        {
            return messageDefaultInstance;
        }

        public int getNumber()
        {
            return descriptor.getNumber();
        }

        Object singularFromFieldSetType(Object obj)
        {
            Object obj1 = obj;
            if (descriptor.getLiteJavaType() == WireFormat.JavaType.ENUM)
            {
                obj1 = GeneratedMessageLite.invokeOrDie(enumValueOf, null, new Object[] {
                    (Integer)obj
                });
            }
            return obj1;
        }

        Object singularToFieldSetType(Object obj)
        {
            Object obj1 = obj;
            if (descriptor.getLiteJavaType() == WireFormat.JavaType.ENUM)
            {
                obj1 = Integer.valueOf(((Internal.EnumLite)obj).getNumber());
            }
            return obj1;
        }

        Object toFieldSetType(Object obj)
        {
            if (descriptor.isRepeated())
            {
                if (descriptor.getLiteJavaType() == WireFormat.JavaType.ENUM)
                {
                    ArrayList arraylist = new ArrayList();
                    Iterator iterator = ((List)obj).iterator();
                    do
                    {
                        obj = arraylist;
                        if (!iterator.hasNext())
                        {
                            break;
                        }
                        arraylist.add(singularToFieldSetType(iterator.next()));
                    } while (true);
                }
                return obj;
            } else
            {
                return singularToFieldSetType(obj);
            }
        }

        GeneratedExtension(MessageLite messagelite, Object obj, MessageLite messagelite1, ExtensionDescriptor extensiondescriptor, Class class1)
        {
            if (messagelite == null)
            {
                throw new IllegalArgumentException("Null containingTypeDefaultInstance");
            }
            if (extensiondescriptor.getLiteType() == WireFormat.FieldType.MESSAGE && messagelite1 == null)
            {
                throw new IllegalArgumentException("Null messageDefaultInstance");
            }
            containingTypeDefaultInstance = messagelite;
            defaultValue = obj;
            messageDefaultInstance = messagelite1;
            descriptor = extensiondescriptor;
            singularType = class1;
            if (com/google/tagmanager/protobuf/Internal$EnumLite.isAssignableFrom(class1))
            {
                enumValueOf = GeneratedMessageLite.getMethodOrDie(class1, "valueOf", new Class[] {
                    Integer.TYPE
                });
                return;
            } else
            {
                enumValueOf = null;
                return;
            }
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
                obj = (MessageLite.Builder)Class.forName(messageClassName).getMethod("newBuilder", new Class[0]).invoke(null, new Object[0]);
                ((MessageLite.Builder) (obj)).mergeFrom(asBytes);
                obj = ((MessageLite.Builder) (obj)).buildPartial();
            }
            catch (ClassNotFoundException classnotfoundexception)
            {
                throw new RuntimeException("Unable to find proto buffer class", classnotfoundexception);
            }
            catch (NoSuchMethodException nosuchmethodexception)
            {
                throw new RuntimeException("Unable to find newBuilder method", nosuchmethodexception);
            }
            catch (IllegalAccessException illegalaccessexception)
            {
                throw new RuntimeException("Unable to call newBuilder method", illegalaccessexception);
            }
            catch (InvocationTargetException invocationtargetexception)
            {
                throw new RuntimeException("Error calling newBuilder", invocationtargetexception.getCause());
            }
            catch (InvalidProtocolBufferException invalidprotocolbufferexception)
            {
                throw new RuntimeException("Unable to understand proto buffer", invalidprotocolbufferexception);
            }
            return obj;
        }

        SerializedForm(MessageLite messagelite)
        {
            messageClassName = messagelite.getClass().getName();
            asBytes = messagelite.toByteArray();
        }
    }


    private static final long serialVersionUID = 1L;

    protected GeneratedMessageLite()
    {
    }

    protected GeneratedMessageLite(Builder builder)
    {
    }

    static transient Method getMethodOrDie(Class class1, String s, Class aclass[])
    {
        try
        {
            aclass = class1.getMethod(s, aclass);
        }
        // Misplaced declaration of an exception variable
        catch (Class aclass[])
        {
            throw new RuntimeException((new StringBuilder()).append("Generated message class \"").append(class1.getName()).append("\" missing method \"").append(s).append("\".").toString(), aclass);
        }
        return aclass;
    }

    protected static MutableMessageLite internalMutableDefault(String s)
    {
        try
        {
            s = (MutableMessageLite)invokeOrDie(getMethodOrDie(Class.forName(s), "getDefaultInstance", new Class[0]), null, new Object[0]);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new UnsupportedOperationException("Cannot load the corresponding mutable class. Please add necessary dependencies.");
        }
        return s;
    }

    static transient Object invokeOrDie(Method method, Object obj, Object aobj[])
    {
        try
        {
            method = ((Method) (method.invoke(obj, aobj)));
        }
        // Misplaced declaration of an exception variable
        catch (Method method)
        {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", method);
        }
        // Misplaced declaration of an exception variable
        catch (Method method)
        {
            method = method.getCause();
            if (method instanceof RuntimeException)
            {
                throw (RuntimeException)method;
            }
            if (method instanceof Error)
            {
                throw (Error)method;
            } else
            {
                throw new RuntimeException("Unexpected exception thrown by generated accessor method.", method);
            }
        }
        return method;
    }

    public static GeneratedExtension newRepeatedGeneratedExtension(MessageLite messagelite, MessageLite messagelite1, Internal.EnumLiteMap enumlitemap, int i, WireFormat.FieldType fieldtype, boolean flag, Class class1)
    {
        return new GeneratedExtension(messagelite, Collections.emptyList(), messagelite1, new ExtensionDescriptor(enumlitemap, i, fieldtype, true, flag), class1);
    }

    public static GeneratedExtension newSingularGeneratedExtension(MessageLite messagelite, Object obj, MessageLite messagelite1, Internal.EnumLiteMap enumlitemap, int i, WireFormat.FieldType fieldtype, Class class1)
    {
        return new GeneratedExtension(messagelite, obj, messagelite1, new ExtensionDescriptor(enumlitemap, i, fieldtype, false, false), class1);
    }

    private static boolean parseUnknownField(FieldSet fieldset, MessageLite messagelite, CodedInputStream codedinputstream, CodedOutputStream codedoutputstream, ExtensionRegistryLite extensionregistrylite, int i)
        throws IOException
    {
        GeneratedExtension generatedextension;
        boolean flag;
        int l = WireFormat.getTagWireType(i);
        generatedextension = extensionregistrylite.findLiteExtensionByNumber(messagelite, WireFormat.getTagFieldNumber(i));
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
            for (; codedinputstream.getBytesUntilLimit() > 0; fieldset.addRepeatedField(generatedextension.descriptor, generatedextension.singularToFieldSetType(messagelite)))
            {
                int j = codedinputstream.readEnum();
                messagelite = generatedextension.descriptor.getEnumType().findValueByNumber(j);
                if (messagelite == null)
                {
                    return true;
                }
            }

        } else
        {
            for (; codedinputstream.getBytesUntilLimit() > 0; fieldset.addRepeatedField(generatedextension.descriptor, messagelite))
            {
                messagelite = ((MessageLite) (FieldSet.readPrimitiveField(codedinputstream, generatedextension.descriptor.getLiteType(), false)));
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
    //                   2 434;
           goto _L3 _L4 _L5
_L3:
        messagelite = ((MessageLite) (FieldSet.readPrimitiveField(codedinputstream, generatedextension.descriptor.getLiteType(), false)));
_L7:
        if (generatedextension.descriptor.isRepeated())
        {
            fieldset.addRepeatedField(generatedextension.descriptor, generatedextension.singularToFieldSetType(messagelite));
        } else
        {
            fieldset.setField(generatedextension.descriptor, generatedextension.singularToFieldSetType(messagelite));
        }
        if (true) goto _L6; else goto _L4
_L4:
        codedoutputstream = null;
        messagelite = codedoutputstream;
        if (!generatedextension.descriptor.isRepeated())
        {
            MessageLite messagelite1 = (MessageLite)fieldset.getField(generatedextension.descriptor);
            messagelite = codedoutputstream;
            if (messagelite1 != null)
            {
                messagelite = messagelite1.toBuilder();
            }
        }
        codedoutputstream = messagelite;
        if (messagelite == null)
        {
            codedoutputstream = generatedextension.getMessageDefaultInstance().newBuilderForType();
        }
        if (generatedextension.descriptor.getLiteType() == WireFormat.FieldType.GROUP)
        {
            codedinputstream.readGroup(generatedextension.getNumber(), codedoutputstream, extensionregistrylite);
        } else
        {
            codedinputstream.readMessage(codedoutputstream, extensionregistrylite);
        }
        messagelite = codedoutputstream.build();
          goto _L7
_L5:
        int k = codedinputstream.readEnum();
        codedinputstream = generatedextension.descriptor.getEnumType().findValueByNumber(k);
        messagelite = codedinputstream;
        if (codedinputstream == null)
        {
            codedoutputstream.writeRawVarint32(i);
            codedoutputstream.writeUInt32NoTag(k);
            return true;
        }
          goto _L7
    }

    public Parser getParserForType()
    {
        throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
    }

    protected MutableMessageLite internalMutableDefault()
    {
        throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
    }

    protected void makeExtensionsImmutable()
    {
    }

    public MutableMessageLite mutableCopy()
    {
        MutableMessageLite mutablemessagelite = internalMutableDefault().newMessageForType();
        if (this == getDefaultInstanceForType())
        {
            return mutablemessagelite;
        } else
        {
            mutablemessagelite.mergeFrom(CodedInputStream.newInstance(toByteArray()));
            return mutablemessagelite;
        }
    }

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

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.protobuf;

import java.io.IOException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

// Referenced classes of package com.google.protobuf:
//            AbstractMessage, UnknownFieldSet, Message, CodedInputStream, 
//            ExtensionRegistryLite, FieldSet, DynamicMessage, CodedOutputStream, 
//            MessageOrBuilder, ProtocolMessageEnum

public abstract class GeneratedMessage extends AbstractMessage
    implements Serializable
{
    public static abstract class Builder extends AbstractMessage.Builder
    {

        private BuilderParent builderParent;
        private boolean isClean;
        private BuilderParentImpl meAsParent;
        private UnknownFieldSet unknownFields;

        private Map getAllFieldsMutable()
        {
            TreeMap treemap = new TreeMap();
            Iterator iterator = internalGetFieldAccessorTable().descriptor.getFields().iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                Descriptors.FieldDescriptor fielddescriptor = (Descriptors.FieldDescriptor)iterator.next();
                if (fielddescriptor.isRepeated())
                {
                    List list = (List)getField(fielddescriptor);
                    if (!list.isEmpty())
                    {
                        treemap.put(fielddescriptor, list);
                    }
                } else
                if (hasField(fielddescriptor))
                {
                    treemap.put(fielddescriptor, getField(fielddescriptor));
                }
            } while (true);
            return treemap;
        }

        public Builder addRepeatedField(Descriptors.FieldDescriptor fielddescriptor, Object obj)
        {
            internalGetFieldAccessorTable().getField(fielddescriptor).addRepeated(this, obj);
            return this;
        }

        public volatile Message.Builder addRepeatedField(Descriptors.FieldDescriptor fielddescriptor, Object obj)
        {
            return addRepeatedField(fielddescriptor, obj);
        }

        public volatile AbstractMessage.Builder clear()
        {
            return clear();
        }

        public Builder clear()
        {
            unknownFields = UnknownFieldSet.getDefaultInstance();
            onChanged();
            return this;
        }

        public volatile Message.Builder clear()
        {
            return clear();
        }

        public volatile MessageLite.Builder clear()
        {
            return clear();
        }

        public Builder clearField(Descriptors.FieldDescriptor fielddescriptor)
        {
            internalGetFieldAccessorTable().getField(fielddescriptor).clear(this);
            return this;
        }

        public volatile Message.Builder clearField(Descriptors.FieldDescriptor fielddescriptor)
        {
            return clearField(fielddescriptor);
        }

        public volatile AbstractMessage.Builder clone()
        {
            return clone();
        }

        public volatile AbstractMessageLite.Builder clone()
        {
            return clone();
        }

        public Builder clone()
        {
            throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
        }

        public volatile Message.Builder clone()
        {
            return clone();
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

        void dispose()
        {
            builderParent = null;
        }

        public Map getAllFields()
        {
            return Collections.unmodifiableMap(getAllFieldsMutable());
        }

        public Descriptors.Descriptor getDescriptorForType()
        {
            return internalGetFieldAccessorTable().descriptor;
        }

        public Object getField(Descriptors.FieldDescriptor fielddescriptor)
        {
            Object obj1 = internalGetFieldAccessorTable().getField(fielddescriptor).get(this);
            Object obj = obj1;
            if (fielddescriptor.isRepeated())
            {
                obj = Collections.unmodifiableList((List)obj1);
            }
            return obj;
        }

        protected BuilderParent getParentForChildren()
        {
            if (meAsParent == null)
            {
                meAsParent = new BuilderParentImpl();
            }
            return meAsParent;
        }

        public Object getRepeatedField(Descriptors.FieldDescriptor fielddescriptor, int i)
        {
            return internalGetFieldAccessorTable().getField(fielddescriptor).getRepeated(this, i);
        }

        public int getRepeatedFieldCount(Descriptors.FieldDescriptor fielddescriptor)
        {
            return internalGetFieldAccessorTable().getField(fielddescriptor).getRepeatedCount(this);
        }

        public final UnknownFieldSet getUnknownFields()
        {
            return unknownFields;
        }

        public boolean hasField(Descriptors.FieldDescriptor fielddescriptor)
        {
            return internalGetFieldAccessorTable().getField(fielddescriptor).has(this);
        }

        protected abstract FieldAccessorTable internalGetFieldAccessorTable();

        protected boolean isClean()
        {
            return isClean;
        }

        public boolean isInitialized()
        {
            Iterator iterator = getDescriptorForType().getFields().iterator();
_L2:
            Object obj;
            do
            {
                if (!iterator.hasNext())
                {
                    break MISSING_BLOCK_LABEL_134;
                }
                obj = (Descriptors.FieldDescriptor)iterator.next();
                if (((Descriptors.FieldDescriptor) (obj)).isRequired() && !hasField(((Descriptors.FieldDescriptor) (obj))))
                {
                    return false;
                }
            } while (((Descriptors.FieldDescriptor) (obj)).getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE);
            if (!((Descriptors.FieldDescriptor) (obj)).isRepeated())
            {
                continue; /* Loop/switch isn't completed */
            }
            obj = ((List)getField(((Descriptors.FieldDescriptor) (obj)))).iterator();
_L4:
            if (!((Iterator) (obj)).hasNext()) goto _L2; else goto _L1
_L1:
            if (((Message)((Iterator) (obj)).next()).isInitialized()) goto _L4; else goto _L3
_L3:
            return false;
            if (!hasField(((Descriptors.FieldDescriptor) (obj))) || ((Message)getField(((Descriptors.FieldDescriptor) (obj)))).isInitialized()) goto _L2; else goto _L5
_L5:
            return false;
            return true;
        }

        protected void markClean()
        {
            isClean = true;
        }

        public volatile AbstractMessage.Builder mergeUnknownFields(UnknownFieldSet unknownfieldset)
        {
            return mergeUnknownFields(unknownfieldset);
        }

        public final Builder mergeUnknownFields(UnknownFieldSet unknownfieldset)
        {
            unknownFields = UnknownFieldSet.newBuilder(unknownFields).mergeFrom(unknownfieldset).build();
            onChanged();
            return this;
        }

        public volatile Message.Builder mergeUnknownFields(UnknownFieldSet unknownfieldset)
        {
            return mergeUnknownFields(unknownfieldset);
        }

        public Message.Builder newBuilderForField(Descriptors.FieldDescriptor fielddescriptor)
        {
            return internalGetFieldAccessorTable().getField(fielddescriptor).newBuilder();
        }

        protected void onBuilt()
        {
            if (builderParent != null)
            {
                markClean();
            }
        }

        protected final void onChanged()
        {
            if (isClean && builderParent != null)
            {
                builderParent.markDirty();
                isClean = false;
            }
        }

        protected boolean parseUnknownField(CodedInputStream codedinputstream, UnknownFieldSet.Builder builder, ExtensionRegistryLite extensionregistrylite, int i)
            throws IOException
        {
            return builder.mergeFieldFrom(i, codedinputstream);
        }

        public Builder setField(Descriptors.FieldDescriptor fielddescriptor, Object obj)
        {
            internalGetFieldAccessorTable().getField(fielddescriptor).set(this, obj);
            return this;
        }

        public volatile Message.Builder setField(Descriptors.FieldDescriptor fielddescriptor, Object obj)
        {
            return setField(fielddescriptor, obj);
        }

        public Builder setRepeatedField(Descriptors.FieldDescriptor fielddescriptor, int i, Object obj)
        {
            internalGetFieldAccessorTable().getField(fielddescriptor).setRepeated(this, i, obj);
            return this;
        }

        public volatile Message.Builder setRepeatedField(Descriptors.FieldDescriptor fielddescriptor, int i, Object obj)
        {
            return setRepeatedField(fielddescriptor, i, obj);
        }

        public final Builder setUnknownFields(UnknownFieldSet unknownfieldset)
        {
            unknownFields = unknownfieldset;
            onChanged();
            return this;
        }

        public volatile Message.Builder setUnknownFields(UnknownFieldSet unknownfieldset)
        {
            return setUnknownFields(unknownfieldset);
        }


        protected Builder()
        {
            this(null);
        }

        protected Builder(BuilderParent builderparent)
        {
            unknownFields = UnknownFieldSet.getDefaultInstance();
            builderParent = builderparent;
        }
    }

    private class Builder.BuilderParentImpl
        implements BuilderParent
    {

        final Builder this$0;

        public void markDirty()
        {
            onChanged();
        }

        private Builder.BuilderParentImpl()
        {
            this$0 = Builder.this;
            super();
        }

    }

    protected static interface BuilderParent
    {

        public abstract void markDirty();
    }

    public static abstract class ExtendableBuilder extends Builder
        implements ExtendableMessageOrBuilder
    {

        private FieldSet extensions;

        private FieldSet buildExtensions()
        {
            extensions.makeImmutable();
            return extensions;
        }

        private void ensureExtensionsIsMutable()
        {
            if (extensions.isImmutable())
            {
                extensions = extensions.clone();
            }
        }

        private void verifyContainingType(Descriptors.FieldDescriptor fielddescriptor)
        {
            if (fielddescriptor.getContainingType() != getDescriptorForType())
            {
                throw new IllegalArgumentException("FieldDescriptor does not match message type.");
            } else
            {
                return;
            }
        }

        public volatile Builder addRepeatedField(Descriptors.FieldDescriptor fielddescriptor, Object obj)
        {
            return addRepeatedField(fielddescriptor, obj);
        }

        public ExtendableBuilder addRepeatedField(Descriptors.FieldDescriptor fielddescriptor, Object obj)
        {
            if (fielddescriptor.isExtension())
            {
                verifyContainingType(fielddescriptor);
                ensureExtensionsIsMutable();
                extensions.addRepeatedField(fielddescriptor, obj);
                onChanged();
                return this;
            } else
            {
                return (ExtendableBuilder)super.addRepeatedField(fielddescriptor, obj);
            }
        }

        public volatile Message.Builder addRepeatedField(Descriptors.FieldDescriptor fielddescriptor, Object obj)
        {
            return addRepeatedField(fielddescriptor, obj);
        }

        public volatile AbstractMessage.Builder clear()
        {
            return clear();
        }

        public volatile Builder clear()
        {
            return clear();
        }

        public ExtendableBuilder clear()
        {
            extensions = FieldSet.emptySet();
            return (ExtendableBuilder)super.clear();
        }

        public volatile Message.Builder clear()
        {
            return clear();
        }

        public volatile MessageLite.Builder clear()
        {
            return clear();
        }

        public volatile Builder clearField(Descriptors.FieldDescriptor fielddescriptor)
        {
            return clearField(fielddescriptor);
        }

        public ExtendableBuilder clearField(Descriptors.FieldDescriptor fielddescriptor)
        {
            if (fielddescriptor.isExtension())
            {
                verifyContainingType(fielddescriptor);
                ensureExtensionsIsMutable();
                extensions.clearField(fielddescriptor);
                onChanged();
                return this;
            } else
            {
                return (ExtendableBuilder)super.clearField(fielddescriptor);
            }
        }

        public volatile Message.Builder clearField(Descriptors.FieldDescriptor fielddescriptor)
        {
            return clearField(fielddescriptor);
        }

        public volatile AbstractMessage.Builder clone()
        {
            return clone();
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

        public volatile Message.Builder clone()
        {
            return clone();
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

        public Map getAllFields()
        {
            Map map = ((Builder)this).getAllFieldsMutable();
            map.putAll(extensions.getAllFields());
            return Collections.unmodifiableMap(map);
        }

        public Object getField(Descriptors.FieldDescriptor fielddescriptor)
        {
label0:
            {
label1:
                {
                    if (!fielddescriptor.isExtension())
                    {
                        break label0;
                    }
                    verifyContainingType(fielddescriptor);
                    Object obj1 = extensions.getField(fielddescriptor);
                    Object obj = obj1;
                    if (obj1 == null)
                    {
                        if (fielddescriptor.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE)
                        {
                            break label1;
                        }
                        obj = DynamicMessage.getDefaultInstance(fielddescriptor.getMessageType());
                    }
                    return obj;
                }
                return fielddescriptor.getDefaultValue();
            }
            return super.getField(fielddescriptor);
        }

        public Object getRepeatedField(Descriptors.FieldDescriptor fielddescriptor, int i)
        {
            if (fielddescriptor.isExtension())
            {
                verifyContainingType(fielddescriptor);
                return extensions.getRepeatedField(fielddescriptor, i);
            } else
            {
                return super.getRepeatedField(fielddescriptor, i);
            }
        }

        public int getRepeatedFieldCount(Descriptors.FieldDescriptor fielddescriptor)
        {
            if (fielddescriptor.isExtension())
            {
                verifyContainingType(fielddescriptor);
                return extensions.getRepeatedFieldCount(fielddescriptor);
            } else
            {
                return super.getRepeatedFieldCount(fielddescriptor);
            }
        }

        public boolean hasField(Descriptors.FieldDescriptor fielddescriptor)
        {
            if (fielddescriptor.isExtension())
            {
                verifyContainingType(fielddescriptor);
                return extensions.hasField(fielddescriptor);
            } else
            {
                return super.hasField(fielddescriptor);
            }
        }

        public boolean isInitialized()
        {
            return super.isInitialized() && extensionsAreInitialized();
        }

        protected final void mergeExtensionFields(ExtendableMessage extendablemessage)
        {
            ensureExtensionsIsMutable();
            extensions.mergeFrom(extendablemessage.extensions);
            onChanged();
        }

        protected boolean parseUnknownField(CodedInputStream codedinputstream, UnknownFieldSet.Builder builder, ExtensionRegistryLite extensionregistrylite, int i)
            throws IOException
        {
            return AbstractMessage.Builder.mergeFieldFrom(codedinputstream, builder, extensionregistrylite, this, i);
        }

        public volatile Builder setField(Descriptors.FieldDescriptor fielddescriptor, Object obj)
        {
            return setField(fielddescriptor, obj);
        }

        public ExtendableBuilder setField(Descriptors.FieldDescriptor fielddescriptor, Object obj)
        {
            if (fielddescriptor.isExtension())
            {
                verifyContainingType(fielddescriptor);
                ensureExtensionsIsMutable();
                extensions.setField(fielddescriptor, obj);
                onChanged();
                return this;
            } else
            {
                return (ExtendableBuilder)super.setField(fielddescriptor, obj);
            }
        }

        public volatile Message.Builder setField(Descriptors.FieldDescriptor fielddescriptor, Object obj)
        {
            return setField(fielddescriptor, obj);
        }

        public volatile Builder setRepeatedField(Descriptors.FieldDescriptor fielddescriptor, int i, Object obj)
        {
            return setRepeatedField(fielddescriptor, i, obj);
        }

        public ExtendableBuilder setRepeatedField(Descriptors.FieldDescriptor fielddescriptor, int i, Object obj)
        {
            if (fielddescriptor.isExtension())
            {
                verifyContainingType(fielddescriptor);
                ensureExtensionsIsMutable();
                extensions.setRepeatedField(fielddescriptor, i, obj);
                onChanged();
                return this;
            } else
            {
                return (ExtendableBuilder)super.setRepeatedField(fielddescriptor, i, obj);
            }
        }

        public volatile Message.Builder setRepeatedField(Descriptors.FieldDescriptor fielddescriptor, int i, Object obj)
        {
            return setRepeatedField(fielddescriptor, i, obj);
        }


        protected ExtendableBuilder()
        {
            extensions = FieldSet.emptySet();
        }

        protected ExtendableBuilder(BuilderParent builderparent)
        {
            super(builderparent);
            extensions = FieldSet.emptySet();
        }
    }

    public static abstract class ExtendableMessage extends GeneratedMessage
        implements ExtendableMessageOrBuilder
    {

        private final FieldSet extensions;

        private void verifyContainingType(Descriptors.FieldDescriptor fielddescriptor)
        {
            if (fielddescriptor.getContainingType() != getDescriptorForType())
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
            Map map = getAllFieldsMutable();
            map.putAll(getExtensionFields());
            return Collections.unmodifiableMap(map);
        }

        protected Map getExtensionFields()
        {
            return extensions.getAllFields();
        }

        public Object getField(Descriptors.FieldDescriptor fielddescriptor)
        {
label0:
            {
label1:
                {
                    if (!fielddescriptor.isExtension())
                    {
                        break label0;
                    }
                    verifyContainingType(fielddescriptor);
                    Object obj1 = extensions.getField(fielddescriptor);
                    Object obj = obj1;
                    if (obj1 == null)
                    {
                        if (fielddescriptor.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE)
                        {
                            break label1;
                        }
                        obj = DynamicMessage.getDefaultInstance(fielddescriptor.getMessageType());
                    }
                    return obj;
                }
                return fielddescriptor.getDefaultValue();
            }
            return getField(fielddescriptor);
        }

        public Object getRepeatedField(Descriptors.FieldDescriptor fielddescriptor, int i)
        {
            if (fielddescriptor.isExtension())
            {
                verifyContainingType(fielddescriptor);
                return extensions.getRepeatedField(fielddescriptor, i);
            } else
            {
                return getRepeatedField(fielddescriptor, i);
            }
        }

        public int getRepeatedFieldCount(Descriptors.FieldDescriptor fielddescriptor)
        {
            if (fielddescriptor.isExtension())
            {
                verifyContainingType(fielddescriptor);
                return extensions.getRepeatedFieldCount(fielddescriptor);
            } else
            {
                return getRepeatedFieldCount(fielddescriptor);
            }
        }

        public boolean hasField(Descriptors.FieldDescriptor fielddescriptor)
        {
            if (fielddescriptor.isExtension())
            {
                verifyContainingType(fielddescriptor);
                return extensions.hasField(fielddescriptor);
            } else
            {
                return hasField(fielddescriptor);
            }
        }

        public boolean isInitialized()
        {
            return isInitialized() && extensionsAreInitialized();
        }

        protected ExtensionWriter newExtensionWriter()
        {
            return new ExtensionWriter(false);
        }


        protected ExtendableMessage()
        {
            extensions = FieldSet.newFieldSet();
        }

        protected ExtendableMessage(ExtendableBuilder extendablebuilder)
        {
            super(extendablebuilder);
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
        extends MessageOrBuilder
    {
    }

    private static interface ExtensionDescriptorRetriever
    {
    }

    public static final class FieldAccessorTable
    {

        private final Descriptors.Descriptor descriptor;
        private final FieldAccessor fields[];

        private FieldAccessor getField(Descriptors.FieldDescriptor fielddescriptor)
        {
            if (fielddescriptor.getContainingType() != descriptor)
            {
                throw new IllegalArgumentException("FieldDescriptor does not match message type.");
            }
            if (fielddescriptor.isExtension())
            {
                throw new IllegalArgumentException("This type does not have extensions.");
            } else
            {
                return fields[fielddescriptor.getIndex()];
            }
        }



        public FieldAccessorTable(Descriptors.Descriptor descriptor1, String as[], Class class1, Class class2)
        {
            descriptor = descriptor1;
            fields = new FieldAccessor[descriptor1.getFields().size()];
            int i = 0;
            while (i < fields.length) 
            {
                Descriptors.FieldDescriptor fielddescriptor = (Descriptors.FieldDescriptor)descriptor1.getFields().get(i);
                if (fielddescriptor.isRepeated())
                {
                    if (fielddescriptor.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE)
                    {
                        fields[i] = new RepeatedMessageFieldAccessor(fielddescriptor, as[i], class1, class2);
                    } else
                    if (fielddescriptor.getJavaType() == Descriptors.FieldDescriptor.JavaType.ENUM)
                    {
                        fields[i] = new RepeatedEnumFieldAccessor(fielddescriptor, as[i], class1, class2);
                    } else
                    {
                        fields[i] = new RepeatedFieldAccessor(fielddescriptor, as[i], class1, class2);
                    }
                } else
                if (fielddescriptor.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE)
                {
                    fields[i] = new SingularMessageFieldAccessor(fielddescriptor, as[i], class1, class2);
                } else
                if (fielddescriptor.getJavaType() == Descriptors.FieldDescriptor.JavaType.ENUM)
                {
                    fields[i] = new SingularEnumFieldAccessor(fielddescriptor, as[i], class1, class2);
                } else
                {
                    fields[i] = new SingularFieldAccessor(fielddescriptor, as[i], class1, class2);
                }
                i++;
            }
        }
    }

    private static interface FieldAccessorTable.FieldAccessor
    {

        public abstract void addRepeated(Builder builder, Object obj);

        public abstract void clear(Builder builder);

        public abstract Object get(Builder builder);

        public abstract Object get(GeneratedMessage generatedmessage);

        public abstract Object getRepeated(Builder builder, int i);

        public abstract Object getRepeated(GeneratedMessage generatedmessage, int i);

        public abstract int getRepeatedCount(Builder builder);

        public abstract int getRepeatedCount(GeneratedMessage generatedmessage);

        public abstract boolean has(Builder builder);

        public abstract boolean has(GeneratedMessage generatedmessage);

        public abstract Message.Builder newBuilder();

        public abstract void set(Builder builder, Object obj);

        public abstract void setRepeated(Builder builder, int i, Object obj);
    }

    private static final class FieldAccessorTable.RepeatedEnumFieldAccessor extends FieldAccessorTable.RepeatedFieldAccessor
    {

        private final Method getValueDescriptorMethod;
        private final Method valueOfMethod;

        public void addRepeated(Builder builder, Object obj)
        {
            super.addRepeated(builder, GeneratedMessage.invokeOrDie(valueOfMethod, null, new Object[] {
                obj
            }));
        }

        public Object get(Builder builder)
        {
            ArrayList arraylist = new ArrayList();
            Object obj;
            for (builder = ((List)super.get(builder)).iterator(); builder.hasNext(); arraylist.add(GeneratedMessage.invokeOrDie(getValueDescriptorMethod, obj, new Object[0])))
            {
                obj = builder.next();
            }

            return Collections.unmodifiableList(arraylist);
        }

        public Object get(GeneratedMessage generatedmessage)
        {
            ArrayList arraylist = new ArrayList();
            Object obj;
            for (generatedmessage = ((List)super.get(generatedmessage)).iterator(); generatedmessage.hasNext(); arraylist.add(GeneratedMessage.invokeOrDie(getValueDescriptorMethod, obj, new Object[0])))
            {
                obj = generatedmessage.next();
            }

            return Collections.unmodifiableList(arraylist);
        }

        public Object getRepeated(Builder builder, int i)
        {
            return GeneratedMessage.invokeOrDie(getValueDescriptorMethod, getRepeated(builder, i), new Object[0]);
        }

        public Object getRepeated(GeneratedMessage generatedmessage, int i)
        {
            return GeneratedMessage.invokeOrDie(getValueDescriptorMethod, getRepeated(generatedmessage, i), new Object[0]);
        }

        public void setRepeated(Builder builder, int i, Object obj)
        {
            super.setRepeated(builder, i, GeneratedMessage.invokeOrDie(valueOfMethod, null, new Object[] {
                obj
            }));
        }

        FieldAccessorTable.RepeatedEnumFieldAccessor(Descriptors.FieldDescriptor fielddescriptor, String s, Class class1, Class class2)
        {
            super(fielddescriptor, s, class1, class2);
            valueOfMethod = GeneratedMessage.getMethodOrDie(type, "valueOf", new Class[] {
                com/google/protobuf/Descriptors$EnumValueDescriptor
            });
            getValueDescriptorMethod = GeneratedMessage.getMethodOrDie(type, "getValueDescriptor", new Class[0]);
        }
    }

    private static class FieldAccessorTable.RepeatedFieldAccessor
        implements FieldAccessorTable.FieldAccessor
    {

        protected final Method addRepeatedMethod;
        protected final Method clearMethod;
        protected final Method getCountMethod;
        protected final Method getCountMethodBuilder;
        protected final Method getMethod;
        protected final Method getMethodBuilder;
        protected final Method getRepeatedMethod;
        protected final Method getRepeatedMethodBuilder;
        protected final Method setRepeatedMethod;
        protected final Class type;

        public void addRepeated(Builder builder, Object obj)
        {
            GeneratedMessage.invokeOrDie(addRepeatedMethod, builder, new Object[] {
                obj
            });
        }

        public void clear(Builder builder)
        {
            GeneratedMessage.invokeOrDie(clearMethod, builder, new Object[0]);
        }

        public Object get(Builder builder)
        {
            return GeneratedMessage.invokeOrDie(getMethodBuilder, builder, new Object[0]);
        }

        public Object get(GeneratedMessage generatedmessage)
        {
            return GeneratedMessage.invokeOrDie(getMethod, generatedmessage, new Object[0]);
        }

        public Object getRepeated(Builder builder, int i)
        {
            return GeneratedMessage.invokeOrDie(getRepeatedMethodBuilder, builder, new Object[] {
                Integer.valueOf(i)
            });
        }

        public Object getRepeated(GeneratedMessage generatedmessage, int i)
        {
            return GeneratedMessage.invokeOrDie(getRepeatedMethod, generatedmessage, new Object[] {
                Integer.valueOf(i)
            });
        }

        public int getRepeatedCount(Builder builder)
        {
            return ((Integer)GeneratedMessage.invokeOrDie(getCountMethodBuilder, builder, new Object[0])).intValue();
        }

        public int getRepeatedCount(GeneratedMessage generatedmessage)
        {
            return ((Integer)GeneratedMessage.invokeOrDie(getCountMethod, generatedmessage, new Object[0])).intValue();
        }

        public boolean has(Builder builder)
        {
            throw new UnsupportedOperationException("hasField() called on a singular field.");
        }

        public boolean has(GeneratedMessage generatedmessage)
        {
            throw new UnsupportedOperationException("hasField() called on a singular field.");
        }

        public Message.Builder newBuilder()
        {
            throw new UnsupportedOperationException("newBuilderForField() called on a non-Message type.");
        }

        public void set(Builder builder, Object obj)
        {
            clear(builder);
            for (obj = ((List)obj).iterator(); ((Iterator) (obj)).hasNext(); addRepeated(builder, ((Iterator) (obj)).next())) { }
        }

        public void setRepeated(Builder builder, int i, Object obj)
        {
            GeneratedMessage.invokeOrDie(setRepeatedMethod, builder, new Object[] {
                Integer.valueOf(i), obj
            });
        }

        FieldAccessorTable.RepeatedFieldAccessor(Descriptors.FieldDescriptor fielddescriptor, String s, Class class1, Class class2)
        {
            getMethod = GeneratedMessage.getMethodOrDie(class1, (new StringBuilder()).append("get").append(s).append("List").toString(), new Class[0]);
            getMethodBuilder = GeneratedMessage.getMethodOrDie(class2, (new StringBuilder()).append("get").append(s).append("List").toString(), new Class[0]);
            getRepeatedMethod = GeneratedMessage.getMethodOrDie(class1, (new StringBuilder()).append("get").append(s).toString(), new Class[] {
                Integer.TYPE
            });
            getRepeatedMethodBuilder = GeneratedMessage.getMethodOrDie(class2, (new StringBuilder()).append("get").append(s).toString(), new Class[] {
                Integer.TYPE
            });
            type = getRepeatedMethod.getReturnType();
            setRepeatedMethod = GeneratedMessage.getMethodOrDie(class2, (new StringBuilder()).append("set").append(s).toString(), new Class[] {
                Integer.TYPE, type
            });
            addRepeatedMethod = GeneratedMessage.getMethodOrDie(class2, (new StringBuilder()).append("add").append(s).toString(), new Class[] {
                type
            });
            getCountMethod = GeneratedMessage.getMethodOrDie(class1, (new StringBuilder()).append("get").append(s).append("Count").toString(), new Class[0]);
            getCountMethodBuilder = GeneratedMessage.getMethodOrDie(class2, (new StringBuilder()).append("get").append(s).append("Count").toString(), new Class[0]);
            clearMethod = GeneratedMessage.getMethodOrDie(class2, (new StringBuilder()).append("clear").append(s).toString(), new Class[0]);
        }
    }

    private static final class FieldAccessorTable.RepeatedMessageFieldAccessor extends FieldAccessorTable.RepeatedFieldAccessor
    {

        private final Method newBuilderMethod;

        private Object coerceType(Object obj)
        {
            if (type.isInstance(obj))
            {
                return obj;
            } else
            {
                return ((Message.Builder)GeneratedMessage.invokeOrDie(newBuilderMethod, null, new Object[0])).mergeFrom((Message)obj).build();
            }
        }

        public void addRepeated(Builder builder, Object obj)
        {
            super.addRepeated(builder, coerceType(obj));
        }

        public Message.Builder newBuilder()
        {
            return (Message.Builder)GeneratedMessage.invokeOrDie(newBuilderMethod, null, new Object[0]);
        }

        public void setRepeated(Builder builder, int i, Object obj)
        {
            super.setRepeated(builder, i, coerceType(obj));
        }

        FieldAccessorTable.RepeatedMessageFieldAccessor(Descriptors.FieldDescriptor fielddescriptor, String s, Class class1, Class class2)
        {
            super(fielddescriptor, s, class1, class2);
            newBuilderMethod = GeneratedMessage.getMethodOrDie(type, "newBuilder", new Class[0]);
        }
    }

    private static final class FieldAccessorTable.SingularEnumFieldAccessor extends FieldAccessorTable.SingularFieldAccessor
    {

        private Method getValueDescriptorMethod;
        private Method valueOfMethod;

        public Object get(Builder builder)
        {
            return GeneratedMessage.invokeOrDie(getValueDescriptorMethod, get(builder), new Object[0]);
        }

        public Object get(GeneratedMessage generatedmessage)
        {
            return GeneratedMessage.invokeOrDie(getValueDescriptorMethod, get(generatedmessage), new Object[0]);
        }

        public void set(Builder builder, Object obj)
        {
            super.set(builder, GeneratedMessage.invokeOrDie(valueOfMethod, null, new Object[] {
                obj
            }));
        }

        FieldAccessorTable.SingularEnumFieldAccessor(Descriptors.FieldDescriptor fielddescriptor, String s, Class class1, Class class2)
        {
            super(fielddescriptor, s, class1, class2);
            valueOfMethod = GeneratedMessage.getMethodOrDie(type, "valueOf", new Class[] {
                com/google/protobuf/Descriptors$EnumValueDescriptor
            });
            getValueDescriptorMethod = GeneratedMessage.getMethodOrDie(type, "getValueDescriptor", new Class[0]);
        }
    }

    private static class FieldAccessorTable.SingularFieldAccessor
        implements FieldAccessorTable.FieldAccessor
    {

        protected final Method clearMethod;
        protected final Method getMethod;
        protected final Method getMethodBuilder;
        protected final Method hasMethod;
        protected final Method hasMethodBuilder;
        protected final Method setMethod;
        protected final Class type;

        public void addRepeated(Builder builder, Object obj)
        {
            throw new UnsupportedOperationException("addRepeatedField() called on a singular field.");
        }

        public void clear(Builder builder)
        {
            GeneratedMessage.invokeOrDie(clearMethod, builder, new Object[0]);
        }

        public Object get(Builder builder)
        {
            return GeneratedMessage.invokeOrDie(getMethodBuilder, builder, new Object[0]);
        }

        public Object get(GeneratedMessage generatedmessage)
        {
            return GeneratedMessage.invokeOrDie(getMethod, generatedmessage, new Object[0]);
        }

        public Object getRepeated(Builder builder, int i)
        {
            throw new UnsupportedOperationException("getRepeatedField() called on a singular field.");
        }

        public Object getRepeated(GeneratedMessage generatedmessage, int i)
        {
            throw new UnsupportedOperationException("getRepeatedField() called on a singular field.");
        }

        public int getRepeatedCount(Builder builder)
        {
            throw new UnsupportedOperationException("getRepeatedFieldSize() called on a singular field.");
        }

        public int getRepeatedCount(GeneratedMessage generatedmessage)
        {
            throw new UnsupportedOperationException("getRepeatedFieldSize() called on a singular field.");
        }

        public boolean has(Builder builder)
        {
            return ((Boolean)GeneratedMessage.invokeOrDie(hasMethodBuilder, builder, new Object[0])).booleanValue();
        }

        public boolean has(GeneratedMessage generatedmessage)
        {
            return ((Boolean)GeneratedMessage.invokeOrDie(hasMethod, generatedmessage, new Object[0])).booleanValue();
        }

        public Message.Builder newBuilder()
        {
            throw new UnsupportedOperationException("newBuilderForField() called on a non-Message type.");
        }

        public void set(Builder builder, Object obj)
        {
            GeneratedMessage.invokeOrDie(setMethod, builder, new Object[] {
                obj
            });
        }

        public void setRepeated(Builder builder, int i, Object obj)
        {
            throw new UnsupportedOperationException("setRepeatedField() called on a singular field.");
        }

        FieldAccessorTable.SingularFieldAccessor(Descriptors.FieldDescriptor fielddescriptor, String s, Class class1, Class class2)
        {
            getMethod = GeneratedMessage.getMethodOrDie(class1, (new StringBuilder()).append("get").append(s).toString(), new Class[0]);
            getMethodBuilder = GeneratedMessage.getMethodOrDie(class2, (new StringBuilder()).append("get").append(s).toString(), new Class[0]);
            type = getMethod.getReturnType();
            setMethod = GeneratedMessage.getMethodOrDie(class2, (new StringBuilder()).append("set").append(s).toString(), new Class[] {
                type
            });
            hasMethod = GeneratedMessage.getMethodOrDie(class1, (new StringBuilder()).append("has").append(s).toString(), new Class[0]);
            hasMethodBuilder = GeneratedMessage.getMethodOrDie(class2, (new StringBuilder()).append("has").append(s).toString(), new Class[0]);
            clearMethod = GeneratedMessage.getMethodOrDie(class2, (new StringBuilder()).append("clear").append(s).toString(), new Class[0]);
        }
    }

    private static final class FieldAccessorTable.SingularMessageFieldAccessor extends FieldAccessorTable.SingularFieldAccessor
    {

        private final Method newBuilderMethod;

        private Object coerceType(Object obj)
        {
            if (type.isInstance(obj))
            {
                return obj;
            } else
            {
                return ((Message.Builder)GeneratedMessage.invokeOrDie(newBuilderMethod, null, new Object[0])).mergeFrom((Message)obj).build();
            }
        }

        public Message.Builder newBuilder()
        {
            return (Message.Builder)GeneratedMessage.invokeOrDie(newBuilderMethod, null, new Object[0]);
        }

        public void set(Builder builder, Object obj)
        {
            super.set(builder, coerceType(obj));
        }

        FieldAccessorTable.SingularMessageFieldAccessor(Descriptors.FieldDescriptor fielddescriptor, String s, Class class1, Class class2)
        {
            super(fielddescriptor, s, class1, class2);
            newBuilderMethod = GeneratedMessage.getMethodOrDie(type, "newBuilder", new Class[0]);
        }
    }

    public static final class GeneratedExtension
    {

        private ExtensionDescriptorRetriever descriptorRetriever;
        private final Method enumGetValueDescriptor;
        private final Method enumValueOf;
        private final Message messageDefaultInstance;
        private final Class singularType;

        private GeneratedExtension(ExtensionDescriptorRetriever extensiondescriptorretriever, Class class1, Message message)
        {
            if (com/google/protobuf/Message.isAssignableFrom(class1) && !class1.isInstance(message))
            {
                throw new IllegalArgumentException((new StringBuilder()).append("Bad messageDefaultInstance for ").append(class1.getName()).toString());
            }
            descriptorRetriever = extensiondescriptorretriever;
            singularType = class1;
            messageDefaultInstance = message;
            if (com/google/protobuf/ProtocolMessageEnum.isAssignableFrom(class1))
            {
                enumValueOf = GeneratedMessage.getMethodOrDie(class1, "valueOf", new Class[] {
                    com/google/protobuf/Descriptors$EnumValueDescriptor
                });
                enumGetValueDescriptor = GeneratedMessage.getMethodOrDie(class1, "getValueDescriptor", new Class[0]);
                return;
            } else
            {
                enumValueOf = null;
                enumGetValueDescriptor = null;
                return;
            }
        }

    }


    protected static boolean alwaysUseFieldBuilders = false;
    private static final long serialVersionUID = 1L;
    private final UnknownFieldSet unknownFields;

    protected GeneratedMessage()
    {
        unknownFields = UnknownFieldSet.getDefaultInstance();
    }

    protected GeneratedMessage(Builder builder)
    {
        unknownFields = builder.getUnknownFields();
    }

    static void enableAlwaysUseFieldBuildersForTesting()
    {
        alwaysUseFieldBuilders = true;
    }

    private Map getAllFieldsMutable()
    {
        TreeMap treemap = new TreeMap();
        Iterator iterator = internalGetFieldAccessorTable().descriptor.getFields().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Descriptors.FieldDescriptor fielddescriptor = (Descriptors.FieldDescriptor)iterator.next();
            if (fielddescriptor.isRepeated())
            {
                List list = (List)getField(fielddescriptor);
                if (!list.isEmpty())
                {
                    treemap.put(fielddescriptor, list);
                }
            } else
            if (hasField(fielddescriptor))
            {
                treemap.put(fielddescriptor, getField(fielddescriptor));
            }
        } while (true);
        return treemap;
    }

    private static transient Method getMethodOrDie(Class class1, String s, Class aclass[])
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

    private static transient Object invokeOrDie(Method method, Object obj, Object aobj[])
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

    public static GeneratedExtension newFileScopedGeneratedExtension(Class class1, Message message)
    {
        return new GeneratedExtension(null, class1, message);
    }

    public static GeneratedExtension newMessageScopedGeneratedExtension(Message message, int i, Class class1, Message message1)
    {
        return new GeneratedExtension(new ExtensionDescriptorRetriever(message, i) {

            final int val$descriptorIndex;
            final Message val$scope;

            
            {
                scope = message;
                descriptorIndex = i;
                super();
            }
        }, class1, message1);
    }

    public Map getAllFields()
    {
        return Collections.unmodifiableMap(getAllFieldsMutable());
    }

    public Descriptors.Descriptor getDescriptorForType()
    {
        return internalGetFieldAccessorTable().descriptor;
    }

    public Object getField(Descriptors.FieldDescriptor fielddescriptor)
    {
        return internalGetFieldAccessorTable().getField(fielddescriptor).get(this);
    }

    public Object getRepeatedField(Descriptors.FieldDescriptor fielddescriptor, int i)
    {
        return internalGetFieldAccessorTable().getField(fielddescriptor).getRepeated(this, i);
    }

    public int getRepeatedFieldCount(Descriptors.FieldDescriptor fielddescriptor)
    {
        return internalGetFieldAccessorTable().getField(fielddescriptor).getRepeatedCount(this);
    }

    public final UnknownFieldSet getUnknownFields()
    {
        return unknownFields;
    }

    public boolean hasField(Descriptors.FieldDescriptor fielddescriptor)
    {
        return internalGetFieldAccessorTable().getField(fielddescriptor).has(this);
    }

    protected abstract FieldAccessorTable internalGetFieldAccessorTable();

    public boolean isInitialized()
    {
        Iterator iterator = getDescriptorForType().getFields().iterator();
_L2:
        Object obj;
        do
        {
            if (!iterator.hasNext())
            {
                break MISSING_BLOCK_LABEL_134;
            }
            obj = (Descriptors.FieldDescriptor)iterator.next();
            if (((Descriptors.FieldDescriptor) (obj)).isRequired() && !hasField(((Descriptors.FieldDescriptor) (obj))))
            {
                return false;
            }
        } while (((Descriptors.FieldDescriptor) (obj)).getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE);
        if (!((Descriptors.FieldDescriptor) (obj)).isRepeated())
        {
            continue; /* Loop/switch isn't completed */
        }
        obj = ((List)getField(((Descriptors.FieldDescriptor) (obj)))).iterator();
_L4:
        if (!((Iterator) (obj)).hasNext()) goto _L2; else goto _L1
_L1:
        if (((Message)((Iterator) (obj)).next()).isInitialized()) goto _L4; else goto _L3
_L3:
        return false;
        if (!hasField(((Descriptors.FieldDescriptor) (obj))) || ((Message)getField(((Descriptors.FieldDescriptor) (obj)))).isInitialized()) goto _L2; else goto _L5
_L5:
        return false;
        return true;
    }

    protected abstract Message.Builder newBuilderForType(BuilderParent builderparent);

    protected Object writeReplace()
        throws ObjectStreamException
    {
        return new GeneratedMessageLite.SerializedForm(this);
    }

    static 
    {
        alwaysUseFieldBuilders = false;
    }



}

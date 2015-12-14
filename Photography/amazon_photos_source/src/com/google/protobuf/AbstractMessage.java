// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.protobuf;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.google.protobuf:
//            AbstractMessageLite, Message, UnknownFieldSet, CodedOutputStream, 
//            FieldSet, TextFormat, UninitializedMessageException, CodedInputStream, 
//            MessageOrBuilder, WireFormat, ExtensionRegistry, ExtensionRegistryLite, 
//            Parser, LazyField, InvalidProtocolBufferException, ByteString

public abstract class AbstractMessage extends AbstractMessageLite
    implements Message
{
    public static abstract class Builder extends AbstractMessageLite.Builder
        implements Message.Builder
    {

        private static void addRepeatedField(Message.Builder builder, FieldSet fieldset, Descriptors.FieldDescriptor fielddescriptor, Object obj)
        {
            if (builder != null)
            {
                builder.addRepeatedField(fielddescriptor, obj);
                return;
            } else
            {
                fieldset.addRepeatedField(fielddescriptor, obj);
                return;
            }
        }

        private static void eagerlyMergeMessageSetExtension(CodedInputStream codedinputstream, ExtensionRegistry.ExtensionInfo extensioninfo, ExtensionRegistryLite extensionregistrylite, Message.Builder builder, FieldSet fieldset)
            throws IOException
        {
            Descriptors.FieldDescriptor fielddescriptor = extensioninfo.descriptor;
            if (hasOriginalMessage(builder, fieldset, fielddescriptor))
            {
                extensioninfo = getOriginalMessage(builder, fieldset, fielddescriptor).toBuilder();
                codedinputstream.readMessage(extensioninfo, extensionregistrylite);
                codedinputstream = extensioninfo.buildPartial();
            } else
            {
                codedinputstream = (Message)codedinputstream.readMessage(extensioninfo.defaultInstance.getParserForType(), extensionregistrylite);
            }
            if (builder != null)
            {
                builder.setField(fielddescriptor, codedinputstream);
                return;
            } else
            {
                fieldset.setField(fielddescriptor, codedinputstream);
                return;
            }
        }

        private static List findMissingFields(MessageOrBuilder messageorbuilder)
        {
            ArrayList arraylist = new ArrayList();
            findMissingFields(messageorbuilder, "", ((List) (arraylist)));
            return arraylist;
        }

        private static void findMissingFields(MessageOrBuilder messageorbuilder, String s, List list)
        {
            Iterator iterator = messageorbuilder.getDescriptorForType().getFields().iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                Descriptors.FieldDescriptor fielddescriptor = (Descriptors.FieldDescriptor)iterator.next();
                if (fielddescriptor.isRequired() && !messageorbuilder.hasField(fielddescriptor))
                {
                    list.add((new StringBuilder()).append(s).append(fielddescriptor.getName()).toString());
                }
            } while (true);
            iterator = messageorbuilder.getAllFields().entrySet().iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                Object obj = (java.util.Map.Entry)iterator.next();
                Descriptors.FieldDescriptor fielddescriptor1 = (Descriptors.FieldDescriptor)((java.util.Map.Entry) (obj)).getKey();
                obj = ((java.util.Map.Entry) (obj)).getValue();
                if (fielddescriptor1.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE)
                {
                    if (fielddescriptor1.isRepeated())
                    {
                        int i = 0;
                        obj = ((List)obj).iterator();
                        while (((Iterator) (obj)).hasNext()) 
                        {
                            findMissingFields((MessageOrBuilder)((Iterator) (obj)).next(), subMessagePrefix(s, fielddescriptor1, i), list);
                            i++;
                        }
                    } else
                    if (messageorbuilder.hasField(fielddescriptor1))
                    {
                        findMissingFields((MessageOrBuilder)obj, subMessagePrefix(s, fielddescriptor1, -1), list);
                    }
                }
            } while (true);
        }

        private static Message getOriginalMessage(Message.Builder builder, FieldSet fieldset, Descriptors.FieldDescriptor fielddescriptor)
        {
            if (builder != null)
            {
                return (Message)builder.getField(fielddescriptor);
            } else
            {
                return (Message)fieldset.getField(fielddescriptor);
            }
        }

        private static boolean hasOriginalMessage(Message.Builder builder, FieldSet fieldset, Descriptors.FieldDescriptor fielddescriptor)
        {
            if (builder != null)
            {
                return builder.hasField(fielddescriptor);
            } else
            {
                return fieldset.hasField(fielddescriptor);
            }
        }

        static boolean mergeFieldFrom(CodedInputStream codedinputstream, UnknownFieldSet.Builder builder, ExtensionRegistryLite extensionregistrylite, Descriptors.Descriptor descriptor, Message.Builder builder1, FieldSet fieldset, int i)
            throws IOException
        {
            Object obj;
            Object obj1;
            int j;
            boolean flag;
            int l;
            obj = null;
            obj1 = null;
            flag = false;
            if (descriptor.getOptions().getMessageSetWireFormat() && i == WireFormat.MESSAGE_SET_ITEM_TAG)
            {
                mergeMessageSetExtensionFromCodedStream(codedinputstream, builder, extensionregistrylite, descriptor, builder1, fieldset);
                return true;
            }
            j = WireFormat.getTagWireType(i);
            l = WireFormat.getTagFieldNumber(i);
            if (!descriptor.isExtensionNumber(l))
            {
                break MISSING_BLOCK_LABEL_202;
            }
            if (!(extensionregistrylite instanceof ExtensionRegistry)) goto _L2; else goto _L1
_L1:
            descriptor = ((ExtensionRegistry)extensionregistrylite).findExtensionByNumber(descriptor, l);
            if (descriptor != null) goto _L4; else goto _L3
_L3:
            descriptor = null;
            obj = obj1;
_L6:
            Descriptors.Descriptor descriptor1 = descriptor;
            descriptor = ((Descriptors.Descriptor) (obj));
            obj = descriptor1;
_L8:
            Descriptors.FieldDescriptor fielddescriptor;
            Message message;
            if (descriptor == null)
            {
                j = 0;
                flag = true;
            } else
            if (j == FieldSet.getWireFormatForFieldType(descriptor.getLiteType(), false))
            {
                j = 0;
            } else
            if (descriptor.isPackable() && j == FieldSet.getWireFormatForFieldType(descriptor.getLiteType(), true))
            {
                j = 1;
            } else
            {
                j = 0;
                flag = true;
            }
            if (flag)
            {
                return builder.mergeFieldFrom(i, codedinputstream);
            }
            break MISSING_BLOCK_LABEL_276;
_L4:
            fielddescriptor = ((ExtensionRegistry.ExtensionInfo) (descriptor)).descriptor;
            message = ((ExtensionRegistry.ExtensionInfo) (descriptor)).defaultInstance;
            descriptor = message;
            obj = fielddescriptor;
            if (message != null) goto _L6; else goto _L5
_L5:
            descriptor = message;
            obj = fielddescriptor;
            if (fielddescriptor.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE) goto _L6; else goto _L7
_L7:
            throw new IllegalStateException((new StringBuilder()).append("Message-typed extension lacked default instance: ").append(fielddescriptor.getFullName()).toString());
_L2:
            descriptor = null;
              goto _L8
            if (builder1 != null)
            {
                descriptor = descriptor.findFieldByNumber(l);
            } else
            {
                descriptor = null;
            }
              goto _L8
            if (j == 0) goto _L10; else goto _L9
_L9:
            i = codedinputstream.pushLimit(codedinputstream.readRawVarint32());
            if (descriptor.getLiteType() == WireFormat.FieldType.ENUM)
            {
                for (; codedinputstream.getBytesUntilLimit() > 0; addRepeatedField(builder1, fieldset, descriptor, builder))
                {
                    int k = codedinputstream.readEnum();
                    builder = descriptor.getEnumType().findValueByNumber(k);
                    if (builder == null)
                    {
                        return true;
                    }
                }

            } else
            {
                for (; codedinputstream.getBytesUntilLimit() > 0; addRepeatedField(builder1, fieldset, descriptor, FieldSet.readPrimitiveField(codedinputstream, descriptor.getLiteType()))) { }
            }
            codedinputstream.popLimit(i);
_L15:
            return true;
_L10:
            static class _cls1
            {

                static final int $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[];

                static 
                {
                    $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type = new int[Descriptors.FieldDescriptor.Type.values().length];
                    try
                    {
                        $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.GROUP.ordinal()] = 1;
                    }
                    catch (NoSuchFieldError nosuchfielderror2) { }
                    try
                    {
                        $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.MESSAGE.ordinal()] = 2;
                    }
                    catch (NoSuchFieldError nosuchfielderror1) { }
                    try
                    {
                        $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.ENUM.ordinal()] = 3;
                    }
                    catch (NoSuchFieldError nosuchfielderror)
                    {
                        return;
                    }
                }
            }

            _cls1..SwitchMap.com.google.protobuf.Descriptors.FieldDescriptor.Type[descriptor.getType().ordinal()];
            JVM INSTR tableswitch 1 3: default 412
        //                       1 440
        //                       2 501
        //                       3 558;
               goto _L11 _L12 _L13 _L14
_L11:
            codedinputstream = ((CodedInputStream) (FieldSet.readPrimitiveField(codedinputstream, descriptor.getLiteType())));
_L16:
            if (descriptor.isRepeated())
            {
                addRepeatedField(builder1, fieldset, descriptor, codedinputstream);
            } else
            {
                setField(builder1, fieldset, descriptor, codedinputstream);
            }
            if (true) goto _L15; else goto _L12
_L12:
            if (obj != null)
            {
                builder = ((Message) (obj)).newBuilderForType();
            } else
            {
                builder = builder1.newBuilderForField(descriptor);
            }
            if (!descriptor.isRepeated())
            {
                mergeOriginalMessage(builder1, fieldset, descriptor, builder);
            }
            codedinputstream.readGroup(descriptor.getNumber(), builder, extensionregistrylite);
            codedinputstream = builder.buildPartial();
              goto _L16
_L13:
            if (obj != null)
            {
                builder = ((Message) (obj)).newBuilderForType();
            } else
            {
                builder = builder1.newBuilderForField(descriptor);
            }
            if (!descriptor.isRepeated())
            {
                mergeOriginalMessage(builder1, fieldset, descriptor, builder);
            }
            codedinputstream.readMessage(builder, extensionregistrylite);
            codedinputstream = builder.buildPartial();
              goto _L16
_L14:
            i = codedinputstream.readEnum();
            extensionregistrylite = descriptor.getEnumType().findValueByNumber(i);
            codedinputstream = extensionregistrylite;
            if (extensionregistrylite == null)
            {
                builder.mergeVarintField(l, i);
                return true;
            }
              goto _L16
        }

        private static void mergeMessageSetExtensionFromBytes(ByteString bytestring, ExtensionRegistry.ExtensionInfo extensioninfo, ExtensionRegistryLite extensionregistrylite, Message.Builder builder, FieldSet fieldset)
            throws IOException
        {
            Descriptors.FieldDescriptor fielddescriptor = extensioninfo.descriptor;
            boolean flag = hasOriginalMessage(builder, fieldset, fielddescriptor);
            if (flag || ExtensionRegistryLite.isEagerlyParseMessageSets())
            {
                if (flag)
                {
                    extensioninfo = getOriginalMessage(builder, fieldset, fielddescriptor).toBuilder();
                    extensioninfo.mergeFrom(bytestring, extensionregistrylite);
                    bytestring = extensioninfo.buildPartial();
                } else
                {
                    bytestring = (Message)extensioninfo.defaultInstance.getParserForType().parsePartialFrom(bytestring, extensionregistrylite);
                }
                setField(builder, fieldset, fielddescriptor, bytestring);
                return;
            }
            bytestring = new LazyField(extensioninfo.defaultInstance, extensionregistrylite, bytestring);
            if (builder != null)
            {
                if (builder instanceof GeneratedMessage.ExtendableBuilder)
                {
                    builder.setField(fielddescriptor, bytestring);
                    return;
                } else
                {
                    builder.setField(fielddescriptor, bytestring.getValue());
                    return;
                }
            } else
            {
                fieldset.setField(fielddescriptor, bytestring);
                return;
            }
        }

        private static void mergeMessageSetExtensionFromCodedStream(CodedInputStream codedinputstream, UnknownFieldSet.Builder builder, ExtensionRegistryLite extensionregistrylite, Descriptors.Descriptor descriptor, Message.Builder builder1, FieldSet fieldset)
            throws IOException
        {
            ByteString bytestring;
            ExtensionRegistry.ExtensionInfo extensioninfo;
            int i;
            i = 0;
            extensioninfo = null;
            bytestring = null;
_L7:
            int j = codedinputstream.readTag();
            if (j != 0) goto _L2; else goto _L1
_L1:
            codedinputstream.checkLastTagWas(WireFormat.MESSAGE_SET_ITEM_END_TAG);
            if (bytestring == null || i == 0) goto _L4; else goto _L3
_L3:
            if (extensioninfo == null) goto _L6; else goto _L5
_L5:
            mergeMessageSetExtensionFromBytes(bytestring, extensioninfo, extensionregistrylite, builder1, fieldset);
_L4:
            return;
_L2:
            if (j == WireFormat.MESSAGE_SET_TYPE_ID_TAG)
            {
                j = codedinputstream.readUInt32();
                i = j;
                if (j == 0)
                {
                    break; /* Loop/switch isn't completed */
                }
                i = j;
                if (!(extensionregistrylite instanceof ExtensionRegistry))
                {
                    break; /* Loop/switch isn't completed */
                }
                extensioninfo = ((ExtensionRegistry)extensionregistrylite).findExtensionByNumber(descriptor, j);
                i = j;
                break; /* Loop/switch isn't completed */
            }
            if (j != WireFormat.MESSAGE_SET_MESSAGE_TAG)
            {
                continue; /* Loop/switch isn't completed */
            }
            if (i != 0 && extensioninfo != null && ExtensionRegistryLite.isEagerlyParseMessageSets())
            {
                eagerlyMergeMessageSetExtension(codedinputstream, extensioninfo, extensionregistrylite, builder1, fieldset);
                bytestring = null;
            } else
            {
                bytestring = codedinputstream.readBytes();
            }
            break; /* Loop/switch isn't completed */
            if (codedinputstream.skipField(j)) goto _L7; else goto _L1
_L6:
            if (bytestring == null) goto _L4; else goto _L8
_L8:
            builder.mergeField(i, UnknownFieldSet.Field.newBuilder().addLengthDelimited(bytestring).build());
            return;
            if (true) goto _L7; else goto _L9
_L9:
        }

        private static void mergeOriginalMessage(Message.Builder builder, FieldSet fieldset, Descriptors.FieldDescriptor fielddescriptor, Message.Builder builder1)
        {
            builder = getOriginalMessage(builder, fieldset, fielddescriptor);
            if (builder != null)
            {
                builder1.mergeFrom(builder);
            }
        }

        protected static UninitializedMessageException newUninitializedMessageException(Message message)
        {
            return new UninitializedMessageException(findMissingFields(message));
        }

        private static void setField(Message.Builder builder, FieldSet fieldset, Descriptors.FieldDescriptor fielddescriptor, Object obj)
        {
            if (builder != null)
            {
                builder.setField(fielddescriptor, obj);
                return;
            } else
            {
                fieldset.setField(fielddescriptor, obj);
                return;
            }
        }

        private static String subMessagePrefix(String s, Descriptors.FieldDescriptor fielddescriptor, int i)
        {
            s = new StringBuilder(s);
            if (fielddescriptor.isExtension())
            {
                s.append('(').append(fielddescriptor.getFullName()).append(')');
            } else
            {
                s.append(fielddescriptor.getName());
            }
            if (i != -1)
            {
                s.append('[').append(i).append(']');
            }
            s.append('.');
            return s.toString();
        }

        public abstract Builder clone();

        public volatile AbstractMessageLite.Builder clone()
        {
            return clone();
        }

        public volatile Object clone()
            throws CloneNotSupportedException
        {
            return clone();
        }

        public Builder mergeFrom(ByteString bytestring, ExtensionRegistryLite extensionregistrylite)
            throws InvalidProtocolBufferException
        {
            return (Builder)super.mergeFrom(bytestring, extensionregistrylite);
        }

        public Builder mergeFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException
        {
            UnknownFieldSet.Builder builder = UnknownFieldSet.newBuilder(getUnknownFields());
            do
            {
                int i = codedinputstream.readTag();
                while (i == 0 || !mergeFieldFrom(codedinputstream, builder, extensionregistrylite, getDescriptorForType(), this, null, i)) 
                {
                    setUnknownFields(builder.build());
                    return this;
                }
            } while (true);
        }

        public Builder mergeFrom(Message message)
        {
            if (message.getDescriptorForType() != getDescriptorForType())
            {
                throw new IllegalArgumentException("mergeFrom(Message) can only merge messages of the same type.");
            }
            for (Iterator iterator = message.getAllFields().entrySet().iterator(); iterator.hasNext();)
            {
                Object obj = (java.util.Map.Entry)iterator.next();
                Descriptors.FieldDescriptor fielddescriptor = (Descriptors.FieldDescriptor)((java.util.Map.Entry) (obj)).getKey();
                if (fielddescriptor.isRepeated())
                {
                    obj = ((List)((java.util.Map.Entry) (obj)).getValue()).iterator();
                    while (((Iterator) (obj)).hasNext()) 
                    {
                        addRepeatedField(fielddescriptor, ((Iterator) (obj)).next());
                    }
                } else
                if (fielddescriptor.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE)
                {
                    Message message1 = (Message)getField(fielddescriptor);
                    if (message1 == message1.getDefaultInstanceForType())
                    {
                        setField(fielddescriptor, ((java.util.Map.Entry) (obj)).getValue());
                    } else
                    {
                        setField(fielddescriptor, message1.newBuilderForType().mergeFrom(message1).mergeFrom((Message)((java.util.Map.Entry) (obj)).getValue()).build());
                    }
                } else
                {
                    setField(fielddescriptor, ((java.util.Map.Entry) (obj)).getValue());
                }
            }

            mergeUnknownFields(message.getUnknownFields());
            return this;
        }

        public volatile AbstractMessageLite.Builder mergeFrom(ByteString bytestring, ExtensionRegistryLite extensionregistrylite)
            throws InvalidProtocolBufferException
        {
            return mergeFrom(bytestring, extensionregistrylite);
        }

        public volatile AbstractMessageLite.Builder mergeFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException
        {
            return mergeFrom(codedinputstream, extensionregistrylite);
        }

        public volatile Message.Builder mergeFrom(ByteString bytestring, ExtensionRegistryLite extensionregistrylite)
            throws InvalidProtocolBufferException
        {
            return mergeFrom(bytestring, extensionregistrylite);
        }

        public volatile Message.Builder mergeFrom(Message message)
        {
            return mergeFrom(message);
        }

        public volatile MessageLite.Builder mergeFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException
        {
            return mergeFrom(codedinputstream, extensionregistrylite);
        }

        public Builder mergeUnknownFields(UnknownFieldSet unknownfieldset)
        {
            setUnknownFields(UnknownFieldSet.newBuilder(getUnknownFields()).mergeFrom(unknownfieldset).build());
            return this;
        }

        public Builder()
        {
        }
    }


    private int memoizedSize;

    public AbstractMessage()
    {
        memoizedSize = -1;
    }

    protected static int hashEnum(Internal.EnumLite enumlite)
    {
        return enumlite.getNumber();
    }

    protected static int hashEnumList(List list)
    {
        list = list.iterator();
        int i;
        for (i = 1; list.hasNext(); i = hashEnum((Internal.EnumLite)list.next()) + i * 31) { }
        return i;
    }

    public boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (!(obj instanceof Message))
            {
                return false;
            }
            obj = (Message)obj;
            if (getDescriptorForType() != ((Message) (obj)).getDescriptorForType())
            {
                return false;
            }
            if (!getAllFields().equals(((Message) (obj)).getAllFields()) || !getUnknownFields().equals(((Message) (obj)).getUnknownFields()))
            {
                return false;
            }
        }
        return true;
    }

    public int getSerializedSize()
    {
        int i = memoizedSize;
        if (i != -1)
        {
            return i;
        }
        boolean flag = getDescriptorForType().getOptions().getMessageSetWireFormat();
        Object obj = getAllFields().entrySet().iterator();
        i = 0;
        while (((Iterator) (obj)).hasNext()) 
        {
            Object obj1 = (java.util.Map.Entry)((Iterator) (obj)).next();
            Descriptors.FieldDescriptor fielddescriptor = (Descriptors.FieldDescriptor)((java.util.Map.Entry) (obj1)).getKey();
            obj1 = ((java.util.Map.Entry) (obj1)).getValue();
            if (flag && fielddescriptor.isExtension() && fielddescriptor.getType() == Descriptors.FieldDescriptor.Type.MESSAGE && !fielddescriptor.isRepeated())
            {
                i = CodedOutputStream.computeMessageSetExtensionSize(fielddescriptor.getNumber(), (Message)obj1) + i;
            } else
            {
                i = FieldSet.computeFieldSize(fielddescriptor, obj1) + i;
            }
        }
        obj = getUnknownFields();
        if (flag)
        {
            i = ((UnknownFieldSet) (obj)).getSerializedSizeAsMessageSet() + i;
        } else
        {
            i = ((UnknownFieldSet) (obj)).getSerializedSize() + i;
        }
        memoizedSize = i;
        return i;
    }

    public int hashCode()
    {
        return hashFields(getDescriptorForType().hashCode() + 779, getAllFields()) * 29 + getUnknownFields().hashCode();
    }

    protected int hashFields(int i, Map map)
    {
        for (map = map.entrySet().iterator(); map.hasNext();)
        {
            Object obj = (java.util.Map.Entry)map.next();
            Descriptors.FieldDescriptor fielddescriptor = (Descriptors.FieldDescriptor)((java.util.Map.Entry) (obj)).getKey();
            obj = ((java.util.Map.Entry) (obj)).getValue();
            i = i * 37 + fielddescriptor.getNumber();
            if (fielddescriptor.getType() != Descriptors.FieldDescriptor.Type.ENUM)
            {
                i = i * 53 + obj.hashCode();
            } else
            if (fielddescriptor.isRepeated())
            {
                i = i * 53 + hashEnumList((List)obj);
            } else
            {
                i = i * 53 + hashEnum((Internal.EnumLite)obj);
            }
        }

        return i;
    }

    public boolean isInitialized()
    {
        Iterator iterator1;
        for (Iterator iterator = getDescriptorForType().getFields().iterator(); iterator.hasNext();)
        {
            Descriptors.FieldDescriptor fielddescriptor = (Descriptors.FieldDescriptor)iterator.next();
            if (fielddescriptor.isRequired() && !hasField(fielddescriptor))
            {
                return false;
            }
        }

        iterator1 = getAllFields().entrySet().iterator();
_L2:
        Object obj;
        Descriptors.FieldDescriptor fielddescriptor1;
        do
        {
            if (!iterator1.hasNext())
            {
                break MISSING_BLOCK_LABEL_172;
            }
            obj = (java.util.Map.Entry)iterator1.next();
            fielddescriptor1 = (Descriptors.FieldDescriptor)((java.util.Map.Entry) (obj)).getKey();
        } while (fielddescriptor1.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE);
        if (!fielddescriptor1.isRepeated())
        {
            continue; /* Loop/switch isn't completed */
        }
        obj = ((List)((java.util.Map.Entry) (obj)).getValue()).iterator();
_L4:
        if (!((Iterator) (obj)).hasNext()) goto _L2; else goto _L1
_L1:
        if (((Message)((Iterator) (obj)).next()).isInitialized()) goto _L4; else goto _L3
_L3:
        return false;
        if (((Message)((java.util.Map.Entry) (obj)).getValue()).isInitialized()) goto _L2; else goto _L5
_L5:
        return false;
        return true;
    }

    UninitializedMessageException newUninitializedMessageException()
    {
        return Builder.newUninitializedMessageException(this);
    }

    public final String toString()
    {
        return TextFormat.printToString(this);
    }

    public void writeTo(CodedOutputStream codedoutputstream)
        throws IOException
    {
        boolean flag = getDescriptorForType().getOptions().getMessageSetWireFormat();
        for (Iterator iterator = getAllFields().entrySet().iterator(); iterator.hasNext();)
        {
            Object obj = (java.util.Map.Entry)iterator.next();
            Descriptors.FieldDescriptor fielddescriptor = (Descriptors.FieldDescriptor)((java.util.Map.Entry) (obj)).getKey();
            obj = ((java.util.Map.Entry) (obj)).getValue();
            if (flag && fielddescriptor.isExtension() && fielddescriptor.getType() == Descriptors.FieldDescriptor.Type.MESSAGE && !fielddescriptor.isRepeated())
            {
                codedoutputstream.writeMessageSetExtension(fielddescriptor.getNumber(), (Message)obj);
            } else
            {
                FieldSet.writeField(fielddescriptor, obj, codedoutputstream);
            }
        }

        UnknownFieldSet unknownfieldset = getUnknownFields();
        if (flag)
        {
            unknownfieldset.writeAsMessageSetTo(codedoutputstream);
            return;
        } else
        {
            unknownfieldset.writeTo(codedoutputstream);
            return;
        }
    }
}

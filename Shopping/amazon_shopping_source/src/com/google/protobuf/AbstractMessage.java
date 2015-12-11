// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.google.protobuf:
//            AbstractMessageLite, Message, UnknownFieldSet, CodedOutputStream, 
//            FieldSet, TextFormat, WireFormat, ExtensionRegistry, 
//            CodedInputStream, ByteString, UninitializedMessageException, InvalidProtocolBufferException, 
//            ExtensionRegistryLite

public abstract class AbstractMessage extends AbstractMessageLite
    implements Message
{
    public static abstract class Builder extends AbstractMessageLite.Builder
        implements Message.Builder
    {

        private static List findMissingFields(Message message)
        {
            ArrayList arraylist = new ArrayList();
            findMissingFields(message, "", ((List) (arraylist)));
            return arraylist;
        }

        private static void findMissingFields(Message message, String s, List list)
        {
            Iterator iterator = message.getDescriptorForType().getFields().iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                Descriptors.FieldDescriptor fielddescriptor = (Descriptors.FieldDescriptor)iterator.next();
                if (fielddescriptor.isRequired() && !message.hasField(fielddescriptor))
                {
                    list.add((new StringBuilder()).append(s).append(fielddescriptor.getName()).toString());
                }
            } while (true);
            iterator = message.getAllFields().entrySet().iterator();
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
                            findMissingFields((Message)((Iterator) (obj)).next(), subMessagePrefix(s, fielddescriptor1, i), list);
                            i++;
                        }
                    } else
                    if (message.hasField(fielddescriptor1))
                    {
                        findMissingFields((Message)obj, subMessagePrefix(s, fielddescriptor1, -1), list);
                    }
                }
            } while (true);
        }

        static boolean mergeFieldFrom(CodedInputStream codedinputstream, UnknownFieldSet.Builder builder, ExtensionRegistryLite extensionregistrylite, Message.Builder builder1, int i)
            throws IOException
        {
            Object obj;
            Object obj1;
            Object obj2;
            int j;
            boolean flag;
            int l;
            obj = null;
            obj1 = null;
            flag = false;
            obj2 = builder1.getDescriptorForType();
            if (((Descriptors.Descriptor) (obj2)).getOptions().getMessageSetWireFormat() && i == WireFormat.MESSAGE_SET_ITEM_TAG)
            {
                mergeMessageSetExtensionFromCodedStream(codedinputstream, builder, extensionregistrylite, builder1);
                return true;
            }
            j = WireFormat.getTagWireType(i);
            l = WireFormat.getTagFieldNumber(i);
            if (!((Descriptors.Descriptor) (obj2)).isExtensionNumber(l))
            {
                break MISSING_BLOCK_LABEL_224;
            }
            if (!(extensionregistrylite instanceof ExtensionRegistry)) goto _L2; else goto _L1
_L1:
            obj = ((ExtensionRegistry)extensionregistrylite).findExtensionByNumber(((Descriptors.Descriptor) (obj2)), l);
            if (obj != null) goto _L4; else goto _L3
_L3:
            obj = null;
_L6:
            obj2 = obj;
            obj = obj1;
            obj1 = obj2;
_L8:
            Message message;
            if (obj == null)
            {
                j = 0;
                flag = true;
            } else
            if (j == FieldSet.getWireFormatForFieldType(((Descriptors.FieldDescriptor) (obj)).getLiteType(), false))
            {
                j = 0;
            } else
            if (((Descriptors.FieldDescriptor) (obj)).isPackable() && j == FieldSet.getWireFormatForFieldType(((Descriptors.FieldDescriptor) (obj)).getLiteType(), true))
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
            break MISSING_BLOCK_LABEL_301;
_L4:
            obj2 = ((ExtensionRegistry.ExtensionInfo) (obj)).descriptor;
            message = ((ExtensionRegistry.ExtensionInfo) (obj)).defaultInstance;
            obj = message;
            obj1 = obj2;
            if (message != null) goto _L6; else goto _L5
_L5:
            obj = message;
            obj1 = obj2;
            if (((Descriptors.FieldDescriptor) (obj2)).getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE) goto _L6; else goto _L7
_L7:
            throw new IllegalStateException((new StringBuilder()).append("Message-typed extension lacked default instance: ").append(((Descriptors.FieldDescriptor) (obj2)).getFullName()).toString());
_L2:
            obj2 = null;
            obj1 = obj;
            obj = obj2;
              goto _L8
            obj2 = ((Descriptors.Descriptor) (obj2)).findFieldByNumber(l);
            obj1 = obj;
            obj = obj2;
              goto _L8
            if (j == 0) goto _L10; else goto _L9
_L9:
            i = codedinputstream.pushLimit(codedinputstream.readRawVarint32());
            if (((Descriptors.FieldDescriptor) (obj)).getLiteType() == WireFormat.FieldType.ENUM)
            {
                for (; codedinputstream.getBytesUntilLimit() > 0; builder1.addRepeatedField(((Descriptors.FieldDescriptor) (obj)), builder))
                {
                    int k = codedinputstream.readEnum();
                    builder = ((Descriptors.FieldDescriptor) (obj)).getEnumType().findValueByNumber(k);
                    if (builder == null)
                    {
                        return true;
                    }
                }

            } else
            {
                for (; codedinputstream.getBytesUntilLimit() > 0; builder1.addRepeatedField(((Descriptors.FieldDescriptor) (obj)), FieldSet.readPrimitiveField(codedinputstream, ((Descriptors.FieldDescriptor) (obj)).getLiteType()))) { }
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

            _cls1..SwitchMap.com.google.protobuf.Descriptors.FieldDescriptor.Type[((Descriptors.FieldDescriptor) (obj)).getType().ordinal()];
            JVM INSTR tableswitch 1 3: default 444
        //                       1 475
        //                       2 547
        //                       3 614;
               goto _L11 _L12 _L13 _L14
_L11:
            codedinputstream = ((CodedInputStream) (FieldSet.readPrimitiveField(codedinputstream, ((Descriptors.FieldDescriptor) (obj)).getLiteType())));
_L16:
            if (((Descriptors.FieldDescriptor) (obj)).isRepeated())
            {
                builder1.addRepeatedField(((Descriptors.FieldDescriptor) (obj)), codedinputstream);
            } else
            {
                builder1.setField(((Descriptors.FieldDescriptor) (obj)), codedinputstream);
            }
            if (true) goto _L15; else goto _L12
_L12:
            if (obj1 != null)
            {
                builder = ((Message) (obj1)).newBuilderForType();
            } else
            {
                builder = builder1.newBuilderForField(((Descriptors.FieldDescriptor) (obj)));
            }
            if (!((Descriptors.FieldDescriptor) (obj)).isRepeated())
            {
                builder.mergeFrom((Message)builder1.getField(((Descriptors.FieldDescriptor) (obj))));
            }
            codedinputstream.readGroup(((Descriptors.FieldDescriptor) (obj)).getNumber(), builder, extensionregistrylite);
            codedinputstream = builder.build();
              goto _L16
_L13:
            if (obj1 != null)
            {
                builder = ((Message) (obj1)).newBuilderForType();
            } else
            {
                builder = builder1.newBuilderForField(((Descriptors.FieldDescriptor) (obj)));
            }
            if (!((Descriptors.FieldDescriptor) (obj)).isRepeated())
            {
                builder.mergeFrom((Message)builder1.getField(((Descriptors.FieldDescriptor) (obj))));
            }
            codedinputstream.readMessage(builder, extensionregistrylite);
            codedinputstream = builder.build();
              goto _L16
_L14:
            i = codedinputstream.readEnum();
            extensionregistrylite = ((Descriptors.FieldDescriptor) (obj)).getEnumType().findValueByNumber(i);
            codedinputstream = extensionregistrylite;
            if (extensionregistrylite == null)
            {
                builder.mergeVarintField(l, i);
                return true;
            }
              goto _L16
        }

        private static void mergeMessageSetExtensionFromCodedStream(CodedInputStream codedinputstream, UnknownFieldSet.Builder builder, ExtensionRegistryLite extensionregistrylite, Message.Builder builder1)
            throws IOException
        {
            Object obj;
            Object obj1;
            Object obj2;
            Descriptors.Descriptor descriptor;
            int i;
            descriptor = builder1.getDescriptorForType();
            i = 0;
            obj1 = null;
            obj = null;
            obj2 = null;
_L3:
            int j = codedinputstream.readTag();
            if (j != 0) goto _L2; else goto _L1
_L1:
            codedinputstream.checkLastTagWas(WireFormat.MESSAGE_SET_ITEM_END_TAG);
            if (obj != null)
            {
                builder1.setField(((Descriptors.FieldDescriptor) (obj1)), ((Message.Builder) (obj)).build());
            }
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
                Object obj3;
                if (extensionregistrylite instanceof ExtensionRegistry)
                {
                    obj3 = ((ExtensionRegistry)extensionregistrylite).findExtensionByNumber(descriptor, j);
                } else
                {
                    obj3 = null;
                }
                if (obj3 != null)
                {
                    obj1 = ((ExtensionRegistry.ExtensionInfo) (obj3)).descriptor;
                    Message.Builder builder2 = ((ExtensionRegistry.ExtensionInfo) (obj3)).defaultInstance.newBuilderForType();
                    obj = (Message)builder1.getField(((Descriptors.FieldDescriptor) (obj1)));
                    if (obj != null)
                    {
                        builder2.mergeFrom(((Message) (obj)));
                    }
                    obj = obj2;
                    if (obj2 != null)
                    {
                        builder2.mergeFrom(CodedInputStream.newInstance(((ByteString) (obj2)).newInput()));
                        obj = null;
                    }
                    obj3 = obj1;
                    obj1 = builder2;
                    obj2 = obj;
                    obj = obj3;
                } else
                if (obj2 != null)
                {
                    builder.mergeField(j, UnknownFieldSet.Field.newBuilder().addLengthDelimited(((ByteString) (obj2))).build());
                    obj2 = obj;
                    obj3 = null;
                    obj = obj1;
                    obj1 = obj2;
                    obj2 = obj3;
                } else
                {
                    Object obj4 = obj;
                    obj = obj1;
                    obj1 = obj4;
                }
                i = j;
            } else
            {
                if (j != WireFormat.MESSAGE_SET_MESSAGE_TAG)
                {
                    continue; /* Loop/switch isn't completed */
                }
                if (i == 0)
                {
                    obj2 = codedinputstream.readBytes();
                    obj3 = obj;
                    obj = obj1;
                    obj1 = obj3;
                } else
                if (obj == null)
                {
                    builder.mergeField(i, UnknownFieldSet.Field.newBuilder().addLengthDelimited(codedinputstream.readBytes()).build());
                    obj3 = obj;
                    obj = obj1;
                    obj1 = obj3;
                } else
                {
                    codedinputstream.readMessage(((MessageLite.Builder) (obj)), extensionregistrylite);
                    obj3 = obj;
                    obj = obj1;
                    obj1 = obj3;
                }
            }
            obj3 = obj1;
            obj1 = obj;
            obj = obj3;
              goto _L3
            if (!codedinputstream.skipField(j)) goto _L1; else goto _L4
_L4:
            obj3 = obj;
            obj = obj1;
            obj1 = obj3;
            break MISSING_BLOCK_LABEL_203;
        }

        protected static UninitializedMessageException newUninitializedMessageException(Message message)
        {
            return new UninitializedMessageException(findMissingFields(message));
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

        public Builder clear()
        {
            for (Iterator iterator = getAllFields().entrySet().iterator(); iterator.hasNext(); clearField((Descriptors.FieldDescriptor)((java.util.Map.Entry)iterator.next()).getKey())) { }
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

        public abstract Builder clone();

        public volatile AbstractMessageLite.Builder clone()
        {
            return clone();
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

        public boolean mergeDelimitedFrom(InputStream inputstream)
            throws IOException
        {
            return super.mergeDelimitedFrom(inputstream);
        }

        public boolean mergeDelimitedFrom(InputStream inputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException
        {
            return super.mergeDelimitedFrom(inputstream, extensionregistrylite);
        }

        public Builder mergeFrom(ByteString bytestring)
            throws InvalidProtocolBufferException
        {
            return (Builder)super.mergeFrom(bytestring);
        }

        public Builder mergeFrom(ByteString bytestring, ExtensionRegistryLite extensionregistrylite)
            throws InvalidProtocolBufferException
        {
            return (Builder)super.mergeFrom(bytestring, extensionregistrylite);
        }

        public Builder mergeFrom(CodedInputStream codedinputstream)
            throws IOException
        {
            return mergeFrom(codedinputstream, ((ExtensionRegistryLite) (ExtensionRegistry.getEmptyRegistry())));
        }

        public Builder mergeFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException
        {
            UnknownFieldSet.Builder builder = UnknownFieldSet.newBuilder(getUnknownFields());
            do
            {
                int i = codedinputstream.readTag();
                while (i == 0 || !mergeFieldFrom(codedinputstream, builder, extensionregistrylite, this, i)) 
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

        public Builder mergeFrom(InputStream inputstream)
            throws IOException
        {
            return (Builder)super.mergeFrom(inputstream);
        }

        public Builder mergeFrom(InputStream inputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException
        {
            return (Builder)super.mergeFrom(inputstream, extensionregistrylite);
        }

        public Builder mergeFrom(byte abyte0[])
            throws InvalidProtocolBufferException
        {
            return (Builder)super.mergeFrom(abyte0);
        }

        public Builder mergeFrom(byte abyte0[], int i, int j)
            throws InvalidProtocolBufferException
        {
            return (Builder)super.mergeFrom(abyte0, i, j);
        }

        public Builder mergeFrom(byte abyte0[], int i, int j, ExtensionRegistryLite extensionregistrylite)
            throws InvalidProtocolBufferException
        {
            return (Builder)super.mergeFrom(abyte0, i, j, extensionregistrylite);
        }

        public Builder mergeFrom(byte abyte0[], ExtensionRegistryLite extensionregistrylite)
            throws InvalidProtocolBufferException
        {
            return (Builder)super.mergeFrom(abyte0, extensionregistrylite);
        }

        public volatile AbstractMessageLite.Builder mergeFrom(ByteString bytestring)
            throws InvalidProtocolBufferException
        {
            return mergeFrom(bytestring);
        }

        public volatile AbstractMessageLite.Builder mergeFrom(ByteString bytestring, ExtensionRegistryLite extensionregistrylite)
            throws InvalidProtocolBufferException
        {
            return mergeFrom(bytestring, extensionregistrylite);
        }

        public volatile AbstractMessageLite.Builder mergeFrom(CodedInputStream codedinputstream)
            throws IOException
        {
            return mergeFrom(codedinputstream);
        }

        public volatile AbstractMessageLite.Builder mergeFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException
        {
            return mergeFrom(codedinputstream, extensionregistrylite);
        }

        public volatile AbstractMessageLite.Builder mergeFrom(InputStream inputstream)
            throws IOException
        {
            return mergeFrom(inputstream);
        }

        public volatile AbstractMessageLite.Builder mergeFrom(InputStream inputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException
        {
            return mergeFrom(inputstream, extensionregistrylite);
        }

        public volatile AbstractMessageLite.Builder mergeFrom(byte abyte0[])
            throws InvalidProtocolBufferException
        {
            return mergeFrom(abyte0);
        }

        public volatile AbstractMessageLite.Builder mergeFrom(byte abyte0[], int i, int j)
            throws InvalidProtocolBufferException
        {
            return mergeFrom(abyte0, i, j);
        }

        public volatile AbstractMessageLite.Builder mergeFrom(byte abyte0[], int i, int j, ExtensionRegistryLite extensionregistrylite)
            throws InvalidProtocolBufferException
        {
            return mergeFrom(abyte0, i, j, extensionregistrylite);
        }

        public volatile AbstractMessageLite.Builder mergeFrom(byte abyte0[], ExtensionRegistryLite extensionregistrylite)
            throws InvalidProtocolBufferException
        {
            return mergeFrom(abyte0, extensionregistrylite);
        }

        public volatile Message.Builder mergeFrom(ByteString bytestring)
            throws InvalidProtocolBufferException
        {
            return mergeFrom(bytestring);
        }

        public volatile Message.Builder mergeFrom(ByteString bytestring, ExtensionRegistryLite extensionregistrylite)
            throws InvalidProtocolBufferException
        {
            return mergeFrom(bytestring, extensionregistrylite);
        }

        public volatile Message.Builder mergeFrom(CodedInputStream codedinputstream)
            throws IOException
        {
            return mergeFrom(codedinputstream);
        }

        public volatile Message.Builder mergeFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException
        {
            return mergeFrom(codedinputstream, extensionregistrylite);
        }

        public volatile Message.Builder mergeFrom(Message message)
        {
            return mergeFrom(message);
        }

        public volatile Message.Builder mergeFrom(InputStream inputstream)
            throws IOException
        {
            return mergeFrom(inputstream);
        }

        public volatile Message.Builder mergeFrom(InputStream inputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException
        {
            return mergeFrom(inputstream, extensionregistrylite);
        }

        public volatile Message.Builder mergeFrom(byte abyte0[])
            throws InvalidProtocolBufferException
        {
            return mergeFrom(abyte0);
        }

        public volatile Message.Builder mergeFrom(byte abyte0[], int i, int j)
            throws InvalidProtocolBufferException
        {
            return mergeFrom(abyte0, i, j);
        }

        public volatile Message.Builder mergeFrom(byte abyte0[], int i, int j, ExtensionRegistryLite extensionregistrylite)
            throws InvalidProtocolBufferException
        {
            return mergeFrom(abyte0, i, j, extensionregistrylite);
        }

        public volatile Message.Builder mergeFrom(byte abyte0[], ExtensionRegistryLite extensionregistrylite)
            throws InvalidProtocolBufferException
        {
            return mergeFrom(abyte0, extensionregistrylite);
        }

        public volatile MessageLite.Builder mergeFrom(ByteString bytestring)
            throws InvalidProtocolBufferException
        {
            return mergeFrom(bytestring);
        }

        public volatile MessageLite.Builder mergeFrom(ByteString bytestring, ExtensionRegistryLite extensionregistrylite)
            throws InvalidProtocolBufferException
        {
            return mergeFrom(bytestring, extensionregistrylite);
        }

        public volatile MessageLite.Builder mergeFrom(CodedInputStream codedinputstream)
            throws IOException
        {
            return mergeFrom(codedinputstream);
        }

        public volatile MessageLite.Builder mergeFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException
        {
            return mergeFrom(codedinputstream, extensionregistrylite);
        }

        public volatile MessageLite.Builder mergeFrom(InputStream inputstream)
            throws IOException
        {
            return mergeFrom(inputstream);
        }

        public volatile MessageLite.Builder mergeFrom(InputStream inputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException
        {
            return mergeFrom(inputstream, extensionregistrylite);
        }

        public volatile MessageLite.Builder mergeFrom(byte abyte0[])
            throws InvalidProtocolBufferException
        {
            return mergeFrom(abyte0);
        }

        public volatile MessageLite.Builder mergeFrom(byte abyte0[], int i, int j)
            throws InvalidProtocolBufferException
        {
            return mergeFrom(abyte0, i, j);
        }

        public volatile MessageLite.Builder mergeFrom(byte abyte0[], int i, int j, ExtensionRegistryLite extensionregistrylite)
            throws InvalidProtocolBufferException
        {
            return mergeFrom(abyte0, i, j, extensionregistrylite);
        }

        public volatile MessageLite.Builder mergeFrom(byte abyte0[], ExtensionRegistryLite extensionregistrylite)
            throws InvalidProtocolBufferException
        {
            return mergeFrom(abyte0, extensionregistrylite);
        }

        public Builder mergeUnknownFields(UnknownFieldSet unknownfieldset)
        {
            setUnknownFields(UnknownFieldSet.newBuilder(getUnknownFields()).mergeFrom(unknownfieldset).build());
            return this;
        }

        public volatile Message.Builder mergeUnknownFields(UnknownFieldSet unknownfieldset)
        {
            return mergeUnknownFields(unknownfieldset);
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

    protected static int hashBoolean(boolean flag)
    {
        return !flag ? 1237 : 1231;
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

    protected static int hashLong(long l)
    {
        return (int)(l >>> 32 ^ l);
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

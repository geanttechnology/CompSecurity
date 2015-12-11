// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.analytics.midtier.proto.containertag;

import com.google.tagmanager.protobuf.AbstractParser;
import com.google.tagmanager.protobuf.ByteString;
import com.google.tagmanager.protobuf.CodedInputStream;
import com.google.tagmanager.protobuf.CodedOutputStream;
import com.google.tagmanager.protobuf.ExtensionRegistryLite;
import com.google.tagmanager.protobuf.GeneratedMessageLite;
import com.google.tagmanager.protobuf.Internal;
import com.google.tagmanager.protobuf.InvalidProtocolBufferException;
import com.google.tagmanager.protobuf.MessageLite;
import com.google.tagmanager.protobuf.MutableMessageLite;
import com.google.tagmanager.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectStreamException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class TypeSystem
{
    public static final class Value extends com.google.tagmanager.protobuf.GeneratedMessageLite.ExtendableMessage
        implements ValueOrBuilder
    {

        public static final int BOOLEAN_FIELD_NUMBER = 12;
        public static final int CONTAINS_REFERENCES_FIELD_NUMBER = 9;
        public static final int ESCAPING_FIELD_NUMBER = 10;
        public static final int FUNCTION_ID_FIELD_NUMBER = 7;
        public static final int INTEGER_FIELD_NUMBER = 8;
        public static final int LIST_ITEM_FIELD_NUMBER = 3;
        public static final int MACRO_REFERENCE_FIELD_NUMBER = 6;
        public static final int MAP_KEY_FIELD_NUMBER = 4;
        public static final int MAP_VALUE_FIELD_NUMBER = 5;
        public static Parser PARSER = new AbstractParser() {

            public Value parsePartialFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
                throws InvalidProtocolBufferException
            {
                return new Value(codedinputstream, extensionregistrylite);
            }

            public volatile Object parsePartialFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
                throws InvalidProtocolBufferException
            {
                return parsePartialFrom(codedinputstream, extensionregistrylite);
            }

        };
        public static final int STRING_FIELD_NUMBER = 2;
        public static final int TEMPLATE_TOKEN_FIELD_NUMBER = 11;
        public static final int TYPE_FIELD_NUMBER = 1;
        private static final Value defaultInstance;
        private static volatile MutableMessageLite mutableDefault = null;
        private static final long serialVersionUID = 0L;
        private int bitField0_;
        private boolean boolean_;
        private boolean containsReferences_;
        private List escaping_;
        private Object functionId_;
        private long integer_;
        private List listItem_;
        private Object macroReference_;
        private List mapKey_;
        private List mapValue_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private Object string_;
        private List templateToken_;
        private Type type_;
        private final ByteString unknownFields;

        public static Value getDefaultInstance()
        {
            return defaultInstance;
        }

        private void initFields()
        {
            type_ = Type.STRING;
            string_ = "";
            listItem_ = Collections.emptyList();
            mapKey_ = Collections.emptyList();
            mapValue_ = Collections.emptyList();
            macroReference_ = "";
            functionId_ = "";
            integer_ = 0L;
            boolean_ = false;
            templateToken_ = Collections.emptyList();
            escaping_ = Collections.emptyList();
            containsReferences_ = false;
        }

        public static Builder newBuilder()
        {
            return Builder.create();
        }

        public static Builder newBuilder(Value value)
        {
            return newBuilder().mergeFrom(value);
        }

        public static Value parseDelimitedFrom(InputStream inputstream)
            throws IOException
        {
            return (Value)PARSER.parseDelimitedFrom(inputstream);
        }

        public static Value parseDelimitedFrom(InputStream inputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException
        {
            return (Value)PARSER.parseDelimitedFrom(inputstream, extensionregistrylite);
        }

        public static Value parseFrom(ByteString bytestring)
            throws InvalidProtocolBufferException
        {
            return (Value)PARSER.parseFrom(bytestring);
        }

        public static Value parseFrom(ByteString bytestring, ExtensionRegistryLite extensionregistrylite)
            throws InvalidProtocolBufferException
        {
            return (Value)PARSER.parseFrom(bytestring, extensionregistrylite);
        }

        public static Value parseFrom(CodedInputStream codedinputstream)
            throws IOException
        {
            return (Value)PARSER.parseFrom(codedinputstream);
        }

        public static Value parseFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException
        {
            return (Value)PARSER.parseFrom(codedinputstream, extensionregistrylite);
        }

        public static Value parseFrom(InputStream inputstream)
            throws IOException
        {
            return (Value)PARSER.parseFrom(inputstream);
        }

        public static Value parseFrom(InputStream inputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException
        {
            return (Value)PARSER.parseFrom(inputstream, extensionregistrylite);
        }

        public static Value parseFrom(byte abyte0[])
            throws InvalidProtocolBufferException
        {
            return (Value)PARSER.parseFrom(abyte0);
        }

        public static Value parseFrom(byte abyte0[], ExtensionRegistryLite extensionregistrylite)
            throws InvalidProtocolBufferException
        {
            return (Value)PARSER.parseFrom(abyte0, extensionregistrylite);
        }

        public boolean equals(Object obj)
        {
            if (obj == this)
            {
                return true;
            }
            if (!(obj instanceof Value))
            {
                return super.equals(obj);
            }
            obj = (Value)obj;
            boolean flag;
            boolean flag1;
            boolean flag2;
            boolean flag3;
            if (true && hasType() == ((Value) (obj)).hasType())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            flag1 = flag;
            if (hasType())
            {
                if (flag && getType() == ((Value) (obj)).getType())
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
            }
            if (flag1 && hasString() == ((Value) (obj)).hasString())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            flag1 = flag;
            if (hasString())
            {
                if (flag && getString().equals(((Value) (obj)).getString()))
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
            }
            if (flag1 && getListItemList().equals(((Value) (obj)).getListItemList()))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag && getMapKeyList().equals(((Value) (obj)).getMapKeyList()))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag && getMapValueList().equals(((Value) (obj)).getMapValueList()))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag && hasMacroReference() == ((Value) (obj)).hasMacroReference())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            flag1 = flag;
            if (hasMacroReference())
            {
                if (flag && getMacroReference().equals(((Value) (obj)).getMacroReference()))
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
            }
            if (flag1 && hasFunctionId() == ((Value) (obj)).hasFunctionId())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            flag1 = flag;
            if (hasFunctionId())
            {
                if (flag && getFunctionId().equals(((Value) (obj)).getFunctionId()))
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
            }
            if (flag1 && hasInteger() == ((Value) (obj)).hasInteger())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            flag1 = flag;
            if (hasInteger())
            {
                if (flag && getInteger() == ((Value) (obj)).getInteger())
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
            }
            if (flag1 && hasBoolean() == ((Value) (obj)).hasBoolean())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            flag1 = flag;
            if (hasBoolean())
            {
                if (flag && getBoolean() == ((Value) (obj)).getBoolean())
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
            }
            if (flag1 && getTemplateTokenList().equals(((Value) (obj)).getTemplateTokenList()))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag && getEscapingList().equals(((Value) (obj)).getEscapingList()))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag && hasContainsReferences() == ((Value) (obj)).hasContainsReferences())
            {
                flag2 = true;
            } else
            {
                flag2 = false;
            }
            flag3 = flag2;
            if (hasContainsReferences())
            {
                if (flag2 && getContainsReferences() == ((Value) (obj)).getContainsReferences())
                {
                    flag3 = true;
                } else
                {
                    flag3 = false;
                }
            }
            return flag3;
        }

        public boolean getBoolean()
        {
            return boolean_;
        }

        public boolean getContainsReferences()
        {
            return containsReferences_;
        }

        public Value getDefaultInstanceForType()
        {
            return defaultInstance;
        }

        public volatile MessageLite getDefaultInstanceForType()
        {
            return getDefaultInstanceForType();
        }

        public Escaping getEscaping(int i)
        {
            return (Escaping)escaping_.get(i);
        }

        public int getEscapingCount()
        {
            return escaping_.size();
        }

        public List getEscapingList()
        {
            return escaping_;
        }

        public String getFunctionId()
        {
            Object obj = functionId_;
            if (obj instanceof String)
            {
                return (String)obj;
            }
            obj = (ByteString)obj;
            String s = ((ByteString) (obj)).toStringUtf8();
            if (((ByteString) (obj)).isValidUtf8())
            {
                functionId_ = s;
            }
            return s;
        }

        public ByteString getFunctionIdBytes()
        {
            Object obj = functionId_;
            if (obj instanceof String)
            {
                obj = ByteString.copyFromUtf8((String)obj);
                functionId_ = obj;
                return ((ByteString) (obj));
            } else
            {
                return (ByteString)obj;
            }
        }

        public long getInteger()
        {
            return integer_;
        }

        public Value getListItem(int i)
        {
            return (Value)listItem_.get(i);
        }

        public int getListItemCount()
        {
            return listItem_.size();
        }

        public List getListItemList()
        {
            return listItem_;
        }

        public ValueOrBuilder getListItemOrBuilder(int i)
        {
            return (ValueOrBuilder)listItem_.get(i);
        }

        public List getListItemOrBuilderList()
        {
            return listItem_;
        }

        public String getMacroReference()
        {
            Object obj = macroReference_;
            if (obj instanceof String)
            {
                return (String)obj;
            }
            obj = (ByteString)obj;
            String s = ((ByteString) (obj)).toStringUtf8();
            if (((ByteString) (obj)).isValidUtf8())
            {
                macroReference_ = s;
            }
            return s;
        }

        public ByteString getMacroReferenceBytes()
        {
            Object obj = macroReference_;
            if (obj instanceof String)
            {
                obj = ByteString.copyFromUtf8((String)obj);
                macroReference_ = obj;
                return ((ByteString) (obj));
            } else
            {
                return (ByteString)obj;
            }
        }

        public Value getMapKey(int i)
        {
            return (Value)mapKey_.get(i);
        }

        public int getMapKeyCount()
        {
            return mapKey_.size();
        }

        public List getMapKeyList()
        {
            return mapKey_;
        }

        public ValueOrBuilder getMapKeyOrBuilder(int i)
        {
            return (ValueOrBuilder)mapKey_.get(i);
        }

        public List getMapKeyOrBuilderList()
        {
            return mapKey_;
        }

        public Value getMapValue(int i)
        {
            return (Value)mapValue_.get(i);
        }

        public int getMapValueCount()
        {
            return mapValue_.size();
        }

        public List getMapValueList()
        {
            return mapValue_;
        }

        public ValueOrBuilder getMapValueOrBuilder(int i)
        {
            return (ValueOrBuilder)mapValue_.get(i);
        }

        public List getMapValueOrBuilderList()
        {
            return mapValue_;
        }

        public Parser getParserForType()
        {
            return PARSER;
        }

        public int getSerializedSize()
        {
            int i = memoizedSerializedSize;
            if (i != -1)
            {
                return i;
            }
            int j = 0;
            if ((bitField0_ & 1) == 1)
            {
                j = 0 + CodedOutputStream.computeEnumSize(1, type_.getNumber());
            }
            i = j;
            if ((bitField0_ & 2) == 2)
            {
                i = j + CodedOutputStream.computeBytesSize(2, getStringBytes());
            }
            for (j = 0; j < listItem_.size(); j++)
            {
                i += CodedOutputStream.computeMessageSize(3, (MessageLite)listItem_.get(j));
            }

            for (j = 0; j < mapKey_.size(); j++)
            {
                i += CodedOutputStream.computeMessageSize(4, (MessageLite)mapKey_.get(j));
            }

            for (j = 0; j < mapValue_.size(); j++)
            {
                i += CodedOutputStream.computeMessageSize(5, (MessageLite)mapValue_.get(j));
            }

            j = i;
            if ((bitField0_ & 4) == 4)
            {
                j = i + CodedOutputStream.computeBytesSize(6, getMacroReferenceBytes());
            }
            i = j;
            if ((bitField0_ & 8) == 8)
            {
                i = j + CodedOutputStream.computeBytesSize(7, getFunctionIdBytes());
            }
            j = i;
            if ((bitField0_ & 0x10) == 16)
            {
                j = i + CodedOutputStream.computeInt64Size(8, integer_);
            }
            i = j;
            if ((bitField0_ & 0x40) == 64)
            {
                i = j + CodedOutputStream.computeBoolSize(9, containsReferences_);
            }
            int k = 0;
            for (j = 0; j < escaping_.size(); j++)
            {
                k += CodedOutputStream.computeEnumSizeNoTag(((Escaping)escaping_.get(j)).getNumber());
            }

            i = i + k + escaping_.size() * 1;
            for (j = 0; j < templateToken_.size(); j++)
            {
                i += CodedOutputStream.computeMessageSize(11, (MessageLite)templateToken_.get(j));
            }

            j = i;
            if ((bitField0_ & 0x20) == 32)
            {
                j = i + CodedOutputStream.computeBoolSize(12, boolean_);
            }
            i = j + extensionsSerializedSize() + unknownFields.size();
            memoizedSerializedSize = i;
            return i;
        }

        public String getString()
        {
            Object obj = string_;
            if (obj instanceof String)
            {
                return (String)obj;
            }
            obj = (ByteString)obj;
            String s = ((ByteString) (obj)).toStringUtf8();
            if (((ByteString) (obj)).isValidUtf8())
            {
                string_ = s;
            }
            return s;
        }

        public ByteString getStringBytes()
        {
            Object obj = string_;
            if (obj instanceof String)
            {
                obj = ByteString.copyFromUtf8((String)obj);
                string_ = obj;
                return ((ByteString) (obj));
            } else
            {
                return (ByteString)obj;
            }
        }

        public Value getTemplateToken(int i)
        {
            return (Value)templateToken_.get(i);
        }

        public int getTemplateTokenCount()
        {
            return templateToken_.size();
        }

        public List getTemplateTokenList()
        {
            return templateToken_;
        }

        public ValueOrBuilder getTemplateTokenOrBuilder(int i)
        {
            return (ValueOrBuilder)templateToken_.get(i);
        }

        public List getTemplateTokenOrBuilderList()
        {
            return templateToken_;
        }

        public Type getType()
        {
            return type_;
        }

        public boolean hasBoolean()
        {
            return (bitField0_ & 0x20) == 32;
        }

        public boolean hasContainsReferences()
        {
            return (bitField0_ & 0x40) == 64;
        }

        public boolean hasFunctionId()
        {
            return (bitField0_ & 8) == 8;
        }

        public boolean hasInteger()
        {
            return (bitField0_ & 0x10) == 16;
        }

        public boolean hasMacroReference()
        {
            return (bitField0_ & 4) == 4;
        }

        public boolean hasString()
        {
            return (bitField0_ & 2) == 2;
        }

        public boolean hasType()
        {
            return (bitField0_ & 1) == 1;
        }

        public int hashCode()
        {
            if (memoizedHashCode != 0)
            {
                return memoizedHashCode;
            }
            int j = com/google/analytics/midtier/proto/containertag/TypeSystem$Value.hashCode() + 779;
            int i = j;
            if (hasType())
            {
                i = (j * 37 + 1) * 53 + Internal.hashEnum(getType());
            }
            j = i;
            if (hasString())
            {
                j = (i * 37 + 2) * 53 + getString().hashCode();
            }
            i = j;
            if (getListItemCount() > 0)
            {
                i = (j * 37 + 3) * 53 + getListItemList().hashCode();
            }
            j = i;
            if (getMapKeyCount() > 0)
            {
                j = (i * 37 + 4) * 53 + getMapKeyList().hashCode();
            }
            i = j;
            if (getMapValueCount() > 0)
            {
                i = (j * 37 + 5) * 53 + getMapValueList().hashCode();
            }
            j = i;
            if (hasMacroReference())
            {
                j = (i * 37 + 6) * 53 + getMacroReference().hashCode();
            }
            i = j;
            if (hasFunctionId())
            {
                i = (j * 37 + 7) * 53 + getFunctionId().hashCode();
            }
            j = i;
            if (hasInteger())
            {
                j = (i * 37 + 8) * 53 + Internal.hashLong(getInteger());
            }
            i = j;
            if (hasBoolean())
            {
                i = (j * 37 + 12) * 53 + Internal.hashBoolean(getBoolean());
            }
            j = i;
            if (getTemplateTokenCount() > 0)
            {
                j = (i * 37 + 11) * 53 + getTemplateTokenList().hashCode();
            }
            i = j;
            if (getEscapingCount() > 0)
            {
                i = (j * 37 + 10) * 53 + Internal.hashEnumList(getEscapingList());
            }
            j = i;
            if (hasContainsReferences())
            {
                j = (i * 37 + 9) * 53 + Internal.hashBoolean(getContainsReferences());
            }
            i = j * 29 + unknownFields.hashCode();
            memoizedHashCode = i;
            return i;
        }

        protected MutableMessageLite internalMutableDefault()
        {
            if (mutableDefault == null)
            {
                mutableDefault = internalMutableDefault("com.google.analytics.midtier.proto.containertag.MutableTypeSystem$Value");
            }
            return mutableDefault;
        }

        public final boolean isInitialized()
        {
            boolean flag = true;
            byte byte0 = memoizedIsInitialized;
            if (byte0 != -1)
            {
                if (byte0 != 1)
                {
                    flag = false;
                }
                return flag;
            }
            if (!hasType())
            {
                memoizedIsInitialized = 0;
                return false;
            }
            for (int i = 0; i < getListItemCount(); i++)
            {
                if (!getListItem(i).isInitialized())
                {
                    memoizedIsInitialized = 0;
                    return false;
                }
            }

            for (int j = 0; j < getMapKeyCount(); j++)
            {
                if (!getMapKey(j).isInitialized())
                {
                    memoizedIsInitialized = 0;
                    return false;
                }
            }

            for (int k = 0; k < getMapValueCount(); k++)
            {
                if (!getMapValue(k).isInitialized())
                {
                    memoizedIsInitialized = 0;
                    return false;
                }
            }

            for (int l = 0; l < getTemplateTokenCount(); l++)
            {
                if (!getTemplateToken(l).isInitialized())
                {
                    memoizedIsInitialized = 0;
                    return false;
                }
            }

            if (!extensionsAreInitialized())
            {
                memoizedIsInitialized = 0;
                return false;
            } else
            {
                memoizedIsInitialized = 1;
                return true;
            }
        }

        public Builder newBuilderForType()
        {
            return newBuilder();
        }

        public volatile com.google.tagmanager.protobuf.MessageLite.Builder newBuilderForType()
        {
            return newBuilderForType();
        }

        public Builder toBuilder()
        {
            return newBuilder(this);
        }

        public volatile com.google.tagmanager.protobuf.MessageLite.Builder toBuilder()
        {
            return toBuilder();
        }

        protected Object writeReplace()
            throws ObjectStreamException
        {
            return super.writeReplace();
        }

        public void writeTo(CodedOutputStream codedoutputstream)
            throws IOException
        {
            getSerializedSize();
            com.google.tagmanager.protobuf.GeneratedMessageLite.ExtendableMessage.ExtensionWriter extensionwriter = newExtensionWriter();
            if ((bitField0_ & 1) == 1)
            {
                codedoutputstream.writeEnum(1, type_.getNumber());
            }
            if ((bitField0_ & 2) == 2)
            {
                codedoutputstream.writeBytes(2, getStringBytes());
            }
            for (int i = 0; i < listItem_.size(); i++)
            {
                codedoutputstream.writeMessage(3, (MessageLite)listItem_.get(i));
            }

            for (int j = 0; j < mapKey_.size(); j++)
            {
                codedoutputstream.writeMessage(4, (MessageLite)mapKey_.get(j));
            }

            for (int k = 0; k < mapValue_.size(); k++)
            {
                codedoutputstream.writeMessage(5, (MessageLite)mapValue_.get(k));
            }

            if ((bitField0_ & 4) == 4)
            {
                codedoutputstream.writeBytes(6, getMacroReferenceBytes());
            }
            if ((bitField0_ & 8) == 8)
            {
                codedoutputstream.writeBytes(7, getFunctionIdBytes());
            }
            if ((bitField0_ & 0x10) == 16)
            {
                codedoutputstream.writeInt64(8, integer_);
            }
            if ((bitField0_ & 0x40) == 64)
            {
                codedoutputstream.writeBool(9, containsReferences_);
            }
            for (int l = 0; l < escaping_.size(); l++)
            {
                codedoutputstream.writeEnum(10, ((Escaping)escaping_.get(l)).getNumber());
            }

            for (int i1 = 0; i1 < templateToken_.size(); i1++)
            {
                codedoutputstream.writeMessage(11, (MessageLite)templateToken_.get(i1));
            }

            if ((bitField0_ & 0x20) == 32)
            {
                codedoutputstream.writeBool(12, boolean_);
            }
            extensionwriter.writeUntil(0x20000000, codedoutputstream);
            codedoutputstream.writeRawBytes(unknownFields);
        }

        static 
        {
            defaultInstance = new Value(true);
            defaultInstance.initFields();
        }


/*
        static long access$1002(Value value, long l)
        {
            value.integer_ = l;
            return l;
        }

*/


/*
        static boolean access$1102(Value value, boolean flag)
        {
            value.boolean_ = flag;
            return flag;
        }

*/



/*
        static List access$1202(Value value, List list)
        {
            value.templateToken_ = list;
            return list;
        }

*/



/*
        static List access$1302(Value value, List list)
        {
            value.escaping_ = list;
            return list;
        }

*/


/*
        static boolean access$1402(Value value, boolean flag)
        {
            value.containsReferences_ = flag;
            return flag;
        }

*/


/*
        static int access$1502(Value value, int i)
        {
            value.bitField0_ = i;
            return i;
        }

*/



/*
        static Type access$302(Value value, Type type)
        {
            value.type_ = type;
            return type;
        }

*/



/*
        static Object access$402(Value value, Object obj)
        {
            value.string_ = obj;
            return obj;
        }

*/



/*
        static List access$502(Value value, List list)
        {
            value.listItem_ = list;
            return list;
        }

*/



/*
        static List access$602(Value value, List list)
        {
            value.mapKey_ = list;
            return list;
        }

*/



/*
        static List access$702(Value value, List list)
        {
            value.mapValue_ = list;
            return list;
        }

*/



/*
        static Object access$802(Value value, Object obj)
        {
            value.macroReference_ = obj;
            return obj;
        }

*/



/*
        static Object access$902(Value value, Object obj)
        {
            value.functionId_ = obj;
            return obj;
        }

*/

        private Value(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
            throws InvalidProtocolBufferException
        {
            com.google.tagmanager.protobuf.ByteString.Output output;
            CodedOutputStream codedoutputstream;
            int i;
            boolean flag;
            memoizedIsInitialized = -1;
            memoizedSerializedSize = -1;
            initFields();
            i = 0;
            output = ByteString.newOutput();
            codedoutputstream = CodedOutputStream.newInstance(output);
            flag = false;
_L43:
            if (flag) goto _L2; else goto _L1
_L1:
            int j;
            int k;
            int l;
            k = i;
            j = i;
            l = i;
            int j1 = codedinputstream.readTag();
            j1;
            JVM INSTR lookupswitch 14: default 1697
        //                       0: 1700
        //                       8: 211
        //                       18: 496
        //                       26: 557
        //                       34: 635
        //                       42: 716
        //                       50: 797
        //                       58: 858
        //                       64: 920
        //                       72: 966
        //                       80: 1012
        //                       82: 1173
        //                       90: 1396
        //                       96: 1480;
               goto _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17
_L3:
            k = i;
            j = i;
            l = i;
            if (!parseUnknownField(codedinputstream, codedoutputstream, extensionregistrylite, j1))
            {
                flag = true;
            }
            continue; /* Loop/switch isn't completed */
_L5:
            k = i;
            j = i;
            l = i;
            int i1 = codedinputstream.readEnum();
            k = i;
            j = i;
            l = i;
            Object obj = Type.valueOf(i1);
            if (obj != null) goto _L19; else goto _L18
_L18:
            k = i;
            j = i;
            l = i;
            codedoutputstream.writeRawVarint32(j1);
            k = i;
            j = i;
            l = i;
            codedoutputstream.writeRawVarint32(i1);
            continue; /* Loop/switch isn't completed */
            codedinputstream;
            j = k;
            throw codedinputstream.setUnfinishedMessage(this);
            codedinputstream;
            if ((j & 4) == 4)
            {
                listItem_ = Collections.unmodifiableList(listItem_);
            }
            if ((j & 8) == 8)
            {
                mapKey_ = Collections.unmodifiableList(mapKey_);
            }
            if ((j & 0x10) == 16)
            {
                mapValue_ = Collections.unmodifiableList(mapValue_);
            }
            if ((j & 0x400) == 1024)
            {
                escaping_ = Collections.unmodifiableList(escaping_);
            }
            if ((j & 0x200) == 512)
            {
                templateToken_ = Collections.unmodifiableList(templateToken_);
            }
            codedoutputstream.flush();
            unknownFields = output.toByteString();
_L41:
            makeExtensionsImmutable();
            throw codedinputstream;
_L19:
            k = i;
            j = i;
            l = i;
            bitField0_ = bitField0_ | 1;
            k = i;
            j = i;
            l = i;
            type_ = ((Type) (obj));
            continue; /* Loop/switch isn't completed */
            codedinputstream;
            j = l;
            throw (new InvalidProtocolBufferException(codedinputstream.getMessage())).setUnfinishedMessage(this);
_L6:
            k = i;
            j = i;
            l = i;
            obj = codedinputstream.readBytes();
            k = i;
            j = i;
            l = i;
            bitField0_ = bitField0_ | 2;
            k = i;
            j = i;
            l = i;
            string_ = obj;
            continue; /* Loop/switch isn't completed */
_L7:
            i1 = i;
            if ((i & 4) == 4) goto _L21; else goto _L20
_L20:
            k = i;
            j = i;
            l = i;
            listItem_ = new ArrayList();
            i1 = i | 4;
_L21:
            k = i1;
            j = i1;
            l = i1;
            listItem_.add(codedinputstream.readMessage(PARSER, extensionregistrylite));
            i = i1;
            continue; /* Loop/switch isn't completed */
_L8:
            i1 = i;
            if ((i & 8) == 8) goto _L23; else goto _L22
_L22:
            k = i;
            j = i;
            l = i;
            mapKey_ = new ArrayList();
            i1 = i | 8;
_L23:
            k = i1;
            j = i1;
            l = i1;
            mapKey_.add(codedinputstream.readMessage(PARSER, extensionregistrylite));
            i = i1;
            continue; /* Loop/switch isn't completed */
_L9:
            i1 = i;
            if ((i & 0x10) == 16) goto _L25; else goto _L24
_L24:
            k = i;
            j = i;
            l = i;
            mapValue_ = new ArrayList();
            i1 = i | 0x10;
_L25:
            k = i1;
            j = i1;
            l = i1;
            mapValue_.add(codedinputstream.readMessage(PARSER, extensionregistrylite));
            i = i1;
            continue; /* Loop/switch isn't completed */
_L10:
            k = i;
            j = i;
            l = i;
            obj = codedinputstream.readBytes();
            k = i;
            j = i;
            l = i;
            bitField0_ = bitField0_ | 4;
            k = i;
            j = i;
            l = i;
            macroReference_ = obj;
            continue; /* Loop/switch isn't completed */
_L11:
            k = i;
            j = i;
            l = i;
            obj = codedinputstream.readBytes();
            k = i;
            j = i;
            l = i;
            bitField0_ = bitField0_ | 8;
            k = i;
            j = i;
            l = i;
            functionId_ = obj;
            continue; /* Loop/switch isn't completed */
_L12:
            k = i;
            j = i;
            l = i;
            bitField0_ = bitField0_ | 0x10;
            k = i;
            j = i;
            l = i;
            integer_ = codedinputstream.readInt64();
            continue; /* Loop/switch isn't completed */
_L13:
            k = i;
            j = i;
            l = i;
            bitField0_ = bitField0_ | 0x40;
            k = i;
            j = i;
            l = i;
            containsReferences_ = codedinputstream.readBool();
            continue; /* Loop/switch isn't completed */
_L14:
            k = i;
            j = i;
            l = i;
            i1 = codedinputstream.readEnum();
            k = i;
            j = i;
            l = i;
            obj = Escaping.valueOf(i1);
            if (obj != null) goto _L27; else goto _L26
_L26:
            k = i;
            j = i;
            l = i;
            codedoutputstream.writeRawVarint32(j1);
            k = i;
            j = i;
            l = i;
            codedoutputstream.writeRawVarint32(i1);
            continue; /* Loop/switch isn't completed */
_L27:
            i1 = i;
            if ((i & 0x400) == 1024) goto _L29; else goto _L28
_L28:
            k = i;
            j = i;
            l = i;
            escaping_ = new ArrayList();
            i1 = i | 0x400;
_L29:
            k = i1;
            j = i1;
            l = i1;
            escaping_.add(obj);
            i = i1;
            continue; /* Loop/switch isn't completed */
_L15:
            k = i;
            j = i;
            l = i;
            int k1 = codedinputstream.pushLimit(codedinputstream.readRawVarint32());
_L35:
            k = i;
            j = i;
            l = i;
            if (codedinputstream.getBytesUntilLimit() <= 0)
            {
                break; /* Loop/switch isn't completed */
            }
            k = i;
            j = i;
            l = i;
            i1 = codedinputstream.readEnum();
            k = i;
            j = i;
            l = i;
            obj = Escaping.valueOf(i1);
            if (obj != null) goto _L31; else goto _L30
_L30:
            k = i;
            j = i;
            l = i;
            codedoutputstream.writeRawVarint32(j1);
            k = i;
            j = i;
            l = i;
            codedoutputstream.writeRawVarint32(i1);
            continue; /* Loop/switch isn't completed */
_L31:
            i1 = i;
            if ((i & 0x400) == 1024) goto _L33; else goto _L32
_L32:
            k = i;
            j = i;
            l = i;
            escaping_ = new ArrayList();
            i1 = i | 0x400;
_L33:
            k = i1;
            j = i1;
            l = i1;
            escaping_.add(obj);
            i = i1;
            if (true) goto _L35; else goto _L34
_L34:
            k = i;
            j = i;
            l = i;
            codedinputstream.popLimit(k1);
            continue; /* Loop/switch isn't completed */
_L16:
            i1 = i;
            if ((i & 0x200) == 512) goto _L37; else goto _L36
_L36:
            k = i;
            j = i;
            l = i;
            templateToken_ = new ArrayList();
            i1 = i | 0x200;
_L37:
            k = i1;
            j = i1;
            l = i1;
            templateToken_.add(codedinputstream.readMessage(PARSER, extensionregistrylite));
            i = i1;
            continue; /* Loop/switch isn't completed */
_L17:
            k = i;
            j = i;
            l = i;
            bitField0_ = bitField0_ | 0x20;
            k = i;
            j = i;
            l = i;
            boolean_ = codedinputstream.readBool();
            continue; /* Loop/switch isn't completed */
_L2:
            if ((i & 4) == 4)
            {
                listItem_ = Collections.unmodifiableList(listItem_);
            }
            if ((i & 8) == 8)
            {
                mapKey_ = Collections.unmodifiableList(mapKey_);
            }
            if ((i & 0x10) == 16)
            {
                mapValue_ = Collections.unmodifiableList(mapValue_);
            }
            if ((i & 0x400) == 1024)
            {
                escaping_ = Collections.unmodifiableList(escaping_);
            }
            if ((i & 0x200) == 512)
            {
                templateToken_ = Collections.unmodifiableList(templateToken_);
            }
            codedoutputstream.flush();
            unknownFields = output.toByteString();
_L39:
            makeExtensionsImmutable();
            return;
            codedinputstream;
            unknownFields = output.toByteString();
            if (true) goto _L39; else goto _L38
_L38:
            codedinputstream;
            unknownFields = output.toByteString();
            throw codedinputstream;
            extensionregistrylite;
            unknownFields = output.toByteString();
            if (true) goto _L41; else goto _L40
_L40:
            codedinputstream;
            unknownFields = output.toByteString();
            throw codedinputstream;
_L4:
            flag = true;
            if (true) goto _L43; else goto _L42
_L42:
        }


        private Value(com.google.tagmanager.protobuf.GeneratedMessageLite.ExtendableBuilder extendablebuilder)
        {
            super(extendablebuilder);
            memoizedIsInitialized = -1;
            memoizedSerializedSize = -1;
            unknownFields = extendablebuilder.getUnknownFields();
        }


        private Value(boolean flag)
        {
            memoizedIsInitialized = -1;
            memoizedSerializedSize = -1;
            unknownFields = ByteString.EMPTY;
        }
    }

    public static final class Value.Builder extends com.google.tagmanager.protobuf.GeneratedMessageLite.ExtendableBuilder
        implements ValueOrBuilder
    {

        private int bitField0_;
        private boolean boolean_;
        private boolean containsReferences_;
        private List escaping_;
        private Object functionId_;
        private long integer_;
        private List listItem_;
        private Object macroReference_;
        private List mapKey_;
        private List mapValue_;
        private Object string_;
        private List templateToken_;
        private Value.Type type_;

        private static Value.Builder create()
        {
            return new Value.Builder();
        }

        private void ensureEscapingIsMutable()
        {
            if ((bitField0_ & 0x400) != 1024)
            {
                escaping_ = new ArrayList(escaping_);
                bitField0_ = bitField0_ | 0x400;
            }
        }

        private void ensureListItemIsMutable()
        {
            if ((bitField0_ & 4) != 4)
            {
                listItem_ = new ArrayList(listItem_);
                bitField0_ = bitField0_ | 4;
            }
        }

        private void ensureMapKeyIsMutable()
        {
            if ((bitField0_ & 8) != 8)
            {
                mapKey_ = new ArrayList(mapKey_);
                bitField0_ = bitField0_ | 8;
            }
        }

        private void ensureMapValueIsMutable()
        {
            if ((bitField0_ & 0x10) != 16)
            {
                mapValue_ = new ArrayList(mapValue_);
                bitField0_ = bitField0_ | 0x10;
            }
        }

        private void ensureTemplateTokenIsMutable()
        {
            if ((bitField0_ & 0x200) != 512)
            {
                templateToken_ = new ArrayList(templateToken_);
                bitField0_ = bitField0_ | 0x200;
            }
        }

        private void maybeForceBuilderInitialization()
        {
        }

        public Value.Builder addAllEscaping(Iterable iterable)
        {
            ensureEscapingIsMutable();
            com.google.tagmanager.protobuf.AbstractMessageLite.Builder.addAll(iterable, escaping_);
            return this;
        }

        public Value.Builder addAllListItem(Iterable iterable)
        {
            ensureListItemIsMutable();
            com.google.tagmanager.protobuf.AbstractMessageLite.Builder.addAll(iterable, listItem_);
            return this;
        }

        public Value.Builder addAllMapKey(Iterable iterable)
        {
            ensureMapKeyIsMutable();
            com.google.tagmanager.protobuf.AbstractMessageLite.Builder.addAll(iterable, mapKey_);
            return this;
        }

        public Value.Builder addAllMapValue(Iterable iterable)
        {
            ensureMapValueIsMutable();
            com.google.tagmanager.protobuf.AbstractMessageLite.Builder.addAll(iterable, mapValue_);
            return this;
        }

        public Value.Builder addAllTemplateToken(Iterable iterable)
        {
            ensureTemplateTokenIsMutable();
            com.google.tagmanager.protobuf.AbstractMessageLite.Builder.addAll(iterable, templateToken_);
            return this;
        }

        public Value.Builder addEscaping(Value.Escaping escaping)
        {
            if (escaping == null)
            {
                throw new NullPointerException();
            } else
            {
                ensureEscapingIsMutable();
                escaping_.add(escaping);
                return this;
            }
        }

        public Value.Builder addListItem(int i, Value.Builder builder)
        {
            ensureListItemIsMutable();
            listItem_.add(i, builder.build());
            return this;
        }

        public Value.Builder addListItem(int i, Value value)
        {
            if (value == null)
            {
                throw new NullPointerException();
            } else
            {
                ensureListItemIsMutable();
                listItem_.add(i, value);
                return this;
            }
        }

        public Value.Builder addListItem(Value.Builder builder)
        {
            ensureListItemIsMutable();
            listItem_.add(builder.build());
            return this;
        }

        public Value.Builder addListItem(Value value)
        {
            if (value == null)
            {
                throw new NullPointerException();
            } else
            {
                ensureListItemIsMutable();
                listItem_.add(value);
                return this;
            }
        }

        public Value.Builder addMapKey(int i, Value.Builder builder)
        {
            ensureMapKeyIsMutable();
            mapKey_.add(i, builder.build());
            return this;
        }

        public Value.Builder addMapKey(int i, Value value)
        {
            if (value == null)
            {
                throw new NullPointerException();
            } else
            {
                ensureMapKeyIsMutable();
                mapKey_.add(i, value);
                return this;
            }
        }

        public Value.Builder addMapKey(Value.Builder builder)
        {
            ensureMapKeyIsMutable();
            mapKey_.add(builder.build());
            return this;
        }

        public Value.Builder addMapKey(Value value)
        {
            if (value == null)
            {
                throw new NullPointerException();
            } else
            {
                ensureMapKeyIsMutable();
                mapKey_.add(value);
                return this;
            }
        }

        public Value.Builder addMapValue(int i, Value.Builder builder)
        {
            ensureMapValueIsMutable();
            mapValue_.add(i, builder.build());
            return this;
        }

        public Value.Builder addMapValue(int i, Value value)
        {
            if (value == null)
            {
                throw new NullPointerException();
            } else
            {
                ensureMapValueIsMutable();
                mapValue_.add(i, value);
                return this;
            }
        }

        public Value.Builder addMapValue(Value.Builder builder)
        {
            ensureMapValueIsMutable();
            mapValue_.add(builder.build());
            return this;
        }

        public Value.Builder addMapValue(Value value)
        {
            if (value == null)
            {
                throw new NullPointerException();
            } else
            {
                ensureMapValueIsMutable();
                mapValue_.add(value);
                return this;
            }
        }

        public Value.Builder addTemplateToken(int i, Value.Builder builder)
        {
            ensureTemplateTokenIsMutable();
            templateToken_.add(i, builder.build());
            return this;
        }

        public Value.Builder addTemplateToken(int i, Value value)
        {
            if (value == null)
            {
                throw new NullPointerException();
            } else
            {
                ensureTemplateTokenIsMutable();
                templateToken_.add(i, value);
                return this;
            }
        }

        public Value.Builder addTemplateToken(Value.Builder builder)
        {
            ensureTemplateTokenIsMutable();
            templateToken_.add(builder.build());
            return this;
        }

        public Value.Builder addTemplateToken(Value value)
        {
            if (value == null)
            {
                throw new NullPointerException();
            } else
            {
                ensureTemplateTokenIsMutable();
                templateToken_.add(value);
                return this;
            }
        }

        public Value build()
        {
            Value value = buildPartial();
            if (!value.isInitialized())
            {
                throw newUninitializedMessageException(value);
            } else
            {
                return value;
            }
        }

        public volatile MessageLite build()
        {
            return build();
        }

        public Value buildPartial()
        {
            Value value = new Value(this);
            int k = bitField0_;
            int j = 0;
            if ((k & 1) == 1)
            {
                j = false | true;
            }
            value.type_ = type_;
            int i = j;
            if ((k & 2) == 2)
            {
                i = j | 2;
            }
            value.string_ = string_;
            if ((bitField0_ & 4) == 4)
            {
                listItem_ = Collections.unmodifiableList(listItem_);
                bitField0_ = bitField0_ & -5;
            }
            value.listItem_ = listItem_;
            if ((bitField0_ & 8) == 8)
            {
                mapKey_ = Collections.unmodifiableList(mapKey_);
                bitField0_ = bitField0_ & -9;
            }
            value.mapKey_ = mapKey_;
            if ((bitField0_ & 0x10) == 16)
            {
                mapValue_ = Collections.unmodifiableList(mapValue_);
                bitField0_ = bitField0_ & 0xffffffef;
            }
            value.mapValue_ = mapValue_;
            j = i;
            if ((k & 0x20) == 32)
            {
                j = i | 4;
            }
            value.macroReference_ = macroReference_;
            i = j;
            if ((k & 0x40) == 64)
            {
                i = j | 8;
            }
            value.functionId_ = functionId_;
            j = i;
            if ((k & 0x80) == 128)
            {
                j = i | 0x10;
            }
            value.integer_ = integer_;
            i = j;
            if ((k & 0x100) == 256)
            {
                i = j | 0x20;
            }
            value.boolean_ = boolean_;
            if ((bitField0_ & 0x200) == 512)
            {
                templateToken_ = Collections.unmodifiableList(templateToken_);
                bitField0_ = bitField0_ & 0xfffffdff;
            }
            value.templateToken_ = templateToken_;
            if ((bitField0_ & 0x400) == 1024)
            {
                escaping_ = Collections.unmodifiableList(escaping_);
                bitField0_ = bitField0_ & 0xfffffbff;
            }
            value.escaping_ = escaping_;
            j = i;
            if ((k & 0x800) == 2048)
            {
                j = i | 0x40;
            }
            value.containsReferences_ = containsReferences_;
            value.bitField0_ = j;
            return value;
        }

        public volatile MessageLite buildPartial()
        {
            return buildPartial();
        }

        public Value.Builder clear()
        {
            super.clear();
            type_ = Value.Type.STRING;
            bitField0_ = bitField0_ & -2;
            string_ = "";
            bitField0_ = bitField0_ & -3;
            listItem_ = Collections.emptyList();
            bitField0_ = bitField0_ & -5;
            mapKey_ = Collections.emptyList();
            bitField0_ = bitField0_ & -9;
            mapValue_ = Collections.emptyList();
            bitField0_ = bitField0_ & 0xffffffef;
            macroReference_ = "";
            bitField0_ = bitField0_ & 0xffffffdf;
            functionId_ = "";
            bitField0_ = bitField0_ & 0xffffffbf;
            integer_ = 0L;
            bitField0_ = bitField0_ & 0xffffff7f;
            boolean_ = false;
            bitField0_ = bitField0_ & 0xfffffeff;
            templateToken_ = Collections.emptyList();
            bitField0_ = bitField0_ & 0xfffffdff;
            escaping_ = Collections.emptyList();
            bitField0_ = bitField0_ & 0xfffffbff;
            containsReferences_ = false;
            bitField0_ = bitField0_ & 0xfffff7ff;
            return this;
        }

        public volatile com.google.tagmanager.protobuf.GeneratedMessageLite.Builder clear()
        {
            return clear();
        }

        public volatile com.google.tagmanager.protobuf.GeneratedMessageLite.ExtendableBuilder clear()
        {
            return clear();
        }

        public volatile com.google.tagmanager.protobuf.MessageLite.Builder clear()
        {
            return clear();
        }

        public Value.Builder clearBoolean()
        {
            bitField0_ = bitField0_ & 0xfffffeff;
            boolean_ = false;
            return this;
        }

        public Value.Builder clearContainsReferences()
        {
            bitField0_ = bitField0_ & 0xfffff7ff;
            containsReferences_ = false;
            return this;
        }

        public Value.Builder clearEscaping()
        {
            escaping_ = Collections.emptyList();
            bitField0_ = bitField0_ & 0xfffffbff;
            return this;
        }

        public Value.Builder clearFunctionId()
        {
            bitField0_ = bitField0_ & 0xffffffbf;
            functionId_ = Value.getDefaultInstance().getFunctionId();
            return this;
        }

        public Value.Builder clearInteger()
        {
            bitField0_ = bitField0_ & 0xffffff7f;
            integer_ = 0L;
            return this;
        }

        public Value.Builder clearListItem()
        {
            listItem_ = Collections.emptyList();
            bitField0_ = bitField0_ & -5;
            return this;
        }

        public Value.Builder clearMacroReference()
        {
            bitField0_ = bitField0_ & 0xffffffdf;
            macroReference_ = Value.getDefaultInstance().getMacroReference();
            return this;
        }

        public Value.Builder clearMapKey()
        {
            mapKey_ = Collections.emptyList();
            bitField0_ = bitField0_ & -9;
            return this;
        }

        public Value.Builder clearMapValue()
        {
            mapValue_ = Collections.emptyList();
            bitField0_ = bitField0_ & 0xffffffef;
            return this;
        }

        public Value.Builder clearString()
        {
            bitField0_ = bitField0_ & -3;
            string_ = Value.getDefaultInstance().getString();
            return this;
        }

        public Value.Builder clearTemplateToken()
        {
            templateToken_ = Collections.emptyList();
            bitField0_ = bitField0_ & 0xfffffdff;
            return this;
        }

        public Value.Builder clearType()
        {
            bitField0_ = bitField0_ & -2;
            type_ = Value.Type.STRING;
            return this;
        }

        public Value.Builder clone()
        {
            return create().mergeFrom(buildPartial());
        }

        public volatile com.google.tagmanager.protobuf.AbstractMessageLite.Builder clone()
        {
            return clone();
        }

        public volatile com.google.tagmanager.protobuf.GeneratedMessageLite.Builder clone()
        {
            return clone();
        }

        public volatile com.google.tagmanager.protobuf.GeneratedMessageLite.ExtendableBuilder clone()
        {
            return clone();
        }

        public volatile com.google.tagmanager.protobuf.MessageLite.Builder clone()
        {
            return clone();
        }

        public volatile Object clone()
            throws CloneNotSupportedException
        {
            return clone();
        }

        public boolean getBoolean()
        {
            return boolean_;
        }

        public boolean getContainsReferences()
        {
            return containsReferences_;
        }

        public Value getDefaultInstanceForType()
        {
            return Value.getDefaultInstance();
        }

        public volatile GeneratedMessageLite getDefaultInstanceForType()
        {
            return getDefaultInstanceForType();
        }

        public volatile MessageLite getDefaultInstanceForType()
        {
            return getDefaultInstanceForType();
        }

        public Value.Escaping getEscaping(int i)
        {
            return (Value.Escaping)escaping_.get(i);
        }

        public int getEscapingCount()
        {
            return escaping_.size();
        }

        public List getEscapingList()
        {
            return Collections.unmodifiableList(escaping_);
        }

        public String getFunctionId()
        {
            Object obj = functionId_;
            if (!(obj instanceof String))
            {
                obj = (ByteString)obj;
                String s = ((ByteString) (obj)).toStringUtf8();
                if (((ByteString) (obj)).isValidUtf8())
                {
                    functionId_ = s;
                }
                return s;
            } else
            {
                return (String)obj;
            }
        }

        public ByteString getFunctionIdBytes()
        {
            Object obj = functionId_;
            if (obj instanceof String)
            {
                obj = ByteString.copyFromUtf8((String)obj);
                functionId_ = obj;
                return ((ByteString) (obj));
            } else
            {
                return (ByteString)obj;
            }
        }

        public long getInteger()
        {
            return integer_;
        }

        public Value getListItem(int i)
        {
            return (Value)listItem_.get(i);
        }

        public int getListItemCount()
        {
            return listItem_.size();
        }

        public List getListItemList()
        {
            return Collections.unmodifiableList(listItem_);
        }

        public String getMacroReference()
        {
            Object obj = macroReference_;
            if (!(obj instanceof String))
            {
                obj = (ByteString)obj;
                String s = ((ByteString) (obj)).toStringUtf8();
                if (((ByteString) (obj)).isValidUtf8())
                {
                    macroReference_ = s;
                }
                return s;
            } else
            {
                return (String)obj;
            }
        }

        public ByteString getMacroReferenceBytes()
        {
            Object obj = macroReference_;
            if (obj instanceof String)
            {
                obj = ByteString.copyFromUtf8((String)obj);
                macroReference_ = obj;
                return ((ByteString) (obj));
            } else
            {
                return (ByteString)obj;
            }
        }

        public Value getMapKey(int i)
        {
            return (Value)mapKey_.get(i);
        }

        public int getMapKeyCount()
        {
            return mapKey_.size();
        }

        public List getMapKeyList()
        {
            return Collections.unmodifiableList(mapKey_);
        }

        public Value getMapValue(int i)
        {
            return (Value)mapValue_.get(i);
        }

        public int getMapValueCount()
        {
            return mapValue_.size();
        }

        public List getMapValueList()
        {
            return Collections.unmodifiableList(mapValue_);
        }

        public String getString()
        {
            Object obj = string_;
            if (!(obj instanceof String))
            {
                obj = (ByteString)obj;
                String s = ((ByteString) (obj)).toStringUtf8();
                if (((ByteString) (obj)).isValidUtf8())
                {
                    string_ = s;
                }
                return s;
            } else
            {
                return (String)obj;
            }
        }

        public ByteString getStringBytes()
        {
            Object obj = string_;
            if (obj instanceof String)
            {
                obj = ByteString.copyFromUtf8((String)obj);
                string_ = obj;
                return ((ByteString) (obj));
            } else
            {
                return (ByteString)obj;
            }
        }

        public Value getTemplateToken(int i)
        {
            return (Value)templateToken_.get(i);
        }

        public int getTemplateTokenCount()
        {
            return templateToken_.size();
        }

        public List getTemplateTokenList()
        {
            return Collections.unmodifiableList(templateToken_);
        }

        public Value.Type getType()
        {
            return type_;
        }

        public boolean hasBoolean()
        {
            return (bitField0_ & 0x100) == 256;
        }

        public boolean hasContainsReferences()
        {
            return (bitField0_ & 0x800) == 2048;
        }

        public boolean hasFunctionId()
        {
            return (bitField0_ & 0x40) == 64;
        }

        public boolean hasInteger()
        {
            return (bitField0_ & 0x80) == 128;
        }

        public boolean hasMacroReference()
        {
            return (bitField0_ & 0x20) == 32;
        }

        public boolean hasString()
        {
            return (bitField0_ & 2) == 2;
        }

        public boolean hasType()
        {
            return (bitField0_ & 1) == 1;
        }

        public final boolean isInitialized()
        {
            if (hasType()) goto _L2; else goto _L1
_L1:
            return false;
_L2:
            int i = 0;
_L4:
            if (i >= getListItemCount())
            {
                break MISSING_BLOCK_LABEL_37;
            }
            if (!getListItem(i).isInitialized()) goto _L1; else goto _L3
_L3:
            i++;
              goto _L4
            i = 0;
_L6:
            if (i >= getMapKeyCount())
            {
                break MISSING_BLOCK_LABEL_65;
            }
            if (!getMapKey(i).isInitialized()) goto _L1; else goto _L5
_L5:
            i++;
              goto _L6
            i = 0;
_L8:
            if (i >= getMapValueCount())
            {
                break MISSING_BLOCK_LABEL_93;
            }
            if (!getMapValue(i).isInitialized()) goto _L1; else goto _L7
_L7:
            i++;
              goto _L8
            i = 0;
_L10:
            if (i >= getTemplateTokenCount())
            {
                continue; /* Loop/switch isn't completed */
            }
            if (!getTemplateToken(i).isInitialized()) goto _L1; else goto _L9
_L9:
            i++;
              goto _L10
            if (!extensionsAreInitialized()) goto _L1; else goto _L11
_L11:
            return true;
        }

        public Value.Builder mergeFrom(Value value)
        {
            if (value == Value.getDefaultInstance())
            {
                return this;
            }
            if (value.hasType())
            {
                setType(value.getType());
            }
            if (value.hasString())
            {
                bitField0_ = bitField0_ | 2;
                string_ = value.string_;
            }
            if (!value.listItem_.isEmpty())
            {
                if (listItem_.isEmpty())
                {
                    listItem_ = value.listItem_;
                    bitField0_ = bitField0_ & -5;
                } else
                {
                    ensureListItemIsMutable();
                    listItem_.addAll(value.listItem_);
                }
            }
            if (!value.mapKey_.isEmpty())
            {
                if (mapKey_.isEmpty())
                {
                    mapKey_ = value.mapKey_;
                    bitField0_ = bitField0_ & -9;
                } else
                {
                    ensureMapKeyIsMutable();
                    mapKey_.addAll(value.mapKey_);
                }
            }
            if (!value.mapValue_.isEmpty())
            {
                if (mapValue_.isEmpty())
                {
                    mapValue_ = value.mapValue_;
                    bitField0_ = bitField0_ & 0xffffffef;
                } else
                {
                    ensureMapValueIsMutable();
                    mapValue_.addAll(value.mapValue_);
                }
            }
            if (value.hasMacroReference())
            {
                bitField0_ = bitField0_ | 0x20;
                macroReference_ = value.macroReference_;
            }
            if (value.hasFunctionId())
            {
                bitField0_ = bitField0_ | 0x40;
                functionId_ = value.functionId_;
            }
            if (value.hasInteger())
            {
                setInteger(value.getInteger());
            }
            if (value.hasBoolean())
            {
                setBoolean(value.getBoolean());
            }
            if (!value.templateToken_.isEmpty())
            {
                if (templateToken_.isEmpty())
                {
                    templateToken_ = value.templateToken_;
                    bitField0_ = bitField0_ & 0xfffffdff;
                } else
                {
                    ensureTemplateTokenIsMutable();
                    templateToken_.addAll(value.templateToken_);
                }
            }
            if (!value.escaping_.isEmpty())
            {
                if (escaping_.isEmpty())
                {
                    escaping_ = value.escaping_;
                    bitField0_ = bitField0_ & 0xfffffbff;
                } else
                {
                    ensureEscapingIsMutable();
                    escaping_.addAll(value.escaping_);
                }
            }
            if (value.hasContainsReferences())
            {
                setContainsReferences(value.getContainsReferences());
            }
            mergeExtensionFields(value);
            setUnknownFields(getUnknownFields().concat(value.unknownFields));
            return this;
        }

        public Value.Builder mergeFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException
        {
            CodedInputStream codedinputstream1;
            Object obj;
            obj = null;
            codedinputstream1 = obj;
            codedinputstream = (Value)Value.PARSER.parsePartialFrom(codedinputstream, extensionregistrylite);
            if (codedinputstream != null)
            {
                mergeFrom(((Value) (codedinputstream)));
            }
            return this;
            extensionregistrylite;
            codedinputstream1 = obj;
            codedinputstream = (Value)extensionregistrylite.getUnfinishedMessage();
            codedinputstream1 = codedinputstream;
            throw extensionregistrylite;
            codedinputstream;
            if (codedinputstream1 != null)
            {
                mergeFrom(((Value) (codedinputstream1)));
            }
            throw codedinputstream;
        }

        public volatile com.google.tagmanager.protobuf.AbstractMessageLite.Builder mergeFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException
        {
            return mergeFrom(codedinputstream, extensionregistrylite);
        }

        public volatile com.google.tagmanager.protobuf.GeneratedMessageLite.Builder mergeFrom(GeneratedMessageLite generatedmessagelite)
        {
            return mergeFrom((Value)generatedmessagelite);
        }

        public volatile com.google.tagmanager.protobuf.MessageLite.Builder mergeFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException
        {
            return mergeFrom(codedinputstream, extensionregistrylite);
        }

        public Value.Builder removeListItem(int i)
        {
            ensureListItemIsMutable();
            listItem_.remove(i);
            return this;
        }

        public Value.Builder removeMapKey(int i)
        {
            ensureMapKeyIsMutable();
            mapKey_.remove(i);
            return this;
        }

        public Value.Builder removeMapValue(int i)
        {
            ensureMapValueIsMutable();
            mapValue_.remove(i);
            return this;
        }

        public Value.Builder removeTemplateToken(int i)
        {
            ensureTemplateTokenIsMutable();
            templateToken_.remove(i);
            return this;
        }

        public Value.Builder setBoolean(boolean flag)
        {
            bitField0_ = bitField0_ | 0x100;
            boolean_ = flag;
            return this;
        }

        public Value.Builder setContainsReferences(boolean flag)
        {
            bitField0_ = bitField0_ | 0x800;
            containsReferences_ = flag;
            return this;
        }

        public Value.Builder setEscaping(int i, Value.Escaping escaping)
        {
            if (escaping == null)
            {
                throw new NullPointerException();
            } else
            {
                ensureEscapingIsMutable();
                escaping_.set(i, escaping);
                return this;
            }
        }

        public Value.Builder setFunctionId(String s)
        {
            if (s == null)
            {
                throw new NullPointerException();
            } else
            {
                bitField0_ = bitField0_ | 0x40;
                functionId_ = s;
                return this;
            }
        }

        public Value.Builder setFunctionIdBytes(ByteString bytestring)
        {
            if (bytestring == null)
            {
                throw new NullPointerException();
            } else
            {
                bitField0_ = bitField0_ | 0x40;
                functionId_ = bytestring;
                return this;
            }
        }

        public Value.Builder setInteger(long l)
        {
            bitField0_ = bitField0_ | 0x80;
            integer_ = l;
            return this;
        }

        public Value.Builder setListItem(int i, Value.Builder builder)
        {
            ensureListItemIsMutable();
            listItem_.set(i, builder.build());
            return this;
        }

        public Value.Builder setListItem(int i, Value value)
        {
            if (value == null)
            {
                throw new NullPointerException();
            } else
            {
                ensureListItemIsMutable();
                listItem_.set(i, value);
                return this;
            }
        }

        public Value.Builder setMacroReference(String s)
        {
            if (s == null)
            {
                throw new NullPointerException();
            } else
            {
                bitField0_ = bitField0_ | 0x20;
                macroReference_ = s;
                return this;
            }
        }

        public Value.Builder setMacroReferenceBytes(ByteString bytestring)
        {
            if (bytestring == null)
            {
                throw new NullPointerException();
            } else
            {
                bitField0_ = bitField0_ | 0x20;
                macroReference_ = bytestring;
                return this;
            }
        }

        public Value.Builder setMapKey(int i, Value.Builder builder)
        {
            ensureMapKeyIsMutable();
            mapKey_.set(i, builder.build());
            return this;
        }

        public Value.Builder setMapKey(int i, Value value)
        {
            if (value == null)
            {
                throw new NullPointerException();
            } else
            {
                ensureMapKeyIsMutable();
                mapKey_.set(i, value);
                return this;
            }
        }

        public Value.Builder setMapValue(int i, Value.Builder builder)
        {
            ensureMapValueIsMutable();
            mapValue_.set(i, builder.build());
            return this;
        }

        public Value.Builder setMapValue(int i, Value value)
        {
            if (value == null)
            {
                throw new NullPointerException();
            } else
            {
                ensureMapValueIsMutable();
                mapValue_.set(i, value);
                return this;
            }
        }

        public Value.Builder setString(String s)
        {
            if (s == null)
            {
                throw new NullPointerException();
            } else
            {
                bitField0_ = bitField0_ | 2;
                string_ = s;
                return this;
            }
        }

        public Value.Builder setStringBytes(ByteString bytestring)
        {
            if (bytestring == null)
            {
                throw new NullPointerException();
            } else
            {
                bitField0_ = bitField0_ | 2;
                string_ = bytestring;
                return this;
            }
        }

        public Value.Builder setTemplateToken(int i, Value.Builder builder)
        {
            ensureTemplateTokenIsMutable();
            templateToken_.set(i, builder.build());
            return this;
        }

        public Value.Builder setTemplateToken(int i, Value value)
        {
            if (value == null)
            {
                throw new NullPointerException();
            } else
            {
                ensureTemplateTokenIsMutable();
                templateToken_.set(i, value);
                return this;
            }
        }

        public Value.Builder setType(Value.Type type)
        {
            if (type == null)
            {
                throw new NullPointerException();
            } else
            {
                bitField0_ = bitField0_ | 1;
                type_ = type;
                return this;
            }
        }


        private Value.Builder()
        {
            type_ = Value.Type.STRING;
            string_ = "";
            listItem_ = Collections.emptyList();
            mapKey_ = Collections.emptyList();
            mapValue_ = Collections.emptyList();
            macroReference_ = "";
            functionId_ = "";
            templateToken_ = Collections.emptyList();
            escaping_ = Collections.emptyList();
            maybeForceBuilderInitialization();
        }
    }

    public static final class Value.Escaping extends Enum
        implements com.google.tagmanager.protobuf.Internal.EnumLite
    {

        private static final Value.Escaping $VALUES[];
        public static final Value.Escaping CONVERT_JS_VALUE_TO_EXPRESSION;
        public static final int CONVERT_JS_VALUE_TO_EXPRESSION_VALUE = 16;
        public static final Value.Escaping ESCAPE_CSS_STRING;
        public static final int ESCAPE_CSS_STRING_VALUE = 10;
        public static final Value.Escaping ESCAPE_HTML;
        public static final Value.Escaping ESCAPE_HTML_ATTRIBUTE;
        public static final Value.Escaping ESCAPE_HTML_ATTRIBUTE_NOSPACE;
        public static final int ESCAPE_HTML_ATTRIBUTE_NOSPACE_VALUE = 4;
        public static final int ESCAPE_HTML_ATTRIBUTE_VALUE = 3;
        public static final Value.Escaping ESCAPE_HTML_RCDATA;
        public static final int ESCAPE_HTML_RCDATA_VALUE = 2;
        public static final int ESCAPE_HTML_VALUE = 1;
        public static final Value.Escaping ESCAPE_JS_REGEX;
        public static final int ESCAPE_JS_REGEX_VALUE = 9;
        public static final Value.Escaping ESCAPE_JS_STRING;
        public static final int ESCAPE_JS_STRING_VALUE = 7;
        public static final Value.Escaping ESCAPE_JS_VALUE;
        public static final int ESCAPE_JS_VALUE_VALUE = 8;
        public static final Value.Escaping ESCAPE_URI;
        public static final int ESCAPE_URI_VALUE = 12;
        public static final Value.Escaping FILTER_CSS_VALUE;
        public static final int FILTER_CSS_VALUE_VALUE = 11;
        public static final Value.Escaping FILTER_HTML_ATTRIBUTES;
        public static final int FILTER_HTML_ATTRIBUTES_VALUE = 6;
        public static final Value.Escaping FILTER_HTML_ELEMENT_NAME;
        public static final int FILTER_HTML_ELEMENT_NAME_VALUE = 5;
        public static final Value.Escaping FILTER_NORMALIZE_URI;
        public static final int FILTER_NORMALIZE_URI_VALUE = 14;
        public static final Value.Escaping NORMALIZE_URI;
        public static final int NORMALIZE_URI_VALUE = 13;
        public static final Value.Escaping NO_AUTOESCAPE;
        public static final int NO_AUTOESCAPE_VALUE = 15;
        public static final Value.Escaping TEXT;
        public static final int TEXT_VALUE = 17;
        private static com.google.tagmanager.protobuf.Internal.EnumLiteMap internalValueMap = new com.google.tagmanager.protobuf.Internal.EnumLiteMap() {

            public Value.Escaping findValueByNumber(int i)
            {
                return Value.Escaping.valueOf(i);
            }

            public volatile com.google.tagmanager.protobuf.Internal.EnumLite findValueByNumber(int i)
            {
                return findValueByNumber(i);
            }

        };
        private final int value;

        public static com.google.tagmanager.protobuf.Internal.EnumLiteMap internalGetValueMap()
        {
            return internalValueMap;
        }

        public static Value.Escaping valueOf(int i)
        {
            switch (i)
            {
            default:
                return null;

            case 1: // '\001'
                return ESCAPE_HTML;

            case 2: // '\002'
                return ESCAPE_HTML_RCDATA;

            case 3: // '\003'
                return ESCAPE_HTML_ATTRIBUTE;

            case 4: // '\004'
                return ESCAPE_HTML_ATTRIBUTE_NOSPACE;

            case 5: // '\005'
                return FILTER_HTML_ELEMENT_NAME;

            case 6: // '\006'
                return FILTER_HTML_ATTRIBUTES;

            case 7: // '\007'
                return ESCAPE_JS_STRING;

            case 8: // '\b'
                return ESCAPE_JS_VALUE;

            case 9: // '\t'
                return ESCAPE_JS_REGEX;

            case 10: // '\n'
                return ESCAPE_CSS_STRING;

            case 11: // '\013'
                return FILTER_CSS_VALUE;

            case 12: // '\f'
                return ESCAPE_URI;

            case 13: // '\r'
                return NORMALIZE_URI;

            case 14: // '\016'
                return FILTER_NORMALIZE_URI;

            case 15: // '\017'
                return NO_AUTOESCAPE;

            case 17: // '\021'
                return TEXT;

            case 16: // '\020'
                return CONVERT_JS_VALUE_TO_EXPRESSION;
            }
        }

        public static Value.Escaping valueOf(String s)
        {
            return (Value.Escaping)Enum.valueOf(com/google/analytics/midtier/proto/containertag/TypeSystem$Value$Escaping, s);
        }

        public static Value.Escaping[] values()
        {
            return (Value.Escaping[])$VALUES.clone();
        }

        public final int getNumber()
        {
            return value;
        }

        static 
        {
            ESCAPE_HTML = new Value.Escaping("ESCAPE_HTML", 0, 0, 1);
            ESCAPE_HTML_RCDATA = new Value.Escaping("ESCAPE_HTML_RCDATA", 1, 1, 2);
            ESCAPE_HTML_ATTRIBUTE = new Value.Escaping("ESCAPE_HTML_ATTRIBUTE", 2, 2, 3);
            ESCAPE_HTML_ATTRIBUTE_NOSPACE = new Value.Escaping("ESCAPE_HTML_ATTRIBUTE_NOSPACE", 3, 3, 4);
            FILTER_HTML_ELEMENT_NAME = new Value.Escaping("FILTER_HTML_ELEMENT_NAME", 4, 4, 5);
            FILTER_HTML_ATTRIBUTES = new Value.Escaping("FILTER_HTML_ATTRIBUTES", 5, 5, 6);
            ESCAPE_JS_STRING = new Value.Escaping("ESCAPE_JS_STRING", 6, 6, 7);
            ESCAPE_JS_VALUE = new Value.Escaping("ESCAPE_JS_VALUE", 7, 7, 8);
            ESCAPE_JS_REGEX = new Value.Escaping("ESCAPE_JS_REGEX", 8, 8, 9);
            ESCAPE_CSS_STRING = new Value.Escaping("ESCAPE_CSS_STRING", 9, 9, 10);
            FILTER_CSS_VALUE = new Value.Escaping("FILTER_CSS_VALUE", 10, 10, 11);
            ESCAPE_URI = new Value.Escaping("ESCAPE_URI", 11, 11, 12);
            NORMALIZE_URI = new Value.Escaping("NORMALIZE_URI", 12, 12, 13);
            FILTER_NORMALIZE_URI = new Value.Escaping("FILTER_NORMALIZE_URI", 13, 13, 14);
            NO_AUTOESCAPE = new Value.Escaping("NO_AUTOESCAPE", 14, 14, 15);
            TEXT = new Value.Escaping("TEXT", 15, 15, 17);
            CONVERT_JS_VALUE_TO_EXPRESSION = new Value.Escaping("CONVERT_JS_VALUE_TO_EXPRESSION", 16, 16, 16);
            $VALUES = (new Value.Escaping[] {
                ESCAPE_HTML, ESCAPE_HTML_RCDATA, ESCAPE_HTML_ATTRIBUTE, ESCAPE_HTML_ATTRIBUTE_NOSPACE, FILTER_HTML_ELEMENT_NAME, FILTER_HTML_ATTRIBUTES, ESCAPE_JS_STRING, ESCAPE_JS_VALUE, ESCAPE_JS_REGEX, ESCAPE_CSS_STRING, 
                FILTER_CSS_VALUE, ESCAPE_URI, NORMALIZE_URI, FILTER_NORMALIZE_URI, NO_AUTOESCAPE, TEXT, CONVERT_JS_VALUE_TO_EXPRESSION
            });
        }

        private Value.Escaping(String s, int i, int j, int k)
        {
            super(s, i);
            value = k;
        }
    }

    public static final class Value.Type extends Enum
        implements com.google.tagmanager.protobuf.Internal.EnumLite
    {

        private static final Value.Type $VALUES[];
        public static final Value.Type BOOLEAN;
        public static final int BOOLEAN_VALUE = 8;
        public static final Value.Type FUNCTION_ID;
        public static final int FUNCTION_ID_VALUE = 5;
        public static final Value.Type INTEGER;
        public static final int INTEGER_VALUE = 6;
        public static final Value.Type LIST;
        public static final int LIST_VALUE = 2;
        public static final Value.Type MACRO_REFERENCE;
        public static final int MACRO_REFERENCE_VALUE = 4;
        public static final Value.Type MAP;
        public static final int MAP_VALUE = 3;
        public static final Value.Type STRING;
        public static final int STRING_VALUE = 1;
        public static final Value.Type TEMPLATE;
        public static final int TEMPLATE_VALUE = 7;
        private static com.google.tagmanager.protobuf.Internal.EnumLiteMap internalValueMap = new com.google.tagmanager.protobuf.Internal.EnumLiteMap() {

            public Value.Type findValueByNumber(int i)
            {
                return Value.Type.valueOf(i);
            }

            public volatile com.google.tagmanager.protobuf.Internal.EnumLite findValueByNumber(int i)
            {
                return findValueByNumber(i);
            }

        };
        private final int value;

        public static com.google.tagmanager.protobuf.Internal.EnumLiteMap internalGetValueMap()
        {
            return internalValueMap;
        }

        public static Value.Type valueOf(int i)
        {
            switch (i)
            {
            default:
                return null;

            case 1: // '\001'
                return STRING;

            case 2: // '\002'
                return LIST;

            case 3: // '\003'
                return MAP;

            case 4: // '\004'
                return MACRO_REFERENCE;

            case 5: // '\005'
                return FUNCTION_ID;

            case 6: // '\006'
                return INTEGER;

            case 7: // '\007'
                return TEMPLATE;

            case 8: // '\b'
                return BOOLEAN;
            }
        }

        public static Value.Type valueOf(String s)
        {
            return (Value.Type)Enum.valueOf(com/google/analytics/midtier/proto/containertag/TypeSystem$Value$Type, s);
        }

        public static Value.Type[] values()
        {
            return (Value.Type[])$VALUES.clone();
        }

        public final int getNumber()
        {
            return value;
        }

        static 
        {
            STRING = new Value.Type("STRING", 0, 0, 1);
            LIST = new Value.Type("LIST", 1, 1, 2);
            MAP = new Value.Type("MAP", 2, 2, 3);
            MACRO_REFERENCE = new Value.Type("MACRO_REFERENCE", 3, 3, 4);
            FUNCTION_ID = new Value.Type("FUNCTION_ID", 4, 4, 5);
            INTEGER = new Value.Type("INTEGER", 5, 5, 6);
            TEMPLATE = new Value.Type("TEMPLATE", 6, 6, 7);
            BOOLEAN = new Value.Type("BOOLEAN", 7, 7, 8);
            $VALUES = (new Value.Type[] {
                STRING, LIST, MAP, MACRO_REFERENCE, FUNCTION_ID, INTEGER, TEMPLATE, BOOLEAN
            });
        }

        private Value.Type(String s, int i, int j, int k)
        {
            super(s, i);
            value = k;
        }
    }

    public static interface ValueOrBuilder
        extends com.google.tagmanager.protobuf.GeneratedMessageLite.ExtendableMessageOrBuilder
    {

        public abstract boolean getBoolean();

        public abstract boolean getContainsReferences();

        public abstract Value.Escaping getEscaping(int i);

        public abstract int getEscapingCount();

        public abstract List getEscapingList();

        public abstract String getFunctionId();

        public abstract ByteString getFunctionIdBytes();

        public abstract long getInteger();

        public abstract Value getListItem(int i);

        public abstract int getListItemCount();

        public abstract List getListItemList();

        public abstract String getMacroReference();

        public abstract ByteString getMacroReferenceBytes();

        public abstract Value getMapKey(int i);

        public abstract int getMapKeyCount();

        public abstract List getMapKeyList();

        public abstract Value getMapValue(int i);

        public abstract int getMapValueCount();

        public abstract List getMapValueList();

        public abstract String getString();

        public abstract ByteString getStringBytes();

        public abstract Value getTemplateToken(int i);

        public abstract int getTemplateTokenCount();

        public abstract List getTemplateTokenList();

        public abstract Value.Type getType();

        public abstract boolean hasBoolean();

        public abstract boolean hasContainsReferences();

        public abstract boolean hasFunctionId();

        public abstract boolean hasInteger();

        public abstract boolean hasMacroReference();

        public abstract boolean hasString();

        public abstract boolean hasType();
    }


    private TypeSystem()
    {
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionregistrylite)
    {
    }

}

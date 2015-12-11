// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.analytics.midtier.proto.containertag;

import com.google.tagmanager.protobuf.AbstractMutableMessageLite;
import com.google.tagmanager.protobuf.ByteString;
import com.google.tagmanager.protobuf.CodedInputStream;
import com.google.tagmanager.protobuf.CodedOutputStream;
import com.google.tagmanager.protobuf.ExtensionRegistryLite;
import com.google.tagmanager.protobuf.GeneratedMutableMessageLite;
import com.google.tagmanager.protobuf.Internal;
import com.google.tagmanager.protobuf.MessageLite;
import com.google.tagmanager.protobuf.MutableMessageLite;
import com.google.tagmanager.protobuf.Parser;
import java.io.IOException;
import java.io.ObjectStreamException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class MutableTypeSystem
{
    public static final class Value extends com.google.tagmanager.protobuf.GeneratedMutableMessageLite.ExtendableMutableMessage
        implements MutableMessageLite
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
        public static Parser PARSER;
        public static final int STRING_FIELD_NUMBER = 2;
        public static final int TEMPLATE_TOKEN_FIELD_NUMBER = 11;
        public static final int TYPE_FIELD_NUMBER = 1;
        private static final Value defaultInstance;
        private static volatile MessageLite immutableDefault = null;
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
        private Object string_;
        private List templateToken_;
        private Type type_;

        private void ensureEscapingInitialized()
        {
            if (escaping_ == null)
            {
                escaping_ = new ArrayList();
            }
        }

        private void ensureListItemInitialized()
        {
            if (listItem_ == null)
            {
                listItem_ = new ArrayList();
            }
        }

        private void ensureMapKeyInitialized()
        {
            if (mapKey_ == null)
            {
                mapKey_ = new ArrayList();
            }
        }

        private void ensureMapValueInitialized()
        {
            if (mapValue_ == null)
            {
                mapValue_ = new ArrayList();
            }
        }

        private void ensureTemplateTokenInitialized()
        {
            if (templateToken_ == null)
            {
                templateToken_ = new ArrayList();
            }
        }

        public static Value getDefaultInstance()
        {
            return defaultInstance;
        }

        private void initFields()
        {
            type_ = Type.STRING;
        }

        public static Value newMessage()
        {
            return new Value();
        }

        public Value addAllEscaping(Iterable iterable)
        {
            assertMutable();
            ensureEscapingInitialized();
            AbstractMutableMessageLite.addAll(iterable, escaping_);
            return this;
        }

        public Value addAllListItem(Iterable iterable)
        {
            assertMutable();
            ensureListItemInitialized();
            AbstractMutableMessageLite.addAll(iterable, listItem_);
            return this;
        }

        public Value addAllMapKey(Iterable iterable)
        {
            assertMutable();
            ensureMapKeyInitialized();
            AbstractMutableMessageLite.addAll(iterable, mapKey_);
            return this;
        }

        public Value addAllMapValue(Iterable iterable)
        {
            assertMutable();
            ensureMapValueInitialized();
            AbstractMutableMessageLite.addAll(iterable, mapValue_);
            return this;
        }

        public Value addAllTemplateToken(Iterable iterable)
        {
            assertMutable();
            ensureTemplateTokenInitialized();
            AbstractMutableMessageLite.addAll(iterable, templateToken_);
            return this;
        }

        public Value addEscaping(Escaping escaping)
        {
            assertMutable();
            if (escaping == null)
            {
                throw new NullPointerException();
            } else
            {
                ensureEscapingInitialized();
                escaping_.add(escaping);
                return this;
            }
        }

        public Value addListItem()
        {
            assertMutable();
            ensureListItemInitialized();
            Value value = newMessage();
            listItem_.add(value);
            return value;
        }

        public Value addListItem(Value value)
        {
            assertMutable();
            if (value == null)
            {
                throw new NullPointerException();
            } else
            {
                ensureListItemInitialized();
                listItem_.add(value);
                return this;
            }
        }

        public Value addMapKey()
        {
            assertMutable();
            ensureMapKeyInitialized();
            Value value = newMessage();
            mapKey_.add(value);
            return value;
        }

        public Value addMapKey(Value value)
        {
            assertMutable();
            if (value == null)
            {
                throw new NullPointerException();
            } else
            {
                ensureMapKeyInitialized();
                mapKey_.add(value);
                return this;
            }
        }

        public Value addMapValue()
        {
            assertMutable();
            ensureMapValueInitialized();
            Value value = newMessage();
            mapValue_.add(value);
            return value;
        }

        public Value addMapValue(Value value)
        {
            assertMutable();
            if (value == null)
            {
                throw new NullPointerException();
            } else
            {
                ensureMapValueInitialized();
                mapValue_.add(value);
                return this;
            }
        }

        public Value addTemplateToken()
        {
            assertMutable();
            ensureTemplateTokenInitialized();
            Value value = newMessage();
            templateToken_.add(value);
            return value;
        }

        public Value addTemplateToken(Value value)
        {
            assertMutable();
            if (value == null)
            {
                throw new NullPointerException();
            } else
            {
                ensureTemplateTokenInitialized();
                templateToken_.add(value);
                return this;
            }
        }

        public Value clear()
        {
            assertMutable();
            super.clear();
            type_ = Type.STRING;
            bitField0_ = bitField0_ & -2;
            string_ = Internal.EMPTY_BYTE_ARRAY;
            bitField0_ = bitField0_ & -3;
            listItem_ = null;
            mapKey_ = null;
            mapValue_ = null;
            macroReference_ = Internal.EMPTY_BYTE_ARRAY;
            bitField0_ = bitField0_ & -5;
            functionId_ = Internal.EMPTY_BYTE_ARRAY;
            bitField0_ = bitField0_ & -9;
            integer_ = 0L;
            bitField0_ = bitField0_ & 0xffffffef;
            boolean_ = false;
            bitField0_ = bitField0_ & 0xffffffdf;
            templateToken_ = null;
            escaping_ = null;
            containsReferences_ = false;
            bitField0_ = bitField0_ & 0xffffffbf;
            return this;
        }

        public volatile com.google.tagmanager.protobuf.GeneratedMutableMessageLite.ExtendableMutableMessage clear()
        {
            return clear();
        }

        public volatile GeneratedMutableMessageLite clear()
        {
            return clear();
        }

        public volatile MutableMessageLite clear()
        {
            return clear();
        }

        public Value clearBoolean()
        {
            assertMutable();
            bitField0_ = bitField0_ & 0xffffffdf;
            boolean_ = false;
            return this;
        }

        public Value clearContainsReferences()
        {
            assertMutable();
            bitField0_ = bitField0_ & 0xffffffbf;
            containsReferences_ = false;
            return this;
        }

        public Value clearEscaping()
        {
            assertMutable();
            escaping_ = null;
            return this;
        }

        public Value clearFunctionId()
        {
            assertMutable();
            bitField0_ = bitField0_ & -9;
            functionId_ = Internal.EMPTY_BYTE_ARRAY;
            return this;
        }

        public Value clearInteger()
        {
            assertMutable();
            bitField0_ = bitField0_ & 0xffffffef;
            integer_ = 0L;
            return this;
        }

        public Value clearListItem()
        {
            assertMutable();
            listItem_ = null;
            return this;
        }

        public Value clearMacroReference()
        {
            assertMutable();
            bitField0_ = bitField0_ & -5;
            macroReference_ = Internal.EMPTY_BYTE_ARRAY;
            return this;
        }

        public Value clearMapKey()
        {
            assertMutable();
            mapKey_ = null;
            return this;
        }

        public Value clearMapValue()
        {
            assertMutable();
            mapValue_ = null;
            return this;
        }

        public Value clearString()
        {
            assertMutable();
            bitField0_ = bitField0_ & -3;
            string_ = Internal.EMPTY_BYTE_ARRAY;
            return this;
        }

        public Value clearTemplateToken()
        {
            assertMutable();
            templateToken_ = null;
            return this;
        }

        public Value clearType()
        {
            assertMutable();
            bitField0_ = bitField0_ & -2;
            type_ = Type.STRING;
            return this;
        }

        public Value clone()
        {
            return newMessageForType().mergeFrom(this);
        }

        public volatile MutableMessageLite clone()
        {
            return clone();
        }

        public volatile Object clone()
            throws CloneNotSupportedException
        {
            return clone();
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

        public final Value getDefaultInstanceForType()
        {
            return defaultInstance;
        }

        public volatile GeneratedMutableMessageLite getDefaultInstanceForType()
        {
            return getDefaultInstanceForType();
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
            if (escaping_ == null)
            {
                return 0;
            } else
            {
                return escaping_.size();
            }
        }

        public List getEscapingList()
        {
            if (escaping_ == null)
            {
                return Collections.emptyList();
            } else
            {
                return Collections.unmodifiableList(escaping_);
            }
        }

        public String getFunctionId()
        {
            Object obj = functionId_;
            if (obj instanceof String)
            {
                return (String)obj;
            }
            byte abyte0[] = (byte[])(byte[])obj;
            String s = Internal.toStringUtf8(abyte0);
            if (Internal.isValidUtf8(abyte0))
            {
                functionId_ = s;
            }
            return s;
        }

        public byte[] getFunctionIdAsBytes()
        {
            byte abyte0[] = ((byte []) (functionId_));
            if (abyte0 instanceof String)
            {
                abyte0 = Internal.toByteArray((String)abyte0);
                functionId_ = abyte0;
                return abyte0;
            } else
            {
                return (byte[])(byte[])abyte0;
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
            if (listItem_ == null)
            {
                return 0;
            } else
            {
                return listItem_.size();
            }
        }

        public List getListItemList()
        {
            if (listItem_ == null)
            {
                return Collections.emptyList();
            } else
            {
                return Collections.unmodifiableList(listItem_);
            }
        }

        public String getMacroReference()
        {
            Object obj = macroReference_;
            if (obj instanceof String)
            {
                return (String)obj;
            }
            byte abyte0[] = (byte[])(byte[])obj;
            String s = Internal.toStringUtf8(abyte0);
            if (Internal.isValidUtf8(abyte0))
            {
                macroReference_ = s;
            }
            return s;
        }

        public byte[] getMacroReferenceAsBytes()
        {
            byte abyte0[] = ((byte []) (macroReference_));
            if (abyte0 instanceof String)
            {
                abyte0 = Internal.toByteArray((String)abyte0);
                macroReference_ = abyte0;
                return abyte0;
            } else
            {
                return (byte[])(byte[])abyte0;
            }
        }

        public Value getMapKey(int i)
        {
            return (Value)mapKey_.get(i);
        }

        public int getMapKeyCount()
        {
            if (mapKey_ == null)
            {
                return 0;
            } else
            {
                return mapKey_.size();
            }
        }

        public List getMapKeyList()
        {
            if (mapKey_ == null)
            {
                return Collections.emptyList();
            } else
            {
                return Collections.unmodifiableList(mapKey_);
            }
        }

        public Value getMapValue(int i)
        {
            return (Value)mapValue_.get(i);
        }

        public int getMapValueCount()
        {
            if (mapValue_ == null)
            {
                return 0;
            } else
            {
                return mapValue_.size();
            }
        }

        public List getMapValueList()
        {
            if (mapValue_ == null)
            {
                return Collections.emptyList();
            } else
            {
                return Collections.unmodifiableList(mapValue_);
            }
        }

        public List getMutableEscapingList()
        {
            assertMutable();
            ensureEscapingInitialized();
            return escaping_;
        }

        public Value getMutableListItem(int i)
        {
            return (Value)listItem_.get(i);
        }

        public List getMutableListItemList()
        {
            assertMutable();
            ensureListItemInitialized();
            return listItem_;
        }

        public Value getMutableMapKey(int i)
        {
            return (Value)mapKey_.get(i);
        }

        public List getMutableMapKeyList()
        {
            assertMutable();
            ensureMapKeyInitialized();
            return mapKey_;
        }

        public Value getMutableMapValue(int i)
        {
            return (Value)mapValue_.get(i);
        }

        public List getMutableMapValueList()
        {
            assertMutable();
            ensureMapValueInitialized();
            return mapValue_;
        }

        public Value getMutableTemplateToken(int i)
        {
            return (Value)templateToken_.get(i);
        }

        public List getMutableTemplateTokenList()
        {
            assertMutable();
            ensureTemplateTokenInitialized();
            return templateToken_;
        }

        public Parser getParserForType()
        {
            return PARSER;
        }

        public int getSerializedSize()
        {
            int i = 0 + CodedOutputStream.computeEnumSize(1, type_.getNumber());
            int j = i;
            if ((bitField0_ & 2) == 2)
            {
                j = i + CodedOutputStream.computeByteArraySize(2, getStringAsBytes());
            }
            i = j;
            if (listItem_ != null)
            {
                int k = 0;
                do
                {
                    i = j;
                    if (k >= listItem_.size())
                    {
                        break;
                    }
                    j += CodedOutputStream.computeMessageSize(3, (MessageLite)listItem_.get(k));
                    k++;
                } while (true);
            }
            j = i;
            if (mapKey_ != null)
            {
                int l = 0;
                do
                {
                    j = i;
                    if (l >= mapKey_.size())
                    {
                        break;
                    }
                    i += CodedOutputStream.computeMessageSize(4, (MessageLite)mapKey_.get(l));
                    l++;
                } while (true);
            }
            i = j;
            if (mapValue_ != null)
            {
                int i1 = 0;
                do
                {
                    i = j;
                    if (i1 >= mapValue_.size())
                    {
                        break;
                    }
                    j += CodedOutputStream.computeMessageSize(5, (MessageLite)mapValue_.get(i1));
                    i1++;
                } while (true);
            }
            j = i;
            if ((bitField0_ & 4) == 4)
            {
                j = i + CodedOutputStream.computeByteArraySize(6, getMacroReferenceAsBytes());
            }
            i = j;
            if ((bitField0_ & 8) == 8)
            {
                i = j + CodedOutputStream.computeByteArraySize(7, getFunctionIdAsBytes());
            }
            j = i;
            if ((bitField0_ & 0x10) == 16)
            {
                j = i + CodedOutputStream.computeInt64Size(8, integer_);
            }
            i = j;
            if ((bitField0_ & 0x20) == 32)
            {
                i = j + CodedOutputStream.computeBoolSize(12, boolean_);
            }
            j = i;
            if (templateToken_ != null)
            {
                int j1 = 0;
                do
                {
                    j = i;
                    if (j1 >= templateToken_.size())
                    {
                        break;
                    }
                    i += CodedOutputStream.computeMessageSize(11, (MessageLite)templateToken_.get(j1));
                    j1++;
                } while (true);
            }
            i = j;
            if (escaping_ != null)
            {
                i = j;
                if (escaping_.size() > 0)
                {
                    int k1 = 0;
                    for (i = 0; i < escaping_.size(); i++)
                    {
                        k1 += CodedOutputStream.computeEnumSizeNoTag(((Escaping)escaping_.get(i)).getNumber());
                    }

                    i = j + k1 + escaping_.size() * 1;
                }
            }
            j = i;
            if ((bitField0_ & 0x40) == 64)
            {
                j = i + CodedOutputStream.computeBoolSize(9, containsReferences_);
            }
            i = j + extensionsSerializedSize() + unknownFields.size();
            cachedSize = i;
            return i;
        }

        public String getString()
        {
            Object obj = string_;
            if (obj instanceof String)
            {
                return (String)obj;
            }
            byte abyte0[] = (byte[])(byte[])obj;
            String s = Internal.toStringUtf8(abyte0);
            if (Internal.isValidUtf8(abyte0))
            {
                string_ = s;
            }
            return s;
        }

        public byte[] getStringAsBytes()
        {
            byte abyte0[] = ((byte []) (string_));
            if (abyte0 instanceof String)
            {
                abyte0 = Internal.toByteArray((String)abyte0);
                string_ = abyte0;
                return abyte0;
            } else
            {
                return (byte[])(byte[])abyte0;
            }
        }

        public Value getTemplateToken(int i)
        {
            return (Value)templateToken_.get(i);
        }

        public int getTemplateTokenCount()
        {
            if (templateToken_ == null)
            {
                return 0;
            } else
            {
                return templateToken_.size();
            }
        }

        public List getTemplateTokenList()
        {
            if (templateToken_ == null)
            {
                return Collections.emptyList();
            } else
            {
                return Collections.unmodifiableList(templateToken_);
            }
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
            int j = 41;
            if (hasType())
            {
                j = 0x13a46 + Internal.hashEnum(getType());
            }
            int i = j;
            if (hasString())
            {
                i = (j * 37 + 2) * 53 + getString().hashCode();
            }
            j = i;
            if (getListItemCount() > 0)
            {
                j = (i * 37 + 3) * 53 + getListItemList().hashCode();
            }
            i = j;
            if (getMapKeyCount() > 0)
            {
                i = (j * 37 + 4) * 53 + getMapKeyList().hashCode();
            }
            j = i;
            if (getMapValueCount() > 0)
            {
                j = (i * 37 + 5) * 53 + getMapValueList().hashCode();
            }
            i = j;
            if (hasMacroReference())
            {
                i = (j * 37 + 6) * 53 + getMacroReference().hashCode();
            }
            j = i;
            if (hasFunctionId())
            {
                j = (i * 37 + 7) * 53 + getFunctionId().hashCode();
            }
            i = j;
            if (hasInteger())
            {
                i = (j * 37 + 8) * 53 + Internal.hashLong(getInteger());
            }
            j = i;
            if (hasBoolean())
            {
                j = (i * 37 + 12) * 53 + Internal.hashBoolean(getBoolean());
            }
            i = j;
            if (getTemplateTokenCount() > 0)
            {
                i = (j * 37 + 11) * 53 + getTemplateTokenList().hashCode();
            }
            j = i;
            if (getEscapingCount() > 0)
            {
                j = (i * 37 + 10) * 53 + Internal.hashEnumList(getEscapingList());
            }
            i = j;
            if (hasContainsReferences())
            {
                i = (j * 37 + 9) * 53 + Internal.hashBoolean(getContainsReferences());
            }
            return i * 29 + unknownFields.hashCode();
        }

        protected MessageLite internalImmutableDefault()
        {
            if (immutableDefault == null)
            {
                immutableDefault = internalImmutableDefault("com.google.analytics.midtier.proto.containertag.TypeSystem$Value");
            }
            return immutableDefault;
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

        public Value mergeFrom(Value value)
        {
            if (this == value)
            {
                throw new IllegalArgumentException("mergeFrom(message) called on the same message.");
            }
            assertMutable();
            if (value == getDefaultInstance())
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
                if (value.string_ instanceof String)
                {
                    string_ = value.string_;
                } else
                {
                    byte abyte0[] = (byte[])(byte[])value.string_;
                    string_ = Arrays.copyOf(abyte0, abyte0.length);
                }
            }
            if (value.listItem_ != null && !value.listItem_.isEmpty())
            {
                ensureListItemInitialized();
                AbstractMutableMessageLite.addAll(value.listItem_, listItem_);
            }
            if (value.mapKey_ != null && !value.mapKey_.isEmpty())
            {
                ensureMapKeyInitialized();
                AbstractMutableMessageLite.addAll(value.mapKey_, mapKey_);
            }
            if (value.mapValue_ != null && !value.mapValue_.isEmpty())
            {
                ensureMapValueInitialized();
                AbstractMutableMessageLite.addAll(value.mapValue_, mapValue_);
            }
            if (value.hasMacroReference())
            {
                bitField0_ = bitField0_ | 4;
                if (value.macroReference_ instanceof String)
                {
                    macroReference_ = value.macroReference_;
                } else
                {
                    byte abyte1[] = (byte[])(byte[])value.macroReference_;
                    macroReference_ = Arrays.copyOf(abyte1, abyte1.length);
                }
            }
            if (value.hasFunctionId())
            {
                bitField0_ = bitField0_ | 8;
                if (value.functionId_ instanceof String)
                {
                    functionId_ = value.functionId_;
                } else
                {
                    byte abyte2[] = (byte[])(byte[])value.functionId_;
                    functionId_ = Arrays.copyOf(abyte2, abyte2.length);
                }
            }
            if (value.hasInteger())
            {
                setInteger(value.getInteger());
            }
            if (value.hasContainsReferences())
            {
                setContainsReferences(value.getContainsReferences());
            }
            if (value.escaping_ != null && !value.escaping_.isEmpty())
            {
                ensureEscapingInitialized();
                escaping_.addAll(value.escaping_);
            }
            if (value.templateToken_ != null && !value.templateToken_.isEmpty())
            {
                ensureTemplateTokenInitialized();
                AbstractMutableMessageLite.addAll(value.templateToken_, templateToken_);
            }
            if (value.hasBoolean())
            {
                setBoolean(value.getBoolean());
            }
            mergeExtensionFields(value);
            unknownFields = unknownFields.concat(value.unknownFields);
            return this;
        }

        public volatile GeneratedMutableMessageLite mergeFrom(GeneratedMutableMessageLite generatedmutablemessagelite)
        {
            return mergeFrom((Value)generatedmutablemessagelite);
        }

        public boolean mergeFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
        {
            assertMutable();
            com.google.tagmanager.protobuf.ByteString.Output output;
            CodedOutputStream codedoutputstream;
            Object obj;
            boolean flag;
            int i;
            int j;
            int k;
            try
            {
                output = ByteString.newOutput();
                codedoutputstream = CodedOutputStream.newInstance(output);
            }
            // Misplaced declaration of an exception variable
            catch (CodedInputStream codedinputstream)
            {
                return false;
            }
            flag = false;
            if (flag) goto _L2; else goto _L1
_L1:
            i = codedinputstream.readTag();
            i;
            JVM INSTR lookupswitch 14: default 580
        //                       0: 583
        //                       8: 171
        //                       18: 225
        //                       26: 246
        //                       34: 258
        //                       42: 270
        //                       50: 282
        //                       58: 303
        //                       64: 325
        //                       72: 347
        //                       80: 369
        //                       82: 437
        //                       90: 531
        //                       96: 543;
               goto _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17
_L3:
            if (!parseUnknownField(codedinputstream, codedoutputstream, extensionregistrylite, i))
            {
                flag = true;
            }
            continue; /* Loop/switch isn't completed */
_L5:
            j = codedinputstream.readEnum();
            obj = Type.valueOf(j);
            if (obj != null) goto _L19; else goto _L18
_L18:
            codedoutputstream.writeRawVarint32(i);
            codedoutputstream.writeRawVarint32(j);
            continue; /* Loop/switch isn't completed */
_L19:
            bitField0_ = bitField0_ | 1;
            type_ = ((Type) (obj));
            continue; /* Loop/switch isn't completed */
_L6:
            bitField0_ = bitField0_ | 2;
            string_ = codedinputstream.readByteArray();
            continue; /* Loop/switch isn't completed */
_L7:
            codedinputstream.readMessage(addListItem(), extensionregistrylite);
            continue; /* Loop/switch isn't completed */
_L8:
            codedinputstream.readMessage(addMapKey(), extensionregistrylite);
            continue; /* Loop/switch isn't completed */
_L9:
            codedinputstream.readMessage(addMapValue(), extensionregistrylite);
            continue; /* Loop/switch isn't completed */
_L10:
            bitField0_ = bitField0_ | 4;
            macroReference_ = codedinputstream.readByteArray();
            continue; /* Loop/switch isn't completed */
_L11:
            bitField0_ = bitField0_ | 8;
            functionId_ = codedinputstream.readByteArray();
            continue; /* Loop/switch isn't completed */
_L12:
            bitField0_ = bitField0_ | 0x10;
            integer_ = codedinputstream.readInt64();
            continue; /* Loop/switch isn't completed */
_L13:
            bitField0_ = bitField0_ | 0x40;
            containsReferences_ = codedinputstream.readBool();
            continue; /* Loop/switch isn't completed */
_L14:
            j = codedinputstream.readEnum();
            obj = Escaping.valueOf(j);
            if (obj != null) goto _L21; else goto _L20
_L20:
            codedoutputstream.writeRawVarint32(i);
            codedoutputstream.writeRawVarint32(j);
            continue; /* Loop/switch isn't completed */
_L21:
            if (escaping_ == null)
            {
                escaping_ = new ArrayList();
            }
            escaping_.add(obj);
            continue; /* Loop/switch isn't completed */
_L15:
            j = codedinputstream.pushLimit(codedinputstream.readRawVarint32());
_L26:
            if (codedinputstream.getBytesUntilLimit() <= 0) goto _L23; else goto _L22
_L22:
            k = codedinputstream.readEnum();
            obj = Escaping.valueOf(k);
            if (obj != null) goto _L25; else goto _L24
_L24:
            codedoutputstream.writeRawVarint32(i);
            codedoutputstream.writeRawVarint32(k);
              goto _L26
_L25:
            if (escaping_ == null)
            {
                escaping_ = new ArrayList();
            }
            escaping_.add(obj);
              goto _L26
_L23:
            codedinputstream.popLimit(j);
            continue; /* Loop/switch isn't completed */
_L16:
            codedinputstream.readMessage(addTemplateToken(), extensionregistrylite);
            continue; /* Loop/switch isn't completed */
_L17:
            bitField0_ = bitField0_ | 0x20;
            boolean_ = codedinputstream.readBool();
            continue; /* Loop/switch isn't completed */
_L2:
            codedoutputstream.flush();
            unknownFields = output.toByteString();
            return true;
_L4:
            flag = true;
            if (true) goto _L28; else goto _L27
_L28:
            break MISSING_BLOCK_LABEL_17;
_L27:
        }

        public Value newMessageForType()
        {
            return new Value();
        }

        public volatile MutableMessageLite newMessageForType()
        {
            return newMessageForType();
        }

        public Value setBoolean(boolean flag)
        {
            assertMutable();
            bitField0_ = bitField0_ | 0x20;
            boolean_ = flag;
            return this;
        }

        public Value setContainsReferences(boolean flag)
        {
            assertMutable();
            bitField0_ = bitField0_ | 0x40;
            containsReferences_ = flag;
            return this;
        }

        public Value setEscaping(int i, Escaping escaping)
        {
            assertMutable();
            if (escaping == null)
            {
                throw new NullPointerException();
            } else
            {
                ensureEscapingInitialized();
                escaping_.set(i, escaping);
                return this;
            }
        }

        public Value setFunctionId(String s)
        {
            assertMutable();
            if (s == null)
            {
                throw new NullPointerException();
            } else
            {
                bitField0_ = bitField0_ | 8;
                functionId_ = s;
                return this;
            }
        }

        public Value setFunctionIdAsBytes(byte abyte0[])
        {
            assertMutable();
            if (abyte0 == null)
            {
                throw new NullPointerException();
            } else
            {
                bitField0_ = bitField0_ | 8;
                functionId_ = abyte0;
                return this;
            }
        }

        public Value setInteger(long l)
        {
            assertMutable();
            bitField0_ = bitField0_ | 0x10;
            integer_ = l;
            return this;
        }

        public Value setListItem(int i, Value value)
        {
            assertMutable();
            if (value == null)
            {
                throw new NullPointerException();
            } else
            {
                ensureListItemInitialized();
                listItem_.set(i, value);
                return this;
            }
        }

        public Value setMacroReference(String s)
        {
            assertMutable();
            if (s == null)
            {
                throw new NullPointerException();
            } else
            {
                bitField0_ = bitField0_ | 4;
                macroReference_ = s;
                return this;
            }
        }

        public Value setMacroReferenceAsBytes(byte abyte0[])
        {
            assertMutable();
            if (abyte0 == null)
            {
                throw new NullPointerException();
            } else
            {
                bitField0_ = bitField0_ | 4;
                macroReference_ = abyte0;
                return this;
            }
        }

        public Value setMapKey(int i, Value value)
        {
            assertMutable();
            if (value == null)
            {
                throw new NullPointerException();
            } else
            {
                ensureMapKeyInitialized();
                mapKey_.set(i, value);
                return this;
            }
        }

        public Value setMapValue(int i, Value value)
        {
            assertMutable();
            if (value == null)
            {
                throw new NullPointerException();
            } else
            {
                ensureMapValueInitialized();
                mapValue_.set(i, value);
                return this;
            }
        }

        public Value setString(String s)
        {
            assertMutable();
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

        public Value setStringAsBytes(byte abyte0[])
        {
            assertMutable();
            if (abyte0 == null)
            {
                throw new NullPointerException();
            } else
            {
                bitField0_ = bitField0_ | 2;
                string_ = abyte0;
                return this;
            }
        }

        public Value setTemplateToken(int i, Value value)
        {
            assertMutable();
            if (value == null)
            {
                throw new NullPointerException();
            } else
            {
                ensureTemplateTokenInitialized();
                templateToken_.set(i, value);
                return this;
            }
        }

        public Value setType(Type type)
        {
            assertMutable();
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

        protected Object writeReplace()
            throws ObjectStreamException
        {
            return super.writeReplace();
        }

        public void writeToWithCachedSizes(CodedOutputStream codedoutputstream)
            throws IOException
        {
            int k1 = codedoutputstream.getTotalBytesWritten();
            com.google.tagmanager.protobuf.GeneratedMutableMessageLite.ExtendableMutableMessage.ExtensionWriter extensionwriter = newExtensionWriter();
            codedoutputstream.writeEnum(1, type_.getNumber());
            if ((bitField0_ & 2) == 2)
            {
                codedoutputstream.writeByteArray(2, getStringAsBytes());
            }
            if (listItem_ != null)
            {
                for (int i = 0; i < listItem_.size(); i++)
                {
                    codedoutputstream.writeMessageWithCachedSizes(3, (MutableMessageLite)listItem_.get(i));
                }

            }
            if (mapKey_ != null)
            {
                for (int j = 0; j < mapKey_.size(); j++)
                {
                    codedoutputstream.writeMessageWithCachedSizes(4, (MutableMessageLite)mapKey_.get(j));
                }

            }
            if (mapValue_ != null)
            {
                for (int k = 0; k < mapValue_.size(); k++)
                {
                    codedoutputstream.writeMessageWithCachedSizes(5, (MutableMessageLite)mapValue_.get(k));
                }

            }
            if ((bitField0_ & 4) == 4)
            {
                codedoutputstream.writeByteArray(6, getMacroReferenceAsBytes());
            }
            if ((bitField0_ & 8) == 8)
            {
                codedoutputstream.writeByteArray(7, getFunctionIdAsBytes());
            }
            if ((bitField0_ & 0x10) == 16)
            {
                codedoutputstream.writeInt64(8, integer_);
            }
            if ((bitField0_ & 0x40) == 64)
            {
                codedoutputstream.writeBool(9, containsReferences_);
            }
            if (escaping_ != null)
            {
                for (int l = 0; l < escaping_.size(); l++)
                {
                    codedoutputstream.writeEnum(10, ((Escaping)escaping_.get(l)).getNumber());
                }

            }
            if (templateToken_ != null)
            {
                for (int i1 = 0; i1 < templateToken_.size(); i1++)
                {
                    codedoutputstream.writeMessageWithCachedSizes(11, (MutableMessageLite)templateToken_.get(i1));
                }

            }
            if ((bitField0_ & 0x20) == 32)
            {
                codedoutputstream.writeBool(12, boolean_);
            }
            extensionwriter.writeUntil(0x20000000, codedoutputstream);
            codedoutputstream.writeRawBytes(unknownFields);
            int j1 = codedoutputstream.getTotalBytesWritten();
            if (getCachedSize() != j1 - k1)
            {
                throw new RuntimeException("Serialized size doesn't match cached size. You may forget to call getSerializedSize() or the message is being modified concurrently.");
            } else
            {
                return;
            }
        }

        static 
        {
            defaultInstance = new Value(true);
            defaultInstance.initFields();
            defaultInstance.makeImmutable();
            PARSER = AbstractMutableMessageLite.internalNewParserForType(defaultInstance);
        }

        private Value()
        {
            type_ = Type.STRING;
            string_ = Internal.EMPTY_BYTE_ARRAY;
            listItem_ = null;
            mapKey_ = null;
            mapValue_ = null;
            macroReference_ = Internal.EMPTY_BYTE_ARRAY;
            functionId_ = Internal.EMPTY_BYTE_ARRAY;
            templateToken_ = null;
            escaping_ = null;
            initFields();
        }

        private Value(boolean flag)
        {
            type_ = Type.STRING;
            string_ = Internal.EMPTY_BYTE_ARRAY;
            listItem_ = null;
            mapKey_ = null;
            mapValue_ = null;
            macroReference_ = Internal.EMPTY_BYTE_ARRAY;
            functionId_ = Internal.EMPTY_BYTE_ARRAY;
            templateToken_ = null;
            escaping_ = null;
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
            return (Value.Escaping)Enum.valueOf(com/google/analytics/midtier/proto/containertag/MutableTypeSystem$Value$Escaping, s);
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
            return (Value.Type)Enum.valueOf(com/google/analytics/midtier/proto/containertag/MutableTypeSystem$Value$Type, s);
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


    private MutableTypeSystem()
    {
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionregistrylite)
    {
    }

}

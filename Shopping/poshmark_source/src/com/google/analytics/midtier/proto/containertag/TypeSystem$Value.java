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

// Referenced classes of package com.google.analytics.midtier.proto.containertag:
//            TypeSystem

public static final class unknownFields extends com.google.tagmanager.protobuf.ite.ExtendableMessage
    implements rBuilder
{
    public static final class Builder extends com.google.tagmanager.protobuf.GeneratedMessageLite.ExtendableBuilder
        implements TypeSystem.ValueOrBuilder
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
        private Type type_;

        private static Builder create()
        {
            return new Builder();
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

        public Builder addAllEscaping(Iterable iterable)
        {
            ensureEscapingIsMutable();
            com.google.tagmanager.protobuf.AbstractMessageLite.Builder.addAll(iterable, escaping_);
            return this;
        }

        public Builder addAllListItem(Iterable iterable)
        {
            ensureListItemIsMutable();
            com.google.tagmanager.protobuf.AbstractMessageLite.Builder.addAll(iterable, listItem_);
            return this;
        }

        public Builder addAllMapKey(Iterable iterable)
        {
            ensureMapKeyIsMutable();
            com.google.tagmanager.protobuf.AbstractMessageLite.Builder.addAll(iterable, mapKey_);
            return this;
        }

        public Builder addAllMapValue(Iterable iterable)
        {
            ensureMapValueIsMutable();
            com.google.tagmanager.protobuf.AbstractMessageLite.Builder.addAll(iterable, mapValue_);
            return this;
        }

        public Builder addAllTemplateToken(Iterable iterable)
        {
            ensureTemplateTokenIsMutable();
            com.google.tagmanager.protobuf.AbstractMessageLite.Builder.addAll(iterable, templateToken_);
            return this;
        }

        public Builder addEscaping(Escaping escaping)
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

        public Builder addListItem(int i, Builder builder)
        {
            ensureListItemIsMutable();
            listItem_.add(i, builder.build());
            return this;
        }

        public Builder addListItem(int i, TypeSystem.Value value)
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

        public Builder addListItem(Builder builder)
        {
            ensureListItemIsMutable();
            listItem_.add(builder.build());
            return this;
        }

        public Builder addListItem(TypeSystem.Value value)
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

        public Builder addMapKey(int i, Builder builder)
        {
            ensureMapKeyIsMutable();
            mapKey_.add(i, builder.build());
            return this;
        }

        public Builder addMapKey(int i, TypeSystem.Value value)
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

        public Builder addMapKey(Builder builder)
        {
            ensureMapKeyIsMutable();
            mapKey_.add(builder.build());
            return this;
        }

        public Builder addMapKey(TypeSystem.Value value)
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

        public Builder addMapValue(int i, Builder builder)
        {
            ensureMapValueIsMutable();
            mapValue_.add(i, builder.build());
            return this;
        }

        public Builder addMapValue(int i, TypeSystem.Value value)
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

        public Builder addMapValue(Builder builder)
        {
            ensureMapValueIsMutable();
            mapValue_.add(builder.build());
            return this;
        }

        public Builder addMapValue(TypeSystem.Value value)
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

        public Builder addTemplateToken(int i, Builder builder)
        {
            ensureTemplateTokenIsMutable();
            templateToken_.add(i, builder.build());
            return this;
        }

        public Builder addTemplateToken(int i, TypeSystem.Value value)
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

        public Builder addTemplateToken(Builder builder)
        {
            ensureTemplateTokenIsMutable();
            templateToken_.add(builder.build());
            return this;
        }

        public Builder addTemplateToken(TypeSystem.Value value)
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

        public TypeSystem.Value build()
        {
            TypeSystem.Value value = buildPartial();
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

        public TypeSystem.Value buildPartial()
        {
            TypeSystem.Value value = new TypeSystem.Value(this, null);
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

        public Builder clear()
        {
            super.clear();
            type_ = Type.STRING;
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

        public Builder clearBoolean()
        {
            bitField0_ = bitField0_ & 0xfffffeff;
            boolean_ = false;
            return this;
        }

        public Builder clearContainsReferences()
        {
            bitField0_ = bitField0_ & 0xfffff7ff;
            containsReferences_ = false;
            return this;
        }

        public Builder clearEscaping()
        {
            escaping_ = Collections.emptyList();
            bitField0_ = bitField0_ & 0xfffffbff;
            return this;
        }

        public Builder clearFunctionId()
        {
            bitField0_ = bitField0_ & 0xffffffbf;
            functionId_ = TypeSystem.Value.getDefaultInstance().getFunctionId();
            return this;
        }

        public Builder clearInteger()
        {
            bitField0_ = bitField0_ & 0xffffff7f;
            integer_ = 0L;
            return this;
        }

        public Builder clearListItem()
        {
            listItem_ = Collections.emptyList();
            bitField0_ = bitField0_ & -5;
            return this;
        }

        public Builder clearMacroReference()
        {
            bitField0_ = bitField0_ & 0xffffffdf;
            macroReference_ = TypeSystem.Value.getDefaultInstance().getMacroReference();
            return this;
        }

        public Builder clearMapKey()
        {
            mapKey_ = Collections.emptyList();
            bitField0_ = bitField0_ & -9;
            return this;
        }

        public Builder clearMapValue()
        {
            mapValue_ = Collections.emptyList();
            bitField0_ = bitField0_ & 0xffffffef;
            return this;
        }

        public Builder clearString()
        {
            bitField0_ = bitField0_ & -3;
            string_ = TypeSystem.Value.getDefaultInstance().getString();
            return this;
        }

        public Builder clearTemplateToken()
        {
            templateToken_ = Collections.emptyList();
            bitField0_ = bitField0_ & 0xfffffdff;
            return this;
        }

        public Builder clearType()
        {
            bitField0_ = bitField0_ & -2;
            type_ = Type.STRING;
            return this;
        }

        public Builder clone()
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

        public TypeSystem.Value getDefaultInstanceForType()
        {
            return TypeSystem.Value.getDefaultInstance();
        }

        public volatile GeneratedMessageLite getDefaultInstanceForType()
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

        public TypeSystem.Value getListItem(int i)
        {
            return (TypeSystem.Value)listItem_.get(i);
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

        public TypeSystem.Value getMapKey(int i)
        {
            return (TypeSystem.Value)mapKey_.get(i);
        }

        public int getMapKeyCount()
        {
            return mapKey_.size();
        }

        public List getMapKeyList()
        {
            return Collections.unmodifiableList(mapKey_);
        }

        public TypeSystem.Value getMapValue(int i)
        {
            return (TypeSystem.Value)mapValue_.get(i);
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

        public TypeSystem.Value getTemplateToken(int i)
        {
            return (TypeSystem.Value)templateToken_.get(i);
        }

        public int getTemplateTokenCount()
        {
            return templateToken_.size();
        }

        public List getTemplateTokenList()
        {
            return Collections.unmodifiableList(templateToken_);
        }

        public Type getType()
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

        public Builder mergeFrom(TypeSystem.Value value)
        {
            if (value == TypeSystem.Value.getDefaultInstance())
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

        public Builder mergeFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException
        {
            CodedInputStream codedinputstream1;
            Object obj;
            obj = null;
            codedinputstream1 = obj;
            codedinputstream = (TypeSystem.Value)TypeSystem.Value.PARSER.parsePartialFrom(codedinputstream, extensionregistrylite);
            if (codedinputstream != null)
            {
                mergeFrom(((TypeSystem.Value) (codedinputstream)));
            }
            return this;
            extensionregistrylite;
            codedinputstream1 = obj;
            codedinputstream = (TypeSystem.Value)extensionregistrylite.getUnfinishedMessage();
            codedinputstream1 = codedinputstream;
            throw extensionregistrylite;
            codedinputstream;
            if (codedinputstream1 != null)
            {
                mergeFrom(((TypeSystem.Value) (codedinputstream1)));
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
            return mergeFrom((TypeSystem.Value)generatedmessagelite);
        }

        public volatile com.google.tagmanager.protobuf.MessageLite.Builder mergeFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException
        {
            return mergeFrom(codedinputstream, extensionregistrylite);
        }

        public Builder removeListItem(int i)
        {
            ensureListItemIsMutable();
            listItem_.remove(i);
            return this;
        }

        public Builder removeMapKey(int i)
        {
            ensureMapKeyIsMutable();
            mapKey_.remove(i);
            return this;
        }

        public Builder removeMapValue(int i)
        {
            ensureMapValueIsMutable();
            mapValue_.remove(i);
            return this;
        }

        public Builder removeTemplateToken(int i)
        {
            ensureTemplateTokenIsMutable();
            templateToken_.remove(i);
            return this;
        }

        public Builder setBoolean(boolean flag)
        {
            bitField0_ = bitField0_ | 0x100;
            boolean_ = flag;
            return this;
        }

        public Builder setContainsReferences(boolean flag)
        {
            bitField0_ = bitField0_ | 0x800;
            containsReferences_ = flag;
            return this;
        }

        public Builder setEscaping(int i, Escaping escaping)
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

        public Builder setFunctionId(String s)
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

        public Builder setFunctionIdBytes(ByteString bytestring)
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

        public Builder setInteger(long l)
        {
            bitField0_ = bitField0_ | 0x80;
            integer_ = l;
            return this;
        }

        public Builder setListItem(int i, Builder builder)
        {
            ensureListItemIsMutable();
            listItem_.set(i, builder.build());
            return this;
        }

        public Builder setListItem(int i, TypeSystem.Value value)
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

        public Builder setMacroReference(String s)
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

        public Builder setMacroReferenceBytes(ByteString bytestring)
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

        public Builder setMapKey(int i, Builder builder)
        {
            ensureMapKeyIsMutable();
            mapKey_.set(i, builder.build());
            return this;
        }

        public Builder setMapKey(int i, TypeSystem.Value value)
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

        public Builder setMapValue(int i, Builder builder)
        {
            ensureMapValueIsMutable();
            mapValue_.set(i, builder.build());
            return this;
        }

        public Builder setMapValue(int i, TypeSystem.Value value)
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

        public Builder setString(String s)
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

        public Builder setStringBytes(ByteString bytestring)
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

        public Builder setTemplateToken(int i, Builder builder)
        {
            ensureTemplateTokenIsMutable();
            templateToken_.set(i, builder.build());
            return this;
        }

        public Builder setTemplateToken(int i, TypeSystem.Value value)
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

        public Builder setType(Type type)
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


        private Builder()
        {
            type_ = Type.STRING;
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

    public static final class Escaping extends Enum
        implements com.google.tagmanager.protobuf.Internal.EnumLite
    {

        private static final Escaping $VALUES[];
        public static final Escaping CONVERT_JS_VALUE_TO_EXPRESSION;
        public static final int CONVERT_JS_VALUE_TO_EXPRESSION_VALUE = 16;
        public static final Escaping ESCAPE_CSS_STRING;
        public static final int ESCAPE_CSS_STRING_VALUE = 10;
        public static final Escaping ESCAPE_HTML;
        public static final Escaping ESCAPE_HTML_ATTRIBUTE;
        public static final Escaping ESCAPE_HTML_ATTRIBUTE_NOSPACE;
        public static final int ESCAPE_HTML_ATTRIBUTE_NOSPACE_VALUE = 4;
        public static final int ESCAPE_HTML_ATTRIBUTE_VALUE = 3;
        public static final Escaping ESCAPE_HTML_RCDATA;
        public static final int ESCAPE_HTML_RCDATA_VALUE = 2;
        public static final int ESCAPE_HTML_VALUE = 1;
        public static final Escaping ESCAPE_JS_REGEX;
        public static final int ESCAPE_JS_REGEX_VALUE = 9;
        public static final Escaping ESCAPE_JS_STRING;
        public static final int ESCAPE_JS_STRING_VALUE = 7;
        public static final Escaping ESCAPE_JS_VALUE;
        public static final int ESCAPE_JS_VALUE_VALUE = 8;
        public static final Escaping ESCAPE_URI;
        public static final int ESCAPE_URI_VALUE = 12;
        public static final Escaping FILTER_CSS_VALUE;
        public static final int FILTER_CSS_VALUE_VALUE = 11;
        public static final Escaping FILTER_HTML_ATTRIBUTES;
        public static final int FILTER_HTML_ATTRIBUTES_VALUE = 6;
        public static final Escaping FILTER_HTML_ELEMENT_NAME;
        public static final int FILTER_HTML_ELEMENT_NAME_VALUE = 5;
        public static final Escaping FILTER_NORMALIZE_URI;
        public static final int FILTER_NORMALIZE_URI_VALUE = 14;
        public static final Escaping NORMALIZE_URI;
        public static final int NORMALIZE_URI_VALUE = 13;
        public static final Escaping NO_AUTOESCAPE;
        public static final int NO_AUTOESCAPE_VALUE = 15;
        public static final Escaping TEXT;
        public static final int TEXT_VALUE = 17;
        private static com.google.tagmanager.protobuf.Internal.EnumLiteMap internalValueMap = new com.google.tagmanager.protobuf.Internal.EnumLiteMap() {

            public Escaping findValueByNumber(int i)
            {
                return Escaping.valueOf(i);
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

        public static Escaping valueOf(int i)
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

        public static Escaping valueOf(String s)
        {
            return (Escaping)Enum.valueOf(com/google/analytics/midtier/proto/containertag/TypeSystem$Value$Escaping, s);
        }

        public static Escaping[] values()
        {
            return (Escaping[])$VALUES.clone();
        }

        public final int getNumber()
        {
            return value;
        }

        static 
        {
            ESCAPE_HTML = new Escaping("ESCAPE_HTML", 0, 0, 1);
            ESCAPE_HTML_RCDATA = new Escaping("ESCAPE_HTML_RCDATA", 1, 1, 2);
            ESCAPE_HTML_ATTRIBUTE = new Escaping("ESCAPE_HTML_ATTRIBUTE", 2, 2, 3);
            ESCAPE_HTML_ATTRIBUTE_NOSPACE = new Escaping("ESCAPE_HTML_ATTRIBUTE_NOSPACE", 3, 3, 4);
            FILTER_HTML_ELEMENT_NAME = new Escaping("FILTER_HTML_ELEMENT_NAME", 4, 4, 5);
            FILTER_HTML_ATTRIBUTES = new Escaping("FILTER_HTML_ATTRIBUTES", 5, 5, 6);
            ESCAPE_JS_STRING = new Escaping("ESCAPE_JS_STRING", 6, 6, 7);
            ESCAPE_JS_VALUE = new Escaping("ESCAPE_JS_VALUE", 7, 7, 8);
            ESCAPE_JS_REGEX = new Escaping("ESCAPE_JS_REGEX", 8, 8, 9);
            ESCAPE_CSS_STRING = new Escaping("ESCAPE_CSS_STRING", 9, 9, 10);
            FILTER_CSS_VALUE = new Escaping("FILTER_CSS_VALUE", 10, 10, 11);
            ESCAPE_URI = new Escaping("ESCAPE_URI", 11, 11, 12);
            NORMALIZE_URI = new Escaping("NORMALIZE_URI", 12, 12, 13);
            FILTER_NORMALIZE_URI = new Escaping("FILTER_NORMALIZE_URI", 13, 13, 14);
            NO_AUTOESCAPE = new Escaping("NO_AUTOESCAPE", 14, 14, 15);
            TEXT = new Escaping("TEXT", 15, 15, 17);
            CONVERT_JS_VALUE_TO_EXPRESSION = new Escaping("CONVERT_JS_VALUE_TO_EXPRESSION", 16, 16, 16);
            $VALUES = (new Escaping[] {
                ESCAPE_HTML, ESCAPE_HTML_RCDATA, ESCAPE_HTML_ATTRIBUTE, ESCAPE_HTML_ATTRIBUTE_NOSPACE, FILTER_HTML_ELEMENT_NAME, FILTER_HTML_ATTRIBUTES, ESCAPE_JS_STRING, ESCAPE_JS_VALUE, ESCAPE_JS_REGEX, ESCAPE_CSS_STRING, 
                FILTER_CSS_VALUE, ESCAPE_URI, NORMALIZE_URI, FILTER_NORMALIZE_URI, NO_AUTOESCAPE, TEXT, CONVERT_JS_VALUE_TO_EXPRESSION
            });
        }

        private Escaping(String s, int i, int j, int k)
        {
            super(s, i);
            value = k;
        }
    }

    public static final class Type extends Enum
        implements com.google.tagmanager.protobuf.Internal.EnumLite
    {

        private static final Type $VALUES[];
        public static final Type BOOLEAN;
        public static final int BOOLEAN_VALUE = 8;
        public static final Type FUNCTION_ID;
        public static final int FUNCTION_ID_VALUE = 5;
        public static final Type INTEGER;
        public static final int INTEGER_VALUE = 6;
        public static final Type LIST;
        public static final int LIST_VALUE = 2;
        public static final Type MACRO_REFERENCE;
        public static final int MACRO_REFERENCE_VALUE = 4;
        public static final Type MAP;
        public static final int MAP_VALUE = 3;
        public static final Type STRING;
        public static final int STRING_VALUE = 1;
        public static final Type TEMPLATE;
        public static final int TEMPLATE_VALUE = 7;
        private static com.google.tagmanager.protobuf.Internal.EnumLiteMap internalValueMap = new com.google.tagmanager.protobuf.Internal.EnumLiteMap() {

            public Type findValueByNumber(int i)
            {
                return Type.valueOf(i);
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

        public static Type valueOf(int i)
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

        public static Type valueOf(String s)
        {
            return (Type)Enum.valueOf(com/google/analytics/midtier/proto/containertag/TypeSystem$Value$Type, s);
        }

        public static Type[] values()
        {
            return (Type[])$VALUES.clone();
        }

        public final int getNumber()
        {
            return value;
        }

        static 
        {
            STRING = new Type("STRING", 0, 0, 1);
            LIST = new Type("LIST", 1, 1, 2);
            MAP = new Type("MAP", 2, 2, 3);
            MACRO_REFERENCE = new Type("MACRO_REFERENCE", 3, 3, 4);
            FUNCTION_ID = new Type("FUNCTION_ID", 4, 4, 5);
            INTEGER = new Type("INTEGER", 5, 5, 6);
            TEMPLATE = new Type("TEMPLATE", 6, 6, 7);
            BOOLEAN = new Type("BOOLEAN", 7, 7, 8);
            $VALUES = (new Type[] {
                STRING, LIST, M
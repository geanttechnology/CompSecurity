// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.protobuf;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.google.protobuf:
//            SmallSortedMap, CodedOutputStream, MessageLite, ByteString, 
//            CodedInputStream

final class FieldSet
{
    public static interface FieldDescriptorLite
        extends Comparable
    {

        public abstract WireFormat.JavaType getLiteJavaType();

        public abstract WireFormat.FieldType getLiteType();

        public abstract int getNumber();

        public abstract MessageLite.Builder internalMergeFrom(MessageLite.Builder builder, MessageLite messagelite);

        public abstract boolean isPacked();

        public abstract boolean isRepeated();
    }


    private static final FieldSet DEFAULT_INSTANCE = new FieldSet(true);
    private final SmallSortedMap fields;
    private boolean isImmutable;

    private FieldSet()
    {
        fields = SmallSortedMap.newFieldMap(16);
    }

    private FieldSet(boolean flag)
    {
        fields = SmallSortedMap.newFieldMap(0);
        makeImmutable();
    }

    private static int computeElementSize(WireFormat.FieldType fieldtype, int i, Object obj)
    {
        int j = CodedOutputStream.computeTagSize(i);
        i = j;
        if (fieldtype == WireFormat.FieldType.GROUP)
        {
            i = j * 2;
        }
        return i + computeElementSizeNoTag(fieldtype, obj);
    }

    private static int computeElementSizeNoTag(WireFormat.FieldType fieldtype, Object obj)
    {
        static class _cls1
        {

            static final int $SwitchMap$com$google$protobuf$WireFormat$FieldType[];
            static final int $SwitchMap$com$google$protobuf$WireFormat$JavaType[];

            static 
            {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType = new int[WireFormat.FieldType.values().length];
                try
                {
                    $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.DOUBLE.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror26) { }
                try
                {
                    $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FLOAT.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror25) { }
                try
                {
                    $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.INT64.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror24) { }
                try
                {
                    $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT64.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror23) { }
                try
                {
                    $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.INT32.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror22) { }
                try
                {
                    $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED64.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror21) { }
                try
                {
                    $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED32.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror20) { }
                try
                {
                    $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.BOOL.ordinal()] = 8;
                }
                catch (NoSuchFieldError nosuchfielderror19) { }
                try
                {
                    $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.STRING.ordinal()] = 9;
                }
                catch (NoSuchFieldError nosuchfielderror18) { }
                try
                {
                    $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.BYTES.ordinal()] = 10;
                }
                catch (NoSuchFieldError nosuchfielderror17) { }
                try
                {
                    $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT32.ordinal()] = 11;
                }
                catch (NoSuchFieldError nosuchfielderror16) { }
                try
                {
                    $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED32.ordinal()] = 12;
                }
                catch (NoSuchFieldError nosuchfielderror15) { }
                try
                {
                    $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED64.ordinal()] = 13;
                }
                catch (NoSuchFieldError nosuchfielderror14) { }
                try
                {
                    $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT32.ordinal()] = 14;
                }
                catch (NoSuchFieldError nosuchfielderror13) { }
                try
                {
                    $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT64.ordinal()] = 15;
                }
                catch (NoSuchFieldError nosuchfielderror12) { }
                try
                {
                    $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.GROUP.ordinal()] = 16;
                }
                catch (NoSuchFieldError nosuchfielderror11) { }
                try
                {
                    $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.MESSAGE.ordinal()] = 17;
                }
                catch (NoSuchFieldError nosuchfielderror10) { }
                try
                {
                    $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.ENUM.ordinal()] = 18;
                }
                catch (NoSuchFieldError nosuchfielderror9) { }
                $SwitchMap$com$google$protobuf$WireFormat$JavaType = new int[WireFormat.JavaType.values().length];
                try
                {
                    $SwitchMap$com$google$protobuf$WireFormat$JavaType[WireFormat.JavaType.INT.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror8) { }
                try
                {
                    $SwitchMap$com$google$protobuf$WireFormat$JavaType[WireFormat.JavaType.LONG.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    $SwitchMap$com$google$protobuf$WireFormat$JavaType[WireFormat.JavaType.FLOAT.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    $SwitchMap$com$google$protobuf$WireFormat$JavaType[WireFormat.JavaType.DOUBLE.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$com$google$protobuf$WireFormat$JavaType[WireFormat.JavaType.BOOLEAN.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$google$protobuf$WireFormat$JavaType[WireFormat.JavaType.STRING.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$google$protobuf$WireFormat$JavaType[WireFormat.JavaType.BYTE_STRING.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$google$protobuf$WireFormat$JavaType[WireFormat.JavaType.ENUM.ordinal()] = 8;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$google$protobuf$WireFormat$JavaType[WireFormat.JavaType.MESSAGE.ordinal()] = 9;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1..SwitchMap.com.google.protobuf.WireFormat.FieldType[fieldtype.ordinal()])
        {
        default:
            throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");

        case 1: // '\001'
            return CodedOutputStream.computeDoubleSizeNoTag(((Double)obj).doubleValue());

        case 2: // '\002'
            return CodedOutputStream.computeFloatSizeNoTag(((Float)obj).floatValue());

        case 3: // '\003'
            return CodedOutputStream.computeInt64SizeNoTag(((Long)obj).longValue());

        case 4: // '\004'
            return CodedOutputStream.computeUInt64SizeNoTag(((Long)obj).longValue());

        case 5: // '\005'
            return CodedOutputStream.computeInt32SizeNoTag(((Integer)obj).intValue());

        case 6: // '\006'
            return CodedOutputStream.computeFixed64SizeNoTag(((Long)obj).longValue());

        case 7: // '\007'
            return CodedOutputStream.computeFixed32SizeNoTag(((Integer)obj).intValue());

        case 8: // '\b'
            return CodedOutputStream.computeBoolSizeNoTag(((Boolean)obj).booleanValue());

        case 9: // '\t'
            return CodedOutputStream.computeStringSizeNoTag((String)obj);

        case 16: // '\020'
            return CodedOutputStream.computeGroupSizeNoTag((MessageLite)obj);

        case 17: // '\021'
            return CodedOutputStream.computeMessageSizeNoTag((MessageLite)obj);

        case 10: // '\n'
            return CodedOutputStream.computeBytesSizeNoTag((ByteString)obj);

        case 11: // '\013'
            return CodedOutputStream.computeUInt32SizeNoTag(((Integer)obj).intValue());

        case 12: // '\f'
            return CodedOutputStream.computeSFixed32SizeNoTag(((Integer)obj).intValue());

        case 13: // '\r'
            return CodedOutputStream.computeSFixed64SizeNoTag(((Long)obj).longValue());

        case 14: // '\016'
            return CodedOutputStream.computeSInt32SizeNoTag(((Integer)obj).intValue());

        case 15: // '\017'
            return CodedOutputStream.computeSInt64SizeNoTag(((Long)obj).longValue());

        case 18: // '\022'
            return CodedOutputStream.computeEnumSizeNoTag(((Internal.EnumLite)obj).getNumber());
        }
    }

    public static int computeFieldSize(FieldDescriptorLite fielddescriptorlite, Object obj)
    {
        WireFormat.FieldType fieldtype;
        int i;
        int k;
        int l;
        k = 0;
        i = 0;
        fieldtype = fielddescriptorlite.getLiteType();
        l = fielddescriptorlite.getNumber();
        if (!fielddescriptorlite.isRepeated())
        {
            break MISSING_BLOCK_LABEL_137;
        }
        if (!fielddescriptorlite.isPacked()) goto _L2; else goto _L1
_L1:
        for (fielddescriptorlite = ((List)obj).iterator(); fielddescriptorlite.hasNext();)
        {
            i += computeElementSizeNoTag(fieldtype, fielddescriptorlite.next());
        }

        k = CodedOutputStream.computeTagSize(l);
        k = CodedOutputStream.computeRawVarint32Size(i) + (k + i);
_L4:
        return k;
_L2:
        fielddescriptorlite = ((List)obj).iterator();
        int j = k;
        do
        {
            k = j;
            if (!fielddescriptorlite.hasNext())
            {
                break;
            }
            j += computeElementSize(fieldtype, l, fielddescriptorlite.next());
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
        return computeElementSize(fieldtype, l, obj);
    }

    public static FieldSet emptySet()
    {
        return DEFAULT_INSTANCE;
    }

    private int getMessageSetSerializedSize(java.util.Map.Entry entry)
    {
        FieldDescriptorLite fielddescriptorlite = (FieldDescriptorLite)entry.getKey();
        if (fielddescriptorlite.getLiteJavaType() == WireFormat.JavaType.MESSAGE && !fielddescriptorlite.isRepeated() && !fielddescriptorlite.isPacked())
        {
            return CodedOutputStream.computeMessageSetExtensionSize(((FieldDescriptorLite)entry.getKey()).getNumber(), (MessageLite)entry.getValue());
        } else
        {
            return computeFieldSize(fielddescriptorlite, entry.getValue());
        }
    }

    static int getWireFormatForFieldType(WireFormat.FieldType fieldtype, boolean flag)
    {
        if (flag)
        {
            return 2;
        } else
        {
            return fieldtype.getWireType();
        }
    }

    private boolean isInitialized(java.util.Map.Entry entry)
    {
label0:
        {
            FieldDescriptorLite fielddescriptorlite = (FieldDescriptorLite)entry.getKey();
            if (fielddescriptorlite.getLiteJavaType() != WireFormat.JavaType.MESSAGE)
            {
                break label0;
            }
            if (fielddescriptorlite.isRepeated())
            {
                entry = ((List)entry.getValue()).iterator();
                do
                {
                    if (!entry.hasNext())
                    {
                        break label0;
                    }
                } while (((MessageLite)entry.next()).isInitialized());
                return false;
            }
            if (!((MessageLite)entry.getValue()).isInitialized())
            {
                return false;
            }
        }
        return true;
    }

    private void mergeFromField(java.util.Map.Entry entry)
    {
        FieldDescriptorLite fielddescriptorlite = (FieldDescriptorLite)entry.getKey();
        entry = ((java.util.Map.Entry) (entry.getValue()));
        if (fielddescriptorlite.isRepeated())
        {
            Object obj = fields.get(fielddescriptorlite);
            if (obj == null)
            {
                fields.put(fielddescriptorlite, new ArrayList((List)entry));
                return;
            } else
            {
                ((List)obj).addAll((List)entry);
                return;
            }
        }
        if (fielddescriptorlite.getLiteJavaType() == WireFormat.JavaType.MESSAGE)
        {
            Object obj1 = fields.get(fielddescriptorlite);
            if (obj1 == null)
            {
                fields.put(fielddescriptorlite, entry);
                return;
            } else
            {
                fields.put(fielddescriptorlite, fielddescriptorlite.internalMergeFrom(((MessageLite)obj1).toBuilder(), (MessageLite)entry).build());
                return;
            }
        } else
        {
            fields.put(fielddescriptorlite, entry);
            return;
        }
    }

    public static FieldSet newFieldSet()
    {
        return new FieldSet();
    }

    public static Object readPrimitiveField(CodedInputStream codedinputstream, WireFormat.FieldType fieldtype)
        throws IOException
    {
        switch (_cls1..SwitchMap.com.google.protobuf.WireFormat.FieldType[fieldtype.ordinal()])
        {
        default:
            throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");

        case 1: // '\001'
            return Double.valueOf(codedinputstream.readDouble());

        case 2: // '\002'
            return Float.valueOf(codedinputstream.readFloat());

        case 3: // '\003'
            return Long.valueOf(codedinputstream.readInt64());

        case 4: // '\004'
            return Long.valueOf(codedinputstream.readUInt64());

        case 5: // '\005'
            return Integer.valueOf(codedinputstream.readInt32());

        case 6: // '\006'
            return Long.valueOf(codedinputstream.readFixed64());

        case 7: // '\007'
            return Integer.valueOf(codedinputstream.readFixed32());

        case 8: // '\b'
            return Boolean.valueOf(codedinputstream.readBool());

        case 9: // '\t'
            return codedinputstream.readString();

        case 10: // '\n'
            return codedinputstream.readBytes();

        case 11: // '\013'
            return Integer.valueOf(codedinputstream.readUInt32());

        case 12: // '\f'
            return Integer.valueOf(codedinputstream.readSFixed32());

        case 13: // '\r'
            return Long.valueOf(codedinputstream.readSFixed64());

        case 14: // '\016'
            return Integer.valueOf(codedinputstream.readSInt32());

        case 15: // '\017'
            return Long.valueOf(codedinputstream.readSInt64());

        case 16: // '\020'
            throw new IllegalArgumentException("readPrimitiveField() cannot handle nested groups.");

        case 17: // '\021'
            throw new IllegalArgumentException("readPrimitiveField() cannot handle embedded messages.");

        case 18: // '\022'
            throw new IllegalArgumentException("readPrimitiveField() cannot handle enums.");
        }
    }

    private static void verifyType(WireFormat.FieldType fieldtype, Object obj)
    {
        boolean flag;
        if (obj == null)
        {
            throw new NullPointerException();
        }
        flag = false;
        _cls1..SwitchMap.com.google.protobuf.WireFormat.JavaType[fieldtype.getJavaType().ordinal()];
        JVM INSTR tableswitch 1 9: default 76
    //                   1 91
    //                   2 99
    //                   3 107
    //                   4 115
    //                   5 123
    //                   6 131
    //                   7 139
    //                   8 147
    //                   9 155;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10
_L1:
        break; /* Loop/switch isn't completed */
_L10:
        break MISSING_BLOCK_LABEL_155;
_L11:
        if (!flag)
        {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        } else
        {
            return;
        }
_L2:
        flag = obj instanceof Integer;
          goto _L11
_L3:
        flag = obj instanceof Long;
          goto _L11
_L4:
        flag = obj instanceof Float;
          goto _L11
_L5:
        flag = obj instanceof Double;
          goto _L11
_L6:
        flag = obj instanceof Boolean;
          goto _L11
_L7:
        flag = obj instanceof String;
          goto _L11
_L8:
        flag = obj instanceof ByteString;
          goto _L11
_L9:
        flag = obj instanceof Internal.EnumLite;
          goto _L11
        flag = obj instanceof MessageLite;
          goto _L11
    }

    private static void writeElement(CodedOutputStream codedoutputstream, WireFormat.FieldType fieldtype, int i, Object obj)
        throws IOException
    {
        if (fieldtype == WireFormat.FieldType.GROUP)
        {
            codedoutputstream.writeGroup(i, (MessageLite)obj);
            return;
        } else
        {
            codedoutputstream.writeTag(i, getWireFormatForFieldType(fieldtype, false));
            writeElementNoTag(codedoutputstream, fieldtype, obj);
            return;
        }
    }

    private static void writeElementNoTag(CodedOutputStream codedoutputstream, WireFormat.FieldType fieldtype, Object obj)
        throws IOException
    {
        switch (_cls1..SwitchMap.com.google.protobuf.WireFormat.FieldType[fieldtype.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            codedoutputstream.writeDoubleNoTag(((Double)obj).doubleValue());
            return;

        case 2: // '\002'
            codedoutputstream.writeFloatNoTag(((Float)obj).floatValue());
            return;

        case 3: // '\003'
            codedoutputstream.writeInt64NoTag(((Long)obj).longValue());
            return;

        case 4: // '\004'
            codedoutputstream.writeUInt64NoTag(((Long)obj).longValue());
            return;

        case 5: // '\005'
            codedoutputstream.writeInt32NoTag(((Integer)obj).intValue());
            return;

        case 6: // '\006'
            codedoutputstream.writeFixed64NoTag(((Long)obj).longValue());
            return;

        case 7: // '\007'
            codedoutputstream.writeFixed32NoTag(((Integer)obj).intValue());
            return;

        case 8: // '\b'
            codedoutputstream.writeBoolNoTag(((Boolean)obj).booleanValue());
            return;

        case 9: // '\t'
            codedoutputstream.writeStringNoTag((String)obj);
            return;

        case 16: // '\020'
            codedoutputstream.writeGroupNoTag((MessageLite)obj);
            return;

        case 17: // '\021'
            codedoutputstream.writeMessageNoTag((MessageLite)obj);
            return;

        case 10: // '\n'
            codedoutputstream.writeBytesNoTag((ByteString)obj);
            return;

        case 11: // '\013'
            codedoutputstream.writeUInt32NoTag(((Integer)obj).intValue());
            return;

        case 12: // '\f'
            codedoutputstream.writeSFixed32NoTag(((Integer)obj).intValue());
            return;

        case 13: // '\r'
            codedoutputstream.writeSFixed64NoTag(((Long)obj).longValue());
            return;

        case 14: // '\016'
            codedoutputstream.writeSInt32NoTag(((Integer)obj).intValue());
            return;

        case 15: // '\017'
            codedoutputstream.writeSInt64NoTag(((Long)obj).longValue());
            return;

        case 18: // '\022'
            codedoutputstream.writeEnumNoTag(((Internal.EnumLite)obj).getNumber());
            break;
        }
    }

    public static void writeField(FieldDescriptorLite fielddescriptorlite, Object obj, CodedOutputStream codedoutputstream)
        throws IOException
    {
        WireFormat.FieldType fieldtype = fielddescriptorlite.getLiteType();
        int i = fielddescriptorlite.getNumber();
        if (fielddescriptorlite.isRepeated())
        {
            obj = (List)obj;
            if (fielddescriptorlite.isPacked())
            {
                codedoutputstream.writeTag(i, 2);
                i = 0;
                for (fielddescriptorlite = ((List) (obj)).iterator(); fielddescriptorlite.hasNext();)
                {
                    i += computeElementSizeNoTag(fieldtype, fielddescriptorlite.next());
                }

                codedoutputstream.writeRawVarint32(i);
                for (fielddescriptorlite = ((List) (obj)).iterator(); fielddescriptorlite.hasNext(); writeElementNoTag(codedoutputstream, fieldtype, fielddescriptorlite.next())) { }
            } else
            {
                for (fielddescriptorlite = ((List) (obj)).iterator(); fielddescriptorlite.hasNext(); writeElement(codedoutputstream, fieldtype, i, fielddescriptorlite.next())) { }
            }
        } else
        {
            writeElement(codedoutputstream, fieldtype, i, obj);
        }
    }

    private void writeMessageSetTo(java.util.Map.Entry entry, CodedOutputStream codedoutputstream)
        throws IOException
    {
        FieldDescriptorLite fielddescriptorlite = (FieldDescriptorLite)entry.getKey();
        if (fielddescriptorlite.getLiteJavaType() == WireFormat.JavaType.MESSAGE && !fielddescriptorlite.isRepeated() && !fielddescriptorlite.isPacked())
        {
            codedoutputstream.writeMessageSetExtension(((FieldDescriptorLite)entry.getKey()).getNumber(), (MessageLite)entry.getValue());
            return;
        } else
        {
            writeField(fielddescriptorlite, entry.getValue(), codedoutputstream);
            return;
        }
    }

    public void addRepeatedField(FieldDescriptorLite fielddescriptorlite, Object obj)
    {
        if (!fielddescriptorlite.isRepeated())
        {
            throw new IllegalArgumentException("addRepeatedField() can only be called on repeated fields.");
        }
        verifyType(fielddescriptorlite.getLiteType(), obj);
        Object obj1 = fields.get(fielddescriptorlite);
        if (obj1 == null)
        {
            obj1 = new ArrayList();
            fields.put(fielddescriptorlite, obj1);
            fielddescriptorlite = ((FieldDescriptorLite) (obj1));
        } else
        {
            fielddescriptorlite = (List)obj1;
        }
        fielddescriptorlite.add(obj);
    }

    public void clear()
    {
        fields.clear();
    }

    public void clearField(FieldDescriptorLite fielddescriptorlite)
    {
        fields.remove(fielddescriptorlite);
    }

    public FieldSet clone()
    {
        FieldSet fieldset = newFieldSet();
        for (int i = 0; i < fields.getNumArrayEntries(); i++)
        {
            java.util.Map.Entry entry = fields.getArrayEntryAt(i);
            fieldset.setField((FieldDescriptorLite)entry.getKey(), entry.getValue());
        }

        java.util.Map.Entry entry1;
        for (Iterator iterator1 = fields.getOverflowEntries().iterator(); iterator1.hasNext(); fieldset.setField((FieldDescriptorLite)entry1.getKey(), entry1.getValue()))
        {
            entry1 = (java.util.Map.Entry)iterator1.next();
        }

        return fieldset;
    }

    public volatile Object clone()
        throws CloneNotSupportedException
    {
        return clone();
    }

    public Map getAllFields()
    {
        if (fields.isImmutable())
        {
            return fields;
        } else
        {
            return Collections.unmodifiableMap(fields);
        }
    }

    public Object getField(FieldDescriptorLite fielddescriptorlite)
    {
        return fields.get(fielddescriptorlite);
    }

    public int getMessageSetSerializedSize()
    {
        int j = 0;
        int i = 0;
        for (; j < fields.getNumArrayEntries(); j++)
        {
            i += getMessageSetSerializedSize(fields.getArrayEntryAt(j));
        }

        for (Iterator iterator1 = fields.getOverflowEntries().iterator(); iterator1.hasNext();)
        {
            i += getMessageSetSerializedSize((java.util.Map.Entry)iterator1.next());
        }

        return i;
    }

    public Object getRepeatedField(FieldDescriptorLite fielddescriptorlite, int i)
    {
        if (!fielddescriptorlite.isRepeated())
        {
            throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
        }
        fielddescriptorlite = ((FieldDescriptorLite) (fields.get(fielddescriptorlite)));
        if (fielddescriptorlite == null)
        {
            throw new IndexOutOfBoundsException();
        } else
        {
            return ((List)fielddescriptorlite).get(i);
        }
    }

    public int getRepeatedFieldCount(FieldDescriptorLite fielddescriptorlite)
    {
        if (!fielddescriptorlite.isRepeated())
        {
            throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
        }
        fielddescriptorlite = ((FieldDescriptorLite) (fields.get(fielddescriptorlite)));
        if (fielddescriptorlite == null)
        {
            return 0;
        } else
        {
            return ((List)fielddescriptorlite).size();
        }
    }

    public int getSerializedSize()
    {
        int j = 0;
        int i = 0;
        for (; j < fields.getNumArrayEntries(); j++)
        {
            java.util.Map.Entry entry = fields.getArrayEntryAt(j);
            i += computeFieldSize((FieldDescriptorLite)entry.getKey(), entry.getValue());
        }

        for (Iterator iterator1 = fields.getOverflowEntries().iterator(); iterator1.hasNext();)
        {
            java.util.Map.Entry entry1 = (java.util.Map.Entry)iterator1.next();
            i += computeFieldSize((FieldDescriptorLite)entry1.getKey(), entry1.getValue());
        }

        return i;
    }

    public boolean hasField(FieldDescriptorLite fielddescriptorlite)
    {
        if (fielddescriptorlite.isRepeated())
        {
            throw new IllegalArgumentException("hasField() can only be called on non-repeated fields.");
        }
        return fields.get(fielddescriptorlite) != null;
    }

    public boolean isImmutable()
    {
        return isImmutable;
    }

    public boolean isInitialized()
    {
        for (int i = 0; i < fields.getNumArrayEntries(); i++)
        {
            if (!isInitialized(fields.getArrayEntryAt(i)))
            {
                return false;
            }
        }

        for (Iterator iterator1 = fields.getOverflowEntries().iterator(); iterator1.hasNext();)
        {
            if (!isInitialized((java.util.Map.Entry)iterator1.next()))
            {
                return false;
            }
        }

        return true;
    }

    public Iterator iterator()
    {
        return fields.entrySet().iterator();
    }

    public void makeImmutable()
    {
        if (isImmutable)
        {
            return;
        } else
        {
            fields.makeImmutable();
            isImmutable = true;
            return;
        }
    }

    public void mergeFrom(FieldSet fieldset)
    {
        for (int i = 0; i < fieldset.fields.getNumArrayEntries(); i++)
        {
            mergeFromField(fieldset.fields.getArrayEntryAt(i));
        }

        for (fieldset = fieldset.fields.getOverflowEntries().iterator(); fieldset.hasNext(); mergeFromField((java.util.Map.Entry)fieldset.next())) { }
    }

    public void setField(FieldDescriptorLite fielddescriptorlite, Object obj)
    {
        if (fielddescriptorlite.isRepeated())
        {
            if (!(obj instanceof List))
            {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
            ArrayList arraylist = new ArrayList();
            arraylist.addAll((List)obj);
            Object obj1;
            for (obj = arraylist.iterator(); ((Iterator) (obj)).hasNext(); verifyType(fielddescriptorlite.getLiteType(), obj1))
            {
                obj1 = ((Iterator) (obj)).next();
            }

            obj = arraylist;
        } else
        {
            verifyType(fielddescriptorlite.getLiteType(), obj);
        }
        fields.put(fielddescriptorlite, obj);
    }

    public void setRepeatedField(FieldDescriptorLite fielddescriptorlite, int i, Object obj)
    {
        if (!fielddescriptorlite.isRepeated())
        {
            throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
        }
        Object obj1 = fields.get(fielddescriptorlite);
        if (obj1 == null)
        {
            throw new IndexOutOfBoundsException();
        } else
        {
            verifyType(fielddescriptorlite.getLiteType(), obj);
            ((List)obj1).set(i, obj);
            return;
        }
    }

    public void writeMessageSetTo(CodedOutputStream codedoutputstream)
        throws IOException
    {
        for (int i = 0; i < fields.getNumArrayEntries(); i++)
        {
            writeMessageSetTo(fields.getArrayEntryAt(i), codedoutputstream);
        }

        for (Iterator iterator1 = fields.getOverflowEntries().iterator(); iterator1.hasNext(); writeMessageSetTo((java.util.Map.Entry)iterator1.next(), codedoutputstream)) { }
    }

    public void writeTo(CodedOutputStream codedoutputstream)
        throws IOException
    {
        for (int i = 0; i < fields.getNumArrayEntries(); i++)
        {
            java.util.Map.Entry entry = fields.getArrayEntryAt(i);
            writeField((FieldDescriptorLite)entry.getKey(), entry.getValue(), codedoutputstream);
        }

        java.util.Map.Entry entry1;
        for (Iterator iterator1 = fields.getOverflowEntries().iterator(); iterator1.hasNext(); writeField((FieldDescriptorLite)entry1.getKey(), entry1.getValue(), codedoutputstream))
        {
            entry1 = (java.util.Map.Entry)iterator1.next();
        }

    }

}

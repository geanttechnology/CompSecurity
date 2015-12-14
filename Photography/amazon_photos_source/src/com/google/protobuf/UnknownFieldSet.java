// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.protobuf;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

// Referenced classes of package com.google.protobuf:
//            MessageLite, ByteString, TextFormat, Parser, 
//            CodedOutputStream, WireFormat, InvalidProtocolBufferException, CodedInputStream, 
//            ExtensionRegistry, ExtensionRegistryLite, AbstractParser

public final class UnknownFieldSet
    implements MessageLite
{
    public static final class Builder
        implements MessageLite.Builder
    {

        private Map fields;
        private Field.Builder lastField;
        private int lastFieldNumber;

        private static Builder create()
        {
            Builder builder = new Builder();
            builder.reinitialize();
            return builder;
        }

        private Field.Builder getFieldBuilder(int i)
        {
            if (lastField != null)
            {
                if (i == lastFieldNumber)
                {
                    return lastField;
                }
                addField(lastFieldNumber, lastField.build());
            }
            if (i == 0)
            {
                return null;
            }
            Field field = (Field)fields.get(Integer.valueOf(i));
            lastFieldNumber = i;
            lastField = Field.newBuilder();
            if (field != null)
            {
                lastField.mergeFrom(field);
            }
            return lastField;
        }

        private void reinitialize()
        {
            fields = Collections.emptyMap();
            lastFieldNumber = 0;
            lastField = null;
        }

        public Builder addField(int i, Field field)
        {
            if (i == 0)
            {
                throw new IllegalArgumentException("Zero is not a valid field number.");
            }
            if (lastField != null && lastFieldNumber == i)
            {
                lastField = null;
                lastFieldNumber = 0;
            }
            if (fields.isEmpty())
            {
                fields = new TreeMap();
            }
            fields.put(Integer.valueOf(i), field);
            return this;
        }

        public volatile MessageLite build()
        {
            return build();
        }

        public UnknownFieldSet build()
        {
            getFieldBuilder(0);
            UnknownFieldSet unknownfieldset;
            if (fields.isEmpty())
            {
                unknownfieldset = UnknownFieldSet.getDefaultInstance();
            } else
            {
                unknownfieldset = new UnknownFieldSet(Collections.unmodifiableMap(fields));
            }
            fields = null;
            return unknownfieldset;
        }

        public UnknownFieldSet buildPartial()
        {
            return build();
        }

        public Builder clone()
        {
            getFieldBuilder(0);
            return UnknownFieldSet.newBuilder().mergeFrom(new UnknownFieldSet(fields));
        }

        public volatile Object clone()
            throws CloneNotSupportedException
        {
            return clone();
        }

        public boolean hasField(int i)
        {
            if (i == 0)
            {
                throw new IllegalArgumentException("Zero is not a valid field number.");
            }
            return i == lastFieldNumber || fields.containsKey(Integer.valueOf(i));
        }

        public boolean isInitialized()
        {
            return true;
        }

        public Builder mergeField(int i, Field field)
        {
            if (i == 0)
            {
                throw new IllegalArgumentException("Zero is not a valid field number.");
            }
            if (hasField(i))
            {
                getFieldBuilder(i).mergeFrom(field);
                return this;
            } else
            {
                addField(i, field);
                return this;
            }
        }

        public boolean mergeFieldFrom(int i, CodedInputStream codedinputstream)
            throws IOException
        {
            int j = WireFormat.getTagFieldNumber(i);
            switch (WireFormat.getTagWireType(i))
            {
            default:
                throw InvalidProtocolBufferException.invalidWireType();

            case 0: // '\0'
                getFieldBuilder(j).addVarint(codedinputstream.readInt64());
                return true;

            case 1: // '\001'
                getFieldBuilder(j).addFixed64(codedinputstream.readFixed64());
                return true;

            case 2: // '\002'
                getFieldBuilder(j).addLengthDelimited(codedinputstream.readBytes());
                return true;

            case 3: // '\003'
                Builder builder = UnknownFieldSet.newBuilder();
                codedinputstream.readGroup(j, builder, ExtensionRegistry.getEmptyRegistry());
                getFieldBuilder(j).addGroup(builder.build());
                return true;

            case 4: // '\004'
                return false;

            case 5: // '\005'
                getFieldBuilder(j).addFixed32(codedinputstream.readFixed32());
                break;
            }
            return true;
        }

        public volatile MessageLite.Builder mergeFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException
        {
            return mergeFrom(codedinputstream, extensionregistrylite);
        }

        public Builder mergeFrom(CodedInputStream codedinputstream)
            throws IOException
        {
            int i;
            do
            {
                i = codedinputstream.readTag();
            } while (i != 0 && mergeFieldFrom(i, codedinputstream));
            return this;
        }

        public Builder mergeFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException
        {
            return mergeFrom(codedinputstream);
        }

        public Builder mergeFrom(UnknownFieldSet unknownfieldset)
        {
            if (unknownfieldset != UnknownFieldSet.getDefaultInstance())
            {
                java.util.Map.Entry entry;
                for (unknownfieldset = unknownfieldset.fields.entrySet().iterator(); unknownfieldset.hasNext(); mergeField(((Integer)entry.getKey()).intValue(), (Field)entry.getValue()))
                {
                    entry = (java.util.Map.Entry)unknownfieldset.next();
                }

            }
            return this;
        }

        public Builder mergeVarintField(int i, int j)
        {
            if (i == 0)
            {
                throw new IllegalArgumentException("Zero is not a valid field number.");
            } else
            {
                getFieldBuilder(i).addVarint(j);
                return this;
            }
        }


        private Builder()
        {
        }
    }

    public static final class Field
    {

        private static final Field fieldDefaultInstance = newBuilder().build();
        private List fixed32;
        private List fixed64;
        private List group;
        private List lengthDelimited;
        private List varint;

        private Object[] getIdentityArray()
        {
            return (new Object[] {
                varint, fixed32, fixed64, lengthDelimited, group
            });
        }

        public static Builder newBuilder()
        {
            return Builder.create();
        }

        public boolean equals(Object obj)
        {
            if (this == obj)
            {
                return true;
            }
            if (!(obj instanceof Field))
            {
                return false;
            } else
            {
                return Arrays.equals(getIdentityArray(), ((Field)obj).getIdentityArray());
            }
        }

        public List getFixed32List()
        {
            return fixed32;
        }

        public List getFixed64List()
        {
            return fixed64;
        }

        public List getGroupList()
        {
            return group;
        }

        public List getLengthDelimitedList()
        {
            return lengthDelimited;
        }

        public int getSerializedSize(int i)
        {
            Iterator iterator = varint.iterator();
            int j;
            for (j = 0; iterator.hasNext(); j = CodedOutputStream.computeUInt64Size(i, ((Long)iterator.next()).longValue()) + j) { }
            for (Iterator iterator1 = fixed32.iterator(); iterator1.hasNext();)
            {
                j += CodedOutputStream.computeFixed32Size(i, ((Integer)iterator1.next()).intValue());
            }

            for (Iterator iterator2 = fixed64.iterator(); iterator2.hasNext();)
            {
                j += CodedOutputStream.computeFixed64Size(i, ((Long)iterator2.next()).longValue());
            }

            for (Iterator iterator3 = lengthDelimited.iterator(); iterator3.hasNext();)
            {
                j += CodedOutputStream.computeBytesSize(i, (ByteString)iterator3.next());
            }

            for (Iterator iterator4 = group.iterator(); iterator4.hasNext();)
            {
                j += CodedOutputStream.computeGroupSize(i, (UnknownFieldSet)iterator4.next());
            }

            return j;
        }

        public int getSerializedSizeAsMessageSetExtension(int i)
        {
            Iterator iterator = lengthDelimited.iterator();
            int j;
            for (j = 0; iterator.hasNext(); j = CodedOutputStream.computeRawMessageSetExtensionSize(i, (ByteString)iterator.next()) + j) { }
            return j;
        }

        public List getVarintList()
        {
            return varint;
        }

        public int hashCode()
        {
            return Arrays.hashCode(getIdentityArray());
        }

        public void writeAsMessageSetExtensionTo(int i, CodedOutputStream codedoutputstream)
            throws IOException
        {
            for (Iterator iterator = lengthDelimited.iterator(); iterator.hasNext(); codedoutputstream.writeRawMessageSetExtension(i, (ByteString)iterator.next())) { }
        }

        public void writeTo(int i, CodedOutputStream codedoutputstream)
            throws IOException
        {
            for (Iterator iterator = varint.iterator(); iterator.hasNext(); codedoutputstream.writeUInt64(i, ((Long)iterator.next()).longValue())) { }
            for (Iterator iterator1 = fixed32.iterator(); iterator1.hasNext(); codedoutputstream.writeFixed32(i, ((Integer)iterator1.next()).intValue())) { }
            for (Iterator iterator2 = fixed64.iterator(); iterator2.hasNext(); codedoutputstream.writeFixed64(i, ((Long)iterator2.next()).longValue())) { }
            for (Iterator iterator3 = lengthDelimited.iterator(); iterator3.hasNext(); codedoutputstream.writeBytes(i, (ByteString)iterator3.next())) { }
            for (Iterator iterator4 = group.iterator(); iterator4.hasNext(); codedoutputstream.writeGroup(i, (UnknownFieldSet)iterator4.next())) { }
        }




/*
        static List access$502(Field field, List list)
        {
            field.varint = list;
            return list;
        }

*/



/*
        static List access$602(Field field, List list)
        {
            field.fixed32 = list;
            return list;
        }

*/



/*
        static List access$702(Field field, List list)
        {
            field.fixed64 = list;
            return list;
        }

*/



/*
        static List access$802(Field field, List list)
        {
            field.lengthDelimited = list;
            return list;
        }

*/



/*
        static List access$902(Field field, List list)
        {
            field.group = list;
            return list;
        }

*/

        private Field()
        {
        }

    }

    public static final class Field.Builder
    {

        private Field result;

        private static Field.Builder create()
        {
            Field.Builder builder = new Field.Builder();
            builder.result = new Field();
            return builder;
        }

        public Field.Builder addFixed32(int i)
        {
            if (result.fixed32 == null)
            {
                result.fixed32 = new ArrayList();
            }
            result.fixed32.add(Integer.valueOf(i));
            return this;
        }

        public Field.Builder addFixed64(long l)
        {
            if (result.fixed64 == null)
            {
                result.fixed64 = new ArrayList();
            }
            result.fixed64.add(Long.valueOf(l));
            return this;
        }

        public Field.Builder addGroup(UnknownFieldSet unknownfieldset)
        {
            if (result.group == null)
            {
                result.group = new ArrayList();
            }
            result.group.add(unknownfieldset);
            return this;
        }

        public Field.Builder addLengthDelimited(ByteString bytestring)
        {
            if (result.lengthDelimited == null)
            {
                result.lengthDelimited = new ArrayList();
            }
            result.lengthDelimited.add(bytestring);
            return this;
        }

        public Field.Builder addVarint(long l)
        {
            if (result.varint == null)
            {
                result.varint = new ArrayList();
            }
            result.varint.add(Long.valueOf(l));
            return this;
        }

        public Field build()
        {
            Field field;
            if (result.varint == null)
            {
                result.varint = Collections.emptyList();
            } else
            {
                result.varint = Collections.unmodifiableList(result.varint);
            }
            if (result.fixed32 == null)
            {
                result.fixed32 = Collections.emptyList();
            } else
            {
                result.fixed32 = Collections.unmodifiableList(result.fixed32);
            }
            if (result.fixed64 == null)
            {
                result.fixed64 = Collections.emptyList();
            } else
            {
                result.fixed64 = Collections.unmodifiableList(result.fixed64);
            }
            if (result.lengthDelimited == null)
            {
                result.lengthDelimited = Collections.emptyList();
            } else
            {
                result.lengthDelimited = Collections.unmodifiableList(result.lengthDelimited);
            }
            if (result.group == null)
            {
                result.group = Collections.emptyList();
            } else
            {
                result.group = Collections.unmodifiableList(result.group);
            }
            field = result;
            result = null;
            return field;
        }

        public Field.Builder mergeFrom(Field field)
        {
            if (!field.varint.isEmpty())
            {
                if (result.varint == null)
                {
                    result.varint = new ArrayList();
                }
                result.varint.addAll(field.varint);
            }
            if (!field.fixed32.isEmpty())
            {
                if (result.fixed32 == null)
                {
                    result.fixed32 = new ArrayList();
                }
                result.fixed32.addAll(field.fixed32);
            }
            if (!field.fixed64.isEmpty())
            {
                if (result.fixed64 == null)
                {
                    result.fixed64 = new ArrayList();
                }
                result.fixed64.addAll(field.fixed64);
            }
            if (!field.lengthDelimited.isEmpty())
            {
                if (result.lengthDelimited == null)
                {
                    result.lengthDelimited = new ArrayList();
                }
                result.lengthDelimited.addAll(field.lengthDelimited);
            }
            if (!field.group.isEmpty())
            {
                if (result.group == null)
                {
                    result.group = new ArrayList();
                }
                result.group.addAll(field.group);
            }
            return this;
        }


        private Field.Builder()
        {
        }
    }

    public static final class Parser extends AbstractParser
    {

        public UnknownFieldSet parsePartialFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
            throws InvalidProtocolBufferException
        {
            extensionregistrylite = UnknownFieldSet.newBuilder();
            try
            {
                extensionregistrylite.mergeFrom(codedinputstream);
            }
            // Misplaced declaration of an exception variable
            catch (CodedInputStream codedinputstream)
            {
                throw codedinputstream.setUnfinishedMessage(extensionregistrylite.buildPartial());
            }
            // Misplaced declaration of an exception variable
            catch (CodedInputStream codedinputstream)
            {
                throw (new InvalidProtocolBufferException(codedinputstream.getMessage())).setUnfinishedMessage(extensionregistrylite.buildPartial());
            }
            return extensionregistrylite.buildPartial();
        }

        public volatile Object parsePartialFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
            throws InvalidProtocolBufferException
        {
            return parsePartialFrom(codedinputstream, extensionregistrylite);
        }

        public Parser()
        {
        }
    }


    private static final Parser PARSER = new Parser();
    private static final UnknownFieldSet defaultInstance = new UnknownFieldSet(Collections.emptyMap());
    private Map fields;

    private UnknownFieldSet()
    {
    }

    private UnknownFieldSet(Map map)
    {
        fields = map;
    }


    public static UnknownFieldSet getDefaultInstance()
    {
        return defaultInstance;
    }

    public static Builder newBuilder()
    {
        return Builder.create();
    }

    public static Builder newBuilder(UnknownFieldSet unknownfieldset)
    {
        return newBuilder().mergeFrom(unknownfieldset);
    }

    public Map asMap()
    {
        return fields;
    }

    public boolean equals(Object obj)
    {
        while (this == obj || (obj instanceof UnknownFieldSet) && fields.equals(((UnknownFieldSet)obj).fields)) 
        {
            return true;
        }
        return false;
    }

    public volatile com.google.protobuf.Parser getParserForType()
    {
        return getParserForType();
    }

    public final Parser getParserForType()
    {
        return PARSER;
    }

    public int getSerializedSize()
    {
        Iterator iterator = fields.entrySet().iterator();
        java.util.Map.Entry entry;
        int i;
        for (i = 0; iterator.hasNext(); i = ((Field)entry.getValue()).getSerializedSize(((Integer)entry.getKey()).intValue()) + i)
        {
            entry = (java.util.Map.Entry)iterator.next();
        }

        return i;
    }

    public int getSerializedSizeAsMessageSet()
    {
        Iterator iterator = fields.entrySet().iterator();
        java.util.Map.Entry entry;
        int i;
        for (i = 0; iterator.hasNext(); i = ((Field)entry.getValue()).getSerializedSizeAsMessageSetExtension(((Integer)entry.getKey()).intValue()) + i)
        {
            entry = (java.util.Map.Entry)iterator.next();
        }

        return i;
    }

    public int hashCode()
    {
        return fields.hashCode();
    }

    public boolean isInitialized()
    {
        return true;
    }

    public volatile MessageLite.Builder toBuilder()
    {
        return toBuilder();
    }

    public Builder toBuilder()
    {
        return newBuilder().mergeFrom(this);
    }

    public ByteString toByteString()
    {
        Object obj;
        try
        {
            obj = ByteString.newCodedBuilder(getSerializedSize());
            writeTo(((ByteString.CodedBuilder) (obj)).getCodedOutput());
            obj = ((ByteString.CodedBuilder) (obj)).build();
        }
        catch (IOException ioexception)
        {
            throw new RuntimeException("Serializing to a ByteString threw an IOException (should never happen).", ioexception);
        }
        return ((ByteString) (obj));
    }

    public String toString()
    {
        return TextFormat.printToString(this);
    }

    public void writeAsMessageSetTo(CodedOutputStream codedoutputstream)
        throws IOException
    {
        java.util.Map.Entry entry;
        for (Iterator iterator = fields.entrySet().iterator(); iterator.hasNext(); ((Field)entry.getValue()).writeAsMessageSetExtensionTo(((Integer)entry.getKey()).intValue(), codedoutputstream))
        {
            entry = (java.util.Map.Entry)iterator.next();
        }

    }

    public void writeTo(CodedOutputStream codedoutputstream)
        throws IOException
    {
        java.util.Map.Entry entry;
        for (Iterator iterator = fields.entrySet().iterator(); iterator.hasNext(); ((Field)entry.getValue()).writeTo(((Integer)entry.getKey()).intValue(), codedoutputstream))
        {
            entry = (java.util.Map.Entry)iterator.next();
        }

    }


}

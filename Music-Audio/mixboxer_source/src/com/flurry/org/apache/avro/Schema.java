// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.apache.avro;

import com.flurry.org.codehaus.jackson.JsonFactory;
import com.flurry.org.codehaus.jackson.JsonGenerator;
import com.flurry.org.codehaus.jackson.JsonNode;
import com.flurry.org.codehaus.jackson.JsonParseException;
import com.flurry.org.codehaus.jackson.JsonParser;
import com.flurry.org.codehaus.jackson.map.ObjectMapper;
import com.flurry.org.codehaus.jackson.node.DoubleNode;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.flurry.org.apache.avro:
//            AvroRuntimeException, SchemaParseException, AvroTypeException

public abstract class Schema
{
    private static class ArraySchema extends Schema
    {

        private final Schema elementType;

        int computeHash()
        {
            return computeHash() + elementType.computeHash();
        }

        public boolean equals(Object obj)
        {
            if (obj != this)
            {
                if (!(obj instanceof ArraySchema))
                {
                    return false;
                }
                obj = (ArraySchema)obj;
                if (!equalCachedHash(((Schema) (obj))) || !elementType.equals(((ArraySchema) (obj)).elementType) || !props.equals(((ArraySchema) (obj)).props))
                {
                    return false;
                }
            }
            return true;
        }

        public Schema getElementType()
        {
            return elementType;
        }

        void toJson(Names names, JsonGenerator jsongenerator)
            throws IOException
        {
            jsongenerator.writeStartObject();
            jsongenerator.writeStringField("type", "array");
            jsongenerator.writeFieldName("items");
            elementType.toJson(names, jsongenerator);
            props.write(jsongenerator);
            jsongenerator.writeEndObject();
        }

        public ArraySchema(Schema schema)
        {
            super(Type.ARRAY);
            elementType = schema;
        }
    }

    private static class BooleanSchema extends Schema
    {

        public BooleanSchema()
        {
            super(Type.BOOLEAN);
        }
    }

    private static class BytesSchema extends Schema
    {

        public BytesSchema()
        {
            super(Type.BYTES);
        }
    }

    private static class DoubleSchema extends Schema
    {

        public DoubleSchema()
        {
            super(Type.DOUBLE);
        }
    }

    private static class EnumSchema extends NamedSchema
    {

        private final Map ordinals = new HashMap();
        private final List symbols;

        int computeHash()
        {
            return super.computeHash() + symbols.hashCode();
        }

        public boolean equals(Object obj)
        {
            if (obj != this)
            {
                if (!(obj instanceof EnumSchema))
                {
                    return false;
                }
                obj = (EnumSchema)obj;
                if (!equalCachedHash(((Schema) (obj))) || !equalNames(((NamedSchema) (obj))) || !symbols.equals(((EnumSchema) (obj)).symbols) || !props.equals(((EnumSchema) (obj)).props))
                {
                    return false;
                }
            }
            return true;
        }

        public int getEnumOrdinal(String s)
        {
            return ((Integer)ordinals.get(s)).intValue();
        }

        public List getEnumSymbols()
        {
            return symbols;
        }

        public boolean hasEnumSymbol(String s)
        {
            return ordinals.containsKey(s);
        }

        void toJson(Names names, JsonGenerator jsongenerator)
            throws IOException
        {
            if (writeNameRef(names, jsongenerator))
            {
                return;
            }
            jsongenerator.writeStartObject();
            jsongenerator.writeStringField("type", "enum");
            writeName(names, jsongenerator);
            if (getDoc() != null)
            {
                jsongenerator.writeStringField("doc", getDoc());
            }
            jsongenerator.writeArrayFieldStart("symbols");
            for (names = symbols.iterator(); names.hasNext(); jsongenerator.writeString((String)names.next())) { }
            jsongenerator.writeEndArray();
            props.write(jsongenerator);
            aliasesToJson(jsongenerator);
            jsongenerator.writeEndObject();
        }

        public EnumSchema(Name name, String s, LockableArrayList lockablearraylist)
        {
            super(Type.ENUM, name, s);
            symbols = lockablearraylist.lock();
            int i = 0;
            for (name = lockablearraylist.iterator(); name.hasNext();)
            {
                s = (String)name.next();
                if (ordinals.put(Schema.validateName(s), Integer.valueOf(i)) != null)
                {
                    throw new SchemaParseException((new StringBuilder()).append("Duplicate enum symbol: ").append(s).toString());
                }
                i++;
            }

        }
    }

    public static class Field
    {

        private Set aliases;
        private final JsonNode defaultValue;
        private final String doc;
        private final String name;
        private final Order order;
        private transient int position;
        private final Props props;
        private final Schema schema;

        private boolean defaultValueEquals(JsonNode jsonnode)
        {
            if (defaultValue == null)
            {
                return jsonnode == null;
            }
            if (Double.isNaN(defaultValue.getValueAsDouble()))
            {
                return Double.isNaN(jsonnode.getValueAsDouble());
            } else
            {
                return defaultValue.equals(jsonnode);
            }
        }

        public void addAlias(String s)
        {
            if (aliases == null)
            {
                aliases = new LinkedHashSet();
            }
            aliases.add(s);
        }

        public void addProp(String s, String s1)
        {
            this;
            JVM INSTR monitorenter ;
            props.add(s, s1);
            this;
            JVM INSTR monitorexit ;
            return;
            s;
            throw s;
        }

        public Set aliases()
        {
            if (aliases == null)
            {
                return Collections.emptySet();
            } else
            {
                return Collections.unmodifiableSet(aliases);
            }
        }

        public JsonNode defaultValue()
        {
            return defaultValue;
        }

        public String doc()
        {
            return doc;
        }

        public boolean equals(Object obj)
        {
            if (obj != this)
            {
                if (!(obj instanceof Field))
                {
                    return false;
                }
                obj = (Field)obj;
                if (!name.equals(((Field) (obj)).name) || !schema.equals(((Field) (obj)).schema) || !defaultValueEquals(((Field) (obj)).defaultValue) || !props.equals(((Field) (obj)).props))
                {
                    return false;
                }
            }
            return true;
        }

        public String getProp(String s)
        {
            this;
            JVM INSTR monitorenter ;
            s = (String)props.get(s);
            this;
            JVM INSTR monitorexit ;
            return s;
            s;
            throw s;
        }

        public int hashCode()
        {
            return name.hashCode() + schema.computeHash();
        }

        public String name()
        {
            return name;
        }

        public Order order()
        {
            return order;
        }

        public int pos()
        {
            return position;
        }

        public Map props()
        {
            return Collections.unmodifiableMap(props);
        }

        public Schema schema()
        {
            return schema;
        }

        public String toString()
        {
            return (new StringBuilder()).append(name).append(" type:").append(schema.type).append(" pos:").append(position).toString();
        }



/*
        static Set access$1302(Field field, Set set)
        {
            field.aliases = set;
            return set;
        }

*/









/*
        static int access$702(Field field, int i)
        {
            field.position = i;
            return i;
        }

*/

        public Field(String s, Schema schema1, String s1, JsonNode jsonnode)
        {
            this(s, schema1, s1, jsonnode, Order.ASCENDING);
        }

        public Field(String s, Schema schema1, String s1, JsonNode jsonnode, Order order1)
        {
            position = -1;
            props = new Props(Schema.FIELD_RESERVED);
            name = Schema.validateName(s);
            schema = schema1;
            doc = s1;
            defaultValue = jsonnode;
            order = order1;
        }
    }

    public static final class Field.Order extends Enum
    {

        private static final Field.Order $VALUES[];
        public static final Field.Order ASCENDING;
        public static final Field.Order DESCENDING;
        public static final Field.Order IGNORE;
        private String name;

        public static Field.Order valueOf(String s)
        {
            return (Field.Order)Enum.valueOf(com/flurry/org/apache/avro/Schema$Field$Order, s);
        }

        public static Field.Order[] values()
        {
            return (Field.Order[])$VALUES.clone();
        }

        static 
        {
            ASCENDING = new Field.Order("ASCENDING", 0);
            DESCENDING = new Field.Order("DESCENDING", 1);
            IGNORE = new Field.Order("IGNORE", 2);
            $VALUES = (new Field.Order[] {
                ASCENDING, DESCENDING, IGNORE
            });
        }


        private Field.Order(String s, int i)
        {
            super(s, i);
            name = name().toLowerCase();
        }
    }

    private static class FixedSchema extends NamedSchema
    {

        private final int size;

        int computeHash()
        {
            return super.computeHash() + size;
        }

        public boolean equals(Object obj)
        {
            if (obj != this)
            {
                if (!(obj instanceof FixedSchema))
                {
                    return false;
                }
                obj = (FixedSchema)obj;
                if (!equalCachedHash(((Schema) (obj))) || !equalNames(((NamedSchema) (obj))) || size != ((FixedSchema) (obj)).size || !props.equals(((FixedSchema) (obj)).props))
                {
                    return false;
                }
            }
            return true;
        }

        public int getFixedSize()
        {
            return size;
        }

        void toJson(Names names, JsonGenerator jsongenerator)
            throws IOException
        {
            if (writeNameRef(names, jsongenerator))
            {
                return;
            }
            jsongenerator.writeStartObject();
            jsongenerator.writeStringField("type", "fixed");
            writeName(names, jsongenerator);
            if (getDoc() != null)
            {
                jsongenerator.writeStringField("doc", getDoc());
            }
            jsongenerator.writeNumberField("size", size);
            props.write(jsongenerator);
            aliasesToJson(jsongenerator);
            jsongenerator.writeEndObject();
        }

        public FixedSchema(Name name, String s, int i)
        {
            super(Type.FIXED, name, s);
            if (i < 0)
            {
                throw new IllegalArgumentException((new StringBuilder()).append("Invalid fixed size: ").append(i).toString());
            } else
            {
                size = i;
                return;
            }
        }
    }

    private static class FloatSchema extends Schema
    {

        public FloatSchema()
        {
            super(Type.FLOAT);
        }
    }

    private static class IntSchema extends Schema
    {

        public IntSchema()
        {
            super(Type.INT);
        }
    }

    static class LockableArrayList extends ArrayList
    {

        private static final long serialVersionUID = 1L;
        private boolean locked;

        private void ensureUnlocked()
        {
            if (locked)
            {
                throw new IllegalStateException();
            } else
            {
                return;
            }
        }

        public boolean add(Object obj)
        {
            ensureUnlocked();
            return super.add(obj);
        }

        public boolean addAll(int i, Collection collection)
        {
            ensureUnlocked();
            return super.addAll(i, collection);
        }

        public boolean addAll(Collection collection)
        {
            ensureUnlocked();
            return super.addAll(collection);
        }

        public void clear()
        {
            ensureUnlocked();
            super.clear();
        }

        public List lock()
        {
            locked = true;
            return this;
        }

        public Object remove(int i)
        {
            ensureUnlocked();
            return super.remove(i);
        }

        public boolean remove(Object obj)
        {
            ensureUnlocked();
            return super.remove(obj);
        }

        public boolean removeAll(Collection collection)
        {
            ensureUnlocked();
            return super.removeAll(collection);
        }

        public boolean retainAll(Collection collection)
        {
            ensureUnlocked();
            return super.retainAll(collection);
        }

        public LockableArrayList()
        {
            locked = false;
        }

        public LockableArrayList(int i)
        {
            super(i);
            locked = false;
        }

        public LockableArrayList(List list)
        {
            super(list);
            locked = false;
        }
    }

    private static class LongSchema extends Schema
    {

        public LongSchema()
        {
            super(Type.LONG);
        }
    }

    private static class MapSchema extends Schema
    {

        private final Schema valueType;

        int computeHash()
        {
            return computeHash() + valueType.computeHash();
        }

        public boolean equals(Object obj)
        {
            if (obj != this)
            {
                if (!(obj instanceof MapSchema))
                {
                    return false;
                }
                obj = (MapSchema)obj;
                if (!equalCachedHash(((Schema) (obj))) || !valueType.equals(((MapSchema) (obj)).valueType) || !props.equals(((MapSchema) (obj)).props))
                {
                    return false;
                }
            }
            return true;
        }

        public Schema getValueType()
        {
            return valueType;
        }

        void toJson(Names names, JsonGenerator jsongenerator)
            throws IOException
        {
            jsongenerator.writeStartObject();
            jsongenerator.writeStringField("type", "map");
            jsongenerator.writeFieldName("values");
            valueType.toJson(names, jsongenerator);
            props.write(jsongenerator);
            jsongenerator.writeEndObject();
        }

        public MapSchema(Schema schema)
        {
            super(Type.MAP);
            valueType = schema;
        }
    }

    private static class Name
    {

        private final String full;
        private final String name;
        private final String space;

        public boolean equals(Object obj)
        {
            if (obj != this)
            {
                if (!(obj instanceof Name))
                {
                    return false;
                }
                obj = (Name)obj;
                if (full == null)
                {
                    if (((Name) (obj)).full != null)
                    {
                        return false;
                    }
                } else
                {
                    return full.equals(((Name) (obj)).full);
                }
            }
            return true;
        }

        public String getQualified(String s)
        {
            if (space == null || space.equals(s))
            {
                return name;
            } else
            {
                return full;
            }
        }

        public int hashCode()
        {
            if (full == null)
            {
                return 0;
            } else
            {
                return full.hashCode();
            }
        }

        public String toString()
        {
            return full;
        }

        public void writeName(Names names, JsonGenerator jsongenerator)
            throws IOException
        {
            if (name != null)
            {
                jsongenerator.writeStringField("name", name);
            }
            if (space != null)
            {
                if (!space.equals(names.space()))
                {
                    jsongenerator.writeStringField("namespace", space);
                }
                if (names.space() == null)
                {
                    names.space(space);
                }
            }
        }




        public Name(String s, String s1)
        {
            if (s == null)
            {
                full = null;
                space = null;
                name = null;
                return;
            }
            int i = s.lastIndexOf('.');
            if (i < 0)
            {
                space = s1;
                name = Schema.validateName(s);
            } else
            {
                space = s.substring(0, i);
                name = Schema.validateName(s.substring(i + 1, s.length()));
            }
            if (space == null)
            {
                s = name;
            } else
            {
                s = (new StringBuilder()).append(space).append(".").append(name).toString();
            }
            full = s;
        }
    }

    private static abstract class NamedSchema extends Schema
    {

        Set aliases;
        final String doc;
        final Name name;

        public void addAlias(String s)
        {
            if (aliases == null)
            {
                aliases = new LinkedHashSet();
            }
            aliases.add(new Name(s, name.space));
        }

        public void aliasesToJson(JsonGenerator jsongenerator)
            throws IOException
        {
            if (aliases == null || aliases.size() == 0)
            {
                return;
            }
            jsongenerator.writeFieldName("aliases");
            jsongenerator.writeStartArray();
            for (Iterator iterator = aliases.iterator(); iterator.hasNext(); jsongenerator.writeString(((Name)iterator.next()).getQualified(name.space))) { }
            jsongenerator.writeEndArray();
        }

        int computeHash()
        {
            return computeHash() + name.hashCode();
        }

        public boolean equalNames(NamedSchema namedschema)
        {
            return name.equals(namedschema.name);
        }

        public Set getAliases()
        {
            LinkedHashSet linkedhashset = new LinkedHashSet();
            if (aliases != null)
            {
                for (Iterator iterator = aliases.iterator(); iterator.hasNext(); linkedhashset.add(((Name)iterator.next()).full)) { }
            }
            return linkedhashset;
        }

        public String getDoc()
        {
            return doc;
        }

        public String getFullName()
        {
            return name.full;
        }

        public String getName()
        {
            return name.name;
        }

        public String getNamespace()
        {
            return name.space;
        }

        public void writeName(Names names, JsonGenerator jsongenerator)
            throws IOException
        {
            name.writeName(names, jsongenerator);
        }

        public boolean writeNameRef(Names names, JsonGenerator jsongenerator)
            throws IOException
        {
            if (equals(names.get(name)))
            {
                jsongenerator.writeString(name.getQualified(names.space()));
                return true;
            }
            if (name.name != null)
            {
                names.put(name, this);
            }
            return false;
        }

        public NamedSchema(Type type1, Name name1, String s)
        {
            super(type1);
            name = name1;
            doc = s;
            if (PRIMITIVES.containsKey(name1.full))
            {
                throw new AvroTypeException((new StringBuilder()).append("Schemas may not be named after primitives: ").append(name1.full).toString());
            } else
            {
                return;
            }
        }
    }

    static class Names extends LinkedHashMap
    {

        private String space;

        public void add(Schema schema)
        {
            put(((NamedSchema)schema).name, schema);
        }

        public boolean contains(Schema schema)
        {
            return get(((NamedSchema)schema).name) != null;
        }

        public Schema get(Object obj)
        {
            if (obj instanceof String)
            {
                Type type1 = (Type)Schema.PRIMITIVES.get((String)obj);
                if (type1 != null)
                {
                    return Schema.create(type1);
                }
                obj = new Name((String)obj, space);
            } else
            {
                obj = (Name)obj;
            }
            return (Schema)super.get(obj);
        }

        public volatile Object get(Object obj)
        {
            return get(obj);
        }

        public Schema put(Name name, Schema schema)
        {
            if (containsKey(name))
            {
                throw new SchemaParseException((new StringBuilder()).append("Can't redefine: ").append(name).toString());
            } else
            {
                return (Schema)super.put(name, schema);
            }
        }

        public volatile Object put(Object obj, Object obj1)
        {
            return put((Name)obj, (Schema)obj1);
        }

        public String space()
        {
            return space;
        }

        public void space(String s)
        {
            space = s;
        }



/*
        static String access$1102(Names names, String s)
        {
            names.space = s;
            return s;
        }

*/

        public Names()
        {
        }

        public Names(String s)
        {
            space = s;
        }
    }

    private static class NullSchema extends Schema
    {

        public NullSchema()
        {
            super(Type.NULL);
        }
    }

    public static class Parser
    {

        private Names names;
        private boolean validate;

        private Schema parse(JsonParser jsonparser)
            throws IOException
        {
            boolean flag = ((Boolean)Schema.validateNames.get()).booleanValue();
            Schema.validateNames.set(Boolean.valueOf(validate));
            jsonparser = Schema.parse(Schema.MAPPER.readTree(jsonparser), names);
            Schema.validateNames.set(Boolean.valueOf(flag));
            return jsonparser;
            jsonparser;
            throw new SchemaParseException(jsonparser);
            jsonparser;
            Schema.validateNames.set(Boolean.valueOf(flag));
            throw jsonparser;
        }

        public Parser addTypes(Map map)
        {
            Schema schema;
            for (map = map.values().iterator(); map.hasNext(); names.add(schema))
            {
                schema = (Schema)map.next();
            }

            return this;
        }

        public Map getTypes()
        {
            LinkedHashMap linkedhashmap = new LinkedHashMap();
            Schema schema;
            for (Iterator iterator = names.values().iterator(); iterator.hasNext(); linkedhashmap.put(schema.getFullName(), schema))
            {
                schema = (Schema)iterator.next();
            }

            return linkedhashmap;
        }

        public boolean getValidate()
        {
            return validate;
        }

        public Schema parse(File file)
            throws IOException
        {
            return parse(Schema.FACTORY.createJsonParser(file));
        }

        public Schema parse(InputStream inputstream)
            throws IOException
        {
            return parse(Schema.FACTORY.createJsonParser(inputstream));
        }

        public Schema parse(String s)
        {
            try
            {
                s = parse(Schema.FACTORY.createJsonParser(new StringReader(s)));
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                throw new SchemaParseException(s);
            }
            return s;
        }

        public Parser setValidate(boolean flag)
        {
            validate = flag;
            return this;
        }

        public Parser()
        {
            names = new Names();
            validate = true;
        }
    }

    static final class Props extends LinkedHashMap
    {

        private Set reserved;

        public void add(String s, String s1)
        {
            if (reserved.contains(s))
            {
                throw new AvroRuntimeException((new StringBuilder()).append("Can't set reserved property: ").append(s).toString());
            }
            if (s1 == null)
            {
                throw new AvroRuntimeException((new StringBuilder()).append("Can't set a property to null: ").append(s).toString());
            }
            String s2 = (String)get(s);
            if (s2 == null)
            {
                put(s, s1);
            } else
            if (!s2.equals(s1))
            {
                throw new AvroRuntimeException((new StringBuilder()).append("Can't overwrite property: ").append(s).toString());
            }
        }

        public void write(JsonGenerator jsongenerator)
            throws IOException
        {
            java.util.Map.Entry entry;
            for (Iterator iterator = entrySet().iterator(); iterator.hasNext(); jsongenerator.writeStringField((String)entry.getKey(), (String)entry.getValue()))
            {
                entry = (java.util.Map.Entry)iterator.next();
            }

        }

        public Props(Set set)
        {
            super(1);
            reserved = set;
        }
    }

    private static class RecordSchema extends NamedSchema
    {

        private Map fieldMap;
        private List fields;
        private final boolean isError;

        int computeHash()
        {
            Map map = (Map)Schema.SEEN_HASHCODE.get();
            if (!map.containsKey(this)) goto _L2; else goto _L1
_L1:
            int i = 0;
_L4:
            return i;
_L2:
            boolean flag = map.isEmpty();
            int j;
            map.put(this, this);
            i = super.computeHash();
            j = fields.hashCode();
            j = i + j;
            i = j;
            if (!flag) goto _L4; else goto _L3
_L3:
            map.clear();
            return j;
            Exception exception;
            exception;
            if (flag)
            {
                map.clear();
            }
            throw exception;
        }

        public boolean equals(Object obj)
        {
            boolean flag = true;
            if (obj != this) goto _L2; else goto _L1
_L1:
            return flag;
_L2:
            Object obj1;
            SeenPair seenpair;
            if (!(obj instanceof RecordSchema))
            {
                return false;
            }
            obj1 = (RecordSchema)obj;
            if (!equalCachedHash(((Schema) (obj1))))
            {
                return false;
            }
            if (!equalNames(((NamedSchema) (obj1))))
            {
                return false;
            }
            if (!props.equals(((RecordSchema) (obj1)).props))
            {
                return false;
            }
            obj1 = (Set)Schema.SEEN_EQUALS.get();
            seenpair = new SeenPair(this, obj);
            if (((Set) (obj1)).contains(seenpair)) goto _L1; else goto _L3
_L3:
            boolean flag2 = ((Set) (obj1)).isEmpty();
            boolean flag1;
            ((Set) (obj1)).add(seenpair);
            flag1 = fields.equals(((RecordSchema)obj).fields);
            flag = flag1;
            if (!flag2) goto _L1; else goto _L4
_L4:
            ((Set) (obj1)).clear();
            return flag1;
            obj;
            if (flag2)
            {
                ((Set) (obj1)).clear();
            }
            throw obj;
        }

        void fieldsToJson(Names names, JsonGenerator jsongenerator)
            throws IOException
        {
            jsongenerator.writeStartArray();
            for (Iterator iterator = fields.iterator(); iterator.hasNext(); jsongenerator.writeEndObject())
            {
                Field field = (Field)iterator.next();
                jsongenerator.writeStartObject();
                jsongenerator.writeStringField("name", field.name());
                jsongenerator.writeFieldName("type");
                field.schema().toJson(names, jsongenerator);
                if (field.doc() != null)
                {
                    jsongenerator.writeStringField("doc", field.doc());
                }
                if (field.defaultValue() != null)
                {
                    jsongenerator.writeFieldName("default");
                    jsongenerator.writeTree(field.defaultValue());
                }
                if (field.order() != Field.Order.ASCENDING)
                {
                    jsongenerator.writeStringField("order", field.order().name);
                }
                if (field.aliases != null && field.aliases.size() != 0)
                {
                    jsongenerator.writeFieldName("aliases");
                    jsongenerator.writeStartArray();
                    for (Iterator iterator1 = field.aliases.iterator(); iterator1.hasNext(); jsongenerator.writeString((String)iterator1.next())) { }
                    jsongenerator.writeEndArray();
                }
                field.props.write(jsongenerator);
            }

            jsongenerator.writeEndArray();
        }

        public Field getField(String s)
        {
            if (fieldMap == null)
            {
                throw new AvroRuntimeException("Schema fields not set yet");
            } else
            {
                return (Field)fieldMap.get(s);
            }
        }

        public List getFields()
        {
            if (fields == null)
            {
                throw new AvroRuntimeException("Schema fields not set yet");
            } else
            {
                return fields;
            }
        }

        public boolean isError()
        {
            return isError;
        }

        public void setFields(List list)
        {
            if (fields != null)
            {
                throw new AvroRuntimeException("Fields are already set");
            }
            int i = 0;
            fieldMap = new HashMap();
            LockableArrayList lockablearraylist = new LockableArrayList();
            for (list = list.iterator(); list.hasNext();)
            {
                Field field = (Field)list.next();
                if (field.position != -1)
                {
                    throw new AvroRuntimeException((new StringBuilder()).append("Field already used: ").append(field).toString());
                }
                field.position = i;
                fieldMap.put(field.name(), field);
                lockablearraylist.add(field);
                i++;
            }

            fields = lockablearraylist.lock();
            hashCode = 0x80000000;
        }

        void toJson(Names names, JsonGenerator jsongenerator)
            throws IOException
        {
            if (writeNameRef(names, jsongenerator))
            {
                return;
            }
            String s1 = names.space;
            jsongenerator.writeStartObject();
            String s;
            if (isError)
            {
                s = "error";
            } else
            {
                s = "record";
            }
            jsongenerator.writeStringField("type", s);
            writeName(names, jsongenerator);
            names.space = name.space;
            if (getDoc() != null)
            {
                jsongenerator.writeStringField("doc", getDoc());
            }
            jsongenerator.writeFieldName("fields");
            fieldsToJson(names, jsongenerator);
            props.write(jsongenerator);
            aliasesToJson(jsongenerator);
            jsongenerator.writeEndObject();
            names.space = s1;
        }

        public RecordSchema(Name name, String s, boolean flag)
        {
            super(Type.RECORD, name, s);
            isError = flag;
        }
    }

    private static class SeenPair
    {

        private Object s1;
        private Object s2;

        public boolean equals(Object obj)
        {
            return s1 == ((SeenPair)obj).s1 && s2 == ((SeenPair)obj).s2;
        }

        public int hashCode()
        {
            return System.identityHashCode(s1) + System.identityHashCode(s2);
        }

        private SeenPair(Object obj, Object obj1)
        {
            s1 = obj;
            s2 = obj1;
        }

    }

    private static class StringSchema extends Schema
    {

        public StringSchema()
        {
            super(Type.STRING);
        }
    }

    public static final class Type extends Enum
    {

        private static final Type $VALUES[];
        public static final Type ARRAY;
        public static final Type BOOLEAN;
        public static final Type BYTES;
        public static final Type DOUBLE;
        public static final Type ENUM;
        public static final Type FIXED;
        public static final Type FLOAT;
        public static final Type INT;
        public static final Type LONG;
        public static final Type MAP;
        public static final Type NULL;
        public static final Type RECORD;
        public static final Type STRING;
        public static final Type UNION;
        private String name;

        public static Type valueOf(String s)
        {
            return (Type)Enum.valueOf(com/flurry/org/apache/avro/Schema$Type, s);
        }

        public static Type[] values()
        {
            return (Type[])$VALUES.clone();
        }

        public String getName()
        {
            return name;
        }

        static 
        {
            RECORD = new Type("RECORD", 0);
            ENUM = new Type("ENUM", 1);
            ARRAY = new Type("ARRAY", 2);
            MAP = new Type("MAP", 3);
            UNION = new Type("UNION", 4);
            FIXED = new Type("FIXED", 5);
            STRING = new Type("STRING", 6);
            BYTES = new Type("BYTES", 7);
            INT = new Type("INT", 8);
            LONG = new Type("LONG", 9);
            FLOAT = new Type("FLOAT", 10);
            DOUBLE = new Type("DOUBLE", 11);
            BOOLEAN = new Type("BOOLEAN", 12);
            NULL = new Type("NULL", 13);
            $VALUES = (new Type[] {
                RECORD, ENUM, ARRAY, MAP, UNION, FIXED, STRING, BYTES, INT, LONG, 
                FLOAT, DOUBLE, BOOLEAN, NULL
            });
        }


        private Type(String s, int i)
        {
            super(s, i);
            name = name().toLowerCase();
        }
    }

    private static class UnionSchema extends Schema
    {

        private final Map indexByName = new HashMap();
        private final List types;

        public void addProp(String s, String s1)
        {
            throw new AvroRuntimeException((new StringBuilder()).append("Can't set properties on a union: ").append(this).toString());
        }

        int computeHash()
        {
            int i = computeHash();
            for (Iterator iterator = types.iterator(); iterator.hasNext();)
            {
                i += ((Schema)iterator.next()).computeHash();
            }

            return i;
        }

        public boolean equals(Object obj)
        {
            if (obj != this)
            {
                if (!(obj instanceof UnionSchema))
                {
                    return false;
                }
                obj = (UnionSchema)obj;
                if (!equalCachedHash(((Schema) (obj))) || !types.equals(((UnionSchema) (obj)).types) || !props.equals(((UnionSchema) (obj)).props))
                {
                    return false;
                }
            }
            return true;
        }

        public Integer getIndexNamed(String s)
        {
            return (Integer)indexByName.get(s);
        }

        public List getTypes()
        {
            return types;
        }

        void toJson(Names names, JsonGenerator jsongenerator)
            throws IOException
        {
            jsongenerator.writeStartArray();
            for (Iterator iterator = types.iterator(); iterator.hasNext(); ((Schema)iterator.next()).toJson(names, jsongenerator)) { }
            jsongenerator.writeEndArray();
        }

        public UnionSchema(LockableArrayList lockablearraylist)
        {
            super(Type.UNION);
            types = lockablearraylist.lock();
            int i = 0;
            for (lockablearraylist = lockablearraylist.iterator(); lockablearraylist.hasNext();)
            {
                Object obj = (Schema)lockablearraylist.next();
                if (((Schema) (obj)).getType() == Type.UNION)
                {
                    throw new AvroRuntimeException((new StringBuilder()).append("Nested union: ").append(this).toString());
                }
                obj = ((Schema) (obj)).getFullName();
                if (obj == null)
                {
                    throw new AvroRuntimeException((new StringBuilder()).append("Nameless in union:").append(this).toString());
                }
                if (indexByName.put(obj, Integer.valueOf(i)) != null)
                {
                    throw new AvroRuntimeException((new StringBuilder()).append("Duplicate in union:").append(((String) (obj))).toString());
                }
                i++;
            }

        }
    }


    static final JsonFactory FACTORY;
    private static final Set FIELD_RESERVED;
    static final ObjectMapper MAPPER;
    private static final int NO_HASHCODE = 0x80000000;
    static final Map PRIMITIVES;
    private static final Set SCHEMA_RESERVED;
    private static final ThreadLocal SEEN_EQUALS = new ThreadLocal() {

        protected volatile Object initialValue()
        {
            return initialValue();
        }

        protected Set initialValue()
        {
            return new HashSet();
        }

    };
    private static final ThreadLocal SEEN_HASHCODE = new ThreadLocal() {

        protected volatile Object initialValue()
        {
            return initialValue();
        }

        protected Map initialValue()
        {
            return new IdentityHashMap();
        }

    };
    private static ThreadLocal validateNames = new ThreadLocal() {

        protected Boolean initialValue()
        {
            return Boolean.valueOf(true);
        }

        protected volatile Object initialValue()
        {
            return initialValue();
        }

    };
    int hashCode;
    Props props;
    private final Type type;

    Schema(Type type1)
    {
        props = new Props(SCHEMA_RESERVED);
        hashCode = 0x80000000;
        type = type1;
    }

    public static Schema applyAliases(Schema schema, Schema schema1)
    {
        if (schema != schema1)
        {
            IdentityHashMap identityhashmap = new IdentityHashMap(1);
            HashMap hashmap = new HashMap(1);
            HashMap hashmap1 = new HashMap(1);
            getAliases(schema1, identityhashmap, hashmap, hashmap1);
            if (hashmap.size() != 0 || hashmap1.size() != 0)
            {
                identityhashmap.clear();
                return applyAliases(schema, ((Map) (identityhashmap)), ((Map) (hashmap)), ((Map) (hashmap1)));
            }
        }
        return schema;
    }

    private static Schema applyAliases(Schema schema, Map map, Map map1, Map map2)
    {
        Object obj;
        Object obj1;
        static class _cls4
        {

            static final int $SwitchMap$org$apache$avro$Schema$Type[];

            static 
            {
                $SwitchMap$org$apache$avro$Schema$Type = new int[Type.values().length];
                try
                {
                    $SwitchMap$org$apache$avro$Schema$Type[Type.STRING.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror13) { }
                try
                {
                    $SwitchMap$org$apache$avro$Schema$Type[Type.BYTES.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror12) { }
                try
                {
                    $SwitchMap$org$apache$avro$Schema$Type[Type.INT.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror11) { }
                try
                {
                    $SwitchMap$org$apache$avro$Schema$Type[Type.LONG.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror10) { }
                try
                {
                    $SwitchMap$org$apache$avro$Schema$Type[Type.FLOAT.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror9) { }
                try
                {
                    $SwitchMap$org$apache$avro$Schema$Type[Type.DOUBLE.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror8) { }
                try
                {
                    $SwitchMap$org$apache$avro$Schema$Type[Type.BOOLEAN.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    $SwitchMap$org$apache$avro$Schema$Type[Type.NULL.ordinal()] = 8;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    $SwitchMap$org$apache$avro$Schema$Type[Type.RECORD.ordinal()] = 9;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$org$apache$avro$Schema$Type[Type.ENUM.ordinal()] = 10;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$org$apache$avro$Schema$Type[Type.ARRAY.ordinal()] = 11;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$org$apache$avro$Schema$Type[Type.MAP.ordinal()] = 12;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$org$apache$avro$Schema$Type[Type.UNION.ordinal()] = 13;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$org$apache$avro$Schema$Type[Type.FIXED.ordinal()] = 14;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        if (schema instanceof NamedSchema)
        {
            obj = ((NamedSchema)schema).name;
        } else
        {
            obj = null;
        }
        obj1 = schema;
        _cls4..SwitchMap.org.apache.avro.Schema.Type[schema.getType().ordinal()];
        JVM INSTR tableswitch 9 14: default 68
    //                   9 95
    //                   10 304
    //                   11 348
    //                   12 378
    //                   13 408
    //                   14 474;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7
_L1:
        map = ((Map) (obj1));
_L9:
        if (map != schema)
        {
            ((Schema) (map)).props.putAll(schema.props);
        }
        return map;
_L2:
        if (map.containsKey(schema))
        {
            return (Schema)map.get(schema);
        }
        obj1 = obj;
        if (map1.containsKey(obj))
        {
            obj1 = (Name)map1.get(obj);
        }
        obj = createRecord(((Name) (obj1)).full, schema.getDoc(), null, schema.isError());
        map.put(schema, obj);
        ArrayList arraylist = new ArrayList();
        Object obj2;
        for (Iterator iterator = schema.getFields().iterator(); iterator.hasNext(); arraylist.add(obj2))
        {
            Field field = (Field)iterator.next();
            obj2 = applyAliases(field.schema, map, map1, map2);
            obj2 = new Field(getFieldAlias(((Name) (obj1)), field.name, map2), ((Schema) (obj2)), field.doc, field.defaultValue, field.order);
            ((Field) (obj2)).props.putAll(field.props);
        }

        ((Schema) (obj)).setFields(arraylist);
        map = ((Map) (obj));
        continue; /* Loop/switch isn't completed */
_L3:
        map = ((Map) (obj1));
        if (map1.containsKey(obj))
        {
            map = createEnum(((Name)map1.get(obj)).full, schema.getDoc(), null, schema.getEnumSymbols());
        }
        continue; /* Loop/switch isn't completed */
_L4:
        map1 = applyAliases(schema.getElementType(), map, map1, map2);
        map = ((Map) (obj1));
        if (map1 != schema.getElementType())
        {
            map = createArray(map1);
        }
        continue; /* Loop/switch isn't completed */
_L5:
        map1 = applyAliases(schema.getValueType(), map, map1, map2);
        map = ((Map) (obj1));
        if (map1 != schema.getValueType())
        {
            map = createMap(map1);
        }
        continue; /* Loop/switch isn't completed */
_L6:
        obj = new ArrayList();
        for (obj1 = schema.getTypes().iterator(); ((Iterator) (obj1)).hasNext(); ((List) (obj)).add(applyAliases((Schema)((Iterator) (obj1)).next(), map, map1, map2))) { }
        map = createUnion(((List) (obj)));
        continue; /* Loop/switch isn't completed */
_L7:
        map = ((Map) (obj1));
        if (map1.containsKey(obj))
        {
            map = createFixed(((Name)map1.get(obj)).full, schema.getDoc(), null, schema.getFixedSize());
        }
        if (true) goto _L9; else goto _L8
_L8:
    }

    public static Schema create(Type type1)
    {
        switch (_cls4..SwitchMap.org.apache.avro.Schema.Type[type1.ordinal()])
        {
        default:
            throw new AvroRuntimeException((new StringBuilder()).append("Can't create a: ").append(type1).toString());

        case 1: // '\001'
            return new StringSchema();

        case 2: // '\002'
            return new BytesSchema();

        case 3: // '\003'
            return new IntSchema();

        case 4: // '\004'
            return new LongSchema();

        case 5: // '\005'
            return new FloatSchema();

        case 6: // '\006'
            return new DoubleSchema();

        case 7: // '\007'
            return new BooleanSchema();

        case 8: // '\b'
            return new NullSchema();
        }
    }

    public static Schema createArray(Schema schema)
    {
        return new ArraySchema(schema);
    }

    public static Schema createEnum(String s, String s1, String s2, List list)
    {
        return new EnumSchema(new Name(s, s2), s1, new LockableArrayList(list));
    }

    public static Schema createFixed(String s, String s1, String s2, int i)
    {
        return new FixedSchema(new Name(s, s2), s1, i);
    }

    public static Schema createMap(Schema schema)
    {
        return new MapSchema(schema);
    }

    public static Schema createRecord(String s, String s1, String s2, boolean flag)
    {
        return new RecordSchema(new Name(s, s2), s1, flag);
    }

    public static Schema createRecord(List list)
    {
        Schema schema = createRecord(null, null, null, false);
        schema.setFields(list);
        return schema;
    }

    public static Schema createUnion(List list)
    {
        return new UnionSchema(new LockableArrayList(list));
    }

    private static void getAliases(Schema schema, Map map, Map map1, Map map2)
    {
        if (schema instanceof NamedSchema)
        {
            NamedSchema namedschema = (NamedSchema)schema;
            if (namedschema.aliases != null)
            {
                for (Iterator iterator = namedschema.aliases.iterator(); iterator.hasNext(); map1.put((Name)iterator.next(), namedschema.name)) { }
            }
        }
        _cls4..SwitchMap.org.apache.avro.Schema.Type[schema.getType().ordinal()];
        JVM INSTR tableswitch 9 13: default 112
    //                   9 113
    //                   10 112
    //                   11 365
    //                   12 376
    //                   13 387;
           goto _L1 _L2 _L1 _L3 _L4 _L5
_L1:
        return;
_L2:
        if (!map.containsKey(schema))
        {
            map.put(schema, schema);
            RecordSchema recordschema = (RecordSchema)schema;
            Field field;
            for (Iterator iterator1 = schema.getFields().iterator(); iterator1.hasNext(); getAliases(field.schema, map, map1, map2))
            {
                field = (Field)iterator1.next();
                if (field.aliases == null)
                {
                    continue;
                }
                String s;
                for (Iterator iterator2 = field.aliases.iterator(); iterator2.hasNext(); schema.put(s, field.name))
                {
                    s = (String)iterator2.next();
                    Map map3 = (Map)map2.get(recordschema.name);
                    schema = map3;
                    if (map3 == null)
                    {
                        Name name = recordschema.name;
                        schema = new HashMap();
                        map2.put(name, schema);
                    }
                }

            }

            if (recordschema.aliases != null && map2.containsKey(recordschema.name))
            {
                schema = recordschema.aliases.iterator();
                while (schema.hasNext()) 
                {
                    map2.put((Name)schema.next(), map2.get(recordschema.name));
                }
            }
        }
        continue; /* Loop/switch isn't completed */
_L3:
        getAliases(schema.getElementType(), map, map1, map2);
        return;
_L4:
        getAliases(schema.getValueType(), map, map1, map2);
        return;
_L5:
        schema = schema.getTypes().iterator();
        while (schema.hasNext()) 
        {
            getAliases((Schema)schema.next(), map, map1, map2);
        }
        if (true) goto _L1; else goto _L6
_L6:
    }

    private static String getFieldAlias(Name name, String s, Map map)
    {
        name = (Map)map.get(name);
        if (name != null)
        {
            if ((name = (String)name.get(s)) != null)
            {
                return name;
            }
        }
        return s;
    }

    private static String getOptionalText(JsonNode jsonnode, String s)
    {
        jsonnode = jsonnode.get(s);
        if (jsonnode != null)
        {
            return jsonnode.getTextValue();
        } else
        {
            return null;
        }
    }

    private static String getRequiredText(JsonNode jsonnode, String s, String s1)
    {
        s = getOptionalText(jsonnode, s);
        if (s == null)
        {
            throw new SchemaParseException((new StringBuilder()).append(s1).append(": ").append(jsonnode).toString());
        } else
        {
            return s;
        }
    }

    static Schema parse(JsonNode jsonnode, Names names)
    {
        Object obj;
        String s;
        Object obj1;
        Object obj6;
label0:
        {
            if (jsonnode.isTextual())
            {
                Schema schema = names.get(jsonnode.getTextValue());
                names = schema;
                if (schema == null)
                {
                    throw new SchemaParseException((new StringBuilder()).append("Undefined name: ").append(jsonnode).toString());
                }
                break MISSING_BLOCK_LABEL_1339;
            }
            if (!jsonnode.isObject())
            {
                break MISSING_BLOCK_LABEL_1276;
            }
            obj6 = getRequiredText(jsonnode, "type", "No type");
            obj1 = null;
            Object obj2 = null;
            obj = null;
            if (!((String) (obj6)).equals("record") && !((String) (obj6)).equals("error") && !((String) (obj6)).equals("enum"))
            {
                s = obj2;
                if (!((String) (obj6)).equals("fixed"))
                {
                    break label0;
                }
            }
            s = getOptionalText(jsonnode, "namespace");
            String s2 = getOptionalText(jsonnode, "doc");
            obj = s;
            if (s == null)
            {
                obj = names.space();
            }
            Name name = new Name(getRequiredText(jsonnode, "name", "No name in schema"), ((String) (obj)));
            obj = s2;
            obj1 = name;
            s = obj2;
            if (name.space != null)
            {
                s = names.space();
                names.space(name.space);
                obj1 = name;
                obj = s2;
            }
        }
        if (!PRIMITIVES.containsKey(obj6)) goto _L2; else goto _L1
_L1:
        obj = create((Type)PRIMITIVES.get(obj6));
_L4:
        obj1 = jsonnode.getFieldNames();
        do
        {
            if (!((Iterator) (obj1)).hasNext())
            {
                break;
            }
            String s1 = (String)((Iterator) (obj1)).next();
            String s3 = jsonnode.get(s1).getTextValue();
            if (!SCHEMA_RESERVED.contains(s1) && s3 != null)
            {
                ((Schema) (obj)).addProp(s1, s3);
            }
        } while (true);
        break MISSING_BLOCK_LABEL_1213;
_L2:
label1:
        {
            if (!((String) (obj6)).equals("record") && !((String) (obj6)).equals("error"))
            {
                break label1;
            }
            ArrayList arraylist = new ArrayList();
            RecordSchema recordschema = new RecordSchema(((Name) (obj1)), ((String) (obj)), ((String) (obj6)).equals("error"));
            if (obj1 != null)
            {
                names.add(recordschema);
            }
            obj = jsonnode.get("fields");
            if (obj == null || !((JsonNode) (obj)).isArray())
            {
                throw new SchemaParseException((new StringBuilder()).append("Record has no fields: ").append(jsonnode).toString());
            }
            for (obj6 = ((JsonNode) (obj)).iterator(); ((Iterator) (obj6)).hasNext(); arraylist.add(obj))
            {
                JsonNode jsonnode2;
                String s5;
                String s7;
                Schema schema1;
label2:
                {
                    jsonnode2 = (JsonNode)((Iterator) (obj6)).next();
                    s5 = getRequiredText(jsonnode2, "name", "No field name");
                    s7 = getOptionalText(jsonnode2, "doc");
                    obj = jsonnode2.get("type");
                    if (obj == null)
                    {
                        throw new SchemaParseException((new StringBuilder()).append("No field type: ").append(jsonnode2).toString());
                    }
                    if (((JsonNode) (obj)).isTextual() && names.get(((JsonNode) (obj)).getTextValue()) == null)
                    {
                        throw new SchemaParseException((new StringBuilder()).append(obj).append(" is not a defined name.").append(" The type of the \"").append(s5).append("\" field must be").append(" a defined name or a {\"type\": ...} expression.").toString());
                    }
                    schema1 = parse(((JsonNode) (obj)), names);
                    obj = Field.Order.ASCENDING;
                    obj1 = jsonnode2.get("order");
                    if (obj1 != null)
                    {
                        obj = Field.Order.valueOf(((JsonNode) (obj1)).getTextValue().toUpperCase());
                    }
                    JsonNode jsonnode1 = jsonnode2.get("default");
                    obj1 = jsonnode1;
                    if (jsonnode1 == null)
                    {
                        break label2;
                    }
                    if (!Type.FLOAT.equals(schema1.getType()))
                    {
                        obj1 = jsonnode1;
                        if (!Type.DOUBLE.equals(schema1.getType()))
                        {
                            break label2;
                        }
                    }
                    obj1 = jsonnode1;
                    if (jsonnode1.isTextual())
                    {
                        obj1 = new DoubleNode(Double.valueOf(jsonnode1.getTextValue()).doubleValue());
                    }
                }
                obj = new Field(s5, schema1, s7, ((JsonNode) (obj1)), ((Field.Order) (obj)));
                obj1 = jsonnode2.getFieldNames();
                do
                {
                    if (!((Iterator) (obj1)).hasNext())
                    {
                        break;
                    }
                    String s4 = (String)((Iterator) (obj1)).next();
                    String s6 = jsonnode2.get(s4).getTextValue();
                    if (!FIELD_RESERVED.contains(s4) && s6 != null)
                    {
                        ((Field) (obj)).addProp(s4, s6);
                    }
                } while (true);
                obj.aliases = parseAliases(jsonnode2);
            }

            recordschema.setFields(arraylist);
            obj = recordschema;
            continue; /* Loop/switch isn't completed */
        }
        if (((String) (obj6)).equals("enum"))
        {
            Object obj5 = jsonnode.get("symbols");
            if (obj5 == null || !((JsonNode) (obj5)).isArray())
            {
                throw new SchemaParseException((new StringBuilder()).append("Enum has no symbols: ").append(jsonnode).toString());
            }
            Object obj3 = new LockableArrayList();
            for (obj5 = ((JsonNode) (obj5)).iterator(); ((Iterator) (obj5)).hasNext(); ((LockableArrayList) (obj3)).add(((JsonNode)((Iterator) (obj5)).next()).getTextValue())) { }
            obj3 = new EnumSchema(((Name) (obj1)), ((String) (obj)), ((LockableArrayList) (obj3)));
            obj = obj3;
            if (obj1 != null)
            {
                names.add(((Schema) (obj3)));
                obj = obj3;
            }
            continue; /* Loop/switch isn't completed */
        }
        if (((String) (obj6)).equals("array"))
        {
            obj = jsonnode.get("items");
            if (obj == null)
            {
                throw new SchemaParseException((new StringBuilder()).append("Array has no items type: ").append(jsonnode).toString());
            }
            obj = new ArraySchema(parse(((JsonNode) (obj)), names));
            continue; /* Loop/switch isn't completed */
        }
        if (((String) (obj6)).equals("map"))
        {
            obj = jsonnode.get("values");
            if (obj == null)
            {
                throw new SchemaParseException((new StringBuilder()).append("Map has no values type: ").append(jsonnode).toString());
            }
            obj = new MapSchema(parse(((JsonNode) (obj)), names));
            continue; /* Loop/switch isn't completed */
        }
        if (!((String) (obj6)).equals("fixed"))
        {
            break; /* Loop/switch isn't completed */
        }
        Object obj4 = jsonnode.get("size");
        if (obj4 == null || !((JsonNode) (obj4)).isInt())
        {
            throw new SchemaParseException((new StringBuilder()).append("Invalid or no size: ").append(jsonnode).toString());
        }
        obj4 = new FixedSchema(((Name) (obj1)), ((String) (obj)), ((JsonNode) (obj4)).getIntValue());
        obj = obj4;
        if (obj1 != null)
        {
            names.add(((Schema) (obj4)));
            obj = obj4;
        }
        if (true) goto _L4; else goto _L3
_L3:
        throw new SchemaParseException((new StringBuilder()).append("Type not supported: ").append(((String) (obj6))).toString());
        if (s != null)
        {
            names.space(s);
        }
        names = ((Names) (obj));
        if (obj instanceof NamedSchema)
        {
            jsonnode = parseAliases(jsonnode);
            names = ((Names) (obj));
            if (jsonnode != null)
            {
                jsonnode = jsonnode.iterator();
                do
                {
                    names = ((Names) (obj));
                    if (!jsonnode.hasNext())
                    {
                        break;
                    }
                    ((Schema) (obj)).addAlias((String)jsonnode.next());
                } while (true);
            }
        }
        break MISSING_BLOCK_LABEL_1339;
        if (!jsonnode.isArray())
        {
            break MISSING_BLOCK_LABEL_1341;
        }
        LockableArrayList lockablearraylist = new LockableArrayList(jsonnode.size());
        for (jsonnode = jsonnode.iterator(); jsonnode.hasNext(); lockablearraylist.add(parse((JsonNode)jsonnode.next(), names))) { }
        names = new UnionSchema(lockablearraylist);
        return names;
        throw new SchemaParseException((new StringBuilder()).append("Schema not yet supported: ").append(jsonnode).toString());
    }

    public static Schema parse(File file)
        throws IOException
    {
        return (new Parser()).parse(file);
    }

    public static Schema parse(InputStream inputstream)
        throws IOException
    {
        return (new Parser()).parse(inputstream);
    }

    public static Schema parse(String s)
    {
        return (new Parser()).parse(s);
    }

    public static Schema parse(String s, boolean flag)
    {
        return (new Parser()).setValidate(flag).parse(s);
    }

    private static Set parseAliases(JsonNode jsonnode)
    {
        Object obj = jsonnode.get("aliases");
        if (obj != null) goto _L2; else goto _L1
_L1:
        jsonnode = null;
_L4:
        return jsonnode;
_L2:
        if (!((JsonNode) (obj)).isArray())
        {
            throw new SchemaParseException((new StringBuilder()).append("aliases not an array: ").append(jsonnode).toString());
        }
        LinkedHashSet linkedhashset = new LinkedHashSet();
        obj = ((JsonNode) (obj)).iterator();
        do
        {
            jsonnode = linkedhashset;
            if (!((Iterator) (obj)).hasNext())
            {
                continue;
            }
            jsonnode = (JsonNode)((Iterator) (obj)).next();
            if (!jsonnode.isTextual())
            {
                throw new SchemaParseException((new StringBuilder()).append("alias not a string: ").append(jsonnode).toString());
            }
            linkedhashset.add(jsonnode.getTextValue());
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    static JsonNode parseJson(String s)
    {
        try
        {
            s = MAPPER.readTree(FACTORY.createJsonParser(new StringReader(s)));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new RuntimeException(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new RuntimeException(s);
        }
        return s;
    }

    private static String validateName(String s)
    {
        if (((Boolean)validateNames.get()).booleanValue())
        {
            int j = s.length();
            if (j == 0)
            {
                throw new SchemaParseException("Empty name");
            }
            char c = s.charAt(0);
            if (!Character.isLetter(c) && c != '_')
            {
                throw new SchemaParseException((new StringBuilder()).append("Illegal initial character: ").append(s).toString());
            }
            int i = 1;
            while (i < j) 
            {
                char c1 = s.charAt(i);
                if (!Character.isLetterOrDigit(c1) && c1 != '_')
                {
                    throw new SchemaParseException((new StringBuilder()).append("Illegal character in: ").append(s).toString());
                }
                i++;
            }
        }
        return s;
    }

    public void addAlias(String s)
    {
        throw new AvroRuntimeException((new StringBuilder()).append("Not a named type: ").append(this).toString());
    }

    public void addProp(String s, String s1)
    {
        this;
        JVM INSTR monitorenter ;
        props.add(s, s1);
        hashCode = 0x80000000;
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }

    int computeHash()
    {
        return getType().hashCode() + props.hashCode();
    }

    final boolean equalCachedHash(Schema schema)
    {
        return hashCode == schema.hashCode || hashCode == 0x80000000 || schema.hashCode == 0x80000000;
    }

    public boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (!(obj instanceof Schema))
            {
                return false;
            }
            obj = (Schema)obj;
            if (type != ((Schema) (obj)).type)
            {
                return false;
            }
            if (!equalCachedHash(((Schema) (obj))) || !props.equals(((Schema) (obj)).props))
            {
                return false;
            }
        }
        return true;
    }

    void fieldsToJson(Names names, JsonGenerator jsongenerator)
        throws IOException
    {
        throw new AvroRuntimeException((new StringBuilder()).append("Not a record: ").append(this).toString());
    }

    public Set getAliases()
    {
        throw new AvroRuntimeException((new StringBuilder()).append("Not a named type: ").append(this).toString());
    }

    public String getDoc()
    {
        return null;
    }

    public Schema getElementType()
    {
        throw new AvroRuntimeException((new StringBuilder()).append("Not an array: ").append(this).toString());
    }

    public int getEnumOrdinal(String s)
    {
        throw new AvroRuntimeException((new StringBuilder()).append("Not an enum: ").append(this).toString());
    }

    public List getEnumSymbols()
    {
        throw new AvroRuntimeException((new StringBuilder()).append("Not an enum: ").append(this).toString());
    }

    public Field getField(String s)
    {
        throw new AvroRuntimeException((new StringBuilder()).append("Not a record: ").append(this).toString());
    }

    public List getFields()
    {
        throw new AvroRuntimeException((new StringBuilder()).append("Not a record: ").append(this).toString());
    }

    public int getFixedSize()
    {
        throw new AvroRuntimeException((new StringBuilder()).append("Not fixed: ").append(this).toString());
    }

    public String getFullName()
    {
        return getName();
    }

    public Integer getIndexNamed(String s)
    {
        throw new AvroRuntimeException((new StringBuilder()).append("Not a union: ").append(this).toString());
    }

    public String getName()
    {
        return type.name;
    }

    public String getNamespace()
    {
        throw new AvroRuntimeException((new StringBuilder()).append("Not a named type: ").append(this).toString());
    }

    public String getProp(String s)
    {
        this;
        JVM INSTR monitorenter ;
        s = (String)props.get(s);
        this;
        JVM INSTR monitorexit ;
        return s;
        s;
        throw s;
    }

    public Map getProps()
    {
        return Collections.unmodifiableMap(props);
    }

    public Type getType()
    {
        return type;
    }

    public List getTypes()
    {
        throw new AvroRuntimeException((new StringBuilder()).append("Not a union: ").append(this).toString());
    }

    public Schema getValueType()
    {
        throw new AvroRuntimeException((new StringBuilder()).append("Not a map: ").append(this).toString());
    }

    public boolean hasEnumSymbol(String s)
    {
        throw new AvroRuntimeException((new StringBuilder()).append("Not an enum: ").append(this).toString());
    }

    public final int hashCode()
    {
        if (hashCode == 0x80000000)
        {
            hashCode = computeHash();
        }
        return hashCode;
    }

    public boolean isError()
    {
        throw new AvroRuntimeException((new StringBuilder()).append("Not a record: ").append(this).toString());
    }

    public void setFields(List list)
    {
        throw new AvroRuntimeException((new StringBuilder()).append("Not a record: ").append(this).toString());
    }

    void toJson(Names names, JsonGenerator jsongenerator)
        throws IOException
    {
        if (props.size() == 0)
        {
            jsongenerator.writeString(getName());
            return;
        } else
        {
            jsongenerator.writeStartObject();
            jsongenerator.writeStringField("type", getName());
            props.write(jsongenerator);
            jsongenerator.writeEndObject();
            return;
        }
    }

    public String toString()
    {
        return toString(false);
    }

    public String toString(boolean flag)
    {
        Object obj;
        JsonGenerator jsongenerator;
        try
        {
            obj = new StringWriter();
            jsongenerator = FACTORY.createJsonGenerator(((java.io.Writer) (obj)));
        }
        catch (IOException ioexception)
        {
            throw new AvroRuntimeException(ioexception);
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_25;
        }
        jsongenerator.useDefaultPrettyPrinter();
        toJson(new Names(), jsongenerator);
        jsongenerator.flush();
        obj = ((StringWriter) (obj)).toString();
        return ((String) (obj));
    }

    static 
    {
        FACTORY = new JsonFactory();
        MAPPER = new ObjectMapper(FACTORY);
        FACTORY.enable(com.flurry.org.codehaus.jackson.JsonParser.Feature.ALLOW_COMMENTS);
        FACTORY.setCodec(MAPPER);
        SCHEMA_RESERVED = new HashSet();
        Collections.addAll(SCHEMA_RESERVED, new String[] {
            "doc", "fields", "items", "name", "namespace", "size", "symbols", "values", "type"
        });
        FIELD_RESERVED = new HashSet();
        Collections.addAll(FIELD_RESERVED, new String[] {
            "default", "doc", "name", "order", "type"
        });
        PRIMITIVES = new HashMap();
        PRIMITIVES.put("string", Type.STRING);
        PRIMITIVES.put("bytes", Type.BYTES);
        PRIMITIVES.put("int", Type.INT);
        PRIMITIVES.put("long", Type.LONG);
        PRIMITIVES.put("float", Type.FLOAT);
        PRIMITIVES.put("double", Type.DOUBLE);
        PRIMITIVES.put("boolean", Type.BOOLEAN);
        PRIMITIVES.put("null", Type.NULL);
    }






}

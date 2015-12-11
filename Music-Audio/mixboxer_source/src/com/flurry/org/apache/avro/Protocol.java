// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.apache.avro;

import com.flurry.org.codehaus.jackson.JsonFactory;
import com.flurry.org.codehaus.jackson.JsonGenerator;
import com.flurry.org.codehaus.jackson.JsonNode;
import com.flurry.org.codehaus.jackson.JsonParser;
import com.flurry.org.codehaus.jackson.map.ObjectMapper;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.StringWriter;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.flurry.org.apache.avro:
//            Schema, SchemaParseException, AvroRuntimeException

public class Protocol
{
    public class Message
    {

        private String doc;
        private String name;
        private final Schema.Props props;
        private Schema request;
        final Protocol this$0;

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

        public boolean equals(Object obj)
        {
            if (obj != this)
            {
                if (!(obj instanceof Message))
                {
                    return false;
                }
                obj = (Message)obj;
                if (!name.equals(((Message) (obj)).name) || !request.equals(((Message) (obj)).request) || !props.equals(((Message) (obj)).props))
                {
                    return false;
                }
            }
            return true;
        }

        public String getDoc()
        {
            return doc;
        }

        public Schema getErrors()
        {
            return Schema.createUnion(new ArrayList());
        }

        public String getName()
        {
            return name;
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

        public Schema getRequest()
        {
            return request;
        }

        public Schema getResponse()
        {
            return Schema.create(Schema.Type.NULL);
        }

        public int hashCode()
        {
            return name.hashCode() + request.hashCode() + props.hashCode();
        }

        public boolean isOneWay()
        {
            return true;
        }

        void toJson(JsonGenerator jsongenerator)
            throws IOException
        {
            jsongenerator.writeStartObject();
            if (doc != null)
            {
                jsongenerator.writeStringField("doc", doc);
            }
            props.write(jsongenerator);
            jsongenerator.writeFieldName("request");
            request.fieldsToJson(types, jsongenerator);
            toJson1(jsongenerator);
            jsongenerator.writeEndObject();
        }

        void toJson1(JsonGenerator jsongenerator)
            throws IOException
        {
            jsongenerator.writeStringField("response", "null");
            jsongenerator.writeBooleanField("one-way", true);
        }

        public String toString()
        {
            Object obj;
            try
            {
                obj = new StringWriter();
                JsonGenerator jsongenerator = Schema.FACTORY.createJsonGenerator(((java.io.Writer) (obj)));
                toJson(jsongenerator);
                jsongenerator.flush();
                obj = ((StringWriter) (obj)).toString();
            }
            catch (IOException ioexception)
            {
                throw new AvroRuntimeException(ioexception);
            }
            return ((String) (obj));
        }

        private Message(String s, String s1, Map map, Schema schema)
        {
            this$0 = Protocol.this;
            super();
            props = new Schema.Props(Protocol.MESSAGE_RESERVED);
            name = s;
            doc = s1;
            request = schema;
            if (map != null)
            {
                for (protocol = map.entrySet().iterator(); hasNext(); addProp((String)s.getKey(), (String)s.getValue()))
                {
                    s = (java.util.Map.Entry)next();
                }

            }
        }

    }

    private class TwoWayMessage extends Message
    {

        private Schema errors;
        private Schema response;
        final Protocol this$0;

        public boolean equals(Object obj)
        {
            if (super.equals(obj) && (obj instanceof TwoWayMessage))
            {
                obj = (TwoWayMessage)obj;
                if (response.equals(((TwoWayMessage) (obj)).response) && errors.equals(((TwoWayMessage) (obj)).errors))
                {
                    return true;
                }
            }
            return false;
        }

        public Schema getErrors()
        {
            return errors;
        }

        public Schema getResponse()
        {
            return response;
        }

        public int hashCode()
        {
            return super.hashCode() + response.hashCode() + errors.hashCode();
        }

        public boolean isOneWay()
        {
            return false;
        }

        void toJson1(JsonGenerator jsongenerator)
            throws IOException
        {
            jsongenerator.writeFieldName("response");
            response.toJson(types, jsongenerator);
            Object obj = errors.getTypes();
            if (((List) (obj)).size() > 1)
            {
                obj = Schema.createUnion(((List) (obj)).subList(1, ((List) (obj)).size()));
                jsongenerator.writeFieldName("errors");
                ((Schema) (obj)).toJson(types, jsongenerator);
            }
        }

        private TwoWayMessage(String s, String s1, Map map, Schema schema, Schema schema1, Schema schema2)
        {
            this$0 = Protocol.this;
            super(s, s1, map, schema);
            response = schema1;
            errors = schema2;
        }

    }


    private static final Set MESSAGE_RESERVED;
    private static final Set PROTOCOL_RESERVED;
    public static final Schema SYSTEM_ERROR;
    public static final Schema SYSTEM_ERRORS;
    public static final long VERSION = 1L;
    private String doc;
    private byte md5[];
    private Map messages;
    private String name;
    private String namespace;
    Schema.Props props;
    private Schema.Names types;

    private Protocol()
    {
        types = new Schema.Names();
        messages = new LinkedHashMap();
        props = new Schema.Props(PROTOCOL_RESERVED);
    }

    public Protocol(String s, String s1)
    {
        this(s, null, s1);
    }

    public Protocol(String s, String s1, String s2)
    {
        types = new Schema.Names();
        messages = new LinkedHashMap();
        props = new Schema.Props(PROTOCOL_RESERVED);
        name = s;
        doc = s1;
        namespace = s2;
    }

    public static void main(String args[])
        throws Exception
    {
        System.out.println(parse(new File(args[0])));
    }

    private static Protocol parse(JsonParser jsonparser)
    {
        Protocol protocol;
        try
        {
            protocol = new Protocol();
            protocol.parse(Schema.MAPPER.readTree(jsonparser));
        }
        // Misplaced declaration of an exception variable
        catch (JsonParser jsonparser)
        {
            throw new SchemaParseException(jsonparser);
        }
        return protocol;
    }

    public static Protocol parse(File file)
        throws IOException
    {
        return parse(Schema.FACTORY.createJsonParser(file));
    }

    public static Protocol parse(InputStream inputstream)
        throws IOException
    {
        return parse(Schema.FACTORY.createJsonParser(inputstream));
    }

    public static Protocol parse(String s)
    {
        try
        {
            s = parse(Schema.FACTORY.createJsonParser(new ByteArrayInputStream(s.getBytes("UTF-8"))));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new AvroRuntimeException(s);
        }
        return s;
    }

    private void parse(JsonNode jsonnode)
    {
        parseNamespace(jsonnode);
        parseName(jsonnode);
        parseTypes(jsonnode);
        parseMessages(jsonnode);
        parseDoc(jsonnode);
        parseProps(jsonnode);
    }

    private void parseDoc(JsonNode jsonnode)
    {
        doc = parseDocNode(jsonnode);
    }

    private String parseDocNode(JsonNode jsonnode)
    {
        jsonnode = jsonnode.get("doc");
        if (jsonnode == null)
        {
            return null;
        } else
        {
            return jsonnode.getTextValue();
        }
    }

    private Message parseMessage(String s, JsonNode jsonnode)
    {
        String s1 = parseDocNode(jsonnode);
        LinkedHashMap linkedhashmap = new LinkedHashMap();
        Object obj = jsonnode.getFieldNames();
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break;
            }
            String s2 = (String)((Iterator) (obj)).next();
            if (!MESSAGE_RESERVED.contains(s2))
            {
                JsonNode jsonnode1 = jsonnode.get(s2);
                if (jsonnode1.isValueNode() && jsonnode1.isTextual())
                {
                    linkedhashmap.put(s2, jsonnode1.getTextValue());
                }
            }
        } while (true);
        Object obj1 = jsonnode.get("request");
        if (obj1 == null || !((JsonNode) (obj1)).isArray())
        {
            throw new SchemaParseException((new StringBuilder()).append("No request specified: ").append(jsonnode).toString());
        }
        obj = new ArrayList();
        JsonNode jsonnode2;
        JsonNode jsonnode3;
        JsonNode jsonnode5;
        for (obj1 = ((JsonNode) (obj1)).iterator(); ((Iterator) (obj1)).hasNext(); ((List) (obj)).add(new Schema.Field(jsonnode3.getTextValue(), Schema.parse(jsonnode5, types), null, jsonnode2.get("default"))))
        {
            jsonnode2 = (JsonNode)((Iterator) (obj1)).next();
            jsonnode3 = jsonnode2.get("name");
            if (jsonnode3 == null)
            {
                throw new SchemaParseException((new StringBuilder()).append("No param name: ").append(jsonnode2).toString());
            }
            jsonnode5 = jsonnode2.get("type");
            if (jsonnode5 == null)
            {
                throw new SchemaParseException((new StringBuilder()).append("No param type: ").append(jsonnode2).toString());
            }
        }

        obj = Schema.createRecord(((List) (obj)));
        boolean flag = false;
        obj1 = jsonnode.get("one-way");
        if (obj1 != null)
        {
            if (!((JsonNode) (obj1)).isBoolean())
            {
                throw new SchemaParseException((new StringBuilder()).append("one-way must be boolean: ").append(jsonnode).toString());
            }
            flag = ((JsonNode) (obj1)).getBooleanValue();
        }
        obj1 = jsonnode.get("response");
        if (!flag && obj1 == null)
        {
            throw new SchemaParseException((new StringBuilder()).append("No response specified: ").append(jsonnode).toString());
        }
        JsonNode jsonnode4 = jsonnode.get("errors");
        if (flag)
        {
            if (jsonnode4 != null)
            {
                throw new SchemaParseException((new StringBuilder()).append("one-way can't have errors: ").append(jsonnode).toString());
            }
            if (obj1 != null && Schema.parse(((JsonNode) (obj1)), types).getType() != Schema.Type.NULL)
            {
                throw new SchemaParseException((new StringBuilder()).append("One way response must be null: ").append(jsonnode).toString());
            } else
            {
                return new Message(s, s1, linkedhashmap, ((Schema) (obj)));
            }
        }
        obj1 = Schema.parse(((JsonNode) (obj1)), types);
        ArrayList arraylist = new ArrayList();
        arraylist.add(SYSTEM_ERROR);
        if (jsonnode4 != null)
        {
            if (!jsonnode4.isArray())
            {
                throw new SchemaParseException((new StringBuilder()).append("Errors not an array: ").append(jsonnode).toString());
            }
            Schema schema;
            for (jsonnode = jsonnode4.iterator(); jsonnode.hasNext(); arraylist.add(schema))
            {
                String s3 = ((JsonNode)jsonnode.next()).getTextValue();
                schema = types.get(s3);
                if (schema == null)
                {
                    throw new SchemaParseException((new StringBuilder()).append("Undefined error: ").append(s3).toString());
                }
                if (!schema.isError())
                {
                    throw new SchemaParseException((new StringBuilder()).append("Not an error: ").append(s3).toString());
                }
            }

        }
        return new TwoWayMessage(s, s1, linkedhashmap, ((Schema) (obj)), ((Schema) (obj1)), Schema.createUnion(arraylist));
    }

    private void parseMessages(JsonNode jsonnode)
    {
        jsonnode = jsonnode.get("messages");
        if (jsonnode != null)
        {
            Iterator iterator = jsonnode.getFieldNames();
            while (iterator.hasNext()) 
            {
                String s = (String)iterator.next();
                messages.put(s, parseMessage(s, jsonnode.get(s)));
            }
        }
    }

    private void parseName(JsonNode jsonnode)
    {
        JsonNode jsonnode1 = jsonnode.get("protocol");
        if (jsonnode1 == null)
        {
            throw new SchemaParseException((new StringBuilder()).append("No protocol name specified: ").append(jsonnode).toString());
        } else
        {
            name = jsonnode1.getTextValue();
            return;
        }
    }

    private void parseNamespace(JsonNode jsonnode)
    {
        jsonnode = jsonnode.get("namespace");
        if (jsonnode == null)
        {
            return;
        } else
        {
            namespace = jsonnode.getTextValue();
            types.space(namespace);
            return;
        }
    }

    private void parseProps(JsonNode jsonnode)
    {
        Iterator iterator = jsonnode.getFieldNames();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            String s = (String)iterator.next();
            if (!PROTOCOL_RESERVED.contains(s))
            {
                JsonNode jsonnode1 = jsonnode.get(s);
                if (jsonnode1.isValueNode() && jsonnode1.isTextual())
                {
                    addProp(s, jsonnode1.getTextValue());
                }
            }
        } while (true);
    }

    private void parseTypes(JsonNode jsonnode)
    {
        jsonnode = jsonnode.get("types");
        if (jsonnode != null)
        {
            if (!jsonnode.isArray())
            {
                throw new SchemaParseException((new StringBuilder()).append("Types not an array: ").append(jsonnode).toString());
            }
            jsonnode = jsonnode.iterator();
            while (jsonnode.hasNext()) 
            {
                JsonNode jsonnode1 = (JsonNode)jsonnode.next();
                if (!jsonnode1.isObject())
                {
                    throw new SchemaParseException((new StringBuilder()).append("Type not an object: ").append(jsonnode1).toString());
                }
                Schema.parse(jsonnode1, types);
            }
        }
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

    public Message createMessage(String s, String s1, Schema schema)
    {
        return createMessage(s, s1, ((Map) (new LinkedHashMap())), schema);
    }

    public Message createMessage(String s, String s1, Schema schema, Schema schema1, Schema schema2)
    {
        return createMessage(s, s1, ((Map) (new LinkedHashMap())), schema, schema1, schema2);
    }

    public Message createMessage(String s, String s1, Map map, Schema schema)
    {
        return new Message(s, s1, map, schema);
    }

    public Message createMessage(String s, String s1, Map map, Schema schema, Schema schema1, Schema schema2)
    {
        return new TwoWayMessage(s, s1, map, schema, schema1, schema2);
    }

    public boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (!(obj instanceof Protocol))
            {
                return false;
            }
            obj = (Protocol)obj;
            if (!name.equals(((Protocol) (obj)).name) || !namespace.equals(((Protocol) (obj)).namespace) || !types.equals(((Protocol) (obj)).types) || !messages.equals(((Protocol) (obj)).messages) || !props.equals(props))
            {
                return false;
            }
        }
        return true;
    }

    public String getDoc()
    {
        return doc;
    }

    public byte[] getMD5()
    {
        if (md5 == null)
        {
            try
            {
                md5 = MessageDigest.getInstance("MD5").digest(toString().getBytes("UTF-8"));
            }
            catch (Exception exception)
            {
                throw new AvroRuntimeException(exception);
            }
        }
        return md5;
    }

    public Map getMessages()
    {
        return messages;
    }

    public String getName()
    {
        return name;
    }

    public String getNamespace()
    {
        return namespace;
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

    public Schema getType(String s)
    {
        return types.get(s);
    }

    public Collection getTypes()
    {
        return types.values();
    }

    public int hashCode()
    {
        return name.hashCode() + namespace.hashCode() + types.hashCode() + messages.hashCode() + props.hashCode();
    }

    public void setTypes(Collection collection)
    {
        types = new Schema.Names();
        Schema schema;
        for (collection = collection.iterator(); collection.hasNext(); types.add(schema))
        {
            schema = (Schema)collection.next();
        }

    }

    void toJson(JsonGenerator jsongenerator)
        throws IOException
    {
        types.space(namespace);
        jsongenerator.writeStartObject();
        jsongenerator.writeStringField("protocol", name);
        jsongenerator.writeStringField("namespace", namespace);
        if (doc != null)
        {
            jsongenerator.writeStringField("doc", doc);
        }
        props.write(jsongenerator);
        jsongenerator.writeArrayFieldStart("types");
        Schema.Names names = new Schema.Names(namespace);
        Iterator iterator1 = types.values().iterator();
        do
        {
            if (!iterator1.hasNext())
            {
                break;
            }
            Schema schema = (Schema)iterator1.next();
            if (!names.contains(schema))
            {
                schema.toJson(names, jsongenerator);
            }
        } while (true);
        jsongenerator.writeEndArray();
        jsongenerator.writeObjectFieldStart("messages");
        java.util.Map.Entry entry;
        for (Iterator iterator = messages.entrySet().iterator(); iterator.hasNext(); ((Message)entry.getValue()).toJson(jsongenerator))
        {
            entry = (java.util.Map.Entry)iterator.next();
            jsongenerator.writeFieldName((String)entry.getKey());
        }

        jsongenerator.writeEndObject();
        jsongenerator.writeEndObject();
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
            jsongenerator = Schema.FACTORY.createJsonGenerator(((java.io.Writer) (obj)));
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
        toJson(jsongenerator);
        jsongenerator.flush();
        obj = ((StringWriter) (obj)).toString();
        return ((String) (obj));
    }

    static 
    {
        MESSAGE_RESERVED = new HashSet();
        Collections.addAll(MESSAGE_RESERVED, new String[] {
            "doc", "response", "request", "errors", "one-way"
        });
        SYSTEM_ERROR = Schema.create(Schema.Type.STRING);
        ArrayList arraylist = new ArrayList();
        arraylist.add(SYSTEM_ERROR);
        SYSTEM_ERRORS = Schema.createUnion(arraylist);
        PROTOCOL_RESERVED = new HashSet();
        Collections.addAll(PROTOCOL_RESERVED, new String[] {
            "namespace", "protocol", "doc", "messages", "types", "errors"
        });
    }


}

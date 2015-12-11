// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fasterxml.jackson.databind.node;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonPointer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.fasterxml.jackson.databind.node:
//            ContainerNode, JsonNodeType, MissingNode, BaseJsonNode, 
//            TextNode, ArrayNode, JsonNodeFactory

public class ObjectNode extends ContainerNode
{

    private final Map _children = new LinkedHashMap();

    public ObjectNode(JsonNodeFactory jsonnodefactory)
    {
        super(jsonnodefactory);
    }

    protected JsonNode _at(JsonPointer jsonpointer)
    {
        return get(jsonpointer.getMatchingProperty());
    }

    protected boolean _childrenEqual(ObjectNode objectnode)
    {
        return _children.equals(objectnode._children);
    }

    protected ObjectNode _put(String s, JsonNode jsonnode)
    {
        _children.put(s, jsonnode);
        return this;
    }

    public JsonToken asToken()
    {
        return JsonToken.START_OBJECT;
    }

    public volatile JsonNode deepCopy()
    {
        return deepCopy();
    }

    public ObjectNode deepCopy()
    {
        ObjectNode objectnode = new ObjectNode(_nodeFactory);
        java.util.Map.Entry entry;
        for (Iterator iterator = _children.entrySet().iterator(); iterator.hasNext(); objectnode._children.put(entry.getKey(), ((JsonNode)entry.getValue()).deepCopy()))
        {
            entry = (java.util.Map.Entry)iterator.next();
        }

        return objectnode;
    }

    public Iterator elements()
    {
        return _children.values().iterator();
    }

    public boolean equals(Object obj)
    {
        boolean flag1 = false;
        boolean flag;
        if (obj == this)
        {
            flag = true;
        } else
        {
            flag = flag1;
            if (obj != null)
            {
                flag = flag1;
                if (obj instanceof ObjectNode)
                {
                    return _childrenEqual((ObjectNode)obj);
                }
            }
        }
        return flag;
    }

    public Iterator fieldNames()
    {
        return _children.keySet().iterator();
    }

    public Iterator fields()
    {
        return _children.entrySet().iterator();
    }

    public volatile JsonNode findParent(String s)
    {
        return findParent(s);
    }

    public ObjectNode findParent(String s)
    {
        for (Iterator iterator = _children.entrySet().iterator(); iterator.hasNext();)
        {
            Object obj = (java.util.Map.Entry)iterator.next();
            if (s.equals(((java.util.Map.Entry) (obj)).getKey()))
            {
                return this;
            }
            obj = ((JsonNode)((java.util.Map.Entry) (obj)).getValue()).findParent(s);
            if (obj != null)
            {
                return (ObjectNode)obj;
            }
        }

        return null;
    }

    public List findParents(String s, List list)
    {
        for (Iterator iterator = _children.entrySet().iterator(); iterator.hasNext();)
        {
            java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
            if (s.equals(entry.getKey()))
            {
                if (list == null)
                {
                    list = new ArrayList();
                }
                list.add(this);
            } else
            {
                list = ((JsonNode)entry.getValue()).findParents(s, list);
            }
        }

        return list;
    }

    public JsonNode findValue(String s)
    {
        for (Iterator iterator = _children.entrySet().iterator(); iterator.hasNext();)
        {
            Object obj = (java.util.Map.Entry)iterator.next();
            if (s.equals(((java.util.Map.Entry) (obj)).getKey()))
            {
                return (JsonNode)((java.util.Map.Entry) (obj)).getValue();
            }
            obj = ((JsonNode)((java.util.Map.Entry) (obj)).getValue()).findValue(s);
            if (obj != null)
            {
                return ((JsonNode) (obj));
            }
        }

        return null;
    }

    public List findValues(String s, List list)
    {
        for (Iterator iterator = _children.entrySet().iterator(); iterator.hasNext();)
        {
            java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
            if (s.equals(entry.getKey()))
            {
                Object obj = list;
                if (list == null)
                {
                    obj = new ArrayList();
                }
                ((List) (obj)).add(entry.getValue());
                list = ((List) (obj));
            } else
            {
                list = ((JsonNode)entry.getValue()).findValues(s, list);
            }
        }

        return list;
    }

    public List findValuesAsText(String s, List list)
    {
        for (Iterator iterator = _children.entrySet().iterator(); iterator.hasNext();)
        {
            java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
            if (s.equals(entry.getKey()))
            {
                Object obj = list;
                if (list == null)
                {
                    obj = new ArrayList();
                }
                ((List) (obj)).add(((JsonNode)entry.getValue()).asText());
                list = ((List) (obj));
            } else
            {
                list = ((JsonNode)entry.getValue()).findValuesAsText(s, list);
            }
        }

        return list;
    }

    public volatile TreeNode get(int i)
    {
        return get(i);
    }

    public volatile TreeNode get(String s)
    {
        return get(s);
    }

    public JsonNode get(int i)
    {
        return null;
    }

    public JsonNode get(String s)
    {
        return (JsonNode)_children.get(s);
    }

    public JsonNodeType getNodeType()
    {
        return JsonNodeType.OBJECT;
    }

    public int hashCode()
    {
        return _children.hashCode();
    }

    public volatile TreeNode path(int i)
    {
        return path(i);
    }

    public volatile TreeNode path(String s)
    {
        return path(s);
    }

    public JsonNode path(int i)
    {
        return MissingNode.getInstance();
    }

    public JsonNode path(String s)
    {
        s = (JsonNode)_children.get(s);
        if (s != null)
        {
            return s;
        } else
        {
            return MissingNode.getInstance();
        }
    }

    public JsonNode put(String s, JsonNode jsonnode)
    {
        Object obj = jsonnode;
        if (jsonnode == null)
        {
            obj = nullNode();
        }
        return (JsonNode)_children.put(s, obj);
    }

    public ObjectNode put(String s, double d)
    {
        return _put(s, numberNode(d));
    }

    public ObjectNode put(String s, float f)
    {
        return _put(s, numberNode(f));
    }

    public ObjectNode put(String s, int i)
    {
        return _put(s, numberNode(i));
    }

    public ObjectNode put(String s, long l)
    {
        return _put(s, numberNode(l));
    }

    public ObjectNode put(String s, Boolean boolean1)
    {
        if (boolean1 == null)
        {
            boolean1 = nullNode();
        } else
        {
            boolean1 = booleanNode(boolean1.booleanValue());
        }
        return _put(s, boolean1);
    }

    public ObjectNode put(String s, Double double1)
    {
        if (double1 == null)
        {
            double1 = nullNode();
        } else
        {
            double1 = numberNode(double1.doubleValue());
        }
        return _put(s, double1);
    }

    public ObjectNode put(String s, Float float1)
    {
        if (float1 == null)
        {
            float1 = nullNode();
        } else
        {
            float1 = numberNode(float1.floatValue());
        }
        return _put(s, float1);
    }

    public ObjectNode put(String s, Integer integer)
    {
        if (integer == null)
        {
            integer = nullNode();
        } else
        {
            integer = numberNode(integer.intValue());
        }
        return _put(s, integer);
    }

    public ObjectNode put(String s, Long long1)
    {
        if (long1 == null)
        {
            long1 = nullNode();
        } else
        {
            long1 = numberNode(long1.longValue());
        }
        return _put(s, long1);
    }

    public ObjectNode put(String s, Short short1)
    {
        if (short1 == null)
        {
            short1 = nullNode();
        } else
        {
            short1 = numberNode(short1.shortValue());
        }
        return _put(s, short1);
    }

    public ObjectNode put(String s, String s1)
    {
        if (s1 == null)
        {
            s1 = nullNode();
        } else
        {
            s1 = textNode(s1);
        }
        return _put(s, s1);
    }

    public ObjectNode put(String s, BigDecimal bigdecimal)
    {
        if (bigdecimal == null)
        {
            bigdecimal = nullNode();
        } else
        {
            bigdecimal = numberNode(bigdecimal);
        }
        return _put(s, bigdecimal);
    }

    public ObjectNode put(String s, short word0)
    {
        return _put(s, numberNode(word0));
    }

    public ObjectNode put(String s, boolean flag)
    {
        return _put(s, booleanNode(flag));
    }

    public ObjectNode put(String s, byte abyte0[])
    {
        if (abyte0 == null)
        {
            abyte0 = nullNode();
        } else
        {
            abyte0 = binaryNode(abyte0);
        }
        return _put(s, abyte0);
    }

    public JsonNode putAll(ObjectNode objectnode)
    {
        return setAll(objectnode);
    }

    public JsonNode putAll(Map map)
    {
        return setAll(map);
    }

    public ArrayNode putArray(String s)
    {
        ArrayNode arraynode = arrayNode();
        _put(s, arraynode);
        return arraynode;
    }

    public ObjectNode putNull(String s)
    {
        _children.put(s, nullNode());
        return this;
    }

    public ObjectNode putObject(String s)
    {
        ObjectNode objectnode = objectNode();
        _put(s, objectnode);
        return objectnode;
    }

    public ObjectNode putPOJO(String s, Object obj)
    {
        return _put(s, pojoNode(obj));
    }

    public JsonNode remove(String s)
    {
        return (JsonNode)_children.remove(s);
    }

    public ObjectNode remove(Collection collection)
    {
        _children.keySet().removeAll(collection);
        return this;
    }

    public volatile ContainerNode removeAll()
    {
        return removeAll();
    }

    public ObjectNode removeAll()
    {
        _children.clear();
        return this;
    }

    public JsonNode replace(String s, JsonNode jsonnode)
    {
        Object obj = jsonnode;
        if (jsonnode == null)
        {
            obj = nullNode();
        }
        return (JsonNode)_children.put(s, obj);
    }

    public ObjectNode retain(Collection collection)
    {
        _children.keySet().retainAll(collection);
        return this;
    }

    public transient ObjectNode retain(String as[])
    {
        return retain(((Collection) (Arrays.asList(as))));
    }

    public void serialize(JsonGenerator jsongenerator, SerializerProvider serializerprovider)
        throws IOException, JsonProcessingException
    {
        jsongenerator.writeStartObject();
        java.util.Map.Entry entry;
        for (Iterator iterator = _children.entrySet().iterator(); iterator.hasNext(); ((BaseJsonNode)entry.getValue()).serialize(jsongenerator, serializerprovider))
        {
            entry = (java.util.Map.Entry)iterator.next();
            jsongenerator.writeFieldName((String)entry.getKey());
        }

        jsongenerator.writeEndObject();
    }

    public void serializeWithType(JsonGenerator jsongenerator, SerializerProvider serializerprovider, TypeSerializer typeserializer)
        throws IOException, JsonProcessingException
    {
        typeserializer.writeTypePrefixForObject(this, jsongenerator);
        java.util.Map.Entry entry;
        for (Iterator iterator = _children.entrySet().iterator(); iterator.hasNext(); ((BaseJsonNode)entry.getValue()).serialize(jsongenerator, serializerprovider))
        {
            entry = (java.util.Map.Entry)iterator.next();
            jsongenerator.writeFieldName((String)entry.getKey());
        }

        typeserializer.writeTypeSuffixForObject(this, jsongenerator);
    }

    public JsonNode set(String s, JsonNode jsonnode)
    {
        Object obj = jsonnode;
        if (jsonnode == null)
        {
            obj = nullNode();
        }
        _children.put(s, obj);
        return this;
    }

    public JsonNode setAll(ObjectNode objectnode)
    {
        _children.putAll(objectnode._children);
        return this;
    }

    public JsonNode setAll(Map map)
    {
        java.util.Map.Entry entry;
        for (Iterator iterator = map.entrySet().iterator(); iterator.hasNext(); _children.put(entry.getKey(), map))
        {
            entry = (java.util.Map.Entry)iterator.next();
            JsonNode jsonnode = (JsonNode)entry.getValue();
            map = jsonnode;
            if (jsonnode == null)
            {
                map = nullNode();
            }
        }

        return this;
    }

    public int size()
    {
        return _children.size();
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder((size() << 4) + 32);
        stringbuilder.append("{");
        Iterator iterator = _children.entrySet().iterator();
        for (int i = 0; iterator.hasNext(); i++)
        {
            java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
            if (i > 0)
            {
                stringbuilder.append(",");
            }
            TextNode.appendQuoted(stringbuilder, (String)entry.getKey());
            stringbuilder.append(':');
            stringbuilder.append(((JsonNode)entry.getValue()).toString());
        }

        stringbuilder.append("}");
        return stringbuilder.toString();
    }

    public volatile JsonNode with(String s)
    {
        return with(s);
    }

    public ObjectNode with(String s)
    {
        JsonNode jsonnode = (JsonNode)_children.get(s);
        if (jsonnode != null)
        {
            if (jsonnode instanceof ObjectNode)
            {
                return (ObjectNode)jsonnode;
            } else
            {
                throw new UnsupportedOperationException((new StringBuilder()).append("Property '").append(s).append("' has value that is not of type ObjectNode (but ").append(jsonnode.getClass().getName()).append(")").toString());
            }
        } else
        {
            ObjectNode objectnode = objectNode();
            _children.put(s, objectnode);
            return objectnode;
        }
    }

    public volatile JsonNode withArray(String s)
    {
        return withArray(s);
    }

    public ArrayNode withArray(String s)
    {
        JsonNode jsonnode = (JsonNode)_children.get(s);
        if (jsonnode != null)
        {
            if (jsonnode instanceof ArrayNode)
            {
                return (ArrayNode)jsonnode;
            } else
            {
                throw new UnsupportedOperationException((new StringBuilder()).append("Property '").append(s).append("' has value that is not of type ArrayNode (but ").append(jsonnode.getClass().getName()).append(")").toString());
            }
        } else
        {
            ArrayNode arraynode = arrayNode();
            _children.put(s, arraynode);
            return arraynode;
        }
    }

    public JsonNode without(String s)
    {
        _children.remove(s);
        return this;
    }

    public ObjectNode without(Collection collection)
    {
        _children.keySet().removeAll(collection);
        return this;
    }
}

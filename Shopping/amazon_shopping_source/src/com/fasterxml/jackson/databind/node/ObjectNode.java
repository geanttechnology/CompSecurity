// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fasterxml.jackson.databind.node;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.fasterxml.jackson.databind.node:
//            ContainerNode, MissingNode, BaseJsonNode, TextNode, 
//            JsonNodeFactory

public class ObjectNode extends ContainerNode
{

    protected Map _children;

    public ObjectNode(JsonNodeFactory jsonnodefactory)
    {
        super(jsonnodefactory);
        _children = null;
    }

    private final JsonNode _put(String s, JsonNode jsonnode)
    {
        if (_children == null)
        {
            _children = _createMap();
        }
        return (JsonNode)_children.put(s, jsonnode);
    }

    protected Map _createMap()
    {
        return new LinkedHashMap();
    }

    public Iterator elements()
    {
        if (_children == null)
        {
            return ContainerNode.NoNodesIterator.instance();
        } else
        {
            return _children.values().iterator();
        }
    }

    public boolean equals(Object obj)
    {
        if (obj != this) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        if (obj == null)
        {
            return false;
        }
        if (obj.getClass() != getClass())
        {
            return false;
        }
        obj = (ObjectNode)obj;
        if (((ObjectNode) (obj)).size() != size())
        {
            return false;
        }
        if (_children == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        Iterator iterator = _children.entrySet().iterator();
        Object obj1;
        Object obj2;
        do
        {
            if (!iterator.hasNext())
            {
                continue; /* Loop/switch isn't completed */
            }
            obj2 = (java.util.Map.Entry)iterator.next();
            obj1 = (String)((java.util.Map.Entry) (obj2)).getKey();
            obj2 = (JsonNode)((java.util.Map.Entry) (obj2)).getValue();
            obj1 = ((ObjectNode) (obj)).get(((String) (obj1)));
        } while (obj1 != null && ((JsonNode) (obj1)).equals(obj2));
        break; /* Loop/switch isn't completed */
        if (true) goto _L1; else goto _L3
_L3:
        return false;
    }

    public JsonNode get(String s)
    {
        if (_children != null)
        {
            return (JsonNode)_children.get(s);
        } else
        {
            return null;
        }
    }

    public int hashCode()
    {
        if (_children == null)
        {
            return -1;
        } else
        {
            return _children.hashCode();
        }
    }

    public JsonNode path(String s)
    {
        if (_children != null)
        {
            s = (JsonNode)_children.get(s);
            if (s != null)
            {
                return s;
            }
        }
        return MissingNode.getInstance();
    }

    public JsonNode replace(String s, JsonNode jsonnode)
    {
        Object obj = jsonnode;
        if (jsonnode == null)
        {
            obj = nullNode();
        }
        return _put(s, ((JsonNode) (obj)));
    }

    public final void serialize(JsonGenerator jsongenerator, SerializerProvider serializerprovider)
        throws IOException, JsonProcessingException
    {
        jsongenerator.writeStartObject();
        if (_children != null)
        {
            java.util.Map.Entry entry;
            for (Iterator iterator = _children.entrySet().iterator(); iterator.hasNext(); ((BaseJsonNode)entry.getValue()).serialize(jsongenerator, serializerprovider))
            {
                entry = (java.util.Map.Entry)iterator.next();
                jsongenerator.writeFieldName((String)entry.getKey());
            }

        }
        jsongenerator.writeEndObject();
    }

    public void serializeWithType(JsonGenerator jsongenerator, SerializerProvider serializerprovider, TypeSerializer typeserializer)
        throws IOException, JsonProcessingException
    {
        typeserializer.writeTypePrefixForObject(this, jsongenerator);
        if (_children != null)
        {
            java.util.Map.Entry entry;
            for (Iterator iterator = _children.entrySet().iterator(); iterator.hasNext(); ((BaseJsonNode)entry.getValue()).serialize(jsongenerator, serializerprovider))
            {
                entry = (java.util.Map.Entry)iterator.next();
                jsongenerator.writeFieldName((String)entry.getKey());
            }

        }
        typeserializer.writeTypeSuffixForObject(this, jsongenerator);
    }

    public int size()
    {
        if (_children == null)
        {
            return 0;
        } else
        {
            return _children.size();
        }
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder((size() << 4) + 32);
        stringbuilder.append("{");
        if (_children != null)
        {
            int i = 0;
            java.util.Map.Entry entry;
            for (Iterator iterator = _children.entrySet().iterator(); iterator.hasNext(); stringbuilder.append(((JsonNode)entry.getValue()).toString()))
            {
                entry = (java.util.Map.Entry)iterator.next();
                if (i > 0)
                {
                    stringbuilder.append(",");
                }
                i++;
                TextNode.appendQuoted(stringbuilder, (String)entry.getKey());
                stringbuilder.append(':');
            }

        }
        stringbuilder.append("}");
        return stringbuilder.toString();
    }
}

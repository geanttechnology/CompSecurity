// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.microdata.deserialization;

import com.comcast.cim.microdata.exception.MicrodataConversionException;
import com.comcast.cim.microdata.http.HttpMethod;
import com.comcast.cim.microdata.model.FieldOption;
import com.comcast.cim.microdata.model.FormFieldType;
import com.comcast.cim.microdata.model.MicrodataForm;
import com.comcast.cim.microdata.model.MicrodataFormField;
import com.comcast.cim.microdata.model.MicrodataFormValue;
import com.comcast.cim.microdata.model.MicrodataItem;
import com.comcast.cim.microdata.model.MicrodataLink;
import com.comcast.cim.microdata.model.MicrodataLinkValue;
import com.comcast.cim.microdata.model.MicrodataProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.comcast.cim.microdata.deserialization:
//            MicrodataDeserializer, MicrodataModelFactory

public class HalToMicrodataConverter
    implements MicrodataDeserializer
{

    private final MicrodataModelFactory modelFactory;
    private final ObjectMapper objectMapper;

    public HalToMicrodataConverter(ObjectMapper objectmapper, MicrodataModelFactory microdatamodelfactory)
    {
        objectMapper = objectmapper;
        modelFactory = microdatamodelfactory;
    }

    private boolean parseBooleanNode(JsonNode jsonnode, String s, boolean flag)
    {
        jsonnode = jsonnode.get(s);
        if (jsonnode != null)
        {
            flag = jsonnode.asBoolean();
        }
        return flag;
    }

    private FieldOption parseFieldOptionNode(String s, JsonNode jsonnode)
    {
        return new FieldOption(s, parseTextNode(jsonnode, "label"), parseIntNode(jsonnode, "order", 0));
    }

    private List parseFieldOptions(JsonNode jsonnode)
    {
        ArrayList arraylist = new ArrayList();
        if (jsonnode != null)
        {
            String s;
            for (Iterator iterator = jsonnode.fieldNames(); iterator.hasNext(); arraylist.add(parseFieldOptionNode(s, jsonnode.get(s))))
            {
                s = (String)iterator.next();
            }

        }
        return arraylist;
    }

    private MicrodataForm parseForm(String s, JsonNode jsonnode)
    {
        if (jsonnode.isArray())
        {
            jsonnode = parseMultiValueForm((ArrayNode)jsonnode);
            return modelFactory.createMicrodataForm(s, jsonnode);
        } else
        {
            jsonnode = parseSingleValueForm((ObjectNode)jsonnode);
            return modelFactory.createMicrodataForm(s, jsonnode);
        }
    }

    private MicrodataFormField parseFormField(JsonNode jsonnode, String s)
    {
        String s1 = parseTextNode(jsonnode, "default", "");
        String s2 = parseTextNode(jsonnode, "type", null);
        String s3 = parseTextNode(jsonnode, "label", s);
        int i = parseIntNode(jsonnode, "order", 0);
        String s4 = parseTextNode(jsonnode, "min", null);
        String s5 = parseTextNode(jsonnode, "max", null);
        jsonnode = parseFieldOptions(jsonnode.get("options"));
        s = new com.comcast.cim.microdata.model.MicrodataFormField.Builder(s);
        s.defaultValue(s1);
        s.label(s3);
        s.options(jsonnode);
        s.type(FormFieldType.parseType(s2));
        s.order(i);
        s.minimum(s4);
        s.maximum(s5);
        return s.build();
    }

    private List parseFormFields(JsonNode jsonnode)
    {
        ArrayList arraylist = new ArrayList();
        if (jsonnode != null)
        {
            String s;
            for (Iterator iterator = jsonnode.fieldNames(); iterator.hasNext(); arraylist.add(parseFormField(jsonnode.get(s), s)))
            {
                s = (String)iterator.next();
            }

        }
        return arraylist;
    }

    private List parseForms(JsonNode jsonnode)
    {
        ArrayList arraylist = new ArrayList();
        jsonnode = jsonnode.get("_forms");
        if (jsonnode != null)
        {
            Iterator iterator = jsonnode.fieldNames();
            while (iterator.hasNext()) 
            {
                String s = (String)iterator.next();
                arraylist.add(parseForm(s, jsonnode.get(s)));
            }
        }
        return arraylist;
    }

    private int parseIntNode(JsonNode jsonnode, String s, int i)
    {
        jsonnode = jsonnode.get(s);
        if (jsonnode != null)
        {
            i = jsonnode.asInt();
        }
        return i;
    }

    private MicrodataLink parseLink(String s, JsonNode jsonnode)
    {
        if (jsonnode.isArray())
        {
            return parseMultiValueLink(s, (ArrayNode)jsonnode);
        } else
        {
            return parseSingleValueLink(s, (ObjectNode)jsonnode);
        }
    }

    private MicrodataLinkValue parseLinkValue(JsonNode jsonnode)
    {
        String s = parseTextNode(jsonnode, "href");
        String s1 = parseTextNode(jsonnode, "name");
        String s2 = parseTextNode(jsonnode, "title");
        String s3 = parseTextNode(jsonnode, "type");
        boolean flag = parseBooleanNode(jsonnode, "templated", false);
        return modelFactory.createMicrodataLinkValue(s, s1, s2, flag, s3);
    }

    private List parseLinks(JsonNode jsonnode)
    {
        ArrayList arraylist = new ArrayList();
        jsonnode = jsonnode.get("_links");
        if (jsonnode != null)
        {
            Iterator iterator = jsonnode.fieldNames();
            while (iterator.hasNext()) 
            {
                String s = (String)iterator.next();
                arraylist.add(parseLink(s, jsonnode.get(s)));
            }
        }
        return arraylist;
    }

    private List parseMultiValueForm(ArrayNode arraynode)
    {
        ArrayList arraylist = new ArrayList(arraynode.size());
        for (int i = 0; i < arraynode.size(); i++)
        {
            arraylist.add(parseSingleValueForm((ObjectNode)arraynode.get(i)));
        }

        return arraylist;
    }

    private MicrodataLink parseMultiValueLink(String s, ArrayNode arraynode)
    {
        ArrayList arraylist = new ArrayList(arraynode.size());
        for (arraynode = arraynode.iterator(); arraynode.hasNext(); arraylist.add(parseLinkValue((JsonNode)arraynode.next()))) { }
        return modelFactory.createMicrodataLink(s, arraylist);
    }

    private MicrodataProperty parseMultivalueProperty(String s, ArrayNode arraynode, boolean flag)
        throws MicrodataConversionException
    {
        ArrayList arraylist = new ArrayList(arraynode.size());
        for (int i = 0; i < arraynode.size(); i++)
        {
            arraylist.add(parseValue(arraynode.get(i)));
        }

        return modelFactory.createMicrodataProperty(s, arraylist, flag);
    }

    private List parseProperties(JsonNode jsonnode, boolean flag)
        throws MicrodataConversionException
    {
        ArrayList arraylist = new ArrayList();
        if (jsonnode != null)
        {
            Iterator iterator = jsonnode.fieldNames();
            while (iterator.hasNext()) 
            {
                String s = (String)iterator.next();
                if (!s.startsWith("_"))
                {
                    arraylist.add(parseProperty(s, jsonnode.get(s), flag));
                }
            }
        }
        return arraylist;
    }

    private MicrodataProperty parseProperty(String s, JsonNode jsonnode, boolean flag)
        throws MicrodataConversionException
    {
        if (jsonnode.isArray())
        {
            return parseMultivalueProperty(s, (ArrayNode)jsonnode, flag);
        } else
        {
            return parseSingleValueProperty(s, jsonnode, flag);
        }
    }

    private MicrodataFormValue parseSingleValueForm(ObjectNode objectnode)
    {
        String s = parseTextNode(objectnode, "title");
        String s1 = parseTextNode(objectnode, "action");
        String s2 = parseTextNode(objectnode, "method");
        HttpMethod httpmethod = HttpMethod.GET;
        if (s2 != null)
        {
            httpmethod = HttpMethod.valueOf(s2);
        }
        objectnode = parseFormFields(objectnode.get("fields"));
        return modelFactory.createMicrodataFormValue(s, s1, httpmethod, objectnode);
    }

    private MicrodataLink parseSingleValueLink(String s, ObjectNode objectnode)
    {
        objectnode = parseLinkValue(objectnode);
        return modelFactory.createMicrodataLink(s, objectnode);
    }

    private MicrodataProperty parseSingleValueProperty(String s, JsonNode jsonnode, boolean flag)
        throws MicrodataConversionException
    {
        jsonnode = ((JsonNode) (parseValue(jsonnode)));
        return modelFactory.createMicrodataProperty(s, jsonnode, flag);
    }

    private String parseTextNode(JsonNode jsonnode, String s)
    {
        return parseTextNode(jsonnode, s, null);
    }

    private String parseTextNode(JsonNode jsonnode, String s, String s1)
    {
        jsonnode = jsonnode.get(s);
        if (jsonnode != null)
        {
            s1 = jsonnode.asText();
        }
        return s1;
    }

    private Object parseValue(JsonNode jsonnode)
        throws MicrodataConversionException
    {
        if (jsonnode.isNull())
        {
            return null;
        }
        if (jsonnode.isBoolean())
        {
            return Boolean.valueOf(jsonnode.booleanValue());
        }
        if (jsonnode.isInt())
        {
            return Integer.valueOf(jsonnode.intValue());
        }
        if (jsonnode.isLong())
        {
            return Long.valueOf(jsonnode.longValue());
        }
        if (jsonnode.isObject())
        {
            return convert(jsonnode);
        } else
        {
            return jsonnode.asText();
        }
    }

    protected MicrodataItem convert(JsonNode jsonnode)
        throws MicrodataConversionException
    {
        return convert(jsonnode, false);
    }

    protected MicrodataItem convert(JsonNode jsonnode, boolean flag)
        throws MicrodataConversionException
    {
        String s = parseTextNode(jsonnode, "_type");
        String s1 = parseTextNode(jsonnode, "_id");
        List list = parseProperties(jsonnode, false);
        List list1 = parseProperties(jsonnode.get("_embedded"), true);
        List list2 = parseLinks(jsonnode);
        jsonnode = parseForms(jsonnode);
        list.addAll(list1);
        return modelFactory.createMicrodataItem(s, s1, list2, jsonnode, list, flag);
    }

    public MicrodataItem convert(InputStream inputstream)
        throws MicrodataConversionException
    {
        try
        {
            inputstream = objectMapper.readTree(inputstream);
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            throw new MicrodataConversionException("Cannot parse HAL JSON", inputstream);
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            throw new MicrodataConversionException("Cannot parse HAL JSON", inputstream);
        }
        return convert(((JsonNode) (inputstream)), true);
    }
}

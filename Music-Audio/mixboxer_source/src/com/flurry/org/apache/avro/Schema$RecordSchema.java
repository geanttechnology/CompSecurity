// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.apache.avro;

import com.flurry.org.codehaus.jackson.JsonGenerator;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.flurry.org.apache.avro:
//            Schema, AvroRuntimeException

private static class isError extends isError
{

    private Map fieldMap;
    private List fields;
    private final boolean isError;

    int computeHash()
    {
        Map map = (Map)Schema.access$1000().get();
        if (!map.containsKey(this)) goto _L2; else goto _L1
_L1:
        int i = 0;
_L4:
        return i;
_L2:
        boolean flag = map.isEmpty();
        int j;
        map.put(this, this);
        i = super.omputeHash();
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
        fields fields1;
        if (!(obj instanceof fields))
        {
            return false;
        }
        obj1 = (fields)obj;
        if (!equalCachedHash(((Schema) (obj1))))
        {
            return false;
        }
        if (!equalNames(((equalNames) (obj1))))
        {
            return false;
        }
        if (!props.props(((props) (obj1)).props))
        {
            return false;
        }
        obj1 = (Set)Schema.access$800().get();
        fields1 = new t>(this, obj, null);
        if (((Set) (obj1)).contains(fields1)) goto _L1; else goto _L3
_L3:
        boolean flag2 = ((Set) (obj1)).isEmpty();
        boolean flag1;
        ((Set) (obj1)).add(fields1);
        flag1 = fields.equals(((fields)obj).fields);
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

    void fieldsToJson(fields fields1, JsonGenerator jsongenerator)
        throws IOException
    {
        jsongenerator.writeStartArray();
        for (Iterator iterator = fields.iterator(); iterator.hasNext(); jsongenerator.writeEndObject())
        {
            fields fields2 = (riteEndObject)iterator.next();
            jsongenerator.writeStartObject();
            jsongenerator.writeStringField("name", fields2.riteStringField());
            jsongenerator.writeFieldName("type");
            fields2.riteFieldName().toJson(fields1, jsongenerator);
            if (fields2.riteFieldName() != null)
            {
                jsongenerator.writeStringField("doc", fields2.riteStringField());
            }
            if (fields2.Value() != null)
            {
                jsongenerator.writeFieldName("default");
                jsongenerator.writeTree(fields2.Value());
            }
            if (fields2.Value() != SCENDING)
            {
                jsongenerator.writeStringField("order", ccess._mth1200(fields2._mth1200()));
            }
            if (_mth1300(fields2) != null && _mth1300(fields2).size() != 0)
            {
                jsongenerator.writeFieldName("aliases");
                jsongenerator.writeStartArray();
                for (Iterator iterator1 = _mth1300(fields2).iterator(); iterator1.hasNext(); jsongenerator.writeString((String)iterator1.next())) { }
                jsongenerator.writeEndArray();
            }
            _mth1400(fields2)._mth1400(jsongenerator);
        }

        jsongenerator.writeEndArray();
    }

    public riteEndArray getField(String s)
    {
        if (fieldMap == null)
        {
            throw new AvroRuntimeException("Schema fields not set yet");
        } else
        {
            return ()fieldMap.get(s);
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
        List list1 = new List();
        for (list = list.iterator(); list.hasNext();)
        {
            List list2 = (List)list.next();
            if (_mth700(list2) != -1)
            {
                throw new AvroRuntimeException((new StringBuilder()).append("Field already used: ").append(list2).toString());
            }
            _mth702(list2, i);
            fieldMap.put(list2.fieldMap(), list2);
            list1.add(list2);
            i++;
        }

        fields = list1.lock();
        hashCode = 0x80000000;
    }

    void toJson(hashCode hashcode, JsonGenerator jsongenerator)
        throws IOException
    {
        if (writeNameRef(hashcode, jsongenerator))
        {
            return;
        }
        String s1 = _mth1100(hashcode);
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
        writeName(hashcode, jsongenerator);
        _mth1102(hashcode, _mth00(name));
        if (getDoc() != null)
        {
            jsongenerator.writeStringField("doc", getDoc());
        }
        jsongenerator.writeFieldName("fields");
        fieldsToJson(hashcode, jsongenerator);
        props.props(jsongenerator);
        aliasesToJson(jsongenerator);
        jsongenerator.writeEndObject();
        _mth1102(hashcode, s1);
    }

    public List(List list, String s, boolean flag)
    {
        super(init>, list, s);
        isError = flag;
    }
}

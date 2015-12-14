// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.james.mime4j.message;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.apache.james.mime4j.parser.Field;

public class Header
    implements Iterable
{

    private Map fieldMap;
    private List fields;

    public Header()
    {
        fields = new LinkedList();
        fieldMap = new HashMap();
    }

    public void addField(Field field)
    {
        List list = (List)fieldMap.get(field.getName().toLowerCase());
        Object obj = list;
        if (list == null)
        {
            obj = new LinkedList();
            fieldMap.put(field.getName().toLowerCase(), obj);
        }
        ((List) (obj)).add(field);
        fields.add(field);
    }

    public Field getField(String s)
    {
        s = (List)fieldMap.get(s.toLowerCase());
        if (s != null && !s.isEmpty())
        {
            return (Field)s.get(0);
        } else
        {
            return null;
        }
    }

    public List getFields()
    {
        return Collections.unmodifiableList(fields);
    }

    public Iterator iterator()
    {
        return Collections.unmodifiableList(fields).iterator();
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder(128);
        for (Iterator iterator1 = fields.iterator(); iterator1.hasNext(); stringbuilder.append("\r\n"))
        {
            stringbuilder.append(((Field)iterator1.next()).toString());
        }

        return stringbuilder.toString();
    }
}

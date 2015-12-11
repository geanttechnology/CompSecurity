// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mcc.record;

import com.amazon.mcc.nps.Message;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.amazon.mcc.record:
//            PropertyMap, RecordableContext, Recordable

public class RecordableMessage extends Message
    implements PropertyMap
{

    private final RecordableContext context;
    private final Recordable recordable;

    public RecordableMessage(Recordable recordable1, RecordableContext recordablecontext)
    {
        recordable = recordable1;
        context = recordablecontext;
    }

    public boolean containsKey(Object obj)
    {
        return context.getProperties().containsKey(obj) || recordable.getProperties().containsKey(obj);
    }

    public Object get(Object obj)
    {
        if (recordable.getProperties().containsKey(obj))
        {
            return recordable.getProperties().get(obj);
        } else
        {
            return context.getProperties().get(obj);
        }
    }

    public Object getAsClass(Class class1, String s)
    {
        Object obj = get(s);
        if (obj == null)
        {
            s = null;
        } else
        {
            s = ((String) (obj));
            if (!class1.isInstance(obj))
            {
                return null;
            }
        }
        return s;
    }

    public Set keySet()
    {
        HashSet hashset = new HashSet(context.getProperties().keySet());
        hashset.addAll(recordable.getProperties().keySet());
        return hashset;
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("PropertyMap:{ ");
        Iterator iterator = keySet().iterator();
        while (iterator.hasNext()) 
        {
            String s = (String)iterator.next();
            stringbuilder.append(s);
            stringbuilder.append(":");
            if (get(s) == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(get(s).toString());
            }
            stringbuilder.append(" ");
        }
        stringbuilder.append("};");
        return stringbuilder.toString();
    }
}

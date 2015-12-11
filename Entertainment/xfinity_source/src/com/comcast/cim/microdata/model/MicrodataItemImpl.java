// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.microdata.model;

import com.comcast.cim.microdata.deserialization.MicrodataModelFactory;
import com.comcast.cim.microdata.util.SimpleToStringBuilder;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.comcast.cim.microdata.model:
//            MicrodataItem, MicrodataForm, MicrodataLink, MicrodataProperty, 
//            MicrodataPropertyImpl, MicrodataContext, MissingMicrodataProperty

public class MicrodataItemImpl
    implements MicrodataItem
{

    private MicrodataContext context;
    private Map forms;
    private String id;
    private Map links;
    private Map properties;
    private Set requiredProps;
    private String type;

    public MicrodataItemImpl(String s)
    {
        type = s;
        properties = new LinkedHashMap();
        links = new LinkedHashMap();
        forms = new LinkedHashMap();
        requiredProps = new HashSet();
    }

    public void addForms(List list)
    {
        MicrodataForm microdataform;
        for (list = list.iterator(); list.hasNext(); forms.put(microdataform.getId(), microdataform))
        {
            microdataform = (MicrodataForm)list.next();
        }

    }

    public void addLink(MicrodataLink microdatalink)
    {
        links.put(microdatalink.getRelation(), microdatalink);
    }

    public void addLinks(List list)
    {
        for (list = list.iterator(); list.hasNext(); addLink((MicrodataLink)list.next())) { }
    }

    public void addProperties(List list)
    {
        for (list = list.iterator(); list.hasNext(); addProperty((MicrodataProperty)list.next())) { }
    }

    public void addProperty(MicrodataProperty microdataproperty)
    {
        MicrodataPropertyImpl microdatapropertyimpl = (MicrodataPropertyImpl)getProperty(microdataproperty.getName());
        if (microdatapropertyimpl == null)
        {
            properties.put(microdataproperty.getName(), microdataproperty);
            return;
        } else
        {
            microdatapropertyimpl.addValues(microdataproperty.getValues());
            return;
        }
    }

    public MicrodataProperty get(String s)
    {
        if (properties.containsKey(s))
        {
            return (MicrodataProperty)properties.get(s);
        }
        if (forms.containsKey(s))
        {
            MicrodataProperty microdataproperty = context.getModelFactory().createMicrodataProperty(s, forms.get(s), true);
            properties.put(s, microdataproperty);
            return microdataproperty;
        }
        if (links.containsKey(s))
        {
            MicrodataProperty microdataproperty1 = context.getModelFactory().createMicrodataProperty(s, links.get(s), true);
            properties.put(s, microdataproperty1);
            return microdataproperty1;
        } else
        {
            MissingMicrodataProperty missingmicrodataproperty = new MissingMicrodataProperty(s);
            properties.put(s, missingmicrodataproperty);
            return missingmicrodataproperty;
        }
    }

    public MicrodataProperty get(String s, boolean flag)
    {
        return get(s);
    }

    public Map getForms()
    {
        return Collections.unmodifiableMap(forms);
    }

    public String getId()
    {
        return id;
    }

    public Map getLinks()
    {
        return Collections.unmodifiableMap(links);
    }

    public Map getProperties()
    {
        return Collections.unmodifiableMap(properties);
    }

    public MicrodataProperty getProperty(String s)
    {
        return (MicrodataProperty)properties.get(s);
    }

    public Set getRequiredProps()
    {
        return requiredProps;
    }

    public String getType()
    {
        return type;
    }

    public boolean isCanonical()
    {
        return true;
    }

    public void setContext(MicrodataContext microdatacontext)
    {
        context = microdatacontext;
    }

    public void setId(String s)
    {
        id = s;
    }

    public String toString()
    {
        SimpleToStringBuilder simpletostringbuilder = new SimpleToStringBuilder(this);
        simpletostringbuilder.append("type", type);
        simpletostringbuilder.append("id", id);
        simpletostringbuilder.append("links", links);
        simpletostringbuilder.append("forms", forms);
        simpletostringbuilder.append("properties", properties);
        return simpletostringbuilder.toString();
    }
}

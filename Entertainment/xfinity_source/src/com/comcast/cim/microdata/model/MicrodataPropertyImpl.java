// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.microdata.model;

import com.comcast.cim.microdata.deserialization.MicrodataModelFactory;
import com.comcast.cim.microdata.http.HttpMethod;
import com.comcast.cim.microdata.util.SimpleToStringBuilder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.comcast.cim.microdata.model:
//            MicrodataProperty, MicrodataFormValue, MicrodataFormField, MicrodataContext, 
//            MicrodataItem, MicrodataLinkValue, MicrodataLink, MicrodataForm

public class MicrodataPropertyImpl
    implements MicrodataProperty
{

    private boolean collection;
    private MicrodataContext context;
    private boolean embedded;
    private String name;
    private List values;

    public MicrodataPropertyImpl(String s)
    {
        name = s;
        values = new ArrayList();
    }

    public MicrodataPropertyImpl(String s, Object obj, boolean flag)
    {
        this(s);
        embedded = flag;
        if (obj == null)
        {
            collection = false;
            return;
        }
        if (obj instanceof List)
        {
            addValues((List)obj);
            collection = true;
            return;
        } else
        {
            addValue(obj);
            collection = false;
            return;
        }
    }

    private Object asType(Class class1)
    {
        Object obj = getValue();
        if (class1.isInstance(obj))
        {
            return class1.cast(obj);
        } else
        {
            throw new ClassCastException((new StringBuilder()).append("Property ").append(name).append(" value is not a ").append(class1.getSimpleName()).append(". Is ").append(obj.getClass()).append(" instead.").toString());
        }
    }

    private Object asType(Class class1, Object obj)
    {
        Object obj1;
        for (obj1 = getValue(); obj1 == null || !class1.isInstance(obj1);)
        {
            return obj;
        }

        return class1.cast(obj1);
    }

    private List asTypeList(Class class1)
    {
        Object obj = getValues();
        ArrayList arraylist = new ArrayList(((List) (obj)).size());
        if (!((List) (obj)).isEmpty())
        {
            if (class1.isInstance(((List) (obj)).get(0)))
            {
                obj = ((List) (obj)).iterator();
                while (((Iterator) (obj)).hasNext()) 
                {
                    arraylist.add(class1.cast(((Iterator) (obj)).next()));
                }
            } else
            {
                throw new ClassCastException((new StringBuilder()).append("Property ").append(name).append(" value is not a ").append(class1.getSimpleName()).append(". Is ").append(((List) (obj)).get(0).getClass()).append(" instead.").toString());
            }
        }
        return arraylist;
    }

    private MicrodataLinkValue convertFormToLink(MicrodataFormValue microdataformvalue)
    {
        if (microdataformvalue.getMethod() != HttpMethod.GET)
        {
            throw new ClassCastException("Cannot convert from non-GET form to Link.");
        }
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(microdataformvalue.getAction());
        boolean flag = false;
        List list = microdataformvalue.getFields();
        if (!list.isEmpty())
        {
            flag = true;
            stringbuilder.append("{?");
            for (int i = 0; i < list.size(); i++)
            {
                stringbuilder.append(((MicrodataFormField)list.get(i)).getName());
                if (i < list.size() - 1)
                {
                    stringbuilder.append(",");
                }
            }

            stringbuilder.append("}");
        }
        return getContext().getModelFactory().createMicrodataLinkValue(stringbuilder.toString(), null, microdataformvalue.getTitle(), flag, null);
    }

    private MicrodataLink convertItemToLink()
    {
        if (!(getValue() instanceof MicrodataItem))
        {
            throw new ClassCastException((new StringBuilder()).append("Property ").append(name).append(" is not an instance of ").append(com/comcast/cim/microdata/model/MicrodataItem).toString());
        }
        ArrayList arraylist = new ArrayList();
        for (Iterator iterator = getValues().iterator(); iterator.hasNext(); arraylist.add(convertItemToLinkValue((MicrodataItem)iterator.next()))) { }
        return context.getModelFactory().createMicrodataLink(name, arraylist);
    }

    private MicrodataLinkValue convertItemToLinkValue(MicrodataItem microdataitem)
    {
        microdataitem = microdataitem.get("self").asLink();
        return context.getModelFactory().createMicrodataLinkValue(microdataitem.getHref(), microdataitem.getName(), microdataitem.getTitle(), microdataitem.isTemplated(), microdataitem.getContentType());
    }

    private MicrodataItem convertLinkToItem(MicrodataLinkValue microdatalinkvalue)
    {
        Object obj;
        if (isFragmentUri(microdatalinkvalue))
        {
            MicrodataItem microdataitem = (MicrodataItem)context.getItemMap().get(getFragmentTarget(microdatalinkvalue));
            obj = microdataitem;
            if (microdataitem == null)
            {
                throw new IllegalStateException((new StringBuilder()).append("Fragment link ").append(microdatalinkvalue.getHref()).append(" did not resolve to item in the document.").toString());
            }
        } else
        {
            obj = getContext().getModelFactory();
            microdatalinkvalue = ((MicrodataModelFactory) (obj)).createMicrodataLink("self", microdatalinkvalue);
            ArrayList arraylist = new ArrayList();
            arraylist.add(microdatalinkvalue);
            obj = ((MicrodataModelFactory) (obj)).createMicrodataItem(null, null, arraylist, new ArrayList(), new ArrayList());
        }
        return ((MicrodataItem) (obj));
    }

    private List convertLinkToItems(MicrodataLink microdatalink)
    {
        ArrayList arraylist = new ArrayList(microdatalink.getValues().size());
        for (microdatalink = microdatalink.getValues().iterator(); microdatalink.hasNext(); arraylist.add(convertLinkToItem((MicrodataLinkValue)microdatalink.next()))) { }
        return Collections.unmodifiableList(arraylist);
    }

    private String getFragmentTarget(MicrodataLinkValue microdatalinkvalue)
    {
        return microdatalinkvalue.getHref().substring(1);
    }

    private boolean isFragmentUri(MicrodataLinkValue microdatalinkvalue)
    {
        return microdatalinkvalue.getHref().startsWith("#");
    }

    public void addValue(Object obj)
    {
        values.add(obj);
        if (values.size() > 1)
        {
            collection = true;
        }
    }

    public void addValues(Collection collection1)
    {
        values.addAll(collection1);
        collection = true;
    }

    public Boolean asBoolean()
    {
        return (Boolean)asType(java/lang/Boolean);
    }

    public Boolean asBoolean(Boolean boolean1)
    {
        return (Boolean)asType(java/lang/Boolean, boolean1);
    }

    public Integer asInt()
    {
        return (Integer)asType(java/lang/Integer);
    }

    public Integer asInt(Integer integer)
    {
        return (Integer)asType(java/lang/Integer, integer);
    }

    public MicrodataItem asItem()
    {
        Object obj = getValue();
        if (obj instanceof MicrodataLink)
        {
            return convertLinkToItem(((MicrodataLink)obj).getValue());
        } else
        {
            return (MicrodataItem)asType(com/comcast/cim/microdata/model/MicrodataItem);
        }
    }

    public List asItems()
    {
        if (getValue() instanceof MicrodataLink)
        {
            return convertLinkToItems((MicrodataLink)getValue());
        } else
        {
            return asTypeList(com/comcast/cim/microdata/model/MicrodataItem);
        }
    }

    public MicrodataLinkValue asLink()
    {
        if (getValue() instanceof MicrodataItem)
        {
            return convertItemToLink().getValue();
        }
        if (getValue() instanceof MicrodataForm)
        {
            return convertFormToLink(((MicrodataForm)getValue()).getValue());
        } else
        {
            return ((MicrodataLink)asType(com/comcast/cim/microdata/model/MicrodataLink)).getValue();
        }
    }

    public List asList()
    {
        return Collections.unmodifiableList(values);
    }

    public List asList(List list)
    {
        if (values != null)
        {
            list = Collections.unmodifiableList(values);
        }
        return list;
    }

    public String asString()
    {
        return String.valueOf(getValue());
    }

    public String asString(String s)
    {
        if (getValue() == null)
        {
            return s;
        } else
        {
            return String.valueOf(getValue());
        }
    }

    public MicrodataContext getContext()
    {
        return context;
    }

    public String getName()
    {
        return name;
    }

    public Object getValue()
    {
        if (values.size() > 0)
        {
            return values.get(0);
        } else
        {
            return null;
        }
    }

    public List getValues()
    {
        return Collections.unmodifiableList(values);
    }

    public boolean isCollection()
    {
        return collection;
    }

    public boolean isEmbedded()
    {
        return embedded;
    }

    public boolean isMissing()
    {
        return false;
    }

    public void setCollection(boolean flag)
    {
        collection = flag;
    }

    public void setContext(MicrodataContext microdatacontext)
    {
        context = microdatacontext;
    }

    public void setEmbedded(boolean flag)
    {
        embedded = flag;
    }

    public String toString()
    {
        SimpleToStringBuilder simpletostringbuilder = new SimpleToStringBuilder(this);
        simpletostringbuilder.append("name", name);
        simpletostringbuilder.append("embedded", embedded);
        simpletostringbuilder.append("collection", collection);
        simpletostringbuilder.append("values", values);
        return simpletostringbuilder.toString();
    }
}

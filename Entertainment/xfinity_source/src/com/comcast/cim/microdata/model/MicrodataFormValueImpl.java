// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.microdata.model;

import com.comcast.cim.microdata.http.HttpMethod;
import com.comcast.cim.microdata.util.MicrodataCollectionUtils;
import com.comcast.cim.microdata.util.SimpleToStringBuilder;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.comcast.cim.microdata.model:
//            MicrodataFormValue, MicrodataFormField, MicrodataContext

public class MicrodataFormValueImpl
    implements MicrodataFormValue
{

    private static final Map EMPTY_MAP = Collections.unmodifiableMap(new HashMap());
    private final String action;
    private MicrodataContext context;
    private final Map fieldMap;
    private final List fields;
    private final HttpMethod method;
    private final String title;

    public MicrodataFormValueImpl(String s, String s1, HttpMethod httpmethod, List list)
    {
        title = s;
        action = s1;
        method = httpmethod;
        fields = MicrodataCollectionUtils.unmodifiableList(list);
        s = new HashMap();
        for (s1 = list.iterator(); s1.hasNext(); s.put(httpmethod.getName(), httpmethod))
        {
            httpmethod = (MicrodataFormField)s1.next();
        }

        fieldMap = Collections.unmodifiableMap(s);
    }

    public String getAction()
    {
        return action;
    }

    public List getFields()
    {
        return fields;
    }

    public HttpMethod getMethod()
    {
        return method;
    }

    public String getTitle()
    {
        return title;
    }

    public void setContext(MicrodataContext microdatacontext)
    {
        context = microdatacontext;
    }

    public String toString()
    {
        SimpleToStringBuilder simpletostringbuilder = new SimpleToStringBuilder(this);
        simpletostringbuilder.append("title", title);
        simpletostringbuilder.append("action", action);
        simpletostringbuilder.append("method", method);
        simpletostringbuilder.append("fields", fields);
        return simpletostringbuilder.toString();
    }

}

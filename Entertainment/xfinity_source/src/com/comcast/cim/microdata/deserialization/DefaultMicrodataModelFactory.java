// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.microdata.deserialization;

import com.comcast.cim.microdata.http.HttpMethod;
import com.comcast.cim.microdata.model.MicrodataContext;
import com.comcast.cim.microdata.model.MicrodataForm;
import com.comcast.cim.microdata.model.MicrodataFormImpl;
import com.comcast.cim.microdata.model.MicrodataFormValue;
import com.comcast.cim.microdata.model.MicrodataFormValueImpl;
import com.comcast.cim.microdata.model.MicrodataItem;
import com.comcast.cim.microdata.model.MicrodataItemImpl;
import com.comcast.cim.microdata.model.MicrodataLink;
import com.comcast.cim.microdata.model.MicrodataLinkImpl;
import com.comcast.cim.microdata.model.MicrodataLinkValue;
import com.comcast.cim.microdata.model.MicrodataLinkValueImpl;
import com.comcast.cim.microdata.model.MicrodataProperty;
import com.comcast.cim.microdata.model.MicrodataPropertyImpl;
import java.util.HashMap;
import java.util.List;

// Referenced classes of package com.comcast.cim.microdata.deserialization:
//            MicrodataModelFactory

public class DefaultMicrodataModelFactory
    implements MicrodataModelFactory
{

    protected MicrodataContext context;

    public DefaultMicrodataModelFactory()
    {
        context = new MicrodataContext(null, "", this, new HashMap());
    }

    public MicrodataForm createMicrodataForm(String s, MicrodataFormValue microdataformvalue)
    {
        return new MicrodataFormImpl(s, microdataformvalue);
    }

    public MicrodataForm createMicrodataForm(String s, List list)
    {
        return new MicrodataFormImpl(s, list);
    }

    public MicrodataFormValue createMicrodataFormValue(String s, String s1, HttpMethod httpmethod, List list)
    {
        s = new MicrodataFormValueImpl(s, s1, httpmethod, list);
        s.setContext(context);
        return s;
    }

    public MicrodataItem createMicrodataItem(String s, String s1, List list, List list1, List list2)
    {
        s = new MicrodataItemImpl(s);
        s.setId(s1);
        s.addProperties(list2);
        s.addLinks(list);
        s.addForms(list1);
        s.setContext(context);
        return s;
    }

    public MicrodataItem createMicrodataItem(String s, String s1, List list, List list1, List list2, boolean flag)
    {
        return createMicrodataItem(s, s1, list, list1, list2);
    }

    public MicrodataLink createMicrodataLink(String s, MicrodataLinkValue microdatalinkvalue)
    {
        return new MicrodataLinkImpl(s, microdatalinkvalue);
    }

    public MicrodataLink createMicrodataLink(String s, List list)
    {
        return new MicrodataLinkImpl(s, list);
    }

    public MicrodataLinkValue createMicrodataLinkValue(String s, String s1, String s2, boolean flag, String s3)
    {
        s = new MicrodataLinkValueImpl(s, s1, s2, flag, s3);
        s.setContext(context);
        return s;
    }

    public MicrodataProperty createMicrodataProperty(String s, Object obj, boolean flag)
    {
        s = new MicrodataPropertyImpl(s, obj, flag);
        s.setContext(context);
        return s;
    }

    public void setContext(MicrodataContext microdatacontext)
    {
        context = microdatacontext;
    }
}

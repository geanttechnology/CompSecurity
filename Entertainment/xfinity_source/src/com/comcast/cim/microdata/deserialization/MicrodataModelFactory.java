// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.microdata.deserialization;

import com.comcast.cim.microdata.http.HttpMethod;
import com.comcast.cim.microdata.model.MicrodataContext;
import com.comcast.cim.microdata.model.MicrodataForm;
import com.comcast.cim.microdata.model.MicrodataFormValue;
import com.comcast.cim.microdata.model.MicrodataItem;
import com.comcast.cim.microdata.model.MicrodataLink;
import com.comcast.cim.microdata.model.MicrodataLinkValue;
import com.comcast.cim.microdata.model.MicrodataProperty;
import java.util.List;

public interface MicrodataModelFactory
{

    public abstract MicrodataForm createMicrodataForm(String s, MicrodataFormValue microdataformvalue);

    public abstract MicrodataForm createMicrodataForm(String s, List list);

    public abstract MicrodataFormValue createMicrodataFormValue(String s, String s1, HttpMethod httpmethod, List list);

    public abstract MicrodataItem createMicrodataItem(String s, String s1, List list, List list1, List list2);

    public abstract MicrodataItem createMicrodataItem(String s, String s1, List list, List list1, List list2, boolean flag);

    public abstract MicrodataLink createMicrodataLink(String s, MicrodataLinkValue microdatalinkvalue);

    public abstract MicrodataLink createMicrodataLink(String s, List list);

    public abstract MicrodataLinkValue createMicrodataLinkValue(String s, String s1, String s2, boolean flag, String s3);

    public abstract MicrodataProperty createMicrodataProperty(String s, Object obj, boolean flag);

    public abstract void setContext(MicrodataContext microdatacontext);
}

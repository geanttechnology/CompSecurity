// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.springframework.http.converter.xml;

import org.springframework.http.converter.FormHttpMessageConverter;

// Referenced classes of package org.springframework.http.converter.xml:
//            SourceHttpMessageConverter

public class XmlAwareFormHttpMessageConverter extends FormHttpMessageConverter
{

    public XmlAwareFormHttpMessageConverter()
    {
        addPartConverter(new SourceHttpMessageConverter());
    }
}

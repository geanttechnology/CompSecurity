// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.internal;

import com.google.b.j;
import com.google.b.k;
import com.google.b.l;
import com.google.b.p;
import com.pointinside.internal.utils.StringUtils;
import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateDeserializer
    implements k
{

    public DateDeserializer()
    {
    }

    public volatile Object deserialize(l l1, Type type, j j)
        throws p
    {
        return deserialize(l1, type, j);
    }

    public Date deserialize(l l1, Type type, j j)
        throws p
    {
        type = l1.c();
        l1 = type;
        if (!type.contains("."))
        {
            l1 = (new StringBuilder()).append(type).append(".000Z").toString();
        }
        type = new SimpleDateFormat(StringUtils.DATE_FORMAT, Locale.US);
        try
        {
            l1 = type.parse(l1);
        }
        // Misplaced declaration of an exception variable
        catch (l l1)
        {
            return null;
        }
        return l1;
    }
}

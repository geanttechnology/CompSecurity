// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.microdata.deserialization;

import com.comcast.cim.microdata.exception.MicrodataConversionException;
import com.comcast.cim.microdata.model.MicrodataItem;
import java.io.InputStream;

public interface MicrodataDeserializer
{

    public abstract MicrodataItem convert(InputStream inputstream)
        throws MicrodataConversionException;
}

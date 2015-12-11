// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.codehaus.jackson.map.ext;

import com.flurry.org.codehaus.jackson.map.DeserializationContext;
import org.w3c.dom.Document;

// Referenced classes of package com.flurry.org.codehaus.jackson.map.ext:
//            DOMDeserializer

public static class  extends DOMDeserializer
{

    public volatile Object _deserialize(String s, DeserializationContext deserializationcontext)
    {
        return _deserialize(s, deserializationcontext);
    }

    public Document _deserialize(String s, DeserializationContext deserializationcontext)
        throws IllegalArgumentException
    {
        return parse(s);
    }

    public ()
    {
        super(org/w3c/dom/Document);
    }
}

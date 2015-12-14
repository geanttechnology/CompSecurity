// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.extended.model.serializer;

import com.amazon.clouddrive.extended.model.SubscriptionProblem;
import com.amazon.clouddrive.model.serializer.JsonSerializer;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import org.codehaus.jackson.JsonGenerator;

// Referenced classes of package com.amazon.clouddrive.extended.model.serializer:
//            SubscriptionProblemSerializer

public class SubscriptionProblemListSerializer
    implements JsonSerializer
{

    public static final JsonSerializer INSTANCE = new SubscriptionProblemListSerializer();

    private SubscriptionProblemListSerializer()
    {
    }

    public volatile void serialize(Object obj, JsonGenerator jsongenerator)
        throws IOException
    {
        serialize((List)obj, jsongenerator);
    }

    public void serialize(List list, JsonGenerator jsongenerator)
        throws IOException
    {
        if (list == null)
        {
            jsongenerator.writeNull();
            return;
        }
        jsongenerator.writeStartArray();
        SubscriptionProblem subscriptionproblem;
        for (list = list.iterator(); list.hasNext(); SubscriptionProblemSerializer.INSTANCE.serialize(subscriptionproblem, jsongenerator))
        {
            subscriptionproblem = (SubscriptionProblem)list.next();
        }

        jsongenerator.writeEndArray();
    }

}

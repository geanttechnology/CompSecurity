// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.c.v;

import com.shazam.b.a.a;
import com.shazam.model.audio.Messages;
import com.shazam.model.audio.Mood;
import com.shazam.model.audio.Watermark;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class b
    implements a
{

    public b()
    {
    }

    public final Object a(Object obj)
    {
        obj = (Watermark)obj;
        if (obj == null)
        {
            return null;
        }
        Object obj1 = ((Watermark) (obj)).mood.messages;
        ArrayList arraylist = new ArrayList();
        Messages messages;
        for (obj1 = ((List) (obj1)).iterator(); ((Iterator) (obj1)).hasNext(); arraylist.add(com.shazam.server.request.recognition.Message.Builder.message().withId(messages.id).withType(messages.type).build()))
        {
            messages = (Messages)((Iterator) (obj1)).next();
        }

        return com.shazam.server.request.recognition.Watermark.Builder.watermark().withMood(com.shazam.server.request.recognition.Mood.Builder.mood().withSdkVersion(((Watermark) (obj)).mood.sdkVersion).withMessages(arraylist).build()).build();
    }
}

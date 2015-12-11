// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.ah;

import com.shazam.model.audio.Watermark;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

// Referenced classes of package com.shazam.android.ah:
//            c

public final class a
    implements c
{

    private final Set a = new HashSet();

    public a()
    {
    }

    public final Watermark a()
    {
        ArrayList arraylist = new ArrayList(a);
        com.shazam.model.audio.Watermark.Builder builder = com.shazam.model.audio.Watermark.Builder.a();
        com.shazam.model.audio.Mood.Builder builder1 = com.shazam.model.audio.Mood.Builder.a();
        builder1.messages = arraylist;
        builder.mood = builder1.b();
        return builder.b();
    }

    public final void a(long l, com.moodmedia.moodpresence.MoodPresenceResult.Type type)
    {
        Set set = a;
        com.shazam.model.audio.Messages.Builder builder = com.shazam.model.audio.Messages.Builder.a();
        builder.id = String.valueOf(l);
        builder.type = String.valueOf(type.getValue());
        set.add(builder.b());
    }

    public final void b()
    {
        a.clear();
    }
}

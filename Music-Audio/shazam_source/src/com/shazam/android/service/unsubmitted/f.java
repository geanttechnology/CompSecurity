// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.service.unsubmitted;

import com.shazam.model.Tag;

// Referenced classes of package com.shazam.android.service.unsubmitted:
//            g

public final class f
    implements g
{

    public f()
    {
    }

    public final void a(Tag tag, Tag tag1)
    {
        tag1.status = com.shazam.model.Tag.Status.SUCCESSFUL;
        tag1.unread = true;
        tag1.location = tag.location;
    }
}

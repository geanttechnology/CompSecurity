// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.share.internal;

import com.facebook.share.model.SharePhoto;
import java.util.UUID;

// Referenced classes of package com.facebook.share.internal:
//            h

static final class a
    implements android.support.v7.
{

    final UUID a;

    public android.support.v7. a(SharePhoto sharephoto)
    {
        return h.a(a, sharephoto);
    }

    public volatile Object a(Object obj)
    {
        return a((SharePhoto)obj);
    }

    oto(UUID uuid)
    {
        a = uuid;
        super();
    }
}

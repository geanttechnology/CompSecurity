// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.database.more.makeup;

import java.net.URI;
import org.json.JSONObject;

// Referenced classes of package com.cyberlink.youcammakeup.database.more.makeup:
//            MakeupItemMetadata

public class f
{

    final MakeupItemMetadata a;
    private String b;
    private URI c;
    private int d;
    private int e;
    private String f;

    public f(MakeupItemMetadata makeupitemmetadata, JSONObject jsonobject)
    {
        a = makeupitemmetadata;
        super();
        b = jsonobject.getString("guid");
        c = URI.create(jsonobject.getString("thumbnailURL"));
        d = jsonobject.getInt("thumbnailSizeW");
        e = jsonobject.getInt("thumbnailSizeH");
        f = jsonobject.getString("type");
    }

    public URI a()
    {
        return c;
    }

    public int b()
    {
        return d;
    }

    public int c()
    {
        return e;
    }
}

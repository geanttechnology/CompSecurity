// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.android.exoplayer.drm;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

// Referenced classes of package shared_presage.com.google.android.exoplayer.drm:
//            DrmInitData

public static final class  extends DrmInitData
{

    private final Map schemeData = new HashMap();

    public final byte[] get(UUID uuid)
    {
        return (byte[])schemeData.get(uuid);
    }

    public final void put(UUID uuid, byte abyte0[])
    {
        schemeData.put(uuid, abyte0);
    }

    public (String s)
    {
        super(s);
    }
}

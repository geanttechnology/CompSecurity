// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.android.exoplayer.dash.mpd;

import java.util.Arrays;
import java.util.UUID;
import shared_presage.com.google.android.exoplayer.util.Assertions;
import shared_presage.com.google.android.exoplayer.util.Util;

public class ContentProtection
{

    public final byte data[];
    public final String schemeUriId;
    public final UUID uuid;

    public ContentProtection(String s, UUID uuid1, byte abyte0[])
    {
        schemeUriId = (String)Assertions.checkNotNull(s);
        uuid = uuid1;
        data = abyte0;
    }

    public boolean equals(Object obj)
    {
        if (obj instanceof ContentProtection)
        {
            if (obj == this)
            {
                return true;
            }
            obj = (ContentProtection)obj;
            if (schemeUriId.equals(((ContentProtection) (obj)).schemeUriId) && Util.areEqual(uuid, ((ContentProtection) (obj)).uuid) && Arrays.equals(data, ((ContentProtection) (obj)).data))
            {
                return true;
            }
        }
        return false;
    }

    public int hashCode()
    {
        int j = schemeUriId.hashCode() + 37;
        int i = j;
        if (uuid != null)
        {
            i = j * 37 + uuid.hashCode();
        }
        j = i;
        if (data != null)
        {
            j = i * 37 + Arrays.hashCode(data);
        }
        return j;
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.Uri;
import com.google.android.gms.common.data.DataHolder;
import java.util.HashMap;
import java.util.Map;

public final class aws extends rl
    implements atx
{

    private final int c;

    public aws(DataHolder dataholder, int i, int j)
    {
        super(dataholder, i);
        c = j;
    }

    public Object a()
    {
        return e();
    }

    public Uri b()
    {
        return Uri.parse(b("path"));
    }

    public byte[] c()
    {
        return c("data");
    }

    public Map d()
    {
        HashMap hashmap = new HashMap(c);
        int i = 0;
        while (i < c) 
        {
            awp awp1 = new awp(a, b + i);
            if (awp1.c() != null)
            {
                hashmap.put(awp1.c(), awp1);
            }
            i++;
        }
        return hashmap;
    }

    public atx e()
    {
        return new awq(this);
    }
}

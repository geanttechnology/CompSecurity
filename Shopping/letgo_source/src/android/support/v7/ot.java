// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import com.google.android.gms.ads.internal.util.client.zzb;
import java.util.Map;

// Referenced classes of package android.support.v7:
//            ox, ou, ul

public final class ot
    implements ox
{

    private final ou a;

    public ot(ou ou1)
    {
        a = ou1;
    }

    public void zza(ul ul, Map map)
    {
        ul = (String)map.get("name");
        if (ul == null)
        {
            zzb.zzaE("App event with no name parameter.");
            return;
        } else
        {
            a.onAppEvent(ul, (String)map.get("info"));
            return;
        }
    }
}

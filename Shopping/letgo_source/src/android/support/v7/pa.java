// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.util.Map;

// Referenced classes of package android.support.v7:
//            ox, pb, ul

public class pa
    implements ox
{

    private final pb a;

    public pa(pb pb1)
    {
        a = pb1;
    }

    public void zza(ul ul, Map map)
    {
        boolean flag = "1".equals(map.get("transparentBackground"));
        a.zzd(flag);
    }
}

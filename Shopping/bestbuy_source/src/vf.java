// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.google.android.gms.internal.gu;
import java.util.Map;

public class vf
    implements vd
{

    private final vg a;

    public vf(vg vg1)
    {
        a = vg1;
    }

    public void a(gu gu, Map map)
    {
        boolean flag = "1".equals(map.get("transparentBackground"));
        a.a(flag);
    }
}

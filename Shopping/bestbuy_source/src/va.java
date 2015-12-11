// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.google.android.gms.internal.gu;
import java.util.Map;

public final class va
    implements vd
{

    private final vb a;

    public va(vb vb1)
    {
        a = vb1;
    }

    public void a(gu gu, Map map)
    {
        gu = (String)map.get("name");
        if (gu == null)
        {
            acb.e("App event with no name parameter.");
            return;
        } else
        {
            a.a(gu, (String)map.get("info"));
            return;
        }
    }
}

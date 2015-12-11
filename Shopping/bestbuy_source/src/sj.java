// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.google.android.gms.internal.gu;
import java.util.HashMap;
import java.util.Map;

class sj
    implements sm
{

    private gu a;

    public sj(gu gu1)
    {
        a = gu1;
    }

    public void a(sp sp, boolean flag)
    {
        HashMap hashmap = new HashMap();
        if (flag)
        {
            sp = "1";
        } else
        {
            sp = "0";
        }
        hashmap.put("isVisible", sp);
        a.a("onAdVisibilityChanged", hashmap);
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package a.a;

import org.json.JSONObject;

// Referenced classes of package a.a:
//            dr, ay

public class du
    implements dr
{

    private ay a;
    private ay b;

    public du(ay ay1, ay ay2)
    {
        a = ay1;
        b = ay2;
    }

    public void a(boolean flag, int i, JSONObject jsonobject)
    {
        if (flag || i >= 200 && i < 300)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        if (i != 0)
        {
            a.a();
            return;
        } else
        {
            a.a(b);
            return;
        }
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package u.aly;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package u.aly:
//            u, s, aa

public class l
{

    private final String a = "umeng_event_snapshot";
    private boolean b;
    private SharedPreferences c;
    private Map d;

    public l(Context context)
    {
        b = false;
        d = new HashMap();
        c = u.a(context, "umeng_event_snapshot");
    }

    private void c(String s1)
    {
        Object obj = null;
        if (!d.containsKey(s1)) goto _L2; else goto _L1
_L1:
        obj = (ArrayList)d.get(s1);
_L6:
        if (((ArrayList) (obj)).size() > 4) goto _L4; else goto _L3
_L3:
        obj = s.a(((java.io.Serializable) (obj)));
_L2:
        c.edit().putString(s1, ((String) (obj))).commit();
        return;
_L4:
        ((ArrayList) (obj)).remove(0);
        if (true) goto _L6; else goto _L5
_L5:
    }

    private boolean d(String s1)
    {
        if (d.containsKey(s1))
        {
            return true;
        }
        Object obj = c.getString(s1, null);
        if (obj != null)
        {
            obj = (ArrayList)s.a(((String) (obj)));
            if (obj != null)
            {
                d.put(s1, obj);
                return true;
            }
        }
        return false;
    }

    public int a(String s1)
    {
        if (d.containsKey(s1))
        {
            return ((ArrayList)d.get(s1)).size();
        } else
        {
            return 0;
        }
    }

    public void a(String s1, aa aa1)
    {
        if (b)
        {
            d(s1);
        }
        if (d.containsKey(s1))
        {
            ((ArrayList)d.get(s1)).add(aa1);
        } else
        {
            ArrayList arraylist = new ArrayList();
            arraylist.add(aa1);
            d.put(s1, arraylist);
        }
        if (b)
        {
            c(s1);
        }
    }

    public void a(boolean flag)
    {
        b = flag;
    }

    public aa b(String s1)
    {
        if (b)
        {
            d(s1);
        }
        if (!d.containsKey(s1)) goto _L2; else goto _L1
_L1:
        Object obj = (ArrayList)d.get(s1);
        if (((ArrayList) (obj)).size() <= 0) goto _L2; else goto _L3
_L3:
        obj = (aa)((ArrayList) (obj)).remove(((ArrayList) (obj)).size() - 1);
_L5:
        if (b)
        {
            c(s1);
        }
        return ((aa) (obj));
_L2:
        obj = null;
        if (true) goto _L5; else goto _L4
_L4:
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a.a;

import android.os.Message;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

// Referenced classes of package com.a.a.a:
//            f

public class i extends f
{

    protected static final int a = 100;

    public i()
    {
    }

    public void a(int j, JSONArray jsonarray)
    {
        a(jsonarray);
    }

    public void a(int j, JSONObject jsonobject)
    {
        a(jsonobject);
    }

    protected void a(Message message)
    {
        switch (message.what)
        {
        default:
            super.a(message);
            return;

        case 100: // 'd'
            message = ((Message) ((Object[])message.obj));
            break;
        }
        b(((Integer)message[0]).intValue(), message[1]);
    }

    public void a(Throwable throwable, JSONArray jsonarray)
    {
    }

    public void a(Throwable throwable, JSONObject jsonobject)
    {
    }

    public void a(JSONArray jsonarray)
    {
    }

    public void a(JSONObject jsonobject)
    {
    }

    protected Object b(String s)
    {
        String s1;
label0:
        {
            Object obj = null;
            s1 = s.trim();
            if (!s1.startsWith("{"))
            {
                s = obj;
                if (!s1.startsWith("["))
                {
                    break label0;
                }
            }
            s = ((String) ((new JSONTokener(s1)).nextValue()));
        }
        if (s == null)
        {
            return s1;
        } else
        {
            return s;
        }
    }

    protected void b(int j, Object obj)
    {
        if (obj instanceof JSONObject)
        {
            a(j, (JSONObject)obj);
            return;
        }
        if (obj instanceof JSONArray)
        {
            a(j, (JSONArray)obj);
            return;
        } else
        {
            a(new JSONException((new StringBuilder("Unexpected type ")).append(obj.getClass().getName()).toString()), ((JSONObject) (null)));
            return;
        }
    }

    protected void b(int j, String s)
    {
        if (j != 204)
        {
            try
            {
                b(a(100, ((Object) (new Object[] {
                    Integer.valueOf(j), b(s)
                }))));
                return;
            }
            catch (JSONException jsonexception)
            {
                b(((Throwable) (jsonexception)), s);
            }
            return;
        } else
        {
            b(a(100, ((Object) (new Object[] {
                Integer.valueOf(j), new JSONObject()
            }))));
            return;
        }
    }

    protected void c(Throwable throwable, String s)
    {
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_59;
        }
        Object obj;
        try
        {
            obj = b(s);
            if (obj instanceof JSONObject)
            {
                a(throwable, (JSONObject)obj);
                return;
            }
        }
        catch (JSONException jsonexception)
        {
            a(throwable, s);
            return;
        }
        if (obj instanceof JSONArray)
        {
            a(throwable, (JSONArray)obj);
            return;
        }
        a(throwable, s);
        return;
        a(throwable, "");
        return;
    }
}

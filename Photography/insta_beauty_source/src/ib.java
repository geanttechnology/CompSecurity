// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class ib
{

    private static ib a = null;
    private Context b;
    private JSONObject c;

    private ib(Context context)
    {
        b = null;
        c = null;
        b = context;
        if (b() != null)
        {
            try
            {
                c = new JSONObject(b());
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                context.printStackTrace();
                c = new JSONObject();
            }
            a();
            return;
        } else
        {
            c = new JSONObject();
            return;
        }
    }

    public static ib a(Context context)
    {
        if (a == null)
        {
            a = new ib(context);
        }
        return a;
    }

    private void a()
    {
        if (c != null && c.length() > 0)
        {
            ArrayList arraylist = new ArrayList();
            Iterator iterator = c.keys();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                String s1 = (String)iterator.next();
                try
                {
                    Object obj = c.getJSONObject(s1);
                    long l = ((JSONObject) (obj)).getLong("time");
                    if (((new Date()).getTime() - l) / 1000L > 0x278d00L)
                    {
                        obj = ((JSONObject) (obj)).getString("name");
                        Log.i("FotoAlertFactory", (new StringBuilder()).append("cache file out time : ").append(((String) (obj))).toString());
                        b(((String) (obj)));
                        arraylist.add(s1);
                    }
                }
                catch (JSONException jsonexception)
                {
                    jsonexception.printStackTrace();
                }
            } while (true);
            if (arraylist.size() > 0)
            {
                for (int i = 0; i < arraylist.size(); i++)
                {
                    String s = (String)arraylist.get(i);
                    c.remove(s);
                }

            }
        }
    }

    private String b()
    {
        return b.getSharedPreferences("FotoAlertImagePathCache", 0).getString("FotoAlertCacheData", null);
    }

    private void b(String s)
    {
        s = new File(s);
        if (s.exists() && s.isFile())
        {
            s.delete();
        }
    }

    private boolean c(String s)
    {
        if (s != null && s.length() > 0)
        {
            if ((s = new File(s)).exists() && s.isFile())
            {
                return true;
            }
        }
        return false;
    }

    private void d(String s)
    {
        b.getSharedPreferences("FotoAlertImagePathCache", 0).edit().putString("FotoAlertCacheData", s).apply();
    }

    public void a(String s)
    {
        Log.i("FotoAlertFactory", (new StringBuilder()).append("cache file : ").append(s).toString());
        if (s == null || s.length() <= 0 || !c(s))
        {
            return;
        }
        try
        {
            JSONObject jsonobject = new JSONObject();
            jsonobject.put("name", s);
            jsonobject.put("time", (new Date()).getTime());
            s = yn.a(s);
            c.put(s, jsonobject);
            d(c.toString());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
        }
    }

}

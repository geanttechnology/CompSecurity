// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j.a.g;

import android.content.Context;
import android.os.AsyncTask;
import com.j.a.d.e;
import com.newrelic.agent.android.instrumentation.AsyncTaskInstrumentation;
import com.newrelic.agent.android.instrumentation.JSONArrayInstrumentation;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.j.a.g:
//            w, ad, aa, j, 
//            g, k, e, i, 
//            ac, n, f, ag, 
//            ae, v, ab

public class h
{

    private static final h a = new h();

    private h()
    {
    }

    public static h a()
    {
        return a;
    }

    public void a(ad ad1)
    {
        if (ad1 == null)
        {
            w.a("No listener to read App User Attributes from disk");
            return;
        }
        if (e.e().o() == null)
        {
            ad1.a(null, new Exception("No App Context to read App User Attributes from Disk!"));
            return;
        } else
        {
            a("TLUserAttributes.json", "JSONObject", ((ac) (new aa(this, ad1))));
            return;
        }
    }

    public void a(j j1)
    {
        if (j1 == null)
        {
            w.a("No listener to read TLProperties from disk");
            return;
        }
        if (e.e().o() == null)
        {
            j1.a(null, new Exception("No App Context to write JSON to disk"));
            return;
        } else
        {
            a("TLEvents.json", "JSONArray", ((ac) (new g(this, j1))));
            return;
        }
    }

    public void a(k k1)
    {
        if (k1 == null)
        {
            w.a("No listener to read TLProperties from disk");
            return;
        }
        if (e.e().o() == null)
        {
            k1.a(null, new Exception("No App Context to write JSON to disk"));
            return;
        } else
        {
            a("TLProperties.json", "JSONObject", ((ac) (new com.j.a.g.e(this, k1))));
            return;
        }
    }

    public void a(String s, i l)
    {
        if (s == null || l == null)
        {
            s = new Exception("Missing fileName or listener to delete file from disk");
            if (l != null)
            {
                l.a(s);
                return;
            } else
            {
                w.a((new StringBuilder()).append("Deleting file from disk: ").append(s).toString());
                return;
            }
        }
        Context context = e.e().o();
        if (context == null)
        {
            l.a(new Exception("No App Context to write JSON to disk"));
            return;
        }
        Date date = new Date();
        s = new File(context.getCacheDir(), s);
        if (s.exists())
        {
            if (s.delete())
            {
                w.a("Deleted File", date);
            }
        } else
        {
            w.a("File does not exist to delete");
        }
        l.a(null);
    }

    public void a(String s, String s1, ac ac1)
    {
        Date date;
        if (s == null)
        {
            s = new Exception("Missing fileName or listener to read from disk");
            w.b("Reading item from disk: ", s);
            ac1.a(null, s);
            return;
        }
        Context context = e.e().o();
        date = new Date();
        s = new File(context.getCacheDir(), s);
        if (!s.exists()) goto _L2; else goto _L1
_L1:
        Object obj;
        byte byte0;
        ObjectInputStream objectinputstream;
        try
        {
            objectinputstream = new ObjectInputStream(new FileInputStream(s));
            obj = objectinputstream.readObject();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            w.b("Reading file from disk: ", s);
            ac1.a(null, s);
            return;
        }
        byte0 = -1;
        s1.hashCode();
        JVM INSTR lookupswitch 3: default 277
    //                   1025355039: 216
    //                   1706651217: 201
    //                   1752376903: 186;
           goto _L3 _L4 _L5 _L6
_L7:
        ac1.a(s, null);
        w.a((new StringBuilder()).append("Read item from disk: ").append(s1).toString(), date);
        objectinputstream.close();
        return;
_L6:
        if (s1.equals("JSONObject"))
        {
            byte0 = 0;
        }
          goto _L3
_L5:
        if (s1.equals("JSONArray"))
        {
            byte0 = 1;
        }
          goto _L3
_L4:
        if (s1.equals("Serializable"))
        {
            byte0 = 2;
        }
          goto _L3
_L9:
        s = JSONObjectInstrumentation.init((String)obj);
          goto _L7
_L10:
        s = JSONArrayInstrumentation.init((String)obj);
          goto _L7
_L2:
        w.a("File does not exist");
        ac1.a(null, new Exception("File does not exist"));
        return;
_L3:
        s = ((String) (obj));
        byte0;
        JVM INSTR tableswitch 0 2: default 308
    //                   0 231
    //                   1 243
    //                   2 132;
           goto _L8 _L9 _L10 _L7
_L8:
        s = null;
          goto _L7
    }

    public void a(ArrayList arraylist)
    {
        Context context = e.e().o();
        JSONArray jsonarray;
        if (context == null)
        {
            try
            {
                w.a("Writing TLEvents to Disk: No App Context to write JSON to disk");
                return;
            }
            // Misplaced declaration of an exception variable
            catch (ArrayList arraylist)
            {
                w.b("wr err: ", arraylist);
            }
            break MISSING_BLOCK_LABEL_63;
        }
        arraylist = arraylist.iterator();
        jsonarray = new JSONArray();
        for (; arraylist.hasNext(); jsonarray.put((JSONObject)arraylist.next())) { }
        break MISSING_BLOCK_LABEL_64;
        return;
        Void avoid[];
        arraylist = new n(jsonarray, "TLEvents.json", context.getCacheDir(), new f(this));
        avoid = new Void[0];
        if (!(arraylist instanceof AsyncTask))
        {
            arraylist.execute(avoid);
            return;
        }
        AsyncTaskInstrumentation.execute((AsyncTask)arraylist, avoid);
        return;
    }

    public void a(JSONObject jsonobject)
    {
        Context context = e.e().o();
        if (context == null)
        {
            w.a("Writing Properties to Disk: No App Context to write JSON to disk");
            return;
        }
        jsonobject = new n(jsonobject, "TLProperties.json", context.getCacheDir(), new ag(this));
        Void avoid[] = new Void[0];
        if (!(jsonobject instanceof AsyncTask))
        {
            jsonobject.execute(avoid);
            return;
        } else
        {
            AsyncTaskInstrumentation.execute((AsyncTask)jsonobject, avoid);
            return;
        }
    }

    public void b()
    {
        w.a("Delete TLProperties File from disk");
        a("TLProperties.json", new ae(this));
    }

    public void b(JSONObject jsonobject)
    {
        Context context = e.e().o();
        if (context == null)
        {
            w.a("Writing User Attributes to Disk: No App Context to write JSON to disk");
            return;
        }
        jsonobject = new n(jsonobject, "TLUserAttributes.json", context.getCacheDir(), new v(this));
        Void avoid[] = new Void[0];
        if (!(jsonobject instanceof AsyncTask))
        {
            jsonobject.execute(avoid);
            return;
        } else
        {
            AsyncTaskInstrumentation.execute((AsyncTask)jsonobject, avoid);
            return;
        }
    }

    public void c()
    {
        w.a("Delete App User Attributes From Disk");
        a("TLUserAttributes.json", new ab(this));
    }

}

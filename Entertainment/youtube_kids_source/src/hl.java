// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.database.DataSetObservable;
import android.text.TextUtils;
import android.util.Log;
import android.util.Xml;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class hl extends DataSetObservable
{

    private static final String h = hl.getSimpleName();
    private static final Object i = new Object();
    private static final Map j = new HashMap();
    final Object a = new Object();
    final List b = new ArrayList();
    final List c = new ArrayList();
    final String d;
    hn e;
    boolean f;
    boolean g;
    private final Context k;
    private int l;
    private boolean m;
    private boolean n;

    private hl(Context context, String s)
    {
        e = new ho(this);
        l = 50;
        m = true;
        f = false;
        g = true;
        n = false;
        k = context.getApplicationContext();
        if (!TextUtils.isEmpty(s) && !s.endsWith(".xml"))
        {
            d = (new StringBuilder()).append(s).append(".xml").toString();
            return;
        } else
        {
            d = s;
            return;
        }
    }

    public static hl a(Context context, String s)
    {
        Object obj = i;
        obj;
        JVM INSTR monitorenter ;
        hl hl2 = (hl)j.get(s);
        hl hl1;
        hl1 = hl2;
        if (hl2 != null)
        {
            break MISSING_BLOCK_LABEL_48;
        }
        hl1 = new hl(context, s);
        j.put(s, hl1);
        obj;
        JVM INSTR monitorexit ;
        return hl1;
        context;
        obj;
        JVM INSTR monitorexit ;
        throw context;
    }

    private void d()
    {
        Object obj;
        Object obj1;
        Exception exception;
        List list;
        int i1;
        try
        {
            obj = k.openFileInput(d);
        }
        catch (FileNotFoundException filenotfoundexception)
        {
            return;
        }
        obj1 = Xml.newPullParser();
        ((XmlPullParser) (obj1)).setInput(((java.io.InputStream) (obj)), null);
        i1 = 0;
_L1:
        if (i1 == 1 || i1 == 2)
        {
            break MISSING_BLOCK_LABEL_50;
        }
        i1 = ((XmlPullParser) (obj1)).next();
          goto _L1
        if (!"historical-records".equals(((XmlPullParser) (obj1)).getName()))
        {
            throw new XmlPullParserException("Share records file does not start with historical-records tag.");
        }
          goto _L2
        obj1;
        Log.e(h, (new StringBuilder("Error reading historical recrod file: ")).append(d).toString(), ((Throwable) (obj1)));
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_110;
        }
        ((FileInputStream) (obj)).close();
_L6:
        return;
_L2:
        list = c;
        list.clear();
_L4:
        i1 = ((XmlPullParser) (obj1)).next();
        if (i1 == 1)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (i1 == 3 || i1 == 4) goto _L4; else goto _L3
_L3:
        if (!"historical-record".equals(((XmlPullParser) (obj1)).getName()))
        {
            throw new XmlPullParserException("Share records file not well-formed.");
        }
        break MISSING_BLOCK_LABEL_211;
        obj1;
        Log.e(h, (new StringBuilder("Error reading historical recrod file: ")).append(d).toString(), ((Throwable) (obj1)));
        if (obj == null) goto _L6; else goto _L5
_L5:
        try
        {
            ((FileInputStream) (obj)).close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            return;
        }
        list.add(new hp(((XmlPullParser) (obj1)).getAttributeValue(null, "activity"), Long.parseLong(((XmlPullParser) (obj1)).getAttributeValue(null, "time")), Float.parseFloat(((XmlPullParser) (obj1)).getAttributeValue(null, "weight"))));
          goto _L4
        exception;
        IOException ioexception;
        if (obj != null)
        {
            try
            {
                ((FileInputStream) (obj)).close();
            }
            catch (IOException ioexception1) { }
        }
        throw exception;
        if (obj == null) goto _L6; else goto _L7
_L7:
        try
        {
            ((FileInputStream) (obj)).close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (IOException ioexception)
        {
            return;
        }
        ioexception;
    }

    public final int a()
    {
        int i1;
        synchronized (a)
        {
            b();
            i1 = b.size();
        }
        return i1;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final ResolveInfo a(int i1)
    {
        ResolveInfo resolveinfo;
        synchronized (a)
        {
            b();
            resolveinfo = ((hm)b.get(i1)).a;
        }
        return resolveinfo;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final Intent b(int i1)
    {
        synchronized (a) { }
        return null;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    void b()
    {
        boolean flag = true;
        if (m && g && !TextUtils.isEmpty(d))
        {
            m = false;
            f = true;
            d();
        } else
        {
            flag = false;
        }
        c();
        if (flag | false)
        {
            hn hn = e;
            notifyChanged();
        }
    }

    void c()
    {
        int j1 = c.size() - l;
        if (j1 > 0)
        {
            g = true;
            int i1 = 0;
            while (i1 < j1) 
            {
                c.remove(0);
                i1++;
            }
        }
    }

}

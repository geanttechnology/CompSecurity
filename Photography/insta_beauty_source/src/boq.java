// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.util.Log;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class boq extends AsyncTask
{

    private bor a;
    private HashMap b;
    private String c;
    private ArrayList d;

    public boq()
    {
        c = "AsynSaveBitmapTask";
        d = new ArrayList();
    }

    private ArrayList b(HashMap hashmap)
    {
        if (hashmap == null)
        {
            return null;
        }
        String s;
        for (Iterator iterator = hashmap.keySet().iterator(); iterator.hasNext(); d.add(s))
        {
            s = (String)iterator.next();
            s = a(s, (Bitmap)hashmap.get(s));
        }

        return d;
    }

    public String a(String s, Bitmap bitmap)
    {
        Object obj = null;
        FileOutputStream fileoutputstream = new FileOutputStream(s);
        bitmap.compress(android.graphics.Bitmap.CompressFormat.PNG, 100, fileoutputstream);
        fileoutputstream.flush();
        fileoutputstream.close();
        Log.v(c, (new StringBuilder()).append(s).append(" has write successfully").toString());
        return s;
        bitmap;
        bitmap = obj;
_L2:
        Log.v(c, (new StringBuilder()).append(s).append(" has write failed").toString());
        return bitmap;
        bitmap;
        bitmap = s;
        if (true) goto _L2; else goto _L1
_L1:
    }

    protected transient ArrayList a(HashMap ahashmap[])
    {
        return b(b);
    }

    public void a(bor bor1)
    {
        a = bor1;
    }

    protected void a(ArrayList arraylist)
    {
        Log.v(c, "End processing");
        if (a != null)
        {
            a.a(d);
        }
    }

    public void a(HashMap hashmap)
    {
        b = hashmap;
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((HashMap[])aobj);
    }

    protected void onPostExecute(Object obj)
    {
        a((ArrayList)obj);
    }

    protected void onPreExecute()
    {
        Log.v(c, "start processing");
        if (a != null)
        {
            a.a();
        }
    }
}

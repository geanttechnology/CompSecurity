// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.ComponentName;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.util.Xml;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import org.xmlpull.v1.XmlSerializer;

final class bi extends AsyncTask
{

    final bc a;

    private bi(bc bc1)
    {
        a = bc1;
        super();
    }

    bi(bc bc1, bc._cls1 _pcls1)
    {
        this(bc1);
    }

    public transient Void a(Object aobj[])
    {
        List list;
        Object obj1;
        int i;
        i = 0;
        list = (List)aobj[0];
        obj1 = (String)aobj[1];
        aobj = bc.a(a).openFileOutput(((String) (obj1)), 0);
        obj1 = Xml.newSerializer();
        int j;
        ((XmlSerializer) (obj1)).setOutput(((java.io.OutputStream) (aobj)), null);
        ((XmlSerializer) (obj1)).startDocument("UTF-8", Boolean.valueOf(true));
        ((XmlSerializer) (obj1)).startTag(null, "historical-records");
        j = list.size();
_L2:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        bg bg1 = (bg)list.remove(0);
        ((XmlSerializer) (obj1)).startTag(null, "historical-record");
        ((XmlSerializer) (obj1)).attribute(null, "activity", bg1.a.flattenToString());
        ((XmlSerializer) (obj1)).attribute(null, "time", String.valueOf(bg1.b));
        ((XmlSerializer) (obj1)).attribute(null, "weight", String.valueOf(bg1.c));
        ((XmlSerializer) (obj1)).endTag(null, "historical-record");
        i++;
        if (true) goto _L2; else goto _L1
        aobj;
        Log.e(bc.d(), (new StringBuilder()).append("Error writing historical recrod file: ").append(((String) (obj1))).toString(), ((Throwable) (aobj)));
_L3:
        return null;
_L1:
        ((XmlSerializer) (obj1)).endTag(null, "historical-records");
        ((XmlSerializer) (obj1)).endDocument();
        bc.a(a, true);
        if (aobj != null)
        {
            try
            {
                ((FileOutputStream) (aobj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object aobj[])
            {
                return null;
            }
            return null;
        }
          goto _L3
        Object obj;
        obj;
        Log.e(bc.d(), (new StringBuilder()).append("Error writing historical recrod file: ").append(bc.b(a)).toString(), ((Throwable) (obj)));
        bc.a(a, true);
        if (aobj != null)
        {
            try
            {
                ((FileOutputStream) (aobj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object aobj[])
            {
                return null;
            }
            return null;
        }
          goto _L3
        obj;
        Log.e(bc.d(), (new StringBuilder()).append("Error writing historical recrod file: ").append(bc.b(a)).toString(), ((Throwable) (obj)));
        bc.a(a, true);
        if (aobj != null)
        {
            try
            {
                ((FileOutputStream) (aobj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object aobj[])
            {
                return null;
            }
            return null;
        }
          goto _L3
        obj;
        Log.e(bc.d(), (new StringBuilder()).append("Error writing historical recrod file: ").append(bc.b(a)).toString(), ((Throwable) (obj)));
        bc.a(a, true);
        if (aobj == null) goto _L3; else goto _L4
_L4:
        try
        {
            ((FileOutputStream) (aobj)).close();
        }
        // Misplaced declaration of an exception variable
        catch (Object aobj[])
        {
            return null;
        }
        return null;
        obj;
        bc.a(a, true);
        if (aobj != null)
        {
            try
            {
                ((FileOutputStream) (aobj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object aobj[]) { }
        }
        throw obj;
    }

    public Object doInBackground(Object aobj[])
    {
        return a(aobj);
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.util.Log;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import javax.xml.parsers.ParserConfigurationException;
import opens.components.http.EOnlineDownType;

public class bgf
{

    ArrayList a;
    protected bge b;
    protected cex c;
    protected bgz d;

    public bgf()
    {
        a = new ArrayList();
    }

    protected bgj a()
    {
        return null;
    }

    protected String a(Object obj)
    {
        return null;
    }

    protected String a(ArrayList arraylist)
    {
        return null;
    }

    protected ArrayList a(InputStream inputstream)
    {
        return null;
    }

    public void a(bge bge1)
    {
        b = bge1;
    }

    public void a(bgz bgz)
    {
        d = bgz;
    }

    protected void a(Error error)
    {
        Log.v("Update_REQUSEST", "Update_REQUSESTError");
        if (b != null)
        {
            b.filterUpdateFailed(0);
        }
    }

    protected void a(String s)
    {
        bgj bgj1 = a();
        if (bgj1 instanceof bhl)
        {
            ((bhl)bgj1).j = s;
            bgj1.a(b);
            a.add(bgj1);
            return;
        }
        bib bib1 = new bib();
        try
        {
            bib1.a(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
        }
        bgj1.a(bib1);
        bgj1.a(b);
        a.add(bgj1);
    }

    public void a(EOnlineDownType eonlinedowntype, Error error)
    {
        switch (bgi.a[eonlinedowntype.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            a(error);
            return;

        case 2: // '\002'
            b(error);
            return;

        case 3: // '\003'
            c(error);
            break;
        }
    }

    public void a(EOnlineDownType eonlinedowntype, String s)
    {
        switch (bgi.a[eonlinedowntype.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            b(s);
            return;

        case 2: // '\002'
            c(s);
            return;

        case 3: // '\003'
            d(s);
            break;
        }
    }

    protected int b(InputStream inputstream)
    {
        return 0;
    }

    protected void b()
    {
        ArrayList arraylist = new ArrayList();
        Iterator iterator = a.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            bgj bgj2 = (bgj)iterator.next();
            if (!bgj2.a().booleanValue())
            {
                arraylist.add(bgj2);
            }
        } while (true);
        for (int i = 0; i < arraylist.size(); i++)
        {
            bgj bgj1 = (bgj)arraylist.get(i);
            a.remove(bgj1);
        }

    }

    protected void b(Error error)
    {
        Log.v("NewCount_REQUSEST", "NewCount_REQUSESTError");
    }

    public void b(Object obj)
    {
        obj = a(obj);
        c = new cex();
        c.a(EOnlineDownType.FILTERDOWNLOAD);
        c.a(((String) (obj)), new bgh(this));
        b();
    }

    protected void b(String s)
    {
        Log.v("Update_REQUSEST", "Update_REQUSEST");
        if (s != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if ((s = new ByteArrayInputStream(s.getBytes())) != null)
        {
            try
            {
                s = a(s);
                Log.v("updateDidFinished", String.format("%d", new Object[] {
                    Integer.valueOf(s.size())
                }));
                if (b != null)
                {
                    b.filterUpdateFinished(s);
                    return;
                }
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                s.printStackTrace();
                return;
            }
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    public void b(ArrayList arraylist)
    {
        arraylist = a(arraylist);
        c = new cex();
        c.a(EOnlineDownType.UPDATE);
        c.a(arraylist, new bgg(this));
        if (b != null)
        {
            b.filterUpdateStarting();
        }
    }

    protected void c(Error error)
    {
    }

    protected void c(String s)
    {
        if (s == null)
        {
            return;
        }
        s = new ByteArrayInputStream(s.getBytes());
        if (s != null)
        {
            try
            {
                int i = b(s);
                if (b != null)
                {
                    b.newFilterCount(i);
                }
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                s.printStackTrace();
            }
        }
        Log.v("NewCount_REQUSEST", "NewCount_REQUSEST");
        return;
    }

    protected void d(String s)
    {
        if (s != null)
        {
            try
            {
                a(s);
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                s.printStackTrace();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                s.printStackTrace();
            }
        }
        Log.v("info_REQUSEST", "info_REQUSEST");
    }
}

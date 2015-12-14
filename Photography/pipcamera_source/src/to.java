// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.util.Log;
import com.crashlytics.android.Crashlytics;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import javax.xml.parsers.ParserConfigurationException;
import opens.components.http.EOnlineDownType;

public class to
{

    ArrayList a;
    protected tn b;
    protected aht c;

    public to()
    {
        a = new ArrayList();
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

    protected tp a()
    {
        return null;
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
        uy uy1 = new uy();
        try
        {
            uy1.a(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            Crashlytics.logException(s);
        }
        s = a();
        s.a(uy1);
        s.a(b);
        a.add(s);
    }

    public void a(EOnlineDownType eonlinedowntype, Error error)
    {
        class _cls3
        {

            static final int a[];

            static 
            {
                a = new int[EOnlineDownType.values().length];
                try
                {
                    a[EOnlineDownType.UPDATE.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    a[EOnlineDownType.NEWCOUNT.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[EOnlineDownType.FILTERDOWNLOAD.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls3.a[eonlinedowntype.ordinal()])
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
        switch (_cls3.a[eonlinedowntype.ordinal()])
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

    public void a(tn tn1)
    {
        b = tn1;
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
            tp tp2 = (tp)iterator.next();
            if (!tp2.a().booleanValue())
            {
                arraylist.add(tp2);
            }
        } while (true);
        for (int i = 0; i < arraylist.size(); i++)
        {
            tp tp1 = (tp)arraylist.get(i);
            a.remove(tp1);
        }

    }

    protected void b(Error error)
    {
        Log.v("NewCount_REQUSEST", "NewCount_REQUSESTError");
    }

    public void b(Object obj)
    {
        obj = a(obj);
        c = new aht();
        c.a(EOnlineDownType.FILTERDOWNLOAD);
        c.a(((String) (obj)), new ahu() {

            final to a;

            public void a(EOnlineDownType eonlinedowntype, Error error)
            {
                a.a(eonlinedowntype, error);
            }

            public void a(EOnlineDownType eonlinedowntype, String s)
            {
                a.a(eonlinedowntype, s);
            }

            
            {
                a = to.this;
                super();
            }
        });
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
                Crashlytics.logException(s);
                return;
            }
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    public void b(ArrayList arraylist)
    {
        arraylist = a(arraylist);
        c = new aht();
        c.a(EOnlineDownType.UPDATE);
        c.a(arraylist, new ahu() {

            final to a;

            public void a(EOnlineDownType eonlinedowntype, Error error)
            {
                a.a(eonlinedowntype, error);
            }

            public void a(EOnlineDownType eonlinedowntype, String s)
            {
                a.a(eonlinedowntype, s);
            }

            
            {
                a = to.this;
                super();
            }
        });
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
                Crashlytics.logException(s);
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
                Crashlytics.logException(s);
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                s.printStackTrace();
                Crashlytics.logException(s);
            }
        }
        Log.v("info_REQUSEST", "info_REQUSEST");
    }
}

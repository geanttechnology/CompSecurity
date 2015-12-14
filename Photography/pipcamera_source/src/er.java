// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.util.Log;
import com.fotoable.alertad.FotoAlert;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class er
{

    public String a;
    public long b;
    public List c;
    private Context d;

    public er(Context context)
    {
        c = new ArrayList();
        d = context;
    }

    static Context a(er er1)
    {
        return er1.d;
    }

    public static er a(JSONObject jsonobject, Context context)
    {
        if (jsonobject != null) goto _L2; else goto _L1
_L1:
        return null;
_L2:
        er er1 = new er(context);
        if (jsonobject.isNull("position")) goto _L1; else goto _L3
_L3:
        er1.a = kv.a(jsonobject, "position");
        if (!ep.a(context).contains(er1.a)) goto _L1; else goto _L4
_L4:
        if (!jsonobject.isNull("spaceTime"))
        {
            er1.b = kv.e(jsonobject, "spaceTime");
        }
        if (jsonobject.isNull("alerts")) goto _L6; else goto _L5
_L5:
        jsonobject = kv.b(jsonobject, "alerts");
        if (jsonobject == null) goto _L6; else goto _L7
_L7:
        if (jsonobject.length() <= 0) goto _L6; else goto _L8
_L8:
        int i = 0;
_L10:
        if (i >= jsonobject.length()) goto _L6; else goto _L9
_L9:
        FotoAlert fotoalert = FotoAlert.a(kv.a(jsonobject, i), context);
        if (fotoalert != null)
        {
            try
            {
                er1.c.add(fotoalert);
            }
            // Misplaced declaration of an exception variable
            catch (JSONObject jsonobject)
            {
                return null;
            }
        }
        i++;
        if (true) goto _L10; else goto _L6
_L6:
        return er1;
    }

    private void a(String s, String s1)
    {
        Log.i("FotoAlertFactory", (new StringBuilder()).append("loadImage2Path : ").append(s).toString());
        (new Thread(new Runnable(s, s1) {

            final String a;
            final String b;
            final er c;

            public void run()
            {
                byte abyte0[] = er.a(c, a);
                try
                {
                    FileOutputStream fileoutputstream = new FileOutputStream(new File(b));
                    fileoutputstream.write(abyte0);
                    fileoutputstream.flush();
                    fileoutputstream.close();
                    eq.a(er.a(c)).a(b);
                    return;
                }
                catch (Exception exception)
                {
                    exception.printStackTrace();
                }
            }

            
            {
                c = er.this;
                a = s;
                b = s1;
                super();
            }
        })).start();
    }

    static byte[] a(er er1, String s)
    {
        return er1.c(s);
    }

    private byte[] c(String s)
    {
        ByteArrayOutputStream bytearrayoutputstream;
        byte abyte0[];
        s = (new URL(s)).openStream();
        bytearrayoutputstream = new ByteArrayOutputStream();
        abyte0 = new byte[4096];
_L1:
        int i = s.read(abyte0);
label0:
        {
            if (i == -1)
            {
                break label0;
            }
            try
            {
                bytearrayoutputstream.write(abyte0, 0, i);
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                throw new RuntimeException(s);
            }
        }
          goto _L1
        abyte0 = bytearrayoutputstream.toByteArray();
        bytearrayoutputstream.close();
        s.close();
        return abyte0;
    }

    public FotoAlert a(String s)
    {
label0:
        {
            if (c == null || c.size() <= 0)
            {
                break label0;
            }
            Iterator iterator = c.iterator();
            FotoAlert fotoalert;
            String s1;
            do
            {
                do
                {
                    if (!iterator.hasNext())
                    {
                        break label0;
                    }
                    fotoalert = (FotoAlert)iterator.next();
                } while (!fotoalert.a());
                s1 = fotoalert.a(s);
            } while (s1 == null || s1.length() <= 0 || !(new File(s1)).exists());
            return fotoalert;
        }
        return null;
    }

    public void b(String s)
    {
label0:
        {
            if (c == null || c.size() <= 0)
            {
                break label0;
            }
            Iterator iterator = c.iterator();
            FotoAlert fotoalert;
            String s1;
            do
            {
                do
                {
                    if (!iterator.hasNext())
                    {
                        break label0;
                    }
                    fotoalert = (FotoAlert)iterator.next();
                } while (!fotoalert.a());
                s1 = fotoalert.a(s);
            } while (s1 == null || s1.length() <= 0 || (new File(s1)).exists());
            a(fotoalert.c, s1);
        }
    }
}

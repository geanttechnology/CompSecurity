// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package u.aly;

import android.content.Context;
import android.os.Environment;
import java.io.File;
import java.io.FileInputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package u.aly:
//            a, bv, bi

public class i extends a
{

    private static final String a = "utdid";
    private static final String b = "android.permission.WRITE_EXTERNAL_STORAGE";
    private static final Pattern c = Pattern.compile("UTDID\">([^<]+)");
    private Context d;

    public i(Context context)
    {
        super("utdid");
        d = context;
    }

    private String b(String s)
    {
        if (s != null)
        {
            if ((s = c.matcher(s)).find())
            {
                return s.group(1);
            }
        }
        return null;
    }

    private String g()
    {
        Object obj;
        obj = h();
        if (obj == null || !((File) (obj)).exists())
        {
            return null;
        }
        String s;
        try
        {
            obj = new FileInputStream(((File) (obj)));
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            ((Exception) (obj)).printStackTrace();
            return null;
        }
        s = b(bv.a(((java.io.InputStream) (obj))));
        bv.c(((java.io.InputStream) (obj)));
        return s;
        Exception exception;
        exception;
        bv.c(((java.io.InputStream) (obj)));
        throw exception;
    }

    private File h()
    {
        while (!bi.a(d, "android.permission.WRITE_EXTERNAL_STORAGE") || !Environment.getExternalStorageState().equals("mounted")) 
        {
            return null;
        }
        File file = Environment.getExternalStorageDirectory();
        try
        {
            file = new File(file.getCanonicalPath(), ".UTSystemConfig/Global/Alvin2.xml");
        }
        catch (Exception exception)
        {
            return null;
        }
        return file;
    }

    public String f()
    {
        return g();
    }

}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.Context;
import android.util.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package android.support.v7:
//            jf

public class je
{

    private static je a = new je();

    private je()
    {
    }

    public static je a()
    {
        return a;
    }

    private jf a(File file)
    {
        jf jf1;
        try
        {
            FileReader filereader = new FileReader(file);
            char ac[] = new char[(int)file.length()];
            filereader.read(ac);
            jf1 = new jf(ac);
            jf1.a(file.getName());
            filereader.close();
        }
        // Misplaced declaration of an exception variable
        catch (File file)
        {
            return null;
        }
        return jf1;
    }

    private File c(Context context)
    {
        return new File(context.getFilesDir(), "AFRequestCache");
    }

    public void a(Context context)
    {
        try
        {
            if (!c(context).exists())
            {
                c(context).mkdir();
            }
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Log.i("AppsFlyer_1.18", "Could not create cache directory");
        }
    }

    public void a(jf jf1, Context context)
    {
        File file;
        try
        {
            file = c(context);
            if (!file.exists())
            {
                file.mkdir();
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (jf jf1)
        {
            Log.i("AppsFlyer_1.18", "Could not cache request");
            return;
        }
        if (file.listFiles().length > 20)
        {
            Log.i("AppsFlyer_1.18", "reached cache limit, not caching request");
            return;
        }
        Log.i("AppsFlyer_1.18", "caching request...");
        context = new File(c(context), Long.toString(System.currentTimeMillis()));
        context.createNewFile();
        context = new OutputStreamWriter(new FileOutputStream(context.getPath(), true));
        context.write("version=");
        context.write(jf1.a());
        context.write(10);
        context.write("url=");
        context.write(jf1.c());
        context.write(10);
        context.write("data=");
        context.write(jf1.b());
        context.write(10);
        context.flush();
        context.close();
        return;
    }

    public void a(String s, Context context)
    {
        context = new File(c(context), s);
        Log.i("AppsFlyer_1.18", (new StringBuilder()).append("Deleting ").append(s).append(" from cache").toString());
        if (!context.exists())
        {
            break MISSING_BLOCK_LABEL_56;
        }
        context.delete();
        return;
        context;
        Log.i("AppsFlyer_1.18", (new StringBuilder()).append("Could not delete ").append(s).append(" from cache").toString(), context);
        return;
    }

    public List b(Context context)
    {
        ArrayList arraylist = new ArrayList();
        context = c(context);
        if (context.exists())
        {
            break MISSING_BLOCK_LABEL_28;
        }
        context.mkdir();
        return arraylist;
        int j;
        context = context.listFiles();
        j = context.length;
        int i = 0;
_L2:
        File file;
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        file = context[i];
        Log.i("AppsFlyer_1.18", (new StringBuilder()).append("Found cached request").append(file.getName()).toString());
        arraylist.add(a(file));
        i++;
        if (true) goto _L2; else goto _L1
        context;
        Log.i("AppsFlyer_1.18", "Could not cache request");
_L1:
        return arraylist;
    }

}

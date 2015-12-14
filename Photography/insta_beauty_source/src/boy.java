// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.Test118.NativeView;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class boy
    implements bor
{

    private static boy a;
    private Handler b;
    private File c;
    private HashMap d;

    private boy()
    {
        d = new HashMap();
        c = new File((new StringBuilder()).append(Environment.getExternalStorageDirectory().getPath()).append("/.tmp/").toString());
        if (!c.exists())
        {
            c.mkdir();
        }
    }

    public static String a(String s, Bitmap bitmap)
    {
        String s1 = (new StringBuilder()).append(c()).append("/").append(s).toString();
        try
        {
            NativeView.a(bitmap, (new StringBuilder()).append(c()).append("/").append(s).toString(), 100);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return s1;
        }
        return s1;
    }

    public static boy b()
    {
        if (a == null)
        {
            a = new boy();
        }
        return a;
    }

    public static String b(String s, Bitmap bitmap)
    {
        s = (new StringBuilder()).append(c()).append("/").append(s).toString();
        FileOutputStream fileoutputstream = new FileOutputStream(s);
        bitmap.compress(android.graphics.Bitmap.CompressFormat.JPEG, 100, fileoutputstream);
        fileoutputstream.flush();
        fileoutputstream.close();
        Log.v("Imagekeeper", (new StringBuilder()).append(s).append(" has write successfully").toString());
        return s;
    }

    public static String c()
    {
        File file = new File((new StringBuilder()).append(Environment.getExternalStorageDirectory().getPath()).append("/.tmp/").toString());
        if (!file.exists())
        {
            file.mkdir();
        }
        return file.getAbsolutePath();
    }

    public String a(String s)
    {
        return (new StringBuilder()).append(c.getAbsolutePath()).append("/").append(s).toString();
    }

    public void a()
    {
    }

    public void a(ArrayList arraylist)
    {
        if (b != null)
        {
            arraylist = Message.obtain(b, 0, arraylist);
            b.sendMessage(arraylist);
        }
    }

    public void a(HashMap hashmap, Handler handler)
    {
        b = handler;
        handler = new HashMap(hashmap.size());
        String s;
        String s1;
        for (Iterator iterator = hashmap.keySet().iterator(); iterator.hasNext(); d.put(s, s1))
        {
            s = (String)iterator.next();
            Bitmap bitmap = (Bitmap)hashmap.get(s);
            s1 = (new StringBuilder()).append(c.getAbsolutePath()).append("/").append(s).toString();
            handler.put(s1, bitmap);
        }

        hashmap = new boq();
        hashmap.a(this);
        hashmap.a(handler);
        hashmap.execute(new HashMap[] {
            handler
        });
    }

    public Bitmap b(String s)
    {
        s = (String)d.get(s);
        if (s == null)
        {
            return null;
        } else
        {
            android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
            options.inScaled = false;
            return BitmapFactory.decodeFile(s, options);
        }
    }

    public void d()
    {
        Iterator iterator = d.entrySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Object obj = (String)((java.util.Map.Entry)iterator.next()).getValue();
            if (obj == null)
            {
                return;
            }
            obj = new File(((String) (obj)));
            if (((File) (obj)).exists())
            {
                ((File) (obj)).delete();
            }
        } while (true);
        d.clear();
    }
}

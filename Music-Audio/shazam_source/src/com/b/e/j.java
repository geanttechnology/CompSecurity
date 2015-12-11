// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.b.e;

import android.content.Context;
import com.b.a.b;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

// Referenced classes of package com.b.e:
//            u, n, p, c

public class j
{

    public j()
    {
    }

    public static ArrayList a(Context context)
    {
        Object obj = null;
        File file = context.getFilesDir();
        context = obj;
        if (file != null)
        {
            context = obj;
            if (file.isDirectory())
            {
                context = file.list(new u());
                if (context != null)
                {
                    Arrays.sort(context);
                } else
                {
                    context = new String[0];
                }
            }
        }
        return new ArrayList(Arrays.asList(context));
    }

    public static void a(b b1, String s, int i, String s1)
    {
        Object obj;
        Object obj1;
        n n1;
        int k;
        obj1 = b1.ab;
        n1 = b1.b;
        obj = null;
        b1 = null;
        k = p.a(n1.b(s), 0);
        obj1 = ((Context) (obj1)).openFileOutput(s, i);
        b1 = ((b) (obj1));
        obj = obj1;
        ((FileOutputStream) (obj1)).write(s1.getBytes());
        b1 = ((b) (obj1));
        obj = obj1;
        n1.a(s, String.valueOf(k + 1));
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_84;
        }
        ((FileOutputStream) (obj1)).close();
_L2:
        return;
        b1;
        c.a(b1);
        return;
        s;
        obj = b1;
        c.a(com/b/e/j, (new StringBuilder("Exception in writeEvent:")).append(s.getLocalizedMessage()).toString());
        obj = b1;
        c.a(s);
        if (b1 == null) goto _L2; else goto _L1
_L1:
        try
        {
            b1.close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (b b1)
        {
            c.a(b1);
        }
        return;
        b1;
        if (obj != null)
        {
            try
            {
                ((FileOutputStream) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                c.a(s);
            }
        }
        throw b1;
    }

    public static boolean a(b b1, String s)
    {
        Context context = b1.ab;
        b1 = b1.b;
        boolean flag = context.deleteFile(s);
        if (flag)
        {
            (new StringBuilder("File")).append(s).append(" was removed");
            c.a(com/b/e/j);
            b1.c(s);
        }
        return flag;
    }

    public static String[] a(Context context, String s)
    {
        Object obj;
        LinkedList linkedlist;
        linkedlist = new LinkedList();
        obj = null;
        s = new BufferedReader(new InputStreamReader(context.openFileInput(s)));
_L2:
        context = s;
        obj = s.readLine();
        if (obj == null)
        {
            break; /* Loop/switch isn't completed */
        }
        context = s;
        linkedlist.add(obj);
        if (true) goto _L2; else goto _L1
        obj;
_L6:
        context = s;
        c.a(((Exception) (obj)));
        if (s != null)
        {
            try
            {
                s.close();
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                c.a(context);
            }
        }
        context = new String[linkedlist.size()];
        linkedlist.toArray(context);
        return context;
_L1:
        try
        {
            s.close();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            c.a(context);
        }
        if (true)
        {
            break MISSING_BLOCK_LABEL_67;
        }
        context;
        s = ((String) (obj));
_L4:
        if (s != null)
        {
            try
            {
                s.close();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                c.a(s);
            }
        }
        throw context;
        obj;
        s = context;
        context = ((Context) (obj));
        if (true) goto _L4; else goto _L3
_L3:
        obj;
        s = null;
        if (true) goto _L6; else goto _L5
_L5:
    }
}

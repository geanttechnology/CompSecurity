// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.network.a;

import android.content.Context;
import com.smule.android.c.aa;
import com.smule.android.f.n;
import com.smule.android.network.core.b;
import com.smule.android.network.core.s;
import com.smule.android.network.core.v;
import com.smule.android.network.models.SongV2;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class r
{

    static final String a = com/smule/android/network/a/r.getName();

    public r()
    {
    }

    private static File a(String s, File file, s s1)
    {
        return a(s, file, s1, 60000);
    }

    private static File a(String s, File file, s s1, int i)
    {
        if (s.equals(""))
        {
            aa.b(a, "Empty URL passed to downloadFile(String url, File file); aborting download!");
            return null;
        }
        com.smule.android.network.core.j j = b.a().a(s, s1, i);
        if (j == null)
        {
            break MISSING_BLOCK_LABEL_64;
        }
        com.smule.android.network.core.r.a(j, new FileOutputStream(file), s1);
        return file;
        s1;
        try
        {
            aa.b(a, "Couldn't find file for downloaded resource", s1);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            aa.b(a, "Server exception: ", s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            aa.b(a, "Server IO exception: ", s);
        }
        // Misplaced declaration of an exception variable
        catch (s s1)
        {
            if (s1.getMessage() != null && s1.getMessage().contains("canceled"))
            {
                aa.c(a, (new StringBuilder()).append("File download was canceled from ").append(s).toString());
            } else
            {
                throw s1;
            }
        }
        if (file.exists() && !file.delete())
        {
            aa.e(a, (new StringBuilder()).append("Could not delete file: ").append(file.getAbsolutePath()).toString());
        }
        return null;
    }

    public static File a(String s, String s1, Context context)
    {
        return a(s, s1, context, ((s) (null)));
    }

    public static File a(String s, String s1, Context context, s s2)
    {
        context = n.b(context);
        s1 = new File((new StringBuilder()).append(context).append("/").append(s1).toString());
        if (s1.exists())
        {
            return s1;
        } else
        {
            return a(s, ((File) (s1)), s2);
        }
    }

    public static File a(String s, String s1, Context context, SongV2 songv2, s s2)
    {
        context = n.b(context);
        context = new File((new StringBuilder()).append(context).append("/").append(s1).toString());
        s1 = context;
        if (!songv2.a()) goto _L2; else goto _L1
_L1:
        context = a(s, ((File) (context)), s2);
        s1 = context;
        if (context == null) goto _L2; else goto _L3
_L3:
        return context;
_L2:
        if (s1 == null)
        {
            break; /* Loop/switch isn't completed */
        }
        context = s1;
        if (s1.exists()) goto _L3; else goto _L4
_L4:
        if (s1 == null)
        {
            return null;
        } else
        {
            return a(s, ((File) (s1)), s2);
        }
    }

}

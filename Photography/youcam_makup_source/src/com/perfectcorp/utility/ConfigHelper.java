// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.perfectcorp.utility;

import android.os.Environment;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class ConfigHelper
{

    public static String a = "";
    private static Configs b[];
    private static Map c = new HashMap();

    public static String a(Configs configs, String s)
    {
        if (c.containsKey(configs))
        {
            return (String)c.get(configs);
        } else
        {
            return s;
        }
    }

    public static void a()
    {
        Object obj = Environment.getExternalStorageDirectory().getAbsolutePath();
        if (obj != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Object obj1;
        Properties properties;
        properties = new Properties();
        obj1 = null;
        obj = new FileInputStream((new StringBuilder()).append(((String) (obj))).append("/cyberlink/bc/").append("bc.config").toString());
        Configs aconfigs[];
        int j;
        properties.load(((InputStream) (obj)));
        obj1 = Arrays.asList(b);
        aconfigs = Configs.values();
        j = aconfigs.length;
        int i = 0;
_L5:
        if (i >= j) goto _L4; else goto _L3
_L3:
        Configs configs = aconfigs[i];
        if (((List) (obj1)).contains(configs))
        {
            String s = properties.getProperty(configs.toString(), a);
            c.put(configs, s);
        }
        i++;
          goto _L5
_L4:
        if (obj != null)
        {
            try
            {
                ((InputStream) (obj)).close();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                return;
            }
        }
        if (true) goto _L1; else goto _L6
_L6:
        obj;
        obj = null;
_L10:
        if (obj == null) goto _L1; else goto _L7
_L7:
        try
        {
            ((InputStream) (obj)).close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            return;
        }
        obj;
_L9:
        if (obj1 != null)
        {
            try
            {
                ((InputStream) (obj1)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj1) { }
        }
        throw obj;
        Exception exception1;
        exception1;
        obj1 = obj;
        obj = exception1;
        if (true) goto _L9; else goto _L8
_L8:
        Exception exception;
        exception;
          goto _L10
    }

    static 
    {
        b = (new Configs[] {
            Configs.a, Configs.b
        });
    }

    private class Configs extends Enum
    {

        public static final Configs a;
        public static final Configs b;
        private static final Configs c[];

        public static Configs valueOf(String s)
        {
            return (Configs)Enum.valueOf(com/perfectcorp/utility/ConfigHelper$Configs, s);
        }

        public static Configs[] values()
        {
            return (Configs[])c.clone();
        }

        static 
        {
            a = new Configs("Email", 0);
            b = new Configs("Password", 1);
            c = (new Configs[] {
                a, b
            });
        }

        private Configs(String s, int i)
        {
            super(s, i);
        }
    }

}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.jivesoftware.smack.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

public final class k
{

    private static final Logger a = Logger.getLogger(org/jivesoftware/smack/util/k.getName());

    public k()
    {
    }

    public static InputStream a(String s, ClassLoader classloader)
    {
label0:
        {
            URI uri = URI.create(s);
            if (uri.getScheme() == null)
            {
                throw new MalformedURLException((new StringBuilder()).append("No protocol found in file URL: ").append(s).toString());
            }
            if (uri.getScheme().equals("classpath"))
            {
                s = a();
                if (classloader != null)
                {
                    s.add(0, classloader);
                }
                s = s.iterator();
                do
                {
                    if (!s.hasNext())
                    {
                        break label0;
                    }
                    classloader = ((ClassLoader)s.next()).getResourceAsStream(uri.getSchemeSpecificPart());
                } while (classloader == null);
                return classloader;
            } else
            {
                return uri.toURL().openStream();
            }
        }
        return null;
    }

    public static List a()
    {
        int i = 0;
        ClassLoader aclassloader[] = new ClassLoader[2];
        aclassloader[0] = org/jivesoftware/smack/util/k.getClassLoader();
        aclassloader[1] = Thread.currentThread().getContextClassLoader();
        ArrayList arraylist = new ArrayList(aclassloader.length);
        for (int j = aclassloader.length; i < j; i++)
        {
            ClassLoader classloader = aclassloader[i];
            if (classloader != null)
            {
                arraylist.add(classloader);
            }
        }

        return arraylist;
    }

    public static boolean a(String s, Set set)
    {
        BufferedReader bufferedreader;
        s = a(s, ((ClassLoader) (null)));
        if (s == null)
        {
            return false;
        }
        bufferedreader = new BufferedReader(new InputStreamReader(s));
_L1:
        String s1 = bufferedreader.readLine();
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_66;
        }
        set.add(s1);
          goto _L1
        set;
        throw new IOException("readLine() fail");
        set;
        s.close();
        throw set;
        s.close();
        return true;
    }

}

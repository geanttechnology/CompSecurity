// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.googlecode.javacpp;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.LinkedList;

// Referenced classes of package com.googlecode.javacpp:
//            Builder

public static class paths extends URLClassLoader
{

    private LinkedList paths;

    public transient void addPaths(String as[])
    {
        if (as != null)
        {
            int j = as.length;
            int i = 0;
            while (i < j) 
            {
                String s = as[i];
                File file = new File(s);
                if (file.exists())
                {
                    paths.add(s);
                    try
                    {
                        addURL(file.toURI().toURL());
                    }
                    // Misplaced declaration of an exception variable
                    catch (String as[])
                    {
                        throw new RuntimeException(as);
                    }
                }
                i++;
            }
        }
    }

    protected Class findClass(String s)
        throws ClassNotFoundException
    {
        if (paths.isEmpty())
        {
            addPaths(new String[] {
                System.getProperty("user.dir")
            });
        }
        return super.findClass(s);
    }

    public String[] getPaths()
    {
        if (paths.isEmpty())
        {
            addPaths(new String[] {
                System.getProperty("user.dir")
            });
        }
        return (String[])paths.toArray(new String[paths.size()]);
    }

    public ()
    {
        super(new URL[0]);
        paths = new LinkedList();
    }

    public paths(ClassLoader classloader)
    {
        super(new URL[0], classloader);
        paths = new LinkedList();
    }
}

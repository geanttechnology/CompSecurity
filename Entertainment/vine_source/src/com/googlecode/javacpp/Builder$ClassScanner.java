// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.googlecode.javacpp;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.jar.JarInputStream;
import java.util.zip.ZipEntry;

// Referenced classes of package com.googlecode.javacpp:
//            Builder

public static class loader
{

    private Collection classes;
    private er loader;

    public void addClass(String s)
    {
        if (s != null)
        {
            String s1 = s;
            if (s.endsWith(".class"))
            {
                s1 = s.substring(0, s.length() - 6);
            }
            try
            {
                s = Class.forName(s1, false, loader);
                if (!classes.contains(s))
                {
                    classes.add(s);
                    return;
                }
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                System.err.println((new StringBuilder()).append("Warning: Could not find class ").append(s1).append(": ").append(s).toString());
                return;
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                System.err.println((new StringBuilder()).append("Warning: Could not load class ").append(s1).append(": ").append(s).toString());
                return;
            }
        }
    }

    public void addClassOrPackage(String s)
        throws IOException
    {
        if (s == null)
        {
            return;
        }
        s = s.replace('/', '.');
        if (s.endsWith(".**"))
        {
            addPackage(s.substring(0, s.length() - 3), true);
            return;
        }
        if (s.endsWith(".*"))
        {
            addPackage(s.substring(0, s.length() - 2), false);
            return;
        } else
        {
            addClass(s);
            return;
        }
    }

    public void addMatchingDir(String s, File file, String s1, boolean flag)
    {
        File afile[] = file.listFiles();
        Arrays.sort(afile);
        int j = afile.length;
        int i = 0;
        while (i < j) 
        {
            File file1 = afile[i];
            if (s == null)
            {
                file = file1.getName();
            } else
            {
                file = (new StringBuilder()).append(s).append(file1.getName()).toString();
            }
            if (file1.isDirectory())
            {
                addMatchingDir((new StringBuilder()).append(file).append("/").toString(), file1, s1, flag);
            } else
            {
                addMatchingFile(file, s1, flag);
            }
            i++;
        }
    }

    public void addMatchingFile(String s, String s1, boolean flag)
    {
        if (s != null && s.endsWith(".class") && (s1 == null || flag && s.startsWith(s1) || s.regionMatches(0, s1, 0, Math.max(s.lastIndexOf('/'), s1.lastIndexOf('/')))))
        {
            addClass(s.replace('/', '.'));
        }
    }

    public void addPackage(String s, boolean flag)
        throws IOException
    {
        String as[] = loader.getPaths();
        String s1;
        int i;
        int j;
        int k;
        if (s == null)
        {
            s1 = null;
        } else
        {
            s1 = (new StringBuilder()).append(s.replace('.', '/')).append("/").toString();
        }
        j = classes.size();
        k = as.length;
        i = 0;
        while (i < k) 
        {
            File file = new File(as[i]);
            if (file.isDirectory())
            {
                addMatchingDir(null, file, s1, flag);
            } else
            {
                JarInputStream jarinputstream = new JarInputStream(new FileInputStream(file));
                for (ZipEntry zipentry = jarinputstream.getNextEntry(); zipentry != null; zipentry = jarinputstream.getNextEntry())
                {
                    addMatchingFile(zipentry.getName(), s1, flag);
                    jarinputstream.closeEntry();
                }

                jarinputstream.close();
            }
            i++;
        }
        if (classes.size() == 0 && s == null)
        {
            System.err.println("Warning: No classes found in the unnamed package");
            Builder.printHelp();
        } else
        if (j == classes.size() && s != null)
        {
            System.err.println((new StringBuilder()).append("Warning: No classes found in package ").append(s).toString());
            return;
        }
    }

    public er getClassLoader()
    {
        return loader;
    }

    public Collection getClasses()
    {
        return classes;
    }

    public er(Collection collection, er er)
    {
        classes = collection;
        loader = er;
    }
}

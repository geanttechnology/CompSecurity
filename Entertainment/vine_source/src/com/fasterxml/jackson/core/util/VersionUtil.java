// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fasterxml.jackson.core.util;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.core.Versioned;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.util.Properties;
import java.util.regex.Pattern;

public class VersionUtil
{

    private static final Pattern VERSION_SEPARATOR = Pattern.compile("[-_./;:]");
    private final Version _version;

    protected VersionUtil()
    {
        Version version1;
        version1 = null;
        Version version2 = versionFor(getClass());
        version1 = version2;
_L2:
        Version version3 = version1;
        if (version1 == null)
        {
            version3 = Version.unknownVersion();
        }
        _version = version3;
        return;
        Exception exception;
        exception;
        System.err.println((new StringBuilder()).append("ERROR: Failed to load Version information from ").append(getClass()).toString());
        if (true) goto _L2; else goto _L1
_L1:
    }

    private static final void _close(Closeable closeable)
    {
        try
        {
            closeable.close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Closeable closeable)
        {
            return;
        }
    }

    private static Version doReadVersion(Reader reader)
    {
        String s1;
        Object obj1;
        BufferedReader bufferedreader;
        obj1 = null;
        s1 = null;
        bufferedreader = new BufferedReader(reader);
        String s = bufferedreader.readLine();
        if (s == null) goto _L2; else goto _L1
_L1:
        reader = bufferedreader.readLine();
        Object obj;
        obj = reader;
        if (reader == null)
        {
            break MISSING_BLOCK_LABEL_45;
        }
        s1 = bufferedreader.readLine();
        obj = reader;
_L7:
        _close(bufferedreader);
        reader = ((Reader) (obj));
_L4:
        obj = reader;
        if (reader != null)
        {
            obj = reader.trim();
        }
        reader = s1;
        if (s1 != null)
        {
            reader = s1.trim();
        }
        return parseVersion(s, ((String) (obj)), reader);
        reader;
        reader = null;
        s = null;
_L5:
        _close(bufferedreader);
        s1 = obj1;
        if (true) goto _L4; else goto _L3
_L3:
        reader;
        _close(bufferedreader);
        throw reader;
        reader;
        reader = null;
          goto _L5
        IOException ioexception;
        ioexception;
          goto _L5
_L2:
        obj = null;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public static Version mavenVersionFor(ClassLoader classloader, String s, String s1)
    {
        classloader = classloader.getResourceAsStream((new StringBuilder()).append("META-INF/maven/").append(s.replaceAll("\\.", "/")).append("/").append(s1).append("/pom.properties").toString());
        if (classloader == null)
        {
            break MISSING_BLOCK_LABEL_99;
        }
        s = new Properties();
        s.load(classloader);
        s1 = s.getProperty("version");
        String s2 = s.getProperty("artifactId");
        s = parseVersion(s1, s.getProperty("groupId"), s2);
        _close(classloader);
        return s;
        s;
        _close(classloader);
        return Version.unknownVersion();
        s;
        _close(classloader);
        throw s;
    }

    public static Version packageVersionFor(Class class1)
    {
        Version version1;
        Exception exception;
        try
        {
            class1 = Class.forName((new StringBuilder()).append(class1.getPackage().getName()).append(".PackageVersion").toString(), true, class1.getClassLoader());
        }
        // Misplaced declaration of an exception variable
        catch (Class class1)
        {
            return null;
        }
        version1 = ((Versioned)class1.newInstance()).version();
        return version1;
        exception;
        throw new IllegalArgumentException((new StringBuilder()).append("Failed to get Versioned out of ").append(class1).toString());
    }

    public static Version parseVersion(String s, String s1, String s2)
    {
        Object obj = null;
        int j = 0;
        if (s != null)
        {
            s = s.trim();
            if (s.length() > 0)
            {
                String as[] = VERSION_SEPARATOR.split(s);
                int k = parseVersionPart(as[0]);
                int i;
                if (as.length > 1)
                {
                    i = parseVersionPart(as[1]);
                } else
                {
                    i = 0;
                }
                if (as.length > 2)
                {
                    j = parseVersionPart(as[2]);
                }
                s = obj;
                if (as.length > 3)
                {
                    s = as[3];
                }
                return new Version(k, i, j, s, s1, s2);
            }
        }
        return null;
    }

    protected static int parseVersionPart(String s)
    {
        int i = 0;
        int k = s.length();
        int j = 0;
        do
        {
            char c;
label0:
            {
                if (i < k)
                {
                    c = s.charAt(i);
                    if (c <= '9' && c >= '0')
                    {
                        break label0;
                    }
                }
                return j;
            }
            j = j * 10 + (c - 48);
            i++;
        } while (true);
    }

    public static final void throwInternal()
    {
        throw new RuntimeException("Internal error: this code path should never get executed");
    }

    public static Version versionFor(Class class1)
    {
        Version version1 = packageVersionFor(class1);
        if (version1 != null)
        {
            return version1;
        }
        class1 = class1.getResourceAsStream("VERSION.txt");
        if (class1 == null)
        {
            return Version.unknownVersion();
        }
        Version version2 = doReadVersion(new InputStreamReader(class1, "UTF-8"));
        _close(class1);
        return version2;
        Object obj;
        obj;
        obj = Version.unknownVersion();
        _close(class1);
        return ((Version) (obj));
        obj;
        _close(class1);
        throw obj;
    }

    public Version version()
    {
        return _version;
    }

}

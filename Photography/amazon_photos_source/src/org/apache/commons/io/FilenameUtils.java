// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.io;

import java.io.File;
import java.io.IOException;

// Referenced classes of package org.apache.commons.io:
//            IOCase

public class FilenameUtils
{

    public static final String EXTENSION_SEPARATOR_STR = Character.toString('.');
    private static final char OTHER_SEPARATOR;
    private static final char SYSTEM_SEPARATOR;

    public static boolean directoryContains(String s, String s1)
        throws IOException
    {
        if (s == null)
        {
            throw new IllegalArgumentException("Directory must not be null");
        }
        while (s1 == null || IOCase.SYSTEM.checkEquals(s, s1)) 
        {
            return false;
        }
        return IOCase.SYSTEM.checkStartsWith(s1, s);
    }

    private static String doGetFullPath(String s, boolean flag)
    {
        String s1;
        if (s == null)
        {
            s1 = null;
        } else
        {
            int i = getPrefixLength(s);
            if (i < 0)
            {
                return null;
            }
            if (i >= s.length())
            {
                s1 = s;
                if (flag)
                {
                    return getPrefix(s);
                }
            } else
            {
                int j = indexOfLastSeparator(s);
                if (j < 0)
                {
                    return s.substring(0, i);
                }
                if (flag)
                {
                    i = 1;
                } else
                {
                    i = 0;
                }
                j += i;
                i = j;
                if (j == 0)
                {
                    i = j + 1;
                }
                return s.substring(0, i);
            }
        }
        return s1;
    }

    public static String getBaseName(String s)
    {
        return removeExtension(getName(s));
    }

    public static String getExtension(String s)
    {
        if (s == null)
        {
            return null;
        }
        int i = indexOfExtension(s);
        if (i == -1)
        {
            return "";
        } else
        {
            return s.substring(i + 1);
        }
    }

    public static String getFullPathNoEndSeparator(String s)
    {
        return doGetFullPath(s, false);
    }

    public static String getName(String s)
    {
        if (s == null)
        {
            return null;
        } else
        {
            return s.substring(indexOfLastSeparator(s) + 1);
        }
    }

    public static String getPrefix(String s)
    {
        int i;
        if (s != null)
        {
            if ((i = getPrefixLength(s)) >= 0)
            {
                if (i > s.length())
                {
                    return (new StringBuilder()).append(s).append('/').toString();
                } else
                {
                    return s.substring(0, i);
                }
            }
        }
        return null;
    }

    public static int getPrefixLength(String s)
    {
        byte byte0 = 1;
        if (s != null) goto _L2; else goto _L1
_L1:
        byte0 = -1;
_L4:
        return byte0;
_L2:
        char c;
        int k1;
        k1 = s.length();
        if (k1 == 0)
        {
            return 0;
        }
        c = s.charAt(0);
        if (c == ':')
        {
            return -1;
        }
        if (k1 != 1)
        {
            break; /* Loop/switch isn't completed */
        }
        if (c == '~')
        {
            return 2;
        }
        if (!isSeparator(c))
        {
            return 0;
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (c == '~')
        {
            int i1 = s.indexOf('/', 1);
            int k = s.indexOf('\\', 1);
            if (i1 == -1 && k == -1)
            {
                return k1 + 1;
            }
            int i = i1;
            if (i1 == -1)
            {
                i = k;
            }
            i1 = k;
            if (k == -1)
            {
                i1 = i;
            }
            return Math.min(i, i1) + 1;
        }
        char c1 = s.charAt(1);
        if (c1 == ':')
        {
            char c2 = Character.toUpperCase(c);
            if (c2 >= 'A' && c2 <= 'Z')
            {
                return k1 != 2 && isSeparator(s.charAt(2)) ? 3 : 2;
            } else
            {
                return -1;
            }
        }
        if (isSeparator(c) && isSeparator(c1))
        {
            int j1 = s.indexOf('/', 2);
            int l = s.indexOf('\\', 2);
            if (j1 == -1 && l == -1 || j1 == 2 || l == 2)
            {
                return -1;
            }
            int j = j1;
            if (j1 == -1)
            {
                j = l;
            }
            j1 = l;
            if (l == -1)
            {
                j1 = j;
            }
            return Math.min(j, j1) + 1;
        }
        if (!isSeparator(c))
        {
            return 0;
        }
        if (true) goto _L4; else goto _L5
_L5:
    }

    public static int indexOfExtension(String s)
    {
        if (s == null)
        {
            return -1;
        }
        int j = s.lastIndexOf('.');
        int i = j;
        if (indexOfLastSeparator(s) > j)
        {
            i = -1;
        }
        return i;
    }

    public static int indexOfLastSeparator(String s)
    {
        if (s == null)
        {
            return -1;
        } else
        {
            return Math.max(s.lastIndexOf('/'), s.lastIndexOf('\\'));
        }
    }

    private static boolean isSeparator(char c)
    {
        return c == '/' || c == '\\';
    }

    static boolean isSystemWindows()
    {
        return SYSTEM_SEPARATOR == '\\';
    }

    public static String removeExtension(String s)
    {
        String s1;
        if (s == null)
        {
            s1 = null;
        } else
        {
            int i = indexOfExtension(s);
            s1 = s;
            if (i != -1)
            {
                return s.substring(0, i);
            }
        }
        return s1;
    }

    static 
    {
        SYSTEM_SEPARATOR = File.separatorChar;
        if (isSystemWindows())
        {
            OTHER_SEPARATOR = '/';
        } else
        {
            OTHER_SEPARATOR = '\\';
        }
    }
}

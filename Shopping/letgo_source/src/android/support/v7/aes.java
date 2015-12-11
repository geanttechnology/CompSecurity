// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.lang.reflect.Field;

// Referenced classes of package android.support.v7:
//            aet

public abstract class aes extends Enum
    implements aet
{

    public static final aes a;
    public static final aes b;
    public static final aes c;
    public static final aes d;
    public static final aes e;
    private static final aes f[];

    private aes(String s, int i)
    {
        super(s, i);
    }


    private static String a(char c1, String s, int i)
    {
        if (i < s.length())
        {
            return (new StringBuilder()).append(c1).append(s.substring(i)).toString();
        } else
        {
            return String.valueOf(c1);
        }
    }

    static String a(String s)
    {
        return b(s);
    }

    static String a(String s, String s1)
    {
        return b(s, s1);
    }

    private static String b(String s)
    {
        char c1;
        StringBuilder stringbuilder;
        int i;
        stringbuilder = new StringBuilder();
        i = 0;
        c1 = s.charAt(0);
_L8:
        if (i < s.length() - 1 && !Character.isLetter(c1)) goto _L2; else goto _L1
_L1:
        if (i != s.length()) goto _L4; else goto _L3
_L3:
        String s1 = stringbuilder.toString();
_L6:
        return s1;
_L2:
        stringbuilder.append(c1);
        i++;
        c1 = s.charAt(i);
        continue; /* Loop/switch isn't completed */
_L4:
        s1 = s;
        if (Character.isUpperCase(c1)) goto _L6; else goto _L5
_L5:
        return stringbuilder.append(a(Character.toUpperCase(c1), s, i + 1)).toString();
        if (true) goto _L8; else goto _L7
_L7:
    }

    private static String b(String s, String s1)
    {
        StringBuilder stringbuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++)
        {
            char c1 = s.charAt(i);
            if (Character.isUpperCase(c1) && stringbuilder.length() != 0)
            {
                stringbuilder.append(s1);
            }
            stringbuilder.append(c1);
        }

        return stringbuilder.toString();
    }

    public static aes valueOf(String s)
    {
        return (aes)Enum.valueOf(android/support/v7/aes, s);
    }

    public static aes[] values()
    {
        return (aes[])f.clone();
    }

    static 
    {
        a = new aes("IDENTITY", 0) {

            public String a(Field field)
            {
                return field.getName();
            }

        };
        b = new aes("UPPER_CAMEL_CASE", 1) {

            public String a(Field field)
            {
                return aes.a(field.getName());
            }

        };
        c = new aes("UPPER_CAMEL_CASE_WITH_SPACES", 2) {

            public String a(Field field)
            {
                return aes.a(aes.a(field.getName(), " "));
            }

        };
        d = new aes("LOWER_CASE_WITH_UNDERSCORES", 3) {

            public String a(Field field)
            {
                return aes.a(field.getName(), "_").toLowerCase();
            }

        };
        e = new aes("LOWER_CASE_WITH_DASHES", 4) {

            public String a(Field field)
            {
                return aes.a(field.getName(), "-").toLowerCase();
            }

        };
        f = (new aes[] {
            a, b, c, d, e
        });
    }
}

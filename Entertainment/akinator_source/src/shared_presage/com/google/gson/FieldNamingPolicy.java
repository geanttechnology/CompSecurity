// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.gson;


// Referenced classes of package shared_presage.com.google.gson:
//            FieldNamingStrategy, b, c, d, 
//            e, f

public abstract class FieldNamingPolicy extends Enum
    implements FieldNamingStrategy
{

    private static final FieldNamingPolicy $VALUES[];
    public static final FieldNamingPolicy IDENTITY;
    public static final FieldNamingPolicy LOWER_CASE_WITH_DASHES;
    public static final FieldNamingPolicy LOWER_CASE_WITH_UNDERSCORES;
    public static final FieldNamingPolicy UPPER_CAMEL_CASE;
    public static final FieldNamingPolicy UPPER_CAMEL_CASE_WITH_SPACES;

    private FieldNamingPolicy(String s, int i)
    {
        super(s, i);
    }

    FieldNamingPolicy(String s, int i, b b1)
    {
        this(s, i);
    }

    private static String modifyString(char c1, String s, int i)
    {
        if (i < s.length())
        {
            return (new StringBuilder()).append(c1).append(s.substring(i)).toString();
        } else
        {
            return String.valueOf(c1);
        }
    }

    private static String separateCamelCase(String s, String s1)
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

    private static String upperCaseFirstLetter(String s)
    {
        int i = 0;
        StringBuilder stringbuilder = new StringBuilder();
        char c1;
        for (c1 = s.charAt(0); i < s.length() - 1 && !Character.isLetter(c1); c1 = s.charAt(i))
        {
            stringbuilder.append(c1);
            i++;
        }

        String s1;
        if (i == s.length())
        {
            s1 = stringbuilder.toString();
        } else
        {
            s1 = s;
            if (!Character.isUpperCase(c1))
            {
                return stringbuilder.append(modifyString(Character.toUpperCase(c1), s, i + 1)).toString();
            }
        }
        return s1;
    }

    public static FieldNamingPolicy valueOf(String s)
    {
        return (FieldNamingPolicy)Enum.valueOf(shared_presage/com/google/gson/FieldNamingPolicy, s);
    }

    public static FieldNamingPolicy[] values()
    {
        return (FieldNamingPolicy[])$VALUES.clone();
    }

    static 
    {
        IDENTITY = new b("IDENTITY");
        UPPER_CAMEL_CASE = new c("UPPER_CAMEL_CASE");
        UPPER_CAMEL_CASE_WITH_SPACES = new d("UPPER_CAMEL_CASE_WITH_SPACES");
        LOWER_CASE_WITH_UNDERSCORES = new e("LOWER_CASE_WITH_UNDERSCORES");
        LOWER_CASE_WITH_DASHES = new f("LOWER_CASE_WITH_DASHES");
        $VALUES = (new FieldNamingPolicy[] {
            IDENTITY, UPPER_CAMEL_CASE, UPPER_CAMEL_CASE_WITH_SPACES, LOWER_CASE_WITH_UNDERSCORES, LOWER_CASE_WITH_DASHES
        });
    }


}

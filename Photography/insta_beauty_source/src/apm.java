// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public class apm
{

    private static final char a[] = {
        '\u3131', '\u3132', '\u3134', '\u3137', '\u3138', '\u3139', '\u3141', '\u3142', '\u3143', '\u3145', 
        '\u3146', '\u3147', '\u3148', '\u3149', '\u314A', '\u314B', '\u314C', '\u314D', '\u314E'
    };

    private static boolean a(char c1)
    {
        return c1 >= '\uAC00' && c1 <= '\uD7A3';
    }

    public static boolean a(String s, String s1)
    {
_L2:
        return false;
        if (s == null || s1 == null || s1.length() > s.length()) goto _L2; else goto _L1
_L1:
        int i;
        int k;
        k = 0;
        i = 0;
_L8:
        if (!a(s.charAt(i)) || !b(s1.charAt(k))) goto _L4; else goto _L3
_L3:
        if (s1.charAt(k) != c(s.charAt(i))) goto _L6; else goto _L5
_L5:
        int j;
        i++;
        j = k + 1;
_L11:
        int l;
        l = j;
        if (i >= s.length())
        {
            break MISSING_BLOCK_LABEL_100;
        }
        k = j;
        if (j < s1.length()) goto _L8; else goto _L7
_L7:
        l = j;
_L10:
        if (l == s1.length())
        {
            return true;
        }
          goto _L2
_L6:
        l = k;
        if (k > 0) goto _L10; else goto _L9
_L9:
        i++;
        j = k;
          goto _L11
_L4:
label0:
        {
            if (s1.charAt(k) != s.charAt(i))
            {
                break label0;
            }
            i++;
            j = k + 1;
        }
          goto _L11
        l = k;
        if (k > 0) goto _L10; else goto _L12
_L12:
        i++;
        j = k;
          goto _L11
    }

    private static boolean b(char c1)
    {
        boolean flag1 = false;
        char ac[] = a;
        int j = ac.length;
        int i = 0;
        do
        {
label0:
            {
                boolean flag = flag1;
                if (i < j)
                {
                    if (c1 != ac[i])
                    {
                        break label0;
                    }
                    flag = true;
                }
                return flag;
            }
            i++;
        } while (true);
    }

    private static char c(char c1)
    {
        return a[(c1 - 44032) / 588];
    }

}

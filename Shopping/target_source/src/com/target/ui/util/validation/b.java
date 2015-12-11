// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.util.validation;

import android.content.Context;
import android.content.res.Resources;
import android.util.Patterns;
import android.widget.EditText;
import com.target.mothership.util.o;
import com.target.ui.util.validation.a.a;
import com.target.ui.util.validation.a.d;
import com.target.ui.util.validation.a.e;
import com.target.ui.util.validation.a.g;
import com.target.ui.util.validation.a.j;
import com.target.ui.util.validation.a.m;
import com.target.ui.view.CustomErrorViewWrapper;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package com.target.ui.util.validation:
//            h, g

public class b
{

    private static final int ADDRESS_LINE_MAX_LENGTH = 35;
    private static final int ADDRESS_LINE_MIN_LENGTH = 1;
    private static final String ADDRESS_LINE_SPECIAL_CHARACTERS = "- '.#,";
    private static final String ALLOWED_ADDRESS_LINE_CHARACTERS = (new StringBuilder()).append("- '.#,ABCDEFGHIJKLMNOPQRSTUVWXYZ").append("ABCDEFGHIJKLMNOPQRSTUVWXYZ".toLowerCase()).append("0123456789").toString();
    private static final String ALLOWED_CITY_CHARACTERS = (new StringBuilder()).append("- 'ABCDEFGHIJKLMNOPQRSTUVWXYZ").append("ABCDEFGHIJKLMNOPQRSTUVWXYZ".toLowerCase()).toString();
    private static final String ALLOWED_NAME_CHARACTERS = (new StringBuilder()).append("- '.ABCDEFGHIJKLMNOPQRSTUVWXYZ").append("ABCDEFGHIJKLMNOPQRSTUVWXYZ".toLowerCase()).toString();
    private static final String ALLOWED_PHONE_NUMBER_CHARACTERS = "- ()0123456789";
    private static final String ALLOWED_ZIP_CHARACTERS = "0123456789";
    private static final int APARTMENT_LINE_MAX_LENGTH = 35;
    private static final String CAPS_ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final int CITY_MAX_LENGTH = 35;
    private static final int CITY_MIN_LENGTH = 1;
    private static final String CITY_SPECIAL_CHARACTERS = "- '";
    private static final String DEFAULT_COUNTRY = "United States";
    private static final String DIGITS = "0123456789";
    private static final int EMAIL_GC_FROM_NAME_MAX_LENGTH = 19;
    private static final int EMAIL_GC_FROM_NAME_MIN_LENGTH = 1;
    private static final int EMAIL_GC_TO_NAME_MAX_LENGTH = 8;
    private static final int EMAIL_GC_TO_NAME_MIN_LENGTH = 1;
    private static final Pattern EMAIL_PATTERN;
    public static final int GIFT_CARD_LENGTH = 15;
    private static final int MOBILE_GC_FROM_NAME_MAX_LENGTH = 13;
    private static final int MOBILE_GC_FROM_NAME_MIN_LENGTH = 1;
    private static final int MOBILE_GC_TO_NAME_MAX_LENGTH = 14;
    private static final int MOBILE_GC_TO_NAME_MIN_LENGTH = 1;
    private static final String NAME_SPECIAL_CHARACTERS = "- '.";
    private static final String PHONE_NUMBER_COUNTRY_CODE = "1";
    private static final int PHONE_NUMBER_MAX_LENGTH = 10;
    private static final int PHONE_NUMBER_MIN_LENGTH = 1;
    private static final String PHONE_NUMBER_SPECIAL_CHARACTERS = "- ()";
    private static final int PHONE_NUMBER_WITH_COUNTRY_CODE_MAX_LENGTH = 11;
    private static final int STATE_CODE_LENGTH = 2;
    private static final int ZIP_MAX_LENGTH = 5;
    private static final int ZIP_MIN_LENGTH = 1;

    public static a a(String s)
    {
        boolean flag = com.target.ui.util.validation.h.a(s, 1);
        boolean flag1 = com.target.ui.util.validation.h.b(s, 35);
        boolean flag2 = o(s);
        boolean flag3 = com.target.ui.util.validation.h.c(s);
        ArrayList arraylist = new ArrayList(com.target.ui.util.validation.a.a.a.values().length);
        if (flag)
        {
            arraylist.add(com.target.ui.util.validation.a.a.a.TOO_SHORT);
        }
        if (flag1)
        {
            arraylist.add(com.target.ui.util.validation.a.a.a.TOO_LONG);
        }
        if (flag2)
        {
            arraylist.add(com.target.ui.util.validation.a.a.a.SPECIAL_CHAR_NOT_ALLOWED);
        }
        if (flag3)
        {
            arraylist.add(com.target.ui.util.validation.a.a.a.ONLY_SPACES);
        }
        return new a(s, arraylist.isEmpty(), arraylist);
    }

    public static e a(String s, int i1, int j1)
    {
        ArrayList arraylist;
        boolean flag;
        boolean flag1;
        boolean flag2;
        boolean flag3;
        boolean flag4;
        flag = com.target.mothership.util.o.c(s);
        flag1 = com.target.ui.util.validation.h.a(s, i1);
        flag2 = com.target.ui.util.validation.h.b(s, j1);
        flag3 = com.target.ui.util.validation.h.a(s);
        flag4 = com.target.ui.util.validation.h.c(s);
        arraylist = new ArrayList(com.target.ui.util.validation.a.e.a.values().length);
        if (!flag) goto _L2; else goto _L1
_L1:
        arraylist.add(com.target.ui.util.validation.a.e.a.EMPTY);
_L4:
        if (flag2)
        {
            arraylist.add(com.target.ui.util.validation.a.e.a.TOO_LONG);
        }
        if (flag3)
        {
            arraylist.add(com.target.ui.util.validation.a.e.a.SPECIAL_CHAR_NOT_ALLOWED);
        }
        if (flag4)
        {
            arraylist.add(com.target.ui.util.validation.a.e.a.ONLY_SPACES);
        }
        return new e(s, arraylist.isEmpty(), arraylist);
_L2:
        if (flag1)
        {
            arraylist.add(com.target.ui.util.validation.a.e.a.TOO_SHORT);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static void a(Context context, m m1, EditText edittext, CustomErrorViewWrapper customerrorviewwrapper)
    {
        if (com.target.ui.util.validation.g.a(m1, edittext, customerrorviewwrapper))
        {
            a(context, m1.reasons, customerrorviewwrapper);
            return;
        } else
        {
            customerrorviewwrapper.b();
            return;
        }
    }

    private static void a(Context context, List list, CustomErrorViewWrapper customerrorviewwrapper)
    {
        if (list != null && !list.isEmpty())
        {
            context = context.getResources();
            if (list.contains(com.target.ui.util.validation.a.m.a.TOO_SHORT) || list.contains(com.target.ui.util.validation.a.m.a.ONLY_SPACES))
            {
                customerrorviewwrapper.setErrorState(context.getString(0x7f0901f3));
                return;
            }
            if (list.contains(com.target.ui.util.validation.a.m.a.TOO_LONG))
            {
                customerrorviewwrapper.setErrorState(context.getString(0x7f0901f9));
                return;
            }
            if (list.contains(com.target.ui.util.validation.a.m.a.INVALID_LENGTH))
            {
                customerrorviewwrapper.setErrorState(context.getString(0x7f0901f8));
                return;
            }
            if (list.contains(com.target.ui.util.validation.a.m.a.SPECIAL_CHAR_NOT_ALLOWED))
            {
                customerrorviewwrapper.setErrorState(context.getString(0x7f0901fa));
                return;
            }
        }
    }

    public static boolean a(com.target.mothership.model.c.c.a a1)
    {
        return a1 != null && a1.c().b() && ((String)a1.c().c()).equalsIgnoreCase("United States");
    }

    public static com.target.ui.util.validation.a.b b(String s)
    {
        boolean flag = com.target.ui.util.validation.h.b(s, 35);
        boolean flag1 = o(s);
        ArrayList arraylist = new ArrayList(com.target.ui.util.validation.a.a.values().length);
        if (flag)
        {
            arraylist.add(com.target.ui.util.validation.a.a.TOO_LONG);
        }
        if (flag1)
        {
            arraylist.add(com.target.ui.util.validation.a.a.SPECIAL_CHAR_NOT_ALLOWED);
        }
        return new com.target.ui.util.validation.a.b(s, arraylist.isEmpty(), arraylist);
    }

    public static d c(String s)
    {
        boolean flag = com.target.ui.util.validation.h.a(s, 1);
        boolean flag1 = com.target.ui.util.validation.h.b(s, 35);
        boolean flag2 = p(s);
        boolean flag3 = com.target.ui.util.validation.h.c(s);
        ArrayList arraylist = new ArrayList(com.target.ui.util.validation.a.d.a.values().length);
        if (flag)
        {
            arraylist.add(com.target.ui.util.validation.a.d.a.TOO_SHORT);
        }
        if (flag1)
        {
            arraylist.add(com.target.ui.util.validation.a.d.a.TOO_LONG);
        }
        if (flag2)
        {
            arraylist.add(com.target.ui.util.validation.a.d.a.SPECIAL_CHAR_NOT_ALLOWED);
        }
        if (flag3)
        {
            arraylist.add(com.target.ui.util.validation.a.d.a.ONLY_SPACES);
        }
        return new d(s, arraylist.isEmpty(), arraylist);
    }

    public static j d(String s)
    {
        boolean flag = com.target.ui.util.validation.h.c(s, 2);
        ArrayList arraylist = new ArrayList(com.target.ui.util.validation.a.j.a.values().length);
        if (flag)
        {
            arraylist.add(com.target.ui.util.validation.a.j.a.STATE_INVALID);
        }
        return new j(s, arraylist.isEmpty(), arraylist);
    }

    public static m e(String s)
    {
        boolean flag = com.target.ui.util.validation.h.a(s, 1);
        boolean flag1 = com.target.ui.util.validation.h.b(s, 5);
        boolean flag2 = com.target.ui.util.validation.h.c(s, 5);
        boolean flag3 = q(s);
        boolean flag4 = com.target.ui.util.validation.h.c(s);
        ArrayList arraylist = new ArrayList(com.target.ui.util.validation.a.m.a.values().length);
        if (flag)
        {
            arraylist.add(com.target.ui.util.validation.a.m.a.TOO_SHORT);
        }
        if (flag1)
        {
            arraylist.add(com.target.ui.util.validation.a.m.a.TOO_LONG);
        }
        if (flag2)
        {
            arraylist.add(com.target.ui.util.validation.a.m.a.INVALID_LENGTH);
        }
        if (flag3)
        {
            arraylist.add(com.target.ui.util.validation.a.m.a.SPECIAL_CHAR_NOT_ALLOWED);
        }
        if (flag4)
        {
            arraylist.add(com.target.ui.util.validation.a.m.a.ONLY_SPACES);
        }
        return new m(s, arraylist.isEmpty(), arraylist);
    }

    public static g f(String s)
    {
        Object obj = com.target.ui.util.d.b.g(s);
        boolean flag = com.target.ui.util.validation.h.a(((String) (obj)), 1);
        boolean flag1 = g(((String) (obj)));
        boolean flag2 = h(((String) (obj)));
        boolean flag3 = r(((String) (obj)));
        boolean flag4 = com.target.ui.util.validation.h.c(((String) (obj)));
        obj = new ArrayList(com.target.ui.util.validation.a.g.a.values().length);
        if (flag)
        {
            ((List) (obj)).add(com.target.ui.util.validation.a.g.a.TOO_SHORT);
        }
        if (flag1)
        {
            ((List) (obj)).add(com.target.ui.util.validation.a.g.a.TOO_LONG);
        }
        if (flag2)
        {
            ((List) (obj)).add(com.target.ui.util.validation.a.g.a.INVALID_LENGTH);
        }
        if (flag3)
        {
            ((List) (obj)).add(com.target.ui.util.validation.a.g.a.SPECIAL_CHAR_NOT_ALLOWED);
        }
        if (flag4)
        {
            ((List) (obj)).add(com.target.ui.util.validation.a.g.a.ONLY_SPACES);
        }
        return new g(s, ((List) (obj)).isEmpty(), ((List) (obj)));
    }

    public static boolean g(String s)
    {
        boolean flag = true;
        if (!com.target.mothership.util.o.c(s)) goto _L2; else goto _L1
_L1:
        flag = false;
_L4:
        return flag;
_L2:
        if (!s.startsWith("1"))
        {
            continue; /* Loop/switch isn't completed */
        }
        if (s.length() > 11) goto _L4; else goto _L3
_L3:
        return false;
        if (s.length() > 10) goto _L4; else goto _L5
_L5:
        return false;
    }

    public static boolean h(String s)
    {
        boolean flag = true;
        if (!com.target.mothership.util.o.c(s)) goto _L2; else goto _L1
_L1:
        flag = false;
_L4:
        return flag;
_L2:
        if (!s.startsWith("1"))
        {
            continue; /* Loop/switch isn't completed */
        }
        if (s.length() != 11) goto _L4; else goto _L3
_L3:
        return false;
        if (s.length() != 10) goto _L4; else goto _L5
_L5:
        return false;
    }

    public static boolean i(String s)
    {
        if (com.target.mothership.util.o.e(s))
        {
            return true;
        } else
        {
            return EMAIL_PATTERN.matcher(s).matches();
        }
    }

    public static e j(String s)
    {
        boolean flag = com.target.ui.util.validation.h.a(s, 1);
        boolean flag1 = com.target.ui.util.validation.h.b(s, 19);
        boolean flag2 = com.target.ui.util.validation.h.c(s);
        boolean flag3 = com.target.ui.util.validation.h.a(s);
        ArrayList arraylist = new ArrayList(com.target.ui.util.validation.a.e.a.values().length);
        if (flag)
        {
            arraylist.add(com.target.ui.util.validation.a.e.a.TOO_SHORT);
        }
        if (flag1)
        {
            arraylist.add(com.target.ui.util.validation.a.e.a.TOO_LONG);
        }
        if (flag2)
        {
            arraylist.add(com.target.ui.util.validation.a.e.a.ONLY_SPACES);
        }
        if (flag3)
        {
            arraylist.add(com.target.ui.util.validation.a.e.a.SPECIAL_CHAR_NOT_ALLOWED);
        }
        return new e(s, arraylist.isEmpty(), arraylist);
    }

    public static e k(String s)
    {
        boolean flag = com.target.ui.util.validation.h.a(s, 1);
        boolean flag1 = com.target.ui.util.validation.h.b(s, 8);
        boolean flag2 = com.target.ui.util.validation.h.c(s);
        boolean flag3 = com.target.ui.util.validation.h.a(s);
        ArrayList arraylist = new ArrayList(com.target.ui.util.validation.a.e.a.values().length);
        if (flag)
        {
            arraylist.add(com.target.ui.util.validation.a.e.a.TOO_SHORT);
        }
        if (flag1)
        {
            arraylist.add(com.target.ui.util.validation.a.e.a.TOO_LONG);
        }
        if (flag2)
        {
            arraylist.add(com.target.ui.util.validation.a.e.a.ONLY_SPACES);
        }
        if (flag3)
        {
            arraylist.add(com.target.ui.util.validation.a.e.a.SPECIAL_CHAR_NOT_ALLOWED);
        }
        return new e(s, arraylist.isEmpty(), arraylist);
    }

    public static e l(String s)
    {
        boolean flag = com.target.ui.util.validation.h.a(s, 1);
        boolean flag1 = com.target.ui.util.validation.h.b(s, 13);
        boolean flag2 = com.target.ui.util.validation.h.c(s);
        boolean flag3 = com.target.ui.util.validation.h.a(s);
        ArrayList arraylist = new ArrayList(com.target.ui.util.validation.a.e.a.values().length);
        if (flag)
        {
            arraylist.add(com.target.ui.util.validation.a.e.a.TOO_SHORT);
        }
        if (flag1)
        {
            arraylist.add(com.target.ui.util.validation.a.e.a.TOO_LONG);
        }
        if (flag2)
        {
            arraylist.add(com.target.ui.util.validation.a.e.a.ONLY_SPACES);
        }
        if (flag3)
        {
            arraylist.add(com.target.ui.util.validation.a.e.a.SPECIAL_CHAR_NOT_ALLOWED);
        }
        return new e(s, arraylist.isEmpty(), arraylist);
    }

    public static e m(String s)
    {
        boolean flag = com.target.ui.util.validation.h.a(s, 1);
        boolean flag1 = com.target.ui.util.validation.h.b(s, 14);
        boolean flag2 = com.target.ui.util.validation.h.c(s);
        boolean flag3 = com.target.ui.util.validation.h.a(s);
        ArrayList arraylist = new ArrayList(com.target.ui.util.validation.a.e.a.values().length);
        if (flag)
        {
            arraylist.add(com.target.ui.util.validation.a.e.a.TOO_SHORT);
        }
        if (flag1)
        {
            arraylist.add(com.target.ui.util.validation.a.e.a.TOO_LONG);
        }
        if (flag2)
        {
            arraylist.add(com.target.ui.util.validation.a.e.a.ONLY_SPACES);
        }
        if (flag3)
        {
            arraylist.add(com.target.ui.util.validation.a.e.a.SPECIAL_CHAR_NOT_ALLOWED);
        }
        return new e(s, arraylist.isEmpty(), arraylist);
    }

    public static boolean n(String s)
    {
        return com.target.mothership.util.o.g(s) && s.length() == 15;
    }

    private static boolean o(String s)
    {
        while (com.target.mothership.util.o.c(s) || com.target.ui.util.validation.h.a(s, ALLOWED_ADDRESS_LINE_CHARACTERS)) 
        {
            return false;
        }
        return true;
    }

    private static boolean p(String s)
    {
        while (com.target.mothership.util.o.c(s) || com.target.ui.util.validation.h.a(s, ALLOWED_CITY_CHARACTERS)) 
        {
            return false;
        }
        return true;
    }

    private static boolean q(String s)
    {
        while (com.target.mothership.util.o.c(s) || com.target.ui.util.validation.h.a(s, "0123456789")) 
        {
            return false;
        }
        return true;
    }

    private static boolean r(String s)
    {
        while (com.target.mothership.util.o.c(s) || com.target.ui.util.validation.h.a(s, "- ()0123456789")) 
        {
            return false;
        }
        return true;
    }

    static 
    {
        EMAIL_PATTERN = Patterns.EMAIL_ADDRESS;
    }
}

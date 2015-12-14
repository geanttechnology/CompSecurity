// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.perfectcorp.utility;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;

// Referenced classes of package com.perfectcorp.utility:
//            e

public class s
{

    private static final String a[][];
    private static final HashMap b;

    public static String a(String s1)
    {
        String s2;
        try
        {
            s2 = URLEncoder.encode(s1, "UTF-8");
        }
        catch (UnsupportedEncodingException unsupportedencodingexception)
        {
            e.e(new Object[] {
                "UTF-8 should always be supported", unsupportedencodingexception
            });
            throw new RuntimeException((new StringBuilder()).append("URLEncoder.encode() failed for ").append(s1).toString());
        }
        return s2;
    }

    static 
    {
        Object obj = {
            "&", "amp"
        };
        String as[] = {
            ">", "gt"
        };
        String as2[] = {
            "\240", "nbsp"
        };
        String as3[] = {
            "\243", "pound"
        };
        String as4[] = {
            "\244", "curren"
        };
        String as5[] = {
            "\245", "yen"
        };
        String as6[] = {
            "\246", "brvbar"
        };
        String as7[] = {
            "\251", "copy"
        };
        String as8[] = {
            "\252", "ordf"
        };
        String as9[] = {
            "\253", "laquo"
        };
        String as10[] = {
            "\254", "not"
        };
        String as11[] = {
            "\255", "shy"
        };
        String as12[] = {
            "\257", "macr"
        };
        String as13[] = {
            "\261", "plusmn"
        };
        String as14[] = {
            "\262", "sup2"
        };
        String as15[] = {
            "\264", "acute"
        };
        String as16[] = {
            "\265", "micro"
        };
        String as17[] = {
            "\267", "middot"
        };
        String as18[] = {
            "\270", "cedil"
        };
        String as19[] = {
            "\272", "ordm"
        };
        String as20[] = {
            "\275", "frac12"
        };
        String as21[] = {
            "\277", "iquest"
        };
        String as22[] = {
            "\300", "Agrave"
        };
        String as23[] = {
            "\301", "Aacute"
        };
        String as24[] = {
            "\302", "Acirc"
        };
        String as25[] = {
            "\303", "Atilde"
        };
        String as26[] = {
            "\304", "Auml"
        };
        String as27[] = {
            "\305", "Aring"
        };
        String as28[] = {
            "\307", "Ccedil"
        };
        String as29[] = {
            "\310", "Egrave"
        };
        String as30[] = {
            "\311", "Eacute"
        };
        String as31[] = {
            "\312", "Ecirc"
        };
        String as32[] = {
            "\313", "Euml"
        };
        String as33[] = {
            "\314", "Igrave"
        };
        String as34[] = {
            "\316", "Icirc"
        };
        String as35[] = {
            "\317", "Iuml"
        };
        String as36[] = {
            "\322", "Ograve"
        };
        String as37[] = {
            "\323", "Oacute"
        };
        String as38[] = {
            "\324", "Ocirc"
        };
        String as39[] = {
            "\325", "Otilde"
        };
        String as40[] = {
            "\326", "Ouml"
        };
        String as41[] = {
            "\330", "Oslash"
        };
        String as42[] = {
            "\331", "Ugrave"
        };
        String as43[] = {
            "\334", "Uuml"
        };
        String as44[] = {
            "\335", "Yacute"
        };
        String as45[] = {
            "\336", "THORN"
        };
        String as46[] = {
            "\337", "szlig"
        };
        String as47[] = {
            "\341", "aacute"
        };
        String as48[] = {
            "\342", "acirc"
        };
        String as49[] = {
            "\343", "atilde"
        };
        String as50[] = {
            "\346", "aelig"
        };
        String as51[] = {
            "\350", "egrave"
        };
        String as52[] = {
            "\351", "eacute"
        };
        String as53[] = {
            "\352", "ecirc"
        };
        String as54[] = {
            "\353", "euml"
        };
        String as55[] = {
            "\354", "igrave"
        };
        String as56[] = {
            "\356", "icirc"
        };
        String as57[] = {
            "\357", "iuml"
        };
        String as58[] = {
            "\360", "eth"
        };
        String as59[] = {
            "\361", "ntilde"
        };
        String as60[] = {
            "\362", "ograve"
        };
        String as61[] = {
            "\363", "oacute"
        };
        String as62[] = {
            "\364", "ocirc"
        };
        String as63[] = {
            "\365", "otilde"
        };
        String as64[] = {
            "\367", "divide"
        };
        String as65[] = {
            "\370", "oslash"
        };
        String as66[] = {
            "\371", "ugrave"
        };
        String as67[] = {
            "\373", "ucirc"
        };
        String as68[] = {
            "\375", "yacute"
        };
        String as69[] = {
            "\377", "yuml"
        };
        a = (new String[][] {
            new String[] {
                "\"", "quot"
            }, obj, new String[] {
                "<", "lt"
            }, as, as2, new String[] {
                "\241", "iexcl"
            }, new String[] {
                "\242", "cent"
            }, as3, as4, as5, as6, new String[] {
                "\247", "sect"
            }, new String[] {
                "\250", "uml"
            }, as7, as8, as9, as10, as11, new String[] {
                "\256", "reg"
            }, as12, new String[] {
                "\260", "deg"
            }, as13, as14, new String[] {
                "\263", "sup3"
            }, as15, as16, new String[] {
                "\266", "para"
            }, as17, as18, new String[] {
                "\271", "sup1"
            }, as19, new String[] {
                "\273", "raquo"
            }, new String[] {
                "\274", "frac14"
            }, as20, new String[] {
                "\276", "frac34"
            }, as21, as22, as23, as24, as25, as26, as27, new String[] {
                "\306", "AElig"
            }, as28, as29, as30, as31, as32, as33, new String[] {
                "\315", "Iacute"
            }, as34, as35, new String[] {
                "\320", "ETH"
            }, new String[] {
                "\321", "Ntilde"
            }, as36, as37, as38, as39, as40, new String[] {
                "\327", "times"
            }, as41, as42, new String[] {
                "\332", "Uacute"
            }, new String[] {
                "\333", "Ucirc"
            }, as43, as44, as45, as46, new String[] {
                "\340", "agrave"
            }, as47, as48, as49, new String[] {
                "\344", "auml"
            }, new String[] {
                "\345", "aring"
            }, as50, new String[] {
                "\347", "ccedil"
            }, as51, as52, as53, as54, as55, new String[] {
                "\355", "iacute"
            }, as56, as57, as58, as59, as60, as61, as62, as63, new String[] {
                "\366", "ouml"
            }, as64, as65, as66, new String[] {
                "\372", "uacute"
            }, as67, new String[] {
                "\374", "uuml"
            }, as68, new String[] {
                "\376", "thorn"
            }, as69
        });
        b = new HashMap();
        obj = a;
        int j = obj.length;
        for (int i = 0; i < j; i++)
        {
            String as1[] = obj[i];
            b.put(as1[1].toString(), as1[0]);
        }

    }
}

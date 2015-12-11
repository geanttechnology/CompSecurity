// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.lang3.text.translate;

import java.lang.reflect.Array;

public class EntityArrays
{

    private static final String APOS_ESCAPE[][] = {
        {
            "'", "&apos;"
        }
    };
    private static final String APOS_UNESCAPE[][] = invert(APOS_ESCAPE);
    private static final String BASIC_ESCAPE[][];
    private static final String BASIC_UNESCAPE[][];
    private static final String HTML40_EXTENDED_ESCAPE[][];
    private static final String HTML40_EXTENDED_UNESCAPE[][];
    private static final String ISO8859_1_ESCAPE[][] = {
        {
            "\240", "&nbsp;"
        }, {
            "\241", "&iexcl;"
        }, {
            "\242", "&cent;"
        }, {
            "\243", "&pound;"
        }, {
            "\244", "&curren;"
        }, {
            "\245", "&yen;"
        }, {
            "\246", "&brvbar;"
        }, {
            "\247", "&sect;"
        }, {
            "\250", "&uml;"
        }, {
            "\251", "&copy;"
        }, {
            "\252", "&ordf;"
        }, {
            "\253", "&laquo;"
        }, {
            "\254", "&not;"
        }, {
            "\255", "&shy;"
        }, {
            "\256", "&reg;"
        }, {
            "\257", "&macr;"
        }, {
            "\260", "&deg;"
        }, {
            "\261", "&plusmn;"
        }, {
            "\262", "&sup2;"
        }, {
            "\263", "&sup3;"
        }, {
            "\264", "&acute;"
        }, {
            "\265", "&micro;"
        }, {
            "\266", "&para;"
        }, {
            "\267", "&middot;"
        }, {
            "\270", "&cedil;"
        }, {
            "\271", "&sup1;"
        }, {
            "\272", "&ordm;"
        }, {
            "\273", "&raquo;"
        }, {
            "\274", "&frac14;"
        }, {
            "\275", "&frac12;"
        }, {
            "\276", "&frac34;"
        }, {
            "\277", "&iquest;"
        }, {
            "\300", "&Agrave;"
        }, {
            "\301", "&Aacute;"
        }, {
            "\302", "&Acirc;"
        }, {
            "\303", "&Atilde;"
        }, {
            "\304", "&Auml;"
        }, {
            "\305", "&Aring;"
        }, {
            "\306", "&AElig;"
        }, {
            "\307", "&Ccedil;"
        }, {
            "\310", "&Egrave;"
        }, {
            "\311", "&Eacute;"
        }, {
            "\312", "&Ecirc;"
        }, {
            "\313", "&Euml;"
        }, {
            "\314", "&Igrave;"
        }, {
            "\315", "&Iacute;"
        }, {
            "\316", "&Icirc;"
        }, {
            "\317", "&Iuml;"
        }, {
            "\320", "&ETH;"
        }, {
            "\321", "&Ntilde;"
        }, {
            "\322", "&Ograve;"
        }, {
            "\323", "&Oacute;"
        }, {
            "\324", "&Ocirc;"
        }, {
            "\325", "&Otilde;"
        }, {
            "\326", "&Ouml;"
        }, {
            "\327", "&times;"
        }, {
            "\330", "&Oslash;"
        }, {
            "\331", "&Ugrave;"
        }, {
            "\332", "&Uacute;"
        }, {
            "\333", "&Ucirc;"
        }, {
            "\334", "&Uuml;"
        }, {
            "\335", "&Yacute;"
        }, {
            "\336", "&THORN;"
        }, {
            "\337", "&szlig;"
        }, {
            "\340", "&agrave;"
        }, {
            "\341", "&aacute;"
        }, {
            "\342", "&acirc;"
        }, {
            "\343", "&atilde;"
        }, {
            "\344", "&auml;"
        }, {
            "\345", "&aring;"
        }, {
            "\346", "&aelig;"
        }, {
            "\347", "&ccedil;"
        }, {
            "\350", "&egrave;"
        }, {
            "\351", "&eacute;"
        }, {
            "\352", "&ecirc;"
        }, {
            "\353", "&euml;"
        }, {
            "\354", "&igrave;"
        }, {
            "\355", "&iacute;"
        }, {
            "\356", "&icirc;"
        }, {
            "\357", "&iuml;"
        }, {
            "\360", "&eth;"
        }, {
            "\361", "&ntilde;"
        }, {
            "\362", "&ograve;"
        }, {
            "\363", "&oacute;"
        }, {
            "\364", "&ocirc;"
        }, {
            "\365", "&otilde;"
        }, {
            "\366", "&ouml;"
        }, {
            "\367", "&divide;"
        }, {
            "\370", "&oslash;"
        }, {
            "\371", "&ugrave;"
        }, {
            "\372", "&uacute;"
        }, {
            "\373", "&ucirc;"
        }, {
            "\374", "&uuml;"
        }, {
            "\375", "&yacute;"
        }, {
            "\376", "&thorn;"
        }, {
            "\377", "&yuml;"
        }
    };
    private static final String ISO8859_1_UNESCAPE[][] = invert(ISO8859_1_ESCAPE);
    private static final String JAVA_CTRL_CHARS_ESCAPE[][] = {
        {
            "\b", "\\b"
        }, {
            "\n", "\\n"
        }, {
            "\t", "\\t"
        }, {
            "\f", "\\f"
        }, {
            "\r", "\\r"
        }
    };
    private static final String JAVA_CTRL_CHARS_UNESCAPE[][] = invert(JAVA_CTRL_CHARS_ESCAPE);

    public EntityArrays()
    {
    }

    public static String[][] APOS_ESCAPE()
    {
        return (String[][])APOS_ESCAPE.clone();
    }

    public static String[][] APOS_UNESCAPE()
    {
        return (String[][])APOS_UNESCAPE.clone();
    }

    public static String[][] BASIC_ESCAPE()
    {
        return (String[][])BASIC_ESCAPE.clone();
    }

    public static String[][] BASIC_UNESCAPE()
    {
        return (String[][])BASIC_UNESCAPE.clone();
    }

    public static String[][] HTML40_EXTENDED_ESCAPE()
    {
        return (String[][])HTML40_EXTENDED_ESCAPE.clone();
    }

    public static String[][] HTML40_EXTENDED_UNESCAPE()
    {
        return (String[][])HTML40_EXTENDED_UNESCAPE.clone();
    }

    public static String[][] ISO8859_1_ESCAPE()
    {
        return (String[][])ISO8859_1_ESCAPE.clone();
    }

    public static String[][] ISO8859_1_UNESCAPE()
    {
        return (String[][])ISO8859_1_UNESCAPE.clone();
    }

    public static String[][] JAVA_CTRL_CHARS_ESCAPE()
    {
        return (String[][])JAVA_CTRL_CHARS_ESCAPE.clone();
    }

    public static String[][] JAVA_CTRL_CHARS_UNESCAPE()
    {
        return (String[][])JAVA_CTRL_CHARS_UNESCAPE.clone();
    }

    public static String[][] invert(String as[][])
    {
        String as1[][] = (String[][])Array.newInstance(java/lang/String, new int[] {
            as.length, 2
        });
        for (int i = 0; i < as.length; i++)
        {
            as1[i][0] = as[i][1];
            as1[i][1] = as[i][0];
        }

        return as1;
    }

    static 
    {
        String as[] = {
            "\u0392", "&Beta;"
        };
        String as1[] = {
            "\u0393", "&Gamma;"
        };
        String as2[] = {
            "\u0395", "&Epsilon;"
        };
        String as3[] = {
            "\u0396", "&Zeta;"
        };
        String as4[] = {
            "\u0399", "&Iota;"
        };
        String as5[] = {
            "\u039D", "&Nu;"
        };
        String as6[] = {
            "\u039E", "&Xi;"
        };
        String as7[] = {
            "\u039F", "&Omicron;"
        };
        String as8[] = {
            "\u03A0", "&Pi;"
        };
        String as9[] = {
            "\u03A1", "&Rho;"
        };
        String as10[] = {
            "\u03A3", "&Sigma;"
        };
        String as11[] = {
            "\u03A7", "&Chi;"
        };
        String as12[] = {
            "\u03A8", "&Psi;"
        };
        String as13[] = {
            "\u03A9", "&Omega;"
        };
        String as14[] = {
            "\u03B1", "&alpha;"
        };
        String as15[] = {
            "\u03B3", "&gamma;"
        };
        String as16[] = {
            "\u03B4", "&delta;"
        };
        String as17[] = {
            "\u03B5", "&epsilon;"
        };
        String as18[] = {
            "\u03B7", "&eta;"
        };
        String as19[] = {
            "\u03B8", "&theta;"
        };
        String as20[] = {
            "\u03B9", "&iota;"
        };
        String as21[] = {
            "\u03BA", "&kappa;"
        };
        String as22[] = {
            "\u03BB", "&lambda;"
        };
        String as23[] = {
            "\u03BC", "&mu;"
        };
        String as24[] = {
            "\u03BD", "&nu;"
        };
        String as25[] = {
            "\u03BF", "&omicron;"
        };
        String as26[] = {
            "\u03C1", "&rho;"
        };
        String as27[] = {
            "\u03C5", "&upsilon;"
        };
        String as28[] = {
            "\u03C7", "&chi;"
        };
        String as29[] = {
            "\u03C8", "&psi;"
        };
        String as30[] = {
            "\u03C9", "&omega;"
        };
        String as31[] = {
            "\u03D1", "&thetasym;"
        };
        String as32[] = {
            "\u03D2", "&upsih;"
        };
        String as33[] = {
            "\u03D6", "&piv;"
        };
        String as34[] = {
            "\u2022", "&bull;"
        };
        String as35[] = {
            "\u2026", "&hellip;"
        };
        String as36[] = {
            "\u2032", "&prime;"
        };
        String as37[] = {
            "\u203E", "&oline;"
        };
        String as38[] = {
            "\u2044", "&frasl;"
        };
        String as39[] = {
            "\u2118", "&weierp;"
        };
        String as40[] = {
            "\u211C", "&real;"
        };
        String as41[] = {
            "\u2122", "&trade;"
        };
        String as42[] = {
            "\u2190", "&larr;"
        };
        String as43[] = {
            "\u2191", "&uarr;"
        };
        String as44[] = {
            "\u2192", "&rarr;"
        };
        String as45[] = {
            "\u2193", "&darr;"
        };
        String as46[] = {
            "\u21B5", "&crarr;"
        };
        String as47[] = {
            "\u21D0", "&lArr;"
        };
        String as48[] = {
            "\u21D1", "&uArr;"
        };
        String as49[] = {
            "\u21D2", "&rArr;"
        };
        String as50[] = {
            "\u21D3", "&dArr;"
        };
        String as51[] = {
            "\u21D4", "&hArr;"
        };
        String as52[] = {
            "\u2200", "&forall;"
        };
        String as53[] = {
            "\u2202", "&part;"
        };
        String as54[] = {
            "\u2203", "&exist;"
        };
        String as55[] = {
            "\u2208", "&isin;"
        };
        String as56[] = {
            "\u220F", "&prod;"
        };
        String as57[] = {
            "\u2212", "&minus;"
        };
        String as58[] = {
            "\u2217", "&lowast;"
        };
        String as59[] = {
            "\u221E", "&infin;"
        };
        String as60[] = {
            "\u2227", "&and;"
        };
        String as61[] = {
            "\u2229", "&cap;"
        };
        String as62[] = {
            "\u222B", "&int;"
        };
        String as63[] = {
            "\u2248", "&asymp;"
        };
        String as64[] = {
            "\u2260", "&ne;"
        };
        String as65[] = {
            "\u2261", "&equiv;"
        };
        String as66[] = {
            "\u2282", "&sub;"
        };
        String as67[] = {
            "\u2283", "&sup;"
        };
        String as68[] = {
            "\u2286", "&sube;"
        };
        String as69[] = {
            "\u2287", "&supe;"
        };
        String as70[] = {
            "\u2295", "&oplus;"
        };
        String as71[] = {
            "\u2297", "&otimes;"
        };
        String as72[] = {
            "\u22C5", "&sdot;"
        };
        String as73[] = {
            "\u2309", "&rceil;"
        };
        String as74[] = {
            "\u230A", "&lfloor;"
        };
        String as75[] = {
            "\u230B", "&rfloor;"
        };
        String as76[] = {
            "\u232A", "&rang;"
        };
        String as77[] = {
            "\u25CA", "&loz;"
        };
        String as78[] = {
            "\u2660", "&spades;"
        };
        String as79[] = {
            "\u2663", "&clubs;"
        };
        String as80[] = {
            "\u2665", "&hearts;"
        };
        String as81[] = {
            "\u2666", "&diams;"
        };
        String as82[] = {
            "\u0152", "&OElig;"
        };
        String as83[] = {
            "\u0153", "&oelig;"
        };
        String as84[] = {
            "\u0160", "&Scaron;"
        };
        String as85[] = {
            "\u0161", "&scaron;"
        };
        String as86[] = {
            "\u02C6", "&circ;"
        };
        String as87[] = {
            "\u02DC", "&tilde;"
        };
        String as88[] = {
            "\u2003", "&emsp;"
        };
        String as89[] = {
            "\u200C", "&zwnj;"
        };
        String as90[] = {
            "\u200E", "&lrm;"
        };
        String as91[] = {
            "\u200F", "&rlm;"
        };
        String as92[] = {
            "\u2014", "&mdash;"
        };
        String as93[] = {
            "\u2018", "&lsquo;"
        };
        String as94[] = {
            "\u2019", "&rsquo;"
        };
        String as95[] = {
            "\u201C", "&ldquo;"
        };
        String as96[] = {
            "\u2020", "&dagger;"
        };
        String as97[] = {
            "\u2021", "&Dagger;"
        };
        String as98[] = {
            "\u2030", "&permil;"
        };
        String as99[] = {
            "\u2039", "&lsaquo;"
        };
        String as100[] = {
            "\u20AC", "&euro;"
        };
        HTML40_EXTENDED_ESCAPE = (new String[][] {
            new String[] {
                "\u0192", "&fnof;"
            }, new String[] {
                "\u0391", "&Alpha;"
            }, as, as1, new String[] {
                "\u0394", "&Delta;"
            }, as2, as3, new String[] {
                "\u0397", "&Eta;"
            }, new String[] {
                "\u0398", "&Theta;"
            }, as4, new String[] {
                "\u039A", "&Kappa;"
            }, new String[] {
                "\u039B", "&Lambda;"
            }, new String[] {
                "\u039C", "&Mu;"
            }, as5, as6, as7, as8, as9, as10, new String[] {
                "\u03A4", "&Tau;"
            }, new String[] {
                "\u03A5", "&Upsilon;"
            }, new String[] {
                "\u03A6", "&Phi;"
            }, as11, as12, as13, as14, new String[] {
                "\u03B2", "&beta;"
            }, as15, as16, as17, new String[] {
                "\u03B6", "&zeta;"
            }, as18, as19, as20, as21, as22, as23, as24, new String[] {
                "\u03BE", "&xi;"
            }, as25, new String[] {
                "\u03C0", "&pi;"
            }, as26, new String[] {
                "\u03C2", "&sigmaf;"
            }, new String[] {
                "\u03C3", "&sigma;"
            }, new String[] {
                "\u03C4", "&tau;"
            }, as27, new String[] {
                "\u03C6", "&phi;"
            }, as28, as29, as30, as31, as32, as33, as34, as35, as36, new String[] {
                "\u2033", "&Prime;"
            }, as37, as38, as39, new String[] {
                "\u2111", "&image;"
            }, as40, as41, new String[] {
                "\u2135", "&alefsym;"
            }, as42, as43, as44, as45, new String[] {
                "\u2194", "&harr;"
            }, as46, as47, as48, as49, as50, as51, as52, as53, as54, new String[] {
                "\u2205", "&empty;"
            }, new String[] {
                "\u2207", "&nabla;"
            }, as55, new String[] {
                "\u2209", "&notin;"
            }, new String[] {
                "\u220B", "&ni;"
            }, as56, new String[] {
                "\u2211", "&sum;"
            }, as57, as58, new String[] {
                "\u221A", "&radic;"
            }, new String[] {
                "\u221D", "&prop;"
            }, as59, new String[] {
                "\u2220", "&ang;"
            }, as60, new String[] {
                "\u2228", "&or;"
            }, as61, new String[] {
                "\u222A", "&cup;"
            }, as62, new String[] {
                "\u2234", "&there4;"
            }, new String[] {
                "\u223C", "&sim;"
            }, new String[] {
                "\u2245", "&cong;"
            }, as63, as64, as65, new String[] {
                "\u2264", "&le;"
            }, new String[] {
                "\u2265", "&ge;"
            }, as66, as67, as68, as69, as70, as71, new String[] {
                "\u22A5", "&perp;"
            }, as72, new String[] {
                "\u2308", "&lceil;"
            }, as73, as74, as75, new String[] {
                "\u2329", "&lang;"
            }, as76, as77, as78, as79, as80, as81, as82, as83, as84, as85, new String[] {
                "\u0178", "&Yuml;"
            }, as86, as87, new String[] {
                "\u2002", "&ensp;"
            }, as88, new String[] {
                "\u2009", "&thinsp;"
            }, as89, new String[] {
                "\u200D", "&zwj;"
            }, as90, as91, new String[] {
                "\u2013", "&ndash;"
            }, as92, as93, as94, new String[] {
                "\u201A", "&sbquo;"
            }, as95, new String[] {
                "\u201D", "&rdquo;"
            }, new String[] {
                "\u201E", "&bdquo;"
            }, as96, as97, as98, as99, new String[] {
                "\u203A", "&rsaquo;"
            }, as100
        });
        HTML40_EXTENDED_UNESCAPE = invert(HTML40_EXTENDED_ESCAPE);
        as = (new String[] {
            "&", "&amp;"
        });
        as1 = (new String[] {
            ">", "&gt;"
        });
        BASIC_ESCAPE = (new String[][] {
            new String[] {
                "\"", "&quot;"
            }, as, new String[] {
                "<", "&lt;"
            }, as1
        });
        BASIC_UNESCAPE = invert(BASIC_ESCAPE);
    }
}

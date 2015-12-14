// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package twitter4j.internal.json;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import twitter4j.HashtagEntity;
import twitter4j.MediaEntity;
import twitter4j.URLEntity;
import twitter4j.UserMentionEntity;

// Referenced classes of package twitter4j.internal.json:
//            EntityIndex

final class HTMLEntity
{

    private static final Map entityEscapeMap;
    private static final Map escapeEntityMap;

    HTMLEntity()
    {
    }

    static String escape(String s)
    {
        s = new StringBuilder(s);
        escape(((StringBuilder) (s)));
        return s.toString();
    }

    static void escape(StringBuilder stringbuilder)
    {
        for (int i = 0; i < stringbuilder.length();)
        {
            String s = (String)entityEscapeMap.get(stringbuilder.substring(i, i + 1));
            if (s != null)
            {
                stringbuilder.replace(i, i + 1, s);
                i = s.length() + i;
            } else
            {
                i++;
            }
        }

    }

    static String unescape(String s)
    {
        String s1 = null;
        if (s != null)
        {
            s = new StringBuilder(s);
            unescape(((StringBuilder) (s)));
            s1 = s.toString();
        }
        return s1;
    }

    static void unescape(StringBuilder stringbuilder)
    {
        for (int i = 0; i < stringbuilder.length(); i++)
        {
            i = stringbuilder.indexOf("&", i);
            if (-1 == i)
            {
                break;
            }
            int j = stringbuilder.indexOf(";", i);
            if (-1 == j)
            {
                break;
            }
            String s = stringbuilder.substring(i, j + 1);
            s = (String)escapeEntityMap.get(s);
            if (s != null)
            {
                stringbuilder.replace(i, j + 1, s);
            }
        }

    }

    static String unescapeAndSlideEntityIncdices(String s, UserMentionEntity ausermentionentity[], URLEntity aurlentity[], HashtagEntity ahashtagentity[], MediaEntity amediaentity[])
    {
        char c;
        EntityIndex aentityindex[];
        int i;
        int j;
        int k;
        int l;
        int i1;
        if (ausermentionentity == null)
        {
            i = 0;
        } else
        {
            i = ausermentionentity.length;
        }
        if (aurlentity == null)
        {
            j = 0;
        } else
        {
            j = aurlentity.length;
        }
        if (ahashtagentity == null)
        {
            k = 0;
        } else
        {
            k = ahashtagentity.length;
        }
        if (amediaentity == null)
        {
            l = 0;
        } else
        {
            l = amediaentity.length;
        }
        aentityindex = new EntityIndex[l + (i + 0 + j + k)];
        j = 0;
        if (ausermentionentity != null)
        {
            System.arraycopy(ausermentionentity, 0, aentityindex, 0, ausermentionentity.length);
            j = ausermentionentity.length + 0;
        }
        i = j;
        if (aurlentity != null)
        {
            System.arraycopy(aurlentity, 0, aentityindex, j, aurlentity.length);
            i = j + aurlentity.length;
        }
        j = i;
        if (ahashtagentity != null)
        {
            System.arraycopy(ahashtagentity, 0, aentityindex, i, ahashtagentity.length);
            j = i + ahashtagentity.length;
        }
        if (amediaentity != null)
        {
            System.arraycopy(amediaentity, 0, aentityindex, j, amediaentity.length);
        }
        Arrays.sort(aentityindex);
        l = 1;
        j = 0;
        ausermentionentity = new StringBuilder(s.length());
        i = 0;
        if (i >= s.length())
        {
            break; /* Loop/switch isn't completed */
        }
        c = s.charAt(i);
        if (c == '&')
        {
            k = s.indexOf(";", i);
            if (-1 != k)
            {
                aurlentity = s.substring(i, k + 1);
                ahashtagentity = (String)escapeEntityMap.get(aurlentity);
                if (ahashtagentity != null)
                {
                    ausermentionentity.append(ahashtagentity);
                    i1 = 1 - aurlentity.length();
                    i = k;
                    k = i1;
                } else
                {
                    ausermentionentity.append(c);
                    k = 0;
                }
            } else
            {
                ausermentionentity.append(c);
                k = 0;
            }
        } else
        {
            ausermentionentity.append(c);
            k = 0;
        }
        if (j >= aentityindex.length)
        {
            break MISSING_BLOCK_LABEL_466;
        }
        if (l != 0)
        {
            if (aentityindex[j].getStart() != k + i)
            {
                break MISSING_BLOCK_LABEL_466;
            }
            aentityindex[j].setStart(ausermentionentity.length() - 1);
            k = 0;
        } else
        {
            if (aentityindex[j].getEnd() != k + i)
            {
                break MISSING_BLOCK_LABEL_466;
            }
            aentityindex[j].setEnd(ausermentionentity.length() - 1);
            j++;
            k = 1;
        }
_L4:
        i++;
        l = k;
        if (true) goto _L2; else goto _L1
_L2:
        break MISSING_BLOCK_LABEL_166;
_L1:
        if (j < aentityindex.length && aentityindex[j].getEnd() == s.length())
        {
            aentityindex[j].setEnd(ausermentionentity.length());
        }
        return ausermentionentity.toString();
        k = l;
        if (true) goto _L4; else goto _L3
_L3:
    }

    static 
    {
        entityEscapeMap = new HashMap();
        escapeEntityMap = new HashMap();
        String as1[] = {
            "&yen;", "&#165;", "\245"
        };
        String as2[] = {
            "&ordf;", "&#170;", "\252"
        };
        String as3[] = {
            "&frac14;", "&#188;", "\274"
        };
        String as4[] = {
            "&Aacute;", "&#193;", "\301"
        };
        String as5[] = {
            "&Acirc;", "&#194;", "\302"
        };
        String as6[] = {
            "&agrave;", "&#224;", "\340"
        };
        String as7[] = {
            "&aelig;", "&#230;", "\346"
        };
        String as8[] = {
            "&ecirc;", "&#234;", "\352"
        };
        String as9[] = {
            "&Theta;", "&#920;", "\u0398"
        };
        String as10[] = {
            "&Xi;", "&#926;", "\u039E"
        };
        String as11[] = {
            "&Rho;", "&#929;", "\u03A1"
        };
        String as12[] = {
            "&Phi;", "&#934;", "\u03A6"
        };
        String as13[] = {
            "&tau;", "&#964;", "\u03C4"
        };
        String as14[] = {
            "&uArr;", "&#8657;", "\u21D1"
        };
        String as15[] = {
            "&rArr;", "&#8658;", "\u21D2"
        };
        String as16[] = {
            "&sim;", "&#8764;", "\u223C"
        };
        String as17[] = {
            "&ge;", "&#8805;", "\u2265"
        };
        String as18[] = {
            "&sube;", "&#8838;", "\u2286"
        };
        String as19[] = {
            "&spades;", "&#9824;", "\u2660"
        };
        String as20[] = {
            "&thinsp;", "&#8201;", "\u2009"
        };
        String as21[] = {
            "&rlm;", "&#8207;", "\u200F"
        };
        for (int i = 0; i < 251; i++)
        {
            String as[] = (new String[][] {
                new String[] {
                    "&nbsp;", "&#160;", "\240"
                }, new String[] {
                    "&iexcl;", "&#161;", "\241"
                }, new String[] {
                    "&cent;", "&#162;", "\242"
                }, new String[] {
                    "&pound;", "&#163;", "\243"
                }, new String[] {
                    "&curren;", "&#164;", "\244"
                }, as1, new String[] {
                    "&brvbar;", "&#166;", "\246"
                }, new String[] {
                    "&sect;", "&#167;", "\247"
                }, new String[] {
                    "&uml;", "&#168;", "\250"
                }, new String[] {
                    "&copy;", "&#169;", "\251"
                }, as2, new String[] {
                    "&laquo;", "&#171;", "\253"
                }, new String[] {
                    "&not;", "&#172;", "\254"
                }, new String[] {
                    "&shy;", "&#173;", "\255"
                }, new String[] {
                    "&reg;", "&#174;", "\256"
                }, new String[] {
                    "&macr;", "&#175;", "\257"
                }, new String[] {
                    "&deg;", "&#176;", "\260"
                }, new String[] {
                    "&plusmn;", "&#177;", "\261"
                }, new String[] {
                    "&sup2;", "&#178;", "\262"
                }, new String[] {
                    "&sup3;", "&#179;", "\263"
                }, new String[] {
                    "&acute;", "&#180;", "\264"
                }, new String[] {
                    "&micro;", "&#181;", "\265"
                }, new String[] {
                    "&para;", "&#182;", "\266"
                }, new String[] {
                    "&middot;", "&#183;", "\267"
                }, new String[] {
                    "&cedil;", "&#184;", "\270"
                }, new String[] {
                    "&sup1;", "&#185;", "\271"
                }, new String[] {
                    "&ordm;", "&#186;", "\272"
                }, new String[] {
                    "&raquo;", "&#187;", "\273"
                }, as3, new String[] {
                    "&frac12;", "&#189;", "\275"
                }, new String[] {
                    "&frac34;", "&#190;", "\276"
                }, new String[] {
                    "&iquest;", "&#191;", "\277"
                }, new String[] {
                    "&Agrave;", "&#192;", "\300"
                }, as4, as5, new String[] {
                    "&Atilde;", "&#195;", "\303"
                }, new String[] {
                    "&Auml;", "&#196;", "\304"
                }, new String[] {
                    "&Aring;", "&#197;", "\305"
                }, new String[] {
                    "&AElig;", "&#198;", "\306"
                }, new String[] {
                    "&Ccedil;", "&#199;", "\307"
                }, new String[] {
                    "&Egrave;", "&#200;", "\310"
                }, new String[] {
                    "&Eacute;", "&#201;", "\311"
                }, new String[] {
                    "&Ecirc;", "&#202;", "\312"
                }, new String[] {
                    "&Euml;", "&#203;", "\313"
                }, new String[] {
                    "&Igrave;", "&#204;", "\314"
                }, new String[] {
                    "&Iacute;", "&#205;", "\315"
                }, new String[] {
                    "&Icirc;", "&#206;", "\316"
                }, new String[] {
                    "&Iuml;", "&#207;", "\317"
                }, new String[] {
                    "&ETH;", "&#208;", "\320"
                }, new String[] {
                    "&Ntilde;", "&#209;", "\321"
                }, new String[] {
                    "&Ograve;", "&#210;", "\322"
                }, new String[] {
                    "&Oacute;", "&#211;", "\323"
                }, new String[] {
                    "&Ocirc;", "&#212;", "\324"
                }, new String[] {
                    "&Otilde;", "&#213;", "\325"
                }, new String[] {
                    "&Ouml;", "&#214;", "\326"
                }, new String[] {
                    "&times;", "&#215;", "\327"
                }, new String[] {
                    "&Oslash;", "&#216;", "\330"
                }, new String[] {
                    "&Ugrave;", "&#217;", "\331"
                }, new String[] {
                    "&Uacute;", "&#218;", "\332"
                }, new String[] {
                    "&Ucirc;", "&#219;", "\333"
                }, new String[] {
                    "&Uuml;", "&#220;", "\334"
                }, new String[] {
                    "&Yacute;", "&#221;", "\335"
                }, new String[] {
                    "&THORN;", "&#222;", "\336"
                }, new String[] {
                    "&szlig;", "&#223;", "\337"
                }, as6, new String[] {
                    "&aacute;", "&#225;", "\341"
                }, new String[] {
                    "&acirc;", "&#226;", "\342"
                }, new String[] {
                    "&atilde;", "&#227;", "\343"
                }, new String[] {
                    "&auml;", "&#228;", "\344"
                }, new String[] {
                    "&aring;", "&#229;", "\345"
                }, as7, new String[] {
                    "&ccedil;", "&#231;", "\347"
                }, new String[] {
                    "&egrave;", "&#232;", "\350"
                }, new String[] {
                    "&eacute;", "&#233;", "\351"
                }, as8, new String[] {
                    "&euml;", "&#235;", "\353"
                }, new String[] {
                    "&igrave;", "&#236;", "\354"
                }, new String[] {
                    "&iacute;", "&#237;", "\355"
                }, new String[] {
                    "&icirc;", "&#238;", "\356"
                }, new String[] {
                    "&iuml;", "&#239;", "\357"
                }, new String[] {
                    "&eth;", "&#240;", "\360"
                }, new String[] {
                    "&ntilde;", "&#241;", "\361"
                }, new String[] {
                    "&ograve;", "&#242;", "\362"
                }, new String[] {
                    "&oacute;", "&#243;", "\363"
                }, new String[] {
                    "&ocirc;", "&#244;", "\364"
                }, new String[] {
                    "&otilde;", "&#245;", "\365"
                }, new String[] {
                    "&ouml;", "&#246;", "\366"
                }, new String[] {
                    "&divide;", "&#247;", "\367"
                }, new String[] {
                    "&oslash;", "&#248;", "\370"
                }, new String[] {
                    "&ugrave;", "&#249;", "\371"
                }, new String[] {
                    "&uacute;", "&#250;", "\372"
                }, new String[] {
                    "&ucirc;", "&#251;", "\373"
                }, new String[] {
                    "&uuml;", "&#252;", "\374"
                }, new String[] {
                    "&yacute;", "&#253;", "\375"
                }, new String[] {
                    "&thorn;", "&#254;", "\376"
                }, new String[] {
                    "&yuml;", "&#255;", "\377"
                }, new String[] {
                    "&fnof;", "&#402;", "\u0192"
                }, new String[] {
                    "&Alpha;", "&#913;", "\u0391"
                }, new String[] {
                    "&Beta;", "&#914;", "\u0392"
                }, new String[] {
                    "&Gamma;", "&#915;", "\u0393"
                }, new String[] {
                    "&Delta;", "&#916;", "\u0394"
                }, new String[] {
                    "&Epsilon;", "&#917;", "\u0395"
                }, new String[] {
                    "&Zeta;", "&#918;", "\u0396"
                }, new String[] {
                    "&Eta;", "&#919;", "\u0397"
                }, as9, new String[] {
                    "&Iota;", "&#921;", "\u0399"
                }, new String[] {
                    "&Kappa;", "&#922;", "\u039A"
                }, new String[] {
                    "&Lambda;", "&#923;", "\u039B"
                }, new String[] {
                    "&Mu;", "&#924;", "\u039C"
                }, new String[] {
                    "&Nu;", "&#925;", "\u039D"
                }, as10, new String[] {
                    "&Omicron;", "&#927;", "\u039F"
                }, new String[] {
                    "&Pi;", "&#928;", "\u03A0"
                }, as11, new String[] {
                    "&Sigma;", "&#931;", "\u03A3"
                }, new String[] {
                    "&Tau;", "&#932;", "\u03A4"
                }, new String[] {
                    "&Upsilon;", "&#933;", "\u03A5"
                }, as12, new String[] {
                    "&Chi;", "&#935;", "\u03A7"
                }, new String[] {
                    "&Psi;", "&#936;", "\u03A8"
                }, new String[] {
                    "&Omega;", "&#937;", "\u03A9"
                }, new String[] {
                    "&alpha;", "&#945;", "\u03B1"
                }, new String[] {
                    "&beta;", "&#946;", "\u03B2"
                }, new String[] {
                    "&gamma;", "&#947;", "\u03B3"
                }, new String[] {
                    "&delta;", "&#948;", "\u03B4"
                }, new String[] {
                    "&epsilon;", "&#949;", "\u03B5"
                }, new String[] {
                    "&zeta;", "&#950;", "\u03B6"
                }, new String[] {
                    "&eta;", "&#951;", "\u03B7"
                }, new String[] {
                    "&theta;", "&#952;", "\u03B8"
                }, new String[] {
                    "&iota;", "&#953;", "\u03B9"
                }, new String[] {
                    "&kappa;", "&#954;", "\u03BA"
                }, new String[] {
                    "&lambda;", "&#955;", "\u03BB"
                }, new String[] {
                    "&mu;", "&#956;", "\u03BC"
                }, new String[] {
                    "&nu;", "&#957;", "\u03BD"
                }, new String[] {
                    "&xi;", "&#958;", "\u03BE"
                }, new String[] {
                    "&omicron;", "&#959;", "\u03BF"
                }, new String[] {
                    "&pi;", "&#960;", "\u03C0"
                }, new String[] {
                    "&rho;", "&#961;", "\u03C1"
                }, new String[] {
                    "&sigmaf;", "&#962;", "\u03C2"
                }, new String[] {
                    "&sigma;", "&#963;", "\u03C3"
                }, as13, new String[] {
                    "&upsilon;", "&#965;", "\u03C5"
                }, new String[] {
                    "&phi;", "&#966;", "\u03C6"
                }, new String[] {
                    "&chi;", "&#967;", "\u03C7"
                }, new String[] {
                    "&psi;", "&#968;", "\u03C8"
                }, new String[] {
                    "&omega;", "&#969;", "\u03C9"
                }, new String[] {
                    "&thetasym;", "&#977;", "\u03D1"
                }, new String[] {
                    "&upsih;", "&#978;", "\u03D2"
                }, new String[] {
                    "&piv;", "&#982;", "\u03D6"
                }, new String[] {
                    "&bull;", "&#8226;", "\u2022"
                }, new String[] {
                    "&hellip;", "&#8230;", "\u2026"
                }, new String[] {
                    "&prime;", "&#8242;", "\u2032"
                }, new String[] {
                    "&Prime;", "&#8243;", "\u2033"
                }, new String[] {
                    "&oline;", "&#8254;", "\u203E"
                }, new String[] {
                    "&frasl;", "&#8260;", "\u2044"
                }, new String[] {
                    "&weierp;", "&#8472;", "\u2118"
                }, new String[] {
                    "&image;", "&#8465;", "\u2111"
                }, new String[] {
                    "&real;", "&#8476;", "\u211C"
                }, new String[] {
                    "&trade;", "&#8482;", "\u2122"
                }, new String[] {
                    "&alefsym;", "&#8501;", "\u2135"
                }, new String[] {
                    "&larr;", "&#8592;", "\u2190"
                }, new String[] {
                    "&uarr;", "&#8593;", "\u2191"
                }, new String[] {
                    "&rarr;", "&#8594;", "\u2192"
                }, new String[] {
                    "&darr;", "&#8595;", "\u2193"
                }, new String[] {
                    "&harr;", "&#8596;", "\u2194"
                }, new String[] {
                    "&crarr;", "&#8629;", "\u21B5"
                }, new String[] {
                    "&lArr;", "&#8656;", "\u21D0"
                }, as14, as15, new String[] {
                    "&dArr;", "&#8659;", "\u21D3"
                }, new String[] {
                    "&hArr;", "&#8660;", "\u21D4"
                }, new String[] {
                    "&forall;", "&#8704;", "\u2200"
                }, new String[] {
                    "&part;", "&#8706;", "\u2202"
                }, new String[] {
                    "&exist;", "&#8707;", "\u2203"
                }, new String[] {
                    "&empty;", "&#8709;", "\u2205"
                }, new String[] {
                    "&nabla;", "&#8711;", "\u2207"
                }, new String[] {
                    "&isin;", "&#8712;", "\u2208"
                }, new String[] {
                    "&notin;", "&#8713;", "\u2209"
                }, new String[] {
                    "&ni;", "&#8715;", "\u220B"
                }, new String[] {
                    "&prod;", "&#8719;", "\u220F"
                }, new String[] {
                    "&sum;", "&#8721;", "\u2211"
                }, new String[] {
                    "&minus;", "&#8722;", "\u2212"
                }, new String[] {
                    "&lowast;", "&#8727;", "\u2217"
                }, new String[] {
                    "&radic;", "&#8730;", "\u221A"
                }, new String[] {
                    "&prop;", "&#8733;", "\u221D"
                }, new String[] {
                    "&infin;", "&#8734;", "\u221E"
                }, new String[] {
                    "&ang;", "&#8736;", "\u2220"
                }, new String[] {
                    "&and;", "&#8743;", "\u2227"
                }, new String[] {
                    "&or;", "&#8744;", "\u2228"
                }, new String[] {
                    "&cap;", "&#8745;", "\u2229"
                }, new String[] {
                    "&cup;", "&#8746;", "\u222A"
                }, new String[] {
                    "&int;", "&#8747;", "\u222B"
                }, new String[] {
                    "&there4;", "&#8756;", "\u2234"
                }, as16, new String[] {
                    "&cong;", "&#8773;", "\u2245"
                }, new String[] {
                    "&asymp;", "&#8776;", "\u2248"
                }, new String[] {
                    "&ne;", "&#8800;", "\u2260"
                }, new String[] {
                    "&equiv;", "&#8801;", "\u2261"
                }, new String[] {
                    "&le;", "&#8804;", "\u2264"
                }, as17, new String[] {
                    "&sub;", "&#8834;", "\u2282"
                }, new String[] {
                    "&sup;", "&#8835;", "\u2283"
                }, as18, new String[] {
                    "&supe;", "&#8839;", "\u2287"
                }, new String[] {
                    "&oplus;", "&#8853;", "\u2295"
                }, new String[] {
                    "&otimes;", "&#8855;", "\u2297"
                }, new String[] {
                    "&perp;", "&#8869;", "\u22A5"
                }, new String[] {
                    "&sdot;", "&#8901;", "\u22C5"
                }, new String[] {
                    "&lceil;", "&#8968;", "\u2308"
                }, new String[] {
                    "&rceil;", "&#8969;", "\u2309"
                }, new String[] {
                    "&lfloor;", "&#8970;", "\u230A"
                }, new String[] {
                    "&rfloor;", "&#8971;", "\u230B"
                }, new String[] {
                    "&lang;", "&#9001;", "\u2329"
                }, new String[] {
                    "&rang;", "&#9002;", "\u232A"
                }, new String[] {
                    "&loz;", "&#9674;", "\u25CA"
                }, as19, new String[] {
                    "&clubs;", "&#9827;", "\u2663"
                }, new String[] {
                    "&hearts;", "&#9829;", "\u2665"
                }, new String[] {
                    "&diams;", "&#9830;", "\u2666"
                }, new String[] {
                    "&quot;", "&#34;", "\""
                }, new String[] {
                    "&amp;", "&#38;", "&"
                }, new String[] {
                    "&lt;", "&#60;", "<"
                }, new String[] {
                    "&gt;", "&#62;", ">"
                }, new String[] {
                    "&OElig;", "&#338;", "\u0152"
                }, new String[] {
                    "&oelig;", "&#339;", "\u0153"
                }, new String[] {
                    "&Scaron;", "&#352;", "\u0160"
                }, new String[] {
                    "&scaron;", "&#353;", "\u0161"
                }, new String[] {
                    "&Yuml;", "&#376;", "\u0178"
                }, new String[] {
                    "&circ;", "&#710;", "\u02C6"
                }, new String[] {
                    "&tilde;", "&#732;", "\u02DC"
                }, new String[] {
                    "&ensp;", "&#8194;", "\u2002"
                }, new String[] {
                    "&emsp;", "&#8195;", "\u2003"
                }, as20, new String[] {
                    "&zwnj;", "&#8204;", "\u200C"
                }, new String[] {
                    "&zwj;", "&#8205;", "\u200D"
                }, new String[] {
                    "&lrm;", "&#8206;", "\u200E"
                }, as21, new String[] {
                    "&ndash;", "&#8211;", "\u2013"
                }, new String[] {
                    "&mdash;", "&#8212;", "\u2014"
                }, new String[] {
                    "&lsquo;", "&#8216;", "\u2018"
                }, new String[] {
                    "&rsquo;", "&#8217;", "\u2019"
                }, new String[] {
                    "&sbquo;", "&#8218;", "\u201A"
                }, new String[] {
                    "&ldquo;", "&#8220;", "\u201C"
                }, new String[] {
                    "&rdquo;", "&#8221;", "\u201D"
                }, new String[] {
                    "&bdquo;", "&#8222;", "\u201E"
                }, new String[] {
                    "&dagger;", "&#8224;", "\u2020"
                }, new String[] {
                    "&Dagger;", "&#8225;", "\u2021"
                }, new String[] {
                    "&permil;", "&#8240;", "\u2030"
                }, new String[] {
                    "&lsaquo;", "&#8249;", "\u2039"
                }, new String[] {
                    "&rsaquo;", "&#8250;", "\u203A"
                }, new String[] {
                    "&euro;", "&#8364;", "\u20AC"
                }
            })[i];
            entityEscapeMap.put(as[2], as[0]);
            escapeEntityMap.put(as[0], as[2]);
            escapeEntityMap.put(as[1], as[2]);
        }

    }
}

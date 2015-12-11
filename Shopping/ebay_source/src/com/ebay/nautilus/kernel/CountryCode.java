// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.kernel;

import android.content.Context;
import android.telephony.TelephonyManager;
import java.util.Locale;

final class CountryCode
{

    CountryCode()
    {
    }

    public static String getCountry(Context context)
    {
label0:
        {
            String s = ((TelephonyManager)context.getSystemService("phone")).getNetworkCountryIso();
            if (s != null)
            {
                context = s;
                if (s.length() == 2)
                {
                    break label0;
                }
            }
            s = Locale.getDefault().getCountry();
            context = s;
            if (s != null)
            {
                context = s;
                if (s.length() != 2)
                {
                    context = null;
                }
            }
        }
        Object obj = context;
        if (context != null)
        {
            obj = context.toLowerCase(Locale.US);
        }
        return ((String) (obj));
    }

    public static String getCountryCallingCode(Context context)
    {
        Object obj = null;
        String s = getCountry(context);
        context = obj;
        if (s != null)
        {
            context = getCountryCallingCode(s);
        }
        return context;
    }

    private static String getCountryCallingCode(String s)
    {
        if (s != null && s.length() == 2)
        {
            s = s.toUpperCase(Locale.US);
            if ("AF".equals(s))
            {
                return "93";
            }
            if ("AL".equals(s))
            {
                return "355";
            }
            if ("DZ".equals(s))
            {
                return "213";
            }
            if ("AS".equals(s))
            {
                return "1684";
            }
            if ("AD".equals(s))
            {
                return "376";
            }
            if ("AO".equals(s))
            {
                return "244";
            }
            if ("AI".equals(s))
            {
                return "1264";
            }
            if ("AQ".equals(s))
            {
                return "672";
            }
            if ("AG".equals(s))
            {
                return "1268";
            }
            if ("AR".equals(s))
            {
                return "54";
            }
            if ("AM".equals(s))
            {
                return "374";
            }
            if ("AW".equals(s))
            {
                return "297";
            }
            if ("AU".equals(s))
            {
                return "61";
            }
            if ("AT".equals(s))
            {
                return "43";
            }
            if ("AZ".equals(s))
            {
                return "994";
            }
            if ("BS".equals(s))
            {
                return "1242";
            }
            if ("BH".equals(s))
            {
                return "973";
            }
            if ("BD".equals(s))
            {
                return "880";
            }
            if ("BB".equals(s))
            {
                return "1246";
            }
            if ("BY".equals(s))
            {
                return "375";
            }
            if ("BE".equals(s))
            {
                return "32";
            }
            if ("BZ".equals(s))
            {
                return "501";
            }
            if ("BJ".equals(s))
            {
                return "229";
            }
            if ("BM".equals(s))
            {
                return "1441";
            }
            if ("BT".equals(s))
            {
                return "975";
            }
            if ("BO".equals(s))
            {
                return "591";
            }
            if ("BA".equals(s))
            {
                return "387";
            }
            if ("BW".equals(s))
            {
                return "267";
            }
            if ("BR".equals(s))
            {
                return "55";
            }
            if ("VG".equals(s))
            {
                return "1284";
            }
            if ("BN".equals(s))
            {
                return "673";
            }
            if ("BG".equals(s))
            {
                return "359";
            }
            if ("BF".equals(s))
            {
                return "226";
            }
            if ("MM".equals(s))
            {
                return "95";
            }
            if ("BI".equals(s))
            {
                return "257";
            }
            if ("KH".equals(s))
            {
                return "855";
            }
            if ("CM".equals(s))
            {
                return "237";
            }
            if ("CA".equals(s))
            {
                return "1";
            }
            if ("CV".equals(s))
            {
                return "238";
            }
            if ("KY".equals(s))
            {
                return "1345";
            }
            if ("CF".equals(s))
            {
                return "236";
            }
            if ("TD".equals(s))
            {
                return "235";
            }
            if ("CL".equals(s))
            {
                return "56";
            }
            if ("CN".equals(s))
            {
                return "86";
            }
            if ("CX".equals(s))
            {
                return "61";
            }
            if ("CC".equals(s))
            {
                return "61";
            }
            if ("CO".equals(s))
            {
                return "57";
            }
            if ("KM".equals(s))
            {
                return "269";
            }
            if ("CG".equals(s))
            {
                return "242";
            }
            if ("CD".equals(s))
            {
                return "243";
            }
            if ("CK".equals(s))
            {
                return "682";
            }
            if ("CR".equals(s))
            {
                return "506";
            }
            if ("HR".equals(s))
            {
                return "385";
            }
            if ("CU".equals(s))
            {
                return "53";
            }
            if ("CY".equals(s))
            {
                return "357";
            }
            if ("CZ".equals(s))
            {
                return "420";
            }
            if ("DK".equals(s))
            {
                return "45";
            }
            if ("DJ".equals(s))
            {
                return "253";
            }
            if ("DM".equals(s))
            {
                return "1767";
            }
            if ("DO".equals(s))
            {
                return "1809";
            }
            if ("TL".equals(s))
            {
                return "670";
            }
            if ("EC".equals(s))
            {
                return "593";
            }
            if ("EG".equals(s))
            {
                return "20";
            }
            if ("SV".equals(s))
            {
                return "503";
            }
            if ("GQ".equals(s))
            {
                return "240";
            }
            if ("ER".equals(s))
            {
                return "291";
            }
            if ("EE".equals(s))
            {
                return "372";
            }
            if ("ET".equals(s))
            {
                return "251";
            }
            if ("FK".equals(s))
            {
                return "500";
            }
            if ("FO".equals(s))
            {
                return "298";
            }
            if ("FJ".equals(s))
            {
                return "679";
            }
            if ("FI".equals(s))
            {
                return "358";
            }
            if ("FR".equals(s))
            {
                return "33";
            }
            if ("PF".equals(s))
            {
                return "689";
            }
            if ("GA".equals(s))
            {
                return "241";
            }
            if ("GM".equals(s))
            {
                return "220";
            }
            if ("GE".equals(s))
            {
                return "995";
            }
            if ("DE".equals(s))
            {
                return "49";
            }
            if ("GH".equals(s))
            {
                return "233";
            }
            if ("GI".equals(s))
            {
                return "350";
            }
            if ("GR".equals(s))
            {
                return "30";
            }
            if ("GL".equals(s))
            {
                return "299";
            }
            if ("GD".equals(s))
            {
                return "1473";
            }
            if ("GU".equals(s))
            {
                return "1671";
            }
            if ("GT".equals(s))
            {
                return "502";
            }
            if ("GN".equals(s))
            {
                return "224";
            }
            if ("GW".equals(s))
            {
                return "245";
            }
            if ("GY".equals(s))
            {
                return "592";
            }
            if ("HT".equals(s))
            {
                return "509";
            }
            if ("HN".equals(s))
            {
                return "504";
            }
            if ("HK".equals(s))
            {
                return "852";
            }
            if ("HU".equals(s))
            {
                return "36";
            }
            if ("IS".equals(s))
            {
                return "354";
            }
            if ("IN".equals(s))
            {
                return "91";
            }
            if ("ID".equals(s))
            {
                return "62";
            }
            if ("IR".equals(s))
            {
                return "98";
            }
            if ("IQ".equals(s))
            {
                return "964";
            }
            if ("IE".equals(s))
            {
                return "353";
            }
            if ("IM".equals(s))
            {
                return "44";
            }
            if ("IL".equals(s))
            {
                return "972";
            }
            if ("IT".equals(s))
            {
                return "39";
            }
            if ("CI".equals(s))
            {
                return "225";
            }
            if ("JM".equals(s))
            {
                return "1876";
            }
            if ("JP".equals(s))
            {
                return "81";
            }
            if ("JO".equals(s))
            {
                return "962";
            }
            if ("KZ".equals(s))
            {
                return "7";
            }
            if ("KE".equals(s))
            {
                return "254";
            }
            if ("KI".equals(s))
            {
                return "686";
            }
            if ("KW".equals(s))
            {
                return "965";
            }
            if ("KG".equals(s))
            {
                return "996";
            }
            if ("LA".equals(s))
            {
                return "856";
            }
            if ("LV".equals(s))
            {
                return "371";
            }
            if ("LB".equals(s))
            {
                return "961";
            }
            if ("LS".equals(s))
            {
                return "266";
            }
            if ("LR".equals(s))
            {
                return "231";
            }
            if ("LY".equals(s))
            {
                return "218";
            }
            if ("LI".equals(s))
            {
                return "423";
            }
            if ("LT".equals(s))
            {
                return "370";
            }
            if ("LU".equals(s))
            {
                return "352";
            }
            if ("MO".equals(s))
            {
                return "853";
            }
            if ("MK".equals(s))
            {
                return "389";
            }
            if ("MG".equals(s))
            {
                return "261";
            }
            if ("MW".equals(s))
            {
                return "265";
            }
            if ("MY".equals(s))
            {
                return "60";
            }
            if ("MV".equals(s))
            {
                return "960";
            }
            if ("ML".equals(s))
            {
                return "223";
            }
            if ("MT".equals(s))
            {
                return "356";
            }
            if ("MH".equals(s))
            {
                return "692";
            }
            if ("MR".equals(s))
            {
                return "222";
            }
            if ("MU".equals(s))
            {
                return "230";
            }
            if ("YT".equals(s))
            {
                return "262";
            }
            if ("MX".equals(s))
            {
                return "52";
            }
            if ("FM".equals(s))
            {
                return "691";
            }
            if ("MD".equals(s))
            {
                return "373";
            }
            if ("MC".equals(s))
            {
                return "377";
            }
            if ("MN".equals(s))
            {
                return "976";
            }
            if ("ME".equals(s))
            {
                return "382";
            }
            if ("MS".equals(s))
            {
                return "1664";
            }
            if ("MA".equals(s))
            {
                return "212";
            }
            if ("MZ".equals(s))
            {
                return "258";
            }
            if ("NA".equals(s))
            {
                return "264";
            }
            if ("NR".equals(s))
            {
                return "674";
            }
            if ("NP".equals(s))
            {
                return "977";
            }
            if ("NL".equals(s))
            {
                return "31";
            }
            if ("AN".equals(s))
            {
                return "599";
            }
            if ("NC".equals(s))
            {
                return "687";
            }
            if ("NZ".equals(s))
            {
                return "64";
            }
            if ("NI".equals(s))
            {
                return "505";
            }
            if ("NE".equals(s))
            {
                return "227";
            }
            if ("NG".equals(s))
            {
                return "234";
            }
            if ("NU".equals(s))
            {
                return "683";
            }
            if ("MP".equals(s))
            {
                return "1670";
            }
            if ("KP".equals(s))
            {
                return "850";
            }
            if ("NO".equals(s))
            {
                return "47";
            }
            if ("OM".equals(s))
            {
                return "968";
            }
            if ("PK".equals(s))
            {
                return "92";
            }
            if ("PW".equals(s))
            {
                return "680";
            }
            if ("PA".equals(s))
            {
                return "507";
            }
            if ("PG".equals(s))
            {
                return "675";
            }
            if ("PY".equals(s))
            {
                return "595";
            }
            if ("PE".equals(s))
            {
                return "51";
            }
            if ("PH".equals(s))
            {
                return "63";
            }
            if ("PN".equals(s))
            {
                return "870";
            }
            if ("PL".equals(s))
            {
                return "48";
            }
            if ("PT".equals(s))
            {
                return "351";
            }
            if ("PR".equals(s))
            {
                return "1";
            }
            if ("QA".equals(s))
            {
                return "974";
            }
            if ("RO".equals(s))
            {
                return "40";
            }
            if ("RU".equals(s))
            {
                return "7";
            }
            if ("RW".equals(s))
            {
                return "250";
            }
            if ("BL".equals(s))
            {
                return "590";
            }
            if ("WS".equals(s))
            {
                return "685";
            }
            if ("SM".equals(s))
            {
                return "378";
            }
            if ("ST".equals(s))
            {
                return "239";
            }
            if ("SA".equals(s))
            {
                return "966";
            }
            if ("SN".equals(s))
            {
                return "221";
            }
            if ("RS".equals(s))
            {
                return "381";
            }
            if ("SC".equals(s))
            {
                return "248";
            }
            if ("SL".equals(s))
            {
                return "232";
            }
            if ("SG".equals(s))
            {
                return "65";
            }
            if ("SK".equals(s))
            {
                return "421";
            }
            if ("SI".equals(s))
            {
                return "386";
            }
            if ("SB".equals(s))
            {
                return "677";
            }
            if ("SO".equals(s))
            {
                return "252";
            }
            if ("ZA".equals(s))
            {
                return "27";
            }
            if ("KR".equals(s))
            {
                return "82";
            }
            if ("ES".equals(s))
            {
                return "34";
            }
            if ("LK".equals(s))
            {
                return "94";
            }
            if ("SH".equals(s))
            {
                return "290";
            }
            if ("KN".equals(s))
            {
                return "1869";
            }
            if ("LC".equals(s))
            {
                return "1758";
            }
            if ("MF".equals(s))
            {
                return "1599";
            }
            if ("PM".equals(s))
            {
                return "508";
            }
            if ("VC".equals(s))
            {
                return "1784";
            }
            if ("SD".equals(s))
            {
                return "249";
            }
            if ("SR".equals(s))
            {
                return "597";
            }
            if ("SZ".equals(s))
            {
                return "268";
            }
            if ("SE".equals(s))
            {
                return "46";
            }
            if ("CH".equals(s))
            {
                return "41";
            }
            if ("SY".equals(s))
            {
                return "963";
            }
            if ("TW".equals(s))
            {
                return "886";
            }
            if ("TJ".equals(s))
            {
                return "992";
            }
            if ("TZ".equals(s))
            {
                return "255";
            }
            if ("TH".equals(s))
            {
                return "66";
            }
            if ("TG".equals(s))
            {
                return "228";
            }
            if ("TK".equals(s))
            {
                return "690";
            }
            if ("TO".equals(s))
            {
                return "676";
            }
            if ("TT".equals(s))
            {
                return "1868";
            }
            if ("TN".equals(s))
            {
                return "216";
            }
            if ("TR".equals(s))
            {
                return "90";
            }
            if ("TM".equals(s))
            {
                return "993";
            }
            if ("TC".equals(s))
            {
                return "1649";
            }
            if ("TV".equals(s))
            {
                return "688";
            }
            if ("AE".equals(s))
            {
                return "971";
            }
            if ("UG".equals(s))
            {
                return "256";
            }
            if ("GB".equals(s))
            {
                return "44";
            }
            if ("UA".equals(s))
            {
                return "380";
            }
            if ("UY".equals(s))
            {
                return "598";
            }
            if ("US".equals(s))
            {
                return "1";
            }
            if ("UZ".equals(s))
            {
                return "998";
            }
            if ("VU".equals(s))
            {
                return "678";
            }
            if ("VA".equals(s))
            {
                return "39";
            }
            if ("VE".equals(s))
            {
                return "58";
            }
            if ("VN".equals(s))
            {
                return "84";
            }
            if ("VI".equals(s))
            {
                return "1340";
            }
            if ("WF".equals(s))
            {
                return "681";
            }
            if ("YE".equals(s))
            {
                return "967";
            }
            if ("ZM".equals(s))
            {
                return "260";
            }
            if ("ZW".equals(s))
            {
                return "263";
            }
        }
        return null;
    }
}

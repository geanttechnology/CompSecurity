// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.attribute;

import java.util.HashMap;
import java.util.Map;

class ForeignLanguageStemming
{

    private static final Map foreignLanguageStemmingMap;

    ForeignLanguageStemming()
    {
    }

    public static String replaceForeignLanguageStemming(String s)
    {
        StringBuilder stringbuilder = new StringBuilder();
        int i = 0;
        while (i < s.length()) 
        {
            Character character = Character.valueOf(s.charAt(i));
            if (foreignLanguageStemmingMap.containsKey(character))
            {
                stringbuilder.append((String)foreignLanguageStemmingMap.get(character));
            } else
            {
                stringbuilder.append(character);
            }
            i++;
        }
        return stringbuilder.toString();
    }

    static 
    {
        foreignLanguageStemmingMap = new HashMap();
        foreignLanguageStemmingMap.put(Character.valueOf('\203'), "f");
        foreignLanguageStemmingMap.put(Character.valueOf('\212'), "S");
        foreignLanguageStemmingMap.put(Character.valueOf('\216'), "Z");
        foreignLanguageStemmingMap.put(Character.valueOf('\232'), "s");
        foreignLanguageStemmingMap.put(Character.valueOf('\236'), "z");
        foreignLanguageStemmingMap.put(Character.valueOf('\237'), "Y");
        foreignLanguageStemmingMap.put(Character.valueOf('\300'), "A");
        foreignLanguageStemmingMap.put(Character.valueOf('\301'), "A");
        foreignLanguageStemmingMap.put(Character.valueOf('\302'), "A");
        foreignLanguageStemmingMap.put(Character.valueOf('\303'), "A");
        foreignLanguageStemmingMap.put(Character.valueOf('\304'), "AE");
        foreignLanguageStemmingMap.put(Character.valueOf('\305'), "A");
        foreignLanguageStemmingMap.put(Character.valueOf('\307'), "C");
        foreignLanguageStemmingMap.put(Character.valueOf('\310'), "E");
        foreignLanguageStemmingMap.put(Character.valueOf('\311'), "E");
        foreignLanguageStemmingMap.put(Character.valueOf('\312'), "E");
        foreignLanguageStemmingMap.put(Character.valueOf('\313'), "E");
        foreignLanguageStemmingMap.put(Character.valueOf('\314'), "I");
        foreignLanguageStemmingMap.put(Character.valueOf('\315'), "I");
        foreignLanguageStemmingMap.put(Character.valueOf('\316'), "I");
        foreignLanguageStemmingMap.put(Character.valueOf('\317'), "I");
        foreignLanguageStemmingMap.put(Character.valueOf('\321'), "N");
        foreignLanguageStemmingMap.put(Character.valueOf('\322'), "O");
        foreignLanguageStemmingMap.put(Character.valueOf('\323'), "O");
        foreignLanguageStemmingMap.put(Character.valueOf('\324'), "O");
        foreignLanguageStemmingMap.put(Character.valueOf('\325'), "O");
        foreignLanguageStemmingMap.put(Character.valueOf('\326'), "OE");
        foreignLanguageStemmingMap.put(Character.valueOf('\331'), "U");
        foreignLanguageStemmingMap.put(Character.valueOf('\332'), "U");
        foreignLanguageStemmingMap.put(Character.valueOf('\333'), "U");
        foreignLanguageStemmingMap.put(Character.valueOf('\334'), "UE");
        foreignLanguageStemmingMap.put(Character.valueOf('\335'), "Y");
        foreignLanguageStemmingMap.put(Character.valueOf('\337'), "ss");
        foreignLanguageStemmingMap.put(Character.valueOf('\340'), "a");
        foreignLanguageStemmingMap.put(Character.valueOf('\341'), "a");
        foreignLanguageStemmingMap.put(Character.valueOf('\342'), "a");
        foreignLanguageStemmingMap.put(Character.valueOf('\343'), "a");
        foreignLanguageStemmingMap.put(Character.valueOf('\344'), "ae");
        foreignLanguageStemmingMap.put(Character.valueOf('\345'), "a");
        foreignLanguageStemmingMap.put(Character.valueOf('\347'), "c");
        foreignLanguageStemmingMap.put(Character.valueOf('\350'), "e");
        foreignLanguageStemmingMap.put(Character.valueOf('\351'), "e");
        foreignLanguageStemmingMap.put(Character.valueOf('\352'), "e");
        foreignLanguageStemmingMap.put(Character.valueOf('\353'), "e");
        foreignLanguageStemmingMap.put(Character.valueOf('\354'), "i");
        foreignLanguageStemmingMap.put(Character.valueOf('\355'), "i");
        foreignLanguageStemmingMap.put(Character.valueOf('\356'), "i");
        foreignLanguageStemmingMap.put(Character.valueOf('\357'), "i");
        foreignLanguageStemmingMap.put(Character.valueOf('\361'), "n");
        foreignLanguageStemmingMap.put(Character.valueOf('\362'), "o");
        foreignLanguageStemmingMap.put(Character.valueOf('\363'), "o");
        foreignLanguageStemmingMap.put(Character.valueOf('\364'), "o");
        foreignLanguageStemmingMap.put(Character.valueOf('\365'), "o");
        foreignLanguageStemmingMap.put(Character.valueOf('\366'), "oe");
        foreignLanguageStemmingMap.put(Character.valueOf('\371'), "u");
        foreignLanguageStemmingMap.put(Character.valueOf('\372'), "u");
        foreignLanguageStemmingMap.put(Character.valueOf('\373'), "u");
        foreignLanguageStemmingMap.put(Character.valueOf('\374'), "ue");
        foreignLanguageStemmingMap.put(Character.valueOf('\375'), "y");
        foreignLanguageStemmingMap.put(Character.valueOf('\377'), "y");
    }
}

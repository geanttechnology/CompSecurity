// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;

import android.text.TextUtils;
import com.ebay.nautilus.domain.EbaySite;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

// Referenced classes of package com.ebay.nautilus.domain.data:
//            BaseCommonType

public final class EnergyEfficiencyRating extends BaseCommonType
{

    private static final Map localeMap;
    public BaseCommonType.Text abbreviatedName;
    public BaseCommonType.Text name;
    public BaseCommonType.Text value;

    public EnergyEfficiencyRating(BaseCommonType.Text text, BaseCommonType.Text text1, BaseCommonType.Text text2)
    {
        name = text;
        abbreviatedName = text1;
        value = text2;
    }

    public static EnergyEfficiencyRating getInstanceForLangauge(String s)
    {
        Map map = localeMap;
        if (!localeMap.containsKey(s))
        {
            s = Locale.ENGLISH.getLanguage();
        }
        return (EnergyEfficiencyRating)map.get(s);
    }

    public static String getItemSpecificsValueKey(EbaySite ebaysite)
    {
        return getInstanceForLangauge(ebaysite.getLocale().getLanguage()).getName(false);
    }

    public String getDisplayString()
    {
        String s = getName(true);
        if (s == null)
        {
            return value.getSourceContent();
        } else
        {
            return (new StringBuilder()).append(s).append(": ").append(value.getSourceContent()).toString();
        }
    }

    public String getName(boolean flag)
    {
        if (flag && abbreviatedName != null && !TextUtils.isEmpty(abbreviatedName.getSourceContent()))
        {
            return abbreviatedName.getSourceContent();
        }
        if (name != null)
        {
            return name.getSourceContent();
        } else
        {
            return null;
        }
    }

    static 
    {
        HashMap hashmap = new HashMap();
        hashmap.put(Locale.GERMAN.getLanguage(), new EnergyEfficiencyRating(new BaseCommonType.Text("Energieeffizienzklasse"), new BaseCommonType.Text("EEK"), null));
        hashmap.put(Locale.ENGLISH.getLanguage(), new EnergyEfficiencyRating(new BaseCommonType.Text("Energy efficiency rating"), new BaseCommonType.Text("EER"), null));
        hashmap.put("es", new EnergyEfficiencyRating(new BaseCommonType.Text("Clasificaci\363n energ\351tica"), new BaseCommonType.Text("CE"), null));
        hashmap.put(Locale.FRENCH.getLanguage(), new EnergyEfficiencyRating(new BaseCommonType.Text("Classe Energ\351tique"), new BaseCommonType.Text("CE"), null));
        hashmap.put(Locale.ITALIAN.getLanguage(), new EnergyEfficiencyRating(new BaseCommonType.Text("Classe di efficienza energetica"), new BaseCommonType.Text("CE"), null));
        hashmap.put("nl", new EnergyEfficiencyRating(new BaseCommonType.Text("Energieklasse"), new BaseCommonType.Text("EK"), null));
        hashmap.put("pl", new EnergyEfficiencyRating(new BaseCommonType.Text("Klasa energetyczna"), new BaseCommonType.Text("Klasa"), null));
        hashmap.put("pt", new EnergyEfficiencyRating(new BaseCommonType.Text("Classe de efici\352ncia energ\351tica"), new BaseCommonType.Text("Classe"), null));
        hashmap.put("ru", new EnergyEfficiencyRating(new BaseCommonType.Text("\u041A\u043B\u0430\u0441\u0441 \u044D\u043D\u0435\u0440\u0433\u043E\u044D\u0444\u0444\u0435\u043A\u0442\u0438\u0432\u043D\u043E\u0441\u0442\u0438"), new BaseCommonType.Text("\u041A\u043B\u0430\u0441\u0441"), null));
        localeMap = Collections.unmodifiableMap(hashmap);
    }
}

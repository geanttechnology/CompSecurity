// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.network.ssl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class VinePins
{

    public static final String PINS[];
    public static final Map PIN_MAP;

    private VinePins()
    {
    }

    static 
    {
        PIN_MAP = new HashMap() {

            
            {
                put("VERISIGN_CLASS1", "2343d148a255899b947d461a797ec04cfed170b7");
                put("VERISIGN_CLASS3", "e27f7bd877d5df9e0a3f9eb4cb0e2ea9efdb6977");
                put("VERISIGN_CLASS3_G4", "ed663135d31bd4eca614c429e319069f94c12650");
                put("VERISIGN_CLASS4_G3", "3c03436868951cf3692ab8b426daba8fe922e5bd");
                put("VERISIGN_CLASS3_G3", "22f19e2ec6eaccfc5d2346f4c2e8f6c554dd5e07");
                put("VERISIGN_CLASS1_G3", "5519b278acb281d7eda7abc18399c3bb690424b5");
                put("VERISIGN_CLASS2_G3", "5abec575dcaef3b08e271943fc7f250c3df661e3");
                put("VERISIGN_CLASS3_G2", "1a21b4952b6293ce18b365ec9c0e934cb381e6d4");
                put("VERISIGN_CLASS2_G2", "1237ba4517eead2926fdc1cdfebeedf2ded9145c");
                put("VERISIGN_CLASS3_G5", "b181081a19a4c0941ffae89528c124c99b34acc7");
                put("VERISIGN_UNIVERSAL", "bbc23e290bb328771dad3ea24dbdf423bd06b03d");
                put("GEOTRUST_GLOBAL", "c07a98688d89fbab05640c117daa7d65b8cacc4e");
                put("GEOTRUST_GLOBAL2", "713836f2023153472b6eba6546a9101558200509");
                put("GEOTRUST_UNIVERAL", "87e85b6353c623a3128cb0ffbbf551fe59800e22");
                put("GEOTRUST_UNIVERSAL2", "5e4f538685dd4f9eca5fdc0d456f7d51b1dc9b7b");
                put("GEOTRUST_PRIMARY", "b01989e7effb4aafcb148f58463976224150e1ba");
                put("GEOTRUST_PRIMARY_G2", "bdbea71bab7157f9e475d954d2b727801a822682");
                put("GEOTRUST_PRIMARY_G3", "9ca98d00af740ddd8180d21345a58b8f2e9438d6");
                put("DIGICERT_GLOBAL_ROOT", "d52e13c1abe349dae8b49594ef7c3843606466bd");
                put("DIGICERT_EV_ROOT", "83317e62854253d6d7783190ec919056e991b9e3");
                put("DIGICERT_ASSUREDID_ROOT", "68330e61358521592983a3c8d2d2e1406e7ab3c1");
                put("TWITTER1", "56fef3c2147d4ed38837fdbd3052387201e5778d");
            }
        };
        PINS = (String[])PIN_MAP.values().toArray(new String[PIN_MAP.size()]);
    }
}

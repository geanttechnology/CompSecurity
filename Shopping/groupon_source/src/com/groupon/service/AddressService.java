// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service;

import android.content.SharedPreferences;
import com.groupon.db.models.Location;
import com.groupon.models.country.Country;
import com.groupon.models.dealbreakdown.DealBreakdownAddress;
import com.groupon.models.support.StaticSupportInfo;
import com.groupon.service.core.StaticSupportInfoService;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import com.groupon.util.ArrayUtil;
import java.util.ArrayList;
import roboguice.util.Strings;

public class AddressService
{

    private CurrentCountryManager currentCountryManager;
    private SharedPreferences prefs;
    private StaticSupportInfoService staticSupportInfoService;

    public AddressService()
    {
    }

    public String getAddressFromLocation(Location location)
    {
        if (location == null)
        {
            return "";
        }
        String s = location.streetAddress1;
        Object obj1 = location.postalCode;
        String s2 = location.city;
        String s1 = location.streetAddress2;
        if (currentCountryManager.getCurrentCountry().isUSACompatible())
        {
            return getFormattedAddress(s, s1, ((String) (obj1)), s2, location.state);
        }
        ArrayList arraylist = new ArrayList();
        ArrayList arraylist1 = new ArrayList();
        if (staticSupportInfoService.getSupportInfo(currentCountryManager.getCurrentCountry()).postalCodeAfterCity)
        {
            obj1 = (String[])ArrayUtil.toArray(new String[] {
                s2, obj1
            });
            int j1 = obj1.length;
            for (int i = 0; i < j1; i++)
            {
                s2 = obj1[i];
                if (Strings.notEmpty(s2))
                {
                    arraylist1.add(s2);
                }
            }

        } else
        {
            String as[] = (String[])ArrayUtil.toArray(new String[] {
                obj1, s2
            });
            int k1 = as.length;
            for (int j = 0; j < k1; j++)
            {
                String s3 = as[j];
                if (Strings.notEmpty(s3))
                {
                    arraylist1.add(s3);
                }
            }

        }
        location = location.streetNumber;
        if (staticSupportInfoService.getSupportInfo(currentCountryManager.getCurrentCountry()).numberBeforeStreet)
        {
            location = (String[])ArrayUtil.toArray(new String[] {
                Strings.join(" ", new String[] {
                    location, s
                }), s1, Strings.joinAnd(", ", " ", arraylist1)
            });
            int l1 = location.length;
            for (int k = 0; k < l1; k++)
            {
                s = location[k];
                if (Strings.notEmpty(s))
                {
                    arraylist.add(s);
                }
            }

        } else
        if (currentCountryManager.getCurrentCountry().usePostalCodeBeforeStreet())
        {
            location = (String[])ArrayUtil.toArray(new String[] {
                Strings.joinAnd(", ", " ", arraylist1), Strings.join(" ", new String[] {
                    s, location
                }), s1
            });
            int i2 = location.length;
            for (int l = 0; l < i2; l++)
            {
                s = location[l];
                if (Strings.notEmpty(s))
                {
                    arraylist.add(s);
                }
            }

        } else
        {
            location = (String[])ArrayUtil.toArray(new String[] {
                Strings.join(" ", new String[] {
                    s, location
                }), s1, Strings.joinAnd(", ", " ", arraylist1)
            });
            int j2 = location.length;
            for (int i1 = 0; i1 < j2; i1++)
            {
                Object obj = location[i1];
                if (Strings.notEmpty(obj))
                {
                    arraylist.add(obj);
                }
            }

        }
        return Strings.join("\n", arraylist);
    }

    public String getAddressFromLocation(DealBreakdownAddress dealbreakdownaddress)
    {
        if (dealbreakdownaddress == null)
        {
            return "";
        }
        String s = dealbreakdownaddress.streetAddress1;
        Object obj1 = dealbreakdownaddress.postalCode;
        String s2 = dealbreakdownaddress.city;
        String s1 = dealbreakdownaddress.streetAddress2;
        if (currentCountryManager.getCurrentCountry().isUSACompatible())
        {
            return getFormattedAddress(s, s1, ((String) (obj1)), s2, dealbreakdownaddress.state);
        }
        ArrayList arraylist = new ArrayList();
        ArrayList arraylist1 = new ArrayList();
        if (staticSupportInfoService.getSupportInfo(currentCountryManager.getCurrentCountry()).postalCodeAfterCity)
        {
            obj1 = (String[])ArrayUtil.toArray(new String[] {
                s2, obj1
            });
            int i1 = obj1.length;
            for (int i = 0; i < i1; i++)
            {
                s2 = obj1[i];
                if (Strings.notEmpty(s2))
                {
                    arraylist1.add(s2);
                }
            }

        } else
        {
            String as[] = (String[])ArrayUtil.toArray(new String[] {
                obj1, s2
            });
            int j1 = as.length;
            for (int j = 0; j < j1; j++)
            {
                String s3 = as[j];
                if (Strings.notEmpty(s3))
                {
                    arraylist1.add(s3);
                }
            }

        }
        dealbreakdownaddress = dealbreakdownaddress.streetNumber;
        if (staticSupportInfoService.getSupportInfo(currentCountryManager.getCurrentCountry()).numberBeforeStreet)
        {
            dealbreakdownaddress = (String[])ArrayUtil.toArray(new String[] {
                Strings.join(" ", new String[] {
                    dealbreakdownaddress, s
                }), s1, Strings.joinAnd(", ", " ", arraylist1)
            });
            int k1 = dealbreakdownaddress.length;
            for (int k = 0; k < k1; k++)
            {
                s = dealbreakdownaddress[k];
                if (Strings.notEmpty(s))
                {
                    arraylist.add(s);
                }
            }

        } else
        {
            dealbreakdownaddress = (String[])ArrayUtil.toArray(new String[] {
                Strings.join(" ", new String[] {
                    s, dealbreakdownaddress
                }), s1, Strings.joinAnd(", ", " ", arraylist1)
            });
            int l1 = dealbreakdownaddress.length;
            for (int l = 0; l < l1; l++)
            {
                Object obj = dealbreakdownaddress[l];
                if (Strings.notEmpty(obj))
                {
                    arraylist.add(obj);
                }
            }

        }
        return Strings.join("\n", arraylist);
    }

    public String getFormattedAddress(String s, String s1, String s2, String s3, String s4)
    {
        ArrayList arraylist = new ArrayList();
        ArrayList arraylist1 = new ArrayList();
        s2 = (String[])ArrayUtil.toArray(new String[] {
            s3, s4, s2
        });
        int k = s2.length;
        for (int i = 0; i < k; i++)
        {
            s3 = s2[i];
            if (Strings.notEmpty(s3))
            {
                arraylist1.add(s3);
            }
        }

        s = (String[])ArrayUtil.toArray(new String[] {
            s, s1, Strings.joinAnd(", ", " ", arraylist1)
        });
        k = s.length;
        for (int j = 0; j < k; j++)
        {
            s1 = s[j];
            if (Strings.notEmpty(s1))
            {
                arraylist.add(s1);
            }
        }

        return Strings.join("\n", arraylist);
    }

    public String getFormattedAddressFrom(DealBreakdownAddress dealbreakdownaddress)
    {
        String s8 = dealbreakdownaddress.shippingAddress1;
        String s = dealbreakdownaddress.shippingAddress2;
        String s9 = dealbreakdownaddress.address1;
        String s7 = dealbreakdownaddress.address2;
        String s1 = dealbreakdownaddress.shippingPostalCode;
        String s6 = dealbreakdownaddress.postalCode;
        String s2 = dealbreakdownaddress.shippingCity;
        String s5 = dealbreakdownaddress.city;
        String s3 = dealbreakdownaddress.shippingState;
        String s4 = dealbreakdownaddress.state;
        if (Strings.notEmpty(s8))
        {
            dealbreakdownaddress = s8;
        } else
        {
            dealbreakdownaddress = s9;
        }
        if (!Strings.notEmpty(s))
        {
            s = s7;
        }
        if (!Strings.notEmpty(s1))
        {
            s1 = s6;
        }
        if (!Strings.notEmpty(s2))
        {
            s2 = s5;
        }
        if (!Strings.notEmpty(s3))
        {
            s3 = s4;
        }
        return getFormattedAddress(dealbreakdownaddress, s, s1, s2, s3);
    }

    public String getFormattedAddressFromPrefsForUS()
    {
        return getFormattedAddress(prefs.getString("preferredShippingAddr1", ""), prefs.getString("preferredShippingAddr2", ""), prefs.getString("preferredShippingPostalCode", ""), prefs.getString("preferredShippingCity", ""), prefs.getString("preferredShippingState", ""));
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import android.content.res.Resources;
import android.location.Location;
import com.groupon.Channel;
import com.groupon.db.models.AbstractDeal;
import com.groupon.db.models.BusinessSummary;
import com.groupon.models.Place;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.util:
//            GeoPoint, GeoUtils

public class LocationsUtil
{

    private static final int MAX_MILES_TO_SHOW_DISTANCE_SEARCH_DEAL_CARD = 25;

    public LocationsUtil()
    {
    }

    public static Place findClosestPlace(List list, AbstractDeal abstractdeal, Double adouble[], GeoUtils geoutils)
    {
        Object obj;
label0:
        {
            java.util.ArrayList arraylist = null;
            Object obj1 = null;
            obj = arraylist;
            if (list == null)
            {
                break label0;
            }
            obj = arraylist;
            if (list.size() <= 0)
            {
                break label0;
            }
            arraylist = abstractdeal.derivedRedemptionLocations;
            Iterator iterator = list.iterator();
            list = obj1;
            do
            {
                obj = list;
                if (!iterator.hasNext())
                {
                    break label0;
                }
                obj = (Place)iterator.next();
                GeoPoint geopoint = new GeoPoint((int)(((Place) (obj)).lat * 1000000D), (int)(((Place) (obj)).lng * 1000000D));
                Iterator iterator1 = arraylist.iterator();
                abstractdeal = list;
                do
                {
                    list = abstractdeal;
                    if (!iterator1.hasNext())
                    {
                        break;
                    }
                    list = (GeoPoint)iterator1.next();
                    if (list.getLatitudeE6() != 0 && list.getLongitudeE6() != 0)
                    {
                        double d = geoutils.distanceBetween(geopoint, list);
                        if (d < adouble[0].doubleValue())
                        {
                            abstractdeal = ((AbstractDeal) (obj));
                            adouble[0] = Double.valueOf(d);
                        }
                    }
                } while (true);
            } while (true);
        }
        return ((Place) (obj));
    }

    public static String getLocation(boolean flag, boolean flag1, AbstractDeal abstractdeal, List list, Resources resources, GeoUtils geoutils, boolean flag2)
    {
        Object obj;
        String s;
        int i;
        Double adouble[] = new Double[1];
        adouble[0] = Double.valueOf(1.7976931348623157E+308D);
        Place place = findClosestPlace(list, abstractdeal, adouble, geoutils);
        s = abstractdeal.redemptionLocation;
        Object obj1;
        String s1;
        Double double1;
        if (abstractdeal.optionLocationCount > 0)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        list = "";
        s1 = "";
        double1 = adouble[0];
        obj1 = s1;
        obj = list;
        if (place != null)
        {
            double d = double1.doubleValue();
            int j;
            if (flag)
            {
                j = 40225;
            } else
            {
                j = 25;
            }
            obj1 = s1;
            obj = list;
            if (d < (double)j)
            {
                if (flag2)
                {
                    geoutils = geoutils.distanceBetweenAsString(double1.doubleValue());
                    obj = list;
                    list = geoutils;
                } else
                {
                    obj = resources.getString(0x7f0804f1, new Object[] {
                        geoutils.distanceBetweenAsString(double1.doubleValue())
                    });
                    list = s1;
                }
                abstractdeal.putAttr("ns:distanceAway", double1);
                obj1 = list;
            }
        }
        if (!flag1) goto _L2; else goto _L1
_L1:
        list = abstractdeal.area_name;
_L4:
        abstractdeal = list;
        if (flag2)
        {
            abstractdeal = list;
            if (Strings.notEmpty(obj1))
            {
                abstractdeal = resources.getString(0x7f0804ec, new Object[] {
                    list, obj1
                });
            }
        }
        return Strings.toString(abstractdeal);
_L2:
        if (!flag2)
        {
            list = ((List) (obj));
            if (flag2)
            {
                continue; /* Loop/switch isn't completed */
            }
            list = ((List) (obj));
            if (!Strings.isEmpty(obj))
            {
                continue; /* Loop/switch isn't completed */
            }
        }
        if (i == 0)
        {
            list = ((List) (obj));
            if (Strings.notEmpty(s))
            {
                list = ((List) (obj));
                if (!hasGoodsChannel(abstractdeal))
                {
                    list = s;
                }
            }
        } else
        if (i != 0 && abstractdeal.optionLocationCount > 1)
        {
            i = abstractdeal.optionLocationCount;
            try
            {
                list = resources.getQuantityString(0x7f0c0023, i, new Object[] {
                    Integer.valueOf(i)
                });
            }
            // Misplaced declaration of an exception variable
            catch (AbstractDeal abstractdeal)
            {
                list = resources.getString(0x7f080338, new Object[] {
                    Integer.valueOf(i)
                });
            }
        } else
        if (i != 0 && Strings.notEmpty(s))
        {
            list = s;
        } else
        {
            list = abstractdeal.derivedLocationName;
            if (!Strings.notEmpty(list))
            {
                list = abstractdeal.derivedLocationNeighborhood;
                if (!Strings.notEmpty(list))
                {
                    list = abstractdeal.derivedLocationCity;
                }
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static String getLocationForBusinessSummary(BusinessSummary businesssummary)
    {
        String s = businesssummary.city;
        String s1 = businesssummary.streetAddress1;
        if (Strings.notEmpty(s) && Strings.notEmpty(s1))
        {
            businesssummary = String.format("%s, %s", new Object[] {
                s1, s
            });
        } else
        {
            businesssummary = s;
            if (!Strings.notEmpty(s))
            {
                if (Strings.notEmpty(s1))
                {
                    return s1;
                } else
                {
                    return "";
                }
            }
        }
        return businesssummary;
    }

    protected static boolean hasGoodsChannel(AbstractDeal abstractdeal)
    {
        for (abstractdeal = abstractdeal.getChannelList().iterator(); abstractdeal.hasNext();)
        {
            Channel channel = (Channel)abstractdeal.next();
            if (Channel.GOODS == channel)
            {
                return true;
            }
        }

        return false;
    }

    public static boolean isPointContainedInPolygon(List list, Location location)
    {
        boolean flag3 = false;
        int k = list.size();
        int j = k - 1;
        int i = 0;
        while (i < k) 
        {
            boolean flag;
            boolean flag1;
            boolean flag2;
            if (((Location)list.get(i)).getLongitude() > location.getLongitude())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (((Location)list.get(j)).getLongitude() > location.getLongitude())
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            flag2 = flag3;
            if (flag != flag1)
            {
                flag2 = flag3;
                if (location.getLatitude() < ((((Location)list.get(j)).getLatitude() - ((Location)list.get(i)).getLatitude()) * (location.getLongitude() - ((Location)list.get(i)).getLongitude())) / (((Location)list.get(j)).getLongitude() - ((Location)list.get(i)).getLongitude()) + ((Location)list.get(i)).getLatitude())
                {
                    if (!flag3)
                    {
                        flag2 = true;
                    } else
                    {
                        flag2 = false;
                    }
                }
            }
            j = i;
            i++;
            flag3 = flag2;
        }
        return flag3;
    }
}

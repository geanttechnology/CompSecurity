// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.lds;

import android.text.TextUtils;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.data.EbayCategory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class ListingCategoryFilters
{

    private static final long AUTOMOTIVE_TOOLS_AND_SUPPLIES_CATEGORY = 34998L;
    private static final long DVDS_AND_MOVIES_CATEGORY = 11232L;
    private static final long FR_PETS = 0x2a3e6L;
    private static final long FR_PET_ACCESSORIES = 0x19a34L;
    private static final long MOTORS_CARS_AND_TRUCKS = 6001L;
    private static final long MOTORS_CATEGORY = 6000L;
    private static final long PARTS_AND_ACCESSORIES_CATEGORY = 6028L;
    private static final HashMap unsupportedCategoriesBySiteID;

    public ListingCategoryFilters()
    {
    }

    public static boolean categoryOkForNewListing(String s, String s1)
    {
        if (s1 == null || s1.length() == 0)
        {
            return false;
        }
        boolean flag1 = false;
        boolean flag = false;
        boolean flag2 = false;
        boolean flag3 = false;
        String as[] = s1.split(":");
        s1 = new ArrayList();
        int j = as.length;
        int i = 0;
        while (i < j) 
        {
            Object obj = as[i];
            boolean flag4;
            boolean flag5;
            boolean flag6;
            if (TextUtils.isEmpty(((CharSequence) (obj))))
            {
                flag6 = flag;
                flag5 = flag1;
                flag4 = flag2;
            } else
            {
                obj = Long.valueOf(Long.parseLong(((String) (obj))));
                s1.add(obj);
                if (((Long) (obj)).equals(Long.valueOf(6000L)))
                {
                    flag5 = true;
                    flag4 = flag2;
                    flag6 = flag;
                } else
                if (((Long) (obj)).equals(Long.valueOf(6028L)) || ((Long) (obj)).equals(Long.valueOf(34998L)))
                {
                    flag6 = true;
                    flag4 = flag2;
                    flag5 = flag1;
                } else
                if (((Long) (obj)).equals(Long.valueOf(0x2a3e6L)))
                {
                    flag4 = true;
                    flag5 = flag1;
                    flag6 = flag;
                } else
                {
                    flag4 = flag2;
                    flag5 = flag1;
                    flag6 = flag;
                    if (((Long) (obj)).equals(Long.valueOf(0x19a34L)))
                    {
                        flag3 = true;
                        flag4 = flag2;
                        flag5 = flag1;
                        flag6 = flag;
                    }
                }
            }
            i++;
            flag2 = flag4;
            flag1 = flag5;
            flag = flag6;
        }
        if (flag1 && !flag)
        {
            return false;
        }
        if (flag2 && !flag3)
        {
            return false;
        }
        s = (ArrayList)unsupportedCategoriesBySiteID.get(s);
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_345;
        }
        s = s.iterator();
_L2:
        Long long1;
        Iterator iterator;
        if (!s.hasNext())
        {
            break MISSING_BLOCK_LABEL_345;
        }
        long1 = (Long)s.next();
        iterator = s1.iterator();
_L4:
        if (!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        if (!long1.equals((Long)iterator.next())) goto _L4; else goto _L3
_L3:
        return false;
        return true;
    }

    public static boolean isCategorySupported(String s, Long long1, Long long2, boolean flag)
    {
label0:
        {
            if (long1 == null)
            {
                return false;
            }
            Object obj = (ArrayList)unsupportedCategoriesBySiteID.get(s);
            if (obj == null)
            {
                break label0;
            }
            obj = ((ArrayList) (obj)).iterator();
            do
            {
                if (!((Iterator) (obj)).hasNext())
                {
                    break label0;
                }
            } while (!((Long)((Iterator) (obj)).next()).equals(long1));
            return false;
        }
label1:
        {
            if (EbaySite.FR.id.equals(s) && long2 != null && long2.equals(Long.valueOf(0x2a3e6L)))
            {
                return long1.equals(Long.valueOf(0x19a34L));
            }
            if (!EbaySite.MOTOR.id.equals(s) && (!flag || !EbaySite.US.id.equals(s) || long2 == null || !long2.equals(Long.valueOf(6000L))))
            {
                break label1;
            }
            s = (ArrayList)unsupportedCategoriesBySiteID.get(EbaySite.MOTOR.id);
            if (s == null)
            {
                break label1;
            }
            s = s.iterator();
            do
            {
                if (!s.hasNext())
                {
                    break label1;
                }
            } while (!((Long)s.next()).equals(long1));
            return false;
        }
        return true;
    }

    public static boolean isMotorsCarsAndTrucks(String s)
    {
        if (TextUtils.isEmpty(s))
        {
            return false;
        } else
        {
            return s.startsWith("6000:6001");
        }
    }

    public static boolean isMotorsCategoryPath(String s)
    {
        if (!TextUtils.isEmpty(s))
        {
            if (s.contains(">"))
            {
                s = s.split(">");
            } else
            {
                s = s.split(":");
            }
            if (s.length != 0 && String.valueOf(6000L).equals(s[0].trim()))
            {
                return true;
            }
        }
        return false;
    }

    public static void updateList(String s, EbayCategory ebaycategory, ArrayList arraylist, boolean flag, String s1)
    {
        if (arraylist != null)
        {
            if (ebaycategory != null && arraylist.size() > 0)
            {
                arraylist.remove(0);
            }
            ArrayList arraylist1 = new ArrayList();
            Iterator iterator = arraylist.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                EbayCategory ebaycategory1 = (EbayCategory)iterator.next();
                if (ebaycategory1.expired || ebaycategory1.virtual)
                {
                    arraylist1.add(ebaycategory1);
                }
            } while (true);
            arraylist.removeAll(arraylist1);
            if (s.equals(EbaySite.US.id) && ebaycategory == null && flag)
            {
                int j = 0;
                for (int i = 0; i < arraylist.size(); i++)
                {
                    if (((EbayCategory)arraylist.get(i)).id == 11232L)
                    {
                        j = i;
                    }
                }

                s = new EbayCategory();
                s.id = 6000L;
                s.name = s1;
                if (j != 0)
                {
                    arraylist.add(j + 1, s);
                    return;
                } else
                {
                    arraylist.add(s);
                    return;
                }
            }
        }
    }

    static 
    {
        unsupportedCategoriesBySiteID = new HashMap();
        ArrayList arraylist = new ArrayList();
        arraylist.add(Long.valueOf(63676L));
        arraylist.add(Long.valueOf(26429L));
        arraylist.add(Long.valueOf(32633L));
        arraylist.add(Long.valueOf(32636L));
        arraylist.add(Long.valueOf(26435L));
        arraylist.add(Long.valueOf(0x24db8L));
        arraylist.add(Long.valueOf(0x29a64L));
        arraylist.add(Long.valueOf(0x2a092L));
        arraylist.add(Long.valueOf(0x2a093L));
        arraylist.add(Long.valueOf(0x2a094L));
        arraylist.add(Long.valueOf(0x2a095L));
        arraylist.add(Long.valueOf(29690L));
        arraylist.add(Long.valueOf(32073L));
        arraylist.add(Long.valueOf(6049L));
        arraylist.add(Long.valueOf(0x26a71L));
        arraylist.add(Long.valueOf(0x1ddc2L));
        arraylist.add(Long.valueOf(0x103a4L));
        arraylist.add(Long.valueOf(316L));
        arraylist.add(Long.valueOf(10542L));
        arraylist.add(Long.valueOf(0x29a64L));
        unsupportedCategoriesBySiteID.put(EbaySite.AU.id, arraylist);
        arraylist = new ArrayList();
        arraylist.add(Long.valueOf(9800L));
        arraylist.add(Long.valueOf(11730L));
        arraylist.add(Long.valueOf(0x25578L));
        arraylist.add(Long.valueOf(0x1828bL));
        arraylist.add(Long.valueOf(10542L));
        unsupportedCategoriesBySiteID.put(EbaySite.UK.id, arraylist);
        arraylist = new ArrayList();
        arraylist.add(Long.valueOf(2038L));
        arraylist.add(Long.valueOf(10542L));
        arraylist.add(Long.valueOf(319L));
        arraylist.add(Long.valueOf(10159L));
        arraylist.add(Long.valueOf(25558L));
        arraylist.add(Long.valueOf(47105L));
        unsupportedCategoriesBySiteID.put(EbaySite.US.id, arraylist);
        arraylist = new ArrayList();
        arraylist.add(Long.valueOf(0x23fe1L));
        arraylist.add(Long.valueOf(0x2a3ecL));
        unsupportedCategoriesBySiteID.put(EbaySite.FR.id, arraylist);
        arraylist = new ArrayList();
        arraylist.add(Long.valueOf(8480L));
        arraylist.add(Long.valueOf(9800L));
        arraylist.add(Long.valueOf(60089L));
        arraylist.add(Long.valueOf(19875L));
        unsupportedCategoriesBySiteID.put(EbaySite.DE.id, arraylist);
        arraylist = new ArrayList();
        arraylist.add(Long.valueOf(9800L));
        unsupportedCategoriesBySiteID.put(EbaySite.AT.id, arraylist);
        arraylist = new ArrayList();
        arraylist.add(Long.valueOf(6001L));
        arraylist.add(Long.valueOf(6024L));
        arraylist.add(Long.valueOf(6038L));
        arraylist.add(Long.valueOf(26429L));
        arraylist.add(Long.valueOf(0x103a2L));
        arraylist.add(Long.valueOf(0x292deL));
        unsupportedCategoriesBySiteID.put(EbaySite.MOTOR.id, arraylist);
    }
}

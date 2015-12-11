// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.controllers;

import android.content.Intent;
import com.poshmark.data_model.models.MetaItem;
import com.poshmark.notifications.PMNotificationListener;
import com.poshmark.utils.MetaItemList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package com.poshmark.controllers:
//            SharedPreferencesController

public class RecentBrandsController
    implements PMNotificationListener
{

    private static final String DEFAULT_RECENT_BRANDS[] = {
        "Tory Burch", "Michael Kors", "Coach", "Louis Vuitton", "Gucci", "kate spade", "J. Crew", "Steve Madden", "Juicy Couture", "Free People", 
        "lululemon athletica"
    };
    public static final String GLOBAL_RECENT_BRANDS = "global_recent_brands";
    private static final int GLOBAL_RECENT_ITEMS_SIZE = 30;
    public static final String RECENT_BRANDS = "recent_brands";
    public static final int RECENT_ITEMS_SIZE = 6;
    static RecentBrandsController recentBrandsStore = null;
    public MetaItemList globalRecentItems;
    public MetaItemList recentItems;
    SharedPreferencesController sharedPreferencesController;

    RecentBrandsController()
    {
        recentItems = retrieveRecentBrands(true);
        globalRecentItems = retrieveRecentBrands(false);
    }

    public static RecentBrandsController globalRecentBrandsController()
    {
        if (recentBrandsStore == null)
        {
            recentBrandsStore = new RecentBrandsController();
        }
        return recentBrandsStore;
    }

    public int actualGlobalItemCount()
    {
        IndexOutOfBoundsException indexoutofboundsexception;
        for (int i = 0; i < globalRecentItems.getLimit(); i++)
        {
            Object obj;
            try
            {
                obj = globalRecentItems.get(i);
            }
            // Misplaced declaration of an exception variable
            catch (IndexOutOfBoundsException indexoutofboundsexception)
            {
                return i;
            }
            if (obj == null)
            {
                return i + 1;
            }
        }

        return globalRecentItems.getLimit();
    }

    public int actualRecentItemCount()
    {
        IndexOutOfBoundsException indexoutofboundsexception;
        for (int i = 0; i < recentItems.getLimit(); i++)
        {
            Object obj;
            try
            {
                obj = recentItems.get(i);
            }
            // Misplaced declaration of an exception variable
            catch (IndexOutOfBoundsException indexoutofboundsexception)
            {
                return i;
            }
            if (obj == null)
            {
                return i + 1;
            }
        }

        return recentItems.getLimit();
    }

    public boolean addToGlobalBrands(MetaItem metaitem)
    {
        if (isDuplicateInGlobalRecent(metaitem))
        {
            return false;
        } else
        {
            globalRecentItems.addToGlobalList(metaitem);
            storeRecentBrands(globalRecentItems, false);
            return true;
        }
    }

    public void addToGlobalTop(MetaItem metaitem)
    {
        addToGlobalBrands(metaitem);
    }

    public boolean addToRecentBrands(MetaItem metaitem)
    {
        if (isDuplicateInRecent(metaitem))
        {
            return false;
        } else
        {
            recentItems.addToRecentList(metaitem);
            storeRecentBrands(recentItems, true);
            return true;
        }
    }

    public void addToTop(MetaItem metaitem)
    {
        addToRecentBrands(metaitem);
        addToGlobalTop(metaitem);
    }

    public void clearGlobalRecentBrands()
    {
        globalRecentItems.clear();
    }

    public void clearGlobalRecentBrandsPref()
    {
        globalRecentItems.clear();
        sharedPreferencesController = SharedPreferencesController.getSharedPreferencesController();
        sharedPreferencesController.removePreference("global_recent_brands");
    }

    public void clearRecentBrands()
    {
        recentItems.clear();
    }

    public void clearRecentBrandsPref()
    {
        recentItems.clear();
        sharedPreferencesController = SharedPreferencesController.getSharedPreferencesController();
        sharedPreferencesController.removePreference("recent_brands");
    }

    public int getCount()
    {
        return recentItems.size();
    }

    public void getFilteredList()
    {
        HashSet hashset = new HashSet();
        for (Iterator iterator = globalRecentItems.iterator(); iterator.hasNext(); hashset.add((MetaItem)iterator.next())) { }
        Iterator iterator1 = recentItems.iterator();
        do
        {
            if (!iterator1.hasNext())
            {
                break;
            }
            MetaItem metaitem = (MetaItem)iterator1.next();
            if (hashset.contains(metaitem))
            {
                continue;
            }
            recentItems.remove(metaitem);
            break;
        } while (true);
    }

    public int getGlobalCount()
    {
        return globalRecentItems.size();
    }

    public MetaItemList getGlobalRecentItems()
    {
        return globalRecentItems;
    }

    public MetaItem getGlobalTop()
    {
        return (MetaItem)globalRecentItems.get(0);
    }

    public MetaItemList getRecentItems()
    {
        MetaItemList metaitemlist;
        try
        {
            if (recentItems != null)
            {
                return recentItems;
            }
            recentItems = retrieveRecentBrands(true);
            globalRecentItems = retrieveRecentBrands(false);
            metaitemlist = recentItems;
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            return null;
        }
        return metaitemlist;
    }

    public MetaItem getTop()
    {
        return (MetaItem)recentItems.get(0);
    }

    public void handleNotification(Intent intent)
    {
    }

    public boolean isDuplicateInGlobalRecent(MetaItem metaitem)
    {
        boolean flag1 = false;
        int i = 0;
        do
        {
label0:
            {
                boolean flag = flag1;
                if (i < actualGlobalItemCount())
                {
                    try
                    {
                        if (!metaitem.equals(globalRecentItems.get(i)))
                        {
                            break label0;
                        }
                        globalRecentItems.remove(metaitem);
                        globalRecentItems.addToRecentList(metaitem);
                    }
                    // Misplaced declaration of an exception variable
                    catch (MetaItem metaitem)
                    {
                        return false;
                    }
                    flag = true;
                }
                return flag;
            }
            i++;
        } while (true);
    }

    public boolean isDuplicateInRecent(MetaItem metaitem)
    {
        boolean flag1 = false;
        int i = 0;
        do
        {
label0:
            {
                boolean flag = flag1;
                if (i < actualRecentItemCount())
                {
                    try
                    {
                        if (!metaitem.equals(recentItems.get(i)))
                        {
                            break label0;
                        }
                        recentItems.remove(metaitem);
                        recentItems.addToRecentList(metaitem);
                    }
                    // Misplaced declaration of an exception variable
                    catch (MetaItem metaitem)
                    {
                        return false;
                    }
                    flag = true;
                }
                return flag;
            }
            i++;
        } while (true);
    }

    public MetaItemList retrieveRecentBrands(boolean flag)
    {
        sharedPreferencesController = SharedPreferencesController.getSharedPreferencesController();
        if (flag)
        {
            MetaItemList metaitemlist = new MetaItemList(6);
            Object obj = sharedPreferencesController.getStringSet("recent_brands");
            if (obj != null)
            {
                for (obj = ((Set) (obj)).iterator(); ((Iterator) (obj)).hasNext();)
                {
                    String s = (String)((Iterator) (obj)).next();
                    try
                    {
                        metaitemlist.add(new MetaItem(s, s));
                    }
                    catch (Exception exception)
                    {
                        exception.printStackTrace();
                    }
                }

            }
            return metaitemlist;
        }
        MetaItemList metaitemlist1 = new MetaItemList(30);
        Object obj1 = sharedPreferencesController.getStringSet("global_recent_brands");
        if (obj1 != null)
        {
            for (obj1 = ((Set) (obj1)).iterator(); ((Iterator) (obj1)).hasNext();)
            {
                String s1 = (String)((Iterator) (obj1)).next();
                try
                {
                    metaitemlist1.addToGlobalList(new MetaItem(s1, s1));
                }
                catch (Exception exception1)
                {
                    exception1.printStackTrace();
                }
            }

            return metaitemlist1;
        }
        String as[] = DEFAULT_RECENT_BRANDS;
        int j = as.length;
        int i = 0;
        while (i < j) 
        {
            String s2 = as[i];
            try
            {
                metaitemlist1.addToGlobalList(new MetaItem(s2, s2));
            }
            catch (Exception exception2)
            {
                exception2.printStackTrace();
            }
            i++;
        }
        return metaitemlist1;
    }

    public void storeRecentBrands(MetaItemList metaitemlist, boolean flag)
    {
        HashSet hashset = new HashSet();
        for (int i = 0; i < metaitemlist.size(); i++)
        {
            hashset.add(((MetaItem)metaitemlist.get(i)).getDisplay());
        }

        if (flag)
        {
            sharedPreferencesController.putStringSet("recent_brands", hashset);
            return;
        } else
        {
            sharedPreferencesController.putStringSet("global_recent_brands", hashset);
            return;
        }
    }

}

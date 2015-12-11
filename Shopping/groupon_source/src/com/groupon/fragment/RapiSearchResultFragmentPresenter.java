// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.content.res.Resources;
import android.os.Bundle;
import com.groupon.models.search.domain.ReloadSearchEvent;
import com.groupon.util.Dates;
import com.groupon.util.RapiRequestProperties;
import com.groupon.util.search.RapiDateTimeRequestHelper;
import com.squareup.otto.Bus;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.fragment:
//            CategoryIntentProperties, RapiSearchResultFragmentDomainModel, DateTimeFindingView, RapiSearchResultDomainModelFacade

public class RapiSearchResultFragmentPresenter
    implements CategoryIntentProperties
{
    private static class StaticCategoryBuilder
    {

        private Map categoryMap;
        private Resources resources;

        public List buildCategorySectionArray()
        {
            ArrayList arraylist = new ArrayList();
            String s;
            for (Iterator iterator = categoryMap.keySet().iterator(); iterator.hasNext(); arraylist.add(new ValuePair(s, (String)categoryMap.get(s))))
            {
                s = (String)iterator.next();
            }

            return arraylist;
        }

        public List buildHourIntervals()
        {
            Calendar calendar = Calendar.getInstance();
            calendar.set(11, 24);
            calendar.set(12, 0);
            SimpleDateFormat simpledateformat = new SimpleDateFormat("h:mm a");
            ArrayList arraylist = new ArrayList();
            arraylist.add(new ValuePair(resources.getString(0x7f0802fd), null));
            for (int i = 0; i < 24; i++)
            {
                Date date = calendar.getTime();
                arraylist.add(new ValuePair(simpledateformat.format(date), Long.toString(date.getTime())));
                calendar.add(10, 1);
            }

            return arraylist;
        }

        public List buildNPeopleArray(int i)
        {
            ArrayList arraylist = new ArrayList();
            for (int j = 1; j <= i; j++)
            {
                arraylist.add(new ValuePair(resources.getQuantityString(0x7f0c0015, j, new Object[] {
                    Integer.valueOf(j)
                }), Integer.toString(j)));
            }

            return arraylist;
        }

        public List buildNextNDays(int i)
        {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date());
            SimpleDateFormat simpledateformat = new SimpleDateFormat("E, MMM d");
            ArrayList arraylist = new ArrayList();
            int j = 0;
            while (j < i) 
            {
                ValuePair valuepair = new ValuePair();
                Date date = calendar.getTime();
                valuepair.actualValue = Long.toString(date.getTime());
                if (j == 0)
                {
                    valuepair.displayValue = resources.getString(0x7f0803e0);
                } else
                {
                    valuepair.displayValue = simpledateformat.format(date);
                }
                arraylist.add(valuepair);
                calendar.add(5, 1);
                j++;
            }
            return arraylist;
        }

        public List buildPartialHourIntervals()
        {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date());
            calendar.set(12, 0);
            SimpleDateFormat simpledateformat = new SimpleDateFormat("h:mm a");
            ArrayList arraylist = new ArrayList();
            arraylist.add(new ValuePair(resources.getString(0x7f0802fd), null));
            for (int i = calendar.get(11); i < 24; i++)
            {
                Date date = calendar.getTime();
                arraylist.add(new ValuePair(simpledateformat.format(date), Long.toString(date.getTime())));
                calendar.add(10, 1);
            }

            return arraylist;
        }

        public String getCategoryString(String s)
        {
label0:
            {
                if (!categoryMap.containsValue(s))
                {
                    break label0;
                }
                Iterator iterator = categoryMap.keySet().iterator();
                String s1;
                do
                {
                    if (!iterator.hasNext())
                    {
                        break label0;
                    }
                    s1 = (String)iterator.next();
                } while (!((String)categoryMap.get(s1)).equals(s));
                return s1;
            }
            return "";
        }

        public StaticCategoryBuilder(Resources resources1)
        {
            categoryMap = new LinkedHashMap();
            resources = resources1;
            categoryMap.put(resources1.getString(0x7f0801b5), "all");
            categoryMap.put(resources1.getString(0x7f0801b6), "beauty-and-spas");
            categoryMap.put(resources1.getString(0x7f0801b7), "skin-care");
            categoryMap.put(resources1.getString(0x7f0801b8), "hair-removal");
            categoryMap.put(resources1.getString(0x7f0801b9), "hair-salons");
            categoryMap.put(resources1.getString(0x7f0801ba), "massage");
            categoryMap.put(resources1.getString(0x7f0801bb), "nail-salons");
        }
    }

    public static class ValuePair
    {

        public String actualValue;
        public String displayValue;

        public ValuePair()
        {
            displayValue = "";
            actualValue = "";
        }

        public ValuePair(String s, String s1)
        {
            displayValue = "";
            actualValue = "";
            displayValue = s;
            actualValue = s1;
        }
    }


    public static final int ADAPTER_ID_1 = 1;
    public static final int ADAPTER_ID_2 = 2;
    public static final int ADAPTER_ID_3 = 3;
    private static final int DEFAULT_MAX_PARTY = 8;
    private static final String FRAGMENT_DOMAIN_MODEL = "FRAGMENT_DOMAIN_MODEL";
    private static final int INITIAL_POS_2 = 1;
    private static final int INITIAL_POS_3 = 1;
    private static final int INITIAL_POS_FD = 2;
    private static final int INITIAL_POS_HBW = 1;
    private static final String SEARCH_INTENT_CATEGORY = "SEARCH_INTENT_CATEGORY";
    private static final String SELECTED_POS_1 = "SELECTED_POS_1";
    private static final String SELECTED_POS_2 = "SELECTED_POS_2";
    private static final String SELECTED_POS_3 = "SELECTED_POS_3";
    private RapiSearchResultFragmentDomainModel domainModel;
    private final Bus eventBus;
    private DateTimeFindingView fragment;
    private String initialServiceCategory;
    private int listSelectedPosition1;
    private int listSelectedPosition2;
    private int listSelectedPosition3;
    private List listValuePair1;
    private List listValuePair2;
    private List listValuePair3;
    private List listValuePair3ForToday;
    private final RapiDateTimeRequestHelper rapiDateTimeRequestHelper = new RapiDateTimeRequestHelper();
    private final RapiRequestProperties rapiRequestProperties;
    private Resources resources;
    private com.groupon.db.models.Features.SearchIntentCategory searchIntentCategory;
    private StaticCategoryBuilder staticCategoryBuilder;

    public RapiSearchResultFragmentPresenter(DateTimeFindingView datetimefindingview, Resources resources1, Bundle bundle, RapiRequestProperties rapirequestproperties, Bus bus, boolean flag)
    {
        searchIntentCategory = com.groupon.db.models.Features.SearchIntentCategory.UNKNOWN;
        listSelectedPosition1 = -1;
        listSelectedPosition2 = 1;
        listSelectedPosition3 = 1;
        domainModel = new RapiSearchResultFragmentDomainModel();
        staticCategoryBuilder = new StaticCategoryBuilder(resources1);
        fragment = datetimefindingview;
        resources = resources1;
        rapiRequestProperties = rapirequestproperties;
        eventBus = bus;
        domainModel.setMakeAReservationToggle(flag);
        onRestoreInstanceState(bundle);
    }

    private String calculateHeaderString()
    {
        Object obj = new SimpleDateFormat("E MMM d");
        Object obj1 = new SimpleDateFormat("h:mm a");
        String s;
        String s1;
        int i;
        if (domainModel.getReservationDate() == null)
        {
            obj = "";
        } else
        if (Dates.isToday(domainModel.getReservationDate().getTime()))
        {
            obj = resources.getString(0x7f0803e0);
        } else
        {
            obj = ((SimpleDateFormat) (obj)).format(domainModel.getReservationDate());
        }
        if (domainModel.getReservationTime() == null)
        {
            obj1 = resources.getString(0x7f0802fd);
        } else
        {
            obj1 = ((SimpleDateFormat) (obj1)).format(domainModel.getReservationTime());
        }
        i = domainModel.getPartySize();
        s = resources.getQuantityString(0x7f0c0015, i, new Object[] {
            Integer.valueOf(i)
        });
        s1 = staticCategoryBuilder.getCategoryString(domainModel.getServiceType());
        if (!displayPartySize())
        {
            s = s1;
        }
        return String.format("%s, %s, %s", new Object[] {
            s, obj, obj1
        });
    }

    private boolean displayPartySize()
    {
        return searchIntentCategory == com.groupon.db.models.Features.SearchIntentCategory.FOOD_AND_DRINK;
    }

    private int getInitialHBWPosition(String s)
    {
        if (!Strings.isEmpty(s)) goto _L2; else goto _L1
_L1:
        int j = 1;
_L4:
        return j;
_L2:
        int i = 0;
label0:
        do
        {
label1:
            {
                if (i >= listValuePair1.size())
                {
                    break label1;
                }
                j = i;
                if (((ValuePair)listValuePair1.get(i)).actualValue.equals(s))
                {
                    break label0;
                }
                i++;
            }
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
        return 1;
    }

    private List getListData(List list)
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(new ValuePair());
        arraylist.addAll(list);
        arraylist.add(new ValuePair());
        return arraylist;
    }

    public void buildStaticListsAndSetDefaultValues()
    {
        List list;
        if (isFoodAndDrinkIntent())
        {
            list = staticCategoryBuilder.buildNPeopleArray(8);
        } else
        {
            list = staticCategoryBuilder.buildCategorySectionArray();
        }
        listValuePair1 = getListData(list);
        listValuePair2 = getListData(staticCategoryBuilder.buildNextNDays(31));
        listValuePair3 = getListData(staticCategoryBuilder.buildHourIntervals());
        listValuePair3ForToday = getListData(staticCategoryBuilder.buildPartialHourIntervals());
        if (isFoodAndDrinkIntent())
        {
            setPartySize(getDefaultPositionForList1(false));
        } else
        {
            setServiceCategory(getDefaultPositionForList1(false));
        }
        setReservationDate(getDefaultPositionForList2(false));
        setReservationTime(getDefaultPositionForList3(false));
    }

    public int findMappingIndexInListValuePair3ForToday()
    {
        if (listSelectedPosition3 < listValuePair3.size() - listValuePair3ForToday.size())
        {
            return getDefaultPositionForList3(true);
        } else
        {
            return Math.abs(listSelectedPosition3 - (listValuePair3.size() - listValuePair3ForToday.size()));
        }
    }

    public int findMappingIndexInListValuePair3FromToday()
    {
        if (listSelectedPosition3 == getDefaultPositionForList3(true))
        {
            return listSelectedPosition3;
        } else
        {
            return listValuePair3.size() - (listValuePair3ForToday.size() - listSelectedPosition3);
        }
    }

    public com.groupon.db.models.Features.SearchIntentCategory getCategoryIntent()
    {
        return searchIntentCategory;
    }

    public int getDefaultPositionForList1(boolean flag)
    {
        if (!flag && listSelectedPosition1 >= 0)
        {
            return listSelectedPosition1;
        }
        if (isFoodAndDrinkIntent())
        {
            return 2;
        } else
        {
            return getInitialHBWPosition(initialServiceCategory);
        }
    }

    public int getDefaultPositionForList2(boolean flag)
    {
        if (!flag && listSelectedPosition2 >= 0)
        {
            return listSelectedPosition2;
        } else
        {
            return 1;
        }
    }

    public int getDefaultPositionForList3(boolean flag)
    {
        if (!flag && listSelectedPosition3 >= 0)
        {
            return listSelectedPosition3;
        } else
        {
            return 1;
        }
    }

    public RapiSearchResultDomainModelFacade getDomainModelFacade()
    {
        return domainModel;
    }

    public List getListValuePair1()
    {
        return listValuePair1;
    }

    public List getListValuePair2()
    {
        return listValuePair2;
    }

    public List getListValuePair3()
    {
        if (isToday())
        {
            return listValuePair3ForToday;
        } else
        {
            return listValuePair3;
        }
    }

    public int getSelectedPositionFor(int i)
    {
        switch (i)
        {
        default:
            return -1;

        case 1: // '\001'
            return listSelectedPosition1;

        case 2: // '\002'
            return listSelectedPosition2;

        case 3: // '\003'
            return listSelectedPosition3;
        }
    }

    public void initializeServiceCategory(String s)
    {
        initialServiceCategory = s;
        domainModel.setServiceType(s);
    }

    public boolean isBeautyAndSpaIntent()
    {
        return searchIntentCategory.equals(com.groupon.db.models.Features.SearchIntentCategory.HEALTH_BEAUTY_WELLNESS);
    }

    public boolean isFoodAndDrinkIntent()
    {
        return searchIntentCategory.equals(com.groupon.db.models.Features.SearchIntentCategory.FOOD_AND_DRINK);
    }

    public boolean isIntentUnknown()
    {
        return searchIntentCategory.equals(com.groupon.db.models.Features.SearchIntentCategory.UNKNOWN);
    }

    public boolean isToday()
    {
        return listSelectedPosition2 == 1;
    }

    public void onRestoreInstanceState(Bundle bundle)
    {
        if (bundle != null)
        {
            domainModel = (RapiSearchResultFragmentDomainModel)bundle.getParcelable("FRAGMENT_DOMAIN_MODEL");
            searchIntentCategory = (com.groupon.db.models.Features.SearchIntentCategory)bundle.getSerializable("SEARCH_INTENT_CATEGORY");
            listSelectedPosition1 = bundle.getInt("SELECTED_POS_1");
            listSelectedPosition2 = bundle.getInt("SELECTED_POS_2");
            listSelectedPosition3 = bundle.getInt("SELECTED_POS_3");
        }
        if (!isIntentUnknown())
        {
            buildStaticListsAndSetDefaultValues();
        }
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        bundle.putParcelable("FRAGMENT_DOMAIN_MODEL", domainModel);
        bundle.putSerializable("SEARCH_INTENT_CATEGORY", searchIntentCategory);
        bundle.putInt("SELECTED_POS_1", listSelectedPosition1);
        bundle.putInt("SELECTED_POS_2", listSelectedPosition2);
        bundle.putInt("SELECTED_POS_3", listSelectedPosition3);
    }

    public void refreshView()
    {
        fragment.setHeaderToggleVisible(domainModel.isReservationHeaderVisible());
        DateTimeFindingView datetimefindingview = fragment;
        boolean flag;
        if (domainModel.isMakeAReservationToggled() && domainModel.isReservationHeaderVisible())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        datetimefindingview.setDateTimeHeaderVisible(flag);
        fragment.setDateTimeHeaderString(calculateHeaderString());
        fragment.setToggleTitle(resources.getString(0x7f08013e));
    }

    public void reloadDeals()
    {
        eventBus.post(new ReloadSearchEvent());
    }

    public void setMakeAReservationVisibility(boolean flag)
    {
        domainModel.setReservationHeaderVisibility(flag);
    }

    public void setPartySize(int i)
    {
        domainModel.setPartySize(Integer.parseInt(((ValuePair)listValuePair1.get(i)).actualValue));
        rapiDateTimeRequestHelper.updateReservationDetails(rapiRequestProperties, getDomainModelFacade(), searchIntentCategory);
    }

    public void setReservationDate(int i)
    {
        domainModel.setReservationDate(new Date(Long.parseLong(((ValuePair)listValuePair2.get(i)).actualValue)));
        rapiDateTimeRequestHelper.updateReservationDetails(rapiRequestProperties, getDomainModelFacade(), searchIntentCategory);
    }

    public void setReservationTime(int i)
    {
        String s;
        if (isToday())
        {
            s = ((ValuePair)listValuePair3ForToday.get(i)).actualValue;
        } else
        {
            s = ((ValuePair)listValuePair3.get(i)).actualValue;
        }
        if (s == null)
        {
            domainModel.setReservationTime(null);
        } else
        {
            domainModel.setReservationTime(new Date(Long.parseLong(s)));
        }
        rapiDateTimeRequestHelper.updateReservationDetails(rapiRequestProperties, getDomainModelFacade(), searchIntentCategory);
    }

    public void setSearchIntentCategory(com.groupon.db.models.Features.SearchIntentCategory searchintentcategory)
    {
        searchIntentCategory = searchintentcategory;
    }

    public void setSelectedPositionFor(int i, int j)
    {
        switch (i)
        {
        default:
            return;

        case 1: // '\001'
            listSelectedPosition1 = j;
            return;

        case 2: // '\002'
            listSelectedPosition2 = j;
            return;

        case 3: // '\003'
            listSelectedPosition3 = j;
            break;
        }
    }

    public void setServiceCategory(int i)
    {
        domainModel.setServiceType(((ValuePair)listValuePair1.get(i)).actualValue);
        rapiDateTimeRequestHelper.updateReservationDetails(rapiRequestProperties, getDomainModelFacade(), searchIntentCategory);
    }

    public void toggleReservation(boolean flag)
    {
        domainModel.setMakeAReservationToggle(flag);
        boolean flag1;
        if (domainModel.isReservationHeaderVisible() && flag)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        fragment.animateDateTimeHeaderVisible(flag1);
        rapiDateTimeRequestHelper.toggleReservation(rapiRequestProperties, flag, domainModel, isFoodAndDrinkIntent());
    }
}

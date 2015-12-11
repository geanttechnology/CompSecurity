// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.shared.ui;

import android.content.res.Resources;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.CharacterStyle;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import com.ebay.common.Preferences;
import com.ebay.common.model.search.EbayAspectHistogram;
import com.ebay.common.model.search.EbayCategorySummary;
import com.ebay.common.model.search.SavedSearch;
import com.ebay.common.net.api.search.SearchParameters;
import com.ebay.common.view.util.EbayCountryManager;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.common.EbayCurrencyUtil;
import com.ebay.mobile.search.SearchUtil;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.data.ItemCurrency;
import com.ebay.nautilus.domain.dcs.DcsNautilusBoolean;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class SearchRefinementSummary
{
    private static class Refinement
    {

        public final String key;
        public final String value;

        public Refinement(String s, String s1)
        {
            key = s;
            value = s1;
        }
    }

    private static final class RefinementBuilderHelper
    {

        private final Resources resources;
        StringBuilder sb;

        public final void add(boolean flag, int i)
        {
            if (flag)
            {
                if (sb == null)
                {
                    sb = new StringBuilder();
                } else
                {
                    sb.append("; ");
                }
                sb.append(resources.getString(i));
            }
        }

        public final transient void add(boolean flag, int i, Object aobj[])
        {
            if (flag)
            {
                if (sb == null)
                {
                    sb = new StringBuilder();
                } else
                {
                    sb.append("; ");
                }
                sb.append(resources.getString(i, aobj));
            }
        }

        public final boolean isEmpty()
        {
            return sb == null;
        }

        public String toString()
        {
            if (sb == null)
            {
                return super.toString();
            } else
            {
                return sb.toString();
            }
        }

        public RefinementBuilderHelper(Resources resources1)
        {
            sb = null;
            resources = resources1;
        }
    }

    private static final class Span
    {

        public int end;
        private final int flags;
        public int start;
        public Object what;

        public final void setSpan(SpannableString spannablestring)
        {
            spannablestring.setSpan(what, start, end, flags);
        }

        public Span(Object obj, int i, int j, int k)
        {
            what = obj;
            start = i;
            end = j;
            flags = k;
        }
    }


    private SearchRefinementSummary()
    {
    }

    private static String formatCurrency(ItemCurrency itemcurrency)
    {
        return EbayCurrencyUtil.formatDisplay(itemcurrency, 0);
    }

    private static String getBuyingFormat(Resources resources, int i)
    {
        i = getBuyingFormatResId(i);
        if (i == 0x7f07055d)
        {
            return null;
        } else
        {
            return resources.getString(i);
        }
    }

    private static int getBuyingFormatResId(int i)
    {
        switch (i)
        {
        case 7: // '\007'
        default:
            return 0x7f07055d;

        case 5: // '\005'
            return 0x7f07055f;

        case 6: // '\006'
            return 0x7f070529;
        }
    }

    private static String getConditionDisplay(Resources resources, String s)
    {
        String as[] = resources.getStringArray(0x7f0e000c);
        resources = resources.getStringArray(0x7f0e000d);
        as[0] = null;
        if (s != null)
        {
            int j = resources.length;
            for (int i = 0; i < j; i++)
            {
                if (s.equals(resources[i]))
                {
                    return as[i];
                }
            }

        }
        return as[0];
    }

    private static String getMaxDistance(Resources resources, EbayCountry ebaycountry, int i)
    {
        if (i > 0 && ebaycountry != null && resources != null)
        {
            return (new StringBuilder()).append(String.valueOf(i)).append(' ').append(EbayCountryManager.getDistanceString(resources, ebaycountry)).toString();
        } else
        {
            return null;
        }
    }

    private static String getPriceRange(Resources resources, ItemCurrency itemcurrency, ItemCurrency itemcurrency1)
    {
        if (itemcurrency != null)
        {
            if (itemcurrency1 != null)
            {
                return resources.getString(0x7f0707bf, new Object[] {
                    formatCurrency(itemcurrency), formatCurrency(itemcurrency1)
                });
            } else
            {
                return resources.getString(0x7f070179, new Object[] {
                    formatCurrency(itemcurrency)
                });
            }
        }
        if (itemcurrency1 != null)
        {
            return resources.getString(0x7f070604, new Object[] {
                formatCurrency(itemcurrency1)
            });
        } else
        {
            return null;
        }
    }

    private static List getRefinements(SavedSearch savedsearch, Resources resources)
    {
        ArrayList arraylist = new ArrayList(1);
        arraylist.add(new Refinement(resources.getString(0x7f070591), savedsearch.name));
        savedsearch = new ArrayList(1);
        savedsearch.add(arraylist);
        return savedsearch;
    }

    private static List getRefinements(SearchParameters searchparameters, Resources resources)
    {
        ArrayList arraylist;
label0:
        {
            arraylist = new ArrayList();
            Object obj = new ArrayList();
            Object obj1;
            Object obj3;
            boolean flag1;
            if (!TextUtils.isEmpty(searchparameters.sellerId))
            {
                ((ArrayList) (obj)).add(new Refinement(resources.getString(0x7f070592), searchparameters.sellerId));
            } else
            if (!TextUtils.isEmpty(searchparameters.keywords))
            {
                ((ArrayList) (obj)).add(new Refinement(resources.getString(0x7f070590), searchparameters.keywords));
            } else
            if (!TextUtils.isEmpty(searchparameters.productId) && !TextUtils.isEmpty(searchparameters.productIdType))
            {
                ((ArrayList) (obj)).add(new Refinement(searchparameters.productIdType, searchparameters.productId));
            }
            if (!((ArrayList) (obj)).isEmpty())
            {
                arraylist.add(obj);
            }
            obj = new ArrayList();
            if (!SearchUtil.isZipCodeDefault(searchparameters.buyerPostalCode))
            {
                ((ArrayList) (obj)).add(new Refinement(resources.getString(0x7f07058a), searchparameters.buyerPostalCode));
            }
            if (searchparameters.category != null && !TextUtils.isEmpty(searchparameters.category.name))
            {
                ((ArrayList) (obj)).add(new Refinement(resources.getString(0x7f070216), searchparameters.category.name));
            }
            obj1 = getPriceRange(resources, searchparameters.minPrice, searchparameters.maxPrice);
            if (obj1 != null)
            {
                ((ArrayList) (obj)).add(new Refinement(resources.getString(0x7f0707be), ((String) (obj1))));
            }
            obj1 = getConditionDisplay(resources, searchparameters.condition);
            if (obj1 != null)
            {
                ((ArrayList) (obj)).add(new Refinement(resources.getString(0x7f070535), ((String) (obj1))));
            }
            obj1 = getMaxDistance(resources, searchparameters.country, searchparameters.maxDistance);
            if (obj1 != null)
            {
                ((ArrayList) (obj)).add(new Refinement(resources.getString(0x7f070605), ((String) (obj1))));
            }
            if (searchparameters.descriptionSearch || searchparameters.completedListings || searchparameters.soldItemsOnly || searchparameters.ebnOnly || searchparameters.localPickupOnly || searchparameters.inStorePickupOnly || searchparameters.ebayPlusOnly || searchparameters.ebayGivingWorks)
            {
                obj1 = new RefinementBuilderHelper(resources);
                ((RefinementBuilderHelper) (obj1)).add(searchparameters.completedListings, 0x7f070534);
                ((RefinementBuilderHelper) (obj1)).add(searchparameters.soldItemsOnly, 0x7f0705c5);
                ((RefinementBuilderHelper) (obj1)).add(searchparameters.descriptionSearch, 0x7f07053d);
                ((RefinementBuilderHelper) (obj1)).add(searchparameters.ebnOnly, SearchUtil.getEbayNowResourceForCountry(searchparameters.country));
                ((RefinementBuilderHelper) (obj1)).add(searchparameters.localPickupOnly, 0x7f0700b7);
                ((RefinementBuilderHelper) (obj1)).add(searchparameters.inStorePickupOnly, SearchUtil.getInStorePickupResourceForCountry(searchparameters.country));
                ((RefinementBuilderHelper) (obj1)).add(searchparameters.ebayPlusOnly, 0x7f070375);
                ((RefinementBuilderHelper) (obj1)).add(searchparameters.ebayGivingWorks, 0x7f070532);
                if (!((RefinementBuilderHelper) (obj1)).isEmpty())
                {
                    ((ArrayList) (obj)).add(new Refinement(resources.getString(0x7f07058f), ((RefinementBuilderHelper) (obj1)).toString()));
                }
            }
            obj1 = resources.getString(0x7f070ae4);
            obj3 = searchparameters.sortOrder;
            if (searchparameters.completedListings || searchparameters.soldItemsOnly)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            ((ArrayList) (obj)).add(new Refinement(((String) (obj1)), getSortDisplay(resources, ((String) (obj3)), flag1)));
            obj1 = getBuyingFormat(resources, searchparameters.buyingFormat);
            if (obj1 != null)
            {
                ((ArrayList) (obj)).add(new Refinement(resources.getString(0x7f07017c), ((String) (obj1))));
            }
            if (searchparameters.bestOfferOnly)
            {
                ((ArrayList) (obj)).add(new Refinement(resources.getString(0x7f07017c), resources.getString(0x7f070523)));
            }
            if (searchparameters.freeShipping || searchparameters.expeditedShipping || searchparameters.searchLocalCountryOnly || searchparameters.searchOtherCountries)
            {
                Object obj2 = new RefinementBuilderHelper(resources);
                ((RefinementBuilderHelper) (obj2)).add(searchparameters.freeShipping, 0x7f070549);
                ((RefinementBuilderHelper) (obj2)).add(searchparameters.expeditedShipping, 0x7f07097a);
                if (searchparameters.searchLocalCountryOnly)
                {
                    ((RefinementBuilderHelper) (obj2)).add(searchparameters.searchLocalCountryOnly, 0x7f070562, new Object[] {
                        EbayCountryManager.getCountryName(resources, searchparameters.country)
                    });
                }
                obj3 = DeviceConfiguration.getAsync();
                Iterator iterator;
                Iterator iterator1;
                boolean flag;
                if (!MyApp.getPrefs().getCurrentCountry().isSite() && ((DeviceConfiguration) (obj3)).get(DcsNautilusBoolean.GBH))
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (!flag)
                {
                    ((RefinementBuilderHelper) (obj2)).add(searchparameters.searchOtherCountries, 0x7f0705a7);
                }
                if (!((RefinementBuilderHelper) (obj2)).isEmpty())
                {
                    ((ArrayList) (obj)).add(new Refinement(resources.getString(0x7f07058f), ((RefinementBuilderHelper) (obj2)).toString()));
                }
            }
            if (!((ArrayList) (obj)).isEmpty())
            {
                arraylist.add(obj);
            }
            if (searchparameters.aspectHistogram == null)
            {
                break label0;
            }
            obj3 = new ArrayList();
            iterator = searchparameters.aspectHistogram.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                com.ebay.common.model.search.EbayAspectHistogram.Aspect aspect = (com.ebay.common.model.search.EbayAspectHistogram.Aspect)iterator.next();
                searchparameters = null;
                iterator1 = aspect.iterator();
label1:
                do
                {
label2:
                    {
                        if (!iterator1.hasNext())
                        {
                            break label1;
                        }
                        obj = (com.ebay.common.model.search.EbayAspectHistogram.AspectValue)iterator1.next();
                        if (!((com.ebay.common.model.search.EbayAspectHistogram.AspectValue) (obj)).checked)
                        {
                            continue;
                        }
                        if (searchparameters == null)
                        {
                            searchparameters = new StringBuilder();
                        } else
                        {
                            searchparameters.append("; ");
                        }
                        obj2 = ((com.ebay.common.model.search.EbayAspectHistogram.AspectValue) (obj)).value;
                        if (TextUtils.isEmpty(((com.ebay.common.model.search.EbayAspectHistogram.AspectValue) (obj)).serviceValue) || !((com.ebay.common.model.search.EbayAspectHistogram.AspectValue) (obj)).serviceValue.equals("!"))
                        {
                            obj = obj2;
                            if (!((String) (obj2)).equals("LH_SiteWideCondition_NS"))
                            {
                                break label2;
                            }
                        }
                        obj = resources.getString(0x7f070953);
                    }
                    searchparameters.append(((String) (obj)));
                } while (true);
                if (searchparameters != null)
                {
                    ((ArrayList) (obj3)).add(new Refinement(aspect.name, searchparameters.toString()));
                }
            } while (true);
            if (!((ArrayList) (obj3)).isEmpty())
            {
                arraylist.add(obj3);
            }
        }
        return arraylist;
    }

    public static CharSequence getRefinementsSummary(SavedSearch savedsearch, Resources resources, CharacterStyle characterstyle, String s)
    {
        return getRefinementsSummary(getRefinements(savedsearch, resources), characterstyle, s, resources);
    }

    public static CharSequence getRefinementsSummary(SearchParameters searchparameters, Resources resources, CharacterStyle characterstyle, String s)
    {
        return getRefinementsSummary(getRefinements(searchparameters, resources), characterstyle, s, resources);
    }

    private static CharSequence getRefinementsSummary(List list, CharacterStyle characterstyle, String s, Resources resources)
    {
        Object obj;
        ArrayList arraylist;
        arraylist = new ArrayList();
        obj = null;
        if (!TextUtils.isEmpty(s))
        {
            obj = new StringBuilder();
            ((StringBuilder) (obj)).append(s);
            int i = ((StringBuilder) (obj)).length();
            arraylist.add(new Span(new RelativeSizeSpan(1.2F), 0, i, 0));
            arraylist.add(new Span(new StyleSpan(1), 0, i, 0));
        }
        s = resources.getString(0x7f0705ca);
        resources = list.iterator();
        do
        {
label0:
            {
                Object obj1;
                do
                {
                    if (!resources.hasNext())
                    {
                        break label0;
                    }
                    obj1 = (ArrayList)resources.next();
                } while (((ArrayList) (obj1)).isEmpty());
                if (obj == null)
                {
                    list = new StringBuilder();
                } else
                {
                    ((StringBuilder) (obj)).append('\n');
                    list = ((List) (obj));
                }
                obj1 = ((ArrayList) (obj1)).iterator();
                do
                {
                    obj = list;
                    if (!((Iterator) (obj1)).hasNext())
                    {
                        break;
                    }
                    obj = (Refinement)((Iterator) (obj1)).next();
                    list.append('\n');
                    if (((Refinement) (obj)).key != null)
                    {
                        int j = list.length();
                        list.append(((Refinement) (obj)).key).append(s);
                        int k = list.length();
                        arraylist.add(new Span(new StyleSpan(1), j, k - 1, 0));
                    }
                    list.append(((Refinement) (obj)).value);
                } while (true);
            }
        } while (true);
        list = null;
        if (obj != null)
        {
            list = new SpannableString(((StringBuilder) (obj)).toString());
            if (characterstyle != null)
            {
                list.setSpan(characterstyle, 0, ((StringBuilder) (obj)).length(), 0);
            }
            for (characterstyle = arraylist.iterator(); characterstyle.hasNext(); ((Span)characterstyle.next()).setSpan(list)) { }
        }
        return list;
    }

    public static String getSortDisplay(Resources resources, String s, boolean flag)
    {
        String as[];
        if (flag)
        {
            as = resources.getStringArray(0x7f0e001c);
        } else
        {
            as = resources.getStringArray(0x7f0e001b);
        }
        resources = resources.getStringArray(0x7f0e001d);
        if (s != null)
        {
            int j = resources.length;
            for (int i = 0; i < j; i++)
            {
                if (s.equals(resources[i]))
                {
                    return as[i];
                }
            }

        }
        return as[0];
    }
}

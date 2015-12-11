// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.search.viewit;

import android.graphics.Point;
import android.view.Display;
import android.view.WindowManager;
import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.util.Util;
import com.amazon.rio.j2me.client.services.mShop.BasicProductInfo;
import com.amazon.rio.j2me.client.services.mShop.SearchResult;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

// Referenced classes of package com.amazon.mShop.search.viewit:
//            ViewItSearchResultWrapper, ResultWrapper, ViewItSlidingDrawerBrowser, ViewItDBResultWrapper, 
//            ViewItDBHelper

public class ViewItUtil
{

    public ViewItUtil()
    {
    }

    public static Point getScreenSize(AmazonActivity amazonactivity)
    {
        amazonactivity = amazonactivity.getWindowManager().getDefaultDisplay();
        if (android.os.Build.VERSION.SDK_INT >= 13)
        {
            Point point = new Point();
            amazonactivity.getSize(point);
            return point;
        } else
        {
            return new Point(amazonactivity.getWidth(), amazonactivity.getHeight());
        }
    }

    public static String getSeriesAsinString(List list)
    {
        Object obj = null;
        Object obj1 = null;
        if (!Util.isEmpty(list))
        {
            Iterator iterator = list.iterator();
            list = obj1;
            do
            {
                obj = list;
                if (!iterator.hasNext())
                {
                    break;
                }
                obj = (String)iterator.next();
                if (list != null)
                {
                    list = (new StringBuilder()).append(list).append(",").append(((String) (obj))).toString();
                } else
                {
                    list = ((List) (obj));
                }
            } while (true);
        }
        return ((String) (obj));
    }

    public static boolean hasMultipleResults(ViewItSearchResultWrapper viewitsearchresultwrapper)
    {
        return !Util.isEmpty(viewitsearchresultwrapper.getSearchResults()) && viewitsearchresultwrapper.getSearchResults().size() > 1;
    }

    public static boolean isOverlappedWithTopFiveResults(List list, List list1)
    {
        if (!Util.isEmpty(list) && !Util.isEmpty(list1))
        {
            HashSet hashset;
            int i;
            int j;
            if (list.size() > 5)
            {
                i = 5;
            } else
            {
                i = list.size();
            }
            if (list1.size() > 5)
            {
                j = 5;
            } else
            {
                j = list1.size();
            }
            hashset = new HashSet();
            for (int l = 0; l < j; l++)
            {
                hashset.add(list1.get(l));
            }

            for (int k = 0; k < i; k++)
            {
                if (hashset.contains((String)list.get(k)))
                {
                    return true;
                }
            }

        }
        return false;
    }

    public static boolean isSimilarObject(List list, ResultWrapper resultwrapper, ResultWrapper.ResultType resulttype, boolean flag)
    {
        if (Util.isEmpty(list) || resultwrapper == null)
        {
            break MISSING_BLOCK_LABEL_86;
        }
        if (!resulttype.equals(ResultWrapper.ResultType.BARCODE) || !flag) goto _L2; else goto _L1
_L1:
        list = (String)list.get(0);
        if (!resultwrapper.getResultType().equals(ResultWrapper.ResultType.BARCODE) || !list.equals(removePrefix(resultwrapper.getOriginalScannedOutput(), ResultWrapper.ResultType.BARCODE.getTypeValue()))) goto _L4; else goto _L3
_L3:
        return true;
_L4:
        return false;
_L2:
        if (isOverlappedWithTopFiveResults(list, resultwrapper.getAsinList())) goto _L3; else goto _L5
_L5:
        return false;
        return false;
    }

    public static boolean isSimilarObject(List list, List list1)
    {
        if (!Util.isEmpty(list) && !Util.isEmpty(list1))
        {
            return isOverlappedWithTopFiveResults(list, list1);
        } else
        {
            return false;
        }
    }

    public static void mergeSimilarObejcts(ViewItSearchResultWrapper viewitsearchresultwrapper, ViewItSearchResultWrapper viewitsearchresultwrapper1)
    {
        if (viewitsearchresultwrapper == null || viewitsearchresultwrapper1 == null || !isOverlappedWithTopFiveResults(viewitsearchresultwrapper.getAsinList(), viewitsearchresultwrapper1.getAsinList())) goto _L2; else goto _L1
_L1:
        List list;
        List list1;
        list = viewitsearchresultwrapper.getSearchResults();
        list1 = viewitsearchresultwrapper1.getSearchResults();
        if (Util.isEmpty(list)) goto _L2; else goto _L3
_L3:
        ArrayList arraylist;
        int i;
        int k;
        int l;
        k = list.size();
        l = list1.size();
        arraylist = new ArrayList();
        i = 0;
_L5:
        if (i < k)
        {
            boolean flag1 = true;
            SearchResult searchresult = (SearchResult)list.get(i);
            int j = 0;
            do
            {
label0:
                {
                    boolean flag = flag1;
                    if (j < l)
                    {
                        SearchResult searchresult1 = (SearchResult)list1.get(j);
                        if (!searchresult.getBasicProduct().getAsin().equals(searchresult1.getBasicProduct().getAsin()))
                        {
                            break label0;
                        }
                        flag = false;
                    }
                    if (flag)
                    {
                        arraylist.add(searchresult);
                    }
                    i++;
                    continue; /* Loop/switch isn't completed */
                }
                j++;
            } while (true);
        }
        if (!Util.isEmpty(arraylist))
        {
            list1.addAll(arraylist);
        }
        if (viewitsearchresultwrapper.getResultType().equals(ResultWrapper.ResultType.BARCODE) && !viewitsearchresultwrapper1.getResultType().equals(ResultWrapper.ResultType.BARCODE))
        {
            viewitsearchresultwrapper1.updateOriginalScannedOutput(viewitsearchresultwrapper.getOriginalScannedOutput());
        }
_L2:
        return;
        if (true) goto _L5; else goto _L4
_L4:
    }

    public static boolean removeIfContained(List list, SearchResult searchresult)
    {
        if (!Util.isEmpty(list) && searchresult != null)
        {
            int j = list.size();
            for (int i = 0; i < j; i++)
            {
                if (((SearchResult)list.get(i)).getBasicProduct().getAsin().equals(searchresult.getBasicProduct().getAsin()))
                {
                    list.remove(i);
                    return true;
                }
            }

        }
        return false;
    }

    public static String removePrefix(String s, String s1)
    {
        String s2 = s;
        if (!Util.isEmpty(s))
        {
            s2 = s;
            if (!Util.isEmpty(s1))
            {
                s2 = s;
                if (s.startsWith(s1))
                {
                    s2 = s.replace(s1, "");
                }
            }
        }
        return s2;
    }

    public static ResultWrapper removeSimilarObject(List list, List list1, ResultWrapper.ResultType resulttype, boolean flag)
    {
        if (!Util.isEmpty(list) && !Util.isEmpty(list1))
        {
            int j = list.size();
            for (int i = 0; i < j; i++)
            {
                if (isSimilarObject(list1, (ResultWrapper)list.get(i), resulttype, flag))
                {
                    return (ResultWrapper)list.remove(i);
                }
            }

        }
        return null;
    }

    public static ViewItSearchResultWrapper removeSimilarObjectFromHistory(List list, ResultWrapper.ResultType resulttype, ViewItSlidingDrawerBrowser viewitslidingdrawerbrowser, ViewItDBHelper viewitdbhelper, boolean flag)
    {
        ViewItSearchResultWrapper viewitsearchresultwrapper1 = (ViewItSearchResultWrapper)removeSimilarObject(viewitslidingdrawerbrowser.getRecentlyScannedObjects(), list, resulttype, flag);
        ViewItSearchResultWrapper viewitsearchresultwrapper = viewitsearchresultwrapper1;
        if (viewitsearchresultwrapper1 == null)
        {
            viewitsearchresultwrapper1 = (ViewItSearchResultWrapper)removeSimilarObject(viewitslidingdrawerbrowser.getHistoryListingObjects(), list, resulttype, flag);
            viewitsearchresultwrapper = viewitsearchresultwrapper1;
            if (viewitsearchresultwrapper1 != null)
            {
                viewitslidingdrawerbrowser.mHistoryObjectsDeletedCount = viewitslidingdrawerbrowser.mHistoryObjectsDeletedCount + 1;
                viewitsearchresultwrapper = viewitsearchresultwrapper1;
            }
        }
        viewitsearchresultwrapper1 = viewitslidingdrawerbrowser.getObjectToDelete();
        if (viewitsearchresultwrapper != null && viewitsearchresultwrapper1 != null)
        {
            if (!viewitsearchresultwrapper1.getOriginalScannedOutput().equals(viewitsearchresultwrapper.getOriginalScannedOutput()));
        }
        if (viewitsearchresultwrapper == null)
        {
            ViewItDBResultWrapper viewitdbresultwrapper = (ViewItDBResultWrapper)removeSimilarObject(viewitslidingdrawerbrowser.getCurrentRequestDBObjects(), list, resulttype, flag);
            if (viewitdbresultwrapper != null)
            {
                viewitdbhelper.delete(viewitdbresultwrapper);
                viewitslidingdrawerbrowser.mHistoryObjectsDeletedCount = viewitslidingdrawerbrowser.mHistoryObjectsDeletedCount + 1;
            }
            List list1 = viewitslidingdrawerbrowser.getAllHistoryDBObjects();
            if (viewitdbresultwrapper == null && !Util.isEmpty(list1))
            {
                int i = viewitslidingdrawerbrowser.getNextPageStartIndex();
                int j = list1.size();
                if (i < j)
                {
                    list = (ViewItDBResultWrapper)removeSimilarObject(list1.subList(i, j), list, resulttype, flag);
                    if (list != null)
                    {
                        viewitslidingdrawerbrowser.setAvailableCount(viewitslidingdrawerbrowser.getAvailableCount() - 1);
                        viewitdbhelper.delete(list);
                    }
                }
            }
        }
        return viewitsearchresultwrapper;
    }
}

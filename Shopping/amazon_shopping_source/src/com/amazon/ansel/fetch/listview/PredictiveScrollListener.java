// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.ansel.fetch.listview;

import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import com.amazon.ansel.fetch.ResourceLoader;
import com.amazon.ansel.fetch.ResourceProvider;
import com.amazon.ansel.fetch.log.AppLog;
import com.amazon.ansel.fetch.tools.collection.Factory;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public abstract class PredictiveScrollListener
    implements android.widget.AbsListView.OnScrollListener
{

    private static final String TAG = com/amazon/ansel/fetch/listview/PredictiveScrollListener.getSimpleName();
    private boolean firstRun;
    private final int interval;
    private final int maxPositions;
    private final int maxResources;
    private final int minPriority;
    private int prevFirst;
    private long prevTime;
    private int prevTop;
    private final ResourceProvider resourceProvider;
    private final boolean useInterval;

    public PredictiveScrollListener(ResourceProvider resourceprovider)
    {
        this(resourceprovider, true, 500, 20, 10, 1);
    }

    public PredictiveScrollListener(ResourceProvider resourceprovider, boolean flag, int i, int j, int k, int l)
    {
        firstRun = false;
        prevFirst = -1;
        prevTop = -1;
        resourceProvider = resourceprovider;
        useInterval = flag;
        interval = i;
        maxResources = j;
        maxPositions = k;
        minPriority = l;
    }

    private void load(AdapterView adapterview, int i, long l)
    {
        if (adapterview != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Object obj;
        int j;
        int k1;
        int l1;
        int i2;
        int k2;
        int l2;
        k2 = adapterview.getCount();
        l1 = adapterview.getFirstVisiblePosition();
        j = adapterview.getLastVisiblePosition();
        l2 = Math.max(2, Math.max(Math.max(1, (j - l1) + 1), maxPositions / 2));
        if (i == -1)
        {
            l1 = j;
        }
        j = 0;
        k1 = 0;
        obj = new ArrayList(maxPositions);
        i2 = 0;
_L8:
        int j1;
        int j2;
        j2 = k1;
        j1 = j;
        if (j >= maxPositions) goto _L4; else goto _L3
_L3:
        ArrayList arraylist;
        int k;
        int i1;
        k = k1;
        i1 = j;
        if (i2 > 0)
        {
            k = k1;
            i1 = j;
            if (i2 % l2 == 0)
            {
                k = k1;
                i1 = j;
                if (k1 < 1)
                {
                    k1++;
                    Integer integer;
                    Object obj1;
                    ResourceLoader resourceloader1;
                    if (i == -1)
                    {
                        j1 = l1 + k1;
                    } else
                    {
                        j1 = l1 - k1;
                    }
                    k = k1;
                    i1 = j;
                    if (j1 >= 0)
                    {
                        k = k1;
                        i1 = j;
                        if (j1 < k2)
                        {
                            ((ArrayList) (obj)).add(Integer.valueOf(j1));
                            i1 = j + 1;
                            k = k1;
                        }
                    }
                }
            }
        }
        if (i == -1)
        {
            j = l1 - i2;
        } else
        {
            j = l1 + i2;
        }
        j2 = k;
        j1 = i1;
        if (j < 0) goto _L4; else goto _L5
_L5:
        if (j < k2) goto _L7; else goto _L6
_L6:
        j1 = i1;
        j2 = k;
_L4:
        if (j1 < maxPositions)
        {
            if (i == -1)
            {
                j = l1 + j1 + j2;
            } else
            {
                j = l1 - j1 - j2;
            }
            if (j >= 0 && j < k2)
            {
                break MISSING_BLOCK_LABEL_599;
            }
        }
        k = 0;
        i = 0;
        adapterview = new HashSet(((ArrayList) (obj)).size());
        arraylist = new ArrayList(((ArrayList) (obj)).size());
        obj = ((ArrayList) (obj)).iterator();
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break;
            }
            integer = (Integer)((Iterator) (obj)).next();
            obj1 = getLoadersFor(integer.intValue());
            if (obj1 != null)
            {
                obj1 = ((List) (obj1)).iterator();
                do
                {
                    j = i;
                    if (!((Iterator) (obj1)).hasNext())
                    {
                        break;
                    }
                    resourceloader1 = (ResourceLoader)((Factory)((Iterator) (obj1)).next()).get();
                    resourceloader1.setPriority((long)minPriority + (l - (long)k));
                    if (AppLog.isLoggable(TAG, 2))
                    {
                        AppLog.v(TAG, (new StringBuilder()).append("Adding ").append(resourceloader1).append(" at position ").append(integer).append(" with priority ").append(resourceloader1.getPriority()).toString());
                    }
                    arraylist.add(resourceloader1);
                    if (resourceloader1.getResourceKey() != null)
                    {
                        adapterview.add(resourceloader1.getResourceKey());
                    }
                    j = i + 1;
                    i = j;
                } while (j < maxResources);
                k++;
                i = j;
            }
        } while (true);
        break MISSING_BLOCK_LABEL_619;
_L7:
        ((ArrayList) (obj)).add(Integer.valueOf(j));
        i2++;
        j = i1 + 1;
        k1 = k;
          goto _L8
        ((ArrayList) (obj)).add(Integer.valueOf(j));
        j1++;
          goto _L4
        adapterview = arraylist.iterator();
        while (adapterview.hasNext()) 
        {
            ResourceLoader resourceloader = (ResourceLoader)adapterview.next();
            if (AppLog.isLoggable(TAG, 2))
            {
                AppLog.v(TAG, (new StringBuilder()).append("Loading ").append(resourceloader).append(" with priority ").append(resourceloader.getPriority()).toString());
            }
            resourceProvider.execute(resourceloader);
        }
        if (true) goto _L1; else goto _L9
_L9:
    }

    private void processViewInternal(AdapterView adapterview, boolean flag)
    {
        if (adapterview != null)
        {
            long l = System.currentTimeMillis();
            if (flag || !useInterval || prevTime <= 0L || l - prevTime >= (long)interval)
            {
                int k = adapterview.getFirstVisiblePosition();
                int i;
                int j;
                if (adapterview.getChildCount() > 0)
                {
                    j = adapterview.getChildAt(0).getTop();
                } else
                {
                    j = 0;
                }
                if (prevFirst == -1)
                {
                    i = 0;
                } else
                if (k > prevFirst)
                {
                    i = 1;
                } else
                if (k < prevFirst)
                {
                    i = -1;
                } else
                if (prevTop == -1)
                {
                    i = 0;
                } else
                if (j > prevTop)
                {
                    i = 1;
                } else
                if (j < prevTop)
                {
                    i = -1;
                } else
                {
                    i = 0;
                }
                if (i != 0 || firstRun || flag)
                {
                    if (i != -1)
                    {
                        i = 1;
                    }
                    if (AppLog.isLoggable(TAG, 2))
                    {
                        AppLog.v(TAG, (new StringBuilder()).append("Scroll direction: ").append(i).toString());
                    }
                    load(adapterview, i, l);
                    prevTime = l;
                    prevFirst = k;
                    prevTop = j;
                    firstRun = false;
                    return;
                }
            }
        }
    }

    public int getInterval()
    {
        return interval;
    }

    protected abstract List getLoadersFor(int i);

    public int getMaxPositions()
    {
        return maxPositions;
    }

    public int getMaxResources()
    {
        return maxResources;
    }

    public int getMinPriority()
    {
        return minPriority;
    }

    public boolean getUseInterval()
    {
        return useInterval;
    }

    public void onScroll(AbsListView abslistview, int i, int j, int k)
    {
        process(abslistview);
    }

    public void onScroll(AdapterView adapterview, int i, int j, int k)
    {
        process(adapterview);
    }

    public void onScrollStateChanged(AbsListView abslistview, int i)
    {
        process(abslistview);
    }

    public void onScrollStateChanged(AdapterView adapterview, int i)
    {
        process(adapterview);
    }

    public void process(AdapterView adapterview)
    {
        processView(adapterview, false);
    }

    public void processView(AdapterView adapterview, boolean flag)
    {
        try
        {
            processViewInternal(adapterview, flag);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (AdapterView adapterview)
        {
            Log.e(TAG, "Error", adapterview);
        }
    }

}

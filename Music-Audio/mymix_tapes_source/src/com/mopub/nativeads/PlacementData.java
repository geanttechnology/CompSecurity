// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.nativeads;

import com.mopub.common.logging.MoPubLog;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.mopub.nativeads:
//            NativeAd

class PlacementData
{

    private static final int MAX_ADS = 200;
    public static final int NOT_FOUND = -1;
    private final int mAdjustedAdPositions[] = new int[200];
    private int mDesiredCount;
    private final int mDesiredInsertionPositions[] = new int[200];
    private final int mDesiredOriginalPositions[] = new int[200];
    private final NativeAd mNativeAds[] = new NativeAd[200];
    private final int mOriginalAdPositions[] = new int[200];
    private int mPlacedCount;

    private PlacementData(int ai[])
    {
        mDesiredCount = 0;
        mPlacedCount = 0;
        mDesiredCount = Math.min(ai.length, 200);
        System.arraycopy(ai, 0, mDesiredInsertionPositions, 0, mDesiredCount);
        System.arraycopy(ai, 0, mDesiredOriginalPositions, 0, mDesiredCount);
    }

    private static int binarySearch(int ai[], int i, int j, int k)
    {
label0:
        {
            for (j--; i <= j;)
            {
                int l = i + j >>> 1;
                int i1 = ai[l];
                if (i1 < k)
                {
                    i = l + 1;
                } else
                {
                    j = l;
                    if (i1 <= k)
                    {
                        break label0;
                    }
                    j = l - 1;
                }
            }

            j = ~i;
        }
        return j;
    }

    private static int binarySearchFirstEquals(int ai[], int i, int j)
    {
        i = binarySearch(ai, 0, i, j);
        if (i < 0)
        {
            return ~i;
        }
        for (j = ai[i]; i >= 0 && ai[i] == j; i--) { }
        return i + 1;
    }

    private static int binarySearchGreaterThan(int ai[], int i, int j)
    {
        j = binarySearch(ai, 0, i, j);
        if (j < 0)
        {
            return ~j;
        }
        for (int k = ai[j]; j < i && ai[j] == k; j++) { }
        return j;
    }

    static PlacementData empty()
    {
        return new PlacementData(new int[0]);
    }

    static PlacementData fromAdPositioning(MoPubNativeAdPositioning.MoPubClientPositioning mopubclientpositioning)
    {
        Object obj = mopubclientpositioning.getFixedPositions();
        int l = mopubclientpositioning.getRepeatingInterval();
        int i;
        int j;
        int k;
        if (l == 0x7fffffff)
        {
            k = ((List) (obj)).size();
        } else
        {
            k = 200;
        }
        mopubclientpositioning = new int[k];
        j = 0;
        i = 0;
        for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext();)
        {
            i = ((Integer)((Iterator) (obj)).next()).intValue() - j;
            mopubclientpositioning[j] = i;
            j++;
        }

        for (; j < k; j++)
        {
            i = (i + l) - 1;
            mopubclientpositioning[j] = i;
        }

        return new PlacementData(mopubclientpositioning);
    }

    void clearAds()
    {
        if (mPlacedCount == 0)
        {
            return;
        } else
        {
            clearAdsInRange(0, mAdjustedAdPositions[mPlacedCount - 1] + 1);
            return;
        }
    }

    int clearAdsInRange(int i, int j)
    {
        int ai[] = new int[mPlacedCount];
        int ai1[] = new int[mPlacedCount];
        int k = 0;
        int l = 0;
        while (l < mPlacedCount) 
        {
            int j1 = mOriginalAdPositions[l];
            int k1 = mAdjustedAdPositions[l];
            int i1;
            if (i <= k1 && k1 < j)
            {
                ai[k] = j1;
                ai1[k] = k1 - k;
                mNativeAds[l].destroy();
                mNativeAds[l] = null;
                i1 = k + 1;
            } else
            {
                i1 = k;
                if (k > 0)
                {
                    i1 = l - k;
                    mOriginalAdPositions[i1] = j1;
                    mAdjustedAdPositions[i1] = k1 - k;
                    mNativeAds[i1] = mNativeAds[l];
                    i1 = k;
                }
            }
            l++;
            k = i1;
        }
        if (k == 0)
        {
            return 0;
        }
        i = ai1[0];
        j = binarySearchFirstEquals(mDesiredInsertionPositions, mDesiredCount, i);
        for (i = mDesiredCount - 1; i >= j; i--)
        {
            mDesiredOriginalPositions[i + k] = mDesiredOriginalPositions[i];
            mDesiredInsertionPositions[i + k] = mDesiredInsertionPositions[i] - k;
        }

        for (i = 0; i < k; i++)
        {
            mDesiredOriginalPositions[j + i] = ai[i];
            mDesiredInsertionPositions[j + i] = ai1[i];
        }

        mDesiredCount = mDesiredCount + k;
        mPlacedCount = mPlacedCount - k;
        return k;
    }

    int getAdjustedCount(int i)
    {
        if (i == 0)
        {
            return 0;
        } else
        {
            return getAdjustedPosition(i - 1) + 1;
        }
    }

    int getAdjustedPosition(int i)
    {
        return i + binarySearchGreaterThan(mOriginalAdPositions, mPlacedCount, i);
    }

    int getOriginalCount(int i)
    {
        byte byte0 = -1;
        if (i == 0)
        {
            i = 0;
        } else
        {
            int j = getOriginalPosition(i - 1);
            i = byte0;
            if (j != -1)
            {
                return j + 1;
            }
        }
        return i;
    }

    int getOriginalPosition(int i)
    {
        int j = binarySearch(mAdjustedAdPositions, 0, mPlacedCount, i);
        if (j < 0)
        {
            return i - ~j;
        } else
        {
            return -1;
        }
    }

    NativeAd getPlacedAd(int i)
    {
        i = binarySearch(mAdjustedAdPositions, 0, mPlacedCount, i);
        if (i < 0)
        {
            return null;
        } else
        {
            return mNativeAds[i];
        }
    }

    int[] getPlacedAdPositions()
    {
        int ai[] = new int[mPlacedCount];
        System.arraycopy(mAdjustedAdPositions, 0, ai, 0, mPlacedCount);
        return ai;
    }

    void insertItem(int i)
    {
        for (int j = binarySearchFirstEquals(mDesiredOriginalPositions, mDesiredCount, i); j < mDesiredCount; j++)
        {
            int ai[] = mDesiredOriginalPositions;
            ai[j] = ai[j] + 1;
            ai = mDesiredInsertionPositions;
            ai[j] = ai[j] + 1;
        }

        for (i = binarySearchFirstEquals(mOriginalAdPositions, mPlacedCount, i); i < mPlacedCount; i++)
        {
            int ai1[] = mOriginalAdPositions;
            ai1[i] = ai1[i] + 1;
            ai1 = mAdjustedAdPositions;
            ai1[i] = ai1[i] + 1;
        }

    }

    boolean isPlacedAd(int i)
    {
        boolean flag = false;
        if (binarySearch(mAdjustedAdPositions, 0, mPlacedCount, i) >= 0)
        {
            flag = true;
        }
        return flag;
    }

    void moveItem(int i, int j)
    {
        removeItem(i);
        insertItem(j);
    }

    int nextInsertionPosition(int i)
    {
        i = binarySearchGreaterThan(mDesiredInsertionPositions, mDesiredCount, i);
        if (i == mDesiredCount)
        {
            return -1;
        } else
        {
            return mDesiredInsertionPositions[i];
        }
    }

    void placeAd(int i, NativeAd nativead)
    {
        int j = binarySearchFirstEquals(mDesiredInsertionPositions, mDesiredCount, i);
        if (j == mDesiredCount || mDesiredInsertionPositions[j] != i)
        {
            MoPubLog.w("Attempted to insert an ad at an invalid position");
        } else
        {
            int l = mDesiredOriginalPositions[j];
            int k = binarySearchGreaterThan(mOriginalAdPositions, mPlacedCount, l);
            if (k < mPlacedCount)
            {
                int i1 = mPlacedCount - k;
                System.arraycopy(mOriginalAdPositions, k, mOriginalAdPositions, k + 1, i1);
                System.arraycopy(mAdjustedAdPositions, k, mAdjustedAdPositions, k + 1, i1);
                System.arraycopy(mNativeAds, k, mNativeAds, k + 1, i1);
            }
            mOriginalAdPositions[k] = l;
            mAdjustedAdPositions[k] = i;
            mNativeAds[k] = nativead;
            mPlacedCount = mPlacedCount + 1;
            i = mDesiredCount - j - 1;
            System.arraycopy(mDesiredInsertionPositions, j + 1, mDesiredInsertionPositions, j, i);
            System.arraycopy(mDesiredOriginalPositions, j + 1, mDesiredOriginalPositions, j, i);
            mDesiredCount = mDesiredCount - 1;
            for (i = j; i < mDesiredCount; i++)
            {
                nativead = mDesiredInsertionPositions;
                nativead[i] = nativead[i] + 1;
            }

            i = k + 1;
            while (i < mPlacedCount) 
            {
                nativead = mAdjustedAdPositions;
                nativead[i] = nativead[i] + 1;
                i++;
            }
        }
    }

    int previousInsertionPosition(int i)
    {
        i = binarySearchFirstEquals(mDesiredInsertionPositions, mDesiredCount, i);
        if (i == 0)
        {
            return -1;
        } else
        {
            return mDesiredInsertionPositions[i - 1];
        }
    }

    void removeItem(int i)
    {
        for (int j = binarySearchGreaterThan(mDesiredOriginalPositions, mDesiredCount, i); j < mDesiredCount; j++)
        {
            int ai[] = mDesiredOriginalPositions;
            ai[j] = ai[j] - 1;
            ai = mDesiredInsertionPositions;
            ai[j] = ai[j] - 1;
        }

        for (i = binarySearchGreaterThan(mOriginalAdPositions, mPlacedCount, i); i < mPlacedCount; i++)
        {
            int ai1[] = mOriginalAdPositions;
            ai1[i] = ai1[i] - 1;
            ai1 = mAdjustedAdPositions;
            ai1[i] = ai1[i] - 1;
        }

    }

    boolean shouldPlaceAd(int i)
    {
        boolean flag = false;
        if (binarySearch(mDesiredInsertionPositions, 0, mDesiredCount, i) >= 0)
        {
            flag = true;
        }
        return flag;
    }
}

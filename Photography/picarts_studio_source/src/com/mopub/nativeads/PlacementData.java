// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.nativeads;

import com.mopub.common.logging.MoPubLog;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.mopub.nativeads:
//            NativeAdData, NativeResponse

class PlacementData
{

    private static final int MAX_ADS = 70;
    public static final int NOT_FOUND = -1;
    private final NativeAdData mAdDataObjects[] = new NativeAdData[70];
    private final int mAdjustedAdPositions[] = new int[70];
    private int mDesiredCount;
    private final int mDesiredInsertionPositions[] = new int[70];
    private final int mDesiredOriginalPositions[] = new int[70];
    private final int mOriginalAdPositions[] = new int[70];
    private int mPlacedCount;

    private PlacementData(int ai[])
    {
        mDesiredCount = 0;
        mPlacedCount = 0;
        mDesiredCount = Math.min(ai.length, 70);
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
        if (j >= 0) goto _L2; else goto _L1
_L1:
        int k = ~j;
_L4:
        return k;
_L2:
        int l = ai[j];
_L6:
        k = j;
        if (j >= i) goto _L4; else goto _L3
_L3:
        k = j;
        if (ai[j] != l) goto _L4; else goto _L5
_L5:
        j++;
          goto _L6
    }

    static PlacementData empty()
    {
        return new PlacementData(new int[0]);
    }

    static PlacementData fromAdPositioning(MoPubNativeAdPositioning.MoPubClientPositioning mopubclientpositioning, int i)
    {
        i = 0;
        Object obj = mopubclientpositioning.getFixedPositions();
        int i1 = mopubclientpositioning.getRepeatingInterval();
        int j;
        int k;
        int l;
        if (i1 == 0x7fffffff)
        {
            k = ((List) (obj)).size();
        } else
        {
            k = 70;
        }
        mopubclientpositioning = new int[k];
        obj = ((List) (obj)).iterator();
        j = 0;
        do
        {
            l = i;
            if (!((Iterator) (obj)).hasNext())
            {
                break;
            }
            j = ((Integer)((Iterator) (obj)).next()).intValue() - i;
            mopubclientpositioning[i] = j;
            i++;
        } while (true);
        for (; l < k; l++)
        {
            j = (j + i1) - 1;
            mopubclientpositioning[l] = j;
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
        boolean flag = false;
        int ai[] = new int[mPlacedCount];
        int ai1[] = new int[mPlacedCount];
        int l = 0;
        int k = 0;
        while (l < mPlacedCount) 
        {
            int j1 = mOriginalAdPositions[l];
            int k1 = mAdjustedAdPositions[l];
            int i1;
            if (i <= k1 && k1 < j)
            {
                ai[k] = j1;
                ai1[k] = k1 - k;
                if (mAdDataObjects[l] != null)
                {
                    mAdDataObjects[l].getAd().destroy();
                    mAdDataObjects[l] = null;
                }
                i1 = k + 1;
            } else
            {
                i1 = k;
                if (k > 0)
                {
                    i1 = l - k;
                    mOriginalAdPositions[i1] = j1;
                    mAdjustedAdPositions[i1] = k1 - k;
                    mAdDataObjects[i1] = mAdDataObjects[l];
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
        l = binarySearchFirstEquals(mDesiredInsertionPositions, mDesiredCount, i);
        i = mDesiredCount - 1;
        do
        {
            j = ((flag) ? 1 : 0);
            if (i < l)
            {
                break;
            }
            mDesiredOriginalPositions[i + k] = mDesiredOriginalPositions[i];
            mDesiredInsertionPositions[i + k] = mDesiredInsertionPositions[i] - k;
            i--;
        } while (true);
        for (; j < k; j++)
        {
            mDesiredOriginalPositions[l + j] = ai[j];
            mDesiredInsertionPositions[l + j] = ai1[j];
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
        return binarySearchGreaterThan(mOriginalAdPositions, mPlacedCount, i) + i;
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

    NativeAdData getPlacedAd(int i)
    {
        i = binarySearch(mAdjustedAdPositions, 0, mPlacedCount, i);
        if (i < 0)
        {
            return null;
        } else
        {
            return mAdDataObjects[i];
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

    void placeAd(int i, NativeAdData nativeaddata)
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
                System.arraycopy(mAdDataObjects, k, mAdDataObjects, k + 1, i1);
            }
            mOriginalAdPositions[k] = l;
            mAdjustedAdPositions[k] = i;
            mAdDataObjects[k] = nativeaddata;
            mPlacedCount = mPlacedCount + 1;
            i = mDesiredCount - j - 1;
            System.arraycopy(mDesiredInsertionPositions, j + 1, mDesiredInsertionPositions, j, i);
            System.arraycopy(mDesiredOriginalPositions, j + 1, mDesiredOriginalPositions, j, i);
            mDesiredCount = mDesiredCount - 1;
            for (i = j; i < mDesiredCount; i++)
            {
                nativeaddata = mDesiredInsertionPositions;
                nativeaddata[i] = nativeaddata[i] + 1;
            }

            i = k + 1;
            while (i < mPlacedCount) 
            {
                nativeaddata = mAdjustedAdPositions;
                nativeaddata[i] = nativeaddata[i] + 1;
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

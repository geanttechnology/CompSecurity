// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import android.text.TextUtils;
import com.mopub.common.Preconditions;
import java.util.Map;
import java.util.TreeMap;

public class AdRequestStatusMapping
{
    private static class AdRequestStatus
    {

        private String mClickUrl;
        private String mFailUrl;
        private String mImpressionUrl;
        private LoadingStatus mLoadingStatus;

        private String getClickUrl()
        {
            return mClickUrl;
        }

        private String getFailurl()
        {
            return mFailUrl;
        }

        private String getImpressionUrl()
        {
            return mImpressionUrl;
        }

        private LoadingStatus getStatus()
        {
            return mLoadingStatus;
        }

        private void setClickUrl(String s)
        {
            mClickUrl = s;
        }

        private void setImpressionUrl(String s)
        {
            mImpressionUrl = s;
        }

        private void setStatus(LoadingStatus loadingstatus)
        {
            mLoadingStatus = loadingstatus;
        }

        public boolean equals(Object obj)
        {
            boolean flag = true;
            if (obj != null)
            {
                if (this == obj)
                {
                    return true;
                }
                if (obj instanceof AdRequestStatus)
                {
                    obj = (AdRequestStatus)obj;
                    if (!mLoadingStatus.equals(((AdRequestStatus) (obj)).mLoadingStatus) || !TextUtils.equals(mFailUrl, ((AdRequestStatus) (obj)).mFailUrl) || !TextUtils.equals(mImpressionUrl, ((AdRequestStatus) (obj)).mImpressionUrl) || !TextUtils.equals(mClickUrl, ((AdRequestStatus) (obj)).mClickUrl))
                    {
                        flag = false;
                    }
                    return flag;
                }
            }
            return false;
        }

        public int hashCode()
        {
            int k = 0;
            int l = mLoadingStatus.ordinal();
            int i;
            int j;
            if (mFailUrl != null)
            {
                i = mFailUrl.hashCode();
            } else
            {
                i = 0;
            }
            if (mImpressionUrl != null)
            {
                j = mImpressionUrl.hashCode();
            } else
            {
                j = 0;
            }
            if (mClickUrl != null)
            {
                k = mClickUrl.hashCode();
            }
            return (((l + 899) * 31 + i) * 31 + j) * 31 + k;
        }








        public AdRequestStatus(LoadingStatus loadingstatus)
        {
            this(loadingstatus, null, null, null);
        }

        public AdRequestStatus(LoadingStatus loadingstatus, String s, String s1, String s2)
        {
            Preconditions.checkNotNull(loadingstatus);
            mLoadingStatus = loadingstatus;
            mFailUrl = s;
            mImpressionUrl = s1;
            mClickUrl = s2;
        }
    }

    private static final class LoadingStatus extends Enum
    {

        private static final LoadingStatus $VALUES[];
        public static final LoadingStatus LOADED;
        public static final LoadingStatus LOADING;
        public static final LoadingStatus PLAYED;

        public static LoadingStatus valueOf(String s)
        {
            return (LoadingStatus)Enum.valueOf(com/mopub/mobileads/AdRequestStatusMapping$LoadingStatus, s);
        }

        public static LoadingStatus[] values()
        {
            return (LoadingStatus[])$VALUES.clone();
        }

        static 
        {
            LOADING = new LoadingStatus("LOADING", 0);
            LOADED = new LoadingStatus("LOADED", 1);
            PLAYED = new LoadingStatus("PLAYED", 2);
            $VALUES = (new LoadingStatus[] {
                LOADING, LOADED, PLAYED
            });
        }

        private LoadingStatus(String s, int i)
        {
            super(s, i);
        }
    }


    private final Map mAdUnitToAdRequestStatus = new TreeMap();

    public AdRequestStatusMapping()
    {
    }

    boolean canPlay(String s)
    {
        s = (AdRequestStatus)mAdUnitToAdRequestStatus.get(s);
        return s != null && LoadingStatus.LOADED.equals(s.getStatus());
    }

    void clearClickUrl(String s)
    {
        if (mAdUnitToAdRequestStatus.containsKey(s))
        {
            ((AdRequestStatus)mAdUnitToAdRequestStatus.get(s)).setClickUrl(null);
        }
    }

    void clearImpressionUrl(String s)
    {
        if (mAdUnitToAdRequestStatus.containsKey(s))
        {
            ((AdRequestStatus)mAdUnitToAdRequestStatus.get(s)).setImpressionUrl(null);
        }
    }

    String getClickTrackerUrlString(String s)
    {
        if (!mAdUnitToAdRequestStatus.containsKey(s))
        {
            return null;
        } else
        {
            return ((AdRequestStatus)mAdUnitToAdRequestStatus.get(s)).getClickUrl();
        }
    }

    String getFailoverUrl(String s)
    {
        if (!mAdUnitToAdRequestStatus.containsKey(s))
        {
            return null;
        } else
        {
            return ((AdRequestStatus)mAdUnitToAdRequestStatus.get(s)).getFailurl();
        }
    }

    String getImpressionTrackerUrlString(String s)
    {
        if (!mAdUnitToAdRequestStatus.containsKey(s))
        {
            return null;
        } else
        {
            return ((AdRequestStatus)mAdUnitToAdRequestStatus.get(s)).getImpressionUrl();
        }
    }

    boolean isLoading(String s)
    {
        if (!mAdUnitToAdRequestStatus.containsKey(s))
        {
            return false;
        }
        boolean flag;
        if (((AdRequestStatus)mAdUnitToAdRequestStatus.get(s)).getStatus() == LoadingStatus.LOADING)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        return flag;
    }

    void markFail(String s)
    {
        mAdUnitToAdRequestStatus.remove(s);
    }

    void markLoaded(String s, String s1, String s2, String s3)
    {
        mAdUnitToAdRequestStatus.put(s, new AdRequestStatus(LoadingStatus.LOADED, s1, s2, s3));
    }

    void markLoading(String s)
    {
        mAdUnitToAdRequestStatus.put(s, new AdRequestStatus(LoadingStatus.LOADING));
    }

    void markPlayed(String s)
    {
        if (mAdUnitToAdRequestStatus.containsKey(s))
        {
            ((AdRequestStatus)mAdUnitToAdRequestStatus.get(s)).setStatus(LoadingStatus.PLAYED);
            return;
        } else
        {
            mAdUnitToAdRequestStatus.put(s, new AdRequestStatus(LoadingStatus.PLAYED));
            return;
        }
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal;

import com.millennialmedia.MMException;
import com.millennialmedia.MMSDK;

// Referenced classes of package com.millennialmedia.internal:
//            PlayList, AdPlacementReporter

public abstract class AdPlacement
{
    public static class RequestState
    {

        private AdPlacementReporter adPlacementReporter;
        private int itemHash;
        private int requestHash;

        public boolean compare(RequestState requeststate)
        {
            while (requestHash != requeststate.requestHash || itemHash != requeststate.itemHash) 
            {
                return false;
            }
            return true;
        }

        public boolean compareRequest(RequestState requeststate)
        {
            return requestHash == requeststate.requestHash;
        }

        public RequestState copy()
        {
            RequestState requeststate = new RequestState();
            requeststate.requestHash = requestHash;
            requeststate.itemHash = itemHash;
            requeststate.adPlacementReporter = adPlacementReporter;
            return requeststate;
        }

        public AdPlacementReporter getAdPlacementReporter()
        {
            return adPlacementReporter;
        }

        public int getItemHash()
        {
            itemHash = (new Object()).hashCode();
            return itemHash;
        }

        public void setAdPlacementReporter(AdPlacementReporter adplacementreporter)
        {
            adPlacementReporter = adplacementreporter;
        }

        public RequestState()
        {
            requestHash = (new Object()).hashCode();
        }
    }


    protected static final String STATE_AD_ADAPTER_LOAD_FAILED = "ad_adapter_load_failed";
    protected static final String STATE_IDLE = "idle";
    protected static final String STATE_LOADED = "loaded";
    protected static final String STATE_LOADING_AD_ADAPTER = "loading_ad_adapter";
    protected static final String STATE_LOADING_PLAY_LIST = "loading_play_list";
    protected static final String STATE_LOAD_FAILED = "load_failed";
    protected static final String STATE_PLAY_LIST_LOADED = "play_list_loaded";
    private static final String TAG = com/millennialmedia/internal/AdPlacement.getSimpleName();
    protected volatile RequestState currentRequestState;
    public String placementId;
    protected volatile String placementState;
    protected volatile PlayList playList;

    protected AdPlacement(String s)
        throws MMException
    {
        placementState = "idle";
        if (!MMSDK.initialized)
        {
            throw new IllegalStateException("MMSDK must be initialized before creating a new Ad Placement");
        }
        if (s == null)
        {
            throw new MMException("PlacementId must be a non null.");
        }
        placementId = s.trim();
        if (placementId.isEmpty())
        {
            throw new MMException("PlacementId cannot be an empty string.");
        } else
        {
            return;
        }
    }

    public RequestState getRequestState()
    {
        currentRequestState = new RequestState();
        return currentRequestState;
    }

}

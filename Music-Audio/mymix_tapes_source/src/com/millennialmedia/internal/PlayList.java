// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal;

import android.text.TextUtils;
import com.millennialmedia.MMLog;
import com.millennialmedia.internal.adadapters.AdAdapter;
import com.millennialmedia.internal.adadapters.MediatedAdAdapter;
import com.millennialmedia.internal.adcontrollers.AdController;
import com.millennialmedia.internal.utils.HttpUtils;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.millennialmedia.internal:
//            AdPlacement, Handshake

public class PlayList
{
    public static class AdContentPlayListItem extends PlayListItem
    {

        final String value;

        public AdContentPlayListItem(String s, String s1)
        {
            super(s);
            if (TextUtils.isEmpty(s1))
            {
                throw new InvalidParameterException("value is required");
            } else
            {
                value = s1;
                return;
            }
        }
    }

    public static class ClientMediationPlayListItem extends PlayListItem
    {

        final String networkId;
        final String siteId;
        final String spaceId;

        public ClientMediationPlayListItem(String s, String s1, String s2, String s3)
        {
            super(s);
            if (TextUtils.isEmpty(s1) || TextUtils.isEmpty(s2) || TextUtils.isEmpty(s3))
            {
                throw new InvalidParameterException("networkId, siteId and spaceId are required");
            } else
            {
                networkId = s1;
                siteId = s2;
                spaceId = s3;
                return;
            }
        }
    }

    public static class ExchangeMediationPlayListItem extends PlayListItem
    {

        public String postBody;
        public String postContentType;
        final String url;

        public ExchangeMediationPlayListItem(String s, String s1)
        {
            super(s);
            if (TextUtils.isEmpty(s1))
            {
                throw new InvalidParameterException("url is required");
            } else
            {
                url = s1;
                return;
            }
        }
    }

    private static class PlayListItem
    {

        final String itemId;

        protected PlayListItem(String s)
        {
            if (TextUtils.isEmpty(s))
            {
                throw new InvalidParameterException("itemId is required");
            } else
            {
                itemId = s;
                return;
            }
        }
    }

    public static class ServerMediationPlayListItem extends PlayListItem
    {

        public String postBody;
        public String postContentType;
        final String url;
        public String validateRegex;

        public ServerMediationPlayListItem(String s, String s1)
        {
            super(s);
            if (TextUtils.isEmpty(s1))
            {
                throw new InvalidParameterException("url is required");
            } else
            {
                url = s1;
                return;
            }
        }
    }


    private static final String TAG = com/millennialmedia/internal/PlayList.getSimpleName();
    public static final String VERSION = "1";
    private int currentPlayListPosition;
    public String handshakeConfig;
    public String placementId;
    public String placementName;
    private final List playListItems = new ArrayList();
    public String playListVersion;
    public boolean reportingEnabled;
    public String responseId;
    public String siteId;

    public PlayList()
    {
        currentPlayListPosition = 0;
        reportingEnabled = false;
    }

    private static AdAdapter getAdAdapterForContent(AdPlacement adplacement, String s)
    {
        Object obj = null;
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(TAG, (new StringBuilder()).append("Attempting to get ad adapter for ad placement ID: ").append(adplacement.placementId).toString());
        }
        if (s == null)
        {
            MMLog.e(TAG, "Unable to find ad adapter, ad content is null");
        } else
        {
            obj = AdController.getControllerClassForContent(s);
            if (obj == null)
            {
                MMLog.e(TAG, (new StringBuilder()).append("Unable to determine ad controller type for specified ad content <").append(s).append(">").toString());
                return null;
            }
            AdAdapter adadapter = AdAdapter.getAdapterInstance(adplacement.getClass(), ((Class) (obj)));
            obj = adadapter;
            if (adadapter != null)
            {
                if (MMLog.isDebugEnabled())
                {
                    MMLog.d(TAG, (new StringBuilder()).append("Found ad adapter <").append(adadapter).append("> for placement ID <").append(adplacement.placementId).append(">").toString());
                }
                adadapter.setContent(s);
                return adadapter;
            }
        }
        return ((AdAdapter) (obj));
    }

    private int setErrorStatusFromResponseCode(com.millennialmedia.internal.utils.HttpUtils.Response response)
    {
        switch (response.code)
        {
        default:
            return -1;

        case 408: 
        case 504: 
            return -2;
        }
    }

    public void addItem(PlayListItem playlistitem)
        throws InvalidParameterException
    {
        if (playlistitem != null)
        {
            if (MMLog.isDebugEnabled())
            {
                MMLog.d(TAG, (new StringBuilder()).append("Adding playlist item.\n\tPlaylist: ").append(this).append("\n\tPlaylist item: ").append(playlistitem).append("\n\tPlaylist item ID: ").append(playlistitem.itemId).toString());
            }
            playListItems.add(playlistitem);
        } else
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(TAG, "Unable to add null playlist item");
            return;
        }
    }

    public void enableReporting()
    {
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(TAG, (new StringBuilder()).append("Enabling reporting for placement id <").append(placementId).append("> and playlist <").append(this).append(">").toString());
        }
        reportingEnabled = true;
    }

    public AdAdapter getNextAdAdapter(AdPlacement adplacement, AdPlacementReporter.PlayListItemReporter playlistitemreporter)
    {
        AdAdapter adadapter;
        String s;
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(TAG, (new StringBuilder()).append("Attempting to get ad adapter for placement.\n\tPlacement: ").append(adplacement).append("\n\tPlacement ID: ").append(adplacement.placementId).toString());
        }
        adadapter = null;
        s = null;
        byte byte0 = -3;
        this;
        JVM INSTR monitorenter ;
        if (currentPlayListPosition < playListItems.size())
        {
            break MISSING_BLOCK_LABEL_85;
        }
        if (playlistitemreporter == null)
        {
            break MISSING_BLOCK_LABEL_81;
        }
        playlistitemreporter.status = -3;
        this;
        JVM INSTR monitorexit ;
        return null;
        Object obj1;
        List list = playListItems;
        int i = currentPlayListPosition;
        currentPlayListPosition = i + 1;
        obj1 = (PlayListItem)list.get(i);
        this;
        JVM INSTR monitorexit ;
        if (playlistitemreporter != null)
        {
            playlistitemreporter.itemId = ((PlayListItem) (obj1)).itemId;
        }
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(TAG, (new StringBuilder()).append("Processing playlist item ID: ").append(((PlayListItem) (obj1)).itemId).toString());
        }
        if (!(obj1 instanceof ClientMediationPlayListItem)) goto _L2; else goto _L1
_L1:
        Object obj;
        int j;
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(TAG, (new StringBuilder()).append("Processing client mediation playlist item ID: ").append(((PlayListItem) (obj1)).itemId).toString());
        }
        obj1 = (ClientMediationPlayListItem)obj1;
        obj = AdAdapter.getMediatedAdapterInstance(((ClientMediationPlayListItem) (obj1)).networkId, adplacement.getClass());
        if (obj == null)
        {
            MMLog.e(TAG, (new StringBuilder()).append("Unable to find ad adapter for network ID: ").append(((ClientMediationPlayListItem) (obj1)).networkId).toString());
            j = byte0;
        } else
        if (!(obj instanceof MediatedAdAdapter))
        {
            MMLog.e(TAG, (new StringBuilder()).append("Unable to use ad adapter <").append(obj).append("> for <").append(((ClientMediationPlayListItem) (obj1)).networkId).append(">, does not implement mediated ad interface").toString());
            obj = null;
            j = byte0;
        } else
        {
            ((MediatedAdAdapter)obj).setMediationInfo(new com.millennialmedia.internal.adadapters.MediatedAdAdapter.MediationInfo(((ClientMediationPlayListItem) (obj1)).siteId, ((ClientMediationPlayListItem) (obj1)).spaceId));
            obj.requestTimeout = Handshake.getClientMediationTimeout();
            j = byte0;
        }
_L4:
        if (obj != null)
        {
            j = 1;
        }
        if (playlistitemreporter != null)
        {
            playlistitemreporter.status = j;
        }
        return ((AdAdapter) (obj));
        adplacement;
        this;
        JVM INSTR monitorexit ;
        throw adplacement;
_L2:
        if (obj1 instanceof ServerMediationPlayListItem)
        {
            if (MMLog.isDebugEnabled())
            {
                MMLog.d(TAG, (new StringBuilder()).append("Processing server mediation playlist item ID: ").append(((PlayListItem) (obj1)).itemId).toString());
            }
            obj1 = (ServerMediationPlayListItem)obj1;
            j = Handshake.getServerToServerTimeout();
            if (!TextUtils.isEmpty(((ServerMediationPlayListItem) (obj1)).postBody))
            {
                obj = HttpUtils.getContentFromPostRequest(((ServerMediationPlayListItem) (obj1)).url, ((ServerMediationPlayListItem) (obj1)).postBody, ((ServerMediationPlayListItem) (obj1)).postContentType, j);
            } else
            {
                obj = HttpUtils.getContentFromPostRequest(((ServerMediationPlayListItem) (obj1)).url, j);
            }
            if (TextUtils.isEmpty(((com.millennialmedia.internal.utils.HttpUtils.Response) (obj)).content))
            {
                MMLog.e(TAG, (new StringBuilder()).append("Unable to retrieve content for server mediation playlist item, placement ID <").append(adplacement.placementId).append(">").toString());
                j = setErrorStatusFromResponseCode(((com.millennialmedia.internal.utils.HttpUtils.Response) (obj)));
                obj = s;
            } else
            if (!TextUtils.isEmpty(((ServerMediationPlayListItem) (obj1)).validateRegex) && ((com.millennialmedia.internal.utils.HttpUtils.Response) (obj)).content.matches((new StringBuilder()).append("(?s)").append(((ServerMediationPlayListItem) (obj1)).validateRegex).toString()))
            {
                MMLog.e(TAG, (new StringBuilder()).append("Unable to validate content for server mediation playlist item due to \"no ad\" response for placement ID <").append(adplacement.placementId).append("> and content <").append(((com.millennialmedia.internal.utils.HttpUtils.Response) (obj)).content).append(">").toString());
                j = -1;
                obj = s;
            } else
            {
                obj1 = getAdAdapterForContent(adplacement, ((com.millennialmedia.internal.utils.HttpUtils.Response) (obj)).content);
                if (obj1 == null)
                {
                    MMLog.e(TAG, (new StringBuilder()).append("Unable to find adapter for server mediation playlist item, placement ID <").append(adplacement.placementId).append("> and content <").append(((com.millennialmedia.internal.utils.HttpUtils.Response) (obj)).content).append(">").toString());
                    obj = obj1;
                    j = byte0;
                } else
                {
                    ((AdAdapter) (obj1)).setAdMetadata(((com.millennialmedia.internal.utils.HttpUtils.Response) (obj)).adMetadata);
                    obj = obj1;
                    j = byte0;
                }
            }
            continue; /* Loop/switch isn't completed */
        }
        if (!(obj1 instanceof ExchangeMediationPlayListItem))
        {
            break MISSING_BLOCK_LABEL_1090;
        }
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(TAG, (new StringBuilder()).append("Processing exchange mediation playlist item ID: ").append(((PlayListItem) (obj1)).itemId).toString());
        }
        obj = (ExchangeMediationPlayListItem)obj1;
        j = Handshake.getExchangeTimeout();
        if (!TextUtils.isEmpty(((ExchangeMediationPlayListItem) (obj)).postBody))
        {
            obj1 = HttpUtils.getContentFromPostRequest(((ExchangeMediationPlayListItem) (obj)).url, ((ExchangeMediationPlayListItem) (obj)).postBody, ((ExchangeMediationPlayListItem) (obj)).postContentType, j);
        } else
        {
            obj1 = HttpUtils.getContentFromPostRequest(((ExchangeMediationPlayListItem) (obj)).url, j);
        }
        if (TextUtils.isEmpty(((com.millennialmedia.internal.utils.HttpUtils.Response) (obj1)).content))
        {
            MMLog.e(TAG, (new StringBuilder()).append("Unable to retrieve content for exchange mediation playlist item, placement ID <").append(adplacement.placementId).append(">").toString());
            j = setErrorStatusFromResponseCode(((com.millennialmedia.internal.utils.HttpUtils.Response) (obj1)));
            obj = s;
            continue; /* Loop/switch isn't completed */
        }
        obj = adadapter;
        String s1;
        Object obj2;
        try
        {
            obj2 = new JSONObject(((com.millennialmedia.internal.utils.HttpUtils.Response) (obj1)).content);
        }
        // Misplaced declaration of an exception variable
        catch (AdPlacement adplacement)
        {
            MMLog.e(TAG, "Error occurred when trying to parse ad content from exchange response");
            j = byte0;
            continue; /* Loop/switch isn't completed */
        }
        obj = adadapter;
        s = ((JSONObject) (obj2)).getString("ad");
        obj = adadapter;
        s1 = ((JSONObject) (obj2)).optString("ad_buyer", null);
        obj = adadapter;
        obj2 = ((JSONObject) (obj2)).optString("ad_pru", null);
        obj = adadapter;
        adadapter = getAdAdapterForContent(adplacement, s);
        if (adadapter == null)
        {
            break MISSING_BLOCK_LABEL_1032;
        }
        if (playlistitemreporter == null)
        {
            break MISSING_BLOCK_LABEL_992;
        }
        obj = adadapter;
        playlistitemreporter.buyer = s1;
        obj = adadapter;
        playlistitemreporter.pru = ((String) (obj2));
        obj = adadapter;
        adadapter.setAdMetadata(((com.millennialmedia.internal.utils.HttpUtils.Response) (obj1)).adMetadata);
        obj = adadapter;
        j = byte0;
        continue; /* Loop/switch isn't completed */
        obj = adadapter;
        MMLog.e(TAG, (new StringBuilder()).append("Unable to find adapter for exchange mediation playlist item, placement ID <").append(adplacement.placementId).append("> and content <").append(s).append(">").toString());
        obj = adadapter;
        j = byte0;
        continue; /* Loop/switch isn't completed */
        obj = s;
        j = byte0;
        if (obj1 instanceof AdContentPlayListItem)
        {
            if (MMLog.isDebugEnabled())
            {
                MMLog.d(TAG, (new StringBuilder()).append("Processing ad content playlist item ID: ").append(((PlayListItem) (obj1)).itemId).toString());
            }
            AdContentPlayListItem adcontentplaylistitem = (AdContentPlayListItem)obj1;
            obj1 = getAdAdapterForContent(adplacement, adcontentplaylistitem.value);
            obj = obj1;
            j = byte0;
            if (obj1 == null)
            {
                MMLog.e(TAG, (new StringBuilder()).append("Unable to find adapter for ad content playlist item, placement ID <").append(adplacement.placementId).append("> and content <").append(adcontentplaylistitem.value).append(">").toString());
                obj = obj1;
                j = byte0;
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public boolean hasNext()
    {
        return currentPlayListPosition < playListItems.size();
    }

}

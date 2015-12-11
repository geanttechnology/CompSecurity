// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.http.api;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.poshmark.application.AppInfo;
import com.poshmark.application.PMApplicationSession;
import com.poshmark.data_model.ID;
import com.poshmark.data_model.models.ActiveUserInfo;
import com.poshmark.data_model.models.AddressCheckerResults;
import com.poshmark.data_model.models.BrainTreeGatewayInfo;
import com.poshmark.data_model.models.Brand;
import com.poshmark.data_model.models.BrandShareMessageContainer;
import com.poshmark.data_model.models.Catalog;
import com.poshmark.data_model.models.EventList;
import com.poshmark.data_model.models.ExternalServiceInfo;
import com.poshmark.data_model.models.Features;
import com.poshmark.data_model.models.Feed_v1;
import com.poshmark.data_model.models.ListingDetails;
import com.poshmark.data_model.models.ListingSummaryCollection;
import com.poshmark.data_model.models.MyBundles;
import com.poshmark.data_model.models.MyLikes;
import com.poshmark.data_model.models.MySize;
import com.poshmark.data_model.models.NewListing;
import com.poshmark.data_model.models.PMBundle;
import com.poshmark.data_model.models.PMOffer;
import com.poshmark.data_model.models.PMOfferInfo;
import com.poshmark.data_model.models.PMOrder;
import com.poshmark.data_model.models.PartyEventListings;
import com.poshmark.data_model.models.Referral;
import com.poshmark.data_model.models.SearchResults;
import com.poshmark.data_model.models.Showroom;
import com.poshmark.data_model.models.ShowroomGroupList;
import com.poshmark.data_model.models.ShowroomListings;
import com.poshmark.data_model.models.SuggestedSearchResults;
import com.poshmark.data_model.models.UserInteractions;
import com.poshmark.data_model.models.UserReferenceList;
import com.poshmark.data_model.models.UserStateSummary;
import com.poshmark.data_model.models.inner_models.Address;
import com.poshmark.data_model.models.inner_models.Comment;
import com.poshmark.data_model.models.inner_models.ShortUrl;
import com.poshmark.db.AllBrandsModel;
import com.poshmark.http.PMMultipartItem;
import com.poshmark.user.UserInfo;
import com.poshmark.user.UserInfoDetails;
import com.poshmark.utils.meta_data.PinterestBoardList;
import com.poshmark.utils.meta_data.PinterestSettings;
import com.poshmark.utils.sharing.ServerShareMessages;
import com.poshmark.utils.view_holders.MultiMap;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.poshmark.http.api:
//            PMApiRequest, PMApiResponseHandler

public class PMApi
{

    public static String PMTrackingActionKey = "act";
    public static String PMTrackingActionShareBrand = "sh_b";
    public static String PMTrackingActionShareCloset = "sh_c";
    public static String PMTrackingActionShareListing = "sh_l";
    public static String PMTrackingActionShareParty = "sh_p";
    public static String PMTrackingActionShareReferralCode = "sh_r";
    public static String PMTrackingActionShareShowroom = "sh_s";
    public static String PMTrackingMediumKey = "mdm";
    public static String PMTrackingObjectIdKey = "oid";
    public static String PMTrackingScreenBrandShare = "br_s";
    public static String PMTrackingScreenClosetShare = "cl_s";
    public static String PMTrackingScreenJustInBrandShare = "brj_s";
    public static String PMTrackingScreenKey = "scr";
    public static String PMTrackingScreenListingShare = "li_s";
    public static String PMTrackingScreenPartyShare = "pa_s";
    public static String PMTrackingScreenReferralCodeShare = "rc_s";
    public static String PMTrackingScreenShowroomShare = "sh_s";
    public static String PMTrackingShareMediumEmail = "em";
    public static String PMTrackingShareMediumFbDialog = "fbd";
    public static String PMTrackingShareMediumFbMessenger = "fbm";
    public static String PMTrackingShareMediumInstagram = "ins";
    public static String PMTrackingShareMediumPinterest = "pin";
    public static String PMTrackingShareMediumSMS = "sms";

    public PMApi()
    {
    }

    public static void addListingToBundle(String s, String s1, PMApiResponseHandler pmapiresponsehandler)
    {
        (new PMApiRequest(com.poshmark.http.PMHttpRequest.REQUEST_TYPE.HTTP_POST, String.format("/api/users/%s/bundles/users/%s/posts/%s", new Object[] {
            PMApplicationSession.GetPMSession().getUserId(), s, s1
        }), java/lang/Void)).callAPI(pmapiresponsehandler);
    }

    public static void addProductToOffer(String s, Map map, String s1, PMApiResponseHandler pmapiresponsehandler)
    {
        s = new PMApiRequest(com.poshmark.http.PMHttpRequest.REQUEST_TYPE.HTTP_POST, String.format("/api/users/%s/posts/%s/offers/new", new Object[] {
            PMApplicationSession.GetPMSession().getUserId(), s
        }), com/poshmark/data_model/models/PMOfferInfo);
        ((PMApiRequest) (s)).formData.putAll(map);
        if (s1 != null)
        {
            ((PMApiRequest) (s)).formData.put("tr_goal", s1);
        }
        s.callAPI(pmapiresponsehandler);
    }

    public static void addProductToOrder(Map map, String s, PMApiResponseHandler pmapiresponsehandler)
    {
        PMApiRequest pmapirequest = new PMApiRequest(com.poshmark.http.PMHttpRequest.REQUEST_TYPE.HTTP_POST, String.format("/api/users/%s/orders/%s/line_items", new Object[] {
            PMApplicationSession.GetPMSession().getUserId(), "self"
        }), com/poshmark/data_model/models/PMOrder);
        pmapirequest.formData.putAll(map);
        if (s != null)
        {
            pmapirequest.formData.put("tr_goal", s);
        }
        pmapirequest.callAPI(pmapiresponsehandler);
    }

    public static void becameActive(PMApiResponseHandler pmapiresponsehandler, ActiveUserInfo activeuserinfo)
    {
        Object obj = AppInfo.getInstance().deviceID;
        if (obj == null || ((String) (obj)).length() == 0)
        {
            return;
        }
        obj = new PMApiRequest(com.poshmark.http.PMHttpRequest.REQUEST_TYPE.HTTP_PUT, String.format("/api/devices/%s/apps/events/became_active", new Object[] {
            obj
        }), java/lang/Void);
        if (activeuserinfo != null)
        {
            Gson gson = (new GsonBuilder()).create();
            if (!(gson instanceof Gson))
            {
                activeuserinfo = gson.toJson(activeuserinfo, com/poshmark/data_model/models/ActiveUserInfo);
            } else
            {
                activeuserinfo = GsonInstrumentation.toJson((Gson)gson, activeuserinfo, com/poshmark/data_model/models/ActiveUserInfo);
            }
            ((PMApiRequest) (obj)).queryParams.put("source", activeuserinfo);
        }
        ((PMApiRequest) (obj)).callAPI(pmapiresponsehandler);
    }

    public static void blockUser(String s, PMApiResponseHandler pmapiresponsehandler)
    {
        (new PMApiRequest(com.poshmark.http.PMHttpRequest.REQUEST_TYPE.HTTP_POST, String.format("/api/users/%s/blocked/users/%s", new Object[] {
            PMApplicationSession.GetPMSession().getUserId(), s
        }), java/lang/Void)).callAPI(pmapiresponsehandler);
    }

    public static void checkIfPasswordSet(PMApiResponseHandler pmapiresponsehandler)
    {
        String s = String.format("/api/users/%s/password_set", new Object[] {
            PMApplicationSession.GetPMSession().getUserId()
        });
        (new PMApiRequest(com.poshmark.http.PMHttpRequest.REQUEST_TYPE.HTTP_GET, s, com/poshmark/user/UserInfoDetails$PasswordStatus)).callAPI(pmapiresponsehandler);
    }

    public static void createNewUser(Map map, Bitmap bitmap, PMApiResponseHandler pmapiresponsehandler)
    {
        PMApiRequest pmapirequest = new PMApiRequest(com.poshmark.http.PMHttpRequest.REQUEST_TYPE.HTTP_POST, "/api/auth/users", com/poshmark/user/UserInfo);
        pmapirequest.queryParams.putAll(AppInfo.getInstance().deviceInfo);
        pmapirequest.formData.putAll(map);
        map = PMApplicationSession.GetPMSession().getGCMRegId();
        if (map != null && map.length() > 0)
        {
            pmapirequest.queryParams.put("push_token", map);
        }
        if (bitmap != null)
        {
            map = new ByteArrayOutputStream();
            bitmap.compress(android.graphics.Bitmap.CompressFormat.JPEG, 95, map);
            map = map.toByteArray();
            pmapirequest.multipartData.put("file", new PMMultipartItem(map, "image/jpeg", "file.jpg"));
        }
        pmapirequest.callAPI(pmapiresponsehandler);
    }

    public static void deleteComment(String s, String s1, PMApiResponseHandler pmapiresponsehandler)
    {
        (new PMApiRequest(com.poshmark.http.PMHttpRequest.REQUEST_TYPE.HTTP_DELETE, String.format("/api/posts/%s/comments/%s", new Object[] {
            s, s1
        }), java/lang/Void)).callAPI(pmapiresponsehandler);
    }

    public static void deleteListing(String s, PMApiResponseHandler pmapiresponsehandler)
    {
        (new PMApiRequest(com.poshmark.http.PMHttpRequest.REQUEST_TYPE.HTTP_DELETE, String.format("/api/posts/%s", new Object[] {
            s
        }), java/lang/Void)).callAPI(pmapiresponsehandler);
    }

    public static void fbLink(String s, String s1, PMApiResponseHandler pmapiresponsehandler)
    {
        PMApiRequest pmapirequest = new PMApiRequest(com.poshmark.http.PMHttpRequest.REQUEST_TYPE.HTTP_POST, String.format("/api/users/%s/external_services", new Object[] {
            PMApplicationSession.GetPMSession().getUserId()
        }), com/poshmark/data_model/models/ExternalServiceInfo);
        pmapirequest.formData.put("ext_access_token", s);
        pmapirequest.formData.put("ext_token_expr", s1);
        pmapirequest.formData.put("ext_service_id", "fb");
        pmapirequest.callAPI(pmapiresponsehandler);
    }

    public static void followBrand(String s, PMApiResponseHandler pmapiresponsehandler)
    {
        s = s.replace("/", "%2F");
        (new PMApiRequest(com.poshmark.http.PMHttpRequest.REQUEST_TYPE.HTTP_PUT, String.format("/api/brands/%s/followers/%s", new Object[] {
            Uri.encode(s), PMApplicationSession.GetPMSession().getUserId()
        }), java/lang/Void)).callAPI(pmapiresponsehandler);
    }

    public static void followUser(String s, PMApiResponseHandler pmapiresponsehandler)
    {
        (new PMApiRequest(com.poshmark.http.PMHttpRequest.REQUEST_TYPE.HTTP_PUT, String.format("/api/users/%s/followers/%s", new Object[] {
            s, PMApplicationSession.GetPMSession().getUserId()
        }), java/lang/Void)).callAPI(pmapiresponsehandler);
    }

    public static void getAddressConfirmation(Address address, PMApiResponseHandler pmapiresponsehandler)
    {
        Object obj = (new GsonBuilder()).create();
        if (!(obj instanceof Gson))
        {
            address = ((Gson) (obj)).toJson(address, com/poshmark/data_model/models/inner_models/Address);
        } else
        {
            address = GsonInstrumentation.toJson((Gson)obj, address, com/poshmark/data_model/models/inner_models/Address);
        }
        obj = new PMApiRequest(com.poshmark.http.PMHttpRequest.REQUEST_TYPE.HTTP_GET, "/api/addresses", com/poshmark/data_model/models/AddressCheckerResults);
        ((PMApiRequest) (obj)).queryParams.put("address", address);
        ((PMApiRequest) (obj)).callAPI(pmapiresponsehandler);
    }

    public static void getAllBrands(List list, PMApiResponseHandler pmapiresponsehandler)
    {
        PMApiRequest pmapirequest = new PMApiRequest(com.poshmark.http.PMHttpRequest.REQUEST_TYPE.HTTP_GET, "/api/meta/brands", com/poshmark/db/AllBrandsModel);
        String s = new String();
        if (list != null)
        {
            int j = list.size();
            for (int i = 0; i < j; i++)
            {
                String s1 = (new StringBuilder()).append(s).append((String)list.get(i)).toString();
                s = s1;
                if (i < j - 1)
                {
                    s = (new StringBuilder()).append(s1).append(",").toString();
                }
            }

            pmapirequest.queryParams.put("fields", s);
            pmapirequest.callAPI(pmapiresponsehandler);
        }
    }

    public static void getAllFollowingBrands(List list, PMApiResponseHandler pmapiresponsehandler)
    {
        PMApiRequest pmapirequest = new PMApiRequest(com.poshmark.http.PMHttpRequest.REQUEST_TYPE.HTTP_GET, String.format("/api/users/%s/brands/following", new Object[] {
            PMApplicationSession.GetPMSession().getUserId()
        }), com/poshmark/db/AllBrandsModel);
        String s = new String();
        if (list != null)
        {
            int j = list.size();
            for (int i = 0; i < j; i++)
            {
                String s1 = (new StringBuilder()).append(s).append((String)list.get(i)).toString();
                s = s1;
                if (i < j - 1)
                {
                    s = (new StringBuilder()).append(s1).append(",").toString();
                }
            }

            pmapirequest.queryParams.put("fields", s);
            pmapirequest.callAPI(pmapiresponsehandler);
        }
    }

    public static void getBrandMetaData(String s, PMApiResponseHandler pmapiresponsehandler)
    {
        s = s.replace("/", "%2F");
        (new PMApiRequest(com.poshmark.http.PMHttpRequest.REQUEST_TYPE.HTTP_GET, String.format("/api/brands/%s/meta", new Object[] {
            Uri.encode(s)
        }), com/poshmark/data_model/models/Brand)).callAPI(pmapiresponsehandler);
    }

    public static void getBrandShareMessages(String s, PMApiResponseHandler pmapiresponsehandler)
    {
        if (s != null)
        {
            s = s.replace("/", "%2F");
            (new PMApiRequest(com.poshmark.http.PMHttpRequest.REQUEST_TYPE.HTTP_GET, String.format("/api/users/%s/external_shares/brands/%s/share_messages", new Object[] {
                PMApplicationSession.GetPMSession().getUserId(), Uri.encode(s)
            }), com/poshmark/data_model/models/BrandShareMessageContainer)).callAPI(pmapiresponsehandler);
        }
    }

    public static void getBundleFromCloset(String s, PMApiResponseHandler pmapiresponsehandler)
    {
        s = new PMApiRequest(com.poshmark.http.PMHttpRequest.REQUEST_TYPE.HTTP_GET, String.format("/api/users/%s/bundles/users/%s", new Object[] {
            PMApplicationSession.GetPMSession().getUserId(), s
        }), com/poshmark/data_model/models/PMBundle);
        ((PMApiRequest) (s)).queryParams.put("nm", "bnd");
        s.callAPI(pmapiresponsehandler);
    }

    public static void getCatalog(PMApiResponseHandler pmapiresponsehandler)
    {
        (new PMApiRequest(com.poshmark.http.PMHttpRequest.REQUEST_TYPE.HTTP_GET, "/api/meta/catalog", com/poshmark/data_model/models/Catalog)).callAPI(pmapiresponsehandler);
    }

    public static void getCreditCardGatewayData(String s, PMApiResponseHandler pmapiresponsehandler)
    {
        (new PMApiRequest(com.poshmark.http.PMHttpRequest.REQUEST_TYPE.HTTP_GET, String.format("/api/users/%s/orders/%s/gateway-data", new Object[] {
            PMApplicationSession.GetPMSession().getUserId(), s
        }), com/poshmark/data_model/models/BrainTreeGatewayInfo)).callAPI(pmapiresponsehandler);
    }

    public static void getDiscoveredClosets(String s, String s1, PMApiResponseHandler pmapiresponsehandler)
    {
        (new PMApiRequest(com.poshmark.http.PMHttpRequest.REQUEST_TYPE.HTTP_GET, String.format("/api/users/%s/users/discovered", new Object[] {
            s
        }), com/poshmark/data_model/models/UserReferenceList)).callAPI(pmapiresponsehandler);
    }

    public static void getEventSocialListings(String s, String s1, String s2, PMApiResponseHandler pmapiresponsehandler)
    {
        s = new PMApiRequest(com.poshmark.http.PMHttpRequest.REQUEST_TYPE.HTTP_GET, String.format("/api/events/%s/posts", new Object[] {
            s
        }), com/poshmark/data_model/models/Feed_v1);
        ((PMApiRequest) (s)).queryParams.put("summarize", "true");
        ((PMApiRequest) (s)).queryParams.put("count", "40");
        ((PMApiRequest) (s)).queryParams.put("summary_slice", "oldest");
        if (s2 != null)
        {
            ((PMApiRequest) (s)).queryParams.put("max_id", s2);
        }
        if (s1 != null && s1.length() > 0)
        {
            ((PMApiRequest) (s)).queryParams.put("collection", s1);
        }
        s.callAPI(pmapiresponsehandler);
    }

    public static void getEventSummaryListings(String s, String s1, String s2, PMApiResponseHandler pmapiresponsehandler)
    {
        s = new PMApiRequest(com.poshmark.http.PMHttpRequest.REQUEST_TYPE.HTTP_GET, String.format("/api/events/%s/posts", new Object[] {
            s
        }), com/poshmark/data_model/models/PartyEventListings);
        ((PMApiRequest) (s)).queryParams.put("summarize", "true");
        ((PMApiRequest) (s)).queryParams.put("count", "40");
        if (s2 != null)
        {
            ((PMApiRequest) (s)).queryParams.put("max_id", s2);
        }
        if (s1 != null && s1.length() > 0)
        {
            ((PMApiRequest) (s)).queryParams.put("collection", s1);
        }
        s.callAPI(pmapiresponsehandler);
    }

    public static void getEvents(PMApiResponseHandler pmapiresponsehandler)
    {
        (new PMApiRequest(com.poshmark.http.PMHttpRequest.REQUEST_TYPE.HTTP_GET, String.format("/api/users/%s/events/invited", new Object[] {
            PMApplicationSession.GetPMSession().getUserId()
        }), com/poshmark/data_model/models/EventList)).callAPI(pmapiresponsehandler);
    }

    public static void getFacebookFriends(PMApiResponseHandler pmapiresponsehandler)
    {
        PMApiRequest pmapirequest = new PMApiRequest(com.poshmark.http.PMHttpRequest.REQUEST_TYPE.HTTP_GET, String.format("/api/users/%s/connections", new Object[] {
            PMApplicationSession.GetPMSession().getUserId()
        }), com/poshmark/data_model/models/UserReferenceList);
        pmapirequest.queryParams.put("ext_service_id", "fb");
        pmapirequest.queryParams.put("username", PMApplicationSession.GetPMSession().getUserName());
        pmapirequest.callAPI(pmapiresponsehandler);
    }

    public static void getFeatures(PMApiResponseHandler pmapiresponsehandler)
    {
        (new PMApiRequest(com.poshmark.http.PMHttpRequest.REQUEST_TYPE.HTTP_GET, String.format("/api/users/%s/feature_settings", new Object[] {
            PMApplicationSession.GetPMSession().getUserId()
        }), com/poshmark/data_model/models/Features)).callAPI(pmapiresponsehandler);
    }

    public static void getFeed(String s, PMApiResponseHandler pmapiresponsehandler)
    {
        PMApiRequest pmapirequest = new PMApiRequest(com.poshmark.http.PMHttpRequest.REQUEST_TYPE.HTTP_GET, String.format("/api/users/%s/feed", new Object[] {
            PMApplicationSession.GetPMSession().getUserId()
        }), com/poshmark/data_model/models/Feed_v1);
        if (s != null)
        {
            pmapirequest.queryParams.put("max_id", s);
        } else
        {
            pmapirequest.queryParams.put("nm", "fd");
        }
        pmapirequest.callAPI(pmapiresponsehandler);
    }

    public static void getFollowersList(String s, PMApiResponseHandler pmapiresponsehandler)
    {
        s = new PMApiRequest(com.poshmark.http.PMHttpRequest.REQUEST_TYPE.HTTP_GET, String.format("/api/users/%s/followers", new Object[] {
            s
        }), com/poshmark/data_model/models/UserReferenceList);
        ((PMApiRequest) (s)).queryParams.put("count", "500");
        s.callAPI(pmapiresponsehandler);
    }

    public static void getFollowingList(String s, PMApiResponseHandler pmapiresponsehandler)
    {
        s = new PMApiRequest(com.poshmark.http.PMHttpRequest.REQUEST_TYPE.HTTP_GET, String.format("/api/users/%s/following", new Object[] {
            s
        }), com/poshmark/data_model/models/UserReferenceList);
        ((PMApiRequest) (s)).queryParams.put("count", "500");
        s.callAPI(pmapiresponsehandler);
    }

    public static void getHetroFeed(String s, PMApiResponseHandler pmapiresponsehandler)
    {
        PMApiRequest pmapirequest = new PMApiRequest(com.poshmark.http.PMHttpRequest.REQUEST_TYPE.HTTP_GET, String.format("/api/users/%s/feed/personalized", new Object[] {
            PMApplicationSession.GetPMSession().getUserId()
        }), java/lang/Void);
        if (s != null)
        {
            pmapirequest.queryParams.put("max_id", s);
        } else
        {
            pmapirequest.queryParams.put("nm", "fd");
        }
        pmapirequest.callAPI(pmapiresponsehandler);
    }

    public static void getLikersforListing(String s, PMApiResponseHandler pmapiresponsehandler)
    {
        s = new PMApiRequest(com.poshmark.http.PMHttpRequest.REQUEST_TYPE.HTTP_GET, String.format("/api/posts/%s/likes/users", new Object[] {
            s
        }), com/poshmark/data_model/models/UserReferenceList);
        ((PMApiRequest) (s)).queryParams.put("count", "40");
        s.callAPI(pmapiresponsehandler);
    }

    public static void getListingDetails(String s, PMApiResponseHandler pmapiresponsehandler)
    {
        (new PMApiRequest(com.poshmark.http.PMHttpRequest.REQUEST_TYPE.HTTP_GET, String.format("/api/posts/%s", new Object[] {
            s
        }), com/poshmark/data_model/models/ListingDetails)).callAPI(pmapiresponsehandler);
    }

    public static void getListingsForBrand(String s, String s1, String s2, String s3, String s4, PMApiResponseHandler pmapiresponsehandler)
    {
        s = s.replace("/", "%2F");
        s = new PMApiRequest(com.poshmark.http.PMHttpRequest.REQUEST_TYPE.HTTP_GET, String.format("/api/brands/%s/posts", new Object[] {
            Uri.encode(s)
        }), com/poshmark/data_model/models/SearchResults);
        ((PMApiRequest) (s)).queryParams.put("summarize", "true");
        ((PMApiRequest) (s)).queryParams.put("count", "40");
        ((PMApiRequest) (s)).queryParams.put("request", s1);
        if (s3 != null)
        {
            ((PMApiRequest) (s)).queryParams.put("nm", s3);
        }
        if (s4 != null)
        {
            ((PMApiRequest) (s)).queryParams.put("src", s4);
        }
        if (s2 != null)
        {
            ((PMApiRequest) (s)).queryParams.put("max_id", s2);
        }
        s.callAPI(pmapiresponsehandler);
    }

    public static void getMyBundles(String s, PMApiResponseHandler pmapiresponsehandler)
    {
        PMApiRequest pmapirequest = new PMApiRequest(com.poshmark.http.PMHttpRequest.REQUEST_TYPE.HTTP_GET, String.format("/api/users/%s/bundles", new Object[] {
            PMApplicationSession.GetPMSession().getUserId()
        }), com/poshmark/data_model/models/MyBundles);
        if (s != null)
        {
            pmapirequest.queryParams.put("max_id", s);
        }
        pmapirequest.queryParams.put("posts_per_bundle", "3");
        pmapirequest.callAPI(pmapiresponsehandler);
    }

    public static void getMyLikedListings(String s, PMApiResponseHandler pmapiresponsehandler)
    {
        PMApiRequest pmapirequest = new PMApiRequest(com.poshmark.http.PMHttpRequest.REQUEST_TYPE.HTTP_GET, String.format("/api/users/%s/posts/liked", new Object[] {
            PMApplicationSession.GetPMSession().getUserId()
        }), com/poshmark/data_model/models/MyLikes);
        pmapirequest.queryParams.put("summarize", "true");
        pmapirequest.queryParams.put("count", "40");
        if (s != null)
        {
            pmapirequest.queryParams.put("max_id", s);
        } else
        {
            pmapirequest.queryParams.put("nm", "mlk");
        }
        pmapirequest.callAPI(pmapiresponsehandler);
    }

    public static void getMyLikedListingsFiltered(String s, String s1, String s2, PMApiResponseHandler pmapiresponsehandler)
    {
        PMApiRequest pmapirequest = new PMApiRequest(com.poshmark.http.PMHttpRequest.REQUEST_TYPE.HTTP_GET, String.format("/api/users/%s/posts/liked/filtered", new Object[] {
            PMApplicationSession.GetPMSession().getUserId()
        }), com/poshmark/data_model/models/MyLikes);
        pmapirequest.queryParams.put("summarize", "true");
        pmapirequest.queryParams.put("count", "40");
        if (s1 != null)
        {
            pmapirequest.queryParams.put("request", s1);
        }
        if (s != null)
        {
            pmapirequest.queryParams.put("max_id", s);
        }
        if (s2 != null)
        {
            pmapirequest.queryParams.put("nm", s2);
        }
        pmapirequest.callAPI(pmapiresponsehandler);
    }

    public static void getMyLikesFacets(String s, PMApiResponseHandler pmapiresponsehandler)
    {
        PMApiRequest pmapirequest = new PMApiRequest(com.poshmark.http.PMHttpRequest.REQUEST_TYPE.HTTP_GET, String.format("/api/users/%s/posts/liked/filtered", new Object[] {
            PMApplicationSession.GetPMSession().getUserId()
        }), com/poshmark/data_model/models/MyLikes);
        pmapirequest.queryParams.put("summarize", "true");
        pmapirequest.queryParams.put("count", "1");
        if (s != null)
        {
            pmapirequest.queryParams.put("request", s);
        }
        pmapirequest.callAPI(pmapiresponsehandler);
    }

    public static void getMySize(PMApiResponseHandler pmapiresponsehandler)
    {
        (new PMApiRequest(com.poshmark.http.PMHttpRequest.REQUEST_TYPE.HTTP_GET, String.format("/api/users/%s/sizes", new Object[] {
            PMApplicationSession.GetPMSession().getUserId()
        }), com/poshmark/data_model/models/MySize)).callAPI(pmapiresponsehandler);
    }

    public static void getNewlyJoinedClosets(String s, String s1, PMApiResponseHandler pmapiresponsehandler)
    {
        (new PMApiRequest(com.poshmark.http.PMHttpRequest.REQUEST_TYPE.HTTP_GET, String.format("/api/users/%s/users/suggested/newly_joined", new Object[] {
            s
        }), com/poshmark/data_model/models/UserReferenceList)).callAPI(pmapiresponsehandler);
    }

    public static void getNewlyOpenedClosets(String s, String s1, PMApiResponseHandler pmapiresponsehandler)
    {
        (new PMApiRequest(com.poshmark.http.PMHttpRequest.REQUEST_TYPE.HTTP_GET, String.format("/api/users/%s/users/suggested/newly_opened", new Object[] {
            s
        }), com/poshmark/data_model/models/UserReferenceList)).callAPI(pmapiresponsehandler);
    }

    public static void getOffer(String s, String s1, PMApiResponseHandler pmapiresponsehandler)
    {
        s = new PMApiRequest(com.poshmark.http.PMHttpRequest.REQUEST_TYPE.HTTP_GET, String.format("/api/users/%s/offers/%s/checkout", new Object[] {
            PMApplicationSession.GetPMSession().getUserId(), s
        }), com/poshmark/data_model/models/PMOfferInfo);
        if (s1 != null)
        {
            ((PMApiRequest) (s)).formData.put("tr_goal", s1);
        }
        s.callAPI(pmapiresponsehandler);
    }

    public static void getPinterestBoards(PMApiResponseHandler pmapiresponsehandler)
    {
        (new PMApiRequest(com.poshmark.http.PMHttpRequest.REQUEST_TYPE.HTTP_GET, String.format("/api/users/%s/external_services/pinterest/boards", new Object[] {
            PMApplicationSession.GetPMSession().getUserId()
        }), com/poshmark/utils/meta_data/PinterestBoardList)).callAPI(pmapiresponsehandler);
    }

    public static void getPinterestSettings(PMApiResponseHandler pmapiresponsehandler)
    {
        (new PMApiRequest(com.poshmark.http.PMHttpRequest.REQUEST_TYPE.HTTP_GET, String.format("/api/users/%s/settings/pinterest", new Object[] {
            PMApplicationSession.GetPMSession().getUserId()
        }), com/poshmark/utils/meta_data/PinterestSettings)).callAPI(pmapiresponsehandler);
    }

    public static void getReferralCode(PMApiResponseHandler pmapiresponsehandler)
    {
        (new PMApiRequest(com.poshmark.http.PMHttpRequest.REQUEST_TYPE.HTTP_GET, String.format("/api/users/%s/referral_codes/join", new Object[] {
            PMApplicationSession.GetPMSession().getUserId()
        }), com/poshmark/data_model/models/Referral)).callAPI(pmapiresponsehandler);
    }

    public static void getSearchResults(String s, String s1, String s2, String s3, PMApiResponseHandler pmapiresponsehandler)
    {
        PMApiRequest pmapirequest = new PMApiRequest(com.poshmark.http.PMHttpRequest.REQUEST_TYPE.HTTP_GET, String.format("/api/posts", new Object[0]), com/poshmark/data_model/models/SearchResults);
        pmapirequest.queryParams.put("summarize", "true");
        pmapirequest.queryParams.put("count", "40");
        pmapirequest.queryParams.put("request", s);
        if (s2 != null)
        {
            pmapirequest.queryParams.put("nm", s2);
        }
        if (s3 != null)
        {
            pmapirequest.queryParams.put("src", s3);
        }
        if (s1 != null)
        {
            pmapirequest.queryParams.put("max_id", s1);
        }
        pmapirequest.callAPI(pmapiresponsehandler);
    }

    public static void getShareBannerImage(String s, PMApiResponseHandler pmapiresponsehandler)
    {
        if (s != null)
        {
            s = s.replace("/", "%2F");
            PMApiRequest pmapirequest = new PMApiRequest(com.poshmark.http.PMHttpRequest.REQUEST_TYPE.HTTP_GET, String.format("/api/users/%s/external_services/banner_content", new Object[] {
                PMApplicationSession.GetPMSession().getUserId()
            }), java/lang/Void);
            pmapirequest.queryParams.put("data", s);
            pmapirequest.callAPI(pmapiresponsehandler);
        }
    }

    public static void getShareMessagesFromServer(String s, PMApiResponseHandler pmapiresponsehandler)
    {
        (new PMApiRequest(com.poshmark.http.PMHttpRequest.REQUEST_TYPE.HTTP_GET, s, com/poshmark/utils/sharing/ServerShareMessages)).callAPI(pmapiresponsehandler);
    }

    public static void getShowroom(String s, PMApiResponseHandler pmapiresponsehandler)
    {
        (new PMApiRequest(com.poshmark.http.PMHttpRequest.REQUEST_TYPE.HTTP_GET, String.format("/api/collections/%s", new Object[] {
            s
        }), com/poshmark/data_model/models/Showroom)).callAPI(pmapiresponsehandler);
    }

    public static void getShowroomListings(String s, String s1, String s2, String s3, PMApiResponseHandler pmapiresponsehandler)
    {
        s = new PMApiRequest(com.poshmark.http.PMHttpRequest.REQUEST_TYPE.HTTP_GET, String.format("/api/collections/%s/items", new Object[] {
            s
        }), com/poshmark/data_model/models/ShowroomListings);
        ((PMApiRequest) (s)).queryParams.put("summarize", "true");
        ((PMApiRequest) (s)).queryParams.put("count", "40");
        ((PMApiRequest) (s)).queryParams.put("summary_slice", "oldest");
        if (s2 != null)
        {
            ((PMApiRequest) (s)).queryParams.put("request", s2);
        }
        if (s1 != null)
        {
            ((PMApiRequest) (s)).queryParams.put("max_id", s1);
        }
        if (s3 != null)
        {
            ((PMApiRequest) (s)).queryParams.put("nm", s3);
        }
        s.callAPI(pmapiresponsehandler);
    }

    public static void getShowrooms(PMApiResponseHandler pmapiresponsehandler)
    {
        (new PMApiRequest(com.poshmark.http.PMHttpRequest.REQUEST_TYPE.HTTP_GET, String.format("/api/users/%s/collections/posts/feed/summary", new Object[] {
            PMApplicationSession.GetPMSession().getUserId()
        }), com/poshmark/data_model/models/ShowroomGroupList)).callAPI(pmapiresponsehandler);
    }

    public static void getSimilarListing(String s, int i, PMApiResponseHandler pmapiresponsehandler)
    {
        s = new PMApiRequest(com.poshmark.http.PMHttpRequest.REQUEST_TYPE.HTTP_GET, String.format("/api/posts/%s/related/posts", new Object[] {
            s
        }), com/poshmark/data_model/models/ListingSummaryCollection);
        ((PMApiRequest) (s)).queryParams.put("summarize", "true");
        ((PMApiRequest) (s)).queryParams.put("count", Integer.toString(i));
        s.callAPI(pmapiresponsehandler);
    }

    public static void getSuggestedBrandsForUser(PMApiResponseHandler pmapiresponsehandler)
    {
        (new PMApiRequest(com.poshmark.http.PMHttpRequest.REQUEST_TYPE.HTTP_GET, String.format("/api/users/%s/brands/suggested", new Object[] {
            PMApplicationSession.GetPMSession().getUserId()
        }), com/poshmark/db/AllBrandsModel)).callAPI(pmapiresponsehandler);
    }

    public static void getSuggestedSearch(String s, PMApiResponseHandler pmapiresponsehandler)
    {
        PMApiRequest pmapirequest = new PMApiRequest(com.poshmark.http.PMHttpRequest.REQUEST_TYPE.HTTP_GET, "/api/searches/suggested", com/poshmark/data_model/models/SuggestedSearchResults);
        pmapirequest.queryParams.put("for_user_id", PMApplicationSession.GetPMSession().getUserId());
        pmapirequest.queryParams.put("query", s);
        pmapirequest.callAPI(pmapiresponsehandler);
    }

    public static void getSuggestedUsers(String s, boolean flag, int i, PMApiResponseHandler pmapiresponsehandler)
    {
        Object obj = "/api/users/suggested";
        if (flag)
        {
            obj = (new StringBuilder()).append("/api/users/suggested").append("/new_user").toString();
        }
        obj = new PMApiRequest(com.poshmark.http.PMHttpRequest.REQUEST_TYPE.HTTP_GET, ((String) (obj)), com/poshmark/data_model/models/UserReferenceList);
        ((PMApiRequest) (obj)).queryParams.put("for_user_id", s);
        if (i > 0)
        {
            ((PMApiRequest) (obj)).queryParams.put("view_count", Integer.toString(i));
        }
        ((PMApiRequest) (obj)).callAPI(pmapiresponsehandler);
    }

    public static void getTinyURLForUser(String s, PMApiResponseHandler pmapiresponsehandler)
    {
        (new PMApiRequest(com.poshmark.http.PMHttpRequest.REQUEST_TYPE.HTTP_GET, String.format("/api/users/%s/short_url", new Object[] {
            s
        }), com/poshmark/data_model/models/inner_models/ShortUrl)).callAPI(pmapiresponsehandler);
    }

    public static void getTinyUrlForListing(String s, PMApiResponseHandler pmapiresponsehandler)
    {
        (new PMApiRequest(com.poshmark.http.PMHttpRequest.REQUEST_TYPE.HTTP_GET, String.format("/api/posts/%s/short_url", new Object[] {
            s
        }), com/poshmark/data_model/models/inner_models/ShortUrl)).callAPI(pmapiresponsehandler);
    }

    public static void getTwitterConnections(PMApiResponseHandler pmapiresponsehandler)
    {
        PMApiRequest pmapirequest = new PMApiRequest(com.poshmark.http.PMHttpRequest.REQUEST_TYPE.HTTP_GET, String.format("/api/users/%s/connections", new Object[] {
            PMApplicationSession.GetPMSession().getUserId()
        }), com/poshmark/data_model/models/UserReferenceList);
        pmapirequest.queryParams.put("ext_service_id", "tw");
        pmapirequest.queryParams.put("username", PMApplicationSession.GetPMSession().getUserName());
        pmapirequest.callAPI(pmapiresponsehandler);
    }

    public static void getUserCloset(String s, String s1, PMApiResponseHandler pmapiresponsehandler)
    {
        s = new PMApiRequest(com.poshmark.http.PMHttpRequest.REQUEST_TYPE.HTTP_GET, String.format("/api/users/%s/posts", new Object[] {
            s
        }), com/poshmark/data_model/models/ListingSummaryCollection);
        ((PMApiRequest) (s)).queryParams.put("summarize", "true");
        ((PMApiRequest) (s)).queryParams.put("count", "40");
        if (s1 != null)
        {
            ((PMApiRequest) (s)).queryParams.put("max_id", s1);
        } else
        {
            ((PMApiRequest) (s)).queryParams.put("nm", "cl");
        }
        s.callAPI(pmapiresponsehandler);
    }

    public static void getUserClosetFacets(String s, String s1, PMApiResponseHandler pmapiresponsehandler)
    {
        s = new PMApiRequest(com.poshmark.http.PMHttpRequest.REQUEST_TYPE.HTTP_GET, String.format("/api/users/%s/posts/filtered", new Object[] {
            s
        }), com/poshmark/data_model/models/ListingSummaryCollection);
        ((PMApiRequest) (s)).queryParams.put("summarize", "true");
        ((PMApiRequest) (s)).queryParams.put("count", "1");
        if (s1 != null)
        {
            ((PMApiRequest) (s)).queryParams.put("request", s1);
        }
        s.callAPI(pmapiresponsehandler);
    }

    public static void getUserClosetFiltered(String s, String s1, String s2, PMApiResponseHandler pmapiresponsehandler)
    {
        s = new PMApiRequest(com.poshmark.http.PMHttpRequest.REQUEST_TYPE.HTTP_GET, String.format("/api/users/%s/posts/filtered", new Object[] {
            s
        }), com/poshmark/data_model/models/ListingSummaryCollection);
        ((PMApiRequest) (s)).queryParams.put("summarize", "true");
        ((PMApiRequest) (s)).queryParams.put("count", "40");
        if (s2 != null)
        {
            ((PMApiRequest) (s)).queryParams.put("request", s2);
        }
        if (s1 != null)
        {
            ((PMApiRequest) (s)).queryParams.put("max_id", s1);
        }
        s.callAPI(pmapiresponsehandler);
    }

    public static void getUserInteractionsList(String s, PMApiResponseHandler pmapiresponsehandler)
    {
        (new PMApiRequest(com.poshmark.http.PMHttpRequest.REQUEST_TYPE.HTTP_GET, String.format("/api/users/%s/interactions/users", new Object[] {
            s
        }), com/poshmark/data_model/models/UserInteractions)).callAPI(pmapiresponsehandler);
    }

    public static void getUserProfile(String s, PMApiResponseHandler pmapiresponsehandler)
    {
        (new PMApiRequest(com.poshmark.http.PMHttpRequest.REQUEST_TYPE.HTTP_GET, String.format("/api/users/%s", new Object[] {
            s
        }), com/poshmark/user/UserInfoDetails)).callAPI(pmapiresponsehandler);
    }

    public static void getUserSettings(PMApiResponseHandler pmapiresponsehandler)
    {
        (new PMApiRequest(com.poshmark.http.PMHttpRequest.REQUEST_TYPE.HTTP_GET, String.format("/api/users/%s/settings", new Object[] {
            PMApplicationSession.GetPMSession().getUserId()
        }), com/poshmark/user/UserInfoDetails$Settings)).callAPI(pmapiresponsehandler);
    }

    public static void getUserSharesList(String s, String s1, PMApiResponseHandler pmapiresponsehandler)
    {
        s = new PMApiRequest(com.poshmark.http.PMHttpRequest.REQUEST_TYPE.HTTP_GET, String.format("/api/users/%s/shared_posts", new Object[] {
            s
        }), com/poshmark/data_model/models/ListingSummaryCollection);
        ((PMApiRequest) (s)).queryParams.put("summarize", "true");
        ((PMApiRequest) (s)).queryParams.put("count", "40");
        if (s1 != null)
        {
            ((PMApiRequest) (s)).queryParams.put("max_id", s1);
        } else
        {
            ((PMApiRequest) (s)).queryParams.put("nm", "ush");
        }
        s.callAPI(pmapiresponsehandler);
    }

    public static void getUserSummary(PMApiResponseHandler pmapiresponsehandler)
    {
        PMApiRequest pmapirequest = new PMApiRequest(com.poshmark.http.PMHttpRequest.REQUEST_TYPE.HTTP_GET, String.format("/api/users/%s/state/summary", new Object[] {
            PMApplicationSession.GetPMSession().getUserId()
        }), com/poshmark/data_model/models/UserStateSummary);
        pmapirequest.queryParams.put("notifications", "true");
        pmapirequest.queryParams.put("event_invites", "true");
        pmapirequest.queryParams.put("info", "true");
        pmapirequest.queryParams.put("user_info", "true");
        pmapirequest.queryParams.put("collections", "true");
        pmapirequest.queryParams.put("active_user_tracking", "false");
        pmapirequest.queryParams.put("feature_settings", "true");
        pmapirequest.queryParams.put("brands", "true");
        pmapirequest.queryParams.put("catalog", "true");
        pmapirequest.callAPI(pmapiresponsehandler);
    }

    public static void getViewTrackingInfo(String s)
    {
        PMApiRequest pmapirequest = new PMApiRequest(com.poshmark.http.PMHttpRequest.REQUEST_TYPE.HTTP_GET, "/trk/view", java/lang/Void, "https://tr.poshmark.com");
        if (s != null)
        {
            pmapirequest.queryParams.put("nm", s);
        }
        s = PMApplicationSession.GetPMSession().getUserId();
        if (s != null)
        {
            pmapirequest.queryParams.put("user_id", s);
        }
        pmapirequest.callAPI(null);
    }

    public static void getViewTrackingInfo(Map map)
    {
        PMApiRequest pmapirequest = new PMApiRequest(com.poshmark.http.PMHttpRequest.REQUEST_TYPE.HTTP_GET, "/trk/view", java/lang/Void, "https://tr.poshmark.com");
        pmapirequest.queryParams.putAll(map);
        map = PMApplicationSession.GetPMSession().getUserId();
        if (map != null)
        {
            pmapirequest.queryParams.put("user_id", map);
        }
        pmapirequest.callAPI(null);
    }

    public static void gpLogin(String s, PMApiResponseHandler pmapiresponsehandler)
    {
        PMApiRequest pmapirequest = new PMApiRequest(com.poshmark.http.PMHttpRequest.REQUEST_TYPE.HTTP_POST, "/api/auth/users/access_token", com/poshmark/user/UserInfo);
        pmapirequest.formData.put("ext_access_token", s);
        pmapirequest.formData.put("ext_service_id", "gp");
        pmapirequest.queryParams.putAll(AppInfo.getInstance().deviceInfo);
        s = PMApplicationSession.GetPMSession().getGCMRegId();
        if (s != null && s.length() > 0)
        {
            pmapirequest.queryParams.put("push_token", s);
        }
        pmapirequest.callAPI(pmapiresponsehandler);
    }

    public static void inviteFriends(String s, String s1, String s2, PMApiResponseHandler pmapiresponsehandler)
    {
        Object obj = String.format("/api/users/%s/external_shares/invites/join", new Object[] {
            PMApplicationSession.GetPMSession().getUserId()
        });
        obj = new PMApiRequest(com.poshmark.http.PMHttpRequest.REQUEST_TYPE.HTTP_PUT, ((String) (obj)), java/lang/Void);
        if (s2 != null && s2.length() > 0)
        {
            ((PMApiRequest) (obj)).queryParams.put("ext_service_id", s2);
        }
        if (s != null && s.length() > 0)
        {
            ((PMApiRequest) (obj)).queryParams.put("referral_code", s);
        }
        if (s1 != null && s1.length() > 0)
        {
            ((PMApiRequest) (obj)).queryParams.put("message", s1);
        }
        ((PMApiRequest) (obj)).callAPI(pmapiresponsehandler);
    }

    public static void like(String s, String s1, PMApiResponseHandler pmapiresponsehandler)
    {
        s = new PMApiRequest(com.poshmark.http.PMHttpRequest.REQUEST_TYPE.HTTP_POST, String.format("/api/posts/%s/likes", new Object[] {
            s
        }), java/lang/Void);
        if (s1 != null)
        {
            ((PMApiRequest) (s)).formData.put("tr_goal", s1);
        }
        s.callAPI(pmapiresponsehandler);
    }

    public static void logout(PMApiResponseHandler pmapiresponsehandler)
    {
        PMApiRequest pmapirequest = new PMApiRequest(com.poshmark.http.PMHttpRequest.REQUEST_TYPE.HTTP_DELETE, String.format("/api/auth/access_token/%s", new Object[] {
            PMApplicationSession.GetPMSession().getAccessToken()
        }), java/lang/Void);
        pmapirequest.queryParams.putAll(AppInfo.getInstance().deviceInfo);
        pmapirequest.callAPI(pmapiresponsehandler);
    }

    public static void pinterestLink(String s, String s1, PMApiResponseHandler pmapiresponsehandler)
    {
        PMApiRequest pmapirequest = new PMApiRequest(com.poshmark.http.PMHttpRequest.REQUEST_TYPE.HTTP_POST, String.format("/api/users/%s/external_services", new Object[] {
            PMApplicationSession.GetPMSession().getUserId()
        }), com/poshmark/data_model/models/ExternalServiceInfo);
        pmapirequest.formData.put("ext_access_token", s);
        pmapirequest.formData.put("ext_permissions", s1);
        pmapirequest.formData.put("ext_service_id", "pn");
        pmapirequest.callAPI(pmapiresponsehandler);
    }

    public static void pmLogin(String s, String s1, HashMap hashmap, PMApiResponseHandler pmapiresponsehandler)
    {
        PMApiRequest pmapirequest = new PMApiRequest(com.poshmark.http.PMHttpRequest.REQUEST_TYPE.HTTP_POST, "/api/auth/users/access_token", com/poshmark/user/UserInfo);
        pmapirequest.formData.put("user_handle", s);
        pmapirequest.formData.put("password", s1);
        if (hashmap != null && !hashmap.isEmpty())
        {
            pmapirequest.queryParams.putAll(hashmap);
        }
        s = PMApplicationSession.GetPMSession().getGCMRegId();
        if (s != null && s.length() > 0)
        {
            pmapirequest.queryParams.put("push_token", s);
        }
        pmapirequest.queryParams.putAll(AppInfo.getInstance().deviceInfo);
        pmapirequest.callAPI(pmapiresponsehandler);
    }

    public static void postComment(String s, String s1, String s2, PMApiResponseHandler pmapiresponsehandler)
    {
        s = new PMApiRequest(com.poshmark.http.PMHttpRequest.REQUEST_TYPE.HTTP_POST, String.format("/api/posts/%s/comments", new Object[] {
            s
        }), com/poshmark/data_model/models/inner_models/Comment);
        ((PMApiRequest) (s)).formData.put("comment", s1);
        if (s2 != null)
        {
            ((PMApiRequest) (s)).formData.put("tr_goal", s2);
        }
        s.callAPI(pmapiresponsehandler);
    }

    public static void postFacebookTimelineFlag(boolean flag, PMApiResponseHandler pmapiresponsehandler)
    {
        int i = 1;
        PMApiRequest pmapirequest = new PMApiRequest(com.poshmark.http.PMHttpRequest.REQUEST_TYPE.HTTP_POST, String.format("/api/users/%s/settings", new Object[] {
            PMApplicationSession.GetPMSession().getUserId()
        }), java/lang/Void);
        if (!flag)
        {
            i = 0;
        }
        pmapirequest.formData.put("timeline", Integer.toString(i));
        pmapirequest.callAPI(pmapiresponsehandler);
    }

    public static void postGoalTrackingInfo(String s)
    {
        PMApiRequest pmapirequest = new PMApiRequest(com.poshmark.http.PMHttpRequest.REQUEST_TYPE.HTTP_POST, "/trk/goal", java/lang/Void, "https://tr.poshmark.com");
        if (s != null)
        {
            pmapirequest.formData.put("tr_goal", s);
        }
        s = PMApplicationSession.GetPMSession().getUserId();
        if (s != null)
        {
            pmapirequest.formData.put("user_id", s);
        }
        pmapirequest.callAPI(null);
    }

    public static void postImageToListing(String s, String s1, PMApiResponseHandler pmapiresponsehandler)
    {
        s1 = new PMApiRequest(com.poshmark.http.PMHttpRequest.REQUEST_TYPE.HTTP_POST, String.format("/api/posts/%s/media", new Object[] {
            s1
        }), java/lang/Void, "https://up.poshmark.com");
        ((PMApiRequest) (s1)).queryParams.putAll(AppInfo.getInstance().deviceInfo);
        ((PMApiRequest) (s1)).multipartData.put("file", PMMultipartItem.getMultipartJPGItem(s));
        s1.callAPI(pmapiresponsehandler);
    }

    public static void postNewListing(String s, NewListing newlisting, PMApiResponseHandler pmapiresponsehandler)
    {
        PMApiRequest pmapirequest = new PMApiRequest(com.poshmark.http.PMHttpRequest.REQUEST_TYPE.HTTP_POST, "/api/users/self/posts", com/poshmark/data_model/ID, "https://up.poshmark.com");
        pmapirequest.queryParams.putAll(AppInfo.getInstance().deviceInfo);
        pmapirequest.multipartData.put("file", PMMultipartItem.getMultipartJPGItem(s));
        pmapirequest.formData.putAll(newlisting.getListingInfoHash());
        pmapirequest.callAPI(pmapiresponsehandler);
    }

    public static void postNewPassword(String s, String s1, PMApiResponseHandler pmapiresponsehandler)
    {
        PMApiRequest pmapirequest = new PMApiRequest(com.poshmark.http.PMHttpRequest.REQUEST_TYPE.HTTP_POST, String.format("/api/users/%s/password", new Object[] {
            PMApplicationSession.GetPMSession().getUserId()
        }), com/poshmark/user/UserInfo);
        pmapirequest.formData.put("new_password", s);
        pmapirequest.formData.put("old_password", s1);
        pmapirequest.callAPI(pmapiresponsehandler);
    }

    public static void postOffer(String s, Map map, String s1, PMApiResponseHandler pmapiresponsehandler)
    {
        s = new PMApiRequest(com.poshmark.http.PMHttpRequest.REQUEST_TYPE.HTTP_POST, String.format("/api/users/%s/offers/%s/checkout", new Object[] {
            PMApplicationSession.GetPMSession().getUserId(), s
        }), com/poshmark/data_model/models/PMOffer);
        ((PMApiRequest) (s)).formData.putAll(map);
        if (s1 != null)
        {
            ((PMApiRequest) (s)).formData.put("tr_goal", s1);
        }
        s.callAPI(pmapiresponsehandler);
    }

    public static void postOfferAddresses(String s, Map map, PMApiResponseHandler pmapiresponsehandler)
    {
        s = new PMApiRequest(com.poshmark.http.PMHttpRequest.REQUEST_TYPE.HTTP_POST, String.format("/api/users/%s/offers/%s/addresses", new Object[] {
            PMApplicationSession.GetPMSession().getUserId(), s
        }), com/poshmark/data_model/models/PMOfferInfo);
        ((PMApiRequest) (s)).formData.putAll(map);
        s.callAPI(pmapiresponsehandler);
    }

    public static void postOrder(String s, Map map, String s1, PMApiResponseHandler pmapiresponsehandler)
    {
        s = new PMApiRequest(com.poshmark.http.PMHttpRequest.REQUEST_TYPE.HTTP_POST, String.format("/api/users/%s/orders/%s", new Object[] {
            PMApplicationSession.GetPMSession().getUserId(), s
        }), com/poshmark/data_model/models/PMOrder);
        ((PMApiRequest) (s)).formData.putAll(map);
        if (s1 != null)
        {
            ((PMApiRequest) (s)).formData.put("tr_goal", s1);
        }
        s.callAPI(pmapiresponsehandler);
    }

    public static void postOrderAddresses(String s, Map map, PMApiResponseHandler pmapiresponsehandler)
    {
        s = new PMApiRequest(com.poshmark.http.PMHttpRequest.REQUEST_TYPE.HTTP_POST, String.format("/api/users/%s/orders/%s/addresses", new Object[] {
            PMApplicationSession.GetPMSession().getUserId(), s
        }), com/poshmark/data_model/models/PMOrder);
        ((PMApiRequest) (s)).formData.putAll(map);
        s.callAPI(pmapiresponsehandler);
    }

    public static void postPinterestBoardsUpdate(Map map, PMApiResponseHandler pmapiresponsehandler)
    {
        PMApiRequest pmapirequest = new PMApiRequest(com.poshmark.http.PMHttpRequest.REQUEST_TYPE.HTTP_POST, String.format("/api/users/%s/settings", new Object[] {
            PMApplicationSession.GetPMSession().getUserId()
        }), java/lang/Void);
        pmapirequest.nestedFormData.putNestedFormParams("pins", map);
        pmapirequest.callAPI(pmapiresponsehandler);
    }

    public static void postSearchVisibilityFlag(boolean flag, PMApiResponseHandler pmapiresponsehandler)
    {
        int i = 1;
        PMApiRequest pmapirequest = new PMApiRequest(com.poshmark.http.PMHttpRequest.REQUEST_TYPE.HTTP_POST, String.format("/api/users/%s/settings", new Object[] {
            PMApplicationSession.GetPMSession().getUserId()
        }), java/lang/Void);
        if (!flag)
        {
            i = 0;
        }
        pmapirequest.formData.put("search_visibility", Integer.toString(i));
        pmapirequest.callAPI(pmapiresponsehandler);
    }

    public static void postUpdateListing(String s, NewListing newlisting, Map map, PMApiResponseHandler pmapiresponsehandler)
    {
        s = new PMApiRequest(com.poshmark.http.PMHttpRequest.REQUEST_TYPE.HTTP_POST, String.format("/api/posts/%s", new Object[] {
            s
        }), java/lang/Void, "https://up.poshmark.com");
        ((PMApiRequest) (s)).queryParams.putAll(AppInfo.getInstance().deviceInfo);
        java.util.Map.Entry entry;
        for (map = map.entrySet().iterator(); map.hasNext(); ((PMApiRequest) (s)).multipartData.put(entry.getKey(), PMMultipartItem.getMultipartJPGItem((String)entry.getValue())))
        {
            entry = (java.util.Map.Entry)map.next();
        }

        ((PMApiRequest) (s)).formData.putAll(newlisting.getListingInfoHash());
        s.callAPI(pmapiresponsehandler);
    }

    public static void publishListing(String s, String s1, String s2, PMApiResponseHandler pmapiresponsehandler)
    {
        s = new PMApiRequest(com.poshmark.http.PMHttpRequest.REQUEST_TYPE.HTTP_PUT, String.format("/api/posts/%s/status/published", new Object[] {
            s
        }), java/lang/Void);
        ((PMApiRequest) (s)).queryParams.putAll(AppInfo.getInstance().deviceInfo);
        if (s1 != null && s1.length() > 0)
        {
            ((PMApiRequest) (s)).queryParams.put("ext_service_ids", s1);
        }
        if (s2 != null && s2.length() > 0)
        {
            ((PMApiRequest) (s)).queryParams.put("event_ids", s2);
        }
        s.callAPI(pmapiresponsehandler);
    }

    public static void putGCMPushToken(String s, PMApiResponseHandler pmapiresponsehandler)
    {
        String s1 = AppInfo.getInstance().deviceID;
        if (s1 == null || s1.length() == 0)
        {
            return;
        } else
        {
            s = new PMApiRequest(com.poshmark.http.PMHttpRequest.REQUEST_TYPE.HTTP_PUT, String.format("/api/devices/%s/push_token/%s", new Object[] {
                s1, s
            }), java/lang/Void);
            ((PMApiRequest) (s)).queryParams.putAll(AppInfo.getInstance().deviceInfo);
            s.callAPI(pmapiresponsehandler);
            return;
        }
    }

    public static void releaseBundle(String s, PMApiResponseHandler pmapiresponsehandler)
    {
        (new PMApiRequest(com.poshmark.http.PMHttpRequest.REQUEST_TYPE.HTTP_DELETE, String.format("/api/users/%s/orders/%s/line_items/all", new Object[] {
            PMApplicationSession.GetPMSession().getUserId(), s
        }), com/poshmark/data_model/models/Referral)).callAPI(pmapiresponsehandler);
    }

    public static void releaseOrder(String s, String s1, PMApiResponseHandler pmapiresponsehandler)
    {
        (new PMApiRequest(com.poshmark.http.PMHttpRequest.REQUEST_TYPE.HTTP_DELETE, String.format("/api/users/%s/orders/%s/line_items/%s", new Object[] {
            PMApplicationSession.GetPMSession().getUserId(), s1, s
        }), com/poshmark/data_model/models/Referral)).callAPI(pmapiresponsehandler);
    }

    public static void removeListingFromBundle(String s, String s1, PMApiResponseHandler pmapiresponsehandler)
    {
        (new PMApiRequest(com.poshmark.http.PMHttpRequest.REQUEST_TYPE.HTTP_DELETE, String.format("/api/users/%s/bundles/users/%s/posts/%s", new Object[] {
            PMApplicationSession.GetPMSession().getUserId(), s, s1
        }), java/lang/Void)).callAPI(pmapiresponsehandler);
    }

    public static void reportListing(String s, String s1, PMApiResponseHandler pmapiresponsehandler)
    {
        s = new PMApiRequest(com.poshmark.http.PMHttpRequest.REQUEST_TYPE.HTTP_POST, String.format("/api/users/%s/reported/posts/%s", new Object[] {
            PMApplicationSession.GetPMSession().getUserId(), s
        }), java/lang/Void);
        ((PMApiRequest) (s)).formData.put("reason", s1);
        s.callAPI(pmapiresponsehandler);
    }

    public static void reportUser(String s, String s1, PMApiResponseHandler pmapiresponsehandler)
    {
        s = new PMApiRequest(com.poshmark.http.PMHttpRequest.REQUEST_TYPE.HTTP_POST, String.format("/api/users/%s/reported/users/%s", new Object[] {
            PMApplicationSession.GetPMSession().getUserId(), s
        }), java/lang/Void);
        ((PMApiRequest) (s)).formData.put("reason", s1);
        s.callAPI(pmapiresponsehandler);
    }

    public static void saveExternalServiceInfo(String s, String s1, String s2, HashMap hashmap, PMApiResponseHandler pmapiresponsehandler)
    {
        PMApiRequest pmapirequest = new PMApiRequest(com.poshmark.http.PMHttpRequest.REQUEST_TYPE.HTTP_POST, "/api/auth/users/access_token", com/poshmark/user/UserInfo);
        pmapirequest.formData.put("ext_access_token", s1);
        pmapirequest.formData.put("ext_token_expr", s2);
        pmapirequest.formData.put("ext_service_id", s);
        pmapirequest.queryParams.putAll(AppInfo.getInstance().deviceInfo);
        if (hashmap != null && !hashmap.isEmpty())
        {
            pmapirequest.queryParams.putAll(hashmap);
        }
        s = PMApplicationSession.GetPMSession().getGCMRegId();
        if (s != null && s.length() > 0)
        {
            pmapirequest.queryParams.put("push_token", s);
        }
        pmapirequest.callAPI(pmapiresponsehandler);
    }

    public static void searchUsers(String s, PMApiResponseHandler pmapiresponsehandler)
    {
        PMApiRequest pmapirequest = new PMApiRequest(com.poshmark.http.PMHttpRequest.REQUEST_TYPE.HTTP_GET, "/api/users", com/poshmark/data_model/models/UserReferenceList);
        HashMap hashmap = new HashMap();
        hashmap.put("name", s);
        s = (new GsonBuilder()).create();
        if (!(s instanceof Gson))
        {
            s = s.toJson(hashmap, java/util/HashMap);
        } else
        {
            s = GsonInstrumentation.toJson((Gson)s, hashmap, java/util/HashMap);
        }
        pmapirequest.queryParams.put("request", s);
        pmapirequest.queryParams.put("nm", "sp");
        pmapirequest.callAPI(pmapiresponsehandler);
    }

    public static void setMySize(Map map, PMApiResponseHandler pmapiresponsehandler)
    {
        PMApiRequest pmapirequest = new PMApiRequest(com.poshmark.http.PMHttpRequest.REQUEST_TYPE.HTTP_POST, String.format("/api/users/%s/sizes", new Object[] {
            PMApplicationSession.GetPMSession().getUserId()
        }), java/lang/Void);
        pmapirequest.formData.putAll(map);
        pmapirequest.callAPI(pmapiresponsehandler);
    }

    public static void setUserProfile(Map map, Bitmap bitmap, PMApiResponseHandler pmapiresponsehandler)
    {
        PMApiRequest pmapirequest = new PMApiRequest(com.poshmark.http.PMHttpRequest.REQUEST_TYPE.HTTP_POST, String.format("/api/users/%s/profile", new Object[] {
            PMApplicationSession.GetPMSession().getUserId()
        }), java/lang/Void);
        pmapirequest.formData.putAll(map);
        if (bitmap != null)
        {
            map = new ByteArrayOutputStream();
            bitmap.compress(android.graphics.Bitmap.CompressFormat.JPEG, 95, map);
            map = map.toByteArray();
            pmapirequest.multipartData.put("cover_shot", new PMMultipartItem(map, "image/jpeg", "file.jpg"));
        }
        pmapirequest.callAPI(pmapiresponsehandler);
    }

    public static void shareBrandToExternalService(String s, String s1, String s2, PMApiResponseHandler pmapiresponsehandler)
    {
        if (s != null)
        {
            s = s.replace("/", "%2F");
            s = new PMApiRequest(com.poshmark.http.PMHttpRequest.REQUEST_TYPE.HTTP_PUT, String.format("/api/users/%s/external_shares/brands/%s", new Object[] {
                PMApplicationSession.GetPMSession().getUserId(), Uri.encode(s)
            }), java/lang/Void);
            if (s1 != null && s1.length() > 0)
            {
                ((PMApiRequest) (s)).queryParams.put("ext_service_id", s1);
            }
            if (s2 != null && s2.length() > 0)
            {
                ((PMApiRequest) (s)).queryParams.put("message", s2);
            }
            s.callAPI(pmapiresponsehandler);
        }
    }

    public static void shareCloset(String s, String s1, String s2, PMApiResponseHandler pmapiresponsehandler)
    {
        s = new PMApiRequest(com.poshmark.http.PMHttpRequest.REQUEST_TYPE.HTTP_PUT, String.format("/api/users/%s/external_shares/users/%s", new Object[] {
            PMApplicationSession.GetPMSession().getUserId(), s
        }), java/lang/Void);
        if (s1 != null && s1.length() > 0)
        {
            ((PMApiRequest) (s)).queryParams.put("ext_service_id", s1);
        }
        if (s2 != null && s2.length() > 0)
        {
            ((PMApiRequest) (s)).queryParams.put("message", s2);
        }
        s.callAPI(pmapiresponsehandler);
    }

    public static void shareEvent(String s, String s1, String s2, PMApiResponseHandler pmapiresponsehandler)
    {
        s = new PMApiRequest(com.poshmark.http.PMHttpRequest.REQUEST_TYPE.HTTP_PUT, String.format("/api/users/%s/external_shares/events/%s", new Object[] {
            PMApplicationSession.GetPMSession().getUserId(), s
        }), java/lang/Void);
        if (s1 != null && s1.length() > 0)
        {
            ((PMApiRequest) (s)).queryParams.put("ext_service_id", s1);
        }
        if (s2 != null && s2.length() > 0)
        {
            ((PMApiRequest) (s)).queryParams.put("message", s2);
        }
        s.callAPI(pmapiresponsehandler);
    }

    public static void shareListing(String s, String s1, String s2, String s3, PMApiResponseHandler pmapiresponsehandler)
    {
        s = new PMApiRequest(com.poshmark.http.PMHttpRequest.REQUEST_TYPE.HTTP_PUT, String.format("/api/users/%s/shared_posts/%s", new Object[] {
            PMApplicationSession.GetPMSession().getUserId(), s
        }), java/lang/Void);
        if (s1 != null && s1.length() > 0)
        {
            ((PMApiRequest) (s)).queryParams.put("ext_service_ids", s1);
        }
        if (s2 != null && s2.length() > 0)
        {
            ((PMApiRequest) (s)).queryParams.put("event_ids", s2);
        }
        if (s3 != null && s3.length() > 0)
        {
            ((PMApiRequest) (s)).queryParams.put("message", s3);
        }
        s.callAPI(pmapiresponsehandler);
    }

    public static void shareListingToExternalService(String s, String s1, String s2, PMApiResponseHandler pmapiresponsehandler)
    {
        s = new PMApiRequest(com.poshmark.http.PMHttpRequest.REQUEST_TYPE.HTTP_PUT, String.format("/api/users/%s/external_shares/%s", new Object[] {
            PMApplicationSession.GetPMSession().getUserId(), s
        }), java/lang/Void);
        if (s1 != null && s1.length() > 0)
        {
            ((PMApiRequest) (s)).queryParams.put("ext_service_id", s1);
        }
        if (s2 != null && s2.length() > 0)
        {
            ((PMApiRequest) (s)).queryParams.put("message", s2);
        }
        s.callAPI(pmapiresponsehandler);
    }

    public static void shareShowroom(String s, String s1, String s2, PMApiResponseHandler pmapiresponsehandler)
    {
        s = new PMApiRequest(com.poshmark.http.PMHttpRequest.REQUEST_TYPE.HTTP_PUT, String.format("/api/users/%s/external_shares/collections/%s", new Object[] {
            PMApplicationSession.GetPMSession().getUserId(), s
        }), java/lang/Void);
        if (s1 != null && s1.length() > 0)
        {
            ((PMApiRequest) (s)).queryParams.put("ext_service_id", s1);
        }
        if (s2 != null && s2.length() > 0)
        {
            ((PMApiRequest) (s)).queryParams.put("message", s2);
        }
        s.callAPI(pmapiresponsehandler);
    }

    public static void tmblrLink(String s, String s1, PMApiResponseHandler pmapiresponsehandler)
    {
        PMApiRequest pmapirequest = new PMApiRequest(com.poshmark.http.PMHttpRequest.REQUEST_TYPE.HTTP_POST, String.format("/api/users/%s/external_services", new Object[] {
            PMApplicationSession.GetPMSession().getUserId()
        }), com/poshmark/data_model/models/ExternalServiceInfo);
        pmapirequest.formData.put("ext_access_token", s);
        pmapirequest.formData.put("ext_token_secret", s1);
        pmapirequest.formData.put("ext_service_id", "tm");
        pmapirequest.callAPI(pmapiresponsehandler);
    }

    public static void trackDeepLink(HashMap hashmap)
    {
        PMApiRequest pmapirequest = new PMApiRequest(com.poshmark.http.PMHttpRequest.REQUEST_TYPE.HTTP_GET, "/tr", java/lang/Void, "https://tr.poshmark.com");
        if (hashmap != null)
        {
            Gson gson = (new GsonBuilder()).create();
            if (!(gson instanceof Gson))
            {
                hashmap = gson.toJson(hashmap, java/util/HashMap);
            } else
            {
                hashmap = GsonInstrumentation.toJson((Gson)gson, hashmap, java/util/HashMap);
            }
            if (hashmap != null)
            {
                pmapirequest.queryParams.put("d", hashmap);
            }
        }
        pmapirequest.queryParams.putAll(AppInfo.getInstance().deviceInfo);
        pmapirequest.queryParams.put("os", (new StringBuilder()).append("Android: ").append(android.os.Build.VERSION.RELEASE).toString());
        pmapirequest.callAPI(null);
    }

    public static void trackExternalShare(String s, String s1)
    {
        PMApiRequest pmapirequest = new PMApiRequest(com.poshmark.http.PMHttpRequest.REQUEST_TYPE.HTTP_GET, "/trk/evt/ext_share_init", java/lang/Void, "https://tr.poshmark.com");
        pmapirequest.queryParams.putAll(AppInfo.getInstance().deviceInfo);
        pmapirequest.queryParams.put("os", (new StringBuilder()).append("Android: ").append(android.os.Build.VERSION.RELEASE).toString());
        pmapirequest.queryParams.put("d", s);
        pmapirequest.queryParams.put("d", s);
        pmapirequest.queryParams.put("s", s1);
        s = PMApplicationSession.GetPMSession().getUserId();
        if (s != null)
        {
            pmapirequest.queryParams.put("user_id", s);
        }
        pmapirequest.callAPI(null);
    }

    public static void trackPushNotificationClick(ActiveUserInfo activeuserinfo)
    {
        PMApiRequest pmapirequest;
        pmapirequest = new PMApiRequest(com.poshmark.http.PMHttpRequest.REQUEST_TYPE.HTTP_GET, "/trk/ntf/clk", java/lang/Void, "https://tr.poshmark.com");
        String s = PMApplicationSession.GetPMSession().getUserId();
        if (s != null)
        {
            pmapirequest.queryParams.put("user_id", s);
        }
        if (activeuserinfo == null) goto _L2; else goto _L1
_L1:
        String s1;
        Gson gson;
        s1 = null;
        gson = (new GsonBuilder()).create();
        if (!activeuserinfo.type.equals("push_ntf")) goto _L4; else goto _L3
_L3:
        activeuserinfo = activeuserinfo.push_ntf;
        if (!(gson instanceof Gson))
        {
            s1 = gson.toJson(activeuserinfo, com/poshmark/data_model/models/ActiveUserInfo$PushNotificationInfo);
        } else
        {
            s1 = GsonInstrumentation.toJson((Gson)gson, activeuserinfo, com/poshmark/data_model/models/ActiveUserInfo$PushNotificationInfo);
        }
_L6:
        if (s1 != null)
        {
            pmapirequest.queryParams.put("d", s1);
        }
_L2:
        pmapirequest.callAPI(null);
        return;
_L4:
        if (activeuserinfo.type.equals("local_ntf"))
        {
            activeuserinfo = activeuserinfo.local_ntf;
            if (!(gson instanceof Gson))
            {
                s1 = gson.toJson(activeuserinfo, com/poshmark/data_model/models/ActiveUserInfo$LocalNotificationInfo);
            } else
            {
                s1 = GsonInstrumentation.toJson((Gson)gson, activeuserinfo, com/poshmark/data_model/models/ActiveUserInfo$LocalNotificationInfo);
            }
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public static void trackPushNotificationDelivery(Bundle bundle)
    {
        PMApiRequest pmapirequest = new PMApiRequest(com.poshmark.http.PMHttpRequest.REQUEST_TYPE.HTTP_GET, "/tr", java/lang/Void, "https://tr.poshmark.com");
        pmapirequest.queryParams.putAll(AppInfo.getInstance().deviceInfo);
        pmapirequest.queryParams.put("os", (new StringBuilder()).append("Android: ").append(android.os.Build.VERSION.RELEASE).toString());
        bundle = bundle.getString("message");
        if (bundle != null)
        {
            pmapirequest.queryParams.put("message", bundle);
        }
        bundle = PMApplicationSession.GetPMSession().getUserId();
        if (bundle != null)
        {
            pmapirequest.queryParams.put("user_id", bundle);
        }
        pmapirequest.callAPI(null);
    }

    public static void twitterLink(String s, String s1, String s2, String s3, PMApiResponseHandler pmapiresponsehandler)
    {
        s3 = new PMApiRequest(com.poshmark.http.PMHttpRequest.REQUEST_TYPE.HTTP_POST, String.format("/api/users/%s/external_services", new Object[] {
            PMApplicationSession.GetPMSession().getUserId()
        }), com/poshmark/data_model/models/ExternalServiceInfo);
        ((PMApiRequest) (s3)).formData.put("ext_access_token", s);
        ((PMApiRequest) (s3)).formData.put("ext_token_secret", s1);
        ((PMApiRequest) (s3)).formData.put("ext_service_id", "tw");
        ((PMApiRequest) (s3)).formData.put("ext_user_id", s2);
        s3.callAPI(pmapiresponsehandler);
    }

    public static void unFollowBrand(String s, PMApiResponseHandler pmapiresponsehandler)
    {
        s = s.replace("/", "%2F");
        (new PMApiRequest(com.poshmark.http.PMHttpRequest.REQUEST_TYPE.HTTP_DELETE, String.format("/api/brands/%s/followers/%s", new Object[] {
            Uri.encode(s), PMApplicationSession.GetPMSession().getUserId()
        }), java/lang/Void)).callAPI(pmapiresponsehandler);
    }

    public static void unFollowUser(String s, PMApiResponseHandler pmapiresponsehandler)
    {
        (new PMApiRequest(com.poshmark.http.PMHttpRequest.REQUEST_TYPE.HTTP_DELETE, String.format("/api/users/%s/followers/%s", new Object[] {
            s, PMApplicationSession.GetPMSession().getUserId()
        }), java/lang/Void)).callAPI(pmapiresponsehandler);
    }

    public static void unLike(String s, PMApiResponseHandler pmapiresponsehandler)
    {
        (new PMApiRequest(com.poshmark.http.PMHttpRequest.REQUEST_TYPE.HTTP_DELETE, String.format("/api/posts/%s/likes", new Object[] {
            s
        }), java/lang/Void)).callAPI(pmapiresponsehandler);
    }

    public static void unblockUser(String s, PMApiResponseHandler pmapiresponsehandler)
    {
        (new PMApiRequest(com.poshmark.http.PMHttpRequest.REQUEST_TYPE.HTTP_DELETE, String.format("/api/users/%s/blocked/users/%s", new Object[] {
            PMApplicationSession.GetPMSession().getUserId(), s
        }), java/lang/Void)).callAPI(pmapiresponsehandler);
    }

    public static void unlinkExternalService(String s, PMApiResponseHandler pmapiresponsehandler)
    {
        PMApiRequest pmapirequest = new PMApiRequest(com.poshmark.http.PMHttpRequest.REQUEST_TYPE.HTTP_DELETE, String.format("/api/users/%s/external_services", new Object[] {
            PMApplicationSession.GetPMSession().getUserId()
        }), java/lang/Void);
        pmapirequest.queryParams.put("ext_service_id", s);
        pmapirequest.callAPI(pmapiresponsehandler);
    }

    public static void updateFbToken(String s, String s1, HashMap hashmap, PMApiResponseHandler pmapiresponsehandler)
    {
        PMApiRequest pmapirequest = new PMApiRequest(com.poshmark.http.PMHttpRequest.REQUEST_TYPE.HTTP_POST, "/api/auth/users/access_token", com/poshmark/user/UserInfo);
        pmapirequest.formData.put("ext_access_token", s);
        pmapirequest.formData.put("ext_token_expr", s1);
        pmapirequest.formData.put("ext_service_id", "fb");
        pmapirequest.queryParams.putAll(AppInfo.getInstance().deviceInfo);
        if (hashmap != null && !hashmap.isEmpty())
        {
            pmapirequest.queryParams.putAll(hashmap);
        }
        s = PMApplicationSession.GetPMSession().getGCMRegId();
        if (s != null && s.length() > 0)
        {
            pmapirequest.queryParams.put("push_token", s);
        }
        pmapirequest.callAPI(pmapiresponsehandler);
    }

    public static void updateListingStatus(String s, String s1, PMApiResponseHandler pmapiresponsehandler)
    {
        s = new PMApiRequest(com.poshmark.http.PMHttpRequest.REQUEST_TYPE.HTTP_PUT, String.format("/api/posts/%s/inventory/status", new Object[] {
            s, s1
        }), java/lang/Void);
        if (s1 != null && s1.length() > 0)
        {
            ((PMApiRequest) (s)).queryParams.put("status", s1);
        }
        s.callAPI(pmapiresponsehandler);
    }

}

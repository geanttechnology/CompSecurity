// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.apiv3.controllers;

import com.socialin.android.apiv3.SocialinApiV3;
import com.socialin.android.apiv3.SocialinV3;
import com.socialin.android.apiv3.model.AddDesignParams;
import com.socialin.android.apiv3.model.User;
import com.socialin.android.apiv3.model.stripe.StripeChargeParams;
import com.socialin.android.apiv3.model.stripe.StripeTokenParams;
import com.socialin.android.apiv3.request.AddCoinsParams;
import com.socialin.android.apiv3.request.AddCommentParams;
import com.socialin.android.apiv3.request.CheckoutShopItemParams;
import com.socialin.android.apiv3.request.ContestParams;
import com.socialin.android.apiv3.request.GetFollowParams;
import com.socialin.android.apiv3.request.GetItemsParams;
import com.socialin.android.apiv3.request.GetTagsParams;
import com.socialin.android.apiv3.request.GetUserDesignsParams;
import com.socialin.android.apiv3.request.GetUsersParams;
import com.socialin.android.apiv3.request.LocationParams;
import com.socialin.android.apiv3.request.ParamWithCommentId;
import com.socialin.android.apiv3.request.ParamWithItemId;
import com.socialin.android.apiv3.request.ParamWithPageLimit;
import com.socialin.android.apiv3.request.ParamWithUserData;
import com.socialin.android.apiv3.request.ReportParams;
import com.socialin.android.apiv3.request.RequestParams;
import com.socialin.android.apiv3.request.StreamParams;
import com.socialin.android.apiv3.request.UpdateItemParams;
import com.socialin.android.apiv3.request.UploadParams;

// Referenced classes of package com.socialin.android.apiv3.controllers:
//            BaseSocialinApiRequestController

public class RequestControllerFactory
{

    public RequestControllerFactory()
    {
    }

    public static BaseSocialinApiRequestController createAddBlockedUserController()
    {
        return new BaseSocialinApiRequestController() {

            public final void doRequest(String s, RequestParams requestparams)
            {
                requestparams = (ParamWithUserData)requestparams;
                params = requestparams;
                if (status != 0)
                {
                    status = 0;
                    SocialinApiV3.getInstance().addBlockedUser(((ParamWithUserData) (requestparams)).userId, s, this);
                }
            }

        };
    }

    public static BaseSocialinApiRequestController createAddCoinsController()
    {
        return new BaseSocialinApiRequestController() {

            public final void doRequest(String s, RequestParams requestparams)
            {
                requestparams = (AddCoinsParams)requestparams;
                params = requestparams;
                if (status != 0)
                {
                    status = 0;
                    SocialinApiV3.getInstance().requestAddCoins(s, this, ((AddCoinsParams) (requestparams)).amount, ((AddCoinsParams) (requestparams)).data, 5);
                }
            }

        };
    }

    public static BaseSocialinApiRequestController createAddCommentController()
    {
        return new BaseSocialinApiRequestController() {

            public final void doRequest(String s, RequestParams requestparams)
            {
                requestparams = (AddCommentParams)requestparams;
                params = requestparams;
                if (status != 0)
                {
                    status = 0;
                    SocialinApiV3.getInstance().addComment(((AddCommentParams) (requestparams)).itemId, ((AddCommentParams) (requestparams)).text, ((AddCommentParams) (requestparams)).isDesignItem, s, this);
                }
            }

        };
    }

    public static BaseSocialinApiRequestController createAddDesignController()
    {
        return new BaseSocialinApiRequestController() {

            public final void doRequest(String s, RequestParams requestparams)
            {
                requestparams = (AddDesignParams)requestparams;
                params = requestparams;
                if (status != 0)
                {
                    status = 0;
                    SocialinApiV3.getInstance().addDesign(requestparams, this, s);
                }
            }

        };
    }

    public static BaseSocialinApiRequestController createAddStreamItemController()
    {
        return new BaseSocialinApiRequestController() {

            public final void doRequest(String s, RequestParams requestparams)
            {
                requestparams = (StreamParams)requestparams;
                params = requestparams;
                if (status != 0)
                {
                    status = 0;
                    SocialinApiV3.getInstance().addStreamPhoto(((StreamParams) (requestparams)).streamId, ((StreamParams) (requestparams)).itemId, ((StreamParams) (requestparams)).isDesignItem, s, this);
                }
            }

        };
    }

    public static BaseSocialinApiRequestController createAddVoteController()
    {
        BaseSocialinApiRequestController basesocialinapirequestcontroller = new BaseSocialinApiRequestController() {

            public final void doRequest(String s, RequestParams requestparams)
            {
                requestparams = (ContestParams)requestparams;
                params = requestparams;
                if (status != 0)
                {
                    status = 0;
                    SocialinApiV3.getInstance().addVote(s, this, ((ContestParams) (requestparams)).photoId, ((ContestParams) (requestparams)).votePlace, ((ContestParams) (requestparams)).contestName);
                }
            }

        };
        basesocialinapirequestcontroller.setRequestParams(new ContestParams());
        return basesocialinapirequestcontroller;
    }

    public static BaseSocialinApiRequestController createBlogsController()
    {
        return new BaseSocialinApiRequestController() {

            public final void doRequest(String s, RequestParams requestparams)
            {
                requestparams = (ParamWithPageLimit)requestparams;
                if (status != 0)
                {
                    status = 0;
                    SocialinApiV3.getInstance().getBlogs(s, this, requestparams);
                }
            }

        };
    }

    public static BaseSocialinApiRequestController createChargeAliPayController()
    {
        return new BaseSocialinApiRequestController() {

            public final void doRequest(String s, RequestParams requestparams)
            {
                requestparams = (StripeChargeParams)requestparams;
                if (status != 0)
                {
                    status = 0;
                    SocialinApiV3.getInstance().shopChargeWithAliPay(s, requestparams, this);
                }
            }

        };
    }

    public static BaseSocialinApiRequestController createCheckUsernameController()
    {
        return new BaseSocialinApiRequestController() {

            private int a;

            public final void doRequest(String s, RequestParams requestparams)
            {
                requestparams = (ParamWithUserData)requestparams;
                if (status != 0)
                {
                    params = requestparams;
                    status = 0;
                    a = SocialinApiV3.getInstance().checkUsername(((ParamWithUserData) (requestparams)).username, listener, s);
                }
            }

            public final int getRequestId()
            {
                return a;
            }

            
            {
                a = -1;
            }
        };
    }

    public static BaseSocialinApiRequestController createCheckoutShopItemsController()
    {
        return new BaseSocialinApiRequestController() {

            public final void doRequest(String s, RequestParams requestparams)
            {
                requestparams = (CheckoutShopItemParams)requestparams;
                if (status != 0)
                {
                    params = requestparams;
                    status = 0;
                    SocialinApiV3.getInstance().checkoutShopItem(s, listener, ((CheckoutShopItemParams) (requestparams)).shopItemId, ((CheckoutShopItemParams) (requestparams)).amount, ((CheckoutShopItemParams) (requestparams)).data, 5);
                }
            }

        };
    }

    public static BaseSocialinApiRequestController createGetAliPayTokenController()
    {
        return new BaseSocialinApiRequestController() {

            public final void doRequest(String s, RequestParams requestparams)
            {
                if (status == 0)
                {
                    return;
                } else
                {
                    status = 0;
                    SocialinApiV3.getInstance().retrieveStripeToken(s, this);
                    return;
                }
            }

        };
    }

    public static BaseSocialinApiRequestController createGetContestRateItemsController()
    {
        BaseSocialinApiRequestController basesocialinapirequestcontroller = new BaseSocialinApiRequestController() {

            public final void doRequest(String s, RequestParams requestparams)
            {
                requestparams = (ContestParams)requestparams;
                if (status != 0)
                {
                    params = requestparams;
                    status = 0;
                    SocialinApiV3.getInstance().getContestRateItems(s, this, ((ContestParams) (requestparams)).contestName);
                }
            }

        };
        basesocialinapirequestcontroller.setRequestParams(new ContestParams());
        return basesocialinapirequestcontroller;
    }

    public static BaseSocialinApiRequestController createGetItemCommentsController()
    {
        return new BaseSocialinApiRequestController() {

            public final void doRequest(String s, RequestParams requestparams)
            {
                requestparams = (ParamWithItemId)requestparams;
                if (status != 0)
                {
                    status = 0;
                    params = requestparams;
                    SocialinApiV3.getInstance().getPhotoComments(((ParamWithItemId) (requestparams)).itemId, s, this, ((ParamWithItemId) (requestparams)).offset, ((ParamWithItemId) (requestparams)).limit);
                }
            }

        };
    }

    public static BaseSocialinApiRequestController createGetItemController()
    {
        return new BaseSocialinApiRequestController() {

            public final void doRequest(String s, RequestParams requestparams)
            {
                requestparams = (ParamWithItemId)requestparams;
                if (status != 0)
                {
                    status = 0;
                    params = requestparams;
                    SocialinApiV3.getInstance().getPhoto(((ParamWithItemId) (requestparams)).itemId, ((ParamWithItemId) (requestparams)).isDesignItem, s, this);
                }
            }

        };
    }

    public static BaseSocialinApiRequestController createGetItemDetailsController()
    {
        return new BaseSocialinApiRequestController() {

            public final void doRequest(String s, RequestParams requestparams)
            {
                requestparams = (ParamWithItemId)requestparams;
                params = requestparams;
                if (status != 0)
                {
                    status = 0;
                    SocialinApiV3.getInstance().getPhotoDetails(((ParamWithItemId) (requestparams)).itemId, ((ParamWithItemId) (requestparams)).isDesignItem, 1, s, this);
                }
            }

        };
    }

    public static BaseSocialinApiRequestController createGetItemLikesController()
    {
        return new BaseSocialinApiRequestController() {

            public final void doRequest(String s, RequestParams requestparams)
            {
                requestparams = (ParamWithItemId)requestparams;
                if (status != 0)
                {
                    status = 0;
                    params = requestparams;
                    SocialinApiV3.getInstance().getPhotoLikes(((ParamWithItemId) (requestparams)).itemId, s, this, ((ParamWithItemId) (requestparams)).offset, ((ParamWithItemId) (requestparams)).limit);
                }
            }

        };
    }

    public static BaseSocialinApiRequestController createGetItemMemboxesController()
    {
        return new BaseSocialinApiRequestController() {

            public final void doRequest(String s, RequestParams requestparams)
            {
                requestparams = (ParamWithItemId)requestparams;
                if (status != 0)
                {
                    status = 0;
                    params = requestparams;
                    SocialinApiV3.getInstance().getPhotoMemboxes(((ParamWithItemId) (requestparams)).itemId, s, this, ((ParamWithItemId) (requestparams)).offset, ((ParamWithItemId) (requestparams)).limit);
                }
            }

        };
    }

    public static BaseSocialinApiRequestController createGetItemRepostsController()
    {
        return new BaseSocialinApiRequestController() {

            public final void doRequest(String s, RequestParams requestparams)
            {
                requestparams = (ParamWithItemId)requestparams;
                if (status != 0)
                {
                    status = 0;
                    params = requestparams;
                    SocialinApiV3.getInstance().getPhotoReposts(((ParamWithItemId) (requestparams)).itemId, s, this, ((ParamWithItemId) (requestparams)).offset, ((ParamWithItemId) (requestparams)).limit);
                }
            }

        };
    }

    public static BaseSocialinApiRequestController createGetItemStreamsController()
    {
        return new BaseSocialinApiRequestController() {

            public final void doRequest(String s, RequestParams requestparams)
            {
                requestparams = (ParamWithItemId)requestparams;
                params = requestparams;
                if (status != 0)
                {
                    status = 0;
                    SocialinApiV3.getInstance().getPhotoStreams(((ParamWithItemId) (requestparams)).itemId, ((ParamWithItemId) (requestparams)).isDesignItem, s, this);
                }
            }

        };
    }

    public static BaseSocialinApiRequestController createGetOwnerDesignsController()
    {
        return new BaseSocialinApiRequestController() {

            public final void doRequest(String s, RequestParams requestparams)
            {
                requestparams = (ParamWithPageLimit)requestparams;
                params = requestparams;
                if (status != 0)
                {
                    status = 0;
                    SocialinApiV3.getInstance().getOwnerDesigns(requestparams, s, this);
                }
            }

        };
    }

    public static BaseSocialinApiRequestController createGetOwnerItemsController(int i)
    {
        BaseSocialinApiRequestController basesocialinapirequestcontroller = new BaseSocialinApiRequestController() {

            public final void doRequest(String s, RequestParams requestparams)
            {
                requestparams = (GetItemsParams)requestparams;
                if (status != 0)
                {
                    status = 0;
                    SocialinApiV3.getInstance().getOwnerItems(((GetItemsParams) (requestparams)).offset, ((GetItemsParams) (requestparams)).limit, ((GetItemsParams) (requestparams)).contentRating, -1L, s, this, 5);
                }
            }

        };
        basesocialinapirequestcontroller.setRequestParams(new GetItemsParams());
        ((GetItemsParams)basesocialinapirequestcontroller.getRequestParams()).contentRating = i;
        return basesocialinapirequestcontroller;
    }

    public static BaseSocialinApiRequestController createGetPhotosLocGroupedController()
    {
        BaseSocialinApiRequestController basesocialinapirequestcontroller = new BaseSocialinApiRequestController() {

            public final void doRequest(String s, RequestParams requestparams)
            {
                boolean flag = false;
                requestparams = (ParamWithPageLimit)requestparams;
                if (status != 0)
                {
                    status = 0;
                    if (SocialinV3.getInstance().getUser().id == ((ParamWithPageLimit) (requestparams)).userId)
                    {
                        flag = true;
                    }
                    SocialinApiV3.getInstance().getPhotosLocGrouped(((ParamWithPageLimit) (requestparams)).userId, flag, ((ParamWithPageLimit) (requestparams)).offset, ((ParamWithPageLimit) (requestparams)).limit, ((ParamWithPageLimit) (requestparams)).contentRating, s, this);
                }
            }

        };
        basesocialinapirequestcontroller.setRequestParams(new ParamWithPageLimit());
        return basesocialinapirequestcontroller;
    }

    public static BaseSocialinApiRequestController createGetPopularUsersController()
    {
        BaseSocialinApiRequestController basesocialinapirequestcontroller = new BaseSocialinApiRequestController() {

            public final void doRequest(String s, RequestParams requestparams)
            {
                requestparams = (ParamWithPageLimit)requestparams;
                if (status != 0)
                {
                    status = 0;
                    params = requestparams;
                    SocialinApiV3.getInstance().newGetPopUsers(((ParamWithPageLimit) (requestparams)).offset, ((ParamWithPageLimit) (requestparams)).limit, s, this, 3);
                }
            }

        };
        basesocialinapirequestcontroller.setRequestParams(new ParamWithPageLimit());
        return basesocialinapirequestcontroller;
    }

    public static BaseSocialinApiRequestController createGetStickerStreamController()
    {
        return new BaseSocialinApiRequestController() {

            public final void doRequest(String s, RequestParams requestparams)
            {
                if (status == 0)
                {
                    return;
                } else
                {
                    status = 0;
                    SocialinApiV3.getInstance().getStickerStream(s, this, 5);
                    return;
                }
            }

        };
    }

    public static BaseSocialinApiRequestController createGetStreamItemsController()
    {
        return new BaseSocialinApiRequestController() {

            public final void doRequest(String s, RequestParams requestparams)
            {
                requestparams = (StreamParams)requestparams;
                if (status != 0)
                {
                    status = 0;
                    SocialinApiV3.getInstance().getStreamPhotos(((StreamParams) (requestparams)).streamId, ((StreamParams) (requestparams)).contentRating, s, this, 5);
                }
            }

        };
    }

    public static BaseSocialinApiRequestController createGetUserDesignsController()
    {
        return new BaseSocialinApiRequestController() {

            public final void doRequest(String s, RequestParams requestparams)
            {
                requestparams = (GetUserDesignsParams)requestparams;
                params = requestparams;
                if (status != 0)
                {
                    status = 0;
                    SocialinApiV3.getInstance().getUserDesigns(requestparams, s, this);
                }
            }

        };
    }

    public static BaseSocialinApiRequestController createGetUserLocationPhotosController()
    {
        return new BaseSocialinApiRequestController() {

            public final void doRequest(String s, RequestParams requestparams)
            {
                requestparams = (GetItemsParams)requestparams;
                params = requestparams;
                if (status != 0)
                {
                    status = 0;
                    SocialinApiV3.getInstance().getUserPhotosByLocation(((GetItemsParams) (requestparams)).searchLocation, ((GetItemsParams) (requestparams)).userId, ((GetItemsParams) (requestparams)).lastId, ((GetItemsParams) (requestparams)).offset, ((GetItemsParams) (requestparams)).limit, s, this, 5);
                }
            }

        };
    }

    public static BaseSocialinApiRequestController createGetUserPhotosByTagController()
    {
        BaseSocialinApiRequestController basesocialinapirequestcontroller = new BaseSocialinApiRequestController() {

            public final void doRequest(String s, RequestParams requestparams)
            {
                requestparams = (GetItemsParams)requestparams;
                params = requestparams;
                if (status != 0)
                {
                    status = 0;
                    SocialinApiV3.getInstance().getUserPhotosByTag(((GetItemsParams) (requestparams)).lastId, ((GetItemsParams) (requestparams)).searchTag, ((GetItemsParams) (requestparams)).userId, s, ((GetItemsParams) (requestparams)).offset, ((GetItemsParams) (requestparams)).limit, this, 5);
                }
            }

        };
        basesocialinapirequestcontroller.setRequestParams(new GetItemsParams());
        return basesocialinapirequestcontroller;
    }

    public static BaseSocialinApiRequestController createGetUserTagsGroupedController()
    {
        BaseSocialinApiRequestController basesocialinapirequestcontroller = new BaseSocialinApiRequestController() {

            public final void doRequest(String s, RequestParams requestparams)
            {
                requestparams = (ParamWithPageLimit)requestparams;
                params = requestparams;
                if (status != 0)
                {
                    status = 0;
                    SocialinApiV3.getInstance().getViewerTags(((ParamWithPageLimit) (requestparams)).userId, ((ParamWithPageLimit) (requestparams)).offset, ((ParamWithPageLimit) (requestparams)).limit, ((ParamWithPageLimit) (requestparams)).contentRating, s, this, 5);
                }
            }

        };
        basesocialinapirequestcontroller.setRequestParams(new ParamWithPageLimit());
        return basesocialinapirequestcontroller;
    }

    public static BaseSocialinApiRequestController createGetViewerBlockedController()
    {
        return new BaseSocialinApiRequestController() {

            public final void doRequest(String s, RequestParams requestparams)
            {
                requestparams = (ParamWithUserData)requestparams;
                params = requestparams;
                if (status != 0)
                {
                    status = 0;
                    SocialinApiV3.getInstance().getViewerBlockedUsers(((ParamWithUserData) (requestparams)).userId, s, this, 5);
                }
            }

        };
    }

    public static BaseSocialinApiRequestController createGetViewerController()
    {
        return new BaseSocialinApiRequestController() {

            public final void doRequest(String s, RequestParams requestparams)
            {
                requestparams = (ParamWithUserData)requestparams;
                params = requestparams;
                if (status != 0)
                {
                    status = 0;
                    SocialinApiV3.getInstance().getViewerUser(((ParamWithUserData) (requestparams)).userId, ((ParamWithUserData) (requestparams)).username, s, this, 5);
                }
            }

        };
    }

    public static BaseSocialinApiRequestController createGetViewerFollowersController(long l)
    {
        BaseSocialinApiRequestController basesocialinapirequestcontroller = new BaseSocialinApiRequestController() {

            public final void doRequest(String s, RequestParams requestparams)
            {
                requestparams = (GetFollowParams)requestparams;
                params = requestparams;
                if (status != 0)
                {
                    status = 0;
                    SocialinApiV3.getInstance().getViewerFollowers(((GetFollowParams) (requestparams)).userId, ((GetFollowParams) (requestparams)).offset, ((GetFollowParams) (requestparams)).limit, ((GetFollowParams) (requestparams)).searchUser, s, this, 5);
                }
            }

        };
        basesocialinapirequestcontroller.setCacheConfig(3);
        basesocialinapirequestcontroller.setRequestParams(new GetFollowParams());
        ((GetFollowParams)basesocialinapirequestcontroller.getRequestParams()).userId = l;
        return basesocialinapirequestcontroller;
    }

    public static BaseSocialinApiRequestController createGetViewerFollowingsController(long l)
    {
        BaseSocialinApiRequestController basesocialinapirequestcontroller = new BaseSocialinApiRequestController() {

            public final void doRequest(String s, RequestParams requestparams)
            {
                requestparams = (GetFollowParams)requestparams;
                params = requestparams;
                if (status != 0)
                {
                    status = 0;
                    SocialinApiV3.getInstance().getViewerFollowings(((GetFollowParams) (requestparams)).userId, ((GetFollowParams) (requestparams)).offset, ((GetFollowParams) (requestparams)).limit, ((GetFollowParams) (requestparams)).searchUser, s, this, 5);
                }
            }

        };
        basesocialinapirequestcontroller.setRequestParams(new GetFollowParams());
        ((GetFollowParams)basesocialinapirequestcontroller.getRequestParams()).userId = l;
        return basesocialinapirequestcontroller;
    }

    public static BaseSocialinApiRequestController createGetViewerItemsController(long l, int i)
    {
        BaseSocialinApiRequestController basesocialinapirequestcontroller = new BaseSocialinApiRequestController() {

            public final void doRequest(String s, RequestParams requestparams)
            {
                requestparams = (GetItemsParams)requestparams;
                if (status != 0)
                {
                    status = 0;
                    SocialinApiV3.getInstance().getViewerItems(((GetItemsParams) (requestparams)).userId, ((GetItemsParams) (requestparams)).offset, ((GetItemsParams) (requestparams)).limit, ((GetItemsParams) (requestparams)).interesting, ((GetItemsParams) (requestparams)).contentRating, -1L, s, this, 5);
                }
            }

        };
        GetItemsParams getitemsparams = new GetItemsParams();
        getitemsparams.userId = l;
        getitemsparams.contentRating = i;
        basesocialinapirequestcontroller.setRequestParams(getitemsparams);
        return basesocialinapirequestcontroller;
    }

    public static BaseSocialinApiRequestController createLikeItemController()
    {
        BaseSocialinApiRequestController basesocialinapirequestcontroller = new BaseSocialinApiRequestController() {

            public final void doRequest(String s, RequestParams requestparams)
            {
                requestparams = (ParamWithItemId)requestparams;
                params = requestparams;
                if (status != 0)
                {
                    status = 0;
                    SocialinApiV3.getInstance().likePhoto(((ParamWithItemId) (requestparams)).itemId, ((ParamWithItemId) (requestparams)).isDesignItem, s, this);
                }
            }

        };
        basesocialinapirequestcontroller.setRequestParams(new ParamWithItemId());
        return basesocialinapirequestcontroller;
    }

    public static BaseSocialinApiRequestController createRemoveBlockedUserController()
    {
        return new BaseSocialinApiRequestController() {

            public final void doRequest(String s, RequestParams requestparams)
            {
                requestparams = (ParamWithUserData)requestparams;
                params = requestparams;
                if (status != 0)
                {
                    status = 0;
                    SocialinApiV3.getInstance().removeBlockedUser(((ParamWithUserData) (requestparams)).userId, s, this);
                }
            }

        };
    }

    public static BaseSocialinApiRequestController createRemoveCommentController()
    {
        return new BaseSocialinApiRequestController() {

            public final void doRequest(String s, RequestParams requestparams)
            {
                requestparams = (ParamWithCommentId)requestparams;
                params = requestparams;
                if (status != 0)
                {
                    status = 0;
                    SocialinApiV3.getInstance().removeComment(((ParamWithCommentId) (requestparams)).itemId, ((ParamWithCommentId) (requestparams)).commentId, ((ParamWithCommentId) (requestparams)).isDesignItem, s, this);
                }
            }

        };
    }

    public static BaseSocialinApiRequestController createRemoveDeviceController()
    {
        return new BaseSocialinApiRequestController() {

            public final void doRequest(String s, RequestParams requestparams)
            {
                requestparams = (AddCommentParams)requestparams;
                params = requestparams;
                if (status != 0)
                {
                    status = 0;
                    SocialinApiV3.getInstance().removeDevice(((AddCommentParams) (requestparams)).text, this, s);
                }
            }

        };
    }

    public static BaseSocialinApiRequestController createRemoveShopItemsController()
    {
        return new BaseSocialinApiRequestController() {

            public final void doRequest(String s, RequestParams requestparams)
            {
                requestparams = (CheckoutShopItemParams)requestparams;
                params = requestparams;
                if (status != 0)
                {
                    status = 0;
                    SocialinApiV3.getInstance().removeShopItem(s, listener, ((CheckoutShopItemParams) (requestparams)).shopItemId, 5);
                }
            }

        };
    }

    public static BaseSocialinApiRequestController createRemoveStreamItemController()
    {
        return new BaseSocialinApiRequestController() {

            public final void doRequest(String s, RequestParams requestparams)
            {
                requestparams = (StreamParams)requestparams;
                params = requestparams;
                if (status != 0)
                {
                    status = 0;
                    SocialinApiV3.getInstance().removeStreamPhoto(((StreamParams) (requestparams)).streamId, ((StreamParams) (requestparams)).itemId, ((StreamParams) (requestparams)).isDesignItem, s, this);
                }
            }

        };
    }

    public static BaseSocialinApiRequestController createRenameStreamController()
    {
        return new BaseSocialinApiRequestController() {

            public final void doRequest(String s, RequestParams requestparams)
            {
                requestparams = (StreamParams)requestparams;
                params = requestparams;
                if (status != 0)
                {
                    status = 0;
                    SocialinApiV3.getInstance().renameStream(((StreamParams) (requestparams)).streamId, ((StreamParams) (requestparams)).title, ((StreamParams) (requestparams)).desc, s, this);
                }
            }

        };
    }

    public static BaseSocialinApiRequestController createReportItemController()
    {
        return new BaseSocialinApiRequestController() {

            public final void doRequest(String s, RequestParams requestparams)
            {
                requestparams = (ReportParams)requestparams;
                params = requestparams;
                if (status != 0)
                {
                    status = 0;
                    SocialinApiV3.getInstance().reportPhoto(((ReportParams) (requestparams)).itemId, ((ReportParams) (requestparams)).type, ((ReportParams) (requestparams)).materialUrl, ((ReportParams) (requestparams)).description, ((ReportParams) (requestparams)).firstName, ((ReportParams) (requestparams)).lastName, ((ReportParams) (requestparams)).address, ((ReportParams) (requestparams)).phone, ((ReportParams) (requestparams)).email, ((ReportParams) (requestparams)).isOwner, ((ReportParams) (requestparams)).isAccurate, ((ReportParams) (requestparams)).signature, ((ReportParams) (requestparams)).isDesignItem, s, this);
                }
            }

        };
    }

    public static BaseSocialinApiRequestController createRepostItemController()
    {
        BaseSocialinApiRequestController basesocialinapirequestcontroller = new BaseSocialinApiRequestController() {

            public final void doRequest(String s, RequestParams requestparams)
            {
                requestparams = (ParamWithItemId)requestparams;
                params = requestparams;
                if (status != 0)
                {
                    status = 0;
                    SocialinApiV3.getInstance().repostPhoto(((ParamWithItemId) (requestparams)).itemId, s, this);
                }
            }

        };
        basesocialinapirequestcontroller.setRequestParams(new ParamWithItemId());
        return basesocialinapirequestcontroller;
    }

    public static BaseSocialinApiRequestController createSearchFollowingsController()
    {
        return new BaseSocialinApiRequestController() {

            public final void doRequest(String s, RequestParams requestparams)
            {
                requestparams = (GetUsersParams)requestparams;
                if (status != 0)
                {
                    status = 0;
                    SocialinApiV3.getInstance().searchInsideFollowings(s, this, requestparams);
                }
            }

        };
    }

    public static BaseSocialinApiRequestController createSearchItemsController()
    {
        BaseSocialinApiRequestController basesocialinapirequestcontroller = new BaseSocialinApiRequestController() {

            public final void doRequest(String s, RequestParams requestparams)
            {
                requestparams = (GetItemsParams)requestparams;
                if (status != 0)
                {
                    status = 0;
                    SocialinApiV3.getInstance().searchItems(requestparams, s, this, 5);
                }
            }

        };
        GetItemsParams getitemsparams = new GetItemsParams();
        int i;
        if (SocialinV3.getInstance().getUser().mature)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        getitemsparams.contentRating = i;
        basesocialinapirequestcontroller.setRequestParams(getitemsparams);
        return basesocialinapirequestcontroller;
    }

    public static BaseSocialinApiRequestController createSearchTagsByLocationController()
    {
        return new BaseSocialinApiRequestController() {

            public final void doRequest(String s, RequestParams requestparams)
            {
                requestparams = (LocationParams)requestparams;
                if (status != 0)
                {
                    status = 0;
                    SocialinApiV3.getInstance().searchTagsByLocation(s, this, requestparams);
                }
            }

        };
    }

    public static BaseSocialinApiRequestController createSearchTagsController()
    {
        BaseSocialinApiRequestController basesocialinapirequestcontroller = new BaseSocialinApiRequestController() {

            public final void doRequest(String s, RequestParams requestparams)
            {
                requestparams = (GetTagsParams)requestparams;
                if (status != 0)
                {
                    status = 0;
                    SocialinApiV3.getInstance().searchTags(requestparams, s, this, 5);
                }
            }

        };
        GetTagsParams gettagsparams = new GetTagsParams();
        int i;
        if (SocialinV3.getInstance().getUser().mature)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        gettagsparams.contentRating = i;
        basesocialinapirequestcontroller.setRequestParams(gettagsparams);
        return basesocialinapirequestcontroller;
    }

    public static BaseSocialinApiRequestController createSearchUsersController()
    {
        BaseSocialinApiRequestController basesocialinapirequestcontroller = new BaseSocialinApiRequestController() {

            public final void doRequest(String s, RequestParams requestparams)
            {
                requestparams = (GetUsersParams)requestparams;
                if (status != 0)
                {
                    status = 0;
                    SocialinApiV3.getInstance().searchUsers(requestparams, s, this, 5);
                }
            }

        };
        basesocialinapirequestcontroller.setRequestParams(new GetUsersParams());
        basesocialinapirequestcontroller.setCacheConfig(5);
        return basesocialinapirequestcontroller;
    }

    public static BaseSocialinApiRequestController createStoreAliPayTokenConroller()
    {
        return new BaseSocialinApiRequestController() {

            public final void doRequest(String s, RequestParams requestparams)
            {
                requestparams = (StripeTokenParams)requestparams;
                if (status != 0)
                {
                    status = 0;
                    SocialinApiV3.getInstance().saveStripeToken(s, requestparams, this);
                }
            }

        };
    }

    public static BaseSocialinApiRequestController createUnlikeItemController()
    {
        BaseSocialinApiRequestController basesocialinapirequestcontroller = new BaseSocialinApiRequestController() {

            public final void doRequest(String s, RequestParams requestparams)
            {
                requestparams = (ParamWithItemId)requestparams;
                params = requestparams;
                if (status != 0)
                {
                    status = 0;
                    SocialinApiV3.getInstance().unlikePhoto(((ParamWithItemId) (requestparams)).itemId, ((ParamWithItemId) (requestparams)).isDesignItem, s, this);
                }
            }

        };
        basesocialinapirequestcontroller.setRequestParams(new ParamWithItemId());
        return basesocialinapirequestcontroller;
    }

    public static BaseSocialinApiRequestController createUnpostItemController()
    {
        BaseSocialinApiRequestController basesocialinapirequestcontroller = new BaseSocialinApiRequestController() {

            public final void doRequest(String s, RequestParams requestparams)
            {
                requestparams = (ParamWithItemId)requestparams;
                params = requestparams;
                if (status != 0)
                {
                    status = 0;
                    SocialinApiV3.getInstance().unpostPhoto(((ParamWithItemId) (requestparams)).itemId, s, this);
                }
            }

        };
        basesocialinapirequestcontroller.setRequestParams(new ParamWithItemId());
        return basesocialinapirequestcontroller;
    }

    public static BaseSocialinApiRequestController createUpdateItemController()
    {
        return new BaseSocialinApiRequestController() {

            public final void doRequest(String s, RequestParams requestparams)
            {
                requestparams = (UpdateItemParams)requestparams;
                params = requestparams;
                if (status != 0)
                {
                    status = 0;
                    SocialinApiV3.getInstance().updatePhoto(((UpdateItemParams) (requestparams)).itemId, ((UpdateItemParams) (requestparams)).title, ((UpdateItemParams) (requestparams)).desc, ((UpdateItemParams) (requestparams)).tags, ((UpdateItemParams) (requestparams)).isMature, ((UpdateItemParams) (requestparams)).isPublic, ((UpdateItemParams) (requestparams)).address, this, s);
                }
            }

        };
    }

    public static BaseSocialinApiRequestController createUploadController()
    {
        return new BaseSocialinApiRequestController() {

            private int a;

            public final void doRequest(String s, RequestParams requestparams)
            {
                requestparams = (UploadParams)requestparams;
                params = requestparams;
                if (status != 0)
                {
                    status = 0;
                    a = SocialinApiV3.getInstance().uploadPhoto(requestparams, s, this);
                }
            }

            public final int getRequestId()
            {
                return a;
            }

            
            {
                a = -1;
            }
        };
    }

    public static BaseSocialinApiRequestController createUserSuggestionsController()
    {
        BaseSocialinApiRequestController basesocialinapirequestcontroller = new BaseSocialinApiRequestController() {

            public final void doRequest(String s, RequestParams requestparams)
            {
                requestparams = (GetUsersParams)requestparams;
                if (status != 0)
                {
                    status = 0;
                    SocialinApiV3.getInstance().getUserSuggestions(((GetUsersParams) (requestparams)).query, ((GetUsersParams) (requestparams)).offset, ((GetUsersParams) (requestparams)).limit, s, this, 5);
                }
            }

        };
        basesocialinapirequestcontroller.setRequestParams(new GetUsersParams());
        basesocialinapirequestcontroller.setCacheConfig(5);
        return basesocialinapirequestcontroller;
    }
}

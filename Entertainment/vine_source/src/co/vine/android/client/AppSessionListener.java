// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.client;

import co.vine.android.api.TwitterUser;
import co.vine.android.api.VineClientFlags;
import co.vine.android.api.VineComment;
import co.vine.android.api.VineLogin;
import co.vine.android.api.VinePagedData;
import co.vine.android.api.VinePost;
import co.vine.android.api.VineRepost;
import co.vine.android.api.VineSingleNotification;
import co.vine.android.api.VineUser;
import co.vine.android.network.HttpResult;
import co.vine.android.service.PendingAction;
import co.vine.android.util.image.ImageKey;
import co.vine.android.util.video.VideoKey;
import com.facebook.Session;
import com.facebook.SessionState;
import java.util.ArrayList;
import java.util.HashMap;

// Referenced classes of package co.vine.android.client:
//            Session

public abstract class AppSessionListener
{

    public AppSessionListener()
    {
    }

    public void onAbortAllRequestsComplete()
    {
    }

    public void onBlockUserComplete(String s, int i, String s1, boolean flag)
    {
    }

    public void onBulkFollowComplete(String s, int i, String s1)
    {
    }

    public void onCaptchaRequired(String s, String s1, PendingAction pendingaction)
    {
    }

    public void onCheckTwitterComplete(String s, int i, String s1, int j, boolean flag, VineUser vineuser, VineLogin vinelogin)
    {
    }

    public void onClearCacheComplete(String s, int i, String s1)
    {
    }

    public void onConnectFacebookComplete(String s, int i, String s1)
    {
    }

    public void onConnectTwitterComplete(String s, int i, String s1, String s2, String s3, String s4, long l)
    {
    }

    public void onDeactivateAccountComplete(String s, int i, String s1, boolean flag)
    {
    }

    public void onDeleteCommentComplete(String s, int i, String s1, long l)
    {
    }

    public void onDeleteConversationComplete(String s, int i, String s1, long l)
    {
    }

    public void onDeletePostComplete(String s, long l, int i, String s1)
    {
    }

    public void onDisableUserRepostsComplete(String s, int i, String s1, boolean flag)
    {
    }

    public void onDisconnectTwitterComplete(String s, int i, String s1)
    {
    }

    public void onEnableUserRepostsComplete(String s, int i, String s1, boolean flag)
    {
    }

    public void onFacebookSessionChanged(Session session, SessionState sessionstate, Exception exception)
    {
    }

    public void onFetchClientFlagsComplete(String s, int i, String s1, VineClientFlags vineclientflags, boolean flag)
    {
    }

    public void onFollowComplete(String s, int i, String s1, long l)
    {
    }

    public void onGcmRegistrationComplete(String s, int i, String s1, long l)
    {
    }

    public void onGetActivityComplete(String s, int i, String s1, VinePagedData vinepageddata, VinePagedData vinepageddata1)
    {
    }

    public void onGetActivityCountComplete(String s, int i, String s1, int j, int k)
    {
    }

    public void onGetAddressFriendsComplete(String s, int i, String s1, int j, ArrayList arraylist)
    {
    }

    public void onGetBlockedUsersComplete(String s, int i, String s1, ArrayList arraylist)
    {
    }

    public void onGetChannelsComplete(String s, int i, String s1, ArrayList arraylist)
    {
    }

    public void onGetCommentsComplete(String s, int i, String s1, int j, long l, ArrayList arraylist)
    {
    }

    public void onGetConversationComplete(String s, int i, String s1, long l, int j, boolean flag)
    {
    }

    public void onGetConversationRemoteIdComplete(long l)
    {
    }

    public void onGetConversationRowIdComplete(long l, long l1, String s, boolean flag)
    {
    }

    public void onGetEditionsComplete(int i, ArrayList arraylist)
    {
    }

    public void onGetFriendsTypeAheadComplete(String s, int i, String s1, String s2, ArrayList arraylist)
    {
    }

    public void onGetMessageCountComplete(String s, int i, String s1, int j)
    {
    }

    public void onGetMessageInboxComplete(String s, int i, String s1, int j)
    {
    }

    public void onGetNotificationSettingsComplete(String s, ArrayList arraylist)
    {
    }

    public void onGetPendingNotificationCountComplete(String s, int i, String s1, int j)
    {
    }

    public void onGetPostIdComplete(String s, int i, String s1, long l)
    {
    }

    public void onGetSinglePostComplete(String s, int i, String s1, VinePost vinepost)
    {
    }

    public void onGetTagTypeAheadComplete(String s, int i, String s1, String s2, ArrayList arraylist)
    {
    }

    public void onGetTimeLineComplete(String s, int i, String s1, int j, int k, boolean flag, ArrayList arraylist, 
            String s2, int l, int i1, int j1, long l1, boolean flag1, 
            int k1, String s3)
    {
    }

    public void onGetTwitterAuthUrlComplete(String s, String s1)
    {
    }

    public void onGetTwitterFriendsComplete(String s, int i, String s1, int j, ArrayList arraylist)
    {
    }

    public void onGetTwitterUserComplete(String s, int i, String s1, TwitterUser twitteruser, VineLogin vinelogin)
    {
    }

    public void onGetUserComplete(String s, int i, String s1, VineUser vineuser)
    {
    }

    public void onGetUserIdComplete(String s, int i, String s1, long l)
    {
    }

    public void onGetUserTypeAheadComplete(String s, int i, String s1, String s2, ArrayList arraylist)
    {
    }

    public void onGetUsersComplete(co.vine.android.client.Session session, String s, int i, String s1, int j, ArrayList arraylist, int k, 
            int l, long l1)
    {
    }

    public void onGetUsersMeComplete(String s, int i, String s1, long l, VineUser vineuser)
    {
    }

    public void onIgnoreConversationComplete(String s, int i, String s1, long l)
    {
    }

    public void onLikePost(String s, int i, String s1, long l)
    {
    }

    public void onLoginComplete(co.vine.android.client.Session session, String s, int i, String s1, int j, VineLogin vinelogin)
    {
    }

    public void onLogoutComplete(String s)
    {
    }

    public void onLowMemory()
    {
    }

    public void onMergeNotificationComplete(VineSingleNotification vinesinglenotification, ArrayList arraylist)
    {
    }

    public void onMobileDataNetworkActivated()
    {
    }

    public void onPhotoImageError(ImageKey imagekey, HttpResult httpresult)
    {
    }

    public void onPhotoImageLoaded(HashMap hashmap)
    {
    }

    public void onPostCommentComplete(String s, int i, String s1, long l, String s2, VineComment vinecomment)
    {
    }

    public void onPostVideoComplete(String s, int i, String s1)
    {
    }

    public void onProfilePhotoUpdatedComplete(String s, int i, String s1, String s2)
    {
    }

    public void onReceiveRTCMessage(ArrayList arraylist)
    {
    }

    public void onRemoveUsersComplete(String s)
    {
    }

    public void onReportPostComplete(String s, int i, String s1, long l)
    {
    }

    public void onReportUserComplete(String s, int i, String s1)
    {
    }

    public void onRequestEmailVerificationComplete(String s, int i, String s1, String s2)
    {
    }

    public void onRequestPhoneVerificationComplete(String s, int i, String s1, String s2)
    {
    }

    public void onResetPasswordComplete(String s, int i, String s1)
    {
    }

    public void onRespondFollowRequestComplete(String s, int i, String s1, boolean flag, long l)
    {
    }

    public void onRevine(String s, int i, String s1, long l, VineRepost vinerepost)
    {
    }

    public void onSaveNotificationSettingsComplete(String s, int i, String s1)
    {
    }

    public void onSharePostComplete(String s, int i, String s1)
    {
    }

    public void onSignUpComplete(String s, int i, String s1, VineLogin vinelogin, String s2, String s3, String s4)
    {
    }

    public void onSubscribeConversationComplete()
    {
    }

    public void onTagSearchComplete(String s, int i, String s1, int j, int k, int l)
    {
    }

    public void onTrimMemory(int i)
    {
    }

    public void onTwitterxAuthComplete(String s, int i, String s1, VineLogin vinelogin)
    {
    }

    public void onUnFollowComplete(String s, int i, String s1, long l)
    {
    }

    public void onUnblockUserComplete(String s, int i, String s1, boolean flag)
    {
    }

    public void onUnlikePost(String s, int i, String s1, long l)
    {
    }

    public void onUnrevine(String s, int i, String s1, long l)
    {
    }

    public void onUpdateAcceptOonComplete(String s, int i, String s1, boolean flag)
    {
    }

    public void onUpdateDiscoverability(String s, int i, String s1, int j, boolean flag)
    {
    }

    public void onUpdateEditionComplete(String s, int i, String s1, String s2)
    {
    }

    public void onUpdateEnableAddressBookComplete(String s, int i, String s1, boolean flag)
    {
    }

    public void onUpdateExplicitComplete(String s, int i, String s1, boolean flag)
    {
    }

    public void onUpdateFollowEditorsPicksComplete(String s, int i, String s1, boolean flag)
    {
    }

    public void onUpdatePrivateComplete(String s, int i, String s1, boolean flag)
    {
    }

    public void onUpdateProfileComplete(String s, int i, String s1, String s2)
    {
    }

    public void onUpdateTypingStateComplete(boolean flag)
    {
    }

    public void onUserSearchComplete(String s, int i, String s1, int j, int k, int l)
    {
    }

    public void onVerifyEmailComplete(String s, int i, String s1)
    {
    }

    public void onVerifyPhoneNumberComplete(String s, int i, String s1)
    {
    }

    public void onVideoPathError(VideoKey videokey, HttpResult httpresult)
    {
    }

    public void onVideoPathObtained(HashMap hashmap)
    {
    }

    public void onWebSocketConnectComplete()
    {
    }

    public void onWebSocketDisconnected()
    {
    }

    public void onWebSocketError()
    {
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.util;

import android.content.Context;
import android.view.View;
import co.vine.android.api.VineError;
import co.vine.android.client.AppController;
import co.vine.android.recorder.BasicVineRecorder;
import co.vine.android.recorder.RecordController;
import com.edisonwang.android.slog.SLog;
import com.flurry.android.FlurryAgent;
import java.util.HashMap;

// Referenced classes of package co.vine.android.util:
//            FlurryEvent, CrashUtil, BuildUtil

public class FlurryUtils
{

    private static final String LOADING_KEY = "Loading";
    private static boolean isSignupFailed;
    private static final HashMap mLoadingTime = new HashMap();
    private static boolean sRecordingCamera;
    private static boolean sRecordingFocus;
    private static boolean sRecordingGhost;
    private static boolean sRecordingGrid;
    private static boolean sRecordingSession;

    public FlurryUtils()
    {
    }

    private static String getBucketedTime(long l)
    {
        if (l < 1000L)
        {
            return (new StringBuilder()).append(String.valueOf((l / 100L) * 100L)).append("ms").toString();
        } else
        {
            return String.valueOf((new StringBuilder()).append(Math.max((double)((l / 500L) * 500L) / 1000D, 1.0D)).append("s").toString());
        }
    }

    public static void onSignupFailure(boolean flag, VineError vineerror, int i)
    {
        isSignupFailed = true;
        FlurryEvent flurryevent = new FlurryEvent("SignupFailure");
        if (vineerror != null)
        {
            flurryevent.add("errorCode", Integer.valueOf(vineerror.errorCode)).add("message", vineerror.message);
        }
        flurryevent.add("isTwitter", Boolean.valueOf(flag)).add("statusCode", Integer.valueOf(i)).log();
    }

    public static void onSignupSuccess(boolean flag)
    {
        isSignupFailed = false;
        FlurryEvent.log("SignupSuccess", "isTwitter", Boolean.valueOf(flag));
    }

    public static void onSignupWithPreinstallSuccess(String s)
    {
        FlurryEvent.log("SignUpWithPreinstall", "target", s);
    }

    public static void start(Context context)
    {
        long l;
        try
        {
            FlurryAgent.onStartSession(context, "K5MVVCSN2MQ89JDRWKGY");
            FlurryAgent.setUseHttps(true);
            l = AppController.getInstance(context).getActiveId();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            CrashUtil.logException(context);
            return;
        }
        if (l <= 0L)
        {
            break MISSING_BLOCK_LABEL_31;
        }
        FlurryAgent.setUserId(String.valueOf(l));
        FlurryAgent.setVersionName("2.1.5");
        return;
    }

    public static void stop(Context context)
    {
        try
        {
            FlurryAgent.onEndSession(context);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            CrashUtil.logException(context);
        }
    }

    public static void traceNotificationShown()
    {
        FlurryEvent.log("notificationShown");
    }

    public static void trackAbandonedStage(String s)
    {
        FlurryEvent.log("Abandon", "stage", s);
    }

    public static void trackAbandonedTier(String s)
    {
        SLog.d("Post abandoned for {}, had to wait {}ms and {}ms.", s, Long.valueOf(BasicVineRecorder.sTimeTaken), Long.valueOf(RecordController.sMaxKnownStopTime));
        FlurryEvent.log((new StringBuilder()).append("Post_Abandon_").append(s).toString(), "waitOnCamera", Long.valueOf(BasicVineRecorder.sTimeTaken), "waitOnProcessing", Long.valueOf(RecordController.sMaxKnownStopTime));
    }

    public static void trackAddressNewFollowingCount(String s)
    {
        FlurryEvent.log("FindFriendsAddressNewFollowing", "Count", s);
    }

    public static void trackAttribution()
    {
        FlurryEvent.log("Attribution");
    }

    public static void trackBackFromPostScreen()
    {
        FlurryEvent.log("BackToPreviewFromPostScreen");
    }

    public static void trackBlockUser()
    {
        FlurryEvent.log("BlockUser");
    }

    public static void trackCameraSwitchPressed(View view)
    {
        if (view != null && !sRecordingCamera)
        {
            sRecordingCamera = true;
            FlurryEvent.log("RecordingCamera");
        }
    }

    public static void trackCameraWidgetAdded()
    {
        FlurryEvent.log("CameraWidgetAdded");
    }

    public static void trackCameraWidgetRemoved()
    {
        FlurryEvent.log("CameraWidgetRemoved");
    }

    public static void trackChangedDescription()
    {
        FlurryEvent.log("Settings_ChangedDescription");
    }

    public static void trackChangedEdition()
    {
        FlurryEvent.log("ChangedEdition");
    }

    public static void trackChangedEmail()
    {
        FlurryEvent.log("Settings_ChangedEmail");
    }

    public static void trackChangedLocation()
    {
        FlurryEvent.log("Settings_ChangedLocation");
    }

    public static void trackChangedName()
    {
        FlurryEvent.log("Settings_ChangedName");
    }

    public static void trackChannelChange(String s)
    {
        FlurryEvent.log("PostChannelChange", "channelDetails", s);
    }

    public static void trackConnectFacebook()
    {
        FlurryEvent.log("ConnectFacebook");
    }

    public static void trackConnectTwitter()
    {
        FlurryEvent.log("ConnectTwitter");
    }

    public static void trackContentControls()
    {
        FlurryEvent.log("ContentControls");
    }

    public static void trackCreateProfileShortCut()
    {
        FlurryEvent.log("CreateProfileShortCut");
    }

    public static void trackDeactivateAccount()
    {
        FlurryEvent.log("DeactivateAccount");
    }

    public static void trackDeleteComment()
    {
        FlurryEvent.log("DeleteComment");
    }

    public static void trackDisConnectTwitter()
    {
        FlurryEvent.log("DisconnectTwitter");
    }

    public static void trackFilterProfileReposts(boolean flag, boolean flag1, boolean flag2)
    {
        String s;
        if (flag)
        {
            s = "ProfileRepostsHidden";
        } else
        {
            s = "ProfileRepostsShown";
        }
        FlurryEvent.log(s, "Is Following", Boolean.valueOf(flag1), "Is Me", Boolean.valueOf(flag2));
    }

    public static void trackFindFriendsAddressCount(int i)
    {
        FlurryEvent.log("FindFriendsAddressResultsCount", "Result Count", Integer.valueOf(i));
    }

    public static void trackFindFriendsAddressFailure()
    {
        FlurryEvent.log("FindFriendsAddressFailure");
    }

    public static void trackFindFriendsTabSelect(int i)
    {
        FlurryEvent.log("FindFriendsTabSelect", "Address/Twitter/Search", Integer.valueOf(i));
    }

    public static void trackFindFriendsTwitterCount(int i)
    {
        FlurryEvent.log("FindFriendsTwitterResultsCount", "Result Count", Integer.valueOf(i));
    }

    public static void trackFindFriendsTwitterFailure()
    {
        FlurryEvent.log("FindFriendsTwitterFailure");
    }

    public static void trackFocusSwitchPressed(View view)
    {
        if (view != null && !sRecordingFocus)
        {
            sRecordingFocus = true;
            FlurryEvent.log("RecordingFocus");
        }
    }

    public static void trackFollow(String s)
    {
        FlurryEvent.log("Follow", "source", s);
    }

    public static void trackGetComments()
    {
        FlurryEvent.log("GetComments");
    }

    public static void trackGetEditions()
    {
        FlurryEvent.log("GetEditions");
    }

    public static void trackGetUser(boolean flag)
    {
        FlurryEvent.log("ProfileFetch", "self", Boolean.valueOf(flag));
    }

    public static void trackGhostSwitchPressed(View view)
    {
        if (view != null && !sRecordingGhost)
        {
            sRecordingGhost = true;
            FlurryEvent.log("RecordingGhost");
        }
    }

    public static void trackGraphTimelineRefreshNewCount(int i)
    {
        FlurryEvent.log("GraphRefreshNewVideoCount", "count", Integer.valueOf(i));
    }

    public static void trackGridSwitchPressed(View view)
    {
        if (view != null && !sRecordingGrid)
        {
            sRecordingGrid = true;
            FlurryEvent.log("RecordingGrid");
        }
    }

    public static void trackInvite(String s, String s1)
    {
        FlurryEvent.log((new StringBuilder()).append("Invite_").append(s).toString(), "source", s1);
    }

    public static void trackInviteBannerViewed(long l)
    {
        FlurryEvent.log("InviteBannerViews", "ViewCount", (new StringBuilder()).append(">").append(l).toString());
    }

    public static void trackLikePost(long l, String s)
    {
        FlurryEvent.log("Like", "postId", Long.valueOf(l), "Source View", s);
    }

    public static void trackLoadingTime(String s, long l)
    {
        if (BuildUtil.isProduction())
        {
            mLoadingTime.put("Loading", String.valueOf(l));
            FlurryAgent.logEvent((new StringBuilder()).append("Loading_").append(s).toString(), mLoadingTime);
        }
    }

    public static void trackLockOutSessionCount()
    {
        if (isSignupFailed)
        {
            isSignupFailed = false;
            FlurryEvent.log("SignUpLockOut");
        }
    }

    public static void trackLoginFailure(boolean flag, int i)
    {
        FlurryEvent.log("LoginFailure", "isTwitter", Boolean.valueOf(flag), "statusCode", Integer.valueOf(i));
    }

    public static void trackLoginSuccess(boolean flag)
    {
        FlurryEvent.log("LoginSuccess", "isTwitter", Boolean.valueOf(flag));
    }

    public static void trackLogout()
    {
        FlurryEvent.log("Logout");
    }

    public static void trackNotificationClicked(String s)
    {
        FlurryEvent.log("notificationClicked", "type", s);
    }

    public static void trackNotificationDisabled()
    {
        FlurryEvent.log("notificationDisabled");
    }

    public static void trackNotificationReceived(boolean flag)
    {
        FlurryEvent.log("notificationReceived", "isDisabled", Boolean.valueOf(flag));
    }

    public static void trackNotificationSettings()
    {
        FlurryEvent.log("NotificationSettings");
    }

    public static void trackPost(boolean flag)
    {
        FlurryEvent.log("Post", "Vine", Boolean.valueOf(flag));
    }

    public static void trackPostComment()
    {
        FlurryEvent.log("PostComment");
    }

    public static void trackPostTier(String s)
    {
        FlurryEvent.log((new StringBuilder()).append("Post_Posted_").append(s).toString(), "waitOnCamera", Long.valueOf(BasicVineRecorder.sTimeTaken), "waitOnProcessing", Long.valueOf(RecordController.sMaxKnownStopTime));
    }

    public static void trackPreviewAction(String s)
    {
        FlurryEvent.log("PreviewAction", "action", s);
    }

    public static void trackPrivacyPolicy()
    {
        FlurryEvent.log("PrivacyPolicy");
    }

    public static void trackProfileImageClick(boolean flag)
    {
        FlurryEvent.log("ProfileImageClick", "self", Boolean.valueOf(flag));
    }

    public static void trackRecordingDestroy()
    {
    }

    public static void trackRecordingInfo(int i, long l, long l1, int j)
    {
        (new FlurryEvent("Recording")).add("Duration", Long.valueOf(l)).add("Wait time", Long.valueOf(l1)).add("Cuts", Integer.valueOf(j)).add("Phase", Integer.valueOf(i)).log();
    }

    public static void trackRecordingStart()
    {
        sRecordingCamera = false;
        sRecordingFocus = false;
        sRecordingGrid = false;
        sRecordingGhost = false;
        sRecordingSession = false;
        FlurryEvent.log("RecordingStart");
    }

    public static void trackReportPost()
    {
        FlurryEvent.log("ReportPost");
    }

    public static void trackReportUser()
    {
        FlurryEvent.log("ReportUser");
    }

    public static void trackResetPassword()
    {
        FlurryEvent.log("ResetPassword");
    }

    public static void trackRespondTime(String s, String s1, long l, long l1, boolean flag)
    {
        if (BuildUtil.isProduction())
        {
            StringBuilder stringbuilder = (new StringBuilder()).append("Response_");
            Object obj;
            if (flag)
            {
                obj = "video";
            } else
            {
                obj = "generic";
            }
            obj = new FlurryEvent(stringbuilder.append(((String) (obj))).toString());
            if (flag)
            {
                ((FlurryEvent) (obj)).add("host", s);
            } else
            {
                ((FlurryEvent) (obj)).add("host", s).add("path", s1);
            }
            ((FlurryEvent) (obj)).add("statusTime", getBucketedTime(l)).add("totalTime", getBucketedTime(l1)).log();
        }
    }

    public static void trackRevine(long l, String s)
    {
        FlurryEvent.log("Revine", "postId", Long.valueOf(l), "Source View", s);
    }

    public static void trackSaveSession(String s)
    {
        FlurryEvent.log("SaveSession", "source", s);
    }

    public static void trackSearchTags()
    {
        FlurryEvent.log("SearchTags");
    }

    public static void trackSearchUsers()
    {
        FlurryEvent.log("SearchUser");
    }

    public static void trackSeeReviners()
    {
        FlurryEvent.log("SeeReviners");
    }

    public static void trackSessionSwitchPressed(View view)
    {
        if (!sRecordingSession)
        {
            sRecordingSession = true;
            FlurryEvent.log("RecordingSession");
        }
    }

    public static void trackSessionSwitchPressedOnDraftUpgrade(int i)
    {
        if (!sRecordingSession)
        {
            sRecordingSession = true;
            FlurryEvent.log("RecordingSessionDraftUpgrading", "count", Integer.valueOf(i));
        }
    }

    public static void trackSharePost(String s, long l)
    {
        FlurryEvent.log((new StringBuilder()).append("SharePost_").append(s).toString(), "postId", Long.valueOf(l));
    }

    public static void trackShareProfile()
    {
        FlurryEvent.log("ShareProfile");
    }

    public static void trackTabChange(String s)
    {
        FlurryEvent.log((new StringBuilder()).append("Page_").append(s).toString());
    }

    public static void trackTimeLinePageScroll(String s, int i)
    {
        FlurryEvent.log((new StringBuilder()).append("TimeLinePageScroll_").append(s).toString(), "page", Integer.valueOf(i));
    }

    public static void trackTos()
    {
        FlurryEvent.log("TermsOfServiceClicked");
    }

    public static void trackTwitterNewFollowingCount(String s)
    {
        FlurryEvent.log("FindFriendsTwitterNewFollowing", "Count", s);
    }

    public static void trackUnBlockUser()
    {
        FlurryEvent.log("UnBlockUser");
    }

    public static void trackUnLikePost(String s)
    {
        FlurryEvent.log("UnLike", "Source View", s);
    }

    public static void trackUnRevine(String s)
    {
        FlurryEvent.log("UnRevine", "Source View", s);
    }

    public static void trackUnfollow(String s)
    {
        FlurryEvent.log("Unfollow", "source", s);
    }

    public static void trackValidPullToRefreshRelease(String s)
    {
        FlurryEvent.log("ValidPullToRefreshRelease", "source", s);
    }

    public static void trackVineLoopWatched()
    {
        FlurryEvent.log("VineLoopWatched");
    }

    public static void trackVisitFindFriends(String s)
    {
        FlurryEvent.log("VisitFindFriends", "source", s);
    }

    public static void trackVisitInbox(String s)
    {
        FlurryEvent.log("VisitInbox", "source", s);
    }

    public static void trackVisitSearch(String s)
    {
        FlurryEvent.log("VisitSearch", "source", s);
    }

    public static void trackVisitSettings(String s)
    {
        FlurryEvent.log("VisitSettings", "source", s);
    }

    public static void trackZeroRatedSessionStarted(boolean flag)
    {
        if (flag)
        {
            FlurryEvent.log("ZeroRatedSessionStarted");
        }
    }

}

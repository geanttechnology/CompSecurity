.class public Lco/vine/android/HomeTimelineFragment;
.super Lco/vine/android/BaseTimelineFragment;
.source "HomeTimelineFragment.java"

# interfaces
.implements Lco/vine/android/widgets/PromptDialogSupportFragment$OnDialogDoneListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lco/vine/android/HomeTimelineFragment$HomeTimeLineSessionListener;
    }
.end annotation


# static fields
.field private static final DIALOG_ADD_WIDGET:I = 0x3e0

.field private static final EVENT_SOURCE_TITLE:Ljava/lang/String; = "Home Timeline"

.field public static final PREF_INVITE_BANNER_CLICKED:Ljava/lang/String; = "inviteBannerWasClicked"

.field public static final PREF_INVITE_BANNER_VIEW_COUNT:Ljava/lang/String; = "inviteBannerViewCount"

.field public static final PREF_VM_ONBOARD_IN_PROGRESS:Ljava/lang/String; = "vmOnboardInProgress"

.field public static final REQUEST_FIND_FRIENDS:I = 0x0

.field public static final REQUEST_SETTINGS:I = 0x1

.field public static final SHOW_ADD_WIDGET_THRESHOLD:I = 0x5

.field private static sIsNewUser:Z


# instance fields
.field private mInviteBottomBanner:Landroid/widget/FrameLayout;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 46
    const/4 v0, 0x0

    sput-boolean v0, Lco/vine/android/HomeTimelineFragment;->sIsNewUser:Z

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 30
    invoke-direct {p0}, Lco/vine/android/BaseTimelineFragment;-><init>()V

    .line 219
    return-void
.end method

.method static synthetic access$100(Lco/vine/android/HomeTimelineFragment;)Landroid/widget/FrameLayout;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/HomeTimelineFragment;

    .prologue
    .line 30
    iget-object v0, p0, Lco/vine/android/HomeTimelineFragment;->mInviteBottomBanner:Landroid/widget/FrameLayout;

    return-object v0
.end method


# virtual methods
.method protected fetchPosts(IJZ)Ljava/lang/String;
    .locals 13
    .param p1, "page"    # I
    .param p2, "anchor"    # J
    .param p4, "userInitiated"    # Z

    .prologue
    .line 198
    iget-object v0, p0, Lco/vine/android/HomeTimelineFragment;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v0}, Lco/vine/android/client/AppController;->fetchActivityCounts()Ljava/lang/String;

    .line 199
    iget-object v0, p0, Lco/vine/android/HomeTimelineFragment;->mAppController:Lco/vine/android/client/AppController;

    iget-object v1, p0, Lco/vine/android/HomeTimelineFragment;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v1}, Lco/vine/android/client/AppController;->getActiveSession()Lco/vine/android/client/Session;

    move-result-object v1

    const/16 v2, 0xa

    iget-object v3, p0, Lco/vine/android/HomeTimelineFragment;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v3}, Lco/vine/android/client/AppController;->getActiveId()J

    move-result-wide v3

    const/4 v5, 0x1

    iget-object v6, p0, Lco/vine/android/HomeTimelineFragment;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v6}, Lco/vine/android/client/AppController;->getActiveId()J

    move-result-wide v6

    invoke-static {v6, v7}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v10

    const/4 v11, 0x0

    const/4 v12, 0x0

    move v6, p1

    move-wide v7, p2

    move/from16 v9, p4

    invoke-virtual/range {v0 .. v12}, Lco/vine/android/client/AppController;->fetchPosts(Lco/vine/android/client/Session;IJIIJZLjava/lang/String;Ljava/lang/String;Landroid/net/Uri;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 24
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 64
    invoke-super/range {p0 .. p1}, Lco/vine/android/BaseTimelineFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 65
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/HomeTimelineFragment;->mListView:Landroid/widget/ListView;

    move-object/from16 v20, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/HomeTimelineFragment;->mFeedAdapter:Lco/vine/android/widget/GenericTimelineAdapter;

    move-object/from16 v21, v0

    invoke-virtual/range {v20 .. v21}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 67
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/HomeTimelineFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v5

    .line 68
    .local v5, "activity":Landroid/support/v4/app/FragmentActivity;
    invoke-static {v5}, Landroid/accounts/AccountManager;->get(Landroid/content/Context;)Landroid/accounts/AccountManager;

    move-result-object v7

    .line 69
    .local v7, "am":Landroid/accounts/AccountManager;
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/HomeTimelineFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v20

    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/HomeTimelineFragment;->mAppController:Lco/vine/android/client/AppController;

    move-object/from16 v21, v0

    invoke-virtual/range {v21 .. v21}, Lco/vine/android/client/AppController;->getActiveSession()Lco/vine/android/client/Session;

    move-result-object v21

    invoke-virtual/range {v21 .. v21}, Lco/vine/android/client/Session;->getLoginEmail()Ljava/lang/String;

    move-result-object v21

    invoke-static/range {v20 .. v21}, Lco/vine/android/client/VineAccountHelper;->getAccount(Landroid/content/Context;Ljava/lang/String;)Landroid/accounts/Account;

    move-result-object v4

    .line 72
    .local v4, "account":Landroid/accounts/Account;
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/HomeTimelineFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v20

    invoke-static/range {v20 .. v20}, Lco/vine/android/util/Util;->getDefaultSharedPrefs(Landroid/content/Context;)Landroid/content/SharedPreferences;

    move-result-object v17

    .line 73
    .local v17, "sp":Landroid/content/SharedPreferences;
    const-string v20, "profile_follow_count"

    const/16 v21, 0x0

    move-object/from16 v0, v17

    move-object/from16 v1, v20

    move/from16 v2, v21

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences;->getInt(Ljava/lang/String;I)I

    move-result v10

    .line 75
    .local v10, "followCount":I
    const-string v20, "inviteBannerWasClicked"

    const/16 v21, 0x0

    move-object/from16 v0, v17

    move-object/from16 v1, v20

    move/from16 v2, v21

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v20

    if-eqz v20, :cond_0

    const/16 v20, 0x5

    move/from16 v0, v20

    if-gt v10, v0, :cond_3

    .line 77
    :cond_0
    :try_start_0
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/HomeTimelineFragment;->getView()Landroid/view/View;

    move-result-object v20

    const v21, 0x7f0a0145

    invoke-virtual/range {v20 .. v21}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v20

    check-cast v20, Landroid/widget/FrameLayout;

    move-object/from16 v0, v20

    move-object/from16 v1, p0

    iput-object v0, v1, Lco/vine/android/HomeTimelineFragment;->mInviteBottomBanner:Landroid/widget/FrameLayout;

    .line 78
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/HomeTimelineFragment;->mInviteBottomBanner:Landroid/widget/FrameLayout;

    move-object/from16 v20, v0

    new-instance v21, Lco/vine/android/HomeTimelineFragment$1;

    move-object/from16 v0, v21

    move-object/from16 v1, p0

    invoke-direct {v0, v1}, Lco/vine/android/HomeTimelineFragment$1;-><init>(Lco/vine/android/HomeTimelineFragment;)V

    invoke-virtual/range {v20 .. v21}, Landroid/widget/FrameLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 87
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/HomeTimelineFragment;->mInviteBottomBanner:Landroid/widget/FrameLayout;

    move-object/from16 v20, v0

    const/16 v21, 0x0

    invoke-virtual/range {v20 .. v21}, Landroid/widget/FrameLayout;->setVisibility(I)V

    .line 89
    const-string v20, "inviteBannerViewCount"

    const-wide/16 v21, 0x0

    move-object/from16 v0, v17

    move-object/from16 v1, v20

    move-wide/from16 v2, v21

    invoke-interface {v0, v1, v2, v3}, Landroid/content/SharedPreferences;->getLong(Ljava/lang/String;J)J

    move-result-wide v20

    const-wide/16 v22, 0x1

    add-long v18, v20, v22

    .line 90
    .local v18, "viewCount":J
    invoke-interface/range {v17 .. v17}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v20

    const-string v21, "inviteBannerViewCount"

    move-object/from16 v0, v20

    move-object/from16 v1, v21

    move-wide/from16 v2, v18

    invoke-interface {v0, v1, v2, v3}, Landroid/content/SharedPreferences$Editor;->putLong(Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;

    move-result-object v20

    invoke-interface/range {v20 .. v20}, Landroid/content/SharedPreferences$Editor;->apply()V

    .line 91
    const-wide/16 v20, 0xa

    cmp-long v20, v18, v20

    if-gez v20, :cond_1

    const-wide/16 v20, 0x5

    rem-long v20, v18, v20

    const-wide/16 v22, 0x0

    cmp-long v20, v20, v22

    if-eqz v20, :cond_2

    :cond_1
    const-wide/16 v20, 0xa

    rem-long v20, v18, v20

    const-wide/16 v22, 0x0

    cmp-long v20, v20, v22

    if-nez v20, :cond_3

    .line 92
    :cond_2
    invoke-static/range {v18 .. v19}, Lco/vine/android/util/FlurryUtils;->trackInviteBannerViewed(J)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 101
    .end local v18    # "viewCount":J
    :cond_3
    :goto_0
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/HomeTimelineFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v20

    invoke-static/range {v20 .. v20}, Lco/vine/android/util/Util;->getDefaultSharedPrefs(Landroid/content/Context;)Landroid/content/SharedPreferences;

    move-result-object v14

    .line 102
    .local v14, "prefs":Landroid/content/SharedPreferences;
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/HomeTimelineFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v20

    invoke-virtual/range {v20 .. v20}, Landroid/support/v4/app/FragmentActivity;->getIntent()Landroid/content/Intent;

    move-result-object v6

    .line 103
    .local v6, "activityIntent":Landroid/content/Intent;
    const-string v20, "is_new_user"

    move-object/from16 v0, v20

    invoke-virtual {v6, v0}, Landroid/content/Intent;->hasExtra(Ljava/lang/String;)Z

    move-result v20

    if-eqz v20, :cond_4

    .line 104
    const/16 v20, 0x1

    sput-boolean v20, Lco/vine/android/HomeTimelineFragment;->sIsNewUser:Z

    .line 107
    :cond_4
    if-eqz v4, :cond_6

    invoke-static {v7, v4}, Lco/vine/android/client/VineAccountHelper;->shouldShowVmOnboard(Landroid/accounts/AccountManager;Landroid/accounts/Account;)Z

    move-result v20

    if-eqz v20, :cond_6

    sget-boolean v20, Lco/vine/android/HomeTimelineFragment;->sIsNewUser:Z

    if-nez v20, :cond_6

    const/16 v16, 0x1

    .line 109
    .local v16, "shouldShowVmOnboard":Z
    :goto_1
    if-eqz v16, :cond_7

    .line 110
    invoke-static {v7, v4}, Lco/vine/android/client/VineAccountHelper;->setDidShowVmOnboard(Landroid/accounts/AccountManager;Landroid/accounts/Account;)V

    .line 112
    invoke-interface {v14}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v9

    .line 113
    .local v9, "e":Landroid/content/SharedPreferences$Editor;
    const-string v20, "vmOnboardInProgress"

    const/16 v21, 0x1

    move-object/from16 v0, v20

    move/from16 v1, v21

    invoke-interface {v9, v0, v1}, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    move-result-object v20

    invoke-interface/range {v20 .. v20}, Landroid/content/SharedPreferences$Editor;->apply()V

    .line 115
    const v20, 0x7f0300a7

    const v21, 0x7f0a0236

    const v22, 0x7f0a008a

    move/from16 v0, v20

    move/from16 v1, v21

    move/from16 v2, v22

    invoke-static {v5, v0, v1, v2}, Lco/vine/android/ViewOverlayActivity;->getIntent(Landroid/content/Context;III)Landroid/content/Intent;

    move-result-object v11

    .line 117
    .local v11, "intent":Landroid/content/Intent;
    const/16 v20, 0x2

    move/from16 v0, v20

    invoke-virtual {v5, v11, v0}, Landroid/support/v4/app/FragmentActivity;->startActivityForResult(Landroid/content/Intent;I)V

    .line 123
    .end local v11    # "intent":Landroid/content/Intent;
    :goto_2
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/HomeTimelineFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v20

    const-string v21, "capture"

    const/16 v22, 0x0

    invoke-virtual/range {v20 .. v22}, Landroid/support/v4/app/FragmentActivity;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v8

    .line 125
    .local v8, "capturePrefs":Landroid/content/SharedPreferences;
    const-string v20, "recorder_launch_count"

    const/16 v21, 0x0

    move-object/from16 v0, v20

    move/from16 v1, v21

    invoke-interface {v8, v0, v1}, Landroid/content/SharedPreferences;->getInt(Ljava/lang/String;I)I

    move-result v12

    .line 126
    .local v12, "launchCount":I
    if-eqz v4, :cond_8

    if-nez v16, :cond_8

    invoke-static {}, Lco/vine/android/util/BuildUtil;->isAmazon()Z

    move-result v20

    if-nez v20, :cond_8

    invoke-static {}, Lco/vine/android/AppImpl;->getInstance()Lco/vine/android/AppImpl;

    move-result-object v20

    move-object/from16 v0, v20

    invoke-virtual {v0, v5, v7, v4}, Lco/vine/android/AppImpl;->doAddWidget(Landroid/content/Context;Landroid/accounts/AccountManager;Landroid/accounts/Account;)Z

    move-result v20

    if-eqz v20, :cond_8

    const/16 v20, 0x5

    move/from16 v0, v20

    if-le v12, v0, :cond_8

    const/4 v15, 0x1

    .line 130
    .local v15, "shouldShowAddWidget":Z
    :goto_3
    if-eqz v15, :cond_5

    .line 131
    invoke-static {v7, v4}, Lco/vine/android/client/VineAccountHelper;->setDidShowAddWidget(Landroid/accounts/AccountManager;Landroid/accounts/Account;)V

    .line 132
    const/16 v20, 0x3e0

    invoke-static/range {v20 .. v20}, Lco/vine/android/widgets/PromptDialogSupportFragment;->newInstance(I)Lco/vine/android/widgets/PromptDialogSupportFragment;

    move-result-object v13

    .line 134
    .local v13, "p":Lco/vine/android/widgets/PromptDialogSupportFragment;
    const v20, 0x7f0e0046

    move/from16 v0, v20

    invoke-virtual {v13, v0}, Lco/vine/android/widgets/PromptDialogSupportFragment;->setTitle(I)Lco/vine/android/widgets/PromptDialogSupportFragment;

    .line 135
    const v20, 0x7f0e0045

    move/from16 v0, v20

    invoke-virtual {v13, v0}, Lco/vine/android/widgets/PromptDialogSupportFragment;->setMessage(I)Lco/vine/android/widgets/PromptDialogSupportFragment;

    .line 136
    const v20, 0x7f0e0057

    move/from16 v0, v20

    invoke-virtual {v13, v0}, Lco/vine/android/widgets/PromptDialogSupportFragment;->setNegativeButton(I)Lco/vine/android/widgets/PromptDialogSupportFragment;

    .line 137
    const v20, 0x7f0e0048

    move/from16 v0, v20

    invoke-virtual {v13, v0}, Lco/vine/android/widgets/PromptDialogSupportFragment;->setPositiveButton(I)Lco/vine/android/widgets/PromptDialogSupportFragment;

    .line 138
    move-object/from16 v0, p0

    invoke-virtual {v13, v0}, Lco/vine/android/widgets/PromptDialogSupportFragment;->setListener(Lco/vine/android/widgets/PromptDialogSupportFragment$OnDialogDoneListener;)V

    .line 140
    :try_start_1
    invoke-virtual {v5}, Landroid/support/v4/app/FragmentActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v20

    move-object/from16 v0, v20

    invoke-virtual {v13, v0}, Lco/vine/android/widgets/PromptDialogSupportFragment;->show(Landroid/support/v4/app/FragmentManager;)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1

    .line 145
    .end local v13    # "p":Lco/vine/android/widgets/PromptDialogSupportFragment;
    :cond_5
    :goto_4
    return-void

    .line 94
    .end local v6    # "activityIntent":Landroid/content/Intent;
    .end local v8    # "capturePrefs":Landroid/content/SharedPreferences;
    .end local v9    # "e":Landroid/content/SharedPreferences$Editor;
    .end local v12    # "launchCount":I
    .end local v14    # "prefs":Landroid/content/SharedPreferences;
    .end local v15    # "shouldShowAddWidget":Z
    .end local v16    # "shouldShowVmOnboard":Z
    :catch_0
    move-exception v9

    .line 96
    .local v9, "e":Ljava/lang/Exception;
    const-string v20, "Failed to show invite banner, which is ok."

    const/16 v21, 0x0

    move/from16 v0, v21

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v21, v0

    move-object/from16 v0, v20

    move-object/from16 v1, v21

    invoke-static {v9, v0, v1}, Lco/vine/android/util/CrashUtil;->logException(Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 97
    invoke-interface/range {v17 .. v17}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v20

    const-string v21, "inviteBannerWasClicked"

    const/16 v22, 0x1

    invoke-interface/range {v20 .. v22}, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    move-result-object v20

    invoke-interface/range {v20 .. v20}, Landroid/content/SharedPreferences$Editor;->apply()V

    goto/16 :goto_0

    .line 107
    .end local v9    # "e":Ljava/lang/Exception;
    .restart local v6    # "activityIntent":Landroid/content/Intent;
    .restart local v14    # "prefs":Landroid/content/SharedPreferences;
    :cond_6
    const/16 v16, 0x0

    goto/16 :goto_1

    .line 119
    .restart local v16    # "shouldShowVmOnboard":Z
    :cond_7
    invoke-interface {v14}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v9

    .line 120
    .local v9, "e":Landroid/content/SharedPreferences$Editor;
    const-string v20, "vmOnboardInProgress"

    const/16 v21, 0x0

    move-object/from16 v0, v20

    move/from16 v1, v21

    invoke-interface {v9, v0, v1}, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    move-result-object v20

    invoke-interface/range {v20 .. v20}, Landroid/content/SharedPreferences$Editor;->apply()V

    goto/16 :goto_2

    .line 126
    .restart local v8    # "capturePrefs":Landroid/content/SharedPreferences;
    .restart local v12    # "launchCount":I
    :cond_8
    const/4 v15, 0x0

    goto :goto_3

    .line 141
    .restart local v13    # "p":Lco/vine/android/widgets/PromptDialogSupportFragment;
    .restart local v15    # "shouldShowAddWidget":Z
    :catch_1
    move-exception v20

    goto :goto_4
.end method

.method public onActivityResult(IILandroid/content/Intent;)V
    .locals 1
    .param p1, "requestCode"    # I
    .param p2, "resultCode"    # I
    .param p3, "data"    # Landroid/content/Intent;

    .prologue
    const/4 v0, 0x1

    .line 149
    invoke-super {p0, p1, p2, p3}, Lco/vine/android/BaseTimelineFragment;->onActivityResult(IILandroid/content/Intent;)V

    .line 150
    if-ne p1, v0, :cond_0

    if-ne p2, v0, :cond_0

    .line 152
    const/4 v0, 0x0

    iput-boolean v0, p0, Lco/vine/android/HomeTimelineFragment;->mFetched:Z

    .line 154
    :cond_0
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 51
    invoke-super {p0, p1}, Lco/vine/android/BaseTimelineFragment;->onCreate(Landroid/os/Bundle;)V

    .line 52
    new-instance v0, Lco/vine/android/HomeTimelineFragment$HomeTimeLineSessionListener;

    const/4 v1, 0x0

    invoke-direct {v0, p0, v1}, Lco/vine/android/HomeTimelineFragment$HomeTimeLineSessionListener;-><init>(Lco/vine/android/HomeTimelineFragment;Lco/vine/android/HomeTimelineFragment$1;)V

    iput-object v0, p0, Lco/vine/android/HomeTimelineFragment;->mAppSessionListener:Lco/vine/android/client/AppSessionListener;

    .line 53
    const-string v0, "Home Timeline"

    invoke-virtual {p0, v0}, Lco/vine/android/HomeTimelineFragment;->setFlurryEventSource(Ljava/lang/String;)V

    .line 54
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lco/vine/android/HomeTimelineFragment;->setFocused(Z)V

    .line 55
    return-void
.end method

.method public onDialogDone(Landroid/content/DialogInterface;II)V
    .locals 2
    .param p1, "dialog"    # Landroid/content/DialogInterface;
    .param p2, "id"    # I
    .param p3, "which"    # I

    .prologue
    .line 206
    packed-switch p2, :pswitch_data_0

    .line 216
    :goto_0
    invoke-interface {p1}, Landroid/content/DialogInterface;->dismiss()V

    .line 217
    return-void

    .line 208
    :pswitch_0
    packed-switch p3, :pswitch_data_1

    goto :goto_0

    .line 210
    :pswitch_1
    invoke-static {}, Lco/vine/android/AppImpl;->getInstance()Lco/vine/android/AppImpl;

    move-result-object v0

    invoke-virtual {p0}, Lco/vine/android/HomeTimelineFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-virtual {v0, v1}, Lco/vine/android/AppImpl;->setupWidget(Landroid/app/Activity;)V

    goto :goto_0

    .line 206
    nop

    :pswitch_data_0
    .packed-switch 0x3e0
        :pswitch_0
    .end packed-switch

    .line 208
    :pswitch_data_1
    .packed-switch -0x1
        :pswitch_1
    .end packed-switch
.end method

.method public onPause()V
    .locals 2

    .prologue
    .line 192
    invoke-super {p0}, Lco/vine/android/BaseTimelineFragment;->onPause()V

    .line 193
    iget-object v0, p0, Lco/vine/android/HomeTimelineFragment;->mFeedAdapter:Lco/vine/android/widget/GenericTimelineAdapter;

    invoke-virtual {p0}, Lco/vine/android/HomeTimelineFragment;->isFocused()Z

    move-result v1

    invoke-virtual {v0, v1}, Lco/vine/android/widget/GenericTimelineAdapter;->onPause(Z)V

    .line 194
    return-void
.end method

.method public onResume()V
    .locals 6

    .prologue
    const/4 v5, 0x0

    .line 166
    invoke-super {p0}, Lco/vine/android/BaseTimelineFragment;->onResume()V

    .line 167
    invoke-virtual {p0}, Lco/vine/android/HomeTimelineFragment;->registerMergePostReceiver()V

    .line 168
    invoke-virtual {p0}, Lco/vine/android/HomeTimelineFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v3

    check-cast v3, Lco/vine/android/HomeTabActivity;

    invoke-virtual {v3}, Lco/vine/android/HomeTabActivity;->showMenuIfNeeded()V

    .line 169
    iget-object v3, p0, Lco/vine/android/HomeTimelineFragment;->mFeedAdapter:Lco/vine/android/widget/GenericTimelineAdapter;

    invoke-virtual {p0}, Lco/vine/android/HomeTimelineFragment;->isFocused()Z

    move-result v4

    invoke-virtual {v3, v4}, Lco/vine/android/widget/GenericTimelineAdapter;->onResume(Z)V

    .line 170
    iget-object v3, p0, Lco/vine/android/HomeTimelineFragment;->mFeedAdapter:Lco/vine/android/widget/GenericTimelineAdapter;

    const-string v4, "HomeTimelineFragment"

    invoke-virtual {v3, v4}, Lco/vine/android/widget/GenericTimelineAdapter;->startLoadingTimeProfiling(Ljava/lang/String;)V

    .line 171
    iget-object v3, p0, Lco/vine/android/HomeTimelineFragment;->mAdapter:Landroid/widget/BaseAdapter;

    invoke-virtual {v3}, Landroid/widget/BaseAdapter;->isEmpty()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 172
    const/4 v3, 0x3

    const/4 v4, 0x1

    invoke-virtual {p0, v3, v4}, Lco/vine/android/HomeTimelineFragment;->fetchContent(IZ)V

    .line 175
    :cond_0
    invoke-virtual {p0}, Lco/vine/android/HomeTimelineFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v3

    invoke-static {v3}, Lco/vine/android/util/ClientFlagsHelper;->shouldShowClientFlagsBanner(Landroid/content/Context;)Z

    move-result v3

    if-eqz v3, :cond_3

    iget-boolean v3, p0, Lco/vine/android/HomeTimelineFragment;->mClientFlagsBannerWasDismissed:Z

    if-nez v3, :cond_3

    invoke-virtual {p0}, Lco/vine/android/HomeTimelineFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v3

    invoke-static {v3}, Lco/vine/android/util/Util;->getActiveNetworkType(Landroid/content/Context;)I

    move-result v3

    if-nez v3, :cond_3

    .line 177
    invoke-virtual {p0}, Lco/vine/android/HomeTimelineFragment;->showClientFlagsBanner()V

    .line 178
    invoke-virtual {p0}, Lco/vine/android/HomeTimelineFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v3

    invoke-static {v3}, Lco/vine/android/util/Util;->getDefaultSharedPrefs(Landroid/content/Context;)Landroid/content/SharedPreferences;

    move-result-object v2

    .line 179
    .local v2, "prefs":Landroid/content/SharedPreferences;
    const-string v3, "client_flags_message_title"

    invoke-interface {v2, v3, v5}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 180
    .local v1, "messageTitle":Ljava/lang/String;
    const-string v3, "client_flags_message_text"

    invoke-interface {v2, v3, v5}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 181
    .local v0, "messageText":Ljava/lang/String;
    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_1

    const v3, 0x7f0a008d

    invoke-virtual {p0, v3, v1}, Lco/vine/android/HomeTimelineFragment;->setBannerText(ILjava/lang/String;)V

    .line 182
    :cond_1
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_2

    const v3, 0x7f0a0093

    invoke-virtual {p0, v3, v0}, Lco/vine/android/HomeTimelineFragment;->setBannerText(ILjava/lang/String;)V

    .line 184
    :cond_2
    iget-object v3, p0, Lco/vine/android/HomeTimelineFragment;->mInviteBottomBanner:Landroid/widget/FrameLayout;

    if-eqz v3, :cond_3

    .line 185
    iget-object v3, p0, Lco/vine/android/HomeTimelineFragment;->mInviteBottomBanner:Landroid/widget/FrameLayout;

    const/16 v4, 0x8

    invoke-virtual {v3, v4}, Landroid/widget/FrameLayout;->setVisibility(I)V

    .line 188
    .end local v0    # "messageText":Ljava/lang/String;
    .end local v1    # "messageTitle":Ljava/lang/String;
    .end local v2    # "prefs":Landroid/content/SharedPreferences;
    :cond_3
    return-void
.end method

.method public removeBanner()V
    .locals 2

    .prologue
    .line 159
    iget-object v0, p0, Lco/vine/android/HomeTimelineFragment;->mInviteBottomBanner:Landroid/widget/FrameLayout;

    if-eqz v0, :cond_0

    .line 160
    iget-object v0, p0, Lco/vine/android/HomeTimelineFragment;->mInviteBottomBanner:Landroid/widget/FrameLayout;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/FrameLayout;->setVisibility(I)V

    .line 162
    :cond_0
    return-void
.end method

.method protected trackNewCount()Z
    .locals 1

    .prologue
    .line 59
    const/4 v0, 0x1

    return v0
.end method

.class public Lco/vine/android/util/ConversationMenuHelper;
.super Lcom/jeremyfeinstein/slidingmenu/lib/SlidingActivityHelper;
.source "ConversationMenuHelper.java"

# interfaces
.implements Landroid/text/TextWatcher;
.implements Landroid/view/View$OnClickListener;
.implements Landroid/os/Handler$Callback;
.implements Landroid/widget/AdapterView$OnItemClickListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lco/vine/android/util/ConversationMenuHelper$ConversationMenuHelperAppSessionListener;,
        Lco/vine/android/util/ConversationMenuHelper$OnboardingOverlayFadeOutRunnable;
    }
.end annotation


# static fields
.field private static final FETCH_THRESHOLD_MS:J = 0xc8L

.field private static final MSG_SEARCH_USERS:I = 0x1

.field private static final QUERY_FETCH_THRESHOLD:I = 0x2

.field private static final TAG_INBOX_FRAGMENT:Ljava/lang/String; = "Inbox"


# instance fields
.field private mActionContainer:Landroid/view/ViewGroup;

.field private final mActivity:Lco/vine/android/BaseControllerActionBarActivity;

.field private mAppController:Lco/vine/android/client/AppController;

.field private final mAppSessionListener:Lco/vine/android/util/ConversationMenuHelper$ConversationMenuHelperAppSessionListener;

.field private mFriendSearchAdapter:Lco/vine/android/FriendSearchAdapter;

.field private mHandler:Landroid/os/Handler;

.field private mInboxFragment:Lco/vine/android/InboxFragment;

.field private mIsSearching:Z

.field private final mMessageSentFadeListener:Landroid/view/animation/Animation$AnimationListener;

.field private mNothingFoundText:Landroid/view/View;

.field private mOnboardingOverlay:Landroid/widget/TextView;

.field private mOthersText:Landroid/widget/TextView;

.field private mProfileColor:I

.field private mSadFace:Landroid/view/View;

.field private mSearchContainer:Landroid/view/ViewGroup;

.field private mSearchField:Landroid/widget/EditText;

.field private mSearchInProgress:Landroid/widget/ProgressBar;

.field private mSearchOnBackgroundView:Landroid/view/View;

.field private mSearchResultView:Lcom/twitter/android/widget/RefreshableListView;

.field private final mTapToStartFadeListener:Landroid/view/animation/Animation$AnimationListener;

.field private mTapToStartText:Landroid/widget/TextView;

.field private mWaitingToStartSearchUserId:J

.field private mWaitingToStartUserId:J


# direct methods
.method public constructor <init>(Lco/vine/android/BaseControllerActionBarActivity;)V
    .locals 2
    .param p1, "activity"    # Lco/vine/android/BaseControllerActionBarActivity;

    .prologue
    const-wide/16 v0, -0x1

    .line 82
    invoke-direct {p0, p1}, Lcom/jeremyfeinstein/slidingmenu/lib/SlidingActivityHelper;-><init>(Landroid/app/Activity;)V

    .line 69
    iput-wide v0, p0, Lco/vine/android/util/ConversationMenuHelper;->mWaitingToStartUserId:J

    .line 77
    iput-wide v0, p0, Lco/vine/android/util/ConversationMenuHelper;->mWaitingToStartSearchUserId:J

    .line 171
    new-instance v0, Lco/vine/android/util/ConversationMenuHelper$2;

    invoke-direct {v0, p0}, Lco/vine/android/util/ConversationMenuHelper$2;-><init>(Lco/vine/android/util/ConversationMenuHelper;)V

    iput-object v0, p0, Lco/vine/android/util/ConversationMenuHelper;->mTapToStartFadeListener:Landroid/view/animation/Animation$AnimationListener;

    .line 348
    new-instance v0, Lco/vine/android/util/ConversationMenuHelper$4;

    invoke-direct {v0, p0}, Lco/vine/android/util/ConversationMenuHelper$4;-><init>(Lco/vine/android/util/ConversationMenuHelper;)V

    iput-object v0, p0, Lco/vine/android/util/ConversationMenuHelper;->mMessageSentFadeListener:Landroid/view/animation/Animation$AnimationListener;

    .line 83
    iput-object p1, p0, Lco/vine/android/util/ConversationMenuHelper;->mActivity:Lco/vine/android/BaseControllerActionBarActivity;

    .line 84
    new-instance v0, Lco/vine/android/util/ConversationMenuHelper$ConversationMenuHelperAppSessionListener;

    invoke-direct {v0, p0}, Lco/vine/android/util/ConversationMenuHelper$ConversationMenuHelperAppSessionListener;-><init>(Lco/vine/android/util/ConversationMenuHelper;)V

    iput-object v0, p0, Lco/vine/android/util/ConversationMenuHelper;->mAppSessionListener:Lco/vine/android/util/ConversationMenuHelper$ConversationMenuHelperAppSessionListener;

    .line 85
    return-void
.end method

.method static synthetic access$000(Lco/vine/android/util/ConversationMenuHelper;)Landroid/widget/TextView;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/util/ConversationMenuHelper;

    .prologue
    .line 47
    iget-object v0, p0, Lco/vine/android/util/ConversationMenuHelper;->mTapToStartText:Landroid/widget/TextView;

    return-object v0
.end method

.method static synthetic access$1000(Lco/vine/android/util/ConversationMenuHelper;)Lco/vine/android/FriendSearchAdapter;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/util/ConversationMenuHelper;

    .prologue
    .line 47
    iget-object v0, p0, Lco/vine/android/util/ConversationMenuHelper;->mFriendSearchAdapter:Lco/vine/android/FriendSearchAdapter;

    return-object v0
.end method

.method static synthetic access$1100(Lco/vine/android/util/ConversationMenuHelper;Ljava/util/ArrayList;)V
    .locals 0
    .param p0, "x0"    # Lco/vine/android/util/ConversationMenuHelper;
    .param p1, "x1"    # Ljava/util/ArrayList;

    .prologue
    .line 47
    invoke-direct {p0, p1}, Lco/vine/android/util/ConversationMenuHelper;->displaySearchResults(Ljava/util/ArrayList;)V

    return-void
.end method

.method static synthetic access$200(Lco/vine/android/util/ConversationMenuHelper;)Landroid/os/Handler;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/util/ConversationMenuHelper;

    .prologue
    .line 47
    iget-object v0, p0, Lco/vine/android/util/ConversationMenuHelper;->mHandler:Landroid/os/Handler;

    return-object v0
.end method

.method static synthetic access$300(Lco/vine/android/util/ConversationMenuHelper;)Lco/vine/android/BaseControllerActionBarActivity;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/util/ConversationMenuHelper;

    .prologue
    .line 47
    iget-object v0, p0, Lco/vine/android/util/ConversationMenuHelper;->mActivity:Lco/vine/android/BaseControllerActionBarActivity;

    return-object v0
.end method

.method static synthetic access$400(Lco/vine/android/util/ConversationMenuHelper;)Landroid/view/animation/Animation$AnimationListener;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/util/ConversationMenuHelper;

    .prologue
    .line 47
    iget-object v0, p0, Lco/vine/android/util/ConversationMenuHelper;->mMessageSentFadeListener:Landroid/view/animation/Animation$AnimationListener;

    return-object v0
.end method

.method static synthetic access$500(Lco/vine/android/util/ConversationMenuHelper;)Landroid/widget/TextView;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/util/ConversationMenuHelper;

    .prologue
    .line 47
    iget-object v0, p0, Lco/vine/android/util/ConversationMenuHelper;->mOnboardingOverlay:Landroid/widget/TextView;

    return-object v0
.end method

.method static synthetic access$600(Lco/vine/android/util/ConversationMenuHelper;)J
    .locals 2
    .param p0, "x0"    # Lco/vine/android/util/ConversationMenuHelper;

    .prologue
    .line 47
    iget-wide v0, p0, Lco/vine/android/util/ConversationMenuHelper;->mWaitingToStartUserId:J

    return-wide v0
.end method

.method static synthetic access$602(Lco/vine/android/util/ConversationMenuHelper;J)J
    .locals 0
    .param p0, "x0"    # Lco/vine/android/util/ConversationMenuHelper;
    .param p1, "x1"    # J

    .prologue
    .line 47
    iput-wide p1, p0, Lco/vine/android/util/ConversationMenuHelper;->mWaitingToStartUserId:J

    return-wide p1
.end method

.method static synthetic access$700(Lco/vine/android/util/ConversationMenuHelper;)J
    .locals 2
    .param p0, "x0"    # Lco/vine/android/util/ConversationMenuHelper;

    .prologue
    .line 47
    iget-wide v0, p0, Lco/vine/android/util/ConversationMenuHelper;->mWaitingToStartSearchUserId:J

    return-wide v0
.end method

.method static synthetic access$800(Lco/vine/android/util/ConversationMenuHelper;)Lco/vine/android/client/AppController;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/util/ConversationMenuHelper;

    .prologue
    .line 47
    iget-object v0, p0, Lco/vine/android/util/ConversationMenuHelper;->mAppController:Lco/vine/android/client/AppController;

    return-object v0
.end method

.method static synthetic access$900(Lco/vine/android/util/ConversationMenuHelper;)Z
    .locals 1
    .param p0, "x0"    # Lco/vine/android/util/ConversationMenuHelper;

    .prologue
    .line 47
    iget-boolean v0, p0, Lco/vine/android/util/ConversationMenuHelper;->mIsSearching:Z

    return v0
.end method

.method private displaySearchResults(Ljava/util/ArrayList;)V
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lco/vine/android/api/VineUser;",
            ">;)V"
        }
    .end annotation

    .prologue
    .local p1, "users":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineUser;>;"
    const/16 v2, 0x8

    const/4 v4, 0x0

    .line 240
    invoke-virtual {p1}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 241
    iget-object v1, p0, Lco/vine/android/util/ConversationMenuHelper;->mSearchResultView:Lcom/twitter/android/widget/RefreshableListView;

    invoke-virtual {v1, v2}, Lcom/twitter/android/widget/RefreshableListView;->setVisibility(I)V

    .line 242
    iget-object v1, p0, Lco/vine/android/util/ConversationMenuHelper;->mSadFace:Landroid/view/View;

    invoke-virtual {v1, v4}, Landroid/view/View;->setVisibility(I)V

    .line 243
    iget-object v1, p0, Lco/vine/android/util/ConversationMenuHelper;->mNothingFoundText:Landroid/view/View;

    invoke-virtual {v1, v4}, Landroid/view/View;->setVisibility(I)V

    .line 258
    :goto_0
    return-void

    .line 245
    :cond_0
    iget-object v1, p0, Lco/vine/android/util/ConversationMenuHelper;->mSadFace:Landroid/view/View;

    invoke-virtual {v1, v2}, Landroid/view/View;->setVisibility(I)V

    .line 246
    iget-object v1, p0, Lco/vine/android/util/ConversationMenuHelper;->mFriendSearchAdapter:Lco/vine/android/FriendSearchAdapter;

    if-nez v1, :cond_1

    .line 247
    new-instance v1, Lco/vine/android/FriendSearchAdapter;

    iget-object v2, p0, Lco/vine/android/util/ConversationMenuHelper;->mActivity:Lco/vine/android/BaseControllerActionBarActivity;

    iget-object v3, p0, Lco/vine/android/util/ConversationMenuHelper;->mAppController:Lco/vine/android/client/AppController;

    invoke-direct {v1, v2, v3, p1}, Lco/vine/android/FriendSearchAdapter;-><init>(Landroid/content/Context;Lco/vine/android/client/AppController;Ljava/util/List;)V

    iput-object v1, p0, Lco/vine/android/util/ConversationMenuHelper;->mFriendSearchAdapter:Lco/vine/android/FriendSearchAdapter;

    .line 249
    iget-object v1, p0, Lco/vine/android/util/ConversationMenuHelper;->mSearchResultView:Lcom/twitter/android/widget/RefreshableListView;

    iget-object v2, p0, Lco/vine/android/util/ConversationMenuHelper;->mFriendSearchAdapter:Lco/vine/android/FriendSearchAdapter;

    invoke-virtual {v1, v2}, Lcom/twitter/android/widget/RefreshableListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 256
    :goto_1
    iget-object v1, p0, Lco/vine/android/util/ConversationMenuHelper;->mSearchResultView:Lcom/twitter/android/widget/RefreshableListView;

    invoke-virtual {v1, v4}, Lcom/twitter/android/widget/RefreshableListView;->setVisibility(I)V

    goto :goto_0

    .line 251
    :cond_1
    iget-object v0, p0, Lco/vine/android/util/ConversationMenuHelper;->mFriendSearchAdapter:Lco/vine/android/FriendSearchAdapter;

    .line 252
    .local v0, "adapter":Lco/vine/android/FriendSearchAdapter;
    invoke-virtual {v0}, Lco/vine/android/FriendSearchAdapter;->clear()V

    .line 253
    invoke-virtual {v0, p1}, Lco/vine/android/FriendSearchAdapter;->setData(Ljava/util/List;)V

    .line 254
    invoke-virtual {v0}, Lco/vine/android/FriendSearchAdapter;->notifyDataSetChanged()V

    goto :goto_1
.end method


# virtual methods
.method public afterTextChanged(Landroid/text/Editable;)V
    .locals 0
    .param p1, "s"    # Landroid/text/Editable;

    .prologue
    .line 224
    return-void
.end method

.method public beforeTextChanged(Ljava/lang/CharSequence;III)V
    .locals 0
    .param p1, "s"    # Ljava/lang/CharSequence;
    .param p2, "start"    # I
    .param p3, "count"    # I
    .param p4, "after"    # I

    .prologue
    .line 189
    return-void
.end method

.method public getOthersText()Landroid/widget/TextView;
    .locals 1

    .prologue
    .line 139
    iget-object v0, p0, Lco/vine/android/util/ConversationMenuHelper;->mOthersText:Landroid/widget/TextView;

    return-object v0
.end method

.method public handleMessage(Landroid/os/Message;)Z
    .locals 2
    .param p1, "message"    # Landroid/os/Message;

    .prologue
    .line 193
    iget v0, p1, Landroid/os/Message;->what:I

    packed-switch v0, :pswitch_data_0

    .line 199
    :goto_0
    const/4 v0, 0x0

    return v0

    .line 195
    :pswitch_0
    iget-object v0, p0, Lco/vine/android/util/ConversationMenuHelper;->mAppController:Lco/vine/android/client/AppController;

    iget-object v1, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    invoke-static {v1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lco/vine/android/client/AppController;->fetchFriendsTypeAhead(Ljava/lang/String;)Ljava/lang/String;

    goto :goto_0

    .line 193
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
    .end packed-switch
.end method

.method public onClick(Landroid/view/View;)V
    .locals 6
    .param p1, "view"    # Landroid/view/View;

    .prologue
    const/4 v5, 0x0

    .line 144
    invoke-virtual {p1}, Landroid/view/View;->getId()I

    move-result v2

    packed-switch v2, :pswitch_data_0

    .line 169
    :goto_0
    :pswitch_0
    return-void

    .line 147
    :pswitch_1
    iget-object v2, p0, Lco/vine/android/util/ConversationMenuHelper;->mTapToStartText:Landroid/widget/TextView;

    if-eqz v2, :cond_0

    iget-object v2, p0, Lco/vine/android/util/ConversationMenuHelper;->mTapToStartText:Landroid/widget/TextView;

    invoke-virtual {v2}, Landroid/widget/TextView;->getVisibility()I

    move-result v2

    if-nez v2, :cond_0

    .line 148
    iget-object v2, p0, Lco/vine/android/util/ConversationMenuHelper;->mActivity:Lco/vine/android/BaseControllerActionBarActivity;

    const v3, 0x7f04000f

    invoke-static {v2, v3}, Landroid/view/animation/AnimationUtils;->loadAnimation(Landroid/content/Context;I)Landroid/view/animation/Animation;

    move-result-object v0

    .line 150
    .local v0, "fadeOut":Landroid/view/animation/Animation;
    iget-object v2, p0, Lco/vine/android/util/ConversationMenuHelper;->mTapToStartFadeListener:Landroid/view/animation/Animation$AnimationListener;

    invoke-virtual {v0, v2}, Landroid/view/animation/Animation;->setAnimationListener(Landroid/view/animation/Animation$AnimationListener;)V

    .line 151
    iget-object v2, p0, Lco/vine/android/util/ConversationMenuHelper;->mTapToStartText:Landroid/widget/TextView;

    invoke-virtual {v2, v0}, Landroid/widget/TextView;->startAnimation(Landroid/view/animation/Animation;)V

    .line 152
    const/4 v1, 0x1

    .line 156
    .end local v0    # "fadeOut":Landroid/view/animation/Animation;
    .local v1, "isVmOnboarding":Z
    :goto_1
    iget-object v2, p0, Lco/vine/android/util/ConversationMenuHelper;->mActivity:Lco/vine/android/BaseControllerActionBarActivity;

    iget-object v3, p0, Lco/vine/android/util/ConversationMenuHelper;->mActivity:Lco/vine/android/BaseControllerActionBarActivity;

    const-string v4, "New VM"

    invoke-static {v3, v5, v1, v4}, Lco/vine/android/AbstractRecordingActivity;->getIntentForMessaging(Landroid/content/Context;IZLjava/lang/String;)Landroid/content/Intent;

    move-result-object v3

    invoke-static {v2, v3, v5}, Lco/vine/android/util/Util;->startActionOnRecordingAvailable(Landroid/app/Activity;Landroid/content/Intent;I)V

    goto :goto_0

    .line 154
    .end local v1    # "isVmOnboarding":Z
    :cond_0
    const/4 v1, 0x0

    .restart local v1    # "isVmOnboarding":Z
    goto :goto_1

    .line 161
    .end local v1    # "isVmOnboarding":Z
    :pswitch_2
    const/4 v2, 0x1

    invoke-virtual {p0, v2}, Lco/vine/android/util/ConversationMenuHelper;->toggleContactSearch(Z)V

    goto :goto_0

    .line 165
    :pswitch_3
    invoke-virtual {p0, v5}, Lco/vine/android/util/ConversationMenuHelper;->toggleContactSearch(Z)V

    goto :goto_0

    .line 144
    :pswitch_data_0
    .packed-switch 0x7f0a00b6
        :pswitch_1
        :pswitch_2
        :pswitch_0
        :pswitch_3
    .end packed-switch
.end method

.method public onItemClick(Landroid/widget/AdapterView;Landroid/view/View;IJ)V
    .locals 4
    .param p2, "view"    # Landroid/view/View;
    .param p3, "position"    # I
    .param p4, "id"    # J
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/widget/AdapterView",
            "<*>;",
            "Landroid/view/View;",
            "IJ)V"
        }
    .end annotation

    .prologue
    .line 228
    .local p1, "parent":Landroid/widget/AdapterView;, "Landroid/widget/AdapterView<*>;"
    iget-object v2, p0, Lco/vine/android/util/ConversationMenuHelper;->mFriendSearchAdapter:Lco/vine/android/FriendSearchAdapter;

    invoke-virtual {v2, p3}, Lco/vine/android/FriendSearchAdapter;->getItemId(I)J

    move-result-wide v0

    .line 229
    .local v0, "userRemoteId":J
    iput-wide v0, p0, Lco/vine/android/util/ConversationMenuHelper;->mWaitingToStartSearchUserId:J

    .line 230
    const-wide/16 v2, 0x1

    cmp-long v2, v0, v2

    if-gez v2, :cond_0

    .line 231
    new-instance v2, Ljava/lang/IllegalStateException;

    const-string v3, "The userRemoteId of the clicked search result item is invalid"

    invoke-direct {v2, v3}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 236
    :cond_0
    iget-object v2, p0, Lco/vine/android/util/ConversationMenuHelper;->mAppController:Lco/vine/android/client/AppController;

    const/4 v3, 0x1

    invoke-virtual {v2, v0, v1, v3}, Lco/vine/android/client/AppController;->fetchConversationRowIdFromUserRemoteId(JI)V

    .line 237
    return-void
.end method

.method public onPause()V
    .locals 2

    .prologue
    .line 278
    iget-object v0, p0, Lco/vine/android/util/ConversationMenuHelper;->mAppController:Lco/vine/android/client/AppController;

    iget-object v1, p0, Lco/vine/android/util/ConversationMenuHelper;->mAppSessionListener:Lco/vine/android/util/ConversationMenuHelper$ConversationMenuHelperAppSessionListener;

    invoke-virtual {v0, v1}, Lco/vine/android/client/AppController;->removeListener(Lco/vine/android/client/AppSessionListener;)V

    .line 279
    return-void
.end method

.method public onResume()V
    .locals 3

    .prologue
    .line 282
    invoke-virtual {p0}, Lco/vine/android/util/ConversationMenuHelper;->getSlidingMenu()Lcom/jeremyfeinstein/slidingmenu/lib/SlidingMenu;

    move-result-object v0

    .line 283
    .local v0, "sm":Lcom/jeremyfeinstein/slidingmenu/lib/SlidingMenu;
    invoke-virtual {v0}, Lcom/jeremyfeinstein/slidingmenu/lib/SlidingMenu;->isMenuShowing()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 284
    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/jeremyfeinstein/slidingmenu/lib/SlidingMenu;->showContent(Z)V

    .line 286
    :cond_0
    iget-object v1, p0, Lco/vine/android/util/ConversationMenuHelper;->mAppController:Lco/vine/android/client/AppController;

    iget-object v2, p0, Lco/vine/android/util/ConversationMenuHelper;->mAppSessionListener:Lco/vine/android/util/ConversationMenuHelper$ConversationMenuHelperAppSessionListener;

    invoke-virtual {v1, v2}, Lco/vine/android/client/AppController;->addListener(Lco/vine/android/client/AppSessionListener;)V

    .line 287
    return-void
.end method

.method public onTextChanged(Ljava/lang/CharSequence;III)V
    .locals 7
    .param p1, "s"    # Ljava/lang/CharSequence;
    .param p2, "start"    # I
    .param p3, "before"    # I
    .param p4, "count"    # I

    .prologue
    const/16 v6, 0x8

    const/4 v4, 0x0

    const/4 v5, 0x1

    .line 204
    iget-object v2, p0, Lco/vine/android/util/ConversationMenuHelper;->mHandler:Landroid/os/Handler;

    invoke-virtual {v2, v5}, Landroid/os/Handler;->removeMessages(I)V

    .line 205
    invoke-interface {p1}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v1

    .line 206
    .local v1, "query":Ljava/lang/String;
    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_1

    invoke-interface {p1}, Ljava/lang/CharSequence;->length()I

    move-result v2

    const/4 v3, 0x2

    if-lt v2, v3, :cond_1

    .line 207
    const/4 v2, 0x0

    invoke-static {v2, v5, v1}, Landroid/os/Message;->obtain(Landroid/os/Handler;ILjava/lang/Object;)Landroid/os/Message;

    move-result-object v0

    .line 208
    .local v0, "msg":Landroid/os/Message;
    if-eqz v0, :cond_0

    .line 209
    invoke-virtual {p0, v5}, Lco/vine/android/util/ConversationMenuHelper;->showSearchProgressBar(Z)V

    .line 210
    iget-object v2, p0, Lco/vine/android/util/ConversationMenuHelper;->mHandler:Landroid/os/Handler;

    const-wide/16 v3, 0xc8

    invoke-virtual {v2, v0, v3, v4}, Landroid/os/Handler;->sendMessageDelayed(Landroid/os/Message;J)Z

    .line 211
    iput-boolean v5, p0, Lco/vine/android/util/ConversationMenuHelper;->mIsSearching:Z

    .line 219
    .end local v0    # "msg":Landroid/os/Message;
    :cond_0
    :goto_0
    return-void

    .line 213
    :cond_1
    iget-boolean v2, p0, Lco/vine/android/util/ConversationMenuHelper;->mIsSearching:Z

    if-eqz v2, :cond_0

    .line 214
    invoke-virtual {p0, v4}, Lco/vine/android/util/ConversationMenuHelper;->showSearchProgressBar(Z)V

    .line 215
    iget-object v2, p0, Lco/vine/android/util/ConversationMenuHelper;->mSearchResultView:Lcom/twitter/android/widget/RefreshableListView;

    invoke-virtual {v2, v6}, Lcom/twitter/android/widget/RefreshableListView;->setVisibility(I)V

    .line 216
    iget-object v2, p0, Lco/vine/android/util/ConversationMenuHelper;->mSadFace:Landroid/view/View;

    invoke-virtual {v2, v6}, Landroid/view/View;->setVisibility(I)V

    .line 217
    iput-boolean v4, p0, Lco/vine/android/util/ConversationMenuHelper;->mIsSearching:Z

    goto :goto_0
.end method

.method public setPersonalizedColor(I)V
    .locals 3
    .param p1, "profileBackground"    # I

    .prologue
    .line 290
    sget v0, Lco/vine/android/Settings;->DEFAULT_PROFILE_COLOR:I

    if-eq p1, v0, :cond_0

    if-gtz p1, :cond_1

    .line 291
    :cond_0
    const v0, 0xffffff

    iget-object v1, p0, Lco/vine/android/util/ConversationMenuHelper;->mActivity:Lco/vine/android/BaseControllerActionBarActivity;

    invoke-virtual {v1}, Lco/vine/android/BaseControllerActionBarActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f090096

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getColor(I)I

    move-result v1

    and-int p1, v0, v1

    .line 293
    :cond_1
    const/high16 v0, -0x1000000

    or-int/2addr v0, p1

    iput v0, p0, Lco/vine/android/util/ConversationMenuHelper;->mProfileColor:I

    .line 294
    iget-object v0, p0, Lco/vine/android/util/ConversationMenuHelper;->mActionContainer:Landroid/view/ViewGroup;

    iget v1, p0, Lco/vine/android/util/ConversationMenuHelper;->mProfileColor:I

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->setBackgroundColor(I)V

    .line 295
    iget-object v0, p0, Lco/vine/android/util/ConversationMenuHelper;->mInboxFragment:Lco/vine/android/InboxFragment;

    if-eqz v0, :cond_2

    .line 296
    iget-object v0, p0, Lco/vine/android/util/ConversationMenuHelper;->mInboxFragment:Lco/vine/android/InboxFragment;

    invoke-virtual {v0, p1}, Lco/vine/android/InboxFragment;->setPersonalizedColor(I)V

    .line 298
    :cond_2
    return-void
.end method

.method public setupConversationSlidingMenu()V
    .locals 9

    .prologue
    const v8, 0x7f0a00bd

    const/4 v7, 0x1

    .line 88
    iget-object v5, p0, Lco/vine/android/util/ConversationMenuHelper;->mActivity:Lco/vine/android/BaseControllerActionBarActivity;

    invoke-static {v5}, Lco/vine/android/client/AppController;->getInstance(Landroid/content/Context;)Lco/vine/android/client/AppController;

    move-result-object v5

    iput-object v5, p0, Lco/vine/android/util/ConversationMenuHelper;->mAppController:Lco/vine/android/client/AppController;

    .line 89
    iget-object v5, p0, Lco/vine/android/util/ConversationMenuHelper;->mActivity:Lco/vine/android/BaseControllerActionBarActivity;

    const v6, 0x7f03002f

    invoke-virtual {v5, v6}, Lco/vine/android/BaseControllerActionBarActivity;->setBehindContentView(I)Landroid/view/View;

    move-result-object v4

    .line 90
    .local v4, "view":Landroid/view/View;
    const v5, 0x7f0a00bb

    invoke-virtual {v4, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/EditText;

    iput-object v5, p0, Lco/vine/android/util/ConversationMenuHelper;->mSearchField:Landroid/widget/EditText;

    .line 91
    iget-object v5, p0, Lco/vine/android/util/ConversationMenuHelper;->mSearchField:Landroid/widget/EditText;

    invoke-virtual {v5, p0}, Landroid/widget/EditText;->addTextChangedListener(Landroid/text/TextWatcher;)V

    .line 92
    const v5, 0x7f0a00b4

    invoke-virtual {v4, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/view/ViewGroup;

    iput-object v5, p0, Lco/vine/android/util/ConversationMenuHelper;->mActionContainer:Landroid/view/ViewGroup;

    .line 93
    iget-object v5, p0, Lco/vine/android/util/ConversationMenuHelper;->mActivity:Lco/vine/android/BaseControllerActionBarActivity;

    invoke-static {v5}, Lco/vine/android/util/Util;->getProfileColor(Landroid/content/Context;)I

    move-result v5

    invoke-virtual {p0, v5}, Lco/vine/android/util/ConversationMenuHelper;->setPersonalizedColor(I)V

    .line 94
    const v5, 0x7f0a00b8

    invoke-virtual {v4, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/view/ViewGroup;

    iput-object v5, p0, Lco/vine/android/util/ConversationMenuHelper;->mSearchContainer:Landroid/view/ViewGroup;

    .line 95
    const v5, 0x7f0a00bf

    invoke-virtual {v4, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Lcom/twitter/android/widget/RefreshableListView;

    iput-object v5, p0, Lco/vine/android/util/ConversationMenuHelper;->mSearchResultView:Lcom/twitter/android/widget/RefreshableListView;

    .line 96
    iget-object v5, p0, Lco/vine/android/util/ConversationMenuHelper;->mSearchResultView:Lcom/twitter/android/widget/RefreshableListView;

    invoke-virtual {v5, p0}, Lcom/twitter/android/widget/RefreshableListView;->setOnItemClickListener(Landroid/widget/AdapterView$OnItemClickListener;)V

    .line 97
    const v5, 0x7f0a00be

    invoke-virtual {v4, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    iput-object v5, p0, Lco/vine/android/util/ConversationMenuHelper;->mSearchOnBackgroundView:Landroid/view/View;

    .line 98
    iget-object v5, p0, Lco/vine/android/util/ConversationMenuHelper;->mSearchOnBackgroundView:Landroid/view/View;

    new-instance v6, Lco/vine/android/util/ConversationMenuHelper$1;

    invoke-direct {v6, p0}, Lco/vine/android/util/ConversationMenuHelper$1;-><init>(Lco/vine/android/util/ConversationMenuHelper;)V

    invoke-virtual {v5, v6}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 104
    const v5, 0x7f0a00c0

    invoke-virtual {v4, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    iput-object v5, p0, Lco/vine/android/util/ConversationMenuHelper;->mSadFace:Landroid/view/View;

    .line 105
    const v5, 0x7f0a00c2

    invoke-virtual {v4, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    iput-object v5, p0, Lco/vine/android/util/ConversationMenuHelper;->mNothingFoundText:Landroid/view/View;

    .line 106
    const v5, 0x7f0a00bc

    invoke-virtual {v4, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/TextView;

    iput-object v5, p0, Lco/vine/android/util/ConversationMenuHelper;->mTapToStartText:Landroid/widget/TextView;

    .line 107
    const v5, 0x7f0a00b6

    invoke-virtual {v4, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    invoke-virtual {v5, p0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 108
    const v5, 0x7f0a00b7

    invoke-virtual {v4, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    invoke-virtual {v5, p0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 109
    const v5, 0x7f0a00b9

    invoke-virtual {v4, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    invoke-virtual {v5, p0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 110
    iget-object v5, p0, Lco/vine/android/util/ConversationMenuHelper;->mActivity:Lco/vine/android/BaseControllerActionBarActivity;

    const v6, 0x7f0a00b3

    invoke-virtual {v4, v6}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v6

    invoke-static {v5, v6}, Lco/vine/android/util/ViewUtil;->setActionBarHeight(Landroid/support/v7/app/ActionBarActivity;Landroid/view/View;)V

    .line 111
    const v5, 0x7f0a00ba

    invoke-virtual {v4, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/ProgressBar;

    iput-object v5, p0, Lco/vine/android/util/ConversationMenuHelper;->mSearchInProgress:Landroid/widget/ProgressBar;

    .line 112
    invoke-virtual {p0, v7}, Lco/vine/android/util/ConversationMenuHelper;->setSlidingActionBarEnabled(Z)V

    .line 113
    invoke-virtual {p0}, Lco/vine/android/util/ConversationMenuHelper;->getSlidingMenu()Lcom/jeremyfeinstein/slidingmenu/lib/SlidingMenu;

    move-result-object v3

    .line 114
    .local v3, "sm":Lcom/jeremyfeinstein/slidingmenu/lib/SlidingMenu;
    const/16 v5, 0x23

    invoke-virtual {v3, v5}, Lcom/jeremyfeinstein/slidingmenu/lib/SlidingMenu;->setShadowWidth(I)V

    .line 115
    iget-object v5, p0, Lco/vine/android/util/ConversationMenuHelper;->mActivity:Lco/vine/android/BaseControllerActionBarActivity;

    invoke-virtual {v5}, Lco/vine/android/BaseControllerActionBarActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v5

    const v6, 0x7f0b0071

    invoke-virtual {v5, v6}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v5

    invoke-virtual {v3, v5}, Lcom/jeremyfeinstein/slidingmenu/lib/SlidingMenu;->setBehindOffset(I)V

    .line 116
    invoke-virtual {v3, v7}, Lcom/jeremyfeinstein/slidingmenu/lib/SlidingMenu;->setTouchModeAbove(I)V

    .line 118
    iget-object v5, p0, Lco/vine/android/util/ConversationMenuHelper;->mActivity:Lco/vine/android/BaseControllerActionBarActivity;

    invoke-virtual {v5, v8}, Lco/vine/android/BaseControllerActionBarActivity;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Lco/vine/android/views/TouchableRelativeLayout;

    new-instance v6, Lco/vine/android/util/ViewBehindTouchListener;

    iget-object v7, p0, Lco/vine/android/util/ConversationMenuHelper;->mActivity:Lco/vine/android/BaseControllerActionBarActivity;

    invoke-direct {v6, v7, v3}, Lco/vine/android/util/ViewBehindTouchListener;-><init>(Landroid/content/Context;Lcom/jeremyfeinstein/slidingmenu/lib/SlidingMenu;)V

    invoke-virtual {v5, v6}, Lco/vine/android/views/TouchableRelativeLayout;->setTouchListener(Lco/vine/android/views/TouchableRelativeLayout$TouchListener;)V

    .line 120
    iget-object v5, p0, Lco/vine/android/util/ConversationMenuHelper;->mActivity:Lco/vine/android/BaseControllerActionBarActivity;

    invoke-virtual {v5}, Lco/vine/android/BaseControllerActionBarActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    .line 122
    .local v0, "fm":Landroid/support/v4/app/FragmentManager;
    const-string v5, "Inbox"

    invoke-virtual {v0, v5}, Landroid/support/v4/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroid/support/v4/app/Fragment;

    move-result-object v1

    .line 124
    .local v1, "frag":Landroid/support/v4/app/Fragment;
    if-nez v1, :cond_0

    .line 125
    new-instance v5, Lco/vine/android/InboxFragment;

    invoke-direct {v5}, Lco/vine/android/InboxFragment;-><init>()V

    iput-object v5, p0, Lco/vine/android/util/ConversationMenuHelper;->mInboxFragment:Lco/vine/android/InboxFragment;

    .line 126
    invoke-virtual {v0}, Landroid/support/v4/app/FragmentManager;->beginTransaction()Landroid/support/v4/app/FragmentTransaction;

    move-result-object v2

    .line 127
    .local v2, "ft":Landroid/support/v4/app/FragmentTransaction;
    iget-object v5, p0, Lco/vine/android/util/ConversationMenuHelper;->mInboxFragment:Lco/vine/android/InboxFragment;

    const-string v6, "Inbox"

    invoke-virtual {v2, v8, v5, v6}, Landroid/support/v4/app/FragmentTransaction;->add(ILandroid/support/v4/app/Fragment;Ljava/lang/String;)Landroid/support/v4/app/FragmentTransaction;

    .line 128
    invoke-virtual {v2}, Landroid/support/v4/app/FragmentTransaction;->commit()I

    .line 132
    .end local v1    # "frag":Landroid/support/v4/app/Fragment;
    .end local v2    # "ft":Landroid/support/v4/app/FragmentTransaction;
    :goto_0
    iget-object v5, p0, Lco/vine/android/util/ConversationMenuHelper;->mInboxFragment:Lco/vine/android/InboxFragment;

    invoke-virtual {v3, v5}, Lcom/jeremyfeinstein/slidingmenu/lib/SlidingMenu;->setOnClosedListener(Lcom/jeremyfeinstein/slidingmenu/lib/SlidingMenu$OnClosedListener;)V

    .line 133
    iget-object v5, p0, Lco/vine/android/util/ConversationMenuHelper;->mInboxFragment:Lco/vine/android/InboxFragment;

    invoke-virtual {v3, v5}, Lcom/jeremyfeinstein/slidingmenu/lib/SlidingMenu;->setOnOpenedListener(Lcom/jeremyfeinstein/slidingmenu/lib/SlidingMenu$OnOpenedListener;)V

    .line 135
    new-instance v5, Landroid/os/Handler;

    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object v6

    invoke-direct {v5, v6, p0}, Landroid/os/Handler;-><init>(Landroid/os/Looper;Landroid/os/Handler$Callback;)V

    iput-object v5, p0, Lco/vine/android/util/ConversationMenuHelper;->mHandler:Landroid/os/Handler;

    .line 136
    return-void

    .line 130
    .restart local v1    # "frag":Landroid/support/v4/app/Fragment;
    :cond_0
    check-cast v1, Lco/vine/android/InboxFragment;

    .end local v1    # "frag":Landroid/support/v4/app/Fragment;
    iput-object v1, p0, Lco/vine/android/util/ConversationMenuHelper;->mInboxFragment:Lco/vine/android/InboxFragment;

    goto :goto_0
.end method

.method public showSearchProgressBar(Z)V
    .locals 2
    .param p1, "show"    # Z

    .prologue
    .line 261
    iget-object v1, p0, Lco/vine/android/util/ConversationMenuHelper;->mSearchInProgress:Landroid/widget/ProgressBar;

    if-eqz p1, :cond_0

    const/4 v0, 0x0

    :goto_0
    invoke-virtual {v1, v0}, Landroid/widget/ProgressBar;->setVisibility(I)V

    .line 262
    return-void

    .line 261
    :cond_0
    const/16 v0, 0x8

    goto :goto_0
.end method

.method public showVmOnboarding()V
    .locals 2

    .prologue
    .line 301
    iget-object v0, p0, Lco/vine/android/util/ConversationMenuHelper;->mTapToStartText:Landroid/widget/TextView;

    invoke-virtual {v0}, Landroid/widget/TextView;->bringToFront()V

    .line 302
    iget-object v0, p0, Lco/vine/android/util/ConversationMenuHelper;->mTapToStartText:Landroid/widget/TextView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    .line 303
    return-void
.end method

.method public showVmOnboardingAfterSend()V
    .locals 8

    .prologue
    const/4 v6, 0x0

    const/4 v7, -0x1

    .line 306
    invoke-virtual {p0}, Lco/vine/android/util/ConversationMenuHelper;->getSlidingMenu()Lcom/jeremyfeinstein/slidingmenu/lib/SlidingMenu;

    move-result-object v4

    invoke-virtual {v4}, Lcom/jeremyfeinstein/slidingmenu/lib/SlidingMenu;->getMenu()Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    .line 307
    .local v0, "behind":Landroid/widget/RelativeLayout;
    iget-object v4, p0, Lco/vine/android/util/ConversationMenuHelper;->mActivity:Lco/vine/android/BaseControllerActionBarActivity;

    invoke-virtual {v4}, Lco/vine/android/BaseControllerActionBarActivity;->getLayoutInflater()Landroid/view/LayoutInflater;

    move-result-object v4

    const v5, 0x7f030067

    invoke-virtual {v4, v5, v0, v6}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/TextView;

    .line 309
    .local v2, "onboardingOverlay":Landroid/widget/TextView;
    invoke-virtual {v2, v6}, Landroid/widget/TextView;->setVisibility(I)V

    .line 310
    const v4, 0x7f0e0281

    invoke-virtual {v2, v4}, Landroid/widget/TextView;->setText(I)V

    .line 312
    new-instance v1, Lco/vine/android/util/ConversationMenuHelper$OnboardingOverlayFadeOutRunnable;

    const/4 v4, 0x0

    invoke-direct {v1, p0, v4}, Lco/vine/android/util/ConversationMenuHelper$OnboardingOverlayFadeOutRunnable;-><init>(Lco/vine/android/util/ConversationMenuHelper;Lco/vine/android/util/ConversationMenuHelper$1;)V

    .line 313
    .local v1, "fadeOut":Lco/vine/android/util/ConversationMenuHelper$OnboardingOverlayFadeOutRunnable;
    invoke-virtual {v1, v2}, Lco/vine/android/util/ConversationMenuHelper$OnboardingOverlayFadeOutRunnable;->setView(Landroid/view/View;)V

    .line 314
    iget-object v4, p0, Lco/vine/android/util/ConversationMenuHelper;->mHandler:Landroid/os/Handler;

    const-wide/16 v5, 0x2710

    invoke-virtual {v4, v1, v5, v6}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 316
    new-instance v4, Lco/vine/android/util/ConversationMenuHelper$3;

    invoke-direct {v4, p0, v1}, Lco/vine/android/util/ConversationMenuHelper$3;-><init>(Lco/vine/android/util/ConversationMenuHelper;Lco/vine/android/util/ConversationMenuHelper$OnboardingOverlayFadeOutRunnable;)V

    invoke-virtual {v2, v4}, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 324
    new-instance v3, Landroid/widget/RelativeLayout$LayoutParams;

    const/4 v4, -0x2

    invoke-direct {v3, v7, v4}, Landroid/widget/RelativeLayout$LayoutParams;-><init>(II)V

    .line 326
    .local v3, "params":Landroid/widget/RelativeLayout$LayoutParams;
    const/16 v4, 0xc

    invoke-virtual {v3, v4, v7}, Landroid/widget/RelativeLayout$LayoutParams;->addRule(II)V

    .line 327
    invoke-virtual {v0, v2, v3}, Landroid/widget/RelativeLayout;->addView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V

    .line 328
    iput-object v2, p0, Lco/vine/android/util/ConversationMenuHelper;->mOnboardingOverlay:Landroid/widget/TextView;

    .line 329
    return-void
.end method

.method public toggleContactSearch(Z)V
    .locals 4
    .param p1, "show"    # Z

    .prologue
    const/4 v2, 0x4

    const/4 v1, 0x0

    .line 265
    iget-object v3, p0, Lco/vine/android/util/ConversationMenuHelper;->mSearchOnBackgroundView:Landroid/view/View;

    if-eqz p1, :cond_0

    move v0, v1

    :goto_0
    invoke-virtual {v3, v0}, Landroid/view/View;->setVisibility(I)V

    .line 266
    iget-object v3, p0, Lco/vine/android/util/ConversationMenuHelper;->mSearchContainer:Landroid/view/ViewGroup;

    if-eqz p1, :cond_1

    move v0, v1

    :goto_1
    invoke-virtual {v3, v0}, Landroid/view/ViewGroup;->setVisibility(I)V

    .line 267
    iget-object v0, p0, Lco/vine/android/util/ConversationMenuHelper;->mActionContainer:Landroid/view/ViewGroup;

    if-eqz p1, :cond_2

    :goto_2
    invoke-virtual {v0, v2}, Landroid/view/ViewGroup;->setVisibility(I)V

    .line 268
    if-eqz p1, :cond_3

    .line 269
    iget-object v0, p0, Lco/vine/android/util/ConversationMenuHelper;->mSearchField:Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->requestFocus()Z

    .line 274
    :goto_3
    iget-object v0, p0, Lco/vine/android/util/ConversationMenuHelper;->mActivity:Lco/vine/android/BaseControllerActionBarActivity;

    iget-object v1, p0, Lco/vine/android/util/ConversationMenuHelper;->mSearchField:Landroid/widget/EditText;

    invoke-static {v0, v1, p1}, Lco/vine/android/util/Util;->setSoftKeyboardVisibility(Landroid/content/Context;Landroid/view/View;Z)V

    .line 275
    return-void

    :cond_0
    move v0, v2

    .line 265
    goto :goto_0

    :cond_1
    move v0, v2

    .line 266
    goto :goto_1

    :cond_2
    move v2, v1

    .line 267
    goto :goto_2

    .line 271
    :cond_3
    iget-object v0, p0, Lco/vine/android/util/ConversationMenuHelper;->mSearchField:Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->clearFocus()V

    .line 272
    iget-object v0, p0, Lco/vine/android/util/ConversationMenuHelper;->mSearchField:Landroid/widget/EditText;

    const-string v1, ""

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    goto :goto_3
.end method

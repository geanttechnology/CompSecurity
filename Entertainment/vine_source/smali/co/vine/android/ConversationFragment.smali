.class public Lco/vine/android/ConversationFragment;
.super Lco/vine/android/BaseCursorListFragment;
.source "ConversationFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;
.implements Landroid/text/TextWatcher;
.implements Landroid/widget/TextView$OnEditorActionListener;
.implements Lco/vine/android/widget/TypefacesEditText$KeyboardListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lco/vine/android/ConversationFragment$ConversationSessionListener;,
        Lco/vine/android/ConversationFragment$HeightAnimation;,
        Lco/vine/android/ConversationFragment$UploadProgressHandler;
    }
.end annotation


# static fields
.field public static final ARG_AM_FOLLOWING:Ljava/lang/String; = "am_following_recipient"

.field public static final ARG_CONVERSATION_ROW_ID:Ljava/lang/String; = "conversation_row_id"

.field public static final ARG_ENCODER_VERSION:Ljava/lang/String; = "arg_encoder_version"

.field private static final COLLAPSE_DURATION_MS:J = 0x12cL

.field private static final MAX_CHARS:I = 0x1a4

.field public static final REQUEST_POST_OPTIONS:I = 0x2

.field public static final REQUEST_RECORD_REPLY:I = 0x7c7

.field private static final SCROLL_TO_BOTTOM_MESSAGE_COUNT_THRESHOLD:I = 0x1

.field private static final STATE_FETCHED:Ljava/lang/String; = "fetched"

.field private static final TAG:Ljava/lang/String; = "ConversationFrag"


# instance fields
.field private mAmFollowing:Z

.field private mBound:Z

.field private mCallback:Lco/vine/android/ConversationActivity;

.field private mChatPresenceContainer:Landroid/view/ViewGroup;

.field private mChatPresenceEllipsis:Landroid/widget/ImageView;

.field private mChatPresenceFooter:Landroid/view/ViewGroup;

.field private mColorMap:Landroid/support/v4/util/LongSparseArray;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/support/v4/util/LongSparseArray",
            "<",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation
.end field

.field private mComposeContainer:Landroid/view/View;

.field private mConnection:Landroid/content/ServiceConnection;

.field private mContentResolver:Landroid/content/ContentResolver;

.field private mConversationAdapter:Lco/vine/android/ConversationAdapter;

.field private mConversationId:J

.field private mConversationRowId:J

.field private mEdit:Lco/vine/android/widget/TypefacesEditText;

.field private mFetchWasInitial:Z

.field private mFetchWasLoadMore:Z

.field private mFetched:Z

.field private mFullRecordIntent:Landroid/content/Intent;

.field private mIncomingHandler:Landroid/os/Handler;

.field private mIsSending:Z

.field private mLastTopItemId:J

.field private mLastTopItemPixelOffset:I

.field private final mLaunchFullRecordRunnable:Ljava/lang/Runnable;

.field private final mLaunchRecorderListener:Landroid/view/View$OnClickListener;

.field private mLoadMoreHeaderContent:Landroid/view/View;

.field private mLoadMoreProgress:Landroid/view/View;

.field private mLocalUnreadCount:I

.field private final mMuteChangeReceiver:Landroid/content/BroadcastReceiver;

.field private mMyColor:I

.field private mMyUserRowId:J

.field private mNewMessageBarContainer:Landroid/view/View;

.field private mNewMessageBarText:Landroid/widget/TextView;

.field private mProgressView:Lco/vine/android/recorder/ProgressView;

.field private mProgressViewWidth:I

.field private mRecipientColor:I

.field private mRecipientUsername:Ljava/lang/String;

.field private mRecordButton:Landroid/widget/ImageView;

.field private mRecorderManager:Lco/vine/android/InlineRecorderManager;

.field private mRecordingEnabled:Z

.field private mSendButton:Landroid/widget/ImageView;

.field private mTextInputContainer:Landroid/widget/RelativeLayout;

.field private mTextInputToggle:Landroid/view/View;

.field private mUploadProgressContainer:Landroid/view/ViewGroup;

.field private mUploadServiceMessenger:Landroid/os/Messenger;

.field private mUploadThumbnail:Landroid/widget/ImageView;

.field private mVersion:Lco/vine/android/recorder/RecordSessionVersion;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 83
    invoke-direct {p0}, Lco/vine/android/BaseCursorListFragment;-><init>()V

    .line 108
    iput-boolean v0, p0, Lco/vine/android/ConversationFragment;->mFetched:Z

    .line 109
    iput-boolean v0, p0, Lco/vine/android/ConversationFragment;->mFetchWasLoadMore:Z

    .line 119
    iput v0, p0, Lco/vine/android/ConversationFragment;->mProgressViewWidth:I

    .line 134
    iput v0, p0, Lco/vine/android/ConversationFragment;->mMyColor:I

    .line 135
    iput v0, p0, Lco/vine/android/ConversationFragment;->mRecipientColor:I

    .line 149
    iput-boolean v0, p0, Lco/vine/android/ConversationFragment;->mFetchWasInitial:Z

    .line 150
    new-instance v0, Lco/vine/android/ConversationFragment$1;

    invoke-direct {v0, p0}, Lco/vine/android/ConversationFragment$1;-><init>(Lco/vine/android/ConversationFragment;)V

    iput-object v0, p0, Lco/vine/android/ConversationFragment;->mMuteChangeReceiver:Landroid/content/BroadcastReceiver;

    .line 740
    new-instance v0, Lco/vine/android/ConversationFragment$6;

    invoke-direct {v0, p0}, Lco/vine/android/ConversationFragment$6;-><init>(Lco/vine/android/ConversationFragment;)V

    iput-object v0, p0, Lco/vine/android/ConversationFragment;->mLaunchRecorderListener:Landroid/view/View$OnClickListener;

    .line 997
    new-instance v0, Lco/vine/android/ConversationFragment$7;

    invoke-direct {v0, p0}, Lco/vine/android/ConversationFragment$7;-><init>(Lco/vine/android/ConversationFragment;)V

    iput-object v0, p0, Lco/vine/android/ConversationFragment;->mLaunchFullRecordRunnable:Ljava/lang/Runnable;

    .line 1004
    return-void
.end method

.method static synthetic access$1000(Lco/vine/android/ConversationFragment;)Landroid/widget/ImageView;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/ConversationFragment;

    .prologue
    .line 83
    iget-object v0, p0, Lco/vine/android/ConversationFragment;->mUploadThumbnail:Landroid/widget/ImageView;

    return-object v0
.end method

.method static synthetic access$102(Lco/vine/android/ConversationFragment;Landroid/os/Messenger;)Landroid/os/Messenger;
    .locals 0
    .param p0, "x0"    # Lco/vine/android/ConversationFragment;
    .param p1, "x1"    # Landroid/os/Messenger;

    .prologue
    .line 83
    iput-object p1, p0, Lco/vine/android/ConversationFragment;->mUploadServiceMessenger:Landroid/os/Messenger;

    return-object p1
.end method

.method static synthetic access$1100(Lco/vine/android/ConversationFragment;)I
    .locals 1
    .param p0, "x0"    # Lco/vine/android/ConversationFragment;

    .prologue
    .line 83
    iget v0, p0, Lco/vine/android/ConversationFragment;->mProgressViewWidth:I

    return v0
.end method

.method static synthetic access$1102(Lco/vine/android/ConversationFragment;I)I
    .locals 0
    .param p0, "x0"    # Lco/vine/android/ConversationFragment;
    .param p1, "x1"    # I

    .prologue
    .line 83
    iput p1, p0, Lco/vine/android/ConversationFragment;->mProgressViewWidth:I

    return p1
.end method

.method static synthetic access$1200(Lco/vine/android/ConversationFragment;)Landroid/content/Intent;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/ConversationFragment;

    .prologue
    .line 83
    iget-object v0, p0, Lco/vine/android/ConversationFragment;->mFullRecordIntent:Landroid/content/Intent;

    return-object v0
.end method

.method static synthetic access$1300(Lco/vine/android/ConversationFragment;)Z
    .locals 1
    .param p0, "x0"    # Lco/vine/android/ConversationFragment;

    .prologue
    .line 83
    iget-boolean v0, p0, Lco/vine/android/ConversationFragment;->mFetched:Z

    return v0
.end method

.method static synthetic access$1400(Lco/vine/android/ConversationFragment;)Landroid/view/View;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/ConversationFragment;

    .prologue
    .line 83
    iget-object v0, p0, Lco/vine/android/ConversationFragment;->mLoadMoreHeaderContent:Landroid/view/View;

    return-object v0
.end method

.method static synthetic access$1502(Lco/vine/android/ConversationFragment;J)J
    .locals 0
    .param p0, "x0"    # Lco/vine/android/ConversationFragment;
    .param p1, "x1"    # J

    .prologue
    .line 83
    iput-wide p1, p0, Lco/vine/android/ConversationFragment;->mConversationId:J

    return-wide p1
.end method

.method static synthetic access$202(Lco/vine/android/ConversationFragment;Z)Z
    .locals 0
    .param p0, "x0"    # Lco/vine/android/ConversationFragment;
    .param p1, "x1"    # Z

    .prologue
    .line 83
    iput-boolean p1, p0, Lco/vine/android/ConversationFragment;->mBound:Z

    return p1
.end method

.method static synthetic access$300(Lco/vine/android/ConversationFragment;)Landroid/os/Handler;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/ConversationFragment;

    .prologue
    .line 83
    iget-object v0, p0, Lco/vine/android/ConversationFragment;->mIncomingHandler:Landroid/os/Handler;

    return-object v0
.end method

.method static synthetic access$400(Lco/vine/android/ConversationFragment;Landroid/os/Handler;)V
    .locals 0
    .param p0, "x0"    # Lco/vine/android/ConversationFragment;
    .param p1, "x1"    # Landroid/os/Handler;

    .prologue
    .line 83
    invoke-direct {p0, p1}, Lco/vine/android/ConversationFragment;->subscribe(Landroid/os/Handler;)V

    return-void
.end method

.method static synthetic access$600(Lco/vine/android/ConversationFragment;)V
    .locals 0
    .param p0, "x0"    # Lco/vine/android/ConversationFragment;

    .prologue
    .line 83
    invoke-direct {p0}, Lco/vine/android/ConversationFragment;->toggleInput()V

    return-void
.end method

.method static synthetic access$700(Lco/vine/android/ConversationFragment;)J
    .locals 2
    .param p0, "x0"    # Lco/vine/android/ConversationFragment;

    .prologue
    .line 83
    iget-wide v0, p0, Lco/vine/android/ConversationFragment;->mConversationRowId:J

    return-wide v0
.end method

.method static synthetic access$800(Lco/vine/android/ConversationFragment;)Landroid/view/ViewGroup;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/ConversationFragment;

    .prologue
    .line 83
    iget-object v0, p0, Lco/vine/android/ConversationFragment;->mUploadProgressContainer:Landroid/view/ViewGroup;

    return-object v0
.end method

.method static synthetic access$900(Lco/vine/android/ConversationFragment;)Lco/vine/android/recorder/ProgressView;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/ConversationFragment;

    .prologue
    .line 83
    iget-object v0, p0, Lco/vine/android/ConversationFragment;->mProgressView:Lco/vine/android/recorder/ProgressView;

    return-object v0
.end method

.method static synthetic access$902(Lco/vine/android/ConversationFragment;Lco/vine/android/recorder/ProgressView;)Lco/vine/android/recorder/ProgressView;
    .locals 0
    .param p0, "x0"    # Lco/vine/android/ConversationFragment;
    .param p1, "x1"    # Lco/vine/android/recorder/ProgressView;

    .prologue
    .line 83
    iput-object p1, p0, Lco/vine/android/ConversationFragment;->mProgressView:Lco/vine/android/recorder/ProgressView;

    return-object p1
.end method

.method private fetchContent(I)V
    .locals 13
    .param p1, "fetchType"    # I

    .prologue
    const/4 v6, 0x3

    const-wide/16 v3, 0x0

    const/4 v2, 0x0

    const/4 v1, 0x1

    .line 637
    iget-wide v7, p0, Lco/vine/android/ConversationFragment;->mConversationRowId:J

    cmp-long v0, v7, v3

    if-lez v0, :cond_0

    .line 638
    invoke-virtual {p0}, Lco/vine/android/ConversationFragment;->hasPendingRequest()Z

    move-result v0

    if-nez v0, :cond_0

    .line 639
    packed-switch p1, :pswitch_data_0

    .line 655
    :cond_0
    :goto_0
    :pswitch_0
    return-void

    .line 641
    :pswitch_1
    iput-boolean v1, p0, Lco/vine/android/ConversationFragment;->mFetched:Z

    .line 642
    invoke-virtual {p0, v6}, Lco/vine/android/ConversationFragment;->showProgress(I)V

    .line 643
    iget-object v0, p0, Lco/vine/android/ConversationFragment;->mAppController:Lco/vine/android/client/AppController;

    iget-wide v5, p0, Lco/vine/android/ConversationFragment;->mConversationRowId:J

    move v7, v2

    invoke-virtual/range {v0 .. v7}, Lco/vine/android/client/AppController;->fetchConversation(IZJJZ)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lco/vine/android/ConversationFragment;->addRequest(Ljava/lang/String;)Ljava/lang/String;

    goto :goto_0

    .line 647
    :pswitch_2
    iput-boolean v1, p0, Lco/vine/android/ConversationFragment;->mFetchWasLoadMore:Z

    .line 648
    invoke-virtual {p0, v1}, Lco/vine/android/ConversationFragment;->showProgress(I)V

    .line 649
    iget-object v5, p0, Lco/vine/android/ConversationFragment;->mAppController:Lco/vine/android/client/AppController;

    iget-wide v10, p0, Lco/vine/android/ConversationFragment;->mConversationRowId:J

    move v7, v1

    move-wide v8, v3

    move v12, v2

    invoke-virtual/range {v5 .. v12}, Lco/vine/android/client/AppController;->fetchConversation(IZJJZ)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lco/vine/android/ConversationFragment;->addRequest(Ljava/lang/String;)Ljava/lang/String;

    goto :goto_0

    .line 639
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_2
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method private getMessageBundle()Landroid/os/Bundle;
    .locals 4

    .prologue
    .line 760
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 761
    .local v0, "extras":Landroid/os/Bundle;
    const-string v1, "conversation_row_id"

    iget-wide v2, p0, Lco/vine/android/ConversationFragment;->mConversationRowId:J

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Bundle;->putLong(Ljava/lang/String;J)V

    .line 762
    return-object v0
.end method

.method private hideTypingContainer()V
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 910
    iget-object v0, p0, Lco/vine/android/ConversationFragment;->mEdit:Lco/vine/android/widget/TypefacesEditText;

    invoke-virtual {v0}, Lco/vine/android/widget/TypefacesEditText;->clearFocus()V

    .line 911
    iget v0, p0, Lco/vine/android/ConversationFragment;->mLocalUnreadCount:I

    if-lez v0, :cond_0

    .line 912
    const/4 v0, 0x1

    invoke-direct {p0, v0}, Lco/vine/android/ConversationFragment;->toggleNewMessageBar(Z)V

    .line 914
    :cond_0
    iget-object v0, p0, Lco/vine/android/ConversationFragment;->mTextInputContainer:Landroid/widget/RelativeLayout;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 915
    iget-object v0, p0, Lco/vine/android/ConversationFragment;->mComposeContainer:Landroid/view/View;

    new-instance v1, Landroid/graphics/drawable/ColorDrawable;

    invoke-virtual {p0}, Lco/vine/android/ConversationFragment;->getMyColor()I

    move-result v2

    invoke-direct {v1, v2}, Landroid/graphics/drawable/ColorDrawable;-><init>(I)V

    invoke-static {v0, v1}, Lco/vine/android/util/ViewUtil;->setBackground(Landroid/view/View;Landroid/graphics/drawable/Drawable;)V

    .line 917
    iget-object v0, p0, Lco/vine/android/ConversationFragment;->mRecordButton:Landroid/widget/ImageView;

    invoke-virtual {v0, v3}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 918
    iget-object v0, p0, Lco/vine/android/ConversationFragment;->mTextInputToggle:Landroid/view/View;

    invoke-virtual {v0, v3}, Landroid/view/View;->setVisibility(I)V

    .line 919
    return-void
.end method

.method private saveTopItemInfo()V
    .locals 4

    .prologue
    .line 878
    iget-object v1, p0, Lco/vine/android/ConversationFragment;->mCursorAdapter:Landroid/support/v4/widget/CursorAdapter;

    invoke-virtual {v1}, Landroid/support/v4/widget/CursorAdapter;->getCount()I

    move-result v1

    if-nez v1, :cond_1

    .line 886
    :cond_0
    :goto_0
    return-void

    .line 881
    :cond_1
    iget-object v1, p0, Lco/vine/android/ConversationFragment;->mCursorAdapter:Landroid/support/v4/widget/CursorAdapter;

    iget-object v2, p0, Lco/vine/android/ConversationFragment;->mListView:Landroid/widget/ListView;

    invoke-virtual {v2}, Landroid/widget/ListView;->getFirstVisiblePosition()I

    move-result v2

    invoke-virtual {v1, v2}, Landroid/support/v4/widget/CursorAdapter;->getItemId(I)J

    move-result-wide v1

    iput-wide v1, p0, Lco/vine/android/ConversationFragment;->mLastTopItemId:J

    .line 882
    iget-object v1, p0, Lco/vine/android/ConversationFragment;->mListView:Landroid/widget/ListView;

    iget-object v2, p0, Lco/vine/android/ConversationFragment;->mListView:Landroid/widget/ListView;

    invoke-virtual {v2}, Landroid/widget/ListView;->getFirstVisiblePosition()I

    move-result v2

    iget-object v3, p0, Lco/vine/android/ConversationFragment;->mListView:Landroid/widget/ListView;

    invoke-virtual {v3}, Landroid/widget/ListView;->getHeaderViewsCount()I

    move-result v3

    add-int/2addr v2, v3

    invoke-virtual {v1, v2}, Landroid/widget/ListView;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    .line 883
    .local v0, "topChild":Landroid/view/View;
    if-eqz v0, :cond_0

    .line 884
    invoke-virtual {v0}, Landroid/view/View;->getTop()I

    move-result v1

    iput v1, p0, Lco/vine/android/ConversationFragment;->mLastTopItemPixelOffset:I

    goto :goto_0
.end method

.method private scrollToBottom(ZZ)V
    .locals 4
    .param p1, "respectCurrentPos"    # Z
    .param p2, "smooth"    # Z

    .prologue
    .line 620
    iget-object v1, p0, Lco/vine/android/ConversationFragment;->mListView:Landroid/widget/ListView;

    .line 621
    .local v1, "listView":Landroid/widget/ListView;
    iget-object v2, p0, Lco/vine/android/ConversationFragment;->mCursorAdapter:Landroid/support/v4/widget/CursorAdapter;

    invoke-virtual {v2}, Landroid/support/v4/widget/CursorAdapter;->getCount()I

    move-result v2

    invoke-virtual {v1}, Landroid/widget/ListView;->getHeaderViewsCount()I

    move-result v3

    add-int v0, v2, v3

    .line 622
    .local v0, "count":I
    if-eqz p1, :cond_0

    invoke-virtual {v1}, Landroid/widget/ListView;->getLastVisiblePosition()I

    move-result v2

    sub-int v2, v0, v2

    const/4 v3, 0x2

    if-ge v2, v3, :cond_1

    .line 623
    :cond_0
    new-instance v2, Lco/vine/android/ConversationFragment$4;

    invoke-direct {v2, p0, p2, v1, v0}, Lco/vine/android/ConversationFragment$4;-><init>(Lco/vine/android/ConversationFragment;ZLandroid/widget/ListView;I)V

    invoke-virtual {v1, v2}, Landroid/widget/ListView;->post(Ljava/lang/Runnable;)Z

    .line 634
    :cond_1
    return-void
.end method

.method private sendMessage(Ljava/lang/String;)V
    .locals 11
    .param p1, "uploadPath"    # Ljava/lang/String;

    .prologue
    const/4 v6, 0x0

    const/4 v2, 0x0

    .line 468
    invoke-virtual {p0}, Lco/vine/android/ConversationFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    iget-wide v3, p0, Lco/vine/android/ConversationFragment;->mConversationRowId:J

    iget-object v1, p0, Lco/vine/android/ConversationFragment;->mContentResolver:Landroid/content/ContentResolver;

    iget-wide v9, p0, Lco/vine/android/ConversationFragment;->mConversationRowId:J

    invoke-static {v1, v9, v10}, Lco/vine/android/provider/VineProviderHelper;->getConversationRecipients(Landroid/content/ContentResolver;J)Ljava/util/ArrayList;

    move-result-object v5

    move-object v1, p1

    move v7, v2

    invoke-static/range {v0 .. v7}, Lco/vine/android/service/VineUploadService;->getVMPostIntent(Landroid/content/Context;Ljava/lang/String;ZJLjava/util/ArrayList;Ljava/lang/String;I)Landroid/content/Intent;

    move-result-object v8

    .line 470
    .local v8, "intent":Landroid/content/Intent;
    const-string v0, "intent={}, extras={}"

    invoke-virtual {v8}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v1

    invoke-static {v0, v8, v1}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V

    .line 471
    invoke-virtual {p0}, Lco/vine/android/ConversationFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0, v8}, Landroid/support/v4/app/FragmentActivity;->startService(Landroid/content/Intent;)Landroid/content/ComponentName;

    .line 472
    new-instance v0, Lco/vine/android/ConversationFragment$UploadProgressHandler;

    invoke-direct {v0, p0, v6}, Lco/vine/android/ConversationFragment$UploadProgressHandler;-><init>(Lco/vine/android/ConversationFragment;Lco/vine/android/ConversationFragment$1;)V

    iput-object v0, p0, Lco/vine/android/ConversationFragment;->mIncomingHandler:Landroid/os/Handler;

    .line 473
    iget-object v0, p0, Lco/vine/android/ConversationFragment;->mIncomingHandler:Landroid/os/Handler;

    invoke-direct {p0, v0}, Lco/vine/android/ConversationFragment;->subscribe(Landroid/os/Handler;)V

    .line 474
    return-void
.end method

.method private sendMessageToUploadService(Landroid/os/Message;)V
    .locals 2
    .param p1, "msg"    # Landroid/os/Message;

    .prologue
    .line 611
    :try_start_0
    iget-object v1, p0, Lco/vine/android/ConversationFragment;->mUploadServiceMessenger:Landroid/os/Messenger;

    if-eqz v1, :cond_0

    .line 612
    iget-object v1, p0, Lco/vine/android/ConversationFragment;->mUploadServiceMessenger:Landroid/os/Messenger;

    invoke-virtual {v1, p1}, Landroid/os/Messenger;->send(Landroid/os/Message;)V
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0

    .line 617
    :cond_0
    :goto_0
    return-void

    .line 614
    :catch_0
    move-exception v0

    .line 615
    .local v0, "e":Landroid/os/RemoteException;
    invoke-virtual {v0}, Landroid/os/RemoteException;->printStackTrace()V

    goto :goto_0
.end method

.method private sendTextMessage()V
    .locals 12

    .prologue
    const/4 v2, 0x0

    .line 889
    iget-object v8, p0, Lco/vine/android/ConversationFragment;->mEdit:Lco/vine/android/widget/TypefacesEditText;

    .line 890
    .local v8, "editText":Landroid/widget/EditText;
    invoke-virtual {v8}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v0

    invoke-interface {v0}, Landroid/text/Editable;->length()I

    move-result v0

    const/16 v1, 0x1a4

    if-le v0, v1, :cond_0

    .line 891
    invoke-virtual {p0}, Lco/vine/android/ConversationFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    const v1, 0x7f0e013c

    invoke-static {v0, v1}, Lco/vine/android/util/Util;->showTopToast(Landroid/content/Context;I)V

    .line 907
    :goto_0
    return-void

    .line 893
    :cond_0
    iget-object v0, p0, Lco/vine/android/ConversationFragment;->mEdit:Lco/vine/android/widget/TypefacesEditText;

    invoke-direct {p0, v0}, Lco/vine/android/ConversationFragment;->validate(Landroid/widget/EditText;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 894
    invoke-virtual {v8}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v6

    .line 895
    .local v6, "message":Ljava/lang/String;
    invoke-virtual {p0}, Lco/vine/android/ConversationFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    const/4 v1, 0x0

    iget-wide v3, p0, Lco/vine/android/ConversationFragment;->mConversationRowId:J

    iget-object v5, p0, Lco/vine/android/ConversationFragment;->mContentResolver:Landroid/content/ContentResolver;

    iget-wide v10, p0, Lco/vine/android/ConversationFragment;->mConversationRowId:J

    invoke-static {v5, v10, v11}, Lco/vine/android/provider/VineProviderHelper;->getConversationRecipients(Landroid/content/ContentResolver;J)Ljava/util/ArrayList;

    move-result-object v5

    move v7, v2

    invoke-static/range {v0 .. v7}, Lco/vine/android/service/VineUploadService;->getVMPostIntent(Landroid/content/Context;Ljava/lang/String;ZJLjava/util/ArrayList;Ljava/lang/String;I)Landroid/content/Intent;

    move-result-object v9

    .line 898
    .local v9, "i":Landroid/content/Intent;
    invoke-virtual {p0}, Lco/vine/android/ConversationFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0, v9}, Landroid/support/v4/app/FragmentActivity;->startService(Landroid/content/Intent;)Landroid/content/ComponentName;

    .line 899
    const/4 v0, 0x1

    iput-boolean v0, p0, Lco/vine/android/ConversationFragment;->mIsSending:Z

    .line 900
    invoke-virtual {v8}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v0

    invoke-interface {v0}, Landroid/text/Editable;->clear()V

    .line 901
    iput-boolean v2, p0, Lco/vine/android/ConversationFragment;->mIsSending:Z

    goto :goto_0

    .line 903
    .end local v6    # "message":Ljava/lang/String;
    .end local v9    # "i":Landroid/content/Intent;
    :cond_1
    invoke-virtual {p0}, Lco/vine/android/ConversationFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    iget-object v1, p0, Lco/vine/android/ConversationFragment;->mEdit:Lco/vine/android/widget/TypefacesEditText;

    invoke-static {v0, v1, v2}, Lco/vine/android/util/Util;->setSoftKeyboardVisibility(Landroid/content/Context;Landroid/view/View;Z)V

    .line 904
    invoke-direct {p0}, Lco/vine/android/ConversationFragment;->hideTypingContainer()V

    goto :goto_0
.end method

.method private subscribe(Landroid/os/Handler;)V
    .locals 4
    .param p1, "replyHandler"    # Landroid/os/Handler;

    .prologue
    .line 256
    new-instance v0, Landroid/os/Messenger;

    invoke-direct {v0, p1}, Landroid/os/Messenger;-><init>(Landroid/os/Handler;)V

    .line 257
    .local v0, "replyTo":Landroid/os/Messenger;
    const/4 v2, 0x0

    const/4 v3, 0x1

    invoke-static {v2, v3}, Landroid/os/Message;->obtain(Landroid/os/Handler;I)Landroid/os/Message;

    move-result-object v1

    .line 258
    .local v1, "subscribe":Landroid/os/Message;
    iput-object v0, v1, Landroid/os/Message;->replyTo:Landroid/os/Messenger;

    .line 259
    invoke-direct {p0, v1}, Lco/vine/android/ConversationFragment;->sendMessageToUploadService(Landroid/os/Message;)V

    .line 260
    return-void
.end method

.method private toggleInput()V
    .locals 7

    .prologue
    const/16 v6, 0x8

    .line 926
    invoke-virtual {p0}, Lco/vine/android/ConversationFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    .line 927
    .local v0, "activity":Landroid/support/v4/app/FragmentActivity;
    if-eqz v0, :cond_0

    .line 928
    iget-object v1, p0, Lco/vine/android/ConversationFragment;->mEdit:Lco/vine/android/widget/TypefacesEditText;

    .line 929
    .local v1, "edit":Landroid/widget/EditText;
    invoke-virtual {v1}, Landroid/widget/EditText;->requestFocus()Z

    .line 930
    const/4 v2, 0x1

    invoke-static {v0, v1, v2}, Lco/vine/android/util/Util;->setSoftKeyboardVisibility(Landroid/content/Context;Landroid/view/View;Z)V

    .line 931
    iget-object v2, p0, Lco/vine/android/ConversationFragment;->mTextInputContainer:Landroid/widget/RelativeLayout;

    const/4 v3, 0x0

    invoke-virtual {v2, v3}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 932
    iget-object v2, p0, Lco/vine/android/ConversationFragment;->mComposeContainer:Landroid/view/View;

    const v3, 0x7f0a0097

    invoke-virtual {v2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    new-instance v3, Landroid/graphics/drawable/ColorDrawable;

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    const v5, 0x7f090083

    invoke-virtual {v4, v5}, Landroid/content/res/Resources;->getColor(I)I

    move-result v4

    invoke-direct {v3, v4}, Landroid/graphics/drawable/ColorDrawable;-><init>(I)V

    invoke-static {v2, v3}, Lco/vine/android/util/ViewUtil;->setBackground(Landroid/view/View;Landroid/graphics/drawable/Drawable;)V

    .line 934
    iget-object v2, p0, Lco/vine/android/ConversationFragment;->mRecordButton:Landroid/widget/ImageView;

    invoke-virtual {v2, v6}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 935
    iget-object v2, p0, Lco/vine/android/ConversationFragment;->mTextInputToggle:Landroid/view/View;

    invoke-virtual {v2, v6}, Landroid/view/View;->setVisibility(I)V

    .line 937
    .end local v1    # "edit":Landroid/widget/EditText;
    :cond_0
    return-void
.end method

.method private toggleNewMessageBar(Z)V
    .locals 2
    .param p1, "show"    # Z

    .prologue
    .line 982
    iget-object v1, p0, Lco/vine/android/ConversationFragment;->mNewMessageBarContainer:Landroid/view/View;

    if-eqz p1, :cond_0

    const/4 v0, 0x0

    :goto_0
    invoke-virtual {v1, v0}, Landroid/view/View;->setVisibility(I)V

    .line 983
    return-void

    .line 982
    :cond_0
    const/16 v0, 0x8

    goto :goto_0
.end method

.method private validate(Landroid/widget/EditText;)Z
    .locals 1
    .param p1, "editText"    # Landroid/widget/EditText;

    .prologue
    .line 922
    if-eqz p1, :cond_0

    invoke-virtual {p1}, Landroid/widget/EditText;->length()I

    move-result v0

    if-lez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method


# virtual methods
.method public afterTextChanged(Landroid/text/Editable;)V
    .locals 3
    .param p1, "editable"    # Landroid/text/Editable;

    .prologue
    .line 767
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 768
    iget-object v0, p0, Lco/vine/android/ConversationFragment;->mCallback:Lco/vine/android/ConversationActivity;

    const/4 v1, 0x1

    iget-boolean v2, p0, Lco/vine/android/ConversationFragment;->mIsSending:Z

    invoke-virtual {v0, v1, v2}, Lco/vine/android/ConversationActivity;->onTypingStatusChanged(ZZ)V

    .line 772
    :goto_0
    return-void

    .line 770
    :cond_0
    iget-object v0, p0, Lco/vine/android/ConversationFragment;->mCallback:Lco/vine/android/ConversationActivity;

    const/4 v1, 0x0

    iget-boolean v2, p0, Lco/vine/android/ConversationFragment;->mIsSending:Z

    invoke-virtual {v0, v1, v2}, Lco/vine/android/ConversationActivity;->onTypingStatusChanged(ZZ)V

    goto :goto_0
.end method

.method public beforeTextChanged(Ljava/lang/CharSequence;III)V
    .locals 0
    .param p1, "charSequence"    # Ljava/lang/CharSequence;
    .param p2, "i"    # I
    .param p3, "i2"    # I
    .param p4, "i3"    # I

    .prologue
    .line 776
    return-void
.end method

.method public getMyColor()I
    .locals 1

    .prologue
    .line 498
    iget v0, p0, Lco/vine/android/ConversationFragment;->mMyColor:I

    return v0
.end method

.method public hideProgress(I)V
    .locals 2
    .param p1, "type"    # I

    .prologue
    .line 669
    iget-object v0, p0, Lco/vine/android/ConversationFragment;->mLoadMoreProgress:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 670
    return-void
.end method

.method public isInTextInputMode()Z
    .locals 2

    .prologue
    .line 986
    iget-object v0, p0, Lco/vine/android/ConversationFragment;->mRecordButton:Landroid/widget/ImageView;

    invoke-virtual {v0}, Landroid/widget/ImageView;->getVisibility()I

    move-result v0

    const/16 v1, 0x8

    if-ne v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method launchFullRecord()V
    .locals 8

    .prologue
    const/4 v1, 0x0

    .line 990
    invoke-virtual {p0}, Lco/vine/android/ConversationFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    const-string v2, "ConversationFullRecord"

    iget-wide v3, p0, Lco/vine/android/ConversationFragment;->mConversationRowId:J

    iget-object v6, p0, Lco/vine/android/ConversationFragment;->mRecipientUsername:Ljava/lang/String;

    iget-boolean v7, p0, Lco/vine/android/ConversationFragment;->mAmFollowing:Z

    move v5, v1

    invoke-static/range {v0 .. v7}, Lco/vine/android/AbstractRecordingActivity;->getIntentForConversation(Landroid/content/Context;ILjava/lang/String;JZLjava/lang/String;Z)Landroid/content/Intent;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/ConversationFragment;->mFullRecordIntent:Landroid/content/Intent;

    .line 992
    new-instance v0, Lco/vine/android/ConversationFragment$UploadProgressHandler;

    const/4 v1, 0x0

    invoke-direct {v0, p0, v1}, Lco/vine/android/ConversationFragment$UploadProgressHandler;-><init>(Lco/vine/android/ConversationFragment;Lco/vine/android/ConversationFragment$1;)V

    iput-object v0, p0, Lco/vine/android/ConversationFragment;->mIncomingHandler:Landroid/os/Handler;

    .line 993
    iget-object v0, p0, Lco/vine/android/ConversationFragment;->mIncomingHandler:Landroid/os/Handler;

    invoke-direct {p0, v0}, Lco/vine/android/ConversationFragment;->subscribe(Landroid/os/Handler;)V

    .line 994
    iget-object v0, p0, Lco/vine/android/ConversationFragment;->mHandler:Landroid/os/Handler;

    iget-object v1, p0, Lco/vine/android/ConversationFragment;->mLaunchFullRecordRunnable:Ljava/lang/Runnable;

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 995
    return-void
.end method

.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 17
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 290
    invoke-super/range {p0 .. p1}, Lco/vine/android/BaseCursorListFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 291
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/ConversationFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    check-cast v2, Lco/vine/android/ConversationActivity;

    .line 292
    .local v2, "activity":Lco/vine/android/ConversationActivity;
    invoke-static {v2}, Lco/vine/android/util/Util;->getDefaultSharedPrefs(Landroid/content/Context;)Landroid/content/SharedPreferences;

    move-result-object v13

    .line 293
    .local v13, "prefs":Landroid/content/SharedPreferences;
    invoke-static {v2}, Lco/vine/android/util/Util;->isCapableOfRecording(Landroid/content/Context;)Z

    move-result v1

    move-object/from16 v0, p0

    iput-boolean v1, v0, Lco/vine/android/ConversationFragment;->mRecordingEnabled:Z

    .line 295
    move-object/from16 v0, p0

    iget-boolean v1, v0, Lco/vine/android/ConversationFragment;->mRecordingEnabled:Z

    if-eqz v1, :cond_0

    .line 297
    :try_start_0
    move-object/from16 v0, p0

    iget-object v1, v0, Lco/vine/android/ConversationFragment;->mVersion:Lco/vine/android/recorder/RecordSessionVersion;

    invoke-virtual {v1, v2}, Lco/vine/android/recorder/RecordSessionVersion;->getManager(Landroid/content/Context;)Lco/vine/android/recorder/RecordSessionManager;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 309
    :cond_0
    :goto_0
    const-string v1, "pref_user_row_id"

    const-wide/16 v3, 0x0

    invoke-interface {v13, v1, v3, v4}, Landroid/content/SharedPreferences;->getLong(Ljava/lang/String;J)J

    move-result-wide v3

    move-object/from16 v0, p0

    iput-wide v3, v0, Lco/vine/android/ConversationFragment;->mMyUserRowId:J

    .line 310
    move-object/from16 v0, p0

    iget-object v1, v0, Lco/vine/android/ConversationFragment;->mCursorAdapter:Landroid/support/v4/widget/CursorAdapter;

    if-nez v1, :cond_1

    .line 311
    new-instance v1, Lco/vine/android/ConversationAdapter;

    move-object/from16 v0, p0

    iget-object v3, v0, Lco/vine/android/ConversationFragment;->mAppController:Lco/vine/android/client/AppController;

    move-object/from16 v0, p0

    iget-object v4, v0, Lco/vine/android/ConversationFragment;->mListView:Landroid/widget/ListView;

    move-object/from16 v0, p0

    iget-wide v5, v0, Lco/vine/android/ConversationFragment;->mMyUserRowId:J

    const/4 v7, 0x0

    invoke-direct/range {v1 .. v7}, Lco/vine/android/ConversationAdapter;-><init>(Lco/vine/android/ConversationActivity;Lco/vine/android/client/AppController;Landroid/widget/ListView;JI)V

    move-object/from16 v0, p0

    iput-object v1, v0, Lco/vine/android/ConversationFragment;->mConversationAdapter:Lco/vine/android/ConversationAdapter;

    .line 313
    move-object/from16 v0, p0

    iget-object v1, v0, Lco/vine/android/ConversationFragment;->mConversationAdapter:Lco/vine/android/ConversationAdapter;

    move-object/from16 v0, p0

    iput-object v1, v0, Lco/vine/android/ConversationFragment;->mCursorAdapter:Landroid/support/v4/widget/CursorAdapter;

    .line 316
    :cond_1
    move-object/from16 v0, p0

    iget-object v11, v0, Lco/vine/android/ConversationFragment;->mListView:Landroid/widget/ListView;

    .line 317
    .local v11, "listView":Landroid/widget/ListView;
    move-object/from16 v0, p0

    invoke-virtual {v11, v0}, Landroid/widget/ListView;->setOnScrollListener(Landroid/widget/AbsListView$OnScrollListener;)V

    .line 318
    const/4 v1, 0x0

    invoke-virtual {v11, v1}, Landroid/widget/ListView;->setDivider(Landroid/graphics/drawable/Drawable;)V

    move-object v1, v11

    .line 319
    check-cast v1, Lco/vine/android/widget/ConversationList;

    const/4 v3, 0x1

    invoke-virtual {v1, v3}, Lco/vine/android/widget/ConversationList;->deactivateRefresh(Z)V

    .line 320
    new-instance v1, Lco/vine/android/ConversationFragment$ConversationSessionListener;

    const/4 v3, 0x0

    move-object/from16 v0, p0

    invoke-direct {v1, v0, v3}, Lco/vine/android/ConversationFragment$ConversationSessionListener;-><init>(Lco/vine/android/ConversationFragment;Lco/vine/android/ConversationFragment$1;)V

    move-object/from16 v0, p0

    iput-object v1, v0, Lco/vine/android/ConversationFragment;->mAppSessionListener:Lco/vine/android/client/AppSessionListener;

    .line 322
    invoke-static {v2}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v1

    const v3, 0x7f03002e

    const/4 v4, 0x0

    invoke-virtual {v1, v3, v4}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v12

    check-cast v12, Landroid/view/ViewGroup;

    .line 324
    .local v12, "loadMoreHeader":Landroid/view/ViewGroup;
    const v1, 0x7f0a00b0

    invoke-virtual {v12, v1}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v1

    move-object/from16 v0, p0

    iput-object v1, v0, Lco/vine/android/ConversationFragment;->mLoadMoreHeaderContent:Landroid/view/View;

    .line 325
    move-object/from16 v0, p0

    iget-object v1, v0, Lco/vine/android/ConversationFragment;->mLoadMoreHeaderContent:Landroid/view/View;

    const/16 v3, 0x8

    invoke-virtual {v1, v3}, Landroid/view/View;->setVisibility(I)V

    .line 326
    const v1, 0x7f0a00b2

    invoke-virtual {v12, v1}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v1

    move-object/from16 v0, p0

    iput-object v1, v0, Lco/vine/android/ConversationFragment;->mLoadMoreProgress:Landroid/view/View;

    .line 327
    invoke-virtual {v11, v12}, Landroid/widget/ListView;->addHeaderView(Landroid/view/View;)V

    .line 328
    move-object/from16 v0, p0

    iget-object v1, v0, Lco/vine/android/ConversationFragment;->mLoadMoreHeaderContent:Landroid/view/View;

    move-object/from16 v0, p0

    invoke-virtual {v1, v0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 329
    move-object/from16 v0, p0

    iget-object v1, v0, Lco/vine/android/ConversationFragment;->mLoadMoreHeaderContent:Landroid/view/View;

    const/4 v3, 0x0

    invoke-virtual {v1, v3}, Landroid/view/View;->setVisibility(I)V

    .line 330
    move-object/from16 v0, p0

    iget-object v1, v0, Lco/vine/android/ConversationFragment;->mCursorAdapter:Landroid/support/v4/widget/CursorAdapter;

    invoke-virtual {v11, v1}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 333
    invoke-static {v2}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v1

    const v3, 0x7f030031

    move-object/from16 v0, p0

    iget-object v4, v0, Lco/vine/android/ConversationFragment;->mListView:Landroid/widget/ListView;

    const/4 v5, 0x0

    invoke-virtual {v1, v3, v4, v5}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v16

    check-cast v16, Landroid/view/ViewGroup;

    .line 335
    .local v16, "uploadProgressContainer":Landroid/view/ViewGroup;
    const v1, 0x7f0a00c5

    move-object/from16 v0, v16

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/view/ViewGroup;

    move-object/from16 v0, p0

    iput-object v1, v0, Lco/vine/android/ConversationFragment;->mUploadProgressContainer:Landroid/view/ViewGroup;

    .line 336
    const v1, 0x7f0a00c6

    move-object/from16 v0, v16

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lco/vine/android/recorder/ProgressView;

    move-object/from16 v0, p0

    iput-object v1, v0, Lco/vine/android/ConversationFragment;->mProgressView:Lco/vine/android/recorder/ProgressView;

    .line 337
    const v1, 0x7f0a0065

    move-object/from16 v0, v16

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/ImageView;

    move-object/from16 v0, p0

    iput-object v1, v0, Lco/vine/android/ConversationFragment;->mUploadThumbnail:Landroid/widget/ImageView;

    .line 340
    invoke-static {v2}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v1

    const v3, 0x7f03002b

    move-object/from16 v0, p0

    iget-object v4, v0, Lco/vine/android/ConversationFragment;->mListView:Landroid/widget/ListView;

    const/4 v5, 0x0

    invoke-virtual {v1, v3, v4, v5}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v10

    check-cast v10, Landroid/view/ViewGroup;

    .line 342
    .local v10, "footer":Landroid/view/ViewGroup;
    const v1, 0x7f0a00ad

    invoke-virtual {v10, v1}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/view/ViewGroup;

    move-object/from16 v0, p0

    iput-object v1, v0, Lco/vine/android/ConversationFragment;->mChatPresenceContainer:Landroid/view/ViewGroup;

    .line 343
    const v1, 0x7f0a00ae

    invoke-virtual {v10, v1}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/ImageView;

    move-object/from16 v0, p0

    iput-object v1, v0, Lco/vine/android/ConversationFragment;->mChatPresenceEllipsis:Landroid/widget/ImageView;

    .line 344
    move-object/from16 v0, p0

    iput-object v10, v0, Lco/vine/android/ConversationFragment;->mChatPresenceFooter:Landroid/view/ViewGroup;

    .line 346
    move-object/from16 v0, p0

    iget-object v1, v0, Lco/vine/android/ConversationFragment;->mListView:Landroid/widget/ListView;

    move-object/from16 v0, p0

    iget-object v3, v0, Lco/vine/android/ConversationFragment;->mChatPresenceFooter:Landroid/view/ViewGroup;

    invoke-virtual {v1, v3}, Landroid/widget/ListView;->addFooterView(Landroid/view/View;)V

    .line 348
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/ConversationFragment;->getView()Landroid/view/View;

    move-result-object v15

    .line 350
    .local v15, "rootView":Landroid/view/View;
    move-object/from16 v0, p0

    iget-boolean v1, v0, Lco/vine/android/ConversationFragment;->mRecordingEnabled:Z

    if-eqz v1, :cond_5

    .line 351
    const v1, 0x7f0a009d

    invoke-virtual {v15, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lco/vine/android/InlineRecorderManager;

    move-object/from16 v0, p0

    iput-object v1, v0, Lco/vine/android/ConversationFragment;->mRecorderManager:Lco/vine/android/InlineRecorderManager;

    .line 352
    move-object/from16 v0, p0

    iget-object v1, v0, Lco/vine/android/ConversationFragment;->mRecorderManager:Lco/vine/android/InlineRecorderManager;

    move-object/from16 v0, p0

    iget-object v3, v0, Lco/vine/android/ConversationFragment;->mVersion:Lco/vine/android/recorder/RecordSessionVersion;

    move-object/from16 v0, p0

    invoke-virtual {v1, v0, v2, v3}, Lco/vine/android/InlineRecorderManager;->init(Lco/vine/android/ConversationFragment;Lco/vine/android/ConversationActivity;Lco/vine/android/recorder/RecordSessionVersion;)V

    .line 357
    :goto_1
    invoke-virtual {v2}, Lco/vine/android/ConversationActivity;->getSupportActionBar()Landroid/support/v7/app/ActionBar;

    move-result-object v1

    new-instance v3, Landroid/graphics/drawable/ColorDrawable;

    move-object/from16 v0, p0

    iget v4, v0, Lco/vine/android/ConversationFragment;->mRecipientColor:I

    invoke-direct {v3, v4}, Landroid/graphics/drawable/ColorDrawable;-><init>(I)V

    invoke-virtual {v1, v3}, Landroid/support/v7/app/ActionBar;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 359
    const v1, 0x7f0a0097

    invoke-virtual {v15, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    move-object/from16 v0, p0

    iput-object v1, v0, Lco/vine/android/ConversationFragment;->mComposeContainer:Landroid/view/View;

    .line 361
    const-string v1, "profile_background"

    sget v3, Lco/vine/android/Settings;->DEFAULT_PROFILE_COLOR:I

    invoke-interface {v13, v1, v3}, Landroid/content/SharedPreferences;->getInt(Ljava/lang/String;I)I

    move-result v14

    .line 362
    .local v14, "rawColor":I
    sget v1, Lco/vine/android/Settings;->DEFAULT_PROFILE_COLOR:I

    if-eq v14, v1, :cond_2

    if-gtz v14, :cond_3

    .line 363
    :cond_2
    const v1, 0xffffff

    invoke-virtual/range {p0 .. p0}, Lco/vine/android/ConversationFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    const v4, 0x7f090096

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getColor(I)I

    move-result v3

    and-int v14, v1, v3

    .line 365
    :cond_3
    const/high16 v1, -0x1000000

    or-int/2addr v1, v14

    move-object/from16 v0, p0

    iput v1, v0, Lco/vine/android/ConversationFragment;->mMyColor:I

    .line 366
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/ConversationFragment;->getView()Landroid/view/View;

    move-result-object v1

    const v3, 0x7f0a00a1

    invoke-virtual {v1, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lco/vine/android/recorder/ProgressView;

    move-object/from16 v0, p0

    iget v3, v0, Lco/vine/android/ConversationFragment;->mMyColor:I

    invoke-virtual {v1, v3}, Lco/vine/android/recorder/ProgressView;->setColor(I)V

    .line 368
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/ConversationFragment;->getView()Landroid/view/View;

    move-result-object v1

    const v3, 0x7f0a00a7

    invoke-virtual {v1, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lco/vine/android/recorder/ProgressView;

    move-object/from16 v0, p0

    iget v3, v0, Lco/vine/android/ConversationFragment;->mMyColor:I

    invoke-virtual {v1, v3}, Lco/vine/android/recorder/ProgressView;->setColor(I)V

    .line 370
    move-object/from16 v0, p0

    iget-object v1, v0, Lco/vine/android/ConversationFragment;->mComposeContainer:Landroid/view/View;

    new-instance v3, Landroid/graphics/drawable/ColorDrawable;

    invoke-virtual/range {p0 .. p0}, Lco/vine/android/ConversationFragment;->getMyColor()I

    move-result v4

    invoke-direct {v3, v4}, Landroid/graphics/drawable/ColorDrawable;-><init>(I)V

    invoke-static {v1, v3}, Lco/vine/android/util/ViewUtil;->setBackground(Landroid/view/View;Landroid/graphics/drawable/Drawable;)V

    .line 372
    invoke-virtual {v2}, Lco/vine/android/ConversationActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v3, 0x7f0200f5

    invoke-virtual {v1, v3}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v8

    check-cast v8, Landroid/graphics/drawable/GradientDrawable;

    .line 373
    .local v8, "dr":Landroid/graphics/drawable/GradientDrawable;
    const/high16 v1, -0x1000000

    move-object/from16 v0, p0

    iget v3, v0, Lco/vine/android/ConversationFragment;->mMyColor:I

    or-int/2addr v1, v3

    invoke-virtual {v8, v1}, Landroid/graphics/drawable/GradientDrawable;->setColor(I)V

    .line 375
    move-object/from16 v0, p0

    iget-object v1, v0, Lco/vine/android/ConversationFragment;->mNewMessageBarContainer:Landroid/view/View;

    new-instance v3, Landroid/graphics/drawable/ColorDrawable;

    move-object/from16 v0, p0

    iget v4, v0, Lco/vine/android/ConversationFragment;->mRecipientColor:I

    invoke-direct {v3, v4}, Landroid/graphics/drawable/ColorDrawable;-><init>(I)V

    invoke-virtual {v1, v3}, Landroid/view/View;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 376
    move-object/from16 v0, p0

    iget-object v1, v0, Lco/vine/android/ConversationFragment;->mSendButton:Landroid/widget/ImageView;

    move-object/from16 v0, p0

    iget-object v3, v0, Lco/vine/android/ConversationFragment;->mLaunchRecorderListener:Landroid/view/View$OnClickListener;

    invoke-virtual {v1, v3}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 377
    move-object/from16 v0, p0

    iget-object v1, v0, Lco/vine/android/ConversationFragment;->mSendButton:Landroid/widget/ImageView;

    new-instance v3, Landroid/graphics/PorterDuffColorFilter;

    invoke-virtual/range {p0 .. p0}, Lco/vine/android/ConversationFragment;->getMyColor()I

    move-result v4

    sget-object v5, Landroid/graphics/PorterDuff$Mode;->SRC_IN:Landroid/graphics/PorterDuff$Mode;

    invoke-direct {v3, v4, v5}, Landroid/graphics/PorterDuffColorFilter;-><init>(ILandroid/graphics/PorterDuff$Mode;)V

    invoke-virtual {v1, v3}, Landroid/widget/ImageView;->setColorFilter(Landroid/graphics/ColorFilter;)V

    .line 378
    return-void

    .line 298
    .end local v8    # "dr":Landroid/graphics/drawable/GradientDrawable;
    .end local v10    # "footer":Landroid/view/ViewGroup;
    .end local v11    # "listView":Landroid/widget/ListView;
    .end local v12    # "loadMoreHeader":Landroid/view/ViewGroup;
    .end local v14    # "rawColor":I
    .end local v15    # "rootView":Landroid/view/View;
    .end local v16    # "uploadProgressContainer":Landroid/view/ViewGroup;
    :catch_0
    move-exception v9

    .line 299
    .local v9, "e":Ljava/io/IOException;
    const/4 v1, 0x0

    move-object/from16 v0, p0

    iput-boolean v1, v0, Lco/vine/android/ConversationFragment;->mRecordingEnabled:Z

    .line 300
    instance-of v1, v9, Lco/vine/android/recorder/RecordSessionManager$NotEnoughSpaceException;

    if-eqz v1, :cond_4

    .line 301
    const v1, 0x7f0e00dc

    invoke-static {v2, v1}, Lco/vine/android/util/Util;->showCenteredToast(Landroid/content/Context;I)V

    .line 305
    :goto_2
    const-string v1, "Exception has happened: {}"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    aput-object v9, v3, v4

    invoke-static {v1, v3}, Lco/vine/android/util/CrashUtil;->log(Ljava/lang/String;[Ljava/lang/Object;)V

    goto/16 :goto_0

    .line 303
    :cond_4
    const v1, 0x7f0e00dd

    invoke-static {v2, v1}, Lco/vine/android/util/Util;->showCenteredToast(Landroid/content/Context;I)V

    goto :goto_2

    .line 354
    .end local v9    # "e":Ljava/io/IOException;
    .restart local v10    # "footer":Landroid/view/ViewGroup;
    .restart local v11    # "listView":Landroid/widget/ListView;
    .restart local v12    # "loadMoreHeader":Landroid/view/ViewGroup;
    .restart local v15    # "rootView":Landroid/view/View;
    .restart local v16    # "uploadProgressContainer":Landroid/view/ViewGroup;
    :cond_5
    const v1, 0x7f0a009d

    invoke-virtual {v15, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lco/vine/android/InlineRecorderManager;

    move-object/from16 v0, p0

    invoke-virtual {v1, v0}, Lco/vine/android/InlineRecorderManager;->initDisabled(Lco/vine/android/ConversationFragment;)V

    goto/16 :goto_1
.end method

.method public onActivityResult(IILandroid/content/Intent;)V
    .locals 3
    .param p1, "requestCode"    # I
    .param p2, "resultCode"    # I
    .param p3, "data"    # Landroid/content/Intent;

    .prologue
    const/4 v1, 0x2

    .line 450
    if-ne p1, v1, :cond_1

    .line 451
    iget-object v0, p0, Lco/vine/android/ConversationFragment;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {p0}, Lco/vine/android/ConversationFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-static {v0, v1, p2, p3}, Lco/vine/android/PostOptionsDialogActivity;->onActivityResult(Lco/vine/android/client/AppController;Landroid/app/Activity;ILandroid/content/Intent;)Lco/vine/android/PostOptionsDialogActivity$Result;

    move-result-object v0

    invoke-virtual {p0, v0}, Lco/vine/android/ConversationFragment;->processPostOptionsResult(Lco/vine/android/PostOptionsDialogActivity$Result;)V

    .line 465
    :cond_0
    :goto_0
    return-void

    .line 454
    :cond_1
    const/16 v0, 0x7c7

    if-ne p1, v0, :cond_2

    if-eqz p3, :cond_2

    .line 455
    const-string v0, "ConversationFrag"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "resultCode="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ", data="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/edisonwang/android/slog/SLog;->dWithTag(Ljava/lang/String;Ljava/lang/String;)V

    .line 456
    invoke-static {}, Lco/vine/android/util/BuildUtil;->isIsHwEncodingEnabled()Z

    move-result v0

    if-nez v0, :cond_0

    .line 457
    const-string v0, "upload_path"

    invoke-virtual {p3, v0}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-direct {p0, v0}, Lco/vine/android/ConversationFragment;->sendMessage(Ljava/lang/String;)V

    goto :goto_0

    .line 459
    :cond_2
    const/16 v0, 0x64

    if-ne p2, v0, :cond_0

    .line 461
    const/4 v0, 0x0

    invoke-static {v0, v1}, Landroid/os/Message;->obtain(Landroid/os/Handler;I)Landroid/os/Message;

    move-result-object v0

    invoke-direct {p0, v0}, Lco/vine/android/ConversationFragment;->sendMessageToUploadService(Landroid/os/Message;)V

    goto :goto_0
.end method

.method public onAttach(Landroid/app/Activity;)V
    .locals 0
    .param p1, "activity"    # Landroid/app/Activity;

    .prologue
    .line 164
    invoke-super {p0, p1}, Lco/vine/android/BaseCursorListFragment;->onAttach(Landroid/app/Activity;)V

    .line 165
    check-cast p1, Lco/vine/android/ConversationActivity;

    .end local p1    # "activity":Landroid/app/Activity;
    iput-object p1, p0, Lco/vine/android/ConversationFragment;->mCallback:Lco/vine/android/ConversationActivity;

    .line 166
    return-void
.end method

.method public onClick(Landroid/view/View;)V
    .locals 3
    .param p1, "view"    # Landroid/view/View;

    .prologue
    const/4 v2, 0x0

    .line 941
    invoke-virtual {p1}, Landroid/view/View;->getId()I

    move-result v0

    sparse-switch v0, :sswitch_data_0

    .line 963
    :goto_0
    return-void

    .line 943
    :sswitch_0
    invoke-direct {p0}, Lco/vine/android/ConversationFragment;->sendTextMessage()V

    goto :goto_0

    .line 947
    :sswitch_1
    invoke-direct {p0}, Lco/vine/android/ConversationFragment;->toggleInput()V

    goto :goto_0

    .line 951
    :sswitch_2
    iget-object v0, p0, Lco/vine/android/ConversationFragment;->mLoadMoreHeaderContent:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 952
    iget-object v0, p0, Lco/vine/android/ConversationFragment;->mLoadMoreProgress:Landroid/view/View;

    invoke-virtual {v0, v2}, Landroid/view/View;->setVisibility(I)V

    .line 953
    const/4 v0, 0x1

    invoke-direct {p0, v0}, Lco/vine/android/ConversationFragment;->fetchContent(I)V

    goto :goto_0

    .line 957
    :sswitch_3
    invoke-direct {p0, v2, v2}, Lco/vine/android/ConversationFragment;->scrollToBottom(ZZ)V

    .line 958
    invoke-direct {p0, v2}, Lco/vine/android/ConversationFragment;->toggleNewMessageBar(Z)V

    .line 959
    iput v2, p0, Lco/vine/android/ConversationFragment;->mLocalUnreadCount:I

    goto :goto_0

    .line 941
    nop

    :sswitch_data_0
    .sparse-switch
        0x7f0a0098 -> :sswitch_1
        0x7f0a009b -> :sswitch_0
        0x7f0a00ab -> :sswitch_3
        0x7f0a00b0 -> :sswitch_2
    .end sparse-switch
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 12
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    const/4 v11, 0x0

    .line 170
    invoke-super {p0, p1}, Lco/vine/android/BaseCursorListFragment;->onCreate(Landroid/os/Bundle;)V

    .line 172
    if-eqz p1, :cond_0

    .line 173
    const-string v8, "fetched"

    invoke-virtual {p1, v8}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v8

    if-eqz v8, :cond_0

    .line 174
    const-string v8, "fetched"

    invoke-virtual {p1, v8}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v8

    iput-boolean v8, p0, Lco/vine/android/ConversationFragment;->mFetched:Z

    .line 178
    :cond_0
    invoke-virtual {p0}, Lco/vine/android/ConversationFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v8

    check-cast v8, Lco/vine/android/BaseActionBarActivity;

    invoke-virtual {v8}, Lco/vine/android/BaseActionBarActivity;->getSlidingMenu()Lcom/jeremyfeinstein/slidingmenu/lib/SlidingMenu;

    move-result-object v5

    .line 179
    .local v5, "m":Lcom/jeremyfeinstein/slidingmenu/lib/SlidingMenu;
    if-eqz v5, :cond_1

    .line 180
    invoke-virtual {v5, v11}, Lcom/jeremyfeinstein/slidingmenu/lib/SlidingMenu;->setTouchModeAbove(I)V

    .line 183
    :cond_1
    invoke-virtual {p0}, Lco/vine/android/ConversationFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    .line 184
    .local v0, "args":Landroid/os/Bundle;
    const-string v8, "conversation_row_id"

    const-wide/16 v9, -0x1

    invoke-virtual {v0, v8, v9, v10}, Landroid/os/Bundle;->getLong(Ljava/lang/String;J)J

    move-result-wide v8

    iput-wide v8, p0, Lco/vine/android/ConversationFragment;->mConversationRowId:J

    .line 185
    const-string v8, "am_following_recipient"

    invoke-virtual {v0, v8}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v8

    iput-boolean v8, p0, Lco/vine/android/ConversationFragment;->mAmFollowing:Z

    .line 187
    const/4 v8, 0x1

    invoke-virtual {p0, v8}, Lco/vine/android/ConversationFragment;->setHasOptionsMenu(Z)V

    .line 189
    const-string v8, "arg_encoder_version"

    invoke-virtual {v0, v8}, Landroid/os/Bundle;->getSerializable(Ljava/lang/String;)Ljava/io/Serializable;

    move-result-object v8

    check-cast v8, Lco/vine/android/recorder/RecordSessionVersion;

    iput-object v8, p0, Lco/vine/android/ConversationFragment;->mVersion:Lco/vine/android/recorder/RecordSessionVersion;

    .line 190
    iget-object v8, p0, Lco/vine/android/ConversationFragment;->mVersion:Lco/vine/android/recorder/RecordSessionVersion;

    if-nez v8, :cond_2

    .line 191
    invoke-virtual {p0}, Lco/vine/android/ConversationFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v8

    invoke-static {v8}, Lco/vine/android/recorder/RecordSessionManager;->getCurrentVersion(Landroid/content/Context;)Lco/vine/android/recorder/RecordSessionVersion;

    move-result-object v8

    iput-object v8, p0, Lco/vine/android/ConversationFragment;->mVersion:Lco/vine/android/recorder/RecordSessionVersion;

    .line 194
    :cond_2
    new-instance v8, Lco/vine/android/ConversationFragment$UploadProgressHandler;

    const/4 v9, 0x0

    invoke-direct {v8, p0, v9}, Lco/vine/android/ConversationFragment$UploadProgressHandler;-><init>(Lco/vine/android/ConversationFragment;Lco/vine/android/ConversationFragment$1;)V

    iput-object v8, p0, Lco/vine/android/ConversationFragment;->mIncomingHandler:Landroid/os/Handler;

    .line 195
    iput-boolean v11, p0, Lco/vine/android/ConversationFragment;->mBound:Z

    .line 196
    new-instance v8, Lco/vine/android/ConversationFragment$2;

    invoke-direct {v8, p0}, Lco/vine/android/ConversationFragment$2;-><init>(Lco/vine/android/ConversationFragment;)V

    iput-object v8, p0, Lco/vine/android/ConversationFragment;->mConnection:Landroid/content/ServiceConnection;

    .line 216
    iget-object v8, p0, Lco/vine/android/ConversationFragment;->mColorMap:Landroid/support/v4/util/LongSparseArray;

    if-nez v8, :cond_3

    .line 217
    new-instance v8, Landroid/support/v4/util/LongSparseArray;

    invoke-direct {v8}, Landroid/support/v4/util/LongSparseArray;-><init>()V

    iput-object v8, p0, Lco/vine/android/ConversationFragment;->mColorMap:Landroid/support/v4/util/LongSparseArray;

    .line 220
    :cond_3
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v6

    .line 222
    .local v6, "start":J
    invoke-virtual {p0}, Lco/vine/android/ConversationFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v8

    invoke-virtual {v8}, Landroid/support/v4/app/FragmentActivity;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v8

    iput-object v8, p0, Lco/vine/android/ConversationFragment;->mContentResolver:Landroid/content/ContentResolver;

    .line 224
    iget-object v8, p0, Lco/vine/android/ConversationFragment;->mContentResolver:Landroid/content/ContentResolver;

    iget-wide v9, p0, Lco/vine/android/ConversationFragment;->mConversationRowId:J

    invoke-static {v8, v9, v10}, Lco/vine/android/provider/VineProviderHelper;->queryConversationRecipientsUsersView(Landroid/content/ContentResolver;J)Landroid/database/Cursor;

    move-result-object v2

    .line 226
    .local v2, "cursor":Landroid/database/Cursor;
    if-eqz v2, :cond_8

    .line 227
    :goto_0
    invoke-interface {v2}, Landroid/database/Cursor;->moveToNext()Z

    move-result v8

    if-eqz v8, :cond_7

    .line 228
    const/4 v8, 0x6

    invoke-interface {v2, v8}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v3

    .line 230
    .local v3, "id":J
    const/4 v8, 0x7

    invoke-interface {v2, v8}, Landroid/database/Cursor;->getInt(I)I

    move-result v1

    .line 232
    .local v1, "color":I
    sget v8, Lco/vine/android/Settings;->DEFAULT_PROFILE_COLOR:I

    if-eq v1, v8, :cond_4

    if-gtz v1, :cond_5

    .line 233
    :cond_4
    const v8, 0xffffff

    invoke-virtual {p0}, Lco/vine/android/ConversationFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v9

    const v10, 0x7f090096

    invoke-virtual {v9, v10}, Landroid/content/res/Resources;->getColor(I)I

    move-result v9

    and-int v1, v8, v9

    .line 236
    :cond_5
    const/high16 v8, -0x1000000

    or-int/2addr v1, v8

    .line 239
    iget v8, p0, Lco/vine/android/ConversationFragment;->mRecipientColor:I

    if-nez v8, :cond_6

    .line 240
    iput v1, p0, Lco/vine/android/ConversationFragment;->mRecipientColor:I

    .line 243
    :cond_6
    iget-object v8, p0, Lco/vine/android/ConversationFragment;->mColorMap:Landroid/support/v4/util/LongSparseArray;

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v9

    invoke-virtual {v8, v3, v4, v9}, Landroid/support/v4/util/LongSparseArray;->put(JLjava/lang/Object;)V

    .line 244
    const/4 v8, 0x3

    invoke-interface {v2, v8}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v8

    iput-object v8, p0, Lco/vine/android/ConversationFragment;->mRecipientUsername:Ljava/lang/String;

    goto :goto_0

    .line 246
    .end local v1    # "color":I
    .end local v3    # "id":J
    :cond_7
    invoke-interface {v2}, Landroid/database/Cursor;->close()V

    .line 249
    :cond_8
    invoke-virtual {p0}, Lco/vine/android/ConversationFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v8

    check-cast v8, Lco/vine/android/ConversationActivity;

    iget-object v9, p0, Lco/vine/android/ConversationFragment;->mRecipientUsername:Ljava/lang/String;

    invoke-virtual {v8, v9}, Lco/vine/android/ConversationActivity;->setRecipientUsername(Ljava/lang/String;)V

    .line 251
    const-string v8, "onCreate queries took {}ms."

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v9

    sub-long/2addr v9, v6

    invoke-static {v9, v10}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v9

    invoke-static {v8, v9}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;)V

    .line 252
    iput v11, p0, Lco/vine/android/ConversationFragment;->mLocalUnreadCount:I

    .line 253
    return-void
.end method

.method public onCreateLoader(ILandroid/os/Bundle;)Landroid/support/v4/content/Loader;
    .locals 8
    .param p1, "id"    # I
    .param p2, "args"    # Landroid/os/Bundle;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I",
            "Landroid/os/Bundle;",
            ")",
            "Landroid/support/v4/content/Loader",
            "<",
            "Landroid/database/Cursor;",
            ">;"
        }
    .end annotation

    .prologue
    const/4 v4, 0x0

    .line 795
    iget-wide v0, p0, Lco/vine/android/ConversationFragment;->mConversationRowId:J

    invoke-static {v0, v1}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v7

    .line 799
    .local v7, "conversationId":Ljava/lang/String;
    sget-object v0, Lco/vine/android/provider/Vine$ConversationMessageUsersView;->CONTENT_URI_CONVERSATION:Landroid/net/Uri;

    invoke-virtual {v0}, Landroid/net/Uri;->buildUpon()Landroid/net/Uri$Builder;

    move-result-object v0

    const-string v1, "conversation_row_id"

    invoke-virtual {v0, v1, v7}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    move-result-object v0

    invoke-virtual {v0}, Landroid/net/Uri$Builder;->build()Landroid/net/Uri;

    move-result-object v2

    .line 802
    .local v2, "contentUri":Landroid/net/Uri;
    new-instance v0, Landroid/support/v4/content/CursorLoader;

    invoke-virtual {p0}, Lco/vine/android/ConversationFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    sget-object v3, Lco/vine/android/provider/VineDatabaseSQL$ConversationMessageUsersQuery;->PROJECTION:[Ljava/lang/String;

    const-string v6, "message_id ASC"

    move-object v5, v4

    invoke-direct/range {v0 .. v6}, Landroid/support/v4/content/CursorLoader;-><init>(Landroid/content/Context;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)V

    return-object v0
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 4
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 271
    const v2, 0x7f03002a

    invoke-virtual {p0, p1, v2, p2}, Lco/vine/android/ConversationFragment;->createView(Landroid/view/LayoutInflater;ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v1

    .line 272
    .local v1, "v":Landroid/view/View;
    const v2, 0x7f0a0083

    invoke-virtual {v1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lco/vine/android/widget/TypefacesEditText;

    .line 273
    .local v0, "edit":Lco/vine/android/widget/TypefacesEditText;
    invoke-virtual {v0, p0}, Lco/vine/android/widget/TypefacesEditText;->setOnEditorActionListener(Landroid/widget/TextView$OnEditorActionListener;)V

    .line 274
    invoke-virtual {v0, p0}, Lco/vine/android/widget/TypefacesEditText;->addTextChangedListener(Landroid/text/TextWatcher;)V

    .line 275
    invoke-virtual {v0, p0}, Lco/vine/android/widget/TypefacesEditText;->setKeyboardListener(Lco/vine/android/widget/TypefacesEditText$KeyboardListener;)V

    .line 276
    iput-object v0, p0, Lco/vine/android/ConversationFragment;->mEdit:Lco/vine/android/widget/TypefacesEditText;

    .line 277
    const v2, 0x7f0a0099

    invoke-virtual {v1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/RelativeLayout;

    iput-object v2, p0, Lco/vine/android/ConversationFragment;->mTextInputContainer:Landroid/widget/RelativeLayout;

    .line 278
    const v2, 0x7f0a0098

    invoke-virtual {v1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    iput-object v2, p0, Lco/vine/android/ConversationFragment;->mTextInputToggle:Landroid/view/View;

    .line 279
    iget-object v2, p0, Lco/vine/android/ConversationFragment;->mTextInputToggle:Landroid/view/View;

    invoke-virtual {v2, p0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 280
    const v2, 0x7f0a00ab

    invoke-virtual {v1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    iput-object v2, p0, Lco/vine/android/ConversationFragment;->mNewMessageBarContainer:Landroid/view/View;

    .line 281
    iget-object v2, p0, Lco/vine/android/ConversationFragment;->mNewMessageBarContainer:Landroid/view/View;

    invoke-virtual {v2, p0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 282
    iget-object v2, p0, Lco/vine/android/ConversationFragment;->mNewMessageBarContainer:Landroid/view/View;

    const v3, 0x7f0a00ac

    invoke-virtual {v2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/TextView;

    iput-object v2, p0, Lco/vine/android/ConversationFragment;->mNewMessageBarText:Landroid/widget/TextView;

    .line 283
    const v2, 0x7f0a00aa

    invoke-virtual {v1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/ImageView;

    iput-object v2, p0, Lco/vine/android/ConversationFragment;->mRecordButton:Landroid/widget/ImageView;

    .line 284
    const v2, 0x7f0a009b

    invoke-virtual {v1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/ImageView;

    iput-object v2, p0, Lco/vine/android/ConversationFragment;->mSendButton:Landroid/widget/ImageView;

    .line 285
    return-object v1
.end method

.method public onDestroy()V
    .locals 1

    .prologue
    .line 829
    invoke-super {p0}, Lco/vine/android/BaseCursorListFragment;->onDestroy()V

    .line 830
    iget-object v0, p0, Lco/vine/android/ConversationFragment;->mRecorderManager:Lco/vine/android/InlineRecorderManager;

    if-eqz v0, :cond_0

    .line 831
    iget-object v0, p0, Lco/vine/android/ConversationFragment;->mRecorderManager:Lco/vine/android/InlineRecorderManager;

    invoke-virtual {v0}, Lco/vine/android/InlineRecorderManager;->release()V

    .line 833
    :cond_0
    return-void
.end method

.method public onEditorAction(Landroid/widget/TextView;ILandroid/view/KeyEvent;)Z
    .locals 1
    .param p1, "v"    # Landroid/widget/TextView;
    .param p2, "actionId"    # I
    .param p3, "event"    # Landroid/view/KeyEvent;

    .prologue
    .line 780
    invoke-virtual {p1}, Landroid/widget/TextView;->getId()I

    move-result v0

    packed-switch v0, :pswitch_data_0

    .line 788
    const/4 v0, 0x0

    :goto_0
    return v0

    .line 782
    :pswitch_0
    const/4 v0, 0x4

    if-ne p2, v0, :cond_0

    .line 783
    invoke-direct {p0}, Lco/vine/android/ConversationFragment;->sendTextMessage()V

    .line 785
    :cond_0
    const/4 v0, 0x1

    goto :goto_0

    .line 780
    nop

    :pswitch_data_0
    .packed-switch 0x7f0a0083
        :pswitch_0
    .end packed-switch
.end method

.method public onKeyboardDismissed()V
    .locals 3

    .prologue
    .line 488
    iget-object v0, p0, Lco/vine/android/ConversationFragment;->mCallback:Lco/vine/android/ConversationActivity;

    const/4 v1, 0x0

    iget-boolean v2, p0, Lco/vine/android/ConversationFragment;->mIsSending:Z

    invoke-virtual {v0, v1, v2}, Lco/vine/android/ConversationActivity;->onTypingStatusChanged(ZZ)V

    .line 489
    invoke-direct {p0}, Lco/vine/android/ConversationFragment;->hideTypingContainer()V

    .line 490
    return-void
.end method

.method public onLoadFinished(Landroid/support/v4/content/Loader;Landroid/database/Cursor;)V
    .locals 5
    .param p2, "cursor"    # Landroid/database/Cursor;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/support/v4/content/Loader",
            "<",
            "Landroid/database/Cursor;",
            ">;",
            "Landroid/database/Cursor;",
            ")V"
        }
    .end annotation

    .prologue
    .local p1, "loader":Landroid/support/v4/content/Loader;, "Landroid/support/v4/content/Loader<Landroid/database/Cursor;>;"
    const/4 v1, 0x3

    const/4 v2, 0x1

    const/4 v4, 0x0

    .line 837
    invoke-virtual {p1}, Landroid/support/v4/content/Loader;->getId()I

    move-result v0

    packed-switch v0, :pswitch_data_0

    .line 875
    :cond_0
    :goto_0
    return-void

    .line 839
    :pswitch_0
    invoke-direct {p0}, Lco/vine/android/ConversationFragment;->saveTopItemInfo()V

    .line 840
    invoke-super {p0, p1, p2}, Lco/vine/android/BaseCursorListFragment;->onLoadFinished(Landroid/support/v4/content/Loader;Landroid/database/Cursor;)V

    .line 841
    invoke-virtual {p0, v1}, Lco/vine/android/ConversationFragment;->hideProgress(I)V

    .line 842
    iget-boolean v0, p0, Lco/vine/android/ConversationFragment;->mFetched:Z

    if-nez v0, :cond_1

    .line 843
    invoke-direct {p0, v1}, Lco/vine/android/ConversationFragment;->fetchContent(I)V

    .line 844
    iput-boolean v2, p0, Lco/vine/android/ConversationFragment;->mFetchWasInitial:Z

    goto :goto_0

    .line 846
    :cond_1
    iget-object v0, p0, Lco/vine/android/ConversationFragment;->mCursorAdapter:Landroid/support/v4/widget/CursorAdapter;

    invoke-virtual {v0}, Landroid/support/v4/widget/CursorAdapter;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_3

    .line 847
    invoke-virtual {p0, v2, v4}, Lco/vine/android/ConversationFragment;->showSadface(ZZ)V

    .line 862
    :cond_2
    :goto_1
    iput-boolean v4, p0, Lco/vine/android/ConversationFragment;->mFetchWasInitial:Z

    .line 863
    iget-object v0, p0, Lco/vine/android/ConversationFragment;->mCursorAdapter:Landroid/support/v4/widget/CursorAdapter;

    check-cast v0, Lco/vine/android/ConversationAdapter;

    invoke-virtual {v0}, Lco/vine/android/ConversationAdapter;->atLastPage()Z

    move-result v0

    if-eqz v0, :cond_6

    .line 864
    iget-object v0, p0, Lco/vine/android/ConversationFragment;->mLoadMoreHeaderContent:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 868
    :goto_2
    iget-object v0, p0, Lco/vine/android/ConversationFragment;->mCursorAdapter:Landroid/support/v4/widget/CursorAdapter;

    invoke-virtual {v0}, Landroid/support/v4/widget/CursorAdapter;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_0

    .line 869
    iget-object v0, p0, Lco/vine/android/ConversationFragment;->mCursorAdapter:Landroid/support/v4/widget/CursorAdapter;

    check-cast v0, Lco/vine/android/ConversationAdapter;

    invoke-virtual {v0}, Lco/vine/android/ConversationAdapter;->playCurrentPosition()V

    goto :goto_0

    .line 849
    :cond_3
    invoke-virtual {p0, v4}, Lco/vine/android/ConversationFragment;->showSadface(Z)V

    .line 850
    iget-boolean v0, p0, Lco/vine/android/ConversationFragment;->mFetchWasLoadMore:Z

    if-eqz v0, :cond_4

    .line 851
    iput-boolean v4, p0, Lco/vine/android/ConversationFragment;->mFetchWasLoadMore:Z

    .line 852
    iget-object v0, p0, Lco/vine/android/ConversationFragment;->mLoadMoreHeaderContent:Landroid/view/View;

    invoke-virtual {v0, v4}, Landroid/view/View;->setVisibility(I)V

    .line 853
    invoke-virtual {p0, v1}, Lco/vine/android/ConversationFragment;->hideProgress(I)V

    .line 854
    iget-object v1, p0, Lco/vine/android/ConversationFragment;->mListView:Landroid/widget/ListView;

    iget-object v0, p0, Lco/vine/android/ConversationFragment;->mCursorAdapter:Landroid/support/v4/widget/CursorAdapter;

    check-cast v0, Lco/vine/android/ConversationAdapter;

    iget-wide v2, p0, Lco/vine/android/ConversationFragment;->mLastTopItemId:J

    invoke-virtual {v0, v2, v3}, Lco/vine/android/ConversationAdapter;->getPositionForId(J)I

    move-result v0

    iget-object v2, p0, Lco/vine/android/ConversationFragment;->mListView:Landroid/widget/ListView;

    invoke-virtual {v2}, Landroid/widget/ListView;->getHeaderViewsCount()I

    move-result v2

    add-int/2addr v0, v2

    iget v2, p0, Lco/vine/android/ConversationFragment;->mLastTopItemPixelOffset:I

    invoke-virtual {v1, v0, v2}, Landroid/widget/ListView;->setSelectionFromTop(II)V

    goto :goto_1

    .line 856
    :cond_4
    iget-boolean v0, p0, Lco/vine/android/ConversationFragment;->mFetchWasInitial:Z

    if-eqz v0, :cond_5

    .line 857
    invoke-direct {p0, v4, v4}, Lco/vine/android/ConversationFragment;->scrollToBottom(ZZ)V

    goto :goto_1

    .line 858
    :cond_5
    iget-object v0, p0, Lco/vine/android/ConversationFragment;->mListView:Landroid/widget/ListView;

    invoke-virtual {v0}, Landroid/widget/ListView;->getLastVisiblePosition()I

    move-result v0

    invoke-interface {p2}, Landroid/database/Cursor;->getCount()I

    move-result v1

    add-int/lit8 v1, v1, -0x1

    if-lt v0, v1, :cond_2

    .line 859
    invoke-direct {p0, v4, v2}, Lco/vine/android/ConversationFragment;->scrollToBottom(ZZ)V

    goto :goto_1

    .line 866
    :cond_6
    iget-object v0, p0, Lco/vine/android/ConversationFragment;->mLoadMoreHeaderContent:Landroid/view/View;

    invoke-virtual {v0, v4}, Landroid/view/View;->setVisibility(I)V

    goto :goto_2

    .line 837
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
    .end packed-switch
.end method

.method public bridge synthetic onLoadFinished(Landroid/support/v4/content/Loader;Ljava/lang/Object;)V
    .locals 0
    .param p1, "x0"    # Landroid/support/v4/content/Loader;
    .param p2, "x1"    # Ljava/lang/Object;

    .prologue
    .line 83
    check-cast p2, Landroid/database/Cursor;

    .end local p2    # "x1":Ljava/lang/Object;
    invoke-virtual {p0, p1, p2}, Lco/vine/android/ConversationFragment;->onLoadFinished(Landroid/support/v4/content/Loader;Landroid/database/Cursor;)V

    return-void
.end method

.method public onNewMessage()V
    .locals 8

    .prologue
    const/4 v7, 0x1

    .line 966
    iget-object v0, p0, Lco/vine/android/ConversationFragment;->mListView:Landroid/widget/ListView;

    invoke-virtual {v0}, Landroid/widget/ListView;->getLastVisiblePosition()I

    move-result v0

    iget-object v1, p0, Lco/vine/android/ConversationFragment;->mCursorAdapter:Landroid/support/v4/widget/CursorAdapter;

    invoke-virtual {v1}, Landroid/support/v4/widget/CursorAdapter;->getCount()I

    move-result v1

    if-ge v0, v1, :cond_0

    iget-object v0, p0, Lco/vine/android/ConversationFragment;->mTextInputContainer:Landroid/widget/RelativeLayout;

    invoke-virtual {v0}, Landroid/widget/RelativeLayout;->getVisibility()I

    move-result v0

    if-eqz v0, :cond_0

    .line 968
    iget v0, p0, Lco/vine/android/ConversationFragment;->mLocalUnreadCount:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lco/vine/android/ConversationFragment;->mLocalUnreadCount:I

    .line 969
    iget-object v0, p0, Lco/vine/android/ConversationFragment;->mNewMessageBarText:Landroid/widget/TextView;

    invoke-virtual {p0}, Lco/vine/android/ConversationFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const/high16 v2, 0x7f0d0000

    iget v3, p0, Lco/vine/android/ConversationFragment;->mLocalUnreadCount:I

    new-array v4, v7, [Ljava/lang/Object;

    const/4 v5, 0x0

    iget v6, p0, Lco/vine/android/ConversationFragment;->mLocalUnreadCount:I

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    aput-object v6, v4, v5

    invoke-virtual {v1, v2, v3, v4}, Landroid/content/res/Resources;->getQuantityString(II[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 971
    invoke-direct {p0, v7}, Lco/vine/android/ConversationFragment;->toggleNewMessageBar(Z)V

    .line 973
    :cond_0
    return-void
.end method

.method public onPause()V
    .locals 2

    .prologue
    .line 810
    invoke-super {p0}, Lco/vine/android/BaseCursorListFragment;->onPause()V

    .line 811
    iget-object v0, p0, Lco/vine/android/ConversationFragment;->mConversationAdapter:Lco/vine/android/ConversationAdapter;

    invoke-virtual {v0}, Lco/vine/android/ConversationAdapter;->onPause()V

    .line 812
    invoke-virtual {p0}, Lco/vine/android/ConversationFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    iget-object v1, p0, Lco/vine/android/ConversationFragment;->mMuteChangeReceiver:Landroid/content/BroadcastReceiver;

    invoke-virtual {v0, v1}, Landroid/support/v4/app/FragmentActivity;->unregisterReceiver(Landroid/content/BroadcastReceiver;)V

    .line 814
    iget-boolean v0, p0, Lco/vine/android/ConversationFragment;->mBound:Z

    if-eqz v0, :cond_0

    .line 815
    const-string v0, "ConversationFrag"

    const-string v1, "Will unbind from VineUploadService now"

    invoke-static {v0, v1}, Lcom/edisonwang/android/slog/SLog;->dWithTag(Ljava/lang/String;Ljava/lang/String;)V

    .line 817
    const/4 v0, 0x0

    const/4 v1, 0x2

    invoke-static {v0, v1}, Landroid/os/Message;->obtain(Landroid/os/Handler;I)Landroid/os/Message;

    move-result-object v0

    invoke-direct {p0, v0}, Lco/vine/android/ConversationFragment;->sendMessageToUploadService(Landroid/os/Message;)V

    .line 819
    invoke-virtual {p0}, Lco/vine/android/ConversationFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    iget-object v1, p0, Lco/vine/android/ConversationFragment;->mConnection:Landroid/content/ServiceConnection;

    invoke-virtual {v0, v1}, Landroid/support/v4/app/FragmentActivity;->unbindService(Landroid/content/ServiceConnection;)V

    .line 820
    const/4 v0, 0x0

    iput-boolean v0, p0, Lco/vine/android/ConversationFragment;->mBound:Z

    .line 822
    :cond_0
    iget-object v0, p0, Lco/vine/android/ConversationFragment;->mRecorderManager:Lco/vine/android/InlineRecorderManager;

    if-eqz v0, :cond_1

    .line 823
    iget-object v0, p0, Lco/vine/android/ConversationFragment;->mRecorderManager:Lco/vine/android/InlineRecorderManager;

    invoke-virtual {v0}, Lco/vine/android/InlineRecorderManager;->onPaused()V

    .line 825
    :cond_1
    return-void
.end method

.method public onRecorderHidden()V
    .locals 2

    .prologue
    .line 482
    iget-object v0, p0, Lco/vine/android/ConversationFragment;->mTextInputToggle:Landroid/view/View;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 483
    iget-object v0, p0, Lco/vine/android/ConversationFragment;->mCursorAdapter:Landroid/support/v4/widget/CursorAdapter;

    check-cast v0, Lco/vine/android/ConversationAdapter;

    invoke-virtual {v0}, Lco/vine/android/ConversationAdapter;->playCurrentPosition()V

    .line 484
    return-void
.end method

.method public onRecorderShown()V
    .locals 2

    .prologue
    .line 477
    iget-object v0, p0, Lco/vine/android/ConversationFragment;->mTextInputToggle:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 478
    iget-object v0, p0, Lco/vine/android/ConversationFragment;->mCursorAdapter:Landroid/support/v4/widget/CursorAdapter;

    check-cast v0, Lco/vine/android/ConversationAdapter;

    invoke-virtual {v0}, Lco/vine/android/ConversationAdapter;->stopCurrentPlayer()V

    .line 479
    return-void
.end method

.method public onResume()V
    .locals 10

    .prologue
    const/16 v9, 0x8

    const/4 v8, 0x0

    .line 405
    invoke-super {p0}, Lco/vine/android/BaseCursorListFragment;->onResume()V

    .line 407
    invoke-virtual {p0}, Lco/vine/android/ConversationFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    const v5, 0x7f0200f5

    invoke-virtual {v4, v5}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v1

    check-cast v1, Landroid/graphics/drawable/GradientDrawable;

    .line 408
    .local v1, "dr":Landroid/graphics/drawable/GradientDrawable;
    const/high16 v4, -0x1000000

    iget v5, p0, Lco/vine/android/ConversationFragment;->mMyColor:I

    or-int/2addr v4, v5

    invoke-virtual {v1, v4}, Landroid/graphics/drawable/GradientDrawable;->setColor(I)V

    .line 410
    invoke-virtual {p0}, Lco/vine/android/ConversationFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lco/vine/android/ConversationActivity;

    .line 412
    .local v0, "activity":Lco/vine/android/ConversationActivity;
    iget-boolean v4, v0, Lco/vine/android/ConversationActivity;->keyBoardUpOnStart:Z

    if-eqz v4, :cond_0

    .line 413
    iput-boolean v8, v0, Lco/vine/android/ConversationActivity;->keyBoardUpOnStart:Z

    .line 414
    iget-object v4, p0, Lco/vine/android/ConversationFragment;->mHandler:Landroid/os/Handler;

    new-instance v5, Lco/vine/android/ConversationFragment$3;

    invoke-direct {v5, p0}, Lco/vine/android/ConversationFragment$3;-><init>(Lco/vine/android/ConversationFragment;)V

    invoke-virtual {v4, v5}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 422
    :cond_0
    iget-object v4, p0, Lco/vine/android/ConversationFragment;->mConversationAdapter:Lco/vine/android/ConversationAdapter;

    invoke-virtual {v4}, Lco/vine/android/ConversationAdapter;->onResume()V

    .line 423
    iget-object v4, p0, Lco/vine/android/ConversationFragment;->mMuteChangeReceiver:Landroid/content/BroadcastReceiver;

    sget-object v5, Lco/vine/android/util/MuteUtil;->MUTE_INTENT_FILTER:Landroid/content/IntentFilter;

    const-string v6, "co.vine.android.BROADCAST"

    const/4 v7, 0x0

    invoke-virtual {v0, v4, v5, v6, v7}, Lco/vine/android/ConversationActivity;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;Ljava/lang/String;Landroid/os/Handler;)Landroid/content/Intent;

    .line 424
    iget-object v4, p0, Lco/vine/android/ConversationFragment;->mCursorAdapter:Landroid/support/v4/widget/CursorAdapter;

    invoke-virtual {v4}, Landroid/support/v4/widget/CursorAdapter;->getCursor()Landroid/database/Cursor;

    move-result-object v4

    if-nez v4, :cond_1

    .line 425
    invoke-virtual {p0}, Lco/vine/android/ConversationFragment;->initLoader()V

    .line 428
    :cond_1
    iget-boolean v4, p0, Lco/vine/android/ConversationFragment;->mBound:Z

    if-nez v4, :cond_2

    .line 429
    const-string v4, "ConversationFrag"

    const-string v5, "Will bind to VineUploadService now"

    invoke-static {v4, v5}, Lcom/edisonwang/android/slog/SLog;->dWithTag(Ljava/lang/String;Ljava/lang/String;)V

    .line 430
    new-instance v3, Landroid/content/Intent;

    const-class v4, Lco/vine/android/service/VineUploadService;

    invoke-direct {v3, v0, v4}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 431
    .local v3, "intent":Landroid/content/Intent;
    iget-object v4, p0, Lco/vine/android/ConversationFragment;->mConnection:Landroid/content/ServiceConnection;

    const/4 v5, 0x1

    invoke-virtual {v0, v3, v4, v5}, Lco/vine/android/ConversationActivity;->bindService(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z

    .line 434
    .end local v3    # "intent":Landroid/content/Intent;
    :cond_2
    iget-object v4, p0, Lco/vine/android/ConversationFragment;->mUploadProgressContainer:Landroid/view/ViewGroup;

    invoke-virtual {v4, v9}, Landroid/view/ViewGroup;->setVisibility(I)V

    .line 435
    iget-object v4, p0, Lco/vine/android/ConversationFragment;->mChatPresenceContainer:Landroid/view/ViewGroup;

    invoke-virtual {v4, v9}, Landroid/view/ViewGroup;->setVisibility(I)V

    .line 437
    iget-object v4, p0, Lco/vine/android/ConversationFragment;->mRecorderManager:Lco/vine/android/InlineRecorderManager;

    if-eqz v4, :cond_3

    .line 439
    :try_start_0
    iget-object v4, p0, Lco/vine/android/ConversationFragment;->mRecorderManager:Lco/vine/android/InlineRecorderManager;

    invoke-virtual {v4}, Lco/vine/android/InlineRecorderManager;->onResume()V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 446
    :cond_3
    :goto_0
    return-void

    .line 440
    :catch_0
    move-exception v2

    .line 441
    .local v2, "e":Ljava/io/IOException;
    iput-boolean v8, p0, Lco/vine/android/ConversationFragment;->mRecordingEnabled:Z

    .line 442
    const-string v4, "Failed to create folder."

    invoke-static {v4}, Lco/vine/android/util/CrashUtil;->log(Ljava/lang/String;)V

    .line 443
    invoke-virtual {p0}, Lco/vine/android/ConversationFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v4

    const v5, 0x7f0e00dd

    invoke-static {v4, v5}, Lco/vine/android/util/Util;->showCenteredToast(Landroid/content/Context;I)V

    goto :goto_0
.end method

.method public onSaveInstanceState(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "outState"    # Landroid/os/Bundle;

    .prologue
    .line 264
    invoke-super {p0, p1}, Lco/vine/android/BaseCursorListFragment;->onSaveInstanceState(Landroid/os/Bundle;)V

    .line 265
    const-string v0, "fetched"

    iget-boolean v1, p0, Lco/vine/android/ConversationFragment;->mFetched:Z

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 266
    return-void
.end method

.method protected onScrollLastItem(Landroid/database/Cursor;)V
    .locals 1
    .param p1, "cursor"    # Landroid/database/Cursor;

    .prologue
    const/4 v0, 0x0

    .line 977
    iput v0, p0, Lco/vine/android/ConversationFragment;->mLocalUnreadCount:I

    .line 978
    invoke-direct {p0, v0}, Lco/vine/android/ConversationFragment;->toggleNewMessageBar(Z)V

    .line 979
    return-void
.end method

.method public onScrollStateChanged(Landroid/widget/AbsListView;I)V
    .locals 1
    .param p1, "view"    # Landroid/widget/AbsListView;
    .param p2, "scrollState"    # I

    .prologue
    .line 397
    invoke-super {p0, p1, p2}, Lco/vine/android/BaseCursorListFragment;->onScrollStateChanged(Landroid/widget/AbsListView;I)V

    .line 398
    iget-object v0, p0, Lco/vine/android/ConversationFragment;->mCursorAdapter:Landroid/support/v4/widget/CursorAdapter;

    if-eqz v0, :cond_0

    if-nez p2, :cond_0

    .line 399
    iget-object v0, p0, Lco/vine/android/ConversationFragment;->mCursorAdapter:Landroid/support/v4/widget/CursorAdapter;

    check-cast v0, Lco/vine/android/ConversationAdapter;

    invoke-virtual {v0}, Lco/vine/android/ConversationAdapter;->playCurrentPosition()V

    .line 401
    :cond_0
    return-void
.end method

.method public onTextChanged(Ljava/lang/CharSequence;III)V
    .locals 2
    .param p1, "s"    # Ljava/lang/CharSequence;
    .param p2, "start"    # I
    .param p3, "before"    # I
    .param p4, "count"    # I

    .prologue
    .line 750
    iget-object v0, p0, Lco/vine/android/ConversationFragment;->mEdit:Lco/vine/android/widget/TypefacesEditText;

    invoke-virtual {v0}, Lco/vine/android/widget/TypefacesEditText;->getText()Landroid/text/Editable;

    move-result-object v0

    invoke-interface {v0}, Landroid/text/Editable;->length()I

    move-result v0

    if-nez v0, :cond_0

    .line 751
    iget-object v0, p0, Lco/vine/android/ConversationFragment;->mSendButton:Landroid/widget/ImageView;

    const v1, 0x7f020204

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 752
    iget-object v0, p0, Lco/vine/android/ConversationFragment;->mSendButton:Landroid/widget/ImageView;

    iget-object v1, p0, Lco/vine/android/ConversationFragment;->mLaunchRecorderListener:Landroid/view/View$OnClickListener;

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 757
    :goto_0
    return-void

    .line 754
    :cond_0
    iget-object v0, p0, Lco/vine/android/ConversationFragment;->mSendButton:Landroid/widget/ImageView;

    const v1, 0x7f020137

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 755
    iget-object v0, p0, Lco/vine/android/ConversationFragment;->mSendButton:Landroid/widget/ImageView;

    invoke-virtual {v0, p0}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    goto :goto_0
.end method

.method protected prepareUpload()V
    .locals 10

    .prologue
    .line 381
    iget-object v0, p0, Lco/vine/android/ConversationFragment;->mRecorderManager:Lco/vine/android/InlineRecorderManager;

    invoke-virtual {v0}, Lco/vine/android/InlineRecorderManager;->getRecorder()Lco/vine/android/recorder/InlineVineRecorder;

    move-result-object v8

    .line 382
    .local v8, "recorder":Lco/vine/android/recorder/InlineVineRecorder;
    if-eqz v8, :cond_0

    iget-object v0, v8, Lco/vine/android/recorder/InlineVineRecorder;->finalFile:Lco/vine/android/recorder/RecordingFile;

    if-eqz v0, :cond_0

    .line 384
    :try_start_0
    invoke-virtual {p0}, Lco/vine/android/ConversationFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    iget-object v1, v8, Lco/vine/android/recorder/InlineVineRecorder;->finalFile:Lco/vine/android/recorder/RecordingFile;

    iget-object v2, v8, Lco/vine/android/recorder/InlineVineRecorder;->finalFile:Lco/vine/android/recorder/RecordingFile;

    invoke-virtual {v2}, Lco/vine/android/recorder/RecordingFile;->getThumbnailPath()Ljava/lang/String;

    move-result-object v2

    iget-object v3, v8, Lco/vine/android/recorder/InlineVineRecorder;->finalFile:Lco/vine/android/recorder/RecordingFile;

    iget-object v3, v3, Lco/vine/android/recorder/RecordingFile;->folder:Ljava/io/File;

    invoke-virtual {v3}, Ljava/io/File;->getName()Ljava/lang/String;

    move-result-object v3

    const/4 v4, 0x1

    iget-wide v5, p0, Lco/vine/android/ConversationFragment;->mConversationRowId:J

    invoke-static/range {v0 .. v6}, Lco/vine/android/util/UploadManager;->addToUploadQueue(Landroid/content/Context;Lco/vine/android/recorder/RecordingFile;Ljava/lang/String;Ljava/lang/String;ZJ)Ljava/lang/String;

    move-result-object v9

    .line 387
    .local v9, "uploadPath":Ljava/lang/String;
    invoke-direct {p0, v9}, Lco/vine/android/ConversationFragment;->sendMessage(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 393
    .end local v9    # "uploadPath":Ljava/lang/String;
    :cond_0
    :goto_0
    return-void

    .line 388
    :catch_0
    move-exception v7

    .line 390
    .local v7, "e":Ljava/lang/Exception;
    invoke-virtual {v7}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_0
.end method

.method public sendKeyEvent(Landroid/view/KeyEvent;)Z
    .locals 1
    .param p1, "event"    # Landroid/view/KeyEvent;

    .prologue
    .line 494
    const/4 v0, 0x0

    return v0
.end method

.method public showProgress(I)V
    .locals 2
    .param p1, "type"    # I

    .prologue
    .line 659
    packed-switch p1, :pswitch_data_0

    .line 665
    :goto_0
    return-void

    .line 661
    :pswitch_0
    iget-object v0, p0, Lco/vine/android/ConversationFragment;->mLoadMoreHeaderContent:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 662
    iget-object v0, p0, Lco/vine/android/ConversationFragment;->mLoadMoreProgress:Landroid/view/View;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    goto :goto_0

    .line 659
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
    .end packed-switch
.end method

.method public showTypingIndicator(ZJ)V
    .locals 10
    .param p1, "show"    # Z
    .param p2, "userId"    # J

    .prologue
    const/4 v9, 0x0

    .line 673
    iget-object v2, p0, Lco/vine/android/ConversationFragment;->mChatPresenceContainer:Landroid/view/ViewGroup;

    .line 674
    .local v2, "container":Landroid/view/ViewGroup;
    invoke-virtual {v2}, Landroid/view/ViewGroup;->clearAnimation()V

    .line 676
    if-eqz p1, :cond_2

    .line 677
    iget-object v3, p0, Lco/vine/android/ConversationFragment;->mChatPresenceEllipsis:Landroid/widget/ImageView;

    .line 678
    .local v3, "ellipsis":Landroid/widget/ImageView;
    iget-object v6, p0, Lco/vine/android/ConversationFragment;->mCursorAdapter:Landroid/support/v4/widget/CursorAdapter;

    check-cast v6, Lco/vine/android/ConversationAdapter;

    invoke-virtual {v6}, Lco/vine/android/ConversationAdapter;->getIdAtLastPosition()J

    move-result-wide v4

    .line 679
    .local v4, "lastUserId":J
    const/4 v1, 0x0

    .line 680
    .local v1, "color":Ljava/lang/Integer;
    iget-object v6, p0, Lco/vine/android/ConversationFragment;->mColorMap:Landroid/support/v4/util/LongSparseArray;

    if-eqz v6, :cond_0

    .line 681
    iget-object v6, p0, Lco/vine/android/ConversationFragment;->mColorMap:Landroid/support/v4/util/LongSparseArray;

    invoke-virtual {v6, p2, p3}, Landroid/support/v4/util/LongSparseArray;->get(J)Ljava/lang/Object;

    move-result-object v1

    .end local v1    # "color":Ljava/lang/Integer;
    check-cast v1, Ljava/lang/Integer;

    .line 684
    .restart local v1    # "color":Ljava/lang/Integer;
    :cond_0
    if-nez v1, :cond_1

    .line 685
    iget v6, p0, Lco/vine/android/ConversationFragment;->mRecipientColor:I

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    .line 688
    :cond_1
    invoke-virtual {v2, v9}, Landroid/view/ViewGroup;->setVisibility(I)V

    .line 689
    invoke-virtual {v2}, Landroid/view/ViewGroup;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v6

    invoke-virtual {p0}, Lco/vine/android/ConversationFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v7

    const v8, 0x7f0b001e

    invoke-virtual {v7, v8}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v7

    iput v7, v6, Landroid/view/ViewGroup$LayoutParams;->height:I

    .line 692
    const/high16 v6, 0x5a000000

    invoke-virtual {v1}, Ljava/lang/Integer;->intValue()I

    move-result v7

    const v8, 0xffffff

    and-int/2addr v7, v8

    or-int/2addr v6, v7

    invoke-virtual {v3, v6}, Landroid/widget/ImageView;->setColorFilter(I)V

    .line 694
    const/4 v6, 0x1

    invoke-direct {p0, v6, v9}, Lco/vine/android/ConversationFragment;->scrollToBottom(ZZ)V

    .line 704
    .end local v1    # "color":Ljava/lang/Integer;
    .end local v3    # "ellipsis":Landroid/widget/ImageView;
    .end local v4    # "lastUserId":J
    :goto_0
    return-void

    .line 696
    :cond_2
    new-instance v0, Lco/vine/android/ConversationFragment$HeightAnimation;

    new-instance v6, Lco/vine/android/ConversationFragment$5;

    invoke-direct {v6, p0, v2}, Lco/vine/android/ConversationFragment$5;-><init>(Lco/vine/android/ConversationFragment;Landroid/view/ViewGroup;)V

    invoke-direct {v0, p0, v2, v6}, Lco/vine/android/ConversationFragment$HeightAnimation;-><init>(Lco/vine/android/ConversationFragment;Landroid/view/View;Ljava/lang/Runnable;)V

    .line 702
    .local v0, "collapse":Lco/vine/android/ConversationFragment$HeightAnimation;
    invoke-virtual {v2, v0}, Landroid/view/ViewGroup;->startAnimation(Landroid/view/animation/Animation;)V

    goto :goto_0
.end method

.method public startPostOptionsActivity(Landroid/content/Intent;)V
    .locals 1
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    .line 502
    const/4 v0, 0x2

    invoke-virtual {p0, p1, v0}, Lco/vine/android/ConversationFragment;->startActivityForResult(Landroid/content/Intent;I)V

    .line 503
    return-void
.end method

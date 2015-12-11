.class public Lco/vine/android/InboxFragment;
.super Lco/vine/android/BaseCursorListFragment;
.source "InboxFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;
.implements Lcom/jeremyfeinstein/slidingmenu/lib/SlidingMenu$OnOpenedListener;
.implements Lcom/jeremyfeinstein/slidingmenu/lib/SlidingMenu$OnClosedListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lco/vine/android/InboxFragment$ConversationMenuSessionListener;,
        Lco/vine/android/InboxFragment$SortMenuContactsTask;,
        Lco/vine/android/InboxFragment$TabSwicher;
    }
.end annotation


# static fields
.field protected static final FETCH_FLAG_BOTH:I = 0x3

.field protected static final FETCH_FLAG_FRIENDS:I = 0x2

.field protected static final FETCH_FLAG_INBOX:I = 0x1

.field protected static final FETCH_FLAG_OTHERS:I = 0x4

.field protected static final LOADER_ID_CONTACTS:I = 0x3

.field protected static final LOADER_ID_FRIENDS:I = 0x2

.field protected static final LOADER_ID_INBOX:I = 0x1

.field protected static final LOADER_ID_OTHERS:I = 0x4

.field protected static final VIEW_TYPE_CONTACTS:I = 0x3

.field protected static final VIEW_TYPE_FRIENDS:I = 0x2

.field protected static final VIEW_TYPE_MESSAGES:I = 0x1


# instance fields
.field private mActiveAdapter:Landroid/widget/BaseAdapter;

.field private mAddressAdapter:Lco/vine/android/widget/ContactsMenuAdapter;

.field private mAddressCursor:Landroid/database/Cursor;

.field private mAnchorManager:Lco/vine/android/util/StringAnchorManager;

.field private mColor:I

.field private final mColorChangedReceiver:Landroid/content/BroadcastReceiver;

.field private mContactEntries:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lco/vine/android/ContactEntry;",
            ">;"
        }
    .end annotation
.end field

.field private mContactEntryMap:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/Long;",
            "Lco/vine/android/ContactEntry;",
            ">;"
        }
    .end annotation
.end field

.field private mCurrentLastId:J

.field private mDummyAdapter:Lco/vine/android/MessageBoxAdapter;

.field private mEmptyImage:Landroid/widget/ImageView;

.field private mEmptyTitle:Landroid/widget/TextView;

.field private mEmptyView:Landroid/view/View;

.field private mEmptyWords:Landroid/widget/TextView;

.field protected mFetchFlags:I

.field private mFriendsAdapter:Lco/vine/android/MenuUsersAdapter;

.field private mFriendsText:Landroid/widget/TextView;

.field protected mInboxAdapter:Lco/vine/android/MessageBoxAdapter;

.field private mInboxCursorCount:I

.field private final mInvalidateContactEntryRunnable:Ljava/lang/Runnable;

.field private final mInvalidateEmptyViewRunnable:Ljava/lang/Runnable;

.field private mIsAddressBookShowing:Z

.field private mIsEmptyViewAdded:Z

.field private mIsSwitching:Z

.field private final mListener:Lco/vine/android/OnContactEntryClickedListener;

.field private mLoadingMore:Z

.field protected mMessageCount:J

.field private mOtherAdapter:Lco/vine/android/MessageBoxAdapter;

.field private mOthersCursorCount:I

.field private mOthersText:Landroid/widget/TextView;

.field private mSectionAdapter:Lco/vine/android/widget/SectionAdapter;

.field private mSortMenuTask:Lco/vine/android/InboxFragment$SortMenuContactsTask;

.field private mTypefaces:Lco/vine/android/widget/Typefaces;

.field private mUnReadCount:I

.field protected mWaitingToStartId:J


# direct methods
.method public constructor <init>()V
    .locals 2

    .prologue
    .line 56
    invoke-direct {p0}, Lco/vine/android/BaseCursorListFragment;-><init>()V

    .line 60
    const-wide/16 v0, -0x1

    iput-wide v0, p0, Lco/vine/android/InboxFragment;->mWaitingToStartId:J

    .line 103
    const/4 v0, 0x0

    iput-boolean v0, p0, Lco/vine/android/InboxFragment;->mLoadingMore:Z

    .line 106
    new-instance v0, Lco/vine/android/InboxFragment$1;

    invoke-direct {v0, p0}, Lco/vine/android/InboxFragment$1;-><init>(Lco/vine/android/InboxFragment;)V

    iput-object v0, p0, Lco/vine/android/InboxFragment;->mColorChangedReceiver:Landroid/content/BroadcastReceiver;

    .line 188
    new-instance v0, Lco/vine/android/InboxFragment$2;

    invoke-direct {v0, p0}, Lco/vine/android/InboxFragment$2;-><init>(Lco/vine/android/InboxFragment;)V

    iput-object v0, p0, Lco/vine/android/InboxFragment;->mInvalidateEmptyViewRunnable:Ljava/lang/Runnable;

    .line 545
    new-instance v0, Lco/vine/android/InboxFragment$3;

    invoke-direct {v0, p0}, Lco/vine/android/InboxFragment$3;-><init>(Lco/vine/android/InboxFragment;)V

    iput-object v0, p0, Lco/vine/android/InboxFragment;->mInvalidateContactEntryRunnable:Ljava/lang/Runnable;

    .line 777
    new-instance v0, Lco/vine/android/InboxFragment$4;

    invoke-direct {v0, p0}, Lco/vine/android/InboxFragment$4;-><init>(Lco/vine/android/InboxFragment;)V

    iput-object v0, p0, Lco/vine/android/InboxFragment;->mListener:Lco/vine/android/OnContactEntryClickedListener;

    return-void
.end method

.method static synthetic access$100(Lco/vine/android/InboxFragment;)Landroid/widget/BaseAdapter;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/InboxFragment;

    .prologue
    .line 56
    iget-object v0, p0, Lco/vine/android/InboxFragment;->mActiveAdapter:Landroid/widget/BaseAdapter;

    return-object v0
.end method

.method static synthetic access$1000(Lco/vine/android/InboxFragment;)Ljava/util/HashMap;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/InboxFragment;

    .prologue
    .line 56
    iget-object v0, p0, Lco/vine/android/InboxFragment;->mContactEntryMap:Ljava/util/HashMap;

    return-object v0
.end method

.method static synthetic access$1002(Lco/vine/android/InboxFragment;Ljava/util/HashMap;)Ljava/util/HashMap;
    .locals 0
    .param p0, "x0"    # Lco/vine/android/InboxFragment;
    .param p1, "x1"    # Ljava/util/HashMap;

    .prologue
    .line 56
    iput-object p1, p0, Lco/vine/android/InboxFragment;->mContactEntryMap:Ljava/util/HashMap;

    return-object p1
.end method

.method static synthetic access$102(Lco/vine/android/InboxFragment;Landroid/widget/BaseAdapter;)Landroid/widget/BaseAdapter;
    .locals 0
    .param p0, "x0"    # Lco/vine/android/InboxFragment;
    .param p1, "x1"    # Landroid/widget/BaseAdapter;

    .prologue
    .line 56
    iput-object p1, p0, Lco/vine/android/InboxFragment;->mActiveAdapter:Landroid/widget/BaseAdapter;

    return-object p1
.end method

.method static synthetic access$1102(Lco/vine/android/InboxFragment;Ljava/util/ArrayList;)Ljava/util/ArrayList;
    .locals 0
    .param p0, "x0"    # Lco/vine/android/InboxFragment;
    .param p1, "x1"    # Ljava/util/ArrayList;

    .prologue
    .line 56
    iput-object p1, p0, Lco/vine/android/InboxFragment;->mContactEntries:Ljava/util/ArrayList;

    return-object p1
.end method

.method static synthetic access$1200(Lco/vine/android/InboxFragment;)V
    .locals 0
    .param p0, "x0"    # Lco/vine/android/InboxFragment;

    .prologue
    .line 56
    invoke-direct {p0}, Lco/vine/android/InboxFragment;->invalidateContactEntries()V

    return-void
.end method

.method static synthetic access$1300(Lco/vine/android/InboxFragment;)Z
    .locals 1
    .param p0, "x0"    # Lco/vine/android/InboxFragment;

    .prologue
    .line 56
    iget-boolean v0, p0, Lco/vine/android/InboxFragment;->mIsAddressBookShowing:Z

    return v0
.end method

.method static synthetic access$1402(Lco/vine/android/InboxFragment;Z)Z
    .locals 0
    .param p0, "x0"    # Lco/vine/android/InboxFragment;
    .param p1, "x1"    # Z

    .prologue
    .line 56
    iput-boolean p1, p0, Lco/vine/android/InboxFragment;->mLoadingMore:Z

    return p1
.end method

.method static synthetic access$200(Lco/vine/android/InboxFragment;)Lco/vine/android/widget/SectionAdapter;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/InboxFragment;

    .prologue
    .line 56
    iget-object v0, p0, Lco/vine/android/InboxFragment;->mSectionAdapter:Lco/vine/android/widget/SectionAdapter;

    return-object v0
.end method

.method static synthetic access$300(Lco/vine/android/InboxFragment;)I
    .locals 1
    .param p0, "x0"    # Lco/vine/android/InboxFragment;

    .prologue
    .line 56
    iget v0, p0, Lco/vine/android/InboxFragment;->mInboxCursorCount:I

    return v0
.end method

.method static synthetic access$400(Lco/vine/android/InboxFragment;)Z
    .locals 1
    .param p0, "x0"    # Lco/vine/android/InboxFragment;

    .prologue
    .line 56
    iget-boolean v0, p0, Lco/vine/android/InboxFragment;->mIsEmptyViewAdded:Z

    return v0
.end method

.method static synthetic access$402(Lco/vine/android/InboxFragment;Z)Z
    .locals 0
    .param p0, "x0"    # Lco/vine/android/InboxFragment;
    .param p1, "x1"    # Z

    .prologue
    .line 56
    iput-boolean p1, p0, Lco/vine/android/InboxFragment;->mIsEmptyViewAdded:Z

    return p1
.end method

.method static synthetic access$500(Lco/vine/android/InboxFragment;)Landroid/view/View;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/InboxFragment;

    .prologue
    .line 56
    iget-object v0, p0, Lco/vine/android/InboxFragment;->mEmptyView:Landroid/view/View;

    return-object v0
.end method

.method static synthetic access$600(Lco/vine/android/InboxFragment;)I
    .locals 1
    .param p0, "x0"    # Lco/vine/android/InboxFragment;

    .prologue
    .line 56
    iget v0, p0, Lco/vine/android/InboxFragment;->mOthersCursorCount:I

    return v0
.end method

.method static synthetic access$700(Lco/vine/android/InboxFragment;)Z
    .locals 1
    .param p0, "x0"    # Lco/vine/android/InboxFragment;

    .prologue
    .line 56
    iget-boolean v0, p0, Lco/vine/android/InboxFragment;->mIsSwitching:Z

    return v0
.end method

.method static synthetic access$702(Lco/vine/android/InboxFragment;Z)Z
    .locals 0
    .param p0, "x0"    # Lco/vine/android/InboxFragment;
    .param p1, "x1"    # Z

    .prologue
    .line 56
    iput-boolean p1, p0, Lco/vine/android/InboxFragment;->mIsSwitching:Z

    return p1
.end method

.method static synthetic access$800(Lco/vine/android/InboxFragment;)V
    .locals 0
    .param p0, "x0"    # Lco/vine/android/InboxFragment;

    .prologue
    .line 56
    invoke-direct {p0}, Lco/vine/android/InboxFragment;->invalidateAdapters()V

    return-void
.end method

.method static synthetic access$902(Lco/vine/android/InboxFragment;Lco/vine/android/InboxFragment$SortMenuContactsTask;)Lco/vine/android/InboxFragment$SortMenuContactsTask;
    .locals 0
    .param p0, "x0"    # Lco/vine/android/InboxFragment;
    .param p1, "x1"    # Lco/vine/android/InboxFragment$SortMenuContactsTask;

    .prologue
    .line 56
    iput-object p1, p0, Lco/vine/android/InboxFragment;->mSortMenuTask:Lco/vine/android/InboxFragment$SortMenuContactsTask;

    return-object p1
.end method

.method private invalidateAdapters()V
    .locals 5

    .prologue
    const/4 v4, 0x0

    const/high16 v3, 0x5a000000

    const v2, -0xcccccd

    .line 495
    iget-object v0, p0, Lco/vine/android/InboxFragment;->mActiveAdapter:Landroid/widget/BaseAdapter;

    iget-object v1, p0, Lco/vine/android/InboxFragment;->mOtherAdapter:Lco/vine/android/MessageBoxAdapter;

    if-ne v0, v1, :cond_0

    .line 496
    iget-object v0, p0, Lco/vine/android/InboxFragment;->mFriendsText:Landroid/widget/TextView;

    invoke-virtual {v0, v3}, Landroid/widget/TextView;->setTextColor(I)V

    .line 497
    iget-object v0, p0, Lco/vine/android/InboxFragment;->mOthersText:Landroid/widget/TextView;

    invoke-virtual {v0, v2}, Landroid/widget/TextView;->setTextColor(I)V

    .line 498
    iget-object v0, p0, Lco/vine/android/InboxFragment;->mFriendsText:Landroid/widget/TextView;

    iget-object v1, p0, Lco/vine/android/InboxFragment;->mTypefaces:Lco/vine/android/widget/Typefaces;

    iget-object v1, v1, Lco/vine/android/widget/Typefaces;->mediumContent:Landroid/graphics/Typeface;

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setTypeface(Landroid/graphics/Typeface;)V

    .line 499
    iget-object v0, p0, Lco/vine/android/InboxFragment;->mOthersText:Landroid/widget/TextView;

    iget-object v1, p0, Lco/vine/android/InboxFragment;->mTypefaces:Lco/vine/android/widget/Typefaces;

    iget-object v1, v1, Lco/vine/android/widget/Typefaces;->boldContent:Landroid/graphics/Typeface;

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setTypeface(Landroid/graphics/Typeface;)V

    .line 500
    iput-object v4, p0, Lco/vine/android/InboxFragment;->mCursorAdapter:Landroid/support/v4/widget/CursorAdapter;

    .line 501
    iget-object v0, p0, Lco/vine/android/InboxFragment;->mEmptyWords:Landroid/widget/TextView;

    const v1, 0x7f0e0280

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(I)V

    .line 502
    iget-object v0, p0, Lco/vine/android/InboxFragment;->mEmptyImage:Landroid/widget/ImageView;

    const v1, 0x7f020293

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 503
    iget-object v0, p0, Lco/vine/android/InboxFragment;->mEmptyTitle:Landroid/widget/TextView;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    .line 504
    iget-object v0, p0, Lco/vine/android/InboxFragment;->mListView:Landroid/widget/ListView;

    invoke-static {v0, v4}, Lco/vine/android/util/ViewUtil;->setBackground(Landroid/view/View;Landroid/graphics/drawable/Drawable;)V

    .line 516
    :goto_0
    const/4 v0, 0x1

    invoke-direct {p0, v0}, Lco/vine/android/InboxFragment;->invalidateEmptyView(Z)V

    .line 517
    return-void

    .line 506
    :cond_0
    iget-object v0, p0, Lco/vine/android/InboxFragment;->mOthersText:Landroid/widget/TextView;

    invoke-virtual {v0, v3}, Landroid/widget/TextView;->setTextColor(I)V

    .line 507
    iget-object v0, p0, Lco/vine/android/InboxFragment;->mFriendsText:Landroid/widget/TextView;

    invoke-virtual {v0, v2}, Landroid/widget/TextView;->setTextColor(I)V

    .line 508
    iget-object v0, p0, Lco/vine/android/InboxFragment;->mOthersText:Landroid/widget/TextView;

    iget-object v1, p0, Lco/vine/android/InboxFragment;->mTypefaces:Lco/vine/android/widget/Typefaces;

    iget-object v1, v1, Lco/vine/android/widget/Typefaces;->mediumContent:Landroid/graphics/Typeface;

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setTypeface(Landroid/graphics/Typeface;)V

    .line 509
    iget-object v0, p0, Lco/vine/android/InboxFragment;->mFriendsText:Landroid/widget/TextView;

    iget-object v1, p0, Lco/vine/android/InboxFragment;->mTypefaces:Lco/vine/android/widget/Typefaces;

    iget-object v1, v1, Lco/vine/android/widget/Typefaces;->boldContent:Landroid/graphics/Typeface;

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setTypeface(Landroid/graphics/Typeface;)V

    .line 510
    iget-object v0, p0, Lco/vine/android/InboxFragment;->mFriendsAdapter:Lco/vine/android/MenuUsersAdapter;

    iput-object v0, p0, Lco/vine/android/InboxFragment;->mCursorAdapter:Landroid/support/v4/widget/CursorAdapter;

    .line 511
    iget-object v0, p0, Lco/vine/android/InboxFragment;->mEmptyTitle:Landroid/widget/TextView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    .line 512
    iget-object v0, p0, Lco/vine/android/InboxFragment;->mEmptyWords:Landroid/widget/TextView;

    const v1, 0x7f0e0279

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(I)V

    .line 513
    iget-object v0, p0, Lco/vine/android/InboxFragment;->mEmptyImage:Landroid/widget/ImageView;

    const v1, 0x7f02028c

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 514
    iget-object v0, p0, Lco/vine/android/InboxFragment;->mListView:Landroid/widget/ListView;

    invoke-virtual {p0}, Lco/vine/android/InboxFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f090082

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getColor(I)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setBackgroundColor(I)V

    goto :goto_0
.end method

.method private invalidateContactEntries()V
    .locals 4

    .prologue
    .line 577
    iget-object v0, p0, Lco/vine/android/InboxFragment;->mHandler:Landroid/os/Handler;

    iget-object v1, p0, Lco/vine/android/InboxFragment;->mInvalidateContactEntryRunnable:Ljava/lang/Runnable;

    invoke-virtual {v0, v1}, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V

    .line 578
    iget-object v0, p0, Lco/vine/android/InboxFragment;->mHandler:Landroid/os/Handler;

    iget-object v1, p0, Lco/vine/android/InboxFragment;->mInvalidateContactEntryRunnable:Ljava/lang/Runnable;

    const-wide/16 v2, 0x64

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 579
    return-void
.end method

.method private declared-synchronized invalidateEmptyView(Z)V
    .locals 4
    .param p1, "immediate"    # Z

    .prologue
    .line 224
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lco/vine/android/InboxFragment;->mHandler:Landroid/os/Handler;

    iget-object v1, p0, Lco/vine/android/InboxFragment;->mInvalidateEmptyViewRunnable:Ljava/lang/Runnable;

    invoke-virtual {v0, v1}, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V

    .line 225
    if-eqz p1, :cond_0

    .line 226
    iget-object v0, p0, Lco/vine/android/InboxFragment;->mInvalidateEmptyViewRunnable:Ljava/lang/Runnable;

    invoke-interface {v0}, Ljava/lang/Runnable;->run()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 230
    :goto_0
    monitor-exit p0

    return-void

    .line 228
    :cond_0
    :try_start_1
    iget-object v0, p0, Lco/vine/android/InboxFragment;->mHandler:Landroid/os/Handler;

    iget-object v1, p0, Lco/vine/android/InboxFragment;->mInvalidateEmptyViewRunnable:Ljava/lang/Runnable;

    const-wide/16 v2, 0x64

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 224
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method private invalidateUnreadCount()V
    .locals 7

    .prologue
    const/4 v6, 0x0

    const/4 v5, -0x1

    .line 233
    const/4 v2, 0x0

    .line 234
    .local v2, "text":Ljava/lang/String;
    iget v3, p0, Lco/vine/android/InboxFragment;->mUnReadCount:I

    if-lez v3, :cond_0

    .line 235
    iget v3, p0, Lco/vine/android/InboxFragment;->mUnReadCount:I

    const/16 v4, 0x14

    if-le v3, v4, :cond_2

    .line 236
    const-string v2, "20+"

    .line 241
    :cond_0
    :goto_0
    iget-object v3, p0, Lco/vine/android/InboxFragment;->mOthersText:Landroid/widget/TextView;

    if-eqz v3, :cond_1

    .line 242
    iget-object v3, p0, Lco/vine/android/InboxFragment;->mOthersText:Landroid/widget/TextView;

    invoke-virtual {v3}, Landroid/widget/TextView;->getText()Ljava/lang/CharSequence;

    move-result-object v3

    invoke-interface {v3}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v0

    .line 243
    .local v0, "currentText":Ljava/lang/String;
    const-string v3, "("

    invoke-virtual {v0, v3}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v1

    .line 244
    .local v1, "index":I
    if-eqz v2, :cond_4

    .line 245
    iget-object v3, p0, Lco/vine/android/InboxFragment;->mOthersText:Landroid/widget/TextView;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    if-ne v1, v5, :cond_3

    .end local v0    # "currentText":Ljava/lang/String;
    :goto_1
    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, " ("

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, ") "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 253
    .end local v1    # "index":I
    :cond_1
    :goto_2
    return-void

    .line 238
    :cond_2
    iget v3, p0, Lco/vine/android/InboxFragment;->mUnReadCount:I

    invoke-static {v3}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v2

    goto :goto_0

    .line 245
    .restart local v0    # "currentText":Ljava/lang/String;
    .restart local v1    # "index":I
    :cond_3
    add-int/lit8 v5, v1, -0x1

    invoke-virtual {v0, v6, v5}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v0

    goto :goto_1

    .line 248
    :cond_4
    if-eq v1, v5, :cond_1

    .line 249
    iget-object v3, p0, Lco/vine/android/InboxFragment;->mOthersText:Landroid/widget/TextView;

    add-int/lit8 v4, v1, -0x1

    invoke-virtual {v0, v6, v4}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto :goto_2
.end method


# virtual methods
.method public addEntriesToAddressAdapter()V
    .locals 2

    .prologue
    .line 520
    iget-object v0, p0, Lco/vine/android/InboxFragment;->mContactEntries:Ljava/util/ArrayList;

    if-eqz v0, :cond_1

    .line 521
    const-string v0, "Showing address book: {}."

    iget-object v1, p0, Lco/vine/android/InboxFragment;->mContactEntries:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v1

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;)V

    .line 522
    const/4 v0, 0x1

    iput-boolean v0, p0, Lco/vine/android/InboxFragment;->mIsAddressBookShowing:Z

    .line 523
    iget-object v0, p0, Lco/vine/android/InboxFragment;->mAddressAdapter:Lco/vine/android/widget/ContactsMenuAdapter;

    invoke-virtual {v0}, Lco/vine/android/widget/ContactsMenuAdapter;->getCount()I

    move-result v0

    iget-object v1, p0, Lco/vine/android/InboxFragment;->mContactEntries:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v1

    if-eq v0, v1, :cond_0

    .line 524
    iget-object v0, p0, Lco/vine/android/InboxFragment;->mAddressAdapter:Lco/vine/android/widget/ContactsMenuAdapter;

    invoke-virtual {v0}, Lco/vine/android/widget/ContactsMenuAdapter;->clear()V

    .line 525
    iget-object v0, p0, Lco/vine/android/InboxFragment;->mAddressAdapter:Lco/vine/android/widget/ContactsMenuAdapter;

    iget-object v1, p0, Lco/vine/android/InboxFragment;->mContactEntries:Ljava/util/ArrayList;

    invoke-virtual {v0, v1}, Lco/vine/android/widget/ContactsMenuAdapter;->addAll(Ljava/util/Collection;)V

    .line 527
    :cond_0
    invoke-virtual {p0}, Lco/vine/android/InboxFragment;->makeSadFaceHeaderView()V

    .line 529
    :cond_1
    return-void
.end method

.method public createView(Landroid/view/LayoutInflater;ILandroid/view/ViewGroup;)Landroid/view/View;
    .locals 8
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "id"    # I
    .param p3, "container"    # Landroid/view/ViewGroup;

    .prologue
    const/4 v7, 0x0

    const/4 v6, 0x0

    .line 355
    invoke-super {p0, p1, p2, p3}, Lco/vine/android/BaseCursorListFragment;->createView(Landroid/view/LayoutInflater;ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v2

    .line 356
    .local v2, "root":Landroid/view/View;
    invoke-virtual {p0}, Lco/vine/android/InboxFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v3

    invoke-virtual {v3}, Landroid/support/v4/app/FragmentActivity;->getLayoutInflater()Landroid/view/LayoutInflater;

    move-result-object v3

    const v4, 0x7f030058

    iget-object v5, p0, Lco/vine/android/InboxFragment;->mListView:Landroid/widget/ListView;

    invoke-virtual {v3, v4, v5, v6}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v1

    .line 357
    .local v1, "header":Landroid/view/View;
    const v3, 0x7f0a0126

    invoke-virtual {v1, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/TextView;

    iput-object v3, p0, Lco/vine/android/InboxFragment;->mFriendsText:Landroid/widget/TextView;

    .line 358
    const v3, 0x7f0a0127

    invoke-virtual {v1, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/TextView;

    iput-object v3, p0, Lco/vine/android/InboxFragment;->mOthersText:Landroid/widget/TextView;

    .line 359
    iget-object v3, p0, Lco/vine/android/InboxFragment;->mListView:Landroid/widget/ListView;

    invoke-virtual {v3, v1, v7, v6}, Landroid/widget/ListView;->addHeaderView(Landroid/view/View;Ljava/lang/Object;Z)V

    .line 360
    const v3, 0x7f0300a6

    invoke-virtual {p1, v3, v7}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    .line 361
    .local v0, "emptyHeader":Landroid/view/View;
    iput-object v0, p0, Lco/vine/android/InboxFragment;->mEmptyView:Landroid/view/View;

    .line 362
    iget-object v3, p0, Lco/vine/android/InboxFragment;->mEmptyView:Landroid/view/View;

    const v4, 0x7f0a00e3

    invoke-virtual {v3, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/ImageView;

    iput-object v3, p0, Lco/vine/android/InboxFragment;->mEmptyImage:Landroid/widget/ImageView;

    .line 363
    iget-object v3, p0, Lco/vine/android/InboxFragment;->mEmptyView:Landroid/view/View;

    const v4, 0x7f0a0235

    invoke-virtual {v3, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/TextView;

    iput-object v3, p0, Lco/vine/android/InboxFragment;->mEmptyWords:Landroid/widget/TextView;

    .line 364
    iget-object v3, p0, Lco/vine/android/InboxFragment;->mEmptyView:Landroid/view/View;

    const v4, 0x7f0a0234

    invoke-virtual {v3, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/TextView;

    iput-object v3, p0, Lco/vine/android/InboxFragment;->mEmptyTitle:Landroid/widget/TextView;

    .line 365
    return-object v2
.end method

.method protected fetchContent(IIZ)V
    .locals 5
    .param p1, "fetchType"    # I
    .param p2, "fetchMode"    # I
    .param p3, "silent"    # Z

    .prologue
    const/4 v4, 0x2

    const/4 v3, 0x0

    const/4 v2, 0x1

    .line 286
    invoke-virtual {p0, p1}, Lco/vine/android/InboxFragment;->hasPendingRequest(I)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 334
    :cond_0
    :goto_0
    return-void

    .line 291
    :cond_1
    packed-switch p1, :pswitch_data_0

    .line 306
    const/4 v0, 0x1

    .line 311
    .local v0, "pageType":I
    :goto_1
    const/4 v1, 0x3

    if-ne v0, v1, :cond_2

    if-ne p2, v2, :cond_2

    .line 312
    iput-boolean v2, p0, Lco/vine/android/InboxFragment;->mLoadingMore:Z

    .line 315
    :cond_2
    and-int/lit8 v1, p2, 0x4

    if-eqz v1, :cond_3

    .line 316
    const/4 v1, 0x4

    invoke-virtual {p0, v1}, Lco/vine/android/InboxFragment;->setFetched(I)V

    .line 317
    iget-object v1, p0, Lco/vine/android/InboxFragment;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v1, v0, v3, v4}, Lco/vine/android/client/AppController;->fetchConversations(IZI)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v1, p1}, Lco/vine/android/InboxFragment;->addRequest(Ljava/lang/String;I)Ljava/lang/String;

    .line 321
    :cond_3
    and-int/lit8 v1, p2, 0x1

    if-eqz v1, :cond_4

    .line 322
    invoke-virtual {p0, v2}, Lco/vine/android/InboxFragment;->setFetched(I)V

    .line 323
    iget-object v1, p0, Lco/vine/android/InboxFragment;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v1, v0, v3, v2}, Lco/vine/android/client/AppController;->fetchConversations(IZI)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v1, p1}, Lco/vine/android/InboxFragment;->addRequest(Ljava/lang/String;I)Ljava/lang/String;

    .line 326
    :cond_4
    and-int/lit8 v1, p2, 0x2

    if-eqz v1, :cond_5

    .line 327
    invoke-virtual {p0, v4}, Lco/vine/android/InboxFragment;->setFetched(I)V

    .line 328
    iget-object v1, p0, Lco/vine/android/InboxFragment;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v1, v0, v2}, Lco/vine/android/client/AppController;->fetchFriends(II)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v1, p1}, Lco/vine/android/InboxFragment;->addRequest(Ljava/lang/String;I)Ljava/lang/String;

    .line 331
    :cond_5
    if-nez p3, :cond_0

    .line 332
    invoke-virtual {p0, p1}, Lco/vine/android/InboxFragment;->showProgress(I)V

    goto :goto_0

    .line 293
    .end local v0    # "pageType":I
    :pswitch_0
    const/4 v0, 0x1

    .line 294
    .restart local v0    # "pageType":I
    goto :goto_1

    .line 298
    .end local v0    # "pageType":I
    :pswitch_1
    const/4 v0, 0x1

    .line 299
    .restart local v0    # "pageType":I
    goto :goto_1

    .line 302
    .end local v0    # "pageType":I
    :pswitch_2
    const/4 v0, 0x3

    .line 303
    .restart local v0    # "pageType":I
    goto :goto_1

    .line 291
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_2
        :pswitch_1
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method protected isFetched(I)Z
    .locals 1
    .param p1, "mode"    # I

    .prologue
    .line 337
    iget v0, p0, Lco/vine/android/InboxFragment;->mFetchFlags:I

    and-int/2addr v0, p1

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isLoadingMore()Z
    .locals 1

    .prologue
    .line 425
    iget-boolean v0, p0, Lco/vine/android/InboxFragment;->mLoadingMore:Z

    return v0
.end method

.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 8
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    const/4 v1, 0x0

    const/4 v4, 0x3

    const/4 v6, 0x1

    const/4 v5, 0x0

    .line 456
    invoke-super {p0, p1}, Lco/vine/android/BaseCursorListFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 457
    invoke-virtual {p0}, Lco/vine/android/InboxFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lco/vine/android/widget/Typefaces;->get(Landroid/content/Context;)Lco/vine/android/widget/Typefaces;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/InboxFragment;->mTypefaces:Lco/vine/android/widget/Typefaces;

    .line 458
    invoke-virtual {p0}, Lco/vine/android/InboxFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lco/vine/android/util/Util;->getDefaultSharedPrefs(Landroid/content/Context;)Landroid/content/SharedPreferences;

    move-result-object v0

    const-string v2, "profile_background"

    sget v3, Lco/vine/android/Settings;->DEFAULT_PROFILE_COLOR:I

    invoke-interface {v0, v2, v3}, Landroid/content/SharedPreferences;->getInt(Ljava/lang/String;I)I

    move-result v7

    .line 459
    .local v7, "profileColor":I
    sget v0, Lco/vine/android/Settings;->DEFAULT_PROFILE_COLOR:I

    if-eq v7, v0, :cond_0

    if-gtz v7, :cond_1

    .line 460
    :cond_0
    const v0, 0xffffff

    invoke-virtual {p0}, Lco/vine/android/InboxFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f090096

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getColor(I)I

    move-result v2

    and-int v7, v0, v2

    .line 462
    :cond_1
    iget-object v0, p0, Lco/vine/android/InboxFragment;->mInboxAdapter:Lco/vine/android/MessageBoxAdapter;

    if-nez v0, :cond_2

    .line 463
    new-instance v0, Lco/vine/android/MessageBoxAdapter;

    invoke-virtual {p0}, Lco/vine/android/InboxFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    iget-object v3, p0, Lco/vine/android/InboxFragment;->mAppController:Lco/vine/android/client/AppController;

    invoke-direct {v0, v2, v3, p0, v5}, Lco/vine/android/MessageBoxAdapter;-><init>(Landroid/content/Context;Lco/vine/android/client/AppController;Lco/vine/android/InboxFragment;I)V

    iput-object v0, p0, Lco/vine/android/InboxFragment;->mInboxAdapter:Lco/vine/android/MessageBoxAdapter;

    .line 465
    :cond_2
    iget-object v0, p0, Lco/vine/android/InboxFragment;->mDummyAdapter:Lco/vine/android/MessageBoxAdapter;

    if-nez v0, :cond_3

    .line 466
    new-instance v0, Lco/vine/android/MessageBoxAdapter;

    invoke-virtual {p0}, Lco/vine/android/InboxFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    iget-object v3, p0, Lco/vine/android/InboxFragment;->mAppController:Lco/vine/android/client/AppController;

    invoke-direct {v0, v2, v3, p0, v5}, Lco/vine/android/MessageBoxAdapter;-><init>(Landroid/content/Context;Lco/vine/android/client/AppController;Lco/vine/android/InboxFragment;I)V

    iput-object v0, p0, Lco/vine/android/InboxFragment;->mDummyAdapter:Lco/vine/android/MessageBoxAdapter;

    .line 468
    :cond_3
    iget-object v0, p0, Lco/vine/android/InboxFragment;->mFriendsAdapter:Lco/vine/android/MenuUsersAdapter;

    if-nez v0, :cond_4

    .line 469
    new-instance v0, Lco/vine/android/MenuUsersAdapter;

    invoke-virtual {p0}, Lco/vine/android/InboxFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    iget-object v3, p0, Lco/vine/android/InboxFragment;->mAppController:Lco/vine/android/client/AppController;

    invoke-direct {v0, v2, v3, v5}, Lco/vine/android/MenuUsersAdapter;-><init>(Landroid/content/Context;Lco/vine/android/client/AppController;I)V

    iput-object v0, p0, Lco/vine/android/InboxFragment;->mFriendsAdapter:Lco/vine/android/MenuUsersAdapter;

    .line 470
    iget-object v0, p0, Lco/vine/android/InboxFragment;->mFriendsAdapter:Lco/vine/android/MenuUsersAdapter;

    iget-object v2, p0, Lco/vine/android/InboxFragment;->mInboxAdapter:Lco/vine/android/MessageBoxAdapter;

    invoke-virtual {v0, v2}, Lco/vine/android/MenuUsersAdapter;->setInboxAdapter(Lco/vine/android/MessageBoxAdapter;)V

    .line 472
    :cond_4
    iget-object v0, p0, Lco/vine/android/InboxFragment;->mAddressAdapter:Lco/vine/android/widget/ContactsMenuAdapter;

    if-nez v0, :cond_5

    .line 473
    new-instance v0, Lco/vine/android/widget/ContactsMenuAdapter;

    invoke-virtual {p0}, Lco/vine/android/InboxFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    invoke-direct {v0, v2}, Lco/vine/android/widget/ContactsMenuAdapter;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lco/vine/android/InboxFragment;->mAddressAdapter:Lco/vine/android/widget/ContactsMenuAdapter;

    .line 475
    :cond_5
    iget-object v0, p0, Lco/vine/android/InboxFragment;->mOtherAdapter:Lco/vine/android/MessageBoxAdapter;

    if-nez v0, :cond_6

    .line 476
    new-instance v0, Lco/vine/android/MessageBoxAdapter;

    invoke-virtual {p0}, Lco/vine/android/InboxFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    iget-object v3, p0, Lco/vine/android/InboxFragment;->mAppController:Lco/vine/android/client/AppController;

    invoke-direct {v0, v2, v3, p0, v5}, Lco/vine/android/MessageBoxAdapter;-><init>(Landroid/content/Context;Lco/vine/android/client/AppController;Lco/vine/android/InboxFragment;I)V

    iput-object v0, p0, Lco/vine/android/InboxFragment;->mOtherAdapter:Lco/vine/android/MessageBoxAdapter;

    .line 479
    :cond_6
    new-instance v0, Lco/vine/android/widget/SectionAdapter;

    new-array v3, v4, [I

    fill-array-data v3, :array_0

    new-array v4, v4, [Landroid/widget/BaseAdapter;

    iget-object v2, p0, Lco/vine/android/InboxFragment;->mInboxAdapter:Lco/vine/android/MessageBoxAdapter;

    aput-object v2, v4, v5

    iget-object v2, p0, Lco/vine/android/InboxFragment;->mFriendsAdapter:Lco/vine/android/MenuUsersAdapter;

    aput-object v2, v4, v6

    const/4 v2, 0x2

    iget-object v5, p0, Lco/vine/android/InboxFragment;->mAddressAdapter:Lco/vine/android/widget/ContactsMenuAdapter;

    aput-object v5, v4, v2

    const v5, 0x7f030059

    move-object v2, v1

    invoke-direct/range {v0 .. v6}, Lco/vine/android/widget/SectionAdapter;-><init>([Z[I[I[Landroid/widget/BaseAdapter;II)V

    iput-object v0, p0, Lco/vine/android/InboxFragment;->mSectionAdapter:Lco/vine/android/widget/SectionAdapter;

    .line 483
    iget-object v0, p0, Lco/vine/android/InboxFragment;->mFriendsText:Landroid/widget/TextView;

    new-instance v1, Lco/vine/android/InboxFragment$TabSwicher;

    iget-object v2, p0, Lco/vine/android/InboxFragment;->mSectionAdapter:Lco/vine/android/widget/SectionAdapter;

    invoke-direct {v1, p0, v2}, Lco/vine/android/InboxFragment$TabSwicher;-><init>(Lco/vine/android/InboxFragment;Landroid/widget/BaseAdapter;)V

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 484
    iget-object v0, p0, Lco/vine/android/InboxFragment;->mOthersText:Landroid/widget/TextView;

    new-instance v1, Lco/vine/android/InboxFragment$TabSwicher;

    iget-object v2, p0, Lco/vine/android/InboxFragment;->mOtherAdapter:Lco/vine/android/MessageBoxAdapter;

    invoke-direct {v1, p0, v2}, Lco/vine/android/InboxFragment$TabSwicher;-><init>(Lco/vine/android/InboxFragment;Landroid/widget/BaseAdapter;)V

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 486
    iget-object v0, p0, Lco/vine/android/InboxFragment;->mSectionAdapter:Lco/vine/android/widget/SectionAdapter;

    iput-object v0, p0, Lco/vine/android/InboxFragment;->mActiveAdapter:Landroid/widget/BaseAdapter;

    .line 487
    iget-object v0, p0, Lco/vine/android/InboxFragment;->mListView:Landroid/widget/ListView;

    iget-object v1, p0, Lco/vine/android/InboxFragment;->mActiveAdapter:Landroid/widget/BaseAdapter;

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 488
    iget-object v0, p0, Lco/vine/android/InboxFragment;->mListView:Landroid/widget/ListView;

    invoke-virtual {v0, p0}, Landroid/widget/ListView;->setOnScrollListener(Landroid/widget/AbsListView$OnScrollListener;)V

    .line 489
    iget-object v0, p0, Lco/vine/android/InboxFragment;->mListView:Landroid/widget/ListView;

    check-cast v0, Lcom/twitter/android/widget/RefreshableListView;

    const/high16 v1, -0x1000000

    or-int/2addr v1, v7

    invoke-virtual {v0, v1}, Lcom/twitter/android/widget/RefreshableListView;->colorizePTR(I)V

    .line 490
    invoke-virtual {p0}, Lco/vine/android/InboxFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0, v6}, Lco/vine/android/provider/Vine;->getUserSectionsAnchorManager(Landroid/content/Context;I)Lco/vine/android/util/StringAnchorManager;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/InboxFragment;->mAnchorManager:Lco/vine/android/util/StringAnchorManager;

    .line 491
    invoke-direct {p0}, Lco/vine/android/InboxFragment;->invalidateAdapters()V

    .line 492
    return-void

    .line 479
    :array_0
    .array-data 4
        0x0
        0x0
        0x0
    .end array-data
.end method

.method public onClick(Landroid/view/View;)V
    .locals 5
    .param p1, "view"    # Landroid/view/View;

    .prologue
    const/4 v4, 0x1

    .line 636
    invoke-virtual {p1}, Landroid/view/View;->getId()I

    move-result v0

    packed-switch v0, :pswitch_data_0

    .line 649
    :cond_0
    :goto_0
    return-void

    .line 638
    :pswitch_0
    invoke-virtual {p0, v4}, Lco/vine/android/InboxFragment;->hasPendingRequest(I)Z

    move-result v0

    if-nez v0, :cond_0

    .line 639
    const v0, 0x7f0a010d

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 640
    const v0, 0x7f0a00b2

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 641
    iget-wide v0, p0, Lco/vine/android/InboxFragment;->mMessageCount:J

    const-wide/16 v2, 0xa

    add-long/2addr v0, v2

    iput-wide v0, p0, Lco/vine/android/InboxFragment;->mMessageCount:J

    .line 643
    invoke-virtual {p0, v4}, Lco/vine/android/InboxFragment;->restartLoader(I)Z

    .line 644
    invoke-virtual {p0, v4, v4, v4}, Lco/vine/android/InboxFragment;->fetchContent(IIZ)V

    goto :goto_0

    .line 636
    :pswitch_data_0
    .packed-switch 0x7f0a010c
        :pswitch_0
    .end packed-switch
.end method

.method public onClosed()V
    .locals 5

    .prologue
    const/4 v4, 0x0

    .line 370
    const-wide/16 v2, 0xa

    iput-wide v2, p0, Lco/vine/android/InboxFragment;->mMessageCount:J

    .line 371
    iget-object v2, p0, Lco/vine/android/InboxFragment;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v2}, Lco/vine/android/client/AppController;->clearInboxPageCursors()V

    .line 372
    iget-object v2, p0, Lco/vine/android/InboxFragment;->mListView:Landroid/widget/ListView;

    invoke-virtual {v2, v4, v4}, Landroid/widget/ListView;->setSelectionFromTop(II)V

    .line 373
    invoke-virtual {p0}, Lco/vine/android/InboxFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    .line 374
    .local v0, "activity":Landroid/support/v4/app/FragmentActivity;
    if-eqz v0, :cond_0

    .line 375
    invoke-virtual {p0}, Lco/vine/android/InboxFragment;->restartLoader()Z

    .line 376
    check-cast v0, Lco/vine/android/BaseActionBarActivity;

    .end local v0    # "activity":Landroid/support/v4/app/FragmentActivity;
    invoke-virtual {v0}, Lco/vine/android/BaseActionBarActivity;->getSlidingMenuHelper()Lcom/jeremyfeinstein/slidingmenu/lib/SlidingActivityHelper;

    move-result-object v1

    check-cast v1, Lco/vine/android/util/ConversationMenuHelper;

    .line 378
    .local v1, "helper":Lco/vine/android/util/ConversationMenuHelper;
    invoke-virtual {v1, v4}, Lco/vine/android/util/ConversationMenuHelper;->toggleContactSearch(Z)V

    .line 380
    .end local v1    # "helper":Lco/vine/android/util/ConversationMenuHelper;
    :cond_0
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 348
    invoke-super {p0, p1}, Lco/vine/android/BaseCursorListFragment;->onCreate(Landroid/os/Bundle;)V

    .line 349
    new-instance v0, Lco/vine/android/InboxFragment$ConversationMenuSessionListener;

    invoke-direct {v0, p0}, Lco/vine/android/InboxFragment$ConversationMenuSessionListener;-><init>(Lco/vine/android/InboxFragment;)V

    iput-object v0, p0, Lco/vine/android/InboxFragment;->mAppSessionListener:Lco/vine/android/client/AppSessionListener;

    .line 350
    const-wide/16 v0, 0xa

    iput-wide v0, p0, Lco/vine/android/InboxFragment;->mMessageCount:J

    .line 351
    return-void
.end method

.method public onCreateLoader(ILandroid/os/Bundle;)Landroid/support/v4/content/Loader;
    .locals 11
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
    const/4 v5, 0x0

    .line 583
    packed-switch p1, :pswitch_data_0

    .line 598
    sget-object v0, Lco/vine/android/provider/Vine$InboxView;->CONTENT_URI:Landroid/net/Uri;

    invoke-virtual {v0}, Landroid/net/Uri;->buildUpon()Landroid/net/Uri$Builder;

    move-result-object v0

    const-string v1, "hidden"

    const-string v3, "0"

    invoke-virtual {v0, v1, v3}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    move-result-object v1

    const-string v3, "network_type"

    const/4 v0, 0x4

    if-ne p1, v0, :cond_0

    const/4 v0, 0x2

    :goto_0
    invoke-static {v0}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v3, v0}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    move-result-object v0

    const-string v1, "limit"

    iget-wide v3, p0, Lco/vine/android/InboxFragment;->mMessageCount:J

    invoke-static {v3, v4}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v1, v3}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    move-result-object v0

    invoke-virtual {v0}, Landroid/net/Uri$Builder;->build()Landroid/net/Uri;

    move-result-object v2

    .line 606
    .local v2, "contentUri":Landroid/net/Uri;
    new-instance v0, Landroid/support/v4/content/CursorLoader;

    invoke-virtual {p0}, Lco/vine/android/InboxFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    sget-object v3, Lco/vine/android/provider/VineDatabaseSQL$InboxQuery;->PROJECTION:[Ljava/lang/String;

    move-object v4, v5

    move-object v6, v5

    invoke-direct/range {v0 .. v6}, Landroid/support/v4/content/CursorLoader;-><init>(Landroid/content/Context;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)V

    .end local v2    # "contentUri":Landroid/net/Uri;
    :goto_1
    return-object v0

    .line 585
    :pswitch_0
    const-string v10, "section_type=1"

    .line 586
    .local v10, "selection":Ljava/lang/String;
    sget-object v0, Lco/vine/android/provider/Vine$UserGroupsView;->CONTENT_URI_FRIENDS:Landroid/net/Uri;

    iget-object v1, p0, Lco/vine/android/InboxFragment;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v1}, Lco/vine/android/client/AppController;->getActiveId()J

    move-result-wide v3

    invoke-static {v0, v3, v4}, Landroid/content/ContentUris;->withAppendedId(Landroid/net/Uri;J)Landroid/net/Uri;

    move-result-object v2

    .line 588
    .restart local v2    # "contentUri":Landroid/net/Uri;
    new-instance v0, Landroid/support/v4/content/CursorLoader;

    invoke-virtual {p0}, Lco/vine/android/InboxFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    sget-object v3, Lco/vine/android/provider/VineDatabaseSQL$UsersQuery;->PROJECTION:[Ljava/lang/String;

    const-string v4, "section_type=1"

    const-string v6, "last_section_refresh DESC, section_index ASC"

    invoke-direct/range {v0 .. v6}, Landroid/support/v4/content/CursorLoader;-><init>(Landroid/content/Context;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_1

    .line 592
    .end local v2    # "contentUri":Landroid/net/Uri;
    .end local v10    # "selection":Ljava/lang/String;
    :pswitch_1
    new-instance v3, Landroid/support/v4/content/CursorLoader;

    invoke-virtual {p0}, Lco/vine/android/InboxFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v4

    sget-object v5, Lco/vine/android/ContactEntry;->sUri:Landroid/net/Uri;

    sget-object v6, Lco/vine/android/ContactEntry;->sProjection:[Ljava/lang/String;

    const-string v7, "mimetype=? OR mimetype=?"

    sget-object v8, Lco/vine/android/ContactEntry;->sSelectionArgs:[Ljava/lang/String;

    const-string v9, "contact_id ASC "

    invoke-direct/range {v3 .. v9}, Landroid/support/v4/content/CursorLoader;-><init>(Landroid/content/Context;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)V

    move-object v0, v3

    goto :goto_1

    .line 598
    :cond_0
    const/4 v0, 0x1

    goto :goto_0

    .line 583
    nop

    :pswitch_data_0
    .packed-switch 0x2
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 1
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 120
    const v0, 0x7f030047

    invoke-virtual {p0, p1, v0, p2}, Lco/vine/android/InboxFragment;->createView(Landroid/view/LayoutInflater;ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method protected onGetMessageInboxComplete(I)V
    .locals 3
    .param p1, "count"    # I

    .prologue
    const/4 v2, 0x0

    .line 765
    iget-object v0, p0, Lco/vine/android/InboxFragment;->mActiveAdapter:Landroid/widget/BaseAdapter;

    iget-object v1, p0, Lco/vine/android/InboxFragment;->mSectionAdapter:Lco/vine/android/widget/SectionAdapter;

    if-ne v0, v1, :cond_0

    .line 766
    if-nez p1, :cond_1

    .line 767
    invoke-direct {p0}, Lco/vine/android/InboxFragment;->invalidateContactEntries()V

    .line 774
    :cond_0
    :goto_0
    invoke-direct {p0, v2}, Lco/vine/android/InboxFragment;->invalidateEmptyView(Z)V

    .line 775
    return-void

    .line 769
    :cond_1
    iget-object v0, p0, Lco/vine/android/InboxFragment;->mAddressAdapter:Lco/vine/android/widget/ContactsMenuAdapter;

    invoke-virtual {v0}, Lco/vine/android/widget/ContactsMenuAdapter;->clear()V

    .line 770
    iput-boolean v2, p0, Lco/vine/android/InboxFragment;->mIsAddressBookShowing:Z

    .line 771
    iget-object v0, p0, Lco/vine/android/InboxFragment;->mAddressAdapter:Lco/vine/android/widget/ContactsMenuAdapter;

    invoke-virtual {v0}, Lco/vine/android/widget/ContactsMenuAdapter;->notifyDataSetChanged()V

    goto :goto_0
.end method

.method public onInboxCursorClicked(Landroid/database/Cursor;Landroid/view/View;)V
    .locals 13
    .param p1, "inboxCursor"    # Landroid/database/Cursor;
    .param p2, "item"    # Landroid/view/View;

    .prologue
    const/16 v12, 0x8

    const/4 v7, 0x0

    const/4 v6, 0x1

    .line 613
    const/16 v9, 0xf

    invoke-interface {p1, v9}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v9

    invoke-static {v9}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v9

    if-nez v9, :cond_0

    const/16 v9, 0xe

    invoke-interface {p1, v9}, Landroid/database/Cursor;->getInt(I)I

    move-result v9

    if-gt v9, v6, :cond_2

    .line 615
    :cond_0
    invoke-interface {p1, v6}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v1

    .line 617
    .local v1, "conversationObjectId":J
    invoke-interface {p1, v12}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v3

    .line 619
    .local v3, "username":Ljava/lang/String;
    const/16 v9, 0xb

    invoke-interface {p1, v9}, Landroid/database/Cursor;->getInt(I)I

    move-result v9

    if-ne v9, v6, :cond_1

    .line 620
    .local v6, "amFollowing":Z
    :goto_0
    const/16 v9, 0xa

    invoke-interface {p1, v9}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v4

    .line 621
    .local v4, "userId":J
    invoke-virtual {p0}, Lco/vine/android/InboxFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lco/vine/android/BaseActionBarActivity;

    .line 622
    .local v0, "activity":Lco/vine/android/BaseActionBarActivity;
    invoke-static/range {v0 .. v7}, Lco/vine/android/ConversationActivity;->getIntent(Landroid/content/Context;JLjava/lang/String;JZZ)Landroid/content/Intent;

    move-result-object v7

    invoke-virtual {p0, v7}, Lco/vine/android/InboxFragment;->startActivity(Landroid/content/Intent;)V

    .line 632
    .end local v0    # "activity":Lco/vine/android/BaseActionBarActivity;
    .end local v1    # "conversationObjectId":J
    .end local v3    # "username":Ljava/lang/String;
    .end local v4    # "userId":J
    .end local v6    # "amFollowing":Z
    :goto_1
    return-void

    .restart local v1    # "conversationObjectId":J
    .restart local v3    # "username":Ljava/lang/String;
    :cond_1
    move v6, v7

    .line 619
    goto :goto_0

    .line 625
    .end local v1    # "conversationObjectId":J
    .end local v3    # "username":Ljava/lang/String;
    :cond_2
    iget-object v9, p0, Lco/vine/android/InboxFragment;->mAppController:Lco/vine/android/client/AppController;

    invoke-interface {p1, v6}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v10

    invoke-virtual {v9, v10, v11}, Lco/vine/android/client/AppController;->retryMessagesInConversationRowId(J)V

    .line 627
    const v9, 0x7f0a0108

    invoke-virtual {p2, v9}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v8

    check-cast v8, Landroid/widget/TextView;

    .line 628
    .local v8, "retryText":Landroid/widget/TextView;
    const v9, 0x7f0e0142

    invoke-virtual {v8, v9}, Landroid/widget/TextView;->setText(I)V

    .line 629
    const v9, 0x7f0a010a

    invoke-virtual {p2, v9}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v9

    invoke-virtual {v9, v12}, Landroid/view/View;->setVisibility(I)V

    .line 630
    const v9, 0x7f0a010b

    invoke-virtual {p2, v9}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v9

    invoke-virtual {v9, v7}, Landroid/view/View;->setVisibility(I)V

    goto :goto_1
.end method

.method protected onListItemClick(Landroid/widget/ListView;Landroid/view/View;IJ)V
    .locals 4
    .param p1, "l"    # Landroid/widget/ListView;
    .param p2, "v"    # Landroid/view/View;
    .param p3, "position"    # I
    .param p4, "id"    # J

    .prologue
    .line 738
    iget-object v0, p0, Lco/vine/android/InboxFragment;->mListView:Landroid/widget/ListView;

    invoke-virtual {v0}, Landroid/widget/ListView;->getHeaderViewsCount()I

    move-result v0

    sub-int/2addr p3, v0

    .line 739
    if-ltz p3, :cond_0

    .line 740
    iget-object v0, p0, Lco/vine/android/InboxFragment;->mActiveAdapter:Landroid/widget/BaseAdapter;

    iget-object v1, p0, Lco/vine/android/InboxFragment;->mSectionAdapter:Lco/vine/android/widget/SectionAdapter;

    if-ne v0, v1, :cond_1

    .line 741
    iget-object v0, p0, Lco/vine/android/InboxFragment;->mSectionAdapter:Lco/vine/android/widget/SectionAdapter;

    invoke-virtual {v0, p3}, Lco/vine/android/widget/SectionAdapter;->getItemViewType(I)I

    move-result v0

    packed-switch v0, :pswitch_data_0

    .line 762
    :cond_0
    :goto_0
    return-void

    .line 743
    :pswitch_0
    iget-object v0, p0, Lco/vine/android/InboxFragment;->mSectionAdapter:Lco/vine/android/widget/SectionAdapter;

    invoke-virtual {v0, p3}, Lco/vine/android/widget/SectionAdapter;->getItem(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/database/Cursor;

    invoke-virtual {p0, v0, p2}, Lco/vine/android/InboxFragment;->onInboxCursorClicked(Landroid/database/Cursor;Landroid/view/View;)V

    goto :goto_0

    .line 747
    :pswitch_1
    iget-wide v0, p0, Lco/vine/android/InboxFragment;->mWaitingToStartId:J

    const-wide/16 v2, -0x1

    cmp-long v0, v0, v2

    if-nez v0, :cond_0

    .line 748
    iput-wide p4, p0, Lco/vine/android/InboxFragment;->mWaitingToStartId:J

    .line 749
    iget-object v0, p0, Lco/vine/android/InboxFragment;->mAppController:Lco/vine/android/client/AppController;

    const/4 v1, 0x1

    invoke-virtual {v0, p4, p5, v1}, Lco/vine/android/client/AppController;->fetchConversationRowIdFromUserRemoteId(JI)V

    goto :goto_0

    .line 754
    :pswitch_2
    iget-object v1, p0, Lco/vine/android/InboxFragment;->mListener:Lco/vine/android/OnContactEntryClickedListener;

    iget-object v0, p0, Lco/vine/android/InboxFragment;->mContactEntryMap:Ljava/util/HashMap;

    invoke-static {p4, p5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lco/vine/android/ContactEntry;

    invoke-virtual {v1, p0, v0}, Lco/vine/android/OnContactEntryClickedListener;->onClick(Landroid/support/v4/app/Fragment;Lco/vine/android/ContactEntry;)V

    goto :goto_0

    .line 759
    :cond_1
    iget-object v0, p0, Lco/vine/android/InboxFragment;->mOtherAdapter:Lco/vine/android/MessageBoxAdapter;

    invoke-virtual {v0, p3}, Lco/vine/android/MessageBoxAdapter;->getItem(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/database/Cursor;

    invoke-virtual {p0, v0, p2}, Lco/vine/android/InboxFragment;->onInboxCursorClicked(Landroid/database/Cursor;Landroid/view/View;)V

    goto :goto_0

    .line 741
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method

.method public onLoadFinished(Landroid/support/v4/content/Loader;Landroid/database/Cursor;)V
    .locals 7
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
    const/4 v4, 0x2

    const/4 v6, 0x3

    const/4 v3, 0x1

    const/4 v5, 0x0

    .line 125
    invoke-virtual {p1}, Landroid/support/v4/content/Loader;->getId()I

    move-result v1

    packed-switch v1, :pswitch_data_0

    .line 181
    :cond_0
    :goto_0
    const-string v1, "Load finished: {}."

    invoke-virtual {p1}, Landroid/support/v4/content/Loader;->getId()I

    move-result v2

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;)V

    .line 182
    invoke-direct {p0, v5}, Lco/vine/android/InboxFragment;->invalidateEmptyView(Z)V

    .line 183
    invoke-virtual {p1}, Landroid/support/v4/content/Loader;->getId()I

    move-result v1

    if-eq v1, v6, :cond_1

    .line 184
    invoke-direct {p0}, Lco/vine/android/InboxFragment;->invalidateContactEntries()V

    .line 186
    :cond_1
    return-void

    .line 127
    :pswitch_0
    iget-object v1, p0, Lco/vine/android/InboxFragment;->mFriendsAdapter:Lco/vine/android/MenuUsersAdapter;

    invoke-virtual {v1}, Lco/vine/android/MenuUsersAdapter;->getCursor()Landroid/database/Cursor;

    move-result-object v0

    .line 128
    .local v0, "oldCursor":Landroid/database/Cursor;
    if-eqz v0, :cond_2

    .line 129
    iget-object v1, p0, Lco/vine/android/InboxFragment;->mChangeObserver:Lco/vine/android/BaseCursorAdapterFragment$ChangeObserver;

    invoke-interface {v0, v1}, Landroid/database/Cursor;->unregisterContentObserver(Landroid/database/ContentObserver;)V

    .line 131
    :cond_2
    if-eqz p2, :cond_3

    .line 132
    iget-object v1, p0, Lco/vine/android/InboxFragment;->mChangeObserver:Lco/vine/android/BaseCursorAdapterFragment$ChangeObserver;

    invoke-interface {p2, v1}, Landroid/database/Cursor;->registerContentObserver(Landroid/database/ContentObserver;)V

    .line 133
    invoke-interface {p2}, Landroid/database/Cursor;->moveToLast()Z

    move-result v1

    if-eqz v1, :cond_3

    .line 134
    invoke-interface {p2, v3}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v1

    iput-wide v1, p0, Lco/vine/android/InboxFragment;->mCurrentLastId:J

    .line 135
    invoke-interface {p2}, Landroid/database/Cursor;->moveToFirst()Z

    .line 138
    :cond_3
    iget-object v1, p0, Lco/vine/android/InboxFragment;->mFriendsAdapter:Lco/vine/android/MenuUsersAdapter;

    invoke-virtual {v1, p2}, Lco/vine/android/MenuUsersAdapter;->swapCursor(Landroid/database/Cursor;)Landroid/database/Cursor;

    .line 139
    iget-object v1, p0, Lco/vine/android/InboxFragment;->mFriendsAdapter:Lco/vine/android/MenuUsersAdapter;

    invoke-virtual {v1}, Lco/vine/android/MenuUsersAdapter;->isEmpty()Z

    move-result v1

    if-eqz v1, :cond_4

    invoke-virtual {p0, v4}, Lco/vine/android/InboxFragment;->isFetched(I)Z

    move-result v1

    if-nez v1, :cond_4

    .line 140
    invoke-virtual {p0, v6, v4, v3}, Lco/vine/android/InboxFragment;->fetchContent(IIZ)V

    goto :goto_0

    .line 142
    :cond_4
    invoke-virtual {p0}, Lco/vine/android/InboxFragment;->makeSadFaceHeaderView()V

    .line 143
    invoke-virtual {p0, v6}, Lco/vine/android/InboxFragment;->hideProgress(I)V

    goto :goto_0

    .line 148
    .end local v0    # "oldCursor":Landroid/database/Cursor;
    :pswitch_1
    iput v5, p0, Lco/vine/android/InboxFragment;->mUnReadCount:I

    .line 149
    if-eqz p2, :cond_6

    invoke-interface {p2}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v1

    if-eqz v1, :cond_6

    .line 151
    :cond_5
    iget v1, p0, Lco/vine/android/InboxFragment;->mUnReadCount:I

    const/4 v2, 0x4

    invoke-interface {p2, v2}, Landroid/database/Cursor;->getInt(I)I

    move-result v2

    add-int/2addr v1, v2

    iput v1, p0, Lco/vine/android/InboxFragment;->mUnReadCount:I

    .line 152
    invoke-interface {p2}, Landroid/database/Cursor;->moveToNext()Z

    move-result v1

    if-nez v1, :cond_5

    .line 153
    invoke-interface {p2}, Landroid/database/Cursor;->moveToFirst()Z

    .line 155
    :cond_6
    invoke-direct {p0}, Lco/vine/android/InboxFragment;->invalidateUnreadCount()V

    .line 158
    :pswitch_2
    if-eqz p2, :cond_0

    .line 159
    invoke-virtual {p1}, Landroid/support/v4/content/Loader;->getId()I

    move-result v1

    invoke-virtual {p0, v1, p2}, Lco/vine/android/InboxFragment;->onLoadMessageBoxComplete(ILandroid/database/Cursor;)V

    goto/16 :goto_0

    .line 164
    :pswitch_3
    iget-object v0, p0, Lco/vine/android/InboxFragment;->mAddressCursor:Landroid/database/Cursor;

    .line 165
    .restart local v0    # "oldCursor":Landroid/database/Cursor;
    if-eqz v0, :cond_7

    .line 166
    iget-object v1, p0, Lco/vine/android/InboxFragment;->mChangeObserver:Lco/vine/android/BaseCursorAdapterFragment$ChangeObserver;

    invoke-interface {v0, v1}, Landroid/database/Cursor;->unregisterContentObserver(Landroid/database/ContentObserver;)V

    .line 168
    :cond_7
    if-eqz p2, :cond_8

    .line 169
    iget-object v1, p0, Lco/vine/android/InboxFragment;->mChangeObserver:Lco/vine/android/BaseCursorAdapterFragment$ChangeObserver;

    invoke-interface {p2, v1}, Landroid/database/Cursor;->registerContentObserver(Landroid/database/ContentObserver;)V

    .line 171
    :cond_8
    if-eqz p2, :cond_0

    .line 172
    iput-object p2, p0, Lco/vine/android/InboxFragment;->mAddressCursor:Landroid/database/Cursor;

    .line 173
    iget-object v1, p0, Lco/vine/android/InboxFragment;->mSortMenuTask:Lco/vine/android/InboxFragment$SortMenuContactsTask;

    if-nez v1, :cond_0

    .line 174
    new-instance v1, Lco/vine/android/InboxFragment$SortMenuContactsTask;

    const/4 v2, 0x0

    invoke-direct {v1, p0, v2}, Lco/vine/android/InboxFragment$SortMenuContactsTask;-><init>(Lco/vine/android/InboxFragment;Lco/vine/android/InboxFragment$1;)V

    iput-object v1, p0, Lco/vine/android/InboxFragment;->mSortMenuTask:Lco/vine/android/InboxFragment$SortMenuContactsTask;

    .line 175
    iget-object v1, p0, Lco/vine/android/InboxFragment;->mSortMenuTask:Lco/vine/android/InboxFragment$SortMenuContactsTask;

    sget-object v2, Landroid/os/AsyncTask;->THREAD_POOL_EXECUTOR:Ljava/util/concurrent/Executor;

    new-array v3, v3, [Landroid/database/Cursor;

    iget-object v4, p0, Lco/vine/android/InboxFragment;->mAddressCursor:Landroid/database/Cursor;

    aput-object v4, v3, v5

    invoke-virtual {v1, v2, v3}, Lco/vine/android/InboxFragment$SortMenuContactsTask;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto/16 :goto_0

    .line 125
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_2
        :pswitch_0
        :pswitch_3
        :pswitch_1
    .end packed-switch
.end method

.method public bridge synthetic onLoadFinished(Landroid/support/v4/content/Loader;Ljava/lang/Object;)V
    .locals 0
    .param p1, "x0"    # Landroid/support/v4/content/Loader;
    .param p2, "x1"    # Ljava/lang/Object;

    .prologue
    .line 56
    check-cast p2, Landroid/database/Cursor;

    .end local p2    # "x1":Ljava/lang/Object;
    invoke-virtual {p0, p1, p2}, Lco/vine/android/InboxFragment;->onLoadFinished(Landroid/support/v4/content/Loader;Landroid/database/Cursor;)V

    return-void
.end method

.method public onLoadMessageBoxComplete(ILandroid/database/Cursor;)V
    .locals 6
    .param p1, "loaderId"    # I
    .param p2, "cursor"    # Landroid/database/Cursor;

    .prologue
    const/4 v5, 0x3

    const/4 v4, 0x1

    const/4 v3, 0x4

    .line 256
    if-ne p1, v3, :cond_2

    iget-object v0, p0, Lco/vine/android/InboxFragment;->mOtherAdapter:Lco/vine/android/MessageBoxAdapter;

    .line 257
    .local v0, "adapter":Lco/vine/android/MessageBoxAdapter;
    :goto_0
    if-ne p1, v3, :cond_3

    move v1, v3

    .line 259
    .local v1, "flag":I
    :goto_1
    invoke-virtual {v0}, Lco/vine/android/MessageBoxAdapter;->getCursor()Landroid/database/Cursor;

    move-result-object v2

    .line 261
    .local v2, "oldCursor":Landroid/database/Cursor;
    if-eqz p2, :cond_1

    .line 262
    if-ne p1, v3, :cond_4

    .line 263
    invoke-interface {p2}, Landroid/database/Cursor;->getCount()I

    move-result v3

    iput v3, p0, Lco/vine/android/InboxFragment;->mOthersCursorCount:I

    .line 267
    :goto_2
    if-eqz v2, :cond_0

    .line 268
    iget-object v3, p0, Lco/vine/android/InboxFragment;->mChangeObserver:Lco/vine/android/BaseCursorAdapterFragment$ChangeObserver;

    invoke-interface {v2, v3}, Landroid/database/Cursor;->unregisterContentObserver(Landroid/database/ContentObserver;)V

    .line 270
    :cond_0
    iget-object v3, p0, Lco/vine/android/InboxFragment;->mChangeObserver:Lco/vine/android/BaseCursorAdapterFragment$ChangeObserver;

    invoke-interface {p2, v3}, Landroid/database/Cursor;->registerContentObserver(Landroid/database/ContentObserver;)V

    .line 273
    :cond_1
    invoke-virtual {v0, p2}, Lco/vine/android/MessageBoxAdapter;->swapCursor(Landroid/database/Cursor;)Landroid/database/Cursor;

    .line 274
    invoke-virtual {v0}, Lco/vine/android/MessageBoxAdapter;->isEmpty()Z

    move-result v3

    if-eqz v3, :cond_6

    .line 275
    invoke-virtual {p0, v1}, Lco/vine/android/InboxFragment;->isFetched(I)Z

    move-result v3

    if-nez v3, :cond_5

    .line 276
    invoke-virtual {p0, v5, v1, v4}, Lco/vine/android/InboxFragment;->fetchContent(IIZ)V

    .line 283
    :goto_3
    return-void

    .line 256
    .end local v0    # "adapter":Lco/vine/android/MessageBoxAdapter;
    .end local v1    # "flag":I
    .end local v2    # "oldCursor":Landroid/database/Cursor;
    :cond_2
    iget-object v0, p0, Lco/vine/android/InboxFragment;->mInboxAdapter:Lco/vine/android/MessageBoxAdapter;

    goto :goto_0

    .restart local v0    # "adapter":Lco/vine/android/MessageBoxAdapter;
    :cond_3
    move v1, v4

    .line 257
    goto :goto_1

    .line 265
    .restart local v1    # "flag":I
    .restart local v2    # "oldCursor":Landroid/database/Cursor;
    :cond_4
    invoke-interface {p2}, Landroid/database/Cursor;->getCount()I

    move-result v3

    iput v3, p0, Lco/vine/android/InboxFragment;->mInboxCursorCount:I

    goto :goto_2

    .line 278
    :cond_5
    invoke-virtual {p0, v4}, Lco/vine/android/InboxFragment;->showSadface(Z)V

    goto :goto_3

    .line 281
    :cond_6
    invoke-virtual {p0, v5}, Lco/vine/android/InboxFragment;->hideProgress(I)V

    goto :goto_3
.end method

.method public onOpened()V
    .locals 9

    .prologue
    const/4 v8, 0x0

    .line 384
    invoke-virtual {p0}, Lco/vine/android/InboxFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    .line 385
    .local v0, "a":Landroid/app/Activity;
    instance-of v6, v0, Lco/vine/android/HomeTabActivity;

    if-eqz v6, :cond_1

    .line 386
    invoke-static {v0}, Lco/vine/android/util/MuteUtil;->isMuted(Landroid/content/Context;)Z

    move-result v6

    if-nez v6, :cond_0

    .line 387
    new-instance v6, Landroid/content/Intent;

    sget-object v7, Lco/vine/android/util/MuteUtil;->ACTION_CHANGED_TO_MUTE:Ljava/lang/String;

    invoke-direct {v6, v7}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    const-string v7, "co.vine.android.BROADCAST"

    invoke-virtual {v0, v6, v7}, Landroid/app/Activity;->sendBroadcast(Landroid/content/Intent;Ljava/lang/String;)V

    .line 390
    :cond_0
    invoke-static {v0}, Landroid/accounts/AccountManager;->get(Landroid/content/Context;)Landroid/accounts/AccountManager;

    move-result-object v2

    .line 391
    .local v2, "am":Landroid/accounts/AccountManager;
    invoke-static {v0}, Lco/vine/android/client/VineAccountHelper;->getActiveAccount(Landroid/content/Context;)Landroid/accounts/Account;

    move-result-object v1

    .line 392
    .local v1, "account":Landroid/accounts/Account;
    if-eqz v1, :cond_1

    .line 393
    invoke-static {v0}, Lco/vine/android/util/Util;->getDefaultSharedPrefs(Landroid/content/Context;)Landroid/content/SharedPreferences;

    move-result-object v6

    const-string v7, "vmOnboardInProgress"

    invoke-interface {v6, v7, v8}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v4

    .line 395
    .local v4, "isOnboarding":Z
    if-nez v4, :cond_1

    invoke-static {v2, v1}, Lco/vine/android/client/VineAccountHelper;->shouldShowStoreContactsPrompt(Landroid/accounts/AccountManager;Landroid/accounts/Account;)Z

    move-result v6

    if-eqz v6, :cond_1

    .line 396
    const/4 v6, 0x1

    invoke-static {v6}, Lco/vine/android/widgets/PromptDialogSupportFragment;->newInstance(I)Lco/vine/android/widgets/PromptDialogSupportFragment;

    move-result-object v5

    .local v5, "p":Lco/vine/android/widgets/PromptDialogSupportFragment;
    move-object v6, v0

    .line 398
    check-cast v6, Lco/vine/android/HomeTabActivity;

    invoke-virtual {v5, v6}, Lco/vine/android/widgets/PromptDialogSupportFragment;->setListener(Lco/vine/android/widgets/PromptDialogSupportFragment$OnDialogDoneListener;)V

    .line 399
    const v6, 0x7f0e0234

    invoke-virtual {v5, v6}, Lco/vine/android/widgets/PromptDialogSupportFragment;->setMessage(I)Lco/vine/android/widgets/PromptDialogSupportFragment;

    .line 400
    const v6, 0x7f0e0233

    invoke-virtual {v5, v6}, Lco/vine/android/widgets/PromptDialogSupportFragment;->setTitle(I)Lco/vine/android/widgets/PromptDialogSupportFragment;

    .line 401
    const v6, 0x7f0e014d

    invoke-virtual {v5, v6}, Lco/vine/android/widgets/PromptDialogSupportFragment;->setNegativeButton(I)Lco/vine/android/widgets/PromptDialogSupportFragment;

    .line 402
    const v6, 0x7f0e0163

    invoke-virtual {v5, v6}, Lco/vine/android/widgets/PromptDialogSupportFragment;->setPositiveButton(I)Lco/vine/android/widgets/PromptDialogSupportFragment;

    .line 404
    :try_start_0
    check-cast v0, Lco/vine/android/HomeTabActivity;

    .end local v0    # "a":Landroid/app/Activity;
    invoke-virtual {v0}, Lco/vine/android/HomeTabActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v6

    invoke-virtual {v5, v6}, Lco/vine/android/widgets/PromptDialogSupportFragment;->show(Landroid/support/v4/app/FragmentManager;)V

    .line 405
    invoke-static {v2, v1}, Lco/vine/android/client/VineAccountHelper;->setDidShowStoreContactsPrompt(Landroid/accounts/AccountManager;Landroid/accounts/Account;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 412
    .end local v1    # "account":Landroid/accounts/Account;
    .end local v2    # "am":Landroid/accounts/AccountManager;
    .end local v4    # "isOnboarding":Z
    .end local v5    # "p":Lco/vine/android/widgets/PromptDialogSupportFragment;
    :cond_1
    :goto_0
    return-void

    .line 406
    .restart local v1    # "account":Landroid/accounts/Account;
    .restart local v2    # "am":Landroid/accounts/AccountManager;
    .restart local v4    # "isOnboarding":Z
    .restart local v5    # "p":Lco/vine/android/widgets/PromptDialogSupportFragment;
    :catch_0
    move-exception v3

    .line 407
    .local v3, "e":Ljava/lang/Exception;
    const-string v6, "Failed to show contact agreement box. "

    new-array v7, v8, [Ljava/lang/Object;

    invoke-static {v3, v6, v7}, Lco/vine/android/util/CrashUtil;->logException(Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_0
.end method

.method public onPause()V
    .locals 2

    .prologue
    .line 814
    invoke-super {p0}, Lco/vine/android/BaseCursorListFragment;->onPause()V

    .line 815
    invoke-virtual {p0}, Lco/vine/android/InboxFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    iget-object v1, p0, Lco/vine/android/InboxFragment;->mColorChangedReceiver:Landroid/content/BroadcastReceiver;

    invoke-virtual {v0, v1}, Landroid/support/v4/app/FragmentActivity;->unregisterReceiver(Landroid/content/BroadcastReceiver;)V

    .line 816
    return-void
.end method

.method public onPhotoImageLoaded(Ljava/util/HashMap;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/HashMap",
            "<",
            "Lco/vine/android/util/image/ImageKey;",
            "Lco/vine/android/util/image/UrlImage;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 819
    .local p1, "images":Ljava/util/HashMap;, "Ljava/util/HashMap<Lco/vine/android/util/image/ImageKey;Lco/vine/android/util/image/UrlImage;>;"
    iget-object v0, p0, Lco/vine/android/InboxFragment;->mInboxAdapter:Lco/vine/android/MessageBoxAdapter;

    if-eqz v0, :cond_0

    .line 820
    iget-object v0, p0, Lco/vine/android/InboxFragment;->mInboxAdapter:Lco/vine/android/MessageBoxAdapter;

    invoke-virtual {v0, p1}, Lco/vine/android/MessageBoxAdapter;->setUserImages(Ljava/util/HashMap;)V

    .line 822
    :cond_0
    iget-object v0, p0, Lco/vine/android/InboxFragment;->mFriendsAdapter:Lco/vine/android/MenuUsersAdapter;

    if-eqz v0, :cond_1

    .line 823
    iget-object v0, p0, Lco/vine/android/InboxFragment;->mFriendsAdapter:Lco/vine/android/MenuUsersAdapter;

    invoke-virtual {v0, p1}, Lco/vine/android/MenuUsersAdapter;->setUserImages(Ljava/util/HashMap;)V

    .line 825
    :cond_1
    iget-object v0, p0, Lco/vine/android/InboxFragment;->mOtherAdapter:Lco/vine/android/MessageBoxAdapter;

    if-eqz v0, :cond_2

    .line 826
    iget-object v0, p0, Lco/vine/android/InboxFragment;->mOtherAdapter:Lco/vine/android/MessageBoxAdapter;

    invoke-virtual {v0, p1}, Lco/vine/android/MessageBoxAdapter;->setUserImages(Ljava/util/HashMap;)V

    .line 828
    :cond_2
    return-void
.end method

.method public onResume()V
    .locals 6

    .prologue
    const/4 v5, 0x2

    const/4 v4, 0x4

    const/4 v3, 0x1

    const/4 v2, 0x0

    const/4 v1, 0x3

    .line 714
    invoke-super {p0}, Lco/vine/android/BaseCursorListFragment;->onResume()V

    .line 715
    iget-object v0, p0, Lco/vine/android/InboxFragment;->mInboxAdapter:Lco/vine/android/MessageBoxAdapter;

    invoke-virtual {v0}, Lco/vine/android/MessageBoxAdapter;->getCursor()Landroid/database/Cursor;

    move-result-object v0

    if-nez v0, :cond_4

    .line 716
    invoke-virtual {p0, v3}, Lco/vine/android/InboxFragment;->initLoader(I)V

    .line 720
    :cond_0
    :goto_0
    iget-object v0, p0, Lco/vine/android/InboxFragment;->mOtherAdapter:Lco/vine/android/MessageBoxAdapter;

    invoke-virtual {v0}, Lco/vine/android/MessageBoxAdapter;->getCursor()Landroid/database/Cursor;

    move-result-object v0

    if-nez v0, :cond_5

    .line 721
    invoke-virtual {p0, v4}, Lco/vine/android/InboxFragment;->initLoader(I)V

    .line 725
    :cond_1
    :goto_1
    iget-object v0, p0, Lco/vine/android/InboxFragment;->mFriendsAdapter:Lco/vine/android/MenuUsersAdapter;

    invoke-virtual {v0}, Lco/vine/android/MenuUsersAdapter;->getCursor()Landroid/database/Cursor;

    move-result-object v0

    if-nez v0, :cond_6

    .line 726
    invoke-virtual {p0, v5}, Lco/vine/android/InboxFragment;->initLoader(I)V

    .line 730
    :cond_2
    :goto_2
    iget-object v0, p0, Lco/vine/android/InboxFragment;->mAddressCursor:Landroid/database/Cursor;

    if-nez v0, :cond_3

    .line 731
    invoke-virtual {p0, v1}, Lco/vine/android/InboxFragment;->initLoader(I)V

    .line 733
    :cond_3
    invoke-virtual {p0}, Lco/vine/android/InboxFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    iget-object v1, p0, Lco/vine/android/InboxFragment;->mColorChangedReceiver:Landroid/content/BroadcastReceiver;

    sget-object v2, Lco/vine/android/util/Util;->COLOR_CHANGED_INTENT_FILTER:Landroid/content/IntentFilter;

    const-string v3, "co.vine.android.BROADCAST"

    const/4 v4, 0x0

    invoke-virtual {v0, v1, v2, v3, v4}, Landroid/support/v4/app/FragmentActivity;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;Ljava/lang/String;Landroid/os/Handler;)Landroid/content/Intent;

    .line 734
    return-void

    .line 717
    :cond_4
    iget-object v0, p0, Lco/vine/android/InboxFragment;->mInboxAdapter:Lco/vine/android/MessageBoxAdapter;

    invoke-virtual {v0}, Lco/vine/android/MessageBoxAdapter;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-virtual {p0, v3}, Lco/vine/android/InboxFragment;->isFetched(I)Z

    move-result v0

    if-nez v0, :cond_0

    .line 718
    invoke-virtual {p0, v1, v3, v2}, Lco/vine/android/InboxFragment;->fetchContent(IIZ)V

    goto :goto_0

    .line 722
    :cond_5
    iget-object v0, p0, Lco/vine/android/InboxFragment;->mOtherAdapter:Lco/vine/android/MessageBoxAdapter;

    invoke-virtual {v0}, Lco/vine/android/MessageBoxAdapter;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-virtual {p0, v4}, Lco/vine/android/InboxFragment;->isFetched(I)Z

    move-result v0

    if-nez v0, :cond_1

    .line 723
    invoke-virtual {p0, v1, v4, v2}, Lco/vine/android/InboxFragment;->fetchContent(IIZ)V

    goto :goto_1

    .line 727
    :cond_6
    iget-object v0, p0, Lco/vine/android/InboxFragment;->mFriendsAdapter:Lco/vine/android/MenuUsersAdapter;

    invoke-virtual {v0}, Lco/vine/android/MenuUsersAdapter;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_2

    invoke-virtual {p0, v5}, Lco/vine/android/InboxFragment;->isFetched(I)Z

    move-result v0

    if-nez v0, :cond_2

    .line 728
    invoke-virtual {p0, v1, v1, v2}, Lco/vine/android/InboxFragment;->fetchContent(IIZ)V

    goto :goto_2
.end method

.method protected onScrollLastItem(Landroid/database/Cursor;)V
    .locals 3
    .param p1, "cursor"    # Landroid/database/Cursor;

    .prologue
    .line 800
    iget-object v0, p0, Lco/vine/android/InboxFragment;->mActiveAdapter:Landroid/widget/BaseAdapter;

    iget-object v1, p0, Lco/vine/android/InboxFragment;->mSectionAdapter:Lco/vine/android/widget/SectionAdapter;

    if-ne v0, v1, :cond_0

    .line 801
    iget-object v0, p0, Lco/vine/android/InboxFragment;->mAnchorManager:Lco/vine/android/util/StringAnchorManager;

    invoke-virtual {v0}, Lco/vine/android/util/StringAnchorManager;->haveMore()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 802
    const/4 v0, 0x1

    const/4 v1, 0x2

    const/4 v2, 0x0

    invoke-virtual {p0, v0, v1, v2}, Lco/vine/android/InboxFragment;->fetchContent(IIZ)V

    .line 810
    :cond_0
    :goto_0
    return-void

    .line 804
    :cond_1
    iget-boolean v0, p0, Lco/vine/android/InboxFragment;->mIsAddressBookShowing:Z

    if-nez v0, :cond_2

    .line 805
    invoke-virtual {p0}, Lco/vine/android/InboxFragment;->addEntriesToAddressAdapter()V

    .line 807
    :cond_2
    const/4 v0, 0x3

    invoke-virtual {p0, v0}, Lco/vine/android/InboxFragment;->hideProgress(I)V

    goto :goto_0
.end method

.method protected refresh()V
    .locals 4

    .prologue
    const/4 v3, 0x2

    const/4 v2, 0x0

    .line 791
    iget-object v0, p0, Lco/vine/android/InboxFragment;->mActiveAdapter:Landroid/widget/BaseAdapter;

    iget-object v1, p0, Lco/vine/android/InboxFragment;->mSectionAdapter:Lco/vine/android/widget/SectionAdapter;

    if-ne v0, v1, :cond_0

    .line 792
    const/4 v0, 0x3

    invoke-virtual {p0, v3, v0, v2}, Lco/vine/android/InboxFragment;->fetchContent(IIZ)V

    .line 796
    :goto_0
    return-void

    .line 794
    :cond_0
    const/4 v0, 0x4

    invoke-virtual {p0, v3, v0, v2}, Lco/vine/android/InboxFragment;->fetchContent(IIZ)V

    goto :goto_0
.end method

.method protected setFetched(I)V
    .locals 1
    .param p1, "mode"    # I

    .prologue
    .line 341
    iget v0, p0, Lco/vine/android/InboxFragment;->mFetchFlags:I

    or-int/2addr v0, p1

    iput v0, p0, Lco/vine/android/InboxFragment;->mFetchFlags:I

    .line 342
    return-void
.end method

.method public setPersonalizedColor(I)V
    .locals 3
    .param p1, "profileBackground"    # I

    .prologue
    .line 415
    iput p1, p0, Lco/vine/android/InboxFragment;->mColor:I

    .line 416
    sget v0, Lco/vine/android/Settings;->DEFAULT_PROFILE_COLOR:I

    if-eq p1, v0, :cond_0

    if-gtz p1, :cond_1

    .line 417
    :cond_0
    const v0, 0xffffff

    invoke-virtual {p0}, Lco/vine/android/InboxFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f090096

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getColor(I)I

    move-result v1

    and-int p1, v0, v1

    .line 419
    :cond_1
    iget-object v0, p0, Lco/vine/android/InboxFragment;->mListView:Landroid/widget/ListView;

    if-eqz v0, :cond_2

    .line 420
    iget-object v0, p0, Lco/vine/android/InboxFragment;->mListView:Landroid/widget/ListView;

    check-cast v0, Lcom/twitter/android/widget/RefreshableListView;

    const/high16 v1, -0x1000000

    or-int/2addr v1, p1

    invoke-virtual {v0, v1}, Lcom/twitter/android/widget/RefreshableListView;->colorizePTR(I)V

    .line 422
    :cond_2
    return-void
.end method

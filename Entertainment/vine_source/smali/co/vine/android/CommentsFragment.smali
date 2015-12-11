.class public Lco/vine/android/CommentsFragment;
.super Lco/vine/android/BaseArrayListFragment;
.source "CommentsFragment.java"

# interfaces
.implements Lco/vine/android/widget/SpanClickListener;
.implements Landroid/view/View$OnClickListener;
.implements Landroid/widget/AdapterView$OnItemLongClickListener;
.implements Landroid/widget/AdapterView$OnItemClickListener;
.implements Landroid/widget/TextView$OnEditorActionListener;
.implements Landroid/widget/Filterable;
.implements Lco/vine/android/widget/PopupEditText$PopupEditTextListener;
.implements Lco/vine/android/widget/ConversationList$GetMoreListener;
.implements Landroid/text/TextWatcher;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lco/vine/android/CommentsFragment$CommentsAppSessionListener;
    }
.end annotation


# static fields
.field public static final ARG_HIDE_KEYBOARD:Ljava/lang/String; = "hide_keyboard"

.field public static final ARG_POST_AUTHOR_ID:Ljava/lang/String; = "post_author_id"

.field public static final ARG_POST_ID:Ljava/lang/String; = "post_id"

.field public static final DEFAULT_PAGE_SIZE:I = 0x14

.field private static final EVENT_SOURCE_TITLE:Ljava/lang/String; = "Comments List"

.field private static final MAX_CHARS:I = 0x8c

.field private static final STATE_FETCHED:Ljava/lang/String; = "fetched"

.field private static mActionMode:Landroid/support/v7/view/ActionMode;

.field private static mSelectedCommentId:Ljava/lang/String;


# instance fields
.field private final DATE_FORMAT:Ljava/text/SimpleDateFormat;

.field private final mActionModeCallback:Landroid/support/v7/view/ActionMode$Callback;

.field private mAnchor:J

.field private mEdit:Lco/vine/android/widget/PopupEditText;

.field private mFetched:Z

.field private mFilter:Landroid/widget/Filter;

.field private mLastTopItemId:J

.field private mLastTopItemPixelOffset:I

.field private mNextPage:I

.field private mPostAuthorId:J

.field private mPostId:J

.field private mSelectedView:Landroid/view/View;

.field private mSendButton:Landroid/widget/ImageView;

.field private mTagsAdapter:Lco/vine/android/TagsAutoCompleteAdapter;

.field private mTokenizer:Lco/vine/android/ComposeTokenizer;

.field private mTypeaheadAdapter:Landroid/support/v4/widget/CursorAdapter;

.field private mUsersAdapter:Lco/vine/android/UsersAutoCompleteAdapter;


# direct methods
.method public constructor <init>()V
    .locals 2

    .prologue
    .line 56
    invoke-direct {p0}, Lco/vine/android/BaseArrayListFragment;-><init>()V

    .line 72
    new-instance v0, Ljava/text/SimpleDateFormat;

    invoke-direct {v0}, Ljava/text/SimpleDateFormat;-><init>()V

    iput-object v0, p0, Lco/vine/android/CommentsFragment;->DATE_FORMAT:Ljava/text/SimpleDateFormat;

    .line 85
    const-wide/16 v0, -0x1

    iput-wide v0, p0, Lco/vine/android/CommentsFragment;->mLastTopItemId:J

    .line 86
    const/4 v0, 0x0

    iput v0, p0, Lco/vine/android/CommentsFragment;->mLastTopItemPixelOffset:I

    .line 89
    const-wide/16 v0, 0x0

    iput-wide v0, p0, Lco/vine/android/CommentsFragment;->mAnchor:J

    .line 90
    const/4 v0, 0x1

    iput v0, p0, Lco/vine/android/CommentsFragment;->mNextPage:I

    .line 341
    new-instance v0, Lco/vine/android/CommentsFragment$1;

    invoke-direct {v0, p0}, Lco/vine/android/CommentsFragment$1;-><init>(Lco/vine/android/CommentsFragment;)V

    iput-object v0, p0, Lco/vine/android/CommentsFragment;->mActionModeCallback:Landroid/support/v7/view/ActionMode$Callback;

    .line 484
    return-void
.end method

.method static synthetic access$000(Lco/vine/android/CommentsFragment;)J
    .locals 2
    .param p0, "x0"    # Lco/vine/android/CommentsFragment;

    .prologue
    .line 56
    iget-wide v0, p0, Lco/vine/android/CommentsFragment;->mPostId:J

    return-wide v0
.end method

.method static synthetic access$100()Ljava/lang/String;
    .locals 1

    .prologue
    .line 56
    sget-object v0, Lco/vine/android/CommentsFragment;->mSelectedCommentId:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$1000(Lco/vine/android/CommentsFragment;)Lco/vine/android/UsersAutoCompleteAdapter;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/CommentsFragment;

    .prologue
    .line 56
    iget-object v0, p0, Lco/vine/android/CommentsFragment;->mUsersAdapter:Lco/vine/android/UsersAutoCompleteAdapter;

    return-object v0
.end method

.method static synthetic access$1100(Lco/vine/android/CommentsFragment;)Lco/vine/android/widget/PopupEditText;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/CommentsFragment;

    .prologue
    .line 56
    iget-object v0, p0, Lco/vine/android/CommentsFragment;->mEdit:Lco/vine/android/widget/PopupEditText;

    return-object v0
.end method

.method static synthetic access$200(Lco/vine/android/CommentsFragment;)Landroid/view/View;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/CommentsFragment;

    .prologue
    .line 56
    iget-object v0, p0, Lco/vine/android/CommentsFragment;->mSelectedView:Landroid/view/View;

    return-object v0
.end method

.method static synthetic access$302(Landroid/support/v7/view/ActionMode;)Landroid/support/v7/view/ActionMode;
    .locals 0
    .param p0, "x0"    # Landroid/support/v7/view/ActionMode;

    .prologue
    .line 56
    sput-object p0, Lco/vine/android/CommentsFragment;->mActionMode:Landroid/support/v7/view/ActionMode;

    return-object p0
.end method

.method static synthetic access$400(Lco/vine/android/CommentsFragment;)I
    .locals 1
    .param p0, "x0"    # Lco/vine/android/CommentsFragment;

    .prologue
    .line 56
    iget v0, p0, Lco/vine/android/CommentsFragment;->mNextPage:I

    return v0
.end method

.method static synthetic access$402(Lco/vine/android/CommentsFragment;I)I
    .locals 0
    .param p0, "x0"    # Lco/vine/android/CommentsFragment;
    .param p1, "x1"    # I

    .prologue
    .line 56
    iput p1, p0, Lco/vine/android/CommentsFragment;->mNextPage:I

    return p1
.end method

.method static synthetic access$502(Lco/vine/android/CommentsFragment;J)J
    .locals 0
    .param p0, "x0"    # Lco/vine/android/CommentsFragment;
    .param p1, "x1"    # J

    .prologue
    .line 56
    iput-wide p1, p0, Lco/vine/android/CommentsFragment;->mAnchor:J

    return-wide p1
.end method

.method static synthetic access$600(Lco/vine/android/CommentsFragment;)V
    .locals 0
    .param p0, "x0"    # Lco/vine/android/CommentsFragment;

    .prologue
    .line 56
    invoke-direct {p0}, Lco/vine/android/CommentsFragment;->saveTopItemInfo()V

    return-void
.end method

.method static synthetic access$700(Lco/vine/android/CommentsFragment;)J
    .locals 2
    .param p0, "x0"    # Lco/vine/android/CommentsFragment;

    .prologue
    .line 56
    iget-wide v0, p0, Lco/vine/android/CommentsFragment;->mLastTopItemId:J

    return-wide v0
.end method

.method static synthetic access$800(Lco/vine/android/CommentsFragment;)I
    .locals 1
    .param p0, "x0"    # Lco/vine/android/CommentsFragment;

    .prologue
    .line 56
    iget v0, p0, Lco/vine/android/CommentsFragment;->mLastTopItemPixelOffset:I

    return v0
.end method

.method static synthetic access$900(Lco/vine/android/CommentsFragment;)Z
    .locals 1
    .param p0, "x0"    # Lco/vine/android/CommentsFragment;

    .prologue
    .line 56
    iget-boolean v0, p0, Lco/vine/android/CommentsFragment;->mFetched:Z

    return v0
.end method

.method private editTextLength()I
    .locals 1

    .prologue
    .line 255
    iget-object v0, p0, Lco/vine/android/CommentsFragment;->mEdit:Lco/vine/android/widget/PopupEditText;

    invoke-virtual {v0}, Lco/vine/android/widget/PopupEditText;->getText()Landroid/text/Editable;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v0

    return v0
.end method

.method private fetchContent()V
    .locals 7

    .prologue
    .line 207
    invoke-virtual {p0}, Lco/vine/android/CommentsFragment;->hasPendingRequest()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 212
    :goto_0
    return-void

    .line 210
    :cond_0
    const/4 v0, 0x1

    iput-boolean v0, p0, Lco/vine/android/CommentsFragment;->mFetched:Z

    .line 211
    iget-object v0, p0, Lco/vine/android/CommentsFragment;->mAppController:Lco/vine/android/client/AppController;

    iget-wide v1, p0, Lco/vine/android/CommentsFragment;->mPostId:J

    iget v3, p0, Lco/vine/android/CommentsFragment;->mNextPage:I

    iget-wide v4, p0, Lco/vine/android/CommentsFragment;->mAnchor:J

    const/16 v6, 0x14

    invoke-virtual/range {v0 .. v6}, Lco/vine/android/client/AppController;->fetchComments(JIJI)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lco/vine/android/CommentsFragment;->addRequest(Ljava/lang/String;)Ljava/lang/String;

    goto :goto_0
.end method

.method private insertText(Ljava/lang/String;)V
    .locals 3
    .param p1, "toInsert"    # Ljava/lang/String;

    .prologue
    .line 191
    iget-object v2, p0, Lco/vine/android/CommentsFragment;->mEdit:Lco/vine/android/widget/PopupEditText;

    if-eqz v2, :cond_0

    .line 192
    iget-object v2, p0, Lco/vine/android/CommentsFragment;->mEdit:Lco/vine/android/widget/PopupEditText;

    invoke-virtual {v2}, Lco/vine/android/widget/PopupEditText;->getSelectionStart()I

    move-result v1

    .line 193
    .local v1, "selStart":I
    iget-object v2, p0, Lco/vine/android/CommentsFragment;->mEdit:Lco/vine/android/widget/PopupEditText;

    invoke-virtual {v2}, Lco/vine/android/widget/PopupEditText;->getSelectionEnd()I

    move-result v0

    .line 194
    .local v0, "selEnd":I
    iget-object v2, p0, Lco/vine/android/CommentsFragment;->mEdit:Lco/vine/android/widget/PopupEditText;

    invoke-virtual {v2}, Lco/vine/android/widget/PopupEditText;->getText()Landroid/text/Editable;

    move-result-object v2

    if-eqz v2, :cond_0

    if-ltz v1, :cond_0

    iget-object v2, p0, Lco/vine/android/CommentsFragment;->mEdit:Lco/vine/android/widget/PopupEditText;

    invoke-virtual {v2}, Lco/vine/android/widget/PopupEditText;->length()I

    move-result v2

    if-gt v0, v2, :cond_0

    .line 195
    iget-object v2, p0, Lco/vine/android/CommentsFragment;->mEdit:Lco/vine/android/widget/PopupEditText;

    invoke-virtual {v2}, Lco/vine/android/widget/PopupEditText;->getText()Landroid/text/Editable;

    move-result-object v2

    invoke-interface {v2, v1, v0, p1}, Landroid/text/Editable;->replace(IILjava/lang/CharSequence;)Landroid/text/Editable;

    .line 198
    .end local v0    # "selEnd":I
    .end local v1    # "selStart":I
    :cond_0
    return-void
.end method

.method private saveTopItemInfo()V
    .locals 4

    .prologue
    .line 215
    iget-object v1, p0, Lco/vine/android/CommentsFragment;->mAdapter:Landroid/widget/BaseAdapter;

    invoke-virtual {v1}, Landroid/widget/BaseAdapter;->getCount()I

    move-result v1

    if-nez v1, :cond_1

    .line 223
    :cond_0
    :goto_0
    return-void

    .line 218
    :cond_1
    iget-object v1, p0, Lco/vine/android/CommentsFragment;->mAdapter:Landroid/widget/BaseAdapter;

    iget-object v2, p0, Lco/vine/android/CommentsFragment;->mListView:Landroid/widget/ListView;

    invoke-virtual {v2}, Landroid/widget/ListView;->getFirstVisiblePosition()I

    move-result v2

    invoke-virtual {v1, v2}, Landroid/widget/BaseAdapter;->getItemId(I)J

    move-result-wide v1

    iput-wide v1, p0, Lco/vine/android/CommentsFragment;->mLastTopItemId:J

    .line 219
    iget-object v1, p0, Lco/vine/android/CommentsFragment;->mListView:Landroid/widget/ListView;

    iget-object v2, p0, Lco/vine/android/CommentsFragment;->mListView:Landroid/widget/ListView;

    invoke-virtual {v2}, Landroid/widget/ListView;->getFirstVisiblePosition()I

    move-result v2

    iget-object v3, p0, Lco/vine/android/CommentsFragment;->mListView:Landroid/widget/ListView;

    invoke-virtual {v3}, Landroid/widget/ListView;->getHeaderViewsCount()I

    move-result v3

    add-int/2addr v2, v3

    invoke-virtual {v1, v2}, Landroid/widget/ListView;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    .line 220
    .local v0, "topChild":Landroid/view/View;
    if-eqz v0, :cond_0

    .line 221
    invoke-virtual {v0}, Landroid/view/View;->getTop()I

    move-result v1

    iput v1, p0, Lco/vine/android/CommentsFragment;->mLastTopItemPixelOffset:I

    goto :goto_0
.end method

.method private sendComment()V
    .locals 3

    .prologue
    .line 331
    invoke-direct {p0}, Lco/vine/android/CommentsFragment;->editTextLength()I

    move-result v0

    const/16 v1, 0x8c

    if-le v0, v1, :cond_0

    .line 332
    invoke-virtual {p0}, Lco/vine/android/CommentsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    const v1, 0x7f0e0063

    invoke-static {v0, v1}, Lco/vine/android/util/Util;->showTopToast(Landroid/content/Context;I)V

    .line 338
    :goto_0
    return-void

    .line 334
    :cond_0
    iget-object v0, p0, Lco/vine/android/CommentsFragment;->mEdit:Lco/vine/android/widget/PopupEditText;

    invoke-virtual {p0, v0}, Lco/vine/android/CommentsFragment;->postComment(Landroid/widget/EditText;)V

    .line 335
    invoke-virtual {p0}, Lco/vine/android/CommentsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    iget-object v1, p0, Lco/vine/android/CommentsFragment;->mEdit:Lco/vine/android/widget/PopupEditText;

    const/4 v2, 0x0

    invoke-static {v0, v1, v2}, Lco/vine/android/util/Util;->setSoftKeyboardVisibility(Landroid/content/Context;Landroid/view/View;Z)V

    .line 336
    iget-object v0, p0, Lco/vine/android/CommentsFragment;->mEdit:Lco/vine/android/widget/PopupEditText;

    invoke-virtual {v0}, Lco/vine/android/widget/PopupEditText;->clearFocus()V

    goto :goto_0
.end method

.method private validate(Landroid/widget/EditText;)Z
    .locals 1
    .param p1, "editText"    # Landroid/widget/EditText;

    .prologue
    .line 251
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
    .locals 0
    .param p1, "s"    # Landroid/text/Editable;

    .prologue
    .line 482
    return-void
.end method

.method public beforeTextChanged(Ljava/lang/CharSequence;III)V
    .locals 0
    .param p1, "s"    # Ljava/lang/CharSequence;
    .param p2, "start"    # I
    .param p3, "count"    # I
    .param p4, "after"    # I

    .prologue
    .line 468
    return-void
.end method

.method public getFilter()Landroid/widget/Filter;
    .locals 3

    .prologue
    .line 389
    iget-object v2, p0, Lco/vine/android/CommentsFragment;->mFilter:Landroid/widget/Filter;

    if-nez v2, :cond_0

    .line 390
    iget-object v2, p0, Lco/vine/android/CommentsFragment;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v2}, Lco/vine/android/client/AppController;->getActiveId()J

    move-result-wide v0

    .line 391
    .local v0, "activeId":J
    new-instance v2, Lco/vine/android/ComposeFilter;

    invoke-direct {v2, p0, v0, v1}, Lco/vine/android/ComposeFilter;-><init>(Lco/vine/android/widget/PopupEditText$PopupEditTextListener;J)V

    iput-object v2, p0, Lco/vine/android/CommentsFragment;->mFilter:Landroid/widget/Filter;

    .line 393
    .end local v0    # "activeId":J
    :cond_0
    iget-object v2, p0, Lco/vine/android/CommentsFragment;->mFilter:Landroid/widget/Filter;

    return-object v2
.end method

.method public getMore()V
    .locals 0

    .prologue
    .line 446
    invoke-direct {p0}, Lco/vine/android/CommentsFragment;->fetchContent()V

    .line 447
    return-void
.end method

.method public getPopupAdapter()Landroid/support/v4/widget/CursorAdapter;
    .locals 1

    .prologue
    .line 374
    iget-object v0, p0, Lco/vine/android/CommentsFragment;->mTypeaheadAdapter:Landroid/support/v4/widget/CursorAdapter;

    return-object v0
.end method

.method public hideProgress(I)V
    .locals 1
    .param p1, "fetchType"    # I

    .prologue
    .line 459
    invoke-super {p0, p1}, Lco/vine/android/BaseArrayListFragment;->hideProgress(I)V

    .line 460
    const/4 v0, 0x1

    if-ne p1, v0, :cond_0

    .line 461
    iget-object v0, p0, Lco/vine/android/CommentsFragment;->mListView:Landroid/widget/ListView;

    check-cast v0, Lco/vine/android/widget/ConversationList;

    invoke-virtual {v0}, Lco/vine/android/widget/ConversationList;->hideProgress()V

    .line 463
    :cond_0
    return-void
.end method

.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 4
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 143
    invoke-super {p0, p1}, Lco/vine/android/BaseArrayListFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 144
    invoke-virtual {p0}, Lco/vine/android/CommentsFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v1

    const-string v2, "hide_keyboard"

    const/4 v3, 0x0

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    .line 145
    .local v0, "hideKeyboard":Z
    if-nez v0, :cond_0

    .line 146
    iget-object v1, p0, Lco/vine/android/CommentsFragment;->mEdit:Lco/vine/android/widget/PopupEditText;

    invoke-virtual {v1}, Lco/vine/android/widget/PopupEditText;->requestFocus()Z

    .line 147
    invoke-virtual {p0}, Lco/vine/android/CommentsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    iget-object v2, p0, Lco/vine/android/CommentsFragment;->mEdit:Lco/vine/android/widget/PopupEditText;

    const/4 v3, 0x1

    invoke-static {v1, v2, v3}, Lco/vine/android/util/Util;->setSoftKeyboardVisibility(Landroid/content/Context;Landroid/view/View;Z)V

    .line 149
    :cond_0
    return-void
.end method

.method public onClick(Landroid/view/View;)V
    .locals 5
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 260
    invoke-virtual {p1}, Landroid/view/View;->getId()I

    move-result v1

    packed-switch v1, :pswitch_data_0

    .line 266
    invoke-virtual {p1}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lco/vine/android/CommentViewHolder;

    .line 267
    .local v0, "h":Lco/vine/android/CommentViewHolder;
    invoke-virtual {p0}, Lco/vine/android/CommentsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    iget-wide v2, v0, Lco/vine/android/CommentViewHolder;->userId:J

    const-string v4, "Comments List"

    invoke-static {v1, v2, v3, v4}, Lco/vine/android/ProfileActivity;->start(Landroid/content/Context;JLjava/lang/String;)V

    .line 271
    .end local v0    # "h":Lco/vine/android/CommentViewHolder;
    :goto_0
    return-void

    .line 262
    :pswitch_0
    invoke-direct {p0}, Lco/vine/android/CommentsFragment;->sendComment()V

    goto :goto_0

    .line 260
    nop

    :pswitch_data_0
    .packed-switch 0x7f0a0082
        :pswitch_0
    .end packed-switch
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 3
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 94
    invoke-super {p0, p1}, Lco/vine/android/BaseArrayListFragment;->onCreate(Landroid/os/Bundle;)V

    .line 95
    iget-object v0, p0, Lco/vine/android/CommentsFragment;->DATE_FORMAT:Ljava/text/SimpleDateFormat;

    invoke-virtual {p0}, Lco/vine/android/CommentsFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f0e00ab

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/text/SimpleDateFormat;->applyPattern(Ljava/lang/String;)V

    .line 97
    if-eqz p1, :cond_0

    .line 98
    const-string v0, "fetched"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 99
    const-string v0, "fetched"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v0

    iput-boolean v0, p0, Lco/vine/android/CommentsFragment;->mFetched:Z

    .line 103
    :cond_0
    new-instance v0, Lco/vine/android/CommentsFragment$CommentsAppSessionListener;

    invoke-direct {v0, p0}, Lco/vine/android/CommentsFragment$CommentsAppSessionListener;-><init>(Lco/vine/android/CommentsFragment;)V

    iput-object v0, p0, Lco/vine/android/CommentsFragment;->mAppSessionListener:Lco/vine/android/client/AppSessionListener;

    .line 104
    new-instance v0, Lco/vine/android/UsersAutoCompleteAdapter;

    invoke-virtual {p0}, Lco/vine/android/CommentsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    iget-object v2, p0, Lco/vine/android/CommentsFragment;->mAppController:Lco/vine/android/client/AppController;

    invoke-direct {v0, v1, v2}, Lco/vine/android/UsersAutoCompleteAdapter;-><init>(Landroid/app/Activity;Lco/vine/android/client/AppController;)V

    iput-object v0, p0, Lco/vine/android/CommentsFragment;->mUsersAdapter:Lco/vine/android/UsersAutoCompleteAdapter;

    .line 105
    new-instance v0, Lco/vine/android/TagsAutoCompleteAdapter;

    invoke-virtual {p0}, Lco/vine/android/CommentsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    iget-object v2, p0, Lco/vine/android/CommentsFragment;->mAppController:Lco/vine/android/client/AppController;

    invoke-direct {v0, v1, v2}, Lco/vine/android/TagsAutoCompleteAdapter;-><init>(Landroid/app/Activity;Lco/vine/android/client/AppController;)V

    iput-object v0, p0, Lco/vine/android/CommentsFragment;->mTagsAdapter:Lco/vine/android/TagsAutoCompleteAdapter;

    .line 106
    iget-object v0, p0, Lco/vine/android/CommentsFragment;->mTagsAdapter:Lco/vine/android/TagsAutoCompleteAdapter;

    iput-object v0, p0, Lco/vine/android/CommentsFragment;->mTypeaheadAdapter:Landroid/support/v4/widget/CursorAdapter;

    .line 108
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lco/vine/android/CommentsFragment;->setHasOptionsMenu(Z)V

    .line 109
    return-void
.end method

.method public onCreateOptionsMenu(Landroid/view/Menu;Landroid/view/MenuInflater;)V
    .locals 1
    .param p1, "menu"    # Landroid/view/Menu;
    .param p2, "inflater"    # Landroid/view/MenuInflater;

    .prologue
    .line 168
    const v0, 0x7f100002

    invoke-virtual {p2, v0, p1}, Landroid/view/MenuInflater;->inflate(ILandroid/view/Menu;)V

    .line 169
    invoke-super {p0, p1, p2}, Lco/vine/android/BaseArrayListFragment;->onCreateOptionsMenu(Landroid/view/Menu;Landroid/view/MenuInflater;)V

    .line 170
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 1
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 114
    const v0, 0x7f030026

    invoke-virtual {p0, p1, v0, p2}, Lco/vine/android/CommentsFragment;->createView(Landroid/view/LayoutInflater;ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method public onDestroy()V
    .locals 0

    .prologue
    .line 161
    invoke-super {p0}, Lco/vine/android/BaseArrayListFragment;->onDestroy()V

    .line 162
    invoke-static {}, Lco/vine/android/provider/VineSuggestionsProvider;->clearRealtimeUserSuggestions()V

    .line 163
    invoke-static {}, Lco/vine/android/provider/VineSuggestionsProvider;->clearRealtimeTagSuggestions()V

    .line 164
    return-void
.end method

.method public onEditorAction(Landroid/widget/TextView;ILandroid/view/KeyEvent;)Z
    .locals 1
    .param p1, "v"    # Landroid/widget/TextView;
    .param p2, "actionId"    # I
    .param p3, "event"    # Landroid/view/KeyEvent;

    .prologue
    .line 317
    invoke-virtual {p1}, Landroid/widget/TextView;->getId()I

    move-result v0

    packed-switch v0, :pswitch_data_0

    .line 325
    const/4 v0, 0x0

    :goto_0
    return v0

    .line 319
    :pswitch_0
    const/4 v0, 0x4

    if-ne p2, v0, :cond_0

    .line 320
    invoke-direct {p0}, Lco/vine/android/CommentsFragment;->sendComment()V

    .line 322
    :cond_0
    const/4 v0, 0x1

    goto :goto_0

    .line 317
    nop

    :pswitch_data_0
    .packed-switch 0x7f0a0083
        :pswitch_0
    .end packed-switch
.end method

.method public onFiltering(Ljava/lang/CharSequence;)V
    .locals 7
    .param p1, "constraint"    # Ljava/lang/CharSequence;

    .prologue
    const/4 v5, 0x0

    const/4 v0, 0x1

    .line 406
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v6

    if-nez v6, :cond_0

    .line 408
    invoke-interface {p1}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v3

    .line 411
    .local v3, "selection":Ljava/lang/String;
    const-string v6, "@"

    invoke-virtual {v3, v6}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_1

    .line 412
    const-string v4, "mention"

    .line 413
    .local v4, "type":Ljava/lang/String;
    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v6

    invoke-virtual {v3, v0, v6}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v2

    .line 421
    .local v2, "query":Ljava/lang/String;
    :goto_0
    iget-object v6, p0, Lco/vine/android/CommentsFragment;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v6, v4}, Lco/vine/android/client/AppController;->getTypeaheadFetchThreshold(Ljava/lang/String;)I

    move-result v1

    .line 423
    .local v1, "fetchThreshold":I
    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v6

    if-nez v6, :cond_0

    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v6

    if-lt v6, v1, :cond_0

    .line 425
    const-string v6, "mention"

    invoke-virtual {v6, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_4

    .line 426
    invoke-static {v2}, Lco/vine/android/provider/VineSuggestionsProvider;->getRealtimeUserSuggestions(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v6

    if-nez v6, :cond_3

    .line 433
    .local v0, "fetch":Z
    :goto_1
    if-eqz v0, :cond_0

    .line 434
    const-string v5, "mention"

    invoke-virtual {v5, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_7

    .line 435
    iget-object v5, p0, Lco/vine/android/CommentsFragment;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v5, v2}, Lco/vine/android/client/AppController;->fetchUserTypeahead(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {p0, v5}, Lco/vine/android/CommentsFragment;->addRequest(Ljava/lang/String;)Ljava/lang/String;

    .line 442
    .end local v0    # "fetch":Z
    .end local v1    # "fetchThreshold":I
    .end local v2    # "query":Ljava/lang/String;
    .end local v3    # "selection":Ljava/lang/String;
    .end local v4    # "type":Ljava/lang/String;
    :cond_0
    :goto_2
    return-void

    .line 414
    .restart local v3    # "selection":Ljava/lang/String;
    :cond_1
    const-string v6, "#"

    invoke-virtual {v3, v6}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_2

    .line 415
    const-string v4, "tag"

    .line 416
    .restart local v4    # "type":Ljava/lang/String;
    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v6

    invoke-virtual {v3, v0, v6}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v2

    .restart local v2    # "query":Ljava/lang/String;
    goto :goto_0

    .line 418
    .end local v2    # "query":Ljava/lang/String;
    .end local v4    # "type":Ljava/lang/String;
    :cond_2
    const/4 v4, 0x0

    .line 419
    .restart local v4    # "type":Ljava/lang/String;
    const/4 v2, 0x0

    .restart local v2    # "query":Ljava/lang/String;
    goto :goto_0

    .restart local v1    # "fetchThreshold":I
    :cond_3
    move v0, v5

    .line 426
    goto :goto_1

    .line 427
    :cond_4
    const-string v6, "tag"

    invoke-virtual {v6, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_6

    .line 428
    invoke-static {v2}, Lco/vine/android/provider/VineSuggestionsProvider;->getRealtimeTagSuggestions(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v6

    if-nez v6, :cond_5

    .restart local v0    # "fetch":Z
    :goto_3
    goto :goto_1

    .end local v0    # "fetch":Z
    :cond_5
    move v0, v5

    goto :goto_3

    .line 430
    :cond_6
    const/4 v0, 0x0

    .restart local v0    # "fetch":Z
    goto :goto_1

    .line 436
    :cond_7
    const-string v5, "tag"

    invoke-virtual {v5, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_0

    .line 437
    iget-object v5, p0, Lco/vine/android/CommentsFragment;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v5, v2}, Lco/vine/android/client/AppController;->fetchTagTypeahead(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {p0, v5}, Lco/vine/android/CommentsFragment;->addRequest(Ljava/lang/String;)Ljava/lang/String;

    goto :goto_2
.end method

.method public onItemClick(Landroid/widget/AdapterView;Landroid/view/View;IJ)V
    .locals 5
    .param p2, "view"    # Landroid/view/View;
    .param p3, "i"    # I
    .param p4, "l"    # J
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
    .line 246
    .local p1, "adapterView":Landroid/widget/AdapterView;, "Landroid/widget/AdapterView<*>;"
    invoke-virtual {p2}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lco/vine/android/CommentViewHolder;

    .line 247
    .local v0, "h":Lco/vine/android/CommentViewHolder;
    invoke-virtual {p0}, Lco/vine/android/CommentsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    iget-wide v2, v0, Lco/vine/android/CommentViewHolder;->userId:J

    const-string v4, "Comments List"

    invoke-static {v1, v2, v3, v4}, Lco/vine/android/ProfileActivity;->start(Landroid/content/Context;JLjava/lang/String;)V

    .line 248
    return-void
.end method

.method public onItemLongClick(Landroid/widget/AdapterView;Landroid/view/View;IJ)Z
    .locals 7
    .param p2, "view"    # Landroid/view/View;
    .param p3, "i"    # I
    .param p4, "l"    # J
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/widget/AdapterView",
            "<*>;",
            "Landroid/view/View;",
            "IJ)Z"
        }
    .end annotation

    .prologue
    .local p1, "adapterView":Landroid/widget/AdapterView;, "Landroid/widget/AdapterView<*>;"
    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 292
    sget-object v5, Lco/vine/android/CommentsFragment;->mActionMode:Landroid/support/v7/view/ActionMode;

    if-eqz v5, :cond_1

    .line 312
    :cond_0
    :goto_0
    return v3

    .line 297
    :cond_1
    invoke-virtual {p2}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v5

    instance-of v5, v5, Lco/vine/android/CommentViewHolder;

    if-eqz v5, :cond_0

    .line 300
    invoke-virtual {p2}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lco/vine/android/CommentViewHolder;

    .line 303
    .local v0, "commentViewHolder":Lco/vine/android/CommentViewHolder;
    iget-object v5, p0, Lco/vine/android/CommentsFragment;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v5}, Lco/vine/android/client/AppController;->getActiveId()J

    move-result-wide v1

    .line 304
    .local v1, "userId":J
    iget-wide v5, v0, Lco/vine/android/CommentViewHolder;->userId:J

    cmp-long v5, v1, v5

    if-eqz v5, :cond_2

    iget-wide v5, p0, Lco/vine/android/CommentsFragment;->mPostAuthorId:J

    cmp-long v5, v1, v5

    if-nez v5, :cond_0

    .line 308
    :cond_2
    iput-object p2, p0, Lco/vine/android/CommentsFragment;->mSelectedView:Landroid/view/View;

    .line 309
    iget-object v3, p0, Lco/vine/android/CommentsFragment;->mSelectedView:Landroid/view/View;

    invoke-virtual {v3, v4}, Landroid/view/View;->setSelected(Z)V

    .line 310
    invoke-virtual {p2}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lco/vine/android/CommentViewHolder;

    iget-object v3, v3, Lco/vine/android/CommentViewHolder;->commentId:Ljava/lang/String;

    sput-object v3, Lco/vine/android/CommentsFragment;->mSelectedCommentId:Ljava/lang/String;

    .line 311
    invoke-virtual {p0}, Lco/vine/android/CommentsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v3

    check-cast v3, Landroid/support/v7/app/ActionBarActivity;

    iget-object v5, p0, Lco/vine/android/CommentsFragment;->mActionModeCallback:Landroid/support/v7/view/ActionMode$Callback;

    invoke-virtual {v3, v5}, Landroid/support/v7/app/ActionBarActivity;->startSupportActionMode(Landroid/support/v7/view/ActionMode$Callback;)Landroid/support/v7/view/ActionMode;

    move-result-object v3

    sput-object v3, Lco/vine/android/CommentsFragment;->mActionMode:Landroid/support/v7/view/ActionMode;

    move v3, v4

    .line 312
    goto :goto_0
.end method

.method protected onListItemClick(Landroid/widget/ListView;Landroid/view/View;IJ)V
    .locals 0
    .param p1, "l"    # Landroid/widget/ListView;
    .param p2, "v"    # Landroid/view/View;
    .param p3, "position"    # I
    .param p4, "id"    # J

    .prologue
    .line 241
    invoke-super/range {p0 .. p5}, Lco/vine/android/BaseArrayListFragment;->onListItemClick(Landroid/widget/ListView;Landroid/view/View;IJ)V

    .line 242
    return-void
.end method

.method public onOptionsItemSelected(Landroid/view/MenuItem;)Z
    .locals 1
    .param p1, "item"    # Landroid/view/MenuItem;

    .prologue
    .line 174
    invoke-interface {p1}, Landroid/view/MenuItem;->getItemId()I

    move-result v0

    packed-switch v0, :pswitch_data_0

    .line 184
    invoke-super {p0, p1}, Lco/vine/android/BaseArrayListFragment;->onOptionsItemSelected(Landroid/view/MenuItem;)Z

    move-result v0

    .line 187
    :goto_0
    return v0

    .line 176
    :pswitch_0
    const-string v0, "@"

    invoke-direct {p0, v0}, Lco/vine/android/CommentsFragment;->insertText(Ljava/lang/String;)V

    .line 187
    :goto_1
    const/4 v0, 0x1

    goto :goto_0

    .line 180
    :pswitch_1
    const-string v0, "#"

    invoke-direct {p0, v0}, Lco/vine/android/CommentsFragment;->insertText(Ljava/lang/String;)V

    goto :goto_1

    .line 174
    nop

    :pswitch_data_0
    .packed-switch 0x7f0a023e
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method public onPopupItemSelected(IILjava/lang/CharSequence;J)V
    .locals 0
    .param p1, "tokenStart"    # I
    .param p2, "tokenEnd"    # I
    .param p3, "selection"    # Ljava/lang/CharSequence;
    .param p4, "userId"    # J

    .prologue
    .line 398
    return-void
.end method

.method public onPopupShown()V
    .locals 0

    .prologue
    .line 402
    return-void
.end method

.method public onResume()V
    .locals 1

    .prologue
    .line 153
    invoke-super {p0}, Lco/vine/android/BaseArrayListFragment;->onResume()V

    .line 154
    iget-object v0, p0, Lco/vine/android/CommentsFragment;->mAdapter:Landroid/widget/BaseAdapter;

    invoke-virtual {v0}, Landroid/widget/BaseAdapter;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_0

    iget-boolean v0, p0, Lco/vine/android/CommentsFragment;->mFetched:Z

    if-nez v0, :cond_0

    .line 155
    invoke-direct {p0}, Lco/vine/android/CommentsFragment;->fetchContent()V

    .line 157
    :cond_0
    return-void
.end method

.method public onSaveInstanceState(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "outState"    # Landroid/os/Bundle;

    .prologue
    .line 202
    invoke-super {p0, p1}, Lco/vine/android/BaseArrayListFragment;->onSaveInstanceState(Landroid/os/Bundle;)V

    .line 203
    const-string v0, "fetched"

    iget-boolean v1, p0, Lco/vine/android/CommentsFragment;->mFetched:Z

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 204
    return-void
.end method

.method public onSpanClicked(Landroid/view/View;ILjava/lang/Object;)V
    .locals 4
    .param p1, "view"    # Landroid/view/View;
    .param p2, "type"    # I
    .param p3, "tag"    # Ljava/lang/Object;

    .prologue
    .line 275
    packed-switch p2, :pswitch_data_0

    .line 288
    .end local p3    # "tag":Ljava/lang/Object;
    :goto_0
    :pswitch_0
    return-void

    .line 277
    .restart local p3    # "tag":Ljava/lang/Object;
    :pswitch_1
    invoke-virtual {p0}, Lco/vine/android/CommentsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast p3, Ljava/lang/Long;

    .end local p3    # "tag":Ljava/lang/Object;
    invoke-virtual {p3}, Ljava/lang/Long;->longValue()J

    move-result-wide v1

    const-string v3, "Comments List"

    invoke-static {v0, v1, v2, v3}, Lco/vine/android/ProfileActivity;->start(Landroid/content/Context;JLjava/lang/String;)V

    goto :goto_0

    .line 281
    .restart local p3    # "tag":Ljava/lang/Object;
    :pswitch_2
    invoke-virtual {p0}, Lco/vine/android/CommentsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast p3, Ljava/lang/String;

    .end local p3    # "tag":Ljava/lang/Object;
    invoke-static {v0, p3}, Lco/vine/android/HashtagActivity;->start(Landroid/content/Context;Ljava/lang/String;)V

    goto :goto_0

    .line 275
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_1
        :pswitch_0
        :pswitch_2
    .end packed-switch
.end method

.method public onTextChanged(Ljava/lang/CharSequence;III)V
    .locals 4
    .param p1, "s"    # Ljava/lang/CharSequence;
    .param p2, "start"    # I
    .param p3, "before"    # I
    .param p4, "count"    # I

    .prologue
    const/high16 v3, -0x1000000

    .line 472
    iget-object v0, p0, Lco/vine/android/CommentsFragment;->mEdit:Lco/vine/android/widget/PopupEditText;

    invoke-virtual {v0}, Lco/vine/android/widget/PopupEditText;->getText()Landroid/text/Editable;

    move-result-object v0

    invoke-interface {v0}, Landroid/text/Editable;->length()I

    move-result v0

    if-lez v0, :cond_0

    .line 473
    iget-object v0, p0, Lco/vine/android/CommentsFragment;->mSendButton:Landroid/widget/ImageView;

    invoke-virtual {p0}, Lco/vine/android/CommentsFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f090096

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getColor(I)I

    move-result v1

    or-int/2addr v1, v3

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setColorFilter(I)V

    .line 477
    :goto_0
    return-void

    .line 475
    :cond_0
    iget-object v0, p0, Lco/vine/android/CommentsFragment;->mSendButton:Landroid/widget/ImageView;

    invoke-virtual {p0}, Lco/vine/android/CommentsFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f09001f

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getColor(I)I

    move-result v1

    or-int/2addr v1, v3

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setColorFilter(I)V

    goto :goto_0
.end method

.method public onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V
    .locals 6
    .param p1, "view"    # Landroid/view/View;
    .param p2, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 119
    invoke-super {p0, p1, p2}, Lco/vine/android/BaseArrayListFragment;->onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V

    .line 120
    const v2, 0x7f0a0083

    invoke-virtual {p1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lco/vine/android/widget/PopupEditText;

    .line 121
    .local v1, "edit":Lco/vine/android/widget/PopupEditText;
    invoke-virtual {v1, p0}, Lco/vine/android/widget/PopupEditText;->setOnEditorActionListener(Landroid/widget/TextView$OnEditorActionListener;)V

    .line 122
    iget-object v2, p0, Lco/vine/android/CommentsFragment;->mTypeaheadAdapter:Landroid/support/v4/widget/CursorAdapter;

    invoke-virtual {v1, v2}, Lco/vine/android/widget/PopupEditText;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 123
    new-instance v2, Lco/vine/android/ComposeTokenizer;

    invoke-direct {v2, p0}, Lco/vine/android/ComposeTokenizer;-><init>(Lco/vine/android/widget/PopupEditText$PopupEditTextListener;)V

    iput-object v2, p0, Lco/vine/android/CommentsFragment;->mTokenizer:Lco/vine/android/ComposeTokenizer;

    .line 124
    iget-object v2, p0, Lco/vine/android/CommentsFragment;->mTokenizer:Lco/vine/android/ComposeTokenizer;

    iget-object v3, p0, Lco/vine/android/CommentsFragment;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v3}, Lco/vine/android/client/AppController;->getTypeaheadThrottle()J

    move-result-wide v3

    invoke-virtual {v1, v2, p0, v3, v4}, Lco/vine/android/widget/PopupEditText;->setTokenizer(Landroid/widget/MultiAutoCompleteTextView$Tokenizer;Landroid/widget/Filterable;J)V

    .line 125
    invoke-virtual {v1, p0}, Lco/vine/android/widget/PopupEditText;->setPopupEditTextListener(Lco/vine/android/widget/PopupEditText$PopupEditTextListener;)V

    .line 126
    iput-object v1, p0, Lco/vine/android/CommentsFragment;->mEdit:Lco/vine/android/widget/PopupEditText;

    .line 127
    iget-object v2, p0, Lco/vine/android/CommentsFragment;->mEdit:Lco/vine/android/widget/PopupEditText;

    invoke-virtual {v2, p0}, Lco/vine/android/widget/PopupEditText;->addTextChangedListener(Landroid/text/TextWatcher;)V

    .line 128
    invoke-virtual {p0}, Lco/vine/android/CommentsFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    .line 129
    .local v0, "args":Landroid/os/Bundle;
    const-string v2, "post_id"

    invoke-virtual {v0, v2}, Landroid/os/Bundle;->getLong(Ljava/lang/String;)J

    move-result-wide v2

    iput-wide v2, p0, Lco/vine/android/CommentsFragment;->mPostId:J

    .line 130
    const-string v2, "post_author_id"

    invoke-virtual {v0, v2}, Landroid/os/Bundle;->getLong(Ljava/lang/String;)J

    move-result-wide v2

    iput-wide v2, p0, Lco/vine/android/CommentsFragment;->mPostAuthorId:J

    .line 131
    const v2, 0x7f0a0082

    invoke-virtual {p1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/ImageView;

    iput-object v2, p0, Lco/vine/android/CommentsFragment;->mSendButton:Landroid/widget/ImageView;

    .line 132
    iget-object v2, p0, Lco/vine/android/CommentsFragment;->mSendButton:Landroid/widget/ImageView;

    invoke-virtual {v2, p0}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 133
    iget-object v2, p0, Lco/vine/android/CommentsFragment;->mSendButton:Landroid/widget/ImageView;

    const/high16 v3, -0x1000000

    invoke-virtual {p0}, Lco/vine/android/CommentsFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    const v5, 0x7f09001f

    invoke-virtual {v4, v5}, Landroid/content/res/Resources;->getColor(I)I

    move-result v4

    or-int/2addr v3, v4

    sget-object v4, Landroid/graphics/PorterDuff$Mode;->SRC_ATOP:Landroid/graphics/PorterDuff$Mode;

    invoke-virtual {v2, v3, v4}, Landroid/widget/ImageView;->setColorFilter(ILandroid/graphics/PorterDuff$Mode;)V

    .line 134
    iget-object v2, p0, Lco/vine/android/CommentsFragment;->mListView:Landroid/widget/ListView;

    invoke-virtual {v2, p0}, Landroid/widget/ListView;->setOnItemLongClickListener(Landroid/widget/AdapterView$OnItemLongClickListener;)V

    .line 135
    iget-object v2, p0, Lco/vine/android/CommentsFragment;->mListView:Landroid/widget/ListView;

    invoke-virtual {v2, p0}, Landroid/widget/ListView;->setOnItemClickListener(Landroid/widget/AdapterView$OnItemClickListener;)V

    .line 136
    new-instance v2, Lco/vine/android/CommentsAdapter;

    invoke-virtual {p0}, Lco/vine/android/CommentsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v3

    iget-object v4, p0, Lco/vine/android/CommentsFragment;->mAppController:Lco/vine/android/client/AppController;

    invoke-direct {v2, v3, v4, p0}, Lco/vine/android/CommentsAdapter;-><init>(Landroid/content/Context;Lco/vine/android/client/AppController;Lco/vine/android/widget/SpanClickListener;)V

    iput-object v2, p0, Lco/vine/android/CommentsFragment;->mAdapter:Landroid/widget/BaseAdapter;

    .line 137
    iget-object v2, p0, Lco/vine/android/CommentsFragment;->mListView:Landroid/widget/ListView;

    check-cast v2, Lco/vine/android/widget/ConversationList;

    invoke-virtual {v2, p0}, Lco/vine/android/widget/ConversationList;->setGetMoreListener(Lco/vine/android/widget/ConversationList$GetMoreListener;)V

    .line 138
    iget-object v2, p0, Lco/vine/android/CommentsFragment;->mListView:Landroid/widget/ListView;

    iget-object v3, p0, Lco/vine/android/CommentsFragment;->mAdapter:Landroid/widget/BaseAdapter;

    invoke-virtual {v2, v3}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 139
    return-void
.end method

.method public postComment(Landroid/widget/EditText;)V
    .locals 7
    .param p1, "editText"    # Landroid/widget/EditText;

    .prologue
    .line 226
    invoke-direct {p0, p1}, Lco/vine/android/CommentsFragment;->validate(Landroid/widget/EditText;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 227
    new-instance v6, Landroid/app/ProgressDialog;

    invoke-virtual {p0}, Lco/vine/android/CommentsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    const v1, 0x7f0f0037

    invoke-direct {v6, v0, v1}, Landroid/app/ProgressDialog;-><init>(Landroid/content/Context;I)V

    .line 229
    .local v6, "dialog":Landroid/app/ProgressDialog;
    const v0, 0x7f0e0066

    invoke-virtual {p0, v0}, Lco/vine/android/CommentsFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v6, v0}, Landroid/app/ProgressDialog;->setMessage(Ljava/lang/CharSequence;)V

    .line 230
    const/4 v0, 0x0

    invoke-virtual {v6, v0}, Landroid/app/ProgressDialog;->setProgressStyle(I)V

    .line 231
    invoke-virtual {v6}, Landroid/app/ProgressDialog;->show()V

    .line 232
    iput-object v6, p0, Lco/vine/android/CommentsFragment;->mProgressDialog:Landroid/app/ProgressDialog;

    .line 233
    iget-object v0, p0, Lco/vine/android/CommentsFragment;->mAppController:Lco/vine/android/client/AppController;

    iget-wide v1, p0, Lco/vine/android/CommentsFragment;->mPostId:J

    iget-object v3, p0, Lco/vine/android/CommentsFragment;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v3}, Lco/vine/android/client/AppController;->getActiveSession()Lco/vine/android/client/Session;

    move-result-object v3

    invoke-virtual {p1}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v4

    iget-object v5, p0, Lco/vine/android/CommentsFragment;->mEdit:Lco/vine/android/widget/PopupEditText;

    invoke-virtual {v5}, Lco/vine/android/widget/PopupEditText;->getEntities()Ljava/util/ArrayList;

    move-result-object v5

    invoke-virtual/range {v0 .. v5}, Lco/vine/android/client/AppController;->postComment(JLco/vine/android/client/Session;Ljava/lang/String;Ljava/util/ArrayList;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lco/vine/android/CommentsFragment;->addRequest(Ljava/lang/String;)Ljava/lang/String;

    .line 235
    invoke-virtual {p1}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v0

    invoke-interface {v0}, Landroid/text/Editable;->clear()V

    .line 237
    .end local v6    # "dialog":Landroid/app/ProgressDialog;
    :cond_0
    return-void
.end method

.method public setPopupAdapter(Ljava/lang/String;)V
    .locals 2
    .param p1, "type"    # Ljava/lang/String;

    .prologue
    .line 379
    const-string v0, "users_adapter"

    invoke-virtual {v0, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 380
    iget-object v0, p0, Lco/vine/android/CommentsFragment;->mUsersAdapter:Lco/vine/android/UsersAutoCompleteAdapter;

    iput-object v0, p0, Lco/vine/android/CommentsFragment;->mTypeaheadAdapter:Landroid/support/v4/widget/CursorAdapter;

    .line 384
    :cond_0
    :goto_0
    iget-object v0, p0, Lco/vine/android/CommentsFragment;->mEdit:Lco/vine/android/widget/PopupEditText;

    iget-object v1, p0, Lco/vine/android/CommentsFragment;->mTypeaheadAdapter:Landroid/support/v4/widget/CursorAdapter;

    invoke-virtual {v0, v1}, Lco/vine/android/widget/PopupEditText;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 385
    return-void

    .line 381
    :cond_1
    const-string v0, "tags_adapter"

    invoke-virtual {v0, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 382
    iget-object v0, p0, Lco/vine/android/CommentsFragment;->mTagsAdapter:Lco/vine/android/TagsAutoCompleteAdapter;

    iput-object v0, p0, Lco/vine/android/CommentsFragment;->mTypeaheadAdapter:Landroid/support/v4/widget/CursorAdapter;

    goto :goto_0
.end method

.method public showProgress(I)V
    .locals 1
    .param p1, "fetchType"    # I

    .prologue
    .line 451
    invoke-super {p0, p1}, Lco/vine/android/BaseArrayListFragment;->showProgress(I)V

    .line 452
    const/4 v0, 0x1

    if-ne p1, v0, :cond_0

    iget v0, p0, Lco/vine/android/CommentsFragment;->mNextPage:I

    if-lez v0, :cond_0

    .line 453
    iget-object v0, p0, Lco/vine/android/CommentsFragment;->mListView:Landroid/widget/ListView;

    check-cast v0, Lco/vine/android/widget/ConversationList;

    invoke-virtual {v0}, Lco/vine/android/widget/ConversationList;->showProgress()V

    .line 455
    :cond_0
    return-void
.end method

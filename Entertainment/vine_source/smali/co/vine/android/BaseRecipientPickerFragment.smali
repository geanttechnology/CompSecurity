.class public abstract Lco/vine/android/BaseRecipientPickerFragment;
.super Lco/vine/android/BaseCursorListFragment;
.source "BaseRecipientPickerFragment.java"

# interfaces
.implements Landroid/widget/AdapterView$OnItemClickListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lco/vine/android/BaseRecipientPickerFragment$1;,
        Lco/vine/android/BaseRecipientPickerFragment$RecipientPickerSessionListener;
    }
.end annotation


# static fields
.field protected static final ARG_QUERY:Ljava/lang/String; = "filter"

.field public static final ARG_TAG:Ljava/lang/String; = "tag"

.field protected static final FILTER_THRESHOLD_MS:J = 0x96L


# instance fields
.field protected mContentUri:Landroid/net/Uri;

.field protected mEncodedQueryString:Ljava/lang/String;

.field protected mHandler:Landroid/os/Handler;

.field protected mProjection:[Ljava/lang/String;

.field protected mQueryString:Ljava/lang/String;

.field protected mSelArgs:[Ljava/lang/String;

.field protected mSelection:Ljava/lang/String;

.field protected mSortOrder:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 29
    invoke-direct {p0}, Lco/vine/android/BaseCursorListFragment;-><init>()V

    .line 105
    return-void
.end method


# virtual methods
.method protected addRecipient(Lco/vine/android/api/VineRecipient;)V
    .locals 1
    .param p1, "recipient"    # Lco/vine/android/api/VineRecipient;

    .prologue
    .line 79
    invoke-virtual {p0}, Lco/vine/android/BaseRecipientPickerFragment;->getCallback()Lco/vine/android/RecipientPickerActivity;

    move-result-object v0

    .line 80
    .local v0, "callback":Lco/vine/android/RecipientPickerActivity;
    if-eqz v0, :cond_0

    .line 81
    invoke-virtual {v0, p1}, Lco/vine/android/RecipientPickerActivity;->addRecipient(Lco/vine/android/api/VineRecipient;)V

    .line 83
    :cond_0
    return-void
.end method

.method public getCallback()Lco/vine/android/RecipientPickerActivity;
    .locals 1

    .prologue
    .line 75
    invoke-super {p0}, Lco/vine/android/BaseCursorListFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lco/vine/android/RecipientPickerActivity;

    return-object v0
.end method

.method protected abstract handleFocus()V
.end method

.method protected isRecipientSelected(Lco/vine/android/api/VineRecipient;)Z
    .locals 2
    .param p1, "recipient"    # Lco/vine/android/api/VineRecipient;

    .prologue
    .line 93
    invoke-virtual {p0}, Lco/vine/android/BaseRecipientPickerFragment;->getCallback()Lco/vine/android/RecipientPickerActivity;

    move-result-object v0

    .line 94
    .local v0, "callback":Lco/vine/android/RecipientPickerActivity;
    if-eqz v0, :cond_0

    invoke-virtual {v0, p1}, Lco/vine/android/RecipientPickerActivity;->isRecipientSelected(Lco/vine/android/api/VineRecipient;)Z

    move-result v1

    if-eqz v1, :cond_0

    const/4 v1, 0x1

    :goto_0
    return v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 56
    invoke-super {p0, p1}, Lco/vine/android/BaseCursorListFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 57
    iget-object v0, p0, Lco/vine/android/BaseRecipientPickerFragment;->mListView:Landroid/widget/ListView;

    invoke-virtual {v0, p0}, Landroid/widget/ListView;->setOnItemClickListener(Landroid/widget/AdapterView$OnItemClickListener;)V

    .line 58
    iget-object v0, p0, Lco/vine/android/BaseRecipientPickerFragment;->mListView:Landroid/widget/ListView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setDividerHeight(I)V

    .line 59
    new-instance v0, Lco/vine/android/BaseRecipientPickerFragment$RecipientPickerSessionListener;

    const/4 v1, 0x0

    invoke-direct {v0, p0, v1}, Lco/vine/android/BaseRecipientPickerFragment$RecipientPickerSessionListener;-><init>(Lco/vine/android/BaseRecipientPickerFragment;Lco/vine/android/BaseRecipientPickerFragment$1;)V

    iput-object v0, p0, Lco/vine/android/BaseRecipientPickerFragment;->mAppSessionListener:Lco/vine/android/client/AppSessionListener;

    .line 60
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 50
    invoke-super {p0, p1}, Lco/vine/android/BaseCursorListFragment;->onCreate(Landroid/os/Bundle;)V

    .line 51
    new-instance v0, Landroid/os/Handler;

    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    iput-object v0, p0, Lco/vine/android/BaseRecipientPickerFragment;->mHandler:Landroid/os/Handler;

    .line 52
    return-void
.end method

.method public onCreateLoader(ILandroid/os/Bundle;)Landroid/support/v4/content/Loader;
    .locals 7
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
    .line 99
    new-instance v0, Landroid/support/v4/content/CursorLoader;

    invoke-virtual {p0}, Lco/vine/android/BaseRecipientPickerFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    iget-object v2, p0, Lco/vine/android/BaseRecipientPickerFragment;->mContentUri:Landroid/net/Uri;

    iget-object v3, p0, Lco/vine/android/BaseRecipientPickerFragment;->mProjection:[Ljava/lang/String;

    iget-object v4, p0, Lco/vine/android/BaseRecipientPickerFragment;->mSelection:Ljava/lang/String;

    iget-object v5, p0, Lco/vine/android/BaseRecipientPickerFragment;->mSelArgs:[Ljava/lang/String;

    iget-object v6, p0, Lco/vine/android/BaseRecipientPickerFragment;->mSortOrder:Ljava/lang/String;

    invoke-direct/range {v0 .. v6}, Landroid/support/v4/content/CursorLoader;-><init>(Landroid/content/Context;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)V

    return-object v0
.end method

.method protected onGetFriendsComplete(I)V
    .locals 0
    .param p1, "errorCode"    # I

    .prologue
    .line 145
    return-void
.end method

.method abstract onGetFriendsTypeAheadComplete(Ljava/lang/String;Ljava/util/ArrayList;)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/ArrayList",
            "<",
            "Lco/vine/android/api/VineUser;",
            ">;)V"
        }
    .end annotation
.end method

.method public onMoveTo(I)V
    .locals 0
    .param p1, "oldPosition"    # I

    .prologue
    .line 70
    invoke-super {p0, p1}, Lco/vine/android/BaseCursorListFragment;->onMoveTo(I)V

    .line 71
    invoke-virtual {p0}, Lco/vine/android/BaseRecipientPickerFragment;->handleFocus()V

    .line 72
    return-void
.end method

.method public abstract onRecipientItemRemoved(Lco/vine/android/api/VineRecipient;)V
.end method

.method public onResume()V
    .locals 0

    .prologue
    .line 64
    invoke-super {p0}, Lco/vine/android/BaseCursorListFragment;->onResume()V

    .line 65
    invoke-virtual {p0}, Lco/vine/android/BaseRecipientPickerFragment;->handleFocus()V

    .line 66
    return-void
.end method

.method protected onTextChanged(Ljava/lang/CharSequence;III)V
    .locals 2
    .param p1, "s"    # Ljava/lang/CharSequence;
    .param p2, "start"    # I
    .param p3, "before"    # I
    .param p4, "count"    # I

    .prologue
    .line 154
    iget-object v0, p0, Lco/vine/android/BaseRecipientPickerFragment;->mHandler:Landroid/os/Handler;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/os/Handler;->removeCallbacksAndMessages(Ljava/lang/Object;)V

    .line 155
    return-void
.end method

.method protected removeRecipient(Lco/vine/android/api/VineRecipient;)V
    .locals 1
    .param p1, "recipient"    # Lco/vine/android/api/VineRecipient;

    .prologue
    .line 86
    invoke-virtual {p0}, Lco/vine/android/BaseRecipientPickerFragment;->getCallback()Lco/vine/android/RecipientPickerActivity;

    move-result-object v0

    .line 87
    .local v0, "callback":Lco/vine/android/RecipientPickerActivity;
    if-eqz v0, :cond_0

    .line 88
    invoke-virtual {v0, p1}, Lco/vine/android/RecipientPickerActivity;->removeRecipient(Lco/vine/android/api/VineRecipient;)V

    .line 90
    :cond_0
    return-void
.end method

.method public setQueryText(Ljava/lang/String;)V
    .locals 1
    .param p1, "query"    # Ljava/lang/String;

    .prologue
    .line 148
    iput-object p1, p0, Lco/vine/android/BaseRecipientPickerFragment;->mQueryString:Ljava/lang/String;

    .line 149
    invoke-virtual {p1}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lco/vine/android/client/VineAPI;->encode(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/BaseRecipientPickerFragment;->mEncodedQueryString:Ljava/lang/String;

    .line 150
    return-void
.end method

.class public abstract Lco/vine/android/BaseCursorAdapterFragment;
.super Lco/vine/android/BaseAdapterFragment;
.source "BaseCursorAdapterFragment.java"

# interfaces
.implements Landroid/support/v4/app/LoaderManager$LoaderCallbacks;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lco/vine/android/BaseCursorAdapterFragment$ChangeObserver;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lco/vine/android/BaseAdapterFragment;",
        "Landroid/support/v4/app/LoaderManager$LoaderCallbacks",
        "<",
        "Landroid/database/Cursor;",
        ">;"
    }
.end annotation


# static fields
.field protected static final LOADER_ID_DEFAULT:I = 0x0

.field protected static final PROGRESS_FIRST_USER:I = 0x6

.field protected static final PROGRESS_LOAD_DATA:I = 0x5

.field protected static final PROGRESS_LOAD_DATA_OLDER:I = 0x7


# instance fields
.field protected mChangeObserver:Lco/vine/android/BaseCursorAdapterFragment$ChangeObserver;

.field protected mCursorAdapter:Landroid/support/v4/widget/CursorAdapter;

.field private mLoaderId:I

.field protected mRefreshing:Z


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 17
    invoke-direct {p0}, Lco/vine/android/BaseAdapterFragment;-><init>()V

    .line 26
    const/4 v0, 0x0

    iput v0, p0, Lco/vine/android/BaseCursorAdapterFragment;->mLoaderId:I

    .line 51
    return-void
.end method


# virtual methods
.method protected abstract handleContentChanged()V
.end method

.method protected initLoader()V
    .locals 1

    .prologue
    .line 77
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lco/vine/android/BaseCursorAdapterFragment;->initLoader(I)V

    .line 78
    return-void
.end method

.method protected final initLoader(I)V
    .locals 2
    .param p1, "loaderId"    # I

    .prologue
    .line 88
    iget-object v0, p0, Lco/vine/android/BaseCursorAdapterFragment;->mChangeObserver:Lco/vine/android/BaseCursorAdapterFragment$ChangeObserver;

    if-nez v0, :cond_0

    .line 89
    new-instance v0, Lco/vine/android/BaseCursorAdapterFragment$ChangeObserver;

    iget-object v1, p0, Lco/vine/android/BaseCursorAdapterFragment;->mHandler:Landroid/os/Handler;

    invoke-direct {v0, p0, v1}, Lco/vine/android/BaseCursorAdapterFragment$ChangeObserver;-><init>(Lco/vine/android/BaseCursorAdapterFragment;Landroid/os/Handler;)V

    iput-object v0, p0, Lco/vine/android/BaseCursorAdapterFragment;->mChangeObserver:Lco/vine/android/BaseCursorAdapterFragment$ChangeObserver;

    .line 90
    iput p1, p0, Lco/vine/android/BaseCursorAdapterFragment;->mLoaderId:I

    .line 92
    :cond_0
    invoke-virtual {p0}, Lco/vine/android/BaseCursorAdapterFragment;->getLoaderManager()Landroid/support/v4/app/LoaderManager;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, p1, v1, p0}, Landroid/support/v4/app/LoaderManager;->initLoader(ILandroid/os/Bundle;Landroid/support/v4/app/LoaderManager$LoaderCallbacks;)Landroid/support/v4/content/Loader;

    .line 93
    return-void
.end method

.method protected loadCursor(Z)V
    .locals 0
    .param p1, "restart"    # Z

    .prologue
    .line 119
    return-void
.end method

.method public onCreateLoader(ILandroid/os/Bundle;)Landroid/support/v4/content/Loader;
    .locals 1
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
    .line 130
    const/4 v0, 0x0

    return-object v0
.end method

.method public onDestroy()V
    .locals 4

    .prologue
    .line 34
    iget-object v2, p0, Lco/vine/android/BaseCursorAdapterFragment;->mCursorAdapter:Landroid/support/v4/widget/CursorAdapter;

    if-eqz v2, :cond_0

    .line 38
    iget-object v2, p0, Lco/vine/android/BaseCursorAdapterFragment;->mCursorAdapter:Landroid/support/v4/widget/CursorAdapter;

    const/4 v3, 0x0

    invoke-virtual {v2, v3}, Landroid/support/v4/widget/CursorAdapter;->swapCursor(Landroid/database/Cursor;)Landroid/database/Cursor;

    move-result-object v0

    .line 39
    .local v0, "cursor":Landroid/database/Cursor;
    if-eqz v0, :cond_0

    iget-object v2, p0, Lco/vine/android/BaseCursorAdapterFragment;->mChangeObserver:Lco/vine/android/BaseCursorAdapterFragment$ChangeObserver;

    if-eqz v2, :cond_0

    .line 41
    :try_start_0
    iget-object v2, p0, Lco/vine/android/BaseCursorAdapterFragment;->mChangeObserver:Lco/vine/android/BaseCursorAdapterFragment$ChangeObserver;

    invoke-interface {v0, v2}, Landroid/database/Cursor;->unregisterContentObserver(Landroid/database/ContentObserver;)V
    :try_end_0
    .catch Ljava/lang/IllegalStateException; {:try_start_0 .. :try_end_0} :catch_0

    .line 48
    .end local v0    # "cursor":Landroid/database/Cursor;
    :cond_0
    :goto_0
    invoke-super {p0}, Lco/vine/android/BaseAdapterFragment;->onDestroy()V

    .line 49
    return-void

    .line 42
    .restart local v0    # "cursor":Landroid/database/Cursor;
    :catch_0
    move-exception v1

    .line 43
    .local v1, "e":Ljava/lang/IllegalStateException;
    const-string v2, "This is ok, because this cursor probably didn\'t need a change observer."

    const/4 v3, 0x0

    new-array v3, v3, [Ljava/lang/Object;

    invoke-static {v1, v2, v3}, Lco/vine/android/util/CrashUtil;->logException(Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_0
.end method

.method public onLoadFinished(Landroid/support/v4/content/Loader;Landroid/database/Cursor;)V
    .locals 2
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
    .line 141
    .local p1, "loader":Landroid/support/v4/content/Loader;, "Landroid/support/v4/content/Loader<Landroid/database/Cursor;>;"
    iget-object v1, p0, Lco/vine/android/BaseCursorAdapterFragment;->mCursorAdapter:Landroid/support/v4/widget/CursorAdapter;

    invoke-virtual {v1}, Landroid/support/v4/widget/CursorAdapter;->getCursor()Landroid/database/Cursor;

    move-result-object v0

    .line 142
    .local v0, "oldCursor":Landroid/database/Cursor;
    if-eqz v0, :cond_0

    .line 143
    iget-object v1, p0, Lco/vine/android/BaseCursorAdapterFragment;->mChangeObserver:Lco/vine/android/BaseCursorAdapterFragment$ChangeObserver;

    invoke-interface {v0, v1}, Landroid/database/Cursor;->unregisterContentObserver(Landroid/database/ContentObserver;)V

    .line 145
    :cond_0
    if-eqz p2, :cond_1

    .line 146
    iget-object v1, p0, Lco/vine/android/BaseCursorAdapterFragment;->mChangeObserver:Lco/vine/android/BaseCursorAdapterFragment$ChangeObserver;

    invoke-interface {p2, v1}, Landroid/database/Cursor;->registerContentObserver(Landroid/database/ContentObserver;)V

    .line 148
    :cond_1
    iget-object v1, p0, Lco/vine/android/BaseCursorAdapterFragment;->mCursorAdapter:Landroid/support/v4/widget/CursorAdapter;

    invoke-virtual {v1, p2}, Landroid/support/v4/widget/CursorAdapter;->swapCursor(Landroid/database/Cursor;)Landroid/database/Cursor;

    .line 149
    return-void
.end method

.method public bridge synthetic onLoadFinished(Landroid/support/v4/content/Loader;Ljava/lang/Object;)V
    .locals 0
    .param p1, "x0"    # Landroid/support/v4/content/Loader;
    .param p2, "x1"    # Ljava/lang/Object;

    .prologue
    .line 17
    check-cast p2, Landroid/database/Cursor;

    .end local p2    # "x1":Ljava/lang/Object;
    invoke-virtual {p0, p1, p2}, Lco/vine/android/BaseCursorAdapterFragment;->onLoadFinished(Landroid/support/v4/content/Loader;Landroid/database/Cursor;)V

    return-void
.end method

.method public onLoaderReset(Landroid/support/v4/content/Loader;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/support/v4/content/Loader",
            "<",
            "Landroid/database/Cursor;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 158
    .local p1, "loader":Landroid/support/v4/content/Loader;, "Landroid/support/v4/content/Loader<Landroid/database/Cursor;>;"
    iget-object v1, p0, Lco/vine/android/BaseCursorAdapterFragment;->mCursorAdapter:Landroid/support/v4/widget/CursorAdapter;

    if-eqz v1, :cond_1

    .line 159
    iget-object v1, p0, Lco/vine/android/BaseCursorAdapterFragment;->mCursorAdapter:Landroid/support/v4/widget/CursorAdapter;

    invoke-virtual {v1}, Landroid/support/v4/widget/CursorAdapter;->getCursor()Landroid/database/Cursor;

    move-result-object v0

    .line 160
    .local v0, "cursor":Landroid/database/Cursor;
    if-eqz v0, :cond_0

    .line 161
    iget-object v1, p0, Lco/vine/android/BaseCursorAdapterFragment;->mChangeObserver:Lco/vine/android/BaseCursorAdapterFragment$ChangeObserver;

    invoke-interface {v0, v1}, Landroid/database/Cursor;->unregisterContentObserver(Landroid/database/ContentObserver;)V

    .line 163
    :cond_0
    iget-object v1, p0, Lco/vine/android/BaseCursorAdapterFragment;->mCursorAdapter:Landroid/support/v4/widget/CursorAdapter;

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Landroid/support/v4/widget/CursorAdapter;->swapCursor(Landroid/database/Cursor;)Landroid/database/Cursor;

    .line 165
    .end local v0    # "cursor":Landroid/database/Cursor;
    :cond_1
    return-void
.end method

.method protected restartLoader()Z
    .locals 1

    .prologue
    .line 102
    iget v0, p0, Lco/vine/android/BaseCursorAdapterFragment;->mLoaderId:I

    invoke-virtual {p0, v0}, Lco/vine/android/BaseCursorAdapterFragment;->restartLoader(I)Z

    move-result v0

    return v0
.end method

.method protected restartLoader(I)Z
    .locals 2
    .param p1, "loaderId"    # I

    .prologue
    .line 106
    iget-object v0, p0, Lco/vine/android/BaseCursorAdapterFragment;->mChangeObserver:Lco/vine/android/BaseCursorAdapterFragment$ChangeObserver;

    if-nez v0, :cond_0

    .line 107
    const/4 v0, 0x0

    .line 110
    :goto_0
    return v0

    .line 109
    :cond_0
    invoke-virtual {p0}, Lco/vine/android/BaseCursorAdapterFragment;->getLoaderManager()Landroid/support/v4/app/LoaderManager;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, p1, v1, p0}, Landroid/support/v4/app/LoaderManager;->restartLoader(ILandroid/os/Bundle;Landroid/support/v4/app/LoaderManager$LoaderCallbacks;)Landroid/support/v4/content/Loader;

    .line 110
    const/4 v0, 0x1

    goto :goto_0
.end method

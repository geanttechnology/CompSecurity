.class public abstract Lco/vine/android/provider/GroupCursor;
.super Landroid/database/CursorWrapper;
.source "GroupCursor.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lco/vine/android/provider/GroupCursor$LocalContentObserver;,
        Lco/vine/android/provider/GroupCursor$LocalDataSetObserver;,
        Lco/vine/android/provider/GroupCursor$LocalDataSetObservable;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Landroid/database/CursorWrapper;"
    }
.end annotation


# static fields
.field public static final LIMIT_DEFAULT:I = 0x14


# instance fields
.field private final mContentObservable:Landroid/database/ContentObservable;

.field protected mCursor:Landroid/database/Cursor;

.field protected mCursorPosition:I

.field protected mLimit:I

.field protected mList:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<TT;>;"
        }
    .end annotation
.end field

.field protected final mLocalDataSetObservable:Lco/vine/android/provider/GroupCursor$LocalDataSetObservable;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lco/vine/android/provider/GroupCursor",
            "<TT;>.",
            "LocalDataSetObservable;"
        }
    .end annotation
.end field

.field volatile mNeedsDispatchChange:Z

.field volatile mPreparing:Z

.field volatile mSelfChange:Z


# direct methods
.method public constructor <init>(Landroid/database/Cursor;)V
    .locals 1
    .param p1, "cursor"    # Landroid/database/Cursor;

    .prologue
    .line 31
    .local p0, "this":Lco/vine/android/provider/GroupCursor;, "Lco/vine/android/provider/GroupCursor<TT;>;"
    const/16 v0, 0x14

    invoke-direct {p0, p1, v0}, Lco/vine/android/provider/GroupCursor;-><init>(Landroid/database/Cursor;I)V

    .line 32
    return-void
.end method

.method public constructor <init>(Landroid/database/Cursor;I)V
    .locals 1
    .param p1, "cursor"    # Landroid/database/Cursor;
    .param p2, "limit"    # I

    .prologue
    .line 35
    .local p0, "this":Lco/vine/android/provider/GroupCursor;, "Lco/vine/android/provider/GroupCursor<TT;>;"
    invoke-direct {p0, p1}, Landroid/database/CursorWrapper;-><init>(Landroid/database/Cursor;)V

    .line 22
    const/4 v0, -0x1

    iput v0, p0, Lco/vine/android/provider/GroupCursor;->mCursorPosition:I

    .line 36
    new-instance v0, Lco/vine/android/provider/GroupCursor$LocalDataSetObservable;

    invoke-direct {v0, p0}, Lco/vine/android/provider/GroupCursor$LocalDataSetObservable;-><init>(Lco/vine/android/provider/GroupCursor;)V

    iput-object v0, p0, Lco/vine/android/provider/GroupCursor;->mLocalDataSetObservable:Lco/vine/android/provider/GroupCursor$LocalDataSetObservable;

    .line 37
    new-instance v0, Landroid/database/ContentObservable;

    invoke-direct {v0}, Landroid/database/ContentObservable;-><init>()V

    iput-object v0, p0, Lco/vine/android/provider/GroupCursor;->mContentObservable:Landroid/database/ContentObservable;

    .line 38
    iput-object p1, p0, Lco/vine/android/provider/GroupCursor;->mCursor:Landroid/database/Cursor;

    .line 39
    if-gtz p2, :cond_1

    .line 40
    const/16 v0, 0x14

    iput v0, p0, Lco/vine/android/provider/GroupCursor;->mLimit:I

    .line 44
    :goto_0
    if-eqz p1, :cond_0

    invoke-interface {p1}, Landroid/database/Cursor;->isClosed()Z

    move-result v0

    if-nez v0, :cond_0

    .line 45
    new-instance v0, Lco/vine/android/provider/GroupCursor$LocalDataSetObserver;

    invoke-direct {v0, p0}, Lco/vine/android/provider/GroupCursor$LocalDataSetObserver;-><init>(Lco/vine/android/provider/GroupCursor;)V

    invoke-interface {p1, v0}, Landroid/database/Cursor;->registerDataSetObserver(Landroid/database/DataSetObserver;)V

    .line 46
    new-instance v0, Lco/vine/android/provider/GroupCursor$LocalContentObserver;

    invoke-direct {v0, p0}, Lco/vine/android/provider/GroupCursor$LocalContentObserver;-><init>(Lco/vine/android/provider/GroupCursor;)V

    invoke-interface {p1, v0}, Landroid/database/Cursor;->registerContentObserver(Landroid/database/ContentObserver;)V

    .line 48
    :cond_0
    return-void

    .line 42
    :cond_1
    iput p2, p0, Lco/vine/android/provider/GroupCursor;->mLimit:I

    goto :goto_0
.end method

.method static synthetic access$000(Lco/vine/android/provider/GroupCursor;)Landroid/database/ContentObservable;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/provider/GroupCursor;

    .prologue
    .line 12
    iget-object v0, p0, Lco/vine/android/provider/GroupCursor;->mContentObservable:Landroid/database/ContentObservable;

    return-object v0
.end method


# virtual methods
.method public getCount()I
    .locals 1

    .prologue
    .line 67
    .local p0, "this":Lco/vine/android/provider/GroupCursor;, "Lco/vine/android/provider/GroupCursor<TT;>;"
    iget-object v0, p0, Lco/vine/android/provider/GroupCursor;->mList:Ljava/util/List;

    if-eqz v0, :cond_0

    .line 68
    iget-object v0, p0, Lco/vine/android/provider/GroupCursor;->mList:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    .line 70
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getItem(I)Ljava/lang/Object;
    .locals 1
    .param p1, "position"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I)TT;"
        }
    .end annotation

    .prologue
    .line 143
    .local p0, "this":Lco/vine/android/provider/GroupCursor;, "Lco/vine/android/provider/GroupCursor<TT;>;"
    iget-object v0, p0, Lco/vine/android/provider/GroupCursor;->mList:Ljava/util/List;

    if-nez v0, :cond_0

    .line 144
    const/4 v0, 0x0

    .line 146
    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lco/vine/android/provider/GroupCursor;->mList:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    goto :goto_0
.end method

.method public getPosition()I
    .locals 1

    .prologue
    .line 76
    .local p0, "this":Lco/vine/android/provider/GroupCursor;, "Lco/vine/android/provider/GroupCursor<TT;>;"
    iget v0, p0, Lco/vine/android/provider/GroupCursor;->mCursorPosition:I

    return v0
.end method

.method public moveToFirst()Z
    .locals 1

    .prologue
    .line 81
    .local p0, "this":Lco/vine/android/provider/GroupCursor;, "Lco/vine/android/provider/GroupCursor<TT;>;"
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lco/vine/android/provider/GroupCursor;->moveToPosition(I)Z

    move-result v0

    return v0
.end method

.method public moveToLast()Z
    .locals 1

    .prologue
    .line 86
    .local p0, "this":Lco/vine/android/provider/GroupCursor;, "Lco/vine/android/provider/GroupCursor<TT;>;"
    iget-object v0, p0, Lco/vine/android/provider/GroupCursor;->mList:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    add-int/lit8 v0, v0, -0x1

    invoke-virtual {p0, v0}, Lco/vine/android/provider/GroupCursor;->moveToPosition(I)Z

    move-result v0

    return v0
.end method

.method public moveToNext()Z
    .locals 1

    .prologue
    .line 91
    .local p0, "this":Lco/vine/android/provider/GroupCursor;, "Lco/vine/android/provider/GroupCursor<TT;>;"
    iget v0, p0, Lco/vine/android/provider/GroupCursor;->mCursorPosition:I

    add-int/lit8 v0, v0, 0x1

    invoke-virtual {p0, v0}, Lco/vine/android/provider/GroupCursor;->moveToPosition(I)Z

    move-result v0

    return v0
.end method

.method public moveToPosition(I)Z
    .locals 3
    .param p1, "position"    # I

    .prologue
    .local p0, "this":Lco/vine/android/provider/GroupCursor;, "Lco/vine/android/provider/GroupCursor<TT;>;"
    const/4 v1, 0x0

    const/4 v2, -0x1

    .line 101
    invoke-virtual {p0}, Lco/vine/android/provider/GroupCursor;->getCount()I

    move-result v0

    .line 102
    .local v0, "size":I
    if-gt p1, v2, :cond_0

    .line 103
    iput v2, p0, Lco/vine/android/provider/GroupCursor;->mCursorPosition:I

    .line 110
    :goto_0
    return v1

    .line 105
    :cond_0
    if-lt p1, v0, :cond_1

    .line 106
    iput v0, p0, Lco/vine/android/provider/GroupCursor;->mCursorPosition:I

    goto :goto_0

    .line 109
    :cond_1
    iput p1, p0, Lco/vine/android/provider/GroupCursor;->mCursorPosition:I

    .line 110
    const/4 v1, 0x1

    goto :goto_0
.end method

.method public moveToPrevious()Z
    .locals 1

    .prologue
    .line 96
    .local p0, "this":Lco/vine/android/provider/GroupCursor;, "Lco/vine/android/provider/GroupCursor<TT;>;"
    iget v0, p0, Lco/vine/android/provider/GroupCursor;->mCursorPosition:I

    add-int/lit8 v0, v0, -0x1

    invoke-virtual {p0, v0}, Lco/vine/android/provider/GroupCursor;->moveToPosition(I)Z

    move-result v0

    return v0
.end method

.method public abstract onPrepare()V
.end method

.method public final prepare()V
    .locals 2

    .prologue
    .local p0, "this":Lco/vine/android/provider/GroupCursor;, "Lco/vine/android/provider/GroupCursor<TT;>;"
    const/4 v1, 0x0

    .line 54
    const/4 v0, 0x1

    iput-boolean v0, p0, Lco/vine/android/provider/GroupCursor;->mPreparing:Z

    .line 55
    invoke-virtual {p0}, Lco/vine/android/provider/GroupCursor;->onPrepare()V

    .line 56
    iput-boolean v1, p0, Lco/vine/android/provider/GroupCursor;->mPreparing:Z

    .line 57
    iget-boolean v0, p0, Lco/vine/android/provider/GroupCursor;->mNeedsDispatchChange:Z

    if-eqz v0, :cond_0

    .line 58
    iput-boolean v1, p0, Lco/vine/android/provider/GroupCursor;->mNeedsDispatchChange:Z

    .line 59
    iget-object v0, p0, Lco/vine/android/provider/GroupCursor;->mContentObservable:Landroid/database/ContentObservable;

    iget-boolean v1, p0, Lco/vine/android/provider/GroupCursor;->mSelfChange:Z

    invoke-virtual {v0, v1}, Landroid/database/ContentObservable;->dispatchChange(Z)V

    .line 61
    :cond_0
    return-void
.end method

.method public registerContentObserver(Landroid/database/ContentObserver;)V
    .locals 1
    .param p1, "observer"    # Landroid/database/ContentObserver;

    .prologue
    .line 130
    .local p0, "this":Lco/vine/android/provider/GroupCursor;, "Lco/vine/android/provider/GroupCursor<TT;>;"
    if-eqz p1, :cond_0

    .line 131
    iget-object v0, p0, Lco/vine/android/provider/GroupCursor;->mContentObservable:Landroid/database/ContentObservable;

    invoke-virtual {v0, p1}, Landroid/database/ContentObservable;->registerObserver(Landroid/database/ContentObserver;)V

    .line 133
    :cond_0
    return-void
.end method

.method public registerDataSetObserver(Landroid/database/DataSetObserver;)V
    .locals 1
    .param p1, "observer"    # Landroid/database/DataSetObserver;

    .prologue
    .line 116
    .local p0, "this":Lco/vine/android/provider/GroupCursor;, "Lco/vine/android/provider/GroupCursor<TT;>;"
    if-eqz p1, :cond_0

    .line 117
    iget-object v0, p0, Lco/vine/android/provider/GroupCursor;->mLocalDataSetObservable:Lco/vine/android/provider/GroupCursor$LocalDataSetObservable;

    invoke-virtual {v0, p1}, Lco/vine/android/provider/GroupCursor$LocalDataSetObservable;->registerObserver(Ljava/lang/Object;)V

    .line 119
    :cond_0
    return-void
.end method

.method public requery()Z
    .locals 4

    .prologue
    .local p0, "this":Lco/vine/android/provider/GroupCursor;, "Lco/vine/android/provider/GroupCursor<TT;>;"
    const/4 v2, 0x1

    const/4 v1, 0x0

    .line 157
    iget-object v0, p0, Lco/vine/android/provider/GroupCursor;->mLocalDataSetObservable:Lco/vine/android/provider/GroupCursor$LocalDataSetObservable;

    .line 158
    .local v0, "localDataSetObservable":Lco/vine/android/provider/GroupCursor$LocalDataSetObservable;, "Lco/vine/android/provider/GroupCursor<TT;>.LocalDataSetObservable;"
    invoke-virtual {v0, v1}, Lco/vine/android/provider/GroupCursor$LocalDataSetObservable;->setNotifyOnChange(Z)V

    .line 159
    iget-object v3, p0, Lco/vine/android/provider/GroupCursor;->mCursor:Landroid/database/Cursor;

    invoke-interface {v3}, Landroid/database/Cursor;->isClosed()Z

    move-result v3

    if-nez v3, :cond_0

    iget-object v3, p0, Lco/vine/android/provider/GroupCursor;->mCursor:Landroid/database/Cursor;

    invoke-interface {v3}, Landroid/database/Cursor;->requery()Z

    move-result v3

    if-eqz v3, :cond_0

    move v1, v2

    .line 160
    .local v1, "result":Z
    :cond_0
    invoke-virtual {p0}, Lco/vine/android/provider/GroupCursor;->prepare()V

    .line 161
    invoke-virtual {v0, v2}, Lco/vine/android/provider/GroupCursor$LocalDataSetObservable;->setNotifyOnChange(Z)V

    .line 162
    invoke-virtual {v0}, Lco/vine/android/provider/GroupCursor$LocalDataSetObservable;->notifyChanged()V

    .line 163
    return v1
.end method

.method public unregisterContentObserver(Landroid/database/ContentObserver;)V
    .locals 1
    .param p1, "observer"    # Landroid/database/ContentObserver;

    .prologue
    .line 137
    .local p0, "this":Lco/vine/android/provider/GroupCursor;, "Lco/vine/android/provider/GroupCursor<TT;>;"
    if-eqz p1, :cond_0

    .line 138
    iget-object v0, p0, Lco/vine/android/provider/GroupCursor;->mContentObservable:Landroid/database/ContentObservable;

    invoke-virtual {v0, p1}, Landroid/database/ContentObservable;->unregisterObserver(Ljava/lang/Object;)V

    .line 140
    :cond_0
    return-void
.end method

.method public unregisterDataSetObserver(Landroid/database/DataSetObserver;)V
    .locals 1
    .param p1, "observer"    # Landroid/database/DataSetObserver;

    .prologue
    .line 123
    .local p0, "this":Lco/vine/android/provider/GroupCursor;, "Lco/vine/android/provider/GroupCursor<TT;>;"
    if-eqz p1, :cond_0

    .line 124
    iget-object v0, p0, Lco/vine/android/provider/GroupCursor;->mLocalDataSetObservable:Lco/vine/android/provider/GroupCursor$LocalDataSetObservable;

    invoke-virtual {v0, p1}, Lco/vine/android/provider/GroupCursor$LocalDataSetObservable;->unregisterObserver(Ljava/lang/Object;)V

    .line 126
    :cond_0
    return-void
.end method

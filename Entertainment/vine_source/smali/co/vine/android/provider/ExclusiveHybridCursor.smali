.class public abstract Lco/vine/android/provider/ExclusiveHybridCursor;
.super Lco/vine/android/provider/GroupCursor;
.source "ExclusiveHybridCursor.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lco/vine/android/provider/ExclusiveHybridCursor$1;,
        Lco/vine/android/provider/ExclusiveHybridCursor$Mode;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        "E:",
        "Ljava/lang/Object;",
        ">",
        "Lco/vine/android/provider/GroupCursor",
        "<TT;>;"
    }
.end annotation


# instance fields
.field private mMode:Lco/vine/android/provider/ExclusiveHybridCursor$Mode;

.field private mRemoteData:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<TE;>;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Landroid/database/Cursor;)V
    .locals 1
    .param p1, "cursor"    # Landroid/database/Cursor;

    .prologue
    .line 33
    .local p0, "this":Lco/vine/android/provider/ExclusiveHybridCursor;, "Lco/vine/android/provider/ExclusiveHybridCursor<TT;TE;>;"
    const/16 v0, 0x14

    invoke-direct {p0, p1, v0}, Lco/vine/android/provider/ExclusiveHybridCursor;-><init>(Landroid/database/Cursor;I)V

    .line 34
    return-void
.end method

.method public constructor <init>(Landroid/database/Cursor;I)V
    .locals 1
    .param p1, "cursor"    # Landroid/database/Cursor;
    .param p2, "limit"    # I

    .prologue
    .line 37
    .local p0, "this":Lco/vine/android/provider/ExclusiveHybridCursor;, "Lco/vine/android/provider/ExclusiveHybridCursor<TT;TE;>;"
    invoke-direct {p0, p1, p2}, Lco/vine/android/provider/GroupCursor;-><init>(Landroid/database/Cursor;I)V

    .line 16
    sget-object v0, Lco/vine/android/provider/ExclusiveHybridCursor$Mode;->CURSOR:Lco/vine/android/provider/ExclusiveHybridCursor$Mode;

    iput-object v0, p0, Lco/vine/android/provider/ExclusiveHybridCursor;->mMode:Lco/vine/android/provider/ExclusiveHybridCursor$Mode;

    .line 38
    return-void
.end method

.method public constructor <init>(Ljava/util/ArrayList;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<TE;>;)V"
        }
    .end annotation

    .prologue
    .line 20
    .local p0, "this":Lco/vine/android/provider/ExclusiveHybridCursor;, "Lco/vine/android/provider/ExclusiveHybridCursor<TT;TE;>;"
    .local p1, "remoteData":Ljava/util/ArrayList;, "Ljava/util/ArrayList<TE;>;"
    const/4 v0, 0x0

    invoke-direct {p0, v0}, Lco/vine/android/provider/GroupCursor;-><init>(Landroid/database/Cursor;)V

    .line 16
    sget-object v0, Lco/vine/android/provider/ExclusiveHybridCursor$Mode;->CURSOR:Lco/vine/android/provider/ExclusiveHybridCursor$Mode;

    iput-object v0, p0, Lco/vine/android/provider/ExclusiveHybridCursor;->mMode:Lco/vine/android/provider/ExclusiveHybridCursor$Mode;

    .line 21
    iput-object p1, p0, Lco/vine/android/provider/ExclusiveHybridCursor;->mRemoteData:Ljava/util/List;

    .line 22
    return-void
.end method


# virtual methods
.method public abstract createItemFromCursor(Landroid/database/Cursor;)Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/database/Cursor;",
            ")TT;"
        }
    .end annotation
.end method

.method public abstract createItemsFromRemoteData(Ljava/lang/Object;)Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TE;)TT;"
        }
    .end annotation
.end method

.method public getMode()Lco/vine/android/provider/ExclusiveHybridCursor$Mode;
    .locals 1

    .prologue
    .line 25
    .local p0, "this":Lco/vine/android/provider/ExclusiveHybridCursor;, "Lco/vine/android/provider/ExclusiveHybridCursor<TT;TE;>;"
    iget-object v0, p0, Lco/vine/android/provider/ExclusiveHybridCursor;->mMode:Lco/vine/android/provider/ExclusiveHybridCursor$Mode;

    return-object v0
.end method

.method public isLastItem()Z
    .locals 2

    .prologue
    .line 76
    .local p0, "this":Lco/vine/android/provider/ExclusiveHybridCursor;, "Lco/vine/android/provider/ExclusiveHybridCursor<TT;TE;>;"
    iget-object v0, p0, Lco/vine/android/provider/ExclusiveHybridCursor;->mRemoteData:Ljava/util/List;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lco/vine/android/provider/ExclusiveHybridCursor;->mRemoteData:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    iget v1, p0, Lco/vine/android/provider/ExclusiveHybridCursor;->mCursorPosition:I

    add-int/lit8 v1, v1, 0x1

    if-ge v0, v1, :cond_1

    :cond_0
    iget-object v0, p0, Lco/vine/android/provider/ExclusiveHybridCursor;->mCursor:Landroid/database/Cursor;

    if-eqz v0, :cond_2

    iget-object v0, p0, Lco/vine/android/provider/ExclusiveHybridCursor;->mCursor:Landroid/database/Cursor;

    invoke-interface {v0}, Landroid/database/Cursor;->getCount()I

    move-result v0

    iget v1, p0, Lco/vine/android/provider/ExclusiveHybridCursor;->mCursorPosition:I

    if-lt v0, v1, :cond_2

    :cond_1
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_2
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public onPrepare()V
    .locals 8

    .prologue
    .line 42
    .local p0, "this":Lco/vine/android/provider/ExclusiveHybridCursor;, "Lco/vine/android/provider/ExclusiveHybridCursor<TT;TE;>;"
    sget-object v6, Lco/vine/android/provider/ExclusiveHybridCursor$1;->$SwitchMap$co$vine$android$provider$ExclusiveHybridCursor$Mode:[I

    iget-object v7, p0, Lco/vine/android/provider/ExclusiveHybridCursor;->mMode:Lco/vine/android/provider/ExclusiveHybridCursor$Mode;

    invoke-virtual {v7}, Lco/vine/android/provider/ExclusiveHybridCursor$Mode;->ordinal()I

    move-result v7

    aget v6, v6, v7

    packed-switch v6, :pswitch_data_0

    .line 73
    :cond_0
    :goto_0
    return-void

    .line 44
    :pswitch_0
    new-instance v6, Ljava/util/ArrayList;

    invoke-direct {v6}, Ljava/util/ArrayList;-><init>()V

    iput-object v6, p0, Lco/vine/android/provider/ExclusiveHybridCursor;->mList:Ljava/util/List;

    .line 45
    iget-object v6, p0, Lco/vine/android/provider/ExclusiveHybridCursor;->mRemoteData:Ljava/util/List;

    invoke-interface {v6}, Ljava/util/List;->size()I

    move-result v5

    .line 46
    .local v5, "size":I
    const/4 v3, 0x0

    .local v3, "i":I
    :goto_1
    if-ge v3, v5, :cond_0

    iget v6, p0, Lco/vine/android/provider/ExclusiveHybridCursor;->mLimit:I

    if-ge v3, v6, :cond_0

    .line 47
    iget-object v6, p0, Lco/vine/android/provider/ExclusiveHybridCursor;->mList:Ljava/util/List;

    iget-object v7, p0, Lco/vine/android/provider/ExclusiveHybridCursor;->mRemoteData:Ljava/util/List;

    invoke-interface {v7, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v7

    invoke-virtual {p0, v7}, Lco/vine/android/provider/ExclusiveHybridCursor;->createItemsFromRemoteData(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v7

    invoke-interface {v6, v7}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 46
    add-int/lit8 v3, v3, 0x1

    goto :goto_1

    .line 52
    .end local v3    # "i":I
    .end local v5    # "size":I
    :pswitch_1
    iget-object v1, p0, Lco/vine/android/provider/ExclusiveHybridCursor;->mCursor:Landroid/database/Cursor;

    .line 53
    .local v1, "cursor":Landroid/database/Cursor;
    const/4 v0, 0x0

    .line 54
    .local v0, "count":I
    if-eqz v1, :cond_2

    invoke-interface {v1}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v6

    if-eqz v6, :cond_2

    .line 55
    new-instance v6, Ljava/util/ArrayList;

    invoke-direct {v6}, Ljava/util/ArrayList;-><init>()V

    iput-object v6, p0, Lco/vine/android/provider/ExclusiveHybridCursor;->mList:Ljava/util/List;

    .line 58
    :cond_1
    iget-object v6, p0, Lco/vine/android/provider/ExclusiveHybridCursor;->mList:Ljava/util/List;

    invoke-virtual {p0, v1}, Lco/vine/android/provider/ExclusiveHybridCursor;->createItemFromCursor(Landroid/database/Cursor;)Ljava/lang/Object;

    move-result-object v7

    invoke-interface {v6, v7}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 60
    :try_start_0
    invoke-interface {v1}, Landroid/database/Cursor;->moveToNext()Z
    :try_end_0
    .catch Ljava/lang/IllegalStateException; {:try_start_0 .. :try_end_0} :catch_0

    move-result v4

    .line 66
    .local v4, "moveToNext":Z
    :goto_2
    if-eqz v4, :cond_0

    iget v6, p0, Lco/vine/android/provider/ExclusiveHybridCursor;->mLimit:I

    if-lt v0, v6, :cond_1

    goto :goto_0

    .line 61
    .end local v4    # "moveToNext":Z
    :catch_0
    move-exception v2

    .line 62
    .local v2, "e":Ljava/lang/IllegalStateException;
    const-string v6, "Failed to get cursor\'s row id."

    invoke-static {v6}, Lco/vine/android/util/CrashUtil;->log(Ljava/lang/String;)V

    .line 63
    invoke-static {}, Ljava/lang/System;->gc()V

    .line 64
    invoke-interface {v1}, Landroid/database/Cursor;->moveToNext()Z

    move-result v4

    .restart local v4    # "moveToNext":Z
    goto :goto_2

    .line 68
    .end local v2    # "e":Ljava/lang/IllegalStateException;
    .end local v4    # "moveToNext":Z
    :cond_2
    const/4 v6, 0x0

    iput-object v6, p0, Lco/vine/android/provider/ExclusiveHybridCursor;->mList:Ljava/util/List;

    goto :goto_0

    .line 42
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method public setMode(Lco/vine/android/provider/ExclusiveHybridCursor$Mode;)V
    .locals 0
    .param p1, "mode"    # Lco/vine/android/provider/ExclusiveHybridCursor$Mode;

    .prologue
    .line 29
    .local p0, "this":Lco/vine/android/provider/ExclusiveHybridCursor;, "Lco/vine/android/provider/ExclusiveHybridCursor<TT;TE;>;"
    iput-object p1, p0, Lco/vine/android/provider/ExclusiveHybridCursor;->mMode:Lco/vine/android/provider/ExclusiveHybridCursor$Mode;

    .line 30
    return-void
.end method

.class public Lco/vine/android/provider/FriendsPickerExclusiveCursor;
.super Lco/vine/android/provider/ExclusiveHybridCursor;
.source "FriendsPickerExclusiveCursor.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lco/vine/android/provider/ExclusiveHybridCursor",
        "<",
        "Lco/vine/android/api/VineRecipient;",
        "Lco/vine/android/api/VineUser;",
        ">;"
    }
.end annotation


# direct methods
.method public constructor <init>(Landroid/database/Cursor;)V
    .locals 1
    .param p1, "cursor"    # Landroid/database/Cursor;

    .prologue
    .line 16
    invoke-direct {p0, p1}, Lco/vine/android/provider/ExclusiveHybridCursor;-><init>(Landroid/database/Cursor;)V

    .line 17
    sget-object v0, Lco/vine/android/provider/ExclusiveHybridCursor$Mode;->CURSOR:Lco/vine/android/provider/ExclusiveHybridCursor$Mode;

    invoke-virtual {p0, v0}, Lco/vine/android/provider/FriendsPickerExclusiveCursor;->setMode(Lco/vine/android/provider/ExclusiveHybridCursor$Mode;)V

    .line 18
    return-void
.end method

.method public constructor <init>(Ljava/util/ArrayList;)V
    .locals 1
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
    .line 21
    .local p1, "users":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineUser;>;"
    invoke-direct {p0, p1}, Lco/vine/android/provider/ExclusiveHybridCursor;-><init>(Ljava/util/ArrayList;)V

    .line 22
    sget-object v0, Lco/vine/android/provider/ExclusiveHybridCursor$Mode;->LIST:Lco/vine/android/provider/ExclusiveHybridCursor$Mode;

    invoke-virtual {p0, v0}, Lco/vine/android/provider/FriendsPickerExclusiveCursor;->setMode(Lco/vine/android/provider/ExclusiveHybridCursor$Mode;)V

    .line 23
    return-void
.end method


# virtual methods
.method public createItemFromCursor(Landroid/database/Cursor;)Lco/vine/android/api/VineRecipient;
    .locals 1
    .param p1, "cursor"    # Landroid/database/Cursor;

    .prologue
    .line 43
    invoke-static {p1}, Lco/vine/android/provider/VineDatabaseSQL$UsersQuery;->getVineRecipient(Landroid/database/Cursor;)Lco/vine/android/api/VineRecipient;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic createItemFromCursor(Landroid/database/Cursor;)Ljava/lang/Object;
    .locals 1
    .param p1, "x0"    # Landroid/database/Cursor;

    .prologue
    .line 13
    invoke-virtual {p0, p1}, Lco/vine/android/provider/FriendsPickerExclusiveCursor;->createItemFromCursor(Landroid/database/Cursor;)Lco/vine/android/api/VineRecipient;

    move-result-object v0

    return-object v0
.end method

.method public createItemsFromRemoteData(Lco/vine/android/api/VineUser;)Lco/vine/android/api/VineRecipient;
    .locals 7
    .param p1, "remoteItem"    # Lco/vine/android/api/VineUser;

    .prologue
    .line 36
    iget-object v0, p1, Lco/vine/android/api/VineUser;->username:Ljava/lang/String;

    iget-wide v1, p1, Lco/vine/android/api/VineUser;->userId:J

    const/4 v3, 0x0

    const-wide/16 v4, -0x1

    invoke-static/range {v0 .. v5}, Lco/vine/android/api/VineRecipient;->fromUser(Ljava/lang/String;JIJ)Lco/vine/android/api/VineRecipient;

    move-result-object v6

    .line 37
    .local v6, "vr":Lco/vine/android/api/VineRecipient;
    iget-object v0, p1, Lco/vine/android/api/VineUser;->avatarUrl:Ljava/lang/String;

    iput-object v0, v6, Lco/vine/android/api/VineRecipient;->avatarUrl:Ljava/lang/String;

    .line 38
    return-object v6
.end method

.method public bridge synthetic createItemsFromRemoteData(Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1
    .param p1, "x0"    # Ljava/lang/Object;

    .prologue
    .line 13
    check-cast p1, Lco/vine/android/api/VineUser;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lco/vine/android/provider/FriendsPickerExclusiveCursor;->createItemsFromRemoteData(Lco/vine/android/api/VineUser;)Lco/vine/android/api/VineRecipient;

    move-result-object v0

    return-object v0
.end method

.method public getColumnIndexOrThrow(Ljava/lang/String;)I
    .locals 1
    .param p1, "columnName"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalArgumentException;
        }
    .end annotation

    .prologue
    .line 27
    iget-object v0, p0, Lco/vine/android/provider/FriendsPickerExclusiveCursor;->mCursor:Landroid/database/Cursor;

    if-eqz v0, :cond_0

    .line 28
    iget-object v0, p0, Lco/vine/android/provider/FriendsPickerExclusiveCursor;->mCursor:Landroid/database/Cursor;

    invoke-interface {v0, p1}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    .line 30
    :goto_0
    return v0

    :cond_0
    const/4 v0, -0x1

    goto :goto_0
.end method

.class public Lcom/xfinity/playerlib/model/downloads/comparator/DownloadableFileExpirationComparator;
.super Ljava/lang/Object;
.source "DownloadableFileExpirationComparator.java"

# interfaces
.implements Ljava/util/Comparator;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Ljava/util/Comparator",
        "<",
        "Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;",
        ">;"
    }
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 9
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public compare(Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;)I
    .locals 5
    .param p1, "f1"    # Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;
    .param p2, "f2"    # Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;

    .prologue
    .line 13
    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;->getWatchable()Lcom/xfinity/playerlib/model/consumable/Watchable;

    move-result-object v2

    .line 14
    .local v2, "watchable1":Lcom/xfinity/playerlib/model/consumable/Watchable;
    invoke-virtual {p2}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;->getWatchable()Lcom/xfinity/playerlib/model/consumable/Watchable;

    move-result-object v3

    .line 17
    .local v3, "watchable2":Lcom/xfinity/playerlib/model/consumable/Watchable;
    invoke-interface {v2}, Lcom/xfinity/playerlib/model/consumable/Watchable;->getExpiresDate()Ljava/util/Date;

    move-result-object v0

    .line 18
    .local v0, "expiresDate1":Ljava/util/Date;
    invoke-interface {v3}, Lcom/xfinity/playerlib/model/consumable/Watchable;->getExpiresDate()Ljava/util/Date;

    move-result-object v1

    .line 20
    .local v1, "expiresDate2":Ljava/util/Date;
    invoke-virtual {v0, v1}, Ljava/util/Date;->compareTo(Ljava/util/Date;)I

    move-result v4

    return v4
.end method

.method public bridge synthetic compare(Ljava/lang/Object;Ljava/lang/Object;)I
    .locals 1

    .prologue
    .line 9
    check-cast p1, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;

    check-cast p2, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;

    invoke-virtual {p0, p1, p2}, Lcom/xfinity/playerlib/model/downloads/comparator/DownloadableFileExpirationComparator;->compare(Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;)I

    move-result v0

    return v0
.end method

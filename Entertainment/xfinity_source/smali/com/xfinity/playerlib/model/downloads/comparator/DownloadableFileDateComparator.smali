.class public Lcom/xfinity/playerlib/model/downloads/comparator/DownloadableFileDateComparator;
.super Ljava/lang/Object;
.source "DownloadableFileDateComparator.java"

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
    .line 8
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public compare(Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;)I
    .locals 3
    .param p1, "f1"    # Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;
    .param p2, "f2"    # Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;

    .prologue
    .line 12
    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;->getDownloadDate()Ljava/util/Date;

    move-result-object v0

    .line 13
    .local v0, "downloadDate1":Ljava/util/Date;
    invoke-virtual {p2}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;->getDownloadDate()Ljava/util/Date;

    move-result-object v1

    .line 16
    .local v1, "downloadDate2":Ljava/util/Date;
    invoke-virtual {v1, v0}, Ljava/util/Date;->compareTo(Ljava/util/Date;)I

    move-result v2

    return v2
.end method

.method public bridge synthetic compare(Ljava/lang/Object;Ljava/lang/Object;)I
    .locals 1

    .prologue
    .line 8
    check-cast p1, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;

    check-cast p2, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;

    invoke-virtual {p0, p1, p2}, Lcom/xfinity/playerlib/model/downloads/comparator/DownloadableFileDateComparator;->compare(Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;)I

    move-result v0

    return v0
.end method

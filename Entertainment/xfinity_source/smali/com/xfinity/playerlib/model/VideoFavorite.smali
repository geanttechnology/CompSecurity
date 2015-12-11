.class public Lcom/xfinity/playerlib/model/VideoFavorite;
.super Lcom/xfinity/playerlib/model/Favorite;
.source "VideoFavorite.java"


# instance fields
.field private merlinId:Lcom/xfinity/playerlib/model/MerlinId;


# direct methods
.method public constructor <init>(Lcom/xfinity/playerlib/model/MerlinId;Ljava/lang/String;)V
    .locals 0
    .param p1, "merlinId"    # Lcom/xfinity/playerlib/model/MerlinId;
    .param p2, "title"    # Ljava/lang/String;

    .prologue
    .line 19
    invoke-direct {p0, p2}, Lcom/xfinity/playerlib/model/Favorite;-><init>(Ljava/lang/String;)V

    .line 20
    iput-object p1, p0, Lcom/xfinity/playerlib/model/VideoFavorite;->merlinId:Lcom/xfinity/playerlib/model/MerlinId;

    .line 21
    return-void
.end method

.method public constructor <init>(Lcom/xfinity/playerlib/model/MerlinId;Ljava/lang/String;Z)V
    .locals 0
    .param p1, "merlinId"    # Lcom/xfinity/playerlib/model/MerlinId;
    .param p2, "title"    # Ljava/lang/String;
    .param p3, "adultContent"    # Z

    .prologue
    .line 24
    invoke-direct {p0, p2, p3}, Lcom/xfinity/playerlib/model/Favorite;-><init>(Ljava/lang/String;Z)V

    .line 25
    iput-object p1, p0, Lcom/xfinity/playerlib/model/VideoFavorite;->merlinId:Lcom/xfinity/playerlib/model/MerlinId;

    .line 26
    return-void
.end method

.method public constructor <init>(Lcom/xfinity/playerlib/model/MerlinId;Ljava/lang/String;ZLjava/util/Date;)V
    .locals 0
    .param p1, "merlinId"    # Lcom/xfinity/playerlib/model/MerlinId;
    .param p2, "title"    # Ljava/lang/String;
    .param p3, "adultContent"    # Z
    .param p4, "created"    # Ljava/util/Date;

    .prologue
    .line 14
    invoke-direct {p0, p2, p3, p4}, Lcom/xfinity/playerlib/model/Favorite;-><init>(Ljava/lang/String;ZLjava/util/Date;)V

    .line 15
    iput-object p1, p0, Lcom/xfinity/playerlib/model/VideoFavorite;->merlinId:Lcom/xfinity/playerlib/model/MerlinId;

    .line 16
    return-void
.end method


# virtual methods
.method public getMerlinId()Lcom/xfinity/playerlib/model/MerlinId;
    .locals 1

    .prologue
    .line 29
    iget-object v0, p0, Lcom/xfinity/playerlib/model/VideoFavorite;->merlinId:Lcom/xfinity/playerlib/model/MerlinId;

    return-object v0
.end method

.method public setMerlinId(Lcom/xfinity/playerlib/model/MerlinId;)V
    .locals 0
    .param p1, "merlinId"    # Lcom/xfinity/playerlib/model/MerlinId;

    .prologue
    .line 33
    iput-object p1, p0, Lcom/xfinity/playerlib/model/VideoFavorite;->merlinId:Lcom/xfinity/playerlib/model/MerlinId;

    .line 34
    return-void
.end method

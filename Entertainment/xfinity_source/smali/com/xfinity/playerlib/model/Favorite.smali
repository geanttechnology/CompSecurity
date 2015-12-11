.class public Lcom/xfinity/playerlib/model/Favorite;
.super Ljava/lang/Object;
.source "Favorite.java"


# instance fields
.field private adultContent:Z

.field private created:Ljava/util/Date;

.field private title:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;)V
    .locals 1
    .param p1, "title"    # Ljava/lang/String;

    .prologue
    .line 10
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 11
    iput-object p1, p0, Lcom/xfinity/playerlib/model/Favorite;->title:Ljava/lang/String;

    .line 12
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/xfinity/playerlib/model/Favorite;->adultContent:Z

    .line 13
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Z)V
    .locals 0
    .param p1, "title"    # Ljava/lang/String;
    .param p2, "adultContent"    # Z

    .prologue
    .line 15
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 16
    iput-object p1, p0, Lcom/xfinity/playerlib/model/Favorite;->title:Ljava/lang/String;

    .line 17
    iput-boolean p2, p0, Lcom/xfinity/playerlib/model/Favorite;->adultContent:Z

    .line 18
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;ZLjava/util/Date;)V
    .locals 0
    .param p1, "title"    # Ljava/lang/String;
    .param p2, "adultContent"    # Z
    .param p3, "created"    # Ljava/util/Date;

    .prologue
    .line 26
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 27
    iput-object p1, p0, Lcom/xfinity/playerlib/model/Favorite;->title:Ljava/lang/String;

    .line 28
    iput-boolean p2, p0, Lcom/xfinity/playerlib/model/Favorite;->adultContent:Z

    .line 29
    iput-object p3, p0, Lcom/xfinity/playerlib/model/Favorite;->created:Ljava/util/Date;

    .line 30
    return-void
.end method


# virtual methods
.method public getCreated()Ljava/util/Date;
    .locals 1

    .prologue
    .line 49
    iget-object v0, p0, Lcom/xfinity/playerlib/model/Favorite;->created:Ljava/util/Date;

    return-object v0
.end method

.method public getTitle()Ljava/lang/String;
    .locals 1

    .prologue
    .line 33
    iget-object v0, p0, Lcom/xfinity/playerlib/model/Favorite;->title:Ljava/lang/String;

    return-object v0
.end method

.method public isAdultContent()Z
    .locals 1

    .prologue
    .line 41
    iget-boolean v0, p0, Lcom/xfinity/playerlib/model/Favorite;->adultContent:Z

    return v0
.end method

.method public setAdultContent(Z)V
    .locals 0
    .param p1, "adultContent"    # Z

    .prologue
    .line 45
    iput-boolean p1, p0, Lcom/xfinity/playerlib/model/Favorite;->adultContent:Z

    .line 46
    return-void
.end method

.method public setCreated(Ljava/util/Date;)V
    .locals 0
    .param p1, "created"    # Ljava/util/Date;

    .prologue
    .line 53
    iput-object p1, p0, Lcom/xfinity/playerlib/model/Favorite;->created:Ljava/util/Date;

    .line 54
    return-void
.end method

.method public setTitle(Ljava/lang/String;)V
    .locals 0
    .param p1, "title"    # Ljava/lang/String;

    .prologue
    .line 37
    iput-object p1, p0, Lcom/xfinity/playerlib/model/Favorite;->title:Ljava/lang/String;

    .line 38
    return-void
.end method

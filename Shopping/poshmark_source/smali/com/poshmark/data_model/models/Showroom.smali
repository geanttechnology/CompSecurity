.class public Lcom/poshmark/data_model/models/Showroom;
.super Ljava/lang/Object;
.source "Showroom.java"


# instance fields
.field content_type:Ljava/lang/String;

.field cover_shot:Lcom/poshmark/data_model/models/inner_models/CoverShot;

.field created_at:Ljava/lang/String;

.field creator_id:Ljava/lang/String;

.field description:Ljava/lang/String;

.field id:Ljava/lang/String;

.field name:Ljava/lang/String;

.field short_url:Ljava/lang/String;

.field tags:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/inner_models/ShowroomTag;",
            ">;"
        }
    .end annotation
.end field

.field updated_at:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 15
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 25
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    invoke-static {v0}, Ljava/util/Collections;->synchronizedList(Ljava/util/List;)Ljava/util/List;

    move-result-object v0

    iput-object v0, p0, Lcom/poshmark/data_model/models/Showroom;->tags:Ljava/util/List;

    return-void
.end method


# virtual methods
.method public getCoverShot()Lcom/poshmark/data_model/models/inner_models/CoverShot;
    .locals 1

    .prologue
    .line 41
    iget-object v0, p0, Lcom/poshmark/data_model/models/Showroom;->cover_shot:Lcom/poshmark/data_model/models/inner_models/CoverShot;

    return-object v0
.end method

.method public getDescription()Ljava/lang/String;
    .locals 1

    .prologue
    .line 37
    iget-object v0, p0, Lcom/poshmark/data_model/models/Showroom;->description:Ljava/lang/String;

    return-object v0
.end method

.method public getId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 29
    iget-object v0, p0, Lcom/poshmark/data_model/models/Showroom;->id:Ljava/lang/String;

    return-object v0
.end method

.method public getName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 33
    iget-object v0, p0, Lcom/poshmark/data_model/models/Showroom;->name:Ljava/lang/String;

    return-object v0
.end method

.method public getShortURL()Ljava/lang/String;
    .locals 1

    .prologue
    .line 45
    iget-object v0, p0, Lcom/poshmark/data_model/models/Showroom;->short_url:Ljava/lang/String;

    return-object v0
.end method

.method public getWebURL()Ljava/lang/String;
    .locals 5

    .prologue
    .line 49
    const-string v0, "https://www.poshmark.com"

    .line 50
    .local v0, "baseURL":Ljava/lang/String;
    const-string v1, "%s/showroom/%s"

    const/4 v2, 0x2

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    aput-object v0, v2, v3

    const/4 v3, 0x1

    iget-object v4, p0, Lcom/poshmark/data_model/models/Showroom;->id:Ljava/lang/String;

    aput-object v4, v2, v3

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

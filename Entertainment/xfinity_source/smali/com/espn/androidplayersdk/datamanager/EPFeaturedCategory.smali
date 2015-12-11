.class public Lcom/espn/androidplayersdk/datamanager/EPFeaturedCategory;
.super Ljava/lang/Object;
.source "EPFeaturedCategory.java"

# interfaces
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x4eb65af01a14a2dbL


# instance fields
.field abbrevation:Ljava/lang/String;

.field categoryId:Ljava/lang/String;

.field imageUrl:Ljava/lang/String;

.field listingsUrl:Ljava/lang/String;

.field name:Ljava/lang/String;

.field shortName:Ljava/lang/String;

.field type:Ljava/lang/String;

.field vodUrl:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "categoryId"    # Ljava/lang/String;
    .param p2, "name"    # Ljava/lang/String;
    .param p3, "shortName"    # Ljava/lang/String;
    .param p4, "abbrevation"    # Ljava/lang/String;
    .param p5, "type"    # Ljava/lang/String;
    .param p6, "imageUrl"    # Ljava/lang/String;
    .param p7, "listingsUrl"    # Ljava/lang/String;
    .param p8, "vodUrl"    # Ljava/lang/String;

    .prologue
    .line 21
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 24
    iput-object p1, p0, Lcom/espn/androidplayersdk/datamanager/EPFeaturedCategory;->categoryId:Ljava/lang/String;

    .line 25
    iput-object p2, p0, Lcom/espn/androidplayersdk/datamanager/EPFeaturedCategory;->name:Ljava/lang/String;

    .line 26
    iput-object p3, p0, Lcom/espn/androidplayersdk/datamanager/EPFeaturedCategory;->shortName:Ljava/lang/String;

    .line 27
    iput-object p4, p0, Lcom/espn/androidplayersdk/datamanager/EPFeaturedCategory;->abbrevation:Ljava/lang/String;

    .line 28
    iput-object p5, p0, Lcom/espn/androidplayersdk/datamanager/EPFeaturedCategory;->type:Ljava/lang/String;

    .line 29
    iput-object p6, p0, Lcom/espn/androidplayersdk/datamanager/EPFeaturedCategory;->imageUrl:Ljava/lang/String;

    .line 30
    iput-object p7, p0, Lcom/espn/androidplayersdk/datamanager/EPFeaturedCategory;->listingsUrl:Ljava/lang/String;

    .line 31
    iput-object p8, p0, Lcom/espn/androidplayersdk/datamanager/EPFeaturedCategory;->vodUrl:Ljava/lang/String;

    .line 33
    return-void
.end method


# virtual methods
.method public getAbbrevation()Ljava/lang/String;
    .locals 1

    .prologue
    .line 44
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EPFeaturedCategory;->abbrevation:Ljava/lang/String;

    return-object v0
.end method

.method public getCategoryId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 56
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EPFeaturedCategory;->categoryId:Ljava/lang/String;

    return-object v0
.end method

.method public getImageUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 52
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EPFeaturedCategory;->imageUrl:Ljava/lang/String;

    return-object v0
.end method

.method protected getListingsUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 60
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EPFeaturedCategory;->listingsUrl:Ljava/lang/String;

    return-object v0
.end method

.method public getName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 36
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EPFeaturedCategory;->name:Ljava/lang/String;

    return-object v0
.end method

.method public getShortName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 40
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EPFeaturedCategory;->shortName:Ljava/lang/String;

    return-object v0
.end method

.method public getType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 48
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EPFeaturedCategory;->type:Ljava/lang/String;

    return-object v0
.end method

.method protected getVodUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 64
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EPFeaturedCategory;->vodUrl:Ljava/lang/String;

    return-object v0
.end method

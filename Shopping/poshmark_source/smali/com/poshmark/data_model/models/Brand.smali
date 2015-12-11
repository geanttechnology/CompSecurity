.class public Lcom/poshmark/data_model/models/Brand;
.super Ljava/lang/Object;
.source "Brand.java"


# instance fields
.field public canonical_name:Ljava/lang/String;

.field public cover_shot:Lcom/poshmark/data_model/models/inner_models/CoverShot;

.field public description:Ljava/lang/String;

.field public logo:Lcom/poshmark/data_model/models/inner_models/CoverShot;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static getDefaultBrandCovershotUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 75
    const-string v0, "https://d1g0nxoa63qf2e.cloudfront.net/apps/img/m_brand_share_default_v1.jpg"

    return-object v0
.end method

.method public static getUrlFromBrandName(Ljava/lang/String;)Ljava/lang/String;
    .locals 4
    .param p0, "brandName"    # Ljava/lang/String;

    .prologue
    .line 65
    const-string v1, "https://www.poshmark.com/brand/"

    .line 66
    .local v1, "url":Ljava/lang/String;
    if-eqz p0, :cond_0

    .line 67
    const-string v2, "/"

    const-string v3, "%2F"

    invoke-virtual {p0, v2, v3}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object p0

    .line 68
    invoke-static {p0}, Landroid/net/Uri;->encode(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 69
    .local v0, "encodedBrandName":Ljava/lang/String;
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 71
    .end local v0    # "encodedBrandName":Ljava/lang/String;
    :cond_0
    return-object v1
.end method


# virtual methods
.method getBrandCanonicalName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 18
    iget-object v0, p0, Lcom/poshmark/data_model/models/Brand;->canonical_name:Ljava/lang/String;

    return-object v0
.end method

.method getBrandCovershot()Ljava/lang/String;
    .locals 1

    .prologue
    .line 22
    iget-object v0, p0, Lcom/poshmark/data_model/models/Brand;->cover_shot:Lcom/poshmark/data_model/models/inner_models/CoverShot;

    if-eqz v0, :cond_0

    .line 23
    iget-object v0, p0, Lcom/poshmark/data_model/models/Brand;->cover_shot:Lcom/poshmark/data_model/models/inner_models/CoverShot;

    iget-object v0, v0, Lcom/poshmark/data_model/models/inner_models/CoverShot;->url:Ljava/lang/String;

    .line 25
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method getBrandCovershotSmall()Ljava/lang/String;
    .locals 1

    .prologue
    .line 29
    iget-object v0, p0, Lcom/poshmark/data_model/models/Brand;->cover_shot:Lcom/poshmark/data_model/models/inner_models/CoverShot;

    if-eqz v0, :cond_0

    .line 30
    iget-object v0, p0, Lcom/poshmark/data_model/models/Brand;->cover_shot:Lcom/poshmark/data_model/models/inner_models/CoverShot;

    iget-object v0, v0, Lcom/poshmark/data_model/models/inner_models/CoverShot;->url_small:Ljava/lang/String;

    .line 32
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method getBrandCovershotThumbnail()Ljava/lang/String;
    .locals 1

    .prologue
    .line 36
    iget-object v0, p0, Lcom/poshmark/data_model/models/Brand;->cover_shot:Lcom/poshmark/data_model/models/inner_models/CoverShot;

    if-eqz v0, :cond_0

    .line 37
    iget-object v0, p0, Lcom/poshmark/data_model/models/Brand;->cover_shot:Lcom/poshmark/data_model/models/inner_models/CoverShot;

    iget-object v0, v0, Lcom/poshmark/data_model/models/inner_models/CoverShot;->url_thumb:Ljava/lang/String;

    .line 39
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method getBrandLogo()Ljava/lang/String;
    .locals 1

    .prologue
    .line 57
    iget-object v0, p0, Lcom/poshmark/data_model/models/Brand;->logo:Lcom/poshmark/data_model/models/inner_models/CoverShot;

    if-eqz v0, :cond_0

    .line 58
    iget-object v0, p0, Lcom/poshmark/data_model/models/Brand;->logo:Lcom/poshmark/data_model/models/inner_models/CoverShot;

    iget-object v0, v0, Lcom/poshmark/data_model/models/inner_models/CoverShot;->url:Ljava/lang/String;

    .line 60
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method getBrandLogoSmall()Ljava/lang/String;
    .locals 1

    .prologue
    .line 43
    iget-object v0, p0, Lcom/poshmark/data_model/models/Brand;->logo:Lcom/poshmark/data_model/models/inner_models/CoverShot;

    if-eqz v0, :cond_0

    .line 44
    iget-object v0, p0, Lcom/poshmark/data_model/models/Brand;->logo:Lcom/poshmark/data_model/models/inner_models/CoverShot;

    iget-object v0, v0, Lcom/poshmark/data_model/models/inner_models/CoverShot;->url_small:Ljava/lang/String;

    .line 46
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method getBrandLogoThumbnail()Ljava/lang/String;
    .locals 1

    .prologue
    .line 50
    iget-object v0, p0, Lcom/poshmark/data_model/models/Brand;->logo:Lcom/poshmark/data_model/models/inner_models/CoverShot;

    if-eqz v0, :cond_0

    .line 51
    iget-object v0, p0, Lcom/poshmark/data_model/models/Brand;->logo:Lcom/poshmark/data_model/models/inner_models/CoverShot;

    iget-object v0, v0, Lcom/poshmark/data_model/models/inner_models/CoverShot;->url_thumb:Ljava/lang/String;

    .line 53
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

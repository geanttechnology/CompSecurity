.class public Lcom/poshmark/data_model/models/ShareBannerInfo$BannnerResponse$Data;
.super Ljava/lang/Object;
.source "ShareBannerInfo.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/data_model/models/ShareBannerInfo$BannnerResponse;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "Data"
.end annotation


# instance fields
.field public bg_color:Ljava/lang/String;

.field public image_url:Ljava/lang/String;

.field final synthetic this$1:Lcom/poshmark/data_model/models/ShareBannerInfo$BannnerResponse;


# direct methods
.method public constructor <init>(Lcom/poshmark/data_model/models/ShareBannerInfo$BannnerResponse;)V
    .locals 0

    .prologue
    .line 92
    iput-object p1, p0, Lcom/poshmark/data_model/models/ShareBannerInfo$BannnerResponse$Data;->this$1:Lcom/poshmark/data_model/models/ShareBannerInfo$BannnerResponse;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

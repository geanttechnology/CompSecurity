.class Lcom/poshmark/data_model/models/ShareBannerInfo$ExternalConnectSetting$Feature;
.super Ljava/lang/Object;
.source "ShareBannerInfo.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/data_model/models/ShareBannerInfo$ExternalConnectSetting;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "Feature"
.end annotation


# instance fields
.field listing_flow_share_toggle:Z

.field listing_flow_visibility:Z

.field final synthetic this$1:Lcom/poshmark/data_model/models/ShareBannerInfo$ExternalConnectSetting;


# direct methods
.method public constructor <init>(Lcom/poshmark/data_model/models/ShareBannerInfo$ExternalConnectSetting;)V
    .locals 0

    .prologue
    .line 71
    iput-object p1, p0, Lcom/poshmark/data_model/models/ShareBannerInfo$ExternalConnectSetting$Feature;->this$1:Lcom/poshmark/data_model/models/ShareBannerInfo$ExternalConnectSetting;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 72
    return-void
.end method

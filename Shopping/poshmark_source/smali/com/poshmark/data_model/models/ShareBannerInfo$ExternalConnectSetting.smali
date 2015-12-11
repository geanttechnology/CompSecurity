.class Lcom/poshmark/data_model/models/ShareBannerInfo$ExternalConnectSetting;
.super Ljava/lang/Object;
.source "ShareBannerInfo.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/data_model/models/ShareBannerInfo;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "ExternalConnectSetting"
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/poshmark/data_model/models/ShareBannerInfo$ExternalConnectSetting$Feature;
    }
.end annotation


# instance fields
.field fb:Lcom/poshmark/data_model/models/ShareBannerInfo$ExternalConnectSetting$Feature;

.field pn:Lcom/poshmark/data_model/models/ShareBannerInfo$ExternalConnectSetting$Feature;

.field final synthetic this$0:Lcom/poshmark/data_model/models/ShareBannerInfo;

.field tm:Lcom/poshmark/data_model/models/ShareBannerInfo$ExternalConnectSetting$Feature;

.field tw:Lcom/poshmark/data_model/models/ShareBannerInfo$ExternalConnectSetting$Feature;


# direct methods
.method public constructor <init>(Lcom/poshmark/data_model/models/ShareBannerInfo;)V
    .locals 3

    .prologue
    const/4 v2, 0x1

    .line 51
    iput-object p1, p0, Lcom/poshmark/data_model/models/ShareBannerInfo$ExternalConnectSetting;->this$0:Lcom/poshmark/data_model/models/ShareBannerInfo;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 52
    new-instance v0, Lcom/poshmark/data_model/models/ShareBannerInfo$ExternalConnectSetting$Feature;

    invoke-direct {v0, p0}, Lcom/poshmark/data_model/models/ShareBannerInfo$ExternalConnectSetting$Feature;-><init>(Lcom/poshmark/data_model/models/ShareBannerInfo$ExternalConnectSetting;)V

    iput-object v0, p0, Lcom/poshmark/data_model/models/ShareBannerInfo$ExternalConnectSetting;->fb:Lcom/poshmark/data_model/models/ShareBannerInfo$ExternalConnectSetting$Feature;

    .line 53
    iget-object v0, p0, Lcom/poshmark/data_model/models/ShareBannerInfo$ExternalConnectSetting;->fb:Lcom/poshmark/data_model/models/ShareBannerInfo$ExternalConnectSetting$Feature;

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v1

    invoke-virtual {v1}, Lcom/poshmark/application/PMApplicationSession;->getFacebookSharingFlag()Ljava/lang/Boolean;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v1

    iput-boolean v1, v0, Lcom/poshmark/data_model/models/ShareBannerInfo$ExternalConnectSetting$Feature;->listing_flow_share_toggle:Z

    .line 54
    iget-object v0, p0, Lcom/poshmark/data_model/models/ShareBannerInfo$ExternalConnectSetting;->fb:Lcom/poshmark/data_model/models/ShareBannerInfo$ExternalConnectSetting$Feature;

    iput-boolean v2, v0, Lcom/poshmark/data_model/models/ShareBannerInfo$ExternalConnectSetting$Feature;->listing_flow_visibility:Z

    .line 56
    new-instance v0, Lcom/poshmark/data_model/models/ShareBannerInfo$ExternalConnectSetting$Feature;

    invoke-direct {v0, p0}, Lcom/poshmark/data_model/models/ShareBannerInfo$ExternalConnectSetting$Feature;-><init>(Lcom/poshmark/data_model/models/ShareBannerInfo$ExternalConnectSetting;)V

    iput-object v0, p0, Lcom/poshmark/data_model/models/ShareBannerInfo$ExternalConnectSetting;->pn:Lcom/poshmark/data_model/models/ShareBannerInfo$ExternalConnectSetting$Feature;

    .line 57
    iget-object v0, p0, Lcom/poshmark/data_model/models/ShareBannerInfo$ExternalConnectSetting;->pn:Lcom/poshmark/data_model/models/ShareBannerInfo$ExternalConnectSetting$Feature;

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v1

    invoke-virtual {v1}, Lcom/poshmark/application/PMApplicationSession;->getPinterestSharingFlag()Ljava/lang/Boolean;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v1

    iput-boolean v1, v0, Lcom/poshmark/data_model/models/ShareBannerInfo$ExternalConnectSetting$Feature;->listing_flow_share_toggle:Z

    .line 58
    iget-object v0, p0, Lcom/poshmark/data_model/models/ShareBannerInfo$ExternalConnectSetting;->pn:Lcom/poshmark/data_model/models/ShareBannerInfo$ExternalConnectSetting$Feature;

    invoke-static {}, Lcom/poshmark/utils/FeatureManager;->getGlobalFeatureManager()Lcom/poshmark/utils/FeatureManager;

    move-result-object v1

    invoke-virtual {v1}, Lcom/poshmark/utils/FeatureManager;->isPinterestButtonEnabled()Z

    move-result v1

    iput-boolean v1, v0, Lcom/poshmark/data_model/models/ShareBannerInfo$ExternalConnectSetting$Feature;->listing_flow_visibility:Z

    .line 60
    new-instance v0, Lcom/poshmark/data_model/models/ShareBannerInfo$ExternalConnectSetting$Feature;

    invoke-direct {v0, p0}, Lcom/poshmark/data_model/models/ShareBannerInfo$ExternalConnectSetting$Feature;-><init>(Lcom/poshmark/data_model/models/ShareBannerInfo$ExternalConnectSetting;)V

    iput-object v0, p0, Lcom/poshmark/data_model/models/ShareBannerInfo$ExternalConnectSetting;->tw:Lcom/poshmark/data_model/models/ShareBannerInfo$ExternalConnectSetting$Feature;

    .line 61
    iget-object v0, p0, Lcom/poshmark/data_model/models/ShareBannerInfo$ExternalConnectSetting;->tw:Lcom/poshmark/data_model/models/ShareBannerInfo$ExternalConnectSetting$Feature;

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v1

    invoke-virtual {v1}, Lcom/poshmark/application/PMApplicationSession;->getTwitterSharingFlag()Ljava/lang/Boolean;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v1

    iput-boolean v1, v0, Lcom/poshmark/data_model/models/ShareBannerInfo$ExternalConnectSetting$Feature;->listing_flow_share_toggle:Z

    .line 62
    iget-object v0, p0, Lcom/poshmark/data_model/models/ShareBannerInfo$ExternalConnectSetting;->tw:Lcom/poshmark/data_model/models/ShareBannerInfo$ExternalConnectSetting$Feature;

    iput-boolean v2, v0, Lcom/poshmark/data_model/models/ShareBannerInfo$ExternalConnectSetting$Feature;->listing_flow_visibility:Z

    .line 64
    new-instance v0, Lcom/poshmark/data_model/models/ShareBannerInfo$ExternalConnectSetting$Feature;

    invoke-direct {v0, p0}, Lcom/poshmark/data_model/models/ShareBannerInfo$ExternalConnectSetting$Feature;-><init>(Lcom/poshmark/data_model/models/ShareBannerInfo$ExternalConnectSetting;)V

    iput-object v0, p0, Lcom/poshmark/data_model/models/ShareBannerInfo$ExternalConnectSetting;->tm:Lcom/poshmark/data_model/models/ShareBannerInfo$ExternalConnectSetting$Feature;

    .line 65
    iget-object v0, p0, Lcom/poshmark/data_model/models/ShareBannerInfo$ExternalConnectSetting;->tm:Lcom/poshmark/data_model/models/ShareBannerInfo$ExternalConnectSetting$Feature;

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v1

    invoke-virtual {v1}, Lcom/poshmark/application/PMApplicationSession;->getTumblrSharingFlag()Ljava/lang/Boolean;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v1

    iput-boolean v1, v0, Lcom/poshmark/data_model/models/ShareBannerInfo$ExternalConnectSetting$Feature;->listing_flow_share_toggle:Z

    .line 66
    iget-object v0, p0, Lcom/poshmark/data_model/models/ShareBannerInfo$ExternalConnectSetting;->tm:Lcom/poshmark/data_model/models/ShareBannerInfo$ExternalConnectSetting$Feature;

    iput-boolean v2, v0, Lcom/poshmark/data_model/models/ShareBannerInfo$ExternalConnectSetting$Feature;->listing_flow_visibility:Z

    .line 68
    return-void
.end method

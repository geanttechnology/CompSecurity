.class public Lcom/poshmark/data_model/models/ShareBannerInfo;
.super Ljava/lang/Object;
.source "ShareBannerInfo.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/poshmark/data_model/models/ShareBannerInfo$BannnerResponse;,
        Lcom/poshmark/data_model/models/ShareBannerInfo$DeviceInfo;,
        Lcom/poshmark/data_model/models/ShareBannerInfo$ExternalConnectSetting;
    }
.end annotation


# instance fields
.field public transient activity:Landroid/app/Activity;

.field public device_info:Lcom/poshmark/data_model/models/ShareBannerInfo$DeviceInfo;

.field public ext_apps_installed:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field public ext_connect_settings:Lcom/poshmark/data_model/models/ShareBannerInfo$ExternalConnectSetting;


# direct methods
.method public constructor <init>(Landroid/app/Activity;)V
    .locals 2
    .param p1, "activity"    # Landroid/app/Activity;

    .prologue
    .line 26
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 27
    iput-object p1, p0, Lcom/poshmark/data_model/models/ShareBannerInfo;->activity:Landroid/app/Activity;

    .line 28
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/poshmark/data_model/models/ShareBannerInfo;->ext_apps_installed:Ljava/util/List;

    .line 29
    new-instance v0, Lcom/poshmark/data_model/models/ShareBannerInfo$ExternalConnectSetting;

    invoke-direct {v0, p0}, Lcom/poshmark/data_model/models/ShareBannerInfo$ExternalConnectSetting;-><init>(Lcom/poshmark/data_model/models/ShareBannerInfo;)V

    iput-object v0, p0, Lcom/poshmark/data_model/models/ShareBannerInfo;->ext_connect_settings:Lcom/poshmark/data_model/models/ShareBannerInfo$ExternalConnectSetting;

    .line 30
    new-instance v0, Lcom/poshmark/data_model/models/ShareBannerInfo$DeviceInfo;

    invoke-direct {v0, p0, p1}, Lcom/poshmark/data_model/models/ShareBannerInfo$DeviceInfo;-><init>(Lcom/poshmark/data_model/models/ShareBannerInfo;Landroid/app/Activity;)V

    iput-object v0, p0, Lcom/poshmark/data_model/models/ShareBannerInfo;->device_info:Lcom/poshmark/data_model/models/ShareBannerInfo$DeviceInfo;

    .line 31
    invoke-static {p1}, Lcom/poshmark/utils/ExternalAppUtils;->isFacebookInstalled(Landroid/app/Activity;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 32
    iget-object v0, p0, Lcom/poshmark/data_model/models/ShareBannerInfo;->ext_apps_installed:Ljava/util/List;

    const-string v1, "fb"

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 34
    :cond_0
    invoke-static {p1}, Lcom/poshmark/utils/ExternalAppUtils;->isPinterestAllInstalled(Landroid/app/Activity;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 35
    iget-object v0, p0, Lcom/poshmark/data_model/models/ShareBannerInfo;->ext_apps_installed:Ljava/util/List;

    const-string v1, "pn"

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 37
    :cond_1
    invoke-static {p1}, Lcom/poshmark/utils/ExternalAppUtils;->isTumblrAppInstalled(Landroid/app/Activity;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 38
    iget-object v0, p0, Lcom/poshmark/data_model/models/ShareBannerInfo;->ext_apps_installed:Ljava/util/List;

    const-string v1, "tm"

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 40
    :cond_2
    invoke-static {p1}, Lcom/poshmark/utils/ExternalAppUtils;->isTwitterAppInstalled(Landroid/app/Activity;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 41
    iget-object v0, p0, Lcom/poshmark/data_model/models/ShareBannerInfo;->ext_apps_installed:Ljava/util/List;

    const-string v1, "tw"

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 43
    :cond_3
    return-void
.end method

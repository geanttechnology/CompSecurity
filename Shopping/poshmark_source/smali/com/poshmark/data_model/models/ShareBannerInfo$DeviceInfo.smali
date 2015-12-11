.class Lcom/poshmark/data_model/models/ShareBannerInfo$DeviceInfo;
.super Ljava/lang/Object;
.source "ShareBannerInfo.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/data_model/models/ShareBannerInfo;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "DeviceInfo"
.end annotation


# instance fields
.field height:F

.field final synthetic this$0:Lcom/poshmark/data_model/models/ShareBannerInfo;

.field width:F


# direct methods
.method public constructor <init>(Lcom/poshmark/data_model/models/ShareBannerInfo;Landroid/app/Activity;)V
    .locals 3
    .param p2, "activity"    # Landroid/app/Activity;

    .prologue
    .line 82
    iput-object p1, p0, Lcom/poshmark/data_model/models/ShareBannerInfo$DeviceInfo;->this$0:Lcom/poshmark/data_model/models/ShareBannerInfo;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 83
    invoke-virtual {p2}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    invoke-virtual {v2}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v2

    iget v2, v2, Landroid/util/DisplayMetrics;->widthPixels:I

    int-to-float v1, v2

    .line 84
    .local v1, "width":F
    const/high16 v2, 0x43480000    # 200.0f

    invoke-static {p2, v2}, Lcom/poshmark/utils/ViewUtils;->dipToPixels(Landroid/content/Context;F)F

    move-result v0

    .line 85
    .local v0, "height":F
    iput v0, p0, Lcom/poshmark/data_model/models/ShareBannerInfo$DeviceInfo;->height:F

    .line 86
    iput v1, p0, Lcom/poshmark/data_model/models/ShareBannerInfo$DeviceInfo;->width:F

    .line 87
    return-void
.end method

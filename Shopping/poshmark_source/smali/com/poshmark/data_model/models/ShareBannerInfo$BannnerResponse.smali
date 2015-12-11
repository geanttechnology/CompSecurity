.class public Lcom/poshmark/data_model/models/ShareBannerInfo$BannnerResponse;
.super Ljava/lang/Object;
.source "ShareBannerInfo.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/data_model/models/ShareBannerInfo;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "BannnerResponse"
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/poshmark/data_model/models/ShareBannerInfo$BannnerResponse$Data;
    }
.end annotation


# instance fields
.field public data:Lcom/poshmark/data_model/models/ShareBannerInfo$BannnerResponse$Data;

.field final synthetic this$0:Lcom/poshmark/data_model/models/ShareBannerInfo;


# direct methods
.method public constructor <init>(Lcom/poshmark/data_model/models/ShareBannerInfo;)V
    .locals 0

    .prologue
    .line 90
    iput-object p1, p0, Lcom/poshmark/data_model/models/ShareBannerInfo$BannnerResponse;->this$0:Lcom/poshmark/data_model/models/ShareBannerInfo;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 92
    return-void
.end method

.class final Lcom/amazon/mShop/util/UpgradeUtil$7;
.super Ljava/lang/Object;
.source "UpgradeUtil.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/util/UpgradeUtil;->checkForUpgradeLater()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 259
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 0

    .prologue
    .line 263
    invoke-static {}, Lcom/amazon/mShop/util/UpgradeUtil;->checkForUpgrade()V

    .line 264
    return-void
.end method

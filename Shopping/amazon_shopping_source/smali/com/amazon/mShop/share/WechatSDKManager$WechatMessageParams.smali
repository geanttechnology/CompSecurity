.class Lcom/amazon/mShop/share/WechatSDKManager$WechatMessageParams;
.super Ljava/lang/Object;
.source "WechatSDKManager.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/share/WechatSDKManager;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "WechatMessageParams"
.end annotation


# instance fields
.field private final context:Landroid/content/Context;

.field private final intent:Landroid/content/Intent;

.field private shareToFriend:Z


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/content/Intent;Z)V
    .locals 0
    .param p1, "shareContext"    # Landroid/content/Context;
    .param p2, "shareIntent"    # Landroid/content/Intent;
    .param p3, "shareToFriend"    # Z

    .prologue
    .line 352
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 353
    iput-object p1, p0, Lcom/amazon/mShop/share/WechatSDKManager$WechatMessageParams;->context:Landroid/content/Context;

    .line 354
    iput-object p2, p0, Lcom/amazon/mShop/share/WechatSDKManager$WechatMessageParams;->intent:Landroid/content/Intent;

    .line 355
    iput-boolean p3, p0, Lcom/amazon/mShop/share/WechatSDKManager$WechatMessageParams;->shareToFriend:Z

    .line 356
    return-void
.end method


# virtual methods
.method public getShareContext()Landroid/content/Context;
    .locals 1

    .prologue
    .line 359
    iget-object v0, p0, Lcom/amazon/mShop/share/WechatSDKManager$WechatMessageParams;->context:Landroid/content/Context;

    return-object v0
.end method

.method public getShareIntent()Landroid/content/Intent;
    .locals 1

    .prologue
    .line 363
    iget-object v0, p0, Lcom/amazon/mShop/share/WechatSDKManager$WechatMessageParams;->intent:Landroid/content/Intent;

    return-object v0
.end method

.method public isShareToFriend()Z
    .locals 1

    .prologue
    .line 367
    iget-boolean v0, p0, Lcom/amazon/mShop/share/WechatSDKManager$WechatMessageParams;->shareToFriend:Z

    return v0
.end method

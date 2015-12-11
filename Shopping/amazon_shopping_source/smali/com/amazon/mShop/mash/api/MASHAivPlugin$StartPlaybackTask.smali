.class Lcom/amazon/mShop/mash/api/MASHAivPlugin$StartPlaybackTask;
.super Ljava/lang/Object;
.source "MASHAivPlugin.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/mash/api/MASHAivPlugin;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "StartPlaybackTask"
.end annotation


# instance fields
.field private final mActivity:Landroid/app/Activity;

.field private final mAsin:Ljava/lang/String;

.field private final mCordovaPlugin:Lorg/apache/cordova/CordovaPlugin;

.field private final mTimecode:I


# direct methods
.method private constructor <init>(Ljava/lang/String;ILorg/apache/cordova/CordovaPlugin;)V
    .locals 1
    .param p1, "asin"    # Ljava/lang/String;
    .param p2, "timecode"    # I
    .param p3, "cordovaPlugin"    # Lorg/apache/cordova/CordovaPlugin;

    .prologue
    .line 230
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 231
    iget-object v0, p3, Lorg/apache/cordova/CordovaPlugin;->cordova:Lorg/apache/cordova/CordovaInterface;

    invoke-interface {v0}, Lorg/apache/cordova/CordovaInterface;->getActivity()Landroid/app/Activity;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/mShop/mash/api/MASHAivPlugin$StartPlaybackTask;->mActivity:Landroid/app/Activity;

    .line 232
    iput-object p1, p0, Lcom/amazon/mShop/mash/api/MASHAivPlugin$StartPlaybackTask;->mAsin:Ljava/lang/String;

    .line 233
    iput p2, p0, Lcom/amazon/mShop/mash/api/MASHAivPlugin$StartPlaybackTask;->mTimecode:I

    .line 234
    iput-object p3, p0, Lcom/amazon/mShop/mash/api/MASHAivPlugin$StartPlaybackTask;->mCordovaPlugin:Lorg/apache/cordova/CordovaPlugin;

    .line 235
    return-void
.end method

.method synthetic constructor <init>(Ljava/lang/String;ILorg/apache/cordova/CordovaPlugin;Lcom/amazon/mShop/mash/api/MASHAivPlugin$1;)V
    .locals 0
    .param p1, "x0"    # Ljava/lang/String;
    .param p2, "x1"    # I
    .param p3, "x2"    # Lorg/apache/cordova/CordovaPlugin;
    .param p4, "x3"    # Lcom/amazon/mShop/mash/api/MASHAivPlugin$1;

    .prologue
    .line 221
    invoke-direct {p0, p1, p2, p3}, Lcom/amazon/mShop/mash/api/MASHAivPlugin$StartPlaybackTask;-><init>(Ljava/lang/String;ILorg/apache/cordova/CordovaPlugin;)V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 6

    .prologue
    .line 239
    iget-object v1, p0, Lcom/amazon/mShop/mash/api/MASHAivPlugin$StartPlaybackTask;->mActivity:Landroid/app/Activity;

    instance-of v0, v1, Lorg/apache/cordova/CordovaInterface;

    .line 240
    .local v0, "canDelayCallback":Z
    if-eqz v0, :cond_1

    .line 242
    iget-object v1, p0, Lcom/amazon/mShop/mash/api/MASHAivPlugin$StartPlaybackTask;->mActivity:Landroid/app/Activity;

    check-cast v1, Lorg/apache/cordova/CordovaInterface;

    iget-object v2, p0, Lcom/amazon/mShop/mash/api/MASHAivPlugin$StartPlaybackTask;->mCordovaPlugin:Lorg/apache/cordova/CordovaPlugin;

    invoke-interface {v1, v2}, Lorg/apache/cordova/CordovaInterface;->setActivityResultCallback(Lorg/apache/cordova/CordovaPlugin;)V

    .line 247
    :goto_0
    invoke-static {}, Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;->getInstance()Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/mShop/mash/api/MASHAivPlugin$StartPlaybackTask;->mActivity:Landroid/app/Activity;

    iget-object v3, p0, Lcom/amazon/mShop/mash/api/MASHAivPlugin$StartPlaybackTask;->mAsin:Ljava/lang/String;

    iget v4, p0, Lcom/amazon/mShop/mash/api/MASHAivPlugin$StartPlaybackTask;->mTimecode:I

    int-to-long v4, v4

    invoke-virtual {v1, v2, v3, v4, v5}, Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;->startPlayback(Landroid/app/Activity;Ljava/lang/String;J)V

    .line 252
    if-nez v0, :cond_0

    .line 253
    iget-object v1, p0, Lcom/amazon/mShop/mash/api/MASHAivPlugin$StartPlaybackTask;->mCordovaPlugin:Lorg/apache/cordova/CordovaPlugin;

    const/4 v2, 0x1

    const/4 v3, -0x1

    const/4 v4, 0x0

    invoke-virtual {v1, v2, v3, v4}, Lorg/apache/cordova/CordovaPlugin;->onActivityResult(IILandroid/content/Intent;)V

    .line 255
    :cond_0
    return-void

    .line 244
    :cond_1
    const-string/jumbo v1, "aiv.StartPlayback"

    const-string/jumbo v2, "The activity in StartPlayback is not a CordovaInterface. Cannot delay callback."

    invoke-static {v1, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0
.end method

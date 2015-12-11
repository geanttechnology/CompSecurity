.class Lcom/amazon/mShop/mash/api/MASHAivPlugin$StartTrailerTask;
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
    name = "StartTrailerTask"
.end annotation


# instance fields
.field private final mActivity:Landroid/app/Activity;

.field private final mAsin:Ljava/lang/String;

.field private final mCallbackContext:Lorg/apache/cordova/CallbackContext;


# direct methods
.method private constructor <init>(Lorg/apache/cordova/CallbackContext;Landroid/app/Activity;Ljava/lang/String;)V
    .locals 0
    .param p1, "callbackContext"    # Lorg/apache/cordova/CallbackContext;
    .param p2, "activity"    # Landroid/app/Activity;
    .param p3, "asin"    # Ljava/lang/String;

    .prologue
    .line 278
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 279
    iput-object p1, p0, Lcom/amazon/mShop/mash/api/MASHAivPlugin$StartTrailerTask;->mCallbackContext:Lorg/apache/cordova/CallbackContext;

    .line 280
    iput-object p2, p0, Lcom/amazon/mShop/mash/api/MASHAivPlugin$StartTrailerTask;->mActivity:Landroid/app/Activity;

    .line 281
    iput-object p3, p0, Lcom/amazon/mShop/mash/api/MASHAivPlugin$StartTrailerTask;->mAsin:Ljava/lang/String;

    .line 282
    return-void
.end method

.method synthetic constructor <init>(Lorg/apache/cordova/CallbackContext;Landroid/app/Activity;Ljava/lang/String;Lcom/amazon/mShop/mash/api/MASHAivPlugin$1;)V
    .locals 0
    .param p1, "x0"    # Lorg/apache/cordova/CallbackContext;
    .param p2, "x1"    # Landroid/app/Activity;
    .param p3, "x2"    # Ljava/lang/String;
    .param p4, "x3"    # Lcom/amazon/mShop/mash/api/MASHAivPlugin$1;

    .prologue
    .line 273
    invoke-direct {p0, p1, p2, p3}, Lcom/amazon/mShop/mash/api/MASHAivPlugin$StartTrailerTask;-><init>(Lorg/apache/cordova/CallbackContext;Landroid/app/Activity;Ljava/lang/String;)V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 286
    invoke-static {}, Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;->getInstance()Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/mShop/mash/api/MASHAivPlugin$StartTrailerTask;->mActivity:Landroid/app/Activity;

    iget-object v2, p0, Lcom/amazon/mShop/mash/api/MASHAivPlugin$StartTrailerTask;->mAsin:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;->startTrailer(Landroid/app/Activity;Ljava/lang/String;)V

    .line 287
    iget-object v0, p0, Lcom/amazon/mShop/mash/api/MASHAivPlugin$StartTrailerTask;->mCallbackContext:Lorg/apache/cordova/CallbackContext;

    invoke-virtual {v0}, Lorg/apache/cordova/CallbackContext;->success()V

    .line 288
    return-void
.end method

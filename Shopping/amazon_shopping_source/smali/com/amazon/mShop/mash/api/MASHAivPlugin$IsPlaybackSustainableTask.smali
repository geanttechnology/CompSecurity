.class Lcom/amazon/mShop/mash/api/MASHAivPlugin$IsPlaybackSustainableTask;
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
    name = "IsPlaybackSustainableTask"
.end annotation


# instance fields
.field private final mCallbackContext:Lorg/apache/cordova/CallbackContext;


# direct methods
.method private constructor <init>(Lorg/apache/cordova/CallbackContext;)V
    .locals 0
    .param p1, "callbackContext"    # Lorg/apache/cordova/CallbackContext;

    .prologue
    .line 262
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 263
    iput-object p1, p0, Lcom/amazon/mShop/mash/api/MASHAivPlugin$IsPlaybackSustainableTask;->mCallbackContext:Lorg/apache/cordova/CallbackContext;

    .line 264
    return-void
.end method

.method synthetic constructor <init>(Lorg/apache/cordova/CallbackContext;Lcom/amazon/mShop/mash/api/MASHAivPlugin$1;)V
    .locals 0
    .param p1, "x0"    # Lorg/apache/cordova/CallbackContext;
    .param p2, "x1"    # Lcom/amazon/mShop/mash/api/MASHAivPlugin$1;

    .prologue
    .line 259
    invoke-direct {p0, p1}, Lcom/amazon/mShop/mash/api/MASHAivPlugin$IsPlaybackSustainableTask;-><init>(Lorg/apache/cordova/CallbackContext;)V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 268
    invoke-static {}, Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;->getInstance()Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;->isPlaybackSustainable()Z

    move-result v0

    .line 269
    .local v0, "isSustainable":Z
    iget-object v1, p0, Lcom/amazon/mShop/mash/api/MASHAivPlugin$IsPlaybackSustainableTask;->mCallbackContext:Lorg/apache/cordova/CallbackContext;

    invoke-static {v0}, Ljava/lang/String;->valueOf(Z)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lorg/apache/cordova/CallbackContext;->success(Ljava/lang/String;)V

    .line 270
    return-void
.end method

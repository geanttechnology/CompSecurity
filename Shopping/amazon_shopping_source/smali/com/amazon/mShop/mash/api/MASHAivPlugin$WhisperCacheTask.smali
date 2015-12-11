.class Lcom/amazon/mShop/mash/api/MASHAivPlugin$WhisperCacheTask;
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
    name = "WhisperCacheTask"
.end annotation


# instance fields
.field private final mAsins:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private final mCallbackContext:Lorg/apache/cordova/CallbackContext;


# direct methods
.method private constructor <init>(Lorg/apache/cordova/CallbackContext;Ljava/util/List;)V
    .locals 0
    .param p1, "callbackContext"    # Lorg/apache/cordova/CallbackContext;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lorg/apache/cordova/CallbackContext;",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 295
    .local p2, "asins":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 296
    iput-object p1, p0, Lcom/amazon/mShop/mash/api/MASHAivPlugin$WhisperCacheTask;->mCallbackContext:Lorg/apache/cordova/CallbackContext;

    .line 297
    iput-object p2, p0, Lcom/amazon/mShop/mash/api/MASHAivPlugin$WhisperCacheTask;->mAsins:Ljava/util/List;

    .line 298
    return-void
.end method

.method synthetic constructor <init>(Lorg/apache/cordova/CallbackContext;Ljava/util/List;Lcom/amazon/mShop/mash/api/MASHAivPlugin$1;)V
    .locals 0
    .param p1, "x0"    # Lorg/apache/cordova/CallbackContext;
    .param p2, "x1"    # Ljava/util/List;
    .param p3, "x2"    # Lcom/amazon/mShop/mash/api/MASHAivPlugin$1;

    .prologue
    .line 291
    invoke-direct {p0, p1, p2}, Lcom/amazon/mShop/mash/api/MASHAivPlugin$WhisperCacheTask;-><init>(Lorg/apache/cordova/CallbackContext;Ljava/util/List;)V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 302
    invoke-static {}, Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;->getInstance()Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/mShop/mash/api/MASHAivPlugin$WhisperCacheTask;->mAsins:Ljava/util/List;

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;->whisperCache(Ljava/util/List;)V

    .line 303
    iget-object v0, p0, Lcom/amazon/mShop/mash/api/MASHAivPlugin$WhisperCacheTask;->mCallbackContext:Lorg/apache/cordova/CallbackContext;

    invoke-virtual {v0}, Lorg/apache/cordova/CallbackContext;->success()V

    .line 304
    return-void
.end method

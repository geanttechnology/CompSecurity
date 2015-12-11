.class public abstract Lcom/amazon/identity/auth/device/framework/AmazonIntentService;
.super Landroid/app/IntentService;
.source "AmazonIntentService.java"


# static fields
.field public static final TAG:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 11
    const-class v0, Lcom/amazon/identity/auth/device/framework/AmazonIntentService;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/device/framework/AmazonIntentService;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 15
    invoke-direct {p0, p1}, Landroid/app/IntentService;-><init>(Ljava/lang/String;)V

    .line 16
    return-void
.end method


# virtual methods
.method public final onHandleIntent(Landroid/content/Intent;)V
    .locals 4
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    .line 23
    :try_start_0
    sget-object v1, Lcom/amazon/identity/auth/device/framework/AmazonIntentService;->TAG:Ljava/lang/String;

    new-instance v2, Ljava/lang/StringBuilder;

    const-string/jumbo v3, "Service Received: "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 24
    invoke-virtual {p0, p1}, Lcom/amazon/identity/auth/device/framework/AmazonIntentService;->protectedOnHandleIntent(Landroid/content/Intent;)V
    :try_end_0
    .catch Ljava/lang/RuntimeException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/Error; {:try_start_0 .. :try_end_0} :catch_1

    .line 35
    return-void

    .line 26
    :catch_0
    move-exception v0

    .line 28
    .local v0, "ex":Ljava/lang/RuntimeException;
    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/framework/AmazonIntentService;->stopSelf()V

    .line 29
    throw v0

    .line 31
    .end local v0    # "ex":Ljava/lang/RuntimeException;
    :catch_1
    move-exception v0

    .line 33
    .local v0, "ex":Ljava/lang/Error;
    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/framework/AmazonIntentService;->stopSelf()V

    .line 34
    throw v0
.end method

.method protected abstract protectedOnHandleIntent(Landroid/content/Intent;)V
.end method

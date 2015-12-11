.class public final Lcom/amazon/identity/auth/device/utils/IntentHelpers;
.super Ljava/lang/Object;
.source "IntentHelpers.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/identity/auth/device/utils/IntentHelpers$ReceiverQuerier;
    }
.end annotation


# static fields
.field private static final ACTIVITY_QUERIER:Lcom/amazon/identity/auth/device/utils/IntentHelpers$ReceiverQuerier;

.field private static final SERVICE_QUERIER:Lcom/amazon/identity/auth/device/utils/IntentHelpers$ReceiverQuerier;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 19
    new-instance v0, Lcom/amazon/identity/auth/device/utils/IntentHelpers$1;

    invoke-direct {v0}, Lcom/amazon/identity/auth/device/utils/IntentHelpers$1;-><init>()V

    sput-object v0, Lcom/amazon/identity/auth/device/utils/IntentHelpers;->ACTIVITY_QUERIER:Lcom/amazon/identity/auth/device/utils/IntentHelpers$ReceiverQuerier;

    .line 32
    new-instance v0, Lcom/amazon/identity/auth/device/utils/IntentHelpers$2;

    invoke-direct {v0}, Lcom/amazon/identity/auth/device/utils/IntentHelpers$2;-><init>()V

    sput-object v0, Lcom/amazon/identity/auth/device/utils/IntentHelpers;->SERVICE_QUERIER:Lcom/amazon/identity/auth/device/utils/IntentHelpers$ReceiverQuerier;

    return-void
.end method

.method private constructor <init>()V
    .locals 0

    .prologue
    .line 45
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 46
    return-void
.end method

.method public static constructIntent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    .locals 1
    .param p0, "action"    # Ljava/lang/String;
    .param p1, "packageName"    # Ljava/lang/String;
    .param p2, "className"    # Ljava/lang/String;

    .prologue
    .line 117
    new-instance v0, Landroid/content/Intent;

    invoke-direct {v0}, Landroid/content/Intent;-><init>()V

    .line 118
    .local v0, "intent":Landroid/content/Intent;
    if-eqz p0, :cond_0

    .line 120
    invoke-virtual {v0, p0}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 123
    :cond_0
    if-eqz p2, :cond_1

    .line 125
    invoke-virtual {v0, p1, p2}, Landroid/content/Intent;->setClassName(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 128
    :cond_1
    return-object v0
.end method

.method public static getBestIntentForActivity(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    .locals 1
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "action"    # Ljava/lang/String;
    .param p2, "activityClassName"    # Ljava/lang/String;

    .prologue
    .line 52
    sget-object v0, Lcom/amazon/identity/auth/device/utils/IntentHelpers;->ACTIVITY_QUERIER:Lcom/amazon/identity/auth/device/utils/IntentHelpers$ReceiverQuerier;

    invoke-static {p0, v0, p1, p2}, Lcom/amazon/identity/auth/device/utils/IntentHelpers;->getBestIntentForReceiver(Landroid/content/Context;Lcom/amazon/identity/auth/device/utils/IntentHelpers$ReceiverQuerier;Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v0

    return-object v0
.end method

.method private static getBestIntentForReceiver(Landroid/content/Context;Lcom/amazon/identity/auth/device/utils/IntentHelpers$ReceiverQuerier;Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    .locals 2
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "receiverQuerier"    # Lcom/amazon/identity/auth/device/utils/IntentHelpers$ReceiverQuerier;
    .param p2, "action"    # Ljava/lang/String;
    .param p3, "className"    # Ljava/lang/String;

    .prologue
    .line 67
    invoke-static {p0}, Lcom/amazon/identity/auth/device/utils/CentralApkUtils;->getCentralApkInfo(Landroid/content/Context;)Lcom/amazon/identity/auth/device/utils/CentralApkUtils$CentralApkDescription;

    move-result-object v1

    if-nez v1, :cond_0

    const/4 v0, 0x0

    .line 68
    .local v0, "centralApkIntent":Landroid/content/Intent;
    :goto_0
    if-eqz v0, :cond_1

    .line 73
    .end local v0    # "centralApkIntent":Landroid/content/Intent;
    :goto_1
    return-object v0

    .line 67
    :cond_0
    iget-object v1, v1, Lcom/amazon/identity/auth/device/utils/CentralApkUtils$CentralApkDescription;->mPackageName:Ljava/lang/String;

    invoke-static {p2, v1, p3}, Lcom/amazon/identity/auth/device/utils/IntentHelpers;->constructIntent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v1

    invoke-static {p0, p1, v1}, Lcom/amazon/identity/auth/device/utils/IntentHelpers;->getIntentIfItIsHandled(Landroid/content/Context;Lcom/amazon/identity/auth/device/utils/IntentHelpers$ReceiverQuerier;Landroid/content/Intent;)Landroid/content/Intent;

    move-result-object v0

    goto :goto_0

    .line 73
    .restart local v0    # "centralApkIntent":Landroid/content/Intent;
    :cond_1
    invoke-virtual {p0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v1

    invoke-static {p2, v1, p3}, Lcom/amazon/identity/auth/device/utils/IntentHelpers;->constructIntent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v1

    invoke-static {p0, p1, v1}, Lcom/amazon/identity/auth/device/utils/IntentHelpers;->getIntentIfItIsHandled(Landroid/content/Context;Lcom/amazon/identity/auth/device/utils/IntentHelpers$ReceiverQuerier;Landroid/content/Intent;)Landroid/content/Intent;

    move-result-object v0

    goto :goto_1
.end method

.method public static getBestIntentForService(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    .locals 1
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "action"    # Ljava/lang/String;
    .param p2, "serviceClassName"    # Ljava/lang/String;

    .prologue
    .line 59
    sget-object v0, Lcom/amazon/identity/auth/device/utils/IntentHelpers;->SERVICE_QUERIER:Lcom/amazon/identity/auth/device/utils/IntentHelpers$ReceiverQuerier;

    invoke-static {p0, v0, p1, p2}, Lcom/amazon/identity/auth/device/utils/IntentHelpers;->getBestIntentForReceiver(Landroid/content/Context;Lcom/amazon/identity/auth/device/utils/IntentHelpers$ReceiverQuerier;Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v0

    return-object v0
.end method

.method private static getIntentIfItIsHandled(Landroid/content/Context;Lcom/amazon/identity/auth/device/utils/IntentHelpers$ReceiverQuerier;Landroid/content/Intent;)Landroid/content/Intent;
    .locals 1
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "receiverQuerier"    # Lcom/amazon/identity/auth/device/utils/IntentHelpers$ReceiverQuerier;
    .param p2, "intent"    # Landroid/content/Intent;

    .prologue
    .line 107
    invoke-interface {p1, p0, p2}, Lcom/amazon/identity/auth/device/utils/IntentHelpers$ReceiverQuerier;->existsReceiverThatRespondsToIntent(Landroid/content/Context;Landroid/content/Intent;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 112
    .end local p2    # "intent":Landroid/content/Intent;
    :goto_0
    return-object p2

    .restart local p2    # "intent":Landroid/content/Intent;
    :cond_0
    const/4 p2, 0x0

    goto :goto_0
.end method

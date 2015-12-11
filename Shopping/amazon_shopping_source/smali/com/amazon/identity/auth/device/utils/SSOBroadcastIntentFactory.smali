.class public final Lcom/amazon/identity/auth/device/utils/SSOBroadcastIntentFactory;
.super Ljava/lang/Object;
.source "SSOBroadcastIntentFactory.java"


# direct methods
.method private constructor <init>()V
    .locals 0

    .prologue
    .line 10
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 11
    return-void
.end method

.method public static createIntent()Landroid/content/Intent;
    .locals 2
    .annotation build Landroid/annotation/SuppressLint;
        value = {
            "InlinedApi"
        }
    .end annotation

    .prologue
    .line 28
    new-instance v0, Landroid/content/Intent;

    invoke-direct {v0}, Landroid/content/Intent;-><init>()V

    .line 29
    .local v0, "newIntent":Landroid/content/Intent;
    const/16 v1, 0x20

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setFlags(I)Landroid/content/Intent;

    .line 30
    return-object v0
.end method

.method public static createIntent(Ljava/lang/String;)Landroid/content/Intent;
    .locals 1
    .param p0, "action"    # Ljava/lang/String;

    .prologue
    .line 15
    invoke-static {}, Lcom/amazon/identity/auth/device/utils/SSOBroadcastIntentFactory;->createIntent()Landroid/content/Intent;

    move-result-object v0

    .line 16
    .local v0, "newIntent":Landroid/content/Intent;
    invoke-virtual {v0, p0}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 17
    return-object v0
.end method

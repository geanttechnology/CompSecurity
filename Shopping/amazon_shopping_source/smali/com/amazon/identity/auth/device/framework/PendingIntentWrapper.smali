.class public final Lcom/amazon/identity/auth/device/framework/PendingIntentWrapper;
.super Ljava/lang/Object;
.source "PendingIntentWrapper.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/identity/auth/device/framework/PendingIntentWrapper$PendingIntentType;
    }
.end annotation


# instance fields
.field public final intent:Landroid/content/Intent;

.field public final pendingIntent:Landroid/app/PendingIntent;

.field public final pendingIntentType:Lcom/amazon/identity/auth/device/framework/PendingIntentWrapper$PendingIntentType;


# direct methods
.method private constructor <init>(Landroid/app/PendingIntent;Lcom/amazon/identity/auth/device/framework/PendingIntentWrapper$PendingIntentType;Landroid/content/Intent;)V
    .locals 0
    .param p1, "givenPendingIntent"    # Landroid/app/PendingIntent;
    .param p2, "givenType"    # Lcom/amazon/identity/auth/device/framework/PendingIntentWrapper$PendingIntentType;
    .param p3, "givenIntent"    # Landroid/content/Intent;

    .prologue
    .line 24
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 25
    iput-object p1, p0, Lcom/amazon/identity/auth/device/framework/PendingIntentWrapper;->pendingIntent:Landroid/app/PendingIntent;

    .line 26
    iput-object p2, p0, Lcom/amazon/identity/auth/device/framework/PendingIntentWrapper;->pendingIntentType:Lcom/amazon/identity/auth/device/framework/PendingIntentWrapper$PendingIntentType;

    .line 27
    iput-object p3, p0, Lcom/amazon/identity/auth/device/framework/PendingIntentWrapper;->intent:Landroid/content/Intent;

    .line 28
    return-void
.end method

.method private static constructWrapper(Landroid/app/PendingIntent;Lcom/amazon/identity/auth/device/framework/PendingIntentWrapper$PendingIntentType;Landroid/content/Intent;)Lcom/amazon/identity/auth/device/framework/PendingIntentWrapper;
    .locals 1
    .param p0, "pendingIntent"    # Landroid/app/PendingIntent;
    .param p1, "type"    # Lcom/amazon/identity/auth/device/framework/PendingIntentWrapper$PendingIntentType;
    .param p2, "intent"    # Landroid/content/Intent;

    .prologue
    .line 61
    if-nez p0, :cond_0

    .line 63
    const/4 v0, 0x0

    .line 65
    :goto_0
    return-object v0

    :cond_0
    new-instance v0, Lcom/amazon/identity/auth/device/framework/PendingIntentWrapper;

    invoke-direct {v0, p0, p1, p2}, Lcom/amazon/identity/auth/device/framework/PendingIntentWrapper;-><init>(Landroid/app/PendingIntent;Lcom/amazon/identity/auth/device/framework/PendingIntentWrapper$PendingIntentType;Landroid/content/Intent;)V

    goto :goto_0
.end method

.method public static getActivity(Landroid/content/Context;ILandroid/content/Intent;I)Lcom/amazon/identity/auth/device/framework/PendingIntentWrapper;
    .locals 2
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "requestCode"    # I
    .param p2, "intent"    # Landroid/content/Intent;
    .param p3, "flags"    # I

    .prologue
    .line 53
    invoke-static {p0, p1, p2, p3}, Landroid/app/PendingIntent;->getActivity(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;

    move-result-object v0

    .line 54
    sget-object v1, Lcom/amazon/identity/auth/device/framework/PendingIntentWrapper$PendingIntentType;->Activity:Lcom/amazon/identity/auth/device/framework/PendingIntentWrapper$PendingIntentType;

    invoke-static {v0, v1, p2}, Lcom/amazon/identity/auth/device/framework/PendingIntentWrapper;->constructWrapper(Landroid/app/PendingIntent;Lcom/amazon/identity/auth/device/framework/PendingIntentWrapper$PendingIntentType;Landroid/content/Intent;)Lcom/amazon/identity/auth/device/framework/PendingIntentWrapper;

    move-result-object v0

    return-object v0
.end method

.method public static getBroadcast(Landroid/content/Context;ILandroid/content/Intent;I)Lcom/amazon/identity/auth/device/framework/PendingIntentWrapper;
    .locals 2
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "requestCode"    # I
    .param p2, "intent"    # Landroid/content/Intent;
    .param p3, "flags"    # I

    .prologue
    .line 44
    invoke-static {p0, p1, p2, p3}, Landroid/app/PendingIntent;->getBroadcast(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;

    move-result-object v0

    .line 45
    sget-object v1, Lcom/amazon/identity/auth/device/framework/PendingIntentWrapper$PendingIntentType;->Broadcast:Lcom/amazon/identity/auth/device/framework/PendingIntentWrapper$PendingIntentType;

    invoke-static {v0, v1, p2}, Lcom/amazon/identity/auth/device/framework/PendingIntentWrapper;->constructWrapper(Landroid/app/PendingIntent;Lcom/amazon/identity/auth/device/framework/PendingIntentWrapper$PendingIntentType;Landroid/content/Intent;)Lcom/amazon/identity/auth/device/framework/PendingIntentWrapper;

    move-result-object v0

    return-object v0
.end method

.method public static getService(Landroid/content/Context;ILandroid/content/Intent;I)Lcom/amazon/identity/auth/device/framework/PendingIntentWrapper;
    .locals 2
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "requestCode"    # I
    .param p2, "intent"    # Landroid/content/Intent;
    .param p3, "flags"    # I

    .prologue
    .line 35
    invoke-static {p0, p1, p2, p3}, Landroid/app/PendingIntent;->getService(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;

    move-result-object v0

    .line 36
    sget-object v1, Lcom/amazon/identity/auth/device/framework/PendingIntentWrapper$PendingIntentType;->Service:Lcom/amazon/identity/auth/device/framework/PendingIntentWrapper$PendingIntentType;

    invoke-static {v0, v1, p2}, Lcom/amazon/identity/auth/device/framework/PendingIntentWrapper;->constructWrapper(Landroid/app/PendingIntent;Lcom/amazon/identity/auth/device/framework/PendingIntentWrapper$PendingIntentType;Landroid/content/Intent;)Lcom/amazon/identity/auth/device/framework/PendingIntentWrapper;

    move-result-object v0

    return-object v0
.end method

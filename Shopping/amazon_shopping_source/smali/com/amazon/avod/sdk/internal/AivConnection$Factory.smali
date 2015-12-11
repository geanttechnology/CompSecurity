.class public Lcom/amazon/avod/sdk/internal/AivConnection$Factory;
.super Ljava/lang/Object;
.source "AivConnection.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/avod/sdk/internal/AivConnection;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Factory"
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 130
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static newConnection(Landroid/content/Context;)Lcom/amazon/avod/sdk/internal/AivConnection;
    .locals 4
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 133
    new-instance v1, Lcom/amazon/avod/sdk/internal/IntentConnection;

    invoke-direct {v1, p0}, Lcom/amazon/avod/sdk/internal/IntentConnection;-><init>(Landroid/content/Context;)V

    .line 134
    .local v1, "intentConnection":Lcom/amazon/avod/sdk/internal/AivConnection;
    new-instance v0, Lcom/amazon/avod/sdk/internal/BindingConnection;

    invoke-direct {v0, p0, v1}, Lcom/amazon/avod/sdk/internal/BindingConnection;-><init>(Landroid/content/Context;Lcom/amazon/avod/sdk/internal/AivConnection;)V

    .line 135
    .local v0, "bindingConnection":Lcom/amazon/avod/sdk/internal/AivConnection;
    invoke-interface {v0}, Lcom/amazon/avod/sdk/internal/AivConnection;->tryConnect()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 141
    .end local v0    # "bindingConnection":Lcom/amazon/avod/sdk/internal/AivConnection;
    :goto_0
    return-object v0

    .line 140
    .restart local v0    # "bindingConnection":Lcom/amazon/avod/sdk/internal/AivConnection;
    :cond_0
    invoke-interface {v1}, Lcom/amazon/avod/sdk/internal/AivConnection;->tryConnect()Z

    move-result v2

    if-eqz v2, :cond_1

    move-object v0, v1

    .line 141
    goto :goto_0

    .line 148
    :cond_1
    new-instance v2, Ljava/lang/IllegalStateException;

    const-string/jumbo v3, "Cannot communicate with AIV. Verify the app is installed"

    invoke-direct {v2, v3}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v2
.end method

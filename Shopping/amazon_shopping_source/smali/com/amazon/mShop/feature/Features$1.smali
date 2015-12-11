.class Lcom/amazon/mShop/feature/Features$1;
.super Ljava/lang/Object;
.source "Features.java"

# interfaces
.implements Lcom/amazon/rio/j2me/client/services/mShop/FeatureStateResponseListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/feature/Features;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/feature/Features;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/feature/Features;)V
    .locals 0

    .prologue
    .line 449
    iput-object p1, p0, Lcom/amazon/mShop/feature/Features$1;->this$0:Lcom/amazon/mShop/feature/Features;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public cancelled(Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 2
    .param p1, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 495
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/feature/Features$1$3;

    invoke-direct {v1, p0}, Lcom/amazon/mShop/feature/Features$1$3;-><init>(Lcom/amazon/mShop/feature/Features$1;)V

    invoke-interface {v0, v1}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;)V

    .line 502
    return-void
.end method

.method public completed(Lcom/amazon/rio/j2me/client/services/mShop/FeatureStateResponse;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 2
    .param p1, "response"    # Lcom/amazon/rio/j2me/client/services/mShop/FeatureStateResponse;
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 454
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/feature/Features$1$1;

    invoke-direct {v1, p0, p1}, Lcom/amazon/mShop/feature/Features$1$1;-><init>(Lcom/amazon/mShop/feature/Features$1;Lcom/amazon/rio/j2me/client/services/mShop/FeatureStateResponse;)V

    invoke-interface {v0, v1}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;)V

    .line 480
    return-void
.end method

.method public error(Ljava/lang/Exception;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 2
    .param p1, "e"    # Ljava/lang/Exception;
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 484
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/feature/Features$1$2;

    invoke-direct {v1, p0, p1}, Lcom/amazon/mShop/feature/Features$1$2;-><init>(Lcom/amazon/mShop/feature/Features$1;Ljava/lang/Exception;)V

    invoke-interface {v0, v1}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;)V

    .line 491
    return-void
.end method

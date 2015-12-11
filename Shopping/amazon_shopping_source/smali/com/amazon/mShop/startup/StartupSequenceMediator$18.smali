.class Lcom/amazon/mShop/startup/StartupSequenceMediator$18;
.super Ljava/lang/Object;
.source "StartupSequenceMediator.java"

# interfaces
.implements Lcom/amazon/rio/j2me/client/services/mShop/PostEventsResponseListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/startup/StartupSequenceMediator;->postFaceBookAdvertisedInstallationEvent(Landroid/content/Context;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/startup/StartupSequenceMediator;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/startup/StartupSequenceMediator;)V
    .locals 0

    .prologue
    .line 539
    iput-object p1, p0, Lcom/amazon/mShop/startup/StartupSequenceMediator$18;->this$0:Lcom/amazon/mShop/startup/StartupSequenceMediator;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public cancelled(Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 0
    .param p1, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 543
    return-void
.end method

.method public completed(Lcom/amazon/rio/j2me/client/services/mShop/PostEventsResponse;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 0
    .param p1, "value"    # Lcom/amazon/rio/j2me/client/services/mShop/PostEventsResponse;
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 545
    return-void
.end method

.method public error(Ljava/lang/Exception;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 0
    .param p1, "e"    # Ljava/lang/Exception;
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 541
    return-void
.end method

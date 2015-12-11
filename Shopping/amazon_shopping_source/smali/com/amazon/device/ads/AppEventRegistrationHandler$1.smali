.class Lcom/amazon/device/ads/AppEventRegistrationHandler$1;
.super Ljava/lang/Object;
.source "AppEventRegistrationHandler.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/device/ads/AppEventRegistrationHandler;->addEventToAppEventsCacheFile(Lcom/amazon/device/ads/AppEvent;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/device/ads/AppEventRegistrationHandler;

.field final synthetic val$appEvent:Lcom/amazon/device/ads/AppEvent;


# direct methods
.method constructor <init>(Lcom/amazon/device/ads/AppEventRegistrationHandler;Lcom/amazon/device/ads/AppEvent;)V
    .locals 0

    .prologue
    .line 75
    iput-object p1, p0, Lcom/amazon/device/ads/AppEventRegistrationHandler$1;->this$0:Lcom/amazon/device/ads/AppEventRegistrationHandler;

    iput-object p2, p0, Lcom/amazon/device/ads/AppEventRegistrationHandler$1;->val$appEvent:Lcom/amazon/device/ads/AppEvent;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 79
    iget-object v0, p0, Lcom/amazon/device/ads/AppEventRegistrationHandler$1;->this$0:Lcom/amazon/device/ads/AppEventRegistrationHandler;

    iget-object v1, p0, Lcom/amazon/device/ads/AppEventRegistrationHandler$1;->val$appEvent:Lcom/amazon/device/ads/AppEvent;

    invoke-virtual {v0, v1}, Lcom/amazon/device/ads/AppEventRegistrationHandler;->appendAppEventToFile(Lcom/amazon/device/ads/AppEvent;)V

    .line 80
    return-void
.end method

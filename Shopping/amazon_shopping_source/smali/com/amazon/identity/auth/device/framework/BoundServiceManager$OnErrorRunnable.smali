.class Lcom/amazon/identity/auth/device/framework/BoundServiceManager$OnErrorRunnable;
.super Ljava/lang/Object;
.source "BoundServiceManager.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/identity/auth/device/framework/BoundServiceManager;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "OnErrorRunnable"
.end annotation


# instance fields
.field private final mCallback:Lcom/amazon/identity/auth/device/framework/BoundServiceManager$BoundServiceCallback;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/amazon/identity/auth/device/framework/BoundServiceManager$BoundServiceCallback",
            "<*>;"
        }
    .end annotation
.end field


# direct methods
.method constructor <init>(Lcom/amazon/identity/auth/device/framework/BoundServiceManager$BoundServiceCallback;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/amazon/identity/auth/device/framework/BoundServiceManager$BoundServiceCallback",
            "<*>;)V"
        }
    .end annotation

    .prologue
    .line 362
    .local p1, "callback":Lcom/amazon/identity/auth/device/framework/BoundServiceManager$BoundServiceCallback;, "Lcom/amazon/identity/auth/device/framework/BoundServiceManager$BoundServiceCallback<*>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 363
    iput-object p1, p0, Lcom/amazon/identity/auth/device/framework/BoundServiceManager$OnErrorRunnable;->mCallback:Lcom/amazon/identity/auth/device/framework/BoundServiceManager$BoundServiceCallback;

    .line 364
    return-void
.end method


# virtual methods
.method public run()V
    .locals 1

    .prologue
    .line 369
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/BoundServiceManager$OnErrorRunnable;->mCallback:Lcom/amazon/identity/auth/device/framework/BoundServiceManager$BoundServiceCallback;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/framework/BoundServiceManager$BoundServiceCallback;->onError()V

    .line 370
    return-void
.end method

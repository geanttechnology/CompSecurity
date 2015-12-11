.class Lcom/amazon/identity/auth/device/CommonInfoGetter$1;
.super Ljava/lang/Object;
.source "CommonInfoGetter.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/identity/auth/device/CommonInfoGetter;->init()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/identity/auth/device/CommonInfoGetter;


# direct methods
.method constructor <init>(Lcom/amazon/identity/auth/device/CommonInfoGetter;)V
    .locals 0

    .prologue
    .line 91
    iput-object p1, p0, Lcom/amazon/identity/auth/device/CommonInfoGetter$1;->this$0:Lcom/amazon/identity/auth/device/CommonInfoGetter;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 98
    :try_start_0
    iget-object v0, p0, Lcom/amazon/identity/auth/device/CommonInfoGetter$1;->this$0:Lcom/amazon/identity/auth/device/CommonInfoGetter;

    invoke-static {v0}, Lcom/amazon/identity/auth/device/CommonInfoGetter;->access$000(Lcom/amazon/identity/auth/device/CommonInfoGetter;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 102
    iget-object v0, p0, Lcom/amazon/identity/auth/device/CommonInfoGetter$1;->this$0:Lcom/amazon/identity/auth/device/CommonInfoGetter;

    # getter for: Lcom/amazon/identity/auth/device/CommonInfoGetter;->mLatch:Ljava/util/concurrent/CountDownLatch;
    invoke-static {v0}, Lcom/amazon/identity/auth/device/CommonInfoGetter;->access$100(Lcom/amazon/identity/auth/device/CommonInfoGetter;)Ljava/util/concurrent/CountDownLatch;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/concurrent/CountDownLatch;->countDown()V

    .line 103
    return-void

    .line 102
    :catchall_0
    move-exception v0

    iget-object v1, p0, Lcom/amazon/identity/auth/device/CommonInfoGetter$1;->this$0:Lcom/amazon/identity/auth/device/CommonInfoGetter;

    # getter for: Lcom/amazon/identity/auth/device/CommonInfoGetter;->mLatch:Ljava/util/concurrent/CountDownLatch;
    invoke-static {v1}, Lcom/amazon/identity/auth/device/CommonInfoGetter;->access$100(Lcom/amazon/identity/auth/device/CommonInfoGetter;)Ljava/util/concurrent/CountDownLatch;

    move-result-object v1

    invoke-virtual {v1}, Ljava/util/concurrent/CountDownLatch;->countDown()V

    throw v0
.end method

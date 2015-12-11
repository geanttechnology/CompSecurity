.class Lcom/amazon/mShop/feature/Features$1$3;
.super Ljava/lang/Object;
.source "Features.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/feature/Features$1;->cancelled(Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/amazon/mShop/feature/Features$1;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/feature/Features$1;)V
    .locals 0

    .prologue
    .line 495
    iput-object p1, p0, Lcom/amazon/mShop/feature/Features$1$3;->this$1:Lcom/amazon/mShop/feature/Features$1;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 1

    .prologue
    .line 498
    iget-object v0, p0, Lcom/amazon/mShop/feature/Features$1$3;->this$1:Lcom/amazon/mShop/feature/Features$1;

    iget-object v0, v0, Lcom/amazon/mShop/feature/Features$1;->this$0:Lcom/amazon/mShop/feature/Features;

    # invokes: Lcom/amazon/mShop/feature/Features;->notifyCancel()V
    invoke-static {v0}, Lcom/amazon/mShop/feature/Features;->access$300(Lcom/amazon/mShop/feature/Features;)V

    .line 499
    return-void
.end method

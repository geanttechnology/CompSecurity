.class Lcom/amazon/mShop/AmazonActivity$DelayedInitializer$1;
.super Ljava/lang/Object;
.source "AmazonActivity.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/AmazonActivity$DelayedInitializer;->run()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/amazon/mShop/AmazonActivity$DelayedInitializer;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/AmazonActivity$DelayedInitializer;)V
    .locals 0

    .prologue
    .line 397
    iput-object p1, p0, Lcom/amazon/mShop/AmazonActivity$DelayedInitializer$1;->this$1:Lcom/amazon/mShop/AmazonActivity$DelayedInitializer;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 1

    .prologue
    .line 400
    iget-object v0, p0, Lcom/amazon/mShop/AmazonActivity$DelayedInitializer$1;->this$1:Lcom/amazon/mShop/AmazonActivity$DelayedInitializer;

    # getter for: Lcom/amazon/mShop/AmazonActivity$DelayedInitializer;->view:Lcom/amazon/mShop/DelayedInitView;
    invoke-static {v0}, Lcom/amazon/mShop/AmazonActivity$DelayedInitializer;->access$000(Lcom/amazon/mShop/AmazonActivity$DelayedInitializer;)Lcom/amazon/mShop/DelayedInitView;

    move-result-object v0

    invoke-interface {v0}, Lcom/amazon/mShop/DelayedInitView;->onPushViewCompleted()V

    .line 401
    return-void
.end method

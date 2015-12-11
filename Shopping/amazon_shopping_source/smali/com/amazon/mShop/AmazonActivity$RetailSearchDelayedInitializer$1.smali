.class Lcom/amazon/mShop/AmazonActivity$RetailSearchDelayedInitializer$1;
.super Ljava/lang/Object;
.source "AmazonActivity.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/AmazonActivity$RetailSearchDelayedInitializer;->run()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/amazon/mShop/AmazonActivity$RetailSearchDelayedInitializer;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/AmazonActivity$RetailSearchDelayedInitializer;)V
    .locals 0

    .prologue
    .line 430
    iput-object p1, p0, Lcom/amazon/mShop/AmazonActivity$RetailSearchDelayedInitializer$1;->this$1:Lcom/amazon/mShop/AmazonActivity$RetailSearchDelayedInitializer;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 1

    .prologue
    .line 433
    iget-object v0, p0, Lcom/amazon/mShop/AmazonActivity$RetailSearchDelayedInitializer$1;->this$1:Lcom/amazon/mShop/AmazonActivity$RetailSearchDelayedInitializer;

    # getter for: Lcom/amazon/mShop/AmazonActivity$RetailSearchDelayedInitializer;->view:Lcom/amazon/retailsearch/android/ui/DelayedInitView;
    invoke-static {v0}, Lcom/amazon/mShop/AmazonActivity$RetailSearchDelayedInitializer;->access$100(Lcom/amazon/mShop/AmazonActivity$RetailSearchDelayedInitializer;)Lcom/amazon/retailsearch/android/ui/DelayedInitView;

    move-result-object v0

    invoke-interface {v0}, Lcom/amazon/retailsearch/android/ui/DelayedInitView;->onPushViewCompleted()V

    .line 434
    return-void
.end method

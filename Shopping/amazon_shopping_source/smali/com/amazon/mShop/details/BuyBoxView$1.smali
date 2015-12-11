.class Lcom/amazon/mShop/details/BuyBoxView$1;
.super Ljava/lang/Object;
.source "BuyBoxView.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/details/BuyBoxView;->update(Z)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/details/BuyBoxView;

.field final synthetic val$isLoading:Z


# direct methods
.method constructor <init>(Lcom/amazon/mShop/details/BuyBoxView;Z)V
    .locals 0

    .prologue
    .line 53
    iput-object p1, p0, Lcom/amazon/mShop/details/BuyBoxView$1;->this$0:Lcom/amazon/mShop/details/BuyBoxView;

    iput-boolean p2, p0, Lcom/amazon/mShop/details/BuyBoxView$1;->val$isLoading:Z

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 56
    iget-object v0, p0, Lcom/amazon/mShop/details/BuyBoxView$1;->this$0:Lcom/amazon/mShop/details/BuyBoxView;

    iget-boolean v1, p0, Lcom/amazon/mShop/details/BuyBoxView$1;->val$isLoading:Z

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/details/BuyBoxView;->updateButtons(Z)V

    .line 57
    iget-object v0, p0, Lcom/amazon/mShop/details/BuyBoxView$1;->this$0:Lcom/amazon/mShop/details/BuyBoxView;

    iget-boolean v1, p0, Lcom/amazon/mShop/details/BuyBoxView$1;->val$isLoading:Z

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/details/BuyBoxView;->updateStatus(Z)V

    .line 58
    return-void
.end method

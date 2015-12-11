.class Lcom/amazon/mShop/youraccount/AmazonPointsView$1;
.super Ljava/lang/Object;
.source "AmazonPointsView.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/youraccount/AmazonPointsView;->initSummary()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/youraccount/AmazonPointsView;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/youraccount/AmazonPointsView;)V
    .locals 0

    .prologue
    .line 72
    iput-object p1, p0, Lcom/amazon/mShop/youraccount/AmazonPointsView$1;->this$0:Lcom/amazon/mShop/youraccount/AmazonPointsView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 2
    .param p1, "view"    # Landroid/view/View;

    .prologue
    const/4 v1, 0x0

    .line 75
    iget-object v0, p0, Lcom/amazon/mShop/youraccount/AmazonPointsView$1;->this$0:Lcom/amazon/mShop/youraccount/AmazonPointsView;

    # getter for: Lcom/amazon/mShop/youraccount/AmazonPointsView;->activity:Lcom/amazon/mShop/AmazonActivity;
    invoke-static {v0}, Lcom/amazon/mShop/youraccount/AmazonPointsView;->access$000(Lcom/amazon/mShop/youraccount/AmazonPointsView;)Lcom/amazon/mShop/AmazonActivity;

    move-result-object v0

    invoke-virtual {v0, v1, v1}, Lcom/amazon/mShop/AmazonActivity;->authenticateUser(Lcom/amazon/mShop/model/auth/UserSubscriber$Callback;Lcom/amazon/mShop/model/auth/UserSubscriber$Callback;)V

    .line 76
    return-void
.end method

.class Lcom/amazon/mShop/youraccount/AmazonPointsView$2;
.super Ljava/lang/Object;
.source "AmazonPointsView.java"

# interfaces
.implements Lcom/amazon/mShop/error/AmazonErrorBox$AmazonErrorBoxActionListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/youraccount/AmazonPointsView;->onError(Ljava/lang/Exception;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
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
    .line 112
    iput-object p1, p0, Lcom/amazon/mShop/youraccount/AmazonPointsView$2;->this$0:Lcom/amazon/mShop/youraccount/AmazonPointsView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onActionButtonClick(I)V
    .locals 1
    .param p1, "errorId"    # I

    .prologue
    .line 115
    iget-object v0, p0, Lcom/amazon/mShop/youraccount/AmazonPointsView$2;->this$0:Lcom/amazon/mShop/youraccount/AmazonPointsView;

    # invokes: Lcom/amazon/mShop/youraccount/AmazonPointsView;->doGetPointsSummary()V
    invoke-static {v0}, Lcom/amazon/mShop/youraccount/AmazonPointsView;->access$100(Lcom/amazon/mShop/youraccount/AmazonPointsView;)V

    .line 116
    return-void
.end method

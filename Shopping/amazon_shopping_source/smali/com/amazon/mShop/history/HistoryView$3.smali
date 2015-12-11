.class Lcom/amazon/mShop/history/HistoryView$3;
.super Ljava/lang/Object;
.source "HistoryView.java"

# interfaces
.implements Lcom/amazon/mShop/error/AmazonErrorBox$AmazonErrorBoxActionListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/history/HistoryView;->onError(Ljava/lang/Exception;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/history/HistoryView;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/history/HistoryView;)V
    .locals 0

    .prologue
    .line 276
    iput-object p1, p0, Lcom/amazon/mShop/history/HistoryView$3;->this$0:Lcom/amazon/mShop/history/HistoryView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onActionButtonClick(I)V
    .locals 2
    .param p1, "errorId"    # I

    .prologue
    .line 279
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/history/HistoryView$3$1;

    invoke-direct {v1, p0}, Lcom/amazon/mShop/history/HistoryView$3$1;-><init>(Lcom/amazon/mShop/history/HistoryView$3;)V

    invoke-interface {v0, v1}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;)V

    .line 287
    return-void
.end method

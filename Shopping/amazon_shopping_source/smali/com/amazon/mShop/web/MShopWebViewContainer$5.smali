.class Lcom/amazon/mShop/web/MShopWebViewContainer$5;
.super Ljava/lang/Object;
.source "MShopWebViewContainer.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/web/MShopWebViewContainer;->handlePageLoadNatively()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/web/MShopWebViewContainer;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/web/MShopWebViewContainer;)V
    .locals 0

    .prologue
    .line 1387
    iput-object p1, p0, Lcom/amazon/mShop/web/MShopWebViewContainer$5;->this$0:Lcom/amazon/mShop/web/MShopWebViewContainer;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 1

    .prologue
    .line 1390
    iget-object v0, p0, Lcom/amazon/mShop/web/MShopWebViewContainer$5;->this$0:Lcom/amazon/mShop/web/MShopWebViewContainer;

    invoke-virtual {v0}, Lcom/amazon/mShop/web/MShopWebViewContainer;->hideSpinner()V

    .line 1391
    return-void
.end method

.class Lcom/amazon/mShop/web/MShopWebViewContainer$BottomButton;
.super Lcom/amazon/mShop/ui/BottomToolBar$ToolBarItem;
.source "MShopWebViewContainer.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/web/MShopWebViewContainer;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "BottomButton"
.end annotation


# instance fields
.field private mOnTouchCallbackId:Ljava/lang/String;

.field final synthetic this$0:Lcom/amazon/mShop/web/MShopWebViewContainer;


# direct methods
.method public constructor <init>(Lcom/amazon/mShop/web/MShopWebViewContainer;ILjava/lang/String;Z)V
    .locals 0
    .param p2, "itemId"    # I
    .param p3, "itemName"    # Ljava/lang/String;
    .param p4, "isEnabled"    # Z

    .prologue
    .line 1249
    iput-object p1, p0, Lcom/amazon/mShop/web/MShopWebViewContainer$BottomButton;->this$0:Lcom/amazon/mShop/web/MShopWebViewContainer;

    .line 1250
    invoke-direct {p0, p2, p3, p4}, Lcom/amazon/mShop/ui/BottomToolBar$ToolBarItem;-><init>(ILjava/lang/String;Z)V

    .line 1251
    return-void
.end method


# virtual methods
.method public getOnTouchCallbackId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 1260
    iget-object v0, p0, Lcom/amazon/mShop/web/MShopWebViewContainer$BottomButton;->mOnTouchCallbackId:Ljava/lang/String;

    return-object v0
.end method

.method public setOnTouchCallbackId(Ljava/lang/String;)V
    .locals 0
    .param p1, "callbackId"    # Ljava/lang/String;

    .prologue
    .line 1256
    iput-object p1, p0, Lcom/amazon/mShop/web/MShopWebViewContainer$BottomButton;->mOnTouchCallbackId:Ljava/lang/String;

    .line 1257
    return-void
.end method

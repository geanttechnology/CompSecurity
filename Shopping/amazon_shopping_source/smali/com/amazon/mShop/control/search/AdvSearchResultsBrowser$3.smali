.class Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser$3;
.super Ljava/lang/Object;
.source "AdvSearchResultsBrowser.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;->receivedHyperText(Lcom/amazon/rio/j2me/client/services/mShop/HyperText;ILcom/amazon/rio/j2me/client/services/ServiceCall;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;

.field final synthetic val$value:Lcom/amazon/rio/j2me/client/services/mShop/HyperText;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;Lcom/amazon/rio/j2me/client/services/mShop/HyperText;)V
    .locals 0

    .prologue
    .line 511
    iput-object p1, p0, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser$3;->this$0:Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;

    iput-object p2, p0, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser$3;->val$value:Lcom/amazon/rio/j2me/client/services/mShop/HyperText;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 514
    iget-object v0, p0, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser$3;->this$0:Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;

    iget-object v1, p0, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser$3;->val$value:Lcom/amazon/rio/j2me/client/services/mShop/HyperText;

    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/HyperText;->getText()Ljava/lang/String;

    move-result-object v1

    # setter for: Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;->mCorrection:Ljava/lang/String;
    invoke-static {v0, v1}, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;->access$1502(Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;Ljava/lang/String;)Ljava/lang/String;

    .line 515
    return-void
.end method

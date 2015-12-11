.class Lcom/amazon/mShop/search/viewit/ViewItActivity$1;
.super Ljava/lang/Object;
.source "ViewItActivity.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/search/viewit/ViewItActivity;->clearSceenAndData()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/search/viewit/ViewItActivity;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/search/viewit/ViewItActivity;)V
    .locals 0

    .prologue
    .line 552
    iput-object p1, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity$1;->this$0:Lcom/amazon/mShop/search/viewit/ViewItActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 555
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity$1;->this$0:Lcom/amazon/mShop/search/viewit/ViewItActivity;

    invoke-virtual {v0}, Lcom/amazon/mShop/search/viewit/ViewItActivity;->getCameraBgHelper()Lcom/amazon/mShop/search/viewit/CameraBgHelper;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/search/viewit/CameraBgHelper;->drawScanningGraphic(Ljava/util/List;)V

    .line 556
    return-void
.end method

.class Lcom/amazon/mShop/search/viewit/ViewItActivity$8;
.super Ljava/lang/Object;
.source "ViewItActivity.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/search/viewit/ViewItActivity;->didReceiveInterestPoints(Ljava/util/ArrayList;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/search/viewit/ViewItActivity;

.field final synthetic val$points:Ljava/util/ArrayList;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/search/viewit/ViewItActivity;Ljava/util/ArrayList;)V
    .locals 0

    .prologue
    .line 1021
    iput-object p1, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity$8;->this$0:Lcom/amazon/mShop/search/viewit/ViewItActivity;

    iput-object p2, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity$8;->val$points:Ljava/util/ArrayList;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 5

    .prologue
    .line 1024
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity$8;->this$0:Lcom/amazon/mShop/search/viewit/ViewItActivity;

    # getter for: Lcom/amazon/mShop/search/viewit/ViewItActivity;->mGraphicsMap:Ljava/util/Map;
    invoke-static {v0}, Lcom/amazon/mShop/search/viewit/ViewItActivity;->access$900(Lcom/amazon/mShop/search/viewit/ViewItActivity;)Ljava/util/Map;

    move-result-object v0

    const/4 v1, 0x2

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    new-instance v2, Lcom/amazon/mShop/search/viewit/TrackingDotsGraphic;

    iget-object v3, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity$8;->this$0:Lcom/amazon/mShop/search/viewit/ViewItActivity;

    iget-object v4, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity$8;->val$points:Ljava/util/ArrayList;

    invoke-direct {v2, v3, v4}, Lcom/amazon/mShop/search/viewit/TrackingDotsGraphic;-><init>(Landroid/content/Context;Ljava/util/List;)V

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1025
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity$8;->this$0:Lcom/amazon/mShop/search/viewit/ViewItActivity;

    # invokes: Lcom/amazon/mShop/search/viewit/ViewItActivity;->updateCameraScreen()V
    invoke-static {v0}, Lcom/amazon/mShop/search/viewit/ViewItActivity;->access$1000(Lcom/amazon/mShop/search/viewit/ViewItActivity;)V

    .line 1026
    return-void
.end method

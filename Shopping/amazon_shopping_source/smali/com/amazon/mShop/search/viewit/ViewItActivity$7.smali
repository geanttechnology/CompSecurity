.class Lcom/amazon/mShop/search/viewit/ViewItActivity$7;
.super Ljava/lang/Object;
.source "ViewItActivity.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/search/viewit/ViewItActivity;->upateCheckBoxGraphic(Landroid/graphics/PointF;)V
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
    .line 979
    iput-object p1, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity$7;->this$0:Lcom/amazon/mShop/search/viewit/ViewItActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    const/4 v2, 0x1

    .line 982
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity$7;->this$0:Lcom/amazon/mShop/search/viewit/ViewItActivity;

    # getter for: Lcom/amazon/mShop/search/viewit/ViewItActivity;->mGraphicsMap:Ljava/util/Map;
    invoke-static {v0}, Lcom/amazon/mShop/search/viewit/ViewItActivity;->access$900(Lcom/amazon/mShop/search/viewit/ViewItActivity;)Ljava/util/Map;

    move-result-object v0

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 983
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity$7;->this$0:Lcom/amazon/mShop/search/viewit/ViewItActivity;

    # getter for: Lcom/amazon/mShop/search/viewit/ViewItActivity;->mGraphicsMap:Ljava/util/Map;
    invoke-static {v0}, Lcom/amazon/mShop/search/viewit/ViewItActivity;->access$900(Lcom/amazon/mShop/search/viewit/ViewItActivity;)Ljava/util/Map;

    move-result-object v0

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    new-instance v2, Lcom/amazon/mShop/search/viewit/NullGraphic;

    invoke-direct {v2}, Lcom/amazon/mShop/search/viewit/NullGraphic;-><init>()V

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 985
    :cond_0
    return-void
.end method

.class Lcom/amazon/mShop/recommendations/RecommendationsAdapter$1$1;
.super Ljava/lang/Object;
.source "RecommendationsAdapter.java"

# interfaces
.implements Landroid/widget/AdapterView$OnItemClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/recommendations/RecommendationsAdapter$1;->onClick(Landroid/view/View;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/amazon/mShop/recommendations/RecommendationsAdapter$1;

.field final synthetic val$view:Landroid/view/View;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/recommendations/RecommendationsAdapter$1;Landroid/view/View;)V
    .locals 0

    .prologue
    .line 79
    iput-object p1, p0, Lcom/amazon/mShop/recommendations/RecommendationsAdapter$1$1;->this$1:Lcom/amazon/mShop/recommendations/RecommendationsAdapter$1;

    iput-object p2, p0, Lcom/amazon/mShop/recommendations/RecommendationsAdapter$1$1;->val$view:Landroid/view/View;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onItemClick(Landroid/widget/AdapterView;Landroid/view/View;IJ)V
    .locals 4
    .param p2, "itemView"    # Landroid/view/View;
    .param p3, "position"    # I
    .param p4, "viewId"    # J
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/widget/AdapterView",
            "<*>;",
            "Landroid/view/View;",
            "IJ)V"
        }
    .end annotation

    .prologue
    .local p1, "parentView":Landroid/widget/AdapterView;, "Landroid/widget/AdapterView<*>;"
    const/4 v3, 0x1

    .line 82
    iget-object v0, p0, Lcom/amazon/mShop/recommendations/RecommendationsAdapter$1$1;->this$1:Lcom/amazon/mShop/recommendations/RecommendationsAdapter$1;

    iget-object v0, v0, Lcom/amazon/mShop/recommendations/RecommendationsAdapter$1;->this$0:Lcom/amazon/mShop/recommendations/RecommendationsAdapter;

    # getter for: Lcom/amazon/mShop/recommendations/RecommendationsAdapter;->mFixThisRecsDialog:Lcom/amazon/mShop/AmazonAlertDialog;
    invoke-static {v0}, Lcom/amazon/mShop/recommendations/RecommendationsAdapter;->access$000(Lcom/amazon/mShop/recommendations/RecommendationsAdapter;)Lcom/amazon/mShop/AmazonAlertDialog;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/AmazonAlertDialog;->dismiss()V

    .line 83
    if-nez p3, :cond_1

    .line 85
    const-string/jumbo v0, "recs_o"

    invoke-static {v0}, Lcom/amazon/mShop/net/RefMarkerObserver;->logRefMarker(Ljava/lang/String;)V

    .line 86
    iget-object v0, p0, Lcom/amazon/mShop/recommendations/RecommendationsAdapter$1$1;->this$1:Lcom/amazon/mShop/recommendations/RecommendationsAdapter$1;

    iget-object v0, v0, Lcom/amazon/mShop/recommendations/RecommendationsAdapter$1;->this$0:Lcom/amazon/mShop/recommendations/RecommendationsAdapter;

    iget-object v1, p0, Lcom/amazon/mShop/recommendations/RecommendationsAdapter$1$1;->this$1:Lcom/amazon/mShop/recommendations/RecommendationsAdapter$1;

    iget-object v1, v1, Lcom/amazon/mShop/recommendations/RecommendationsAdapter$1;->this$0:Lcom/amazon/mShop/recommendations/RecommendationsAdapter;

    iget-object v2, p0, Lcom/amazon/mShop/recommendations/RecommendationsAdapter$1$1;->val$view:Landroid/view/View;

    invoke-virtual {v2}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v2

    const/4 v3, 0x0

    invoke-virtual {v0, v1, v2, v3}, Lcom/amazon/mShop/recommendations/RecommendationsAdapter;->removeItemAndRefreshUI(Lcom/amazon/mShop/recommendations/RecommendationsAdapter;II)V

    .line 92
    :cond_0
    :goto_0
    return-void

    .line 87
    :cond_1
    if-ne p3, v3, :cond_0

    .line 89
    const-string/jumbo v0, "recs_ni"

    invoke-static {v0}, Lcom/amazon/mShop/net/RefMarkerObserver;->logRefMarker(Ljava/lang/String;)V

    .line 90
    iget-object v0, p0, Lcom/amazon/mShop/recommendations/RecommendationsAdapter$1$1;->this$1:Lcom/amazon/mShop/recommendations/RecommendationsAdapter$1;

    iget-object v0, v0, Lcom/amazon/mShop/recommendations/RecommendationsAdapter$1;->this$0:Lcom/amazon/mShop/recommendations/RecommendationsAdapter;

    iget-object v1, p0, Lcom/amazon/mShop/recommendations/RecommendationsAdapter$1$1;->this$1:Lcom/amazon/mShop/recommendations/RecommendationsAdapter$1;

    iget-object v1, v1, Lcom/amazon/mShop/recommendations/RecommendationsAdapter$1;->this$0:Lcom/amazon/mShop/recommendations/RecommendationsAdapter;

    iget-object v2, p0, Lcom/amazon/mShop/recommendations/RecommendationsAdapter$1$1;->val$view:Landroid/view/View;

    invoke-virtual {v2}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v2

    invoke-virtual {v0, v1, v2, v3}, Lcom/amazon/mShop/recommendations/RecommendationsAdapter;->removeItemAndRefreshUI(Lcom/amazon/mShop/recommendations/RecommendationsAdapter;II)V

    goto :goto_0
.end method

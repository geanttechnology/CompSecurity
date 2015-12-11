.class Lcom/amazon/mShop/recommendations/RecommendationsAdapter$2;
.super Ljava/lang/Object;
.source "RecommendationsAdapter.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/recommendations/RecommendationsAdapter;->onItemClick(Landroid/widget/AdapterView;Landroid/view/View;IJ)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/recommendations/RecommendationsAdapter;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/recommendations/RecommendationsAdapter;)V
    .locals 0

    .prologue
    .line 186
    iput-object p1, p0, Lcom/amazon/mShop/recommendations/RecommendationsAdapter$2;->this$0:Lcom/amazon/mShop/recommendations/RecommendationsAdapter;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 189
    iget-object v1, p0, Lcom/amazon/mShop/recommendations/RecommendationsAdapter$2;->this$0:Lcom/amazon/mShop/recommendations/RecommendationsAdapter;

    # getter for: Lcom/amazon/mShop/recommendations/RecommendationsAdapter;->mActivity:Lcom/amazon/mShop/AmazonActivity;
    invoke-static {v1}, Lcom/amazon/mShop/recommendations/RecommendationsAdapter;->access$100(Lcom/amazon/mShop/recommendations/RecommendationsAdapter;)Lcom/amazon/mShop/AmazonActivity;

    move-result-object v1

    check-cast v1, Lcom/amazon/mShop/recommendations/RecommendationsActivity;

    invoke-virtual {v1}, Lcom/amazon/mShop/recommendations/RecommendationsActivity;->constructUserUniqueInfo()Ljava/lang/String;

    move-result-object v0

    .line 190
    .local v0, "userKey":Ljava/lang/String;
    invoke-static {}, Lcom/amazon/mShop/control/recommendations/RecommendationsController;->getInstance()Lcom/amazon/mShop/control/recommendations/RecommendationsController;

    move-result-object v1

    invoke-virtual {v1, v0}, Lcom/amazon/mShop/control/recommendations/RecommendationsController;->sendRecsRatingsForUser(Ljava/lang/String;)V

    .line 191
    return-void
.end method

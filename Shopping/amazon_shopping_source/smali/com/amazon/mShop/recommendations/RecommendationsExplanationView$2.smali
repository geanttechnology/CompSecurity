.class Lcom/amazon/mShop/recommendations/RecommendationsExplanationView$2;
.super Ljava/lang/Object;
.source "RecommendationsExplanationView.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/recommendations/RecommendationsExplanationView;-><init>(Lcom/amazon/mShop/AmazonActivity;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/recommendations/RecommendationsExplanationView;

.field final synthetic val$activity:Lcom/amazon/mShop/AmazonActivity;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/recommendations/RecommendationsExplanationView;Lcom/amazon/mShop/AmazonActivity;)V
    .locals 0

    .prologue
    .line 36
    iput-object p1, p0, Lcom/amazon/mShop/recommendations/RecommendationsExplanationView$2;->this$0:Lcom/amazon/mShop/recommendations/RecommendationsExplanationView;

    iput-object p2, p0, Lcom/amazon/mShop/recommendations/RecommendationsExplanationView$2;->val$activity:Lcom/amazon/mShop/AmazonActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 4
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 39
    iget-object v0, p0, Lcom/amazon/mShop/recommendations/RecommendationsExplanationView$2;->val$activity:Lcom/amazon/mShop/AmazonActivity;

    iget-object v1, p0, Lcom/amazon/mShop/recommendations/RecommendationsExplanationView$2;->this$0:Lcom/amazon/mShop/recommendations/RecommendationsExplanationView;

    const/4 v2, 0x0

    const/4 v3, 0x1

    invoke-virtual {v0, v1, v2, v3}, Lcom/amazon/mShop/AmazonActivity;->authenticateUser(Lcom/amazon/mShop/model/auth/UserSubscriber$Callback;Lcom/amazon/mShop/model/auth/UserSubscriber$Callback;Z)V

    .line 40
    return-void
.end method

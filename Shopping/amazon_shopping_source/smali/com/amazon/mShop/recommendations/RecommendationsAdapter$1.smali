.class Lcom/amazon/mShop/recommendations/RecommendationsAdapter$1;
.super Ljava/lang/Object;
.source "RecommendationsAdapter.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/recommendations/RecommendationsAdapter;
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
    .line 67
    iput-object p1, p0, Lcom/amazon/mShop/recommendations/RecommendationsAdapter$1;->this$0:Lcom/amazon/mShop/recommendations/RecommendationsAdapter;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 7
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 72
    iget-object v0, p0, Lcom/amazon/mShop/recommendations/RecommendationsAdapter$1;->this$0:Lcom/amazon/mShop/recommendations/RecommendationsAdapter;

    # getter for: Lcom/amazon/mShop/recommendations/RecommendationsAdapter;->mFixThisRecsDialog:Lcom/amazon/mShop/AmazonAlertDialog;
    invoke-static {v0}, Lcom/amazon/mShop/recommendations/RecommendationsAdapter;->access$000(Lcom/amazon/mShop/recommendations/RecommendationsAdapter;)Lcom/amazon/mShop/AmazonAlertDialog;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/amazon/mShop/recommendations/RecommendationsAdapter$1;->this$0:Lcom/amazon/mShop/recommendations/RecommendationsAdapter;

    # getter for: Lcom/amazon/mShop/recommendations/RecommendationsAdapter;->mFixThisRecsDialog:Lcom/amazon/mShop/AmazonAlertDialog;
    invoke-static {v0}, Lcom/amazon/mShop/recommendations/RecommendationsAdapter;->access$000(Lcom/amazon/mShop/recommendations/RecommendationsAdapter;)Lcom/amazon/mShop/AmazonAlertDialog;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/AmazonAlertDialog;->isShowing()Z

    move-result v0

    if-nez v0, :cond_1

    .line 73
    :cond_0
    new-instance v6, Lcom/amazon/mShop/AmazonAlertDialog$Builder;

    iget-object v0, p0, Lcom/amazon/mShop/recommendations/RecommendationsAdapter$1;->this$0:Lcom/amazon/mShop/recommendations/RecommendationsAdapter;

    # getter for: Lcom/amazon/mShop/recommendations/RecommendationsAdapter;->mActivity:Lcom/amazon/mShop/AmazonActivity;
    invoke-static {v0}, Lcom/amazon/mShop/recommendations/RecommendationsAdapter;->access$100(Lcom/amazon/mShop/recommendations/RecommendationsAdapter;)Lcom/amazon/mShop/AmazonActivity;

    move-result-object v0

    invoke-direct {v6, v0}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 74
    .local v6, "builder":Lcom/amazon/mShop/AmazonAlertDialog$Builder;
    iget-object v0, p0, Lcom/amazon/mShop/recommendations/RecommendationsAdapter$1;->this$0:Lcom/amazon/mShop/recommendations/RecommendationsAdapter;

    invoke-virtual {v6}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->create()Lcom/amazon/mShop/AmazonAlertDialog;

    move-result-object v1

    # setter for: Lcom/amazon/mShop/recommendations/RecommendationsAdapter;->mFixThisRecsDialog:Lcom/amazon/mShop/AmazonAlertDialog;
    invoke-static {v0, v1}, Lcom/amazon/mShop/recommendations/RecommendationsAdapter;->access$002(Lcom/amazon/mShop/recommendations/RecommendationsAdapter;Lcom/amazon/mShop/AmazonAlertDialog;)Lcom/amazon/mShop/AmazonAlertDialog;

    .line 75
    new-instance v3, Landroid/widget/ArrayAdapter;

    iget-object v0, p0, Lcom/amazon/mShop/recommendations/RecommendationsAdapter$1;->this$0:Lcom/amazon/mShop/recommendations/RecommendationsAdapter;

    # getter for: Lcom/amazon/mShop/recommendations/RecommendationsAdapter;->mActivity:Lcom/amazon/mShop/AmazonActivity;
    invoke-static {v0}, Lcom/amazon/mShop/recommendations/RecommendationsAdapter;->access$100(Lcom/amazon/mShop/recommendations/RecommendationsAdapter;)Lcom/amazon/mShop/AmazonActivity;

    move-result-object v0

    sget v1, Lcom/amazon/mShop/android/lib/R$layout;->select_dialog_item:I

    invoke-direct {v3, v0, v1}, Landroid/widget/ArrayAdapter;-><init>(Landroid/content/Context;I)V

    .line 76
    .local v3, "adapter":Landroid/widget/ArrayAdapter;, "Landroid/widget/ArrayAdapter<Ljava/lang/String;>;"
    iget-object v0, p0, Lcom/amazon/mShop/recommendations/RecommendationsAdapter$1;->this$0:Lcom/amazon/mShop/recommendations/RecommendationsAdapter;

    # getter for: Lcom/amazon/mShop/recommendations/RecommendationsAdapter;->mActivity:Lcom/amazon/mShop/AmazonActivity;
    invoke-static {v0}, Lcom/amazon/mShop/recommendations/RecommendationsAdapter;->access$100(Lcom/amazon/mShop/recommendations/RecommendationsAdapter;)Lcom/amazon/mShop/AmazonActivity;

    move-result-object v0

    sget v1, Lcom/amazon/mShop/android/lib/R$string;->recommendations_item_ownit:I

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/AmazonActivity;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v3, v0}, Landroid/widget/ArrayAdapter;->add(Ljava/lang/Object;)V

    .line 77
    iget-object v0, p0, Lcom/amazon/mShop/recommendations/RecommendationsAdapter$1;->this$0:Lcom/amazon/mShop/recommendations/RecommendationsAdapter;

    # getter for: Lcom/amazon/mShop/recommendations/RecommendationsAdapter;->mActivity:Lcom/amazon/mShop/AmazonActivity;
    invoke-static {v0}, Lcom/amazon/mShop/recommendations/RecommendationsAdapter;->access$100(Lcom/amazon/mShop/recommendations/RecommendationsAdapter;)Lcom/amazon/mShop/AmazonActivity;

    move-result-object v0

    sget v1, Lcom/amazon/mShop/android/lib/R$string;->recommendations_item_notinterest:I

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/AmazonActivity;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v3, v0}, Landroid/widget/ArrayAdapter;->add(Ljava/lang/Object;)V

    .line 79
    iget-object v0, p0, Lcom/amazon/mShop/recommendations/RecommendationsAdapter$1;->this$0:Lcom/amazon/mShop/recommendations/RecommendationsAdapter;

    # getter for: Lcom/amazon/mShop/recommendations/RecommendationsAdapter;->mActivity:Lcom/amazon/mShop/AmazonActivity;
    invoke-static {v0}, Lcom/amazon/mShop/recommendations/RecommendationsAdapter;->access$100(Lcom/amazon/mShop/recommendations/RecommendationsAdapter;)Lcom/amazon/mShop/AmazonActivity;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/mShop/recommendations/RecommendationsAdapter$1;->this$0:Lcom/amazon/mShop/recommendations/RecommendationsAdapter;

    # getter for: Lcom/amazon/mShop/recommendations/RecommendationsAdapter;->mFixThisRecsDialog:Lcom/amazon/mShop/AmazonAlertDialog;
    invoke-static {v1}, Lcom/amazon/mShop/recommendations/RecommendationsAdapter;->access$000(Lcom/amazon/mShop/recommendations/RecommendationsAdapter;)Lcom/amazon/mShop/AmazonAlertDialog;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/mShop/recommendations/RecommendationsAdapter$1;->this$0:Lcom/amazon/mShop/recommendations/RecommendationsAdapter;

    # getter for: Lcom/amazon/mShop/recommendations/RecommendationsAdapter;->mActivity:Lcom/amazon/mShop/AmazonActivity;
    invoke-static {v2}, Lcom/amazon/mShop/recommendations/RecommendationsAdapter;->access$100(Lcom/amazon/mShop/recommendations/RecommendationsAdapter;)Lcom/amazon/mShop/AmazonActivity;

    move-result-object v2

    sget v4, Lcom/amazon/mShop/android/lib/R$string;->recommendations_fix_this:I

    invoke-virtual {v2, v4}, Lcom/amazon/mShop/AmazonActivity;->getString(I)Ljava/lang/String;

    move-result-object v2

    new-instance v4, Lcom/amazon/mShop/recommendations/RecommendationsAdapter$1$1;

    invoke-direct {v4, p0, p1}, Lcom/amazon/mShop/recommendations/RecommendationsAdapter$1$1;-><init>(Lcom/amazon/mShop/recommendations/RecommendationsAdapter$1;Landroid/view/View;)V

    const/4 v5, -0x1

    invoke-static/range {v0 .. v5}, Lcom/amazon/mShop/AmazonAlertDialog;->customizeAlertDialog(Landroid/content/Context;Lcom/amazon/mShop/AmazonAlertDialog;Ljava/lang/String;Landroid/widget/ListAdapter;Landroid/widget/AdapterView$OnItemClickListener;I)V

    .line 95
    iget-object v0, p0, Lcom/amazon/mShop/recommendations/RecommendationsAdapter$1;->this$0:Lcom/amazon/mShop/recommendations/RecommendationsAdapter;

    # getter for: Lcom/amazon/mShop/recommendations/RecommendationsAdapter;->mFixThisRecsDialog:Lcom/amazon/mShop/AmazonAlertDialog;
    invoke-static {v0}, Lcom/amazon/mShop/recommendations/RecommendationsAdapter;->access$000(Lcom/amazon/mShop/recommendations/RecommendationsAdapter;)Lcom/amazon/mShop/AmazonAlertDialog;

    move-result-object v0

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/AmazonAlertDialog;->setCanceledOnTouchOutside(Z)V

    .line 96
    iget-object v0, p0, Lcom/amazon/mShop/recommendations/RecommendationsAdapter$1;->this$0:Lcom/amazon/mShop/recommendations/RecommendationsAdapter;

    # getter for: Lcom/amazon/mShop/recommendations/RecommendationsAdapter;->mFixThisRecsDialog:Lcom/amazon/mShop/AmazonAlertDialog;
    invoke-static {v0}, Lcom/amazon/mShop/recommendations/RecommendationsAdapter;->access$000(Lcom/amazon/mShop/recommendations/RecommendationsAdapter;)Lcom/amazon/mShop/AmazonAlertDialog;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/AmazonAlertDialog;->show()V

    .line 98
    .end local v3    # "adapter":Landroid/widget/ArrayAdapter;, "Landroid/widget/ArrayAdapter<Ljava/lang/String;>;"
    .end local v6    # "builder":Lcom/amazon/mShop/AmazonAlertDialog$Builder;
    :cond_1
    return-void
.end method

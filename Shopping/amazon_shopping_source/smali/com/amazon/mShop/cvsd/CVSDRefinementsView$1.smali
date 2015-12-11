.class Lcom/amazon/mShop/cvsd/CVSDRefinementsView$1;
.super Ljava/lang/Object;
.source "CVSDRefinementsView.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/cvsd/CVSDRefinementsView;-><init>(Lcom/amazon/mShop/AmazonActivity;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/cvsd/CVSDRefinementsView;

.field final synthetic val$selectedIndex:I


# direct methods
.method constructor <init>(Lcom/amazon/mShop/cvsd/CVSDRefinementsView;I)V
    .locals 0

    .prologue
    .line 60
    iput-object p1, p0, Lcom/amazon/mShop/cvsd/CVSDRefinementsView$1;->this$0:Lcom/amazon/mShop/cvsd/CVSDRefinementsView;

    iput p2, p0, Lcom/amazon/mShop/cvsd/CVSDRefinementsView$1;->val$selectedIndex:I

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 4
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 65
    new-instance v1, Landroid/content/Intent;

    invoke-direct {v1}, Landroid/content/Intent;-><init>()V

    .line 67
    .local v1, "intent":Landroid/content/Intent;
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 68
    .local v0, "bundle":Landroid/os/Bundle;
    const-string/jumbo v2, "com.amazon.mShop.cvsd.CVSDRefinementsView.KEY_REFINEMENTS_SELECTED_INDEX"

    iget v3, p0, Lcom/amazon/mShop/cvsd/CVSDRefinementsView$1;->val$selectedIndex:I

    invoke-virtual {v0, v2, v3}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 70
    invoke-virtual {v1, v0}, Landroid/content/Intent;->putExtras(Landroid/os/Bundle;)Landroid/content/Intent;

    .line 71
    iget-object v2, p0, Lcom/amazon/mShop/cvsd/CVSDRefinementsView$1;->this$0:Lcom/amazon/mShop/cvsd/CVSDRefinementsView;

    iget-object v2, v2, Lcom/amazon/mShop/cvsd/CVSDRefinementsView;->amazonActivity:Lcom/amazon/mShop/AmazonActivity;

    const/4 v3, -0x1

    invoke-virtual {v2, v3, v1}, Lcom/amazon/mShop/AmazonActivity;->setResult(ILandroid/content/Intent;)V

    .line 72
    iget-object v2, p0, Lcom/amazon/mShop/cvsd/CVSDRefinementsView$1;->this$0:Lcom/amazon/mShop/cvsd/CVSDRefinementsView;

    iget-object v2, v2, Lcom/amazon/mShop/cvsd/CVSDRefinementsView;->amazonActivity:Lcom/amazon/mShop/AmazonActivity;

    invoke-virtual {v2}, Lcom/amazon/mShop/AmazonActivity;->finish()V

    .line 74
    return-void
.end method

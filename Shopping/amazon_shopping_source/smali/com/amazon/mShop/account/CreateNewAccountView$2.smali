.class Lcom/amazon/mShop/account/CreateNewAccountView$2;
.super Ljava/lang/Object;
.source "CreateNewAccountView.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/account/CreateNewAccountView;-><init>(Lcom/amazon/mShop/account/LoginActivity;Ljava/lang/String;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/account/CreateNewAccountView;

.field final synthetic val$loginActivity:Lcom/amazon/mShop/account/LoginActivity;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/account/CreateNewAccountView;Lcom/amazon/mShop/account/LoginActivity;)V
    .locals 0

    .prologue
    .line 124
    iput-object p1, p0, Lcom/amazon/mShop/account/CreateNewAccountView$2;->this$0:Lcom/amazon/mShop/account/CreateNewAccountView;

    iput-object p2, p0, Lcom/amazon/mShop/account/CreateNewAccountView$2;->val$loginActivity:Lcom/amazon/mShop/account/LoginActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 5
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 128
    iget-object v2, p0, Lcom/amazon/mShop/account/CreateNewAccountView$2;->this$0:Lcom/amazon/mShop/account/CreateNewAccountView;

    invoke-virtual {v2}, Lcom/amazon/mShop/account/CreateNewAccountView;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    sget v3, Lcom/amazon/mShop/android/lib/R$string;->cna_legal_link_url:I

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    .line 129
    .local v1, "legalUrl":Ljava/lang/String;
    iget-object v2, p0, Lcom/amazon/mShop/account/CreateNewAccountView$2;->this$0:Lcom/amazon/mShop/account/CreateNewAccountView;

    invoke-virtual {v2}, Lcom/amazon/mShop/account/CreateNewAccountView;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    sget v3, Lcom/amazon/mShop/android/lib/R$string;->cna_legal_text:I

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 130
    .local v0, "legalTitle":Ljava/lang/String;
    iget-object v2, p0, Lcom/amazon/mShop/account/CreateNewAccountView$2;->val$loginActivity:Lcom/amazon/mShop/account/LoginActivity;

    new-instance v3, Lcom/amazon/mShop/AmazonBrandedWebView;

    iget-object v4, p0, Lcom/amazon/mShop/account/CreateNewAccountView$2;->val$loginActivity:Lcom/amazon/mShop/account/LoginActivity;

    invoke-direct {v3, v4, v1, v0}, Lcom/amazon/mShop/AmazonBrandedWebView;-><init>(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v2, v3}, Lcom/amazon/mShop/account/LoginActivity;->pushView(Landroid/view/View;)V

    .line 132
    return-void
.end method

.class Lcom/amazon/mShop/search/SearchActivity$1;
.super Ljava/lang/Object;
.source "SearchActivity.java"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/search/SearchActivity;->onActivityResult(IILandroid/content/Intent;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/search/SearchActivity;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/search/SearchActivity;)V
    .locals 0

    .prologue
    .line 720
    iput-object p1, p0, Lcom/amazon/mShop/search/SearchActivity$1;->this$0:Lcom/amazon/mShop/search/SearchActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 1
    .param p1, "dialog"    # Landroid/content/DialogInterface;
    .param p2, "which"    # I

    .prologue
    .line 723
    iget-object v0, p0, Lcom/amazon/mShop/search/SearchActivity$1;->this$0:Lcom/amazon/mShop/search/SearchActivity;

    invoke-virtual {v0}, Lcom/amazon/mShop/search/SearchActivity;->getCurrentView()Landroid/view/View;

    move-result-object v0

    if-nez v0, :cond_0

    .line 724
    iget-object v0, p0, Lcom/amazon/mShop/search/SearchActivity$1;->this$0:Lcom/amazon/mShop/search/SearchActivity;

    invoke-virtual {v0}, Lcom/amazon/mShop/search/SearchActivity;->finish()V

    .line 726
    :cond_0
    return-void
.end method

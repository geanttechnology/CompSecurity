.class Lcom/amazon/mShop/search/SearchActivity$3$1;
.super Ljava/lang/Object;
.source "SearchActivity.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/search/SearchActivity$3;->onClick(Landroid/view/View;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/amazon/mShop/search/SearchActivity$3;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/search/SearchActivity$3;)V
    .locals 0

    .prologue
    .line 894
    iput-object p1, p0, Lcom/amazon/mShop/search/SearchActivity$3$1;->this$1:Lcom/amazon/mShop/search/SearchActivity$3;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 897
    iget-object v0, p0, Lcom/amazon/mShop/search/SearchActivity$3$1;->this$1:Lcom/amazon/mShop/search/SearchActivity$3;

    iget-object v0, v0, Lcom/amazon/mShop/search/SearchActivity$3;->this$0:Lcom/amazon/mShop/search/SearchActivity;

    iget-object v1, p0, Lcom/amazon/mShop/search/SearchActivity$3$1;->this$1:Lcom/amazon/mShop/search/SearchActivity$3;

    iget-object v1, v1, Lcom/amazon/mShop/search/SearchActivity$3;->this$0:Lcom/amazon/mShop/search/SearchActivity;

    invoke-virtual {v1}, Lcom/amazon/mShop/search/SearchActivity;->getIntent()Landroid/content/Intent;

    move-result-object v1

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Lcom/amazon/mShop/search/SearchActivity;->setSearchEntryViewAsRoot(Landroid/content/Intent;Z)V

    .line 898
    return-void
.end method

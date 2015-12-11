.class Lcom/amazon/mShop/search/SearchActivity$3;
.super Ljava/lang/Object;
.source "SearchActivity.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/search/SearchActivity;->updateSearchButton(Z)V
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
    .line 891
    iput-object p1, p0, Lcom/amazon/mShop/search/SearchActivity$3;->this$0:Lcom/amazon/mShop/search/SearchActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 894
    iget-object v0, p0, Lcom/amazon/mShop/search/SearchActivity$3;->this$0:Lcom/amazon/mShop/search/SearchActivity;

    const/4 v1, 0x1

    new-instance v2, Lcom/amazon/mShop/search/SearchActivity$3$1;

    invoke-direct {v2, p0}, Lcom/amazon/mShop/search/SearchActivity$3$1;-><init>(Lcom/amazon/mShop/search/SearchActivity$3;)V

    invoke-static {v0, v1, v2}, Lcom/amazon/mShop/gno/GNODrawerHelper;->closeDrawerAndExecute(Lcom/amazon/mShop/AmazonActivity;ZLjava/lang/Runnable;)V

    .line 900
    return-void
.end method

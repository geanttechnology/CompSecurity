.class Lcom/amazon/mShop/search/SearchResultsContainer$3;
.super Ljava/lang/Object;
.source "SearchResultsContainer.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/search/SearchResultsContainer;->updateSearchBar(Ljava/lang/String;Ljava/lang/String;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/search/SearchResultsContainer;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/search/SearchResultsContainer;)V
    .locals 0

    .prologue
    .line 155
    iput-object p1, p0, Lcom/amazon/mShop/search/SearchResultsContainer$3;->this$0:Lcom/amazon/mShop/search/SearchResultsContainer;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 1
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 158
    iget-object v0, p0, Lcom/amazon/mShop/search/SearchResultsContainer$3;->this$0:Lcom/amazon/mShop/search/SearchResultsContainer;

    # invokes: Lcom/amazon/mShop/search/SearchResultsContainer;->goToSearchEntry()V
    invoke-static {v0}, Lcom/amazon/mShop/search/SearchResultsContainer;->access$100(Lcom/amazon/mShop/search/SearchResultsContainer;)V

    .line 159
    return-void
.end method

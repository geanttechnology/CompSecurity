.class Lcom/amazon/mShop/search/SearchResultsContainer$2;
.super Ljava/lang/Object;
.source "SearchResultsContainer.java"

# interfaces
.implements Landroid/view/View$OnKeyListener;


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
    .line 136
    iput-object p1, p0, Lcom/amazon/mShop/search/SearchResultsContainer$2;->this$0:Lcom/amazon/mShop/search/SearchResultsContainer;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onKey(Landroid/view/View;ILandroid/view/KeyEvent;)Z
    .locals 2
    .param p1, "v"    # Landroid/view/View;
    .param p2, "keyCode"    # I
    .param p3, "event"    # Landroid/view/KeyEvent;

    .prologue
    const/4 v0, 0x1

    .line 139
    const/16 v1, 0x42

    if-eq v1, p2, :cond_0

    const/16 v1, 0x17

    if-ne v1, p2, :cond_1

    .line 140
    :cond_0
    invoke-virtual {p3}, Landroid/view/KeyEvent;->getAction()I

    move-result v1

    if-ne v0, v1, :cond_1

    .line 141
    iget-object v1, p0, Lcom/amazon/mShop/search/SearchResultsContainer$2;->this$0:Lcom/amazon/mShop/search/SearchResultsContainer;

    # invokes: Lcom/amazon/mShop/search/SearchResultsContainer;->goToSearchEntry()V
    invoke-static {v1}, Lcom/amazon/mShop/search/SearchResultsContainer;->access$100(Lcom/amazon/mShop/search/SearchResultsContainer;)V

    .line 145
    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

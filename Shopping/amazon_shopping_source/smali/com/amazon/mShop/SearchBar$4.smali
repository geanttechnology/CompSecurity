.class Lcom/amazon/mShop/SearchBar$4;
.super Ljava/lang/Object;
.source "SearchBar.java"

# interfaces
.implements Landroid/view/View$OnTouchListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/SearchBar;->initSearchBar()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/SearchBar;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/SearchBar;)V
    .locals 0

    .prologue
    .line 178
    iput-object p1, p0, Lcom/amazon/mShop/SearchBar$4;->this$0:Lcom/amazon/mShop/SearchBar;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onTouch(Landroid/view/View;Landroid/view/MotionEvent;)Z
    .locals 3
    .param p1, "v"    # Landroid/view/View;
    .param p2, "event"    # Landroid/view/MotionEvent;

    .prologue
    const/4 v2, 0x1

    .line 181
    invoke-virtual {p2}, Landroid/view/MotionEvent;->getAction()I

    move-result v0

    if-ne v0, v2, :cond_0

    .line 182
    iget-object v0, p0, Lcom/amazon/mShop/SearchBar$4;->this$0:Lcom/amazon/mShop/SearchBar;

    const/4 v1, 0x0

    invoke-virtual {v0, v1, v2}, Lcom/amazon/mShop/SearchBar;->goToSearchEntry(Ljava/lang/String;Z)V

    .line 185
    iget-object v0, p0, Lcom/amazon/mShop/SearchBar$4;->this$0:Lcom/amazon/mShop/SearchBar;

    invoke-virtual {v0}, Lcom/amazon/mShop/SearchBar;->logRefMarker()V

    .line 188
    iget-object v0, p0, Lcom/amazon/mShop/SearchBar$4;->this$0:Lcom/amazon/mShop/SearchBar;

    # getter for: Lcom/amazon/mShop/SearchBar;->mSearchBarPlate:Landroid/view/View;
    invoke-static {v0}, Lcom/amazon/mShop/SearchBar;->access$300(Lcom/amazon/mShop/SearchBar;)Landroid/view/View;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->setPressed(Z)V

    .line 191
    iget-object v0, p0, Lcom/amazon/mShop/SearchBar$4;->this$0:Lcom/amazon/mShop/SearchBar;

    # setter for: Lcom/amazon/mShop/SearchBar;->mIsTapped:Z
    invoke-static {v0, v2}, Lcom/amazon/mShop/SearchBar;->access$002(Lcom/amazon/mShop/SearchBar;Z)Z

    .line 200
    :goto_0
    return v2

    .line 196
    :cond_0
    iget-object v0, p0, Lcom/amazon/mShop/SearchBar$4;->this$0:Lcom/amazon/mShop/SearchBar;

    # getter for: Lcom/amazon/mShop/SearchBar;->mSearchBarPlate:Landroid/view/View;
    invoke-static {v0}, Lcom/amazon/mShop/SearchBar;->access$300(Lcom/amazon/mShop/SearchBar;)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0, v2}, Landroid/view/View;->setPressed(Z)V

    goto :goto_0
.end method

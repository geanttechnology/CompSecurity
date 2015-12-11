.class Lcom/amazon/mShop/SearchBar$3;
.super Ljava/lang/Object;
.source "SearchBar.java"

# interfaces
.implements Landroid/view/View$OnKeyListener;


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
    .line 136
    iput-object p1, p0, Lcom/amazon/mShop/SearchBar$3;->this$0:Lcom/amazon/mShop/SearchBar;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onKey(Landroid/view/View;ILandroid/view/KeyEvent;)Z
    .locals 5
    .param p1, "v"    # Landroid/view/View;
    .param p2, "keyCode"    # I
    .param p3, "event"    # Landroid/view/KeyEvent;

    .prologue
    const/16 v4, 0x42

    const/4 v1, 0x0

    const/4 v2, 0x1

    .line 139
    if-eq v4, p2, :cond_0

    const/16 v3, 0x17

    if-ne v3, p2, :cond_1

    .line 140
    :cond_0
    invoke-virtual {p3}, Landroid/view/KeyEvent;->getAction()I

    move-result v3

    if-ne v2, v3, :cond_3

    .line 141
    iget-object v3, p0, Lcom/amazon/mShop/SearchBar$3;->this$0:Lcom/amazon/mShop/SearchBar;

    # getter for: Lcom/amazon/mShop/SearchBar;->mSearchInput:Landroid/widget/EditText;
    invoke-static {v3}, Lcom/amazon/mShop/SearchBar;->access$200(Lcom/amazon/mShop/SearchBar;)Landroid/widget/EditText;

    move-result-object v3

    invoke-virtual {v3}, Landroid/widget/EditText;->getEditableText()Landroid/text/Editable;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    .line 142
    .local v0, "searchText":Ljava/lang/String;
    invoke-static {v0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_2

    if-ne v4, p2, :cond_2

    .line 143
    iget-object v3, p0, Lcom/amazon/mShop/SearchBar$3;->this$0:Lcom/amazon/mShop/SearchBar;

    invoke-virtual {v3}, Lcom/amazon/mShop/SearchBar;->startSearch()V

    .line 149
    :goto_0
    iget-object v3, p0, Lcom/amazon/mShop/SearchBar$3;->this$0:Lcom/amazon/mShop/SearchBar;

    invoke-virtual {v3}, Lcom/amazon/mShop/SearchBar;->logRefMarker()V

    .line 152
    iget-object v3, p0, Lcom/amazon/mShop/SearchBar$3;->this$0:Lcom/amazon/mShop/SearchBar;

    # getter for: Lcom/amazon/mShop/SearchBar;->mSearchBarPlate:Landroid/view/View;
    invoke-static {v3}, Lcom/amazon/mShop/SearchBar;->access$300(Lcom/amazon/mShop/SearchBar;)Landroid/view/View;

    move-result-object v3

    invoke-virtual {v3, v1}, Landroid/view/View;->setPressed(Z)V

    .line 155
    iget-object v1, p0, Lcom/amazon/mShop/SearchBar$3;->this$0:Lcom/amazon/mShop/SearchBar;

    # setter for: Lcom/amazon/mShop/SearchBar;->mIsTapped:Z
    invoke-static {v1, v2}, Lcom/amazon/mShop/SearchBar;->access$002(Lcom/amazon/mShop/SearchBar;Z)Z

    .end local v0    # "searchText":Ljava/lang/String;
    :goto_1
    move v1, v2

    .line 165
    :cond_1
    return v1

    .line 145
    .restart local v0    # "searchText":Ljava/lang/String;
    :cond_2
    iget-object v3, p0, Lcom/amazon/mShop/SearchBar$3;->this$0:Lcom/amazon/mShop/SearchBar;

    invoke-virtual {v3, v0, v2}, Lcom/amazon/mShop/SearchBar;->goToSearchEntry(Ljava/lang/String;Z)V

    goto :goto_0

    .line 158
    .end local v0    # "searchText":Ljava/lang/String;
    :cond_3
    iget-object v1, p0, Lcom/amazon/mShop/SearchBar$3;->this$0:Lcom/amazon/mShop/SearchBar;

    # getter for: Lcom/amazon/mShop/SearchBar;->mSearchBarPlate:Landroid/view/View;
    invoke-static {v1}, Lcom/amazon/mShop/SearchBar;->access$300(Lcom/amazon/mShop/SearchBar;)Landroid/view/View;

    move-result-object v1

    invoke-virtual {v1, v2}, Landroid/view/View;->setPressed(Z)V

    goto :goto_1
.end method

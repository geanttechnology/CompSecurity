.class Lcom/amazon/mShop/SearchBar$1;
.super Ljava/lang/Object;
.source "SearchBar.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


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
    .line 109
    iput-object p1, p0, Lcom/amazon/mShop/SearchBar$1;->this$0:Lcom/amazon/mShop/SearchBar;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3
    .param p1, "v"    # Landroid/view/View;

    .prologue
    const/4 v2, 0x1

    .line 112
    iget-object v0, p0, Lcom/amazon/mShop/SearchBar$1;->this$0:Lcom/amazon/mShop/SearchBar;

    const/4 v1, 0x0

    invoke-virtual {v0, v1, v2}, Lcom/amazon/mShop/SearchBar;->goToSearchEntry(Ljava/lang/String;Z)V

    .line 114
    iget-object v0, p0, Lcom/amazon/mShop/SearchBar$1;->this$0:Lcom/amazon/mShop/SearchBar;

    invoke-virtual {v0}, Lcom/amazon/mShop/SearchBar;->logRefMarker()V

    .line 116
    iget-object v0, p0, Lcom/amazon/mShop/SearchBar$1;->this$0:Lcom/amazon/mShop/SearchBar;

    # setter for: Lcom/amazon/mShop/SearchBar;->mIsTapped:Z
    invoke-static {v0, v2}, Lcom/amazon/mShop/SearchBar;->access$002(Lcom/amazon/mShop/SearchBar;Z)Z

    .line 117
    return-void
.end method

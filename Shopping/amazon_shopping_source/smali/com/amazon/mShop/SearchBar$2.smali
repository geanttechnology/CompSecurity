.class Lcom/amazon/mShop/SearchBar$2;
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
    .line 120
    iput-object p1, p0, Lcom/amazon/mShop/SearchBar$2;->this$0:Lcom/amazon/mShop/SearchBar;

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

    .line 123
    invoke-virtual {p2}, Landroid/view/MotionEvent;->getAction()I

    move-result v0

    if-ne v0, v2, :cond_0

    .line 124
    iget-object v0, p0, Lcom/amazon/mShop/SearchBar$2;->this$0:Lcom/amazon/mShop/SearchBar;

    invoke-virtual {v0}, Lcom/amazon/mShop/SearchBar;->doBarcodeScan()V

    .line 127
    iget-object v0, p0, Lcom/amazon/mShop/SearchBar$2;->this$0:Lcom/amazon/mShop/SearchBar;

    # getter for: Lcom/amazon/mShop/SearchBar;->mSearchBarcode:Landroid/widget/ImageView;
    invoke-static {v0}, Lcom/amazon/mShop/SearchBar;->access$100(Lcom/amazon/mShop/SearchBar;)Landroid/widget/ImageView;

    move-result-object v0

    sget v1, Lcom/amazon/mShop/android/lib/R$color;->transparent:I

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setBackgroundResource(I)V

    .line 132
    :goto_0
    return v2

    .line 130
    :cond_0
    iget-object v0, p0, Lcom/amazon/mShop/SearchBar$2;->this$0:Lcom/amazon/mShop/SearchBar;

    # getter for: Lcom/amazon/mShop/SearchBar;->mSearchBarcode:Landroid/widget/ImageView;
    invoke-static {v0}, Lcom/amazon/mShop/SearchBar;->access$100(Lcom/amazon/mShop/SearchBar;)Landroid/widget/ImageView;

    move-result-object v0

    sget v1, Lcom/amazon/mShop/android/lib/R$drawable;->action_bar_icon_round_corner_pressed:I

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setBackgroundResource(I)V

    goto :goto_0
.end method

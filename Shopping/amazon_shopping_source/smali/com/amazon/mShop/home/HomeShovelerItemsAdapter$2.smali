.class Lcom/amazon/mShop/home/HomeShovelerItemsAdapter$2;
.super Ljava/lang/Object;
.source "HomeShovelerItemsAdapter.java"

# interfaces
.implements Landroid/view/View$OnFocusChangeListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;->getShovelerItemView(ILcom/amazon/mShop/home/ShovelerItemView;)Landroid/view/View;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;)V
    .locals 0

    .prologue
    .line 478
    iput-object p1, p0, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter$2;->this$0:Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onFocusChange(Landroid/view/View;Z)V
    .locals 2
    .param p1, "v"    # Landroid/view/View;
    .param p2, "hasFocus"    # Z

    .prologue
    .line 481
    invoke-virtual {p1}, Landroid/view/View;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup;

    .line 482
    .local v0, "p":Landroid/view/ViewGroup;
    invoke-virtual {v0}, Landroid/view/ViewGroup;->getOnFocusChangeListener()Landroid/view/View$OnFocusChangeListener;

    move-result-object v1

    invoke-interface {v1, p1, p2}, Landroid/view/View$OnFocusChangeListener;->onFocusChange(Landroid/view/View;Z)V

    .line 483
    return-void
.end method

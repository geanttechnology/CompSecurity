.class Lcom/amazon/mShop/gno/GNODrawerItemGroup$1;
.super Ljava/lang/Object;
.source "GNODrawerItemGroup.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/gno/GNODrawerItemGroup;-><init>(Landroid/content/Context;Ljava/lang/String;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/gno/GNODrawerItemGroup;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/gno/GNODrawerItemGroup;)V
    .locals 0

    .prologue
    .line 43
    iput-object p1, p0, Lcom/amazon/mShop/gno/GNODrawerItemGroup$1;->this$0:Lcom/amazon/mShop/gno/GNODrawerItemGroup;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 9
    .param p1, "v"    # Landroid/view/View;

    .prologue
    const/4 v3, 0x1

    .line 46
    sget v2, Lcom/amazon/mShop/android/lib/R$id;->group_item_expandable_arrow:I

    invoke-virtual {p1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/ImageView;

    .line 48
    .local v1, "icon":Landroid/widget/ImageView;
    invoke-static {}, Lcom/amazon/mShop/gno/GNODrawer;->getGNOItemAdapter()Lcom/amazon/mShop/gno/GNOItemAdapter;

    move-result-object v6

    .line 49
    .local v6, "adapter":Lcom/amazon/mShop/gno/GNOItemAdapter;
    iget-object v4, p0, Lcom/amazon/mShop/gno/GNODrawerItemGroup$1;->this$0:Lcom/amazon/mShop/gno/GNODrawerItemGroup;

    iget-object v2, p0, Lcom/amazon/mShop/gno/GNODrawerItemGroup$1;->this$0:Lcom/amazon/mShop/gno/GNODrawerItemGroup;

    invoke-virtual {v2}, Lcom/amazon/mShop/gno/GNODrawerItemGroup;->getId()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v6, v2}, Lcom/amazon/mShop/gno/GNOItemAdapter;->isGroupExpanded(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_0

    move v2, v3

    :goto_0
    # setter for: Lcom/amazon/mShop/gno/GNODrawerItemGroup;->mIsExpanding:Z
    invoke-static {v4, v2}, Lcom/amazon/mShop/gno/GNODrawerItemGroup;->access$002(Lcom/amazon/mShop/gno/GNODrawerItemGroup;Z)Z

    .line 50
    iget-object v2, p0, Lcom/amazon/mShop/gno/GNODrawerItemGroup$1;->this$0:Lcom/amazon/mShop/gno/GNODrawerItemGroup;

    # setter for: Lcom/amazon/mShop/gno/GNODrawerItemGroup;->mIsAnimating:Z
    invoke-static {v2, v3}, Lcom/amazon/mShop/gno/GNODrawerItemGroup;->access$102(Lcom/amazon/mShop/gno/GNODrawerItemGroup;Z)Z

    .line 53
    iget-object v2, p0, Lcom/amazon/mShop/gno/GNODrawerItemGroup$1;->this$0:Lcom/amazon/mShop/gno/GNODrawerItemGroup;

    # getter for: Lcom/amazon/mShop/gno/GNODrawerItemGroup;->mIsExpanding:Z
    invoke-static {v2}, Lcom/amazon/mShop/gno/GNODrawerItemGroup;->access$000(Lcom/amazon/mShop/gno/GNODrawerItemGroup;)Z

    move-result v2

    if-eqz v2, :cond_1

    sget v2, Lcom/amazon/mShop/android/lib/R$drawable;->gno_arrow_up:I

    :goto_1
    invoke-virtual {v1, v2}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 54
    new-instance v0, Lcom/amazon/mShop/anim/FlipAnimation;

    sget v2, Lcom/amazon/mShop/anim/FlipAnimation;->X_AXIS:I

    iget-object v4, p0, Lcom/amazon/mShop/gno/GNODrawerItemGroup$1;->this$0:Lcom/amazon/mShop/gno/GNODrawerItemGroup;

    invoke-virtual {v4}, Lcom/amazon/mShop/gno/GNODrawerItemGroup;->getChildren()Ljava/util/List;

    move-result-object v4

    invoke-interface {v4}, Ljava/util/List;->size()I

    move-result v4

    int-to-long v4, v4

    invoke-virtual {p1}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v7

    iget-object v8, p0, Lcom/amazon/mShop/gno/GNODrawerItemGroup$1;->this$0:Lcom/amazon/mShop/gno/GNODrawerItemGroup;

    # getter for: Lcom/amazon/mShop/gno/GNODrawerItemGroup;->mIsExpanding:Z
    invoke-static {v8}, Lcom/amazon/mShop/gno/GNODrawerItemGroup;->access$000(Lcom/amazon/mShop/gno/GNODrawerItemGroup;)Z

    move-result v8

    invoke-static {v7, v8}, Lcom/amazon/mShop/gno/GNODebugSettingsActivity;->getAnimationDurationMillis(Landroid/content/Context;Z)J

    move-result-wide v7

    mul-long/2addr v4, v7

    invoke-direct/range {v0 .. v5}, Lcom/amazon/mShop/anim/FlipAnimation;-><init>(Landroid/view/View;IZJ)V

    .line 55
    .local v0, "anim":Landroid/view/animation/Animation;
    new-instance v2, Lcom/amazon/mShop/gno/GNODrawerItemGroup$1$1;

    invoke-direct {v2, p0}, Lcom/amazon/mShop/gno/GNODrawerItemGroup$1$1;-><init>(Lcom/amazon/mShop/gno/GNODrawerItemGroup$1;)V

    invoke-virtual {v0, v2}, Landroid/view/animation/Animation;->setAnimationListener(Landroid/view/animation/Animation$AnimationListener;)V

    .line 67
    invoke-virtual {v1, v0}, Landroid/widget/ImageView;->startAnimation(Landroid/view/animation/Animation;)V

    .line 69
    iget-object v2, p0, Lcom/amazon/mShop/gno/GNODrawerItemGroup$1;->this$0:Lcom/amazon/mShop/gno/GNODrawerItemGroup;

    # getter for: Lcom/amazon/mShop/gno/GNODrawerItemGroup;->mIsExpanding:Z
    invoke-static {v2}, Lcom/amazon/mShop/gno/GNODrawerItemGroup;->access$000(Lcom/amazon/mShop/gno/GNODrawerItemGroup;)Z

    move-result v2

    if-eqz v2, :cond_2

    .line 70
    iget-object v2, p0, Lcom/amazon/mShop/gno/GNODrawerItemGroup$1;->this$0:Lcom/amazon/mShop/gno/GNODrawerItemGroup;

    invoke-virtual {v2}, Lcom/amazon/mShop/gno/GNODrawerItemGroup;->getId()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v6, v2, v3}, Lcom/amazon/mShop/gno/GNOItemAdapter;->expandGroup(Ljava/lang/String;Z)Z

    .line 75
    :goto_2
    invoke-virtual {v1}, Landroid/widget/ImageView;->invalidate()V

    .line 76
    return-void

    .line 49
    .end local v0    # "anim":Landroid/view/animation/Animation;
    :cond_0
    const/4 v2, 0x0

    goto :goto_0

    .line 53
    :cond_1
    sget v2, Lcom/amazon/mShop/android/lib/R$drawable;->gno_arrow_down:I

    goto :goto_1

    .line 72
    .restart local v0    # "anim":Landroid/view/animation/Animation;
    :cond_2
    iget-object v2, p0, Lcom/amazon/mShop/gno/GNODrawerItemGroup$1;->this$0:Lcom/amazon/mShop/gno/GNODrawerItemGroup;

    invoke-virtual {v2}, Lcom/amazon/mShop/gno/GNODrawerItemGroup;->getId()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v6, v2, v3}, Lcom/amazon/mShop/gno/GNOItemAdapter;->collapseGroup(Ljava/lang/String;Z)Z

    goto :goto_2
.end method

.class Lcom/amazon/mShop/Stars$1;
.super Ljava/lang/Object;
.source "Stars.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/Stars;->setRating(Ljava/lang/Integer;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/Stars;

.field final synthetic val$rating:Ljava/lang/Integer;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/Stars;Ljava/lang/Integer;)V
    .locals 0

    .prologue
    .line 50
    iput-object p1, p0, Lcom/amazon/mShop/Stars$1;->this$0:Lcom/amazon/mShop/Stars;

    iput-object p2, p0, Lcom/amazon/mShop/Stars$1;->val$rating:Ljava/lang/Integer;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 12

    .prologue
    const/4 v11, 0x5

    const/4 v5, 0x0

    .line 53
    iget-object v8, p0, Lcom/amazon/mShop/Stars$1;->val$rating:Ljava/lang/Integer;

    if-nez v8, :cond_1

    .line 54
    iget-object v8, p0, Lcom/amazon/mShop/Stars$1;->this$0:Lcom/amazon/mShop/Stars;

    const/16 v9, 0x8

    invoke-virtual {v8, v9}, Lcom/amazon/mShop/Stars;->setVisibility(I)V

    .line 96
    :cond_0
    return-void

    .line 58
    :cond_1
    :goto_0
    iget-object v8, p0, Lcom/amazon/mShop/Stars$1;->this$0:Lcom/amazon/mShop/Stars;

    invoke-virtual {v8}, Lcom/amazon/mShop/Stars;->getChildCount()I

    move-result v8

    if-le v11, v8, :cond_2

    .line 59
    iget-object v8, p0, Lcom/amazon/mShop/Stars$1;->this$0:Lcom/amazon/mShop/Stars;

    new-instance v9, Landroid/widget/ImageView;

    iget-object v10, p0, Lcom/amazon/mShop/Stars$1;->this$0:Lcom/amazon/mShop/Stars;

    invoke-virtual {v10}, Lcom/amazon/mShop/Stars;->getContext()Landroid/content/Context;

    move-result-object v10

    invoke-direct {v9, v10}, Landroid/widget/ImageView;-><init>(Landroid/content/Context;)V

    invoke-virtual {v8, v9}, Lcom/amazon/mShop/Stars;->addView(Landroid/view/View;)V

    goto :goto_0

    .line 62
    :cond_2
    iget-object v8, p0, Lcom/amazon/mShop/Stars$1;->this$0:Lcom/amazon/mShop/Stars;

    sget v9, Lcom/amazon/mShop/android/lib/R$drawable;->star_on:I

    # invokes: Lcom/amazon/mShop/Stars;->getResourceBitmap(I)Landroid/graphics/Bitmap;
    invoke-static {v8, v9}, Lcom/amazon/mShop/Stars;->access$000(Lcom/amazon/mShop/Stars;I)Landroid/graphics/Bitmap;

    move-result-object v1

    .line 63
    .local v1, "fullStarBitmap":Landroid/graphics/Bitmap;
    iget-object v8, p0, Lcom/amazon/mShop/Stars$1;->this$0:Lcom/amazon/mShop/Stars;

    sget v9, Lcom/amazon/mShop/android/lib/R$drawable;->star_half:I

    # invokes: Lcom/amazon/mShop/Stars;->getResourceBitmap(I)Landroid/graphics/Bitmap;
    invoke-static {v8, v9}, Lcom/amazon/mShop/Stars;->access$000(Lcom/amazon/mShop/Stars;I)Landroid/graphics/Bitmap;

    move-result-object v2

    .line 64
    .local v2, "halfStarBitmap":Landroid/graphics/Bitmap;
    iget-object v8, p0, Lcom/amazon/mShop/Stars$1;->this$0:Lcom/amazon/mShop/Stars;

    sget v9, Lcom/amazon/mShop/android/lib/R$drawable;->star_off:I

    # invokes: Lcom/amazon/mShop/Stars;->getResourceBitmap(I)Landroid/graphics/Bitmap;
    invoke-static {v8, v9}, Lcom/amazon/mShop/Stars;->access$000(Lcom/amazon/mShop/Stars;I)Landroid/graphics/Bitmap;

    move-result-object v0

    .line 66
    .local v0, "emptyStarBitmap":Landroid/graphics/Bitmap;
    if-eqz v1, :cond_0

    if-eqz v2, :cond_0

    if-eqz v0, :cond_0

    .line 70
    iget-object v8, p0, Lcom/amazon/mShop/Stars$1;->this$0:Lcom/amazon/mShop/Stars;

    # getter for: Lcom/amazon/mShop/Stars;->mStarHeight:I
    invoke-static {v8}, Lcom/amazon/mShop/Stars;->access$100(Lcom/amazon/mShop/Stars;)I

    move-result v8

    if-lez v8, :cond_3

    .line 71
    iget-object v8, p0, Lcom/amazon/mShop/Stars$1;->this$0:Lcom/amazon/mShop/Stars;

    # invokes: Lcom/amazon/mShop/Stars;->scaleBitmap(Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
    invoke-static {v8, v1}, Lcom/amazon/mShop/Stars;->access$200(Lcom/amazon/mShop/Stars;Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;

    move-result-object v1

    .line 72
    iget-object v8, p0, Lcom/amazon/mShop/Stars$1;->this$0:Lcom/amazon/mShop/Stars;

    # invokes: Lcom/amazon/mShop/Stars;->scaleBitmap(Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
    invoke-static {v8, v2}, Lcom/amazon/mShop/Stars;->access$200(Lcom/amazon/mShop/Stars;Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;

    move-result-object v2

    .line 73
    iget-object v8, p0, Lcom/amazon/mShop/Stars$1;->this$0:Lcom/amazon/mShop/Stars;

    # invokes: Lcom/amazon/mShop/Stars;->scaleBitmap(Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
    invoke-static {v8, v0}, Lcom/amazon/mShop/Stars;->access$200(Lcom/amazon/mShop/Stars;Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;

    move-result-object v0

    .line 76
    :cond_3
    iget-object v8, p0, Lcom/amazon/mShop/Stars$1;->this$0:Lcom/amazon/mShop/Stars;

    invoke-virtual {v8, v5}, Lcom/amazon/mShop/Stars;->setVisibility(I)V

    .line 78
    iget-object v8, p0, Lcom/amazon/mShop/Stars$1;->val$rating:Ljava/lang/Integer;

    invoke-virtual {v8}, Ljava/lang/Integer;->intValue()I

    move-result v8

    shr-int/lit8 v6, v8, 0x1

    .line 79
    .local v6, "onStars":I
    iget-object v8, p0, Lcom/amazon/mShop/Stars$1;->val$rating:Ljava/lang/Integer;

    invoke-virtual {v8}, Ljava/lang/Integer;->intValue()I

    move-result v8

    and-int/lit8 v8, v8, 0x1

    if-eqz v8, :cond_4

    const/4 v5, 0x1

    .line 81
    .local v5, "isHalf":Z
    :cond_4
    const/4 v3, 0x0

    .local v3, "i":I
    move v4, v3

    .line 82
    .end local v3    # "i":I
    .local v4, "i":I
    :goto_1
    if-ge v4, v6, :cond_5

    .line 83
    iget-object v8, p0, Lcom/amazon/mShop/Stars$1;->this$0:Lcom/amazon/mShop/Stars;

    invoke-virtual {v8, v4}, Lcom/amazon/mShop/Stars;->getChildAt(I)Landroid/view/View;

    move-result-object v7

    check-cast v7, Landroid/widget/ImageView;

    .line 84
    .local v7, "star":Landroid/widget/ImageView;
    invoke-virtual {v7, v1}, Landroid/widget/ImageView;->setImageBitmap(Landroid/graphics/Bitmap;)V

    .line 82
    add-int/lit8 v3, v4, 0x1

    .end local v4    # "i":I
    .restart local v3    # "i":I
    move v4, v3

    .end local v3    # "i":I
    .restart local v4    # "i":I
    goto :goto_1

    .line 87
    .end local v7    # "star":Landroid/widget/ImageView;
    :cond_5
    if-eqz v5, :cond_6

    .line 88
    iget-object v8, p0, Lcom/amazon/mShop/Stars$1;->this$0:Lcom/amazon/mShop/Stars;

    add-int/lit8 v3, v4, 0x1

    .end local v4    # "i":I
    .restart local v3    # "i":I
    invoke-virtual {v8, v4}, Lcom/amazon/mShop/Stars;->getChildAt(I)Landroid/view/View;

    move-result-object v7

    check-cast v7, Landroid/widget/ImageView;

    .line 89
    .restart local v7    # "star":Landroid/widget/ImageView;
    invoke-virtual {v7, v2}, Landroid/widget/ImageView;->setImageBitmap(Landroid/graphics/Bitmap;)V

    .line 92
    .end local v7    # "star":Landroid/widget/ImageView;
    :goto_2
    if-ge v3, v11, :cond_0

    .line 93
    iget-object v8, p0, Lcom/amazon/mShop/Stars$1;->this$0:Lcom/amazon/mShop/Stars;

    invoke-virtual {v8, v3}, Lcom/amazon/mShop/Stars;->getChildAt(I)Landroid/view/View;

    move-result-object v7

    check-cast v7, Landroid/widget/ImageView;

    .line 94
    .restart local v7    # "star":Landroid/widget/ImageView;
    invoke-virtual {v7, v0}, Landroid/widget/ImageView;->setImageBitmap(Landroid/graphics/Bitmap;)V

    .line 92
    add-int/lit8 v3, v3, 0x1

    goto :goto_2

    .end local v3    # "i":I
    .end local v7    # "star":Landroid/widget/ImageView;
    .restart local v4    # "i":I
    :cond_6
    move v3, v4

    .end local v4    # "i":I
    .restart local v3    # "i":I
    goto :goto_2
.end method

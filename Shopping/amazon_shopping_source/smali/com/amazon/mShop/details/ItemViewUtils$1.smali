.class final Lcom/amazon/mShop/details/ItemViewUtils$1;
.super Ljava/lang/Object;
.source "ItemViewUtils.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/details/ItemViewUtils;->updateImageWithDrawable(Landroid/graphics/drawable/Drawable;Landroid/widget/ImageView;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation


# instance fields
.field final synthetic val$drawable:Landroid/graphics/drawable/Drawable;

.field final synthetic val$imageView:Landroid/widget/ImageView;


# direct methods
.method constructor <init>(Landroid/graphics/drawable/Drawable;Landroid/widget/ImageView;)V
    .locals 0

    .prologue
    .line 158
    iput-object p1, p0, Lcom/amazon/mShop/details/ItemViewUtils$1;->val$drawable:Landroid/graphics/drawable/Drawable;

    iput-object p2, p0, Lcom/amazon/mShop/details/ItemViewUtils$1;->val$imageView:Landroid/widget/ImageView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 161
    iget-object v0, p0, Lcom/amazon/mShop/details/ItemViewUtils$1;->val$drawable:Landroid/graphics/drawable/Drawable;

    if-nez v0, :cond_0

    .line 162
    iget-object v0, p0, Lcom/amazon/mShop/details/ItemViewUtils$1;->val$imageView:Landroid/widget/ImageView;

    sget v1, Lcom/amazon/mShop/android/lib/R$drawable;->noimage:I

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 166
    :goto_0
    return-void

    .line 164
    :cond_0
    iget-object v0, p0, Lcom/amazon/mShop/details/ItemViewUtils$1;->val$imageView:Landroid/widget/ImageView;

    iget-object v1, p0, Lcom/amazon/mShop/details/ItemViewUtils$1;->val$drawable:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    goto :goto_0
.end method

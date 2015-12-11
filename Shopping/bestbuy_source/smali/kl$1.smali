.class Lkl$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lkl;->a(I)V
.end annotation


# instance fields
.field final synthetic a:Landroid/widget/ImageView;

.field final synthetic b:Lkl;


# direct methods
.method constructor <init>(Lkl;Landroid/widget/ImageView;)V
    .locals 0

    .prologue
    .line 153
    iput-object p1, p0, Lkl$1;->b:Lkl;

    iput-object p2, p0, Lkl$1;->a:Landroid/widget/ImageView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 2

    .prologue
    .line 157
    invoke-virtual {p1}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    .line 158
    iget-object v1, p0, Lkl$1;->b:Lkl;

    iget-object v1, v1, Lkl;->a:Lcom/bestbuy/android/bbyobjects/ProductImageGallery;

    invoke-static {v1}, Lcom/bestbuy/android/bbyobjects/ProductImageGallery;->c(Lcom/bestbuy/android/bbyobjects/ProductImageGallery;)Landroid/support/v4/view/ViewPager;

    move-result-object v1

    invoke-static {v0}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v0

    invoke-virtual {v1, v0}, Landroid/support/v4/view/ViewPager;->setCurrentItem(I)V

    .line 159
    iget-object v0, p0, Lkl$1;->a:Landroid/widget/ImageView;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setSelected(Z)V

    .line 160
    return-void
.end method

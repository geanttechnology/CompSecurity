.class Lkn$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lkn;->instantiateItem(Landroid/view/View;I)Ljava/lang/Object;
.end annotation


# instance fields
.field final synthetic a:I

.field final synthetic b:Lkn;


# direct methods
.method constructor <init>(Lkn;I)V
    .locals 0

    .prologue
    .line 86
    iput-object p1, p0, Lkn$1;->b:Lkn;

    iput p2, p0, Lkn$1;->a:I

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 2

    .prologue
    .line 90
    iget-object v0, p0, Lkn$1;->b:Lkn;

    iget-object v0, v0, Lkn;->c:Lcom/bestbuy/android/bbyobjects/ProductImageGallery;

    invoke-static {v0}, Lcom/bestbuy/android/bbyobjects/ProductImageGallery;->b(Lcom/bestbuy/android/bbyobjects/ProductImageGallery;)Lkm;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 91
    iget-object v0, p0, Lkn$1;->b:Lkn;

    iget-object v0, v0, Lkn;->c:Lcom/bestbuy/android/bbyobjects/ProductImageGallery;

    invoke-static {v0}, Lcom/bestbuy/android/bbyobjects/ProductImageGallery;->b(Lcom/bestbuy/android/bbyobjects/ProductImageGallery;)Lkm;

    move-result-object v0

    iget v1, p0, Lkn$1;->a:I

    invoke-interface {v0, v1}, Lkm;->a(I)V

    .line 92
    :cond_0
    return-void
.end method

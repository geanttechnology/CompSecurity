.class Lcom/bestbuy/android/bbyobjects/BBYPromoPager$3;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/bestbuy/android/bbyobjects/BBYPromoPager;->a(Landroid/content/Context;Landroid/view/View;ILjava/util/List;)Ljava/lang/Object;
.end annotation


# instance fields
.field final synthetic a:Ljava/util/List;

.field final synthetic b:I

.field final synthetic c:Lcom/bestbuy/android/bbyobjects/BBYPromoPager;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/bbyobjects/BBYPromoPager;Ljava/util/List;I)V
    .locals 0

    .prologue
    .line 183
    iput-object p1, p0, Lcom/bestbuy/android/bbyobjects/BBYPromoPager$3;->c:Lcom/bestbuy/android/bbyobjects/BBYPromoPager;

    iput-object p2, p0, Lcom/bestbuy/android/bbyobjects/BBYPromoPager$3;->a:Ljava/util/List;

    iput p3, p0, Lcom/bestbuy/android/bbyobjects/BBYPromoPager$3;->b:I

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3

    .prologue
    .line 187
    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYPromoPager$3;->c:Lcom/bestbuy/android/bbyobjects/BBYPromoPager;

    invoke-static {v0}, Lcom/bestbuy/android/bbyobjects/BBYPromoPager;->d(Lcom/bestbuy/android/bbyobjects/BBYPromoPager;)Lkh;

    move-result-object v1

    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYPromoPager$3;->a:Ljava/util/List;

    iget v2, p0, Lcom/bestbuy/android/bbyobjects/BBYPromoPager$3;->b:I

    invoke-interface {v0, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/offers/Offer;

    iget v2, p0, Lcom/bestbuy/android/bbyobjects/BBYPromoPager$3;->b:I

    invoke-interface {v1, v0, v2}, Lkh;->a(Lcom/bestbuy/android/api/lib/models/offers/Offer;I)V

    .line 189
    return-void
.end method

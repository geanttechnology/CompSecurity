.class Lef$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lef;->getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
.end annotation


# instance fields
.field final synthetic a:I

.field final synthetic b:Landroid/widget/ImageView;

.field final synthetic c:Lef;


# direct methods
.method constructor <init>(Lef;ILandroid/widget/ImageView;)V
    .locals 0

    .prologue
    .line 58
    iput-object p1, p0, Lef$1;->c:Lef;

    iput p2, p0, Lef$1;->a:I

    iput-object p3, p0, Lef$1;->b:Landroid/widget/ImageView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3

    .prologue
    .line 61
    iget-object v0, p0, Lef$1;->c:Lef;

    invoke-static {v0}, Lef;->a(Lef;)Ljava/util/List;

    move-result-object v0

    iget v1, p0, Lef$1;->a:I

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/browse/Category;

    .line 62
    iget-object v1, p0, Lef$1;->c:Lef;

    iget-object v2, p0, Lef$1;->b:Landroid/widget/ImageView;

    invoke-virtual {v1, v2, v0}, Lef;->a(Landroid/widget/ImageView;Lcom/bestbuy/android/api/lib/models/browse/Category;)V

    .line 63
    return-void
.end method

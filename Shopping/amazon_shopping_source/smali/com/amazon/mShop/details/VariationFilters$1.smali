.class Lcom/amazon/mShop/details/VariationFilters$1;
.super Ljava/lang/Object;
.source "VariationFilters.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/details/VariationFilters;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/details/VariationFilters;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/details/VariationFilters;)V
    .locals 0

    .prologue
    .line 179
    iput-object p1, p0, Lcom/amazon/mShop/details/VariationFilters$1;->this$0:Lcom/amazon/mShop/details/VariationFilters;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 2
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 183
    iget-object v1, p0, Lcom/amazon/mShop/details/VariationFilters$1;->this$0:Lcom/amazon/mShop/details/VariationFilters;

    invoke-virtual {p1}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Integer;

    invoke-virtual {v1, v0}, Lcom/amazon/mShop/details/VariationFilters;->showDimensionList(Ljava/lang/Integer;)V

    .line 184
    return-void
.end method

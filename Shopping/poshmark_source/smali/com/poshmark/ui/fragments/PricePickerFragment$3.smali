.class Lcom/poshmark/ui/fragments/PricePickerFragment$3;
.super Ljava/lang/Object;
.source "PricePickerFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/ui/fragments/PricePickerFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/PricePickerFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/PricePickerFragment;)V
    .locals 0

    .prologue
    .line 185
    iput-object p1, p0, Lcom/poshmark/ui/fragments/PricePickerFragment$3;->this$0:Lcom/poshmark/ui/fragments/PricePickerFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 4
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 188
    iget-object v2, p0, Lcom/poshmark/ui/fragments/PricePickerFragment$3;->this$0:Lcom/poshmark/ui/fragments/PricePickerFragment;

    const/4 v3, 0x1

    iput-boolean v3, v2, Lcom/poshmark/ui/fragments/PricePickerFragment;->dataChanged:Z

    .line 189
    iget-object v2, p0, Lcom/poshmark/ui/fragments/PricePickerFragment$3;->this$0:Lcom/poshmark/ui/fragments/PricePickerFragment;

    iget-object v2, v2, Lcom/poshmark/ui/fragments/PricePickerFragment;->info:Lcom/poshmark/utils/meta_data/PricePickerInfo;

    iget-object v3, v2, Lcom/poshmark/utils/meta_data/PricePickerInfo;->allItems:Ljava/util/List;

    invoke-virtual {p1}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/Integer;

    invoke-virtual {v2}, Ljava/lang/Integer;->intValue()I

    move-result v2

    invoke-interface {v3, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/poshmark/data_model/models/PriceInfo;

    .local v1, "tappedItem":Lcom/poshmark/data_model/models/PriceInfo;
    move-object v0, p1

    .line 190
    check-cast v0, Lcom/poshmark/ui/customviews/PMButton;

    .line 191
    .local v0, "button":Lcom/poshmark/ui/customviews/PMButton;
    iget-object v2, p0, Lcom/poshmark/ui/fragments/PricePickerFragment$3;->this$0:Lcom/poshmark/ui/fragments/PricePickerFragment;

    iget-object v2, v2, Lcom/poshmark/ui/fragments/PricePickerFragment;->info:Lcom/poshmark/utils/meta_data/PricePickerInfo;

    iget-object v2, v2, Lcom/poshmark/utils/meta_data/PricePickerInfo;->selectedItems:Ljava/util/List;

    invoke-interface {v2, v1}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 193
    iget-object v2, p0, Lcom/poshmark/ui/fragments/PricePickerFragment$3;->this$0:Lcom/poshmark/ui/fragments/PricePickerFragment;

    iget-object v2, v2, Lcom/poshmark/ui/fragments/PricePickerFragment;->info:Lcom/poshmark/utils/meta_data/PricePickerInfo;

    iget-object v2, v2, Lcom/poshmark/utils/meta_data/PricePickerInfo;->selectedItems:Ljava/util/List;

    invoke-interface {v2, v1}, Ljava/util/List;->remove(Ljava/lang/Object;)Z

    .line 194
    const/4 v2, 0x0

    invoke-virtual {v0, v2}, Lcom/poshmark/ui/customviews/PMButton;->setBackgroundColor(I)V

    .line 195
    iget-object v2, p0, Lcom/poshmark/ui/fragments/PricePickerFragment$3;->this$0:Lcom/poshmark/ui/fragments/PricePickerFragment;

    invoke-virtual {v2}, Lcom/poshmark/ui/fragments/PricePickerFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f020014

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v2

    invoke-virtual {v0, v2}, Lcom/poshmark/ui/customviews/PMButton;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 196
    iget-object v2, p0, Lcom/poshmark/ui/fragments/PricePickerFragment$3;->this$0:Lcom/poshmark/ui/fragments/PricePickerFragment;

    invoke-virtual {v2}, Lcom/poshmark/ui/fragments/PricePickerFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f090035

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getColor(I)I

    move-result v2

    invoke-virtual {v0, v2}, Lcom/poshmark/ui/customviews/PMButton;->setTextColor(I)V

    .line 202
    :goto_0
    return-void

    .line 198
    :cond_0
    iget-object v2, p0, Lcom/poshmark/ui/fragments/PricePickerFragment$3;->this$0:Lcom/poshmark/ui/fragments/PricePickerFragment;

    invoke-virtual {v2}, Lcom/poshmark/ui/fragments/PricePickerFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f020015

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v2

    invoke-virtual {v0, v2}, Lcom/poshmark/ui/customviews/PMButton;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 199
    iget-object v2, p0, Lcom/poshmark/ui/fragments/PricePickerFragment$3;->this$0:Lcom/poshmark/ui/fragments/PricePickerFragment;

    invoke-virtual {v2}, Lcom/poshmark/ui/fragments/PricePickerFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f090040

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getColor(I)I

    move-result v2

    invoke-virtual {v0, v2}, Lcom/poshmark/ui/customviews/PMButton;->setTextColor(I)V

    .line 200
    iget-object v2, p0, Lcom/poshmark/ui/fragments/PricePickerFragment$3;->this$0:Lcom/poshmark/ui/fragments/PricePickerFragment;

    iget-object v2, v2, Lcom/poshmark/ui/fragments/PricePickerFragment;->info:Lcom/poshmark/utils/meta_data/PricePickerInfo;

    iget-object v2, v2, Lcom/poshmark/utils/meta_data/PricePickerInfo;->selectedItems:Ljava/util/List;

    invoke-interface {v2, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0
.end method

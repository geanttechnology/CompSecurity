.class Lcom/poshmark/ui/fragments/MySizePickerFragment$6;
.super Ljava/lang/Object;
.source "MySizePickerFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/ui/fragments/MySizePickerFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/MySizePickerFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/MySizePickerFragment;)V
    .locals 0

    .prologue
    .line 347
    iput-object p1, p0, Lcom/poshmark/ui/fragments/MySizePickerFragment$6;->this$0:Lcom/poshmark/ui/fragments/MySizePickerFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 5
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 350
    move-object v0, p1

    check-cast v0, Lcom/poshmark/ui/customviews/PMButton;

    .line 351
    .local v0, "button":Lcom/poshmark/ui/customviews/PMButton;
    iget-object v2, p0, Lcom/poshmark/ui/fragments/MySizePickerFragment$6;->this$0:Lcom/poshmark/ui/fragments/MySizePickerFragment;

    const/4 v3, 0x1

    iput-boolean v3, v2, Lcom/poshmark/ui/fragments/MySizePickerFragment;->sizeDataChanged:Z

    .line 352
    iget-object v2, p0, Lcom/poshmark/ui/fragments/MySizePickerFragment$6;->this$0:Lcom/poshmark/ui/fragments/MySizePickerFragment;

    iget-object v2, v2, Lcom/poshmark/ui/fragments/MySizePickerFragment;->info:Lcom/poshmark/utils/meta_data/MySizePickerInfo;

    iget-object v3, v2, Lcom/poshmark/utils/meta_data/MySizePickerInfo;->allItems:Ljava/util/List;

    invoke-virtual {p1}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/Integer;

    invoke-virtual {v2}, Ljava/lang/Integer;->intValue()I

    move-result v2

    invoke-interface {v3, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/poshmark/data_model/models/MetaItem;

    .line 353
    .local v1, "tappedItem":Lcom/poshmark/data_model/models/MetaItem;
    iget-object v2, p0, Lcom/poshmark/ui/fragments/MySizePickerFragment$6;->this$0:Lcom/poshmark/ui/fragments/MySizePickerFragment;

    iget-object v2, v2, Lcom/poshmark/ui/fragments/MySizePickerFragment;->info:Lcom/poshmark/utils/meta_data/MySizePickerInfo;

    iget-object v2, v2, Lcom/poshmark/utils/meta_data/MySizePickerInfo;->selectedItems:Ljava/util/List;

    invoke-interface {v2, v1}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 355
    iget-object v2, p0, Lcom/poshmark/ui/fragments/MySizePickerFragment$6;->this$0:Lcom/poshmark/ui/fragments/MySizePickerFragment;

    iget-object v2, v2, Lcom/poshmark/ui/fragments/MySizePickerFragment;->info:Lcom/poshmark/utils/meta_data/MySizePickerInfo;

    iget-object v2, v2, Lcom/poshmark/utils/meta_data/MySizePickerInfo;->selectedItems:Ljava/util/List;

    invoke-interface {v2, v1}, Ljava/util/List;->remove(Ljava/lang/Object;)Z

    .line 356
    const/4 v2, 0x0

    invoke-virtual {v0, v2}, Lcom/poshmark/ui/customviews/PMButton;->setBackgroundColor(I)V

    .line 357
    iget-object v2, p0, Lcom/poshmark/ui/fragments/MySizePickerFragment$6;->this$0:Lcom/poshmark/ui/fragments/MySizePickerFragment;

    invoke-virtual {v2}, Lcom/poshmark/ui/fragments/MySizePickerFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f020014

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v2

    invoke-virtual {v0, v2}, Lcom/poshmark/ui/customviews/PMButton;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 358
    iget-object v2, p0, Lcom/poshmark/ui/fragments/MySizePickerFragment$6;->this$0:Lcom/poshmark/ui/fragments/MySizePickerFragment;

    invoke-virtual {v2}, Lcom/poshmark/ui/fragments/MySizePickerFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f090035

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getColor(I)I

    move-result v2

    invoke-virtual {v0, v2}, Lcom/poshmark/ui/customviews/PMButton;->setTextColor(I)V

    .line 368
    :goto_0
    return-void

    .line 360
    :cond_0
    iget-object v2, p0, Lcom/poshmark/ui/fragments/MySizePickerFragment$6;->this$0:Lcom/poshmark/ui/fragments/MySizePickerFragment;

    iget-object v2, v2, Lcom/poshmark/ui/fragments/MySizePickerFragment;->info:Lcom/poshmark/utils/meta_data/MySizePickerInfo;

    iget-object v2, v2, Lcom/poshmark/utils/meta_data/MySizePickerInfo;->selectedItems:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v2

    const/4 v3, 0x4

    if-ne v2, v3, :cond_1

    iget-object v2, p0, Lcom/poshmark/ui/fragments/MySizePickerFragment$6;->this$0:Lcom/poshmark/ui/fragments/MySizePickerFragment;

    iget-object v2, v2, Lcom/poshmark/ui/fragments/MySizePickerFragment;->mode:Lcom/poshmark/ui/fragments/MySizePickerFragment$MODE;

    sget-object v3, Lcom/poshmark/ui/fragments/MySizePickerFragment$MODE;->MY_SIZE:Lcom/poshmark/ui/fragments/MySizePickerFragment$MODE;

    if-ne v2, v3, :cond_1

    .line 361
    iget-object v2, p0, Lcom/poshmark/ui/fragments/MySizePickerFragment$6;->this$0:Lcom/poshmark/ui/fragments/MySizePickerFragment;

    const-string v3, ""

    const-string v4, "You can select a maximum of 4 options. Please un select an existing option to select a new one"

    invoke-virtual {v2, v3, v4}, Lcom/poshmark/ui/fragments/MySizePickerFragment;->showAlertMessage(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 363
    :cond_1
    iget-object v2, p0, Lcom/poshmark/ui/fragments/MySizePickerFragment$6;->this$0:Lcom/poshmark/ui/fragments/MySizePickerFragment;

    invoke-virtual {v2}, Lcom/poshmark/ui/fragments/MySizePickerFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f020015

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v2

    invoke-virtual {v0, v2}, Lcom/poshmark/ui/customviews/PMButton;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 364
    iget-object v2, p0, Lcom/poshmark/ui/fragments/MySizePickerFragment$6;->this$0:Lcom/poshmark/ui/fragments/MySizePickerFragment;

    invoke-virtual {v2}, Lcom/poshmark/ui/fragments/MySizePickerFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f090040

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getColor(I)I

    move-result v2

    invoke-virtual {v0, v2}, Lcom/poshmark/ui/customviews/PMButton;->setTextColor(I)V

    .line 365
    iget-object v2, p0, Lcom/poshmark/ui/fragments/MySizePickerFragment$6;->this$0:Lcom/poshmark/ui/fragments/MySizePickerFragment;

    iget-object v2, v2, Lcom/poshmark/ui/fragments/MySizePickerFragment;->info:Lcom/poshmark/utils/meta_data/MySizePickerInfo;

    iget-object v2, v2, Lcom/poshmark/utils/meta_data/MySizePickerInfo;->selectedItems:Ljava/util/List;

    invoke-interface {v2, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0
.end method

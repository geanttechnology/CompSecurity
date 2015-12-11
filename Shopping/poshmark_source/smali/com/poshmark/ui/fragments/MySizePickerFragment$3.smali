.class Lcom/poshmark/ui/fragments/MySizePickerFragment$3;
.super Ljava/lang/Object;
.source "MySizePickerFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/MySizePickerFragment;->setupClickHandlers()V
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
    .line 156
    iput-object p1, p0, Lcom/poshmark/ui/fragments/MySizePickerFragment$3;->this$0:Lcom/poshmark/ui/fragments/MySizePickerFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 7
    .param p1, "view"    # Landroid/view/View;

    .prologue
    const/4 v6, 0x0

    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 160
    iget-object v1, p0, Lcom/poshmark/ui/fragments/MySizePickerFragment$3;->this$0:Lcom/poshmark/ui/fragments/MySizePickerFragment;

    iget-boolean v1, v1, Lcom/poshmark/ui/fragments/MySizePickerFragment;->bIsMySizeSet:Z

    if-nez v1, :cond_0

    .line 161
    iget-object v1, p0, Lcom/poshmark/ui/fragments/MySizePickerFragment$3;->this$0:Lcom/poshmark/ui/fragments/MySizePickerFragment;

    invoke-virtual {v1}, Lcom/poshmark/ui/fragments/MySizePickerFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/PMActivity;

    .line 162
    .local v0, "parent":Lcom/poshmark/ui/PMActivity;
    const-class v1, Lcom/poshmark/ui/fragments/MySizeFragment;

    invoke-virtual {v0, v4, v1, v4}, Lcom/poshmark/ui/PMActivity;->launchFragment(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;)V

    .line 179
    .end local v0    # "parent":Lcom/poshmark/ui/PMActivity;
    :goto_0
    return-void

    .line 165
    :cond_0
    iget-object v1, p0, Lcom/poshmark/ui/fragments/MySizePickerFragment$3;->this$0:Lcom/poshmark/ui/fragments/MySizePickerFragment;

    iput-boolean v5, v1, Lcom/poshmark/ui/fragments/MySizePickerFragment;->mySizeSwitchChanged:Z

    .line 166
    iget-object v1, p0, Lcom/poshmark/ui/fragments/MySizePickerFragment$3;->this$0:Lcom/poshmark/ui/fragments/MySizePickerFragment;

    iget-object v1, v1, Lcom/poshmark/ui/fragments/MySizePickerFragment;->info:Lcom/poshmark/utils/meta_data/MySizePickerInfo;

    iget-boolean v1, v1, Lcom/poshmark/utils/meta_data/MySizePickerInfo;->bIsMySizeEnabled:Z

    if-eqz v1, :cond_1

    .line 167
    iget-object v1, p0, Lcom/poshmark/ui/fragments/MySizePickerFragment$3;->this$0:Lcom/poshmark/ui/fragments/MySizePickerFragment;

    iget-object v1, v1, Lcom/poshmark/ui/fragments/MySizePickerFragment;->info:Lcom/poshmark/utils/meta_data/MySizePickerInfo;

    iput-boolean v6, v1, Lcom/poshmark/utils/meta_data/MySizePickerInfo;->bIsMySizeEnabled:Z

    .line 168
    iget-object v1, p0, Lcom/poshmark/ui/fragments/MySizePickerFragment$3;->this$0:Lcom/poshmark/ui/fragments/MySizePickerFragment;

    iget-object v1, v1, Lcom/poshmark/ui/fragments/MySizePickerFragment;->mySizeToggleButton:Lcom/poshmark/ui/customviews/PMTextView;

    iget-object v2, p0, Lcom/poshmark/ui/fragments/MySizePickerFragment$3;->this$0:Lcom/poshmark/ui/fragments/MySizePickerFragment;

    invoke-virtual {v2}, Lcom/poshmark/ui/fragments/MySizePickerFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f090035

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getColor(I)I

    move-result v2

    invoke-virtual {v1, v2}, Lcom/poshmark/ui/customviews/PMTextView;->setTextColor(I)V

    .line 169
    iget-object v1, p0, Lcom/poshmark/ui/fragments/MySizePickerFragment$3;->this$0:Lcom/poshmark/ui/fragments/MySizePickerFragment;

    iget-object v1, v1, Lcom/poshmark/ui/fragments/MySizePickerFragment;->mySizeToggleButton:Lcom/poshmark/ui/customviews/PMTextView;

    invoke-virtual {v1, v4, v6}, Lcom/poshmark/ui/customviews/PMTextView;->setTypeface(Landroid/graphics/Typeface;I)V

    .line 170
    iget-object v1, p0, Lcom/poshmark/ui/fragments/MySizePickerFragment$3;->this$0:Lcom/poshmark/ui/fragments/MySizePickerFragment;

    iget-object v1, v1, Lcom/poshmark/ui/fragments/MySizePickerFragment;->mySizeToggleButton:Lcom/poshmark/ui/customviews/PMTextView;

    invoke-virtual {v1, v4, v4, v4, v4}, Lcom/poshmark/ui/customviews/PMTextView;->setCompoundDrawablesWithIntrinsicBounds(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V

    goto :goto_0

    .line 172
    :cond_1
    iget-object v1, p0, Lcom/poshmark/ui/fragments/MySizePickerFragment$3;->this$0:Lcom/poshmark/ui/fragments/MySizePickerFragment;

    iget-object v1, v1, Lcom/poshmark/ui/fragments/MySizePickerFragment;->info:Lcom/poshmark/utils/meta_data/MySizePickerInfo;

    iput-boolean v5, v1, Lcom/poshmark/utils/meta_data/MySizePickerInfo;->bIsMySizeEnabled:Z

    .line 173
    iget-object v1, p0, Lcom/poshmark/ui/fragments/MySizePickerFragment$3;->this$0:Lcom/poshmark/ui/fragments/MySizePickerFragment;

    iget-object v1, v1, Lcom/poshmark/ui/fragments/MySizePickerFragment;->mySizeToggleButton:Lcom/poshmark/ui/customviews/PMTextView;

    iget-object v2, p0, Lcom/poshmark/ui/fragments/MySizePickerFragment$3;->this$0:Lcom/poshmark/ui/fragments/MySizePickerFragment;

    invoke-virtual {v2}, Lcom/poshmark/ui/fragments/MySizePickerFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f09003c

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getColor(I)I

    move-result v2

    invoke-virtual {v1, v2}, Lcom/poshmark/ui/customviews/PMTextView;->setTextColor(I)V

    .line 174
    iget-object v1, p0, Lcom/poshmark/ui/fragments/MySizePickerFragment$3;->this$0:Lcom/poshmark/ui/fragments/MySizePickerFragment;

    iget-object v1, v1, Lcom/poshmark/ui/fragments/MySizePickerFragment;->mySizeToggleButton:Lcom/poshmark/ui/customviews/PMTextView;

    invoke-virtual {v1, v4, v5}, Lcom/poshmark/ui/customviews/PMTextView;->setTypeface(Landroid/graphics/Typeface;I)V

    .line 175
    iget-object v1, p0, Lcom/poshmark/ui/fragments/MySizePickerFragment$3;->this$0:Lcom/poshmark/ui/fragments/MySizePickerFragment;

    iget-object v1, v1, Lcom/poshmark/ui/fragments/MySizePickerFragment;->mySizeToggleButton:Lcom/poshmark/ui/customviews/PMTextView;

    iget-object v2, p0, Lcom/poshmark/ui/fragments/MySizePickerFragment$3;->this$0:Lcom/poshmark/ui/fragments/MySizePickerFragment;

    invoke-virtual {v2}, Lcom/poshmark/ui/fragments/MySizePickerFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f02007e

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v2

    invoke-virtual {v1, v4, v4, v2, v4}, Lcom/poshmark/ui/customviews/PMTextView;->setCompoundDrawablesWithIntrinsicBounds(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V

    goto :goto_0
.end method

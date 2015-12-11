.class public Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;
.super Ljava/lang/Object;
.source "ListingEditorViewHolder.java"


# instance fields
.field public availabilityEditText:Lcom/poshmark/ui/customviews/LabelledEditText;

.field public availabilitySectionLayout:Landroid/widget/LinearLayout;

.field public brandEditText:Lcom/poshmark/ui/customviews/LabelledEditText;

.field public categoryEditText:Lcom/poshmark/ui/customviews/LabelledEditText;

.field public colorDummyEditText:Lcom/poshmark/ui/customviews/LabelledEditText;

.field public colorsContainer:Lcom/poshmark/ui/customviews/ColorSelectionView;

.field public deleteButton:Lcom/poshmark/ui/customviews/PMButton;

.field public deleteButtonSectionLayout:Landroid/widget/LinearLayout;

.field public descriptionEditText:Landroid/widget/EditText;

.field public earningsTextView:Landroid/widget/TextView;

.field public imageList:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;",
            ">;"
        }
    .end annotation
.end field

.field public listingPriceEditText:Lcom/poshmark/ui/customviews/LabelledEditText;

.field public nwtEditText:Lcom/poshmark/ui/customviews/LabelledEditText;

.field public originalPriceEditText:Lcom/poshmark/ui/customviews/LabelledEditText;

.field public picturesSelectorLayout:Landroid/widget/LinearLayout;

.field public sizeEditText:Lcom/poshmark/ui/customviews/LabelledEditText;

.field public titleEditText:Landroid/widget/EditText;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 17
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 19
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;->imageList:Ljava/util/List;

    return-void
.end method

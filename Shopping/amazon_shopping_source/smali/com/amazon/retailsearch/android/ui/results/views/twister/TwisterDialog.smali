.class public Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterDialog;
.super Landroid/app/Dialog;
.source "TwisterDialog.java"


# instance fields
.field private mClose:Landroid/widget/ImageView;

.field private mHeaderTitle:Landroid/widget/TextView;

.field private mTwisterList:Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterListView;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 36
    sget v0, Lcom/amazon/retailsearch/R$style;->Rs_Twister_Dialog:I

    invoke-direct {p0, p1, v0}, Landroid/app/Dialog;-><init>(Landroid/content/Context;I)V

    .line 37
    sget v0, Lcom/amazon/retailsearch/R$layout;->rs_twister_menu:I

    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterDialog;->setContentView(I)V

    .line 38
    sget v0, Lcom/amazon/retailsearch/R$id;->rs_twister_menu_header_title:I

    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterDialog;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterDialog;->mHeaderTitle:Landroid/widget/TextView;

    .line 39
    sget v0, Lcom/amazon/retailsearch/R$id;->rs_twister_menu_close:I

    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterDialog;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterDialog;->mClose:Landroid/widget/ImageView;

    .line 40
    sget v0, Lcom/amazon/retailsearch/R$id;->rs_twister_menu_list:I

    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterDialog;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterListView;

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterDialog;->mTwisterList:Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterListView;

    .line 41
    return-void
.end method


# virtual methods
.method public init(Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterModel;)V
    .locals 2
    .param p1, "twisterModel"    # Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterModel;

    .prologue
    .line 49
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterDialog;->getWindow()Landroid/view/Window;

    move-result-object v0

    const v1, 0x106000d

    invoke-virtual {v0, v1}, Landroid/view/Window;->setBackgroundDrawableResource(I)V

    .line 50
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterDialog;->mHeaderTitle:Landroid/widget/TextView;

    invoke-virtual {p1}, Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterModel;->getProductTitle()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 51
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterDialog;->mTwisterList:Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterListView;

    invoke-virtual {p1}, Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterModel;->getEditions()[Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterModel$Edition;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterListView;->setEditions([Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterModel$Edition;)V

    .line 52
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterDialog;->mTwisterList:Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterListView;

    invoke-virtual {v0, p0}, Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterListView;->setTwisterDialog(Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterDialog;)V

    .line 53
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterDialog;->mClose:Landroid/widget/ImageView;

    new-instance v1, Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterDialog$1;

    invoke-direct {v1, p0}, Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterDialog$1;-><init>(Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterDialog;)V

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 59
    return-void
.end method

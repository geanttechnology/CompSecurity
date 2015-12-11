.class public Lcom/poshmark/ui/fragments/GestureTester_II;
.super Lcom/poshmark/ui/fragments/PMFragment;
.source "GestureTester_II.java"


# instance fields
.field crop:Lcom/poshmark/ui/customviews/PMButton;

.field croppable_space:Landroid/widget/LinearLayout;

.field croppable_view:Lcom/poshmark/ui/customviews/GestureView;

.field cropped_image:Landroid/widget/ImageView;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 17
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/PMFragment;-><init>()V

    return-void
.end method


# virtual methods
.method public onCreate(Landroid/os/Bundle;)V
    .locals 0
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 25
    invoke-super {p0, p1}, Lcom/poshmark/ui/fragments/PMFragment;->onCreate(Landroid/os/Bundle;)V

    .line 26
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 3
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 30
    invoke-super {p0, p1, p2, p3}, Lcom/poshmark/ui/fragments/PMFragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;

    .line 31
    const v1, 0x7f030056

    const/4 v2, 0x0

    invoke-virtual {p1, v1, p2, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    .line 32
    .local v0, "v":Landroid/view/View;
    const v1, 0x7f0c015a

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/LinearLayout;

    iput-object v1, p0, Lcom/poshmark/ui/fragments/GestureTester_II;->croppable_space:Landroid/widget/LinearLayout;

    .line 33
    const v1, 0x7f0c0159

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/poshmark/ui/customviews/GestureView;

    iput-object v1, p0, Lcom/poshmark/ui/fragments/GestureTester_II;->croppable_view:Lcom/poshmark/ui/customviews/GestureView;

    .line 34
    const v1, 0x7f0c015c

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/ImageView;

    iput-object v1, p0, Lcom/poshmark/ui/fragments/GestureTester_II;->cropped_image:Landroid/widget/ImageView;

    .line 35
    const v1, 0x7f0c00eb

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/poshmark/ui/customviews/PMButton;

    iput-object v1, p0, Lcom/poshmark/ui/fragments/GestureTester_II;->crop:Lcom/poshmark/ui/customviews/PMButton;

    .line 36
    return-object v0
.end method

.method public setViewNameForAnalytics()V
    .locals 0

    .prologue
    .line 45
    return-void
.end method

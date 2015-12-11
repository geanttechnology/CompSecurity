.class public Lcom/poshmark/ui/fragments/GestureTester;
.super Lcom/poshmark/ui/fragments/PMFragment;
.source "GestureTester.java"


# instance fields
.field private CREATION_MODE:I

.field private cancelButton:Landroid/widget/Button;

.field croppable_space:Lcom/poshmark/ui/customviews/CameraViewportRectView;

.field croppable_view:Lcom/poshmark/ui/customviews/GestureView;

.field cropped_image:Landroid/widget/ImageView;

.field private doneButton:Landroid/widget/Button;

.field private fileName:Ljava/lang/String;

.field isNextClicked:Z


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 20
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/PMFragment;-><init>()V

    .line 32
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/poshmark/ui/fragments/GestureTester;->isNextClicked:Z

    return-void
.end method


# virtual methods
.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 68
    invoke-super {p0, p1}, Lcom/poshmark/ui/fragments/PMFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 69
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/GestureTester;->getView()Landroid/view/View;

    move-result-object v0

    const v1, 0x7f0c00eb

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    iput-object v0, p0, Lcom/poshmark/ui/fragments/GestureTester;->doneButton:Landroid/widget/Button;

    .line 70
    iget-object v0, p0, Lcom/poshmark/ui/fragments/GestureTester;->doneButton:Landroid/widget/Button;

    new-instance v1, Lcom/poshmark/ui/fragments/GestureTester$2;

    invoke-direct {v1, p0}, Lcom/poshmark/ui/fragments/GestureTester$2;-><init>(Lcom/poshmark/ui/fragments/GestureTester;)V

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 84
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/GestureTester;->getView()Landroid/view/View;

    move-result-object v0

    const v1, 0x7f0c0093

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    iput-object v0, p0, Lcom/poshmark/ui/fragments/GestureTester;->cancelButton:Landroid/widget/Button;

    .line 85
    iget-object v0, p0, Lcom/poshmark/ui/fragments/GestureTester;->cancelButton:Landroid/widget/Button;

    new-instance v1, Lcom/poshmark/ui/fragments/GestureTester$3;

    invoke-direct {v1, p0}, Lcom/poshmark/ui/fragments/GestureTester$3;-><init>(Lcom/poshmark/ui/fragments/GestureTester;)V

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 91
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 35
    invoke-super {p0, p1}, Lcom/poshmark/ui/fragments/PMFragment;->onCreate(Landroid/os/Bundle;)V

    .line 36
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/GestureTester;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    .line 37
    .local v0, "b":Landroid/os/Bundle;
    const/4 v1, 0x1

    iput-boolean v1, p0, Lcom/poshmark/ui/fragments/GestureTester;->bShouldHideActionBar:Z

    .line 38
    if-eqz v0, :cond_0

    .line 39
    const-string v1, "FILE"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/poshmark/ui/fragments/GestureTester;->fileName:Ljava/lang/String;

    .line 40
    const-string v1, "CREATION_MODE"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v1

    iput v1, p0, Lcom/poshmark/ui/fragments/GestureTester;->CREATION_MODE:I

    .line 43
    :cond_0
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 4
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 47
    invoke-super {p0, p1, p2, p3}, Lcom/poshmark/ui/fragments/PMFragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;

    .line 48
    const v2, 0x7f030055

    const/4 v3, 0x0

    invoke-virtual {p1, v2, p2, v3}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v1

    .line 49
    .local v1, "v":Landroid/view/View;
    const v2, 0x7f0c015a

    invoke-virtual {v1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Lcom/poshmark/ui/customviews/CameraViewportRectView;

    iput-object v2, p0, Lcom/poshmark/ui/fragments/GestureTester;->croppable_space:Lcom/poshmark/ui/customviews/CameraViewportRectView;

    .line 50
    const v2, 0x7f0c0159

    invoke-virtual {v1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Lcom/poshmark/ui/customviews/GestureView;

    iput-object v2, p0, Lcom/poshmark/ui/fragments/GestureTester;->croppable_view:Lcom/poshmark/ui/customviews/GestureView;

    .line 51
    const v2, 0x7f0c015c

    invoke-virtual {v1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/ImageView;

    iput-object v2, p0, Lcom/poshmark/ui/fragments/GestureTester;->cropped_image:Landroid/widget/ImageView;

    .line 52
    iget-object v2, p0, Lcom/poshmark/ui/fragments/GestureTester;->croppable_view:Lcom/poshmark/ui/customviews/GestureView;

    iget-object v3, p0, Lcom/poshmark/ui/fragments/GestureTester;->fileName:Ljava/lang/String;

    invoke-virtual {v2, v3}, Lcom/poshmark/ui/customviews/GestureView;->setFileName(Ljava/lang/String;)V

    .line 53
    iget-object v2, p0, Lcom/poshmark/ui/fragments/GestureTester;->croppable_view:Lcom/poshmark/ui/customviews/GestureView;

    iget v3, p0, Lcom/poshmark/ui/fragments/GestureTester;->CREATION_MODE:I

    invoke-virtual {v2, v3}, Lcom/poshmark/ui/customviews/GestureView;->setMode(I)V

    .line 54
    new-instance v0, Lcom/poshmark/ui/fragments/GestureTester$1;

    invoke-direct {v0, p0}, Lcom/poshmark/ui/fragments/GestureTester$1;-><init>(Lcom/poshmark/ui/fragments/GestureTester;)V

    .line 62
    .local v0, "customListener":Lcom/poshmark/ui/customviews/CameraViewportRectView$CustomListener;
    iget-object v2, p0, Lcom/poshmark/ui/fragments/GestureTester;->croppable_space:Lcom/poshmark/ui/customviews/CameraViewportRectView;

    invoke-virtual {v2, v0}, Lcom/poshmark/ui/customviews/CameraViewportRectView;->setCustomListerner(Lcom/poshmark/ui/customviews/CameraViewportRectView$CustomListener;)V

    .line 63
    return-object v1
.end method

.method public onResume()V
    .locals 2

    .prologue
    const/16 v1, 0x400

    .line 95
    invoke-super {p0}, Lcom/poshmark/ui/fragments/PMFragment;->onResume()V

    .line 96
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/GestureTester;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->getWindow()Landroid/view/Window;

    move-result-object v0

    invoke-virtual {v0, v1, v1}, Landroid/view/Window;->setFlags(II)V

    .line 97
    return-void
.end method

.method public setViewNameForAnalytics()V
    .locals 1

    .prologue
    .line 100
    const-string v0, "crop_image_screen"

    iput-object v0, p0, Lcom/poshmark/ui/fragments/GestureTester;->viewNameForAnalytics:Ljava/lang/String;

    .line 101
    return-void
.end method

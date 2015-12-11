.class public Lcom/poshmark/ui/fragments/CropImageFragment;
.super Lcom/poshmark/ui/fragments/PMFragment;
.source "CropImageFragment.java"


# instance fields
.field private CREATION_MODE:I

.field private cancelButton:Landroid/widget/Button;

.field private cropImageSurfaceView:Lcom/poshmark/ui/customviews/CropImageSurfaceView;

.field private doneButton:Landroid/widget/Button;

.field private fileName:Ljava/lang/String;

.field isNextClicked:Z

.field private viewportOverlay:Lcom/poshmark/ui/customviews/CameraViewportRectView;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 19
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/PMFragment;-><init>()V

    .line 29
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/poshmark/ui/fragments/CropImageFragment;->isNextClicked:Z

    return-void
.end method

.method static synthetic access$000(Lcom/poshmark/ui/fragments/CropImageFragment;)Lcom/poshmark/ui/customviews/CameraViewportRectView;
    .locals 1
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/CropImageFragment;

    .prologue
    .line 19
    iget-object v0, p0, Lcom/poshmark/ui/fragments/CropImageFragment;->viewportOverlay:Lcom/poshmark/ui/customviews/CameraViewportRectView;

    return-object v0
.end method

.method static synthetic access$100(Lcom/poshmark/ui/fragments/CropImageFragment;)Lcom/poshmark/ui/customviews/CropImageSurfaceView;
    .locals 1
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/CropImageFragment;

    .prologue
    .line 19
    iget-object v0, p0, Lcom/poshmark/ui/fragments/CropImageFragment;->cropImageSurfaceView:Lcom/poshmark/ui/customviews/CropImageSurfaceView;

    return-object v0
.end method


# virtual methods
.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 52
    invoke-super {p0, p1}, Lcom/poshmark/ui/fragments/PMFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 53
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/CropImageFragment;->getView()Landroid/view/View;

    move-result-object v0

    const v1, 0x7f0c0090

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/customviews/CameraViewportRectView;

    iput-object v0, p0, Lcom/poshmark/ui/fragments/CropImageFragment;->viewportOverlay:Lcom/poshmark/ui/customviews/CameraViewportRectView;

    .line 54
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/CropImageFragment;->getView()Landroid/view/View;

    move-result-object v0

    const v1, 0x7f0c00ea

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/customviews/CropImageSurfaceView;

    iput-object v0, p0, Lcom/poshmark/ui/fragments/CropImageFragment;->cropImageSurfaceView:Lcom/poshmark/ui/customviews/CropImageSurfaceView;

    .line 55
    iget-object v0, p0, Lcom/poshmark/ui/fragments/CropImageFragment;->cropImageSurfaceView:Lcom/poshmark/ui/customviews/CropImageSurfaceView;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/CropImageFragment;->fileName:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/customviews/CropImageSurfaceView;->setFile(Ljava/lang/String;)V

    .line 56
    iget-object v0, p0, Lcom/poshmark/ui/fragments/CropImageFragment;->cropImageSurfaceView:Lcom/poshmark/ui/customviews/CropImageSurfaceView;

    iget v1, p0, Lcom/poshmark/ui/fragments/CropImageFragment;->CREATION_MODE:I

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/customviews/CropImageSurfaceView;->setMode(I)V

    .line 57
    iget-object v0, p0, Lcom/poshmark/ui/fragments/CropImageFragment;->cropImageSurfaceView:Lcom/poshmark/ui/customviews/CropImageSurfaceView;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/CropImageFragment;->viewportOverlay:Lcom/poshmark/ui/customviews/CameraViewportRectView;

    invoke-virtual {v1}, Lcom/poshmark/ui/customviews/CameraViewportRectView;->getViewportRect()Landroid/graphics/Rect;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/customviews/CropImageSurfaceView;->setViewPortRect(Landroid/graphics/Rect;)V

    .line 59
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/CropImageFragment;->getView()Landroid/view/View;

    move-result-object v0

    const v1, 0x7f0c00eb

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    iput-object v0, p0, Lcom/poshmark/ui/fragments/CropImageFragment;->doneButton:Landroid/widget/Button;

    .line 60
    iget-object v0, p0, Lcom/poshmark/ui/fragments/CropImageFragment;->doneButton:Landroid/widget/Button;

    new-instance v1, Lcom/poshmark/ui/fragments/CropImageFragment$1;

    invoke-direct {v1, p0}, Lcom/poshmark/ui/fragments/CropImageFragment$1;-><init>(Lcom/poshmark/ui/fragments/CropImageFragment;)V

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 74
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/CropImageFragment;->getView()Landroid/view/View;

    move-result-object v0

    const v1, 0x7f0c0093

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    iput-object v0, p0, Lcom/poshmark/ui/fragments/CropImageFragment;->cancelButton:Landroid/widget/Button;

    .line 75
    iget-object v0, p0, Lcom/poshmark/ui/fragments/CropImageFragment;->cancelButton:Landroid/widget/Button;

    new-instance v1, Lcom/poshmark/ui/fragments/CropImageFragment$2;

    invoke-direct {v1, p0}, Lcom/poshmark/ui/fragments/CropImageFragment$2;-><init>(Lcom/poshmark/ui/fragments/CropImageFragment;)V

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 81
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 33
    invoke-super {p0, p1}, Lcom/poshmark/ui/fragments/PMFragment;->onCreate(Landroid/os/Bundle;)V

    .line 34
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/CropImageFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    .line 35
    .local v0, "b":Landroid/os/Bundle;
    const/4 v1, 0x1

    iput-boolean v1, p0, Lcom/poshmark/ui/fragments/CropImageFragment;->bShouldHideActionBar:Z

    .line 36
    if-eqz v0, :cond_0

    .line 37
    const-string v1, "FILE"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/poshmark/ui/fragments/CropImageFragment;->fileName:Ljava/lang/String;

    .line 38
    const-string v1, "CREATION_MODE"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v1

    iput v1, p0, Lcom/poshmark/ui/fragments/CropImageFragment;->CREATION_MODE:I

    .line 41
    :cond_0
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 3
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 45
    invoke-super {p0, p1, p2, p3}, Lcom/poshmark/ui/fragments/PMFragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;

    .line 46
    const v1, 0x7f030035

    const/4 v2, 0x0

    invoke-virtual {p1, v1, p2, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    .line 47
    .local v0, "v":Landroid/view/View;
    return-object v0
.end method

.method public onResume()V
    .locals 2

    .prologue
    const/16 v1, 0x400

    .line 85
    invoke-super {p0}, Lcom/poshmark/ui/fragments/PMFragment;->onResume()V

    .line 86
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/CropImageFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->getWindow()Landroid/view/Window;

    move-result-object v0

    invoke-virtual {v0, v1, v1}, Landroid/view/Window;->setFlags(II)V

    .line 87
    return-void
.end method

.method public setViewNameForAnalytics()V
    .locals 1

    .prologue
    .line 90
    const-string v0, "crop_image_screen"

    iput-object v0, p0, Lcom/poshmark/ui/fragments/CropImageFragment;->viewNameForAnalytics:Ljava/lang/String;

    .line 91
    return-void
.end method

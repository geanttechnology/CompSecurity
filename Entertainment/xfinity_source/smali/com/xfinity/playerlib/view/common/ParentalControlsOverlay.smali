.class public Lcom/xfinity/playerlib/view/common/ParentalControlsOverlay;
.super Lcom/xfinity/playerlib/view/common/OverlayFragment;
.source "ParentalControlsOverlay.java"


# instance fields
.field private final userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 13
    invoke-direct {p0}, Lcom/xfinity/playerlib/view/common/OverlayFragment;-><init>()V

    .line 16
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getUserManager()Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/common/ParentalControlsOverlay;->userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    return-void
.end method

.method static synthetic access$000(Lcom/xfinity/playerlib/view/common/ParentalControlsOverlay;)Lcom/xfinity/playerlib/model/user/PlayNowUserManager;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/common/ParentalControlsOverlay;

    .prologue
    .line 13
    iget-object v0, p0, Lcom/xfinity/playerlib/view/common/ParentalControlsOverlay;->userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    return-object v0
.end method


# virtual methods
.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 5
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 20
    sget v3, Lcom/xfinity/playerlib/R$layout;->parental_controls_message_overlay:I

    const/4 v4, 0x0

    invoke-virtual {p1, v3, p2, v4}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v2

    .line 21
    .local v2, "view":Landroid/view/View;
    sget v3, Lcom/xfinity/playerlib/R$id;->overlay_parental_controls_go_to_button:I

    invoke-virtual {v2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    .line 22
    .local v1, "gotToButton":Landroid/view/View;
    sget v3, Lcom/xfinity/playerlib/R$id;->overlay_parental_controls_do_not_show_again_button:I

    invoke-virtual {v2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    .line 24
    .local v0, "doNotShowAgainButton":Landroid/view/View;
    new-instance v3, Lcom/xfinity/playerlib/view/common/ParentalControlsOverlay$1;

    invoke-direct {v3, p0}, Lcom/xfinity/playerlib/view/common/ParentalControlsOverlay$1;-><init>(Lcom/xfinity/playerlib/view/common/ParentalControlsOverlay;)V

    invoke-virtual {v1, v3}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 37
    new-instance v3, Lcom/xfinity/playerlib/view/common/ParentalControlsOverlay$2;

    invoke-direct {v3, p0}, Lcom/xfinity/playerlib/view/common/ParentalControlsOverlay$2;-><init>(Lcom/xfinity/playerlib/view/common/ParentalControlsOverlay;)V

    invoke-virtual {v0, v3}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 46
    return-object v2
.end method

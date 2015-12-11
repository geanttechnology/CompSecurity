.class public Lcom/poshmark/ui/customviews/PMAvataarImageView;
.super Lcom/poshmark/ui/customviews/PMImageView;
.source "PMAvataarImageView.java"


# instance fields
.field isImageSet:Z

.field userId:Ljava/lang/String;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 16
    invoke-direct {p0, p1}, Lcom/poshmark/ui/customviews/PMImageView;-><init>(Landroid/content/Context;)V

    .line 12
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/poshmark/ui/customviews/PMAvataarImageView;->userId:Ljava/lang/String;

    .line 13
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/poshmark/ui/customviews/PMAvataarImageView;->isImageSet:Z

    .line 18
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 21
    invoke-direct {p0, p1, p2}, Lcom/poshmark/ui/customviews/PMImageView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 12
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/poshmark/ui/customviews/PMAvataarImageView;->userId:Ljava/lang/String;

    .line 13
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/poshmark/ui/customviews/PMAvataarImageView;->isImageSet:Z

    .line 23
    return-void
.end method


# virtual methods
.method public launchFragmentOnClick()V
    .locals 4

    .prologue
    .line 31
    iget-object v2, p0, Lcom/poshmark/ui/customviews/PMAvataarImageView;->userId:Ljava/lang/String;

    if-eqz v2, :cond_0

    .line 32
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 33
    .local v0, "b":Landroid/os/Bundle;
    const-string v2, "NAME"

    iget-object v3, p0, Lcom/poshmark/ui/customviews/PMAvataarImageView;->userId:Ljava/lang/String;

    invoke-virtual {v0, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 34
    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/PMAvataarImageView;->getContext()Landroid/content/Context;

    move-result-object v1

    check-cast v1, Lcom/poshmark/ui/PMActivity;

    .line 35
    .local v1, "parentActivity":Lcom/poshmark/ui/PMActivity;
    if-eqz v1, :cond_0

    invoke-virtual {v1}, Lcom/poshmark/ui/PMActivity;->isActivityInForeground()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 36
    const-class v2, Lcom/poshmark/ui/fragments/ClosetFragment;

    const/4 v3, 0x0

    invoke-virtual {v1, v0, v2, v3}, Lcom/poshmark/ui/PMActivity;->launchFragment(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;)V

    .line 40
    .end local v0    # "b":Landroid/os/Bundle;
    .end local v1    # "parentActivity":Lcom/poshmark/ui/PMActivity;
    :cond_0
    return-void
.end method

.method public loadImage(Ljava/lang/String;)V
    .locals 1
    .param p1, "url"    # Ljava/lang/String;

    .prologue
    .line 49
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/poshmark/ui/customviews/PMAvataarImageView;->isImageSet:Z

    .line 50
    invoke-super {p0, p1}, Lcom/poshmark/ui/customviews/PMImageView;->loadImage(Ljava/lang/String;)V

    .line 51
    return-void
.end method

.method protected onSizeChanged(IIII)V
    .locals 0
    .param p1, "w"    # I
    .param p2, "h"    # I
    .param p3, "oldw"    # I
    .param p4, "oldh"    # I

    .prologue
    .line 56
    return-void
.end method

.method public requestLayout()V
    .locals 1

    .prologue
    .line 60
    iget-boolean v0, p0, Lcom/poshmark/ui/customviews/PMAvataarImageView;->isImageSet:Z

    if-nez v0, :cond_0

    invoke-super {p0}, Lcom/poshmark/ui/customviews/PMImageView;->requestLayout()V

    .line 61
    :cond_0
    return-void
.end method

.method public setCustomOnClickListener(Lcom/poshmark/ui/customviews/PMImageViewOnClickListener;)V
    .locals 0
    .param p1, "listener"    # Lcom/poshmark/ui/customviews/PMImageViewOnClickListener;

    .prologue
    .line 45
    return-void
.end method

.method public setUser(Ljava/lang/String;)V
    .locals 0
    .param p1, "userId"    # Ljava/lang/String;

    .prologue
    .line 26
    iput-object p1, p0, Lcom/poshmark/ui/customviews/PMAvataarImageView;->userId:Ljava/lang/String;

    .line 27
    return-void
.end method

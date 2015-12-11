.class public abstract Lcom/xfinity/playerlib/view/common/OverlayFragment;
.super Landroid/app/Fragment;
.source "OverlayFragment.java"


# instance fields
.field private overlayDismissedListener:Lcom/xfinity/playerlib/view/common/OverlayDismissedListener;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 18
    invoke-direct {p0}, Landroid/app/Fragment;-><init>()V

    return-void
.end method


# virtual methods
.method protected dismissOverlay(Ljava/lang/String;)V
    .locals 1
    .param p1, "tag"    # Ljava/lang/String;

    .prologue
    .line 27
    iget-object v0, p0, Lcom/xfinity/playerlib/view/common/OverlayFragment;->overlayDismissedListener:Lcom/xfinity/playerlib/view/common/OverlayDismissedListener;

    invoke-interface {v0, p1}, Lcom/xfinity/playerlib/view/common/OverlayDismissedListener;->onOverlayDismissed(Ljava/lang/String;)V

    .line 28
    return-void
.end method

.method public onAttach(Landroid/app/Activity;)V
    .locals 0
    .param p1, "activity"    # Landroid/app/Activity;

    .prologue
    .line 22
    invoke-super {p0, p1}, Landroid/app/Fragment;->onAttach(Landroid/app/Activity;)V

    .line 23
    check-cast p1, Lcom/xfinity/playerlib/view/common/OverlayDismissedListener;

    .end local p1    # "activity":Landroid/app/Activity;
    iput-object p1, p0, Lcom/xfinity/playerlib/view/common/OverlayFragment;->overlayDismissedListener:Lcom/xfinity/playerlib/view/common/OverlayDismissedListener;

    .line 24
    return-void
.end method

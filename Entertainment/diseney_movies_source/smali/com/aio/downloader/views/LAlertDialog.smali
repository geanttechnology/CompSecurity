.class public Lcom/aio/downloader/views/LAlertDialog;
.super Landroid/app/Dialog;
.source "LAlertDialog.java"

# interfaces
.implements Landroid/content/DialogInterface;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/aio/downloader/views/LAlertDialog$Builder;,
        Lcom/aio/downloader/views/LAlertDialog$VisibleCallback;
    }
.end annotation


# static fields
.field private static final default_theme:I


# instance fields
.field private control:Lcom/aio/downloader/views/LDialogController;


# direct methods
.method protected constructor <init>(Landroid/content/Context;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 24
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lcom/aio/downloader/views/LAlertDialog;-><init>(Landroid/content/Context;I)V

    .line 25
    invoke-virtual {p0}, Lcom/aio/downloader/views/LAlertDialog;->getWindow()Landroid/view/Window;

    move-result-object v0

    .line 26
    const v1, 0x7f020145

    .line 25
    invoke-virtual {v0, v1}, Landroid/view/Window;->setBackgroundDrawableResource(I)V

    .line 27
    return-void
.end method

.method protected constructor <init>(Landroid/content/Context;I)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "theme"    # I

    .prologue
    .line 30
    invoke-direct {p0, p1, p2}, Landroid/app/Dialog;-><init>(Landroid/content/Context;I)V

    .line 31
    new-instance v0, Lcom/aio/downloader/views/LDialogController;

    invoke-virtual {p0}, Lcom/aio/downloader/views/LAlertDialog;->getWindow()Landroid/view/Window;

    move-result-object v1

    invoke-direct {v0, p1, p0, v1}, Lcom/aio/downloader/views/LDialogController;-><init>(Landroid/content/Context;Landroid/content/DialogInterface;Landroid/view/Window;)V

    iput-object v0, p0, Lcom/aio/downloader/views/LAlertDialog;->control:Lcom/aio/downloader/views/LDialogController;

    .line 32
    return-void
.end method

.method protected constructor <init>(Landroid/content/Context;ZLandroid/content/DialogInterface$OnCancelListener;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "cancelable"    # Z
    .param p3, "cancelListener"    # Landroid/content/DialogInterface$OnCancelListener;

    .prologue
    .line 36
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Landroid/app/Dialog;-><init>(Landroid/content/Context;I)V

    .line 37
    invoke-virtual {p0, p2}, Lcom/aio/downloader/views/LAlertDialog;->setCancelable(Z)V

    .line 38
    invoke-virtual {p0, p3}, Lcom/aio/downloader/views/LAlertDialog;->setOnCancelListener(Landroid/content/DialogInterface$OnCancelListener;)V

    .line 39
    new-instance v0, Lcom/aio/downloader/views/LDialogController;

    invoke-virtual {p0}, Lcom/aio/downloader/views/LAlertDialog;->getWindow()Landroid/view/Window;

    move-result-object v1

    invoke-direct {v0, p1, p0, v1}, Lcom/aio/downloader/views/LDialogController;-><init>(Landroid/content/Context;Landroid/content/DialogInterface;Landroid/view/Window;)V

    iput-object v0, p0, Lcom/aio/downloader/views/LAlertDialog;->control:Lcom/aio/downloader/views/LDialogController;

    .line 40
    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/views/LAlertDialog;)Lcom/aio/downloader/views/LDialogController;
    .locals 1

    .prologue
    .line 18
    iget-object v0, p0, Lcom/aio/downloader/views/LAlertDialog;->control:Lcom/aio/downloader/views/LDialogController;

    return-object v0
.end method


# virtual methods
.method public getController()Lcom/aio/downloader/views/LDialogController;
    .locals 1

    .prologue
    .line 47
    iget-object v0, p0, Lcom/aio/downloader/views/LAlertDialog;->control:Lcom/aio/downloader/views/LDialogController;

    return-object v0
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 1
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 52
    invoke-super {p0, p1}, Landroid/app/Dialog;->onCreate(Landroid/os/Bundle;)V

    .line 53
    iget-object v0, p0, Lcom/aio/downloader/views/LAlertDialog;->control:Lcom/aio/downloader/views/LDialogController;

    invoke-virtual {v0}, Lcom/aio/downloader/views/LDialogController;->installContent()V

    .line 54
    return-void
.end method

.method public setPositiveButtonEnable(Z)V
    .locals 1
    .param p1, "enable"    # Z

    .prologue
    .line 43
    iget-object v0, p0, Lcom/aio/downloader/views/LAlertDialog;->control:Lcom/aio/downloader/views/LDialogController;

    invoke-virtual {v0, p1}, Lcom/aio/downloader/views/LDialogController;->setPositiveButtonEnable(Z)V

    .line 44
    return-void
.end method

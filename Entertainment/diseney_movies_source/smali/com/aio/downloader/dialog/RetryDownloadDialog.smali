.class public Lcom/aio/downloader/dialog/RetryDownloadDialog;
.super Landroid/app/Dialog;
.source "RetryDownloadDialog.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/aio/downloader/dialog/RetryDownloadDialog$OnCustomDialogListener;
    }
.end annotation


# instance fields
.field private ctx:Landroid/content/Context;


# direct methods
.method public constructor <init>(Landroid/content/Context;I)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "customdialog"    # I

    .prologue
    .line 26
    invoke-direct {p0, p1, p2}, Landroid/app/Dialog;-><init>(Landroid/content/Context;I)V

    .line 27
    iput-object p1, p0, Lcom/aio/downloader/dialog/RetryDownloadDialog;->ctx:Landroid/content/Context;

    .line 28
    return-void
.end method


# virtual methods
.method protected onCreate(Landroid/os/Bundle;)V
    .locals 1
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 32
    invoke-super {p0, p1}, Landroid/app/Dialog;->onCreate(Landroid/os/Bundle;)V

    .line 33
    const v0, 0x7f0300a7

    invoke-virtual {p0, v0}, Lcom/aio/downloader/dialog/RetryDownloadDialog;->setContentView(I)V

    .line 34
    return-void
.end method

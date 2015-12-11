.class public Lcom/aio/downloader/dialog/CleanertoolboxDialog;
.super Landroid/app/Dialog;
.source "CleanertoolboxDialog.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/aio/downloader/dialog/CleanertoolboxDialog$OnCustomDialogListener;
    }
.end annotation


# instance fields
.field private ctx:Landroid/content/Context;

.field private itemsOnClick:Landroid/view/View$OnClickListener;


# direct methods
.method public constructor <init>(Landroid/content/Context;ILandroid/view/View$OnClickListener;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "customdialog"    # I
    .param p3, "itemsOnClick"    # Landroid/view/View$OnClickListener;

    .prologue
    .line 20
    invoke-direct {p0, p1, p2}, Landroid/app/Dialog;-><init>(Landroid/content/Context;I)V

    .line 21
    iput-object p1, p0, Lcom/aio/downloader/dialog/CleanertoolboxDialog;->ctx:Landroid/content/Context;

    .line 22
    iput-object p3, p0, Lcom/aio/downloader/dialog/CleanertoolboxDialog;->itemsOnClick:Landroid/view/View$OnClickListener;

    .line 23
    return-void
.end method


# virtual methods
.method protected onCreate(Landroid/os/Bundle;)V
    .locals 1
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 28
    invoke-super {p0, p1}, Landroid/app/Dialog;->onCreate(Landroid/os/Bundle;)V

    .line 29
    const v0, 0x7f030026

    invoke-virtual {p0, v0}, Lcom/aio/downloader/dialog/CleanertoolboxDialog;->setContentView(I)V

    .line 30
    return-void
.end method

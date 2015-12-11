.class public Lcom/comcast/cim/android/view/common/CancellingClickListener;
.super Ljava/lang/Object;
.source "CancellingClickListener.java"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 5
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 0
    .param p1, "dialog"    # Landroid/content/DialogInterface;
    .param p2, "which"    # I

    .prologue
    .line 8
    invoke-interface {p1}, Landroid/content/DialogInterface;->cancel()V

    .line 9
    return-void
.end method

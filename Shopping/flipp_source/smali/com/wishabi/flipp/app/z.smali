.class public Lcom/wishabi/flipp/app/z;
.super Lcom/wishabi/flipp/app/dl;
.source "SourceFile"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 88
    invoke-direct {p0}, Lcom/wishabi/flipp/app/dl;-><init>()V

    return-void
.end method


# virtual methods
.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 93
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/z;->getActivity()Landroid/app/Activity;

    move-result-object v1

    .line 94
    if-nez v1, :cond_0

    .line 95
    const/4 v0, 0x0

    .line 107
    :goto_0
    return-object v0

    .line 98
    :cond_0
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/z;->a()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 99
    const v0, 0x7f030020

    invoke-virtual {p1, v0, p2, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    .line 105
    :goto_1
    const v2, 0x7f0e007e

    invoke-virtual {v1, v2}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v1}, Lcom/wishabi/flipp/app/z;->b(Ljava/lang/String;)V

    goto :goto_0

    .line 102
    :cond_1
    const v0, 0x7f03001f

    invoke-virtual {p1, v0, p2, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    goto :goto_1
.end method

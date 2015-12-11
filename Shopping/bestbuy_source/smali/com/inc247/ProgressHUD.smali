.class public Lcom/inc247/ProgressHUD;
.super Landroid/app/Dialog;
.source "SourceFile"


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 0

    .prologue
    .line 21
    invoke-direct {p0, p1}, Landroid/app/Dialog;-><init>(Landroid/content/Context;)V

    .line 22
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;I)V
    .locals 0

    .prologue
    .line 25
    invoke-direct {p0, p1, p2}, Landroid/app/Dialog;-><init>(Landroid/content/Context;I)V

    .line 26
    return-void
.end method

.method public static show(Landroid/content/Context;Ljava/lang/CharSequence;ZZ)Lcom/inc247/ProgressHUD;
    .locals 1

    .prologue
    .line 66
    const/4 v0, 0x0

    return-object v0
.end method


# virtual methods
.method public onWindowFocusChanged(Z)V
    .locals 0

    .prologue
    .line 35
    return-void
.end method

.method public setMessage(Ljava/lang/CharSequence;)V
    .locals 0

    .prologue
    .line 45
    return-void
.end method

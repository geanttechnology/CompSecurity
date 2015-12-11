.class public Lco/vine/android/service/PendingAction;
.super Ljava/lang/Object;
.source "PendingAction.java"


# instance fields
.field public final actionCode:I

.field public final bundle:Landroid/os/Bundle;


# direct methods
.method public constructor <init>(ILandroid/os/Bundle;)V
    .locals 2
    .param p1, "actionCode"    # I
    .param p2, "bundle"    # Landroid/os/Bundle;

    .prologue
    .line 9
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 10
    if-nez p2, :cond_0

    .line 11
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Bundle cannot be null."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 13
    :cond_0
    iput p1, p0, Lco/vine/android/service/PendingAction;->actionCode:I

    .line 14
    iput-object p2, p0, Lco/vine/android/service/PendingAction;->bundle:Landroid/os/Bundle;

    .line 15
    return-void
.end method

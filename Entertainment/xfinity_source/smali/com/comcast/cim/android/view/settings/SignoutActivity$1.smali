.class Lcom/comcast/cim/android/view/settings/SignoutActivity$1;
.super Landroid/app/AlertDialog;
.source "SignoutActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/comcast/cim/android/view/settings/SignoutActivity;->onCreate(Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/comcast/cim/android/view/settings/SignoutActivity;


# direct methods
.method constructor <init>(Lcom/comcast/cim/android/view/settings/SignoutActivity;Landroid/content/Context;)V
    .locals 0
    .param p1, "this$0"    # Lcom/comcast/cim/android/view/settings/SignoutActivity;
    .param p2, "x0"    # Landroid/content/Context;

    .prologue
    .line 26
    iput-object p1, p0, Lcom/comcast/cim/android/view/settings/SignoutActivity$1;->this$0:Lcom/comcast/cim/android/view/settings/SignoutActivity;

    invoke-direct {p0, p2}, Landroid/app/AlertDialog;-><init>(Landroid/content/Context;)V

    return-void
.end method


# virtual methods
.method public onSearchRequested()Z
    .locals 1

    .prologue
    .line 29
    const/4 v0, 0x0

    return v0
.end method

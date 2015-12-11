.class Lcom/comcast/cim/android/view/launch/LaunchActivity$1;
.super Landroid/app/AlertDialog;
.source "LaunchActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/comcast/cim/android/view/launch/LaunchActivity;->onCreate(Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/comcast/cim/android/view/launch/LaunchActivity;


# direct methods
.method constructor <init>(Lcom/comcast/cim/android/view/launch/LaunchActivity;Landroid/content/Context;)V
    .locals 0
    .param p1, "this$0"    # Lcom/comcast/cim/android/view/launch/LaunchActivity;
    .param p2, "x0"    # Landroid/content/Context;

    .prologue
    .line 49
    iput-object p1, p0, Lcom/comcast/cim/android/view/launch/LaunchActivity$1;->this$0:Lcom/comcast/cim/android/view/launch/LaunchActivity;

    invoke-direct {p0, p2}, Landroid/app/AlertDialog;-><init>(Landroid/content/Context;)V

    return-void
.end method


# virtual methods
.method public onSearchRequested()Z
    .locals 1

    .prologue
    .line 52
    const/4 v0, 0x0

    return v0
.end method

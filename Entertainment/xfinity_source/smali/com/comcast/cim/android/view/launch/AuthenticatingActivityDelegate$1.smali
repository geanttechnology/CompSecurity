.class Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate$1;
.super Landroid/app/AlertDialog;
.source "AuthenticatingActivityDelegate.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate;->checkForUserUpgrade()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate;


# direct methods
.method constructor <init>(Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate;Landroid/content/Context;)V
    .locals 0
    .param p1, "this$0"    # Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate;
    .param p2, "x0"    # Landroid/content/Context;

    .prologue
    .line 98
    iput-object p1, p0, Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate$1;->this$0:Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate;

    invoke-direct {p0, p2}, Landroid/app/AlertDialog;-><init>(Landroid/content/Context;)V

    return-void
.end method


# virtual methods
.method public onSearchRequested()Z
    .locals 1

    .prologue
    .line 101
    const/4 v0, 0x0

    return v0
.end method

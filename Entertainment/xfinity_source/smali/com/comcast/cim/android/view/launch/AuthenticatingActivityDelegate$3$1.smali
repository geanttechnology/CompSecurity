.class Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate$3$1;
.super Ljava/lang/Object;
.source "AuthenticatingActivityDelegate.java"

# interfaces
.implements Landroid/content/DialogInterface$OnDismissListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate$3;->onPostExecute(Ljava/lang/Integer;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate$3;


# direct methods
.method constructor <init>(Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate$3;)V
    .locals 0
    .param p1, "this$1"    # Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate$3;

    .prologue
    .line 131
    iput-object p1, p0, Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate$3$1;->this$1:Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate$3;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onDismiss(Landroid/content/DialogInterface;)V
    .locals 2
    .param p1, "dialogInterface"    # Landroid/content/DialogInterface;

    .prologue
    .line 134
    iget-object v0, p0, Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate$3$1;->this$1:Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate$3;

    iget-object v0, v0, Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate$3;->this$0:Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate;

    # getter for: Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate;->launchStrategy:Lcom/comcast/cim/android/view/launch/LaunchStrategy;
    invoke-static {v0}, Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate;->access$300(Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate;)Lcom/comcast/cim/android/view/launch/LaunchStrategy;

    move-result-object v0

    iget-object v1, p0, Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate$3$1;->this$1:Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate$3;

    iget-object v1, v1, Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate$3;->this$0:Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate;

    # getter for: Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate;->activity:Landroid/app/Activity;
    invoke-static {v1}, Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate;->access$000(Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate;)Landroid/app/Activity;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/comcast/cim/android/view/launch/LaunchStrategy;->exitApp(Landroid/app/Activity;)V

    .line 135
    return-void
.end method

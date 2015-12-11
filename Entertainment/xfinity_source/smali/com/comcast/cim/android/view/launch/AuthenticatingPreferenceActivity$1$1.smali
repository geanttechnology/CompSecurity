.class Lcom/comcast/cim/android/view/launch/AuthenticatingPreferenceActivity$1$1;
.super Ljava/lang/Object;
.source "AuthenticatingPreferenceActivity.java"

# interfaces
.implements Landroid/content/DialogInterface$OnCancelListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/comcast/cim/android/view/launch/AuthenticatingPreferenceActivity$1;->onPostExecute(Ljava/lang/Integer;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/comcast/cim/android/view/launch/AuthenticatingPreferenceActivity$1;


# direct methods
.method constructor <init>(Lcom/comcast/cim/android/view/launch/AuthenticatingPreferenceActivity$1;)V
    .locals 0
    .param p1, "this$1"    # Lcom/comcast/cim/android/view/launch/AuthenticatingPreferenceActivity$1;

    .prologue
    .line 116
    iput-object p1, p0, Lcom/comcast/cim/android/view/launch/AuthenticatingPreferenceActivity$1$1;->this$1:Lcom/comcast/cim/android/view/launch/AuthenticatingPreferenceActivity$1;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onCancel(Landroid/content/DialogInterface;)V
    .locals 2
    .param p1, "dialog"    # Landroid/content/DialogInterface;

    .prologue
    .line 119
    iget-object v0, p0, Lcom/comcast/cim/android/view/launch/AuthenticatingPreferenceActivity$1$1;->this$1:Lcom/comcast/cim/android/view/launch/AuthenticatingPreferenceActivity$1;

    iget-object v0, v0, Lcom/comcast/cim/android/view/launch/AuthenticatingPreferenceActivity$1;->this$0:Lcom/comcast/cim/android/view/launch/AuthenticatingPreferenceActivity;

    # getter for: Lcom/comcast/cim/android/view/launch/AuthenticatingPreferenceActivity;->launchStrategy:Lcom/comcast/cim/android/view/launch/LaunchStrategy;
    invoke-static {v0}, Lcom/comcast/cim/android/view/launch/AuthenticatingPreferenceActivity;->access$100(Lcom/comcast/cim/android/view/launch/AuthenticatingPreferenceActivity;)Lcom/comcast/cim/android/view/launch/LaunchStrategy;

    move-result-object v0

    iget-object v1, p0, Lcom/comcast/cim/android/view/launch/AuthenticatingPreferenceActivity$1$1;->this$1:Lcom/comcast/cim/android/view/launch/AuthenticatingPreferenceActivity$1;

    iget-object v1, v1, Lcom/comcast/cim/android/view/launch/AuthenticatingPreferenceActivity$1;->this$0:Lcom/comcast/cim/android/view/launch/AuthenticatingPreferenceActivity;

    invoke-virtual {v0, v1}, Lcom/comcast/cim/android/view/launch/LaunchStrategy;->exitApp(Landroid/app/Activity;)V

    .line 120
    return-void
.end method

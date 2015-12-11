.class Lcom/comcast/cim/android/authentication/AuthenticationActivity$4;
.super Ljava/lang/Object;
.source "AuthenticationActivity.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/comcast/cim/android/authentication/AuthenticationActivity;->prepForSignIn()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/comcast/cim/android/authentication/AuthenticationActivity;


# direct methods
.method constructor <init>(Lcom/comcast/cim/android/authentication/AuthenticationActivity;)V
    .locals 0
    .param p1, "this$0"    # Lcom/comcast/cim/android/authentication/AuthenticationActivity;

    .prologue
    .line 166
    .local p0, "this":Lcom/comcast/cim/android/authentication/AuthenticationActivity$4;, "Lcom/comcast/cim/android/authentication/AuthenticationActivity$4;"
    iput-object p1, p0, Lcom/comcast/cim/android/authentication/AuthenticationActivity$4;->this$0:Lcom/comcast/cim/android/authentication/AuthenticationActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 169
    .local p0, "this":Lcom/comcast/cim/android/authentication/AuthenticationActivity$4;, "Lcom/comcast/cim/android/authentication/AuthenticationActivity$4;"
    iget-object v0, p0, Lcom/comcast/cim/android/authentication/AuthenticationActivity$4;->this$0:Lcom/comcast/cim/android/authentication/AuthenticationActivity;

    # getter for: Lcom/comcast/cim/android/authentication/AuthenticationActivity;->viewFlipper:Landroid/widget/ViewFlipper;
    invoke-static {v0}, Lcom/comcast/cim/android/authentication/AuthenticationActivity;->access$200(Lcom/comcast/cim/android/authentication/AuthenticationActivity;)Landroid/widget/ViewFlipper;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 170
    iget-object v0, p0, Lcom/comcast/cim/android/authentication/AuthenticationActivity$4;->this$0:Lcom/comcast/cim/android/authentication/AuthenticationActivity;

    # getter for: Lcom/comcast/cim/android/authentication/AuthenticationActivity;->viewFlipper:Landroid/widget/ViewFlipper;
    invoke-static {v0}, Lcom/comcast/cim/android/authentication/AuthenticationActivity;->access$200(Lcom/comcast/cim/android/authentication/AuthenticationActivity;)Landroid/widget/ViewFlipper;

    move-result-object v0

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/widget/ViewFlipper;->setDisplayedChild(I)V

    .line 172
    :cond_0
    return-void
.end method

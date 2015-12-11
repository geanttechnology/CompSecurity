.class Lcom/comcast/cim/android/authentication/AuthenticationActivity$6;
.super Ljava/lang/Object;
.source "AuthenticationActivity.java"

# interfaces
.implements Landroid/content/DialogInterface$OnCancelListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/comcast/cim/android/authentication/AuthenticationActivity;->createSigninErrorCancelListener()Landroid/content/DialogInterface$OnCancelListener;
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
    .line 260
    .local p0, "this":Lcom/comcast/cim/android/authentication/AuthenticationActivity$6;, "Lcom/comcast/cim/android/authentication/AuthenticationActivity$6;"
    iput-object p1, p0, Lcom/comcast/cim/android/authentication/AuthenticationActivity$6;->this$0:Lcom/comcast/cim/android/authentication/AuthenticationActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onCancel(Landroid/content/DialogInterface;)V
    .locals 1
    .param p1, "dialog"    # Landroid/content/DialogInterface;

    .prologue
    .line 262
    .local p0, "this":Lcom/comcast/cim/android/authentication/AuthenticationActivity$6;, "Lcom/comcast/cim/android/authentication/AuthenticationActivity$6;"
    iget-object v0, p0, Lcom/comcast/cim/android/authentication/AuthenticationActivity$6;->this$0:Lcom/comcast/cim/android/authentication/AuthenticationActivity;

    invoke-virtual {v0}, Lcom/comcast/cim/android/authentication/AuthenticationActivity;->hideSigningInSpinner()V

    .line 263
    return-void
.end method

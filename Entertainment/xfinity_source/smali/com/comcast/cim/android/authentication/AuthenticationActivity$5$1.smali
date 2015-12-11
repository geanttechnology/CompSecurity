.class Lcom/comcast/cim/android/authentication/AuthenticationActivity$5$1;
.super Ljava/lang/Object;
.source "AuthenticationActivity.java"

# interfaces
.implements Landroid/content/DialogInterface$OnCancelListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/comcast/cim/android/authentication/AuthenticationActivity$5;->run()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/comcast/cim/android/authentication/AuthenticationActivity$5;


# direct methods
.method constructor <init>(Lcom/comcast/cim/android/authentication/AuthenticationActivity$5;)V
    .locals 0
    .param p1, "this$1"    # Lcom/comcast/cim/android/authentication/AuthenticationActivity$5;

    .prologue
    .line 222
    .local p0, "this":Lcom/comcast/cim/android/authentication/AuthenticationActivity$5$1;, "Lcom/comcast/cim/android/authentication/AuthenticationActivity$5$1;"
    iput-object p1, p0, Lcom/comcast/cim/android/authentication/AuthenticationActivity$5$1;->this$1:Lcom/comcast/cim/android/authentication/AuthenticationActivity$5;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onCancel(Landroid/content/DialogInterface;)V
    .locals 3
    .param p1, "dialog"    # Landroid/content/DialogInterface;

    .prologue
    .line 225
    .local p0, "this":Lcom/comcast/cim/android/authentication/AuthenticationActivity$5$1;, "Lcom/comcast/cim/android/authentication/AuthenticationActivity$5$1;"
    iget-object v0, p0, Lcom/comcast/cim/android/authentication/AuthenticationActivity$5$1;->this$1:Lcom/comcast/cim/android/authentication/AuthenticationActivity$5;

    iget-object v0, v0, Lcom/comcast/cim/android/authentication/AuthenticationActivity$5;->this$0:Lcom/comcast/cim/android/authentication/AuthenticationActivity;

    new-instance v1, Landroid/content/Intent;

    const-string v2, "android.settings.DATE_SETTINGS"

    invoke-direct {v1, v2}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    const/high16 v2, 0x10000000

    invoke-virtual {v1, v2}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/comcast/cim/android/authentication/AuthenticationActivity;->startActivity(Landroid/content/Intent;)V

    .line 226
    return-void
.end method

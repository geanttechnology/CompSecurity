.class Lcom/comcast/cim/android/view/launch/AuthenticatingPreferenceActivity$1;
.super Lcom/comcast/cim/cmasl/taskexecutor/listener/DefaultTaskExecutionListener;
.source "AuthenticatingPreferenceActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/comcast/cim/android/view/launch/AuthenticatingPreferenceActivity;->onResume()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/comcast/cim/cmasl/taskexecutor/listener/DefaultTaskExecutionListener",
        "<",
        "Ljava/lang/Integer;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/comcast/cim/android/view/launch/AuthenticatingPreferenceActivity;


# direct methods
.method constructor <init>(Lcom/comcast/cim/android/view/launch/AuthenticatingPreferenceActivity;)V
    .locals 0
    .param p1, "this$0"    # Lcom/comcast/cim/android/view/launch/AuthenticatingPreferenceActivity;

    .prologue
    .line 103
    iput-object p1, p0, Lcom/comcast/cim/android/view/launch/AuthenticatingPreferenceActivity$1;->this$0:Lcom/comcast/cim/android/view/launch/AuthenticatingPreferenceActivity;

    invoke-direct {p0}, Lcom/comcast/cim/cmasl/taskexecutor/listener/DefaultTaskExecutionListener;-><init>()V

    return-void
.end method


# virtual methods
.method public onError(Lcom/comcast/cim/cmasl/taskexecutor/exceptions/TaskExecutionException;)V
    .locals 0
    .param p1, "exception"    # Lcom/comcast/cim/cmasl/taskexecutor/exceptions/TaskExecutionException;

    .prologue
    .line 130
    return-void
.end method

.method public onPostExecute(Ljava/lang/Integer;)V
    .locals 4
    .param p1, "result"    # Ljava/lang/Integer;

    .prologue
    .line 106
    invoke-virtual {p1}, Ljava/lang/Integer;->intValue()I

    move-result v1

    iget-object v2, p0, Lcom/comcast/cim/android/view/launch/AuthenticatingPreferenceActivity$1;->this$0:Lcom/comcast/cim/android/view/launch/AuthenticatingPreferenceActivity;

    # getter for: Lcom/comcast/cim/android/view/launch/AuthenticatingPreferenceActivity;->versionCode:I
    invoke-static {v2}, Lcom/comcast/cim/android/view/launch/AuthenticatingPreferenceActivity;->access$000(Lcom/comcast/cim/android/view/launch/AuthenticatingPreferenceActivity;)I

    move-result v2

    if-le v1, v2, :cond_0

    .line 107
    new-instance v0, Landroid/app/AlertDialog$Builder;

    iget-object v1, p0, Lcom/comcast/cim/android/view/launch/AuthenticatingPreferenceActivity$1;->this$0:Lcom/comcast/cim/android/view/launch/AuthenticatingPreferenceActivity;

    invoke-direct {v0, v1}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 108
    .local v0, "builder":Landroid/app/AlertDialog$Builder;
    sget v1, Lcom/comcast/cim/android/R$string;->version_too_low_desc:I

    invoke-virtual {v0, v1}, Landroid/app/AlertDialog$Builder;->setMessage(I)Landroid/app/AlertDialog$Builder;

    move-result-object v1

    sget v2, Lcom/comcast/cim/android/R$string;->version_too_low_title:I

    .line 109
    invoke-virtual {v1, v2}, Landroid/app/AlertDialog$Builder;->setTitle(I)Landroid/app/AlertDialog$Builder;

    move-result-object v1

    sget v2, Lcom/comcast/cim/android/R$string;->dlg_btn_ok:I

    new-instance v3, Lcom/comcast/cim/android/view/launch/AuthenticatingPreferenceActivity$1$2;

    invoke-direct {v3, p0}, Lcom/comcast/cim/android/view/launch/AuthenticatingPreferenceActivity$1$2;-><init>(Lcom/comcast/cim/android/view/launch/AuthenticatingPreferenceActivity$1;)V

    .line 110
    invoke-virtual {v1, v2, v3}, Landroid/app/AlertDialog$Builder;->setPositiveButton(ILandroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    move-result-object v1

    new-instance v2, Lcom/comcast/cim/android/view/launch/AuthenticatingPreferenceActivity$1$1;

    invoke-direct {v2, p0}, Lcom/comcast/cim/android/view/launch/AuthenticatingPreferenceActivity$1$1;-><init>(Lcom/comcast/cim/android/view/launch/AuthenticatingPreferenceActivity$1;)V

    .line 116
    invoke-virtual {v1, v2}, Landroid/app/AlertDialog$Builder;->setOnCancelListener(Landroid/content/DialogInterface$OnCancelListener;)Landroid/app/AlertDialog$Builder;

    .line 123
    invoke-virtual {v0}, Landroid/app/AlertDialog$Builder;->create()Landroid/app/AlertDialog;

    move-result-object v1

    invoke-virtual {v1}, Landroid/app/AlertDialog;->show()V

    .line 125
    .end local v0    # "builder":Landroid/app/AlertDialog$Builder;
    :cond_0
    return-void
.end method

.method public bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 103
    check-cast p1, Ljava/lang/Integer;

    invoke-virtual {p0, p1}, Lcom/comcast/cim/android/view/launch/AuthenticatingPreferenceActivity$1;->onPostExecute(Ljava/lang/Integer;)V

    return-void
.end method

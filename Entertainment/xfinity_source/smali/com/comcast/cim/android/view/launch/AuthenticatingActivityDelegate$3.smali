.class Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate$3;
.super Lcom/comcast/cim/cmasl/taskexecutor/listener/DefaultTaskExecutionListener;
.source "AuthenticatingActivityDelegate.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate;->doMinVersionCheck()V
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
.field final synthetic this$0:Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate;


# direct methods
.method constructor <init>(Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate;)V
    .locals 0
    .param p1, "this$0"    # Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate;

    .prologue
    .line 121
    iput-object p1, p0, Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate$3;->this$0:Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate;

    invoke-direct {p0}, Lcom/comcast/cim/cmasl/taskexecutor/listener/DefaultTaskExecutionListener;-><init>()V

    return-void
.end method


# virtual methods
.method public onError(Lcom/comcast/cim/cmasl/taskexecutor/exceptions/TaskExecutionException;)V
    .locals 0
    .param p1, "exception"    # Lcom/comcast/cim/cmasl/taskexecutor/exceptions/TaskExecutionException;

    .prologue
    .line 145
    return-void
.end method

.method public onPostExecute(Ljava/lang/Integer;)V
    .locals 5
    .param p1, "result"    # Ljava/lang/Integer;

    .prologue
    .line 124
    iget-object v2, p0, Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate$3;->this$0:Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate;

    # getter for: Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate;->LOG:Lorg/slf4j/Logger;
    invoke-static {v2}, Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate;->access$200(Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate;)Lorg/slf4j/Logger;

    move-result-object v2

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Min Version Check: Current App Version is "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p0, Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate$3;->this$0:Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate;

    # getter for: Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate;->versionCode:I
    invoke-static {v4}, Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate;->access$100(Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate;)I

    move-result v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, ", Server Minimum Version is "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v2, v3}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 125
    invoke-virtual {p1}, Ljava/lang/Integer;->intValue()I

    move-result v2

    iget-object v3, p0, Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate$3;->this$0:Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate;

    # getter for: Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate;->versionCode:I
    invoke-static {v3}, Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate;->access$100(Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate;)I

    move-result v3

    if-le v2, v3, :cond_0

    .line 126
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 127
    .local v0, "args":Landroid/os/Bundle;
    const-string v2, "messageDlg"

    invoke-static {v2}, Lcom/comcast/cim/android/view/common/CALDialogFragment;->newInstance(Ljava/lang/String;)Lcom/comcast/cim/android/view/common/CALDialogFragment;

    move-result-object v1

    .line 128
    .local v1, "dialog":Lcom/comcast/cim/android/view/common/CALDialogFragment;
    const-string v2, "description"

    iget-object v3, p0, Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate$3;->this$0:Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate;

    # getter for: Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate;->activity:Landroid/app/Activity;
    invoke-static {v3}, Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate;->access$000(Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate;)Landroid/app/Activity;

    move-result-object v3

    invoke-virtual {v3}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    sget v4, Lcom/comcast/cim/android/R$string;->version_too_low_desc:I

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 129
    const-string v2, "title"

    iget-object v3, p0, Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate$3;->this$0:Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate;

    # getter for: Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate;->activity:Landroid/app/Activity;
    invoke-static {v3}, Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate;->access$000(Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate;)Landroid/app/Activity;

    move-result-object v3

    invoke-virtual {v3}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    sget v4, Lcom/comcast/cim/android/R$string;->version_too_low_title:I

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 130
    invoke-virtual {v1, v0}, Lcom/comcast/cim/android/view/common/CALDialogFragment;->addArguments(Landroid/os/Bundle;)V

    .line 131
    new-instance v2, Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate$3$1;

    invoke-direct {v2, p0}, Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate$3$1;-><init>(Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate$3;)V

    invoke-virtual {v1, v2}, Lcom/comcast/cim/android/view/common/CALDialogFragment;->setOnDismissListener(Landroid/content/DialogInterface$OnDismissListener;)V

    .line 138
    iget-object v2, p0, Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate$3;->this$0:Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate;

    # getter for: Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate;->activity:Landroid/app/Activity;
    invoke-static {v2}, Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate;->access$000(Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate;)Landroid/app/Activity;

    move-result-object v2

    invoke-virtual {v2}, Landroid/app/Activity;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v2

    const-string v3, "caldialogfragment"

    invoke-virtual {v1, v2, v3}, Lcom/comcast/cim/android/view/common/CALDialogFragment;->show(Landroid/app/FragmentManager;Ljava/lang/String;)V

    .line 140
    .end local v0    # "args":Landroid/os/Bundle;
    .end local v1    # "dialog":Lcom/comcast/cim/android/view/common/CALDialogFragment;
    :cond_0
    return-void
.end method

.method public bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 121
    check-cast p1, Ljava/lang/Integer;

    invoke-virtual {p0, p1}, Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate$3;->onPostExecute(Ljava/lang/Integer;)V

    return-void
.end method

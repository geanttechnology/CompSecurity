.class Lcom/comcast/cim/android/authentication/AuthenticationActivity$2;
.super Landroid/os/AsyncTask;
.source "AuthenticationActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/comcast/cim/android/authentication/AuthenticationActivity;->onCreate(Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/os/AsyncTask",
        "<",
        "Ljava/lang/Void;",
        "Ljava/lang/Void;",
        "TT;>;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/comcast/cim/android/authentication/AuthenticationActivity;


# direct methods
.method constructor <init>(Lcom/comcast/cim/android/authentication/AuthenticationActivity;)V
    .locals 0
    .param p1, "this$0"    # Lcom/comcast/cim/android/authentication/AuthenticationActivity;

    .prologue
    .line 102
    .local p0, "this":Lcom/comcast/cim/android/authentication/AuthenticationActivity$2;, "Lcom/comcast/cim/android/authentication/AuthenticationActivity$2;"
    iput-object p1, p0, Lcom/comcast/cim/android/authentication/AuthenticationActivity$2;->this$0:Lcom/comcast/cim/android/authentication/AuthenticationActivity;

    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    return-void
.end method


# virtual methods
.method protected varargs doInBackground([Ljava/lang/Void;)Lcom/comcast/cim/model/user/XipUser;
    .locals 1
    .param p1, "params"    # [Ljava/lang/Void;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "([",
            "Ljava/lang/Void;",
            ")TT;"
        }
    .end annotation

    .prologue
    .line 106
    .local p0, "this":Lcom/comcast/cim/android/authentication/AuthenticationActivity$2;, "Lcom/comcast/cim/android/authentication/AuthenticationActivity$2;"
    iget-object v0, p0, Lcom/comcast/cim/android/authentication/AuthenticationActivity$2;->this$0:Lcom/comcast/cim/android/authentication/AuthenticationActivity;

    # invokes: Lcom/comcast/cim/android/authentication/AuthenticationActivity;->fetchCurrentUserData()Lcom/comcast/cim/model/user/XipUser;
    invoke-static {v0}, Lcom/comcast/cim/android/authentication/AuthenticationActivity;->access$000(Lcom/comcast/cim/android/authentication/AuthenticationActivity;)Lcom/comcast/cim/model/user/XipUser;

    move-result-object v0

    return-object v0
.end method

.method protected bridge synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 102
    .local p0, "this":Lcom/comcast/cim/android/authentication/AuthenticationActivity$2;, "Lcom/comcast/cim/android/authentication/AuthenticationActivity$2;"
    check-cast p1, [Ljava/lang/Void;

    invoke-virtual {p0, p1}, Lcom/comcast/cim/android/authentication/AuthenticationActivity$2;->doInBackground([Ljava/lang/Void;)Lcom/comcast/cim/model/user/XipUser;

    move-result-object v0

    return-object v0
.end method

.method protected onPostExecute(Lcom/comcast/cim/model/user/XipUser;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)V"
        }
    .end annotation

    .prologue
    .line 111
    .local p0, "this":Lcom/comcast/cim/android/authentication/AuthenticationActivity$2;, "Lcom/comcast/cim/android/authentication/AuthenticationActivity$2;"
    .local p1, "currentUser":Lcom/comcast/cim/model/user/XipUser;, "TT;"
    if-nez p1, :cond_0

    .line 112
    iget-object v0, p0, Lcom/comcast/cim/android/authentication/AuthenticationActivity$2;->this$0:Lcom/comcast/cim/android/authentication/AuthenticationActivity;

    invoke-virtual {v0}, Lcom/comcast/cim/android/authentication/AuthenticationActivity;->hideSigningInSpinner()V

    .line 123
    :goto_0
    return-void

    .line 113
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/android/authentication/AuthenticationActivity$2;->this$0:Lcom/comcast/cim/android/authentication/AuthenticationActivity;

    invoke-virtual {v0}, Lcom/comcast/cim/android/authentication/AuthenticationActivity;->getUserManager()Lcom/comcast/cim/model/user/XipUserManager;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/model/user/XipUserManager;->getUser()Lcom/comcast/cim/model/user/User;

    move-result-object v0

    invoke-virtual {p1, v0}, Lcom/comcast/cim/model/user/XipUser;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 114
    iget-object v0, p0, Lcom/comcast/cim/android/authentication/AuthenticationActivity$2;->this$0:Lcom/comcast/cim/android/authentication/AuthenticationActivity;

    # invokes: Lcom/comcast/cim/android/authentication/AuthenticationActivity;->updateUser(Lcom/comcast/cim/model/user/XipUser;)V
    invoke-static {v0, p1}, Lcom/comcast/cim/android/authentication/AuthenticationActivity;->access$100(Lcom/comcast/cim/android/authentication/AuthenticationActivity;Lcom/comcast/cim/model/user/XipUser;)V

    .line 115
    iget-object v0, p0, Lcom/comcast/cim/android/authentication/AuthenticationActivity$2;->this$0:Lcom/comcast/cim/android/authentication/AuthenticationActivity;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/comcast/cim/android/authentication/AuthenticationActivity;->setResult(I)V

    .line 116
    iget-object v0, p0, Lcom/comcast/cim/android/authentication/AuthenticationActivity$2;->this$0:Lcom/comcast/cim/android/authentication/AuthenticationActivity;

    invoke-virtual {v0}, Lcom/comcast/cim/android/authentication/AuthenticationActivity;->finish()V

    goto :goto_0

    .line 118
    :cond_1
    iget-object v0, p0, Lcom/comcast/cim/android/authentication/AuthenticationActivity$2;->this$0:Lcom/comcast/cim/android/authentication/AuthenticationActivity;

    # invokes: Lcom/comcast/cim/android/authentication/AuthenticationActivity;->updateUser(Lcom/comcast/cim/model/user/XipUser;)V
    invoke-static {v0, p1}, Lcom/comcast/cim/android/authentication/AuthenticationActivity;->access$100(Lcom/comcast/cim/android/authentication/AuthenticationActivity;Lcom/comcast/cim/model/user/XipUser;)V

    .line 119
    iget-object v0, p0, Lcom/comcast/cim/android/authentication/AuthenticationActivity$2;->this$0:Lcom/comcast/cim/android/authentication/AuthenticationActivity;

    const/4 v1, 0x2

    invoke-virtual {v0, v1}, Lcom/comcast/cim/android/authentication/AuthenticationActivity;->setResult(I)V

    .line 120
    iget-object v0, p0, Lcom/comcast/cim/android/authentication/AuthenticationActivity$2;->this$0:Lcom/comcast/cim/android/authentication/AuthenticationActivity;

    invoke-virtual {v0}, Lcom/comcast/cim/android/authentication/AuthenticationActivity;->finish()V

    goto :goto_0
.end method

.method protected bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 102
    .local p0, "this":Lcom/comcast/cim/android/authentication/AuthenticationActivity$2;, "Lcom/comcast/cim/android/authentication/AuthenticationActivity$2;"
    check-cast p1, Lcom/comcast/cim/model/user/XipUser;

    invoke-virtual {p0, p1}, Lcom/comcast/cim/android/authentication/AuthenticationActivity$2;->onPostExecute(Lcom/comcast/cim/model/user/XipUser;)V

    return-void
.end method

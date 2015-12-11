.class Lcom/comcast/cim/android/authentication/AuthenticationActivity$7;
.super Ljava/lang/Object;
.source "AuthenticationActivity.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/comcast/cim/android/authentication/AuthenticationActivity;->onSigninSuccess(Lcom/comcast/cim/android/authentication/UserCredentials;Lcom/comcast/cim/model/user/AuthKeys;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/comcast/cim/android/authentication/AuthenticationActivity;

.field final synthetic val$authKeys:Lcom/comcast/cim/model/user/AuthKeys;

.field final synthetic val$userCredentials:Lcom/comcast/cim/android/authentication/UserCredentials;


# direct methods
.method constructor <init>(Lcom/comcast/cim/android/authentication/AuthenticationActivity;Lcom/comcast/cim/android/authentication/UserCredentials;Lcom/comcast/cim/model/user/AuthKeys;)V
    .locals 0
    .param p1, "this$0"    # Lcom/comcast/cim/android/authentication/AuthenticationActivity;

    .prologue
    .line 269
    .local p0, "this":Lcom/comcast/cim/android/authentication/AuthenticationActivity$7;, "Lcom/comcast/cim/android/authentication/AuthenticationActivity$7;"
    iput-object p1, p0, Lcom/comcast/cim/android/authentication/AuthenticationActivity$7;->this$0:Lcom/comcast/cim/android/authentication/AuthenticationActivity;

    iput-object p2, p0, Lcom/comcast/cim/android/authentication/AuthenticationActivity$7;->val$userCredentials:Lcom/comcast/cim/android/authentication/UserCredentials;

    iput-object p3, p0, Lcom/comcast/cim/android/authentication/AuthenticationActivity$7;->val$authKeys:Lcom/comcast/cim/model/user/AuthKeys;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 4

    .prologue
    .line 271
    .local p0, "this":Lcom/comcast/cim/android/authentication/AuthenticationActivity$7;, "Lcom/comcast/cim/android/authentication/AuthenticationActivity$7;"
    iget-object v1, p0, Lcom/comcast/cim/android/authentication/AuthenticationActivity$7;->this$0:Lcom/comcast/cim/android/authentication/AuthenticationActivity;

    invoke-virtual {v1}, Lcom/comcast/cim/android/authentication/AuthenticationActivity;->getUserManager()Lcom/comcast/cim/model/user/XipUserManager;

    move-result-object v1

    iget-object v2, p0, Lcom/comcast/cim/android/authentication/AuthenticationActivity$7;->val$userCredentials:Lcom/comcast/cim/android/authentication/UserCredentials;

    iget-object v3, p0, Lcom/comcast/cim/android/authentication/AuthenticationActivity$7;->val$authKeys:Lcom/comcast/cim/model/user/AuthKeys;

    invoke-virtual {v1, v2, v3}, Lcom/comcast/cim/model/user/XipUserManager;->createUser(Lcom/comcast/cim/android/authentication/UserCredentials;Lcom/comcast/cim/model/user/AuthKeys;)Lcom/comcast/cim/model/user/XipUser;

    move-result-object v0

    .line 272
    .local v0, "loggedIn":Lcom/comcast/cim/model/user/XipUser;, "TT;"
    iget-object v1, p0, Lcom/comcast/cim/android/authentication/AuthenticationActivity$7;->this$0:Lcom/comcast/cim/android/authentication/AuthenticationActivity;

    # invokes: Lcom/comcast/cim/android/authentication/AuthenticationActivity;->updateUser(Lcom/comcast/cim/model/user/XipUser;)V
    invoke-static {v1, v0}, Lcom/comcast/cim/android/authentication/AuthenticationActivity;->access$100(Lcom/comcast/cim/android/authentication/AuthenticationActivity;Lcom/comcast/cim/model/user/XipUser;)V

    .line 273
    iget-object v1, p0, Lcom/comcast/cim/android/authentication/AuthenticationActivity$7;->this$0:Lcom/comcast/cim/android/authentication/AuthenticationActivity;

    const/4 v2, 0x3

    invoke-virtual {v1, v2}, Lcom/comcast/cim/android/authentication/AuthenticationActivity;->setResult(I)V

    .line 274
    iget-object v1, p0, Lcom/comcast/cim/android/authentication/AuthenticationActivity$7;->this$0:Lcom/comcast/cim/android/authentication/AuthenticationActivity;

    invoke-virtual {v1}, Lcom/comcast/cim/android/authentication/AuthenticationActivity;->onPostSignIn()V

    .line 275
    iget-object v1, p0, Lcom/comcast/cim/android/authentication/AuthenticationActivity$7;->this$0:Lcom/comcast/cim/android/authentication/AuthenticationActivity;

    invoke-virtual {v1}, Lcom/comcast/cim/android/authentication/AuthenticationActivity;->finish()V

    .line 276
    return-void
.end method

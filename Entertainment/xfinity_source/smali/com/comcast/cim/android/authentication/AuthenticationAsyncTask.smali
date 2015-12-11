.class public Lcom/comcast/cim/android/authentication/AuthenticationAsyncTask;
.super Lcom/comcast/cim/android/concurrent/RetryableAsyncTask;
.source "AuthenticationAsyncTask.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/comcast/cim/android/concurrent/RetryableAsyncTask",
        "<",
        "Ljava/lang/String;",
        "Ljava/lang/Void;",
        "Lcom/comcast/cim/model/user/AuthKeys;",
        ">;"
    }
.end annotation


# static fields
.field private static final LOG:Lorg/slf4j/Logger;


# instance fields
.field private final authenticationActivity:Lcom/comcast/cim/android/authentication/AuthenticationActivity;

.field private authenticationClient:Lcom/comcast/cim/android/authentication/AuthenticationClient;

.field private savedException:Ljava/lang/Exception;

.field private userCredentials:Lcom/comcast/cim/android/authentication/UserCredentials;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 21
    const-class v0, Lcom/comcast/cim/android/authentication/AuthenticationAsyncTask;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    sput-object v0, Lcom/comcast/cim/android/authentication/AuthenticationAsyncTask;->LOG:Lorg/slf4j/Logger;

    return-void
.end method

.method public constructor <init>(Lcom/comcast/cim/android/authentication/AuthenticationActivity;Lcom/comcast/cim/android/authentication/AuthenticationClient;Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;Lcom/comcast/cim/android/view/common/ErrorDialogFactory;)V
    .locals 6
    .param p1, "activity"    # Lcom/comcast/cim/android/authentication/AuthenticationActivity;
    .param p2, "authenticationClient"    # Lcom/comcast/cim/android/authentication/AuthenticationClient;
    .param p3, "internetConnection"    # Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;
    .param p4, "errorDialogFactory"    # Lcom/comcast/cim/android/view/common/ErrorDialogFactory;

    .prologue
    .line 29
    const/4 v2, 0x1

    invoke-static {p1}, Lcom/comcast/cim/android/authentication/AuthenticationAsyncTask;->getOnCancelListener(Lcom/comcast/cim/android/authentication/AuthenticationActivity;)Landroid/content/DialogInterface$OnCancelListener;

    move-result-object v4

    move-object v0, p0

    move-object v1, p1

    move-object v3, p3

    move-object v5, p4

    invoke-direct/range {v0 .. v5}, Lcom/comcast/cim/android/concurrent/RetryableAsyncTask;-><init>(Landroid/app/Activity;ZLcom/comcast/cim/cmasl/android/util/system/InternetConnection;Landroid/content/DialogInterface$OnCancelListener;Lcom/comcast/cim/android/view/common/ErrorDialogFactory;)V

    .line 25
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/comcast/cim/android/authentication/AuthenticationAsyncTask;->savedException:Ljava/lang/Exception;

    .line 30
    iput-object p2, p0, Lcom/comcast/cim/android/authentication/AuthenticationAsyncTask;->authenticationClient:Lcom/comcast/cim/android/authentication/AuthenticationClient;

    .line 31
    iput-object p1, p0, Lcom/comcast/cim/android/authentication/AuthenticationAsyncTask;->authenticationActivity:Lcom/comcast/cim/android/authentication/AuthenticationActivity;

    .line 32
    return-void
.end method

.method private static getOnCancelListener(Lcom/comcast/cim/android/authentication/AuthenticationActivity;)Landroid/content/DialogInterface$OnCancelListener;
    .locals 1
    .param p0, "activity"    # Lcom/comcast/cim/android/authentication/AuthenticationActivity;

    .prologue
    .line 36
    new-instance v0, Lcom/comcast/cim/android/authentication/AuthenticationAsyncTask$1;

    invoke-direct {v0, p0}, Lcom/comcast/cim/android/authentication/AuthenticationAsyncTask$1;-><init>(Lcom/comcast/cim/android/authentication/AuthenticationActivity;)V

    return-object v0
.end method


# virtual methods
.method protected doInBackgroundWrapped([Ljava/lang/String;)Lcom/comcast/cim/model/user/AuthKeys;
    .locals 5
    .param p1, "params"    # [Ljava/lang/String;

    .prologue
    .line 47
    const/4 v0, 0x0

    .line 50
    .local v0, "authKeys":Lcom/comcast/cim/model/user/AuthKeys;
    :try_start_0
    new-instance v2, Lcom/comcast/cim/android/authentication/UserCredentials;

    const/4 v3, 0x0

    aget-object v3, p1, v3

    const/4 v4, 0x1

    aget-object v4, p1, v4

    invoke-direct {v2, v3, v4}, Lcom/comcast/cim/android/authentication/UserCredentials;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    iput-object v2, p0, Lcom/comcast/cim/android/authentication/AuthenticationAsyncTask;->userCredentials:Lcom/comcast/cim/android/authentication/UserCredentials;

    .line 51
    iget-object v2, p0, Lcom/comcast/cim/android/authentication/AuthenticationAsyncTask;->authenticationClient:Lcom/comcast/cim/android/authentication/AuthenticationClient;

    iget-object v3, p0, Lcom/comcast/cim/android/authentication/AuthenticationAsyncTask;->userCredentials:Lcom/comcast/cim/android/authentication/UserCredentials;

    invoke-virtual {v2, v3}, Lcom/comcast/cim/android/authentication/AuthenticationClient;->authenticate(Lcom/comcast/cim/android/authentication/UserCredentials;)Lcom/comcast/cim/model/user/AuthKeys;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    .line 57
    :goto_0
    return-object v0

    .line 52
    :catch_0
    move-exception v1

    .line 53
    .local v1, "e":Ljava/lang/Exception;
    sget-object v2, Lcom/comcast/cim/android/authentication/AuthenticationAsyncTask;->LOG:Lorg/slf4j/Logger;

    const-string v3, "Caught exception during authentication"

    invoke-interface {v2, v3, v1}, Lorg/slf4j/Logger;->error(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 54
    iput-object v1, p0, Lcom/comcast/cim/android/authentication/AuthenticationAsyncTask;->savedException:Ljava/lang/Exception;

    goto :goto_0
.end method

.method protected bridge synthetic doInBackgroundWrapped([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 19
    check-cast p1, [Ljava/lang/String;

    invoke-virtual {p0, p1}, Lcom/comcast/cim/android/authentication/AuthenticationAsyncTask;->doInBackgroundWrapped([Ljava/lang/String;)Lcom/comcast/cim/model/user/AuthKeys;

    move-result-object v0

    return-object v0
.end method

.method protected getNewInstance(Landroid/app/Activity;)Lcom/comcast/cim/android/concurrent/RetryableAsyncTask;
    .locals 5
    .param p1, "activity"    # Landroid/app/Activity;

    .prologue
    .line 80
    new-instance v0, Lcom/comcast/cim/android/authentication/AuthenticationAsyncTask;

    iget-object v1, p0, Lcom/comcast/cim/android/authentication/AuthenticationAsyncTask;->authenticationActivity:Lcom/comcast/cim/android/authentication/AuthenticationActivity;

    iget-object v2, p0, Lcom/comcast/cim/android/authentication/AuthenticationAsyncTask;->authenticationClient:Lcom/comcast/cim/android/authentication/AuthenticationClient;

    invoke-virtual {p0}, Lcom/comcast/cim/android/authentication/AuthenticationAsyncTask;->getInternetConnection()Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;

    move-result-object v3

    iget-object v4, p0, Lcom/comcast/cim/android/authentication/AuthenticationAsyncTask;->errorDialogFactory:Lcom/comcast/cim/android/view/common/ErrorDialogFactory;

    invoke-direct {v0, v1, v2, v3, v4}, Lcom/comcast/cim/android/authentication/AuthenticationAsyncTask;-><init>(Lcom/comcast/cim/android/authentication/AuthenticationActivity;Lcom/comcast/cim/android/authentication/AuthenticationClient;Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;Lcom/comcast/cim/android/view/common/ErrorDialogFactory;)V

    return-object v0
.end method

.method protected onPostExecuteWrapped(Lcom/comcast/cim/model/user/AuthKeys;)V
    .locals 2
    .param p1, "authKeys"    # Lcom/comcast/cim/model/user/AuthKeys;

    .prologue
    .line 63
    if-eqz p1, :cond_0

    iget-object v0, p0, Lcom/comcast/cim/android/authentication/AuthenticationAsyncTask;->userCredentials:Lcom/comcast/cim/android/authentication/UserCredentials;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/comcast/cim/android/authentication/AuthenticationAsyncTask;->savedException:Ljava/lang/Exception;

    if-eqz v0, :cond_1

    .line 64
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/android/authentication/AuthenticationAsyncTask;->authenticationActivity:Lcom/comcast/cim/android/authentication/AuthenticationActivity;

    iget-object v1, p0, Lcom/comcast/cim/android/authentication/AuthenticationAsyncTask;->savedException:Ljava/lang/Exception;

    invoke-virtual {v0, v1}, Lcom/comcast/cim/android/authentication/AuthenticationActivity;->onSigninFailed(Ljava/lang/Exception;)V

    .line 71
    :goto_0
    return-void

    .line 69
    :cond_1
    iget-object v0, p0, Lcom/comcast/cim/android/authentication/AuthenticationAsyncTask;->authenticationActivity:Lcom/comcast/cim/android/authentication/AuthenticationActivity;

    iget-object v1, p0, Lcom/comcast/cim/android/authentication/AuthenticationAsyncTask;->userCredentials:Lcom/comcast/cim/android/authentication/UserCredentials;

    invoke-virtual {v0, v1, p1}, Lcom/comcast/cim/android/authentication/AuthenticationActivity;->onSigninSuccess(Lcom/comcast/cim/android/authentication/UserCredentials;Lcom/comcast/cim/model/user/AuthKeys;)V

    goto :goto_0
.end method

.method protected bridge synthetic onPostExecuteWrapped(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 19
    check-cast p1, Lcom/comcast/cim/model/user/AuthKeys;

    invoke-virtual {p0, p1}, Lcom/comcast/cim/android/authentication/AuthenticationAsyncTask;->onPostExecuteWrapped(Lcom/comcast/cim/model/user/AuthKeys;)V

    return-void
.end method

.method protected retryOnException(Ljava/lang/Exception;)Z
    .locals 1
    .param p1, "e"    # Ljava/lang/Exception;

    .prologue
    .line 75
    const/4 v0, 0x1

    return v0
.end method

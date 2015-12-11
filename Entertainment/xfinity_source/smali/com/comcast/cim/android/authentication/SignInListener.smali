.class public Lcom/comcast/cim/android/authentication/SignInListener;
.super Ljava/lang/Object;
.source "SignInListener.java"

# interfaces
.implements Landroid/view/View$OnClickListener;
.implements Landroid/widget/TextView$OnEditorActionListener;


# static fields
.field private static final LOG:Lorg/slf4j/Logger;


# instance fields
.field protected final authenticationClient:Lcom/comcast/cim/android/authentication/AuthenticationClient;

.field private final errorDialogFactory:Lcom/comcast/cim/android/view/common/ErrorDialogFactory;

.field protected final internetConnection:Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;

.field private final softKeyboard:Lcom/comcast/cim/cmasl/android/util/system/SoftKeyboard;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 14
    const-class v0, Lcom/comcast/cim/android/authentication/SignInListener;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    sput-object v0, Lcom/comcast/cim/android/authentication/SignInListener;->LOG:Lorg/slf4j/Logger;

    return-void
.end method

.method public constructor <init>(Lcom/comcast/cim/android/authentication/AuthenticationClient;Lcom/comcast/cim/cmasl/android/util/system/SoftKeyboard;Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;Lcom/comcast/cim/android/view/common/ErrorDialogFactory;)V
    .locals 0
    .param p1, "authenticationClient"    # Lcom/comcast/cim/android/authentication/AuthenticationClient;
    .param p2, "softKeyboard"    # Lcom/comcast/cim/cmasl/android/util/system/SoftKeyboard;
    .param p3, "internetConnection"    # Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;
    .param p4, "errorDialogFactory"    # Lcom/comcast/cim/android/view/common/ErrorDialogFactory;

    .prologue
    .line 20
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 21
    iput-object p1, p0, Lcom/comcast/cim/android/authentication/SignInListener;->authenticationClient:Lcom/comcast/cim/android/authentication/AuthenticationClient;

    .line 22
    iput-object p2, p0, Lcom/comcast/cim/android/authentication/SignInListener;->softKeyboard:Lcom/comcast/cim/cmasl/android/util/system/SoftKeyboard;

    .line 23
    iput-object p3, p0, Lcom/comcast/cim/android/authentication/SignInListener;->internetConnection:Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;

    .line 24
    iput-object p4, p0, Lcom/comcast/cim/android/authentication/SignInListener;->errorDialogFactory:Lcom/comcast/cim/android/view/common/ErrorDialogFactory;

    .line 25
    return-void
.end method

.method private submitLogin(Lcom/comcast/cim/android/authentication/AuthenticationActivity;)V
    .locals 6
    .param p1, "view"    # Lcom/comcast/cim/android/authentication/AuthenticationActivity;

    .prologue
    .line 49
    invoke-virtual {p1}, Lcom/comcast/cim/android/authentication/AuthenticationActivity;->getUsername()Ljava/lang/String;

    move-result-object v2

    .line 50
    .local v2, "username":Ljava/lang/String;
    invoke-virtual {p1}, Lcom/comcast/cim/android/authentication/AuthenticationActivity;->getPassword()Ljava/lang/String;

    move-result-object v1

    .line 52
    .local v1, "password":Ljava/lang/String;
    sget-object v3, Lcom/comcast/cim/android/authentication/SignInListener;->LOG:Lorg/slf4j/Logger;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "signing in as "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-interface {v3, v4}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 54
    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v3

    if-eqz v3, :cond_0

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v3

    if-nez v3, :cond_1

    .line 55
    :cond_0
    invoke-virtual {p1}, Lcom/comcast/cim/android/authentication/AuthenticationActivity;->showZeroLengthDialog()V

    .line 62
    :goto_0
    return-void

    .line 59
    :cond_1
    invoke-virtual {p1}, Lcom/comcast/cim/android/authentication/AuthenticationActivity;->showSigningInSpinner()V

    .line 60
    invoke-virtual {p0, p1}, Lcom/comcast/cim/android/authentication/SignInListener;->getAuthenticationTask(Lcom/comcast/cim/android/authentication/AuthenticationActivity;)Lcom/comcast/cim/android/authentication/AuthenticationAsyncTask;

    move-result-object v0

    .line 61
    .local v0, "authTask":Lcom/comcast/cim/android/authentication/AuthenticationAsyncTask;
    const/4 v3, 0x2

    new-array v3, v3, [Ljava/lang/String;

    const/4 v4, 0x0

    aput-object v2, v3, v4

    const/4 v4, 0x1

    aput-object v1, v3, v4

    invoke-virtual {v0, v3}, Lcom/comcast/cim/android/authentication/AuthenticationAsyncTask;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto :goto_0
.end method


# virtual methods
.method protected getAuthenticationTask(Lcom/comcast/cim/android/authentication/AuthenticationActivity;)Lcom/comcast/cim/android/authentication/AuthenticationAsyncTask;
    .locals 4
    .param p1, "authenticationActivity"    # Lcom/comcast/cim/android/authentication/AuthenticationActivity;

    .prologue
    .line 66
    new-instance v0, Lcom/comcast/cim/android/authentication/AuthenticationAsyncTask;

    iget-object v1, p0, Lcom/comcast/cim/android/authentication/SignInListener;->authenticationClient:Lcom/comcast/cim/android/authentication/AuthenticationClient;

    iget-object v2, p0, Lcom/comcast/cim/android/authentication/SignInListener;->internetConnection:Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;

    iget-object v3, p0, Lcom/comcast/cim/android/authentication/SignInListener;->errorDialogFactory:Lcom/comcast/cim/android/view/common/ErrorDialogFactory;

    invoke-direct {v0, p1, v1, v2, v3}, Lcom/comcast/cim/android/authentication/AuthenticationAsyncTask;-><init>(Lcom/comcast/cim/android/authentication/AuthenticationActivity;Lcom/comcast/cim/android/authentication/AuthenticationClient;Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;Lcom/comcast/cim/android/view/common/ErrorDialogFactory;)V

    return-object v0
.end method

.method public onClick(Landroid/view/View;)V
    .locals 1
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 29
    invoke-virtual {p1}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v0

    check-cast v0, Lcom/comcast/cim/android/authentication/AuthenticationActivity;

    .line 30
    .local v0, "activity":Lcom/comcast/cim/android/authentication/AuthenticationActivity;
    invoke-direct {p0, v0}, Lcom/comcast/cim/android/authentication/SignInListener;->submitLogin(Lcom/comcast/cim/android/authentication/AuthenticationActivity;)V

    .line 31
    return-void
.end method

.method public onEditorAction(Landroid/widget/TextView;ILandroid/view/KeyEvent;)Z
    .locals 2
    .param p1, "textView"    # Landroid/widget/TextView;
    .param p2, "actionId"    # I
    .param p3, "keyEvent"    # Landroid/view/KeyEvent;

    .prologue
    .line 35
    const/4 v1, 0x6

    if-eq p2, v1, :cond_0

    .line 36
    const/4 v1, 0x0

    .line 45
    :goto_0
    return v1

    .line 39
    :cond_0
    invoke-virtual {p1}, Landroid/widget/TextView;->getContext()Landroid/content/Context;

    move-result-object v0

    check-cast v0, Lcom/comcast/cim/android/authentication/AuthenticationActivity;

    .line 41
    .local v0, "activity":Lcom/comcast/cim/android/authentication/AuthenticationActivity;
    iget-object v1, p0, Lcom/comcast/cim/android/authentication/SignInListener;->softKeyboard:Lcom/comcast/cim/cmasl/android/util/system/SoftKeyboard;

    invoke-virtual {v1, p1}, Lcom/comcast/cim/cmasl/android/util/system/SoftKeyboard;->hide(Landroid/view/View;)V

    .line 43
    invoke-direct {p0, v0}, Lcom/comcast/cim/android/authentication/SignInListener;->submitLogin(Lcom/comcast/cim/android/authentication/AuthenticationActivity;)V

    .line 45
    const/4 v1, 0x1

    goto :goto_0
.end method

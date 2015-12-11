.class public Lcom/poshmark/fb_tmblr_twitter/GooglePlusHelper;
.super Ljava/lang/Object;
.source "GooglePlusHelper.java"

# interfaces
.implements Lcom/google/android/gms/common/api/GoogleApiClient$ConnectionCallbacks;
.implements Lcom/google/android/gms/common/api/GoogleApiClient$OnConnectionFailedListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/poshmark/fb_tmblr_twitter/GooglePlusHelper$1;,
        Lcom/poshmark/fb_tmblr_twitter/GooglePlusHelper$FetchGoogleTokenTask;,
        Lcom/poshmark/fb_tmblr_twitter/GooglePlusHelper$SingletonHolder;
    }
.end annotation


# static fields
.field public static GP_REQUEST:I


# instance fields
.field activity:Lcom/poshmark/ui/PMActivity;

.field callback:Lcom/poshmark/fb_tmblr_twitter/ExtServiceUserInfoInterface;

.field fragment:Lcom/poshmark/ui/fragments/PMFragment;

.field private mGoogleApiClient:Lcom/google/android/gms/common/api/GoogleApiClient;

.field private mLogoutInProgress:Z


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 54
    const/16 v0, 0x3e6

    sput v0, Lcom/poshmark/fb_tmblr_twitter/GooglePlusHelper;->GP_REQUEST:I

    return-void
.end method

.method private constructor <init>()V
    .locals 1

    .prologue
    .line 46
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 56
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/poshmark/fb_tmblr_twitter/GooglePlusHelper;->mLogoutInProgress:Z

    .line 48
    return-void
.end method

.method synthetic constructor <init>(Lcom/poshmark/fb_tmblr_twitter/GooglePlusHelper$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/poshmark/fb_tmblr_twitter/GooglePlusHelper$1;

    .prologue
    .line 31
    invoke-direct {p0}, Lcom/poshmark/fb_tmblr_twitter/GooglePlusHelper;-><init>()V

    return-void
.end method

.method static synthetic access$100(Lcom/poshmark/fb_tmblr_twitter/GooglePlusHelper;)Lcom/google/android/gms/common/api/GoogleApiClient;
    .locals 1
    .param p0, "x0"    # Lcom/poshmark/fb_tmblr_twitter/GooglePlusHelper;

    .prologue
    .line 31
    iget-object v0, p0, Lcom/poshmark/fb_tmblr_twitter/GooglePlusHelper;->mGoogleApiClient:Lcom/google/android/gms/common/api/GoogleApiClient;

    return-object v0
.end method

.method public static getInstance()Lcom/poshmark/fb_tmblr_twitter/GooglePlusHelper;
    .locals 1

    .prologue
    .line 43
    sget-object v0, Lcom/poshmark/fb_tmblr_twitter/GooglePlusHelper$SingletonHolder;->INSTANCE:Lcom/poshmark/fb_tmblr_twitter/GooglePlusHelper;

    return-object v0
.end method

.method private loadUserAccountInfo()V
    .locals 3

    .prologue
    .line 99
    new-instance v0, Lcom/poshmark/fb_tmblr_twitter/GooglePlusHelper$FetchGoogleTokenTask;

    invoke-direct {v0, p0}, Lcom/poshmark/fb_tmblr_twitter/GooglePlusHelper$FetchGoogleTokenTask;-><init>(Lcom/poshmark/fb_tmblr_twitter/GooglePlusHelper;)V

    const/4 v1, 0x0

    new-array v1, v1, [Ljava/lang/Void;

    instance-of v2, v0, Landroid/os/AsyncTask;

    if-nez v2, :cond_0

    invoke-virtual {v0, v1}, Lcom/poshmark/fb_tmblr_twitter/GooglePlusHelper$FetchGoogleTokenTask;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 100
    :goto_0
    return-void

    .line 99
    :cond_0
    check-cast v0, Landroid/os/AsyncTask;

    invoke-static {v0, v1}, Lcom/newrelic/agent/android/instrumentation/AsyncTaskInstrumentation;->execute(Landroid/os/AsyncTask;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto :goto_0
.end method

.method public static showGoogleLinkError(Lcom/poshmark/http/api/PMApiError;Lcom/poshmark/ui/fragments/PMFragment;)V
    .locals 1
    .param p0, "apiError"    # Lcom/poshmark/http/api/PMApiError;
    .param p1, "fragment"    # Lcom/poshmark/ui/fragments/PMFragment;

    .prologue
    .line 176
    sget-object v0, Lcom/poshmark/ui/model/ActionErrorContext$Severity;->LOW:Lcom/poshmark/ui/model/ActionErrorContext$Severity;

    invoke-static {p0, p1, v0}, Lcom/poshmark/fb_tmblr_twitter/GooglePlusHelper;->showGoogleLinkError(Lcom/poshmark/http/api/PMApiError;Lcom/poshmark/ui/fragments/PMFragment;Lcom/poshmark/ui/model/ActionErrorContext$Severity;)V

    .line 177
    return-void
.end method

.method public static showGoogleLinkError(Lcom/poshmark/http/api/PMApiError;Lcom/poshmark/ui/fragments/PMFragment;Lcom/poshmark/ui/model/ActionErrorContext$Severity;)V
    .locals 7
    .param p0, "apiError"    # Lcom/poshmark/http/api/PMApiError;
    .param p1, "fragment"    # Lcom/poshmark/ui/fragments/PMFragment;
    .param p2, "severity"    # Lcom/poshmark/ui/model/ActionErrorContext$Severity;

    .prologue
    const/4 v3, 0x0

    .line 180
    iget-object v0, p0, Lcom/poshmark/http/api/PMApiError;->pmErrorType:Lcom/poshmark/data_model/models/PMErrorType;

    sget-object v1, Lcom/poshmark/data_model/models/PMErrorType;->EXTERNAL_ID_TAKEN_ERROR:Lcom/poshmark/data_model/models/PMErrorType;

    if-ne v0, v1, :cond_0

    .line 181
    new-instance v0, Lcom/poshmark/ui/model/ActionErrorContext;

    sget-object v2, Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;->LINK_GOOGLE:Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;

    const v1, 0x7f0600de

    invoke-virtual {p1, v1}, Lcom/poshmark/ui/fragments/PMFragment;->getString(I)Ljava/lang/String;

    move-result-object v6

    move-object v1, p0

    move-object v4, p2

    move-object v5, v3

    invoke-direct/range {v0 .. v6}, Lcom/poshmark/ui/model/ActionErrorContext;-><init>(Lcom/poshmark/http/api/PMApiError;Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;Ljava/lang/String;Lcom/poshmark/ui/model/ActionErrorContext$Severity;Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {p1, v0}, Lcom/poshmark/ui/fragments/PMFragment;->showError(Lcom/poshmark/ui/model/ActionErrorContext;)V

    .line 188
    :goto_0
    return-void

    .line 185
    :cond_0
    new-instance v0, Lcom/poshmark/ui/model/ActionErrorContext;

    sget-object v1, Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;->LINK_GOOGLE:Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;

    const v2, 0x7f0600df

    invoke-virtual {p1, v2}, Lcom/poshmark/ui/fragments/PMFragment;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, p0, v1, v2, p2}, Lcom/poshmark/ui/model/ActionErrorContext;-><init>(Lcom/poshmark/http/api/PMApiError;Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;Ljava/lang/String;Lcom/poshmark/ui/model/ActionErrorContext$Severity;)V

    invoke-virtual {p1, v0}, Lcom/poshmark/ui/fragments/PMFragment;->showError(Lcom/poshmark/ui/model/ActionErrorContext;)V

    goto :goto_0
.end method


# virtual methods
.method public getGooglePlusProfileImageUrl()Ljava/lang/String;
    .locals 4

    .prologue
    const/4 v1, 0x0

    .line 162
    iget-object v2, p0, Lcom/poshmark/fb_tmblr_twitter/GooglePlusHelper;->mGoogleApiClient:Lcom/google/android/gms/common/api/GoogleApiClient;

    if-eqz v2, :cond_0

    iget-object v2, p0, Lcom/poshmark/fb_tmblr_twitter/GooglePlusHelper;->mGoogleApiClient:Lcom/google/android/gms/common/api/GoogleApiClient;

    invoke-interface {v2}, Lcom/google/android/gms/common/api/GoogleApiClient;->isConnected()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 163
    sget-object v2, Lcom/google/android/gms/plus/Plus;->PeopleApi:Lcom/google/android/gms/plus/People;

    iget-object v3, p0, Lcom/poshmark/fb_tmblr_twitter/GooglePlusHelper;->mGoogleApiClient:Lcom/google/android/gms/common/api/GoogleApiClient;

    invoke-interface {v2, v3}, Lcom/google/android/gms/plus/People;->getCurrentPerson(Lcom/google/android/gms/common/api/GoogleApiClient;)Lcom/google/android/gms/plus/model/people/Person;

    move-result-object v0

    .line 164
    .local v0, "currentPerson":Lcom/google/android/gms/plus/model/people/Person;
    if-eqz v0, :cond_0

    .line 165
    invoke-interface {v0}, Lcom/google/android/gms/plus/model/people/Person;->getImage()Lcom/google/android/gms/plus/model/people/Person$Image;

    move-result-object v1

    invoke-interface {v1}, Lcom/google/android/gms/plus/model/people/Person$Image;->getUrl()Ljava/lang/String;

    move-result-object v1

    .line 171
    .end local v0    # "currentPerson":Lcom/google/android/gms/plus/model/people/Person;
    :cond_0
    return-object v1
.end method

.method public handleResultFromActivity(IILandroid/content/Intent;)V
    .locals 1
    .param p1, "requestCode"    # I
    .param p2, "resultCode"    # I
    .param p3, "data"    # Landroid/content/Intent;

    .prologue
    .line 128
    sget v0, Lcom/poshmark/fb_tmblr_twitter/GooglePlusHelper;->GP_REQUEST:I

    if-ne p1, v0, :cond_1

    const/4 v0, -0x1

    if-ne p2, v0, :cond_1

    .line 129
    iget-object v0, p0, Lcom/poshmark/fb_tmblr_twitter/GooglePlusHelper;->mGoogleApiClient:Lcom/google/android/gms/common/api/GoogleApiClient;

    invoke-interface {v0}, Lcom/google/android/gms/common/api/GoogleApiClient;->isConnecting()Z

    move-result v0

    if-nez v0, :cond_0

    .line 130
    iget-object v0, p0, Lcom/poshmark/fb_tmblr_twitter/GooglePlusHelper;->mGoogleApiClient:Lcom/google/android/gms/common/api/GoogleApiClient;

    invoke-interface {v0}, Lcom/google/android/gms/common/api/GoogleApiClient;->connect()V

    .line 136
    :cond_0
    :goto_0
    return-void

    .line 132
    :cond_1
    iget-object v0, p0, Lcom/poshmark/fb_tmblr_twitter/GooglePlusHelper;->fragment:Lcom/poshmark/ui/fragments/PMFragment;

    if-eqz v0, :cond_0

    .line 133
    iget-object v0, p0, Lcom/poshmark/fb_tmblr_twitter/GooglePlusHelper;->fragment:Lcom/poshmark/ui/fragments/PMFragment;

    invoke-virtual {v0}, Lcom/poshmark/ui/fragments/PMFragment;->hideProgressDialog()V

    goto :goto_0
.end method

.method public link(Lcom/poshmark/ui/fragments/PMFragment;Lcom/poshmark/fb_tmblr_twitter/ExtServiceUserInfoInterface;)V
    .locals 3
    .param p1, "fragment"    # Lcom/poshmark/ui/fragments/PMFragment;
    .param p2, "callback"    # Lcom/poshmark/fb_tmblr_twitter/ExtServiceUserInfoInterface;

    .prologue
    .line 59
    invoke-virtual {p1}, Lcom/poshmark/ui/fragments/PMFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/PMActivity;

    iput-object v0, p0, Lcom/poshmark/fb_tmblr_twitter/GooglePlusHelper;->activity:Lcom/poshmark/ui/PMActivity;

    .line 60
    iput-object p1, p0, Lcom/poshmark/fb_tmblr_twitter/GooglePlusHelper;->fragment:Lcom/poshmark/ui/fragments/PMFragment;

    .line 61
    iput-object p2, p0, Lcom/poshmark/fb_tmblr_twitter/GooglePlusHelper;->callback:Lcom/poshmark/fb_tmblr_twitter/ExtServiceUserInfoInterface;

    .line 64
    new-instance v0, Lcom/google/android/gms/common/api/GoogleApiClient$Builder;

    iget-object v1, p0, Lcom/poshmark/fb_tmblr_twitter/GooglePlusHelper;->activity:Lcom/poshmark/ui/PMActivity;

    invoke-direct {v0, v1}, Lcom/google/android/gms/common/api/GoogleApiClient$Builder;-><init>(Landroid/content/Context;)V

    invoke-virtual {v0, p0}, Lcom/google/android/gms/common/api/GoogleApiClient$Builder;->addConnectionCallbacks(Lcom/google/android/gms/common/api/GoogleApiClient$ConnectionCallbacks;)Lcom/google/android/gms/common/api/GoogleApiClient$Builder;

    move-result-object v0

    invoke-virtual {v0, p0}, Lcom/google/android/gms/common/api/GoogleApiClient$Builder;->addOnConnectionFailedListener(Lcom/google/android/gms/common/api/GoogleApiClient$OnConnectionFailedListener;)Lcom/google/android/gms/common/api/GoogleApiClient$Builder;

    move-result-object v0

    sget-object v1, Lcom/google/android/gms/plus/Plus;->API:Lcom/google/android/gms/common/api/Api;

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Lcom/google/android/gms/common/api/GoogleApiClient$Builder;->addApi(Lcom/google/android/gms/common/api/Api;Lcom/google/android/gms/common/api/GoogleApiClient$ApiOptions;)Lcom/google/android/gms/common/api/GoogleApiClient$Builder;

    move-result-object v0

    sget-object v1, Lcom/google/android/gms/plus/Plus;->SCOPE_PLUS_LOGIN:Lcom/google/android/gms/common/api/Scope;

    invoke-virtual {v0, v1}, Lcom/google/android/gms/common/api/GoogleApiClient$Builder;->addScope(Lcom/google/android/gms/common/api/Scope;)Lcom/google/android/gms/common/api/GoogleApiClient$Builder;

    move-result-object v0

    new-instance v1, Lcom/google/android/gms/common/api/Scope;

    const-string v2, "https://www.googleapis.com/auth/userinfo.email"

    invoke-direct {v1, v2}, Lcom/google/android/gms/common/api/Scope;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Lcom/google/android/gms/common/api/GoogleApiClient$Builder;->addScope(Lcom/google/android/gms/common/api/Scope;)Lcom/google/android/gms/common/api/GoogleApiClient$Builder;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/android/gms/common/api/GoogleApiClient$Builder;->build()Lcom/google/android/gms/common/api/GoogleApiClient;

    move-result-object v0

    iput-object v0, p0, Lcom/poshmark/fb_tmblr_twitter/GooglePlusHelper;->mGoogleApiClient:Lcom/google/android/gms/common/api/GoogleApiClient;

    .line 73
    const-string v0, ""

    invoke-virtual {p1, v0}, Lcom/poshmark/ui/fragments/PMFragment;->showProgressDialogWithMessage(Ljava/lang/String;)V

    .line 75
    iget-object v0, p0, Lcom/poshmark/fb_tmblr_twitter/GooglePlusHelper;->mGoogleApiClient:Lcom/google/android/gms/common/api/GoogleApiClient;

    invoke-interface {v0}, Lcom/google/android/gms/common/api/GoogleApiClient;->connect()V

    .line 77
    return-void
.end method

.method public logout()V
    .locals 0

    .prologue
    .line 159
    return-void
.end method

.method public onConnected(Landroid/os/Bundle;)V
    .locals 1
    .param p1, "bundle"    # Landroid/os/Bundle;

    .prologue
    .line 81
    iget-boolean v0, p0, Lcom/poshmark/fb_tmblr_twitter/GooglePlusHelper;->mLogoutInProgress:Z

    if-nez v0, :cond_0

    .line 82
    invoke-direct {p0}, Lcom/poshmark/fb_tmblr_twitter/GooglePlusHelper;->loadUserAccountInfo()V

    .line 89
    :goto_0
    return-void

    .line 84
    :cond_0
    iget-object v0, p0, Lcom/poshmark/fb_tmblr_twitter/GooglePlusHelper;->fragment:Lcom/poshmark/ui/fragments/PMFragment;

    if-eqz v0, :cond_1

    .line 85
    iget-object v0, p0, Lcom/poshmark/fb_tmblr_twitter/GooglePlusHelper;->fragment:Lcom/poshmark/ui/fragments/PMFragment;

    invoke-virtual {v0}, Lcom/poshmark/ui/fragments/PMFragment;->hideProgressDialog()V

    .line 87
    :cond_1
    invoke-virtual {p0}, Lcom/poshmark/fb_tmblr_twitter/GooglePlusHelper;->logout()V

    goto :goto_0
.end method

.method public onConnectionFailed(Lcom/google/android/gms/common/ConnectionResult;)V
    .locals 3
    .param p1, "connectionResult"    # Lcom/google/android/gms/common/ConnectionResult;

    .prologue
    .line 105
    invoke-virtual {p1}, Lcom/google/android/gms/common/ConnectionResult;->hasResolution()Z

    move-result v1

    if-eqz v1, :cond_2

    .line 106
    iget-boolean v1, p0, Lcom/poshmark/fb_tmblr_twitter/GooglePlusHelper;->mLogoutInProgress:Z

    if-nez v1, :cond_1

    .line 108
    :try_start_0
    iget-object v1, p0, Lcom/poshmark/fb_tmblr_twitter/GooglePlusHelper;->activity:Lcom/poshmark/ui/PMActivity;

    sget v2, Lcom/poshmark/fb_tmblr_twitter/GooglePlusHelper;->GP_REQUEST:I

    invoke-virtual {p1, v1, v2}, Lcom/google/android/gms/common/ConnectionResult;->startResolutionForResult(Landroid/app/Activity;I)V
    :try_end_0
    .catch Landroid/content/IntentSender$SendIntentException; {:try_start_0 .. :try_end_0} :catch_0

    .line 125
    :cond_0
    :goto_0
    return-void

    .line 109
    :catch_0
    move-exception v0

    .line 112
    .local v0, "e":Landroid/content/IntentSender$SendIntentException;
    iget-object v1, p0, Lcom/poshmark/fb_tmblr_twitter/GooglePlusHelper;->mGoogleApiClient:Lcom/google/android/gms/common/api/GoogleApiClient;

    invoke-interface {v1}, Lcom/google/android/gms/common/api/GoogleApiClient;->connect()V

    goto :goto_0

    .line 118
    .end local v0    # "e":Landroid/content/IntentSender$SendIntentException;
    :cond_1
    const/4 v1, 0x0

    iput-boolean v1, p0, Lcom/poshmark/fb_tmblr_twitter/GooglePlusHelper;->mLogoutInProgress:Z

    goto :goto_0

    .line 121
    :cond_2
    iget-object v1, p0, Lcom/poshmark/fb_tmblr_twitter/GooglePlusHelper;->fragment:Lcom/poshmark/ui/fragments/PMFragment;

    if-eqz v1, :cond_0

    .line 122
    iget-object v1, p0, Lcom/poshmark/fb_tmblr_twitter/GooglePlusHelper;->fragment:Lcom/poshmark/ui/fragments/PMFragment;

    invoke-virtual {v1}, Lcom/poshmark/ui/fragments/PMFragment;->hideProgressDialog()V

    goto :goto_0
.end method

.method public onConnectionSuspended(I)V
    .locals 1
    .param p1, "i"    # I

    .prologue
    .line 93
    iget-object v0, p0, Lcom/poshmark/fb_tmblr_twitter/GooglePlusHelper;->fragment:Lcom/poshmark/ui/fragments/PMFragment;

    if-eqz v0, :cond_0

    .line 94
    iget-object v0, p0, Lcom/poshmark/fb_tmblr_twitter/GooglePlusHelper;->fragment:Lcom/poshmark/ui/fragments/PMFragment;

    invoke-virtual {v0}, Lcom/poshmark/ui/fragments/PMFragment;->hideProgressDialog()V

    .line 96
    :cond_0
    return-void
.end method

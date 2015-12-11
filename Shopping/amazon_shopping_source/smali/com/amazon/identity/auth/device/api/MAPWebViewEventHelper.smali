.class public final Lcom/amazon/identity/auth/device/api/MAPWebViewEventHelper;
.super Ljava/lang/Object;
.source "MAPWebViewEventHelper.java"


# static fields
.field public static final AUTHENTICATION_EVENT:Ljava/lang/String; = "authentication_event"

.field public static final AUTHENTICATION_ONLY_EVENT:Ljava/lang/String; = "authentication_only_event"

.field public static final ERROR_EVENT:Ljava/lang/String; = "error_event"

.field public static final ERROR_EVENT_VALUE:Ljava/lang/String; = "error_event_value"

.field public static final KEY_ERRORS:Ljava/lang/String; = "errors"

.field public static final KEY_EVENT_TYPE:Ljava/lang/String; = "event_type"


# instance fields
.field private final mResult:Landroid/os/Bundle;


# direct methods
.method public constructor <init>(Landroid/os/Bundle;)V
    .locals 0
    .param p1, "result"    # Landroid/os/Bundle;

    .prologue
    .line 33
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 34
    iput-object p1, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewEventHelper;->mResult:Landroid/os/Bundle;

    .line 35
    return-void
.end method

.method private resultContainsKey(Ljava/lang/String;)Z
    .locals 1
    .param p1, "key"    # Ljava/lang/String;

    .prologue
    .line 115
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewEventHelper;->mResult:Landroid/os/Bundle;

    if-nez v0, :cond_0

    .line 117
    const/4 v0, 0x0

    .line 120
    :goto_0
    return v0

    :cond_0
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewEventHelper;->mResult:Landroid/os/Bundle;

    invoke-virtual {v0, p1}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v0

    goto :goto_0
.end method

.method static setAuthenticationEvent(Lcom/amazon/identity/auth/device/api/Callback;)V
    .locals 3
    .param p0, "callback"    # Lcom/amazon/identity/auth/device/api/Callback;

    .prologue
    .line 89
    if-nez p0, :cond_0

    .line 98
    :goto_0
    return-void

    .line 94
    :cond_0
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 95
    .local v0, "result":Landroid/os/Bundle;
    const-string/jumbo v1, "event_type"

    const-string/jumbo v2, "authentication_event"

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 97
    invoke-interface {p0, v0}, Lcom/amazon/identity/auth/device/api/Callback;->onSuccess(Landroid/os/Bundle;)V

    goto :goto_0
.end method

.method static setAuthenticationOnlyEvent(Lcom/amazon/identity/auth/device/api/Callback;)V
    .locals 3
    .param p0, "callback"    # Lcom/amazon/identity/auth/device/api/Callback;

    .prologue
    .line 102
    if-nez p0, :cond_0

    .line 111
    :goto_0
    return-void

    .line 107
    :cond_0
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 108
    .local v0, "result":Landroid/os/Bundle;
    const-string/jumbo v1, "event_type"

    const-string/jumbo v2, "authentication_only_event"

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 110
    invoke-interface {p0, v0}, Lcom/amazon/identity/auth/device/api/Callback;->onSuccess(Landroid/os/Bundle;)V

    goto :goto_0
.end method

.method static setError(Landroid/os/Bundle;Lcom/amazon/identity/auth/device/api/Callback;)V
    .locals 3
    .param p0, "result"    # Landroid/os/Bundle;
    .param p1, "callback"    # Lcom/amazon/identity/auth/device/api/Callback;

    .prologue
    .line 68
    if-nez p1, :cond_0

    .line 80
    :goto_0
    return-void

    .line 73
    :cond_0
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 75
    .local v0, "retResult":Landroid/os/Bundle;
    const-string/jumbo v1, "event_type"

    const-string/jumbo v2, "error_event_value"

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 77
    invoke-virtual {v0, p0}, Landroid/os/Bundle;->putAll(Landroid/os/Bundle;)V

    .line 79
    invoke-interface {p1, v0}, Lcom/amazon/identity/auth/device/api/Callback;->onError(Landroid/os/Bundle;)V

    goto :goto_0
.end method


# virtual methods
.method public isAuthenticationEvent()Z
    .locals 2

    .prologue
    .line 42
    const-string/jumbo v0, "event_type"

    invoke-direct {p0, v0}, Lcom/amazon/identity/auth/device/api/MAPWebViewEventHelper;->resultContainsKey(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 44
    const/4 v0, 0x0

    .line 47
    :goto_0
    return v0

    :cond_0
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewEventHelper;->mResult:Landroid/os/Bundle;

    const-string/jumbo v1, "event_type"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    const-string/jumbo v1, "authentication_event"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    goto :goto_0
.end method

.method public isErrorEvent()Z
    .locals 2

    .prologue
    .line 55
    const-string/jumbo v0, "event_type"

    invoke-direct {p0, v0}, Lcom/amazon/identity/auth/device/api/MAPWebViewEventHelper;->resultContainsKey(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 57
    const/4 v0, 0x0

    .line 60
    :goto_0
    return v0

    :cond_0
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewEventHelper;->mResult:Landroid/os/Bundle;

    const-string/jumbo v1, "event_type"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    const-string/jumbo v1, "error_event"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    goto :goto_0
.end method

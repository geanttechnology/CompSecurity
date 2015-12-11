.class public abstract Lcom/amazon/identity/auth/device/api/MAPWebViewActivity;
.super Landroid/app/Activity;
.source "MAPWebViewActivity.java"

# interfaces
.implements Lcom/amazon/identity/auth/device/api/MAPWebViewActivityInterface;


# static fields
.field private static final LOG_TAG:Ljava/lang/String;


# instance fields
.field public mWebViewHelper:Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 32
    const-class v0, Lcom/amazon/identity/auth/device/api/MAPWebViewActivity;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/device/api/MAPWebViewActivity;->LOG_TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 29
    invoke-direct {p0}, Landroid/app/Activity;-><init>()V

    return-void
.end method

.method static synthetic access$000(Lcom/amazon/identity/auth/device/api/MAPWebViewActivity;Landroid/os/Bundle;)V
    .locals 1
    .param p0, "x0"    # Lcom/amazon/identity/auth/device/api/MAPWebViewActivity;
    .param p1, "x1"    # Landroid/os/Bundle;

    .prologue
    .line 29
    sget-object v0, Lcom/amazon/identity/auth/device/api/MAPWebViewActivity;->LOG_TAG:Ljava/lang/String;

    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewActivity;->mWebViewHelper:Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;

    invoke-virtual {v0, p1}, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->handleAuthSuccessResult(Landroid/os/Bundle;)V

    return-void
.end method

.method static synthetic access$100(Lcom/amazon/identity/auth/device/api/MAPWebViewActivity;Landroid/os/Bundle;)V
    .locals 1
    .param p0, "x0"    # Lcom/amazon/identity/auth/device/api/MAPWebViewActivity;
    .param p1, "x1"    # Landroid/os/Bundle;

    .prologue
    .line 29
    sget-object v0, Lcom/amazon/identity/auth/device/api/MAPWebViewActivity;->LOG_TAG:Ljava/lang/String;

    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewActivity;->mWebViewHelper:Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;

    invoke-virtual {v0, p1}, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->handleAuthResultError(Landroid/os/Bundle;)V

    return-void
.end method


# virtual methods
.method public getActivity()Landroid/app/Activity;
    .locals 0

    .prologue
    .line 130
    return-object p0
.end method

.method public final getAuthActivityCallback()Lcom/amazon/identity/auth/device/api/Callback;
    .locals 1

    .prologue
    .line 39
    new-instance v0, Lcom/amazon/identity/auth/device/api/MAPWebViewActivity$1;

    invoke-direct {v0, p0}, Lcom/amazon/identity/auth/device/api/MAPWebViewActivity$1;-><init>(Lcom/amazon/identity/auth/device/api/MAPWebViewActivity;)V

    .line 55
    return-object v0
.end method

.method public getEventCallback()Lcom/amazon/identity/auth/device/api/Callback;
    .locals 1

    .prologue
    .line 111
    const/4 v0, 0x0

    return-object v0
.end method

.method public getOptions()Landroid/os/Bundle;
    .locals 1

    .prologue
    .line 121
    const/4 v0, 0x0

    return-object v0
.end method

.method public abstract getWebView()Lcom/amazon/android/webkit/AmazonWebView;
.end method

.method public final getWebWebViewHelper()Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;
    .locals 1

    .prologue
    .line 61
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewActivity;->mWebViewHelper:Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;

    return-object v0
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 6
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 67
    invoke-super {p0, p1}, Landroid/app/Activity;->onCreate(Landroid/os/Bundle;)V

    .line 68
    invoke-static {p0}, Lcom/amazon/identity/auth/device/api/AmazonWebViewUtils;->initAmazonWebViewFactory(Landroid/content/Context;)V

    .line 70
    new-instance v0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;

    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/api/MAPWebViewActivity;->getWebView()Lcom/amazon/android/webkit/AmazonWebView;

    move-result-object v2

    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/api/MAPWebViewActivity;->getEventCallback()Lcom/amazon/identity/auth/device/api/Callback;

    move-result-object v3

    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/api/MAPWebViewActivity;->getAuthActivityCallback()Lcom/amazon/identity/auth/device/api/Callback;

    move-result-object v4

    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/api/MAPWebViewActivity;->getOptions()Landroid/os/Bundle;

    move-result-object v5

    move-object v1, p0

    invoke-direct/range {v0 .. v5}, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;-><init>(Landroid/content/Context;Lcom/amazon/android/webkit/AmazonWebView;Lcom/amazon/identity/auth/device/api/Callback;Lcom/amazon/identity/auth/device/api/Callback;Landroid/os/Bundle;)V

    iput-object v0, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewActivity;->mWebViewHelper:Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;

    .line 73
    sget-object v0, Lcom/amazon/identity/auth/device/api/MAPWebViewActivity;->LOG_TAG:Ljava/lang/String;

    .line 74
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewActivity;->mWebViewHelper:Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;

    invoke-virtual {v0, p0, p1}, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->handleOnCreate(Lcom/amazon/identity/auth/device/api/MAPWebViewActivityInterface;Landroid/os/Bundle;)V

    .line 75
    return-void
.end method

.method public onSaveInstanceState(Landroid/os/Bundle;)V
    .locals 1
    .param p1, "outState"    # Landroid/os/Bundle;

    .prologue
    .line 80
    invoke-super {p0, p1}, Landroid/app/Activity;->onSaveInstanceState(Landroid/os/Bundle;)V

    .line 82
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewActivity;->mWebViewHelper:Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;

    invoke-virtual {v0, p1}, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->saveInstanceState(Landroid/os/Bundle;)V

    .line 83
    return-void
.end method

.method protected setParseOptionsFromURL(Z)V
    .locals 1
    .param p1, "parseFromURL"    # Z

    .prologue
    .line 137
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewActivity;->mWebViewHelper:Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;

    invoke-virtual {v0, p1}, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->setParseUrl(Z)V

    .line 138
    return-void
.end method

.class Lcom/exacttarget/etpushsdk/a;
.super Landroid/webkit/WebViewClient;
.source "SourceFile"


# instance fields
.field final synthetic a:Lcom/exacttarget/etpushsdk/ETLandingPagePresenter;


# direct methods
.method constructor <init>(Lcom/exacttarget/etpushsdk/ETLandingPagePresenter;)V
    .locals 0

    .prologue
    .line 87
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/a;->a:Lcom/exacttarget/etpushsdk/ETLandingPagePresenter;

    invoke-direct {p0}, Landroid/webkit/WebViewClient;-><init>()V

    return-void
.end method


# virtual methods
.method public onPageFinished(Landroid/webkit/WebView;Ljava/lang/String;)V
    .locals 2

    .prologue
    .line 91
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/a;->a:Lcom/exacttarget/etpushsdk/ETLandingPagePresenter;

    invoke-virtual {p1}, Landroid/webkit/WebView;->getTitle()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/exacttarget/etpushsdk/ETLandingPagePresenter;->setTitle(Ljava/lang/CharSequence;)V

    .line 92
    return-void
.end method

.class public Ltv/freewheel/test/stubs/CookieSyncManagerStubActivity;
.super Landroid/app/Activity;
.source "CookieSyncManagerStubActivity.java"


# instance fields
.field private mWebView:Landroid/webkit/WebView;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 8
    invoke-direct {p0}, Landroid/app/Activity;-><init>()V

    return-void
.end method


# virtual methods
.method public onCreate(Landroid/os/Bundle;)V
    .locals 1
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 13
    invoke-super {p0, p1}, Landroid/app/Activity;->onCreate(Landroid/os/Bundle;)V

    .line 14
    invoke-static {p0}, Landroid/webkit/CookieSyncManager;->createInstance(Landroid/content/Context;)Landroid/webkit/CookieSyncManager;

    .line 16
    new-instance v0, Landroid/webkit/WebView;

    invoke-direct {v0, p0}, Landroid/webkit/WebView;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Ltv/freewheel/test/stubs/CookieSyncManagerStubActivity;->mWebView:Landroid/webkit/WebView;

    .line 17
    iget-object v0, p0, Ltv/freewheel/test/stubs/CookieSyncManagerStubActivity;->mWebView:Landroid/webkit/WebView;

    invoke-virtual {p0, v0}, Ltv/freewheel/test/stubs/CookieSyncManagerStubActivity;->setContentView(Landroid/view/View;)V

    .line 18
    return-void
.end method

.method protected onResume()V
    .locals 1

    .prologue
    .line 22
    invoke-super {p0}, Landroid/app/Activity;->onResume()V

    .line 23
    invoke-static {}, Landroid/webkit/CookieSyncManager;->getInstance()Landroid/webkit/CookieSyncManager;

    move-result-object v0

    invoke-virtual {v0}, Landroid/webkit/CookieSyncManager;->startSync()V

    .line 24
    return-void
.end method

.method protected onStop()V
    .locals 1

    .prologue
    .line 28
    invoke-super {p0}, Landroid/app/Activity;->onStop()V

    .line 29
    invoke-static {}, Landroid/webkit/CookieSyncManager;->getInstance()Landroid/webkit/CookieSyncManager;

    move-result-object v0

    invoke-virtual {v0}, Landroid/webkit/CookieSyncManager;->stopSync()V

    .line 30
    return-void
.end method

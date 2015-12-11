.class public Lcom/amazon/android/webkit/android/AndroidCookieSyncManager;
.super Lcom/amazon/android/webkit/AmazonCookieSyncManager;
.source "AndroidCookieSyncManager.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 14
    invoke-direct {p0}, Lcom/amazon/android/webkit/AmazonCookieSyncManager;-><init>()V

    return-void
.end method


# virtual methods
.method public createInstance(Landroid/content/Context;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 32
    invoke-static {p1}, Landroid/webkit/CookieSyncManager;->createInstance(Landroid/content/Context;)Landroid/webkit/CookieSyncManager;

    .line 33
    return-void
.end method

.method public sync()V
    .locals 1

    .prologue
    .line 17
    invoke-static {}, Landroid/webkit/CookieSyncManager;->getInstance()Landroid/webkit/CookieSyncManager;

    move-result-object v0

    invoke-virtual {v0}, Landroid/webkit/CookieSyncManager;->sync()V

    .line 18
    return-void
.end method

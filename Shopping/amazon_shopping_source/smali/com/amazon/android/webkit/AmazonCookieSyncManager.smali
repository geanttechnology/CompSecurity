.class public abstract Lcom/amazon/android/webkit/AmazonCookieSyncManager;
.super Ljava/lang/Object;
.source "AmazonCookieSyncManager.java"


# direct methods
.method protected constructor <init>()V
    .locals 0

    .prologue
    .line 17
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static getInstance()Lcom/amazon/android/webkit/AmazonCookieSyncManager;
    .locals 1

    .prologue
    .line 26
    invoke-static {}, Lcom/amazon/android/webkit/AmazonWebKitFactories;->getDefaultFactory()Lcom/amazon/android/webkit/AmazonWebKitFactory;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/android/webkit/AmazonWebKitFactory;->getCookieSyncManager()Lcom/amazon/android/webkit/AmazonCookieSyncManager;

    move-result-object v0

    return-object v0
.end method

.method public static initialize(Landroid/content/Context;)V
    .locals 1
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 36
    invoke-static {}, Lcom/amazon/android/webkit/AmazonWebKitFactories;->getDefaultFactory()Lcom/amazon/android/webkit/AmazonWebKitFactory;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/android/webkit/AmazonWebKitFactory;->getCookieSyncManager()Lcom/amazon/android/webkit/AmazonCookieSyncManager;

    move-result-object v0

    invoke-virtual {v0, p0}, Lcom/amazon/android/webkit/AmazonCookieSyncManager;->createInstance(Landroid/content/Context;)V

    .line 37
    return-void
.end method


# virtual methods
.method public abstract createInstance(Landroid/content/Context;)V
.end method

.method public abstract sync()V
.end method

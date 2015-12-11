.class public abstract Lcom/amazon/android/webkit/AmazonCookieManager;
.super Ljava/lang/Object;
.source "AmazonCookieManager.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 9
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static getInstance()Lcom/amazon/android/webkit/AmazonCookieManager;
    .locals 1

    .prologue
    .line 17
    invoke-static {}, Lcom/amazon/android/webkit/AmazonWebKitFactories;->getDefaultFactory()Lcom/amazon/android/webkit/AmazonWebKitFactory;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/android/webkit/AmazonWebKitFactory;->getCookieManager()Lcom/amazon/android/webkit/AmazonCookieManager;

    move-result-object v0

    return-object v0
.end method


# virtual methods
.method public abstract getCookie(Ljava/lang/String;)Ljava/lang/String;
.end method

.method public abstract removeExpiredCookie()V
.end method

.method public abstract setAcceptCookie(Z)V
.end method

.method public abstract setCookie(Ljava/lang/String;Ljava/lang/String;)V
.end method

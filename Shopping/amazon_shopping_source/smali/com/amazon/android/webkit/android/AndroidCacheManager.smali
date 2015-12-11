.class public Lcom/amazon/android/webkit/android/AndroidCacheManager;
.super Lcom/amazon/android/webkit/AmazonCacheManager;
.source "AndroidCacheManager.java"


# static fields
.field private static final CACHE_MANAGER_CLASS:Ljava/lang/Class;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/lang/Class",
            "<*>;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 20
    const-string/jumbo v0, "android.webkit.CacheManager"

    invoke-static {v0}, Lcom/amazon/android/webkit/android/Reflect;->getOptionalClass(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v0

    sput-object v0, Lcom/amazon/android/webkit/android/AndroidCacheManager;->CACHE_MANAGER_CLASS:Ljava/lang/Class;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 19
    invoke-direct {p0}, Lcom/amazon/android/webkit/AmazonCacheManager;-><init>()V

    return-void
.end method

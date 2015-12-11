.class public Lcom/amazon/mShop/android/platform/dex/ExceptionUtil;
.super Ljava/lang/Object;
.source "ExceptionUtil.java"


# static fields
.field private static final DEBUG:Z


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 7
    invoke-static {}, Lcom/amazon/mShop/android/platform/dex/SecondDexEntry;->getInstance()Lcom/amazon/mShop/android/platform/dex/SecondDexEntry;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/android/platform/dex/SecondDexEntry;->isDebuggable()Z

    move-result v0

    sput-boolean v0, Lcom/amazon/mShop/android/platform/dex/ExceptionUtil;->DEBUG:Z

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 5
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static reportExceptions(Ljava/lang/String;Ljava/lang/Exception;)V
    .locals 1
    .param p0, "tag"    # Ljava/lang/String;
    .param p1, "e"    # Ljava/lang/Exception;

    .prologue
    .line 18
    sget-boolean v0, Lcom/amazon/mShop/android/platform/dex/ExceptionUtil;->DEBUG:Z

    if-eqz v0, :cond_0

    .line 19
    const-string/jumbo v0, "Exception"

    invoke-static {p0, v0, p1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 21
    :cond_0
    return-void
.end method

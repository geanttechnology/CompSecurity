.class public Lcom/amazon/device/ads/ReflectionUtils;
.super Ljava/lang/Object;
.source "ReflectionUtils.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 9
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static isClassAvailable(Ljava/lang/String;)Z
    .locals 2
    .param p0, "className"    # Ljava/lang/String;

    .prologue
    .line 15
    :try_start_0
    invoke-static {p0}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;
    :try_end_0
    .catch Ljava/lang/ClassNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    .line 16
    const/4 v1, 0x1

    .line 20
    :goto_0
    return v1

    .line 18
    :catch_0
    move-exception v0

    .line 20
    .local v0, "e":Ljava/lang/ClassNotFoundException;
    const/4 v1, 0x0

    goto :goto_0
.end method

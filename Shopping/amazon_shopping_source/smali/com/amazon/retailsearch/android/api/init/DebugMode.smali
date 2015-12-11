.class public Lcom/amazon/retailsearch/android/api/init/DebugMode;
.super Ljava/lang/Object;
.source "DebugMode.java"


# static fields
.field private static volatile enabled:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 8
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static enabled()Z
    .locals 1

    .prologue
    .line 17
    sget-boolean v0, Lcom/amazon/retailsearch/android/api/init/DebugMode;->enabled:Z

    return v0
.end method

.method public static setEnabled(Z)V
    .locals 0
    .param p0, "enabled"    # Z

    .prologue
    .line 25
    sput-boolean p0, Lcom/amazon/retailsearch/android/api/init/DebugMode;->enabled:Z

    .line 26
    return-void
.end method

.class public final Lcom/amazon/mobile/mash/util/MASHDebug;
.super Ljava/lang/Object;
.source "MASHDebug.java"


# static fields
.field private static sDebugable:Z


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 13
    const/4 v0, 0x0

    sput-boolean v0, Lcom/amazon/mobile/mash/util/MASHDebug;->sDebugable:Z

    return-void
.end method

.method private constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static isEnabled()Z
    .locals 1

    .prologue
    .line 19
    sget-boolean v0, Lcom/amazon/mobile/mash/util/MASHDebug;->sDebugable:Z

    return v0
.end method

.method public static setEnabled(Z)V
    .locals 0
    .param p0, "debugable"    # Z

    .prologue
    .line 27
    sput-boolean p0, Lcom/amazon/mobile/mash/util/MASHDebug;->sDebugable:Z

    .line 28
    return-void
.end method

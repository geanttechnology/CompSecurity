.class public final Lcom/uplynk/tools/CpuInfo;
.super Ljava/lang/Object;
.source "CpuInfo.java"


# static fields
.field private static final TAG:Ljava/lang/String; = "CpuInfo"


# direct methods
.method private constructor <init>()V
    .locals 0

    .prologue
    .line 6
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 8
    return-void
.end method

.method public static native cpuArch()I
.end method

.method public static native cpuImplementer()I
.end method

.method public static native cpuPart()I
.end method

.method public static native cpuRevision()I
.end method

.method public static native cpuVariant()I
.end method

.method public static native hardwareName()Ljava/lang/String;
.end method

.method public static native hardwareRevision()Ljava/lang/String;
.end method

.method public static native hasFeature(Ljava/lang/String;)Z
.end method

.method public static native numCPUs()I
.end method

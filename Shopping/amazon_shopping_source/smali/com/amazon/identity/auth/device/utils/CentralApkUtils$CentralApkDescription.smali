.class public final Lcom/amazon/identity/auth/device/utils/CentralApkUtils$CentralApkDescription;
.super Ljava/lang/Object;
.source "CentralApkUtils.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/identity/auth/device/utils/CentralApkUtils;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "CentralApkDescription"
.end annotation


# instance fields
.field public final mPackageName:Ljava/lang/String;

.field public final mVersion:Ljava/lang/Integer;


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/lang/Integer;)V
    .locals 0
    .param p1, "packageName"    # Ljava/lang/String;
    .param p2, "version"    # Ljava/lang/Integer;

    .prologue
    .line 33
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 34
    iput-object p1, p0, Lcom/amazon/identity/auth/device/utils/CentralApkUtils$CentralApkDescription;->mPackageName:Ljava/lang/String;

    .line 35
    iput-object p2, p0, Lcom/amazon/identity/auth/device/utils/CentralApkUtils$CentralApkDescription;->mVersion:Ljava/lang/Integer;

    .line 36
    return-void
.end method

.class public final enum Lcom/amazon/dcp/ota/OTAStep;
.super Ljava/lang/Enum;
.source "OTAStep.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/amazon/dcp/ota/OTAStep;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/amazon/dcp/ota/OTAStep;

.field public static final enum Download:Lcom/amazon/dcp/ota/OTAStep;

.field public static final enum DownloadManifest:Lcom/amazon/dcp/ota/OTAStep;

.field public static final enum Install:Lcom/amazon/dcp/ota/OTAStep;

.field public static final enum InstallManifest:Lcom/amazon/dcp/ota/OTAStep;

.field public static final enum None:Lcom/amazon/dcp/ota/OTAStep;

.field public static final enum ProcessManfiest:Lcom/amazon/dcp/ota/OTAStep;


# instance fields
.field private final mStep:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 9

    .prologue
    const/4 v8, 0x4

    const/4 v7, 0x3

    const/4 v6, 0x2

    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 6
    new-instance v0, Lcom/amazon/dcp/ota/OTAStep;

    const-string/jumbo v1, "None"

    const-string/jumbo v2, "None"

    invoke-direct {v0, v1, v4, v2}, Lcom/amazon/dcp/ota/OTAStep;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/dcp/ota/OTAStep;->None:Lcom/amazon/dcp/ota/OTAStep;

    .line 7
    new-instance v0, Lcom/amazon/dcp/ota/OTAStep;

    const-string/jumbo v1, "DownloadManifest"

    const-string/jumbo v2, "OTAStepDownloadManifest"

    invoke-direct {v0, v1, v5, v2}, Lcom/amazon/dcp/ota/OTAStep;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/dcp/ota/OTAStep;->DownloadManifest:Lcom/amazon/dcp/ota/OTAStep;

    .line 8
    new-instance v0, Lcom/amazon/dcp/ota/OTAStep;

    const-string/jumbo v1, "InstallManifest"

    const-string/jumbo v2, "OTAStepInstallManifest"

    invoke-direct {v0, v1, v6, v2}, Lcom/amazon/dcp/ota/OTAStep;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/dcp/ota/OTAStep;->InstallManifest:Lcom/amazon/dcp/ota/OTAStep;

    .line 9
    new-instance v0, Lcom/amazon/dcp/ota/OTAStep;

    const-string/jumbo v1, "ProcessManfiest"

    const-string/jumbo v2, "OTAStepProcessManifest"

    invoke-direct {v0, v1, v7, v2}, Lcom/amazon/dcp/ota/OTAStep;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/dcp/ota/OTAStep;->ProcessManfiest:Lcom/amazon/dcp/ota/OTAStep;

    .line 10
    new-instance v0, Lcom/amazon/dcp/ota/OTAStep;

    const-string/jumbo v1, "Download"

    const-string/jumbo v2, "OTAStepDownload"

    invoke-direct {v0, v1, v8, v2}, Lcom/amazon/dcp/ota/OTAStep;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/dcp/ota/OTAStep;->Download:Lcom/amazon/dcp/ota/OTAStep;

    .line 11
    new-instance v0, Lcom/amazon/dcp/ota/OTAStep;

    const-string/jumbo v1, "Install"

    const/4 v2, 0x5

    const-string/jumbo v3, "OTAStepInstall"

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/dcp/ota/OTAStep;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/dcp/ota/OTAStep;->Install:Lcom/amazon/dcp/ota/OTAStep;

    .line 4
    const/4 v0, 0x6

    new-array v0, v0, [Lcom/amazon/dcp/ota/OTAStep;

    sget-object v1, Lcom/amazon/dcp/ota/OTAStep;->None:Lcom/amazon/dcp/ota/OTAStep;

    aput-object v1, v0, v4

    sget-object v1, Lcom/amazon/dcp/ota/OTAStep;->DownloadManifest:Lcom/amazon/dcp/ota/OTAStep;

    aput-object v1, v0, v5

    sget-object v1, Lcom/amazon/dcp/ota/OTAStep;->InstallManifest:Lcom/amazon/dcp/ota/OTAStep;

    aput-object v1, v0, v6

    sget-object v1, Lcom/amazon/dcp/ota/OTAStep;->ProcessManfiest:Lcom/amazon/dcp/ota/OTAStep;

    aput-object v1, v0, v7

    sget-object v1, Lcom/amazon/dcp/ota/OTAStep;->Download:Lcom/amazon/dcp/ota/OTAStep;

    aput-object v1, v0, v8

    const/4 v1, 0x5

    sget-object v2, Lcom/amazon/dcp/ota/OTAStep;->Install:Lcom/amazon/dcp/ota/OTAStep;

    aput-object v2, v0, v1

    sput-object v0, Lcom/amazon/dcp/ota/OTAStep;->$VALUES:[Lcom/amazon/dcp/ota/OTAStep;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;ILjava/lang/String;)V
    .locals 0
    .param p3, "step"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    .prologue
    .line 16
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 17
    iput-object p3, p0, Lcom/amazon/dcp/ota/OTAStep;->mStep:Ljava/lang/String;

    .line 18
    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/amazon/dcp/ota/OTAStep;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 4
    const-class v0, Lcom/amazon/dcp/ota/OTAStep;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/amazon/dcp/ota/OTAStep;

    return-object v0
.end method

.method public static values()[Lcom/amazon/dcp/ota/OTAStep;
    .locals 1

    .prologue
    .line 4
    sget-object v0, Lcom/amazon/dcp/ota/OTAStep;->$VALUES:[Lcom/amazon/dcp/ota/OTAStep;

    invoke-virtual {v0}, [Lcom/amazon/dcp/ota/OTAStep;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/amazon/dcp/ota/OTAStep;

    return-object v0
.end method


# virtual methods
.method public toString()Ljava/lang/String;
    .locals 1

    .prologue
    .line 23
    iget-object v0, p0, Lcom/amazon/dcp/ota/OTAStep;->mStep:Ljava/lang/String;

    return-object v0
.end method

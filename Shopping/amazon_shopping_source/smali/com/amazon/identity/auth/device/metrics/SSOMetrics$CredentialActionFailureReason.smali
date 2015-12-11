.class public final enum Lcom/amazon/identity/auth/device/metrics/SSOMetrics$CredentialActionFailureReason;
.super Ljava/lang/Enum;
.source "SSOMetrics.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/identity/auth/device/metrics/SSOMetrics;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "CredentialActionFailureReason"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/amazon/identity/auth/device/metrics/SSOMetrics$CredentialActionFailureReason;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/amazon/identity/auth/device/metrics/SSOMetrics$CredentialActionFailureReason;

.field public static final enum DidnotReturnAuthToken:Lcom/amazon/identity/auth/device/metrics/SSOMetrics$CredentialActionFailureReason;

.field public static final enum RequestTimeOut:Lcom/amazon/identity/auth/device/metrics/SSOMetrics$CredentialActionFailureReason;

.field public static final enum UnrecognizedFailure:Lcom/amazon/identity/auth/device/metrics/SSOMetrics$CredentialActionFailureReason;


# instance fields
.field private final mName:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 6

    .prologue
    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 93
    new-instance v0, Lcom/amazon/identity/auth/device/metrics/SSOMetrics$CredentialActionFailureReason;

    const-string/jumbo v1, "RequestTimeOut"

    const-string/jumbo v2, "RequestTimeOut"

    invoke-direct {v0, v1, v3, v2}, Lcom/amazon/identity/auth/device/metrics/SSOMetrics$CredentialActionFailureReason;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/identity/auth/device/metrics/SSOMetrics$CredentialActionFailureReason;->RequestTimeOut:Lcom/amazon/identity/auth/device/metrics/SSOMetrics$CredentialActionFailureReason;

    .line 94
    new-instance v0, Lcom/amazon/identity/auth/device/metrics/SSOMetrics$CredentialActionFailureReason;

    const-string/jumbo v1, "DidnotReturnAuthToken"

    const-string/jumbo v2, "DidnotReturnAuthToken"

    invoke-direct {v0, v1, v4, v2}, Lcom/amazon/identity/auth/device/metrics/SSOMetrics$CredentialActionFailureReason;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/identity/auth/device/metrics/SSOMetrics$CredentialActionFailureReason;->DidnotReturnAuthToken:Lcom/amazon/identity/auth/device/metrics/SSOMetrics$CredentialActionFailureReason;

    .line 95
    new-instance v0, Lcom/amazon/identity/auth/device/metrics/SSOMetrics$CredentialActionFailureReason;

    const-string/jumbo v1, "UnrecognizedFailure"

    const-string/jumbo v2, "UnrecognizedFailure"

    invoke-direct {v0, v1, v5, v2}, Lcom/amazon/identity/auth/device/metrics/SSOMetrics$CredentialActionFailureReason;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/identity/auth/device/metrics/SSOMetrics$CredentialActionFailureReason;->UnrecognizedFailure:Lcom/amazon/identity/auth/device/metrics/SSOMetrics$CredentialActionFailureReason;

    .line 91
    const/4 v0, 0x3

    new-array v0, v0, [Lcom/amazon/identity/auth/device/metrics/SSOMetrics$CredentialActionFailureReason;

    sget-object v1, Lcom/amazon/identity/auth/device/metrics/SSOMetrics$CredentialActionFailureReason;->RequestTimeOut:Lcom/amazon/identity/auth/device/metrics/SSOMetrics$CredentialActionFailureReason;

    aput-object v1, v0, v3

    sget-object v1, Lcom/amazon/identity/auth/device/metrics/SSOMetrics$CredentialActionFailureReason;->DidnotReturnAuthToken:Lcom/amazon/identity/auth/device/metrics/SSOMetrics$CredentialActionFailureReason;

    aput-object v1, v0, v4

    sget-object v1, Lcom/amazon/identity/auth/device/metrics/SSOMetrics$CredentialActionFailureReason;->UnrecognizedFailure:Lcom/amazon/identity/auth/device/metrics/SSOMetrics$CredentialActionFailureReason;

    aput-object v1, v0, v5

    sput-object v0, Lcom/amazon/identity/auth/device/metrics/SSOMetrics$CredentialActionFailureReason;->$VALUES:[Lcom/amazon/identity/auth/device/metrics/SSOMetrics$CredentialActionFailureReason;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;ILjava/lang/String;)V
    .locals 0
    .param p3, "name"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    .prologue
    .line 100
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 101
    iput-object p3, p0, Lcom/amazon/identity/auth/device/metrics/SSOMetrics$CredentialActionFailureReason;->mName:Ljava/lang/String;

    .line 102
    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/amazon/identity/auth/device/metrics/SSOMetrics$CredentialActionFailureReason;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 91
    const-class v0, Lcom/amazon/identity/auth/device/metrics/SSOMetrics$CredentialActionFailureReason;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/amazon/identity/auth/device/metrics/SSOMetrics$CredentialActionFailureReason;

    return-object v0
.end method

.method public static values()[Lcom/amazon/identity/auth/device/metrics/SSOMetrics$CredentialActionFailureReason;
    .locals 1

    .prologue
    .line 91
    sget-object v0, Lcom/amazon/identity/auth/device/metrics/SSOMetrics$CredentialActionFailureReason;->$VALUES:[Lcom/amazon/identity/auth/device/metrics/SSOMetrics$CredentialActionFailureReason;

    invoke-virtual {v0}, [Lcom/amazon/identity/auth/device/metrics/SSOMetrics$CredentialActionFailureReason;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/amazon/identity/auth/device/metrics/SSOMetrics$CredentialActionFailureReason;

    return-object v0
.end method


# virtual methods
.method public getName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 106
    iget-object v0, p0, Lcom/amazon/identity/auth/device/metrics/SSOMetrics$CredentialActionFailureReason;->mName:Ljava/lang/String;

    return-object v0
.end method

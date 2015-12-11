.class public final enum Lcom/creditcardreader/metrics/CreditCardEvent;
.super Ljava/lang/Enum;
.source "CreditCardEvent.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/creditcardreader/metrics/CreditCardEvent;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/creditcardreader/metrics/CreditCardEvent;

.field public static final enum ALIGNED_LANDSCAPE:Lcom/creditcardreader/metrics/CreditCardEvent;

.field public static final enum ALIGNED_PORTRAIT:Lcom/creditcardreader/metrics/CreditCardEvent;

.field public static final enum CANCEL:Lcom/creditcardreader/metrics/CreditCardEvent;

.field public static final enum CANCEL_ON_BACKGROUND_LANDSCAPE:Lcom/creditcardreader/metrics/CreditCardEvent;

.field public static final enum CANCEL_ON_BACKGROUND_PORTRAIT:Lcom/creditcardreader/metrics/CreditCardEvent;

.field public static final enum FAILURE_CAMERA_ERROR:Lcom/creditcardreader/metrics/CreditCardEvent;

.field public static final enum FAILURE_SCAN_TIMEOUT:Lcom/creditcardreader/metrics/CreditCardEvent;

.field public static final enum HELP:Lcom/creditcardreader/metrics/CreditCardEvent;

.field public static final enum LATENCY:Lcom/creditcardreader/metrics/CreditCardEvent;

.field public static final enum PROMISING:Lcom/creditcardreader/metrics/CreditCardEvent;

.field public static final enum RESCAN_AFTER_TIMEOUT:Lcom/creditcardreader/metrics/CreditCardEvent;

.field public static final enum SCAN_TIMEOUT_PROMPT:Lcom/creditcardreader/metrics/CreditCardEvent;

.field public static final enum SESSION_LANDSCAPE:Lcom/creditcardreader/metrics/CreditCardEvent;

.field public static final enum SESSION_PORTRAIT:Lcom/creditcardreader/metrics/CreditCardEvent;

.field public static final enum SUCCESS_HIGH_CONFIDENCE:Lcom/creditcardreader/metrics/CreditCardEvent;

.field public static final enum SUCCESS_LOW_EXPIRATION_CONFIDENCE:Lcom/creditcardreader/metrics/CreditCardEvent;

.field public static final enum SUCCESS_LOW_NUMBER_AND_EXPIRATION_CONFIDENCE:Lcom/creditcardreader/metrics/CreditCardEvent;

.field public static final enum SUCCESS_LOW_NUMBER_CONFIDENCE:Lcom/creditcardreader/metrics/CreditCardEvent;


# instance fields
.field private mEvent:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 9

    .prologue
    const/4 v8, 0x4

    const/4 v7, 0x3

    const/4 v6, 0x2

    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 15
    new-instance v0, Lcom/creditcardreader/metrics/CreditCardEvent;

    const-string/jumbo v1, "SESSION_LANDSCAPE"

    const-string/jumbo v2, "AMICardScanner:Session:Landscape"

    invoke-direct {v0, v1, v4, v2}, Lcom/creditcardreader/metrics/CreditCardEvent;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/creditcardreader/metrics/CreditCardEvent;->SESSION_LANDSCAPE:Lcom/creditcardreader/metrics/CreditCardEvent;

    .line 16
    new-instance v0, Lcom/creditcardreader/metrics/CreditCardEvent;

    const-string/jumbo v1, "SESSION_PORTRAIT"

    const-string/jumbo v2, "AMICardScanner:Session:Portrait"

    invoke-direct {v0, v1, v5, v2}, Lcom/creditcardreader/metrics/CreditCardEvent;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/creditcardreader/metrics/CreditCardEvent;->SESSION_PORTRAIT:Lcom/creditcardreader/metrics/CreditCardEvent;

    .line 19
    new-instance v0, Lcom/creditcardreader/metrics/CreditCardEvent;

    const-string/jumbo v1, "ALIGNED_LANDSCAPE"

    const-string/jumbo v2, "AMICardScanner:Aligned:Landscape"

    invoke-direct {v0, v1, v6, v2}, Lcom/creditcardreader/metrics/CreditCardEvent;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/creditcardreader/metrics/CreditCardEvent;->ALIGNED_LANDSCAPE:Lcom/creditcardreader/metrics/CreditCardEvent;

    .line 20
    new-instance v0, Lcom/creditcardreader/metrics/CreditCardEvent;

    const-string/jumbo v1, "ALIGNED_PORTRAIT"

    const-string/jumbo v2, "AMICardScanner:Aligned:Portrait"

    invoke-direct {v0, v1, v7, v2}, Lcom/creditcardreader/metrics/CreditCardEvent;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/creditcardreader/metrics/CreditCardEvent;->ALIGNED_PORTRAIT:Lcom/creditcardreader/metrics/CreditCardEvent;

    .line 23
    new-instance v0, Lcom/creditcardreader/metrics/CreditCardEvent;

    const-string/jumbo v1, "PROMISING"

    const-string/jumbo v2, "AMICardScanner:Promising"

    invoke-direct {v0, v1, v8, v2}, Lcom/creditcardreader/metrics/CreditCardEvent;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/creditcardreader/metrics/CreditCardEvent;->PROMISING:Lcom/creditcardreader/metrics/CreditCardEvent;

    .line 26
    new-instance v0, Lcom/creditcardreader/metrics/CreditCardEvent;

    const-string/jumbo v1, "CANCEL_ON_BACKGROUND_LANDSCAPE"

    const/4 v2, 0x5

    const-string/jumbo v3, "AMICardScanner:CancelOnBackground:Landscape"

    invoke-direct {v0, v1, v2, v3}, Lcom/creditcardreader/metrics/CreditCardEvent;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/creditcardreader/metrics/CreditCardEvent;->CANCEL_ON_BACKGROUND_LANDSCAPE:Lcom/creditcardreader/metrics/CreditCardEvent;

    .line 27
    new-instance v0, Lcom/creditcardreader/metrics/CreditCardEvent;

    const-string/jumbo v1, "CANCEL_ON_BACKGROUND_PORTRAIT"

    const/4 v2, 0x6

    const-string/jumbo v3, "AMICardScanner:CancelOnBackground:Portrait"

    invoke-direct {v0, v1, v2, v3}, Lcom/creditcardreader/metrics/CreditCardEvent;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/creditcardreader/metrics/CreditCardEvent;->CANCEL_ON_BACKGROUND_PORTRAIT:Lcom/creditcardreader/metrics/CreditCardEvent;

    .line 30
    new-instance v0, Lcom/creditcardreader/metrics/CreditCardEvent;

    const-string/jumbo v1, "SUCCESS_HIGH_CONFIDENCE"

    const/4 v2, 0x7

    const-string/jumbo v3, "AMICardScanner:Success:HighConfidence"

    invoke-direct {v0, v1, v2, v3}, Lcom/creditcardreader/metrics/CreditCardEvent;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/creditcardreader/metrics/CreditCardEvent;->SUCCESS_HIGH_CONFIDENCE:Lcom/creditcardreader/metrics/CreditCardEvent;

    .line 31
    new-instance v0, Lcom/creditcardreader/metrics/CreditCardEvent;

    const-string/jumbo v1, "SUCCESS_LOW_EXPIRATION_CONFIDENCE"

    const/16 v2, 0x8

    const-string/jumbo v3, "AMICardScanner:Success:LowExpirationConfidence"

    invoke-direct {v0, v1, v2, v3}, Lcom/creditcardreader/metrics/CreditCardEvent;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/creditcardreader/metrics/CreditCardEvent;->SUCCESS_LOW_EXPIRATION_CONFIDENCE:Lcom/creditcardreader/metrics/CreditCardEvent;

    .line 32
    new-instance v0, Lcom/creditcardreader/metrics/CreditCardEvent;

    const-string/jumbo v1, "SUCCESS_LOW_NUMBER_CONFIDENCE"

    const/16 v2, 0x9

    const-string/jumbo v3, "AMICardScanner:Success:LowNumberConfidence"

    invoke-direct {v0, v1, v2, v3}, Lcom/creditcardreader/metrics/CreditCardEvent;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/creditcardreader/metrics/CreditCardEvent;->SUCCESS_LOW_NUMBER_CONFIDENCE:Lcom/creditcardreader/metrics/CreditCardEvent;

    .line 33
    new-instance v0, Lcom/creditcardreader/metrics/CreditCardEvent;

    const-string/jumbo v1, "SUCCESS_LOW_NUMBER_AND_EXPIRATION_CONFIDENCE"

    const/16 v2, 0xa

    const-string/jumbo v3, "AMICardScanner:Success:LowNumberAndExpirationConfidence"

    invoke-direct {v0, v1, v2, v3}, Lcom/creditcardreader/metrics/CreditCardEvent;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/creditcardreader/metrics/CreditCardEvent;->SUCCESS_LOW_NUMBER_AND_EXPIRATION_CONFIDENCE:Lcom/creditcardreader/metrics/CreditCardEvent;

    .line 36
    new-instance v0, Lcom/creditcardreader/metrics/CreditCardEvent;

    const-string/jumbo v1, "SCAN_TIMEOUT_PROMPT"

    const/16 v2, 0xb

    const-string/jumbo v3, "AMICardScanner:ScanTimeoutPrompt"

    invoke-direct {v0, v1, v2, v3}, Lcom/creditcardreader/metrics/CreditCardEvent;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/creditcardreader/metrics/CreditCardEvent;->SCAN_TIMEOUT_PROMPT:Lcom/creditcardreader/metrics/CreditCardEvent;

    .line 37
    new-instance v0, Lcom/creditcardreader/metrics/CreditCardEvent;

    const-string/jumbo v1, "RESCAN_AFTER_TIMEOUT"

    const/16 v2, 0xc

    const-string/jumbo v3, "AMICardScanner:RescanAfterScanTimeout"

    invoke-direct {v0, v1, v2, v3}, Lcom/creditcardreader/metrics/CreditCardEvent;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/creditcardreader/metrics/CreditCardEvent;->RESCAN_AFTER_TIMEOUT:Lcom/creditcardreader/metrics/CreditCardEvent;

    .line 38
    new-instance v0, Lcom/creditcardreader/metrics/CreditCardEvent;

    const-string/jumbo v1, "FAILURE_SCAN_TIMEOUT"

    const/16 v2, 0xd

    const-string/jumbo v3, "AMICardScanner:Failure:ScanTimeout"

    invoke-direct {v0, v1, v2, v3}, Lcom/creditcardreader/metrics/CreditCardEvent;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/creditcardreader/metrics/CreditCardEvent;->FAILURE_SCAN_TIMEOUT:Lcom/creditcardreader/metrics/CreditCardEvent;

    .line 41
    new-instance v0, Lcom/creditcardreader/metrics/CreditCardEvent;

    const-string/jumbo v1, "HELP"

    const/16 v2, 0xe

    const-string/jumbo v3, "AMICardScanner:Help"

    invoke-direct {v0, v1, v2, v3}, Lcom/creditcardreader/metrics/CreditCardEvent;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/creditcardreader/metrics/CreditCardEvent;->HELP:Lcom/creditcardreader/metrics/CreditCardEvent;

    .line 44
    new-instance v0, Lcom/creditcardreader/metrics/CreditCardEvent;

    const-string/jumbo v1, "CANCEL"

    const/16 v2, 0xf

    const-string/jumbo v3, "AMICardScanner:Cancel"

    invoke-direct {v0, v1, v2, v3}, Lcom/creditcardreader/metrics/CreditCardEvent;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/creditcardreader/metrics/CreditCardEvent;->CANCEL:Lcom/creditcardreader/metrics/CreditCardEvent;

    .line 47
    new-instance v0, Lcom/creditcardreader/metrics/CreditCardEvent;

    const-string/jumbo v1, "FAILURE_CAMERA_ERROR"

    const/16 v2, 0x10

    const-string/jumbo v3, "AMICardScanner:Failure:CameraError"

    invoke-direct {v0, v1, v2, v3}, Lcom/creditcardreader/metrics/CreditCardEvent;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/creditcardreader/metrics/CreditCardEvent;->FAILURE_CAMERA_ERROR:Lcom/creditcardreader/metrics/CreditCardEvent;

    .line 50
    new-instance v0, Lcom/creditcardreader/metrics/CreditCardEvent;

    const-string/jumbo v1, "LATENCY"

    const/16 v2, 0x11

    const-string/jumbo v3, "AMICardScanner:Latency"

    invoke-direct {v0, v1, v2, v3}, Lcom/creditcardreader/metrics/CreditCardEvent;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/creditcardreader/metrics/CreditCardEvent;->LATENCY:Lcom/creditcardreader/metrics/CreditCardEvent;

    .line 13
    const/16 v0, 0x12

    new-array v0, v0, [Lcom/creditcardreader/metrics/CreditCardEvent;

    sget-object v1, Lcom/creditcardreader/metrics/CreditCardEvent;->SESSION_LANDSCAPE:Lcom/creditcardreader/metrics/CreditCardEvent;

    aput-object v1, v0, v4

    sget-object v1, Lcom/creditcardreader/metrics/CreditCardEvent;->SESSION_PORTRAIT:Lcom/creditcardreader/metrics/CreditCardEvent;

    aput-object v1, v0, v5

    sget-object v1, Lcom/creditcardreader/metrics/CreditCardEvent;->ALIGNED_LANDSCAPE:Lcom/creditcardreader/metrics/CreditCardEvent;

    aput-object v1, v0, v6

    sget-object v1, Lcom/creditcardreader/metrics/CreditCardEvent;->ALIGNED_PORTRAIT:Lcom/creditcardreader/metrics/CreditCardEvent;

    aput-object v1, v0, v7

    sget-object v1, Lcom/creditcardreader/metrics/CreditCardEvent;->PROMISING:Lcom/creditcardreader/metrics/CreditCardEvent;

    aput-object v1, v0, v8

    const/4 v1, 0x5

    sget-object v2, Lcom/creditcardreader/metrics/CreditCardEvent;->CANCEL_ON_BACKGROUND_LANDSCAPE:Lcom/creditcardreader/metrics/CreditCardEvent;

    aput-object v2, v0, v1

    const/4 v1, 0x6

    sget-object v2, Lcom/creditcardreader/metrics/CreditCardEvent;->CANCEL_ON_BACKGROUND_PORTRAIT:Lcom/creditcardreader/metrics/CreditCardEvent;

    aput-object v2, v0, v1

    const/4 v1, 0x7

    sget-object v2, Lcom/creditcardreader/metrics/CreditCardEvent;->SUCCESS_HIGH_CONFIDENCE:Lcom/creditcardreader/metrics/CreditCardEvent;

    aput-object v2, v0, v1

    const/16 v1, 0x8

    sget-object v2, Lcom/creditcardreader/metrics/CreditCardEvent;->SUCCESS_LOW_EXPIRATION_CONFIDENCE:Lcom/creditcardreader/metrics/CreditCardEvent;

    aput-object v2, v0, v1

    const/16 v1, 0x9

    sget-object v2, Lcom/creditcardreader/metrics/CreditCardEvent;->SUCCESS_LOW_NUMBER_CONFIDENCE:Lcom/creditcardreader/metrics/CreditCardEvent;

    aput-object v2, v0, v1

    const/16 v1, 0xa

    sget-object v2, Lcom/creditcardreader/metrics/CreditCardEvent;->SUCCESS_LOW_NUMBER_AND_EXPIRATION_CONFIDENCE:Lcom/creditcardreader/metrics/CreditCardEvent;

    aput-object v2, v0, v1

    const/16 v1, 0xb

    sget-object v2, Lcom/creditcardreader/metrics/CreditCardEvent;->SCAN_TIMEOUT_PROMPT:Lcom/creditcardreader/metrics/CreditCardEvent;

    aput-object v2, v0, v1

    const/16 v1, 0xc

    sget-object v2, Lcom/creditcardreader/metrics/CreditCardEvent;->RESCAN_AFTER_TIMEOUT:Lcom/creditcardreader/metrics/CreditCardEvent;

    aput-object v2, v0, v1

    const/16 v1, 0xd

    sget-object v2, Lcom/creditcardreader/metrics/CreditCardEvent;->FAILURE_SCAN_TIMEOUT:Lcom/creditcardreader/metrics/CreditCardEvent;

    aput-object v2, v0, v1

    const/16 v1, 0xe

    sget-object v2, Lcom/creditcardreader/metrics/CreditCardEvent;->HELP:Lcom/creditcardreader/metrics/CreditCardEvent;

    aput-object v2, v0, v1

    const/16 v1, 0xf

    sget-object v2, Lcom/creditcardreader/metrics/CreditCardEvent;->CANCEL:Lcom/creditcardreader/metrics/CreditCardEvent;

    aput-object v2, v0, v1

    const/16 v1, 0x10

    sget-object v2, Lcom/creditcardreader/metrics/CreditCardEvent;->FAILURE_CAMERA_ERROR:Lcom/creditcardreader/metrics/CreditCardEvent;

    aput-object v2, v0, v1

    const/16 v1, 0x11

    sget-object v2, Lcom/creditcardreader/metrics/CreditCardEvent;->LATENCY:Lcom/creditcardreader/metrics/CreditCardEvent;

    aput-object v2, v0, v1

    sput-object v0, Lcom/creditcardreader/metrics/CreditCardEvent;->$VALUES:[Lcom/creditcardreader/metrics/CreditCardEvent;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;ILjava/lang/String;)V
    .locals 0
    .param p3, "event"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    .prologue
    .line 54
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 55
    iput-object p3, p0, Lcom/creditcardreader/metrics/CreditCardEvent;->mEvent:Ljava/lang/String;

    .line 56
    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/creditcardreader/metrics/CreditCardEvent;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 13
    const-class v0, Lcom/creditcardreader/metrics/CreditCardEvent;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/creditcardreader/metrics/CreditCardEvent;

    return-object v0
.end method

.method public static values()[Lcom/creditcardreader/metrics/CreditCardEvent;
    .locals 1

    .prologue
    .line 13
    sget-object v0, Lcom/creditcardreader/metrics/CreditCardEvent;->$VALUES:[Lcom/creditcardreader/metrics/CreditCardEvent;

    invoke-virtual {v0}, [Lcom/creditcardreader/metrics/CreditCardEvent;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/creditcardreader/metrics/CreditCardEvent;

    return-object v0
.end method


# virtual methods
.method public getEvent()Ljava/lang/String;
    .locals 1

    .prologue
    .line 59
    iget-object v0, p0, Lcom/creditcardreader/metrics/CreditCardEvent;->mEvent:Ljava/lang/String;

    return-object v0
.end method

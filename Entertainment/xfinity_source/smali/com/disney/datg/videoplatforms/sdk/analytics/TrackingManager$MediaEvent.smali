.class public final enum Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$MediaEvent;
.super Ljava/lang/Enum;
.source "TrackingManager.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "MediaEvent"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$MediaEvent;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$MediaEvent;

.field public static final enum COMPLETE:Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$MediaEvent;

.field public static final enum ERROR:Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$MediaEvent;

.field public static final enum FIRST_QUARTER:Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$MediaEvent;

.field public static final enum FORWARD:Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$MediaEvent;

.field public static final enum MID_POINT:Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$MediaEvent;

.field public static final enum PAUSED:Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$MediaEvent;

.field public static final enum PING:Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$MediaEvent;

.field public static final enum RESUMED:Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$MediaEvent;

.field public static final enum REWIND:Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$MediaEvent;

.field public static final enum STARTED:Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$MediaEvent;

.field public static final enum STATEUPDATED:Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$MediaEvent;

.field public static final enum STOPPED:Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$MediaEvent;

.field public static final enum THIRD_QUARTER:Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$MediaEvent;


# direct methods
.method static constructor <clinit>()V
    .locals 8

    .prologue
    const/4 v7, 0x4

    const/4 v6, 0x3

    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 16
    new-instance v0, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$MediaEvent;

    const-string v1, "STARTED"

    invoke-direct {v0, v1, v3}, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$MediaEvent;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$MediaEvent;->STARTED:Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$MediaEvent;

    new-instance v0, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$MediaEvent;

    const-string v1, "PAUSED"

    invoke-direct {v0, v1, v4}, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$MediaEvent;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$MediaEvent;->PAUSED:Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$MediaEvent;

    new-instance v0, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$MediaEvent;

    const-string v1, "RESUMED"

    invoke-direct {v0, v1, v5}, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$MediaEvent;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$MediaEvent;->RESUMED:Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$MediaEvent;

    new-instance v0, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$MediaEvent;

    const-string v1, "FORWARD"

    invoke-direct {v0, v1, v6}, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$MediaEvent;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$MediaEvent;->FORWARD:Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$MediaEvent;

    new-instance v0, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$MediaEvent;

    const-string v1, "REWIND"

    invoke-direct {v0, v1, v7}, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$MediaEvent;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$MediaEvent;->REWIND:Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$MediaEvent;

    new-instance v0, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$MediaEvent;

    const-string v1, "STOPPED"

    const/4 v2, 0x5

    invoke-direct {v0, v1, v2}, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$MediaEvent;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$MediaEvent;->STOPPED:Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$MediaEvent;

    new-instance v0, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$MediaEvent;

    const-string v1, "STATEUPDATED"

    const/4 v2, 0x6

    invoke-direct {v0, v1, v2}, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$MediaEvent;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$MediaEvent;->STATEUPDATED:Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$MediaEvent;

    new-instance v0, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$MediaEvent;

    const-string v1, "ERROR"

    const/4 v2, 0x7

    invoke-direct {v0, v1, v2}, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$MediaEvent;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$MediaEvent;->ERROR:Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$MediaEvent;

    new-instance v0, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$MediaEvent;

    const-string v1, "FIRST_QUARTER"

    const/16 v2, 0x8

    invoke-direct {v0, v1, v2}, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$MediaEvent;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$MediaEvent;->FIRST_QUARTER:Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$MediaEvent;

    new-instance v0, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$MediaEvent;

    const-string v1, "MID_POINT"

    const/16 v2, 0x9

    invoke-direct {v0, v1, v2}, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$MediaEvent;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$MediaEvent;->MID_POINT:Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$MediaEvent;

    new-instance v0, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$MediaEvent;

    const-string v1, "THIRD_QUARTER"

    const/16 v2, 0xa

    invoke-direct {v0, v1, v2}, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$MediaEvent;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$MediaEvent;->THIRD_QUARTER:Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$MediaEvent;

    new-instance v0, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$MediaEvent;

    const-string v1, "COMPLETE"

    const/16 v2, 0xb

    invoke-direct {v0, v1, v2}, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$MediaEvent;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$MediaEvent;->COMPLETE:Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$MediaEvent;

    new-instance v0, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$MediaEvent;

    const-string v1, "PING"

    const/16 v2, 0xc

    invoke-direct {v0, v1, v2}, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$MediaEvent;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$MediaEvent;->PING:Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$MediaEvent;

    const/16 v0, 0xd

    new-array v0, v0, [Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$MediaEvent;

    sget-object v1, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$MediaEvent;->STARTED:Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$MediaEvent;

    aput-object v1, v0, v3

    sget-object v1, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$MediaEvent;->PAUSED:Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$MediaEvent;

    aput-object v1, v0, v4

    sget-object v1, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$MediaEvent;->RESUMED:Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$MediaEvent;

    aput-object v1, v0, v5

    sget-object v1, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$MediaEvent;->FORWARD:Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$MediaEvent;

    aput-object v1, v0, v6

    sget-object v1, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$MediaEvent;->REWIND:Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$MediaEvent;

    aput-object v1, v0, v7

    const/4 v1, 0x5

    sget-object v2, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$MediaEvent;->STOPPED:Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$MediaEvent;

    aput-object v2, v0, v1

    const/4 v1, 0x6

    sget-object v2, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$MediaEvent;->STATEUPDATED:Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$MediaEvent;

    aput-object v2, v0, v1

    const/4 v1, 0x7

    sget-object v2, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$MediaEvent;->ERROR:Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$MediaEvent;

    aput-object v2, v0, v1

    const/16 v1, 0x8

    sget-object v2, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$MediaEvent;->FIRST_QUARTER:Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$MediaEvent;

    aput-object v2, v0, v1

    const/16 v1, 0x9

    sget-object v2, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$MediaEvent;->MID_POINT:Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$MediaEvent;

    aput-object v2, v0, v1

    const/16 v1, 0xa

    sget-object v2, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$MediaEvent;->THIRD_QUARTER:Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$MediaEvent;

    aput-object v2, v0, v1

    const/16 v1, 0xb

    sget-object v2, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$MediaEvent;->COMPLETE:Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$MediaEvent;

    aput-object v2, v0, v1

    const/16 v1, 0xc

    sget-object v2, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$MediaEvent;->PING:Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$MediaEvent;

    aput-object v2, v0, v1

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$MediaEvent;->$VALUES:[Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$MediaEvent;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;I)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()V"
        }
    .end annotation

    .prologue
    .line 16
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$MediaEvent;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 16
    const-class v0, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$MediaEvent;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$MediaEvent;

    return-object v0
.end method

.method public static values()[Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$MediaEvent;
    .locals 1

    .prologue
    .line 16
    sget-object v0, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$MediaEvent;->$VALUES:[Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$MediaEvent;

    invoke-virtual {v0}, [Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$MediaEvent;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$MediaEvent;

    return-object v0
.end method

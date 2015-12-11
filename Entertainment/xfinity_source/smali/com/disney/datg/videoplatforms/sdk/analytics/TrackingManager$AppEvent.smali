.class public final enum Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AppEvent;
.super Ljava/lang/Enum;
.source "TrackingManager.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "AppEvent"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AppEvent;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AppEvent;

.field public static final enum ACTIVITYSTART:Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AppEvent;

.field public static final enum ACTIVITYSTOP:Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AppEvent;

.field public static final enum APPSTATE:Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AppEvent;

.field public static final enum ERROR:Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AppEvent;

.field public static final enum LAUNCH:Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AppEvent;


# direct methods
.method static constructor <clinit>()V
    .locals 7

    .prologue
    const/4 v6, 0x4

    const/4 v5, 0x3

    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 18
    new-instance v0, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AppEvent;

    const-string v1, "LAUNCH"

    invoke-direct {v0, v1, v2}, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AppEvent;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AppEvent;->LAUNCH:Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AppEvent;

    new-instance v0, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AppEvent;

    const-string v1, "ACTIVITYSTART"

    invoke-direct {v0, v1, v3}, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AppEvent;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AppEvent;->ACTIVITYSTART:Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AppEvent;

    new-instance v0, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AppEvent;

    const-string v1, "ACTIVITYSTOP"

    invoke-direct {v0, v1, v4}, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AppEvent;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AppEvent;->ACTIVITYSTOP:Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AppEvent;

    new-instance v0, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AppEvent;

    const-string v1, "APPSTATE"

    invoke-direct {v0, v1, v5}, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AppEvent;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AppEvent;->APPSTATE:Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AppEvent;

    new-instance v0, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AppEvent;

    const-string v1, "ERROR"

    invoke-direct {v0, v1, v6}, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AppEvent;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AppEvent;->ERROR:Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AppEvent;

    const/4 v0, 0x5

    new-array v0, v0, [Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AppEvent;

    sget-object v1, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AppEvent;->LAUNCH:Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AppEvent;

    aput-object v1, v0, v2

    sget-object v1, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AppEvent;->ACTIVITYSTART:Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AppEvent;

    aput-object v1, v0, v3

    sget-object v1, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AppEvent;->ACTIVITYSTOP:Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AppEvent;

    aput-object v1, v0, v4

    sget-object v1, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AppEvent;->APPSTATE:Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AppEvent;

    aput-object v1, v0, v5

    sget-object v1, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AppEvent;->ERROR:Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AppEvent;

    aput-object v1, v0, v6

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AppEvent;->$VALUES:[Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AppEvent;

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
    .line 18
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AppEvent;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 18
    const-class v0, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AppEvent;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AppEvent;

    return-object v0
.end method

.method public static values()[Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AppEvent;
    .locals 1

    .prologue
    .line 18
    sget-object v0, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AppEvent;->$VALUES:[Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AppEvent;

    invoke-virtual {v0}, [Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AppEvent;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AppEvent;

    return-object v0
.end method

.class final enum Lcom/penthera/virtuososdk/monitor/BatteryMonitor$Event;
.super Ljava/lang/Enum;
.source "BatteryMonitor.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/penthera/virtuososdk/monitor/BatteryMonitor;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x401a
    name = "Event"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/penthera/virtuososdk/monitor/BatteryMonitor$Event;",
        ">;"
    }
.end annotation


# static fields
.field public static final enum CONNECTED:Lcom/penthera/virtuososdk/monitor/BatteryMonitor$Event;

.field public static final enum DISCONNECTED:Lcom/penthera/virtuososdk/monitor/BatteryMonitor$Event;

.field private static final synthetic ENUM$VALUES:[Lcom/penthera/virtuososdk/monitor/BatteryMonitor$Event;

.field public static final enum LEVEL_CHANGED:Lcom/penthera/virtuososdk/monitor/BatteryMonitor$Event;

.field public static final enum NONE:Lcom/penthera/virtuososdk/monitor/BatteryMonitor$Event;


# direct methods
.method static constructor <clinit>()V
    .locals 6

    .prologue
    const/4 v5, 0x3

    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 52
    new-instance v0, Lcom/penthera/virtuososdk/monitor/BatteryMonitor$Event;

    const-string v1, "NONE"

    invoke-direct {v0, v1, v2}, Lcom/penthera/virtuososdk/monitor/BatteryMonitor$Event;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/penthera/virtuososdk/monitor/BatteryMonitor$Event;->NONE:Lcom/penthera/virtuososdk/monitor/BatteryMonitor$Event;

    new-instance v0, Lcom/penthera/virtuososdk/monitor/BatteryMonitor$Event;

    const-string v1, "CONNECTED"

    invoke-direct {v0, v1, v3}, Lcom/penthera/virtuososdk/monitor/BatteryMonitor$Event;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/penthera/virtuososdk/monitor/BatteryMonitor$Event;->CONNECTED:Lcom/penthera/virtuososdk/monitor/BatteryMonitor$Event;

    new-instance v0, Lcom/penthera/virtuososdk/monitor/BatteryMonitor$Event;

    const-string v1, "DISCONNECTED"

    invoke-direct {v0, v1, v4}, Lcom/penthera/virtuososdk/monitor/BatteryMonitor$Event;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/penthera/virtuososdk/monitor/BatteryMonitor$Event;->DISCONNECTED:Lcom/penthera/virtuososdk/monitor/BatteryMonitor$Event;

    new-instance v0, Lcom/penthera/virtuososdk/monitor/BatteryMonitor$Event;

    const-string v1, "LEVEL_CHANGED"

    invoke-direct {v0, v1, v5}, Lcom/penthera/virtuososdk/monitor/BatteryMonitor$Event;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/penthera/virtuososdk/monitor/BatteryMonitor$Event;->LEVEL_CHANGED:Lcom/penthera/virtuososdk/monitor/BatteryMonitor$Event;

    const/4 v0, 0x4

    new-array v0, v0, [Lcom/penthera/virtuososdk/monitor/BatteryMonitor$Event;

    sget-object v1, Lcom/penthera/virtuososdk/monitor/BatteryMonitor$Event;->NONE:Lcom/penthera/virtuososdk/monitor/BatteryMonitor$Event;

    aput-object v1, v0, v2

    sget-object v1, Lcom/penthera/virtuososdk/monitor/BatteryMonitor$Event;->CONNECTED:Lcom/penthera/virtuososdk/monitor/BatteryMonitor$Event;

    aput-object v1, v0, v3

    sget-object v1, Lcom/penthera/virtuososdk/monitor/BatteryMonitor$Event;->DISCONNECTED:Lcom/penthera/virtuososdk/monitor/BatteryMonitor$Event;

    aput-object v1, v0, v4

    sget-object v1, Lcom/penthera/virtuososdk/monitor/BatteryMonitor$Event;->LEVEL_CHANGED:Lcom/penthera/virtuososdk/monitor/BatteryMonitor$Event;

    aput-object v1, v0, v5

    sput-object v0, Lcom/penthera/virtuososdk/monitor/BatteryMonitor$Event;->ENUM$VALUES:[Lcom/penthera/virtuososdk/monitor/BatteryMonitor$Event;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;I)V
    .locals 0

    .prologue
    .line 52
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/penthera/virtuososdk/monitor/BatteryMonitor$Event;
    .locals 1

    .prologue
    .line 1
    const-class v0, Lcom/penthera/virtuososdk/monitor/BatteryMonitor$Event;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/penthera/virtuososdk/monitor/BatteryMonitor$Event;

    return-object v0
.end method

.method public static values()[Lcom/penthera/virtuososdk/monitor/BatteryMonitor$Event;
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 1
    sget-object v0, Lcom/penthera/virtuososdk/monitor/BatteryMonitor$Event;->ENUM$VALUES:[Lcom/penthera/virtuososdk/monitor/BatteryMonitor$Event;

    array-length v1, v0

    new-array v2, v1, [Lcom/penthera/virtuososdk/monitor/BatteryMonitor$Event;

    invoke-static {v0, v3, v2, v3, v1}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    return-object v2
.end method
